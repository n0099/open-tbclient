package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.win.opensdk.bd;
import com.win.opensdk.core.Info;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes14.dex */
public class l implements du {

    /* renamed from: a  reason: collision with root package name */
    public String f8168a;
    public Context c;
    public boolean i;
    public long k;
    public PBBannerView qkj;
    public dq qkk;
    public PBBannerListener qkl;
    public Info qkm;
    public bg qkn;
    public be qko;
    public cy qkp;
    public int d = 10;
    public int e = 8;
    public AtomicInteger j = new AtomicInteger(0);
    public Handler o = new et(this, Looper.getMainLooper());

    public l(Context context, PBBannerView pBBannerView, String str) {
        this.c = context;
        this.qkj = pBBannerView;
        this.f8168a = str;
        this.qkp = new cy(context);
    }

    public static /* synthetic */ void a(l lVar, Info info, String str) {
        bf.a(lVar.c, str, info, lVar.qkp, "");
        ca.iT(lVar.c).a(new cd(info), str).a();
        lVar.o.sendEmptyMessage(100152);
        v.a(lVar.qkm, "");
    }

    @Override // com.win.opensdk.du
    public void a() {
    }

    public final void a(PBError pBError) {
        if (this.i) {
            return;
        }
        this.i = true;
        PBBannerListener pBBannerListener = this.qkl;
        if (pBBannerListener != null) {
            pBBannerListener.onFail(pBError);
        }
    }

    public final void a(Info info, fe feVar) {
        try {
            if (this.qkj != null && feVar.b().getParent() == null) {
                this.qkj.removeAllViews();
                this.qkj.addView(feVar.b(), new FrameLayout.LayoutParams(-1, -1));
                ImageView imageView = new ImageView(this.c);
                int b = v.b(this.c, 15.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b, b);
                layoutParams.gravity = 3;
                imageView.setImageResource(bd.a.btn_op);
                this.qkj.addView(imageView, layoutParams);
                ImageView imageView2 = new ImageView(this.c);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b, b);
                layoutParams2.gravity = 53;
                imageView2.setImageResource(bd.a.btn_close_dark);
                imageView2.setOnClickListener(new h(this, info));
                this.qkj.addView(imageView2, layoutParams2);
            }
            b();
        } catch (Exception e) {
        }
    }

    public void c() {
        try {
            if (this.qkn != null) {
                this.qkn.a();
            }
            if (this.qko != null) {
                this.qko.a();
            }
            if (this.o != null) {
                this.o.removeCallbacksAndMessages(null);
            }
            if (this.qkk != null) {
                this.qkk.a();
                this.qkk = null;
            }
            if (this.qkl != null) {
                this.qkl = null;
            }
        } catch (Exception e) {
        }
    }

    public void d() {
        try {
            this.j.set(0);
            this.i = false;
        } catch (Exception e) {
        }
        e();
    }

    public final void e() {
        if (this.qkk == null) {
            this.qkk = new dq(this.c, this.f8168a, F.BANNER);
        }
        this.i = false;
        dq dqVar = this.qkk;
        dqVar.qlS = this;
        dqVar.b();
    }

    @Override // com.win.opensdk.du
    public void onFail(PBError pBError) {
        int andIncrement = this.j.getAndIncrement();
        this.o.sendEmptyMessageDelayed(100152, this.e * 1000);
        if (andIncrement == 0) {
            a(pBError);
        }
    }

    @Override // com.win.opensdk.du
    public void a(Object obj) {
        Info info = (Info) obj;
        if (info != null && !TextUtils.isEmpty(info.getLoad())) {
            this.qkm = info;
            this.j.set(0);
            this.e = info.getTsi();
            this.k = System.currentTimeMillis();
            if (info.getType() == 31) {
                this.qkn = new bg(this.c);
                this.qkn.qlb = new fc(this, info);
                this.qkn.qlc = new d(this, info);
                this.qkn.a(info.getLoad(), this.qkm);
            } else if (info.getType() == 32) {
                this.qko = new be(this.c, K0.BANNER);
                this.qko.a(new ew(this, info));
                this.qko.a(new ez(this, info));
                this.qko.a(info.getLoad(), this.qkm);
            } else {
                a(PBError.PID_TYPE_ERROR);
                this.o.sendEmptyMessageDelayed(100152, this.e * 1000);
                return;
            }
            this.o.sendEmptyMessageDelayed(100152, this.e * 1000);
            return;
        }
        a(PBError.NO_FILL);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r6.equals("603") == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        char c = 3;
        PBBannerView pBBannerView = this.qkj;
        if (pBBannerView != null) {
            ViewGroup.LayoutParams layoutParams = pBBannerView.getLayoutParams();
            String str = this.f8168a;
            int[] iArr = new int[2];
            if (v.g(str)) {
                String substring = str.substring(0, 3);
                switch (substring.hashCode()) {
                    case 53431:
                        if (substring.equals("601")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 53432:
                        if (substring.equals("602")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 53433:
                        break;
                    case 53434:
                        if (substring.equals("604")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 53435:
                    case 53436:
                    default:
                        c = 65535;
                        break;
                    case 53437:
                        if (substring.equals("607")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                    case 2:
                        iArr[0] = -1;
                        iArr[1] = -1;
                        break;
                    case 3:
                        iArr[0] = 320;
                        iArr[1] = 50;
                        break;
                    case 4:
                        iArr[0] = 300;
                        iArr[1] = 250;
                        break;
                }
            }
            int b = v.b(this.c, iArr[0]);
            int b2 = v.b(this.c, iArr[1]);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(b, b2);
            } else {
                layoutParams.width = b;
                layoutParams.height = b2;
            }
            this.qkj.setLayoutParams(layoutParams);
        }
    }
}
