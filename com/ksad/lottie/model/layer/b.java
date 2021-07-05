package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.ksad.lottie.a.b.a<Float, Float> f33980e;

    /* renamed from: f  reason: collision with root package name */
    public final List<a> f33981f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f33982g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f33983h;

    /* renamed from: com.ksad.lottie.model.layer.b$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33984a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-532447658, "Lcom/ksad/lottie/model/layer/b$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-532447658, "Lcom/ksad/lottie/model/layer/b$1;");
                    return;
                }
            }
            int[] iArr = new int[Layer.MatteType.values().length];
            f33984a = iArr;
            try {
                iArr[Layer.MatteType.Add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33984a[Layer.MatteType.Invert.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.ksad.lottie.f fVar, Layer layer, List<Layer> list, com.ksad.lottie.d dVar) {
        super(fVar, layer);
        int i2;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, layer, list, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.ksad.lottie.f) objArr2[0], (Layer) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33981f = new ArrayList();
        this.f33982g = new RectF();
        this.f33983h = new RectF();
        com.ksad.lottie.model.a.b u = layer.u();
        if (u != null) {
            com.ksad.lottie.a.b.a<Float, Float> a2 = u.a();
            this.f33980e = a2;
            a(a2);
            this.f33980e.a(this);
        } else {
            this.f33980e = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.g().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            a a3 = a.a(layer2, fVar, dVar);
            if (a3 != null) {
                longSparseArray.put(a3.b().e(), a3);
                if (aVar2 != null) {
                    aVar2.a(a3);
                    aVar2 = null;
                } else {
                    this.f33981f.add(0, a3);
                    int i5 = AnonymousClass1.f33984a[layer2.l().ordinal()];
                    if (i5 == 1 || i5 == 2) {
                        aVar2 = a3;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.size(); i2++) {
            a aVar3 = (a) longSparseArray.get(longSparseArray.keyAt(i2));
            if (aVar3 != null && (aVar = (a) longSparseArray.get(aVar3.b().m())) != null) {
                aVar3.b(aVar);
            }
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            super.a(f2);
            if (this.f33980e != null) {
                f2 = (this.f33980e.e().floatValue() * 1000.0f) / this.f33968b.r().c();
            }
            if (this.f33969c.b() != 0.0f) {
                f2 /= this.f33969c.b();
            }
            float c2 = f2 - this.f33969c.c();
            for (int size = this.f33981f.size() - 1; size >= 0; size--) {
                this.f33981f.get(size).a(c2);
            }
        }
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rectF, matrix) == null) {
            super.a(rectF, matrix);
            this.f33982g.set(0.0f, 0.0f, 0.0f, 0.0f);
            for (int size = this.f33981f.size() - 1; size >= 0; size--) {
                this.f33981f.get(size).a(this.f33982g, this.f33967a);
                if (rectF.isEmpty()) {
                    rectF.set(this.f33982g);
                } else {
                    rectF.set(Math.min(rectF.left, this.f33982g.left), Math.min(rectF.top, this.f33982g.top), Math.max(rectF.right, this.f33982g.right), Math.max(rectF.bottom, this.f33982g.bottom));
                }
            }
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, canvas, matrix, i2) == null) {
            com.ksad.lottie.c.c("CompositionLayer#draw");
            canvas.save();
            this.f33983h.set(0.0f, 0.0f, this.f33969c.h(), this.f33969c.i());
            matrix.mapRect(this.f33983h);
            for (int size = this.f33981f.size() - 1; size >= 0; size--) {
                if (!this.f33983h.isEmpty() ? canvas.clipRect(this.f33983h) : true) {
                    this.f33981f.get(size).a(canvas, matrix, i2);
                }
            }
            canvas.restore();
            com.ksad.lottie.c.d("CompositionLayer#draw");
        }
    }
}
