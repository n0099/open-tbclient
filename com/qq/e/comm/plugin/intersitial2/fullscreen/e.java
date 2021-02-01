package com.qq.e.comm.plugin.intersitial2.fullscreen;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.intersitial2.fullscreen.a.b;
import com.qq.e.comm.plugin.n.b;
import com.qq.e.comm.plugin.n.f;
import com.qq.e.comm.plugin.n.g;
import com.qq.e.comm.plugin.n.h;
import com.qq.e.comm.plugin.util.aa;
import com.qq.e.comm.plugin.util.q;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e implements ACTD, b.a, b.a, f.a {

    /* renamed from: a  reason: collision with root package name */
    private Activity f12147a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12148b;
    private c c;
    private ViewGroup d;
    private com.qq.e.comm.plugin.intersitial2.fullscreen.a.a e;
    private g f;
    private h g;
    private boolean h;
    private boolean i;
    private boolean j;
    private com.qq.e.comm.plugin.ad.g k;
    private com.qq.e.comm.plugin.y.c l = new com.qq.e.comm.plugin.y.c();
    private com.qq.e.comm.plugin.c.a.c m;

    public e(Activity activity) {
        this.f12147a = activity;
    }

    private void a(int i, String str) {
        a.a(this.c, this.d, i, str, this.m);
        InterstitialFSEventCenter.a().a(this.c.m(), 10003, null);
    }

    private int l() {
        if (this.c.k()) {
            return q.a(this.c) ? 2 : 0;
        }
        return 1;
    }

    private void m() {
        InterstitialFSEventCenter.a().a(this.c.m(), 10004, null);
        if (this.f12147a == null || this.f12147a.isFinishing()) {
            return;
        }
        this.f12147a.finish();
    }

    private void n() {
        if (this.e != null) {
            this.e.e();
        }
        if (this.g != null) {
            if (!this.h) {
                this.g.a(this.c.h());
            }
            this.g.b();
        }
        if (this.e != null) {
            this.e.b(this.d);
        }
        if (this.f != null) {
            this.f.a(this.d);
        }
        this.i = true;
    }

    private String o() {
        this.k.a().a(this.d.getHeight());
        this.k.a().b(this.d.getWidth());
        this.k.a().b(this.e != null && this.e.f());
        this.k.a().c(1);
        this.k.a().b(this.c != null ? this.c.x() : "-999");
        try {
            return this.k.b();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.qq.e.comm.plugin.n.b.a
    public void a() {
        int i = q.a(this.c) ? 7 : 1;
        com.qq.e.comm.plugin.intersitial2.c.a(true, this.l);
        this.k.b(System.currentTimeMillis());
        String o = o();
        try {
            JSONObject jSONObject = new JSONObject(o);
            jSONObject.put("click_area", String.valueOf(i));
            jSONObject.put("p", String.valueOf(this.e != null ? this.e.b().f() : 0));
            o = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(i, o);
    }

    @Override // com.qq.e.comm.plugin.n.f.a
    public void a(String str, boolean z) {
        int i = 2;
        com.qq.e.comm.plugin.intersitial2.c.b(false, this.l);
        if (l() == 2) {
            u.a(1140003, 0, this.l);
        }
        if (z) {
            i = 10;
        } else if (!this.h) {
            i = 4;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("click_area", String.valueOf(i));
            jSONObject.put("p", String.valueOf(this.e != null ? this.e.b().e() : 0));
            String optString = this.c.E().optString("template_id");
            jSONObject.put("vp", String.valueOf(1));
            jSONObject.put("sz", "-999");
            jSONObject.put("tid", optString);
            str = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(i, com.qq.e.comm.plugin.ad.g.a(str));
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.a
    public void a(boolean z, int i, Exception exc) {
        a.a(this.c, this.e, this.f12148b, 2);
        if (z) {
            com.qq.e.comm.plugin.intersitial2.c.a(com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN, false, this.l, i, exc);
        } else {
            com.qq.e.comm.plugin.intersitial2.c.a(com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN, this.l, this.c.g(), i, exc);
        }
        n();
    }

    @Override // com.qq.e.comm.plugin.n.f.a
    public void b() {
        m();
        com.qq.e.comm.plugin.intersitial2.c.b(true, this.l);
    }

    @Override // com.qq.e.comm.plugin.n.f.a
    public com.qq.e.comm.plugin.s.a c() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.a
    public void d() {
        GDTLogger.d("onVideoLoaded");
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.a
    public void e() {
        aa.a(this.c.j());
        com.qq.e.comm.plugin.intersitial2.c.a(com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN, true, this.l, 0, (Exception) null);
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.a
    public void f() {
        com.qq.e.comm.plugin.intersitial2.c.a(this.l);
        a.a(this.c, this.e, this.f12148b, 0);
        n();
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.a
    public void g() {
        if (this.f != null) {
            this.f.a();
            com.qq.e.comm.plugin.intersitial2.c.a(false, this.l);
        }
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.a
    public void h() {
        if (this.e != null) {
            a.a(this.c, this.e, this.f12148b, 0);
            n();
        }
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.a
    public void i() {
        this.k.b(System.currentTimeMillis());
        String o = o();
        try {
            JSONObject jSONObject = new JSONObject(o);
            jSONObject.put("click_area", String.valueOf(3));
            jSONObject.put("p", String.valueOf(this.e != null ? this.e.b().f() : 0));
            o = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(3, o);
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.a
    public void j() {
        this.k.b(System.currentTimeMillis());
        String o = o();
        try {
            JSONObject jSONObject = new JSONObject(o);
            jSONObject.put("click_area", String.valueOf(11));
            jSONObject.put("p", String.valueOf(this.e != null ? this.e.b().f() : 0));
            o = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(11, o);
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.a
    public boolean k() {
        return this.j;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        String stringExtra = this.f12147a.getIntent().getStringExtra(Constants.KEYS.AD_INFO);
        String stringExtra2 = this.f12147a.getIntent().getStringExtra("appid");
        String stringExtra3 = this.f12147a.getIntent().getStringExtra("adThreadId");
        String stringExtra4 = this.f12147a.getIntent().getStringExtra("posId");
        this.l.a(stringExtra4);
        com.qq.e.comm.plugin.ad.e eVar = com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN;
        if (TextUtils.isEmpty(stringExtra)) {
            GDTLogger.e("InterstitialFSActivityDelegate onAfterCreate adData null");
            com.qq.e.comm.plugin.intersitial2.c.a(eVar, true, 4014, this.l);
            this.f12147a.finish();
            return;
        }
        this.c = new c(stringExtra, stringExtra2, stringExtra4, stringExtra3);
        this.c.a(com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN);
        this.l.b(this.c.f()).c(this.c.H());
        if (TextUtils.isEmpty(this.c.g())) {
            com.qq.e.comm.plugin.intersitial2.c.a(eVar, true, 5020, this.l);
            this.f12147a.finish();
            return;
        }
        this.d = new RelativeLayout(this.f12147a);
        this.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.k = new com.qq.e.comm.plugin.ad.g();
        this.e = new com.qq.e.comm.plugin.intersitial2.fullscreen.a.b(this.f12147a, this.c, this.f12148b, this.k, this.l);
        this.e.a(this);
        this.e.a(this.c.g());
        this.e.a(this.d);
        this.f = com.qq.e.comm.plugin.n.a.a(this.f12147a, this.c, this.l);
        if (this.f != null) {
            this.f.a(this);
            this.f.a(this.k);
            this.f.a(this.d, this.f12148b);
        }
        boolean k = this.c.k();
        this.g = com.qq.e.comm.plugin.n.d.a(this.f12147a, this.c, this.k, "Interstitial", l(), this.l);
        this.g.a(this);
        if (k) {
            this.h = true;
            this.g.a(this.c.h());
        }
        this.g.a(this.d);
        this.g.a();
        this.m = new com.qq.e.comm.plugin.c.a.c(this.f12147a);
        this.f12147a.setContentView(this.d);
        com.qq.e.comm.plugin.ad.a.a().a(this.d);
        this.d.post(new Runnable() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.e.1
            @Override // java.lang.Runnable
            public void run() {
                InterstitialFSEventCenter.a().a(e.this.c.m(), 10002, null);
                e.this.k.a().c(1);
                e.this.k.a(System.currentTimeMillis());
                com.qq.e.comm.plugin.intersitial2.c.a((Boolean) null, e.this.l, 0, (Exception) null);
                a.a(e.this.c, e.this.d, e.this.k, new d.b() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.e.1.1
                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a() {
                        com.qq.e.comm.plugin.intersitial2.c.a((Boolean) true, e.this.l, 0, (Exception) null);
                    }

                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a(int i, Exception exc) {
                        com.qq.e.comm.plugin.intersitial2.c.a((Boolean) false, e.this.l, i, exc);
                    }
                });
            }
        });
        InterstitialFSEventCenter.a().a(this.c.m(), 10001, null);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        if (this.i) {
            b();
        } else if (this.e != null) {
            this.e.g();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.f12148b = "l".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation());
        this.f12147a.requestWindowFeature(1);
        this.f12147a.getWindow().setFlags(1024, 1024);
        this.f12147a.getWindow().setBackgroundDrawable(new ColorDrawable(ViewCompat.MEASURED_STATE_MASK));
        this.f12147a.getWindow().setFlags(16777216, 16777216);
        this.f12147a.getWindow().setFlags(128, 128);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        if (this.e != null) {
            this.e.h();
        }
        if (this.f != null) {
            this.f.c();
        }
        if (this.g != null) {
            this.g.c();
        }
        InterstitialFSEventCenter.a().a(this.c.m());
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        this.j = false;
        if (!this.i && this.e != null) {
            this.e.c();
        }
        if (this.c == null || this.e == null || this.i || this.f12147a == null || this.f12147a.isFinishing()) {
            return;
        }
        a.a(this.c, this.e, this.f12148b, 0);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        this.j = true;
        if (this.i || this.e == null) {
            return;
        }
        this.e.d();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }
}
