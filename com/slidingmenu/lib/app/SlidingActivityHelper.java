package com.slidingmenu.lib.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class SlidingActivityHelper {
    private Activity mActivity;
    private SlidingMenu mSlidingMenu;
    private View mViewAbove;
    private View mViewBehind;
    private boolean mBroadcasting = false;
    private boolean mOnPostCreateCalled = false;
    private boolean mEnableSlide = true;

    public SlidingActivityHelper(Activity activity) {
        this.mActivity = activity;
    }

    public void onCreate(Bundle bundle) {
        this.mSlidingMenu = (SlidingMenu) LayoutInflater.from(this.mActivity).inflate(R.layout.slidingmenumain, (ViewGroup) null);
    }

    public void onPostCreate(Bundle bundle) {
        final boolean z;
        final boolean z2 = false;
        if (this.mViewBehind == null || this.mViewAbove == null) {
            throw new IllegalStateException("Both setBehindContentView must be called in onCreate in addition to setContentView.");
        }
        this.mOnPostCreateCalled = true;
        this.mSlidingMenu.attachToActivity(this.mActivity, this.mEnableSlide ? 0 : 1);
        if (bundle != null) {
            z2 = bundle.getBoolean("SlidingActivityHelper.open");
            z = bundle.getBoolean("SlidingActivityHelper.secondary");
        } else {
            z = false;
        }
        new Handler().post(new Runnable() { // from class: com.slidingmenu.lib.app.SlidingActivityHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (!z2) {
                    SlidingActivityHelper.this.mSlidingMenu.showContent(false);
                } else if (z) {
                    SlidingActivityHelper.this.mSlidingMenu.showSecondaryMenu(false);
                } else {
                    SlidingActivityHelper.this.mSlidingMenu.showMenu(false);
                }
            }
        });
    }

    public void setSlidingActionBarEnabled(boolean z) {
        if (this.mOnPostCreateCalled) {
            throw new IllegalStateException("enableSlidingActionBar must be called in onCreate.");
        }
        this.mEnableSlide = z;
    }

    public View findViewById(int i) {
        View findViewById;
        if (this.mSlidingMenu == null || (findViewById = this.mSlidingMenu.findViewById(i)) == null) {
            return null;
        }
        return findViewById;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("SlidingActivityHelper.open", this.mSlidingMenu.isMenuShowing());
        bundle.putBoolean("SlidingActivityHelper.secondary", this.mSlidingMenu.isSecondaryMenuShowing());
    }

    public void registerAboveContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.mBroadcasting) {
            this.mViewAbove = view;
        }
    }

    public void setContentView(View view) {
        this.mBroadcasting = true;
        this.mActivity.setContentView(view);
    }

    public void setBehindContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mViewBehind = view;
        this.mSlidingMenu.setMenu(this.mViewBehind);
    }

    public SlidingMenu getSlidingMenu() {
        return this.mSlidingMenu;
    }

    public void toggle() {
        this.mSlidingMenu.toggle();
    }

    public void showContent() {
        this.mSlidingMenu.showContent();
    }

    public void showMenu() {
        this.mSlidingMenu.showMenu();
    }

    public void showSecondaryMenu() {
        this.mSlidingMenu.showSecondaryMenu();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mSlidingMenu.isMenuShowing()) {
            showContent();
            return true;
        }
        return false;
    }
}
