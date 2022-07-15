package com.kwad.components.offline.tk.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.w;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.b.c;
import com.kwai.sodler.lib.c.b;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.i;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static long i;
    public static Boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(902318849, "Lcom/kwad/components/offline/tk/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(902318849, "Lcom/kwad/components/offline/tk/a/a;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        b = w.a("lib%s.so", "tk_runtime_v0_0_8");
        c = w.a("lib%s.so", "tk_runtime_lite_v0_0_8");
        d = w.a("lib%s.so", "kwai-v8");
        e = w.a("lib%s.so", "kwai-v8-lite");
        f = w.a("lib%s.so", "kwad-fb");
        g = w.a("lib%s.so", "kwad-yoga");
        h = w.a("lib%s.so", SwanKV.LIB_CPP_SHARED);
        j = null;
    }

    public static void a(Context context, @NonNull SoLoadListener soLoadListener) {
        String j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, context, soLoadListener) == null) || a.get()) {
            return;
        }
        a.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        boolean a2 = a();
        if (AbiUtil.b(context)) {
            j2 = d.k();
            if (TextUtils.isEmpty(j2)) {
                j2 = a2 ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.24.2/ks_so-tachikomaLiteArm64v8aRelease-3.3.24.2.apk" : "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.24.2/ks_so-tachikomaArm64v8aRelease-3.3.24.2.apk";
            }
            str = a2 ? "sotk-v8a-lite" : "sotk-v8a";
            str2 = a2 ? "db892c7b72a9636667bfc8ea7e9df0bc" : "40f3b3b81340519f51bfc19cb9ea2284";
            if (a2) {
                hashMap.put(c, "2711ba35c7345099edcc3f4526e0b59d");
                str7 = e;
                str8 = "005c29f4f5c26b21923dce9b72a0fc8d";
            } else {
                hashMap.put(b, "09a2c11101651aa5e866979ad43f3df0");
                str7 = d;
                str8 = "cbed106d3241121e1ccb6a8bc152d53e";
            }
            hashMap.put(str7, str8);
            hashMap.put(f, "31f065607e6da6b741330d1df0b35460");
            hashMap.put(g, "76308532f64b68fd5a930c42cceec22b");
            str5 = h;
            str6 = "6ca7958ee0b0192a7c52c16faffaa8ba";
        } else {
            j2 = d.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = a2 ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.24.2/ks_so-tachikomaLiteArmeabiv7aRelease-3.3.24.2.apk" : "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.24.2/ks_so-tachikomaArmeabiv7aRelease-3.3.24.2.apk";
            }
            str = a2 ? "sotk-v7a-lite" : "sotk-v7a";
            str2 = a2 ? "55ecca97822a39bc4b276d645ad35c09" : "9f22c0987957bb7abb016726b088ad78";
            if (a2) {
                hashMap.put(c, "d278819f65940c10a8b7313bf606bfff");
                str3 = e;
                str4 = "9798330679c11734503264cdfb118e76";
            } else {
                hashMap.put(b, "b48f51dc240ddd4ffb5d8c75a5c5c820");
                str3 = d;
                str4 = "8674972563d49769d5d9a64744ac5749";
            }
            hashMap.put(str3, str4);
            hashMap.put(f, "eff11bebb8a3c872fa30b0484b460d12");
            hashMap.put(g, "2c6f402c6a565d2e6912b0013fa59380");
            str5 = h;
            str6 = "7cb16c2840085bbdf4be628e6604bac1";
        }
        hashMap.put(str5, str6);
        b bVar = new b();
        bVar.c = com.kwad.sdk.core.network.idc.a.a().a(j2);
        bVar.e = true;
        bVar.a = str;
        bVar.b = a2 ? "3.3.24.2-lite" : "3.3.24.2";
        bVar.g = false;
        bVar.f = str2;
        bVar.i = hashMap;
        com.kwai.sodler.lib.a.a a3 = i.a().b().d().a(ITkOfflineCompo.PACKAGE_NAME);
        com.kwad.sdk.core.d.b.a("TkSoLoadHelper", "tkOfflineCompoPlugin: " + a3);
        if (a3 instanceof com.kwai.sodler.lib.kwai.a) {
            bVar.l = ((com.kwai.sodler.lib.kwai.a) a3).a();
        }
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c(a3, soLoadListener) { // from class: com.kwad.components.offline.tk.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ com.kwai.sodler.lib.a.a a;
            public final /* synthetic */ SoLoadListener b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a3, soLoadListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = a3;
                this.b = soLoadListener;
            }

            private void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                    this.b.onLoaded();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            public void a(c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(65538, this, cVar) == null) {
                    super.a((AnonymousClass1) cVar);
                }
            }

            private void a(PluginError pluginError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(65539, this, pluginError) == null) {
                    this.b.onFailed(pluginError.getCode(), pluginError);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            /* renamed from: b */
            public void c(c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cVar) == null) {
                    super.c((AnonymousClass1) cVar);
                    long unused = a.i = SystemClock.elapsedRealtime();
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(cVar.k()).toJson());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            /* renamed from: c */
            public void b(c cVar) {
                String str9;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(65541, this, cVar) == null) {
                    super.b((AnonymousClass1) cVar);
                    if (cVar.c() == 1) {
                        TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setRetryCount(cVar.k()).setDownloadTime(SystemClock.elapsedRealtime() - a.i).setDownloadState(1).toJson());
                        return;
                    }
                    if (cVar.g() != null) {
                        Throwable g2 = cVar.g();
                        if (g2 instanceof PluginError) {
                            str9 = String.valueOf(((PluginError) g2).getCode());
                            TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.k()).setErrorReason(str9).setDownloadState(2).toJson());
                        }
                    }
                    str9 = ImageViewerConfig.FROM_OTHER;
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.k()).setErrorReason(str9).setDownloadState(2).toJson());
                }
            }

            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(f fVar, com.kwai.sodler.lib.a.a aVar) {
                a();
            }

            @Override // com.kwai.sodler.lib.ext.b.C0567b, com.kwai.sodler.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(f fVar, PluginError pluginError) {
                a(pluginError);
            }
        });
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (j == null) {
                j = Boolean.valueOf(d.l());
            }
            return j.booleanValue();
        }
        return invokeV.booleanValue;
    }
}
