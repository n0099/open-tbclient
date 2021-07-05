package com.ksad.lottie.a.b;

import android.graphics.PointF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class j extends f<PointF> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f33692c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(List<com.ksad.lottie.e.a<PointF>> list) {
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
        this.f33692c = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f2) {
        InterceptResult invokeLF;
        PointF pointF;
        PointF pointF2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, f2)) == null) {
            PointF pointF3 = aVar.f33774a;
            if (pointF3 == null || (pointF = aVar.f33775b) == null) {
                throw new IllegalStateException("Missing values for keyframe.");
            }
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            com.ksad.lottie.e.c<A> cVar = this.f33678b;
            if (cVar == 0 || (pointF2 = (PointF) cVar.a(aVar.f33777d, aVar.f33778e.floatValue(), pointF4, pointF5, f2, c(), f())) == null) {
                PointF pointF6 = this.f33692c;
                float f3 = pointF4.x;
                float f4 = pointF4.y;
                pointF6.set(f3 + ((pointF5.x - f3) * f2), f4 + (f2 * (pointF5.y - f4)));
                return this.f33692c;
            }
            return pointF2;
        }
        return (PointF) invokeLF.objValue;
    }
}
