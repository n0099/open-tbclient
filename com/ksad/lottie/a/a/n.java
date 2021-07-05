package com.ksad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes7.dex */
public class n implements j, l, a.InterfaceC0399a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Path f33643a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f33644b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33645c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.f f33646d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, PointF> f33647e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, PointF> f33648f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f33649g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public r f33650h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33651i;

    public n(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.f fVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, fVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33643a = new Path();
        this.f33644b = new RectF();
        this.f33645c = fVar2.a();
        this.f33646d = fVar;
        this.f33647e = fVar2.d().a();
        this.f33648f = fVar2.c().a();
        this.f33649g = fVar2.b().a();
        aVar.a(this.f33647e);
        aVar.a(this.f33648f);
        aVar.a(this.f33649g);
        this.f33647e.a(this);
        this.f33648f.a(this);
        this.f33649g.a(this);
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f33651i = false;
            this.f33646d.invalidateSelf();
        }
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0399a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b();
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                b bVar = list.get(i2);
                if (bVar instanceof r) {
                    r rVar = (r) bVar;
                    if (rVar.b() == ShapeTrimPath.Type.Simultaneously) {
                        this.f33650h = rVar;
                        rVar.a(this);
                    }
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f33651i) {
                return this.f33643a;
            }
            this.f33643a.reset();
            PointF e2 = this.f33648f.e();
            float f2 = e2.x / 2.0f;
            float f3 = e2.y / 2.0f;
            com.ksad.lottie.a.b.a<?, Float> aVar = this.f33649g;
            float floatValue = aVar == null ? 0.0f : aVar.e().floatValue();
            float min = Math.min(f2, f3);
            if (floatValue > min) {
                floatValue = min;
            }
            PointF e3 = this.f33647e.e();
            this.f33643a.moveTo(e3.x + f2, (e3.y - f3) + floatValue);
            this.f33643a.lineTo(e3.x + f2, (e3.y + f3) - floatValue);
            int i2 = (floatValue > 0.0f ? 1 : (floatValue == 0.0f ? 0 : -1));
            if (i2 > 0) {
                RectF rectF = this.f33644b;
                float f4 = e3.x;
                float f5 = floatValue * 2.0f;
                float f6 = e3.y;
                rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
                this.f33643a.arcTo(this.f33644b, 0.0f, 90.0f, false);
            }
            this.f33643a.lineTo((e3.x - f2) + floatValue, e3.y + f3);
            if (i2 > 0) {
                RectF rectF2 = this.f33644b;
                float f7 = e3.x;
                float f8 = e3.y;
                float f9 = floatValue * 2.0f;
                rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
                this.f33643a.arcTo(this.f33644b, 90.0f, 90.0f, false);
            }
            this.f33643a.lineTo(e3.x - f2, (e3.y - f3) + floatValue);
            if (i2 > 0) {
                RectF rectF3 = this.f33644b;
                float f10 = e3.x;
                float f11 = e3.y;
                float f12 = floatValue * 2.0f;
                rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
                this.f33643a.arcTo(this.f33644b, 180.0f, 90.0f, false);
            }
            this.f33643a.lineTo((e3.x + f2) - floatValue, e3.y - f3);
            if (i2 > 0) {
                RectF rectF4 = this.f33644b;
                float f13 = e3.x;
                float f14 = floatValue * 2.0f;
                float f15 = e3.y;
                rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
                this.f33643a.arcTo(this.f33644b, 270.0f, 90.0f, false);
            }
            this.f33643a.close();
            com.ksad.lottie.d.f.a(this.f33643a, this.f33650h);
            this.f33651i = true;
            return this.f33643a;
        }
        return (Path) invokeV.objValue;
    }
}
