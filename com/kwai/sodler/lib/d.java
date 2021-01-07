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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d implements com.kwai.sodler.lib.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11308a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, com.kwai.sodler.lib.a.a> f11309b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        this.f11308a = context.getApplicationContext();
    }

    private com.kwai.sodler.lib.a.a a(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar) {
        String e = aVar.e();
        File file = new File(e);
        a.b("Sodler.loader", "Loading plugin, path = " + e);
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
                    if (a3 != null) {
                        a.b("Sodler.loader", "The current plugin has been loaded, id = " + a2);
                        return a3;
                    }
                    a.a("Sodler.loader", "Load plugin from installed path.");
                    aVar.a(this.f11308a, b3);
                    a(i, aVar);
                    return aVar;
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
            aVar.a(this.f11308a, b4);
            a(i, aVar);
            if (e.endsWith(b2.b().e())) {
                com.kwai.sodler.lib.c.a.a(e);
                return aVar;
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
        a.c("Sodler.loader", "onPostLoad state = " + fVar.c());
        if (fVar.c() == 0) {
            com.kwai.sodler.lib.a.a l = fVar.l();
            if (l != null) {
                fVar.b().g().a(fVar, l);
                return;
            }
            fVar.a(-1);
        }
        fVar.b().g().a(fVar, fVar.g() != null ? new PluginError.LoadError(fVar.g(), (int) PluginError.ERROR_LOA_CREATE_PLUGIN) : new PluginError.LoadError("Can not get plugin instance " + fVar.c(), (int) PluginError.ERROR_LOA_CREATE_PLUGIN));
    }

    public synchronized com.kwai.sodler.lib.a.a a(String str) {
        com.kwai.sodler.lib.a.a aVar;
        aVar = this.f11309b.get(str);
        if (aVar != null) {
            if (!aVar.b()) {
                aVar = null;
            }
        }
        return aVar;
    }

    @Override // com.kwai.sodler.lib.a.d
    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar) {
        PluginError.InstallError installError;
        com.kwai.sodler.lib.b.a aVar;
        int i = 0;
        a.b("Sodler.loader", "Loading plugin, id = " + fVar.i());
        fVar.c("Load");
        b(fVar);
        if (fVar.f()) {
            c(fVar);
        } else {
            fVar.t();
            com.kwai.sodler.lib.a.a aVar2 = this.f11309b.get(fVar.i());
            if (aVar2 == null || !aVar2.b()) {
                a.b("Sodler.loader", "------choose best plugin------------");
                a.b("Sodler.loader", "-------远程存在------------");
                List<com.kwai.sodler.lib.b.a> r = fVar.r();
                com.kwai.sodler.lib.b.b a2 = f.a(this.f11308a, fVar);
                if (a2 == null) {
                    fVar.a(-1);
                    d(fVar);
                } else {
                    if (r == null || r.isEmpty()) {
                        a.b("Sodler.loader", "-------本地不存在，触发更新------------");
                        if (!a2.g || v.b(KsAdSDKImpl.get().getContext())) {
                            fVar.b().d().a(fVar);
                        } else {
                            a(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                        }
                    } else {
                        a.b("Sodler.loader", "-------本地存在------------");
                        Iterator<com.kwai.sodler.lib.b.a> it = r.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                aVar = null;
                                break;
                            }
                            aVar = it.next();
                            if (a2.f11304b.equals(aVar.f11302b)) {
                                break;
                            }
                        }
                        if (aVar == null) {
                            a.b("Sodler.loader", "-------本地需要升级--------");
                            if (!a2.g || v.b(KsAdSDKImpl.get().getContext())) {
                                fVar.b().d().a(fVar);
                            } else {
                                a(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                            }
                        } else {
                            String b2 = fVar.b().e().b(aVar.f11301a, aVar.f11302b);
                            fVar.d(b2);
                            fVar.e(b2);
                            fVar.a(1);
                            fVar.b(aVar.f11302b);
                            a.b("Sodler.loader", "-------本地找到--------" + b2);
                        }
                    }
                    if (fVar.c() == 1) {
                        String k = fVar.k();
                        a.b("Sodler.loader", "-------更新成功或者获取到本地成功------------" + k);
                        if (TextUtils.isEmpty(k)) {
                            fVar.a(-1);
                            d(fVar);
                        } else {
                            com.kwai.sodler.lib.a.a a3 = fVar.a(k).a(a2);
                            fVar.b(fVar.b().b().a());
                            while (true) {
                                int i2 = i;
                                if (fVar.f()) {
                                    c(fVar);
                                    break;
                                }
                                try {
                                    fVar.a((com.kwai.sodler.lib.a.f) a(fVar, a3));
                                    a.b("Sodler.loader", "Load plugin success, path = " + k);
                                    fVar.a(0);
                                    d(fVar);
                                    break;
                                } catch (PluginError.InstallError e) {
                                    installError = e;
                                    a.a("Sodler.loader", installError);
                                    try {
                                        fVar.h();
                                        i = i2 + 1;
                                        a.b("Sodler.loader", "Load fail, retry " + i2);
                                        fVar.c("Retry load " + i);
                                    } catch (PluginError.RetryError e2) {
                                        a.b("Sodler.loader", "Load plugin fail, error = " + installError.toString());
                                        a(fVar, installError);
                                    }
                                } catch (PluginError.LoadError e3) {
                                    installError = e3;
                                    a.a("Sodler.loader", installError);
                                    fVar.h();
                                    i = i2 + 1;
                                    a.b("Sodler.loader", "Load fail, retry " + i2);
                                    fVar.c("Retry load " + i);
                                }
                            }
                        }
                    } else {
                        d(fVar);
                    }
                }
            } else {
                fVar.a((com.kwai.sodler.lib.a.f) aVar2);
                a.b("Sodler.loader", "Load plugin success, path = " + aVar2.e());
                fVar.a(0);
                d(fVar);
            }
        }
        return fVar;
    }

    public synchronized void a(String str, com.kwai.sodler.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.b()) {
                this.f11309b.put(str, aVar);
            }
        }
    }
}
