package com.kwad.sdk.glide;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.h;
/* loaded from: classes7.dex */
public abstract class h<CHILD extends h<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.glide.request.b.c<? super TranscodeType> f37776a;

    public h() {
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
        this.f37776a = com.kwad.sdk.glide.request.b.a.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public final CHILD clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (CHILD) super.clone();
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (CHILD) invokeV.objValue;
    }

    public final com.kwad.sdk.glide.request.b.c<? super TranscodeType> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37776a : (com.kwad.sdk.glide.request.b.c) invokeV.objValue;
    }
}
