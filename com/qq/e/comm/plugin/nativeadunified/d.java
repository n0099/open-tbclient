package com.qq.e.comm.plugin.nativeadunified;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.kwai.video.player.PlayerProps;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.gdtnativead.a.a;
import com.qq.e.comm.plugin.gdtnativead.a.b;
import com.qq.e.comm.plugin.nativeadunified.b;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.util.n;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ACTD, b.a {

    /* renamed from: b  reason: collision with root package name */
    private Activity f12265b;
    private FrameLayout c;
    private com.qq.e.comm.plugin.aa.b.f d;
    private MediaView e;
    private com.qq.e.comm.plugin.ac.a f;
    private com.qq.e.comm.plugin.gdtnativead.a.c g;
    private FrameLayout.LayoutParams h;
    private FrameLayout.LayoutParams i;
    private com.qq.e.comm.plugin.ad.g j;
    private boolean k;
    private boolean l;
    private com.qq.e.comm.plugin.ab.d.a m;
    private com.qq.e.comm.plugin.gdtnativead.a.b n;
    private com.qq.e.comm.plugin.gdtnativead.a.a o;
    private boolean p;
    private String q;
    private com.qq.e.comm.plugin.nativeadunified.b r;
    private com.qq.e.comm.plugin.s.a s;
    private boolean u;
    private int v;

    /* renamed from: a  reason: collision with root package name */
    private final String f12264a = getClass().getSimpleName();
    private a t = new a();
    private b w = new b();
    private com.qq.e.comm.plugin.y.c x = new com.qq.e.comm.plugin.y.c();
    private boolean y = false;

    /* loaded from: classes3.dex */
    private class a implements b.a {
        private a() {
        }

        @Override // com.qq.e.comm.plugin.nativeadunified.b.a
        public void a() {
            d.this.f12265b.setRequestedOrientation(d.this.v == 4 ? 1 : 0);
            u.a(30262, d.this.v, d.this.x);
        }

        @Override // com.qq.e.comm.plugin.nativeadunified.b.a
        public void a(String str, int i, int i2, long j) {
            if (!(i == 4 && i2 % 5 == 0) && i == 4) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.arg1 = i2;
            obtain.arg2 = i;
            d.this.w.sendMessage(obtain);
        }

        @Override // com.qq.e.comm.plugin.nativeadunified.b.a
        public void b() {
            if (d.this.v == 4) {
                d.this.f12265b.setRequestedOrientation(1);
                return;
            }
            if (d.this.d != null && d.this.d.c() && d.this.g != null) {
                d.this.g.d();
            }
            d.this.h();
            GDTLogger.d("NativeAdDetailPageActivityDelegate onCloseButtonClicked");
            d.this.j();
        }

        @Override // com.qq.e.comm.plugin.nativeadunified.b.a
        public void c() {
        }

        @Override // com.qq.e.comm.plugin.nativeadunified.b.a
        public void d() {
            ai.a(d.this.f12264a, "onVideoPlaying: isResume = " + d.this.l);
            if (d.this.k || d.this.l) {
                return;
            }
            d.this.e();
        }
    }

    /* loaded from: classes3.dex */
    private class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (d.this.f != null) {
                        d.this.f.a(message.arg1);
                        if (message.arg1 == 100) {
                            d.this.f.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (d.this.f != null) {
                        d.this.f.setVisibility(8);
                    }
                    if (d.this.g != null) {
                        d.this.g.c();
                        return;
                    }
                    return;
                case 3:
                    if (d.this.p && d.this.o != null) {
                        d.this.o.a(message.arg1, message.arg2);
                        return;
                    } else if (d.this.n != null) {
                        d.this.n.a(message.arg1, message.arg2);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public d(Activity activity) {
        this.f12265b = activity;
    }

    private void a() {
        FrameLayout frameLayout = new FrameLayout(this.f12265b);
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        TextView textView = new TextView(this.f12265b);
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setText("未知错误，请稍后再试");
        textView.setTextSize(24.0f);
        textView.setGravity(17);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(textView, layoutParams);
        this.f12265b.setContentView(frameLayout);
        this.f12265b.setRequestedOrientation(1);
        JSONObject a2 = n.a(this.f12265b, this.r);
        u.a(30292, 5, this.x, new com.qq.e.comm.plugin.y.d(a2));
        GDTLogger.i("after: " + a2.toString());
    }

    private void a(int i) {
        if (this.n == null) {
            this.n = new com.qq.e.comm.plugin.gdtnativead.a.b(this.f12265b, this.s.z(), this.s.E());
            this.n.a(this);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = i;
        this.c.addView(this.n, layoutParams);
        if (f()) {
            c(true);
        }
    }

    private void a(int i, String str, boolean z) {
        if (this.m == null) {
            this.m = new com.qq.e.comm.plugin.ab.d.e(this.f12265b, this.s.E()).a();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = i;
        this.c.addView(this.m.b(), layoutParams);
        if (this.u) {
            b(str);
        } else {
            a(str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent) {
        this.j.a((View) this.c, motionEvent, false);
    }

    private void a(final String str, boolean z) {
        if (str == null) {
            return;
        }
        if (f()) {
            str = az.c(str, "_autodownload", "1");
        }
        if (z) {
            String a2 = com.qq.e.comm.plugin.w.a.h.a(str);
            final String d = this.s.z() != null ? this.s.z().d() : null;
            com.qq.e.comm.plugin.w.a.d.a(a2, this.s, new com.qq.e.comm.plugin.util.j<Pair<Integer, JSONObject>>() { // from class: com.qq.e.comm.plugin.nativeadunified.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.qq.e.comm.plugin.util.j
                public void a(Pair<Integer, JSONObject> pair) {
                    if (d.this.c == null) {
                        return;
                    }
                    if (pair != null && pair.second != null) {
                        String optString = ((JSONObject) pair.second).optString("clickid");
                        com.qq.e.comm.plugin.w.a.a(optString);
                        com.qq.e.comm.plugin.w.a.a(d, optString);
                        String optString2 = ((JSONObject) pair.second).optString("dstlink");
                        if (!TextUtils.isEmpty(optString2)) {
                            d.this.b(optString2);
                            return;
                        }
                    }
                    d.this.b(str);
                    u.a(30252, 0, d.this.x);
                }
            });
            c(a2);
            return;
        }
        this.s.X();
        this.s.Y();
        this.m.a(str);
        c(str);
    }

    private void a(boolean z) {
        if (this.e == null) {
            return;
        }
        if (z) {
            this.e.setLayoutParams(this.i);
            b(4);
        } else {
            this.e.setLayoutParams(this.h);
            b(3);
        }
        this.e.bringToFront();
    }

    private void a(boolean z, String str) {
        if (StringUtil.isEmpty(str)) {
            str = g();
        }
        if (this.e != null && this.g != null && this.g.getParent() == null) {
            this.g.setVisibility(0);
        }
        int min = (int) (Math.min(ak.b(this.f12265b), ak.c(this.f12265b)) * 0.5625f);
        if (this.s.v()) {
            if (this.s.w()) {
                a(min, this.u ? this.q : com.qq.e.comm.plugin.w.a.d.a((String) null, this.s.E(), str, this.r.i()), z);
                return;
            } else if (!this.p) {
                a(min);
                return;
            } else {
                l();
                k();
                return;
            }
        }
        String s = this.u ? this.q : this.s.s();
        if (!TextUtils.isEmpty(s) && !this.u) {
            s = az.a(s, "s", str);
            if (t.a(s)) {
                ai.b("gdt_tag_p", "get P in addFullscreenViews , url = %s", s);
                s = t.a(s, com.qq.e.comm.plugin.ad.g.a(str, this.r.i(), "click"));
            }
        }
        a(min, s, z);
    }

    @TargetApi(14)
    private void b() {
        this.e = new MediaView(this.f12265b);
        this.e.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.nativeadunified.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.d != null) {
                    d.this.d.n();
                }
            }
        });
        this.i = new FrameLayout.LayoutParams(-1, -1);
        this.c.addView(this.e, this.i);
        if (this.p) {
            this.h = new FrameLayout.LayoutParams(-1, Math.min(ak.c(this.f12265b), (ak.b(this.f12265b) * this.s.Q()) / this.s.P()), 17);
        } else {
            this.h = new FrameLayout.LayoutParams(-1, (int) (Math.min(ak.c(this.f12265b), ak.b(this.f12265b)) * 0.5625f));
        }
        this.e.post(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.v == 3) {
                    d.this.e.setLayoutParams(d.this.h);
                }
            }
        });
        this.d = c.b();
        com.qq.e.comm.plugin.aa.b.b c = c.c();
        if (c != null && (c instanceof com.qq.e.comm.plugin.gdtnativead.a.c)) {
            this.g = (com.qq.e.comm.plugin.gdtnativead.a.c) c;
            b(3);
        }
        if (this.d == null || this.g == null) {
            GDTLogger.e("NativeUnifiedADController don't provide necessary widget");
            u.a(30242, 0, this.x);
            j();
            return;
        }
        ViewParent parent = this.d.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.d);
        }
        ViewParent parent2 = this.g.getParent();
        if (parent2 != null) {
            ((ViewGroup) parent2).removeView(this.g);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.e.addView(this.d, 0, layoutParams);
        this.e.addView(this.g, 1, layoutParams);
        if (this.p) {
            this.g.e(this.d.getWidth() < this.d.getHeight());
            com.qq.e.comm.plugin.aa.b.a.a(this.c, this.s.o(), this.d, -872415232, true);
            this.g.a();
        } else {
            com.qq.e.comm.plugin.aa.b.a.a(this.e, this.s.o(), this.d);
            this.g.c(false);
        }
        if (this.y) {
            this.d.h();
        } else {
            this.d.i();
        }
        this.d.b(false);
        if (this.d.c()) {
            return;
        }
        c();
    }

    private void b(int i) {
        this.v = i;
        this.r.a(this.v);
        if (this.g != null) {
            this.g.a(i);
            this.g.g();
            this.g.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.m != null) {
                    d.this.m.a(str);
                }
            }
        });
    }

    private void c() {
        b.d f = this.r.f();
        if (f != b.d.NOT_DOWNLOAD && f != b.d.START) {
            this.r.e_();
            return;
        }
        d();
        if (this.g != null) {
            this.g.d();
        }
        this.r.a(new b.c() { // from class: com.qq.e.comm.plugin.nativeadunified.d.4
            @Override // com.qq.e.comm.plugin.nativeadunified.b.c
            public void a() {
                d.this.r.e_();
            }

            @Override // com.qq.e.comm.plugin.nativeadunified.b.c
            public void a(int i) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.arg1 = i;
                d.this.w.sendMessage(obtain);
            }

            @Override // com.qq.e.comm.plugin.nativeadunified.b.c
            public void b() {
            }
        });
        if (f == b.d.NOT_DOWNLOAD) {
            this.r.a(false);
        }
    }

    private void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", "InnerBrowser");
        com.qq.e.comm.plugin.w.a.d.a(str, this.s.E(), c.f(), c.e(), hashMap);
    }

    private void d() {
        this.f = new com.qq.e.comm.plugin.ac.a(this.e.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(this.e.getContext().getApplicationContext(), 46), ak.a(this.e.getContext().getApplicationContext(), 46));
        layoutParams.gravity = 17;
        this.e.addView(this.f, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        GDTLogger.d("NativeAdDetailPage stopVideo() mVideoView: " + this.d);
        this.r.a(b.EnumC1199b.AUTO_PAUSE);
        if (this.d != null) {
            this.d.a();
        }
    }

    private boolean f() {
        return this.s.v() && this.s.z() != null && com.qq.e.comm.plugin.a.e.b.a(this.s.z().h(), this.s.B());
    }

    private String g() {
        this.j.a().b(this.c.getMeasuredWidth());
        this.j.a().a(this.c.getMeasuredHeight());
        this.j.a().b(this.s.x());
        try {
            String b2 = this.j.b();
            GDTLogger.d("anti info:" + b2);
            return URLEncoder.encode(b2, "UTF-8");
        } catch (Exception e) {
            GDTLogger.w("Get anti failed:" + e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.k = true;
        if (this.d != null) {
            this.d.b(true);
        }
        if (!this.p || this.g == null) {
            return;
        }
        this.g.l();
    }

    private boolean i() {
        return "l".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.r != null) {
            this.r.k();
        }
        this.f12265b.finish();
    }

    private void k() {
        Context context = this.c.getContext();
        ImageView imageView = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(context, 46), ak.a(context, 14));
        layoutParams.gravity = 8388693;
        this.c.addView(imageView, layoutParams);
        com.qq.e.comm.plugin.util.g.a(imageView, this.s.C());
    }

    private void l() {
        if (this.o == null) {
            this.o = new com.qq.e.comm.plugin.gdtnativead.a.a(this.f12265b, this.s.z(), this.s);
            this.o.a(this);
            this.o.a(new a.InterfaceC1191a() { // from class: com.qq.e.comm.plugin.nativeadunified.d.7
                @Override // com.qq.e.comm.plugin.gdtnativead.a.a.InterfaceC1191a
                public void a() {
                    if (d.this.d != null && d.this.d.c() && d.this.g != null) {
                        d.this.g.d();
                    }
                    d.this.h();
                    GDTLogger.d("NativeAdDetailPageActivityDelegateWeb onCloseButtonClicked");
                    d.this.j();
                }

                @Override // com.qq.e.comm.plugin.gdtnativead.a.a.InterfaceC1191a
                public void b() {
                    d.this.g.k();
                    d.this.o.postDelayed(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.d.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.this.o == null || d.this.g == null) {
                                return;
                            }
                            d.this.o.a(d.this.g.j());
                        }
                    }, 50L);
                }
            });
        }
        this.o.a(this.y);
        this.c.addView(this.o, new FrameLayout.LayoutParams(-1, -1));
        if (f()) {
            c(true);
        }
    }

    public com.qq.e.comm.plugin.a.c a(String str) {
        List<com.qq.e.comm.plugin.a.c> d = com.qq.e.comm.plugin.a.l.a().d();
        if (d != null && d.size() > 0) {
            for (com.qq.e.comm.plugin.a.c cVar : d) {
                if (cVar.h().equals(str)) {
                    return cVar;
                }
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.a.b.a
    public void c(boolean z) {
        if (this.r == null) {
            return;
        }
        this.j.b(System.currentTimeMillis());
        if (this.u) {
            this.r.a(this.c, g(), z);
        } else if (this.s.z() != null && this.s.z().h() == 4) {
            com.qq.e.comm.plugin.a.c a2 = a(this.s.z().d());
            if (a2 != null) {
                com.qq.e.comm.plugin.a.l.a().a(a2.m(), 1);
            }
        } else if (this.s.z() == null || this.s.z().h() != 32) {
            this.r.a(this.c, 2, this.s.n(), this.s.B(), this.s.D(), g(), this.s.v(), z);
        } else {
            com.qq.e.comm.plugin.a.c a3 = a(this.s.z().d());
            if (a3 != null) {
                com.qq.e.comm.plugin.a.l.a().a(a3.m());
            }
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        if (this.r == null || this.s == null) {
            a();
            return;
        }
        this.c = new FrameLayout(this.f12265b) { // from class: com.qq.e.comm.plugin.nativeadunified.d.1
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                d.this.a(motionEvent);
                return super.dispatchTouchEvent(motionEvent);
            }
        };
        this.f12265b.setContentView(this.c);
        this.f12265b.setRequestedOrientation(1);
        this.j = this.r.e();
        this.v = i() ? 4 : 3;
        this.r.a(this.v);
        Intent intent = this.f12265b.getIntent();
        String stringExtra = intent.getStringExtra("antiSpam");
        this.y = intent.getBooleanExtra("detailPageMuted", false);
        this.q = intent.getStringExtra("url");
        this.p = this.s.v() && !this.s.w() && this.s.aa();
        b();
        a(c.d(), stringExtra);
        GDTLogger.d("NativeAdDetailPageActivityDelegate product type:" + this.s.a_() + " landding page:" + this.s.w());
        if (!this.c.isHardwareAccelerated()) {
            GDTLogger.e("Hardware acceleration is off");
            u.a(PlayerProps.FFP_PROP_STRING_STREAM_ID, 2, this.x);
        }
        this.r.a(this.t);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        GDTLogger.d("NativeAdDetailPageActivityDelegate onBackPressed");
        if (i()) {
            this.f12265b.setRequestedOrientation(1);
            return;
        }
        GDTLogger.d("NativeAdDetailPageActivityDelegate onBackPressed");
        if (this.d != null && this.d.c() && this.g != null) {
            this.g.d();
        }
        h();
        j();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.r = c.a();
        if (this.r != null && this.r.d() && Build.VERSION.SDK_INT >= 11) {
            this.f12265b.getWindow().setFlags(16777216, 16777216);
        }
        if (this.r == null) {
            GDTLogger.e("mAd is null, why??");
            JSONObject a2 = n.a(this.f12265b, this.r);
            u.a(30292, 2, this.x, new com.qq.e.comm.plugin.y.d(a2));
            GDTLogger.i("before: mAdController " + a2.toString());
        } else {
            this.s = this.r.n();
            if (this.s == null) {
                JSONObject a3 = n.a(this.f12265b, this.r);
                u.a(30292, 6, this.x, new com.qq.e.comm.plugin.y.d(a3));
                GDTLogger.i("before: mAdInfo " + a3.toString());
            } else {
                this.u = com.qq.e.comm.plugin.c.e.a(this.s);
                String B = this.s.B();
                this.x.a(B).c(this.s.H()).b(this.s.m());
            }
        }
        u.a(30222, 1, this.x);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
        a(i());
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        if (this.r == null) {
            return;
        }
        this.e.removeView(this.d);
        this.e.removeView(this.g);
        this.d = null;
        this.g = null;
        if (this.m != null) {
            this.m.a();
            this.m = null;
        }
        if (this.n != null) {
            this.n.removeAllViews();
            this.n = null;
        }
        this.r.j();
        this.r.a((b.c) null);
        this.w.removeCallbacksAndMessages(null);
        u.a(30222, 2, this.x);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        this.l = false;
        if (this.r == null) {
            return;
        }
        ai.a(this.f12264a, "onPause() MediaStatus: " + this.r.h());
        if (this.r.h() != b.EnumC1199b.PLAYING || this.k) {
            return;
        }
        e();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        this.l = true;
        if (this.r == null || this.s == null) {
            return;
        }
        ai.a(this.f12264a, "onResume: mediaStatus = " + this.r.h());
        if (this.r.h() == b.EnumC1199b.AUTO_PAUSE) {
            this.r.e_();
            this.r.a(b.EnumC1199b.PLAYING);
        }
        if (this.s.z() != null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.arg1 = this.s.z().f();
            obtain.arg2 = this.s.z().h();
            this.w.sendMessage(obtain);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }
}
