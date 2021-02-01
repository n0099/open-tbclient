package com.win.opensdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class b {
    private String java;
    private bm qiZ;
    private c qja;

    public b(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.qiZ = new bm(applicationContext, str);
        this.qiZ.qja = new c() { // from class: com.win.opensdk.b.1
            @Override // com.win.opensdk.c
            public final void eAq() {
                if (b.this.qja != null) {
                    b.this.qja.eAq();
                }
            }

            @Override // com.win.opensdk.c
            public final void eAr() {
                if (b.this.qja != null) {
                    b.this.qja.eAr();
                }
            }

            @Override // com.win.opensdk.c
            public final void ZD(String str2) {
                if (b.this.qja != null) {
                    b.this.qja.ZD(str2);
                }
            }

            @Override // com.win.opensdk.c
            public final void r(boolean z, long j) {
                if (b.this.qja != null) {
                    b.this.qja.r(z, j);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (b.this.qja != null) {
                    b.this.qja.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (b.this.qja != null) {
                    b.this.qja.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (b.this.qja != null) {
                    b.this.qja.onClicked();
                }
            }
        };
    }

    public void load() {
        final bm bmVar = this.qiZ;
        if (bmVar.java() && bmVar.qji.isEffective() && !bmVar.qji.isShown()) {
            bmVar.a(bmVar.qji);
            return;
        }
        if (bmVar.qjW == null) {
            bmVar.qjW = new ad(bmVar.qiN, bmVar.java, e.f13748b);
        }
        bmVar.qjW.qjT = new ae<Info>() { // from class: com.win.opensdk.bm.2
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bH(Info info) {
                bmVar.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                bmVar.qja.onFail(pBError);
            }
        };
        bmVar.qjW.eIP();
    }

    public void a(c cVar) {
        this.qja = cVar;
    }

    public boolean isReady() {
        bm bmVar = this.qiZ;
        return bmVar.m71a() || bmVar.c();
    }

    public void show() {
        bm bmVar = this.qiZ;
        if (!av.iM(bmVar.qiN)) {
            if (bmVar.qja != null) {
                bmVar.qja.ZD(PBError.NO_NETWORK.getMsg());
            }
        } else if (bmVar.eJn()) {
            if (!bmVar.m71a() || !bmVar.java()) {
                return;
            }
            bmVar.qiQ = false;
            bp.eJo().a(bp.aX(bmVar.qji.getTraceid(), bmVar.qji.getId(), bmVar.qji.getPid()), bmVar.qiU);
            bmVar.eIP();
        } else if (!bmVar.m72b() || !bmVar.c() || !bmVar.java()) {
        } else {
            bmVar.qjq = false;
            bmVar.eIP();
        }
    }

    public void destroy() {
        bm bmVar = this.qiZ;
        bmVar.f13731a = false;
        bmVar.qiQ = false;
        bmVar.qjq = false;
        if (bmVar.qjW == null) {
            return;
        }
        bmVar.qjW.eIQ();
    }
}
