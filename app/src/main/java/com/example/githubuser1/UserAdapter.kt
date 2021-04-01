package com.example.githubuser1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.githubuser1.databinding.ItemUserBinding
import de.hdodenhof.circleimageview.CircleImageView
import java.text.FieldPosition

class UserAdapter internal constructor(private val context: Context) : BaseAdapter() {

//    var onClickItem: ((User) -> Unit)? = null

    internal var users = arrayListOf<User>()

    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(i: Int): Any {
        return users[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val binding = ItemUserBinding.bind(view)
//        private val txtName: TextView = view.findViewById(R.id.txt_name)
//        private val txtLocation: TextView = view.findViewById(R.id.txt_location)
//        private val txtCompany: TextView = view.findViewById(R.id.txt_company)
//        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(user: User) {
            binding.txtName.text = user.name
            binding.txtLocation.text = user.location
            binding.txtCompany.text = user.company
            binding.imgPhoto.setImageResource(user.photo)

//            txtName.text = user.name
//            txtLocation.text = user.location
//            txtCompany.text = user.company
//            imgPhoto.setImageResource(user.photo)
        }

    }
}