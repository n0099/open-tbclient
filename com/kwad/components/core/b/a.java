package com.kwad.components.core.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.download.DownloadTask;
import com.kuaishou.aegon.Aegon;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.i;
import com.kwad.sdk.core.config.item.n;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.s;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.j;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0505a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
                File file = new File(b(context), "kwad_ex");
                if (!file.exists()) {
                    file.mkdir();
                }
                return file.getAbsolutePath();
            }
            return (String) invokeL.objValue;
        }

        public static File b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                int i = Build.VERSION.SDK_INT;
                if (i >= 29) {
                    return new File(context.getExternalFilesDir(null).getAbsolutePath());
                }
                File dataDir = i >= 24 ? context.getDataDir() : null;
                if (dataDir == null) {
                    dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                    if (!dataDir.exists()) {
                        return new File("/data/data/" + context.getPackageName());
                    }
                }
                return dataDir;
            }
            return (File) invokeL.objValue;
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                int indexOf = str.indexOf(46, str.indexOf(46) + 1);
                if (indexOf > 0) {
                    return str.substring(0, indexOf);
                }
                return null;
            } catch (Throwable th) {
                b.b(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, sdkConfig) == null) || context == null || sdkConfig == null) {
            return;
        }
        try {
            if (a) {
                return;
            }
            b.a("KsAdExceptionCollectorHelper", "init");
            com.kwad.sdk.crash.a.a(b(context, sdkConfig));
            a = true;
        } catch (Throwable th) {
            b.b(th);
        }
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, th) == null) {
            if (a) {
                com.kwad.sdk.crash.a.a(th);
            } else if (com.kwad.components.core.a.c.booleanValue()) {
                throw new RuntimeException("reportSdkCaughtException before init");
            }
        }
    }

    public static String[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(a(KsAdSDKImpl.class.getName()));
                arrayList.add(a(DownloadTask.class.getName()));
            } catch (Throwable th) {
                b.b(th);
            }
            try {
                arrayList.add(a(CpuMemoryProfiler.class.getName()));
                arrayList.add(a(Aegon.class.getName()));
            } catch (Throwable th2) {
                b.b(th2);
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeV.objValue;
    }

    @NonNull
    public static com.kwad.sdk.crash.b b(@NonNull Context context, @NonNull SdkConfig sdkConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, sdkConfig)) == null) {
            Context applicationContext = context.getApplicationContext();
            return new b.a().a(applicationContext).a(((i) d.a(applicationContext, c.am)).d()).b(((i) d.a(applicationContext, c.an)).d()).c(KsAdSDKImpl.get().getIsExternal()).b(((n) d.a(applicationContext, c.ao)).b()).a(((n) d.a(applicationContext, c.ap)).b()).h(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1)).a(KsAdSDKImpl.get().getSDKVersionCode()).i(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1)).b(KsAdSDKImpl.get().getApiVersionCode()).c(1).g("com.kwad.sdk").j(sdkConfig.appId).k(sdkConfig.appName).l(applicationContext.getPackageName()).m(j.a(applicationContext)).d(ao.e()).c("Android").e(sdkConfig.appId).f(C0505a.a(applicationContext)).a(new g(sdkConfig, applicationContext) { // from class: com.kwad.components.core.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SdkConfig a;
                public final /* synthetic */ Context b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {sdkConfig, applicationContext};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = sdkConfig;
                    this.b = applicationContext;
                }

                @Override // com.kwad.sdk.crash.g
                public final com.kwad.sdk.crash.model.message.a a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                        aVar.a(s.b());
                        aVar.a("mKsadAppId", this.a.appId);
                        aVar.a("mKsadAppName", this.a.appName);
                        aVar.a("mKsadAppPackageName", this.b.getPackageName());
                        aVar.a("mKsadAppVersion", j.a(this.b));
                        aVar.a("mKsadSdkName", "com.kwad.sdk");
                        aVar.a("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1));
                        aVar.a("mKsadSdKVersionCode", KsAdSDKImpl.get().getSDKVersionCode());
                        aVar.a("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1));
                        aVar.a("mKsadSdKApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
                        aVar.a("mKsadSdkType", 1);
                        return aVar;
                    }
                    return (com.kwad.sdk.crash.model.message.a) invokeV.objValue;
                }
            }).a(new e() { // from class: com.kwad.components.core.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.kwad.sdk.crash.e
                public final void a(int i, ExceptionMessage exceptionMessage) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, exceptionMessage) == null) {
                        if (i == 1 || i == 3 || i == 4) {
                            com.kwad.sdk.core.d.b.a("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i);
                        }
                    }
                }
            }).a(a()).b(b()).a();
        }
        return (com.kwad.sdk.crash.b) invokeLL.objValue;
    }

    public static String[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String[] strArr = new String[1];
            try {
                String name = com.kwad.sdk.crash.c.class.getName();
                strArr[0] = name.substring(0, name.lastIndexOf("."));
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.b(th);
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }
}
