package com.ksad.download;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.DownloadParams;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f33846a;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f33847a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1395147990, "Lcom/ksad/download/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1395147990, "Lcom/ksad/download/e$a;");
                    return;
                }
            }
            f33847a = new e();
        }
    }

    public e() {
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

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.f33847a : (e) invokeV.objValue;
    }

    public synchronized void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            synchronized (this) {
                if (this.f33846a != null) {
                    this.f33846a.a(i2);
                }
            }
        }
    }

    public synchronized void a(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask) == null) {
            synchronized (this) {
                if (downloadTask.isCanceled()) {
                    a(downloadTask.getId());
                } else if (this.f33846a != null) {
                    this.f33846a.a(downloadTask);
                }
            }
        }
    }

    public synchronized void a(DownloadTask downloadTask, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, downloadTask, z) == null) {
            synchronized (this) {
                if (downloadTask.isCanceled()) {
                    a(downloadTask.getId());
                } else if (this.f33846a != null) {
                    this.f33846a.a(downloadTask, z);
                }
            }
        }
    }

    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f33846a = fVar;
        }
    }

    public synchronized void b(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadTask) == null) {
            synchronized (this) {
                if (downloadTask.isCanceled()) {
                    a(downloadTask.getId());
                } else if (this.f33846a != null) {
                    this.f33846a.b(downloadTask);
                }
            }
        }
    }

    public synchronized void c(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, downloadTask) == null) {
            synchronized (this) {
                if (this.f33846a != null) {
                    this.f33846a.c(downloadTask);
                }
                Object tag = downloadTask.getTag();
                if (tag instanceof DownloadParams) {
                    DownloadParams downloadParams = (DownloadParams) tag;
                }
            }
        }
    }
}
