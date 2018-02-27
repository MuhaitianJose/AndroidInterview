package com.muhaitain.androidinterview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.muhaitain.interviewconclusion.algorithm.SortingAlgorithm

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var muhai = intArrayOf(42, 20, 17, 13, 28, 14, 23, 15)
//        SortingAlgorithm.BubbleSortDiminishing(muhai)
//        SortingAlgorithm.SelctionSortAscending(muhai)
//        SortingAlgorithm.SelctionSortDiminishing(muhai)
//        SortingAlgorithm.InsertionSortAscending(muhai)
//        SortingAlgorithm.InsertionSortDiminishing(muhai)
//        SortingAlgorithm.ShellSortDiminishing(muhai)
        SortingAlgorithm.quickSort(muhai,0,muhai.size-1)
        for (i in muhai.indices){

            Log.d("MainActivity",muhai[i].toString())
        }
    }
}
