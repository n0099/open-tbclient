package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.ar;
import com.win.opensdk.core.Info;
/* loaded from: classes4.dex */
public class bm implements ar.a {

    /* renamed from: case  reason: not valid java name */
    private static final String f28case = bm.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public boolean f14028a;
    public String java;
    public Context qbB;
    public boolean qbE;
    public bw qbI;
    public c qbO;
    public Info qbW;
    private long qbX;
    private Handler qcJ = new Handler() { // from class: com.win.opensdk.bm.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                bm.this.f14028a = true;
                bm.this.qcJ.removeMessages(11);
                int i = 0;
                if (bm.this.java()) {
                    i = bm.this.qbW.getWt();
                }
                w.iM(bm.this.qbB).a(new x(bm.this.qbW), 2002, i * 1000).eJL();
                bm.this.qbO.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad qcK;
    public boolean qce;

    public bm(Context context, String str) {
        this.qbB = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        long j;
        if (TextUtils.equals(str, this.qbW.getId() + this.java)) {
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
                    this.qbO.onClicked();
                    return;
                case 1:
                    this.qbO.eBm();
                    return;
                case 2:
                    this.qbO.eBn();
                    return;
                case 3:
                    if (av.iL(this.qbB)) {
                        if (obj != null) {
                            try {
                                j = ((Long) obj).longValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                j = 0;
                            }
                            if (j <= 0) {
                                this.qbO.r(false, j);
                                return;
                            } else {
                                this.qbO.r(true, j);
                                return;
                            }
                        }
                        this.qbO.r(false, 0L);
                        return;
                    }
                    this.qbO.r(false, 0L);
                    return;
                case 4:
                    if (av.iL(this.qbB)) {
                        if (obj != null) {
                            this.qbO.ZI((String) obj);
                            return;
                        }
                        this.qbO.ZI(PBError.UNKNOWN.getMsg());
                        return;
                    }
                    this.qbO.ZI(PBError.NO_NETWORK.getMsg());
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f14028a = false;
        this.qbW = info;
        this.qbX = System.currentTimeMillis();
        if (eKj()) {
            if (m64a()) {
                this.qbO.onLoaded();
            } else {
                a();
            }
        } else if (m65b()) {
            if (c()) {
                this.qbO.onLoaded();
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
        return java() && this.qbW.getType() == 41;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m64a() {
        return this.qbE && !this.f14028a && java() && !this.qbW.isShown() && this.qbW.isEffective();
    }

    private void eJM() {
        this.qbO.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.qbI = new bw(this.qbB);
        this.qbI.qco = new bq() { // from class: com.win.opensdk.bm.3
            @Override // com.win.opensdk.bq
            public final void eJL() {
            }

            @Override // com.win.opensdk.bq
            public final void eJM() {
                bm.this.qcJ.removeMessages(11);
                bm.this.qbE = true;
                w.iM(bm.this.qbB).a(new x(bm.this.qbW), 200, System.currentTimeMillis() - bm.this.qbX).eJL();
                if (!bm.this.f14028a) {
                    bm.this.qbO.onLoaded();
                }
            }
        };
        this.qbI.a(this.qbW.getLoad(), this.qbW);
        this.qcJ.sendEmptyMessageDelayed(11, this.qbW.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m65b() {
        return java() && this.qbW.getType() == 42;
    }

    public final boolean c() {
        return this.qce && !this.f14028a && java() && !this.qbW.isShown() && this.qbW.isEffective();
    }

    private void b() {
        f.eJK().a(this.qbB, bp.aX(this.qbW.getTraceid(), this.qbW.getId(), this.qbW.getPid()), af.Video, this.qbW.getLoad(), new bq() { // from class: com.win.opensdk.bm.4
            @Override // com.win.opensdk.bq
            public final void eJL() {
            }

            @Override // com.win.opensdk.bq
            public final void eJM() {
                bm.this.qcJ.removeMessages(11);
                bm.this.qce = true;
                w.iM(bm.this.qbB).a(new x(bm.this.qbW), 200, System.currentTimeMillis() - bm.this.qbX).eJL();
                if (!bm.this.f14028a) {
                    bm.this.qbO.onLoaded();
                }
            }
        });
        this.qcJ.sendEmptyMessageDelayed(11, this.qbW.getWt() * 1000);
    }

    public final void eJL() {
        this.qbW.setShown(true);
        br.eKl().a(bp.aX(this.qbW.getTraceid(), this.qbW.getId(), this.java), this.qbW);
        H5Activity.a(this.qbB, this.qbW, this.java);
        ar.a(this.qbW.getId() + this.java, this);
    }
}
