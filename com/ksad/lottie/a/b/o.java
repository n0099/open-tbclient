package com.ksad.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.a;
/* loaded from: classes7.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f33698a;

    /* renamed from: b  reason: collision with root package name */
    public final a<PointF, PointF> f33699b;

    /* renamed from: c  reason: collision with root package name */
    public final a<?, PointF> f33700c;

    /* renamed from: d  reason: collision with root package name */
    public final a<com.ksad.lottie.e.d, com.ksad.lottie.e.d> f33701d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f33702e;

    /* renamed from: f  reason: collision with root package name */
    public final a<Integer, Integer> f33703f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final a<?, Float> f33704g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final a<?, Float> f33705h;

    public o(com.ksad.lottie.model.a.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33698a = new Matrix();
        this.f33699b = lVar.a().a();
        this.f33700c = lVar.b().a();
        this.f33701d = lVar.c().a();
        this.f33702e = lVar.d().a();
        this.f33703f = lVar.e().a();
        if (lVar.f() != null) {
            this.f33704g = lVar.f().a();
        } else {
            this.f33704g = null;
        }
        if (lVar.g() != null) {
            this.f33705h = lVar.g().a();
        } else {
            this.f33705h = null;
        }
    }

    public a<?, Integer> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33703f : (a) invokeV.objValue;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f33699b.a(f2);
            this.f33700c.a(f2);
            this.f33701d.a(f2);
            this.f33702e.a(f2);
            this.f33703f.a(f2);
            a<?, Float> aVar = this.f33704g;
            if (aVar != null) {
                aVar.a(f2);
            }
            a<?, Float> aVar2 = this.f33705h;
            if (aVar2 != null) {
                aVar2.a(f2);
            }
        }
    }

    public void a(a.InterfaceC0399a interfaceC0399a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0399a) == null) {
            this.f33699b.a(interfaceC0399a);
            this.f33700c.a(interfaceC0399a);
            this.f33701d.a(interfaceC0399a);
            this.f33702e.a(interfaceC0399a);
            this.f33703f.a(interfaceC0399a);
            a<?, Float> aVar = this.f33704g;
            if (aVar != null) {
                aVar.a(interfaceC0399a);
            }
            a<?, Float> aVar2 = this.f33705h;
            if (aVar2 != null) {
                aVar2.a(interfaceC0399a);
            }
        }
    }

    public void a(com.ksad.lottie.model.layer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            aVar.a(this.f33699b);
            aVar.a(this.f33700c);
            aVar.a(this.f33701d);
            aVar.a(this.f33702e);
            aVar.a(this.f33703f);
            a<?, Float> aVar2 = this.f33704g;
            if (aVar2 != null) {
                aVar.a(aVar2);
            }
            a<?, Float> aVar3 = this.f33705h;
            if (aVar3 != null) {
                aVar.a(aVar3);
            }
        }
    }

    public Matrix b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) {
            PointF e2 = this.f33700c.e();
            PointF e3 = this.f33699b.e();
            com.ksad.lottie.e.d e4 = this.f33701d.e();
            float floatValue = this.f33702e.e().floatValue();
            this.f33698a.reset();
            this.f33698a.preTranslate(e2.x * f2, e2.y * f2);
            double d2 = f2;
            this.f33698a.preScale((float) Math.pow(e4.a(), d2), (float) Math.pow(e4.b(), d2));
            this.f33698a.preRotate(floatValue * f2, e3.x, e3.y);
            return this.f33698a;
        }
        return (Matrix) invokeF.objValue;
    }

    @Nullable
    public a<?, Float> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33704g : (a) invokeV.objValue;
    }

    @Nullable
    public a<?, Float> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33705h : (a) invokeV.objValue;
    }

    public Matrix d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f33698a.reset();
            PointF e2 = this.f33700c.e();
            if (e2.x != 0.0f || e2.y != 0.0f) {
                this.f33698a.preTranslate(e2.x, e2.y);
            }
            float floatValue = this.f33702e.e().floatValue();
            if (floatValue != 0.0f) {
                this.f33698a.preRotate(floatValue);
            }
            com.ksad.lottie.e.d e3 = this.f33701d.e();
            if (e3.a() != 1.0f || e3.b() != 1.0f) {
                this.f33698a.preScale(e3.a(), e3.b());
            }
            PointF e4 = this.f33699b.e();
            if (e4.x != 0.0f || e4.y != 0.0f) {
                this.f33698a.preTranslate(-e4.x, -e4.y);
            }
            return this.f33698a;
        }
        return (Matrix) invokeV.objValue;
    }
}
