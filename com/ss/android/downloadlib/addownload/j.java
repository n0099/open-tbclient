package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.config.m;
import com.ss.android.download.api.config.n;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final JSONObject a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f61316b;

    /* renamed from: c  reason: collision with root package name */
    public static com.ss.android.download.api.config.f f61317c;

    /* renamed from: d  reason: collision with root package name */
    public static com.ss.android.download.api.config.c f61318d;

    /* renamed from: e  reason: collision with root package name */
    public static com.ss.android.download.api.config.k f61319e;

    /* renamed from: f  reason: collision with root package name */
    public static com.ss.android.download.api.config.g f61320f;

    /* renamed from: g  reason: collision with root package name */
    public static com.ss.android.download.api.config.h f61321g;

    /* renamed from: h  reason: collision with root package name */
    public static com.ss.android.download.api.config.i f61322h;

    /* renamed from: i  reason: collision with root package name */
    public static com.ss.android.download.api.model.a f61323i;

    /* renamed from: j  reason: collision with root package name */
    public static com.ss.android.download.api.config.b f61324j;

    /* renamed from: k  reason: collision with root package name */
    public static com.ss.android.socialbase.appdownloader.c.h f61325k;
    public static com.ss.android.download.api.config.d l;
    public static com.ss.android.download.api.config.e m;
    public static n n;
    public static com.ss.android.download.api.config.j o;
    public static t p;
    public static m q;
    public static com.ss.android.download.api.config.l r;
    public static o s;
    public static com.ss.android.download.api.b.a t;
    public static p u;
    public static r v;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2001018130, "Lcom/ss/android/downloadlib/addownload/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2001018130, "Lcom/ss/android/downloadlib/addownload/j;");
                return;
            }
        }
        a = new JSONObject();
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (context != null && context.getApplicationContext() != null) {
                f61316b = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context is null");
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, context) == null) || f61316b != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        f61316b = context.getApplicationContext();
    }

    @NonNull
    public static com.ss.android.download.api.config.k c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (f61319e == null) {
                f61319e = new com.ss.android.download.api.a.a();
            }
            return f61319e;
        }
        return (com.ss.android.download.api.config.k) invokeV.objValue;
    }

    public static com.ss.android.download.api.config.g d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f61320f : (com.ss.android.download.api.config.g) invokeV.objValue;
    }

    @NonNull
    public static com.ss.android.download.api.config.h e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (f61321g == null) {
                f61321g = new com.ss.android.download.api.a.b();
            }
            return f61321g;
        }
        return (com.ss.android.download.api.config.h) invokeV.objValue;
    }

    public static com.ss.android.socialbase.appdownloader.c.h f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if (f61325k == null) {
                f61325k = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.addownload.j.2
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

                    @Override // com.ss.android.socialbase.appdownloader.c.h
                    public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) {
                        }
                    }
                };
            }
            return f61325k;
        }
        return (com.ss.android.socialbase.appdownloader.c.h) invokeV.objValue;
    }

    public static n g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? n : (n) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            Context context = f61316b;
            if (context != null) {
                return context;
            }
            throw new IllegalArgumentException("Context is null");
        }
        return (Context) invokeV.objValue;
    }

    @NonNull
    public static o h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (s == null) {
                s = new o() { // from class: com.ss.android.downloadlib.addownload.j.3
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

                    @Override // com.ss.android.download.api.config.o
                    public void a(String str, int i2, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, str, i2, jSONObject) == null) {
                        }
                    }
                };
            }
            return s;
        }
        return (o) invokeV.objValue;
    }

    @NonNull
    public static JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            com.ss.android.download.api.config.i iVar = f61322h;
            if (iVar != null && iVar.a() != null) {
                return f61322h.a();
            }
            return a;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static com.ss.android.download.api.config.l j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? r : (com.ss.android.download.api.config.l) invokeV.objValue;
    }

    @Nullable
    public static com.ss.android.download.api.config.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? f61324j : (com.ss.android.download.api.config.b) invokeV.objValue;
    }

    @Nullable
    public static m l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? q : (m) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? "1.7.0" : (String) invokeV.objValue;
    }

    public static com.ss.android.download.api.config.d n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? l : (com.ss.android.download.api.config.d) invokeV.objValue;
    }

    public static com.ss.android.download.api.config.e o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? m : (com.ss.android.download.api.config.e) invokeV.objValue;
    }

    public static com.ss.android.download.api.config.j p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? o : (com.ss.android.download.api.config.j) invokeV.objValue;
    }

    @NonNull
    public static p q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? u : (p) invokeV.objValue;
    }

    public static t r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? p : (t) invokeV.objValue;
    }

    @NonNull
    public static com.ss.android.download.api.b.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            if (t == null) {
                t = new com.ss.android.download.api.b.a() { // from class: com.ss.android.downloadlib.addownload.j.4
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

                    @Override // com.ss.android.download.api.b.a
                    public void a(Throwable th, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, th, str) == null) {
                        }
                    }
                };
            }
            return t;
        }
        return (com.ss.android.download.api.b.a) invokeV.objValue;
    }

    @NonNull
    public static r t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            if (v == null) {
                v = new r() { // from class: com.ss.android.downloadlib.addownload.j.5
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

                    @Override // com.ss.android.download.api.config.r
                    public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{context, downloadModel, downloadController, downloadEventConfig, str, Integer.valueOf(i2)}) == null) {
                        }
                    }
                };
            }
            return v;
        }
        return (r) invokeV.objValue;
    }

    public static String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                int i2 = getContext().getApplicationInfo().targetSdkVersion;
                if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                    return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
                }
                return Environment.getExternalStorageDirectory().getPath() + File.separator + i().optString("default_save_dir_name", BaseConstants.DOWNLOAD_DIR);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? (f61317c == null || f61320f == null || f61322h == null || f61324j == null || u == null) ? false : true : invokeV.booleanValue;
    }

    @NonNull
    public static com.ss.android.download.api.config.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f61318d == null) {
                f61318d = new com.ss.android.download.api.config.c() { // from class: com.ss.android.downloadlib.addownload.j.1
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

                    @Override // com.ss.android.download.api.config.c
                    public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, context, downloadModel, downloadController, downloadEventConfig) == null) {
                        }
                    }

                    @Override // com.ss.android.download.api.config.c
                    public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, downloadModel, downloadController, downloadEventConfig, str, str2}) == null) {
                        }
                    }
                };
            }
            return f61318d;
        }
        return (com.ss.android.download.api.config.c) invokeV.objValue;
    }

    public static void a(@NonNull com.ss.android.download.api.config.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, fVar) == null) {
            f61317c = fVar;
        }
    }

    public static void a(@NonNull com.ss.android.download.api.config.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, kVar) == null) {
            f61319e = kVar;
        }
    }

    public static void a(@NonNull com.ss.android.download.api.config.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, gVar) == null) {
            f61320f = gVar;
        }
    }

    public static void a(@NonNull com.ss.android.download.api.config.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, hVar) == null) {
            f61321g = hVar;
        }
    }

    public static void a(@NonNull com.ss.android.download.api.config.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, iVar) == null) {
            f61322h = iVar;
        }
    }

    public static void a(@NonNull com.ss.android.download.api.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, aVar) == null) {
            f61323i = aVar;
        }
    }

    public static void a(@NonNull com.ss.android.download.api.config.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) {
            f61324j = bVar;
        }
    }

    public static com.ss.android.download.api.config.f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f61317c : (com.ss.android.download.api.config.f) invokeV.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            com.ss.android.socialbase.appdownloader.d.j().a(str);
        }
    }

    public static void a(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, pVar) == null) {
            u = pVar;
        }
    }

    public static void a(com.ss.android.download.api.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            t = aVar;
        }
    }
}
