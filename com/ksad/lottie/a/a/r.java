package com.ksad.lottie.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class r implements b, a.InterfaceC0399a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f33671a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a.InterfaceC0399a> f33672b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTrimPath.Type f33673c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f33674d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f33675e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f33676f;

    public r(com.ksad.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, shapeTrimPath};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33672b = new ArrayList();
        this.f33671a = shapeTrimPath.a();
        this.f33673c = shapeTrimPath.b();
        this.f33674d = shapeTrimPath.d().a();
        this.f33675e = shapeTrimPath.c().a();
        this.f33676f = shapeTrimPath.e().a();
        aVar.a(this.f33674d);
        aVar.a(this.f33675e);
        aVar.a(this.f33676f);
        this.f33674d.a(this);
        this.f33675e.a(this);
        this.f33676f.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0399a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int i2 = 0; i2 < this.f33672b.size(); i2++) {
                this.f33672b.get(i2).a();
            }
        }
    }

    public void a(a.InterfaceC0399a interfaceC0399a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0399a) == null) {
            this.f33672b.add(interfaceC0399a);
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2) == null) {
        }
    }

    public ShapeTrimPath.Type b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33673c : (ShapeTrimPath.Type) invokeV.objValue;
    }

    public com.ksad.lottie.a.b.a<?, Float> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33674d : (com.ksad.lottie.a.b.a) invokeV.objValue;
    }

    public com.ksad.lottie.a.b.a<?, Float> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33675e : (com.ksad.lottie.a.b.a) invokeV.objValue;
    }

    public com.ksad.lottie.a.b.a<?, Float> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33676f : (com.ksad.lottie.a.b.a) invokeV.objValue;
    }
}
