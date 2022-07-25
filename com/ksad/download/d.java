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
    public final Map<Integer, DownloadTask> ae;
    public final Map<String, Integer> af;
    public c ag;
    public boolean ah;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final d ai;
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
            ai = new d();
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
        this.ae = new ConcurrentHashMap();
        this.af = new ConcurrentHashMap();
        this.ah = false;
    }

    public static d N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.ai : (d) invokeV.objValue;
    }

    private void O() {
        h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            try {
                aVar = new h.a(true);
            } catch (Throwable th) {
                th.printStackTrace();
                aVar = null;
            }
            if (aVar != null) {
                com.kwai.filedownloader.download.b.Dp().b(new c.a().cA(Integer.MAX_VALUE).a(aVar));
                this.ah = true;
            }
        }
    }

    public static void P() {
        h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                aVar = new h.a(false);
            } catch (Throwable th) {
                th.printStackTrace();
                aVar = null;
            }
            if (aVar != null) {
                com.kwai.filedownloader.download.b.Dp().b(new c.a().cA(Integer.MAX_VALUE).a(aVar));
            }
        }
    }

    private void a(int i, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, downloadRequest) == null) || (downloadTask = this.ae.get(Integer.valueOf(i))) == null) {
            return;
        }
        downloadTask.resume(downloadRequest);
    }

    private void a(int i, c... cVarArr) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65541, this, i, cVarArr) == null) || (downloadTask = this.ae.get(Integer.valueOf(i))) == null) {
            return;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            c cVar = cVarArr[i2];
            if (cVar != null) {
                cVar.setId(i);
                downloadTask.addListener(cVar);
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull File file, @Nullable f fVar) {
        h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, context, file, fVar) == null) {
            b.D(context);
            b.b(file);
            e.S().a(fVar);
            c.a cA = new c.a().cA(Integer.MAX_VALUE);
            try {
                aVar = new h.a(false);
                try {
                    aVar.r("");
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                aVar = null;
            }
            if (aVar != null) {
                cA.a(aVar);
            }
            r.a(context, cA);
        }
    }

    private void g(@NonNull DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, downloadTask) == null) {
            this.ae.remove(Integer.valueOf(downloadTask.getId()));
            this.af.remove(downloadTask.getUrl());
        }
    }

    private void t(int i) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65544, this, i) == null) || (downloadTask = this.ae.get(Integer.valueOf(i))) == null) {
            return;
        }
        downloadTask.clearListener();
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            while (true) {
                boolean z = false;
                for (Map.Entry<Integer, DownloadTask> entry : this.ae.entrySet()) {
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

    public final int a(@NonNull DownloadTask.DownloadRequest downloadRequest, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadRequest, cVar)) == null) {
            DownloadTask downloadTask = new DownloadTask(downloadRequest);
            if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
                O();
            } else if (this.ah) {
                P();
            }
            if (this.ae.get(Integer.valueOf(downloadTask.getId())) != null) {
                a(downloadTask.getId(), downloadRequest);
                t(downloadTask.getId());
            } else {
                this.ae.put(Integer.valueOf(downloadTask.getId()), downloadTask);
                this.af.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
                downloadTask.submit();
            }
            a(downloadTask.getId(), null, this.ag);
            return downloadTask.getId();
        }
        return invokeLL.intValue;
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.ag = cVar;
        }
    }

    public final void cancel(int i) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (downloadTask = this.ae.get(Integer.valueOf(i))) == null) {
            return;
        }
        downloadTask.cancel();
        g(downloadTask);
    }

    public final void pause(int i) {
        DownloadTask downloadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (downloadTask = this.ae.get(Integer.valueOf(i))) == null) {
            return;
        }
        downloadTask.userPause();
    }

    public final void resume(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            a(i, (DownloadTask.DownloadRequest) null);
        }
    }

    public final DownloadTask s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? this.ae.get(Integer.valueOf(i)) : (DownloadTask) invokeI.objValue;
    }

    public final void u(int i) {
        DownloadTask s;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (s = s(i)) == null) {
            return;
        }
        if (s.isUserPause()) {
            resume(i);
        } else {
            pause(i);
        }
    }
}
