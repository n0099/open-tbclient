package com.kwad.sdk.glide.webp;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.crash.utils.AbiUtil;
import com.kwai.sodler.lib.a.b;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f36585a = new AtomicBoolean(false);

    public static void a(Context context) {
        final String Z;
        final String str;
        if (f36585a.get() || KsAdSDKImpl.get().getIsExternal()) {
            return;
        }
        f36585a.set(true);
        if (AbiUtil.b()) {
            Z = com.kwad.sdk.core.config.c.aa();
            if (TextUtils.isEmpty(Z)) {
                Z = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArm64v8aRelease-3.3.9.apk";
            }
            str = "sowebp-v8a";
        } else {
            Z = com.kwad.sdk.core.config.c.Z();
            if (TextUtils.isEmpty(Z)) {
                Z = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArmeabiv7aRelease-3.3.9.apk";
            }
            str = "sowebp-v7a";
        }
        com.kwai.sodler.a.b.a(context);
        com.kwai.sodler.a.b.a(new b.a() { // from class: com.kwad.sdk.glide.webp.e.1
            @Override // com.kwai.sodler.lib.a.b.a
            public com.kwai.sodler.lib.b.b a(String str2) {
                com.kwai.sodler.lib.b.b bVar = new com.kwai.sodler.lib.b.b();
                bVar.f37912c = Z;
                bVar.f37914e = true;
                bVar.f37910a = str;
                bVar.f37911b = "3.0";
                bVar.f37916g = false;
                return bVar;
            }
        });
        com.kwai.sodler.a.b.a(str, new b.a() { // from class: com.kwad.sdk.glide.webp.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar) {
                super.a(hVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, PluginError pluginError) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, g gVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void b(h hVar) {
                super.b(hVar);
            }
        });
    }
}
