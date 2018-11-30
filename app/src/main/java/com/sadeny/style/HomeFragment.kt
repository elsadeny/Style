package com.sadeny.style


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.content_main_flow.*
import kotlinx.android.synthetic.main.content_main_flow.view.*


class HomeFragment : Fragment() {
    var itemList = ArrayList<ItemDesc>()
 var adapter =Item_Adapter(activity,itemList)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView =inflater.inflate(R.layout.content_main_flow,null)
        //recycler_view = findViewById(R.id.recycler_view)
        rootView.recycler_view.setHasFixedSize(true)
        adapter = Item_Adapter(activity,ArrayList<ItemDesc>())

        rootView.recycler_view.layoutManager=GridLayoutManager(activity,2)
        rootView.recycler_view.addItemDecoration(Grid_lay(2,dpToPx(0),false))
        rootView.recycler_view.adapter=adapter
        prepareItem()
        return rootView
    }

    fun prepareItem(){
        val bitmap :Bitmap = BitmapFactory.decodeResource(resources,R.drawable.ico);
        var i:Int =1
        while(i<=31)
        {
          val itemDesc =ItemDesc("Item "+i,"2000",bitmap)
            itemList.add(itemDesc)
            i++
        }

        Log.d("DEvb ","prepare my item")
       adapter.notifyDataSetChanged()
    }

    private fun dpToPx(dp: Int): Int {
        val r = resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }
}
