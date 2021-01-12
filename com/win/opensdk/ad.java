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
    private int f13718a;

    /* renamed from: case  reason: not valid java name */
    private int f10case;

    /* renamed from: case  reason: not valid java name and collision with other field name */
    private String f11case;
    private Context pYI;
    public ae<Info> pZO;
    private al.a pZP;
    private boolean pZl;

    /* renamed from: java  reason: collision with other field name */
    private static final String f9java = ad.class.getSimpleName();
    private static int java = 100101;
    private boolean pYL = false;
    private Handler pZQ = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ad.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == ad.java) {
                ad.this.pZQ.removeMessages(ad.java);
                int iQ = az.iQ(ad.this.pYI) * 1000;
                w.a iK = w.iK(ad.this.pYI);
                x xVar = new x(null);
                xVar.java = ad.this.f11case;
                iK.a(xVar, iQ, 2002, 0).eGz();
                ad.this.a(PBError.TIMEOUT);
            }
        }
    };
    private ac pZN = new ac();

    public ad(Context context, String str, int i) {
        this.f13718a = 5;
        this.pYI = context;
        this.f11case = str;
        this.f10case = i;
        this.f13718a = az.iQ(context);
    }

    public final void eGz() {
        b();
        this.pZl = false;
        if (!ax.bK(this.pYI, this.f11case)) {
            w.iK(this.pYI).aaI(this.f11case).eGz();
            a(PBError.PID_INVALID);
            return;
        }
        Info eGK = this.pZN.eGK();
        if (eGK == null) {
            a();
        } else {
            a(eGK);
        }
    }

    public final void eGA() {
        try {
            if (this.pZP != null) {
                this.pZP.a(null);
            }
            if (this.pZQ != null) {
                this.pZQ.removeCallbacksAndMessages(null);
            }
            if (this.pZN != null) {
                this.pZN.eGz();
            }
            if (this.pZO != null) {
                this.pZO = null;
            }
        } catch (Exception e) {
        }
    }

    private void a() {
        if (this.pYL) {
            a(PBError.LOAD_TOO_FREQUENTLY);
            return;
        }
        this.pYL = true;
        al.a aVar = new al.a(this.pYI);
        aVar.java = this.f11case;
        this.pZP = aVar.a(new r<bh>() { // from class: com.win.opensdk.ad.2
            private long pZe = 0;

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.win.opensdk.r
            public final /* synthetic */ void bH(bh bhVar) {
                Info info;
                bh bhVar2 = bhVar;
                ad.this.pZQ.removeMessages(ad.java);
                ad.this.pYL = false;
                int size = bhVar2.pZM.size();
                long currentTimeMillis = System.currentTimeMillis() - this.pZe;
                if (size <= 0) {
                    info = null;
                } else {
                    info = bhVar2.pZM.get(0);
                }
                w.a iK = w.iK(ad.this.pYI);
                x xVar = new x(info);
                xVar.java = ad.this.f11case;
                iK.a(xVar, currentTimeMillis, 200, size).eGz();
                ad.a(ad.this, bhVar2);
                if (ad.this.pZN == null || ad.this.pZN.java()) {
                    ad.this.a(PBError.NO_FILL);
                } else if (!ad.this.pZl) {
                    Info eGK = ad.this.pZN.eGK();
                    if (eGK != null) {
                        ad.this.a(eGK);
                    } else {
                        ad.this.a(PBError.NO_FILL);
                    }
                }
            }

            @Override // com.win.opensdk.r
            public final void eGz() {
                this.pZe = System.currentTimeMillis();
                ad.this.pZQ.sendEmptyMessageDelayed(ad.java, ad.this.f13718a * 1000);
            }

            @Override // com.win.opensdk.r
            public final void cd(int i, String str) {
                long currentTimeMillis = System.currentTimeMillis() - this.pZe;
                w.a iK = w.iK(ad.this.pYI);
                x xVar = new x(null);
                xVar.java = ad.this.f11case;
                iK.a(xVar, currentTimeMillis, i, 0).eGz();
                ad.this.pZQ.removeMessages(ad.java);
                ad.this.pYL = false;
                ad.this.a(ad.RI(i));
            }
        });
        if (this.f10case == e.java) {
            this.pZP.eGA();
        } else if (this.f10case == e.f54case) {
            this.pZP.a();
        } else if (this.f10case == e.f13745a) {
            this.pZP.eGz();
        } else if (this.f10case == e.f13746b) {
            this.pZP.b();
        } else if (this.f10case == e.c) {
            this.pZP.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final PBError pBError) {
        if (!this.pZl) {
            this.pZl = true;
            bb.D(new Runnable() { // from class: com.win.opensdk.ad.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (ad.this.pZO != null) {
                        ad.this.pZO.b(pBError);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Info info) {
        if (!this.pZl) {
            this.pZl = true;
            bb.D(new Runnable() { // from class: com.win.opensdk.ad.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (ad.this.pZO != null) {
                        ad.this.pZO.bH(info);
                    }
                }
            });
        }
    }

    private void b() {
        bb.D(new Runnable() { // from class: com.win.opensdk.ad.5
            @Override // java.lang.Runnable
            public final void run() {
                if (ad.this.pZO != null) {
                    ae unused = ad.this.pZO;
                }
            }
        });
    }

    static /* synthetic */ void a(ad adVar, bh bhVar) {
        if (bhVar != null) {
            try {
                if (bhVar.pZM != null && bhVar.pZM.size() > 0) {
                    adVar.pZN.hg(bhVar.pZM);
                }
            } catch (Exception e) {
            }
        }
    }

    static /* synthetic */ PBError RI(int i) {
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
