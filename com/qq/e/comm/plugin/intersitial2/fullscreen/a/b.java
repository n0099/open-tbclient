package com.qq.e.comm.plugin.intersitial2.fullscreen.a;

import android.app.Activity;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ac.b;
import com.qq.e.comm.plugin.ac.k;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.intersitial2.fullscreen.InterstitialFSEventCenter;
import com.qq.e.comm.plugin.intersitial2.fullscreen.b;
import com.qq.e.comm.plugin.p.e;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ao;
import com.qq.e.comm.plugin.util.ba;
import com.qq.e.comm.plugin.util.q;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends RelativeLayout implements View.OnClickListener, b.a, com.qq.e.comm.plugin.intersitial2.fullscreen.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f12427a = GDTADManager.getInstance().getSM().getInteger("ifsvmlt", 10000);

    /* renamed from: b  reason: collision with root package name */
    private Activity f12428b;
    private com.qq.e.comm.plugin.s.a c;
    private f d;
    private com.qq.e.comm.plugin.ac.b e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private com.qq.e.comm.plugin.ac.a i;
    private k j;
    private String k;
    private a l;
    private String m;
    private String n;
    private boolean o;
    private g p;
    private long q;
    private boolean r;
    private long s;
    private int t;
    private boolean u;
    private boolean v;
    private CountDownTimer w;
    private boolean x;
    private c y;
    private r z;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, int i, Exception exc);

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();

        void j();

        boolean k();
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.qq.e.comm.plugin.intersitial2.fullscreen.a.b$1] */
    public b(Activity activity, com.qq.e.comm.plugin.s.a aVar, boolean z, g gVar, c cVar) {
        super(activity);
        this.q = GDTADManager.getInstance().getSM().getInteger("ifsvmpt", 5000);
        this.r = true;
        this.u = false;
        this.v = false;
        this.f12428b = activity;
        this.z = new r(this.f12428b);
        this.c = aVar;
        this.m = this.c.m();
        this.n = this.c.B();
        this.o = z;
        this.p = gVar;
        this.y = cVar;
        j();
        k();
        l();
        m();
        n();
        o();
        setOnClickListener(this);
        this.w = new CountDownTimer(f12427a, f12427a) { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                GDTLogger.d("InterstitialFSVideoADView load video timeout");
                b.this.x = true;
                if (b.this.l != null) {
                    b.this.l.a(false, 5046, null);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    private void a(boolean z) {
        if (z) {
            this.d.i();
            this.f.setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAA51BMVEUAAAAAAAD///////9VVVUM\nDAzj4+MTExMeHh49PT339/f////////////////////////////+/v4SEhL5+fnt7e0aGhoEBAQs\nLCxQUFBkZGRycnJ4eHiLi4uioqKnp6e/v7/Z2dny8vL////////////////////////7+/vHx8dC\nQkIrKyv39/fw8PDa2tpiYmLe3t66urqzs7Ourq6MjIyHh4f////V1dWampqTk5NxcXFra2tPT09I\nSEg1NTXp6enl5eXOzs5bW1s/Pz/y8vLm5ubCwsK8vLyioqJ4eHgeHh7////ORlUAAAAATHRSTlOA\nAE1HmXrmdnJoTkA9KyceEQT9hPjthn5tY15cW1hVVFFQTkQyIxoKB/vRkov28N6e4cjEwbCtNtq3\ns6Ohl5SO6+fVm5Hy587JuqaHiSSVHgAAAuFJREFUWMOll2lX4jAUhu9QCxRZSssqm8paliICCiIu\no7Pf//97hiSUtHSLJ+8HOJwkD7lrEvgWotEg38t2lURC6WZ7+cEobF4wQM9dJs50mdNFAcU+X+1l\n9IsCgGJeSYRKyRfjAIXT8utmvZZSq1U1Vas3r0+IQiRgmGXTMm1NBY9UrZ1hY9lhOEBX2PKGCgFS\nGwyh6GGAQoKqlYIQpVpsRiEYkKODnTREKN2hk3JBgEc6dAUxuqLTHjnA8/+3GsRKu/XsAdz236RB\nQOkb6gcvQKfrVRCSSgm6GzBUyP7TIKg0sUIZugA0fzQQlkYzigMKPv8LxaLgAIoKiT98SR1iRPEI\nyBNcoAPukvZDiBvImjwFsA20IEBPBqJhBhNadAsU0Cf1E5T/94jLn3gRUheksvoUQPpPA3yaztFa\nQzIMAA3SowhAJxtQ/ebb+OMDIgBqhmYT0CJow0n/Pj8nB60MXEzBB1jfwUltWhJALeA5tDWQyVgB\n+AAVw+I/NWoDjEg8uAUzLFPNP4AD3H61pycbyMoRDEj/5DMQgcsPgAX+Bkek0w6AZFFTAGAC1cSw\nXp2xJskl6B0+6/GAqTUGqjEunbH6YWkPSCHW4gHmDP+y8OKbM1YjJQndw2dKwIQ12o6bHRtSh6Vd\nUEgQRJxYRpYDc3x2hUEBEouqCOA7Ph2d4BRolawVB9zjn+P31g0QN2GDa74DboKYE1kYXrgPuBNF\nwwhLXDBQCafuMAonkmGwDTzjuyeRRFPZnG+dYKw8qfzVYtqjNfUU03k5I1aYggHmOy695XzeUGw8\nKrkPAozxreJpKL6WtiuXqCy0HvwA0yhNvC0ttKmavxBX/h3sXnxNlbd1/6kyhri2Hnmw7Eq4MZPR\nB0v00XYxw0UZ91FHW8zhOrERZ1GHa+zx/jreXEQd77IXDNkrjvQlS/aaJ3vRlL3qSl+25a/78g8O\n+SeP/KNL/tkn//CUf/rKP76ln///AWO5YPW0P5qvAAAAAElFTkSuQmCC\n"));
            this.r = true;
            return;
        }
        this.d.h();
        this.f.setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAw1BMVEUAAAAAAAD///8nJyfp6en+\n/v7///9UVFTj4+MMDAz19fX///8eHh49PT11dXX///////////////////8FBQUTExP///8bGxsW\nFhYsLCxQUFBkZGSLi4uioqKnp6e/v7/Z2dn////////////////////////////////5+fns7OxB\nQUETExPe3t78/Pz29vbm5ubw8PDV1dWwsLCHh4dbW1va2trExMSTk5NxcXFjY2Py8vLt7e3IyMi6\nurqbm5v///8IvZbOAAAAQHRSTlOAAE2K6k1HmeZ6Tj9yaFsrJx4EAX93M4Z1bWNeWFVUUVBEPCMa\nEhAKB/nskoTh/Pbn8drCrpvez7Okn/Lt0ci3+fRniwAAArFJREFUWMOll+l2qkAMgHNrQdGibFq1\nLrWubXHvete8/1NdMmgjCMGeyQ8PByaf2WcGfuTIYuK0aiPTMMxRreVMFnnrsgGzRu0qJbXG7FKA\nN2btJGPsXQDwHPMqV0zHKwD47lHdGNa7nbYVBFa7060PjSPC9SXA/CFeVu3bFiTEsvvV+NvDPB8w\nNWP1OmufMuoxwpzmAVxD2d5rQo40e/EKNxPgNxR/cAOC3AzUooZ/DvBb6tMdFMidWtbyzwAN5b0N\nhWJXlQ1pgEtv79l8yY17WusmAVOD9JtwkTSJYExPAXOT7Of/L7KBvDDnDPBV/dhwsdiqovwvgCvE\nX8iFewR4JuUfviUDcsI7AByKSWYAfla2LzlhoKg7BDgY0IMM+VghrsJsQk+ZoABjykBGBoO/iPsN\nlnNySZkYKwDNnzqcSekNVy9QyQNAnWYUAWZkgHXu/hZ/vYIAsMiEWQSgJujz+9tnJXvEZQkkAPRV\nS4DygGvoHx5lH4AMsJUPsKAcsgdrfFLyFplfALAokwuYRL9DfovIzwzYRe5wdJc7UDKMVCfgUA6K\nAEu8/iKUrnHJeXCABlFXBpBSTEg+dmk0AcWwIwJYLakPHYoijKLftgxgxYQ+tCPVEVAjWDKACQl9\nsKgdgHIRyAAmJPQhoAq4BMAE1meA4IIAYBeEIEoucBCFNEpB5DQKhSSlkQtJKGWpkLiUhWaSSpmb\nKd3OiLexJACbZDNtTto5PVC2eJBKmQHhenPazpt1yAMlPdI+fz8qWUUTlS1IjfaQR1ruUA3fEfdQ\nPFSFsf6B+B4UjXVxY/l8xF1YkTcWeWt7XePyiQDC1iZvrs9bxHUgb67y9l76sytL27vuAUP7iKN7\nyNI95ukeNHWPutqHbf3jvv6FQ//Ko3/p0r/26V889a+++pdv7ev/f9d/WD42EM2oAAAAAElFTkSu\nQmCC\n"));
        this.r = false;
    }

    private void j() {
        this.d = new f(getContext());
        this.d.setId(2131755010);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        this.d.a(new f.a() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.2
            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void a() {
                if (b.this.i != null) {
                    b.this.i.setVisibility(4);
                }
                if (b.this.f != null) {
                    b.this.f.setVisibility(0);
                }
                if (b.this.l != null && b.this.l.k()) {
                    b.this.d.b();
                }
                InterstitialFSEventCenter.a().a(b.this.m, 10008, Long.valueOf(b.this.d.e()));
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void a(int i, Exception exc) {
                InterstitialFSEventCenter.a().a(b.this.m, 10012, new AdError(701, "video error while playing!"));
                if (b.this.l != null) {
                    b.this.l.a(true, i, exc);
                }
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void b() {
                if (b.this.h != null) {
                    b.this.h.setVisibility(4);
                }
                if (b.this.e != null && b.this.d != null) {
                    b.this.e.a(b.this.d, 500, b.this);
                }
                b.this.p.a(System.currentTimeMillis());
                InterstitialFSEventCenter.a().a(b.this.m, 10009, null);
                if (b.this.l != null) {
                    b.this.l.e();
                }
                if (b.this.s != 0) {
                    ba.b(System.currentTimeMillis() - b.this.s, b.this.t, b.this.k, b.this.y);
                }
                if (b.this.j != null) {
                    b.this.j.a(8, ak.b(b.this.getContext(), b.this.getHeight() - ak.a(b.this.getContext(), b.this.o ? 8 : q.a(b.this.c) ? 120 : 96)), b.this.o);
                }
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void c() {
                if (b.this.l != null) {
                    b.this.l.f();
                }
                InterstitialFSEventCenter.a().a(b.this.m, 10011, null);
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void d() {
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void e() {
                InterstitialFSEventCenter.a().a(b.this.m, 10010, null);
            }

            @Override // com.qq.e.comm.plugin.aa.b.f.a
            public void f() {
                b.this.v = true;
                InterstitialFSEventCenter.a().a(b.this.m, 10009, null);
            }
        });
        addView(this.d, layoutParams);
        this.h = new ImageView(getContext());
        addView(this.h, layoutParams);
        com.qq.e.comm.plugin.p.a.a().a(this.c.o(), this.h, new com.qq.e.comm.plugin.p.b() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.3
            @Override // com.qq.e.comm.plugin.p.b
            public void a(String str, int i, Exception exc) {
            }

            @Override // com.qq.e.comm.plugin.p.b
            public void a(String str, ImageView imageView, e eVar) {
                if (imageView != null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
            }
        });
    }

    private void k() {
        this.e = new com.qq.e.comm.plugin.ac.b(getContext());
        this.e.setId(2131755009);
        this.e.a(ak.a(getContext(), 2));
        this.e.a(Color.argb(77, 255, 255, 255));
        this.e.b(-1);
        this.e.c(Color.argb(128, 0, 0, 0));
        this.e.b(ak.a(getContext(), 14));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(getContext(), 30), ak.a(getContext(), 30));
        layoutParams.addRule(11, -1);
        layoutParams.topMargin = ak.a(getContext(), 20);
        layoutParams.rightMargin = ak.a(getContext(), 20);
        addView(this.e, layoutParams);
    }

    private void l() {
        boolean z;
        this.f = new ImageView(getContext());
        this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(getContext(), 30), ak.a(getContext(), 30));
        layoutParams.addRule(0, 2131755009);
        layoutParams.rightMargin = ak.a(getContext(), 20);
        layoutParams.topMargin = ak.a(getContext(), 20);
        try {
            String stringForPlacement = GDTADManager.getInstance().getSM().getStringForPlacement("videoOptions", this.n);
            if (stringForPlacement == null) {
                stringForPlacement = "{}";
            }
            z = new JSONObject(stringForPlacement).optBoolean("autoPlayMuted", true);
        } catch (Exception e) {
            GDTLogger.d("Get video options error: " + e.getMessage());
            z = true;
        }
        a(z ? false : true);
        this.f.setVisibility(4);
        addView(this.f, layoutParams);
    }

    private void m() {
        this.g = new ImageView(getContext());
        this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.g.setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(getContext(), 30), ak.a(getContext(), 30));
        layoutParams.addRule(9, -1);
        layoutParams.leftMargin = ak.a(getContext(), 20);
        layoutParams.topMargin = ak.a(getContext(), 20);
        this.g.setOnClickListener(this);
        this.g.setVisibility(8);
        addView(this.g, layoutParams);
    }

    private void n() {
        this.i = new com.qq.e.comm.plugin.ac.a(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(getContext(), 46), ak.a(getContext(), 46));
        layoutParams.addRule(13);
        this.i.setLayoutParams(layoutParams);
        addView(this.i);
    }

    private void o() {
        String ac = this.c.ac();
        if (this.c == null || TextUtils.isEmpty(ac)) {
            return;
        }
        this.j = new k(getContext(), ac, this.p);
        this.j.a(this);
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public void a(ViewGroup viewGroup) {
        if (viewGroup.getParent() == null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public void a(a aVar) {
        this.l = aVar;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("video url null");
            return;
        }
        this.k = str;
        File d = ah.d(str);
        if (d == null || !d.exists()) {
            com.qq.e.comm.plugin.intersitial2.fullscreen.b.a().a(str, this.m, new b.a() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.a.b.4
                @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.b.a
                public void a() {
                    if (b.this.i != null) {
                        b.this.i.setVisibility(0);
                    }
                    InterstitialFSEventCenter.a().a(b.this.m, 10007, null);
                }

                @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.b.a
                public void a(int i) {
                    if (b.this.i != null) {
                        b.this.i.setVisibility(0);
                        b.this.i.a(i);
                    }
                }

                @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.b.a
                public void a(com.qq.e.comm.plugin.j.c cVar) {
                    if (b.this.x) {
                        return;
                    }
                    GDTLogger.e("download video fail");
                    cVar.printStackTrace();
                    InterstitialFSEventCenter.a().a(b.this.m, 10012, new AdError(700, "download video error!"));
                    if (b.this.l != null) {
                        b.this.l.a(false, cVar.a(), cVar);
                    }
                    b.this.x = false;
                    b.this.w.cancel();
                }

                @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.b.a
                public void a(String str2) {
                    if (b.this.x) {
                        return;
                    }
                    if (b.this.i != null) {
                        b.this.i.setVisibility(8);
                    }
                    if (b.this.d != null && str2 != null) {
                        InterstitialFSEventCenter.a().a(b.this.m, 10006, null);
                        b.this.s = System.currentTimeMillis();
                        b.this.t = (int) (new File(str2).length() >> 10);
                        b.this.d.a(str2);
                    }
                    if (b.this.l != null) {
                        b.this.l.d();
                    }
                    b.this.x = false;
                    b.this.w.cancel();
                }
            }, this.y);
            return;
        }
        this.t = (int) (d.length() >> 10);
        InterstitialFSEventCenter.a().a(this.m, 10006, null);
        this.s = System.currentTimeMillis();
        this.d.a(d.getAbsolutePath());
        if (this.i != null) {
            this.i.setVisibility(8);
        }
        if (this.l != null) {
            this.l.d();
        }
        this.x = false;
        this.w.cancel();
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public boolean a() {
        return this.v;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public f b() {
        return this.d;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public void b(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public void c() {
        if (this.d == null || !this.d.c()) {
            return;
        }
        this.d.a();
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public void d() {
        if (this.d == null || this.d.c()) {
            return;
        }
        this.d.b();
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public void e() {
        if (this.j != null) {
            this.j.a();
        }
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public boolean f() {
        return this.d == null || ((long) this.d.f()) >= this.q;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public void g() {
        if (!f()) {
            GDTLogger.i("InterstitialFS ad back button click, no op");
            return;
        }
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        if (this.d != null) {
            this.d.a();
        }
        if (this.l != null) {
            this.l.h();
        }
    }

    @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.a.a
    public void h() {
        if (this.w != null) {
            this.w.cancel();
            this.w = null;
        }
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        if (this.d != null) {
            this.d.a((f.a) null);
            this.d.l();
            this.d = null;
        }
        com.qq.e.comm.plugin.intersitial2.fullscreen.b.a().a(this.k);
    }

    @Override // com.qq.e.comm.plugin.ac.b.a
    public void i() {
        if (this.d != null) {
            if (this.d.f() < this.q) {
                this.g.setVisibility(8);
            } else if (this.u) {
            } else {
                this.g.setVisibility(0);
                if (this.l != null) {
                    this.l.g();
                }
                this.u = true;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this) {
            if (this.l == null || !this.z.a()) {
                return;
            }
            this.l.i();
        } else if (view == this.f) {
            a(!this.r);
        } else if (view == this.g) {
            g();
        } else if (view != this.j || this.l == null) {
        } else {
            this.l.j();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.p.a(this.f12428b.getWindow().getDecorView(), motionEvent, false);
        this.z.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
