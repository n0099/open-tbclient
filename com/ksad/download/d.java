package com.ksad.download;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.download.DownloadTask;
import com.ksad.download.h;
import com.kwai.filedownloader.q;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, DownloadTask> f64694a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Integer> f64695b;

    /* renamed from: c  reason: collision with root package name */
    public c f64696c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64697d;

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f64698a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1395118199, "Lcom/ksad/download/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1395118199, "Lcom/ksad/download/d$a;");
                    return;
                }
            }
            f64698a = new d();
        }
    }

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
        this.f64694a = new ConcurrentHashMap();
        this.f64695b = new ConcurrentHashMap();
        this.f64697d = false;
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.f64698a : (d) invokeV.objValue;
    }

    private void a(int i2, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65538, this, i2, downloadRequest) == null) || (downloadTask = this.f64694a.get(Integer.valueOf(i2))) == null) {
            return;
        }
        downloadTask.resume(downloadRequest);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(@NonNull Context context, @NonNull File file, @Nullable f fVar) {
        h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, file, fVar) == null) {
            b.a(context);
            b.a(file);
            e.a().a(fVar);
            c.a a2 = new c.a().a(Integer.MAX_VALUE);
            h.a aVar2 = null;
            try {
                aVar = new h.a(false);
                try {
                    aVar.a("");
                } catch (Throwable unused) {
                    aVar2 = aVar;
                    aVar = aVar2;
                    if (aVar != null) {
                    }
                    q.a(context, a2);
                }
            } catch (Throwable unused2) {
            }
            if (aVar != null) {
                a2.a(aVar);
            }
            q.a(context, a2);
        }
    }

    public int a(@NonNull DownloadTask.DownloadRequest downloadRequest, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, downloadRequest, cVar)) == null) {
            DownloadTask downloadTask = new DownloadTask(downloadRequest);
            if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
                b();
            } else if (this.f64697d) {
                c();
            }
            if (this.f64694a.get(Integer.valueOf(downloadTask.getId())) != null) {
                a(downloadTask.getId(), downloadRequest);
                b(downloadTask.getId());
                a(downloadTask.getId(), cVar, this.f64696c);
            } else {
                this.f64694a.put(Integer.valueOf(downloadTask.getId()), downloadTask);
                this.f64695b.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
                downloadTask.submit();
                a(downloadTask.getId(), cVar, this.f64696c);
            }
            return downloadTask.getId();
        }
        return invokeLL.intValue;
    }

    public DownloadTask a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f64694a.get(Integer.valueOf(i2)) : (DownloadTask) invokeI.objValue;
    }

    public void a(int i2, c... cVarArr) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, cVarArr) == null) || (downloadTask = this.f64694a.get(Integer.valueOf(i2))) == null || cVarArr == null) {
            return;
        }
        for (c cVar : cVarArr) {
            if (cVar != null) {
                cVar.a(i2);
                downloadTask.addListener(cVar);
            }
        }
    }

    public void a(@NonNull DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadTask) == null) {
            this.f64694a.remove(Integer.valueOf(downloadTask.getId()));
            this.f64695b.remove(downloadTask.getUrl());
        }
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f64696c = cVar;
        }
    }

    public void b() {
        h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                aVar = new h.a(true);
            } catch (Throwable th) {
                th.printStackTrace();
                aVar = null;
            }
            if (aVar != null) {
                com.kwai.filedownloader.download.b.a().b(new c.a().a(Integer.MAX_VALUE).a(aVar));
                this.f64697d = true;
            }
        }
    }

    public void b(int i2) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (downloadTask = this.f64694a.get(Integer.valueOf(i2))) == null) {
            return;
        }
        downloadTask.clearListener();
    }

    public void c() {
        h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                aVar = new h.a(false);
            } catch (Throwable th) {
                th.printStackTrace();
                aVar = null;
            }
            if (aVar != null) {
                com.kwai.filedownloader.download.b.a().b(new c.a().a(Integer.MAX_VALUE).a(aVar));
            }
        }
    }

    public void c(int i2) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (downloadTask = this.f64694a.get(Integer.valueOf(i2))) == null) {
            return;
        }
        downloadTask.cancel();
        a(downloadTask);
    }

    public void d(int i2) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (downloadTask = this.f64694a.get(Integer.valueOf(i2))) == null) {
            return;
        }
        downloadTask.userPause();
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            while (true) {
                boolean z = false;
                for (Map.Entry<Integer, DownloadTask> entry : this.f64694a.entrySet()) {
                    DownloadTask value = entry.getValue();
                    if (value != null) {
                        int status = value.getStatus();
                        if (status != -2 && status != 1 && status != 2 && status != 3 && status != 5 && status != 6 && status != 10 && status != 11 && Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            a(i2, (DownloadTask.DownloadRequest) null);
        }
    }

    public void f(int i2) {
        DownloadTask a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (a2 = a(i2)) == null) {
            return;
        }
        if (a2.isUserPause()) {
            e(i2);
        } else {
            d(i2);
        }
    }
}
