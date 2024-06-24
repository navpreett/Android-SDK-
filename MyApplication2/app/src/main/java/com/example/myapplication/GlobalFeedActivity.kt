//import android.os.Bundle
//import android.view.ViewGroup
//import android.widget.LinearLayout
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.lifecycleScope
//import androidx.paging.PagingData
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.amity.socialcloud.sdk.api.core.AmityCoreClient
//import com.amity.socialcloud.sdk.api.core.endpoint.AmityEndpoint
//import com.amity.socialcloud.sdk.api.social.post.AmityFeedRepository
//
//import com.amity.socialcloud.sdk.model.social.post.AmityPost
//import com.example.myapplication.FeedAdapter
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//class GlobalFeedActivity : AppCompatActivity() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var feedAdapter: FeedAdapter
//    private lateinit var feedRepository: AmityFeedRepository
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val rootLayout = LinearLayout(this).apply {
//            orientation = LinearLayout.VERTICAL
//            layoutParams = ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT
//            )
//        }
//
//        recyclerView = RecyclerView(this).apply {
//            layoutManager = LinearLayoutManager(this@GlobalFeedActivity)
//        }
//        rootLayout.addView(recyclerView, ViewGroup.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.MATCH_PARENT
//        ))
//
//        setContentView(rootLayout)
//
//        // Initialize Amity Core Client
//        AmityCoreClient.setup(
//            apiKey = "your-api-key", // Replace with your actual API key
//            endpoint = AmityEndpoint.SG // Replace with your endpoint if necessary
//        )
//
//        // Initialize FeedRepository
//        feedRepository = AmityCoreClient.newFeedRepository()
//
//        // Initialize the adapter
//        feedAdapter = FeedAdapter()
//        recyclerView.adapter = feedAdapter
//
//        // Fetch the global feed for the logged-in user
//        queryGlobalFeed()
//    }
//
//    private fun queryGlobalFeed() {
//        lifecycleScope.launch {
//            feedRepository.getGlobalFeed()
//                .build()
//                .getPagingData()
//                .collectLatest { pagingData: PagingData<AmityPost> ->
//                    feedAdapter.submitData(pagingData)
//                }
//        }
//    }
//}
