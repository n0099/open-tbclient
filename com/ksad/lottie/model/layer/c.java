package com.ksad.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f33985e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f33986f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f33987g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> f33988h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.ksad.lottie.f fVar, Layer layer) {
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
        this.f33985e = new Paint(3);
        this.f33986f = new Rect();
        this.f33987g = new Rect();
    }

    @Nullable
    private Bitmap e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f33968b.b(this.f33969c.g()) : (Bitmap) invokeV.objValue;
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, rectF, matrix) == null) {
            super.a(rectF, matrix);
            Bitmap e2 = e();
            if (e2 != null) {
                rectF.set(rectF.left, rectF.top, Math.min(rectF.right, e2.getWidth()), Math.min(rectF.bottom, e2.getHeight()));
                this.f33967a.mapRect(rectF);
            }
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(@NonNull Canvas canvas, Matrix matrix, int i2) {
        Bitmap e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) || (e2 = e()) == null || e2.isRecycled()) {
            return;
        }
        float a2 = com.ksad.lottie.d.f.a();
        this.f33985e.setAlpha(i2);
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f33988h;
        if (aVar != null) {
            this.f33985e.setColorFilter(aVar.e());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f33986f.set(0, 0, e2.getWidth(), e2.getHeight());
        this.f33987g.set(0, 0, (int) (e2.getWidth() * a2), (int) (e2.getHeight() * a2));
        canvas.drawBitmap(e2, this.f33986f, this.f33987g, this.f33985e);
        canvas.restore();
    }
}
