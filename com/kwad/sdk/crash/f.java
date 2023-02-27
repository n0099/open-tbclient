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
/* loaded from: classes8.dex */
public final class f {
    public static final AtomicBoolean ISLOADED = new AtomicBoolean(false);

    /* loaded from: classes8.dex */
    public interface a {
        void wu();
    }

    public static void a(Context context, com.kwai.sodler.lib.c.b bVar, @Nullable final a aVar) {
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.crash.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0651b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.c cVar) {
                super.a((AnonymousClass1) cVar);
                com.kwad.sdk.core.e.b.d("ExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0651b, com.kwai.sodler.lib.ext.b
            /* renamed from: c */
            public void b(com.kwai.sodler.lib.b.c cVar) {
                super.b(cVar);
                com.kwad.sdk.core.e.b.d("ExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
            }

            private void qB() {
                com.kwad.sdk.core.e.b.d("ExceptionSoLoadHelper", "onPostLoad thread=" + Thread.currentThread().getName());
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.wu();
                }
            }

            private void wH() {
                com.kwad.sdk.core.e.b.d("ExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName());
            }

            @Override // com.kwai.sodler.lib.ext.b.C0651b, com.kwai.sodler.lib.ext.b
            public final /* synthetic */ void a(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar2) {
                qB();
            }

            @Override // com.kwai.sodler.lib.ext.b.C0651b, com.kwai.sodler.lib.ext.b
            public final /* synthetic */ void a(com.kwai.sodler.lib.a.f fVar, PluginError pluginError) {
                wH();
            }
        });
    }

    public static void a(@NonNull b bVar, @Nullable a aVar) {
        String str;
        String str2;
        if (ISLOADED.get()) {
            aVar.wu();
            return;
        }
        Context context = bVar.context;
        ISLOADED.set(true);
        if (AbiUtil.isArm64(context)) {
            str = bVar.agP;
            if (TextUtils.isEmpty(str)) {
                str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-exceptionArm64v8aRelease-3.3.23.apk";
            }
            str2 = "exception-v8a";
        } else {
            str = bVar.agQ;
            if (TextUtils.isEmpty(str)) {
                str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-exceptionArmeabiv7aRelease-3.3.23.apk";
            }
            str2 = "exception-v7a";
        }
        com.kwai.sodler.lib.c.b bVar2 = new com.kwai.sodler.lib.c.b();
        bVar2.ayA = com.kwad.sdk.core.network.idc.a.tH().bZ(str);
        bVar2.Dv = true;
        bVar2.ayz = str2;
        bVar2.version = Constants.SDK_VER;
        bVar2.ayD = false;
        a(context, bVar2, aVar);
    }
}
