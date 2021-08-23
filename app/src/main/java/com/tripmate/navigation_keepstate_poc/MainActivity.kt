package com.tripmate.navigation_keepstate_poc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.tripmate.navigation_keepstate_poc.databinding.ActivityMainBinding

private const val TAG_FRAGMENT1 = "fragment1"
private const val TAG_FRAGMENT2 = "fragment2"
private const val TAG_FRAGMENT3 = "fragment3"

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_FRAGMENT1, Fragment1())

        binding.btnFragment1.setOnClickListener {
            setFragment(TAG_FRAGMENT1, Fragment1())
        }

        binding.btnFragment2.setOnClickListener {
            setFragment(TAG_FRAGMENT2, Fragment2())
        }

        binding.btnFragment3.setOnClickListener {
            setFragment(TAG_FRAGMENT3, Fragment3())
        }


    }
    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null) {
            ft.add(R.id.container, fragment, tag)
        }

        val fragment1 = manager.findFragmentByTag(TAG_FRAGMENT1)
        val fragment2 = manager.findFragmentByTag(TAG_FRAGMENT2)
        val fragment3 = manager.findFragmentByTag(TAG_FRAGMENT3)

        // Hide all Fragment
        if (fragment1 != null) {
            ft.hide(fragment1)
        }
        if (fragment2 != null) {
            ft.hide(fragment2)
        }
        if (fragment3 != null) {
            ft.hide(fragment3)
        }

        // Show  current Fragment
        if (tag == TAG_FRAGMENT1) {
            if (fragment1 != null) {
                ft.show(fragment1)
                showEnable(binding.btnFragment1)
            }
        }
        if (tag == TAG_FRAGMENT2) {

            if (fragment2 != null) {
                ft.show(fragment2)
                showEnable(binding.btnFragment2)
            }
        }
        if (tag == TAG_FRAGMENT3) {
            if (fragment3 != null) {
                ft.show(fragment3)
                showEnable(binding.btnFragment3)
            }
        }

        ft.commitAllowingStateLoss()
    }

    fun showEnable(falseButton : View){
        binding.btnFragment1.isEnabled = true
        binding.btnFragment2.isEnabled = true
        binding.btnFragment3.isEnabled = true

        when(falseButton){
            binding.btnFragment1 -> {
                binding.btnFragment1.isEnabled = false
            }
            binding.btnFragment2 ->{
                binding.btnFragment2.isEnabled = false
            }
            binding.btnFragment3 ->{
                binding.btnFragment3.isEnabled = false
            }

        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }

}
