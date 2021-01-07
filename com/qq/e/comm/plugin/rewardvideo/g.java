package com.qq.e.comm.plugin.rewardvideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ap;
import com.qq.e.comm.plugin.util.ax;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.util.GDTLogger;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes4.dex */
public class g implements ACTD, com.qq.e.comm.plugin.ab.d.f {
    private String A;
    private String B;
    private String C;
    private com.qq.e.comm.plugin.ad.g D;
    private f F;
    private long G;

    /* renamed from: a  reason: collision with root package name */
    private Activity f12694a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.d.a f12695b;
    private long c;
    private long d;
    private long e;
    private String f;
    private boolean g;
    private com.qq.e.comm.plugin.rewardvideo.b.b h;
    private ax i;
    private com.qq.e.comm.plugin.rewardvideo.b.a k;
    private int n;
    private int o;
    private String r;
    private d s;
    private j t;
    private com.qq.e.comm.plugin.ab.b v;
    private ValueCallback<Uri[]> w;
    private ValueCallback<Uri> x;
    private String y;
    private String z;
    private boolean l = false;
    private boolean p = false;
    private int q = -1;
    private boolean u = false;
    private com.qq.e.comm.plugin.y.c E = new com.qq.e.comm.plugin.y.c();
    private boolean H = true;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private int j = GDTADManager.getInstance().getSM().getInteger("rewardPageCountDelayTime", 5);
    private int m = GDTADManager.getInstance().getSM().getInteger("rewardPageEffectiveTime", 15);

    public g(Activity activity) {
        this.f12694a = activity;
        this.n = GDTADManager.getInstance().getSM().getInteger("rewardPageCloseTime", 15);
        if (this.n > this.m) {
            this.n = this.m;
        }
        this.D = new com.qq.e.comm.plugin.ad.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        b(i, str, null);
    }

