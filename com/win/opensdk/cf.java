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
    public Info qjI;
    private long qjJ;
    public boolean qjQ;
    public Context qjn;
    public boolean qjq;
    public PBInterstitialListener qjs;
    public bw qju;
    private Handler qkv = new Handler() { // from class: com.win.opensdk.cf.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                cf.this.f13745a = true;
                cf.this.qkv.removeMessages(11);
                int i = 0;
                if (cf.this.java()) {
                    i = cf.this.qjI.getWt();
                }
                w.iN(cf.this.qjn).a(new x(cf.this.qjI), 2002, i * 1000).eIX();
                cf.this.qjs.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad qkw;

    public cf(Context context, String str) {
        this.qjn = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.qjI.getId() + this.java)) {
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
                    this.qjs.onClicked();
                    return;
                case 1:
                    this.qjs.onInterstitialDismissed();
                    return;
                case 2:
                    this.qjs.onInterstitialDisplayed();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f13745a = false;
        this.qjI = info;
        this.qjJ = System.currentTimeMillis();
        if (eJv()) {
            if (m73a()) {
                this.qjs.onLoaded();
            } else {
                a();
            }
        } else if (m74b()) {
            if (c()) {
                this.qjs.onLoaded();
            } else {
                b();
            }
        } else {
            eIY();
        }
    }

    public final boolean java() {
        return this.qjI != null;
    }

    public final boolean eJv() {
        return java() && this.qjI.getType() == 21;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m73a() {
        return this.qjq && !this.f13745a && java() && !this.qjI.isShown() && this.qjI.isEffective();
    }

    private void eIY() {
        this.qjs.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.qju = new bw(this.qjn);
        this.qju.qka = new bq() { // from class: com.win.opensdk.cf.3
            @Override // com.win.opensdk.bq
            public final void eIX() {
            }

            @Override // com.win.opensdk.bq
            public final void eIY() {
                cf.this.qkv.removeMessages(11);
                cf.this.qjq = true;
                w.iN(cf.this.qjn).a(new x(cf.this.qjI), 200, System.currentTimeMillis() - cf.this.qjJ).eIX();
                if (!cf.this.f13745a) {
                    cf.this.qjs.onLoaded();
                }
            }
        };
        this.qju.a(this.qjI.getLoad(), this.qjI);
        this.qkv.sendEmptyMessageDelayed(11, this.qjI.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m74b() {
        return java() && this.qjI.getType() == 22;
    }

    public final boolean c() {
        return this.qjQ && !this.f13745a && java() && !this.qjI.isShown() && this.qjI.isEffective();
    }

    private void b() {
        f.eIW().a(this.qjn, bp.aX(this.qjI.getTraceid(), this.qjI.getId(), this.qjI.getPid()), af.INTERSTITIAL, this.qjI.getLoad(), new bq() { // from class: com.win.opensdk.cf.4
            @Override // com.win.opensdk.bq
            public final void eIX() {
            }

            @Override // com.win.opensdk.bq
            public final void eIY() {
                cf.this.qkv.removeMessages(11);
                cf.this.qjQ = true;
                w.iN(cf.this.qjn).a(new x(cf.this.qjI), 200, System.currentTimeMillis() - cf.this.qjJ).eIX();
                if (!cf.this.f13745a) {
                    cf.this.qjs.onLoaded();
                }
            }
        });
        this.qkv.sendEmptyMessageDelayed(11, this.qjI.getWt() * 1000);
    }

    public final void eIX() {
        this.qjI.setShown(true);
        br.eJx().a(bp.aX(this.qjI.getTraceid(), this.qjI.getId(), this.java), this.qjI);
        if (this.qjI.getPid().equals(az.m64c(this.qjn))) {
            PoseidonH5Activity.b(this.qjn, this.qjI, this.java);
        } else {
            H5Activity.a(this.qjn, this.qjI, this.java);
        }
        ar.a(this.qjI.getId() + this.java, this);
    }
}
