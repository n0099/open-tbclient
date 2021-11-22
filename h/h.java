package h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.o.a.t;
import h.o.a.u;
import h.o.a.x;
import h.o.a.y;
import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class h<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c<T> f72785a;

    /* loaded from: classes2.dex */
    public class a extends i<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.n.b f72786f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.n.b f72787g;

        public a(h hVar, h.n.b bVar, h.n.b bVar2) {
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
            this.f72786f = bVar;
            this.f72787g = bVar2;
        }

        @Override // h.i
        public final void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.f72786f.call(th);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // h.i
        public final void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.f72787g.call(t);
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements h.n.b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.n.b f72788e;

        public b(h hVar, h.n.b bVar) {
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
            this.f72788e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.f72788e.call(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c<T> extends h.n.b<i<? super T>> {
        @Override // h.n.b
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
        this.f72785a = h.r.c.i(cVar);
    }

    public static <T> d<T> a(h<T> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hVar)) == null) ? d.a(new y(hVar.f72785a)) : (d) invokeL.objValue;
    }

    public static <T> h<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new h<>(cVar) : (h) invokeL.objValue;
    }

    public static <T> h<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? h.o.d.g.m(t) : (h) invokeL.objValue;
    }

    public final h<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (h) invokeJL.objValue;
    }

    public final h<T> d(long j, TimeUnit timeUnit, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, gVar})) == null) ? b(new t(this.f72785a, j, timeUnit, gVar)) : (h) invokeCommon.objValue;
    }

    public final h<T> e(h.n.b<Throwable> bVar) {
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

    public final h<T> f(h.n.b<? super T> bVar) {
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
            if (this instanceof h.o.d.g) {
                return ((h.o.d.g) this).n(gVar);
            }
            if (gVar != null) {
                return b(new x(this.f72785a, gVar));
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
                    h.r.c.t(this, this.f72785a).call(iVar);
                    return h.r.c.s(iVar);
                } catch (Throwable th) {
                    h.m.a.e(th);
                    try {
                        iVar.b(h.r.c.r(th));
                        return h.u.e.b();
                    } catch (Throwable th2) {
                        h.m.a.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        h.r.c.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (k) invokeL.objValue;
    }

    public final k k(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
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
