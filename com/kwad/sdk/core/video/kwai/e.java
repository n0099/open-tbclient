package com.kwad.sdk.core.video.kwai;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
import com.kwai.video.ksvodplayerkit.KSVodPlayerCoreInitConfig;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class e {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static AtomicBoolean f56445b;

    public static void a(Context context) {
        com.kwad.sdk.core.d.a.a("kp init");
        KSVodPlayerCoreInitConfig.updatePlayerConfig(com.kwad.sdk.core.config.b.g());
        if (!b()) {
            d(context);
        }
        c(context);
    }

    public static boolean a() {
        AtomicBoolean atomicBoolean = f56445b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        f56445b = atomicBoolean2;
        return atomicBoolean2.get();
    }

    public static boolean b() {
        return a.get() || KsAdSDKImpl.get().getIsExternal() || com.kwad.sdk.b.f55654e.booleanValue();
    }

    public static void c(Context context) {
        try {
            d.a(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    public static void d(final Context context) {
        String v;
        String str;
        if (AbiUtil.b()) {
            v = com.kwad.sdk.core.config.b.w();
            if (TextUtils.isEmpty(v)) {
                v = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/so/ks_so-kwaiPlayerArm64v8aRelease-3.3.20.apk";
            }
            str = "kwaiplayer-v8a";
        } else {
            v = com.kwad.sdk.core.config.b.v();
            if (TextUtils.isEmpty(v)) {
                v = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/so/ks_so-kwaiPlayerArmeabiv7aRelease-3.3.20.apk";
            }
            str = "kwaiplayer-v7a";
        }
        com.kwai.sodler.kwai.b.a(context);
        com.kwai.sodler.lib.a.b bVar = new com.kwai.sodler.lib.a.b();
        bVar.f58581c = v;
        bVar.f58583e = true;
        bVar.a = str;
        bVar.f58580b = "3.4";
        bVar.f58585g = true;
        com.kwai.sodler.kwai.b.a(str, bVar, new b.a() { // from class: com.kwad.sdk.core.video.kwai.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar) {
                super.a(hVar);
                e.a.set(false);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, PluginError pluginError) {
                e.a.set(false);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, g gVar) {
                e.a.set(true);
                e.c(context);
                e.e();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void b(h hVar) {
                super.b(hVar);
            }
        });
    }

    public static void e() {
    }
}
