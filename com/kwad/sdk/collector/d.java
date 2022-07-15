package com.kwad.sdk.collector;

import android.content.Context;
import android.util.Log;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class d {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void a(String str);
    }

    public static void a(Context context, final a aVar) {
        com.kwad.sdk.service.kwai.d dVar;
        String str;
        String str2;
        String str3;
        if (a.get() || (dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)) == null) {
            return;
        }
        if (dVar.d()) {
            b(aVar);
            return;
        }
        a.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        if (AbiUtil.b(context)) {
            hashMap.put("libkwappstatus.so", "40eb0d1d346cab7ced4d02a3065b7a94");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArm64v8aRelease-3.3.14.apk";
            str2 = "kwappstatus-v8a";
            str3 = "c66bf3f78bd997bbd5b6e5038a23dff6";
        } else {
            hashMap.put("libkwappstatus.so", "b60d5c17b0cc4aa03e8180bc5cedaf3d");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArmeabiv7aRelease-3.3.14.apk";
            str2 = "kwappstatus-v7a";
            str3 = "b9c0eff152a62bd5062844255107f3e0";
        }
        com.kwai.sodler.lib.c.b bVar = new com.kwai.sodler.lib.c.b();
        bVar.c = com.kwad.sdk.core.network.idc.a.a().a(str);
        bVar.e = true;
        bVar.a = str2;
        bVar.b = "3";
        bVar.g = false;
        bVar.f = str3;
        bVar.i = hashMap;
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.collector.d.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.c cVar) {
                super.a((AnonymousClass1) cVar);
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.a("load canceled");
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.c cVar, PluginError pluginError) {
                super.a((AnonymousClass1) cVar, pluginError);
                if (a.this != null) {
                    a.this.a(pluginError == null ? "load error" : pluginError.toString());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.c cVar, com.kwai.sodler.lib.h hVar) {
                super.a((AnonymousClass1) cVar, (com.kwai.sodler.lib.b.c) hVar);
                d.b(a.this);
            }
        });
    }

    public static boolean a() {
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class);
        if (dVar == null) {
            return false;
        }
        return a.get() || dVar.d();
    }

    public static void b(a aVar) {
        try {
            System.loadLibrary("kwappstatus");
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.a(Log.getStackTraceString(th));
            }
            com.kwad.sdk.core.d.b.b(th);
            if (th instanceof UnsatisfiedLinkError) {
                return;
            }
            com.kwad.sdk.service.a.a(th);
        }
    }
}
