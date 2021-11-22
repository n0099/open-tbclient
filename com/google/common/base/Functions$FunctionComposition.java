package com.google.common.base;

import b.h.d.a.g;
import b.h.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes11.dex */
public class Functions$FunctionComposition<A, B, C> implements g<A, C>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final g<A, ? extends B> f64042f;

    /* renamed from: g  reason: collision with root package name */
    public final g<B, C> f64043g;

    public Functions$FunctionComposition(g<B, C> gVar, g<A, ? extends B> gVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, gVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(gVar);
        this.f64043g = gVar;
        n.p(gVar2);
        this.f64042f = gVar2;
    }

    @Override // b.h.d.a.g
    public C apply(A a2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a2)) == null) ? this.f64043g.apply(this.f64042f.apply(a2)) : (C) invokeL.objValue;
    }

    @Override // b.h.d.a.g
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof Functions$FunctionComposition) {
                Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition) obj;
                return this.f64042f.equals(functions$FunctionComposition.f64042f) && this.f64043g.equals(functions$FunctionComposition.f64043g);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64042f.hashCode() ^ this.f64043g.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f64043g + "(" + this.f64042f + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
