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
import com.kwai.filedownloader.r;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, DownloadTask> a;
    public final Map<String, Integer> b;
    public c c;
    public boolean d;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;
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
            a = new d();
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.d = false;
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (d) invokeV.objValue;
    }

    private void a(int i, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65538, this, i, downloadRequest) == null) || (downloadTask = this.a.get(Integer.valueOf(i))) == null) {
            return;
        }
        downloadTask.resume(downloadRequest);
    }

    private void a(int i, c... cVarArr) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65539, this, i, cVarArr) == null) || (downloadTask = this.a.get(Integer.valueOf(i))) == null) {
            return;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            c cVar = cVarArr[i2];
            if (cVar != null) {
                cVar.a(i);
                downloadTask.addListener(cVar);
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull File file, @Nullable f fVar) {
        h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, file, fVar) == null) {
            b.a(context);
            b.a(file);
            e.a().a(fVar);
            c.a a2 = new c.a().a(Integer.MAX_VALUE);
            try {
                aVar = new h.a(false);
                try {
                    aVar.a("");
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                aVar = null;
            }
            if (aVar != null) {
                a2.a(aVar);
            }
            r.a(context, a2);
        }
    }

    private void a(@NonNull DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, downloadTask) == null) {
            this.a.remove(Integer.valueOf(downloadTask.getId()));
            this.b.remove(downloadTask.getUrl());
        }
    }

    private void c() {
        h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            try {
                aVar = new h.a(true);
            } catch (Throwable th) {
                th.printStackTrace();
                aVar = null;
            }
            if (aVar != null) {
                com.kwai.filedownloader.download.b.a().b(new c.a().a(Integer.MAX_VALUE).a(aVar));
                this.d = true;
            }
        }
    }

    public static void d() {
        h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
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

    private void f(int i) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65544, this, i) == null) || (downloadTask = this.a.get(Integer.valueOf(i))) == null) {
            return;
        }
        downloadTask.clearListener();
    }

    public final int a(@NonNull DownloadTask.DownloadRequest downloadRequest, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, downloadRequest, cVar)) == null) {
            DownloadTask downloadTask = new DownloadTask(downloadRequest);
            if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
                c();
            } else if (this.d) {
                d();
            }
            if (this.a.get(Integer.valueOf(downloadTask.getId())) != null) {
                a(downloadTask.getId(), downloadRequest);
                f(downloadTask.getId());
            } else {
                this.a.put(Integer.valueOf(downloadTask.getId()), downloadTask);
                this.b.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
                downloadTask.submit();
            }
            a(downloadTask.getId(), null, this.c);
            return downloadTask.getId();
        }
        return invokeLL.intValue;
    }

    public final DownloadTask a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.a.get(Integer.valueOf(i)) : (DownloadTask) invokeI.objValue;
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.c = cVar;
        }
    }

    public final void b(int i) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (downloadTask = this.a.get(Integer.valueOf(i))) == null) {
            return;
        }
        downloadTask.cancel();
        a(downloadTask);
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            while (true) {
                boolean z = false;
                for (Map.Entry<Integer, DownloadTask> entry : this.a.entrySet()) {
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

    public final void c(int i) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (downloadTask = this.a.get(Integer.valueOf(i))) == null) {
            return;
        }
        downloadTask.userPause();
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            a(i, (DownloadTask.DownloadRequest) null);
        }
    }

    public final void e(int i) {
        DownloadTask a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (a2 = a(i)) == null) {
            return;
        }
        if (a2.isUserPause()) {
            d(i);
        } else {
            c(i);
        }
    }
}
