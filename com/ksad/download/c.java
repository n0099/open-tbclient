package com.ksad.download;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a = i;
        }
    }

    public abstract void a(DownloadTask downloadTask);

    public abstract void a(DownloadTask downloadTask, int i, int i2);

    public abstract void a(DownloadTask downloadTask, String str, boolean z, int i, int i2);

    public abstract void a(DownloadTask downloadTask, Throwable th);

    public abstract void b(DownloadTask downloadTask);

    public abstract void b(DownloadTask downloadTask, int i, int i2);

    public abstract void c(DownloadTask downloadTask);

    public abstract void c(DownloadTask downloadTask, int i, int i2);

    public abstract void d(DownloadTask downloadTask);

    public abstract void d(DownloadTask downloadTask, int i, int i2);

    public abstract void e(DownloadTask downloadTask);

    public abstract void f(DownloadTask downloadTask);
}
