package com.ksad.lottie.a.b;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a<K, A> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<InterfaceC0399a> f33677a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public com.ksad.lottie.e.c<A> f33678b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33679c;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends com.ksad.lottie.e.a<K>> f33680d;

    /* renamed from: e  reason: collision with root package name */
    public float f33681e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.ksad.lottie.e.a<K> f33682f;

    /* renamed from: com.ksad.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0399a {
        void a();
    }

    public a(List<? extends com.ksad.lottie.e.a<K>> list) {
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
        this.f33677a = new ArrayList();
        this.f33679c = false;
        this.f33681e = 0.0f;
        this.f33680d = list;
    }

    private com.ksad.lottie.e.a<K> g() {
        InterceptResult invokeV;
        List<? extends com.ksad.lottie.e.a<K>> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            com.ksad.lottie.e.a<K> aVar = this.f33682f;
            if (aVar == null || !aVar.a(this.f33681e)) {
                com.ksad.lottie.e.a<K> aVar2 = this.f33680d.get(list.size() - 1);
                if (this.f33681e < aVar2.b()) {
                    for (int size = this.f33680d.size() - 1; size >= 0; size--) {
                        aVar2 = this.f33680d.get(size);
                        if (aVar2.a(this.f33681e)) {
                            break;
                        }
                    }
                }
                this.f33682f = aVar2;
                return aVar2;
            }
            return this.f33682f;
        }
        return (com.ksad.lottie.e.a) invokeV.objValue;
    }

    private float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            com.ksad.lottie.e.a<K> g2 = g();
            if (g2.d()) {
                return 0.0f;
            }
            return g2.f33776c.getInterpolation(c());
        }
        return invokeV.floatValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.f33680d.isEmpty()) {
                return 0.0f;
            }
            return this.f33680d.get(0).b();
        }
        return invokeV.floatValue;
    }

    public abstract A a(com.ksad.lottie.e.a<K> aVar, float f2);

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f33679c = true;
        }
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            if (f2 < i()) {
                f2 = i();
            } else if (f2 > d()) {
                f2 = d();
            }
            if (f2 == this.f33681e) {
                return;
            }
            this.f33681e = f2;
            b();
        }
    }

    public void a(InterfaceC0399a interfaceC0399a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0399a) == null) {
            this.f33677a.add(interfaceC0399a);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (int i2 = 0; i2 < this.f33677a.size(); i2++) {
                this.f33677a.get(i2).a();
            }
        }
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f33679c) {
                return 0.0f;
            }
            com.ksad.lottie.e.a<K> g2 = g();
            if (g2.d()) {
                return 0.0f;
            }
            return (this.f33681e - g2.b()) / (g2.c() - g2.b());
        }
        return invokeV.floatValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f33680d.isEmpty()) {
                return 1.0f;
            }
            List<? extends com.ksad.lottie.e.a<K>> list = this.f33680d;
            return list.get(list.size() - 1).c();
        }
        return invokeV.floatValue;
    }

    public A e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a(g(), h()) : (A) invokeV.objValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f33681e : invokeV.floatValue;
    }
}
