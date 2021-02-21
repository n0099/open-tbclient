package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.win.opensdk.core.Info;
import com.win.opensdk.d;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class ah implements ae<Info> {

    /* renamed from: java  reason: collision with other field name */
    private String f18java;
    public q qjE;
    Info qjI;
    long qjJ;
    private bj qjK;
    Context qjn;
    public PBBannerListener qjp;
    public boolean qjq;
    public bw qju;
    public ad qkw;
    PBBannerView qky;
    int java = 10;

    /* renamed from: case  reason: not valid java name */
    int f17case = 8;
    public AtomicInteger qkz = new AtomicInteger(0);
    public Handler qkv = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ah.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100151:
                    int i = 0;
                    if (ah.this.qjI != null) {
                        i = ah.this.qjI.getWt();
                    }
                    w.iN(ah.this.qjn).a(new x(ah.this.qjI), 2002, i * 1000).eIX();
                    ah.this.qkv.removeMessages(100151);
                    ah.this.a(PBError.TIMEOUT);
                    return;
                case 100152:
                    if (ah.this.qkz.get() < 3) {
                        if (ah.this.qky == null || !ah.this.qky.isVisible()) {
                            ah.this.qkv.sendEmptyMessageDelayed(100152, ah.this.f17case * 1000);
                            return;
                        } else {
                            ah.this.eIX();
                            return;
                        }
                    }
                    ah.this.qkv.removeMessages(100152);
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.win.opensdk.ae
    public final /* synthetic */ void bH(Info info) {
        final Info info2 = info;
        if (info2 == null || TextUtils.isEmpty(info2.getLoad())) {
            a(PBError.NO_FILL);
            return;
        }
        this.qjI = info2;
        this.qkz.set(0);
        this.f17case = info2.getTsi();
        this.qjJ = System.currentTimeMillis();
        if (info2.getType() != 31) {
            if (info2.getType() != 32) {
                a(PBError.PID_TYPE_ERROR);
            } else {
                try {
                    this.qjE = new q(this.qjn, af.BANNER);
                    this.qjE.qka = new bq() { // from class: com.win.opensdk.ah.2
                        @Override // com.win.opensdk.bq
                        public final void eIX() {
                            ah.this.qkv.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [185=4] */
                        @Override // com.win.opensdk.bq
                        public final void eIY() {
                            ah.this.qkv.removeMessages(100151);
                            ah.a(ah.this, info2, ah.this.qjE);
                            w.iN(ah.this.qjn).a(new x(ah.this.qjI), 200, System.currentTimeMillis() - ah.this.qjJ).eIX();
                            w.iN(ah.this.qjn).a(new x(info2)).eIX();
                            ah.a(ah.this);
                            z.b(ah.this.qjI);
                        }
                    };
                    this.qjE.qkb = new bo() { // from class: com.win.opensdk.ah.3
                        @Override // com.win.opensdk.bo
                        public final boolean hC(String str, String str2) {
                            ah.a(ah.this, info2, str);
                            if (ah.this.qjp != null) {
                                ah.this.qjp.onClicked();
                                return true;
                            }
                            return true;
                        }

                        @Override // com.win.opensdk.bo
                        public final void abR(String str) {
                        }
                    };
                    this.qjE.a(info2.getLoad(), this.qjI);
                } catch (Exception e) {
                }
            }
        } else {
            try {
                this.qju = new bw(this.qjn);
                this.qju.qka = new bq() { // from class: com.win.opensdk.ah.4
                    @Override // com.win.opensdk.bq
                    public final void eIX() {
                        ah.this.qkv.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [251=4] */
                    @Override // com.win.opensdk.bq
                    public final void eIY() {
                        ah.this.qkv.removeMessages(100151);
                        ah.a(ah.this, info2, ah.this.qju);
                        w.iN(ah.this.qjn).a(new x(ah.this.qjI), 200, System.currentTimeMillis() - ah.this.qjJ).eIX();
                        w.iN(ah.this.qjn).a(new x(info2)).eIX();
                        ah.a(ah.this);
                        z.b(ah.this.qjI);
                    }
                };
                this.qju.qkb = new bo() { // from class: com.win.opensdk.ah.5
                    @Override // com.win.opensdk.bo
                    public final boolean hC(String str, String str2) {
                        ah.a(ah.this, info2, str);
                        if (ah.this.qjp != null) {
                            ah.this.qjp.onClicked();
                            return true;
                        }
                        return true;
                    }

                    @Override // com.win.opensdk.bo
                    public final void abR(String str) {
                    }
                };
                this.qju.a(info2.getLoad(), this.qjI);
            } catch (Exception e2) {
            }
        }
        this.qkv.sendEmptyMessageDelayed(100152, this.f17case * 1000);
    }

    public ah(Context context, PBBannerView pBBannerView, String str) {
        this.qjn = context;
        this.qky = pBBannerView;
        this.f18java = str;
        this.qjK = new bj(context);
    }

    final void a(PBError pBError) {
        if (!this.qjq) {
            this.qjq = true;
            if (this.qjp != null) {
                this.qjp.onFail(pBError);
            }
        }
    }

    public final void eIX() {
        if (this.qkw == null) {
            this.qkw = new ad(this.qjn, this.f18java, e.java);
        }
        this.qjq = false;
        this.qkw.qkt = this;
        this.qkw.eIX();
    }

    @Override // com.win.opensdk.ae
    public final void b(PBError pBError) {
        int andIncrement = this.qkz.getAndIncrement();
        this.qkv.sendEmptyMessageDelayed(100152, this.f17case * 1000);
        if (andIncrement == 0) {
            a(pBError);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(ah ahVar, final Info info, bn bnVar) {
        char c = 0;
        try {
            if (ahVar.qky != null && bnVar.eJa().getParent() == null) {
                ahVar.qky.removeAllViews();
                ahVar.qky.addView(bnVar.eJa(), new FrameLayout.LayoutParams(-1, -1));
                ImageView imageView = new ImageView(ahVar.qjn);
                int k = bi.k(ahVar.qjn, 15.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, k);
                layoutParams.gravity = 3;
                imageView.setImageResource(d.a.btn_op);
                ahVar.qky.addView(imageView, layoutParams);
                ImageView imageView2 = new ImageView(ahVar.qjn);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(k, k);
                layoutParams2.gravity = 53;
                imageView2.setImageResource(d.a.btn_close_dark);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.ah.6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        try {
                            w.iN(ah.this.qjn).c(new x(info)).eIX();
                            if (ah.this.qjp != null) {
                                ah.this.qjp.onClosed();
                            }
                        } catch (Exception e) {
                        }
                        ah.this.qky.destroy();
                    }
                });
                ahVar.qky.addView(imageView2, layoutParams2);
            }
            if (ahVar.qky == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = ahVar.qky.getLayoutParams();
            String str = ahVar.f18java;
            int[] iArr = new int[2];
            if (ax.abQ(str)) {
                String substring = str.substring(0, 3);
                switch (substring.hashCode()) {
                    case 53431:
                        if (substring.equals("601")) {
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
                        if (substring.equals("603")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
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
            int k2 = bi.k(ahVar.qjn, iArr[0]);
            int k3 = bi.k(ahVar.qjn, iArr[1]);
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(k2, k3);
            } else {
                layoutParams3.width = k2;
                layoutParams3.height = k3;
            }
            ahVar.qky.setLayoutParams(layoutParams3);
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void a(ah ahVar) {
        if (ahVar.qjq) {
            return;
        }
        ahVar.qjq = true;
        if (ahVar.qjp == null) {
            return;
        }
        ahVar.qjp.onLoaded();
    }

    static /* synthetic */ void a(ah ahVar, Info info, String str) {
        aw.a(ahVar.qjn, str, info, ahVar.qjK);
        w.iN(ahVar.qjn).a(new x(info), str).eIX();
        ahVar.qkv.sendEmptyMessage(100152);
        z.a(ahVar.qjI);
    }
}
