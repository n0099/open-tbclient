package com.kwai.filedownloader;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.kwai.filedownloader.a aVar);

        void b(com.kwai.filedownloader.a aVar);

        void c(com.kwai.filedownloader.a aVar);

        void d(com.kwai.filedownloader.a aVar);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a : (a) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a() != null : invokeV.booleanValue;
    }
}
