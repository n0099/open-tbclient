package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
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
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<Long, DownloadModel> f61226b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<Long, DownloadEventConfig> f61227c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentHashMap<Long, DownloadController> f61228d;

    /* renamed from: e  reason: collision with root package name */
    public final ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> f61229e;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static f a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(192073186, "Lcom/ss/android/downloadlib/addownload/b/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(192073186, "Lcom/ss/android/downloadlib/addownload/b/f$a;");
                    return;
                }
            }
            a = new f();
        }
    }

    public DownloadController c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) ? this.f61228d.get(Long.valueOf(j2)) : (DownloadController) invokeJ.objValue;
    }

    public com.ss.android.downloadad.api.a.b d(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) ? this.f61229e.get(Long.valueOf(j2)) : (com.ss.android.downloadad.api.a.b) invokeJ.objValue;
    }

    @NonNull
    public e e(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j2)) == null) {
            e eVar = new e();
            eVar.a = j2;
            eVar.f61223b = a(j2);
            DownloadEventConfig b2 = b(j2);
            eVar.f61224c = b2;
            if (b2 == null) {
                eVar.f61224c = new com.ss.android.download.api.download.c();
            }
            DownloadController c2 = c(j2);
            eVar.f61225d = c2;
            if (c2 == null) {
                eVar.f61225d = new com.ss.android.download.api.download.b();
            }
            return eVar;
        }
        return (e) invokeJ.objValue;
    }

    public void f(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            this.f61226b.remove(Long.valueOf(j2));
            this.f61227c.remove(Long.valueOf(j2));
            this.f61228d.remove(Long.valueOf(j2));
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f61226b = new ConcurrentHashMap<>();
        this.f61227c = new ConcurrentHashMap<>();
        this.f61228d = new ConcurrentHashMap<>();
        this.f61229e = new ConcurrentHashMap<>();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.ss.android.downloadlib.d.a().a(new Runnable(this) { // from class: com.ss.android.downloadlib.addownload.b.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.a) {
                        return;
                    }
                    synchronized (f.class) {
                        if (!this.a.a) {
                            this.a.f61229e.putAll(i.a().b());
                            this.a.a = true;
                        }
                    }
                }
            }, true);
        }
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f61229e : (ConcurrentHashMap) invokeV.objValue;
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (f) invokeV.objValue;
    }

    public DownloadEventConfig b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) ? this.f61227c.get(Long.valueOf(j2)) : (DownloadEventConfig) invokeJ.objValue;
    }

    public void a(DownloadModel downloadModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadModel) == null) || downloadModel == null) {
            return;
        }
        this.f61226b.put(Long.valueOf(downloadModel.getId()), downloadModel);
        if (downloadModel.getDeepLink() != null) {
            downloadModel.getDeepLink().setId(downloadModel.getId());
            downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
        }
    }

    public com.ss.android.downloadad.api.a.b b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (com.ss.android.downloadad.api.a.b bVar : this.f61229e.values()) {
                if (bVar != null && str.equals(bVar.a())) {
                    return bVar;
                }
            }
            return null;
        }
        return (com.ss.android.downloadad.api.a.b) invokeL.objValue;
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.f61226b.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void a(long j2, DownloadEventConfig downloadEventConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048582, this, j2, downloadEventConfig) == null) || downloadEventConfig == null) {
            return;
        }
        this.f61227c.put(Long.valueOf(j2), downloadEventConfig);
    }

    public void a(long j2, DownloadController downloadController) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048581, this, j2, downloadController) == null) || downloadController == null) {
            return;
        }
        this.f61228d.put(Long.valueOf(j2), downloadController);
    }

    public synchronized void a(com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return;
                }
                this.f61229e.put(Long.valueOf(bVar.b()), bVar);
                i.a().a(bVar);
            }
        }
    }

    public DownloadModel a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? this.f61226b.get(Long.valueOf(j2)) : (DownloadModel) invokeJ.objValue;
    }

    public com.ss.android.downloadad.api.a.b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (com.ss.android.downloadad.api.a.b bVar : this.f61229e.values()) {
                if (bVar != null && str.equals(bVar.e())) {
                    return bVar;
                }
            }
            return null;
        }
        return (com.ss.android.downloadad.api.a.b) invokeL.objValue;
    }

    public com.ss.android.downloadad.api.a.b a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return null;
            }
            for (com.ss.android.downloadad.api.a.b bVar : this.f61229e.values()) {
                if (bVar != null && bVar.s() == downloadInfo.getId()) {
                    return bVar;
                }
            }
            if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
                try {
                    long a2 = l.a(new JSONObject(downloadInfo.getExtra()), "extra");
                    if (a2 != 0) {
                        for (com.ss.android.downloadad.api.a.b bVar2 : this.f61229e.values()) {
                            if (bVar2 != null && bVar2.b() == a2) {
                                return bVar2;
                            }
                        }
                        com.ss.android.downloadlib.e.c.a().a("getNativeModelByInfo");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            for (com.ss.android.downloadad.api.a.b bVar3 : this.f61229e.values()) {
                if (bVar3 != null && TextUtils.equals(bVar3.a(), downloadInfo.getUrl())) {
                    return bVar3;
                }
            }
            return null;
        }
        return (com.ss.android.downloadad.api.a.b) invokeL.objValue;
    }

    public com.ss.android.downloadad.api.a.b a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            for (com.ss.android.downloadad.api.a.b bVar : this.f61229e.values()) {
                if (bVar != null && bVar.s() == i2) {
                    return bVar;
                }
            }
            return null;
        }
        return (com.ss.android.downloadad.api.a.b) invokeI.objValue;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.a.b> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                for (com.ss.android.downloadad.api.a.b bVar : this.f61229e.values()) {
                    if (bVar != null && TextUtils.equals(bVar.a(), str)) {
                        bVar.b(str2);
                        hashMap.put(Long.valueOf(bVar.b()), bVar);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public synchronized void a(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                for (Long l : list) {
                    long longValue = l.longValue();
                    arrayList.add(String.valueOf(longValue));
                    this.f61229e.remove(Long.valueOf(longValue));
                }
                i.a().a((List<String>) arrayList);
            }
        }
    }
}
