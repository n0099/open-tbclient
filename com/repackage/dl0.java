package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public interface dl0 {

    /* loaded from: classes5.dex */
    public interface a {
    }

    @Autowired
    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Singleton
        @Inject(force = false)
        public static dl0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? rt0.a() : (dl0) invokeV.objValue;
        }
    }

    void a(@Nullable String str, @Nullable String str2, @Nullable a aVar);
}
