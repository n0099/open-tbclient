package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.win.opensdk.al;
import com.win.opensdk.core.Info;
import com.win.opensdk.w;
/* loaded from: classes4.dex */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    private int f14018a;

    /* renamed from: case  reason: not valid java name */
    private int f11case;

    /* renamed from: case  reason: not valid java name and collision with other field name */
    private String f12case;
    private boolean qdM;
    private Context qdj;
    public ae<Info> qep;
    private al.a qeq;

    /* renamed from: java  reason: collision with other field name */
    private static final String f10java = ad.class.getSimpleName();
    private static int java = 100101;
    private boolean qdm = false;
    private Handler qer = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ad.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == ad.java) {
                ad.this.qer.removeMessages(ad.java);
                int iS = az.iS(ad.this.qdj) * 1000;
                w.a iM = w.iM(ad.this.qdj);
                x xVar = new x(null);
                xVar.java = ad.this.f12case;
                iM.a(xVar, iS, 2002, 0).eKp();
                ad.this.a(PBError.TIMEOUT);
            }
        }
    };
    private ac qeo = new ac();

    public ad(Context context, String str, int i) {
        this.f14018a = 5;
        this.qdj = context;
        this.f12case = str;
        this.f11case = i;
        this.f14018a = az.iS(context);
    }

    public final void eKp() {
        b();
        this.qdM = false;
        if (!ax.bK(this.qdj, this.f12case)) {
            w.iM(this.qdj).abQ(this.f12case).eKp();
            a(PBError.PID_INVALID);
            return;
        }
        Info eKA = this.qeo.eKA();
        if (eKA == null) {
            a();
        } else {
            a(eKA);
        }
    }

    public final void eKq() {
        try {
            if (this.qeq != null) {
                this.qeq.a(null);
            }
            if (this.qer != null) {
                this.qer.removeCallbacksAndMessages(null);
            }
            if (this.qeo != null) {
                this.qeo.eKp();
            }
            if (this.qep != null) {
                this.qep = null;
            }
        } catch (Exception e) {
        }
    }

    private void a() {
        if (this.qdm) {
            a(PBError.LOAD_TOO_FREQUENTLY);
            return;
        }
        this.qdm = true;
        al.a aVar = new al.a(this.qdj);
        aVar.java = this.f12case;
        this.qeq = aVar.a(new r<bh>() { // from class: com.win.opensdk.ad.2
            private long qdF = 0;

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.win.opensdk.r
            public final /* synthetic */ void bH(bh bhVar) {
                Info info;
                bh bhVar2 = bhVar;
                ad.this.qer.removeMessages(ad.java);
                ad.this.qdm = false;
                int size = bhVar2.qen.size();
                long currentTimeMillis = System.currentTimeMillis() - this.qdF;
                if (size <= 0) {
                    info = null;
                } else {
                    info = bhVar2.qen.get(0);
                }
                w.a iM = w.iM(ad.this.qdj);
                x xVar = new x(info);
                xVar.java = ad.this.f12case;
                iM.a(xVar, currentTimeMillis, 200, size).eKp();
                ad.a(ad.this, bhVar2);
                if (ad.this.qeo == null || ad.this.qeo.java()) {
                    ad.this.a(PBError.NO_FILL);
                } else if (!ad.this.qdM) {
                    Info eKA = ad.this.qeo.eKA();
                    if (eKA != null) {
                        ad.this.a(eKA);
                    } else {
                        ad.this.a(PBError.NO_FILL);
                    }
                }
            }

            @Override // com.win.opensdk.r
            public final void eKp() {
                this.qdF = System.currentTimeMillis();
                ad.this.qer.sendEmptyMessageDelayed(ad.java, ad.this.f14018a * 1000);
            }

            @Override // com.win.opensdk.r
            public final void cc(int i, String str) {
                long currentTimeMillis = System.currentTimeMillis() - this.qdF;
                w.a iM = w.iM(ad.this.qdj);
                x xVar = new x(null);
                xVar.java = ad.this.f12case;
                iM.a(xVar, currentTimeMillis, i, 0).eKp();
                ad.this.qer.removeMessages(ad.java);
                ad.this.qdm = false;
                ad.this.a(ad.Tp(i));
            }
        });
        if (this.f11case == e.java) {
            this.qeq.eKq();
        } else if (this.f11case == e.f55case) {
            this.qeq.a();
        } else if (this.f11case == e.f14045a) {
            this.qeq.eKp();
        } else if (this.f11case == e.f14046b) {
            this.qeq.b();
        } else if (this.f11case == e.c) {
            this.qeq.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final PBError pBError) {
        if (!this.qdM) {
            this.qdM = true;
            bb.D(new Runnable() { // from class: com.win.opensdk.ad.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (ad.this.qep != null) {
                        ad.this.qep.b(pBError);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Info info) {
        if (!this.qdM) {
            this.qdM = true;
            bb.D(new Runnable() { // from class: com.win.opensdk.ad.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (ad.this.qep != null) {
                        ad.this.qep.bH(info);
                    }
                }
            });
        }
    }

    private void b() {
        bb.D(new Runnable() { // from class: com.win.opensdk.ad.5
            @Override // java.lang.Runnable
            public final void run() {
                if (ad.this.qep != null) {
                    ae unused = ad.this.qep;
                }
            }
        });
    }

    static /* synthetic */ void a(ad adVar, bh bhVar) {
        if (bhVar != null) {
            try {
                if (bhVar.qen != null && bhVar.qen.size() > 0) {
                    adVar.qeo.hg(bhVar.qen);
                }
            } catch (Exception e) {
            }
        }
    }

    static /* synthetic */ PBError Tp(int i) {
        switch (i) {
            case 100:
            case 101:
                return PBError.SERVER_ERROR;
            case 406:
            case 2003:
                return PBError.PID_INVALID;
            default:
                return PBError.UNKNOWN;
        }
    }
}
