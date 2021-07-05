package com.kwad.sdk.glide.load.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.b.j;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes7.dex */
public interface h {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final h f37857a = new h() { // from class: com.kwad.sdk.glide.load.b.h.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        {
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

        @Override // com.kwad.sdk.glide.load.b.h
        public Map<String, String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Collections.emptyMap() : (Map) invokeV.objValue;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final h f37858b = new j.a().a();

    Map<String, String> a();
}
