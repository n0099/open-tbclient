package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.model.content.GradientType;
import java.util.List;
/* loaded from: classes7.dex */
public class h extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f33618b;

    /* renamed from: c  reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f33619c;

    /* renamed from: d  reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f33620d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f33621e;

    /* renamed from: f  reason: collision with root package name */
    public final GradientType f33622f;

    /* renamed from: g  reason: collision with root package name */
    public final int f33623g;

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> f33624h;

    /* renamed from: i  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<PointF, PointF> f33625i;
    public final com.ksad.lottie.a.b.a<PointF, PointF> j;

    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: com.ksad.lottie.a.a.h */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.h().toPaintCap(), eVar.i().toPaintJoin(), eVar.l(), eVar.d(), eVar.g(), eVar.j(), eVar.k());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {fVar, aVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.ksad.lottie.f) objArr2[0], (com.ksad.lottie.model.layer.a) objArr2[1], (Paint.Cap) objArr2[2], (Paint.Join) objArr2[3], ((Float) objArr2[4]).floatValue(), (com.ksad.lottie.model.a.d) objArr2[5], (com.ksad.lottie.model.a.b) objArr2[6], (List) objArr2[7], (com.ksad.lottie.model.a.b) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33619c = new LongSparseArray<>();
        this.f33620d = new LongSparseArray<>();
        this.f33621e = new RectF();
        this.f33618b = eVar.a();
        this.f33622f = eVar.b();
        fVar.r().c();
        this.f33623g = (int) (this / 32.0f);
        com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> a2 = eVar.c().a();
        this.f33624h = a2;
        a2.a(this);
        aVar.a(this.f33624h);
        com.ksad.lottie.a.b.a<PointF, PointF> a3 = eVar.e().a();
        this.f33625i = a3;
        a3.a(this);
        aVar.a(this.f33625i);
        com.ksad.lottie.a.b.a<PointF, PointF> a4 = eVar.f().a();
        this.j = a4;
        a4.a(this);
        aVar.a(this.j);
    }

    private LinearGradient b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            long d2 = d();
            LinearGradient linearGradient = this.f33619c.get(d2);
            if (linearGradient != null) {
                return linearGradient;
            }
            PointF e2 = this.f33625i.e();
            PointF e3 = this.j.e();
            com.ksad.lottie.model.content.c e4 = this.f33624h.e();
            int[] b2 = e4.b();
            float[] a2 = e4.a();
            RectF rectF = this.f33621e;
            int width = (int) (rectF.left + (rectF.width() / 2.0f) + e2.x);
            RectF rectF2 = this.f33621e;
            int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + e2.y);
            RectF rectF3 = this.f33621e;
            int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + e3.x);
            RectF rectF4 = this.f33621e;
            LinearGradient linearGradient2 = new LinearGradient(width, height, width2, (int) (rectF4.top + (rectF4.height() / 2.0f) + e3.y), b2, a2, Shader.TileMode.CLAMP);
            this.f33619c.put(d2, linearGradient2);
            return linearGradient2;
        }
        return (LinearGradient) invokeV.objValue;
    }

    private RadialGradient c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            long d2 = d();
            RadialGradient radialGradient = this.f33620d.get(d2);
            if (radialGradient != null) {
                return radialGradient;
            }
            PointF e2 = this.f33625i.e();
            PointF e3 = this.j.e();
            com.ksad.lottie.model.content.c e4 = this.f33624h.e();
            int[] b2 = e4.b();
            float[] a2 = e4.a();
            RectF rectF = this.f33621e;
            int width = (int) (rectF.left + (rectF.width() / 2.0f) + e2.x);
            RectF rectF2 = this.f33621e;
            int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + e2.y);
            RectF rectF3 = this.f33621e;
            int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + e3.x);
            RectF rectF4 = this.f33621e;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(width2 - width, ((int) ((rectF4.top + (rectF4.height() / 2.0f)) + e3.y)) - height), b2, a2, Shader.TileMode.CLAMP);
            this.f33620d.put(d2, radialGradient2);
            return radialGradient2;
        }
        return (RadialGradient) invokeV.objValue;
    }

    private int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int round = Math.round(this.f33625i.f() * this.f33623g);
            int round2 = Math.round(this.j.f() * this.f33623g);
            int round3 = Math.round(this.f33624h.f() * this.f33623g);
            int i2 = round != 0 ? 527 * round : 17;
            if (round2 != 0) {
                i2 = i2 * 31 * round2;
            }
            return round3 != 0 ? i2 * 31 * round3 : i2;
        }
        return invokeV.intValue;
    }

    @Override // com.ksad.lottie.a.a.a, com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Paint paint;
        Shader c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, canvas, matrix, i2) == null) {
            a(this.f33621e, matrix);
            if (this.f33622f == GradientType.Linear) {
                paint = this.f33573a;
                c2 = b();
            } else {
                paint = this.f33573a;
                c2 = c();
            }
            paint.setShader(c2);
            super.a(canvas, matrix, i2);
        }
    }
}
