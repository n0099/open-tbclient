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
    Context qiN;
    public PBBannerListener qiP;
    public boolean qiQ;
    public bw qiU;
    public ad qjW;
    PBBannerView qjY;
    public q qje;
    Info qji;
    long qjj;
    private bj qjk;
    int java = 10;

    /* renamed from: case  reason: not valid java name */
    int f17case = 8;
    public AtomicInteger qjZ = new AtomicInteger(0);
    public Handler qjV = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ah.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100151:
                    int i = 0;
                    if (ah.this.qji != null) {
                        i = ah.this.qji.getWt();
                    }
                    w.iN(ah.this.qiN).a(new x(ah.this.qji), 2002, i * 1000).eIP();
                    ah.this.qjV.removeMessages(100151);
                    ah.this.a(PBError.TIMEOUT);
                    return;
                case 100152:
                    if (ah.this.qjZ.get() < 3) {
                        if (ah.this.qjY == null || !ah.this.qjY.isVisible()) {
                            ah.this.qjV.sendEmptyMessageDelayed(100152, ah.this.f17case * 1000);
                            return;
                        } else {
                            ah.this.eIP();
                            return;
                        }
                    }
                    ah.this.qjV.removeMessages(100152);
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
        this.qji = info2;
        this.qjZ.set(0);
        this.f17case = info2.getTsi();
        this.qjj = System.currentTimeMillis();
        if (info2.getType() != 31) {
            if (info2.getType() != 32) {
                a(PBError.PID_TYPE_ERROR);
            } else {
                try {
                    this.qje = new q(this.qiN, af.BANNER);
                    this.qje.qjA = new bq() { // from class: com.win.opensdk.ah.2
                        @Override // com.win.opensdk.bq
                        public final void eIP() {
                            ah.this.qjV.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [185=4] */
                        @Override // com.win.opensdk.bq
                        public final void eIQ() {
                            ah.this.qjV.removeMessages(100151);
                            ah.a(ah.this, info2, ah.this.qje);
                            w.iN(ah.this.qiN).a(new x(ah.this.qji), 200, System.currentTimeMillis() - ah.this.qjj).eIP();
                            w.iN(ah.this.qiN).a(new x(info2)).eIP();
                            ah.a(ah.this);
                            z.b(ah.this.qji);
                        }
                    };
                    this.qje.qjB = new bo() { // from class: com.win.opensdk.ah.3
                        @Override // com.win.opensdk.bo
                        public final boolean hA(String str, String str2) {
                            ah.a(ah.this, info2, str);
                            if (ah.this.qiP != null) {
                                ah.this.qiP.onClicked();
                                return true;
                            }
                            return true;
                        }

                        @Override // com.win.opensdk.bo
                        public final void abF(String str) {
                        }
                    };
                    this.qje.a(info2.getLoad(), this.qji);
                } catch (Exception e) {
                }
            }
        } else {
            try {
                this.qiU = new bw(this.qiN);
                this.qiU.qjA = new bq() { // from class: com.win.opensdk.ah.4
                    @Override // com.win.opensdk.bq
                    public final void eIP() {
                        ah.this.qjV.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [251=4] */
                    @Override // com.win.opensdk.bq
                    public final void eIQ() {
                        ah.this.qjV.removeMessages(100151);
                        ah.a(ah.this, info2, ah.this.qiU);
                        w.iN(ah.this.qiN).a(new x(ah.this.qji), 200, System.currentTimeMillis() - ah.this.qjj).eIP();
                        w.iN(ah.this.qiN).a(new x(info2)).eIP();
                        ah.a(ah.this);
                        z.b(ah.this.qji);
                    }
                };
                this.qiU.qjB = new bo() { // from class: com.win.opensdk.ah.5
                    @Override // com.win.opensdk.bo
                    public final boolean hA(String str, String str2) {
                        ah.a(ah.this, info2, str);
                        if (ah.this.qiP != null) {
                            ah.this.qiP.onClicked();
                            return true;
                        }
                        return true;
                    }

                    @Override // com.win.opensdk.bo
                    public final void abF(String str) {
                    }
                };
                this.qiU.a(info2.getLoad(), this.qji);
            } catch (Exception e2) {
            }
        }
        this.qjV.sendEmptyMessageDelayed(100152, this.f17case * 1000);
    }

    public ah(Context context, PBBannerView pBBannerView, String str) {
        this.qiN = context;
        this.qjY = pBBannerView;
        this.f18java = str;
        this.qjk = new bj(context);
    }

    final void a(PBError pBError) {
        if (!this.qiQ) {
            this.qiQ = true;
            if (this.qiP != null) {
                this.qiP.onFail(pBError);
            }
        }
    }

    public final void eIP() {
        if (this.qjW == null) {
            this.qjW = new ad(this.qiN, this.f18java, e.java);
        }
        this.qiQ = false;
        this.qjW.qjT = this;
        this.qjW.eIP();
    }

    @Override // com.win.opensdk.ae
    public final void b(PBError pBError) {
        int andIncrement = this.qjZ.getAndIncrement();
        this.qjV.sendEmptyMessageDelayed(100152, this.f17case * 1000);
        if (andIncrement == 0) {
            a(pBError);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(ah ahVar, final Info info, bn bnVar) {
        char c = 0;
        try {
            if (ahVar.qjY != null && bnVar.eIS().getParent() == null) {
                ahVar.qjY.removeAllViews();
                ahVar.qjY.addView(bnVar.eIS(), new FrameLayout.LayoutParams(-1, -1));
                ImageView imageView = new ImageView(ahVar.qiN);
                int k = bi.k(ahVar.qiN, 15.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, k);
                layoutParams.gravity = 3;
                imageView.setImageResource(d.a.btn_op);
                ahVar.qjY.addView(imageView, layoutParams);
                ImageView imageView2 = new ImageView(ahVar.qiN);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(k, k);
                layoutParams2.gravity = 53;
                imageView2.setImageResource(d.a.btn_close_dark);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.ah.6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        try {
                            w.iN(ah.this.qiN).c(new x(info)).eIP();
                            if (ah.this.qiP != null) {
                                ah.this.qiP.onClosed();
                            }
                        } catch (Exception e) {
                        }
                        ah.this.qjY.destroy();
                    }
                });
                ahVar.qjY.addView(imageView2, layoutParams2);
            }
            if (ahVar.qjY == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = ahVar.qjY.getLayoutParams();
            String str = ahVar.f18java;
            int[] iArr = new int[2];
            if (ax.abE(str)) {
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
            int k2 = bi.k(ahVar.qiN, iArr[0]);
            int k3 = bi.k(ahVar.qiN, iArr[1]);
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(k2, k3);
            } else {
                layoutParams3.width = k2;
                layoutParams3.height = k3;
            }
            ahVar.qjY.setLayoutParams(layoutParams3);
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void a(ah ahVar) {
        if (ahVar.qiQ) {
            return;
        }
        ahVar.qiQ = true;
        if (ahVar.qiP == null) {
            return;
        }
        ahVar.qiP.onLoaded();
    }

    static /* synthetic */ void a(ah ahVar, Info info, String str) {
        aw.a(ahVar.qiN, str, info, ahVar.qjk);
        w.iN(ahVar.qiN).a(new x(info), str).eIP();
        ahVar.qjV.sendEmptyMessage(100152);
        z.a(ahVar.qji);
    }
}
