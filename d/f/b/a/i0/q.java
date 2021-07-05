package d.f.b.a.i0;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class q implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f73405e;

    /* renamed from: f  reason: collision with root package name */
    public long f73406f;

    /* renamed from: g  reason: collision with root package name */
    public long f73407g;

    /* renamed from: h  reason: collision with root package name */
    public d.f.b.a.p f73408h;

    public q() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73408h = d.f.b.a.p.f73512d;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.f73406f = j;
            if (this.f73405e) {
                this.f73407g = SystemClock.elapsedRealtime();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f73405e) {
            return;
        }
        this.f73407g = SystemClock.elapsedRealtime();
        this.f73405e = true;
    }

    @Override // d.f.b.a.i0.h
    public d.f.b.a.p c(d.f.b.a.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar)) == null) {
            if (this.f73405e) {
                a(p());
            }
            this.f73408h = pVar;
            return pVar;
        }
        return (d.f.b.a.p) invokeL.objValue;
    }

    @Override // d.f.b.a.i0.h
    public d.f.b.a.p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f73408h : (d.f.b.a.p) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f73405e) {
            a(p());
            this.f73405e = false;
        }
    }

    @Override // d.f.b.a.i0.h
    public long p() {
        InterceptResult invokeV;
        long a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long j = this.f73406f;
            if (this.f73405e) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f73407g;
                d.f.b.a.p pVar = this.f73408h;
                if (pVar.f73513a == 1.0f) {
                    a2 = d.f.b.a.b.a(elapsedRealtime);
                } else {
                    a2 = pVar.a(elapsedRealtime);
                }
                return j + a2;
            }
            return j;
        }
        return invokeV.longValue;
    }
}
