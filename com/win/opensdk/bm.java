package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.ar;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class bm implements ar.a {

    /* renamed from: case  reason: not valid java name */
    private static final String f28case = bm.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public boolean f13731a;
    public String java;
    public c qjA;
    public Info qjI;
    private long qjJ;
    public boolean qjQ;
    public Context qjn;
    public boolean qjq;
    public bw qju;
    private Handler qkv = new Handler() { // from class: com.win.opensdk.bm.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                bm.this.f13731a = true;
                bm.this.qkv.removeMessages(11);
                int i = 0;
                if (bm.this.java()) {
                    i = bm.this.qjI.getWt();
                }
                w.iN(bm.this.qjn).a(new x(bm.this.qjI), 2002, i * 1000).eIX();
                bm.this.qjA.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad qkw;

    public bm(Context context, String str) {
        this.qjn = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        long j;
        if (TextUtils.equals(str, this.qjI.getId() + this.java)) {
            char c = 65535;
            switch (str2.hashCode()) {
                case -1398725913:
                    if (str2.equals("VIDEO_USER_EARNED_REWARD")) {
                        c = 3;
                        break;
                    }
                    break;
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
                case -707154884:
                    if (str2.equals("VIDEO_SHOW_FAIL")) {
                        c = 4;
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
                    this.qjA.onClicked();
                    return;
                case 1:
                    this.qjA.eAy();
                    return;
                case 2:
                    this.qjA.eAz();
                    return;
                case 3:
                    if (av.iM(this.qjn)) {
                        if (obj != null) {
                            try {
                                j = ((Long) obj).longValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                j = 0;
                            }
                            if (j <= 0) {
                                this.qjA.r(false, j);
                                return;
                            } else {
                                this.qjA.r(true, j);
                                return;
                            }
                        }
                        this.qjA.r(false, 0L);
                        return;
                    }
                    this.qjA.r(false, 0L);
                    return;
                case 4:
                    if (av.iM(this.qjn)) {
                        if (obj != null) {
                            this.qjA.ZP((String) obj);
                            return;
                        }
                        this.qjA.ZP(PBError.UNKNOWN.getMsg());
                        return;
                    }
                    this.qjA.ZP(PBError.NO_NETWORK.getMsg());
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f13731a = false;
        this.qjI = info;
        this.qjJ = System.currentTimeMillis();
        if (eJv()) {
            if (m70a()) {
                this.qjA.onLoaded();
            } else {
                a();
            }
        } else if (m71b()) {
            if (c()) {
                this.qjA.onLoaded();
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
        return java() && this.qjI.getType() == 41;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m70a() {
        return this.qjq && !this.f13731a && java() && !this.qjI.isShown() && this.qjI.isEffective();
    }

    private void eIY() {
        this.qjA.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.qju = new bw(this.qjn);
        this.qju.qka = new bq() { // from class: com.win.opensdk.bm.3
            @Override // com.win.opensdk.bq
            public final void eIX() {
            }

            @Override // com.win.opensdk.bq
            public final void eIY() {
                bm.this.qkv.removeMessages(11);
                bm.this.qjq = true;
                w.iN(bm.this.qjn).a(new x(bm.this.qjI), 200, System.currentTimeMillis() - bm.this.qjJ).eIX();
                if (!bm.this.f13731a) {
                    bm.this.qjA.onLoaded();
                }
            }
        };
        this.qju.a(this.qjI.getLoad(), this.qjI);
        this.qkv.sendEmptyMessageDelayed(11, this.qjI.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m71b() {
        return java() && this.qjI.getType() == 42;
    }

    public final boolean c() {
        return this.qjQ && !this.f13731a && java() && !this.qjI.isShown() && this.qjI.isEffective();
    }

    private void b() {
        f.eIW().a(this.qjn, bp.aX(this.qjI.getTraceid(), this.qjI.getId(), this.qjI.getPid()), af.Video, this.qjI.getLoad(), new bq() { // from class: com.win.opensdk.bm.4
            @Override // com.win.opensdk.bq
            public final void eIX() {
            }

            @Override // com.win.opensdk.bq
            public final void eIY() {
                bm.this.qkv.removeMessages(11);
                bm.this.qjQ = true;
                w.iN(bm.this.qjn).a(new x(bm.this.qjI), 200, System.currentTimeMillis() - bm.this.qjJ).eIX();
                if (!bm.this.f13731a) {
                    bm.this.qjA.onLoaded();
                }
            }
        });
        this.qkv.sendEmptyMessageDelayed(11, this.qjI.getWt() * 1000);
    }

    public final void eIX() {
        this.qjI.setShown(true);
        br.eJx().a(bp.aX(this.qjI.getTraceid(), this.qjI.getId(), this.java), this.qjI);
        H5Activity.a(this.qjn, this.qjI, this.java);
        ar.a(this.qjI.getId() + this.java, this);
    }
}
