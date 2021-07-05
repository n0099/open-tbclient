package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements d, l, a.InterfaceC0399a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f33584a;

    /* renamed from: b  reason: collision with root package name */
    public final Path f33585b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f33586c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33587d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b> f33588e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.f f33589f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public List<l> f33590g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.ksad.lottie.a.b.o f33591h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.j jVar) {
        this(fVar, aVar, jVar.a(), a(fVar, aVar, jVar.b()), a(jVar.b()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.ksad.lottie.f) objArr2[0], (com.ksad.lottie.model.layer.a) objArr2[1], (String) objArr2[2], (List) objArr2[3], (com.ksad.lottie.model.a.l) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, String str, List<b> list, @Nullable com.ksad.lottie.model.a.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, str, list, lVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33584a = new Matrix();
        this.f33585b = new Path();
        this.f33586c = new RectF();
        this.f33587d = str;
        this.f33589f = fVar;
        this.f33588e = list;
        if (lVar != null) {
            com.ksad.lottie.a.b.o h2 = lVar.h();
            this.f33591h = h2;
            h2.a(aVar);
            this.f33591h.a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof i) {
                arrayList.add((i) bVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((i) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    @Nullable
    public static com.ksad.lottie.model.a.l a(List<com.ksad.lottie.model.content.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                com.ksad.lottie.model.content.b bVar = list.get(i2);
                if (bVar instanceof com.ksad.lottie.model.a.l) {
                    return (com.ksad.lottie.model.a.l) bVar;
                }
            }
            return null;
        }
        return (com.ksad.lottie.model.a.l) invokeL.objValue;
    }

    public static List<b> a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, List<com.ksad.lottie.model.content.b> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, fVar, aVar, list)) == null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (int i2 = 0; i2 < list.size(); i2++) {
                b a2 = list.get(i2).a(fVar, aVar);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0399a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f33589f.invalidateSelf();
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) {
            this.f33584a.set(matrix);
            com.ksad.lottie.a.b.o oVar = this.f33591h;
            if (oVar != null) {
                this.f33584a.preConcat(oVar.d());
                i2 = (int) ((((this.f33591h.a().e().intValue() / 100.0f) * i2) / 255.0f) * 255.0f);
            }
            for (int size = this.f33588e.size() - 1; size >= 0; size--) {
                b bVar = this.f33588e.get(size);
                if (bVar instanceof d) {
                    ((d) bVar).a(canvas, this.f33584a, i2);
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rectF, matrix) == null) {
            this.f33584a.set(matrix);
            com.ksad.lottie.a.b.o oVar = this.f33591h;
            if (oVar != null) {
                this.f33584a.preConcat(oVar.d());
            }
            this.f33586c.set(0.0f, 0.0f, 0.0f, 0.0f);
            for (int size = this.f33588e.size() - 1; size >= 0; size--) {
                b bVar = this.f33588e.get(size);
                if (bVar instanceof d) {
                    ((d) bVar).a(this.f33586c, this.f33584a);
                    if (rectF.isEmpty()) {
                        rectF.set(this.f33586c);
                    } else {
                        rectF.set(Math.min(rectF.left, this.f33586c.left), Math.min(rectF.top, this.f33586c.top), Math.max(rectF.right, this.f33586c.right), Math.max(rectF.bottom, this.f33586c.bottom));
                    }
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, list2) == null) {
            ArrayList arrayList = new ArrayList(list.size() + this.f33588e.size());
            arrayList.addAll(list);
            for (int size = this.f33588e.size() - 1; size >= 0; size--) {
                b bVar = this.f33588e.get(size);
                bVar.a(arrayList, this.f33588e.subList(0, size));
                arrayList.add(bVar);
            }
        }
    }

    public List<l> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f33590g == null) {
                this.f33590g = new ArrayList();
                for (int i2 = 0; i2 < this.f33588e.size(); i2++) {
                    b bVar = this.f33588e.get(i2);
                    if (bVar instanceof l) {
                        this.f33590g.add((l) bVar);
                    }
                }
            }
            return this.f33590g;
        }
        return (List) invokeV.objValue;
    }

    public Matrix c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.ksad.lottie.a.b.o oVar = this.f33591h;
            if (oVar != null) {
                return oVar.d();
            }
            this.f33584a.reset();
            return this.f33584a;
        }
        return (Matrix) invokeV.objValue;
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.f33584a.reset();
            com.ksad.lottie.a.b.o oVar = this.f33591h;
            if (oVar != null) {
                this.f33584a.set(oVar.d());
            }
            this.f33585b.reset();
            for (int size = this.f33588e.size() - 1; size >= 0; size--) {
                b bVar = this.f33588e.get(size);
                if (bVar instanceof l) {
                    this.f33585b.addPath(((l) bVar).d(), this.f33584a);
                }
            }
            return this.f33585b;
        }
        return (Path) invokeV.objValue;
    }
}
