package com.ksad.lottie.a.b;

import android.graphics.PointF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class m extends a<PointF, PointF> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f33695c;

    /* renamed from: d  reason: collision with root package name */
    public final a<Float, Float> f33696d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f33697e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2};
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
        this.f33695c = new PointF();
        this.f33696d = aVar;
        this.f33697e = aVar2;
        a(f());
    }

    @Override // com.ksad.lottie.a.b.a
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f33696d.a(f2);
            this.f33697e.a(f2);
            this.f33695c.set(this.f33696d.e().floatValue(), this.f33697e.e().floatValue());
            for (int i2 = 0; i2 < this.f33677a.size(); i2++) {
                this.f33677a.get(i2).a();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, aVar, f2)) == null) ? this.f33695c : (PointF) invokeLF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: g */
    public PointF e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(null, 0.0f) : (PointF) invokeV.objValue;
    }
}
