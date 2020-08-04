package com.kascend.chushou.view.h5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.view.base.BaseActivity;
import tv.chushou.zues.utils.e;
/* loaded from: classes6.dex */
public class H5Activity extends BaseActivity {
    public static int d = 0;
    public String b;
    private String f;
    private a nEc;
    public boolean a = true;
    public boolean c = false;

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void a() {
        super.setContentView(a.h.activity_h5_page);
        a(getIntent());
        e.d(this.v, "mH5Url = " + this.b + ", mCanBack = " + this.a);
        a(this.f);
        H5Options h5Options = new H5Options();
        h5Options.c = this.c;
        h5Options.b = this.a;
        h5Options.a = this.b;
        this.nEc = a.a(h5Options);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(a.f.fl_fragment, this.nEc);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        e.i(this.v, "onNewIntent");
        a(intent);
        if (this.nEc != null) {
            this.nEc.a(this.a);
            this.nEc.a(this.b);
        }
    }

    public void a(String str) {
        TextView textView = (TextView) findViewById(a.f.tittle_name);
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void a(Intent intent) {
        Bundle bundleExtra;
        if (intent != null && (bundleExtra = intent.getBundleExtra("extra")) != null) {
            this.b = bundleExtra.getString("mH5Url");
            if (this.b != null && this.b.contains("bizCode")) {
                d++;
            }
            this.f = bundleExtra.getString("mTitle");
            this.c = bundleExtra.getBoolean("mEnableRefresh");
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.nEc != null && this.nEc.a()) {
            this.nEc.a(i, keyEvent);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        e.d(this.v, "onActivityResult");
        super.onActivityResult(i, i2, intent);
        if (this.nEc != null) {
            this.nEc.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null && this.b.contains("bizCode")) {
            d--;
        }
        this.nEc = null;
    }
}
