package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes7.dex */
public class q extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f33667b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33668c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Integer, Integer> f33669d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> f33670e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.g().toPaintCap(), shapeStroke.h().toPaintJoin(), shapeStroke.i(), shapeStroke.c(), shapeStroke.d(), shapeStroke.e(), shapeStroke.f());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {fVar, aVar, shapeStroke};
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
        this.f33667b = aVar;
        this.f33668c = shapeStroke.a();
        com.ksad.lottie.a.b.a<Integer, Integer> a2 = shapeStroke.b().a();
        this.f33669d = a2;
        a2.a(this);
        aVar.a(this.f33669d);
    }

    @Override // com.ksad.lottie.a.a.a, com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, canvas, matrix, i2) == null) {
            this.f33573a.setColor(this.f33669d.e().intValue());
            com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f33670e;
            if (aVar != null) {
                this.f33573a.setColorFilter(aVar.e());
            }
            super.a(canvas, matrix, i2);
        }
    }
}
