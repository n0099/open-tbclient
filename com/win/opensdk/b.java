package com.win.opensdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class b {
    private String java;
    private c qjA;
    private bm qjz;

    public b(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.qjz = new bm(applicationContext, str);
        this.qjz.qjA = new c() { // from class: com.win.opensdk.b.1
            @Override // com.win.opensdk.c
            public final void eAy() {
                if (b.this.qjA != null) {
                    b.this.qjA.eAy();
                }
            }

            @Override // com.win.opensdk.c
            public final void eAz() {
                if (b.this.qjA != null) {
                    b.this.qjA.eAz();
                }
            }

            @Override // com.win.opensdk.c
            public final void ZP(String str2) {
                if (b.this.qjA != null) {
                    b.this.qjA.ZP(str2);
                }
            }

            @Override // com.win.opensdk.c
            public final void r(boolean z, long j) {
                if (b.this.qjA != null) {
                    b.this.qjA.r(z, j);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (b.this.qjA != null) {
                    b.this.qjA.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (b.this.qjA != null) {
                    b.this.qjA.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (b.this.qjA != null) {
                    b.this.qjA.onClicked();
                }
            }
        };
    }

    public void load() {
        final bm bmVar = this.qjz;
        if (bmVar.java() && bmVar.qjI.isEffective() && !bmVar.qjI.isShown()) {
            bmVar.a(bmVar.qjI);
            return;
        }
        if (bmVar.qkw == null) {
            bmVar.qkw = new ad(bmVar.qjn, bmVar.java, e.f13748b);
        }
        bmVar.qkw.qkt = new ae<Info>() { // from class: com.win.opensdk.bm.2
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bH(Info info) {
                bmVar.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                bmVar.qjA.onFail(pBError);
            }
        };
        bmVar.qkw.eIX();
    }

    public void a(c cVar) {
        this.qjA = cVar;
    }

    public boolean isReady() {
        bm bmVar = this.qjz;
        return bmVar.m70a() || bmVar.c();
    }

    public void show() {
        bm bmVar = this.qjz;
        if (!av.iM(bmVar.qjn)) {
            if (bmVar.qjA != null) {
                bmVar.qjA.ZP(PBError.NO_NETWORK.getMsg());
            }
        } else if (bmVar.eJv()) {
            if (!bmVar.m70a() || !bmVar.java()) {
                return;
            }
            bmVar.qjq = false;
            bp.eJw().a(bp.aX(bmVar.qjI.getTraceid(), bmVar.qjI.getId(), bmVar.qjI.getPid()), bmVar.qju);
            bmVar.eIX();
        } else if (!bmVar.m71b() || !bmVar.c() || !bmVar.java()) {
        } else {
            bmVar.qjQ = false;
            bmVar.eIX();
        }
    }

    public void destroy() {
        bm bmVar = this.qjz;
        bmVar.f13731a = false;
        bmVar.qjq = false;
        bmVar.qjQ = false;
        if (bmVar.qkw == null) {
            return;
        }
        bmVar.qkw.eIY();
    }
}
