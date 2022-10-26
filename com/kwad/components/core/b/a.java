package com.kwad.components.core.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
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
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.core.report.s;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.ar;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static List DD;
    public static volatile boolean mHasInit;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C0564a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String ag(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
                File file = new File(getDataDir(context), "kwad_ex");
                if (!file.exists()) {
                    file.mkdir();
                }
                return file.getAbsolutePath();
            }
            return (String) invokeL.objValue;
        }

        public static File getDataDir(Context context) {
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

    public static b a(Context context, SdkConfig sdkConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, sdkConfig)) == null) {
            Context applicationContext = context.getApplicationContext();
            return new b.a().bI(applicationContext).aR(((j) d.b(applicationContext, c.UM)).sB()).aS(((j) d.b(applicationContext, c.UN)).sB()).aT(KsAdSDKImpl.get().getIsExternal()).cM(((o) d.b(applicationContext, c.UO)).getValue()).cL(((o) d.b(applicationContext, c.UP)).getValue()).cS(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1)).bc(KsAdSDKImpl.get().getSDKVersionCode()).cT(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1)).bd(KsAdSDKImpl.get().getApiVersionCode()).be(1).cR("com.kwad.sdk").cU(sdkConfig.appId).cV(sdkConfig.appName).cW(applicationContext.getPackageName()).cX(com.kwad.sdk.utils.j.cb(applicationContext)).cO(ar.getDeviceId()).cN("Android").cP(sdkConfig.appId).cQ(C0564a.ag(applicationContext)).a(new g(sdkConfig, applicationContext) { // from class: com.kwad.components.core.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SdkConfig DE;
                public final /* synthetic */ Context DF;

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
                    this.DE = sdkConfig;
                    this.DF = applicationContext;
                }

                @Override // com.kwad.sdk.crash.g
                public final com.kwad.sdk.crash.model.message.a mn() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                        aVar.cY(s.uG());
                        aVar.putString("mKsadAppId", this.DE.appId);
                        aVar.putString("mKsadAppName", this.DE.appName);
                        aVar.putString("mKsadAppPackageName", this.DF.getPackageName());
                        aVar.putString("mKsadAppVersion", com.kwad.sdk.utils.j.cb(this.DF));
                        aVar.putString("mKsadSdkName", "com.kwad.sdk");
                        aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1));
                        aVar.putInt("mKsadSdKVersionCode", KsAdSDKImpl.get().getSDKVersionCode());
                        aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1));
                        aVar.putInt("mKsadSdKApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
                        aVar.putInt("mKsadSdkType", 1);
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
                        com.kwad.sdk.e.qW();
                        if (i == 1 || i == 3 || i == 4) {
                            com.kwad.sdk.core.e.b.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i);
                        }
                    }
                }
            }).d(ml()).e(mm()).wy();
        }
        return (b) invokeLL.objValue;
    }

    public static String aj(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                int indexOf = str.indexOf(46, str.indexOf(46) + 1);
                if (indexOf > 0) {
                    return str.substring(0, indexOf);
                }
                return null;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void b(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, th) == null) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            if (mHasInit) {
                com.kwad.sdk.crash.a.h(th);
            } else {
                c(th);
            }
        }
    }

    public static void c(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, th) == null) {
            if (DD == null) {
                DD = new CopyOnWriteArrayList();
            }
            DD.add(th);
        }
    }

    public static void init(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, sdkConfig) == null) || context == null || sdkConfig == null) {
            return;
        }
        try {
            if (mHasInit) {
                return;
            }
            com.kwad.sdk.core.e.b.d("KsAdExceptionCollectorHelper", "init");
            com.kwad.sdk.crash.a.a(a(context, sdkConfig));
            mk();
            mHasInit = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    public static void mk() {
        List<Throwable> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || (list = DD) == null) {
            return;
        }
        for (Throwable th : list) {
            com.kwad.sdk.crash.a.h(th);
        }
        DD.clear();
        DD = null;
    }

    public static String[] ml() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(aj(KsAdSDKImpl.class.getName()));
                arrayList.add(aj(DownloadTask.class.getName()));
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
            try {
                arrayList.add(aj(CpuMemoryProfiler.class.getName()));
                arrayList.add(aj(Aegon.class.getName()));
            } catch (Throwable th2) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th2);
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeV.objValue;
    }

    public static String[] mm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String[] strArr = new String[1];
            try {
                String name = com.kwad.sdk.crash.c.class.getName();
                strArr[0] = name.substring(0, name.lastIndexOf("."));
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }
}
