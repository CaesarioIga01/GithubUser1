package com.example.githubuser1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubuser1.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userDetail = intent.getParcelableExtra<User>(EXTRA_USER) as User
        binding.photoUser.setImageResource(userDetail.photo)
        binding.tvDetailName.text = userDetail.name
        binding.tvDetailUsername.text = userDetail.username
        binding.tvNumberFollowers.text = userDetail.followers.toString()
        binding.tvNumberFollowing.text = userDetail.following.toString()

//        userData = intent.getParcelableExtra(EXTRA_USER)
//
//        if (userData != null) {
//            Glide.with(this)
//                .load(userData?.photo)
//                .apply(RequestOptions()).into(binding.photoUser)
//
//            binding.tvDetailName.text = userData?.name
//            binding.tvDetailLocation.text = userData?.location
//            binding.tvNumberFollowers.text = userData?.followers.toString()
//            binding.tvNumberFollowing.text = userData?.following.toString()
//
//        }
    }
}