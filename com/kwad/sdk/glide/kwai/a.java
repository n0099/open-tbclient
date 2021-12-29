package com.kwad.sdk.glide.kwai;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    public static void a(Context context) {
        String v;
        String str;
        if (a.get() || KsAdSDKImpl.get().getIsExternal()) {
            return;
        }
        a.set(true);
        if (AbiUtil.b()) {
            v = b.w();
            if (TextUtils.isEmpty(v)) {
                v = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArm64v8aRelease-3.3.9.apk";
            }
            str = "sowebp-v8a";
        } else {
            v = b.v();
            if (TextUtils.isEmpty(v)) {
                v = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArmeabiv7aRelease-3.3.9.apk";
            }
            str = "sowebp-v7a";
        }
        com.kwai.sodler.kwai.b.a(context);
        com.kwai.sodler.lib.a.b bVar = new com.kwai.sodler.lib.a.b();
        bVar.f60665c = v;
        bVar.f60667e = true;
        bVar.a = str;
        bVar.f60664b = "3.0";
        bVar.f60669g = false;
        com.kwai.sodler.kwai.b.a(str, bVar, new b.a() { // from class: com.kwad.sdk.glide.kwai.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar) {
                super.a(hVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, PluginError pluginError) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, g gVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void b(h hVar) {
                super.b(hVar);
            }
        });
    }
}
