package com.repackage;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a7;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class e16 extends w06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a7<d16> b;
    public final PointF c;
    public float d;
    public final PointF e;
    public float f;

    public e16() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a7<>(0);
        this.c = new PointF();
        this.e = new PointF(1.0f, 1.0f);
        this.f = 1.0f;
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            g();
            a7.b<d16> it = this.b.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "actions.iterator()");
            while (it.hasNext()) {
                it.next().a(j);
            }
        }
    }

    public final void d(d16 action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, action) == null) {
            Intrinsics.checkNotNullParameter(action, "action");
            action.c(this);
            action.b();
            this.b.a(action);
        }
    }

    public final float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : invokeV.floatValue;
    }

    public final PointF f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (PointF) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a().f().u();
            this.c.set(0.0f, 0.0f);
            this.d = 0.0f;
            this.e.set(1.0f, 1.0f);
            this.f = 1.0f;
        }
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    public final void i(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, matrix) == null) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            PointF pointF = this.e;
            matrix.setScale(pointF.x, pointF.y);
            matrix.postRotate(this.d);
            PointF pointF2 = this.c;
            matrix.postTranslate(pointF2.x, pointF2.y);
        }
    }

    @Override // com.repackage.w06, com.repackage.z7.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.reset();
            g();
            this.b.clear();
        }
    }
}
