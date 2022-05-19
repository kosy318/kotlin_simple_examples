# kotlin_simple_examples

go into each folder, it says what app it is.

### 1. ImageViewer
<b>xml</b><br>
values->themes->windowNodTitle true<br>
LinearLayout->android:orientation="vertical" : 덩어리를 세로로 나열 / android:gravity="center" : LinearLayout안에서 사진을 가운데 정렬<br>
ImageView->android:scaleType="centerCrop" : 사진 가운데에 맞춰 확대 + 자름<br>
cardview<br>
splashscreen: AndroidManifest.xml->move <intent-filter> inside SplashActivity<br>
<b>kt</b><br>
SplashActivity.kt->Handler(Looper.getMainLooper()).postDelayed({...}, seconds)<br>
MainActivity.kt->about DataBinding https://jolly-note.tistory.com/49 / intent.putExtra() / StartActivity(intent) / setOnClickListener / findViewById<br>
ImageInsideActivity->about DataBinding / Toast.makeText / intent.getStringExtra() / resources.getIdentifier(name_can_use_var, defType_like_drawable, getPackageName()<br>
  
### 2. dice_app
<b>xml</b><br>
themes->parent="Theme.AppCompat.Light" (When color doesn't change)<br>
LinearLayout->background / textFontWeight, textStyle / weightSum, layout_weight / <br>
TextView<br>
font->android:fontFamily="@font/font_name"<br>
Button<br>
<b>kt</b><br>
MainActivity.kt->Random.nextInt(from, until) / about Log. https://jolly-note.tistory.com/50 / StartActivity(intent) / setOnClickListener / findViewById<br>

### 3. listview_ex
made data class->ListViewModel.kt<br>
<b>xml</b><br>
themes->parent="Theme.AppCompat.Light" (When color doesn't change)<br>
LinearLayout->background / textFontWeight, textStyle / weightSum, layout_weight / <br>
TextView<br>
Button<br>
<b>kt</b><br>
MainActivity.kt->MutableList / adapter / layoutInflater.inflate / addHeaderView(ListView에 Header추가) / onBackPressed()(두번 뒤로가기가 발생하면 종료)<br>
ListViewModel.kt<br>
ListViewAdapter->getView<br>
  
### 4. SentenceLists
<b>xml</b><br>
ImageButton<br>
ConstraintLayout<br>
<b>kt</b><br>
MainActivity.kt->.random()하면 List안에서 랜덤하게 나온다<br>
  
  
### 5. listview_ex2
<b>kt</b><br>
MainActivity.kt->.setOnItemClickListener

### 6. RecyclerView_ex
<b>xml</b><br>
activity_main.xml->recyclerview<br>
recyclerview_item.xml->높이를 지정해줘야한다!!<br>
<b>kt</b><br>
MainActivity.kt->recyclerview.adapter=recyclerViewAdapter / recyclerview.layoutManager=LinearLayoutManager(this) / itemClick 이벤트를 사용하기 위해서는 RecyclerViewAdapter.kt에 선언한 itemClick을 통해 사용<br>
RecyclerViewAdapter.kt->onCreateViewHolder: recyclerview의 item을 불러옴 / ItemClick interface선언: Adapter에 직접 선언을 해줘야 사용할 수 있다 / onBindingViewHolder: 불러온 item을 view Binding / getItemCount: 전체 리사이클러뷰의 개수 / ViewHolder: view를 재사용해서 선능이 ListView에 비해 좋다.<br>
