package com.ksad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
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
public class e implements j, l, a.InterfaceC0399a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Path f33592a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33593b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f33594c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, PointF> f33595d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, PointF> f33596e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.content.a f33597f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public r f33598g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33599h;

    public e(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33592a = new Path();
        this.f33593b = aVar2.a();
        this.f33594c = fVar;
        this.f33595d = aVar2.c().a();
        this.f33596e = aVar2.b().a();
        this.f33597f = aVar2;
        aVar.a(this.f33595d);
        aVar.a(this.f33596e);
        this.f33595d.a(this);
        this.f33596e.a(this);
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f33599h = false;
            this.f33594c.invalidateSelf();
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
                        this.f33598g = rVar;
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
            if (this.f33599h) {
                return this.f33592a;
            }
            this.f33592a.reset();
            PointF e2 = this.f33595d.e();
            float f2 = e2.x / 2.0f;
            float f3 = e2.y / 2.0f;
            float f4 = f2 * 0.55228f;
            float f5 = 0.55228f * f3;
            this.f33592a.reset();
            if (this.f33597f.d()) {
                float f6 = -f3;
                this.f33592a.moveTo(0.0f, f6);
                float f7 = 0.0f - f4;
                float f8 = -f2;
                float f9 = 0.0f - f5;
                this.f33592a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
                float f10 = f5 + 0.0f;
                this.f33592a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
                float f11 = f4 + 0.0f;
                this.f33592a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
                this.f33592a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
            } else {
                float f12 = -f3;
                this.f33592a.moveTo(0.0f, f12);
                float f13 = f4 + 0.0f;
                float f14 = 0.0f - f5;
                this.f33592a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
                float f15 = f5 + 0.0f;
                this.f33592a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
                float f16 = 0.0f - f4;
                float f17 = -f2;
                this.f33592a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
                this.f33592a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
            }
            PointF e3 = this.f33596e.e();
            this.f33592a.offset(e3.x, e3.y);
            this.f33592a.close();
            com.ksad.lottie.d.f.a(this.f33592a, this.f33598g);
            this.f33599h = true;
            return this.f33592a;
        }
        return (Path) invokeV.objValue;
    }
}
