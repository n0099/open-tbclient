package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.win.opensdk.al;
import com.win.opensdk.core.Info;
import com.win.opensdk.w;
/* loaded from: classes3.dex */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    private int f13720a;

    /* renamed from: case  reason: not valid java name */
    private int f10case;

    /* renamed from: case  reason: not valid java name and collision with other field name */
    private String f11case;
    private Context qiN;
    public ae<Info> qjT;
    private al.a qjU;
    private boolean qjq;

    /* renamed from: java  reason: collision with other field name */
    private static final String f9java = ad.class.getSimpleName();
    private static int java = 100101;
    private boolean qiQ = false;
    private Handler qjV = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ad.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == ad.java) {
                ad.this.qjV.removeMessages(ad.java);
                int iT = az.iT(ad.this.qiN) * 1000;
                w.a iN = w.iN(ad.this.qiN);
                x xVar = new x(null);
                xVar.java = ad.this.f11case;
                iN.a(xVar, iT, 2002, 0).eIP();
                ad.this.a(PBError.TIMEOUT);
            }
        }
    };
    private ac qjS = new ac();

    public ad(Context context, String str, int i) {
        this.f13720a = 5;
        this.qiN = context;
        this.f11case = str;
        this.f10case = i;
        this.f13720a = az.iT(context);
    }

    public final void eIP() {
        b();
        this.qjq = false;
        if (!ax.bJ(this.qiN, this.f11case)) {
            w.iN(this.qiN).abK(this.f11case).eIP();
            a(PBError.PID_INVALID);
            return;
        }
        Info eJa = this.qjS.eJa();
        if (eJa == null) {
            a();
        } else {
            a(eJa);
        }
    }

    public final void eIQ() {
        try {
            if (this.qjU != null) {
                this.qjU.a(null);
            }
            if (this.qjV != null) {
                this.qjV.removeCallbacksAndMessages(null);
            }
            if (this.qjS != null) {
                this.qjS.eIP();
            }
            if (this.qjT != null) {
                this.qjT = null;
            }
        } catch (Exception e) {
        }
    }

    private void a() {
        if (this.qiQ) {
            a(PBError.LOAD_TOO_FREQUENTLY);
            return;
        }
        this.qiQ = true;
        al.a aVar = new al.a(this.qiN);
        aVar.java = this.f11case;
        this.qjU = aVar.a(new r<bh>() { // from class: com.win.opensdk.ad.2
            private long qjj = 0;

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.win.opensdk.r
            public final /* synthetic */ void bH(bh bhVar) {
                Info info;
                bh bhVar2 = bhVar;
                ad.this.qjV.removeMessages(ad.java);
                ad.this.qiQ = false;
                int size = bhVar2.qjR.size();
                long currentTimeMillis = System.currentTimeMillis() - this.qjj;
                if (size <= 0) {
                    info = null;
                } else {
                    info = bhVar2.qjR.get(0);
                }
                w.a iN = w.iN(ad.this.qiN);
                x xVar = new x(info);
                xVar.java = ad.this.f11case;
                iN.a(xVar, currentTimeMillis, 200, size).eIP();
                ad.a(ad.this, bhVar2);
                if (ad.this.qjS == null || ad.this.qjS.java()) {
                    ad.this.a(PBError.NO_FILL);
                } else if (!ad.this.qjq) {
                    Info eJa = ad.this.qjS.eJa();
                    if (eJa != null) {
                        ad.this.a(eJa);
                    } else {
                        ad.this.a(PBError.NO_FILL);
                    }
                }
            }

            @Override // com.win.opensdk.r
            public final void eIP() {
                this.qjj = System.currentTimeMillis();
                ad.this.qjV.sendEmptyMessageDelayed(ad.java, ad.this.f13720a * 1000);
            }

            @Override // com.win.opensdk.r
            public final void ck(int i, String str) {
                long currentTimeMillis = System.currentTimeMillis() - this.qjj;
                w.a iN = w.iN(ad.this.qiN);
                x xVar = new x(null);
                xVar.java = ad.this.f11case;
                iN.a(xVar, currentTimeMillis, i, 0).eIP();
                ad.this.qjV.removeMessages(ad.java);
                ad.this.qiQ = false;
                ad.this.a(ad.Sd(i));
            }
        });
        if (this.f10case == e.java) {
            this.qjU.eIQ();
        } else if (this.f10case == e.f54case) {
            this.qjU.a();
        } else if (this.f10case == e.f13747a) {
            this.qjU.eIP();
        } else if (this.f10case == e.f13748b) {
            this.qjU.b();
        } else if (this.f10case == e.c) {
            this.qjU.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final PBError pBError) {
        if (!this.qjq) {
            this.qjq = true;
            bb.C(new Runnable() { // from class: com.win.opensdk.ad.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (ad.this.qjT != null) {
                        ad.this.qjT.b(pBError);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Info info) {
        if (!this.qjq) {
            this.qjq = true;
            bb.C(new Runnable() { // from class: com.win.opensdk.ad.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (ad.this.qjT != null) {
                        ad.this.qjT.bH(info);
                    }
                }
            });
        }
    }

    private void b() {
        bb.C(new Runnable() { // from class: com.win.opensdk.ad.5
            @Override // java.lang.Runnable
            public final void run() {
                if (ad.this.qjT != null) {
                    ae unused = ad.this.qjT;
                }
            }
        });
    }

    static /* synthetic */ void a(ad adVar, bh bhVar) {
        if (bhVar != null) {
            try {
                if (bhVar.qjR != null && bhVar.qjR.size() > 0) {
                    adVar.qjS.he(bhVar.qjR);
                }
            } catch (Exception e) {
            }
        }
    }

    static /* synthetic */ PBError Sd(int i) {
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
