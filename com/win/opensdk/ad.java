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
    private int f14017a;

    /* renamed from: case  reason: not valid java name */
    private int f10case;

    /* renamed from: case  reason: not valid java name and collision with other field name */
    private String f11case;
    private Context qbB;
    public ae<Info> qcH;
    private al.a qcI;
    private boolean qce;

    /* renamed from: java  reason: collision with other field name */
    private static final String f9java = ad.class.getSimpleName();
    private static int java = 100101;
    private boolean qbE = false;
    private Handler qcJ = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ad.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == ad.java) {
                ad.this.qcJ.removeMessages(ad.java);
                int iS = az.iS(ad.this.qbB) * 1000;
                w.a iM = w.iM(ad.this.qbB);
                x xVar = new x(null);
                xVar.java = ad.this.f11case;
                iM.a(xVar, iS, 2002, 0).eJL();
                ad.this.a(PBError.TIMEOUT);
            }
        }
    };
    private ac qcG = new ac();

    public ad(Context context, String str, int i) {
        this.f14017a = 5;
        this.qbB = context;
        this.f11case = str;
        this.f10case = i;
        this.f14017a = az.iS(context);
    }

    public final void eJL() {
        b();
        this.qce = false;
        if (!ax.bK(this.qbB, this.f11case)) {
            w.iM(this.qbB).abP(this.f11case).eJL();
            a(PBError.PID_INVALID);
            return;
        }
        Info eJW = this.qcG.eJW();
        if (eJW == null) {
            a();
        } else {
            a(eJW);
        }
    }

    public final void eJM() {
        try {
            if (this.qcI != null) {
                this.qcI.a(null);
            }
            if (this.qcJ != null) {
                this.qcJ.removeCallbacksAndMessages(null);
            }
            if (this.qcG != null) {
                this.qcG.eJL();
            }
            if (this.qcH != null) {
                this.qcH = null;
            }
        } catch (Exception e) {
        }
    }

    private void a() {
        if (this.qbE) {
            a(PBError.LOAD_TOO_FREQUENTLY);
            return;
        }
        this.qbE = true;
        al.a aVar = new al.a(this.qbB);
        aVar.java = this.f11case;
        this.qcI = aVar.a(new r<bh>() { // from class: com.win.opensdk.ad.2
            private long qbX = 0;

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.win.opensdk.r
            public final /* synthetic */ void bG(bh bhVar) {
                Info info;
                bh bhVar2 = bhVar;
                ad.this.qcJ.removeMessages(ad.java);
                ad.this.qbE = false;
                int size = bhVar2.qcF.size();
                long currentTimeMillis = System.currentTimeMillis() - this.qbX;
                if (size <= 0) {
                    info = null;
                } else {
                    info = bhVar2.qcF.get(0);
                }
                w.a iM = w.iM(ad.this.qbB);
                x xVar = new x(info);
                xVar.java = ad.this.f11case;
                iM.a(xVar, currentTimeMillis, 200, size).eJL();
                ad.a(ad.this, bhVar2);
                if (ad.this.qcG == null || ad.this.qcG.java()) {
                    ad.this.a(PBError.NO_FILL);
                } else if (!ad.this.qce) {
                    Info eJW = ad.this.qcG.eJW();
                    if (eJW != null) {
                        ad.this.a(eJW);
                    } else {
                        ad.this.a(PBError.NO_FILL);
                    }
                }
            }

            @Override // com.win.opensdk.r
            public final void eJL() {
                this.qbX = System.currentTimeMillis();
                ad.this.qcJ.sendEmptyMessageDelayed(ad.java, ad.this.f14017a * 1000);
            }

            @Override // com.win.opensdk.r
            public final void cc(int i, String str) {
                long currentTimeMillis = System.currentTimeMillis() - this.qbX;
                w.a iM = w.iM(ad.this.qbB);
                x xVar = new x(null);
                xVar.java = ad.this.f11case;
                iM.a(xVar, currentTimeMillis, i, 0).eJL();
                ad.this.qcJ.removeMessages(ad.java);
                ad.this.qbE = false;
                ad.this.a(ad.SZ(i));
            }
        });
        if (this.f10case == e.java) {
            this.qcI.eJM();
        } else if (this.f10case == e.f54case) {
            this.qcI.a();
        } else if (this.f10case == e.f14044a) {
            this.qcI.eJL();
        } else if (this.f10case == e.f14045b) {
            this.qcI.b();
        } else if (this.f10case == e.c) {
            this.qcI.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final PBError pBError) {
        if (!this.qce) {
            this.qce = true;
            bb.D(new Runnable() { // from class: com.win.opensdk.ad.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (ad.this.qcH != null) {
                        ad.this.qcH.b(pBError);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Info info) {
        if (!this.qce) {
            this.qce = true;
            bb.D(new Runnable() { // from class: com.win.opensdk.ad.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (ad.this.qcH != null) {
                        ad.this.qcH.bG(info);
                    }
                }
            });
        }
    }

    private void b() {
        bb.D(new Runnable() { // from class: com.win.opensdk.ad.5
            @Override // java.lang.Runnable
            public final void run() {
                if (ad.this.qcH != null) {
                    ae unused = ad.this.qcH;
                }
            }
        });
    }

    static /* synthetic */ void a(ad adVar, bh bhVar) {
        if (bhVar != null) {
            try {
                if (bhVar.qcF != null && bhVar.qcF.size() > 0) {
                    adVar.qcG.hf(bhVar.qcF);
                }
            } catch (Exception e) {
            }
        }
    }

    static /* synthetic */ PBError SZ(int i) {
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
