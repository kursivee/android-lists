package kursivee.com.lists

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kursivee.com.lists.dummy.DummyContent
import kursivee.com.lists.grid.normal.GridItemFragment
import kursivee.com.lists.grid.stag.StagGridItemFragment
import kursivee.com.lists.linear.horizontal.HorizontalItemFragment
import kursivee.com.lists.linear.vertical.ItemFragment

class MainActivity : AppCompatActivity(), ItemFragment.OnListFragmentInteractionListener, GridItemFragment.OnListFragmentInteractionListener, HorizontalItemFragment.OnListFragmentInteractionListener, StagGridItemFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        onVerticalButtonClick()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_linear_horizontal -> {
                onHorizontalButtonClick()
                true
            }
            R.id.action_linear_vertical -> {
                onVerticalButtonClick()
                true
            }
            R.id.action_grid_staggered -> {
                onStagGridButtonClick()
                true
            }
            R.id.action_grid -> {
                onGridButtonClick()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(item?.content).show()
    }

    private fun changeFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.placeholder, fragment)
        fragmentTransaction.commit()
    }

    private fun onGridButtonClick() {
        val fragment = GridItemFragment()
        changeFragment(fragment)
    }

    private fun onStagGridButtonClick() {
        val fragment = StagGridItemFragment()
        changeFragment(fragment)
    }

    private fun onHorizontalButtonClick() {
        val fragment = HorizontalItemFragment()
        changeFragment(fragment)
    }

    private fun onVerticalButtonClick() {
        val fragment = ItemFragment()
        changeFragment(fragment)
    }

}
