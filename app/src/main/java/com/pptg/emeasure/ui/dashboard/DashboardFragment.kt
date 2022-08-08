package com.pptg.emeasure.ui.dashboard

import com.pptg.emeasure.R
import com.pptg.emeasure.databinding.FragmentDashboardBinding
import com.pptg.emeasure.ui.dashboard.pagers.DashboardFragment1
import com.pptg.emeasure.ui.dashboard.pagers.DashboardFragment2
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy

class DashboardFragment : Fragment() {

    private val model: DashboardViewModel by activityViewModels()
    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: DashboardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root = binding.root

        val viewPager2: ViewPager2 = root.findViewById(R.id.vp_dash)
        viewPager2.adapter = object : FragmentStateAdapter(requireActivity()) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> DashboardFragment1()
                    else -> DashboardFragment2()
                }
            }

            override fun getItemCount(): Int {
                return 2
            }
        }
        val tabLayout: TabLayout = root.findViewById(R.id.tl_dash)
        TabLayoutMediator(
            tabLayout, viewPager2
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "待完成"
                else -> tab.text = "流程中"
            }
        }.attach()
        model.updateList()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}