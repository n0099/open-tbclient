package com.ss.android.downloadlib.addownload.c;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f68544a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f68545b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, e> f68546c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Integer> f68547d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f68548e;

    public d() {
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
        this.f68545b = 0L;
        this.f68546c = new ConcurrentHashMap<>();
        this.f68547d = new HashMap<>();
        this.f68548e = new CopyOnWriteArrayList();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f68544a == null) {
                synchronized (d.class) {
                    if (f68544a == null) {
                        f68544a = new d();
                    }
                }
            }
            return f68544a;
        }
        return (d) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68545b : invokeV.longValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f68545b = System.currentTimeMillis();
        }
    }

    public int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (this.f68547d == null) {
                this.f68547d = new HashMap<>();
            }
            if (this.f68547d.containsKey(str)) {
                return this.f68547d.get(str).intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void a(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f68546c.put(str, eVar);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f68546c.remove(str);
    }

    @WorkerThread
    public static void a(com.ss.android.downloadad.api.a.b bVar) {
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, bVar) == null) || bVar == null || bVar.b() <= 0 || (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s())) == null) {
            return;
        }
        a(downloadInfo);
    }

    @WorkerThread
    public static void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, downloadInfo) == null) || downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
