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
    private static final String f51case = cf.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public boolean f14043a;
    public String java;
    public Info qdE;
    private long qdF;
    public boolean qdM;
    public Context qdj;
    public boolean qdm;
    public PBInterstitialListener qdo;
    public bw qdq;
    private Handler qer = new Handler() { // from class: com.win.opensdk.cf.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                cf.this.f14043a = true;
                cf.this.qer.removeMessages(11);
                int i = 0;
                if (cf.this.java()) {
                    i = cf.this.qdE.getWt();
                }
                w.iM(cf.this.qdj).a(new x(cf.this.qdE), 2002, i * 1000).eKp();
                cf.this.qdo.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad qes;

    public cf(Context context, String str) {
        this.qdj = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.qdE.getId() + this.java)) {
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
                    this.qdo.onClicked();
                    return;
                case 1:
                    this.qdo.onInterstitialDismissed();
                    return;
                case 2:
                    this.qdo.onInterstitialDisplayed();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f14043a = false;
        this.qdE = info;
        this.qdF = System.currentTimeMillis();
        if (eKN()) {
            if (m78a()) {
                this.qdo.onLoaded();
            } else {
                a();
            }
        } else if (m79b()) {
            if (c()) {
                this.qdo.onLoaded();
            } else {
                b();
            }
        } else {
            eKq();
        }
    }

    public final boolean java() {
        return this.qdE != null;
    }

    public final boolean eKN() {
        return java() && this.qdE.getType() == 21;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m78a() {
        return this.qdm && !this.f14043a && java() && !this.qdE.isShown() && this.qdE.isEffective();
    }

    private void eKq() {
        this.qdo.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.qdq = new bw(this.qdj);
        this.qdq.qdW = new bq() { // from class: com.win.opensdk.cf.3
            @Override // com.win.opensdk.bq
            public final void eKp() {
            }

            @Override // com.win.opensdk.bq
            public final void eKq() {
                cf.this.qer.removeMessages(11);
                cf.this.qdm = true;
                w.iM(cf.this.qdj).a(new x(cf.this.qdE), 200, System.currentTimeMillis() - cf.this.qdF).eKp();
                if (!cf.this.f14043a) {
                    cf.this.qdo.onLoaded();
                }
            }
        };
        this.qdq.a(this.qdE.getLoad(), this.qdE);
        this.qer.sendEmptyMessageDelayed(11, this.qdE.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m79b() {
        return java() && this.qdE.getType() == 22;
    }

    public final boolean c() {
        return this.qdM && !this.f14043a && java() && !this.qdE.isShown() && this.qdE.isEffective();
    }

    private void b() {
        f.eKo().a(this.qdj, bp.aX(this.qdE.getTraceid(), this.qdE.getId(), this.qdE.getPid()), af.INTERSTITIAL, this.qdE.getLoad(), new bq() { // from class: com.win.opensdk.cf.4
            @Override // com.win.opensdk.bq
            public final void eKp() {
            }

            @Override // com.win.opensdk.bq
            public final void eKq() {
                cf.this.qer.removeMessages(11);
                cf.this.qdM = true;
                w.iM(cf.this.qdj).a(new x(cf.this.qdE), 200, System.currentTimeMillis() - cf.this.qdF).eKp();
                if (!cf.this.f14043a) {
                    cf.this.qdo.onLoaded();
                }
            }
        });
        this.qer.sendEmptyMessageDelayed(11, this.qdE.getWt() * 1000);
    }

    public final void eKp() {
        this.qdE.setShown(true);
        br.eKP().a(bp.aX(this.qdE.getTraceid(), this.qdE.getId(), this.java), this.qdE);
        if (this.qdE.getPid().equals(az.m69c(this.qdj))) {
            PoseidonH5Activity.b(this.qdj, this.qdE, this.java);
        } else {
            H5Activity.a(this.qdj, this.qdE, this.java);
        }
        ar.a(this.qdE.getId() + this.java, this);
    }
}
