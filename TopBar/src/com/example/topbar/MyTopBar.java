package com.example.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//�Զ���UI��
//1�������Ҫ������;��values��mytopbar.xml��
//2��ʵ��һ���Լ��ġ�View������public class MyTopBar extends RelativeLayout�� 
//3�������Լ��ġ�View��;

//�̳�RelativeLayout����д���췽��
public class MyTopBar extends RelativeLayout {

	// �Զ���Ŀؼ����Զ�������ԣ�values��mytopbar.xml��������
	private Button leftButton, rightButton;
	private TextView tvTitle;

	private int leftTextColor;
	private Drawable leftDrawable;
	private String leftText;

	private float titleTextSize;
	private int titleTextColor;
	private String title;

	private int rightTextColor;
	private Drawable rightDrawable;
	private String rightText;

	private LayoutParams leftLayoutParams, titleLayoutParams, rightLayoutParams;

	private myTopbarClicklistenter clicklistenter;
	
	//�Զ���click�ļ����ص��ӿ�
	public interface myTopbarClicklistenter{
		public void leftClick();
		public void rightClick();
	}
	
	//�Զ���һ��setOnClickListenter����
	public void setOnTopbarClickListenter(myTopbarClicklistenter clicklistenter){
		this.clicklistenter=clicklistenter;   //���õ�ʱ��ͨ��һ�������ڲ���ӳ�����
	}
	
	//��д���췽��
	public MyTopBar(Context context, AttributeSet attrs) {
		
		super(context, attrs);
		
		// ��ȡ�Զ�������ԣ������Զ��������ӳ�䵽�Զ��������ֵ��ȥ
		// ͨ��obtainStyledAttributes��ȡ�Զ������ԣ����浽TypedArray
		TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.MyTopBar);  

		leftTextColor = ta.getColor(R.styleable.MyTopBar_leftTextColor, 0);    //��TypedArray��ȡ����������Ӧ���Զ��������ֵ��
		leftDrawable = ta.getDrawable(R.styleable.MyTopBar_leftBackGround);
		leftText = ta. getString(R.styleable.MyTopBar_leftText);

		titleTextSize = ta.getDimension(R.styleable.MyTopBar_titleTextSize, 0);
		titleTextColor = ta.getColor(R.styleable.MyTopBar_titleTextColor, 0);
		title = ta.getString(R.styleable.MyTopBar_title);

		rightTextColor = ta.getColor(R.styleable.MyTopBar_rightTextColor, 0);
		rightDrawable = ta.getDrawable(R.styleable.MyTopBar_rightBackGround);
		rightText = ta.getString(R.styleable.MyTopBar_rightText);

		ta.recycle();

		//�������
		leftButton = new Button(context);
		tvTitle = new TextView(context);
		rightButton = new Button(context);

		// ���Զ�����������õ��ؼ���
		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftDrawable);
		leftButton.setText(leftText);

		tvTitle.setTextColor(titleTextColor);
		tvTitle.setTextSize(titleTextSize);
		tvTitle.setText(title);
		tvTitle.setGravity(Gravity.CENTER);    // �������־���

		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightDrawable);
		rightButton.setText(rightText);

		setBackgroundColor(0xFFF59563);    // ���ñ�����ɫ
		
		//���Զ���Ŀؼ��ŵ�Layout�У���LayoutParams����ʽ��
		leftLayoutParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);     //���������		
		addView(leftButton,leftLayoutParams);  //leftButton��leftLayoutParams����ʽ���뵽ViewGroup��
		
		titleLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
		titleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);  //���þ��ж���		
		addView(tvTitle,titleLayoutParams);    //tvTitle��titleLayoutParams����ʽ���뵽ViewGroup��
				
		rightLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		rightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE); //�����Ҷ���		
		addView(rightButton,rightLayoutParams);//rightButton��rightLayoutParams����ʽ���뵽ViewGroup��
		
		//���ü����¼�
		leftButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicklistenter.leftClick();
			}
		});
		
		rightButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicklistenter.rightClick();
			}
		});
		
	}
	
	//������Button�Ƿ���ʾ
	public void setLeftIsVisible(boolean flag){
		if(flag){
			leftButton.setVisibility(View.VISIBLE);
		}else{
			leftButton.setVisibility(View.GONE);
		}
	}
	
	// ������Button�Ƿ���ʾ
	public void setRightIsVisible(boolean flag) {
		if (flag) {
			rightButton.setVisibility(View.VISIBLE);
		} else {
			rightButton.setVisibility(View.GONE);
		}
	}
}
