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
    public Context qiN;
    public boolean qiQ;
    public bw qiU;
    private Handler qjV = new Handler() { // from class: com.win.opensdk.bm.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                bm.this.f13731a = true;
                bm.this.qjV.removeMessages(11);
                int i = 0;
                if (bm.this.java()) {
                    i = bm.this.qji.getWt();
                }
                w.iN(bm.this.qiN).a(new x(bm.this.qji), 2002, i * 1000).eIP();
                bm.this.qja.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad qjW;
    public c qja;
    public Info qji;
    private long qjj;
    public boolean qjq;

    public bm(Context context, String str) {
        this.qiN = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        long j;
        if (TextUtils.equals(str, this.qji.getId() + this.java)) {
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
                    this.qja.onClicked();
                    return;
                case 1:
                    this.qja.eAq();
                    return;
                case 2:
                    this.qja.eAr();
                    return;
                case 3:
                    if (av.iM(this.qiN)) {
                        if (obj != null) {
                            try {
                                j = ((Long) obj).longValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                j = 0;
                            }
                            if (j <= 0) {
                                this.qja.r(false, j);
                                return;
                            } else {
                                this.qja.r(true, j);
                                return;
                            }
                        }
                        this.qja.r(false, 0L);
                        return;
                    }
                    this.qja.r(false, 0L);
                    return;
                case 4:
                    if (av.iM(this.qiN)) {
                        if (obj != null) {
                            this.qja.ZD((String) obj);
                            return;
                        }
                        this.qja.ZD(PBError.UNKNOWN.getMsg());
                        return;
                    }
                    this.qja.ZD(PBError.NO_NETWORK.getMsg());
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f13731a = false;
        this.qji = info;
        this.qjj = System.currentTimeMillis();
        if (eJn()) {
            if (m71a()) {
                this.qja.onLoaded();
            } else {
                a();
            }
        } else if (m72b()) {
            if (c()) {
                this.qja.onLoaded();
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
        return java() && this.qji.getType() == 41;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m71a() {
        return this.qiQ && !this.f13731a && java() && !this.qji.isShown() && this.qji.isEffective();
    }

    private void eIQ() {
        this.qja.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.qiU = new bw(this.qiN);
        this.qiU.qjA = new bq() { // from class: com.win.opensdk.bm.3
            @Override // com.win.opensdk.bq
            public final void eIP() {
            }

            @Override // com.win.opensdk.bq
            public final void eIQ() {
                bm.this.qjV.removeMessages(11);
                bm.this.qiQ = true;
                w.iN(bm.this.qiN).a(new x(bm.this.qji), 200, System.currentTimeMillis() - bm.this.qjj).eIP();
                if (!bm.this.f13731a) {
                    bm.this.qja.onLoaded();
                }
            }
        };
        this.qiU.a(this.qji.getLoad(), this.qji);
        this.qjV.sendEmptyMessageDelayed(11, this.qji.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m72b() {
        return java() && this.qji.getType() == 42;
    }

    public final boolean c() {
        return this.qjq && !this.f13731a && java() && !this.qji.isShown() && this.qji.isEffective();
    }

    private void b() {
        f.eIO().a(this.qiN, bp.aX(this.qji.getTraceid(), this.qji.getId(), this.qji.getPid()), af.Video, this.qji.getLoad(), new bq() { // from class: com.win.opensdk.bm.4
            @Override // com.win.opensdk.bq
            public final void eIP() {
            }

            @Override // com.win.opensdk.bq
            public final void eIQ() {
                bm.this.qjV.removeMessages(11);
                bm.this.qjq = true;
                w.iN(bm.this.qiN).a(new x(bm.this.qji), 200, System.currentTimeMillis() - bm.this.qjj).eIP();
                if (!bm.this.f13731a) {
                    bm.this.qja.onLoaded();
                }
            }
        });
        this.qjV.sendEmptyMessageDelayed(11, this.qji.getWt() * 1000);
    }

    public final void eIP() {
        this.qji.setShown(true);
        br.eJp().a(bp.aX(this.qji.getTraceid(), this.qji.getId(), this.java), this.qji);
        H5Activity.a(this.qiN, this.qji, this.java);
        ar.a(this.qji.getId() + this.java, this);
    }
}
