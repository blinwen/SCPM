package douzi.kaoshi.scpm;

import java.util.ArrayList;
import java.util.List;

/**
 * һ����ѡ��,ֻ��һ�����,������ܶ�Ӧ���ɸ�ѡ����Ŀ
 * @author wenbaolin
 *
 */
public class SingleChoiceQues {
	
	/**
	 * ��Ŀ���
	 */
	private int 				mID;
	
	/**
	 * �������
	 */
	private String				mContent;
	
	/**
	 * ����¶�Ӧ��������Ŀ(������)
	 */
	private List<SubChoiceQues>		mSubChoice;
	
	public SingleChoiceQues(){
		mSubChoice = new ArrayList<SubChoiceQues>();
	}
	
	public void addSubQuestion(SubChoiceQues ci){
		
		ci.mMain = this;
		
		mSubChoice.add(ci);
	}
	
	public List<SubChoiceQues> getSubQuestion(){
		return mSubChoice;
	}
	
	public void setID(int id){
		mID = id;
	}
	
	public int getID(){
		return mID;
	}
	
	public void setContent(String strContent){
		this.mContent = strContent;
	}
	
	public String getContent(){
		
		return this.mContent;
	}
}
