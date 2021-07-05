package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
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
/* loaded from: classes7.dex */
public class f extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f33990e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f33991f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f33992g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f33993h;

    /* renamed from: i  reason: collision with root package name */
    public final Layer f33994i;
    @Nullable
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
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
        this.f33990e = new RectF();
        this.f33991f = new Paint();
        this.f33992g = new float[8];
        this.f33993h = new Path();
        this.f33994i = layer;
        this.f33991f.setAlpha(0);
        this.f33991f.setStyle(Paint.Style.FILL);
        this.f33991f.setColor(layer.p());
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, rectF, matrix) == null) {
            super.a(rectF, matrix);
            this.f33990e.set(0.0f, 0.0f, this.f33994i.r(), this.f33994i.q());
            this.f33967a.mapRect(this.f33990e);
            rectF.set(this.f33990e);
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i2) {
        int alpha;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) || (alpha = Color.alpha(this.f33994i.p())) == 0) {
            return;
        }
        int intValue = (int) ((i2 / 255.0f) * (((alpha / 255.0f) * this.f33970d.a().e().intValue()) / 100.0f) * 255.0f);
        this.f33991f.setAlpha(intValue);
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.j;
        if (aVar != null) {
            this.f33991f.setColorFilter(aVar.e());
        }
        if (intValue > 0) {
            float[] fArr = this.f33992g;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f33994i.r();
            float[] fArr2 = this.f33992g;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f33994i.r();
            this.f33992g[5] = this.f33994i.q();
            float[] fArr3 = this.f33992g;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f33994i.q();
            matrix.mapPoints(this.f33992g);
            this.f33993h.reset();
            Path path = this.f33993h;
            float[] fArr4 = this.f33992g;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f33993h;
            float[] fArr5 = this.f33992g;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f33993h;
            float[] fArr6 = this.f33992g;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f33993h;
            float[] fArr7 = this.f33992g;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f33993h;
            float[] fArr8 = this.f33992g;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f33993h.close();
            canvas.drawPath(this.f33993h, this.f33991f);
        }
    }
}
