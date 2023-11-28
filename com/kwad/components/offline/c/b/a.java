package com.kwad.components.offline.c.b;

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
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aa;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class a {
    public static long ado;
    public static final AtomicBoolean acr = new AtomicBoolean(false);
    public static final String adi = aa.format("lib%s.so", "tk_runtime_v0_0_38");
    public static final String adj = aa.format("lib%s.so", "tk_runtime_lite_v0_0_38");
    public static final String adk = aa.format("lib%s.so", "kwai-v8");
    public static final String adl = aa.format("lib%s.so", "kwai-v8-lite");
    public static final String adm = aa.format("lib%s.so", "kwad-fb");
    public static final String adn = aa.format("lib%s.so", "kwad-yoga");
    public static final String acs = aa.format("lib%s.so", SwanKV.LIB_CPP_SHARED);
    public static Boolean adp = null;

    public static void a(Context context, @NonNull final SoLoadListener soLoadListener) {
        String Az;
        String str;
        String str2;
        String str3;
        if (acr.get()) {
            return;
        }
        acr.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        boolean useTkLite = useTkLite();
        if (AbiUtil.isArm64(context)) {
            Az = d.AA();
            if (TextUtils.isEmpty(Az)) {
                if (useTkLite) {
                    Az = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v8_lite_3334";
                } else {
                    Az = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v8_3334";
                }
            }
            if (useTkLite) {
                str = "sotk-v8a-lite";
            } else {
                str = "sotk-v8a";
            }
            if (useTkLite) {
                str2 = "39df505f83794e951720e9c753824d0c";
            } else {
                str2 = "2c0fb7069df4a3e6fd55e417229bcb6b";
            }
            if (useTkLite) {
                hashMap.put(adj, "a5009e795307441cc05dbd3e8aeaead3");
                hashMap.put(adl, "77545ba1892c1a1d4a039db37b3249eb");
            } else {
                hashMap.put(adi, "e1478b9b4f377d667c7e510e88ae1bcb");
                hashMap.put(adk, "7316cd8d074b04e6cb21486288d314ce");
            }
            hashMap.put(adm, "31f065607e6da6b741330d1df0b35460");
            hashMap.put(adn, "76308532f64b68fd5a930c42cceec22b");
            hashMap.put(acs, "6ca7958ee0b0192a7c52c16faffaa8ba");
        } else {
            Az = d.Az();
            if (TextUtils.isEmpty(Az)) {
                if (useTkLite) {
                    Az = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v7_lite_3334";
                } else {
                    Az = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v7_3334";
                }
            }
            if (useTkLite) {
                str = "sotk-v7a-lite";
            } else {
                str = "sotk-v7a";
            }
            if (useTkLite) {
                str2 = "a46a370ee3a1a61a0d6041b3c69c0ab7";
            } else {
                str2 = "f8d270613187202ab45cfec0dca9deee";
            }
            if (useTkLite) {
                hashMap.put(adj, "8ffd76abe9e5fe33f4035b56b9d6e8e3");
                hashMap.put(adl, "2dbd72527a0739740746adaae48ed2e0");
            } else {
                hashMap.put(adi, "55e6b8f6cd2091d8f8412dafcf9f381a");
                hashMap.put(adk, "519ba633e88efafb8fbd536d800da734");
            }
            hashMap.put(adm, "eff11bebb8a3c872fa30b0484b460d12");
            hashMap.put(adn, "2c6f402c6a565d2e6912b0013fa59380");
            hashMap.put(acs, "7cb16c2840085bbdf4be628e6604bac1");
        }
        b bVar = new b();
        bVar.ajN = com.kwad.sdk.core.network.idc.a.CJ().du(Az);
        bVar.Jq = true;
        bVar.ajM = str;
        if (useTkLite) {
            str3 = "3.3.34-lite";
        } else {
            str3 = "3.3.34";
        }
        bVar.version = str3;
        bVar.ajQ = false;
        bVar.ajP = str2;
        bVar.ajS = hashMap;
        com.kwad.library.b.a i = com.kwad.library.solder.a.a.i(context, ITkOfflineCompo.PACKAGE_NAME);
        c.d("TkSoLoadHelper", "tkOfflineCompoPlugin: " + i);
        if (i instanceof com.kwad.library.b.a) {
            bVar.ajV = i.wK();
        }
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.c.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a */
            public void b(com.kwad.library.solder.lib.b.c cVar) {
                super.b((AnonymousClass1) cVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            /* renamed from: b */
            public void a(com.kwad.library.solder.lib.b.c cVar) {
                super.a((AnonymousClass1) cVar);
                SoLoadListener.this.onPreUpdate();
                long unused = a.ado = SystemClock.elapsedRealtime();
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(cVar.xh()).toJson());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.c cVar, PluginError pluginError) {
                SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
                if (cVar.getState() == 1) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.xh()).setErrorReason(String.valueOf(pluginError.getCode())).setDownloadState(2).toJson());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            public void c(com.kwad.library.solder.lib.b.c cVar) {
                super.c((AnonymousClass1) cVar);
                if (cVar.getState() == 4) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setRetryCount(cVar.xh()).setDownloadTime(SystemClock.elapsedRealtime() - a.ado).setDownloadState(1).toJson());
                }
            }

            private void tw() {
                SoLoadListener.this.onLoaded();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar) {
                tw();
            }
        });
    }

    public static boolean useTkLite() {
        if (adp == null) {
            adp = Boolean.valueOf(!d.a(com.kwad.sdk.core.config.c.aoV));
        }
        return adp.booleanValue();
    }
}
