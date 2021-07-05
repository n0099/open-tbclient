package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a implements d, j, a.InterfaceC0399a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Paint f33573a;

    /* renamed from: b  reason: collision with root package name */
    public final PathMeasure f33574b;

    /* renamed from: c  reason: collision with root package name */
    public final Path f33575c;

    /* renamed from: d  reason: collision with root package name */
    public final Path f33576d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f33577e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.f f33578f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f33579g;

    /* renamed from: h  reason: collision with root package name */
    public final List<C0398a> f33580h;

    /* renamed from: i  reason: collision with root package name */
    public final float[] f33581i;
    public final com.ksad.lottie.a.b.a<?, Float> j;
    public final com.ksad.lottie.a.b.a<?, Integer> k;
    public final List<com.ksad.lottie.a.b.a<?, Float>> l;
    @Nullable
    public final com.ksad.lottie.a.b.a<?, Float> m;
    @Nullable
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> n;

    /* renamed from: com.ksad.lottie.a.a.a$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.ksad.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0398a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<l> f33582a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final r f33583b;

        public C0398a(@Nullable r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33582a = new ArrayList();
            this.f33583b = rVar;
        }

        public /* synthetic */ C0398a(r rVar, AnonymousClass1 anonymousClass1) {
            this(rVar);
        }
    }

    public a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f2, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.b bVar, List<com.ksad.lottie.model.a.b> list, com.ksad.lottie.model.a.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, cap, join, Float.valueOf(f2), dVar, bVar, list, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33574b = new PathMeasure();
        this.f33575c = new Path();
        this.f33576d = new Path();
        this.f33577e = new RectF();
        this.f33580h = new ArrayList();
        Paint paint = new Paint(1);
        this.f33573a = paint;
        this.f33578f = fVar;
        this.f33579g = aVar;
        paint.setStyle(Paint.Style.STROKE);
        this.f33573a.setStrokeCap(cap);
        this.f33573a.setStrokeJoin(join);
        this.f33573a.setStrokeMiter(f2);
        this.k = dVar.a();
        this.j = bVar.a();
        this.m = bVar2 == null ? null : bVar2.a();
        this.l = new ArrayList(list.size());
        this.f33581i = new float[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.l.add(list.get(i4).a());
        }
        aVar.a(this.k);
        aVar.a(this.j);
        for (int i5 = 0; i5 < this.l.size(); i5++) {
            aVar.a(this.l.get(i5));
        }
        com.ksad.lottie.a.b.a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.l.get(i6).a(this);
        }
        com.ksad.lottie.a.b.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    private void a(Canvas canvas, C0398a c0398a, Matrix matrix) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, canvas, c0398a, matrix) == null) {
            com.ksad.lottie.c.c("StrokeContent#applyTrimPath");
            if (c0398a.f33583b == null) {
                com.ksad.lottie.c.d("StrokeContent#applyTrimPath");
                return;
            }
            this.f33575c.reset();
            for (int size = c0398a.f33582a.size() - 1; size >= 0; size--) {
                this.f33575c.addPath(((l) c0398a.f33582a.get(size)).d(), matrix);
            }
            this.f33574b.setPath(this.f33575c, false);
            float length = this.f33574b.getLength();
            while (this.f33574b.nextContour()) {
                length += this.f33574b.getLength();
            }
            float floatValue = (c0398a.f33583b.e().e().floatValue() * length) / 360.0f;
            float floatValue2 = ((c0398a.f33583b.c().e().floatValue() * length) / 100.0f) + floatValue;
            float floatValue3 = ((c0398a.f33583b.d().e().floatValue() * length) / 100.0f) + floatValue;
            float f3 = 0.0f;
            for (int size2 = c0398a.f33582a.size() - 1; size2 >= 0; size2--) {
                this.f33576d.set(((l) c0398a.f33582a.get(size2)).d());
                this.f33576d.transform(matrix);
                this.f33574b.setPath(this.f33576d, false);
                float length2 = this.f33574b.getLength();
                float f4 = 1.0f;
                if (floatValue3 > length) {
                    float f5 = floatValue3 - length;
                    if (f5 < f3 + length2 && f3 < f5) {
                        f2 = floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f;
                        f4 = Math.min(f5 / length2, 1.0f);
                        com.ksad.lottie.d.f.a(this.f33576d, f2, f4, 0.0f);
                        canvas.drawPath(this.f33576d, this.f33573a);
                        f3 += length2;
                    }
                }
                float f6 = f3 + length2;
                if (f6 >= floatValue2 && f3 <= floatValue3) {
                    if (f6 > floatValue3 || floatValue2 >= f3) {
                        f2 = floatValue2 < f3 ? 0.0f : (floatValue2 - f3) / length2;
                        if (floatValue3 <= f6) {
                            f4 = (floatValue3 - f3) / length2;
                        }
                        com.ksad.lottie.d.f.a(this.f33576d, f2, f4, 0.0f);
                    }
                    canvas.drawPath(this.f33576d, this.f33573a);
                }
                f3 += length2;
            }
            com.ksad.lottie.c.d("StrokeContent#applyTrimPath");
        }
    }

    private void a(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, matrix) == null) {
            com.ksad.lottie.c.c("StrokeContent#applyDashPattern");
            if (this.l.isEmpty()) {
                com.ksad.lottie.c.d("StrokeContent#applyDashPattern");
                return;
            }
            float a2 = com.ksad.lottie.d.f.a(matrix);
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                this.f33581i[i2] = this.l.get(i2).e().floatValue();
                if (i2 % 2 == 0) {
                    float[] fArr = this.f33581i;
                    if (fArr[i2] < 1.0f) {
                        fArr[i2] = 1.0f;
                    }
                } else {
                    float[] fArr2 = this.f33581i;
                    if (fArr2[i2] < 0.1f) {
                        fArr2[i2] = 0.1f;
                    }
                }
                float[] fArr3 = this.f33581i;
                fArr3[i2] = fArr3[i2] * a2;
            }
            com.ksad.lottie.a.b.a<?, Float> aVar = this.m;
            this.f33573a.setPathEffect(new DashPathEffect(this.f33581i, aVar == null ? 0.0f : aVar.e().floatValue()));
            com.ksad.lottie.c.d("StrokeContent#applyDashPattern");
        }
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0399a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f33578f.invalidateSelf();
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) {
            com.ksad.lottie.c.c("StrokeContent#draw");
            this.f33573a.setAlpha(com.ksad.lottie.d.e.a((int) ((((i2 / 255.0f) * this.k.e().intValue()) / 100.0f) * 255.0f), 0, 255));
            this.f33573a.setStrokeWidth(this.j.e().floatValue() * com.ksad.lottie.d.f.a(matrix));
            if (this.f33573a.getStrokeWidth() <= 0.0f) {
                com.ksad.lottie.c.d("StrokeContent#draw");
                return;
            }
            a(matrix);
            com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.n;
            if (aVar != null) {
                this.f33573a.setColorFilter(aVar.e());
            }
            for (int i3 = 0; i3 < this.f33580h.size(); i3++) {
                C0398a c0398a = this.f33580h.get(i3);
                if (c0398a.f33583b != null) {
                    a(canvas, c0398a, matrix);
                } else {
                    com.ksad.lottie.c.c("StrokeContent#buildPath");
                    this.f33575c.reset();
                    for (int size = c0398a.f33582a.size() - 1; size >= 0; size--) {
                        this.f33575c.addPath(((l) c0398a.f33582a.get(size)).d(), matrix);
                    }
                    com.ksad.lottie.c.d("StrokeContent#buildPath");
                    com.ksad.lottie.c.c("StrokeContent#drawPath");
                    canvas.drawPath(this.f33575c, this.f33573a);
                    com.ksad.lottie.c.d("StrokeContent#drawPath");
                }
            }
            com.ksad.lottie.c.d("StrokeContent#draw");
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rectF, matrix) == null) {
            com.ksad.lottie.c.c("StrokeContent#getBounds");
            this.f33575c.reset();
            for (int i2 = 0; i2 < this.f33580h.size(); i2++) {
                C0398a c0398a = this.f33580h.get(i2);
                for (int i3 = 0; i3 < c0398a.f33582a.size(); i3++) {
                    this.f33575c.addPath(((l) c0398a.f33582a.get(i3)).d(), matrix);
                }
            }
            this.f33575c.computeBounds(this.f33577e, false);
            float floatValue = this.j.e().floatValue();
            RectF rectF2 = this.f33577e;
            float f2 = floatValue / 2.0f;
            rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
            rectF.set(this.f33577e);
            rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
            com.ksad.lottie.c.d("StrokeContent#getBounds");
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, list2) == null) {
            r rVar = null;
            for (int size = list.size() - 1; size >= 0; size--) {
                b bVar = list.get(size);
                if (bVar instanceof r) {
                    r rVar2 = (r) bVar;
                    if (rVar2.b() == ShapeTrimPath.Type.Individually) {
                        rVar = rVar2;
                    }
                }
            }
            if (rVar != null) {
                rVar.a(this);
            }
            C0398a c0398a = null;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                b bVar2 = list2.get(size2);
                if (bVar2 instanceof r) {
                    r rVar3 = (r) bVar2;
                    if (rVar3.b() == ShapeTrimPath.Type.Individually) {
                        if (c0398a != null) {
                            this.f33580h.add(c0398a);
                        }
                        c0398a = new C0398a(rVar3, null);
                        rVar3.a(this);
                    }
                }
                if (bVar2 instanceof l) {
                    if (c0398a == null) {
                        c0398a = new C0398a(rVar, null);
                    }
                    c0398a.f33582a.add((l) bVar2);
                }
            }
            if (c0398a != null) {
                this.f33580h.add(c0398a);
            }
        }
    }
}
