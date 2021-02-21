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
    private boolean qjQ;
    private Context qjn;
    public ae<Info> qkt;
    private al.a qku;

    /* renamed from: java  reason: collision with other field name */
    private static final String f9java = ad.class.getSimpleName();
    private static int java = 100101;
    private boolean qjq = false;
    private Handler qkv = new Handler(Looper.getMainLooper()) { // from class: com.win.opensdk.ad.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == ad.java) {
                ad.this.qkv.removeMessages(ad.java);
                int iT = az.iT(ad.this.qjn) * 1000;
                w.a iN = w.iN(ad.this.qjn);
                x xVar = new x(null);
                xVar.java = ad.this.f11case;
                iN.a(xVar, iT, 2002, 0).eIX();
                ad.this.a(PBError.TIMEOUT);
            }
        }
    };
    private ac qks = new ac();

    public ad(Context context, String str, int i) {
        this.f13720a = 5;
        this.qjn = context;
        this.f11case = str;
        this.f10case = i;
        this.f13720a = az.iT(context);
    }

    public final void eIX() {
        b();
        this.qjQ = false;
        if (!ax.bI(this.qjn, this.f11case)) {
            w.iN(this.qjn).abW(this.f11case).eIX();
            a(PBError.PID_INVALID);
            return;
        }
        Info eJi = this.qks.eJi();
        if (eJi == null) {
            a();
        } else {
            a(eJi);
        }
    }

    public final void eIY() {
        try {
            if (this.qku != null) {
                this.qku.a(null);
            }
            if (this.qkv != null) {
                this.qkv.removeCallbacksAndMessages(null);
            }
            if (this.qks != null) {
                this.qks.eIX();
            }
            if (this.qkt != null) {
                this.qkt = null;
            }
        } catch (Exception e) {
        }
    }

    private void a() {
        if (this.qjq) {
            a(PBError.LOAD_TOO_FREQUENTLY);
            return;
        }
        this.qjq = true;
        al.a aVar = new al.a(this.qjn);
        aVar.java = this.f11case;
        this.qku = aVar.a(new r<bh>() { // from class: com.win.opensdk.ad.2
            private long qjJ = 0;

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.win.opensdk.r
            public final /* synthetic */ void bH(bh bhVar) {
                Info info;
                bh bhVar2 = bhVar;
                ad.this.qkv.removeMessages(ad.java);
                ad.this.qjq = false;
                int size = bhVar2.qkr.size();
                long currentTimeMillis = System.currentTimeMillis() - this.qjJ;
                if (size <= 0) {
                    info = null;
                } else {
                    info = bhVar2.qkr.get(0);
                }
                w.a iN = w.iN(ad.this.qjn);
                x xVar = new x(info);
                xVar.java = ad.this.f11case;
                iN.a(xVar, currentTimeMillis, 200, size).eIX();
                ad.a(ad.this, bhVar2);
                if (ad.this.qks == null || ad.this.qks.java()) {
                    ad.this.a(PBError.NO_FILL);
                } else if (!ad.this.qjQ) {
                    Info eJi = ad.this.qks.eJi();
                    if (eJi != null) {
                        ad.this.a(eJi);
                    } else {
                        ad.this.a(PBError.NO_FILL);
                    }
                }
            }

            @Override // com.win.opensdk.r
            public final void eIX() {
                this.qjJ = System.currentTimeMillis();
                ad.this.qkv.sendEmptyMessageDelayed(ad.java, ad.this.f13720a * 1000);
            }

            @Override // com.win.opensdk.r
            public final void ck(int i, String str) {
                long currentTimeMillis = System.currentTimeMillis() - this.qjJ;
                w.a iN = w.iN(ad.this.qjn);
                x xVar = new x(null);
                xVar.java = ad.this.f11case;
                iN.a(xVar, currentTimeMillis, i, 0).eIX();
                ad.this.qkv.removeMessages(ad.java);
                ad.this.qjq = false;
                ad.this.a(ad.Se(i));
            }
        });
        if (this.f10case == e.java) {
            this.qku.eIY();
        } else if (this.f10case == e.f54case) {
            this.qku.a();
        } else if (this.f10case == e.f13747a) {
            this.qku.eIX();
        } else if (this.f10case == e.f13748b) {
            this.qku.b();
        } else if (this.f10case == e.c) {
            this.qku.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final PBError pBError) {
        if (!this.qjQ) {
            this.qjQ = true;
            bb.C(new Runnable() { // from class: com.win.opensdk.ad.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (ad.this.qkt != null) {
                        ad.this.qkt.b(pBError);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Info info) {
        if (!this.qjQ) {
            this.qjQ = true;
            bb.C(new Runnable() { // from class: com.win.opensdk.ad.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (ad.this.qkt != null) {
                        ad.this.qkt.bH(info);
                    }
                }
            });
        }
    }

    private void b() {
        bb.C(new Runnable() { // from class: com.win.opensdk.ad.5
            @Override // java.lang.Runnable
            public final void run() {
                if (ad.this.qkt != null) {
                    ae unused = ad.this.qkt;
                }
            }
        });
    }

    static /* synthetic */ void a(ad adVar, bh bhVar) {
        if (bhVar != null) {
            try {
                if (bhVar.qkr != null && bhVar.qkr.size() > 0) {
                    adVar.qks.he(bhVar.qkr);
                }
            } catch (Exception e) {
            }
        }
    }

    static /* synthetic */ PBError Se(int i) {
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
