package com.ksad.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<com.ksad.lottie.model.a> f33935a;

    /* renamed from: b  reason: collision with root package name */
    public PointF f33936b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33937c;

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
        this.f33935a = new ArrayList();
    }

    public h(PointF pointF, boolean z, List<com.ksad.lottie.model.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pointF, Boolean.valueOf(z), list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.f33935a = arrayList;
        this.f33936b = pointF;
        this.f33937c = z;
        arrayList.addAll(list);
    }

    private void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (this.f33936b == null) {
                this.f33936b = new PointF();
            }
            this.f33936b.set(f2, f3);
        }
    }

    public PointF a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33936b : (PointF) invokeV.objValue;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{hVar, hVar2, Float.valueOf(f2)}) == null) {
            if (this.f33936b == null) {
                this.f33936b = new PointF();
            }
            this.f33937c = hVar.b() || hVar2.b();
            if (hVar.c().size() != hVar2.c().size()) {
                com.ksad.lottie.c.b("Curves must have the same number of control points. Shape 1: " + hVar.c().size() + "\tShape 2: " + hVar2.c().size());
            }
            if (this.f33935a.isEmpty()) {
                int min = Math.min(hVar.c().size(), hVar2.c().size());
                for (int i2 = 0; i2 < min; i2++) {
                    this.f33935a.add(new com.ksad.lottie.model.a());
                }
            }
            PointF a2 = hVar.a();
            PointF a3 = hVar2.a();
            a(com.ksad.lottie.d.e.a(a2.x, a3.x, f2), com.ksad.lottie.d.e.a(a2.y, a3.y, f2));
            for (int size = this.f33935a.size() - 1; size >= 0; size--) {
                com.ksad.lottie.model.a aVar = hVar.c().get(size);
                com.ksad.lottie.model.a aVar2 = hVar2.c().get(size);
                PointF a4 = aVar.a();
                PointF b2 = aVar.b();
                PointF c2 = aVar.c();
                PointF a5 = aVar2.a();
                PointF b3 = aVar2.b();
                PointF c3 = aVar2.c();
                this.f33935a.get(size).a(com.ksad.lottie.d.e.a(a4.x, a5.x, f2), com.ksad.lottie.d.e.a(a4.y, a5.y, f2));
                this.f33935a.get(size).b(com.ksad.lottie.d.e.a(b2.x, b3.x, f2), com.ksad.lottie.d.e.a(b2.y, b3.y, f2));
                this.f33935a.get(size).c(com.ksad.lottie.d.e.a(c2.x, c3.x, f2), com.ksad.lottie.d.e.a(c2.y, c3.y, f2));
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33937c : invokeV.booleanValue;
    }

    public List<com.ksad.lottie.model.a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33935a : (List) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "ShapeData{numCurves=" + this.f33935a.size() + "closed=" + this.f33937c + '}';
        }
        return (String) invokeV.objValue;
    }
}
