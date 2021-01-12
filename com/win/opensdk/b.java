package com.win.opensdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class b {
    private String java;
    private bm pYU;
    private c pYV;

    public b(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.pYU = new bm(applicationContext, str);
        this.pYU.pYV = new c() { // from class: com.win.opensdk.b.1
            @Override // com.win.opensdk.c
            public final void exY() {
                if (b.this.pYV != null) {
                    b.this.pYV.exY();
                }
            }

            @Override // com.win.opensdk.c
            public final void exZ() {
                if (b.this.pYV != null) {
                    b.this.pYV.exZ();
                }
            }

            @Override // com.win.opensdk.c
            public final void YB(String str2) {
                if (b.this.pYV != null) {
                    b.this.pYV.YB(str2);
                }
            }

            @Override // com.win.opensdk.c
            public final void r(boolean z, long j) {
                if (b.this.pYV != null) {
                    b.this.pYV.r(z, j);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (b.this.pYV != null) {
                    b.this.pYV.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (b.this.pYV != null) {
                    b.this.pYV.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (b.this.pYV != null) {
                    b.this.pYV.onClicked();
                }
            }
        };
    }

    public void load() {
        final bm bmVar = this.pYU;
        if (bmVar.java() && bmVar.pZd.isEffective() && !bmVar.pZd.isShown()) {
            bmVar.a(bmVar.pZd);
            return;
        }
        if (bmVar.pZR == null) {
            bmVar.pZR = new ad(bmVar.pYI, bmVar.java, e.f13746b);
        }
        bmVar.pZR.pZO = new ae<Info>() { // from class: com.win.opensdk.bm.2
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bH(Info info) {
                bmVar.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                bmVar.pYV.onFail(pBError);
            }
        };
        bmVar.pZR.eGz();
    }

    public void a(c cVar) {
        this.pYV = cVar;
    }

    public boolean isReady() {
        bm bmVar = this.pYU;
        return bmVar.m71a() || bmVar.c();
    }

    public void show() {
        bm bmVar = this.pYU;
        if (!av.iJ(bmVar.pYI)) {
            if (bmVar.pYV != null) {
                bmVar.pYV.YB(PBError.NO_NETWORK.getMsg());
            }
        } else if (bmVar.eGX()) {
            if (!bmVar.m71a() || !bmVar.java()) {
                return;
            }
            bmVar.pYL = false;
            bp.eGY().a(bp.aW(bmVar.pZd.getTraceid(), bmVar.pZd.getId(), bmVar.pZd.getPid()), bmVar.pYP);
            bmVar.eGz();
        } else if (!bmVar.m72b() || !bmVar.c() || !bmVar.java()) {
        } else {
            bmVar.pZl = false;
            bmVar.eGz();
        }
    }

    public void destroy() {
        bm bmVar = this.pYU;
        bmVar.f13729a = false;
        bmVar.pYL = false;
        bmVar.pZl = false;
        if (bmVar.pZR == null) {
            return;
        }
        bmVar.pZR.eGA();
    }
}
