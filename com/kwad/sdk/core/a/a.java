package com.kwad.sdk.core.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.kwad.sdk.core.report.l;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.d;
import com.kwad.sdk.utils.ap;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1898a {
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
                File dataDir = Build.VERSION.SDK_INT >= 24 ? context.getDataDir() : null;
                if (dataDir == null) {
                    File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                    if (file.exists()) {
                        return file;
                    }
                    return new File("/data/data/" + context.getPackageName());
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
                com.kwad.sdk.core.d.a.b(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, sdkConfig) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("崩溃收集是否打开：");
                sb.append(c.q());
                com.kwad.sdk.core.d.a.a("KsAdExceptionCollectorHelper", sb.toString());
                com.kwad.sdk.core.d.a.a("ec init s=" + c.q());
                if (c.q()) {
                    com.kwad.sdk.crash.a.a(b(context, sdkConfig));
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
        }
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, th) == null) && c.q()) {
            com.kwad.sdk.crash.a.a(th);
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
            } catch (Throwable unused) {
            }
            try {
                arrayList.add(a(CpuMemoryProfiler.class.getName()));
                arrayList.add(a(Aegon.class.getName()));
            } catch (Throwable unused2) {
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeV.objValue;
    }

    @NonNull
    public static b b(@NonNull Context context, @NonNull SdkConfig sdkConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, sdkConfig)) == null) {
            Context applicationContext = context.getApplicationContext();
            return new b.a().a(applicationContext).f("3.3.11.4").a(3031104).g(KsAdSDKImpl.get().getApiVersion()).b(KsAdSDKImpl.get().getApiVersionCode()).c(d.f65520a).e("com.kwad.sdk").h(sdkConfig.appId).i(sdkConfig.appName).j(applicationContext.getPackageName()).k(ap.p(applicationContext)).b(ap.n()).a("Android").c(sdkConfig.appId).d(C1898a.a(applicationContext)).a(new f(sdkConfig, applicationContext) { // from class: com.kwad.sdk.core.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SdkConfig f64282a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f64283b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {sdkConfig, applicationContext};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64282a = sdkConfig;
                    this.f64283b = applicationContext;
                }

                @Override // com.kwad.sdk.crash.f
                public com.kwad.sdk.crash.model.message.a a(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) {
                        com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                        aVar.a(l.b());
                        aVar.a("mKsadAppId", this.f64282a.appId);
                        aVar.a("mKsadAppName", this.f64282a.appName);
                        aVar.a("mKsadAppPackageName", this.f64283b.getPackageName());
                        aVar.a("mKsadAppVersion", ap.p(this.f64283b));
                        aVar.a("mKsadSdkName", "com.kwad.sdk");
                        aVar.a("mKsadSdkVersion", "3.3.11.4");
                        aVar.a("mKsadSdKVersionCode", 3031104);
                        aVar.a("mKsadSdkApiVersion", KsAdSDKImpl.get().getApiVersion());
                        aVar.a("mKsadSdKApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
                        aVar.a("mKsadSdkType", d.f65520a);
                        return aVar;
                    }
                    return (com.kwad.sdk.crash.model.message.a) invokeI.objValue;
                }
            }).a(new e() { // from class: com.kwad.sdk.core.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.kwad.sdk.crash.e
                public void a(int i2, ExceptionMessage exceptionMessage) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, exceptionMessage) == null) {
                    }
                }
            }).a(a()).b(b()).a();
        }
        return (b) invokeLL.objValue;
    }

    public static String[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            String[] strArr = new String[1];
            try {
                String name = com.kwad.sdk.crash.c.class.getName();
                strArr[0] = name.substring(0, name.lastIndexOf("."));
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }
}
