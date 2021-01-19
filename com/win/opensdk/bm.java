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
    public boolean f13729a;
    public String java;
    public Context pYJ;
    public boolean pYM;
    public bw pYQ;
    public c pYW;
    private Handler pZR = new Handler() { // from class: com.win.opensdk.bm.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                bm.this.f13729a = true;
                bm.this.pZR.removeMessages(11);
                int i = 0;
                if (bm.this.java()) {
                    i = bm.this.pZe.getWt();
                }
                w.iK(bm.this.pYJ).a(new x(bm.this.pZe), 2002, i * 1000).eGz();
                bm.this.pYW.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad pZS;
    public Info pZe;
    private long pZf;
    public boolean pZm;

    public bm(Context context, String str) {
        this.pYJ = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        long j;
        if (TextUtils.equals(str, this.pZe.getId() + this.java)) {
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
                    this.pYW.onClicked();
                    return;
                case 1:
                    this.pYW.exY();
                    return;
                case 2:
                    this.pYW.exZ();
                    return;
                case 3:
                    if (av.iJ(this.pYJ)) {
                        if (obj != null) {
                            try {
                                j = ((Long) obj).longValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                j = 0;
                            }
                            if (j <= 0) {
                                this.pYW.r(false, j);
                                return;
                            } else {
                                this.pYW.r(true, j);
                                return;
                            }
                        }
                        this.pYW.r(false, 0L);
                        return;
                    }
                    this.pYW.r(false, 0L);
                    return;
                case 4:
                    if (av.iJ(this.pYJ)) {
                        if (obj != null) {
                            this.pYW.YC((String) obj);
                            return;
                        }
                        this.pYW.YC(PBError.UNKNOWN.getMsg());
                        return;
                    }
                    this.pYW.YC(PBError.NO_NETWORK.getMsg());
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f13729a = false;
        this.pZe = info;
        this.pZf = System.currentTimeMillis();
        if (eGX()) {
            if (m71a()) {
                this.pYW.onLoaded();
            } else {
                a();
            }
        } else if (m72b()) {
            if (c()) {
                this.pYW.onLoaded();
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
        return java() && this.pZe.getType() == 41;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m71a() {
        return this.pYM && !this.f13729a && java() && !this.pZe.isShown() && this.pZe.isEffective();
    }

    private void eGA() {
        this.pYW.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.pYQ = new bw(this.pYJ);
        this.pYQ.pZw = new bq() { // from class: com.win.opensdk.bm.3
            @Override // com.win.opensdk.bq
            public final void eGz() {
            }

            @Override // com.win.opensdk.bq
            public final void eGA() {
                bm.this.pZR.removeMessages(11);
                bm.this.pYM = true;
                w.iK(bm.this.pYJ).a(new x(bm.this.pZe), 200, System.currentTimeMillis() - bm.this.pZf).eGz();
                if (!bm.this.f13729a) {
                    bm.this.pYW.onLoaded();
                }
            }
        };
        this.pYQ.a(this.pZe.getLoad(), this.pZe);
        this.pZR.sendEmptyMessageDelayed(11, this.pZe.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m72b() {
        return java() && this.pZe.getType() == 42;
    }

    public final boolean c() {
        return this.pZm && !this.f13729a && java() && !this.pZe.isShown() && this.pZe.isEffective();
    }

    private void b() {
        f.eGy().a(this.pYJ, bp.aW(this.pZe.getTraceid(), this.pZe.getId(), this.pZe.getPid()), af.Video, this.pZe.getLoad(), new bq() { // from class: com.win.opensdk.bm.4
            @Override // com.win.opensdk.bq
            public final void eGz() {
            }

            @Override // com.win.opensdk.bq
            public final void eGA() {
                bm.this.pZR.removeMessages(11);
                bm.this.pZm = true;
                w.iK(bm.this.pYJ).a(new x(bm.this.pZe), 200, System.currentTimeMillis() - bm.this.pZf).eGz();
                if (!bm.this.f13729a) {
                    bm.this.pYW.onLoaded();
                }
            }
        });
        this.pZR.sendEmptyMessageDelayed(11, this.pZe.getWt() * 1000);
    }

    public final void eGz() {
        this.pZe.setShown(true);
        br.eGZ().a(bp.aW(this.pZe.getTraceid(), this.pZe.getId(), this.java), this.pZe);
        H5Activity.a(this.pYJ, this.pZe, this.java);
        ar.a(this.pZe.getId() + this.java, this);
    }
}
