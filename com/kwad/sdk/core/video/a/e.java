package com.kwad.sdk.core.video.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.crash.utils.AbiUtil;
import com.kwai.sodler.lib.a.b;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
import com.kwai.video.ksvodplayerkit.j;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f9453a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private static AtomicBoolean f9454b;

    public static void a(Context context) {
        com.kwad.sdk.core.d.a.b("KwaiPlayHelper", "initConfigSync()");
        j.a(com.kwad.sdk.core.config.c.o());
        if (!b()) {
            d(context);
        }
        c(context);
    }

    public static boolean a() {
        if (f9454b != null) {
            return f9454b.get();
        }
        try {
            if (Class.forName("com.kwai.video.player.KsMediaMeta") != null) {
                f9454b = new AtomicBoolean(true);
                return true;
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        f9454b = new AtomicBoolean(false);
        return false;
    }

    public static boolean b() {
        return f9453a.get() || KsAdSDKImpl.get().getIsExternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            d.a(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    private static void d(final Context context) {
        final String Z;
        final String str;
        if (AbiUtil.b()) {
            Z = com.kwad.sdk.core.config.c.aa();
            if (TextUtils.isEmpty(Z)) {
                Z = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-kwaiPlayerArm64v8aRelease-3.3.9.apk";
            }
            str = "kwaiplayer-v8a";
        } else {
            Z = com.kwad.sdk.core.config.c.Z();
            if (TextUtils.isEmpty(Z)) {
                Z = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-kwaiPlayerArmeabiv7aRelease-3.3.9.apk";
            }
            str = "kwaiplayer-v7a";
        }
        com.kwai.sodler.a.b.a(context);
        com.kwai.sodler.a.b.a(new b.a() { // from class: com.kwad.sdk.core.video.a.e.1
            @Override // com.kwai.sodler.lib.a.b.a
            public com.kwai.sodler.lib.b.b a(String str2) {
                com.kwai.sodler.lib.b.b bVar = new com.kwai.sodler.lib.b.b();
                bVar.c = Z;
                bVar.e = true;
                bVar.f11003a = str;
                bVar.f11004b = "3.0";
                bVar.g = true;
                return bVar;
            }
        });
        com.kwai.sodler.a.b.a(str, new b.a() { // from class: com.kwad.sdk.core.video.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar) {
                super.a(hVar);
                e.f9453a.set(false);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, PluginError pluginError) {
                e.f9453a.set(false);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, g gVar) {
                e.f9453a.set(true);
                e.c(context);
                e.e();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void b(h hVar) {
                super.b(hVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
    }
}
