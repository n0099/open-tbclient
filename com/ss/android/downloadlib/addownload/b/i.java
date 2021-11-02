package com.ss.android.downloadlib.addownload.b;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static i f68533a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(192162559, "Lcom/ss/android/downloadlib/addownload/b/i$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(192162559, "Lcom/ss/android/downloadlib/addownload/b/i$a;");
                    return;
                }
            }
            f68533a = new i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? j.getContext().getSharedPreferences("sp_ad_download_event", 0) : (SharedPreferences) invokeV.objValue;
    }

    @NonNull
    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> concurrentHashMap = new ConcurrentHashMap<>();
            Map<String, ?> all = c().getAll();
            if (all == null) {
                return concurrentHashMap;
            }
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        long longValue = Long.valueOf(entry.getKey()).longValue();
                        com.ss.android.downloadad.api.a.b b2 = com.ss.android.downloadad.api.a.b.b(new JSONObject(String.valueOf(entry.getValue())));
                        if (longValue > 0 && b2 != null) {
                            concurrentHashMap.put(Long.valueOf(longValue), b2);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return concurrentHashMap;
        }
        return (ConcurrentHashMap) invokeV.objValue;
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static i a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f68533a : (i) invokeV.objValue;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar);
            a((Collection<com.ss.android.downloadad.api.a.b>) arrayList);
        }
    }

    public synchronized void a(Collection<com.ss.android.downloadad.api.a.b> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) == null) {
            synchronized (this) {
                if (collection != null) {
                    if (!collection.isEmpty()) {
                        com.ss.android.downloadlib.d.a().a(new Runnable(this, collection) { // from class: com.ss.android.downloadlib.addownload.b.i.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Collection f68529a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ i f68530b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, collection};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f68530b = this;
                                this.f68529a = collection;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    SharedPreferences.Editor edit = this.f68530b.c().edit();
                                    for (com.ss.android.downloadad.api.a.b bVar : this.f68529a) {
                                        if (bVar != null && bVar.b() != 0) {
                                            edit.putString(String.valueOf(bVar.b()), bVar.ae().toString());
                                        }
                                    }
                                    edit.apply();
                                }
                            }
                        }, true);
                    }
                }
            }
        }
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.d.a().a(new Runnable(this, list) { // from class: com.ss.android.downloadlib.addownload.b.i.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f68531a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ i f68532b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, list};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68532b = this;
                this.f68531a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    SharedPreferences.Editor edit = this.f68532b.c().edit();
                    for (String str : this.f68531a) {
                        edit.remove(str);
                    }
                    edit.apply();
                }
            }
        }, true);
    }
}
