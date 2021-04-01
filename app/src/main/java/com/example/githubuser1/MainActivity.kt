package com.example.githubuser1


import android.content.Intent
import android.content.Intent.EXTRA_USER
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import com.example.githubuser1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: IntArray
    private lateinit var dataFollowing: IntArray
    private lateinit var dataPhoto: TypedArray
    private lateinit var binding: ActivityMainBinding
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView: ListView = findViewById(R.id.tv_list)

        adapter = UserAdapter(this)

        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this@MainActivity, DetailUser::class.java)
            intent.putExtra(DetailUser.EXTRA_USER, users)
            startActivity(intent)
        }

    }

    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataCompany = resources.getStringArray(R.array.company)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollowers = resources.getIntArray(R.array.followers)
        dataFollowing = resources.getIntArray(R.array.following)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                dataPhoto.getResourceId(position, 0),
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataCompany[position],
                dataRepository[position],
                dataFollowers[position],
                dataFollowing[position]
            )
            users.add(user)
        }
        adapter.users = users
    }
}