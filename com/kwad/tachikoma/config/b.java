package com.kwad.tachikoma.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.report.CommercialAction;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.i;
import com.kwad.tachikoma.config.TKConfigResultData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;
    public static Context b;
    public static a c;
    public static volatile TKConfigResultData d;
    public static volatile boolean e;
    public static long f;
    public static final String[] g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a(TKConfigResultData tKConfigResultData);

        void b(@NonNull TKConfigResultData tKConfigResultData);
    }

    /* renamed from: com.kwad.tachikoma.config.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class RunnableC0345b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0345b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.b == null) {
                return;
            }
            TKConfigResultData unused = b.d = b.c(b.b);
            String str = (b.d == null || b.d.data == null || TextUtils.isEmpty(b.d.data.b)) ? "1.0.0" : b.d.data.b;
            if (b.c != null) {
                b.c.a(b.d);
            }
            b.b("2.1", str);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(330583328, "Lcom/kwad/tachikoma/config/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(330583328, "Lcom/kwad/tachikoma/config/b;");
                return;
            }
        }
        g = new String[]{"ksad-video-top-bar.js", "ksad-video-bottom-card.js"};
    }

    public static TKConfigResultData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? d : (TKConfigResultData) invokeV.objValue;
    }

    public static synchronized void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, aVar) == null) {
            synchronized (b.class) {
                b = context;
                if (!a) {
                    a = true;
                    c = aVar;
                    i.a(new RunnableC0345b());
                }
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            f = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.report.i.a("ad_client_apm_log", new CommercialAction.TKDownloadMsg().setDownloadState(0).setTemplateId("ksad-old").setVersionCode(str));
        }
    }

    public static void b(TKConfigResultData.a aVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, aVar) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            com.kwad.sdk.core.d.a.a("TKConfigRequestManager", "downloadAndReplaceJsFile downloadAndReplaceJsFile");
            if (context == null) {
                return;
            }
            a(aVar.b);
            File file = new File(aq.e(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "js.zip");
            boolean a2 = c.a(file2, aVar.c);
            com.kwad.sdk.core.d.a.a("TKConfigRequestManager", "downloadAndReplaceJsFile success");
            if (!a2) {
                str = aVar.b;
                str2 = "net";
            } else if (TextUtils.isEmpty(aVar.d) || aVar.d.equalsIgnoreCase(com.kwad.sdk.utils.c.b(file2))) {
                try {
                    File file3 = new File(aq.e(context));
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                    e = com.kwad.tachikoma.a.a.a(new FileInputStream(file2), file3.getAbsolutePath());
                    com.kwad.sdk.core.d.a.a("TKConfigRequestManager", "downloadAndReplaceJsFile sLoadFileFinished " + e);
                } catch (IOException e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                    com.kwad.sdk.core.d.a.a("TKConfigRequestManager", "downloadAndReplaceJsFile IOException " + e);
                }
                boolean z = e;
                String str3 = aVar.b;
                if (z) {
                    b(str3);
                    return;
                } else {
                    c(ZeusPerformanceTiming.KEY_UNZIP, str3);
                    return;
                }
            } else {
                str = aVar.b;
                str2 = PackageTable.MD5;
            }
            c(str2, str);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            com.kwad.sdk.core.report.i.a("ad_client_apm_log", new CommercialAction.TKDownloadMsg().setDownloadTime(f > 0 ? SystemClock.elapsedRealtime() - f : 0L).setDownloadState(1).setTemplateId("ksad-old").setVersionCode(str));
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            com.kwad.sdk.core.d.a.a("TKConfigRequestManager", "load() tkVersion " + str + " jsVersion " + str2);
            new com.kwad.sdk.core.network.i<com.kwad.tachikoma.config.a, TKConfigResultData>(str, str2) { // from class: com.kwad.tachikoma.config.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ String b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = str;
                    this.b = str2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public TKConfigResultData b(String str3) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str3)) == null) {
                        com.kwad.sdk.core.d.a.a("TKConfigRequestManager", "parseData = " + str3);
                        TKConfigResultData tKConfigResultData = new TKConfigResultData();
                        if (str3 != null) {
                            try {
                                tKConfigResultData.parseJson(new JSONObject(str3));
                            } catch (Throwable th) {
                                com.kwad.sdk.core.d.a.a(th);
                            }
                        }
                        return tKConfigResultData;
                    }
                    return (TKConfigResultData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.tachikoma.config.a b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new com.kwad.tachikoma.config.a(this.a, this.b) : (com.kwad.tachikoma.config.a) invokeV.objValue;
                }
            }.a(new j<com.kwad.tachikoma.config.a, TKConfigResultData>() { // from class: com.kwad.tachikoma.config.b.2
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.tachikoma.config.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, aVar) == null) {
                        com.kwad.sdk.core.d.a.a("TKConfigRequestManager", "onStartRequest request url = " + aVar.a());
                        super.a((AnonymousClass2) aVar);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.tachikoma.config.a aVar, int i, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048580, this, aVar, i, str3) == null) {
                        super.a((AnonymousClass2) aVar, i, str3);
                        com.kwad.sdk.core.d.a.a("TKConfigRequestManager", "onError " + str3);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                @SuppressLint({"NewApi"})
                public void a(@NonNull com.kwad.tachikoma.config.a aVar, @NonNull TKConfigResultData tKConfigResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048581, this, aVar, tKConfigResultData) == null) {
                        TKConfigResultData tKConfigResultData2 = new TKConfigResultData();
                        String string = b.b.getSharedPreferences("ksadsdk_JS_CONFIG", 0).getString("js_config", "");
                        try {
                            if (!at.a(string)) {
                                tKConfigResultData2.parseJson(new JSONObject(string));
                            }
                        } catch (JSONException unused) {
                        }
                        if (tKConfigResultData.result == 1 && tKConfigResultData.data.e == -1) {
                            b.i();
                            b.b.getSharedPreferences("ksadsdk_JS_CONFIG", 0).edit().clear().apply();
                            if (b.c == null) {
                                return;
                            }
                        } else if (tKConfigResultData.result == 1 && !at.a(tKConfigResultData.data.c)) {
                            TKConfigResultData unused2 = b.d = tKConfigResultData;
                            String str3 = tKConfigResultData.data.d;
                            if (str3 != null && str3.equals(tKConfigResultData2.data.d) && b.d(b.b)) {
                                boolean unused3 = b.e = true;
                            } else if (b.d.data.e == 1) {
                                b.b(tKConfigResultData.data);
                                b.b.getSharedPreferences("ksadsdk_JS_CONFIG", 0).edit().putString("js_config", tKConfigResultData.toJson().toString()).apply();
                            } else {
                                boolean unused4 = b.e = b.d(b.b);
                                if (!b.e) {
                                    b.b(tKConfigResultData.data);
                                }
                            }
                            if (b.c == null) {
                                return;
                            }
                        } else if (tKConfigResultData2.result != 1 || tKConfigResultData2.data.c == null) {
                            return;
                        } else {
                            boolean unused5 = b.e = b.d(b.b);
                            TKConfigResultData unused6 = b.d = tKConfigResultData2;
                            if (b.c == null) {
                                return;
                            }
                        }
                        b.c.b(tKConfigResultData);
                    }
                }
            });
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? e : invokeV.booleanValue;
    }

    public static TKConfigResultData c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            String string = context.getSharedPreferences("ksadsdk_JS_CONFIG", 0).getString("js_config", null);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            TKConfigResultData tKConfigResultData = new TKConfigResultData();
            try {
                tKConfigResultData.parseJson(new JSONObject(string));
                return tKConfigResultData;
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.b(e2);
                return null;
            }
        }
        return (TKConfigResultData) invokeL.objValue;
    }

    public static void c() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, null) == null) || (context = b) == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_JS_CONFIG", 0).edit().clear().apply();
        i();
        e = false;
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) {
            com.kwad.sdk.core.report.i.a("ad_client_error_log", new CommercialAction.TKDownloadMsg().setDownloadState(2).setErrorReason(str).setTemplateId("ksad-old").setVersionCode(str2));
        }
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            File file = new File(aq.e(context));
            for (String str : g) {
                File file2 = new File(file.getAbsolutePath(), str);
                if (!file2.exists() || file2.length() <= 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void i() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            e = false;
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                File file = new File(aq.e(context));
                for (String str : g) {
                    boolean delete = new File(file.getAbsolutePath(), str).delete();
                    System.out.println("Jifenglei " + str + " delete " + delete);
                }
            }
        }
    }
}
