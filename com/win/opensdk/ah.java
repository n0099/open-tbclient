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
/* loaded from: classes4.dex */
public final class ah implements ae<Info> {

    /* renamed from: java  reason: collision with other field name */
    private String f18java;
    Context qbB;
    public PBBannerListener qbD;
    public boolean qbE;
    public bw qbI;
    public q qbS;
    Info qbW;
    long qbX;
    private bj qbY;
    public ad qcK;
    PBBannerView qcM;
    int java = 10;

    /* renamed from: case  reason: not valid java name */
    int f17case = 8;
    public AtomicInteger qcN = new AtomicInteger(0);
    public Handler qcJ = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ah.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100151:
                    int i = 0;
                    if (ah.this.qbW != null) {
                        i = ah.this.qbW.getWt();
                    }
                    w.iM(ah.this.qbB).a(new x(ah.this.qbW), 2002, i * 1000).eJL();
                    ah.this.qcJ.removeMessages(100151);
                    ah.this.a(PBError.TIMEOUT);
                    return;
                case 100152:
                    if (ah.this.qcN.get() < 3) {
                        if (ah.this.qcM == null || !ah.this.qcM.isVisible()) {
                            ah.this.qcJ.sendEmptyMessageDelayed(100152, ah.this.f17case * 1000);
                            return;
                        } else {
                            ah.this.eJL();
                            return;
                        }
                    }
                    ah.this.qcJ.removeMessages(100152);
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.win.opensdk.ae
    public final /* synthetic */ void bG(Info info) {
        final Info info2 = info;
        if (info2 == null || TextUtils.isEmpty(info2.getLoad())) {
            a(PBError.NO_FILL);
            return;
        }
        this.qbW = info2;
        this.qcN.set(0);
        this.f17case = info2.getTsi();
        this.qbX = System.currentTimeMillis();
        if (info2.getType() != 31) {
            if (info2.getType() != 32) {
                a(PBError.PID_TYPE_ERROR);
            } else {
                try {
                    this.qbS = new q(this.qbB, af.BANNER);
                    this.qbS.qco = new bq() { // from class: com.win.opensdk.ah.2
                        @Override // com.win.opensdk.bq
                        public final void eJL() {
                            ah.this.qcJ.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [185=4] */
                        @Override // com.win.opensdk.bq
                        public final void eJM() {
                            ah.this.qcJ.removeMessages(100151);
                            ah.a(ah.this, info2, ah.this.qbS);
                            w.iM(ah.this.qbB).a(new x(ah.this.qbW), 200, System.currentTimeMillis() - ah.this.qbX).eJL();
                            w.iM(ah.this.qbB).a(new x(info2)).eJL();
                            ah.a(ah.this);
                            z.b(ah.this.qbW);
                        }
                    };
                    this.qbS.qcp = new bo() { // from class: com.win.opensdk.ah.3
                        @Override // com.win.opensdk.bo
                        public final boolean ht(String str, String str2) {
                            ah.a(ah.this, info2, str);
                            if (ah.this.qbD != null) {
                                ah.this.qbD.onClicked();
                                return true;
                            }
                            return true;
                        }

                        @Override // com.win.opensdk.bo
                        public final void abK(String str) {
                        }
                    };
                    this.qbS.a(info2.getLoad(), this.qbW);
                } catch (Exception e) {
                }
            }
        } else {
            try {
                this.qbI = new bw(this.qbB);
                this.qbI.qco = new bq() { // from class: com.win.opensdk.ah.4
                    @Override // com.win.opensdk.bq
                    public final void eJL() {
                        ah.this.qcJ.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [251=4] */
                    @Override // com.win.opensdk.bq
                    public final void eJM() {
                        ah.this.qcJ.removeMessages(100151);
                        ah.a(ah.this, info2, ah.this.qbI);
                        w.iM(ah.this.qbB).a(new x(ah.this.qbW), 200, System.currentTimeMillis() - ah.this.qbX).eJL();
                        w.iM(ah.this.qbB).a(new x(info2)).eJL();
                        ah.a(ah.this);
                        z.b(ah.this.qbW);
                    }
                };
                this.qbI.qcp = new bo() { // from class: com.win.opensdk.ah.5
                    @Override // com.win.opensdk.bo
                    public final boolean ht(String str, String str2) {
                        ah.a(ah.this, info2, str);
                        if (ah.this.qbD != null) {
                            ah.this.qbD.onClicked();
                            return true;
                        }
                        return true;
                    }

                    @Override // com.win.opensdk.bo
                    public final void abK(String str) {
                    }
                };
                this.qbI.a(info2.getLoad(), this.qbW);
            } catch (Exception e2) {
            }
        }
        this.qcJ.sendEmptyMessageDelayed(100152, this.f17case * 1000);
    }

    public ah(Context context, PBBannerView pBBannerView, String str) {
        this.qbB = context;
        this.qcM = pBBannerView;
        this.f18java = str;
        this.qbY = new bj(context);
    }

    final void a(PBError pBError) {
        if (!this.qbE) {
            this.qbE = true;
            if (this.qbD != null) {
                this.qbD.onFail(pBError);
            }
        }
    }

    public final void eJL() {
        if (this.qcK == null) {
            this.qcK = new ad(this.qbB, this.f18java, e.java);
        }
        this.qbE = false;
        this.qcK.qcH = this;
        this.qcK.eJL();
    }

    @Override // com.win.opensdk.ae
    public final void b(PBError pBError) {
        int andIncrement = this.qcN.getAndIncrement();
        this.qcJ.sendEmptyMessageDelayed(100152, this.f17case * 1000);
        if (andIncrement == 0) {
            a(pBError);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(ah ahVar, final Info info, bn bnVar) {
        char c = 0;
        try {
            if (ahVar.qcM != null && bnVar.eJO().getParent() == null) {
                ahVar.qcM.removeAllViews();
                ahVar.qcM.addView(bnVar.eJO(), new FrameLayout.LayoutParams(-1, -1));
                ImageView imageView = new ImageView(ahVar.qbB);
                int k = bi.k(ahVar.qbB, 15.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, k);
                layoutParams.gravity = 3;
                imageView.setImageResource(d.a.btn_op);
                ahVar.qcM.addView(imageView, layoutParams);
                ImageView imageView2 = new ImageView(ahVar.qbB);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(k, k);
                layoutParams2.gravity = 53;
                imageView2.setImageResource(d.a.btn_close_dark);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.ah.6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        try {
                            w.iM(ah.this.qbB).c(new x(info)).eJL();
                            if (ah.this.qbD != null) {
                                ah.this.qbD.onClosed();
                            }
                        } catch (Exception e) {
                        }
                        ah.this.qcM.destroy();
                    }
                });
                ahVar.qcM.addView(imageView2, layoutParams2);
            }
            if (ahVar.qcM == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = ahVar.qcM.getLayoutParams();
            String str = ahVar.f18java;
            int[] iArr = new int[2];
            if (ax.abJ(str)) {
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
            int k2 = bi.k(ahVar.qbB, iArr[0]);
            int k3 = bi.k(ahVar.qbB, iArr[1]);
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(k2, k3);
            } else {
                layoutParams3.width = k2;
                layoutParams3.height = k3;
            }
            ahVar.qcM.setLayoutParams(layoutParams3);
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void a(ah ahVar) {
        if (ahVar.qbE) {
            return;
        }
        ahVar.qbE = true;
        if (ahVar.qbD == null) {
            return;
        }
        ahVar.qbD.onLoaded();
    }

    static /* synthetic */ void a(ah ahVar, Info info, String str) {
        aw.a(ahVar.qbB, str, info, ahVar.qbY);
        w.iM(ahVar.qbB).a(new x(info), str).eJL();
        ahVar.qcJ.sendEmptyMessage(100152);
        z.a(ahVar.qbW);
    }
}
