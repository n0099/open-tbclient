package com.qq.e.comm.plugin.rewardvideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ac.b;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.n.b;
import com.qq.e.comm.plugin.n.f;
import com.qq.e.comm.plugin.util.aa;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ao;
import com.qq.e.comm.plugin.util.ap;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.util.ba;
import com.qq.e.comm.plugin.util.q;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
public class l implements View.OnClickListener, ACTD, com.qq.e.comm.plugin.a.d.a, b.a, b.a, f.a {
    private j B;
    private com.qq.e.comm.plugin.ad.g C;
    private String D;
    private File E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private r J;
    private f K;
    private final Activity c;
    private d d;
    private boolean e;
    private String f;
    private String g;
    private String h;
    private RelativeLayout i;
    private com.qq.e.comm.plugin.rewardvideo.b.c j;
    private com.qq.e.comm.plugin.n.g k;
    private com.qq.e.comm.plugin.n.h l;
    private com.qq.e.comm.plugin.ac.a m;
    private String q;
    private boolean t;
    private boolean u;
    private long w;
    private int x;
    private int y;
    private int z;

    /* renamed from: a  reason: collision with root package name */
    private final String f12425a = getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private SM f12426b = GDTADManager.getInstance().getSM();
    private com.qq.e.comm.plugin.rewardvideo.b.a n = null;
    private boolean o = true;
    private boolean p = false;
    private boolean r = true;
    private boolean s = false;
    private com.qq.e.comm.plugin.y.c v = new com.qq.e.comm.plugin.y.c();
    private int A = n.a();

