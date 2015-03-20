package com.slidingmenu.lib.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class SlidingFragmentActivity extends FragmentActivity implements SlidingActivityBase {
    private SlidingActivityHelper mHelper;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHelper = new SlidingActivityHelper(this);
        this.mHelper.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.mHelper.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        View findViewById = super.findViewById(i);
        return findViewById != null ? findViewById : this.mHelper.findViewById(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mHelper.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        setContentView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.mHelper.registerAboveContentView(view, layoutParams);
    }

    @Override // com.slidingmenu.lib.app.SlidingActivityBase
    public void setBehindContentView(int i) {
        setBehindContentView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    @Override // com.slidingmenu.lib.app.SlidingActivityBase
    public void setBehindContentView(View view) {
        setBehindContentView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.slidingmenu.lib.app.SlidingActivityBase
    public void setBehindContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mHelper.setBehindContentView(view, layoutParams);
    }

    @Override // com.slidingmenu.lib.app.SlidingActivityBase
    public SlidingMenu getSlidingMenu() {
        return this.mHelper.getSlidingMenu();
    }

    @Override // com.slidingmenu.lib.app.SlidingActivityBase
    public void toggle() {
        this.mHelper.toggle();
    }

    @Override // com.slidingmenu.lib.app.SlidingActivityBase
    public void showContent() {
        this.mHelper.showContent();
    }

    @Override // com.slidingmenu.lib.app.SlidingActivityBase
    public void showMenu() {
        this.mHelper.showMenu();
    }

    @Override // com.slidingmenu.lib.app.SlidingActivityBase
    public void showSecondaryMenu() {
        this.mHelper.showSecondaryMenu();
    }

    @Override // com.slidingmenu.lib.app.SlidingActivityBase
    public void setSlidingActionBarEnabled(boolean z) {
        this.mHelper.setSlidingActionBarEnabled(z);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean onKeyUp = this.mHelper.onKeyUp(i, keyEvent);
        return onKeyUp ? onKeyUp : super.onKeyUp(i, keyEvent);
    }
}
