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
    Context pYI;
    public PBBannerListener pYK;
    public boolean pYL;
    public bw pYP;
    public q pYZ;
    public ad pZR;
    PBBannerView pZT;
    Info pZd;
    long pZe;
    private bj pZf;
    int java = 10;

    /* renamed from: case  reason: not valid java name */
    int f17case = 8;
    public AtomicInteger pZU = new AtomicInteger(0);
    public Handler pZQ = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ah.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100151:
                    int i = 0;
                    if (ah.this.pZd != null) {
                        i = ah.this.pZd.getWt();
                    }
                    w.iK(ah.this.pYI).a(new x(ah.this.pZd), 2002, i * 1000).eGz();
                    ah.this.pZQ.removeMessages(100151);
                    ah.this.a(PBError.TIMEOUT);
                    return;
                case 100152:
                    if (ah.this.pZU.get() < 3) {
                        if (ah.this.pZT == null || !ah.this.pZT.isVisible()) {
                            ah.this.pZQ.sendEmptyMessageDelayed(100152, ah.this.f17case * 1000);
                            return;
                        } else {
                            ah.this.eGz();
                            return;
                        }
                    }
                    ah.this.pZQ.removeMessages(100152);
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
        this.pZd = info2;
        this.pZU.set(0);
        this.f17case = info2.getTsi();
        this.pZe = System.currentTimeMillis();
        if (info2.getType() != 31) {
            if (info2.getType() != 32) {
                a(PBError.PID_TYPE_ERROR);
            } else {
                try {
                    this.pYZ = new q(this.pYI, af.BANNER);
                    this.pYZ.pZv = new bq() { // from class: com.win.opensdk.ah.2
                        @Override // com.win.opensdk.bq
                        public final void eGz() {
                            ah.this.pZQ.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [185=4] */
                        @Override // com.win.opensdk.bq
                        public final void eGA() {
                            ah.this.pZQ.removeMessages(100151);
                            ah.a(ah.this, info2, ah.this.pYZ);
                            w.iK(ah.this.pYI).a(new x(ah.this.pZd), 200, System.currentTimeMillis() - ah.this.pZe).eGz();
                            w.iK(ah.this.pYI).a(new x(info2)).eGz();
                            ah.a(ah.this);
                            z.b(ah.this.pZd);
                        }
                    };
                    this.pYZ.pZw = new bo() { // from class: com.win.opensdk.ah.3
                        @Override // com.win.opensdk.bo
                        public final boolean ht(String str, String str2) {
                            ah.a(ah.this, info2, str);
                            if (ah.this.pYK != null) {
                                ah.this.pYK.onClicked();
                                return true;
                            }
                            return true;
                        }

                        @Override // com.win.opensdk.bo
                        public final void aaD(String str) {
                        }
                    };
                    this.pYZ.a(info2.getLoad(), this.pZd);
                } catch (Exception e) {
                }
            }
        } else {
            try {
                this.pYP = new bw(this.pYI);
                this.pYP.pZv = new bq() { // from class: com.win.opensdk.ah.4
                    @Override // com.win.opensdk.bq
                    public final void eGz() {
                        ah.this.pZQ.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [251=4] */
                    @Override // com.win.opensdk.bq
                    public final void eGA() {
                        ah.this.pZQ.removeMessages(100151);
                        ah.a(ah.this, info2, ah.this.pYP);
                        w.iK(ah.this.pYI).a(new x(ah.this.pZd), 200, System.currentTimeMillis() - ah.this.pZe).eGz();
                        w.iK(ah.this.pYI).a(new x(info2)).eGz();
                        ah.a(ah.this);
                        z.b(ah.this.pZd);
                    }
                };
                this.pYP.pZw = new bo() { // from class: com.win.opensdk.ah.5
                    @Override // com.win.opensdk.bo
                    public final boolean ht(String str, String str2) {
                        ah.a(ah.this, info2, str);
                        if (ah.this.pYK != null) {
                            ah.this.pYK.onClicked();
                            return true;
                        }
                        return true;
                    }

                    @Override // com.win.opensdk.bo
                    public final void aaD(String str) {
                    }
                };
                this.pYP.a(info2.getLoad(), this.pZd);
            } catch (Exception e2) {
            }
        }
        this.pZQ.sendEmptyMessageDelayed(100152, this.f17case * 1000);
    }

    public ah(Context context, PBBannerView pBBannerView, String str) {
        this.pYI = context;
        this.pZT = pBBannerView;
        this.f18java = str;
        this.pZf = new bj(context);
    }

    final void a(PBError pBError) {
        if (!this.pYL) {
            this.pYL = true;
            if (this.pYK != null) {
                this.pYK.onFail(pBError);
            }
        }
    }

    public final void eGz() {
        if (this.pZR == null) {
            this.pZR = new ad(this.pYI, this.f18java, e.java);
        }
        this.pYL = false;
        this.pZR.pZO = this;
        this.pZR.eGz();
    }

    @Override // com.win.opensdk.ae
    public final void b(PBError pBError) {
        int andIncrement = this.pZU.getAndIncrement();
        this.pZQ.sendEmptyMessageDelayed(100152, this.f17case * 1000);
        if (andIncrement == 0) {
            a(pBError);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(ah ahVar, final Info info, bn bnVar) {
        char c = 0;
        try {
            if (ahVar.pZT != null && bnVar.eGC().getParent() == null) {
                ahVar.pZT.removeAllViews();
                ahVar.pZT.addView(bnVar.eGC(), new FrameLayout.LayoutParams(-1, -1));
                ImageView imageView = new ImageView(ahVar.pYI);
                int k = bi.k(ahVar.pYI, 15.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, k);
                layoutParams.gravity = 3;
                imageView.setImageResource(d.a.btn_op);
                ahVar.pZT.addView(imageView, layoutParams);
                ImageView imageView2 = new ImageView(ahVar.pYI);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(k, k);
                layoutParams2.gravity = 53;
                imageView2.setImageResource(d.a.btn_close_dark);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.ah.6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        try {
                            w.iK(ah.this.pYI).c(new x(info)).eGz();
                            if (ah.this.pYK != null) {
                                ah.this.pYK.onClosed();
                            }
                        } catch (Exception e) {
                        }
                        ah.this.pZT.destroy();
                    }
                });
                ahVar.pZT.addView(imageView2, layoutParams2);
            }
            if (ahVar.pZT == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = ahVar.pZT.getLayoutParams();
            String str = ahVar.f18java;
            int[] iArr = new int[2];
            if (ax.aaC(str)) {
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
            int k2 = bi.k(ahVar.pYI, iArr[0]);
            int k3 = bi.k(ahVar.pYI, iArr[1]);
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(k2, k3);
            } else {
                layoutParams3.width = k2;
                layoutParams3.height = k3;
            }
            ahVar.pZT.setLayoutParams(layoutParams3);
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void a(ah ahVar) {
        if (ahVar.pYL) {
            return;
        }
        ahVar.pYL = true;
        if (ahVar.pYK == null) {
            return;
        }
        ahVar.pYK.onLoaded();
    }

    static /* synthetic */ void a(ah ahVar, Info info, String str) {
        aw.a(ahVar.pYI, str, info, ahVar.pZf);
        w.iK(ahVar.pYI).a(new x(info), str).eGz();
        ahVar.pZQ.sendEmptyMessage(100152);
        z.a(ahVar.pZd);
    }
}
