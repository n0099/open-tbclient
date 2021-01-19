package com.win.opensdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class b {
    private String java;
    private bm pYV;
    private c pYW;

    public b(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.pYV = new bm(applicationContext, str);
        this.pYV.pYW = new c() { // from class: com.win.opensdk.b.1
            @Override // com.win.opensdk.c
            public final void exY() {
                if (b.this.pYW != null) {
                    b.this.pYW.exY();
                }
            }

            @Override // com.win.opensdk.c
            public final void exZ() {
                if (b.this.pYW != null) {
                    b.this.pYW.exZ();
                }
            }

            @Override // com.win.opensdk.c
            public final void YC(String str2) {
                if (b.this.pYW != null) {
                    b.this.pYW.YC(str2);
                }
            }

            @Override // com.win.opensdk.c
            public final void r(boolean z, long j) {
                if (b.this.pYW != null) {
                    b.this.pYW.r(z, j);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (b.this.pYW != null) {
                    b.this.pYW.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (b.this.pYW != null) {
                    b.this.pYW.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (b.this.pYW != null) {
                    b.this.pYW.onClicked();
                }
            }
        };
    }

    public void load() {
        final bm bmVar = this.pYV;
        if (bmVar.java() && bmVar.pZe.isEffective() && !bmVar.pZe.isShown()) {
            bmVar.a(bmVar.pZe);
            return;
        }
        if (bmVar.pZS == null) {
            bmVar.pZS = new ad(bmVar.pYJ, bmVar.java, e.f13746b);
        }
        bmVar.pZS.pZP = new ae<Info>() { // from class: com.win.opensdk.bm.2
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bH(Info info) {
                bmVar.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                bmVar.pYW.onFail(pBError);
            }
        };
        bmVar.pZS.eGz();
    }

    public void a(c cVar) {
        this.pYW = cVar;
    }

    public boolean isReady() {
        bm bmVar = this.pYV;
        return bmVar.m71a() || bmVar.c();
    }

    public void show() {
        bm bmVar = this.pYV;
        if (!av.iJ(bmVar.pYJ)) {
            if (bmVar.pYW != null) {
                bmVar.pYW.YC(PBError.NO_NETWORK.getMsg());
            }
        } else if (bmVar.eGX()) {
            if (!bmVar.m71a() || !bmVar.java()) {
                return;
            }
            bmVar.pYM = false;
            bp.eGY().a(bp.aW(bmVar.pZe.getTraceid(), bmVar.pZe.getId(), bmVar.pZe.getPid()), bmVar.pYQ);
            bmVar.eGz();
        } else if (!bmVar.m72b() || !bmVar.c() || !bmVar.java()) {
        } else {
            bmVar.pZm = false;
            bmVar.eGz();
        }
    }

    public void destroy() {
        bm bmVar = this.pYV;
        bmVar.f13729a = false;
        bmVar.pYM = false;
        bmVar.pZm = false;
        if (bmVar.pZS == null) {
            return;
        }
        bmVar.pZS.eGA();
    }
}
