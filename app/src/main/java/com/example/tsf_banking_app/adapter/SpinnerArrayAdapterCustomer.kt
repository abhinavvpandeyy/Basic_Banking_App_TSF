package com.example.tsf_banking_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.tsf_banking_app.R
import com.example.tsf_banking_app.databinding.DropdownListItemBinding
import com.example.tsf_banking_app.model.SpinnerCustomer

class SpinnerArrayAdapterCustomer(context: Context,customerList:ArrayList<SpinnerCustomer>):
    ArrayAdapter<SpinnerCustomer>(context,0,customerList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }
    private fun initView(position: Int,convertView: View?, parent: ViewGroup):View{
        val customer = getItem(position)
        val view = LayoutInflater.from(context).inflate(R.layout.dropdown_list_item,parent,false)
        val nameT = view.findViewById<TextView>(R.id.personName)
        val phoneT = view.findViewById<TextView>(R.id.phoneNumber)
        nameT.text = customer!!.name
        phoneT.text = customer.phone
        return view
    }
}