package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class f implements d, j, a.InterfaceC0399a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Path f33600a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f33601b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f33602c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33603d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f33604e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Integer, Integer> f33605f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Integer, Integer> f33606g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> f33607h;

    /* renamed from: i  reason: collision with root package name */
    public final com.ksad.lottie.f f33608i;

    public f(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33600a = new Path();
        this.f33601b = new Paint(1);
        this.f33604e = new ArrayList();
        this.f33602c = aVar;
        this.f33603d = iVar.a();
        this.f33608i = fVar;
        if (iVar.b() == null || iVar.c() == null) {
            this.f33605f = null;
            this.f33606g = null;
            return;
        }
        this.f33600a.setFillType(iVar.d());
        com.ksad.lottie.a.b.a<Integer, Integer> a2 = iVar.b().a();
        this.f33605f = a2;
        a2.a(this);
        aVar.a(this.f33605f);
        com.ksad.lottie.a.b.a<Integer, Integer> a3 = iVar.c().a();
        this.f33606g = a3;
        a3.a(this);
        aVar.a(this.f33606g);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0399a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f33608i.invalidateSelf();
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) {
            com.ksad.lottie.c.c("FillContent#draw");
            this.f33601b.setColor(this.f33605f.e().intValue());
            this.f33601b.setAlpha(com.ksad.lottie.d.e.a((int) ((((i2 / 255.0f) * this.f33606g.e().intValue()) / 100.0f) * 255.0f), 0, 255));
            com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f33607h;
            if (aVar != null) {
                this.f33601b.setColorFilter(aVar.e());
            }
            this.f33600a.reset();
            for (int i3 = 0; i3 < this.f33604e.size(); i3++) {
                this.f33600a.addPath(this.f33604e.get(i3).d(), matrix);
            }
            canvas.drawPath(this.f33600a, this.f33601b);
            com.ksad.lottie.c.d("FillContent#draw");
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rectF, matrix) == null) {
            this.f33600a.reset();
            for (int i2 = 0; i2 < this.f33604e.size(); i2++) {
                this.f33600a.addPath(this.f33604e.get(i2).d(), matrix);
            }
            this.f33600a.computeBounds(rectF, false);
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
                    this.f33604e.add((l) bVar);
                }
            }
        }
    }
}
