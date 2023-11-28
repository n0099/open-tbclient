package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class g {
    public static final AtomicBoolean aEK = new AtomicBoolean(false);

    /* loaded from: classes10.dex */
    public interface a {
        void Ge();

        void Gf();
    }

    public static void a(Context context, com.kwad.library.solder.lib.c.b bVar, @Nullable final a aVar) {
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.crash.g.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a */
            public void b(com.kwad.library.solder.lib.b.c cVar) {
                super.b(cVar);
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            public void c(com.kwad.library.solder.lib.b.c cVar) {
                super.c((AnonymousClass1) cVar);
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
            }

            private void Gu() {
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName());
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.Gf();
                }
            }

            private void tw() {
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onPostLoad");
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.Ge();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                tw();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                Gu();
            }
        });
    }

    public static void a(@NonNull c cVar, a aVar) {
        String str;
        String str2;
        String str3;
        if (aEK.get()) {
            aVar.Ge();
        } else if (cVar.sdkVersion.compareTo(cVar.aEn) < 0) {
            com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "sdkVersion:" + cVar.sdkVersion + "*supportAppVersion:" + cVar.aEn);
            aVar.Gf();
        } else {
            Context context = cVar.context;
            aEK.set(true);
            if (AbiUtil.isArm64(context)) {
                str = cVar.aEq;
                if (TextUtils.isEmpty(str)) {
                    str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202305301754/ks_so-exceptionArm64v8aRelease-3.3.47-e8fbb3a5f8-666.apk";
                }
                str2 = cVar.aEs;
                str3 = "exception-v8a";
            } else {
                str = cVar.aEr;
                if (TextUtils.isEmpty(str)) {
                    str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202305301754/ks_so-exceptionArmeabiv7aRelease-3.3.47-e8fbb3a5f8-666.apk";
                }
                str2 = cVar.aEt;
                str3 = "exception-v7a";
            }
            com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
            bVar.ajN = com.kwad.sdk.core.network.idc.a.CJ().du(str);
            bVar.Jq = true;
            bVar.ajM = str3;
            bVar.version = cVar.aEm;
            bVar.ajP = str2;
            bVar.ajQ = false;
            a(context, bVar, aVar);
        }
    }
}
