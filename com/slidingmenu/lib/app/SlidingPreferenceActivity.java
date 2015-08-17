package com.slidingmenu.lib.app;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class SlidingPreferenceActivity extends PreferenceActivity {
    private SlidingActivityHelper mHelper;

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mHelper = new SlidingActivityHelper(this);
        super.onCreate(bundle);
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

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
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

    public void setBehindContentView(View view) {
        setBehindContentView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    public void setBehindContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mHelper.setBehindContentView(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean onKeyUp = this.mHelper.onKeyUp(i, keyEvent);
        return onKeyUp ? onKeyUp : super.onKeyUp(i, keyEvent);
    }
}
