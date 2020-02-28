
package com.mobicule.client.taskdemo.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;

import com.mobicule.client.taskdemo.R;

public class SplashScreen extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);

		showSplash();
	}

	private void showSplash()
	{
		Thread mSplashThread = new Thread()
		{
			@Override
			public void run()
			{
				try
				{
					synchronized (this)
					{
						wait(2000);
					}
				}
				catch (InterruptedException ex)
				{

				}

				Intent intent = new Intent(SplashScreen.this, UserDataLIstClass.class);
				startActivity(intent);
				finish();
			}
		};

		mSplashThread.start();
	}

	@Override
	protected void onRestart()
	{
		finish();
		super.onRestart();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			android.os.Process.killProcess(android.os.Process.myPid());
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
