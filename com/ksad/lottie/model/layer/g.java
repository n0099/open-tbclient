package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.n;
import com.ksad.lottie.m;
import com.ksad.lottie.model.a.k;
import com.ksad.lottie.model.content.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class g extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final char[] f33995e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f33996f;

    /* renamed from: g  reason: collision with root package name */
    public final Matrix f33997g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f33998h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f33999i;
    public final Map<com.ksad.lottie.model.d, List<com.ksad.lottie.a.a.c>> j;
    public final n k;
    public final com.ksad.lottie.f l;
    public final com.ksad.lottie.d m;
    @Nullable
    public com.ksad.lottie.a.b.a<Integer, Integer> n;
    @Nullable
    public com.ksad.lottie.a.b.a<Integer, Integer> o;
    @Nullable
    public com.ksad.lottie.a.b.a<Float, Float> p;
    @Nullable
    public com.ksad.lottie.a.b.a<Float, Float> q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        com.ksad.lottie.model.a.b bVar;
        com.ksad.lottie.model.a.b bVar2;
        com.ksad.lottie.model.a.a aVar;
        com.ksad.lottie.model.a.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, layer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.ksad.lottie.f) objArr2[0], (Layer) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33995e = new char[1];
        this.f33996f = new RectF();
        this.f33997g = new Matrix();
        this.f33998h = new Paint(this, 1) { // from class: com.ksad.lottie.model.layer.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f34000a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34000a = this;
                setStyle(Paint.Style.FILL);
            }
        };
        this.f33999i = new Paint(this, 1) { // from class: com.ksad.lottie.model.layer.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f34001a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34001a = this;
                setStyle(Paint.Style.STROKE);
            }
        };
        this.j = new HashMap();
        this.l = fVar;
        this.m = layer.a();
        n a2 = layer.s().a();
        this.k = a2;
        a2.a(this);
        a(this.k);
        k t = layer.t();
        if (t != null && (aVar2 = t.f33848a) != null) {
            com.ksad.lottie.a.b.a<Integer, Integer> a3 = aVar2.a();
            this.n = a3;
            a3.a(this);
            a(this.n);
        }
        if (t != null && (aVar = t.f33849b) != null) {
            com.ksad.lottie.a.b.a<Integer, Integer> a4 = aVar.a();
            this.o = a4;
            a4.a(this);
            a(this.o);
        }
        if (t != null && (bVar2 = t.f33850c) != null) {
            com.ksad.lottie.a.b.a<Float, Float> a5 = bVar2.a();
            this.p = a5;
            a5.a(this);
            a(this.p);
        }
        if (t == null || (bVar = t.f33851d) == null) {
            return;
        }
        com.ksad.lottie.a.b.a<Float, Float> a6 = bVar.a();
        this.q = a6;
        a6.a(this);
        a(this.q);
    }

    private List<com.ksad.lottie.a.a.c> a(com.ksad.lottie.model.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, dVar)) == null) {
            if (this.j.containsKey(dVar)) {
                return this.j.get(dVar);
            }
            List<j> a2 = dVar.a();
            int size = a2.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new com.ksad.lottie.a.a.c(this.l, this, a2.get(i2)));
            }
            this.j.put(dVar, arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private void a(char c2, com.ksad.lottie.model.b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Character.valueOf(c2), bVar, canvas}) == null) {
            char[] cArr = this.f33995e;
            cArr[0] = c2;
            if (bVar.k) {
                a(cArr, this.f33998h, canvas);
                a(this.f33995e, this.f33999i, canvas);
                return;
            }
            a(cArr, this.f33999i, canvas);
            a(this.f33995e, this.f33998h, canvas);
        }
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, this, path, paint, canvas) == null) || paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void a(com.ksad.lottie.model.b bVar, Matrix matrix, com.ksad.lottie.model.c cVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65540, this, bVar, matrix, cVar, canvas) == null) {
            float f2 = ((float) bVar.f33862c) / 100.0f;
            float a2 = com.ksad.lottie.d.f.a(matrix);
            String str = bVar.f33860a;
            for (int i2 = 0; i2 < str.length(); i2++) {
                com.ksad.lottie.model.d dVar = this.m.h().get(com.ksad.lottie.model.d.a(str.charAt(i2), cVar.a(), cVar.c()));
                if (dVar != null) {
                    a(dVar, matrix, f2, bVar, canvas);
                    float b2 = ((float) dVar.b()) * f2 * com.ksad.lottie.d.f.a() * a2;
                    float f3 = bVar.f33864e / 10.0f;
                    com.ksad.lottie.a.b.a<Float, Float> aVar = this.q;
                    if (aVar != null) {
                        f3 += aVar.e().floatValue();
                    }
                    canvas.translate(b2 + (f3 * a2), 0.0f);
                }
            }
        }
    }

    private void a(com.ksad.lottie.model.b bVar, com.ksad.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, this, bVar, cVar, matrix, canvas) == null) {
            float a2 = com.ksad.lottie.d.f.a(matrix);
            Typeface a3 = this.l.a(cVar.a(), cVar.c());
            if (a3 == null) {
                return;
            }
            String str = bVar.f33860a;
            m o = this.l.o();
            if (o != null) {
                str = o.a(str);
            }
            this.f33998h.setTypeface(a3);
            this.f33998h.setTextSize((float) (bVar.f33862c * com.ksad.lottie.d.f.a()));
            this.f33999i.setTypeface(this.f33998h.getTypeface());
            this.f33999i.setTextSize(this.f33998h.getTextSize());
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                a(charAt, bVar, canvas);
                char[] cArr = this.f33995e;
                cArr[0] = charAt;
                float measureText = this.f33998h.measureText(cArr, 0, 1);
                float f2 = bVar.f33864e / 10.0f;
                com.ksad.lottie.a.b.a<Float, Float> aVar = this.q;
                if (aVar != null) {
                    f2 += aVar.e().floatValue();
                }
                canvas.translate(measureText + (f2 * a2), 0.0f);
            }
        }
    }

    private void a(com.ksad.lottie.model.d dVar, Matrix matrix, float f2, com.ksad.lottie.model.b bVar, Canvas canvas) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{dVar, matrix, Float.valueOf(f2), bVar, canvas}) == null) {
            List<com.ksad.lottie.a.a.c> a2 = a(dVar);
            for (int i2 = 0; i2 < a2.size(); i2++) {
                Path d2 = a2.get(i2).d();
                d2.computeBounds(this.f33996f, false);
                this.f33997g.set(matrix);
                this.f33997g.preTranslate(0.0f, ((float) (-bVar.f33866g)) * com.ksad.lottie.d.f.a());
                this.f33997g.preScale(f2, f2);
                d2.transform(this.f33997g);
                if (bVar.k) {
                    a(d2, this.f33998h, canvas);
                    paint = this.f33999i;
                } else {
                    a(d2, this.f33999i, canvas);
                    paint = this.f33998h;
                }
                a(d2, paint, canvas);
            }
        }
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, this, cArr, paint, canvas) == null) || paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i2) {
        Paint paint;
        float a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, canvas, matrix, i2) == null) {
            canvas.save();
            if (!this.l.p()) {
                canvas.setMatrix(matrix);
            }
            com.ksad.lottie.model.b e2 = this.k.e();
            com.ksad.lottie.model.c cVar = this.m.i().get(e2.f33861b);
            if (cVar == null) {
                canvas.restore();
                return;
            }
            com.ksad.lottie.a.b.a<Integer, Integer> aVar = this.n;
            if (aVar != null) {
                this.f33998h.setColor(aVar.e().intValue());
            } else {
                this.f33998h.setColor(e2.f33867h);
            }
            com.ksad.lottie.a.b.a<Integer, Integer> aVar2 = this.o;
            if (aVar2 != null) {
                this.f33999i.setColor(aVar2.e().intValue());
            } else {
                this.f33999i.setColor(e2.f33868i);
            }
            int intValue = (this.f33970d.a().e().intValue() * 255) / 100;
            this.f33998h.setAlpha(intValue);
            this.f33999i.setAlpha(intValue);
            com.ksad.lottie.a.b.a<Float, Float> aVar3 = this.p;
            if (aVar3 != null) {
                paint = this.f33999i;
                a2 = aVar3.e().floatValue();
            } else {
                float a3 = com.ksad.lottie.d.f.a(matrix);
                paint = this.f33999i;
                a2 = (float) (e2.j * com.ksad.lottie.d.f.a() * a3);
            }
            paint.setStrokeWidth(a2);
            if (this.l.p()) {
                a(e2, matrix, cVar, canvas);
            } else {
                a(e2, cVar, matrix, canvas);
            }
            canvas.restore();
        }
    }
}
