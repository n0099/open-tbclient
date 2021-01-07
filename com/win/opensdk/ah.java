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
    private String f19java;
    public q qdA;
    Info qdE;
    long qdF;
    private bj qdG;
    Context qdj;
    public PBBannerListener qdl;
    public boolean qdm;
    public bw qdq;
    public ad qes;
    PBBannerView qeu;
    int java = 10;

    /* renamed from: case  reason: not valid java name */
    int f18case = 8;
    public AtomicInteger qev = new AtomicInteger(0);
    public Handler qer = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ah.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100151:
                    int i = 0;
                    if (ah.this.qdE != null) {
                        i = ah.this.qdE.getWt();
                    }
                    w.iM(ah.this.qdj).a(new x(ah.this.qdE), 2002, i * 1000).eKp();
                    ah.this.qer.removeMessages(100151);
                    ah.this.a(PBError.TIMEOUT);
                    return;
                case 100152:
                    if (ah.this.qev.get() < 3) {
                        if (ah.this.qeu == null || !ah.this.qeu.isVisible()) {
                            ah.this.qer.sendEmptyMessageDelayed(100152, ah.this.f18case * 1000);
                            return;
                        } else {
                            ah.this.eKp();
                            return;
                        }
                    }
                    ah.this.qer.removeMessages(100152);
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
        this.qdE = info2;
        this.qev.set(0);
        this.f18case = info2.getTsi();
        this.qdF = System.currentTimeMillis();
        if (info2.getType() != 31) {
            if (info2.getType() != 32) {
                a(PBError.PID_TYPE_ERROR);
            } else {
                try {
                    this.qdA = new q(this.qdj, af.BANNER);
                    this.qdA.qdW = new bq() { // from class: com.win.opensdk.ah.2
                        @Override // com.win.opensdk.bq
                        public final void eKp() {
                            ah.this.qer.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [185=4] */
                        @Override // com.win.opensdk.bq
                        public final void eKq() {
                            ah.this.qer.removeMessages(100151);
                            ah.a(ah.this, info2, ah.this.qdA);
                            w.iM(ah.this.qdj).a(new x(ah.this.qdE), 200, System.currentTimeMillis() - ah.this.qdF).eKp();
                            w.iM(ah.this.qdj).a(new x(info2)).eKp();
                            ah.a(ah.this);
                            z.b(ah.this.qdE);
                        }
                    };
                    this.qdA.qdX = new bo() { // from class: com.win.opensdk.ah.3
                        @Override // com.win.opensdk.bo
                        public final boolean hu(String str, String str2) {
                            ah.a(ah.this, info2, str);
                            if (ah.this.qdl != null) {
                                ah.this.qdl.onClicked();
                                return true;
                            }
                            return true;
                        }

                        @Override // com.win.opensdk.bo
                        public final void abL(String str) {
                        }
                    };
                    this.qdA.a(info2.getLoad(), this.qdE);
                } catch (Exception e) {
                }
            }
        } else {
            try {
                this.qdq = new bw(this.qdj);
                this.qdq.qdW = new bq() { // from class: com.win.opensdk.ah.4
                    @Override // com.win.opensdk.bq
                    public final void eKp() {
                        ah.this.qer.sendEmptyMessageDelayed(100151, ah.this.java * 1000);
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [251=4] */
                    @Override // com.win.opensdk.bq
                    public final void eKq() {
                        ah.this.qer.removeMessages(100151);
                        ah.a(ah.this, info2, ah.this.qdq);
                        w.iM(ah.this.qdj).a(new x(ah.this.qdE), 200, System.currentTimeMillis() - ah.this.qdF).eKp();
                        w.iM(ah.this.qdj).a(new x(info2)).eKp();
                        ah.a(ah.this);
                        z.b(ah.this.qdE);
                    }
                };
                this.qdq.qdX = new bo() { // from class: com.win.opensdk.ah.5
                    @Override // com.win.opensdk.bo
                    public final boolean hu(String str, String str2) {
                        ah.a(ah.this, info2, str);
                        if (ah.this.qdl != null) {
                            ah.this.qdl.onClicked();
                            return true;
                        }
                        return true;
                    }

                    @Override // com.win.opensdk.bo
                    public final void abL(String str) {
                    }
                };
                this.qdq.a(info2.getLoad(), this.qdE);
            } catch (Exception e2) {
            }
        }
        this.qer.sendEmptyMessageDelayed(100152, this.f18case * 1000);
    }

    public ah(Context context, PBBannerView pBBannerView, String str) {
        this.qdj = context;
        this.qeu = pBBannerView;
        this.f19java = str;
        this.qdG = new bj(context);
    }

    final void a(PBError pBError) {
        if (!this.qdm) {
            this.qdm = true;
            if (this.qdl != null) {
                this.qdl.onFail(pBError);
            }
        }
    }

    public final void eKp() {
        if (this.qes == null) {
            this.qes = new ad(this.qdj, this.f19java, e.java);
        }
        this.qdm = false;
        this.qes.qep = this;
        this.qes.eKp();
    }

    @Override // com.win.opensdk.ae
    public final void b(PBError pBError) {
        int andIncrement = this.qev.getAndIncrement();
        this.qer.sendEmptyMessageDelayed(100152, this.f18case * 1000);
        if (andIncrement == 0) {
            a(pBError);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(ah ahVar, final Info info, bn bnVar) {
        char c = 0;
        try {
            if (ahVar.qeu != null && bnVar.eKs().getParent() == null) {
                ahVar.qeu.removeAllViews();
                ahVar.qeu.addView(bnVar.eKs(), new FrameLayout.LayoutParams(-1, -1));
                ImageView imageView = new ImageView(ahVar.qdj);
                int k = bi.k(ahVar.qdj, 15.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, k);
                layoutParams.gravity = 3;
                imageView.setImageResource(d.a.btn_op);
                ahVar.qeu.addView(imageView, layoutParams);
                ImageView imageView2 = new ImageView(ahVar.qdj);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(k, k);
                layoutParams2.gravity = 53;
                imageView2.setImageResource(d.a.btn_close_dark);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.win.opensdk.ah.6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        try {
                            w.iM(ah.this.qdj).c(new x(info)).eKp();
                            if (ah.this.qdl != null) {
                                ah.this.qdl.onClosed();
                            }
                        } catch (Exception e) {
                        }
                        ah.this.qeu.destroy();
                    }
                });
                ahVar.qeu.addView(imageView2, layoutParams2);
            }
            if (ahVar.qeu == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = ahVar.qeu.getLayoutParams();
            String str = ahVar.f19java;
            int[] iArr = new int[2];
            if (ax.abK(str)) {
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
            int k2 = bi.k(ahVar.qdj, iArr[0]);
            int k3 = bi.k(ahVar.qdj, iArr[1]);
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(k2, k3);
            } else {
                layoutParams3.width = k2;
                layoutParams3.height = k3;
            }
            ahVar.qeu.setLayoutParams(layoutParams3);
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void a(ah ahVar) {
        if (ahVar.qdm) {
            return;
        }
        ahVar.qdm = true;
        if (ahVar.qdl == null) {
            return;
        }
        ahVar.qdl.onLoaded();
    }

    static /* synthetic */ void a(ah ahVar, Info info, String str) {
        aw.a(ahVar.qdj, str, info, ahVar.qdG);
        w.iM(ahVar.qdj).a(new x(info), str).eKp();
        ahVar.qer.sendEmptyMessage(100152);
        z.a(ahVar.qdE);
    }
}
