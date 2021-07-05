package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g implements d, j, a.InterfaceC0399a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f33609a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f33610b;

    /* renamed from: c  reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f33611c;

    /* renamed from: d  reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f33612d;

    /* renamed from: e  reason: collision with root package name */
    public final Matrix f33613e;

    /* renamed from: f  reason: collision with root package name */
    public final Path f33614f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f33615g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f33616h;

    /* renamed from: i  reason: collision with root package name */
    public final List<l> f33617i;
    public final GradientType j;
    public final com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> k;
    public final com.ksad.lottie.a.b.a<Integer, Integer> l;
    public final com.ksad.lottie.a.b.a<PointF, PointF> m;
    public final com.ksad.lottie.a.b.a<PointF, PointF> n;
    @Nullable
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> o;
    public final com.ksad.lottie.f p;
    public final int q;

    public g(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33611c = new LongSparseArray<>();
        this.f33612d = new LongSparseArray<>();
        this.f33613e = new Matrix();
        this.f33614f = new Path();
        this.f33615g = new Paint(1);
        this.f33616h = new RectF();
        this.f33617i = new ArrayList();
        this.f33610b = aVar;
        this.f33609a = dVar.a();
        this.p = fVar;
        this.j = dVar.b();
        this.f33614f.setFillType(dVar.c());
        this.q = (int) (fVar.r().c() / 32.0f);
        com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> a2 = dVar.d().a();
        this.k = a2;
        a2.a(this);
        aVar.a(this.k);
        com.ksad.lottie.a.b.a<Integer, Integer> a3 = dVar.e().a();
        this.l = a3;
        a3.a(this);
        aVar.a(this.l);
        com.ksad.lottie.a.b.a<PointF, PointF> a4 = dVar.f().a();
        this.m = a4;
        a4.a(this);
        aVar.a(this.m);
        com.ksad.lottie.a.b.a<PointF, PointF> a5 = dVar.g().a();
        this.n = a5;
        a5.a(this);
        aVar.a(this.n);
    }

    private LinearGradient b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            long d2 = d();
            LinearGradient linearGradient = this.f33611c.get(d2);
            if (linearGradient != null) {
                return linearGradient;
            }
            PointF e2 = this.m.e();
            PointF e3 = this.n.e();
            com.ksad.lottie.model.content.c e4 = this.k.e();
            LinearGradient linearGradient2 = new LinearGradient(e2.x, e2.y, e3.x, e3.y, e4.b(), e4.a(), Shader.TileMode.CLAMP);
            this.f33611c.put(d2, linearGradient2);
            return linearGradient2;
        }
        return (LinearGradient) invokeV.objValue;
    }

    private RadialGradient c() {
        InterceptResult invokeV;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            long d2 = d();
            RadialGradient radialGradient = this.f33612d.get(d2);
            if (radialGradient != null) {
                return radialGradient;
            }
            PointF e2 = this.m.e();
            PointF e3 = this.n.e();
            com.ksad.lottie.model.content.c e4 = this.k.e();
            int[] b2 = e4.b();
            float[] a2 = e4.a();
            RadialGradient radialGradient2 = new RadialGradient(e2.x, e2.y, (float) Math.hypot(e3.x - f2, e3.y - f3), b2, a2, Shader.TileMode.CLAMP);
            this.f33612d.put(d2, radialGradient2);
            return radialGradient2;
        }
        return (RadialGradient) invokeV.objValue;
    }

    private int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int round = Math.round(this.m.f() * this.q);
            int round2 = Math.round(this.n.f() * this.q);
            int round3 = Math.round(this.k.f() * this.q);
            int i2 = round != 0 ? 527 * round : 17;
            if (round2 != 0) {
                i2 = i2 * 31 * round2;
            }
            return round3 != 0 ? i2 * 31 * round3 : i2;
        }
        return invokeV.intValue;
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0399a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.p.invalidateSelf();
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) {
            com.ksad.lottie.c.c("GradientFillContent#draw");
            this.f33614f.reset();
            for (int i3 = 0; i3 < this.f33617i.size(); i3++) {
                this.f33614f.addPath(this.f33617i.get(i3).d(), matrix);
            }
            this.f33614f.computeBounds(this.f33616h, false);
            Shader b2 = this.j == GradientType.Linear ? b() : c();
            this.f33613e.set(matrix);
            b2.setLocalMatrix(this.f33613e);
            this.f33615g.setShader(b2);
            com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.o;
            if (aVar != null) {
                this.f33615g.setColorFilter(aVar.e());
            }
            this.f33615g.setAlpha(com.ksad.lottie.d.e.a((int) ((((i2 / 255.0f) * this.l.e().intValue()) / 100.0f) * 255.0f), 0, 255));
            canvas.drawPath(this.f33614f, this.f33615g);
            com.ksad.lottie.c.d("GradientFillContent#draw");
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rectF, matrix) == null) {
            this.f33614f.reset();
            for (int i2 = 0; i2 < this.f33617i.size(); i2++) {
                this.f33614f.addPath(this.f33617i.get(i2).d(), matrix);
            }
            this.f33614f.computeBounds(rectF, false);
            rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, list2) == null) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                b bVar = list2.get(i2);
                if (bVar instanceof l) {
                    this.f33617i.add((l) bVar);
                }
            }
        }
    }
}
