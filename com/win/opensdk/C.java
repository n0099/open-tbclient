package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.win.opensdk.core.Info;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class C implements o1 {

    /* renamed from: a  reason: collision with root package name */
    public String f39635a;

    /* renamed from: b  reason: collision with root package name */
    public PBBannerView f39636b;

    /* renamed from: c  reason: collision with root package name */
    public Context f39637c;

    /* renamed from: f  reason: collision with root package name */
    public n1 f39640f;

    /* renamed from: g  reason: collision with root package name */
    public PBBannerListener f39641g;

    /* renamed from: h  reason: collision with root package name */
    public Info f39642h;
    public boolean i;
    public long k;
    public S l;
    public R0 m;
    public h2 n;

    /* renamed from: d  reason: collision with root package name */
    public int f39638d = 10;

    /* renamed from: e  reason: collision with root package name */
    public int f39639e = 8;
    public AtomicInteger j = new AtomicInteger(0);
    public Handler o = new w(this, Looper.getMainLooper());

    public C(Context context, PBBannerView pBBannerView, String str) {
        this.f39637c = context;
        this.f39636b = pBBannerView;
        this.f39635a = str;
        this.n = new h2(context);
    }

    public static /* synthetic */ void a(C c2, Info info, String str) {
        R1.a(c2.f39637c, str, info, c2.n, "");
        a1.a(c2.f39637c).a(new b1(info), str).a();
        c2.o.sendEmptyMessage(100152);
        G.a(c2.f39642h, "");
    }

    @Override // com.win.opensdk.o1
    public void a() {
    }

    public final void a(PBError pBError) {
        if (this.i) {
            return;
        }
        this.i = true;
        PBBannerListener pBBannerListener = this.f39641g;
        if (pBBannerListener != null) {
            pBBannerListener.onFail(pBError);
        }
    }

    public final void a(Info info, z2 z2Var) {
        try {
            if (this.f39636b != null && z2Var.b().getParent() == null) {
                this.f39636b.removeAllViews();
                this.f39636b.addView(z2Var.b(), new FrameLayout.LayoutParams(-1, -1));
                ImageView imageView = new ImageView(this.f39637c);
                int b2 = G.b(this.f39637c, 15.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, b2);
                layoutParams.gravity = 3;
                imageView.setImageResource(R.drawable.btn_op);
                this.f39636b.addView(imageView, layoutParams);
                ImageView imageView2 = new ImageView(this.f39637c);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b2, b2);
                layoutParams2.gravity = 53;
                imageView2.setImageResource(R.drawable.btn_close_dark);
                imageView2.setOnClickListener(new B(this, info));
                this.f39636b.addView(imageView2, layoutParams2);
            }
            b();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void b() {
        char c2;
        PBBannerView pBBannerView = this.f39636b;
        if (pBBannerView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = pBBannerView.getLayoutParams();
        String str = this.f39635a;
        int[] iArr = new int[2];
        if (G.g(str)) {
            String substring = str.substring(0, 3);
            switch (substring.hashCode()) {
                case 53431:
                    if (substring.equals("601")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 53432:
                    if (substring.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE602)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 53433:
                    if (substring.equals("603")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 53434:
                    if (substring.equals("604")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 53435:
                case 53436:
                default:
                    c2 = 65535;
                    break;
                case 53437:
                    if (substring.equals("607")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
            }
            if (c2 == 0 || c2 == 1 || c2 == 2) {
                iArr[0] = -1;
                iArr[1] = -1;
            } else if (c2 == 3) {
                iArr[0] = 320;
                iArr[1] = 50;
            } else if (c2 == 4) {
                iArr[0] = 300;
                iArr[1] = 250;
            }
        }
        int b2 = G.b(this.f39637c, iArr[0]);
        int b3 = G.b(this.f39637c, iArr[1]);
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(b2, b3);
        } else {
            layoutParams.width = b2;
            layoutParams.height = b3;
        }
        this.f39636b.setLayoutParams(layoutParams);
    }

    public void c() {
        try {
            if (this.l != null) {
                this.l.a();
            }
            if (this.m != null) {
                this.m.a();
            }
            if (this.o != null) {
                this.o.removeCallbacksAndMessages(null);
            }
            if (this.f39640f != null) {
                this.f39640f.a();
                this.f39640f = null;
            }
            if (this.f39641g != null) {
                this.f39641g = null;
            }
        } catch (Exception unused) {
        }
    }

    public void d() {
        try {
            this.j.set(0);
            this.i = false;
        } catch (Exception unused) {
        }
        e();
    }

    public final void e() {
        if (this.f39640f == null) {
            this.f39640f = new n1(this.f39637c, this.f39635a, F.BANNER);
        }
        this.i = false;
        n1 n1Var = this.f39640f;
        n1Var.f39990g = this;
        n1Var.b();
    }

    @Override // com.win.opensdk.o1
    public void onFail(PBError pBError) {
        int andIncrement = this.j.getAndIncrement();
        this.o.sendEmptyMessageDelayed(100152, this.f39639e * 1000);
        if (andIncrement == 0) {
            a(pBError);
        }
    }

    @Override // com.win.opensdk.o1
    public void a(Object obj) {
        Info info = (Info) obj;
        if (info == null || TextUtils.isEmpty(info.getLoad())) {
            a(PBError.NO_FILL);
            return;
        }
        this.f39642h = info;
        this.j.set(0);
        this.f39639e = info.getTsi();
        this.k = System.currentTimeMillis();
        if (info.getType() == 31) {
            S s = new S(this.f39637c);
            this.l = s;
            s.f39786a = new z(this, info);
            this.l.f39787b = new A(this, info);
            this.l.a(info.getLoad(), this.f39642h);
        } else if (info.getType() == 32) {
            R0 r0 = new R0(this.f39637c, K0.BANNER);
            this.m = r0;
            r0.a(new x(this, info));
            this.m.a(new y(this, info));
            this.m.a(info.getLoad(), this.f39642h);
        } else {
            a(PBError.PID_TYPE_ERROR);
            this.o.sendEmptyMessageDelayed(100152, this.f39639e * 1000);
        }
        this.o.sendEmptyMessageDelayed(100152, this.f39639e * 1000);
    }
}