    /* renamed from: com.qq.e.comm.plugin.rewardvideo.l$10  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass10 implements d.b {
        AnonymousClass10() {
        }

        @Override // com.qq.e.comm.plugin.w.d.b
        public void a() {
            h.a(e.VIDEO, true, l.this.v);
            String t = l.this.d.t();
            if (TextUtils.isEmpty(t)) {
                return;
            }
            af.a(t);
        }

        @Override // com.qq.e.comm.plugin.w.d.b
        public void a(int i, Exception exc) {
            h.a(e.VIDEO, false, l.this.v);
            GDTLogger.e("GDT RewardVideo AD exposure error");
        }
    }

    /* renamed from: com.qq.e.comm.plugin.rewardvideo.l$11  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass11 implements d.b {
        AnonymousClass11() {
        }

        @Override // com.qq.e.comm.plugin.w.d.b
        public void a() {
            String t = l.this.d.t();
            if (StringUtil.isEmpty(t)) {
                return;
            }
            af.a(t);
        }

        @Override // com.qq.e.comm.plugin.w.d.b
        public void a(int i, Exception exc) {
            GDTLogger.e("GDTRewardVideoAD report video info error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements f.a {
        private a() {
        }

        @Override // com.qq.e.comm.plugin.aa.b.f.a
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.aa.b.f.a
        public void a(int i, Exception exc) {
            l.this.a(l.this.s ? 2 : 1, 2);
            l.this.q();
            l.this.B.a(5003);
            l.this.r = true;
            h.a(i, l.this.v, l.this.d.G(), exc);
        }

        @Override // com.qq.e.comm.plugin.aa.b.f.a
        public void b() {
            l.this.r = false;
            int e = l.this.j.c().e() / 1000;
            if (e <= 0) {
                e = l.this.d.h();
            }
            if (e > 0) {
                l.this.j.e().a(l.this.j.c(), 500, l.this);
                l.this.j.a().setVisibility(0);
            }
            if (l.this.w != 0) {
                ba.b(System.currentTimeMillis() - l.this.w, l.this.x, l.this.d.k(), l.this.v);
            }
            if (l.this.j.h() != null && !l.this.F) {
                l.this.j.h().a(8, ak.b((Context) l.this.c, l.this.i.getHeight() - ak.a((Context) l.this.c, l.this.e ? 8 : q.a(l.this.d) ? 120 : 96)), l.this.e);
            }
            l.this.j.d().setVisibility(4);
            h.b(l.this.v);
        }

        @Override // com.qq.e.comm.plugin.aa.b.f.a
        public void c() {
            l.this.a(l.this.s ? 2 : 1, 0);
            l.this.q();
            l.this.B.i();
            l.this.v();
            l.this.r = true;
            h.a(f.d.END, l.this.v);
        }

        @Override // com.qq.e.comm.plugin.aa.b.f.a
        public void d() {
            l.this.r = true;
        }

        @Override // com.qq.e.comm.plugin.aa.b.f.a
        public void e() {
            l.this.a(l.this.s ? 2 : 1, 0);
            h.a(f.d.PAUSE, l.this.v);
        }

        @Override // com.qq.e.comm.plugin.aa.b.f.a
        public void f() {
            l.this.s = true;
            h.a(f.d.PLAY, l.this.v);
        }
    }

    public l(Activity activity) {
        this.c = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            String string = this.f12426b.getString("rewardVideoAdInfoFilter");
            if (TextUtils.isEmpty(string)) {
                string = "apurl,rl,customized_invoke_url,video,edid,video_tracking_url,click_mo_url,click_mo_url_sdk,report_url,report_url_sdk,endcard_info,negative_feedback_url,wechat_ad_trace_data,pkg_download_schema,requrl,corporate_logo,mqq_via,endcard";
            }
            HashSet hashSet = TextUtils.isEmpty(string) ? null : new HashSet(Arrays.asList(string.split(",")));
            if (keys == null || hashSet == null || hashSet.size() <= 0) {
                return jSONObject;
            }
            ArrayList arrayList = new ArrayList();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    if (!hashSet.contains(next)) {
                        arrayList.add(next);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return jSONObject;
                }
            }
            return new JSONObject(jSONObject, (String[]) arrayList.toArray(new String[0]));
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        gdtadv.getVresult(Constants.METHOD_IM_FRIEND_GROUP_DROP, 0, this, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void a(String str) {
        this.d = new d(str, this.g, this.h, this.f);
        this.d.a(e.VIDEO);
        if (!this.d.f()) {
            this.B.a(ARPMessageType.MSG_TYPE_RES_REQUEST);
            this.c.finish();
            return;
        }
        this.p = com.qq.e.comm.plugin.util.d.a(this.d);
        if (this.p) {
            com.qq.e.comm.plugin.ad.j d = com.qq.e.comm.plugin.util.d.d(this.d.l_());
            this.q = d.d();
            if (!TextUtils.isEmpty(this.q)) {
                com.qq.e.comm.plugin.a.l.a().a(d.d(), this);
            }
        }
        this.v.a(this.h);
        this.v.b(this.d.j());
        this.v.c(this.d.H());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        com.qq.e.comm.plugin.ab.d.a f;
        if (!this.F || (f = this.j.f()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("status", Integer.valueOf(i));
            jSONObject.putOpt("progress", Integer.valueOf(i2));
            f.c().a(new com.qq.e.comm.plugin.ab.b.b("onAPKStatusUpdate", jSONObject));
            ai.b("gdt_tag_reward_video", "jsbridge.dispatch updateAppDownloadStatus（%d,%d）", Integer.valueOf(i), Integer.valueOf(i2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void b(String str) {
        this.i.removeView(this.m);
        this.l.a();
        this.j.j();
        this.w = System.currentTimeMillis();
        this.j.c().a(str);
        if (this.H) {
            this.j.c().b();
        }
    }

    private void g() {
        final boolean a2 = n.a(this.d);
        this.i = new RelativeLayout(this.c) { // from class: com.qq.e.comm.plugin.rewardvideo.l.1
            @Override // android.view.View
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (a2) {
                    l.this.J.a(motionEvent);
                    l.this.C.a((View) l.this.i, motionEvent, false);
                }
                return super.onTouchEvent(motionEvent);
            }
        };
        if (a2) {
            this.i.setOnClickListener(this);
        }
        h();
        k();
        j();
        l();
        this.c.setContentView(this.i, new ViewGroup.LayoutParams(-1, -1));
    }

    private void h() {
        this.I = 1;
        if (this.j == null) {
            ai.a(this.f12425a, "initVideoLayout");
            this.j = new com.qq.e.comm.plugin.rewardvideo.b.c(this.c, this.e, this.F, this.d, this.C);
            this.j.c().a(new a());
            this.m = new com.qq.e.comm.plugin.ac.a(this.c);
            this.j.a().setOnClickListener(this);
            this.j.b().setOnClickListener(this);
            this.j.b().setVisibility(8);
            if (this.j.h() != null) {
                this.j.h().a(this);
            }
            TextView g = this.j.g();
            if (g != null) {
                g.setVisibility(4);
            }
            this.j.i();
            this.j.a(this.i);
            if (this.o) {
                this.j.c().i();
                this.j.a().setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAA51BMVEUAAAAAAAD///////9VVVUM\nDAzj4+MTExMeHh49PT339/f////////////////////////////+/v4SEhL5+fnt7e0aGhoEBAQs\nLCxQUFBkZGRycnJ4eHiLi4uioqKnp6e/v7/Z2dny8vL////////////////////////7+/vHx8dC\nQkIrKyv39/fw8PDa2tpiYmLe3t66urqzs7Ourq6MjIyHh4f////V1dWampqTk5NxcXFra2tPT09I\nSEg1NTXp6enl5eXOzs5bW1s/Pz/y8vLm5ubCwsK8vLyioqJ4eHgeHh7////ORlUAAAAATHRSTlOA\nAE1HmXrmdnJoTkA9KyceEQT9hPjthn5tY15cW1hVVFFQTkQyIxoKB/vRkov28N6e4cjEwbCtNtq3\ns6Ohl5SO6+fVm5Hy587JuqaHiSSVHgAAAuFJREFUWMOll2lX4jAUhu9QCxRZSssqm8paliICCiIu\no7Pf//97hiSUtHSLJ+8HOJwkD7lrEvgWotEg38t2lURC6WZ7+cEobF4wQM9dJs50mdNFAcU+X+1l\n9IsCgGJeSYRKyRfjAIXT8utmvZZSq1U1Vas3r0+IQiRgmGXTMm1NBY9UrZ1hY9lhOEBX2PKGCgFS\nGwyh6GGAQoKqlYIQpVpsRiEYkKODnTREKN2hk3JBgEc6dAUxuqLTHjnA8/+3GsRKu/XsAdz236RB\nQOkb6gcvQKfrVRCSSgm6GzBUyP7TIKg0sUIZugA0fzQQlkYzigMKPv8LxaLgAIoKiT98SR1iRPEI\nyBNcoAPukvZDiBvImjwFsA20IEBPBqJhBhNadAsU0Cf1E5T/94jLn3gRUheksvoUQPpPA3yaztFa\nQzIMAA3SowhAJxtQ/ebb+OMDIgBqhmYT0CJow0n/Pj8nB60MXEzBB1jfwUltWhJALeA5tDWQyVgB\n+AAVw+I/NWoDjEg8uAUzLFPNP4AD3H61pycbyMoRDEj/5DMQgcsPgAX+Bkek0w6AZFFTAGAC1cSw\nXp2xJskl6B0+6/GAqTUGqjEunbH6YWkPSCHW4gHmDP+y8OKbM1YjJQndw2dKwIQ12o6bHRtSh6Vd\nUEgQRJxYRpYDc3x2hUEBEouqCOA7Ph2d4BRolawVB9zjn+P31g0QN2GDa74DboKYE1kYXrgPuBNF\nwwhLXDBQCafuMAonkmGwDTzjuyeRRFPZnG+dYKw8qfzVYtqjNfUU03k5I1aYggHmOy695XzeUGw8\nKrkPAozxreJpKL6WtiuXqCy0HvwA0yhNvC0ttKmavxBX/h3sXnxNlbd1/6kyhri2Hnmw7Eq4MZPR\nB0v00XYxw0UZ91FHW8zhOrERZ1GHa+zx/jreXEQd77IXDNkrjvQlS/aaJ3vRlL3qSl+25a/78g8O\n+SeP/KNL/tkn//CUf/rKP76ln///AWO5YPW0P5qvAAAAAElFTkSuQmCC\n"));
            } else {
                this.j.c().h();
                this.j.a().setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAw1BMVEUAAAAAAAD///8nJyfp6en+\n/v7///9UVFTj4+MMDAz19fX///8eHh49PT11dXX///////////////////8FBQUTExP///8bGxsW\nFhYsLCxQUFBkZGSLi4uioqKnp6e/v7/Z2dn////////////////////////////////5+fns7OxB\nQUETExPe3t78/Pz29vbm5ubw8PDV1dWwsLCHh4dbW1va2trExMSTk5NxcXFjY2Py8vLt7e3IyMi6\nurqbm5v///8IvZbOAAAAQHRSTlOAAE2K6k1HmeZ6Tj9yaFsrJx4EAX93M4Z1bWNeWFVUUVBEPCMa\nEhAKB/nskoTh/Pbn8drCrpvez7Okn/Lt0ci3+fRniwAAArFJREFUWMOll+l2qkAMgHNrQdGibFq1\nLrWubXHvete8/1NdMmgjCMGeyQ8PByaf2WcGfuTIYuK0aiPTMMxRreVMFnnrsgGzRu0qJbXG7FKA\nN2btJGPsXQDwHPMqV0zHKwD47lHdGNa7nbYVBFa7060PjSPC9SXA/CFeVu3bFiTEsvvV+NvDPB8w\nNWP1OmufMuoxwpzmAVxD2d5rQo40e/EKNxPgNxR/cAOC3AzUooZ/DvBb6tMdFMidWtbyzwAN5b0N\nhWJXlQ1pgEtv79l8yY17WusmAVOD9JtwkTSJYExPAXOT7Of/L7KBvDDnDPBV/dhwsdiqovwvgCvE\nX8iFewR4JuUfviUDcsI7AByKSWYAfla2LzlhoKg7BDgY0IMM+VghrsJsQk+ZoABjykBGBoO/iPsN\nlnNySZkYKwDNnzqcSekNVy9QyQNAnWYUAWZkgHXu/hZ/vYIAsMiEWQSgJujz+9tnJXvEZQkkAPRV\nS4DygGvoHx5lH4AMsJUPsKAcsgdrfFLyFplfALAokwuYRL9DfovIzwzYRe5wdJc7UDKMVCfgUA6K\nAEu8/iKUrnHJeXCABlFXBpBSTEg+dmk0AcWwIwJYLakPHYoijKLftgxgxYQ+tCPVEVAjWDKACQl9\nsKgdgHIRyAAmJPQhoAq4BMAE1meA4IIAYBeEIEoucBCFNEpB5DQKhSSlkQtJKGWpkLiUhWaSSpmb\nKd3OiLexJACbZDNtTto5PVC2eJBKmQHhenPazpt1yAMlPdI+fz8qWUUTlS1IjfaQR1ruUA3fEfdQ\nPFSFsf6B+B4UjXVxY/l8xF1YkTcWeWt7XePyiQDC1iZvrs9bxHUgb67y9l76sytL27vuAUP7iKN7\nyNI95ukeNHWPutqHbf3jvv6FQ//Ko3/p0r/26V889a+++pdv7ev/f9d/WD42EM2oAAAAAElFTkSu\nQmCC\n"));
            }
            com.qq.e.comm.plugin.p.a.a().a(this.d.o(), this.j.d(), new com.qq.e.comm.plugin.p.b() { // from class: com.qq.e.comm.plugin.rewardvideo.l.5
                @Override // com.qq.e.comm.plugin.p.b
                public void a(String str, int i, Exception exc) {
                }

                @Override // com.qq.e.comm.plugin.p.b
                public void a(String str, ImageView imageView, com.qq.e.comm.plugin.p.e eVar) {
                    if (imageView != null) {
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                }
            });
        }
    }

    private void j() {
        final com.qq.e.comm.plugin.ab.d.a f;
        if (!this.F || (f = this.j.f()) == null) {
            return;
        }
        f.c().a("rewardVideo", new com.qq.e.comm.plugin.rewardvideo.a.b(this));
        long currentTimeMillis = System.currentTimeMillis();
        String c = ah.c(this.E);
        ai.b("gdt_tag_reward_video", "HtmlFile read cost : %d  ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (TextUtils.isEmpty(c)) {
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        f.a(new com.qq.e.comm.plugin.ab.d.f() { // from class: com.qq.e.comm.plugin.rewardvideo.l.6

            /* renamed from: a  reason: collision with root package name */
            long f12436a;

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(int i) {
                ai.b("gdt_tag_reward_video", "onProgressChanged(%d)", Integer.valueOf(i));
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(int i, String str, String str2) {
                ai.b("gdt_tag_reward_video", "onReceivedError(%d,%s,%s)", Integer.valueOf(i), str, str2);
                com.qq.e.comm.plugin.intersitial2.fullscreen.a.a("Reward", "BottomCard", l.this.m(), System.currentTimeMillis() - this.f12436a, str2, str, l.this.v);
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(ValueCallback<Uri> valueCallback, Intent intent) {
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(String str) {
                com.qq.e.comm.plugin.intersitial2.fullscreen.a.a("Reward", "BottomCard", l.this.m(), System.currentTimeMillis() - this.f12436a, str, (String) null, l.this.v);
                ai.b("gdt_tag_reward_video", "load webview layer cost %d ms", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                ai.b("gdt_tag_reward_video", "onPageFinished(%s)", str);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("adInfo", l.this.a(l.this.d.l_()));
                    jSONObject.putOpt("layout", l.this.o());
                    jSONObject.putOpt("logo", l.this.d != null ? com.qq.e.comm.plugin.util.g.a(l.this.d.C()) : null);
                    ai.b("gdt_tag_reward_video", "bridge.dispatch onRewardVideoShow(%s)", jSONObject);
                    f.c().a(new com.qq.e.comm.plugin.ab.b.b("onRewardVideoShow", jSONObject));
                    if (l.this.p) {
                        l.this.b(com.qq.e.comm.plugin.a.l.a().a(l.this.q), -1);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(String str, Bitmap bitmap) {
                ai.b("gdt_tag_reward_video", "onPageStarted(%s)", str);
                this.f12436a = System.currentTimeMillis();
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void b(String str) {
                ai.b("gdt_tag_reward_video", "onOverrideUrlLoading(%s)", str);
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
                return false;
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void c(String str) {
                ai.b("gdt_tag_reward_video", "onReceivedTitle(%s)", str);
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void d_() {
                ai.a("gdt_tag_reward_video", "onLeftApplication");
            }
        });
        f.a(this.D, c, az.a.HTML.a(), "UTF-8", null);
    }

    private void k() {
        this.k = com.qq.e.comm.plugin.n.a.a(this.c, this.d, this.v);
        if (this.k != null) {
            this.k.a(this);
            this.k.a(this.i, this.e);
            this.k.a(this.C);
        }
    }

    private void l() {
        ai.a(this.f12425a, "initEndCard");
        n.a(this.c, this.g, this.h, this.d);
        this.l = com.qq.e.comm.plugin.n.d.a(this.c, this.d, this.C, "Reward", m(), this.v);
        this.l.a(this);
        if (this.d.k_()) {
            this.u = true;
            this.l.a(this.d.ak());
        }
        this.l.a();
        this.l.a(this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m() {
        return n.a(this.d, this.d.k_());
    }

    private void n() {
        if (this.G) {
            return;
        }
        ai.a(this.f12425a, "onAdExposure");
        com.qq.e.comm.plugin.ad.a.a().a(this.i);
        this.i.post(new Runnable() { // from class: com.qq.e.comm.plugin.rewardvideo.l.7
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.d == null || l.this.B == null || l.this.C == null) {
                    return;
                }
                aa.a(l.this.d.am());
                l.this.u();
                l.this.B.h();
            }
        });
        this.G = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject o() {
        int i;
        int i2;
        Rect rect = new Rect();
        this.i.getGlobalVisibleRect(rect);
        int abs = Math.abs(rect.right - rect.left);
        int abs2 = Math.abs(rect.bottom - rect.top);
        int P = this.d.P();
        int Q = this.d.Q();
        int a2 = this.j.a(this.c);
        if (P > 0 && Q > 0 && abs > 0 && abs2 > 0 && a2 > 0) {
            Rect rect2 = new Rect();
            if (P * abs2 > abs * Q) {
                i2 = (Q * abs) / P;
                rect2.left = 0;
                rect2.top = (abs2 - i2) / 2;
                rect2.right = abs;
                rect2.bottom = (abs2 + i2) / 2;
                i = abs;
            } else if (P * abs2 == abs * Q) {
                rect2.left = 0;
                rect2.top = 0;
                rect2.right = abs;
                rect2.bottom = abs2;
                i2 = abs2;
                i = abs;
            } else {
                i = (P * abs2) / Q;
                rect2.left = (abs - i) / 2;
                rect2.top = 0;
                rect2.right = (abs + i) / 2;
                rect2.bottom = abs2;
                i2 = abs2;
            }
            ai.b("gdt_tag_reward_video", "layout detail : webview(%d,%d) , videoRect = %s , scaledVideoWidth = %d , scaledVideoHeight = %d , funcTopMargin = %d", Integer.valueOf(abs), Integer.valueOf(abs2), rect2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(a2));
            float f = this.c.getResources().getDisplayMetrics().density;
            int ceil = (int) Math.ceil(abs / f);
            int ceil2 = (int) Math.ceil(abs2 / f);
            rect2.left = (int) Math.ceil(rect2.left / f);
            rect2.top = (int) Math.ceil(rect2.top / f);
            rect2.right = (int) Math.ceil(rect2.right / f);
            rect2.bottom = (int) Math.ceil(rect2.bottom / f);
            ai.b("gdt_tag_reward_video", "layout detail transformed : webview(%d,%d) , videoRect = %s , scaledVideoWidth = %d , scaledVideoHeight = %d , funcTopMargin = %d", Integer.valueOf(ceil), Integer.valueOf(ceil2), rect2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(a2));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("s_width", Integer.valueOf(ceil));
                jSONObject.putOpt("s_height", Integer.valueOf(ceil2));
                jSONObject.putOpt("v_left", Integer.valueOf(rect2.left));
                jSONObject.putOpt("v_top", Integer.valueOf(rect2.top));
                jSONObject.putOpt("v_right", Integer.valueOf(rect2.right));
                jSONObject.putOpt("v_bottom", Integer.valueOf(rect2.bottom));
                jSONObject.putOpt("func_top", Integer.valueOf(a2));
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.c.getWindow().setBackgroundDrawable(new ColorDrawable(ViewCompat.MEASURED_STATE_MASK));
        String k = this.d.k();
        File d = ah.d(k);
        if (d == null || !d.exists()) {
            this.i.removeView(this.m);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a((Context) this.c, 46), ak.a((Context) this.c, 46));
            layoutParams.addRule(13, -1);
            this.i.addView(this.m, layoutParams);
            this.B.a(k, this.v);
            this.B.a(this);
        } else {
            b(d.getAbsolutePath());
            this.x = (int) (d.length() >> 10);
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.I = 2;
        if (this.j.h() != null) {
            this.j.h().a();
        }
        if (!this.u) {
            this.l.a(this.d.ak());
        }
        this.i.removeView(this.m);
        if (this.k != null) {
            this.k.a(this.i);
        }
        this.i.removeView(this.j);
        com.qq.e.comm.plugin.ab.d.a f = this.j.f();
        if (f != null) {
            f.a();
        }
        this.l.b();
    }

    private void r() {
        int f = this.j.c().f();
        this.j.c().a();
        if (f >= this.z * 1000) {
            if (this.n != null && this.n.isShowing()) {
                this.n.cancel();
            }
            q();
            return;
        }
        String str = this.z * 1000 > this.j.c().e() ? "观看完视频，可获得奖励\n确认要离开吗？" : "观看视频满%d秒即可获得激励\n确认要离开吗？";
        if (this.n == null) {
            this.n = new com.qq.e.comm.plugin.rewardvideo.b.a(this.c);
        }
        this.n.setCancelable(false);
        if (!this.n.isShowing()) {
            this.n.show();
        }
        LinearLayout a2 = this.n.a(this.c, String.format(Locale.getDefault(), str, Integer.valueOf(this.z)), "继续观看", "放弃奖励");
        this.n.setContentView(a2);
        if (this.n.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.n.getWindow().getAttributes();
            a2.measure(0, 0);
            attributes.width = a2.getMeasuredWidth();
            attributes.height = a2.getMeasuredHeight();
            attributes.gravity = 17;
            this.n.getWindow().setAttributes(attributes);
            this.n.getWindow().setBackgroundDrawable(ap.a(ak.a((Context) this.c, 10), -1, 255));
        }
        this.n.a().setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.rewardvideo.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.a(l.this.s ? 2 : 1, 0);
                l.this.s();
            }
        });
        this.n.b().setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.rewardvideo.l.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.n.cancel();
                l.this.j.c().b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.B.d();
        this.c.finish();
    }

    private void t() {
        if (this.o) {
            this.j.c().h();
            this.j.a().setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAw1BMVEUAAAAAAAD///8nJyfp6en+\n/v7///9UVFTj4+MMDAz19fX///8eHh49PT11dXX///////////////////8FBQUTExP///8bGxsW\nFhYsLCxQUFBkZGSLi4uioqKnp6e/v7/Z2dn////////////////////////////////5+fns7OxB\nQUETExPe3t78/Pz29vbm5ubw8PDV1dWwsLCHh4dbW1va2trExMSTk5NxcXFjY2Py8vLt7e3IyMi6\nurqbm5v///8IvZbOAAAAQHRSTlOAAE2K6k1HmeZ6Tj9yaFsrJx4EAX93M4Z1bWNeWFVUUVBEPCMa\nEhAKB/nskoTh/Pbn8drCrpvez7Okn/Lt0ci3+fRniwAAArFJREFUWMOll+l2qkAMgHNrQdGibFq1\nLrWubXHvete8/1NdMmgjCMGeyQ8PByaf2WcGfuTIYuK0aiPTMMxRreVMFnnrsgGzRu0qJbXG7FKA\nN2btJGPsXQDwHPMqV0zHKwD47lHdGNa7nbYVBFa7060PjSPC9SXA/CFeVu3bFiTEsvvV+NvDPB8w\nNWP1OmufMuoxwpzmAVxD2d5rQo40e/EKNxPgNxR/cAOC3AzUooZ/DvBb6tMdFMidWtbyzwAN5b0N\nhWJXlQ1pgEtv79l8yY17WusmAVOD9JtwkTSJYExPAXOT7Of/L7KBvDDnDPBV/dhwsdiqovwvgCvE\nX8iFewR4JuUfviUDcsI7AByKSWYAfla2LzlhoKg7BDgY0IMM+VghrsJsQk+ZoABjykBGBoO/iPsN\nlnNySZkYKwDNnzqcSekNVy9QyQNAnWYUAWZkgHXu/hZ/vYIAsMiEWQSgJujz+9tnJXvEZQkkAPRV\nS4DygGvoHx5lH4AMsJUPsKAcsgdrfFLyFplfALAokwuYRL9DfovIzwzYRe5wdJc7UDKMVCfgUA6K\nAEu8/iKUrnHJeXCABlFXBpBSTEg+dmk0AcWwIwJYLakPHYoijKLftgxgxYQ+tCPVEVAjWDKACQl9\nsKgdgHIRyAAmJPQhoAq4BMAE1meA4IIAYBeEIEoucBCFNEpB5DQKhSSlkQtJKGWpkLiUhWaSSpmb\nKd3OiLexJACbZDNtTto5PVC2eJBKmQHhenPazpt1yAMlPdI+fz8qWUUTlS1IjfaQR1ruUA3fEfdQ\nPFSFsf6B+B4UjXVxY/l8xF1YkTcWeWt7XePyiQDC1iZvrs9bxHUgb67y9l76sytL27vuAUP7iKN7\nyNI95ukeNHWPutqHbf3jvv6FQ//Ko3/p0r/26V889a+++pdv7ev/f9d/WD42EM2oAAAAAElFTkSu\nQmCC\n"));
            this.o = false;
            return;
        }
        this.j.c().i();
        this.j.a().setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAA51BMVEUAAAAAAAD///////9VVVUM\nDAzj4+MTExMeHh49PT339/f////////////////////////////+/v4SEhL5+fnt7e0aGhoEBAQs\nLCxQUFBkZGRycnJ4eHiLi4uioqKnp6e/v7/Z2dny8vL////////////////////////7+/vHx8dC\nQkIrKyv39/fw8PDa2tpiYmLe3t66urqzs7Ourq6MjIyHh4f////V1dWampqTk5NxcXFra2tPT09I\nSEg1NTXp6enl5eXOzs5bW1s/Pz/y8vLm5ubCwsK8vLyioqJ4eHgeHh7////ORlUAAAAATHRSTlOA\nAE1HmXrmdnJoTkA9KyceEQT9hPjthn5tY15cW1hVVFFQTkQyIxoKB/vRkov28N6e4cjEwbCtNtq3\ns6Ohl5SO6+fVm5Hy587JuqaHiSSVHgAAAuFJREFUWMOll2lX4jAUhu9QCxRZSssqm8paliICCiIu\no7Pf//97hiSUtHSLJ+8HOJwkD7lrEvgWotEg38t2lURC6WZ7+cEobF4wQM9dJs50mdNFAcU+X+1l\n9IsCgGJeSYRKyRfjAIXT8utmvZZSq1U1Vas3r0+IQiRgmGXTMm1NBY9UrZ1hY9lhOEBX2PKGCgFS\nGwyh6GGAQoKqlYIQpVpsRiEYkKODnTREKN2hk3JBgEc6dAUxuqLTHjnA8/+3GsRKu/XsAdz236RB\nQOkb6gcvQKfrVRCSSgm6GzBUyP7TIKg0sUIZugA0fzQQlkYzigMKPv8LxaLgAIoKiT98SR1iRPEI\nyBNcoAPukvZDiBvImjwFsA20IEBPBqJhBhNadAsU0Cf1E5T/94jLn3gRUheksvoUQPpPA3yaztFa\nQzIMAA3SowhAJxtQ/ebb+OMDIgBqhmYT0CJow0n/Pj8nB60MXEzBB1jfwUltWhJALeA5tDWQyVgB\n+AAVw+I/NWoDjEg8uAUzLFPNP4AD3H61pycbyMoRDEj/5DMQgcsPgAX+Bkek0w6AZFFTAGAC1cSw\nXp2xJskl6B0+6/GAqTUGqjEunbH6YWkPSCHW4gHmDP+y8OKbM1YjJQndw2dKwIQ12o6bHRtSh6Vd\nUEgQRJxYRpYDc3x2hUEBEouqCOA7Ph2d4BRolawVB9zjn+P31g0QN2GDa74DboKYE1kYXrgPuBNF\nwwhLXDBQCafuMAonkmGwDTzjuyeRRFPZnG+dYKw8qfzVYtqjNfUU03k5I1aYggHmOy695XzeUGw8\nKrkPAozxreJpKL6WtiuXqCy0HvwA0yhNvC0ttKmavxBX/h3sXnxNlbd1/6kyhri2Hnmw7Eq4MZPR\nB0v00XYxw0UZ91FHW8zhOrERZ1GHa+zx/jreXEQd77IXDNkrjvQlS/aaJ3vRlL3qSl+25a/78g8O\n+SeP/KNL/tkn//CUf/rKP76ln///AWO5YPW0P5qvAAAAAElFTkSuQmCC\n"));
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        gdtadv.getVresult(122, 0, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.t) {
            return;
        }
        this.B.f();
        this.t = true;
        h.a(e.VIDEO, this.v);
    }

    private String w() {
        this.C.a(1);
        this.C.a().a(this.j.getHeight());
        this.C.a().b(this.j.getWidth());
        this.C.a().b(this.j.b().getVisibility() == 0);
        try {
            return this.C.b();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.qq.e.comm.plugin.n.b.a
    public void a() {
        this.C.b(System.currentTimeMillis());
        a(q.a(this.d) ? 7 : 1, w());
        h.a(this.v);
    }

    public void a(int i, String str) {
        gdtadv.getVresult(Constants.METHOD_IM_FRIEND_GROUP_QUERY, 0, this, Integer.valueOf(i), str);
    }

    public void a(long j, long j2, int i, String str) {
        String k;
        ai.a(this.f12425a, "onDownloadProgress, finished : " + j + " ,total : " + j2 + " ,progress : " + i + " ,videoUrl : " + str);
        if (this.d == null || ((k = this.d.k()) != null && k.equals(str))) {
            this.m.a(i);
            if (i == 100) {
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.rewardvideo.l.12
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.i.removeView(l.this.m);
                    }
                });
            }
        }
    }

    @Override // com.qq.e.comm.plugin.a.d.a
    public void a(String str, int i, int i2, long j) {
        b(i, i2);
    }

    @Override // com.qq.e.comm.plugin.n.f.a
    public void a(String str, boolean z) {
        if (m() == 2) {
            u.a(1140003, 0, this.v);
        }
        int i = this.d.k_() ? 2 : 4;
        if (z) {
            i = 10;
        }
        a(i, str);
    }

    @Override // com.qq.e.comm.plugin.n.f.a
    public void b() {
        this.B.d();
        this.c.finish();
    }

    @Override // com.qq.e.comm.plugin.n.f.a
    public com.qq.e.comm.plugin.s.a c() {
        return this.d;
    }

    public void d() {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.rewardvideo.l.2
            @Override // java.lang.Runnable
            public void run() {
                l.this.p();
            }
        });
    }

    public void e() {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.rewardvideo.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.q();
            }
        });
    }

    public void f() {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.rewardvideo.l.4
            @Override // java.lang.Runnable
            public void run() {
                l.this.q();
            }
        });
    }

    @Override // com.qq.e.comm.plugin.ac.b.a
    public void i() {
        int f = this.j.c().f();
        if (f - (this.A * 1000) >= 0 && this.k != null && !this.k.b() && !this.F) {
            this.k.a();
        }
        int e = this.j.c().e();
        int min = Math.min(e, this.z * 1000);
        if (this.y >= 0 && f >= this.y * 1000 && this.j.b().getVisibility() != 0) {
            this.j.b().setVisibility(0);
        }
        TextView g = this.j.g();
        if (g != null) {
            g.setVisibility(0);
            int i = (min - f) / 1000;
            if (i > 0) {
                g.setText(String.format(Locale.getDefault(), "奖励将于%d秒后发放", Integer.valueOf(i)));
            }
        }
        if (f >= min) {
            v();
            if (g != null) {
                g.setVisibility(0);
                g.setText("恭喜获得奖励");
            }
        }
        if (m() != 1 || this.u || !n.a(f, this.y, e, n.a(this.f12426b)) || this.l == null || this.d == null) {
            return;
        }
        this.u = true;
        this.l.a(this.d.ak());
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        Intent intent = this.c.getIntent();
        String stringExtra = intent.getStringExtra(Constants.KEYS.AD_INFO);
        this.f = intent.getStringExtra("adThreadId");
        this.h = intent.getStringExtra("posId");
        this.D = intent.getStringExtra("styleUrl");
        this.E = ah.e(this.D);
        this.F = (TextUtils.isEmpty(this.D) || this.E == null || !this.E.exists()) ? false : true;
        this.B = j.b(this.c.getIntent().getIntExtra("objectId", 0));
        if (this.B == null) {
            GDTLogger.e("RewardVideo activity fail to create ! ad instance pass failed");
            this.c.finish();
            return;
        }
        this.y = n.a(this.h);
        this.z = n.b(this.h);
        this.B.g();
        this.C = new com.qq.e.comm.plugin.ad.g();
        this.J = new r(this.c);
        this.o = this.B.j();
        this.g = intent.getStringExtra("appid");
        a(stringExtra);
        g();
        p();
        this.K = new f(new com.qq.e.comm.plugin.c.a.c(this.c));
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        if (this.r) {
            s();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.e = "l".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation());
        this.c.requestWindowFeature(1);
        Window window = this.c.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E6000000")));
        window.setFlags(1024, 1024);
        window.setFlags(16777216, 16777216);
        window.setFlags(128, 128);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.i && this.I == 1 && this.J.a()) {
            this.C.b(System.currentTimeMillis());
            a(3, w());
        } else if (this.j != null && view == this.j.a()) {
            t();
        } else if (this.j != null && view == this.j.b()) {
            r();
        } else if (this.j == null || view != this.j.h()) {
        } else {
            this.C.b(System.currentTimeMillis());
            a(11, w());
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        if (this.k != null) {
            this.k.c();
        }
        if (this.l != null) {
            this.l.c();
        }
        if (this.j != null) {
            this.j.c().l();
            com.qq.e.comm.plugin.ab.d.a f = this.j.f();
            if (f != null) {
                f.a();
            }
        }
        w.a((Object) null);
        if (!TextUtils.isEmpty(this.q)) {
            com.qq.e.comm.plugin.a.l.a().b(this.q, this);
        }
        if (this.n == null || !this.n.isShowing()) {
            return;
        }
        this.n.cancel();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        this.H = false;
        if (this.j != null) {
            this.j.c().a();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        this.H = true;
        if (this.j != null) {
            if (this.n == null || !this.n.isShowing()) {
                this.j.c().b();
            }
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }
}
