package i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.o.a.t;
import i.o.a.u;
import i.o.a.x;
import i.o.a.y;
import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.schedulers.Schedulers;
/* loaded from: classes4.dex */
public class h<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes4.dex */
    public class a extends i<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.n.b f64208f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i.n.b f64209g;

        public a(h hVar, i.n.b bVar, i.n.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64208f = bVar;
            this.f64209g = bVar2;
        }

        @Override // i.i
        public final void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.f64208f.call(th);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // i.i
        public final void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.f64209g.call(t);
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i.n.b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.n.b f64210e;

        public b(h hVar, i.n.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64210e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.f64210e.call(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c<T> extends i.n.b<i<? super T>> {
        @Override // i.n.b
        /* synthetic */ void call(T t);
    }

    public h(c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i.r.c.i(cVar);
    }

    public static <T> d<T> a(h<T> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hVar)) == null) ? d.a(new y(hVar.a)) : (d) invokeL.objValue;
    }

    public static <T> h<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new h<>(cVar) : (h) invokeL.objValue;
    }

    public static <T> h<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? i.o.d.g.m(t) : (h) invokeL.objValue;
    }

    public final h<T> c(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j2, timeUnit)) == null) ? d(j2, timeUnit, Schedulers.computation()) : (h) invokeJL.objValue;
    }

    public final h<T> d(long j2, TimeUnit timeUnit, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), timeUnit, gVar})) == null) ? b(new t(this.a, j2, timeUnit, gVar)) : (h) invokeCommon.objValue;
    }

    public final h<T> e(i.n.b<Throwable> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            if (bVar != null) {
                return b(new u(this, Actions.a(), new b(this, bVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (h) invokeL.objValue;
    }

    public final h<T> f(i.n.b<? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            if (bVar != null) {
                return b(new u(this, bVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (h) invokeL.objValue;
    }

    public final h<T> h(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) {
            if (this instanceof i.o.d.g) {
                return ((i.o.d.g) this).n(gVar);
            }
            if (gVar != null) {
                return b(new x(this.a, gVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (h) invokeL.objValue;
    }

    public final k i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (k) invokeV.objValue;
    }

    public final k j(i<? super T> iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iVar)) == null) {
            if (iVar != null) {
                try {
                    i.r.c.t(this, this.a).call(iVar);
                    return i.r.c.s(iVar);
                } catch (Throwable th) {
                    i.m.a.e(th);
                    try {
                        iVar.b(i.r.c.r(th));
                        return i.u.e.b();
                    } catch (Throwable th2) {
                        i.m.a.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        i.r.c.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (k) invokeL.objValue;
    }

    public final k k(i.n.b<? super T> bVar, i.n.b<Throwable> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bVar, bVar2)) == null) {
            if (bVar != null) {
                if (bVar2 != null) {
                    return j(new a(this, bVar2, bVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (k) invokeLL.objValue;
    }

    public final d<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (d) invokeV.objValue;
    }
}
