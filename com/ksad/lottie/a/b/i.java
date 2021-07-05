package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class i extends f<PointF> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f33688c;

    /* renamed from: d  reason: collision with root package name */
    public final float[] f33689d;

    /* renamed from: e  reason: collision with root package name */
    public h f33690e;

    /* renamed from: f  reason: collision with root package name */
    public PathMeasure f33691f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(List<? extends com.ksad.lottie.e.a<PointF>> list) {
        super(list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((List) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33688c = new PointF();
        this.f33689d = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f2) {
        InterceptResult invokeLF;
        PointF pointF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, f2)) == null) {
            h hVar = (h) aVar;
            Path a2 = hVar.a();
            if (a2 == null) {
                return aVar.f33774a;
            }
            com.ksad.lottie.e.c<A> cVar = this.f33678b;
            if (cVar == 0 || (pointF = (PointF) cVar.a(hVar.f33777d, hVar.f33778e.floatValue(), hVar.f33774a, hVar.f33775b, c(), f2, f())) == null) {
                if (this.f33690e != hVar) {
                    this.f33691f = new PathMeasure(a2, false);
                    this.f33690e = hVar;
                }
                PathMeasure pathMeasure = this.f33691f;
                pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f33689d, null);
                PointF pointF2 = this.f33688c;
                float[] fArr = this.f33689d;
                pointF2.set(fArr[0], fArr[1]);
                return this.f33688c;
            }
            return pointF;
        }
        return (PointF) invokeLF.objValue;
    }
}
