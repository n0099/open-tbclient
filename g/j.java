package g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class j<T> implements e<T>, k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g.o.d.h a;

    /* renamed from: b  reason: collision with root package name */
    public final j<?> f44816b;

    /* renamed from: c  reason: collision with root package name */
    public f f44817c;

    /* renamed from: d  reason: collision with root package name */
    public long f44818d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j() {
        this(null, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.a.a(kVar);
        }
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            long j2 = this.f44818d;
            if (j2 == Long.MIN_VALUE) {
                this.f44818d = j;
                return;
            }
            long j3 = j2 + j;
            if (j3 < 0) {
                this.f44818d = Long.MAX_VALUE;
            } else {
                this.f44818d = j3;
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
                    if (this.f44817c != null) {
                        this.f44817c.request(j);
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
                j = this.f44818d;
                this.f44817c = fVar;
                z = this.f44816b != null && j == Long.MIN_VALUE;
            }
            if (z) {
                this.f44816b.f(this.f44817c);
            } else if (j == Long.MIN_VALUE) {
                this.f44817c.request(Long.MAX_VALUE);
            } else {
                this.f44817c.request(j);
            }
        }
    }

    @Override // g.k
    public final boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // g.k
    public final void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.unsubscribe();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f44818d = Long.MIN_VALUE;
        this.f44816b = jVar;
        this.a = (!z || jVar == null) ? new g.o.d.h() : jVar.a;
    }
}
