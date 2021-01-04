package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.ar;
import com.win.opensdk.core.Info;
import com.win.opensdk.poseidon.PoseidonH5Activity;
/* loaded from: classes4.dex */
public class cf implements ar.a {

    /* renamed from: case  reason: not valid java name */
    private static final String f50case = cf.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public boolean f14042a;
    public String java;
    public Context qbB;
    public boolean qbE;
    public PBInterstitialListener qbG;
    public bw qbI;
    public Info qbW;
    private long qbX;
    private Handler qcJ = new Handler() { // from class: com.win.opensdk.cf.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                cf.this.f14042a = true;
                cf.this.qcJ.removeMessages(11);
                int i = 0;
                if (cf.this.java()) {
                    i = cf.this.qbW.getWt();
                }
                w.iM(cf.this.qbB).a(new x(cf.this.qbW), 2002, i * 1000).eJL();
                cf.this.qbG.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad qcK;
    public boolean qce;

    public cf(Context context, String str) {
        this.qbB = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.qbW.getId() + this.java)) {
            char c = 65535;
            switch (str2.hashCode()) {
                case -1122984843:
                    if (str2.equals("is_dismiss")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1122893139:
                    if (str2.equals("is_display")) {
                        c = 2;
                        break;
                    }
                    break;
                case 109719091:
                    if (str2.equals("is_click")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.qbG.onClicked();
                    return;
                case 1:
                    this.qbG.onInterstitialDismissed();
                    return;
                case 2:
                    this.qbG.onInterstitialDisplayed();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f14042a = false;
        this.qbW = info;
        this.qbX = System.currentTimeMillis();
        if (eKj()) {
            if (m67a()) {
                this.qbG.onLoaded();
            } else {
                a();
            }
        } else if (m68b()) {
            if (c()) {
                this.qbG.onLoaded();
            } else {
                b();
            }
        } else {
            eJM();
        }
    }

    public final boolean java() {
        return this.qbW != null;
    }

    public final boolean eKj() {
        return java() && this.qbW.getType() == 21;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m67a() {
        return this.qbE && !this.f14042a && java() && !this.qbW.isShown() && this.qbW.isEffective();
    }

    private void eJM() {
        this.qbG.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.qbI = new bw(this.qbB);
        this.qbI.qco = new bq() { // from class: com.win.opensdk.cf.3
            @Override // com.win.opensdk.bq
            public final void eJL() {
            }

            @Override // com.win.opensdk.bq
            public final void eJM() {
                cf.this.qcJ.removeMessages(11);
                cf.this.qbE = true;
                w.iM(cf.this.qbB).a(new x(cf.this.qbW), 200, System.currentTimeMillis() - cf.this.qbX).eJL();
                if (!cf.this.f14042a) {
                    cf.this.qbG.onLoaded();
                }
            }
        };
        this.qbI.a(this.qbW.getLoad(), this.qbW);
        this.qcJ.sendEmptyMessageDelayed(11, this.qbW.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m68b() {
        return java() && this.qbW.getType() == 22;
    }

    public final boolean c() {
        return this.qce && !this.f14042a && java() && !this.qbW.isShown() && this.qbW.isEffective();
    }

    private void b() {
        f.eJK().a(this.qbB, bp.aX(this.qbW.getTraceid(), this.qbW.getId(), this.qbW.getPid()), af.INTERSTITIAL, this.qbW.getLoad(), new bq() { // from class: com.win.opensdk.cf.4
            @Override // com.win.opensdk.bq
            public final void eJL() {
            }

            @Override // com.win.opensdk.bq
            public final void eJM() {
                cf.this.qcJ.removeMessages(11);
                cf.this.qce = true;
                w.iM(cf.this.qbB).a(new x(cf.this.qbW), 200, System.currentTimeMillis() - cf.this.qbX).eJL();
                if (!cf.this.f14042a) {
                    cf.this.qbG.onLoaded();
                }
            }
        });
        this.qcJ.sendEmptyMessageDelayed(11, this.qbW.getWt() * 1000);
    }

    public final void eJL() {
        this.qbW.setShown(true);
        br.eKl().a(bp.aX(this.qbW.getTraceid(), this.qbW.getId(), this.java), this.qbW);
        if (this.qbW.getPid().equals(az.m58c(this.qbB))) {
            PoseidonH5Activity.b(this.qbB, this.qbW, this.java);
        } else {
            H5Activity.a(this.qbB, this.qbW, this.java);
        }
        ar.a(this.qbW.getId() + this.java, this);
    }
}
