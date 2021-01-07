package com.win.opensdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes4.dex */
public class b {
    private String java;
    private bm qdv;
    private c qdw;

    public b(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.qdv = new bm(applicationContext, str);
        this.qdv.qdw = new c() { // from class: com.win.opensdk.b.1
            @Override // com.win.opensdk.c
            public final void eBQ() {
                if (b.this.qdw != null) {
                    b.this.qdw.eBQ();
                }
            }

            @Override // com.win.opensdk.c
            public final void eBR() {
                if (b.this.qdw != null) {
                    b.this.qdw.eBR();
                }
            }

            @Override // com.win.opensdk.c
            public final void ZJ(String str2) {
                if (b.this.qdw != null) {
                    b.this.qdw.ZJ(str2);
                }
            }

            @Override // com.win.opensdk.c
            public final void r(boolean z, long j) {
                if (b.this.qdw != null) {
                    b.this.qdw.r(z, j);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (b.this.qdw != null) {
                    b.this.qdw.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (b.this.qdw != null) {
                    b.this.qdw.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (b.this.qdw != null) {
                    b.this.qdw.onClicked();
                }
            }
        };
    }

    public void load() {
        final bm bmVar = this.qdv;
        if (bmVar.java() && bmVar.qdE.isEffective() && !bmVar.qdE.isShown()) {
            bmVar.a(bmVar.qdE);
            return;
        }
        if (bmVar.qes == null) {
            bmVar.qes = new ad(bmVar.qdj, bmVar.java, e.f14046b);
        }
        bmVar.qes.qep = new ae<Info>() { // from class: com.win.opensdk.bm.2
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bH(Info info) {
                bmVar.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                bmVar.qdw.onFail(pBError);
            }
        };
        bmVar.qes.eKp();
    }

    public void a(c cVar) {
        this.qdw = cVar;
    }

    public boolean isReady() {
        bm bmVar = this.qdv;
        return bmVar.m75a() || bmVar.c();
    }

    public void show() {
        bm bmVar = this.qdv;
        if (!av.iL(bmVar.qdj)) {
            if (bmVar.qdw != null) {
                bmVar.qdw.ZJ(PBError.NO_NETWORK.getMsg());
            }
        } else if (bmVar.eKN()) {
            if (!bmVar.m75a() || !bmVar.java()) {
                return;
            }
            bmVar.qdm = false;
            bp.eKO().a(bp.aX(bmVar.qdE.getTraceid(), bmVar.qdE.getId(), bmVar.qdE.getPid()), bmVar.qdq);
            bmVar.eKp();
        } else if (!bmVar.m76b() || !bmVar.c() || !bmVar.java()) {
        } else {
            bmVar.qdM = false;
            bmVar.eKp();
        }
    }

    public void destroy() {
        bm bmVar = this.qdv;
        bmVar.f14029a = false;
        bmVar.qdm = false;
        bmVar.qdM = false;
        if (bmVar.qes == null) {
            return;
        }
        bmVar.qes.eKq();
    }
}
