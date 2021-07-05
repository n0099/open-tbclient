package com.ksad.lottie.model.content;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final float[] f33907a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f33908b;

    public c(float[] fArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fArr, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33907a = fArr;
        this.f33908b = iArr;
    }

    public void a(c cVar, c cVar2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{cVar, cVar2, Float.valueOf(f2)}) == null) {
            if (cVar.f33908b.length == cVar2.f33908b.length) {
                for (int i2 = 0; i2 < cVar.f33908b.length; i2++) {
                    this.f33907a[i2] = com.ksad.lottie.d.e.a(cVar.f33907a[i2], cVar2.f33907a[i2], f2);
                    this.f33908b[i2] = com.ksad.lottie.d.b.a(f2, cVar.f33908b[i2], cVar2.f33908b[i2]);
                }
                return;
            }
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f33908b.length + " vs " + cVar2.f33908b.length + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public float[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33907a : (float[]) invokeV.objValue;
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33908b : (int[]) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33908b.length : invokeV.intValue;
    }
}
