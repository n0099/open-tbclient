package com.kwad.components.offline.tk.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.storage.swankv.SwanKV;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.y;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.b.c;
import com.kwai.sodler.lib.c.b;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.i;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class a {
    public static long Qz;
    public static final AtomicBoolean Qr = new AtomicBoolean(false);
    public static final String Qs = y.format("lib%s.so", "tk_runtime_v0_0_8");
    public static final String Qt = y.format("lib%s.so", "tk_runtime_lite_v0_0_8");
    public static final String Qu = y.format("lib%s.so", "kwai-v8");
    public static final String Qv = y.format("lib%s.so", "kwai-v8-lite");
    public static final String Qw = y.format("lib%s.so", "kwad-fb");
    public static final String Qx = y.format("lib%s.so", "kwad-yoga");
    public static final String Qy = y.format("lib%s.so", SwanKV.LIB_CPP_SHARED);
    public static Boolean QA = null;

    public static void a(Context context, @NonNull final SoLoadListener soLoadListener) {
        String rK;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (Qr.get()) {
            return;
        }
        Qr.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        boolean useTkLite = useTkLite();
        if (AbiUtil.isArm64(context)) {
            rK = d.rL();
            if (TextUtils.isEmpty(rK)) {
                rK = useTkLite ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.24.2/ks_so-tachikomaLiteArm64v8aRelease-3.3.24.2.apk" : "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.24.2/ks_so-tachikomaArm64v8aRelease-3.3.24.2.apk";
            }
            str = useTkLite ? "sotk-v8a-lite" : "sotk-v8a";
            str2 = useTkLite ? "db892c7b72a9636667bfc8ea7e9df0bc" : "40f3b3b81340519f51bfc19cb9ea2284";
            if (useTkLite) {
                hashMap.put(Qt, "2711ba35c7345099edcc3f4526e0b59d");
                str7 = Qv;
                str8 = "005c29f4f5c26b21923dce9b72a0fc8d";
            } else {
                hashMap.put(Qs, "09a2c11101651aa5e866979ad43f3df0");
                str7 = Qu;
                str8 = "cbed106d3241121e1ccb6a8bc152d53e";
            }
            hashMap.put(str7, str8);
            hashMap.put(Qw, "31f065607e6da6b741330d1df0b35460");
            hashMap.put(Qx, "76308532f64b68fd5a930c42cceec22b");
            str5 = Qy;
            str6 = "6ca7958ee0b0192a7c52c16faffaa8ba";
        } else {
            rK = d.rK();
            if (TextUtils.isEmpty(rK)) {
                rK = useTkLite ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.24.2/ks_so-tachikomaLiteArmeabiv7aRelease-3.3.24.2.apk" : "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.24.2/ks_so-tachikomaArmeabiv7aRelease-3.3.24.2.apk";
            }
            str = useTkLite ? "sotk-v7a-lite" : "sotk-v7a";
            str2 = useTkLite ? "55ecca97822a39bc4b276d645ad35c09" : "9f22c0987957bb7abb016726b088ad78";
            if (useTkLite) {
                hashMap.put(Qt, "d278819f65940c10a8b7313bf606bfff");
                str3 = Qv;
                str4 = "9798330679c11734503264cdfb118e76";
            } else {
                hashMap.put(Qs, "b48f51dc240ddd4ffb5d8c75a5c5c820");
                str3 = Qu;
                str4 = "8674972563d49769d5d9a64744ac5749";
            }
            hashMap.put(str3, str4);
            hashMap.put(Qw, "eff11bebb8a3c872fa30b0484b460d12");
            hashMap.put(Qx, "2c6f402c6a565d2e6912b0013fa59380");
            str5 = Qy;
            str6 = "7cb16c2840085bbdf4be628e6604bac1";
        }
        hashMap.put(str5, str6);
        b bVar = new b();
        bVar.ayA = com.kwad.sdk.core.network.idc.a.tH().bZ(rK);
        bVar.Dv = true;
        bVar.ayz = str;
        bVar.version = useTkLite ? "3.3.24.2-lite" : "3.3.24.2";
        bVar.ayD = false;
        bVar.ayC = str2;
        bVar.ayF = hashMap;
        final com.kwai.sodler.lib.a.a eQ = i.EU().EW().EY().eQ(ITkOfflineCompo.PACKAGE_NAME);
        com.kwad.sdk.core.e.b.d("TkSoLoadHelper", "tkOfflineCompoPlugin: " + eQ);
        if (eQ instanceof com.kwai.sodler.lib.kwai.a) {
            bVar.ayI = ((com.kwai.sodler.lib.kwai.a) eQ).Ff();
        }
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.tk.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0694b, com.kwai.sodler.lib.ext.b
            public void a(c cVar) {
                super.a((AnonymousClass1) cVar);
            }

            private void a(PluginError pluginError) {
                soLoadListener.onFailed(pluginError.getCode(), pluginError);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0694b, com.kwai.sodler.lib.ext.b
            /* renamed from: b */
            public void c(c cVar) {
                super.c((AnonymousClass1) cVar);
                long unused = a.Qz = SystemClock.elapsedRealtime();
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(cVar.Fp()).toJson());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0694b, com.kwai.sodler.lib.ext.b
            /* renamed from: c */
            public void b(c cVar) {
                String str9;
                super.b((AnonymousClass1) cVar);
                if (cVar.getState() == 1) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setRetryCount(cVar.Fp()).setDownloadTime(SystemClock.elapsedRealtime() - a.Qz).setDownloadState(1).toJson());
                    return;
                }
                if (cVar.Fm() != null) {
                    Throwable Fm = cVar.Fm();
                    if (Fm instanceof PluginError) {
                        str9 = String.valueOf(((PluginError) Fm).getCode());
                        TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.Fp()).setErrorReason(str9).setDownloadState(2).toJson());
                    }
                }
                str9 = "other";
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.Fp()).setErrorReason(str9).setDownloadState(2).toJson());
            }

            private void qB() {
                soLoadListener.onLoaded();
            }

            @Override // com.kwai.sodler.lib.ext.b.C0694b, com.kwai.sodler.lib.ext.b
            public final /* synthetic */ void a(f fVar, com.kwai.sodler.lib.a.a aVar) {
                qB();
            }

            @Override // com.kwai.sodler.lib.ext.b.C0694b, com.kwai.sodler.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(f fVar, PluginError pluginError) {
                a(pluginError);
            }
        });
    }

    public static boolean useTkLite() {
        if (QA == null) {
            QA = Boolean.valueOf(d.useTkLite());
        }
        return QA.booleanValue();
    }
}
