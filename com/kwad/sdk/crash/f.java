package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.down.utils.Constants;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class f {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public static void a(Context context, com.kwai.sodler.lib.c.b bVar, @Nullable final a aVar) {
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.crash.f.1
            private void a() {
                com.kwad.sdk.core.d.b.a("ExceptionSoLoadHelper", "onPostLoad thread=" + Thread.currentThread().getName());
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.c cVar) {
                super.a((AnonymousClass1) cVar);
                com.kwad.sdk.core.d.b.a("ExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
            }

            private void b() {
                com.kwad.sdk.core.d.b.a("ExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            public void b(com.kwai.sodler.lib.b.c cVar) {
                super.b((AnonymousClass1) cVar);
                com.kwad.sdk.core.d.b.a("ExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
            }

            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar2) {
                a();
            }

            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            public final /* synthetic */ void a(com.kwai.sodler.lib.a.f fVar, PluginError pluginError) {
                b();
            }
        });
    }

    public static void a(@NonNull b bVar, @Nullable a aVar) {
        String str;
        String str2;
        if (a.get() || bVar.i) {
            aVar.a();
            return;
        }
        Context context = bVar.j;
        a.set(true);
        if (AbiUtil.b(context)) {
            str = bVar.r;
            if (TextUtils.isEmpty(str)) {
                str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-exceptionArm64v8aRelease-3.3.23.apk";
            }
            str2 = "exception-v8a";
        } else {
            str = bVar.s;
            if (TextUtils.isEmpty(str)) {
                str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-exceptionArmeabiv7aRelease-3.3.23.apk";
            }
            str2 = "exception-v7a";
        }
        com.kwai.sodler.lib.c.b bVar2 = new com.kwai.sodler.lib.c.b();
        bVar2.c = com.kwad.sdk.core.network.idc.a.a().a(str);
        bVar2.e = true;
        bVar2.a = str2;
        bVar2.b = Constants.SDK_VER;
        bVar2.g = false;
        a(context, bVar2, aVar);
    }
}
