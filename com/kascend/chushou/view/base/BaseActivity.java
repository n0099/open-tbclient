package com.kascend.chushou.view.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.cstvsdk.CSTVSdk;
import com.kascend.cstvsdk.interfaces.ThirdParty;
/* loaded from: classes6.dex */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context w;
    protected ProgressDialog x;
    protected TextView y;
    protected final String v = getClass().getSimpleName();
    protected final io.reactivex.disposables.a z = new io.reactivex.disposables.a();

    /* renamed from: a  reason: collision with root package name */
    private ContentObserver f4229a = new ContentObserver(new Handler()) { // from class: com.kascend.chushou.view.base.BaseActivity.2
        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            int i;
            if (Build.VERSION.SDK_INT < 21) {
                i = Settings.System.getInt(BaseActivity.this.getContentResolver(), "navigationbar_is_min", 0);
            } else {
                i = Settings.Global.getInt(BaseActivity.this.getContentResolver(), "navigationbar_is_min", 0);
            }
            tv.chushou.zues.utils.e.d("guohe", "BaseActivity.onChange(): navigationBarIsMin = " + i);
            if (i == 1) {
                BaseActivity.this.a(false);
            } else {
                BaseActivity.this.a(true);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        tv.chushou.zues.utils.e.i(this.v, "onCreate <-----");
        super.onCreate(bundle);
        CSTVSdk.INSTANCE.check();
        this.w = this;
        ThirdParty thirdParty = (ThirdParty) tv.chushou.basis.d.b.etD().S(ThirdParty.class);
        if (thirdParty != null) {
            thirdParty.onEnterLiveRoom(this);
        }
        Window window = getWindow();
        window.clearFlags(1024);
        window.setBackgroundDrawable(null);
        a();
        M();
        b();
        tv.chushou.zues.utils.e.i(this.v, "onCreate ----->");
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        y();
    }

    protected int y() {
        return tv.chushou.zues.utils.systemBar.b.aC(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, "onPause <----");
        super.onPause();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.w);
        tv.chushou.zues.utils.e.d(this.v, "onPause ---->");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.d(this.v, "onDestroy()<---");
        this.z.dispose();
        super.onDestroy();
        if (this.x != null && this.x.isShowing()) {
            this.x.dismiss();
        }
        this.x = null;
        com.kascend.chushou.d.d.ohb.a();
        ThirdParty thirdParty = (ThirdParty) tv.chushou.basis.d.b.etD().S(ThirdParty.class);
        if (thirdParty != null) {
            thirdParty.onExitLiveRoom(this);
        }
        tv.chushou.zues.utils.e.d(this.v, "onDestroy()--->");
    }

    @Override // android.app.Activity
    public void finish() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        super.finish();
        com.kascend.chushou.d.e.a(this.w, false);
    }

    protected void a() {
    }

    public void M() {
        CharSequence title;
        this.y = (TextView) findViewById(a.f.tittle_name);
        if (this.y != null && (title = getTitle()) != null && title.length() > 0) {
            this.y.setText(getTitle());
        }
        View findViewById = findViewById(a.f.back_icon);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.base.BaseActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseActivity.this.finish();
                }
            });
        }
    }

    public void b() {
    }

    public void i(boolean z) {
        a(z, this.w.getString(a.i.update_userinfo_ing));
    }

    public void a(boolean z, String str) {
        if (z) {
            if (this.x == null) {
                this.x = new ProgressDialog(this.w);
                this.x.setProgressStyle(0);
                this.x.requestWindowFeature(1);
                this.x.setCancelable(true);
            }
            this.x.setMessage(str);
            if (!this.x.isShowing()) {
                this.x.show();
            }
        } else if (this.x != null && this.x.isShowing()) {
            this.x.dismiss();
        }
    }

    public void a_(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(boolean z) {
        if (z) {
            if (Build.VERSION.SDK_INT < 21) {
                getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, this.f4229a);
                return;
            } else {
                getContentResolver().registerContentObserver(Settings.Global.getUriFor("navigationbar_is_min"), true, this.f4229a);
                return;
            }
        }
        getContentResolver().unregisterContentObserver(this.f4229a);
    }

    protected void a(boolean z) {
    }
}
