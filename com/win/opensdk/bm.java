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
    public Context pYI;
    public boolean pYL;
    public bw pYP;
    public c pYV;
    private Handler pZQ = new Handler() { // from class: com.win.opensdk.bm.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                bm.this.f13729a = true;
                bm.this.pZQ.removeMessages(11);
                int i = 0;
                if (bm.this.java()) {
                    i = bm.this.pZd.getWt();
                }
                w.iK(bm.this.pYI).a(new x(bm.this.pZd), 2002, i * 1000).eGz();
                bm.this.pYV.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad pZR;
    public Info pZd;
    private long pZe;
    public boolean pZl;

    public bm(Context context, String str) {
        this.pYI = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        long j;
        if (TextUtils.equals(str, this.pZd.getId() + this.java)) {
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
                    this.pYV.onClicked();
                    return;
                case 1:
                    this.pYV.exY();
                    return;
                case 2:
                    this.pYV.exZ();
                    return;
                case 3:
                    if (av.iJ(this.pYI)) {
                        if (obj != null) {
                            try {
                                j = ((Long) obj).longValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                j = 0;
                            }
                            if (j <= 0) {
                                this.pYV.r(false, j);
                                return;
                            } else {
                                this.pYV.r(true, j);
                                return;
                            }
                        }
                        this.pYV.r(false, 0L);
                        return;
                    }
                    this.pYV.r(false, 0L);
                    return;
                case 4:
                    if (av.iJ(this.pYI)) {
                        if (obj != null) {
                            this.pYV.YB((String) obj);
                            return;
                        }
                        this.pYV.YB(PBError.UNKNOWN.getMsg());
                        return;
                    }
                    this.pYV.YB(PBError.NO_NETWORK.getMsg());
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f13729a = false;
        this.pZd = info;
        this.pZe = System.currentTimeMillis();
        if (eGX()) {
            if (m71a()) {
                this.pYV.onLoaded();
            } else {
                a();
            }
        } else if (m72b()) {
            if (c()) {
                this.pYV.onLoaded();
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
        return java() && this.pZd.getType() == 41;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m71a() {
        return this.pYL && !this.f13729a && java() && !this.pZd.isShown() && this.pZd.isEffective();
    }

    private void eGA() {
        this.pYV.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.pYP = new bw(this.pYI);
        this.pYP.pZv = new bq() { // from class: com.win.opensdk.bm.3
            @Override // com.win.opensdk.bq
            public final void eGz() {
            }

            @Override // com.win.opensdk.bq
            public final void eGA() {
                bm.this.pZQ.removeMessages(11);
                bm.this.pYL = true;
                w.iK(bm.this.pYI).a(new x(bm.this.pZd), 200, System.currentTimeMillis() - bm.this.pZe).eGz();
                if (!bm.this.f13729a) {
                    bm.this.pYV.onLoaded();
                }
            }
        };
        this.pYP.a(this.pZd.getLoad(), this.pZd);
        this.pZQ.sendEmptyMessageDelayed(11, this.pZd.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m72b() {
        return java() && this.pZd.getType() == 42;
    }

    public final boolean c() {
        return this.pZl && !this.f13729a && java() && !this.pZd.isShown() && this.pZd.isEffective();
    }

    private void b() {
        f.eGy().a(this.pYI, bp.aW(this.pZd.getTraceid(), this.pZd.getId(), this.pZd.getPid()), af.Video, this.pZd.getLoad(), new bq() { // from class: com.win.opensdk.bm.4
            @Override // com.win.opensdk.bq
            public final void eGz() {
            }

            @Override // com.win.opensdk.bq
            public final void eGA() {
                bm.this.pZQ.removeMessages(11);
                bm.this.pZl = true;
                w.iK(bm.this.pYI).a(new x(bm.this.pZd), 200, System.currentTimeMillis() - bm.this.pZe).eGz();
                if (!bm.this.f13729a) {
                    bm.this.pYV.onLoaded();
                }
            }
        });
        this.pZQ.sendEmptyMessageDelayed(11, this.pZd.getWt() * 1000);
    }

    public final void eGz() {
        this.pZd.setShown(true);
        br.eGZ().a(bp.aW(this.pZd.getTraceid(), this.pZd.getId(), this.java), this.pZd);
        H5Activity.a(this.pYI, this.pZd, this.java);
        ar.a(this.pZd.getId() + this.java, this);
    }
}
