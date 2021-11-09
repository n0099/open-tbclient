package h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class j<T> implements e<T>, k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.o.d.h f71871e;

    /* renamed from: f  reason: collision with root package name */
    public final j<?> f71872f;

    /* renamed from: g  reason: collision with root package name */
    public f f71873g;

    /* renamed from: h  reason: collision with root package name */
    public long f71874h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j() {
        this(null, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((j) objArr[0], ((Boolean) objArr[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f71871e.a(kVar);
        }
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            long j2 = this.f71874h;
            if (j2 == Long.MIN_VALUE) {
                this.f71874h = j;
                return;
            }
            long j3 = j2 + j;
            if (j3 < 0) {
                this.f71874h = Long.MAX_VALUE;
            } else {
                this.f71874h = j3;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public final void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (j >= 0) {
                synchronized (this) {
                    if (this.f71873g != null) {
                        this.f71873g.request(j);
                        return;
                    }
                    c(j);
                    return;
                }
            }
            throw new IllegalArgumentException("number requested cannot be negative: " + j);
        }
    }

    public void f(f fVar) {
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            synchronized (this) {
                j = this.f71874h;
                this.f71873g = fVar;
                z = this.f71872f != null && j == Long.MIN_VALUE;
            }
            if (z) {
                this.f71872f.f(this.f71873g);
            } else if (j == Long.MIN_VALUE) {
                this.f71873g.request(Long.MAX_VALUE);
            } else {
                this.f71873g.request(j);
            }
        }
    }

    @Override // h.k
    public final boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f71871e.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // h.k
    public final void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f71871e.unsubscribe();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(j<?> jVar) {
        this(jVar, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((j) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public j(j<?> jVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f71874h = Long.MIN_VALUE;
        this.f71872f = jVar;
        this.f71871e = (!z || jVar == null) ? new h.o.d.h() : jVar.f71871e;
    }
}
