package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.v;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class d implements com.kwai.sodler.lib.a.d {

    /* renamed from: a  reason: collision with root package name */
    public final Context f37541a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, com.kwai.sodler.lib.a.a> f37542b = new HashMap();

    public d(Context context) {
        this.f37541a = context.getApplicationContext();
    }

    private com.kwai.sodler.lib.a.a a(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar) {
        String e2 = aVar.e();
        File file = new File(e2);
        a.b("Sodler.loader", "Loading plugin, path = " + e2);
        com.kwai.sodler.lib.a.e b2 = fVar.b();
        if (file.exists()) {
            String i = fVar.i();
            String a2 = fVar.a();
            aVar.b(i);
            aVar.a(a2);
            if (b2.e().c(i, a2)) {
                String b3 = b2.e().b(i, a2);
                if (com.kwai.sodler.lib.c.a.b(b3)) {
                    a.b("Sodler.loader", "The current version has been installed before.");
                    aVar.c(b3);
                    com.kwai.sodler.lib.a.a a3 = a(i);
                    if (a3 == null) {
                        a.a("Sodler.loader", "Load plugin from installed path.");
                        aVar.a(this.f37541a, b3);
                        a(i, aVar);
                        return aVar;
                    }
                    a.b("Sodler.loader", "The current plugin has been loaded, id = " + a2);
                    return a3;
                }
            }
            com.kwai.sodler.lib.a.a a4 = a(i);
            if (a4 != null) {
                return a4;
            }
            a.b("Sodler.loader", "Load plugin from dest path.");
            String b4 = b2.e().b(aVar);
            aVar.c(b4);
            a.b("Sodler.loader", "installed ." + b4);
            aVar.a(this.f37541a, b4);
            a(i, aVar);
            if (e2.endsWith(b2.b().e())) {
                com.kwai.sodler.lib.c.a.a(e2);
            }
            return aVar;
        }
        throw new PluginError.LoadError("Apk file not exist.", 3001);
    }

    private void a(com.kwai.sodler.lib.a.f fVar, PluginError pluginError) {
        a.c("Sodler.loader", "onError state = " + fVar.c());
        fVar.a(-5);
        fVar.a(pluginError);
        d(fVar);
    }

    private void b(com.kwai.sodler.lib.a.f fVar) {
        a.c("Sodler.loader", "onPreLoad state = " + fVar.c());
        fVar.b().g().e(fVar);
    }

    private void c(com.kwai.sodler.lib.a.f fVar) {
        a.c("Sodler.loader", "onCanceled state = " + fVar.c());
        fVar.a(-7);
        fVar.b().g().b(fVar);
    }

    private void d(com.kwai.sodler.lib.a.f fVar) {
        PluginError.LoadError loadError;
        a.c("Sodler.loader", "onPostLoad state = " + fVar.c());
        if (fVar.c() == 0) {
            com.kwai.sodler.lib.a.a l = fVar.l();
            if (l != null) {
                fVar.b().g().a(fVar, l);
                return;
            }
            fVar.a(-1);
        }
        if (fVar.g() != null) {
            loadError = new PluginError.LoadError(fVar.g(), 4011);
        } else {
            loadError = new PluginError.LoadError("Can not get plugin instance " + fVar.c(), 4011);
        }
        fVar.b().g().a(fVar, loadError);
    }

    public synchronized com.kwai.sodler.lib.a.a a(String str) {
        com.kwai.sodler.lib.a.a aVar = this.f37542b.get(str);
        if (aVar != null) {
            if (!aVar.b()) {
                return null;
            }
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f0  */
    @Override // com.kwai.sodler.lib.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar) {
        a.b("Sodler.loader", "Loading plugin, id = " + fVar.i());
        fVar.c("Load");
        b(fVar);
        if (fVar.f()) {
            c(fVar);
            return fVar;
        }
        fVar.t();
        com.kwai.sodler.lib.a.a aVar = this.f37542b.get(fVar.i());
        if (aVar != null && aVar.b()) {
            fVar.a((com.kwai.sodler.lib.a.f) aVar);
            a.b("Sodler.loader", "Load plugin success, path = " + aVar.e());
            fVar.a(0);
            d(fVar);
            return fVar;
        }
        a.b("Sodler.loader", "------choose best plugin------------");
        a.b("Sodler.loader", "-------远程存在------------");
        List<com.kwai.sodler.lib.b.a> r = fVar.r();
        com.kwai.sodler.lib.b.b a2 = f.a(this.f37541a, fVar);
        if (a2 == null) {
            fVar.a(-1);
            d(fVar);
            return fVar;
        }
        if (r == null || r.isEmpty()) {
            a.b("Sodler.loader", "-------本地不存在，触发更新------------");
            if (a2.f37534g && !v.b(KsAdSDKImpl.get().getContext())) {
                a(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return fVar;
            }
        } else {
            a.b("Sodler.loader", "-------本地存在------------");
            com.kwai.sodler.lib.b.a aVar2 = null;
            Iterator<com.kwai.sodler.lib.b.a> it = r.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.kwai.sodler.lib.b.a next = it.next();
                if (a2.f37529b.equals(next.f37526b)) {
                    aVar2 = next;
                    break;
                }
            }
            if (aVar2 != null) {
                String b2 = fVar.b().e().b(aVar2.f37525a, aVar2.f37526b);
                fVar.d(b2);
                fVar.e(b2);
                fVar.a(1);
                fVar.b(aVar2.f37526b);
                a.b("Sodler.loader", "-------本地找到--------" + b2);
                if (fVar.c() == 1) {
                    d(fVar);
                    return fVar;
                }
                String k = fVar.k();
                a.b("Sodler.loader", "-------更新成功或者获取到本地成功------------" + k);
                if (TextUtils.isEmpty(k)) {
                    fVar.a(-1);
                    d(fVar);
                    return fVar;
                }
                com.kwai.sodler.lib.a.a a3 = fVar.a(k).a(a2);
                fVar.b(fVar.b().b().a());
                int i = 0;
                while (!fVar.f()) {
                    try {
                        fVar.a((com.kwai.sodler.lib.a.f) a(fVar, a3));
                        a.b("Sodler.loader", "Load plugin success, path = " + k);
                        fVar.a(0);
                        d(fVar);
                        return fVar;
                    } catch (PluginError.InstallError | PluginError.LoadError e2) {
                        a.a("Sodler.loader", e2);
                        try {
                            fVar.h();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Load fail, retry ");
                            int i2 = i + 1;
                            sb.append(i);
                            a.b("Sodler.loader", sb.toString());
                            fVar.c("Retry load " + i2);
                            i = i2;
                        } catch (PluginError.RetryError unused) {
                            a.b("Sodler.loader", "Load plugin fail, error = " + e2.toString());
                            a(fVar, e2);
                            return fVar;
                        }
                    }
                }
                c(fVar);
                return fVar;
            }
            a.b("Sodler.loader", "-------本地需要升级--------");
            if (a2.f37534g && !v.b(KsAdSDKImpl.get().getContext())) {
                a(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return fVar;
            }
        }
        fVar.b().d().a(fVar);
        if (fVar.c() == 1) {
        }
    }

    public synchronized void a(String str, com.kwai.sodler.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.b()) {
                this.f37542b.put(str, aVar);
            }
        }
    }
}
