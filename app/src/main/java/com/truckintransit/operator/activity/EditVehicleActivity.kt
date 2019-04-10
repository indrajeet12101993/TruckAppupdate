package com.truckintransit.operator.activity


import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.truckintransit.operator.R
import com.truckintransit.operator.base.BaseActivity
import com.truckintransit.operator.fragment.vehicleEdit.AddVehicleBasicInfoEditFragment
import kotlinx.android.synthetic.main.activity_add_vehicle.*

class EditVehicleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_vehicle)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.title = getString(R.string.edit_vehicle)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.yellow))

        replaceFragment(AddVehicleBasicInfoEditFragment())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.place_holder_for_fragment, fragment)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.commit()
    }
}
