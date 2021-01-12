package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.ar;
import com.win.opensdk.core.Info;
import com.win.opensdk.poseidon.PoseidonH5Activity;
/* loaded from: classes3.dex */
public class cf implements ar.a {

    /* renamed from: case  reason: not valid java name */
    private static final String f50case = cf.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public boolean f13743a;
    public String java;
    public Context pYI;
    public boolean pYL;
    public PBInterstitialListener pYN;
    public bw pYP;
    private Handler pZQ = new Handler() { // from class: com.win.opensdk.cf.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                cf.this.f13743a = true;
                cf.this.pZQ.removeMessages(11);
                int i = 0;
                if (cf.this.java()) {
                    i = cf.this.pZd.getWt();
                }
                w.iK(cf.this.pYI).a(new x(cf.this.pZd), 2002, i * 1000).eGz();
                cf.this.pYN.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad pZR;
    public Info pZd;
    private long pZe;
    public boolean pZl;

    public cf(Context context, String str) {
        this.pYI = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.pZd.getId() + this.java)) {
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
                    this.pYN.onClicked();
                    return;
                case 1:
                    this.pYN.onInterstitialDismissed();
                    return;
                case 2:
                    this.pYN.onInterstitialDisplayed();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f13743a = false;
        this.pZd = info;
        this.pZe = System.currentTimeMillis();
        if (eGX()) {
            if (m74a()) {
                this.pYN.onLoaded();
            } else {
                a();
            }
        } else if (m75b()) {
            if (c()) {
                this.pYN.onLoaded();
            } else {
                b();
            }
        } else {
            eGA();
        }
    }

    public final boolean java() {
        return this.pZd != null;
    }

    public final boolean eGX() {
        return java() && this.pZd.getType() == 21;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m74a() {
        return this.pYL && !this.f13743a && java() && !this.pZd.isShown() && this.pZd.isEffective();
    }

    private void eGA() {
        this.pYN.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.pYP = new bw(this.pYI);
        this.pYP.pZv = new bq() { // from class: com.win.opensdk.cf.3
            @Override // com.win.opensdk.bq
            public final void eGz() {
            }

            @Override // com.win.opensdk.bq
            public final void eGA() {
                cf.this.pZQ.removeMessages(11);
                cf.this.pYL = true;
                w.iK(cf.this.pYI).a(new x(cf.this.pZd), 200, System.currentTimeMillis() - cf.this.pZe).eGz();
                if (!cf.this.f13743a) {
                    cf.this.pYN.onLoaded();
                }
            }
        };
        this.pYP.a(this.pZd.getLoad(), this.pZd);
        this.pZQ.sendEmptyMessageDelayed(11, this.pZd.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m75b() {
        return java() && this.pZd.getType() == 22;
    }

    public final boolean c() {
        return this.pZl && !this.f13743a && java() && !this.pZd.isShown() && this.pZd.isEffective();
    }

    private void b() {
        f.eGy().a(this.pYI, bp.aW(this.pZd.getTraceid(), this.pZd.getId(), this.pZd.getPid()), af.INTERSTITIAL, this.pZd.getLoad(), new bq() { // from class: com.win.opensdk.cf.4
            @Override // com.win.opensdk.bq
            public final void eGz() {
            }

            @Override // com.win.opensdk.bq
            public final void eGA() {
                cf.this.pZQ.removeMessages(11);
                cf.this.pZl = true;
                w.iK(cf.this.pYI).a(new x(cf.this.pZd), 200, System.currentTimeMillis() - cf.this.pZe).eGz();
                if (!cf.this.f13743a) {
                    cf.this.pYN.onLoaded();
                }
            }
        });
        this.pZQ.sendEmptyMessageDelayed(11, this.pZd.getWt() * 1000);
    }

    public final void eGz() {
        this.pZd.setShown(true);
        br.eGZ().a(bp.aW(this.pZd.getTraceid(), this.pZd.getId(), this.java), this.pZd);
        if (this.pZd.getPid().equals(az.m65c(this.pYI))) {
            PoseidonH5Activity.b(this.pYI, this.pZd, this.java);
        } else {
            H5Activity.a(this.pYI, this.pZd, this.java);
        }
        ar.a(this.pZd.getId() + this.java, this);
    }
}
