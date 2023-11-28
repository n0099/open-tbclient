package com.kwad.sdk.kgeo;

import android.content.Context;
import android.os.Build;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.o;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class c {
    public static final AtomicBoolean sHasInit = new AtomicBoolean(false);

    /* loaded from: classes10.dex */
    public interface a {
        void Gf();

        void onSuccess(String str);
    }

    public static void a(final Context context, final a aVar) {
        String str;
        String str2;
        String str3;
        if (au.KK()) {
            aVar.Gf();
        } else if (!o.JI()) {
            aVar.Gf();
        } else if (Build.VERSION.SDK_INT < 23) {
            aVar.Gf();
        } else if (sHasInit.get()) {
        } else {
            sHasInit.set(true);
            boolean isArm64 = AbiUtil.isArm64(context);
            com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
            bVar.version = "1.0.2";
            if (isArm64) {
                str = "kmc-v8a";
            } else {
                str = "kmc-v7a";
            }
            bVar.ajM = str;
            com.kwad.sdk.core.network.idc.a CJ = com.kwad.sdk.core.network.idc.a.CJ();
            if (isArm64) {
                str2 = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac64";
            } else {
                str2 = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac32";
            }
            bVar.ajN = CJ.du(str2);
            if (isArm64) {
                str3 = "db9a8da62a0354ec5710ec03e2743f07";
            } else {
                str3 = "2440a8221230913d4287c6b1e02b49f1";
            }
            bVar.ajP = str3;
            bVar.Jq = true;
            com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.kgeo.c.1
                @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
                public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                    tw();
                }

                private void a(PluginError pluginError) {
                    com.kwad.sdk.core.e.c.d("KGeoSoHelper", "onFail error:" + pluginError.getMessage());
                    a.this.Gf();
                }

                private void tw() {
                    com.kwad.sdk.core.e.c.d("KGeoSoHelper", "onPostLoad");
                    try {
                        System.loadLibrary("ipneigh-android");
                        a.this.onSuccess(com.kwai.library.ipneigh.c.dx(context).aSS);
                    } catch (Throwable unused) {
                        com.kwad.sdk.core.e.c.d("KGeoSoHelper", "loadLibrary fail");
                        a.this.Gf();
                    }
                }

                @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
                public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                    a(pluginError);
                }
            });
        }
    }
}
