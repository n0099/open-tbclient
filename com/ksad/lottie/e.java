package com.ksad.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.c.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, k<d>> f33764a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1819785980, "Lcom/ksad/lottie/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1819785980, "Lcom/ksad/lottie/e;");
                return;
            }
        }
        f33764a = new HashMap();
    }

    @Nullable
    public static g a(d dVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, dVar, str)) == null) {
            for (g gVar : dVar.j().values()) {
                if (gVar.b().equals(str)) {
                    return gVar;
                }
            }
            return null;
        }
        return (g) invokeLL.objValue;
    }

    @WorkerThread
    public static j<d> a(InputStream inputStream, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, inputStream, str)) == null) ? a(inputStream, str, true) : (j) invokeLL.objValue;
    }

    @WorkerThread
    public static j<d> a(InputStream inputStream, @Nullable String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, inputStream, str, z)) == null) {
            try {
                return b(new JsonReader(new InputStreamReader(inputStream)), str);
            } finally {
                if (z) {
                    com.ksad.lottie.d.f.a(inputStream);
                }
            }
        }
        return (j) invokeLLZ.objValue;
    }

    @WorkerThread
    public static j<d> a(ZipInputStream zipInputStream, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, zipInputStream, str)) == null) {
            try {
                return b(zipInputStream, str);
            } finally {
                com.ksad.lottie.d.f.a(zipInputStream);
            }
        }
        return (j) invokeLL.objValue;
    }

    public static k<d> a(Context context, @RawRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, context, i2)) == null) ? a(a(i2), new Callable<j<d>>(context.getApplicationContext(), i2) { // from class: com.ksad.lottie.e.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f33768a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f33769b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r6, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33768a = r6;
                this.f33769b = i2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public j<d> call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? e.b(this.f33768a, this.f33769b) : (j) invokeV.objValue;
            }
        }) : (k) invokeLI.objValue;
    }

    public static k<d> a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) ? com.ksad.lottie.network.b.a(context, str) : (k) invokeLL.objValue;
    }

    public static k<d> a(JsonReader jsonReader, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jsonReader, str)) == null) ? a(str, new Callable<j<d>>(jsonReader, str) { // from class: com.ksad.lottie.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsonReader f33770a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f33771b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jsonReader, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33770a = jsonReader;
                this.f33771b = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public j<d> call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? e.b(this.f33770a, this.f33771b) : (j) invokeV.objValue;
            }
        }) : (k) invokeLL.objValue;
    }

    public static k<d> a(@Nullable String str, Callable<j<d>> callable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, callable)) == null) {
            d a2 = com.ksad.lottie.model.e.a().a(str);
            if (a2 != null) {
                return new k<>(new Callable<j<d>>(a2) { // from class: com.ksad.lottie.e.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f33772a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {a2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f33772a = a2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public j<d> call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            Log.d("Gabe", "call\treturning from cache");
                            return new j<>(this.f33772a);
                        }
                        return (j) invokeV.objValue;
                    }
                });
            }
            if (f33764a.containsKey(str)) {
                return f33764a.get(str);
            }
            k<d> kVar = new k<>(callable);
            kVar.a(new h<d>(str) { // from class: com.ksad.lottie.e.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f33773a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f33773a = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.ksad.lottie.h
                public void a(d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dVar) == null) {
                        if (this.f33773a != null) {
                            com.ksad.lottie.model.e.a().a(this.f33773a, dVar);
                        }
                        e.f33764a.remove(this.f33773a);
                    }
                }
            });
            kVar.c(new h<Throwable>(str) { // from class: com.ksad.lottie.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f33767a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f33767a = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.ksad.lottie.h
                public void a(Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        e.f33764a.remove(this.f33767a);
                    }
                }
            });
            f33764a.put(str, kVar);
            return kVar;
        }
        return (k) invokeLL.objValue;
    }

    public static String a(@RawRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            return "rawRes_" + i2;
        }
        return (String) invokeI.objValue;
    }

    @WorkerThread
    public static j<d> b(Context context, @RawRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, context, i2)) == null) {
            try {
                return a(context.getResources().openRawResource(i2), a(i2));
            } catch (Resources.NotFoundException e2) {
                return new j<>(e2);
            }
        }
        return (j) invokeLI.objValue;
    }

    @WorkerThread
    public static j<d> b(JsonReader jsonReader, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, jsonReader, str)) == null) {
            try {
                d a2 = t.a(jsonReader);
                com.ksad.lottie.model.e.a().a(str, a2);
                return new j<>(a2);
            } catch (Exception e2) {
                return new j<>(e2);
            }
        }
        return (j) invokeLL.objValue;
    }

    @WorkerThread
    public static j<d> b(ZipInputStream zipInputStream, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, zipInputStream, str)) == null) {
            HashMap hashMap = new HashMap();
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                d dVar = null;
                while (nextEntry != null) {
                    if (!nextEntry.getName().contains("__MACOSX")) {
                        if (nextEntry.getName().contains(".json")) {
                            dVar = a(zipInputStream, str, false).a();
                        } else if (nextEntry.getName().contains(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)) {
                            String[] split = nextEntry.getName().split("/");
                            hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                        }
                        nextEntry = zipInputStream.getNextEntry();
                    }
                    zipInputStream.closeEntry();
                    nextEntry = zipInputStream.getNextEntry();
                }
                if (dVar == null) {
                    return new j<>(new IllegalArgumentException("Unable to parse composition"));
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    g a2 = a(dVar, (String) entry.getKey());
                    if (a2 != null) {
                        a2.a((Bitmap) entry.getValue());
                    }
                }
                for (Map.Entry<String, g> entry2 : dVar.j().entrySet()) {
                    if (entry2.getValue().c() == null) {
                        return new j<>(new IllegalStateException("There is no image for " + entry2.getValue().b()));
                    }
                }
                com.ksad.lottie.model.e.a().a(str, dVar);
                return new j<>(dVar);
            } catch (IOException e2) {
                return new j<>(e2);
            }
        }
        return (j) invokeLL.objValue;
    }

    public static k<d> b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) ? a(str, new Callable<j<d>>(context.getApplicationContext(), str) { // from class: com.ksad.lottie.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f33765a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f33766b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r6, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33765a = r6;
                this.f33766b = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public j<d> call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? e.c(this.f33765a, this.f33766b) : (j) invokeV.objValue;
            }
        }) : (k) invokeLL.objValue;
    }

    @WorkerThread
    public static j<d> c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, context, str)) == null) {
            try {
                String str2 = "asset_" + str;
                return str.endsWith(".zip") ? a(new ZipInputStream(context.getAssets().open(str)), str2) : a(context.getAssets().open(str), str2);
            } catch (IOException e2) {
                return new j<>(e2);
            }
        }
        return (j) invokeLL.objValue;
    }
}
