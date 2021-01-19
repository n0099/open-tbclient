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
    public Context pYJ;
    public boolean pYM;
    public PBInterstitialListener pYO;
    public bw pYQ;
    private Handler pZR = new Handler() { // from class: com.win.opensdk.cf.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                cf.this.f13743a = true;
                cf.this.pZR.removeMessages(11);
                int i = 0;
                if (cf.this.java()) {
                    i = cf.this.pZe.getWt();
                }
                w.iK(cf.this.pYJ).a(new x(cf.this.pZe), 2002, i * 1000).eGz();
                cf.this.pYO.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad pZS;
    public Info pZe;
    private long pZf;
    public boolean pZm;

    public cf(Context context, String str) {
        this.pYJ = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.pZe.getId() + this.java)) {
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
                    this.pYO.onClicked();
                    return;
                case 1:
                    this.pYO.onInterstitialDismissed();
                    return;
                case 2:
                    this.pYO.onInterstitialDisplayed();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f13743a = false;
        this.pZe = info;
        this.pZf = System.currentTimeMillis();
        if (eGX()) {
            if (m74a()) {
                this.pYO.onLoaded();
            } else {
                a();
            }
        } else if (m75b()) {
            if (c()) {
                this.pYO.onLoaded();
            } else {
                b();
            }
        } else {
            eGA();
        }
    }

    public final boolean java() {
        return this.pZe != null;
    }

    public final boolean eGX() {
        return java() && this.pZe.getType() == 21;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m74a() {
        return this.pYM && !this.f13743a && java() && !this.pZe.isShown() && this.pZe.isEffective();
    }

    private void eGA() {
        this.pYO.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.pYQ = new bw(this.pYJ);
        this.pYQ.pZw = new bq() { // from class: com.win.opensdk.cf.3
            @Override // com.win.opensdk.bq
            public final void eGz() {
            }

            @Override // com.win.opensdk.bq
            public final void eGA() {
                cf.this.pZR.removeMessages(11);
                cf.this.pYM = true;
                w.iK(cf.this.pYJ).a(new x(cf.this.pZe), 200, System.currentTimeMillis() - cf.this.pZf).eGz();
                if (!cf.this.f13743a) {
                    cf.this.pYO.onLoaded();
                }
            }
        };
        this.pYQ.a(this.pZe.getLoad(), this.pZe);
        this.pZR.sendEmptyMessageDelayed(11, this.pZe.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m75b() {
        return java() && this.pZe.getType() == 22;
    }

    public final boolean c() {
        return this.pZm && !this.f13743a && java() && !this.pZe.isShown() && this.pZe.isEffective();
    }

    private void b() {
        f.eGy().a(this.pYJ, bp.aW(this.pZe.getTraceid(), this.pZe.getId(), this.pZe.getPid()), af.INTERSTITIAL, this.pZe.getLoad(), new bq() { // from class: com.win.opensdk.cf.4
            @Override // com.win.opensdk.bq
            public final void eGz() {
            }

            @Override // com.win.opensdk.bq
            public final void eGA() {
                cf.this.pZR.removeMessages(11);
                cf.this.pZm = true;
                w.iK(cf.this.pYJ).a(new x(cf.this.pZe), 200, System.currentTimeMillis() - cf.this.pZf).eGz();
                if (!cf.this.f13743a) {
                    cf.this.pYO.onLoaded();
                }
            }
        });
        this.pZR.sendEmptyMessageDelayed(11, this.pZe.getWt() * 1000);
    }

    public final void eGz() {
        this.pZe.setShown(true);
        br.eGZ().a(bp.aW(this.pZe.getTraceid(), this.pZe.getId(), this.java), this.pZe);
        if (this.pZe.getPid().equals(az.m65c(this.pYJ))) {
            PoseidonH5Activity.b(this.pYJ, this.pZe, this.java);
        } else {
            H5Activity.a(this.pYJ, this.pZe, this.java);
        }
        ar.a(this.pZe.getId() + this.java, this);
    }
}
