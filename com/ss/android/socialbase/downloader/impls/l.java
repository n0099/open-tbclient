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
    public static volatile com.ss.android.socialbase.downloader.downloader.m f69566a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.ss.android.socialbase.downloader.downloader.m f69567b;
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
                if (f69567b == null) {
                    synchronized (l.class) {
                        if (f69567b == null) {
                            f69567b = com.ss.android.socialbase.downloader.downloader.c.T().b();
                        }
                    }
                }
                return f69567b;
            }
            if (f69566a == null) {
                synchronized (l.class) {
                    if (f69566a == null) {
                        f69566a = new p();
                    }
                }
            }
            return f69566a;
        }
        return (com.ss.android.socialbase.downloader.downloader.m) invokeZ.objValue;
    }
}
