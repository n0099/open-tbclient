package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes7.dex */
public class o implements d, i, j, l, a.InterfaceC0399a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f33652a;

    /* renamed from: b  reason: collision with root package name */
    public final Path f33653b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f33654c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f33655d;

    /* renamed from: e  reason: collision with root package name */
    public final String f33656e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Float, Float> f33657f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Float, Float> f33658g;

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.a.b.o f33659h;

    /* renamed from: i  reason: collision with root package name */
    public c f33660i;

    public o(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33652a = new Matrix();
        this.f33653b = new Path();
        this.f33654c = fVar;
        this.f33655d = aVar;
        this.f33656e = gVar.a();
        com.ksad.lottie.a.b.a<Float, Float> a2 = gVar.b().a();
        this.f33657f = a2;
        aVar.a(a2);
        this.f33657f.a(this);
        com.ksad.lottie.a.b.a<Float, Float> a3 = gVar.c().a();
        this.f33658g = a3;
        aVar.a(a3);
        this.f33658g.a(this);
        com.ksad.lottie.a.b.o h2 = gVar.d().h();
        this.f33659h = h2;
        h2.a(aVar);
        this.f33659h.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0399a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f33654c.invalidateSelf();
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) {
            float floatValue = this.f33657f.e().floatValue();
            float floatValue2 = this.f33658g.e().floatValue();
            float floatValue3 = this.f33659h.b().e().floatValue() / 100.0f;
            float floatValue4 = this.f33659h.c().e().floatValue() / 100.0f;
            for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
                this.f33652a.set(matrix);
                float f2 = i3;
                this.f33652a.preConcat(this.f33659h.b(f2 + floatValue2));
                this.f33660i.a(canvas, this.f33652a, (int) (i2 * com.ksad.lottie.d.e.a(floatValue3, floatValue4, f2 / floatValue)));
            }
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rectF, matrix) == null) {
            this.f33660i.a(rectF, matrix);
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, list2) == null) {
            this.f33660i.a(list, list2);
        }
    }

    @Override // com.ksad.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, listIterator) == null) && this.f33660i == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.f33660i = new c(this.f33654c, this.f33655d, "Repeater", arrayList, null);
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Path d2 = this.f33660i.d();
            this.f33653b.reset();
            float floatValue = this.f33657f.e().floatValue();
            float floatValue2 = this.f33658g.e().floatValue();
            for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
                this.f33652a.set(this.f33659h.b(i2 + floatValue2));
                this.f33653b.addPath(d2, this.f33652a);
            }
            return this.f33653b;
        }
        return (Path) invokeV.objValue;
    }
}
