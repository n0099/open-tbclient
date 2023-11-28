package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.q;
import java.io.File;
/* loaded from: classes10.dex */
public final class f implements com.kwad.library.solder.lib.a.f {
    public f.a aiV;
    public final Context mContext;

    public f(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static void a(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onPreUpdate state = ").append(eVar.getState());
        eVar.xb().wS().m(eVar);
    }

    public static void b(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onCanceled state = ").append(eVar.getState());
        eVar.bI(0);
        eVar.xb().wS().l(eVar);
    }

    public static void j(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onPostUpdate state = ").append(eVar.getState());
        eVar.xb().wS().n(eVar);
    }

    public static void a(com.kwad.library.solder.lib.a.e eVar, PluginError.UpdateError updateError) {
        new StringBuilder("onError state = ").append(eVar.getState());
        eVar.bI(1);
        eVar.k(updateError);
        eVar.xb().wS().c(eVar, updateError);
    }

    private void a(com.kwad.library.solder.lib.a.e eVar, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("PluginUpdaterImpl", "start download pluginId: " + eVar.xf());
        f.a aVar = this.aiV;
        if (aVar != null) {
            aVar.a(eVar, file);
            Log.i("PluginUpdaterImpl", "finish download pluginId: " + eVar.xf() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        throw new PluginError.UpdateError("update ", 2008);
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final com.kwad.library.solder.lib.a.f a(f.a aVar) {
        this.aiV = aVar;
        return this;
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final void i(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("start update pluginId: ").append(eVar.xf());
        eVar.bE("Update");
        a(eVar);
        if (eVar.xg()) {
            eVar.xb().wR().bx(eVar.xf());
        }
        if (eVar.isCanceled()) {
            b(eVar);
            return;
        }
        try {
            eVar.xb().wR().wM();
            if (eVar.xk()) {
                try {
                    File e = eVar.xb().wR().e(eVar.xl(), false);
                    if (eVar.isCanceled()) {
                        b(eVar);
                        return;
                    }
                    try {
                        q.a(this.mContext, eVar.xl(), e);
                        eVar.bF(e.getAbsolutePath());
                        eVar.bI(3);
                        j(eVar);
                        return;
                    } catch (Throwable th) {
                        a.e("PluginUpdaterImpl", th);
                        a(eVar, new PluginError.UpdateError(th, 2004));
                        return;
                    }
                } catch (Throwable th2) {
                    new StringBuilder("Can not get temp file, error = ").append(th2.getLocalizedMessage());
                    a(eVar, new PluginError.UpdateError(th2, 2003));
                    return;
                }
            }
            StringBuilder sb = new StringBuilder("requestPlugin use online plugin resource version:");
            sb.append(eVar.xf());
            sb.append(", url: ");
            sb.append(eVar.getDownloadUrl());
            try {
                File e2 = eVar.xb().wR().e(eVar.getDownloadUrl(), eVar.xb().wO().xw());
                if (eVar.xm() != null && e2.exists() && TextUtils.equals(ad.ab(e2), eVar.xm())) {
                    eVar.bF(e2.getAbsolutePath());
                    eVar.bI(4);
                    j(eVar);
                    return;
                }
                try {
                    a(eVar, e2);
                    eVar.bF(e2.getAbsolutePath());
                    eVar.bI(4);
                    j(eVar);
                } catch (PluginError.CancelError unused) {
                    b(eVar);
                } catch (PluginError.UpdateError e3) {
                    a.e("PluginUpdaterImpl", "Download plugin fail, error = " + e3.getLocalizedMessage());
                    eVar.k(e3);
                    a(eVar, e3);
                }
            } catch (Throwable th3) {
                a.e("PluginUpdaterImpl", "Can not get temp file, error = " + th3.getLocalizedMessage());
                a(eVar, new PluginError.UpdateError(th3, 2003));
            }
        } catch (Throwable th4) {
            a.e("PluginUpdaterImpl", th4);
            a(eVar, new PluginError.UpdateError(th4, 2005));
        }
    }
}
