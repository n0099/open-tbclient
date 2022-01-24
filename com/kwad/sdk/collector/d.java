package com.kwad.sdk.collector;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class d {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(String str);
    }

    public static void a(Context context, final a aVar) {
        if (a.get()) {
            return;
        }
        if (KsAdSDKImpl.get().getIsExternal()) {
            b(aVar);
            return;
        }
        a.set(true);
        boolean b2 = AbiUtil.b();
        String str = b2 ? "kwappstatus-v8a" : "kwappstatus-v7a";
        String ad = com.kwad.sdk.core.config.b.ad();
        if (TextUtils.isEmpty(ad)) {
            ad = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArmeabiv7aRelease-3.3.14.apk";
        }
        String ae = com.kwad.sdk.core.config.b.ae();
        if (TextUtils.isEmpty(ae)) {
            ae = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArm64v8aRelease-3.3.14.apk";
        }
        if (b2) {
            ad = ae;
        }
        String ah = com.kwad.sdk.core.config.b.ah();
        if (TextUtils.isEmpty(ah)) {
            ah = "3";
        }
        com.kwai.sodler.kwai.b.a(context);
        com.kwai.sodler.lib.a.b bVar = new com.kwai.sodler.lib.a.b();
        bVar.f58414c = ad;
        bVar.f58416e = true;
        bVar.a = str;
        bVar.f58413b = ah;
        bVar.f58418g = false;
        com.kwai.sodler.kwai.b.a(str, bVar, new b.a() { // from class: com.kwad.sdk.collector.d.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.h hVar) {
                super.a(hVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.h hVar, PluginError pluginError) {
                super.a(hVar, pluginError);
                if (a.this != null) {
                    a.this.a(pluginError == null ? "load error" : pluginError.toString());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.h hVar, com.kwai.sodler.lib.g gVar) {
                super.a(hVar, gVar);
                d.b(a.this);
            }
        });
    }

    public static void b(a aVar) {
        try {
            System.loadLibrary("kwappstatus");
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
            com.kwad.sdk.crash.a.a(th);
        }
        if (aVar != null) {
            aVar.a();
        }
    }
}
