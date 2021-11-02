package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            try {
                File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
            }
        }
    }

    @WorkerThread
    public static void a(Context context, AppStatusRules appStatusRules) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, appStatusRules) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        long obtainUploadConfigFileMaxSize = appStatusRules.obtainUploadConfigFileMaxSize();
        List<com.kwad.sdk.collector.model.d> uploadTargets = appStatusRules.getUploadTargets();
        if (uploadTargets == null) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
        List<com.kwad.sdk.collector.model.e> a2 = b.a().a(uploadTargets, obtainUploadConfigFileMaxSize, file.getAbsolutePath() + "/");
        List<com.kwad.sdk.collector.model.jni.c> b2 = b(context);
        if (b2 != null) {
            a2.addAll(b2);
            HashSet hashSet = new HashSet(a2);
            a2.clear();
            a2.addAll(hashSet);
        }
        a(context, a2);
    }

    @RequiresApi(api = 19)
    public static void a(Context context, List<com.kwad.sdk.collector.model.e> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, context, list) == null) || list == null || list.size() == 0) {
            return;
        }
        new com.kwad.sdk.core.network.i<com.kwad.sdk.collector.b.b, CollectResponse>(list) { // from class: com.kwad.sdk.collector.j.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f64192a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {list};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64192a = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public CollectResponse b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                    CollectResponse collectResponse = new CollectResponse();
                    collectResponse.parseJson(new JSONObject(str));
                    return collectResponse;
                }
                return (CollectResponse) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.collector.b.b b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new com.kwad.sdk.collector.b.b(this.f64192a) : (com.kwad.sdk.collector.b.b) invokeV.objValue;
            }

            @Override // com.kwad.sdk.core.network.i
            public boolean c() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }
        }.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.collector.b.b, CollectResponse>(context) { // from class: com.kwad.sdk.collector.j.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f64193a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64193a = context;
            }

            private synchronized void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                    synchronized (this) {
                        j.a(this.f64193a);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.b.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    super.a((AnonymousClass2) bVar);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.b.b bVar, int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2, str) == null) {
                    super.a((AnonymousClass2) bVar, i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.b.b bVar, @NonNull CollectResponse collectResponse) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, collectResponse) == null) {
                    super.a((AnonymousClass2) bVar, (com.kwad.sdk.collector.b.b) collectResponse);
                    a();
                }
            }
        });
    }

    public static List<com.kwad.sdk.collector.model.jni.c> b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (file.exists()) {
                try {
                    return q.a(com.kwad.sdk.crash.utils.h.a(file));
                } catch (IOException unused) {
                    return null;
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }
}
