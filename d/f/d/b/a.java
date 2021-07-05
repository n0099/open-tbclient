package d.f.d.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.cache.LongAddables;
/* loaded from: classes10.dex */
public final class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final g f73736a;

    /* renamed from: b  reason: collision with root package name */
    public final g f73737b;

    /* renamed from: c  reason: collision with root package name */
    public final g f73738c;

    /* renamed from: d  reason: collision with root package name */
    public final g f73739d;

    /* renamed from: e  reason: collision with root package name */
    public final g f73740e;

    /* renamed from: f  reason: collision with root package name */
    public final g f73741f;

    public a() {
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
        this.f73736a = LongAddables.a();
        this.f73737b = LongAddables.a();
        this.f73738c = LongAddables.a();
        this.f73739d = LongAddables.a();
        this.f73740e = LongAddables.a();
        this.f73741f = LongAddables.a();
    }

    public static long h(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) {
            if (j >= 0) {
                return j;
            }
            return Long.MAX_VALUE;
        }
        return invokeJ.longValue;
    }

    @Override // d.f.d.b.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f73736a.add(i2);
        }
    }

    @Override // d.f.d.b.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f73741f.increment();
        }
    }

    @Override // d.f.d.b.b
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f73738c.increment();
            this.f73740e.add(j);
        }
    }

    @Override // d.f.d.b.b
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f73737b.add(i2);
        }
    }

    @Override // d.f.d.b.b
    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f73739d.increment();
            this.f73740e.add(j);
        }
    }

    @Override // d.f.d.b.b
    public d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new d(h(this.f73736a.sum()), h(this.f73737b.sum()), h(this.f73738c.sum()), h(this.f73739d.sum()), h(this.f73740e.sum()), h(this.f73741f.sum())) : (d) invokeV.objValue;
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            d f2 = bVar.f();
            this.f73736a.add(f2.b());
            this.f73737b.add(f2.e());
            this.f73738c.add(f2.d());
            this.f73739d.add(f2.c());
            this.f73740e.add(f2.f());
            this.f73741f.add(f2.a());
        }
    }
}