    private void b(int i, String str, String str2) {
        if (GDTADManager.getInstance().getSM().getInteger("rpnaspl", 1) == 1) {
            com.qq.e.comm.plugin.ab.b.a(i, this.c, this.E, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f12695b.d()) {
            this.f12695b.e();
        } else if (this.p) {
            if (this.v != null) {
                this.v.a(this.f, com.qq.e.comm.plugin.ab.b.e);
            }
            this.t.d();
            this.f12694a.finish();
            a(2050005, this.f);
        } else if (!this.l || this.i == null) {
        } else {
            this.i.d();
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.i = new ax(this.m * 1000, 500L) { // from class: com.qq.e.comm.plugin.rewardvideo.g.5
            @Override // com.qq.e.comm.plugin.util.ax
            public void a() {
                g.this.p = true;
                if (g.this.i == null || g.this.f12695b == null) {
                    return;
                }
                g.this.t.f();
                g.this.t.i();
                g.this.l = false;
                g.this.h.a(String.format(Locale.getDefault(), TextUtils.isEmpty(g.this.z) ? "恭喜获得奖励" : g.this.z, Integer.valueOf(g.this.m)));
                h.a(e.PAGE, g.this.E);
            }

            @Override // com.qq.e.comm.plugin.util.ax
            public void a(long j) {
                String str = TextUtils.isEmpty(g.this.y) ? "浏览页面 %d 秒可获得奖励" : g.this.y;
                int round = Math.round(((float) j) / 1000.0f);
                if (round > 0) {
                    g.this.h.a(String.format(Locale.getDefault(), str, Integer.valueOf(round)));
                } else {
                    g.this.h.a(String.format(Locale.getDefault(), TextUtils.isEmpty(g.this.z) ? "恭喜获得奖励" : g.this.z, Integer.valueOf(g.this.m)));
                    g.this.p = true;
                    g.this.l = false;
                }
                g.l(g.this);
                if (g.this.o >= g.this.n * 2 && g.this.n < g.this.m) {
                    g.this.g();
                } else if (g.this.o < g.this.m * 2 || g.this.n < g.this.m) {
                } else {
                    g.this.g();
                }
            }
        };
        this.i.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.l = true;
        this.h.a().setVisibility(0);
    }

    private void h() {
        String str = TextUtils.isEmpty(this.A) ? "浏览页面满 %d 秒即可获得奖励\n是否继续浏览页面" : this.A;
        String str2 = TextUtils.isEmpty(this.B) ? "继续浏览" : this.B;
        String str3 = TextUtils.isEmpty(this.C) ? "放弃奖励" : this.C;
        if (this.k == null) {
            this.k = new com.qq.e.comm.plugin.rewardvideo.b.a(this.f12694a);
        }
        this.k.setCancelable(false);
        if (!this.k.isShowing()) {
            this.k.show();
        }
        LinearLayout a2 = this.k.a(this.f12694a, String.format(Locale.getDefault(), str, Integer.valueOf(this.m)), str2, str3);
        this.k.setContentView(a2);
        if (this.k.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.k.getWindow().getAttributes();
            a2.measure(0, 0);
            attributes.width = a2.getMeasuredWidth();
            attributes.height = a2.getMeasuredHeight();
            attributes.gravity = 17;
            this.k.getWindow().setAttributes(attributes);
            this.k.getWindow().setBackgroundDrawable(ap.a(ak.a((Context) this.f12694a, 10), -1, 255));
        }
        this.k.a().setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.rewardvideo.g.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.v != null) {
                    g.this.v.a(g.this.f, com.qq.e.comm.plugin.ab.b.e);
                }
                g.this.t.d();
                g.this.f12694a.finish();
                g.this.a(2050005, g.this.f);
            }
        });
        this.k.b().setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.rewardvideo.g.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.i.e();
                g.this.k.cancel();
            }
        });
    }

    private String i() {
        View b2 = this.f12695b.b();
        this.D.a().a(b2.getHeight());
        this.D.a().b(b2.getWidth());
        try {
            JSONObject jSONObject = new JSONObject(this.D.b());
            jSONObject.put("click_area", 5);
            if (this.G > 0) {
                jSONObject.put("p", System.currentTimeMillis() - this.G);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    static /* synthetic */ int l(g gVar) {
        int i = gVar.o + 1;
        gVar.o = i;
        return i;
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(int i) {
        if (i == 100) {
            this.h.b();
        } else {
            this.h.a(i);
        }
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(int i, String str, String str2) {
        if (this.v != null) {
            this.v.a("", com.qq.e.comm.plugin.ab.b.d);
        }
        this.t.a(5027);
        h.a(false, i, str2, str, this.E);
        this.f12694a.finish();
        if (this.L) {
            return;
        }
        this.L = true;
        b(2050004, str2, str);
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(ValueCallback<Uri> valueCallback, Intent intent) {
        if (valueCallback == null || intent == null) {
            return;
        }
        this.x = valueCallback;
        this.f12694a.startActivityForResult(intent, 2);
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(String str) {
        if (this.v != null) {
            this.v.a(str, com.qq.e.comm.plugin.ab.b.c);
        }
        if (this.I) {
            return;
        }
        this.I = true;
        GDTLogger.d("PageFinished url=" + str);
        this.d = System.currentTimeMillis();
        GDTLogger.d("页面加载完成，耗时：" + (this.d - this.e));
        h.a(true, 0, null, null, this.E);
        a(2050003, str);
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(String str, Bitmap bitmap) {
        if (this.v != null) {
            this.v.a(str, com.qq.e.comm.plugin.ab.b.f12003b);
        }
        if (this.K) {
            return;
        }
        this.K = true;
        a(2050002, str);
    }

    public void b() {
        if (this.u) {
            return;
        }
        this.G = System.currentTimeMillis();
        this.D.a(2);
        h.b(e.PAGE, this.E);
        com.qq.e.comm.plugin.ad.a.a().a(this.f12695b.b());
        this.f12695b.b().post(new Runnable() { // from class: com.qq.e.comm.plugin.rewardvideo.g.8
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.f12695b == null || g.this.f12695b.b() == null) {
                    return;
                }
                String q = g.this.s.q();
                com.qq.e.comm.plugin.w.i.a(g.this.D.a(g.this.f12695b.b(), g.this.D.a().m(), g.this.s.x(), null), com.qq.e.comm.plugin.ad.a.a().b(g.this.f12695b.b()), g.this.s, new com.qq.e.comm.plugin.w.b(g.this.s.D(), com.qq.e.comm.plugin.ad.e.REWARDVIDEOAD, g.this.s.B()), q, new d.b() { // from class: com.qq.e.comm.plugin.rewardvideo.g.8.1
                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a() {
                        GDTLogger.d("RewardPage exposure success");
                        String t = g.this.s.t();
                        if (!TextUtils.isEmpty(t)) {
                            af.a(t);
                        }
                        h.a(e.PAGE, true, g.this.E);
                    }

                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a(int i, Exception exc) {
                        GDTLogger.e("RewardPage exposure error");
                        h.a(e.PAGE, false, g.this.E);
                    }
                });
            }
        });
        this.t.h();
        this.u = true;
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void b(String str) {
        this.f = str;
        if (this.J) {
            return;
        }
        this.J = true;
        GDTLogger.d("302 to url:" + str);
        this.e = System.currentTimeMillis();
        GDTLogger.d("点击到302耗时：" + (this.e - this.c));
        a(2050001, str);
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
        if (valueCallback == null || intent == null) {
            return false;
        }
        this.w = valueCallback;
        this.f12694a.startActivityForResult(intent, 1);
        return true;
    }

    public void c() {
        int i;
        if (this.s == null || this.s.z() == null) {
            i = 0;
        } else {
            i = com.qq.e.comm.plugin.a.l.a().a(this.s.z().d());
        }
        GDTLogger.d("RewardPage onADClick status:" + i + " isFirstClickAd:" + this.H);
        if ((i == 4 || i == 16 || i == 32 || i == 128) && !this.H) {
            return;
        }
        this.D.b(System.currentTimeMillis());
        this.D.a(2);
        this.F.a(this.s, i(), this.f12695b.b());
        this.t.e();
        this.H = false;
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void c(String str) {
    }

    public void d() {
        if (this.i == null) {
            f();
        }
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void d_() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        if (1 == i && this.w != null) {
            this.w.onReceiveValue((i2 != -1 || intent == null || (data = intent.getData()) == null) ? null : new Uri[]{data});
            this.w = null;
        } else if (2 != i || this.x == null) {
        } else {
            this.x.onReceiveValue((i2 != -1 || intent == null) ? null : intent.getData());
            this.x = null;
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        JSONObject jSONObject;
        this.f12694a.getWindow().setBackgroundDrawable(null);
        FrameLayout frameLayout = new FrameLayout(this.f12694a);
        this.f12694a.setContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.c = this.f12694a.getIntent().getLongExtra("clickStartTime", System.currentTimeMillis());
        String stringExtra = this.f12694a.getIntent().getStringExtra(Constants.KEYS.AD_INFO);
        String stringExtra2 = this.f12694a.getIntent().getStringExtra("appid");
        String stringExtra3 = this.f12694a.getIntent().getStringExtra("posId");
        this.s = new d(stringExtra, stringExtra2, stringExtra3, this.f12694a.getIntent().getStringExtra("adThreadId"));
        this.s.a(e.PAGE);
        this.f = this.s.a();
        String an = this.s.an();
        if (!TextUtils.isEmpty(an)) {
            this.v = new com.qq.e.comm.plugin.ab.b(an, this.c);
        }
        this.E.a(stringExtra3);
        this.E.b(this.s.j());
        this.E.c(this.s.H());
        this.t = j.b(this.f12694a.getIntent().getIntExtra("objectId", 0));
        if (this.t == null) {
            GDTLogger.e("RewardPage activity fail to create ! ad instance pass failed");
            if (this.v != null) {
                this.v.a(this.f, com.qq.e.comm.plugin.ab.b.e);
            }
            this.f12694a.finish();
            a(2050005, this.f);
            return;
        }
        this.t.g();
        if (!this.s.g()) {
            this.t.a(ARPMessageType.MSG_TYPE_RES_REQUEST);
            if (this.v != null) {
                this.v.a(this.f, com.qq.e.comm.plugin.ab.b.e);
            }
            this.f12694a.finish();
            a(2050005, this.f);
            return;
        }
        this.t.a(this);
        if (com.qq.e.comm.plugin.util.d.a(this.s.l_())) {
            try {
                JSONObject jSONObject2 = new JSONObject(stringExtra);
                this.q = jSONObject2.optInt("ecpm", -1);
                this.r = jSONObject2.optString("ecpm_level");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.h = new com.qq.e.comm.plugin.rewardvideo.b.b(this.f12694a);
        int applyDimension = (int) TypedValue.applyDimension(1, 45.0f, this.f12694a.getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, applyDimension);
        layoutParams.gravity = 48;
        this.h.setLayoutParams(layoutParams);
        this.h.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.h.a(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.rewardvideo.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.e();
            }
        });
        this.h.a(String.format(Locale.getDefault(), "浏览页面 %d 秒可获得奖励", Integer.valueOf(this.m)));
        if (this.n <= 0) {
            this.h.a().setVisibility(0);
        }
        frameLayout.addView(this.h);
        if (stringExtra != null) {
            try {
                jSONObject = new JSONObject(stringExtra);
            } catch (Exception e2) {
                GDTLogger.i("Parse adinfo failed:" + e2.getMessage());
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        this.f12695b = new com.qq.e.comm.plugin.ab.d.e(this.f12694a, jSONObject).a();
        this.f12695b.a(this);
        this.f12695b.a(this.f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = applyDimension;
        this.f12695b.b().setLayoutParams(layoutParams2);
        this.f12695b.c().a("rewardAD", new com.qq.e.comm.plugin.rewardvideo.a.a(this));
        this.f12695b.b().setOnTouchListener(new View.OnTouchListener() { // from class: com.qq.e.comm.plugin.rewardvideo.g.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (g.this.D != null) {
                    g.this.D.a(motionEvent, true);
                }
                return g.this.f12695b.b().onTouchEvent(motionEvent);
            }
        });
        frameLayout.addView(this.f12695b.b());
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.qq.e.comm.plugin.rewardvideo.g.3
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.i == null) {
                    g.this.f();
                }
                if (g.this.u) {
                    return;
                }
                g.this.b();
            }
        }, this.j * 1000);
        this.y = this.f12694a.getIntent().getStringExtra("rewardAdUnmetLeftTopText");
        this.z = this.f12694a.getIntent().getStringExtra("rewardAdHasDoneLeftTopText");
        this.A = this.f12694a.getIntent().getStringExtra("rewardAdCloseDialogText");
        this.B = this.f12694a.getIntent().getStringExtra("rewardAdConfirmButtonText");
        this.C = this.f12694a.getIntent().getStringExtra("rewardAdCancelButtonText");
        this.F = new f(new com.qq.e.comm.plugin.c.a.c(this.f12694a) { // from class: com.qq.e.comm.plugin.rewardvideo.g.4
            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void a() {
                if (g.this.s.v()) {
                    super.a();
                }
            }
        });
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        if (this.p) {
            e();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.f12694a.requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f12694a.getWindow().setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        this.u = true;
        if (this.v != null) {
            this.v.a(this.f, com.qq.e.comm.plugin.ab.b.g);
        }
        if (this.f12695b != null) {
            this.f12695b.a();
            this.f12695b = null;
        }
        if (this.i != null) {
            this.i.c();
            this.i = null;
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        if (this.i != null && (this.k == null || !this.k.isShowing())) {
            this.i.d();
        }
        if (this.v != null) {
            this.v.a(this.f, com.qq.e.comm.plugin.ab.b.f);
        }
        try {
            if (this.f12695b.b() != null) {
                this.f12695b.b().getClass().getMethod(MissionEvent.MESSAGE_PAUSE, new Class[0]).invoke(this.f12695b.b(), null);
                this.g = true;
            }
        } catch (Exception e) {
            GDTLogger.e("InnerBrowser onPause err" + e);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        if (this.i != null && (this.k == null || !this.k.isShowing())) {
            this.i.e();
        }
        try {
            if (this.g) {
                if (this.f12695b.b() != null) {
                    this.f12695b.b().getClass().getMethod(MissionEvent.MESSAGE_RESUME, new Class[0]).invoke(this.f12695b.b(), null);
                }
                this.g = false;
            }
        } catch (Exception e) {
            GDTLogger.e("InnerBrowser onResume err");
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }
}
