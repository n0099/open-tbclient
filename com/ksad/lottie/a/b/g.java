package com.ksad.lottie.a.b;

import android.graphics.Path;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<a<com.ksad.lottie.model.content.h, Path>> f33684a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a<Integer, Integer>> f33685b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Mask> f33686c;

    public g(List<Mask> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33686c = list;
        this.f33684a = new ArrayList(list.size());
        this.f33685b = new ArrayList(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f33684a.add(list.get(i4).b().a());
            this.f33685b.add(list.get(i4).c().a());
        }
    }

    public List<Mask> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33686c : (List) invokeV.objValue;
    }

    public List<a<com.ksad.lottie.model.content.h, Path>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33684a : (List) invokeV.objValue;
    }

    public List<a<Integer, Integer>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33685b : (List) invokeV.objValue;
    }
}
