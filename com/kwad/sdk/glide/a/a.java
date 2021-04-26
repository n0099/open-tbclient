package com.kwad.sdk.glide.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.crash.utils.AbiUtil;
import com.kwai.sodler.a.b;
import com.kwai.sodler.lib.a.b;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f34136a = new AtomicBoolean(false);

    public static void a(Context context) {
        final String t;
        final String str;
        if (f34136a.get() || KsAdSDKImpl.get().getIsExternal()) {
            return;
        }
        f34136a.set(true);
        if (AbiUtil.b()) {
            t = c.u();
            if (TextUtils.isEmpty(t)) {
                t = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArm64v8aRelease-3.3.9.apk";
            }
            str = "sowebp-v8a";
        } else {
            t = c.t();
            if (TextUtils.isEmpty(t)) {
                t = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArmeabiv7aRelease-3.3.9.apk";
            }
            str = "sowebp-v7a";
        }
        b.a(context);
        b.a(new b.a() { // from class: com.kwad.sdk.glide.a.a.1
            @Override // com.kwai.sodler.lib.a.b.a
            public com.kwai.sodler.lib.b.b a(String str2) {
                com.kwai.sodler.lib.b.b bVar = new com.kwai.sodler.lib.b.b();
                bVar.f35254c = t;
                bVar.f35256e = true;
                bVar.f35252a = str;
                bVar.f35253b = "3.0";
                bVar.f35258g = false;
                return bVar;
            }
        });
        com.kwai.sodler.a.b.a(str, new b.a() { // from class: com.kwad.sdk.glide.a.a.2
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
