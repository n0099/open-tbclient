package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h extends com.ksad.lottie.e.a<PointF> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Path f33687h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(com.ksad.lottie.d dVar, com.ksad.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.f33774a, aVar.f33775b, aVar.f33776c, aVar.f33777d, aVar.f33778e);
        T t;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.ksad.lottie.d) objArr2[0], objArr2[1], objArr2[2], (Interpolator) objArr2[3], ((Float) objArr2[4]).floatValue(), (Float) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        T t2 = this.f33775b;
        boolean z = (t2 == 0 || (t = this.f33774a) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f33775b;
        if (t3 == 0 || z) {
            return;
        }
        this.f33687h = com.ksad.lottie.d.f.a((PointF) this.f33774a, (PointF) t3, aVar.f33779f, aVar.f33780g);
    }

    @Nullable
    public Path a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33687h : (Path) invokeV.objValue;
    }
}
