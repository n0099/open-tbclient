package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public final class d implements com.kwad.library.solder.lib.a.c {
    public final ConcurrentHashMap<String, com.kwad.library.solder.lib.a.a> aiJ = new ConcurrentHashMap<>();
    public final Context mContext;

    public d(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static void b(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onCanceled state = ").append(eVar.getState());
        eVar.bI(0);
        eVar.xb().wS().l(eVar);
    }

    public static void f(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onPreLoad state = ").append(eVar.getState());
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final synchronized com.kwad.library.solder.lib.a.a bz(String str) {
        com.kwad.library.solder.lib.a.a aVar = this.aiJ.get(str);
        if (aVar != null) {
            if (!aVar.isLoaded()) {
                return null;
            }
        }
        return aVar;
    }

    public static void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
        new StringBuilder("onLoadSuccess state = ").append(eVar.getState());
        eVar.bI(5);
        eVar.xb().wS().b(eVar, aVar);
    }

    public static void b(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
        new StringBuilder("onError state = ").append(eVar.getState());
        eVar.bI(6);
        eVar.k(pluginError);
        eVar.xb().wS().c(eVar, pluginError);
    }

    private synchronized void a(String str, com.kwad.library.solder.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.isLoaded()) {
                this.aiJ.put(str, aVar);
            }
        }
    }

    private com.kwad.library.solder.lib.a.a e(com.kwad.library.solder.lib.a.e eVar) {
        com.kwad.library.solder.lib.a.a a = eVar.bH(eVar.xi()).a(eVar.xn());
        String wZ = a.wZ();
        File file = new File(wZ);
        StringBuilder sb = new StringBuilder("install pluginId: ");
        sb.append(eVar.xf());
        sb.append(", path: ");
        sb.append(wZ);
        com.kwad.library.solder.lib.a.d xb = eVar.xb();
        if (file.exists()) {
            String xf = eVar.xf();
            String version = eVar.getVersion();
            com.kwad.library.solder.lib.a.a bz = bz(xf);
            if (bz != null) {
                new StringBuilder("the current plugin has been loaded, id = ").append(version);
                return bz;
            }
            a.bC(xf);
            a.bB(version);
            if (xb.wR().a(xf, version, eVar.xm())) {
                String C = xb.wR().C(xf, version);
                if (q.fK(C)) {
                    new StringBuilder("The current version has been installed before pluginId: ").append(xf);
                    a.bD(C);
                    a.l(this.mContext, C);
                    a(xf, a);
                    return a;
                }
            }
            new StringBuilder("plugin is not install start install pluginId: ").append(xf);
            String b = xb.wR().b(a);
            a.bD(b);
            a.l(this.mContext, b);
            a(xf, a);
            if (wZ.endsWith(xb.wO().xt())) {
                q.delete(wZ);
            }
            return a;
        }
        throw new PluginError.LoadError("Apk file not exist.", 3001);
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final void d(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("start load pluginId: ").append(eVar.xf());
        eVar.bE("Load");
        f(eVar);
        if (eVar.isCanceled()) {
            b(eVar);
            return;
        }
        com.kwad.library.solder.lib.a.a aVar = this.aiJ.get(eVar.xf());
        if (aVar != null && aVar.isLoaded()) {
            eVar.c(aVar);
            StringBuilder sb = new StringBuilder("load plugin success pluginId: ");
            sb.append(eVar.xf());
            sb.append(", path = ");
            sb.append(aVar.wZ());
            a(eVar, aVar);
            return;
        }
        com.kwad.library.solder.lib.c.b xn = eVar.xn();
        if (xn == null) {
            b(eVar, new PluginError.LoadError("not pluginInfo", 2006));
            return;
        }
        List<com.kwad.library.solder.lib.c.a> xo = eVar.xo();
        com.kwad.library.solder.lib.c.a aVar2 = null;
        if (xo != null && !xo.isEmpty()) {
            for (com.kwad.library.solder.lib.c.a aVar3 : xo) {
                if (eVar.getVersion().equals(aVar3.version)) {
                    aVar2 = aVar3;
                } else {
                    eVar.xb().wR().A(eVar.xf(), aVar3.version);
                }
            }
        }
        if (aVar2 == null) {
            if (!ag.isWifiConnected(this.mContext) && (xn.ajQ || (xn.ajR && eVar.xh() > 0))) {
                b(eVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return;
            }
            try {
                eVar.xb().wQ().i(eVar);
            } catch (Throwable th) {
                b(eVar, new PluginError.UpdateError(th, 2006));
                return;
            }
        } else {
            String C = eVar.xb().wR().C(aVar2.ajM, aVar2.version);
            new StringBuilder("-------本地已存在--------").append(C);
            eVar.bF(C);
            eVar.bG(C);
            eVar.bI(2);
            eVar.bB(aVar2.version);
        }
        if (eVar.getState() != 2 && eVar.getState() != 3 && eVar.getState() != 4) {
            b(eVar, new PluginError.InstallError("state exception", 2002));
            return;
        }
        String xi = eVar.xi();
        StringBuilder sb2 = new StringBuilder("-------更新成功或者获取到本地成功------------pluginId: ");
        sb2.append(eVar.xf());
        sb2.append(", path: ");
        sb2.append(xi);
        if (TextUtils.isEmpty(xi)) {
            b(eVar, new PluginError.LoadError("path not found", 2009));
        } else if (eVar.isCanceled()) {
            b(eVar);
        } else {
            try {
                com.kwad.library.solder.lib.a.a e = e(eVar);
                eVar.c(e);
                StringBuilder sb3 = new StringBuilder("load plugin success pluginId: ");
                sb3.append(eVar.xf());
                sb3.append(", path: ");
                sb3.append(xi);
                a(eVar, e);
            } catch (PluginError.InstallError e2) {
                e = e2;
                b(eVar, e);
            } catch (PluginError.LoadError e3) {
                e = e3;
                b(eVar, e);
            } catch (Throwable th2) {
                a.e("PluginLoaderImpl", "load plugin failed, path = " + xi, th2);
                b(eVar, new PluginError.InstallError("load or install plugin failed:" + th2.getMessage(), 4004));
            }
        }
    }
}
