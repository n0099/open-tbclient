package com.qq.e.comm.plugin.splash;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Movie;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.ad.q;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.splash.h;
import com.qq.e.comm.plugin.util.aa;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ao;
import com.qq.e.comm.plugin.util.ap;
import com.qq.e.comm.plugin.util.ax;
import com.qq.e.comm.plugin.util.ba;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.plugin.util.bd;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.util.Locale;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class b extends FrameLayout implements NSPVI, f.a, com.qq.e.comm.plugin.ab.a.b, h.a {
    private String A;
    private com.qq.e.comm.plugin.s.f B;
    private boolean C;
    private boolean D;
    private long E;
    private volatile boolean F;
    private boolean G;
    private Runnable H;
    private File I;
    private volatile EnumC1180b J;
    private volatile EnumC1180b K;
    private File L;
    private boolean M;
    private int N;
    private a O;
    private j P;
    private long Q;
    private long R;
    private long S;
    private ax T;
    private d U;
    private r V;
    private e W;

    /* renamed from: a  reason: collision with root package name */
    private final String f12761a;
    private com.qq.e.comm.plugin.ac.c aa;

    /* renamed from: b  reason: collision with root package name */
    private final String f12762b;
    private final m c;
    private final h d;
    private final com.qq.e.comm.plugin.y.c e;
    private String f;
    private com.qq.e.comm.plugin.s.f g;
    private int h;
    private int i;
    private int j;
    private int k;
    private ViewGroup l;
    private View m;
    private TextView n;
    private ADListener o;
    private g p;
    private com.qq.e.comm.plugin.aa.b.f q;
    private com.qq.e.comm.plugin.ac.k r;
    private Bitmap s;
    private com.qq.e.comm.plugin.ad.g t;
    private int u;
    private int v;
    private q w;
    private LoadAdParams x;
    private View y;
    private View z;

    /* renamed from: com.qq.e.comm.plugin.splash.b$13  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass13 implements d.b {
        AnonymousClass13() {
        }

        @Override // com.qq.e.comm.plugin.w.d.b
        public void a() {
            String t = b.this.g.t();
            if (StringUtil.isEmpty(t)) {
                return;
            }
            af.a(t);
        }

        @Override // com.qq.e.comm.plugin.w.d.b
        public void a(int i, Exception exc) {
            GDTLogger.e("GDTSplashAD report video info error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum a {
        Unknown,
        PreLoadVideo,
        InstantVideo
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qq.e.comm.plugin.splash.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public enum EnumC1180b {
        Unknown,
        Downloading,
        Downloaded,
        Failed
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private TextView f12800a;

        public c(Context context) {
            super(context);
            a(context);
        }

        private void a(Context context) {
            int a2 = ak.a(context, 20);
            int a3 = ak.a(context, 17);
            setBackgroundColor(1711276032);
            setPadding(a2, 0, a2, 0);
            this.f12800a = new TextView(context);
            this.f12800a.setEllipsize(TextUtils.TruncateAt.END);
            this.f12800a.setMaxLines(1);
            this.f12800a.setTextColor(-1);
            this.f12800a.setTextSize(2, 15.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.weight = Float.MIN_NORMAL;
            addView(this.f12800a, layoutParams);
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a3, a3);
            imageView.setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAACIAAAAiCAYAAAA6RwvCAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAIqADAAQAAAABAAAAIgAAAAACeqFUAAAArklEQVRYCe2YzQmAMAyFiwfBQVzCs0M4ipM4jTia9RUa6CE9xdYILxAigcbXr4H+hGC0GOOc3FjGNhwCFvidfbdVM4yGgA1e2jdioGCEn6USfH8mZqIYra1AhWQ0MIFkVCxIkgzJ1AjU8n/omaMmvmk+k7kQxdIxYh2a/tVrccxc24/6Lk1FRN+zC0VIj5IESQgBiewJkhACEtETPq6cEOLmEu7jWSItEai88lDzALbxpaSUq9D9AAAAAElFTkSuQmCC"));
            layoutParams2.gravity = 21;
            addView(imageView, layoutParams2);
        }

        public void a(String str) {
            if (str != null) {
                this.f12800a.setText(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.V.a()) {
                GDTLogger.d("开屏onClick");
                int id = view.getId();
                switch (id) {
                    case 1:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        b.this.d(id);
                        k.a((Boolean) true, false, b.this.e);
                        return;
                    case 2:
                        k.b(b.this.R, b.this.e);
                        b.this.A();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public b(Context context, String str, String str2) {
        this(context, str, str2, com.qq.e.comm.plugin.ad.l.DEFAULT);
    }

    public b(Context context, String str, String str2, com.qq.e.comm.plugin.ad.l lVar) {
        super(context);
        this.e = new com.qq.e.comm.plugin.y.c();
        this.s = null;
        this.w = q.IMG;
        this.C = false;
        this.D = true;
        this.E = 1800000L;
        this.F = false;
        this.G = false;
        this.J = EnumC1180b.Unknown;
        this.K = EnumC1180b.Unknown;
        this.N = 1;
        this.O = a.Unknown;
        this.P = new j();
        this.f12761a = str;
        this.f12762b = str2;
        this.c = new m(str2, com.qq.e.comm.plugin.ad.e.SPLASH, (com.qq.e.comm.plugin.ad.d) null);
        this.f = com.qq.e.comm.plugin.util.a.a(str, str2, o.b());
        n();
        this.e.a(str2);
        this.d = new h(this.f12761a, this.f12762b, this.c, this.f, lVar, this, this.e);
        this.V = new r(context, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.w == q.VIDEO && this.q.c()) {
            this.q.a();
        }
        com.qq.e.comm.plugin.w.a.c.a();
        if (this.aa != null) {
            this.aa.b();
        }
        if (this.P.d()) {
            if (this.o != null) {
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.9
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.o.onADEvent(new ADEvent(1));
                    }
                });
            }
            k.c(this.Q, this.e);
        }
    }

    private void B() {
        if (this.T != null) {
            this.T.c();
        }
        this.T = new ax(this.i, 500L) { // from class: com.qq.e.comm.plugin.splash.b.10
            @Override // com.qq.e.comm.plugin.util.ax
            public void a() {
                GDTLogger.d("开屏计时结束");
                b.this.A();
            }

            @Override // com.qq.e.comm.plugin.util.ax
            public void a(long j) {
                if (b.this.m == null && b.this.n != null) {
                    b.this.n.setText(String.format("%d", Integer.valueOf(Math.round(((float) j) / 1000.0f))));
                }
                if (b.this.o != null) {
                    b.this.o.onADEvent(new ADEvent(5, new Object[]{Long.valueOf(j)}));
                }
            }
        };
        this.T.b();
    }

    private View C() {
        ImageView imageView = new ImageView(getContext());
        imageView.setId(4);
        imageView.setImageBitmap(ao.a("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"));
        imageView.setOnClickListener(this.U);
        return imageView;
    }

    private void D() {
        if (SDKStatus.getSDKVersionCode() < 20 || !i.h()) {
            return;
        }
        if (this.z != null) {
            this.z.setVisibility(0);
            if (this.z.getParent() == null) {
                addView(this.z);
                return;
            }
            return;
        }
        SM sm = GDTADManager.getInstance().getSM();
        int integer = sm.getInteger("preloadMarkBackgroundRadius", 45);
        int integer2 = sm.getInteger("preloadMarkBackgroundColor", Integer.MIN_VALUE);
        int integer3 = sm.getInteger("preloadMarkBackgroundAlpha", 100);
        int integer4 = sm.getInteger("preloadMarkTextSize", 14);
        int integer5 = sm.getInteger("preloadMarkTextColor", -1);
        String string = sm.getString("preloadMarkTextContent");
        int integer6 = sm.getInteger("preloadMarkMargin", 16);
        TextView textView = new TextView(getContext());
        textView.setBackgroundDrawable(ap.a(integer, integer2, integer3));
        textView.setTextSize(2, integer4);
        textView.setTextColor(integer5);
        textView.setPadding(ak.a(getContext(), 8), ak.a(getContext(), 3), ak.a(getContext(), 8), ak.a(getContext(), 3));
        if (TextUtils.isEmpty(string)) {
            string = "已 Wi-Fi 预加载";
        }
        textView.setText(string);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 51;
        int a2 = ak.a(getContext(), integer6);
        layoutParams.setMargins(a2, a2, a2, a2);
        addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        int e;
        int f;
        if (this.q == null || (f = this.q.f()) >= (e = this.q.e())) {
            return;
        }
        long j = e - f;
        if (this.m == null && this.n != null) {
            this.n.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(Math.round(((float) j) / 1000.0f))));
        }
        if (this.o != null) {
            this.o.onADEvent(new ADEvent(5, new Object[]{Long.valueOf(j)}));
        }
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.E();
            }
        }, 500L);
    }

    private View a(String str, int i) {
        c cVar = new c(getContext());
        cVar.setId(7);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i);
        layoutParams.gravity = 80;
        cVar.setVisibility(4);
        addView(cVar, layoutParams);
        cVar.setOnClickListener(this.U);
        if (TextUtils.isEmpty(str)) {
            str = "点击此处查看详情";
        }
        cVar.a(str);
        return cVar;
    }

    private View a(boolean z) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setId(2);
        int a2 = ak.a(getContext(), 6);
        int a3 = ak.a(getContext(), 10);
        linearLayout.setPadding(a3, a2, a3, a2);
        linearLayout.setOnClickListener(this.U);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setCornerRadius(50.0f);
        gradientDrawable.setStroke(ak.a(getContext(), 1), -1);
        gradientDrawable.setAlpha(77);
        linearLayout.setBackgroundDrawable(gradientDrawable);
        TextView textView = new TextView(getContext());
        textView.setText("跳过");
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(-1);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        if (z) {
            this.n = new TextView(getContext());
            this.n.setText(String.format("%d", Integer.valueOf(Math.round(this.i / 1000.0f))));
            this.n.setTextSize(2, 14.0f);
            this.n.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = a2;
            linearLayout.addView(this.n, layoutParams);
        }
        return linearLayout;
    }

    private void a(int i, int i2) {
        gdtadv.getVresult(263, 0, this, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private static void a(int i, View view, int i2, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        GDTLogger.d("开屏banner高度:" + i2);
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        view.setTranslationY(i2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", i2, 0.0f);
        ofFloat.setDuration(500);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        view.setVisibility(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationY", 0.0f, -i2);
        ofFloat2.setDuration(500);
        ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(i);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }

    private void a(View view) {
        if (view != null) {
            AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
            view.setAlpha(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f);
            ofFloat.setDuration(500);
            ofFloat.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat.setStartDelay(1000);
            ofFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        if (this.P.c()) {
            l.c();
            if (!b(this.l)) {
                GDTLogger.e("广告容器处于不可见状态，无法进行曝光上报和计费，请检查您的代码逻辑，保证广告容器可见。");
                b(600);
                k.a(4004, this.e, c(this.l));
                return;
            }
            w();
            x();
            k.a((Boolean) true, 0, this.e);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.l.removeAllViews();
            bc.a(this);
            this.l.addView(this, layoutParams);
            if (this.w == q.VIDEO) {
                bc.a(this.q);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                layoutParams2.gravity = 17;
                addView(this.q, layoutParams2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(i.f());
                alphaAnimation.setFillAfter(true);
                this.q.startAnimation(alphaAnimation);
            }
            this.F = false;
            this.U = new d();
            setVisibility(0);
            if (this.w == q.IMG) {
                v();
                B();
            }
            if (this.y != null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                frameLayout.addView(this.y);
                addView(frameLayout, layoutParams3);
                this.y.setOnClickListener(this.U);
            }
            k.a(this.y != null, this.e);
            this.R = System.currentTimeMillis();
            if (this.o != null) {
                this.o.onADEvent(new ADEvent(3));
            }
            if (this.w == q.VIDEO && file != null && file.exists()) {
                this.q.a(this);
                this.q.a(file.getAbsolutePath());
                this.q.b();
                if (this.O == a.InstantVideo) {
                    this.q.a(f.c.CENTER_CROP);
                    k.b(this.w, this.e);
                }
            } else if (this.w == q.IMG && file != null && file.exists()) {
                Movie b2 = com.qq.e.comm.plugin.util.k.b(file);
                if (b2 != null) {
                    this.p.a(b2);
                } else {
                    if (this.s != null) {
                        this.s.recycle();
                    }
                    this.s = com.qq.e.comm.plugin.util.k.a(file, this.p);
                    this.p.setImageBitmap(this.s);
                    k.b(this.w, this.e);
                }
                this.p.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            l.a(this.f12762b);
            com.qq.e.comm.plugin.splash.a.b.d();
            GDTLogger.d("开屏广告展示完成");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, String str, long j) {
        int length = (int) (file.length() >> 10);
        k.a(j, length, str, this.e);
        if (j > 0) {
            GDTLogger.d("开屏图片下载成功耗时ms:" + (System.currentTimeMillis() - j) + " 大小:" + length + " url:" + str);
        }
        if (!this.P.i() || this.g == null) {
            GDTLogger.d("广告图片下载成功时开屏广告已超时或者在展示：" + this.P);
            return;
        }
        this.J = EnumC1180b.Downloaded;
        k.a(this.K, this.J, this.e, 0, null, str, this.g.G());
        this.I = file;
        if (this.w == q.IMG) {
            m();
        }
    }

    private void a(final String str) {
        final long currentTimeMillis = System.currentTimeMillis();
        com.qq.e.comm.plugin.p.a.a().a(str, this.p, new com.qq.e.comm.plugin.p.b() { // from class: com.qq.e.comm.plugin.splash.b.4
            @Override // com.qq.e.comm.plugin.p.b
            public void a(String str2, int i, Exception exc) {
                GDTLogger.d("Splash Load Image Failed");
                b.this.b(406);
                k.a(b.this.K, b.this.J, b.this.e, i, exc, str2, b.this.g.G());
            }

            @Override // com.qq.e.comm.plugin.p.b
            public void a(String str2, ImageView imageView, com.qq.e.comm.plugin.p.e eVar) {
                GDTLogger.d("Splash Load Image Complete");
                k.a(b.this.K, b.this.J, b.this.e, 0, null, str, b.this.g.G());
                if (!eVar.c()) {
                    k.a(currentTimeMillis, (int) (eVar.b().length() >> 10), str2, b.this.e);
                }
                b.this.s = eVar.a();
                b.this.a((File) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, int i, Exception exc) {
        this.J = EnumC1180b.Failed;
        if (!this.P.i() || this.g == null) {
            GDTLogger.d("广告图片下载失败时开屏广告已超时或者在展示：" + this.P);
            return;
        }
        GDTLogger.d("开屏图片下载失败耗时ms:" + (System.currentTimeMillis() - j) + " url:" + str);
        k.a(this.K, this.J, this.e, i, exc, str, this.g.G());
        if (this.w == q.IMG) {
            b(406);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i) {
        if (this.P.e()) {
            k.c(this.Q, this.e);
            if (this.o != null) {
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.o.onADEvent(new ADEvent(2, new Object[]{Integer.valueOf(i)}));
                    }
                });
            }
        }
        this.F = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file, String str, long j) {
        if (!this.P.i() || this.g == null) {
            GDTLogger.d("广告视频下载成功时开屏广告已超时或者在展示：" + this.P);
            return;
        }
        this.K = EnumC1180b.Downloaded;
        GDTLogger.d("开屏视频下载成功耗时ms:" + j + " 大小:" + file.length() + " url:" + str);
        k.b(this.K, this.J, this.e, 0, null, this.g.o(), str);
        if (j > 0) {
            ba.a(j, (int) (file.length() >> 10), str, this.e);
        }
        this.L = file;
        this.O = a.InstantVideo;
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i, Exception exc) {
        this.K = EnumC1180b.Failed;
        if (!this.P.i() || this.g == null) {
            GDTLogger.d("广告视频下载完成时开屏广告已超时或者在展示：" + this.P);
            return;
        }
        GDTLogger.d("开屏视频下载失败耗时:" + j + " url:" + str);
        if (this.J == EnumC1180b.Downloaded) {
            GDTLogger.d("开屏视频转图文成功");
            k.b(this.K, this.J, this.e, i, exc, null, str);
            this.w = q.IMG;
            m();
        } else if (this.J == EnumC1180b.Downloading) {
            GDTLogger.d("开屏视频转图文，图文尚在下载中");
            this.w = q.IMG;
        } else {
            GDTLogger.d("开屏视频转图文失败");
            k.b(this.K, this.J, this.e, i, exc, this.g.o(), str);
            b(700);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(View view) {
        bd.a(getContext(), view, 50);
        return view != null && view.getVisibility() == 0 && view.isShown() && view.getWindowVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qq.e.comm.plugin.y.d c(View view) {
        boolean z = view == null;
        com.qq.e.comm.plugin.y.d a2 = new com.qq.e.comm.plugin.y.d().a("vn", Boolean.valueOf(z));
        if (!z) {
            a2.a("v", Boolean.valueOf(bd.a(getContext(), view, 50))).a("vv", Integer.valueOf(view.getVisibility())).a("vs", Boolean.valueOf(view.isShown())).a("wv", Integer.valueOf(view.getWindowVisibility()));
        }
        return a2;
    }

    private void c(int i) {
        if (this.w == q.VIDEO) {
            this.r = new com.qq.e.comm.plugin.ac.k(getContext(), this.g.ac(), this.t);
            this.r.a(12, ak.b(getContext(), getHeight() - i) - 12);
            this.r.a(this.U, this.V);
            this.r.setId(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (l.b()) {
            return;
        }
        if (this.q.c()) {
            this.q.a();
        }
        if (this.g != null) {
            this.W.a(this.g, i, this.w, this.l, this.t);
            if (this.o != null) {
                this.o.onADEvent(new ADEvent(4));
            }
        }
    }

    private void l() {
        if (this.W != null) {
            return;
        }
        this.W = new e(this, new com.qq.e.comm.plugin.c.a.c(this.l.getContext()) { // from class: com.qq.e.comm.plugin.splash.b.1
            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void a(int i, final com.qq.e.comm.plugin.c.a.b bVar) {
                if (b.this.T != null) {
                    b.this.T.d();
                }
                super.a(i, new com.qq.e.comm.plugin.c.a.b() { // from class: com.qq.e.comm.plugin.splash.b.1.2
                    private void d() {
                        if (b.this.T != null) {
                            b.this.T.e();
                        }
                    }

                    @Override // com.qq.e.comm.plugin.c.a.b
                    public void a() {
                        bVar.a();
                        d();
                    }

                    @Override // com.qq.e.comm.plugin.c.a.b
                    public void b() {
                        bVar.b();
                        b.this.A();
                    }

                    @Override // com.qq.e.comm.plugin.c.a.b
                    public void c() {
                        bVar.c();
                        d();
                    }
                });
            }

            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void a(String str, int i) {
                super.a(str, i);
                if (com.qq.e.comm.plugin.a.d.d.b(i)) {
                    return;
                }
                b.this.A();
            }

            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void a(String str, final com.qq.e.comm.plugin.c.a.b bVar) {
                Activity a2 = com.qq.e.comm.plugin.util.f.a(this.f12222a);
                if (a2 != null) {
                    b.this.aa = new com.qq.e.comm.plugin.ac.c(a2, str, new com.qq.e.comm.plugin.c.a.b() { // from class: com.qq.e.comm.plugin.splash.b.1.1
                        @Override // com.qq.e.comm.plugin.c.a.b
                        public void a() {
                            bVar.a();
                            b.this.A();
                        }

                        @Override // com.qq.e.comm.plugin.c.a.b
                        public void b() {
                            bVar.b();
                        }

                        @Override // com.qq.e.comm.plugin.c.a.b
                        public void c() {
                            bVar.c();
                            b.this.A();
                        }
                    });
                    b.this.aa.a();
                }
            }

            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void a(boolean z) {
                super.a(z);
                b.this.A();
            }

            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public BrowserType b(String str, com.qq.e.comm.plugin.s.a aVar) {
                BrowserType b2 = super.b(str, aVar);
                b.this.A();
                return b2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        GDTLogger.d("广告和资源加载成功，总耗时:" + (System.currentTimeMillis() - this.Q));
        if (!this.P.b()) {
            GDTLogger.d("开屏广告已超时或者在展示：" + this.P);
            return;
        }
        this.D = false;
        this.G = false;
        this.g.a(SystemClock.elapsedRealtime());
        this.E = i.a();
        boolean b2 = i.b();
        Runnable runnable = new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.15
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.o == null || b.this.g == null) {
                    return;
                }
                b.this.o.onADEvent(new ADEvent(7, new Object[]{Long.valueOf(b.this.g.ao() + b.this.E)}));
            }
        };
        if (b2) {
            w.b(runnable);
        } else {
            w.a(runnable);
        }
        if (this.C) {
            this.C = false;
            k.a((Boolean) null, 0, this.e);
            this.F = true;
            s();
        }
    }

    private void n() {
        this.p = new g(getContext());
        addView(this.p, new FrameLayout.LayoutParams(-1, -1));
        this.p.setId(1);
        this.q = new com.qq.e.comm.plugin.aa.b.f(getContext().getApplicationContext());
        this.q.a(f.c.CROP);
        this.q.h();
        this.q.setId(5);
    }

    private void o() {
        if (this.H == null) {
            this.H = new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.16
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.P.i() && b.this.w == q.VIDEO && b.this.J == EnumC1180b.Downloaded) {
                        GDTLogger.d("开屏视频拉取超时，转图片成功");
                        b.this.w = q.IMG;
                        b.this.m();
                    } else if (b.this.P.f()) {
                        b.this.d.d();
                        k.a(b.this.h, b.this.J, b.this.d.c(), b.this.e);
                        GDTLogger.e("加载开屏广告网络超时，请检查网络状态当前设置的超时时长为：" + b.this.h + "ms]");
                        b.this.b(404);
                    }
                }
            };
        } else {
            w.c(this.H);
        }
        k.a(this.e);
        this.d.a();
        w.a(this.H, this.h);
    }

    private void p() {
        if (TextUtils.isEmpty(this.g.G())) {
            this.w = q.IMG;
        } else {
            this.w = q.VIDEO;
            r();
        }
        k.a(this.w, this.e);
        GDTLogger.d("开始下载开屏图片");
        q();
    }

    private void q() {
        this.J = EnumC1180b.Downloading;
        final String o = this.g.o();
        final long currentTimeMillis = System.currentTimeMillis();
        com.qq.e.comm.plugin.p.a.a().a(o, new com.qq.e.comm.plugin.p.b() { // from class: com.qq.e.comm.plugin.splash.b.17
            @Override // com.qq.e.comm.plugin.p.b
            public void a(String str, int i, Exception exc) {
                GDTLogger.d("开屏图片下载失败");
                GDTLogger.e("Download Failed, code: " + i + ", msg: " + exc.getMessage());
                b.this.a(o, currentTimeMillis, i, exc);
            }

            @Override // com.qq.e.comm.plugin.p.b
            public void a(String str, ImageView imageView, com.qq.e.comm.plugin.p.e eVar) {
                File b2 = eVar.b();
                if (eVar.c()) {
                    b.this.a(b2, o, -1L);
                } else {
                    b.this.a(b2, o, currentTimeMillis);
                }
                GDTLogger.d("开屏图片下载成功");
            }
        });
    }

    private void r() {
        this.K = EnumC1180b.Downloading;
        final String G = this.g.G();
        File f = ah.f();
        String a2 = ah.a(G);
        File file = new File(f, a2);
        if (file.exists()) {
            b(file, G, -1L);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.qq.e.comm.plugin.aa.a.a.a().a(new b.a().b(G).a(f).a(a2).a(), G, new com.qq.e.comm.plugin.j.a() { // from class: com.qq.e.comm.plugin.splash.b.18
            @Override // com.qq.e.comm.plugin.j.a
            public void a() {
                GDTLogger.d("开屏视频开始下载");
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(long j, long j2, int i) {
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(long j, boolean z) {
                GDTLogger.d("开屏视频连接成功");
                GDTLogger.d("onConnected isRangeSupport: " + z + ", total: " + j);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(com.qq.e.comm.plugin.j.c cVar) {
                GDTLogger.d("开屏视频下载失败");
                GDTLogger.e("Download Failed, code: " + cVar.a() + ", msg: " + cVar.b());
                b.this.b(G, System.currentTimeMillis() - currentTimeMillis, cVar.a(), cVar);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(File file2, long j) {
                long currentTimeMillis2 = System.currentTimeMillis();
                long j2 = currentTimeMillis;
                GDTLogger.d("开屏视频下载成功");
                b.this.b(file2, G, currentTimeMillis2 - j2);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void b() {
                GDTLogger.d("开屏视频下载被暂停");
                b.this.b(G, System.currentTimeMillis() - currentTimeMillis, -3, (Exception) null);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void c() {
                GDTLogger.d("开屏视频下载被取消");
                b.this.b(G, System.currentTimeMillis() - currentTimeMillis, -4, (Exception) null);
            }
        });
    }

    private void s() {
        l();
        if (this.g == null) {
            k.a((Boolean) false, 4014, this.e);
            b(4014);
        } else if (this.B == null) {
            GDTLogger.d("开始播放广告type:" + this.w + "，广告倒计时为:" + this.i);
            w.a(new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.w == q.IMG) {
                        b.this.a(b.this.I);
                    } else if (b.this.w == q.VIDEO) {
                        b.this.a(b.this.L);
                    }
                }
            });
        } else {
            com.qq.e.comm.plugin.s.f fVar = this.g;
            this.g = this.B;
            this.g.q(fVar.g());
            if (!this.d.b()) {
                this.g.b(fVar);
            }
            if (this.g.h() > 0) {
                this.i = this.g.h() * 1000;
            }
            this.A = String.valueOf(i.d());
            this.g.z(this.A);
            switch (this.B.F()) {
                case 0:
                    final File a2 = com.qq.e.comm.plugin.u.b.a().a(this.f12762b, this.B.o());
                    if (a2.exists()) {
                        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.19
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.a(a2);
                            }
                        });
                        return;
                    }
                    a(this.B.o());
                    f.b(this.e);
                    return;
                case 1:
                    final File a3 = com.qq.e.comm.plugin.u.b.a().a(this.f12762b, this.B.G());
                    final File a4 = com.qq.e.comm.plugin.u.b.a().a(this.f12762b, this.B.o());
                    if (!a3.exists() ? false : !i.e() || TextUtils.isEmpty(this.B.k()) || this.B.k().equals(Md5Util.encode(a3))) {
                        this.w = q.VIDEO;
                        this.O = a.PreLoadVideo;
                        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.20
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.a(a3);
                            }
                        });
                        f.a(this.e);
                        return;
                    } else if (a4.exists()) {
                        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.21
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.a(a4);
                            }
                        });
                        f.a(false, this.e);
                        return;
                    } else {
                        a(this.B.o());
                        f.a(true, this.e);
                        return;
                    }
                default:
                    f.a(this.B.F(), this.e);
                    return;
            }
        }
    }

    private boolean t() {
        int i;
        if (this.g.L() || this.B != null || (i = i.i()) == 0) {
            return false;
        }
        if (i != 1) {
            if (com.qq.e.comm.plugin.l.a.a().a(this.g.Z(), String.valueOf(i), 0) != 1) {
                return false;
            }
        }
        return true;
    }

    private int u() {
        if (this.g.L() || this.B != null) {
            return 0;
        }
        int j = i.j();
        if (j < 0 || j > 3) {
            return com.qq.e.comm.plugin.l.a.a().a(this.g.Z(), String.valueOf(j), 0);
        }
        return j;
    }

    private void v() {
        View view;
        boolean z = true;
        int i = 0;
        boolean t = t();
        int u = u();
        GDTLogger.d("开屏skip delay:" + t + " pos:" + u + " showVol:false");
        int a2 = ak.a(getContext(), 12);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(a2, a2, a2, a2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ak.a(getContext(), 42), ak.a(getContext(), 16));
        layoutParams2.setMargins(a2, a2, a2, a2);
        boolean z2 = this.m == null;
        k.a(Boolean.valueOf(z2), this.w, this.e);
        View C = C();
        if (z2) {
            View a3 = a(u == 0);
            if (u == 2) {
                layoutParams.gravity = 8388659;
                layoutParams2.gravity = 8388693;
                view = C;
            } else if (u == 3) {
                layoutParams.gravity = 8388693;
                layoutParams2.gravity = 8388659;
                view = a3;
            } else {
                layoutParams.gravity = 8388661;
                layoutParams2.gravity = 8388693;
                view = C;
            }
            addView(a3, layoutParams);
            if (t) {
                a(a3);
            }
        } else {
            layoutParams2.gravity = 8388693;
            view = C;
        }
        addView(C, layoutParams2);
        int aq = this.g.aq();
        if (aq < 0 || !i.c()) {
            z = false;
        }
        GDTLogger.d("开屏是否显示动画:" + z + " 开始时间:" + aq);
        if (z) {
            i = ak.a(getContext(), 60);
            a(aq * 1000, a(this.g.n(), i), i, view);
        }
        c(i);
    }

    private void w() {
        if (this.m != null) {
            this.m.post(new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!b.this.b(b.this.m)) {
                        GDTLogger.e("跳过按钮处于不可见状态，无法进行曝光上报和计费，请检查您的代码逻辑，保证跳过按钮可见。");
                        b.this.b((int) ErrorCode.OtherError.SKIP_VIEW_SIZE_ERROR);
                        k.a(4019, b.this.e, b.this.c(b.this.m));
                        return;
                    }
                    int b2 = ak.b(GDTADManager.getInstance().getAppContext(), b.this.m.getWidth());
                    int b3 = ak.b(GDTADManager.getInstance().getAppContext(), b.this.m.getHeight());
                    GDTLogger.d("###跳过按钮物理宽度=" + b2 + "dp");
                    GDTLogger.d("###跳过按钮物理高度=" + b3 + "dp");
                    Rect rect = new Rect();
                    boolean globalVisibleRect = b.this.m.getGlobalVisibleRect(rect);
                    int b4 = ak.b(GDTADManager.getInstance().getAppContext(), rect.width());
                    int b5 = ak.b(GDTADManager.getInstance().getAppContext(), rect.height());
                    GDTLogger.d("###跳过按钮在屏幕中的可见性=" + globalVisibleRect);
                    GDTLogger.d("###跳过按钮可见宽度=" + b4 + "dp");
                    GDTLogger.d("###跳过按钮可见高度=" + b5 + "dp");
                    if (!globalVisibleRect || b2 < 3 || b3 < 3 || b4 < 3 || b5 < 3) {
                        GDTLogger.e("跳过按钮的宽和高都必须 >= 3dp，否则将不进行曝光上报和计费");
                        b.this.b((int) ErrorCode.OtherError.SKIP_VIEW_SIZE_ERROR);
                        k.a(4009, b.this.e, (com.qq.e.comm.plugin.y.d) null);
                    }
                }
            });
        }
    }

    private void x() {
        if (this.l != null) {
            this.l.post(new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.6
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    b.this.v = b.this.l.getWidth();
                    b.this.u = b.this.l.getHeight();
                    int b2 = ak.b(GDTADManager.getInstance().getAppContext(), b.this.u);
                    GDTLogger.d("###广告容器物理高度=" + b2 + "dp");
                    Rect rect = new Rect();
                    boolean globalVisibleRect = b.this.l.getGlobalVisibleRect(rect);
                    int b3 = ak.b(GDTADManager.getInstance().getAppContext(), rect.height());
                    GDTLogger.d("###开屏容器在屏幕中的可见性=" + globalVisibleRect);
                    GDTLogger.d("###开屏容器在屏幕中的可见高度=" + b3 + "dp");
                    boolean y = b.y();
                    if (y) {
                        DisplayMetrics displayMetrics = b.this.getContext().getResources().getDisplayMetrics();
                        int b4 = ak.b(GDTADManager.getInstance().getAppContext(), displayMetrics.heightPixels > displayMetrics.widthPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels);
                        GDTLogger.d("###开屏屏幕高度=" + b4 + "dp");
                        i = (int) (b4 * 0.75d);
                    } else {
                        i = 400;
                    }
                    if (!globalVisibleRect || b2 < i || b3 < i) {
                        if (y) {
                            GDTLogger.e("广告容器的高度必须 >= 手机的高度 * 0.75，否则将不进行曝光上报和计费，当前的高度为：" + b3 + "dp");
                        } else {
                            GDTLogger.e("广告容器的高度必须 >= 400dp，否则将不进行曝光上报和计费，当前的高度为：" + b3 + "dp");
                        }
                        b.this.b((int) ErrorCode.OtherError.CONTAINER_HEIGHT_ERROR);
                        k.a(4005, b.this.e, (com.qq.e.comm.plugin.y.d) null);
                        return;
                    }
                    b.this.p.setOnClickListener(b.this.U);
                    b.this.q.setOnClickListener(b.this.U);
                    if (b.this.G) {
                        return;
                    }
                    b.this.G = true;
                    com.qq.e.comm.plugin.ad.a.a().a(b.this);
                    b.this.post(new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.z();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean y() {
        return SDKStatus.getSDKVersionCode() > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        boolean z = false;
        GDTLogger.d("开屏开始曝光");
        k.a((Boolean) null, 0, this.e, (Exception) null);
        this.t = new com.qq.e.comm.plugin.ad.g();
        this.t.a(System.currentTimeMillis());
        if (this.d.b() && !l.a(getContext())) {
            z = true;
        }
        if (z) {
            com.qq.e.comm.plugin.splash.a.b.b(this.g);
        } else {
            com.qq.e.comm.plugin.w.i.a(this.t.a(this.l, this.w == q.IMG ? 2 : 1, this.g.x(), "41"), com.qq.e.comm.plugin.ad.a.a().b(this), this.g, new d.b() { // from class: com.qq.e.comm.plugin.splash.b.7
                @Override // com.qq.e.comm.plugin.w.d.b
                public void a() {
                    k.a((Boolean) true, 0, b.this.e, (Exception) null);
                }

                @Override // com.qq.e.comm.plugin.w.d.b
                public void a(int i, Exception exc) {
                    k.a((Boolean) false, i, b.this.e, exc);
                }
            });
            this.g.V();
            this.g.W();
            String t = this.g.t();
            if (!StringUtil.isEmpty(t)) {
                af.a(t);
            }
        }
        if (this.o != null) {
            w.a(new Runnable() { // from class: com.qq.e.comm.plugin.splash.b.8
                @Override // java.lang.Runnable
                public void run() {
                    b.this.o.onADEvent(new ADEvent(6));
                }
            });
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.f.a
    public void a() {
        this.S = System.currentTimeMillis();
    }

    @Override // com.qq.e.comm.plugin.splash.h.a
    public void a(int i) {
        GDTLogger.d("广告拉取失败，耗时:" + (System.currentTimeMillis() - this.Q));
        if (this.P.i()) {
            b(i);
        } else {
            GDTLogger.d("广告回包时开屏广告已超时或者在展示：" + this.P);
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.f.a
    public void a(int i, Exception exc) {
        GDTLogger.d("开屏视频播放错误");
        k.a(this.g.G(), i, exc, this.e);
        if (this.O != a.InstantVideo) {
            A();
            return;
        }
        a(2, this.N);
        if (this.M) {
            return;
        }
        GDTLogger.d("尝试转图片开屏");
        if (!this.L.delete()) {
            GDTLogger.d("删除损坏视频文件失败:" + this.L.getAbsolutePath());
        }
        this.L = null;
        if (this.J == EnumC1180b.Downloaded && this.P.h()) {
            GDTLogger.d("转图片开屏成功");
            this.w = q.IMG;
            k.a(false, i, this.e, this.g.G(), exc);
            a(this.I);
        } else if (this.J == EnumC1180b.Downloading && this.P.g()) {
            GDTLogger.d("图片尚在下载中，等待下载结束");
            this.w = q.IMG;
            this.C = true;
        } else {
            GDTLogger.d("图片下载错误，失败");
            b(700);
            k.a(null, i, this.e, this.g.G(), exc);
        }
    }

    @Override // com.qq.e.comm.plugin.ab.a.b
    public void a(com.qq.e.comm.plugin.ab.a.a aVar) {
        GDTLogger.d("SplashAdView OnADLifeEvent:" + aVar.a());
        switch (aVar.a()) {
            case ConfirmDialogOpened:
                if (this.T != null) {
                    this.T.d();
                    return;
                }
                return;
            case ConfirmDialogClosed:
                if (this.T != null) {
                    this.T.e();
                    return;
                }
                return;
            case Clicked:
                A();
                return;
            default:
                return;
        }
    }

    @Override // com.qq.e.comm.plugin.splash.h.a
    public void a(com.qq.e.comm.plugin.s.f fVar, com.qq.e.comm.plugin.s.f fVar2) {
        GDTLogger.d("广告拉取成功，耗时:" + (System.currentTimeMillis() - this.Q));
        if (!this.P.i()) {
            GDTLogger.d("广告回包时开屏广告已超时或者在展示：" + this.P);
            return;
        }
        this.g = fVar;
        if (fVar2 != null) {
            this.B = fVar2;
            m();
        } else {
            p();
        }
        this.e.b(this.g.m()).c(this.g.H());
    }

    @Override // com.qq.e.comm.plugin.aa.b.f.a
    public void b() {
        GDTLogger.d("开屏视频开始播放:" + this.O);
        v();
        if (this.O != a.InstantVideo) {
            E();
            D();
        } else {
            B();
            this.M = true;
            k.a(true, 0, this.e, null, null);
        }
        k.a(this.S, this.e);
        aa.a(this.g.E().optString("video_tracking_url"));
    }

    @Override // com.qq.e.comm.plugin.aa.b.f.a
    public void c() {
        GDTLogger.d("开屏视频播放结束");
        if (this.O != a.InstantVideo) {
            A();
        } else {
            a(0, this.N);
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.f.a
    public void d() {
        GDTLogger.d("开屏视频stop");
        if (this.O != a.InstantVideo) {
            A();
        } else {
            a(0, this.N);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GDTLogger.d("SplashAdView dispatchTouchEvent");
        if (this.t != null) {
            this.t.a((View) this, motionEvent, false);
        }
        this.V.a(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.qq.e.comm.plugin.aa.b.f.a
    public void e() {
        GDTLogger.d("开屏视频暂停播放");
        if (this.O == a.InstantVideo) {
            a(0, this.N);
            this.N = 2;
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.f.a
    public void f() {
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAdOnly() {
        if (this.F || !this.P.a()) {
            GDTLogger.e("开屏拉取广告接口调用太频繁，之前的广告尚未加载完成或者正在展示isPlaying:" + this.F);
            return;
        }
        if (this.s != null) {
            this.s.recycle();
            this.s = null;
        }
        this.B = null;
        this.g = null;
        this.I = null;
        this.J = EnumC1180b.Unknown;
        this.K = EnumC1180b.Unknown;
        this.L = null;
        this.M = false;
        this.N = 1;
        if (l.a(getContext())) {
            com.qq.e.comm.plugin.splash.a.b.a().b();
        }
        this.Q = System.currentTimeMillis();
        this.h = i.g();
        this.i = i.b(this.f12762b);
        GDTLogger.d("开始拉取开屏资源广告拉取超时设置:" + this.h + " 广告展示时间:" + this.i);
        o();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAndShowIn(ViewGroup viewGroup) {
        if (viewGroup == null) {
            GDTLogger.e("Container param for fetchAndShowIn Method should not be null");
            return;
        }
        this.C = true;
        this.l = viewGroup;
        fetchAdOnly();
    }

    public int g() {
        if (this.B != null) {
            return this.B.O();
        }
        if (this.g != null) {
            return this.g.O();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getECPMLevel() {
        return this.B != null ? this.B.J() : this.g != null ? this.g.J() : "";
    }

    public int h() {
        if (this.B != null) {
            return this.B.I();
        }
        if (this.g != null) {
            return this.g.I();
        }
        return -1;
    }

    public int i() {
        if (this.B != null) {
            return this.B.K();
        }
        if (this.g != null) {
            return this.g.K();
        }
        return -1;
    }

    public boolean j() {
        if (this.B != null) {
            return this.B.L();
        }
        if (this.g != null) {
            return this.g.L();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            GDTLogger.d("onDetachedFromWindow");
            if (this.T != null) {
                this.T.c();
            }
            if (this.p != null) {
                this.p.setImageBitmap(null);
            }
            if (this.s != null && !this.s.isRecycled()) {
                this.s.recycle();
                this.s = null;
            }
            if (this.q != null) {
                this.q.clearAnimation();
                this.q.l();
            }
            if (this.r != null) {
                bc.a(this.r);
                this.r = null;
            }
        } catch (Exception e) {
            GDTLogger.d("Error during onDetachedFromWindow: " + e.getMessage());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        GDTLogger.d("开屏容器可见性发生改变:" + i);
        if (i == 0) {
            if (this.O != a.InstantVideo || this.q.c()) {
                return;
            }
            GDTLogger.d("播放容器可见，播放视频");
            this.q.b();
        } else if (this.O == a.InstantVideo && this.q.c()) {
            GDTLogger.d("播放容器不可见，暂停视频");
            this.q.a();
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void preload() {
        if (l.a(getContext())) {
            com.qq.e.comm.plugin.splash.a.b.a().b();
        }
        com.qq.e.comm.plugin.u.b.a().a(com.qq.e.comm.plugin.ad.e.SPLASH, this.f12761a, this.f12762b, this.c, this.f, this.x, l.b(this.f12762b));
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdListener(ADListener aDListener) {
        this.o = aDListener;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdLogoMargin(int i, int i2) {
        this.j = i;
        this.k = i2;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFetchDelay(int i) {
        if (i == 0) {
            GDTLogger.d("开屏超时时长已设为默认值");
        } else if (i < 2000) {
            i.a(2000L);
            GDTLogger.w("开屏超时时长取值范围为[2000, 5000]，已将超时时长设为2000ms。", null);
        } else if (i <= 5000) {
            i.a(i);
        } else {
            i.a(5000L);
            GDTLogger.w("开屏超时时长取值范围为[2000, 5000]，已将超时时长设为5000ms。", null);
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFloatView(View view) {
        if (view == null) {
            return;
        }
        this.y = view;
        this.y.setId(6);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.x = loadAdParams;
        if (SDKStatus.getSDKVersionCode() >= 50) {
            i.a(loadAdParams.getWXAppId());
        }
        this.d.a(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setPreloadView(View view) {
        if (view == null) {
            return;
        }
        this.z = view;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSkipView(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.splash.b.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.b(b.this.R, b.this.e);
                b.this.A();
            }
        });
        this.m = view;
        k.a((Boolean) null, (q) null, this.e);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showAd(ViewGroup viewGroup) {
        if (viewGroup == null) {
            GDTLogger.e("Container param for showAd Method should not be null");
            return;
        }
        k.a((Boolean) null, 0, this.e);
        int i = (this.g == null || !this.P.j()) ? 4014 : this.D ? 4015 : SystemClock.elapsedRealtime() > this.g.ao() + this.E ? 5012 : 0;
        if (i != 0) {
            k.a((Boolean) false, i, this.e);
            b(i);
            return;
        }
        this.l = viewGroup;
        this.F = true;
        s();
        this.D = true;
    }
}
