package com.aldiae.submissionbfaa3.networking

import android.os.Parcelable
import com.aldiae.submissionbfaa3.model.GithubUser
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchRespond(
    val total_count : String,
    val incomplete_results: Boolean? = null,
    val items : List<GithubUser>
): Parcelable