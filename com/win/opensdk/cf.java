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
    public boolean f13745a;
    public String java;
    public Context qiN;
    public boolean qiQ;
    public PBInterstitialListener qiS;
    public bw qiU;
    private Handler qjV = new Handler() { // from class: com.win.opensdk.cf.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                cf.this.f13745a = true;
                cf.this.qjV.removeMessages(11);
                int i = 0;
                if (cf.this.java()) {
                    i = cf.this.qji.getWt();
                }
                w.iN(cf.this.qiN).a(new x(cf.this.qji), 2002, i * 1000).eIP();
                cf.this.qiS.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad qjW;
    public Info qji;
    private long qjj;
    public boolean qjq;

    public cf(Context context, String str) {
        this.qiN = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.qji.getId() + this.java)) {
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
                    this.qiS.onClicked();
                    return;
                case 1:
                    this.qiS.onInterstitialDismissed();
                    return;
                case 2:
                    this.qiS.onInterstitialDisplayed();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f13745a = false;
        this.qji = info;
        this.qjj = System.currentTimeMillis();
        if (eJn()) {
            if (m74a()) {
                this.qiS.onLoaded();
            } else {
                a();
            }
        } else if (m75b()) {
            if (c()) {
                this.qiS.onLoaded();
            } else {
                b();
            }
        } else {
            eIQ();
        }
    }

    public final boolean java() {
        return this.qji != null;
    }

    public final boolean eJn() {
        return java() && this.qji.getType() == 21;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m74a() {
        return this.qiQ && !this.f13745a && java() && !this.qji.isShown() && this.qji.isEffective();
    }

    private void eIQ() {
        this.qiS.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.qiU = new bw(this.qiN);
        this.qiU.qjA = new bq() { // from class: com.win.opensdk.cf.3
            @Override // com.win.opensdk.bq
            public final void eIP() {
            }

            @Override // com.win.opensdk.bq
            public final void eIQ() {
                cf.this.qjV.removeMessages(11);
                cf.this.qiQ = true;
                w.iN(cf.this.qiN).a(new x(cf.this.qji), 200, System.currentTimeMillis() - cf.this.qjj).eIP();
                if (!cf.this.f13745a) {
                    cf.this.qiS.onLoaded();
                }
            }
        };
        this.qiU.a(this.qji.getLoad(), this.qji);
        this.qjV.sendEmptyMessageDelayed(11, this.qji.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m75b() {
        return java() && this.qji.getType() == 22;
    }

    public final boolean c() {
        return this.qjq && !this.f13745a && java() && !this.qji.isShown() && this.qji.isEffective();
    }

    private void b() {
        f.eIO().a(this.qiN, bp.aX(this.qji.getTraceid(), this.qji.getId(), this.qji.getPid()), af.INTERSTITIAL, this.qji.getLoad(), new bq() { // from class: com.win.opensdk.cf.4
            @Override // com.win.opensdk.bq
            public final void eIP() {
            }

            @Override // com.win.opensdk.bq
            public final void eIQ() {
                cf.this.qjV.removeMessages(11);
                cf.this.qjq = true;
                w.iN(cf.this.qiN).a(new x(cf.this.qji), 200, System.currentTimeMillis() - cf.this.qjj).eIP();
                if (!cf.this.f13745a) {
                    cf.this.qiS.onLoaded();
                }
            }
        });
        this.qjV.sendEmptyMessageDelayed(11, this.qji.getWt() * 1000);
    }

    public final void eIP() {
        this.qji.setShown(true);
        br.eJp().a(bp.aX(this.qji.getTraceid(), this.qji.getId(), this.java), this.qji);
        if (this.qji.getPid().equals(az.m65c(this.qiN))) {
            PoseidonH5Activity.b(this.qiN, this.qji, this.java);
        } else {
            H5Activity.a(this.qiN, this.qji, this.java);
        }
        ar.a(this.qji.getId() + this.java, this);
    }
}
