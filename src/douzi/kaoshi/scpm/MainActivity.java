package douzi.kaoshi.scpm;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

import org.w3c.dom.Text;

import douzi.menudrawer.MenuDrawer;
import douzi.menudrawer.Position;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final int MATCH_PARENT = -1;
    public static final int WRAP_CONTENT = -2;
    
	private MenuDrawer 						mMenuDrawer;
	
	private ImageButton						mTopRightBtn	= null;
	
	private LinearLayout					mContentRoot	= null;
	
	private List<SingleChoiceQues>			mData			= new ArrayList<SingleChoiceQues>();
	
	private int								mTextSize		= 15;
	
	private Button							mShowAnswer		= null;
	private Button							mNextQuest		= null;
	
	private int								mCurQuestID		= 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initView(){
		
        mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_WINDOW, Position.RIGHT);
        mMenuDrawer.setContentView(R.layout.activity_main);
        
        TextView t = new TextView(this);
        t.setText(R.string.hello_world);
        mMenuDrawer.setMenuView(t);

        mContentRoot = (LinearLayout)findViewById(R.id.content_root);
        
        mTopRightBtn = (ImageButton)findViewById(R.id.ivTitleBtnRigh);
        
        mShowAnswer		= (Button)findViewById(R.id.show_answer);
        mNextQuest		= (Button)findViewById(R.id.next_quest);
        
        
        mTopRightBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				
				mMenuDrawer.openMenu(true);
				
			}
		});
        
        mShowAnswer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showAnswer();
				
			}
		});
        
        mNextQuest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				nextQuestion();
				
			}
		});
        
        initData();
        
        initContent();
	}
	
	private void nextQuestion(){
		
		//check out of array
		if(mCurQuestID + 1 >= mData.size()){
			
			Toast.makeText(this, getString(R.string.warning_last_item), Toast.LENGTH_SHORT).show();
			return;
		}
		
		mCurQuestID++;
		
		mContentRoot.removeAllViews();
		
		initContent();
		
	}
	
	private void showAnswer(){
		if(null == mData){
			return ;
		}
		
		SingleChoiceQues scq = mData.get(mCurQuestID);
		
		int count = scq.getSubQuestion().size();
		
		for(int ii = 0; ii < count; ii++){
			
			SubChoiceQues sub = scq.getSubQuestion().get(ii);
			
			int id = createID(sub,sub.getTrueChoice());
			
			Button b = (Button)findViewById(id);
			b.setTextColor(Color.RED);
			
			//b.getPaint().setFakeBoldText(true);
		}
	}
	
	private View createTitle(String str){
		
		TextView v = new TextView(this);
		
		v.setText(str);
		v.setTextColor(Color.BLACK);
		v.setTextSize(mTextSize);
		v.setPadding(0, 30, 0, 7);
		v.setGravity(Gravity.CENTER_VERTICAL);
		v.setBackgroundColor(Color.TRANSPARENT);
		
		return v;
	}
	
	private View createChoiceItem(String str,int id){
		
		Button btn = new Button(this);
		
		btn.setText(str);
		btn.setTextColor(Color.BLACK);
		btn.setTextSize(mTextSize);
		btn.setPadding(10, 1, 0, 1);
		btn.setGravity(Gravity.CENTER_VERTICAL);
		btn.setBackgroundColor(Color.TRANSPARENT);
		btn.setId(id);
		
		return btn;
	}
	
	private View createContent(String str){
		
		TextView tv = new TextView(this);
		tv.setText(str);
		tv.setTextColor(Color.BLACK);
		tv.setTextSize(mTextSize);
		
		return tv;
	}
	
	private View createChoiceItem(String str){
		
		Button btn = new Button(this);
		
		btn.setText(str);
		btn.setTextColor(Color.BLACK);
		btn.setTextSize(15);
		btn.setPadding(10, 1, 0, 1);
		btn.setGravity(Gravity.CENTER_VERTICAL);
		btn.setBackgroundColor(Color.TRANSPARENT);
		
		return btn;
	}
	
	/**
	 * init data
	 */
	private void initData(){

		for(int ii = 0; ii < 10; ii++){
			
			
			SingleChoiceQues	scq = new SingleChoiceQues();
			
			SubChoiceQues subQuestion = new SubChoiceQues();
			
			subQuestion.mAItem = getString(R.string.choice_item_a);
			subQuestion.mBItem	= getString(R.string.choice_item_b);
			subQuestion.mCItem	= getString(R.string.choice_item_c);
			subQuestion.mDItem = getString(R.string.choice_item_d);
			subQuestion.mID = 31;
			subQuestion.setTrueChoice(1);
			
			scq.addSubQuestion(subQuestion);
			
			subQuestion = new SubChoiceQues();
			
			subQuestion.mAItem 	= getString(R.string.choice_item_a);
			subQuestion.mBItem	= getString(R.string.choice_item_b);
			subQuestion.mCItem	= getString(R.string.choice_item_c);
			subQuestion.mDItem 	= getString(R.string.choice_item_d);
			subQuestion.mID = 32;
			subQuestion.setTrueChoice(3);
			scq.addSubQuestion(subQuestion);
			
			if(ii % 3 == 0){
				subQuestion = new SubChoiceQues();
				
				subQuestion.mAItem 	= getString(R.string.choice_item_a);
				subQuestion.mBItem	= getString(R.string.choice_item_b);
				subQuestion.mCItem	= getString(R.string.choice_item_c);
				subQuestion.mDItem 	= getString(R.string.choice_item_d);
				subQuestion.mID = 33;
				subQuestion.setTrueChoice(4);
				scq.addSubQuestion(subQuestion);
			}

			
			scq.setContent(getString(R.string.example));
			
			scq.setID(30);
			
			mData.add(scq);
		}
	}
	

	private void initContent(){
		
		ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(MATCH_PARENT,WRAP_CONTENT);
		
		SingleChoiceQues scq = mData.get(mCurQuestID);
		int count = scq.getSubQuestion().size();
		
		View content = createContent(scq.getContent());
		mContentRoot.addView(content, params);
		
		for(int ii = 0; ii < count; ii++){
			
			SubChoiceQues  	ci 			= scq.getSubQuestion().get(ii);
			
			LinearLayout	subroot = new LinearLayout(this);

			View			title 		= createTitle( getString(R.string.item_name) +"("+ ci.mID++ +")");
			
			subroot.setOrientation(LinearLayout.VERTICAL);
			subroot.addView(title,params);
			
			
			View	choiceItem = createChoiceItem(ci.mAItem,createID(ci,1));
			choiceItem.setOnClickListener(new ChoiceItemClick(scq.getID(),ci.mID,1));
			subroot.addView(choiceItem, params);
			
			choiceItem = createChoiceItem(ci.mBItem,createID(ci,2));
			choiceItem.setOnClickListener(new ChoiceItemClick(scq.getID(),ci.mID,2));
			subroot.addView(choiceItem, params);
			
			choiceItem = createChoiceItem(ci.mCItem,createID(ci,3));
			choiceItem.setOnClickListener(new ChoiceItemClick(scq.getID(),ci.mID,3));
			subroot.addView(choiceItem, params);
			
			choiceItem = createChoiceItem(ci.mDItem,createID(ci,4));
			choiceItem.setOnClickListener(new ChoiceItemClick(scq.getID(),ci.mID,4));
			subroot.addView(choiceItem, params);

			mContentRoot.addView(subroot, MATCH_PARENT, MATCH_PARENT);
		}
	}
	
	private int createID(SubChoiceQues ci,int index){
		
		int outid = 0;
		
		outid = ci.mMain.getID() * 10000 + ci.mID * 100 + index;
		
		return outid;
	}
	
	private int createID(int contentid,int choiceid,int index){
		
		int outid = 0;
		
		outid = contentid * 10000 + choiceid * 100 + index;
		
		return outid;
	}
	
	private class ChoiceItemClick implements View.OnClickListener{

		private int		mContentID;
		private int 	mChoiceID;
		private	int		mIndex;
		
		public ChoiceItemClick(int contentid,int choiceid,int index){
			
			mContentID 		= contentid;
			mChoiceID		= choiceid;
			mIndex			= index;
		}
		
		@Override
		public void onClick(View view) {
			
			clearBg();
			
			int id = createID(mContentID, mChoiceID, mIndex);
			View v = mContentRoot.findViewById(id);
			if(null != v){
				
				v.setBackgroundResource(R.drawable.choiceitem_btn_style);
			}
		}
		
		private void clearBg(){
			
			for(int ii = 1; ii <= 4; ii++){
				
				int id = createID(mContentID, mChoiceID, ii);
				
				View v = mContentRoot.findViewById(id);
				
				if(null != v){
					
					v.setBackgroundColor(Color.TRANSPARENT);
				}
				
			}
		}
		
	}
}
