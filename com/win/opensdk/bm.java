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
    private static final String f29case = bm.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public boolean f14029a;
    public String java;
    public Info qdE;
    private long qdF;
    public boolean qdM;
    public Context qdj;
    public boolean qdm;
    public bw qdq;
    public c qdw;
    private Handler qer = new Handler() { // from class: com.win.opensdk.bm.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 11) {
                bm.this.f14029a = true;
                bm.this.qer.removeMessages(11);
                int i = 0;
                if (bm.this.java()) {
                    i = bm.this.qdE.getWt();
                }
                w.iM(bm.this.qdj).a(new x(bm.this.qdE), 2002, i * 1000).eKp();
                bm.this.qdw.onFail(PBError.TIMEOUT);
            }
        }
    };
    public ad qes;

    public bm(Context context, String str) {
        this.qdj = context;
        this.java = str;
    }

    @Override // com.win.opensdk.ar.a
    public final void f(String str, String str2, Object obj) {
        long j;
        if (TextUtils.equals(str, this.qdE.getId() + this.java)) {
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
                    this.qdw.onClicked();
                    return;
                case 1:
                    this.qdw.eBQ();
                    return;
                case 2:
                    this.qdw.eBR();
                    return;
                case 3:
                    if (av.iL(this.qdj)) {
                        if (obj != null) {
                            try {
                                j = ((Long) obj).longValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                j = 0;
                            }
                            if (j <= 0) {
                                this.qdw.r(false, j);
                                return;
                            } else {
                                this.qdw.r(true, j);
                                return;
                            }
                        }
                        this.qdw.r(false, 0L);
                        return;
                    }
                    this.qdw.r(false, 0L);
                    return;
                case 4:
                    if (av.iL(this.qdj)) {
                        if (obj != null) {
                            this.qdw.ZJ((String) obj);
                            return;
                        }
                        this.qdw.ZJ(PBError.UNKNOWN.getMsg());
                        return;
                    }
                    this.qdw.ZJ(PBError.NO_NETWORK.getMsg());
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Info info) {
        this.f14029a = false;
        this.qdE = info;
        this.qdF = System.currentTimeMillis();
        if (eKN()) {
            if (m75a()) {
                this.qdw.onLoaded();
            } else {
                a();
            }
        } else if (m76b()) {
            if (c()) {
                this.qdw.onLoaded();
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
        return java() && this.qdE.getType() == 41;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m75a() {
        return this.qdm && !this.f14029a && java() && !this.qdE.isShown() && this.qdE.isEffective();
    }

    private void eKq() {
        this.qdw.onFail(PBError.PID_TYPE_ERROR);
    }

    private void a() {
        this.qdq = new bw(this.qdj);
        this.qdq.qdW = new bq() { // from class: com.win.opensdk.bm.3
            @Override // com.win.opensdk.bq
            public final void eKp() {
            }

            @Override // com.win.opensdk.bq
            public final void eKq() {
                bm.this.qer.removeMessages(11);
                bm.this.qdm = true;
                w.iM(bm.this.qdj).a(new x(bm.this.qdE), 200, System.currentTimeMillis() - bm.this.qdF).eKp();
                if (!bm.this.f14029a) {
                    bm.this.qdw.onLoaded();
                }
            }
        };
        this.qdq.a(this.qdE.getLoad(), this.qdE);
        this.qer.sendEmptyMessageDelayed(11, this.qdE.getWt() * 1000);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m76b() {
        return java() && this.qdE.getType() == 42;
    }

    public final boolean c() {
        return this.qdM && !this.f14029a && java() && !this.qdE.isShown() && this.qdE.isEffective();
    }

    private void b() {
        f.eKo().a(this.qdj, bp.aX(this.qdE.getTraceid(), this.qdE.getId(), this.qdE.getPid()), af.Video, this.qdE.getLoad(), new bq() { // from class: com.win.opensdk.bm.4
            @Override // com.win.opensdk.bq
            public final void eKp() {
            }

            @Override // com.win.opensdk.bq
            public final void eKq() {
                bm.this.qer.removeMessages(11);
                bm.this.qdM = true;
                w.iM(bm.this.qdj).a(new x(bm.this.qdE), 200, System.currentTimeMillis() - bm.this.qdF).eKp();
                if (!bm.this.f14029a) {
                    bm.this.qdw.onLoaded();
                }
            }
        });
        this.qer.sendEmptyMessageDelayed(11, this.qdE.getWt() * 1000);
    }

    public final void eKp() {
        this.qdE.setShown(true);
        br.eKP().a(bp.aX(this.qdE.getTraceid(), this.qdE.getId(), this.java), this.qdE);
        H5Activity.a(this.qdj, this.qdE, this.java);
        ar.a(this.qdE.getId() + this.java, this);
    }
}
