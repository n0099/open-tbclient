package com.kwad.tachikoma.kwai;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.core.report.CommercialAction;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public static long f58124b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.tachikoma.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2151a {
        void a();

        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1875851537, "Lcom/kwad/tachikoma/kwai/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1875851537, "Lcom/kwad/tachikoma/kwai/a;");
                return;
            }
        }
        a = new AtomicBoolean(false);
    }

    public static void a(Context context, @NonNull InterfaceC2151a interfaceC2151a) {
        String x;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, interfaceC2151a) == null) || a.get()) {
            return;
        }
        a.set(true);
        if (AbiUtil.b()) {
            x = b.y();
            if (TextUtils.isEmpty(x)) {
                x = "https://static.yximgs.com/udata/pkg/commercial_res_test/ks_so-TachikomaArm64v8aRelease-3.3.13.apk";
            }
            str = "sotk-v8a";
        } else {
            x = b.x();
            if (TextUtils.isEmpty(x)) {
                x = "https://static.yximgs.com/udata/pkg/commercial_res_test/ks_so-TachikomaArmeabiv7aRelease-3.3.13.apk";
            }
            str = "sotk-v7a";
        }
        com.kwai.sodler.kwai.b.a(context);
        com.kwai.sodler.lib.a.b bVar = new com.kwai.sodler.lib.a.b();
        bVar.f58369c = x;
        bVar.f58371e = true;
        bVar.a = str;
        bVar.f58368b = "2.0";
        bVar.f58373g = false;
        com.kwai.sodler.kwai.b.a(str, bVar, new b.a(interfaceC2151a) { // from class: com.kwad.tachikoma.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ InterfaceC2151a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {interfaceC2151a};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = interfaceC2151a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, hVar) == null) {
                    super.a(hVar);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, PluginError pluginError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, pluginError) == null) {
                    this.a.a(pluginError.getCode());
                    i.b("ad_client_error_log", new CommercialAction.TKDownloadMsg().setDownloadState(2).setErrorReason(pluginError.getCode() == 4008 ? PackageTable.MD5 : "net"));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, g gVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hVar, gVar) == null) {
                    this.a.a();
                    if (a.f58124b > 0) {
                        i.b("ad_client_apm_log", new CommercialAction.TKDownloadMsg().setDownloadTime(SystemClock.elapsedRealtime() - a.f58124b).setDownloadState(1));
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void b(h hVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048582, this, hVar) == null) {
                    super.b(hVar);
                    long unused = a.f58124b = SystemClock.elapsedRealtime();
                    i.b("ad_client_apm_log", new CommercialAction.TKDownloadMsg().setDownloadState(0));
                }
            }
        });
    }
}
