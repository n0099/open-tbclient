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
import com.kwai.video.ksvodplayerkit.KSVodPlayerCoreInitConfig;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f33495a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static AtomicBoolean f33496b;

    public static void a(Context context) {
        com.kwad.sdk.core.d.a.a("kp init");
        KSVodPlayerCoreInitConfig.updatePlayerConfig(com.kwad.sdk.core.config.c.f());
        if (!b()) {
            d(context);
        }
        c(context);
    }

    public static boolean a() {
        AtomicBoolean atomicBoolean = f33496b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        f33496b = new AtomicBoolean(true);
        if (com.kwad.sdk.d.f33864a == 2) {
            try {
                if (Class.forName("com.kwai.video.player.KsMediaMeta") != null) {
                    f33496b = new AtomicBoolean(true);
                    return true;
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
                f33496b = new AtomicBoolean(false);
            }
        }
        return f33496b.get();
    }

    public static boolean b() {
        return f33495a.get() || KsAdSDKImpl.get().getIsExternal();
    }

    public static void c(Context context) {
        try {
            d.a(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    public static void d(final Context context) {
        final String t;
        final String str;
        if (AbiUtil.b()) {
            t = com.kwad.sdk.core.config.c.u();
            if (TextUtils.isEmpty(t)) {
                t = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-kwaiPlayerArm64v8aRelease-3.3.10.3.apk";
            }
            str = "kwaiplayer-v8a";
        } else {
            t = com.kwad.sdk.core.config.c.t();
            if (TextUtils.isEmpty(t)) {
                t = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-kwaiPlayerArmeabiv7aRelease-3.3.10.3.apk";
            }
            str = "kwaiplayer-v7a";
        }
        com.kwai.sodler.a.b.a(context);
        com.kwai.sodler.a.b.a(new b.a() { // from class: com.kwad.sdk.core.video.a.e.1
            @Override // com.kwai.sodler.lib.a.b.a
            public com.kwai.sodler.lib.b.b a(String str2) {
                com.kwai.sodler.lib.b.b bVar = new com.kwai.sodler.lib.b.b();
                bVar.f35254c = t;
                bVar.f35256e = true;
                bVar.f35252a = str;
                bVar.f35253b = "3.2";
                bVar.f35258g = true;
                return bVar;
            }
        });
        com.kwai.sodler.a.b.a(str, new b.a() { // from class: com.kwad.sdk.core.video.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar) {
                super.a(hVar);
                e.f33495a.set(false);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, PluginError pluginError) {
                e.f33495a.set(false);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, g gVar) {
                e.f33495a.set(true);
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

    public static void e() {
    }
}
