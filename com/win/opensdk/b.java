package com.win.opensdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes4.dex */
public class b {
    private String java;
    private bm qbN;
    private c qbO;

    public b(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.qbN = new bm(applicationContext, str);
        this.qbN.qbO = new c() { // from class: com.win.opensdk.b.1
            @Override // com.win.opensdk.c
            public final void eBm() {
                if (b.this.qbO != null) {
                    b.this.qbO.eBm();
                }
            }

            @Override // com.win.opensdk.c
            public final void eBn() {
                if (b.this.qbO != null) {
                    b.this.qbO.eBn();
                }
            }

            @Override // com.win.opensdk.c
            public final void ZI(String str2) {
                if (b.this.qbO != null) {
                    b.this.qbO.ZI(str2);
                }
            }

            @Override // com.win.opensdk.c
            public final void r(boolean z, long j) {
                if (b.this.qbO != null) {
                    b.this.qbO.r(z, j);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (b.this.qbO != null) {
                    b.this.qbO.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (b.this.qbO != null) {
                    b.this.qbO.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (b.this.qbO != null) {
                    b.this.qbO.onClicked();
                }
            }
        };
    }

    public void load() {
        final bm bmVar = this.qbN;
        if (bmVar.java() && bmVar.qbW.isEffective() && !bmVar.qbW.isShown()) {
            bmVar.a(bmVar.qbW);
            return;
        }
        if (bmVar.qcK == null) {
            bmVar.qcK = new ad(bmVar.qbB, bmVar.java, e.f14045b);
        }
        bmVar.qcK.qcH = new ae<Info>() { // from class: com.win.opensdk.bm.2
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bG(Info info) {
                bmVar.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                bmVar.qbO.onFail(pBError);
            }
        };
        bmVar.qcK.eJL();
    }

    public void a(c cVar) {
        this.qbO = cVar;
    }

    public boolean isReady() {
        bm bmVar = this.qbN;
        return bmVar.m64a() || bmVar.c();
    }

    public void show() {
        bm bmVar = this.qbN;
        if (!av.iL(bmVar.qbB)) {
            if (bmVar.qbO != null) {
                bmVar.qbO.ZI(PBError.NO_NETWORK.getMsg());
            }
        } else if (bmVar.eKj()) {
            if (!bmVar.m64a() || !bmVar.java()) {
                return;
            }
            bmVar.qbE = false;
            bp.eKk().a(bp.aX(bmVar.qbW.getTraceid(), bmVar.qbW.getId(), bmVar.qbW.getPid()), bmVar.qbI);
            bmVar.eJL();
        } else if (!bmVar.m65b() || !bmVar.c() || !bmVar.java()) {
        } else {
            bmVar.qce = false;
            bmVar.eJL();
        }
    }

    public void destroy() {
        bm bmVar = this.qbN;
        bmVar.f14028a = false;
        bmVar.qbE = false;
        bmVar.qce = false;
        if (bmVar.qcK == null) {
            return;
        }
        bmVar.qcK.eJM();
    }
}
