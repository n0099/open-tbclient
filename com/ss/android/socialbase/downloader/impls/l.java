package com.ss.android.socialbase.downloader.impls;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile com.ss.android.socialbase.downloader.downloader.m f70485a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.ss.android.socialbase.downloader.downloader.m f70486b;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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

    public static com.ss.android.socialbase.downloader.downloader.m a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            if (z && com.ss.android.socialbase.downloader.downloader.c.S()) {
                if (f70486b == null) {
                    synchronized (l.class) {
                        if (f70486b == null) {
                            f70486b = com.ss.android.socialbase.downloader.downloader.c.T().b();
                        }
                    }
                }
                return f70486b;
            }
            if (f70485a == null) {
                synchronized (l.class) {
                    if (f70485a == null) {
                        f70485a = new p();
                    }
                }
            }
            return f70485a;
        }
        return (com.ss.android.socialbase.downloader.downloader.m) invokeZ.objValue;
    }
}
