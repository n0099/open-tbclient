package d.a.s0.w;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.w.b;
/* loaded from: classes9.dex */
public final class d extends b<d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e t;
    public float u;
    public boolean v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(objArr2[0], (c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.u = Float.MAX_VALUE;
        this.v = false;
    }

    @Override // d.a.s0.w.b
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k();
            this.t.g(d());
            super.g();
        }
    }

    @Override // d.a.s0.w.b
    public boolean i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (this.v) {
                float f2 = this.u;
                if (f2 != Float.MAX_VALUE) {
                    this.t.e(f2);
                    this.u = Float.MAX_VALUE;
                }
                this.f68901b = this.t.a();
                this.f68900a = 0.0f;
                this.v = false;
                return true;
            }
            if (this.u != Float.MAX_VALUE) {
                this.t.a();
                long j2 = j / 2;
                b.i h2 = this.t.h(this.f68901b, this.f68900a, j2);
                this.t.e(this.u);
                this.u = Float.MAX_VALUE;
                b.i h3 = this.t.h(h2.f68909a, h2.f68910b, j2);
                this.f68901b = h3.f68909a;
                this.f68900a = h3.f68910b;
            } else {
                b.i h4 = this.t.h(this.f68901b, this.f68900a, j);
                this.f68901b = h4.f68909a;
                this.f68900a = h4.f68910b;
            }
            float max = Math.max(this.f68901b, this.f68907h);
            this.f68901b = max;
            float min = Math.min(max, this.f68906g);
            this.f68901b = min;
            if (j(min, this.f68900a)) {
                this.f68901b = this.t.a();
                this.f68900a = 0.0f;
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public boolean j(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.t.c(f2, f3) : invokeCommon.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e eVar = this.t;
            if (eVar != null) {
                double a2 = eVar.a();
                if (a2 <= this.f68906g) {
                    if (a2 < this.f68907h) {
                        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                    }
                    return;
                }
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            }
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public d l(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
            this.t = eVar;
            return this;
        }
        return (d) invokeL.objValue;
    }
}
