package com.ksad.lottie.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.a.b.o;
import com.ksad.lottie.model.content.Mask;
import com.ksad.lottie.model.content.h;
import com.ksad.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a implements com.ksad.lottie.a.a.d, a.InterfaceC0399a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f33967a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.f f33968b;

    /* renamed from: c  reason: collision with root package name */
    public final Layer f33969c;

    /* renamed from: d  reason: collision with root package name */
    public final o f33970d;

    /* renamed from: e  reason: collision with root package name */
    public final Path f33971e;

    /* renamed from: f  reason: collision with root package name */
    public final Matrix f33972f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f33973g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f33974h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f33975i;
    public final Paint j;
    public final Paint k;
    public final RectF l;
    public final RectF m;
    public final RectF n;
    public final RectF o;
    public final String p;
    @Nullable
    public com.ksad.lottie.a.b.g q;
    @Nullable
    public a r;
    @Nullable
    public a s;
    public List<a> t;
    public final List<com.ksad.lottie.a.b.a<?, ?>> u;
    public boolean v;

    /* renamed from: com.ksad.lottie.model.layer.a$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33978a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f33979b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-532477418, "Lcom/ksad/lottie/model/layer/a$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-532477418, "Lcom/ksad/lottie/model/layer/a$2;");
                    return;
                }
            }
            int[] iArr = new int[Mask.MaskMode.values().length];
            f33979b = iArr;
            try {
                iArr[Mask.MaskMode.MaskModeSubtract.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33979b[Mask.MaskMode.MaskModeIntersect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33979b[Mask.MaskMode.MaskModeAdd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f33978a = iArr2;
            try {
                iArr2[Layer.LayerType.Shape.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33978a[Layer.LayerType.PreComp.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33978a[Layer.LayerType.Solid.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33978a[Layer.LayerType.Image.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33978a[Layer.LayerType.Null.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33978a[Layer.LayerType.Text.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33978a[Layer.LayerType.Unknown.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public a(com.ksad.lottie.f fVar, Layer layer) {
        Paint paint;
        PorterDuffXfermode porterDuffXfermode;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, layer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33971e = new Path();
        this.f33972f = new Matrix();
        this.f33973g = new Paint(1);
        this.f33974h = new Paint(1);
        this.f33975i = new Paint(1);
        this.j = new Paint(1);
        this.k = new Paint();
        this.l = new RectF();
        this.m = new RectF();
        this.n = new RectF();
        this.o = new RectF();
        this.f33967a = new Matrix();
        this.u = new ArrayList();
        this.v = true;
        this.f33968b = fVar;
        this.f33969c = layer;
        this.p = layer.f() + "#draw";
        this.k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f33974h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f33975i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.l() == Layer.MatteType.Invert) {
            paint = this.j;
            porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        } else {
            paint = this.j;
            porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        }
        paint.setXfermode(porterDuffXfermode);
        o h2 = layer.o().h();
        this.f33970d = h2;
        h2.a((a.InterfaceC0399a) this);
        if (layer.j() != null && !layer.j().isEmpty()) {
            com.ksad.lottie.a.b.g gVar = new com.ksad.lottie.a.b.g(layer.j());
            this.q = gVar;
            for (com.ksad.lottie.a.b.a<h, Path> aVar : gVar.b()) {
                aVar.a(this);
            }
            for (com.ksad.lottie.a.b.a<Integer, Integer> aVar2 : this.q.c()) {
                a(aVar2);
                aVar2.a(this);
            }
        }
        e();
    }

    @Nullable
    public static a a(Layer layer, com.ksad.lottie.f fVar, com.ksad.lottie.d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, layer, fVar, dVar)) == null) {
            switch (AnonymousClass2.f33978a[layer.k().ordinal()]) {
                case 1:
                    return new e(fVar, layer);
                case 2:
                    return new b(fVar, layer, dVar.b(layer.g()), dVar);
                case 3:
                    return new f(fVar, layer);
                case 4:
                    return new c(fVar, layer);
                case 5:
                    return new d(fVar, layer);
                case 6:
                    return new g(fVar, layer);
                default:
                    com.ksad.lottie.c.b("Unknown layer type " + layer.k());
                    return null;
            }
        }
        return (a) invokeLLL.objValue;
    }

    private void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, canvas) == null) {
            com.ksad.lottie.c.c("Layer#clearLayer");
            RectF rectF = this.l;
            canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.k);
            com.ksad.lottie.c.d("Layer#clearLayer");
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, canvas, matrix) == null) {
            a(canvas, matrix, Mask.MaskMode.MaskModeAdd);
            a(canvas, matrix, Mask.MaskMode.MaskModeIntersect);
            a(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
        }
    }

    private void a(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65540, this, canvas, matrix, maskMode) == null) {
            boolean z = true;
            Paint paint = AnonymousClass2.f33979b[maskMode.ordinal()] != 1 ? this.f33974h : this.f33975i;
            int size = this.q.a().size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    break;
                } else if (this.q.a().get(i2).a() == maskMode) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                com.ksad.lottie.c.c("Layer#drawMask");
                com.ksad.lottie.c.c("Layer#saveLayer");
                a(canvas, this.l, paint, false);
                com.ksad.lottie.c.d("Layer#saveLayer");
                a(canvas);
                for (int i3 = 0; i3 < size; i3++) {
                    if (this.q.a().get(i3).a() == maskMode) {
                        this.f33971e.set(this.q.b().get(i3).e());
                        this.f33971e.transform(matrix);
                        int alpha = this.f33973g.getAlpha();
                        this.f33973g.setAlpha((int) (this.q.c().get(i3).e().intValue() * 2.55f));
                        canvas.drawPath(this.f33971e, this.f33973g);
                        this.f33973g.setAlpha(alpha);
                    }
                }
                com.ksad.lottie.c.c("Layer#restoreLayer");
                canvas.restore();
                com.ksad.lottie.c.d("Layer#restoreLayer");
                com.ksad.lottie.c.d("Layer#drawMask");
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{canvas, rectF, paint, Boolean.valueOf(z)}) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                canvas.saveLayer(rectF, paint, z ? 31 : 19);
            } else {
                canvas.saveLayer(rectF, paint);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65543, this, z) == null) || z == this.v) {
            return;
        }
        this.v = z;
        f();
    }

    private void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65544, this, f2) == null) {
            this.f33968b.r().a().a(this.f33969c.f(), f2);
        }
    }

    private void b(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, rectF, matrix) == null) {
            this.m.set(0.0f, 0.0f, 0.0f, 0.0f);
            if (d()) {
                int size = this.q.a().size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f33971e.set(this.q.b().get(i2).e());
                    this.f33971e.transform(matrix);
                    int i3 = AnonymousClass2.f33979b[this.q.a().get(i2).a().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        return;
                    }
                    this.f33971e.computeBounds(this.o, false);
                    RectF rectF2 = this.m;
                    if (i2 == 0) {
                        rectF2.set(this.o);
                    } else {
                        rectF2.set(Math.min(rectF2.left, this.o.left), Math.min(this.m.top, this.o.top), Math.max(this.m.right, this.o.right), Math.max(this.m.bottom, this.o.bottom));
                    }
                }
                rectF.set(Math.max(rectF.left, this.m.left), Math.max(rectF.top, this.m.top), Math.min(rectF.right, this.m.right), Math.min(rectF.bottom, this.m.bottom));
            }
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, this, rectF, matrix) == null) && c() && this.f33969c.l() != Layer.MatteType.Invert) {
            this.r.a(this.n, matrix);
            rectF.set(Math.max(rectF.left, this.n.left), Math.max(rectF.top, this.n.top), Math.min(rectF.right, this.n.right), Math.min(rectF.bottom, this.n.bottom));
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (this.f33969c.d().isEmpty()) {
                a(true);
                return;
            }
            com.ksad.lottie.a.b.c cVar = new com.ksad.lottie.a.b.c(this.f33969c.d());
            cVar.a();
            cVar.a(new a.InterfaceC0399a(this, cVar) { // from class: com.ksad.lottie.model.layer.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ksad.lottie.a.b.c f33976a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f33977b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f33977b = this;
                    this.f33976a = cVar;
                }

                @Override // com.ksad.lottie.a.b.a.InterfaceC0399a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f33977b.a(this.f33976a.e().floatValue() == 1.0f);
                    }
                }
            });
            a(cVar.e().floatValue() == 1.0f);
            a(cVar);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f33968b.invalidateSelf();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.t == null) {
            if (this.s == null) {
                this.t = Collections.emptyList();
                return;
            }
            this.t = new ArrayList();
            for (a aVar = this.s; aVar != null; aVar = aVar.s) {
                this.t.add(aVar);
            }
        }
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0399a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f();
        }
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f33970d.a(f2);
            if (this.q != null) {
                for (int i2 = 0; i2 < this.q.b().size(); i2++) {
                    this.q.b().get(i2).a(f2);
                }
            }
            if (this.f33969c.b() != 0.0f) {
                f2 /= this.f33969c.b();
            }
            a aVar = this.r;
            if (aVar != null) {
                this.r.a(aVar.f33969c.b() * f2);
            }
            for (int i3 = 0; i3 < this.u.size(); i3++) {
                this.u.get(i3).a(f2);
            }
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, canvas, matrix, i2) == null) {
            com.ksad.lottie.c.c(this.p);
            if (!this.v) {
                com.ksad.lottie.c.d(this.p);
                return;
            }
            g();
            com.ksad.lottie.c.c("Layer#parentMatrix");
            this.f33972f.reset();
            this.f33972f.set(matrix);
            for (int size = this.t.size() - 1; size >= 0; size--) {
                this.f33972f.preConcat(this.t.get(size).f33970d.d());
            }
            com.ksad.lottie.c.d("Layer#parentMatrix");
            int intValue = (int) ((((i2 / 255.0f) * this.f33970d.a().e().intValue()) / 100.0f) * 255.0f);
            if (!c() && !d()) {
                this.f33972f.preConcat(this.f33970d.d());
                com.ksad.lottie.c.c("Layer#drawLayer");
                b(canvas, this.f33972f, intValue);
                com.ksad.lottie.c.d("Layer#drawLayer");
                b(com.ksad.lottie.c.d(this.p));
                return;
            }
            com.ksad.lottie.c.c("Layer#computeBounds");
            this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(this.l, this.f33972f);
            c(this.l, this.f33972f);
            this.f33972f.preConcat(this.f33970d.d());
            b(this.l, this.f33972f);
            this.l.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            com.ksad.lottie.c.d("Layer#computeBounds");
            com.ksad.lottie.c.c("Layer#saveLayer");
            a(canvas, this.l, this.f33973g, true);
            com.ksad.lottie.c.d("Layer#saveLayer");
            a(canvas);
            com.ksad.lottie.c.c("Layer#drawLayer");
            b(canvas, this.f33972f, intValue);
            com.ksad.lottie.c.d("Layer#drawLayer");
            if (d()) {
                a(canvas, this.f33972f);
            }
            if (c()) {
                com.ksad.lottie.c.c("Layer#drawMatte");
                com.ksad.lottie.c.c("Layer#saveLayer");
                a(canvas, this.l, this.j, false);
                com.ksad.lottie.c.d("Layer#saveLayer");
                a(canvas);
                this.r.a(canvas, matrix, intValue);
                com.ksad.lottie.c.c("Layer#restoreLayer");
                canvas.restore();
                com.ksad.lottie.c.d("Layer#restoreLayer");
                com.ksad.lottie.c.d("Layer#drawMatte");
            }
            com.ksad.lottie.c.c("Layer#restoreLayer");
            canvas.restore();
            com.ksad.lottie.c.d("Layer#restoreLayer");
            b(com.ksad.lottie.c.d(this.p));
        }
    }

    @Override // com.ksad.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, rectF, matrix) == null) {
            this.f33967a.set(matrix);
            this.f33967a.preConcat(this.f33970d.d());
        }
    }

    public void a(com.ksad.lottie.a.b.a<?, ?> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.u.add(aVar);
        }
    }

    public void a(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.r = aVar;
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<com.ksad.lottie.a.a.b> list, List<com.ksad.lottie.a.a.b> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
        }
    }

    public Layer b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f33969c : (Layer) invokeV.objValue;
    }

    public abstract void b(Canvas canvas, Matrix matrix, int i2);

    public void b(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.s = aVar;
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.r != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            com.ksad.lottie.a.b.g gVar = this.q;
            return (gVar == null || gVar.b().isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
