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
    Context pYJ;
    public PBBannerListener pYL;
    public boolean pYM;
    public bw pYQ;
    public ad pZS;
    PBBannerView pZU;
    public q pZa;
    Info pZe;
    long pZf;
    private bj pZg;
    int java = 10;

    /* renamed from: case  reason: not valid java name */
    int f17case = 8;
    public AtomicInteger pZV = new AtomicInteger(0);
    public Handler pZR = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ah.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100151:
                    int i = 0;
                    if (ah.this.pZe != null) {
                        i = ah.this.pZe.getWt();
                    }
                    w.iK(ah.this.pYJ).a(new x(ah.this.pZe), 2002, i * 1000).eGz();
                    ah.this.pZR.removeMessages(100151);
                    ah.this.a(PBError.TIMEOUT);
                    return;
                case 100152:
                    if (ah.this.pZV.get() < 3) {
                        if (ah.this.pZU == null || !ah.this.pZU.isVisible()) {
                            ah.this.pZR.sendEmptyMessageDelayed(100152, ah.this.f17case * 1000);
                            return;
                        } else {
                            ah.this.eGz();
                            return;
                        }
                    }
                    ah.this.pZR.removeMessages(100152);
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
        this.pZe = info2;
        this.pZV.set(0);
        this.f17case = info2.getTsi();
        this.pZf = System.currentTimeMillis();
        if (info2.getType() != 31) {
            if (info2.getType() != 32) {
                a(PBError.PID_TYPE_ERROR);
            } else {
                try {
                    this.pZa = new q(this.pYJ, af.BANNER);
                    this.pZa.pZw = new bq() { // from class: com.win.opensdk.ah.2
                        @Override // com.win.opensdk.bq
                        public final void eGz() {
                            ah.this.pZR.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [185=4] */
                        @Override // com.win.opensdk.bq
                        public final void eGA() {
                            ah.this.pZR.removeMessages(100151);
                            ah.a(ah.this, info2, ah.this.pZa);
                            w.iK(ah.this.pYJ).a(new x(ah.this.pZe), 200, System.currentTimeMillis() - ah.this.pZf).eGz();
                            w.iK(ah.this.pYJ).a(new x(info2)).eGz();
                            ah.a(ah.this);
                            z.b(ah.this.pZe);
                        }
                    };
                    this.pZa.pZx = new bo() { // from class: com.win.opensdk.ah.3
                        @Override // com.win.opensdk.bo
                        public final boolean ht(String str, String str2) {
                            ah.a(ah.this, info2, str);
                            if (ah.this.pYL != null) {
                                ah.this.pYL.onClicked();
                                return true;
                            }
                            return true;
                        }

                        @Override // com.win.opensdk.bo
                        public final void aaE(String str) {
                        }
                    };
                    this.pZa.a(info2.getLoad(), this.pZe);
                } catch (Exception e) {
                }
            }
        } else {
            try {
                this.pYQ = new bw(this.pYJ);
                this.pYQ.pZw = new bq() { // from class: com.win.opensdk.ah.4
                    @Override // com.win.opensdk.bq
                    public final void eGz() {
                        ah.this.pZR.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [251=4] */
                    @Override // com.win.opensdk.bq
                    public final void eGA() {
                        ah.this.pZR.removeMessages(100151);
                        ah.a(ah.this, info2, ah.this.pYQ);
                        w.iK(ah.this.pYJ).a(new x(ah.this.pZe), 200, System.currentTimeMillis() - ah.this.pZf).eGz();
                        w.iK(ah.this.pYJ).a(new x(info2)).eGz();
                        ah.a(ah.this);
                        z.b(ah.this.pZe);
                    }
                };
                this.pYQ.pZx = new bo() { // from class: com.win.opensdk.ah.5
                    @Override // com.win.opensdk.bo
                    public final boolean ht(String str, String str2) {
                        ah.a(ah.this, info2, str);
                        if (ah.this.pYL != null) {
                            ah.this.pYL.onClicked();
                            return true;
                        }
                        return true;
                    }

                    @Override // com.win.opensdk.bo
                    public final void aaE(String str) {
                    }
                };
                this.pYQ.a(info2.getLoad(), this.pZe);
            } catch (Exception e2) {
            }
        }
        this.pZR.sendEmptyMessageDelayed(100152, this.f17case * 1000);
    }

    public ah(Context context, PBBannerView pBBannerView, String str) {
        this.pYJ = context;
        this.pZU = pBBannerView;
        this.f18java = str;
        this.pZg = new bj(context);
    }

    final void a(PBError pBError) {
        if (!this.pYM) {
            this.pYM = true;
            if (this.pYL != null) {
                this.pYL.onFail(pBError);
            }
        }
    }

    public final void eGz() {
        if (this.pZS == null) {
            this.pZS = new ad(this.pYJ, this.f18java, e.java);
        }
        this.pYM = false;
        this.pZS.pZP = this;
        this.pZS.eGz();
    }

    @Override // com.win.opensdk.ae
    public final void b(PBError pBError) {
        int andIncrement = this.pZV.getAndIncrement();
        this.pZR.sendEmptyMessageDelayed(100152, this.f17case * 1000);
        if (andIncrement == 0) {
            a(pBError);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(ah ahVar, final Info info, bn bnVar) {
        char c = 0;
        try {
            if (ahVar.pZU != null && bnVar.eGC().getParent() == null) {
                ahVar.pZU.removeAllViews();
                ahVar.pZU.addView(bnVar.eGC(), new FrameLayout.LayoutParams(-1, -1));
                ImageView imageView = new ImageView(ahVar.pYJ);
                int k = bi.k(ahVar.pYJ, 15.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, k);
                layoutParams.gravity = 3;
                imageView.setImageResource(d.a.btn_op);
                ahVar.pZU.addView(imageView, layoutParams);
                ImageView imageView2 = new ImageView(ahVar.pYJ);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(k, k);
                layoutParams2.gravity = 53;
                imageView2.setImageResource(d.a.btn_close_dark);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.ah.6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        try {
                            w.iK(ah.this.pYJ).c(new x(info)).eGz();
                            if (ah.this.pYL != null) {
                                ah.this.pYL.onClosed();
                            }
                        } catch (Exception e) {
                        }
                        ah.this.pZU.destroy();
                    }
                });
                ahVar.pZU.addView(imageView2, layoutParams2);
            }
            if (ahVar.pZU == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = ahVar.pZU.getLayoutParams();
            String str = ahVar.f18java;
            int[] iArr = new int[2];
            if (ax.aaD(str)) {
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
            int k2 = bi.k(ahVar.pYJ, iArr[0]);
            int k3 = bi.k(ahVar.pYJ, iArr[1]);
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(k2, k3);
            } else {
                layoutParams3.width = k2;
                layoutParams3.height = k3;
            }
            ahVar.pZU.setLayoutParams(layoutParams3);
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void a(ah ahVar) {
        if (ahVar.pYM) {
            return;
        }
        ahVar.pYM = true;
        if (ahVar.pYL == null) {
            return;
        }
        ahVar.pYL.onLoaded();
    }

    static /* synthetic */ void a(ah ahVar, Info info, String str) {
        aw.a(ahVar.pYJ, str, info, ahVar.pZg);
        w.iK(ahVar.pYJ).a(new x(info), str).eGz();
        ahVar.pZR.sendEmptyMessage(100152);
        z.a(ahVar.pZe);
    }
}
