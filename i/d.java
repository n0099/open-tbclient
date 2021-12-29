package i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.o.a.m;
import i.o.a.n;
import i.o.a.q;
import i.o.a.r;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes4.dex */
public class d<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f64207e;

    /* loaded from: classes4.dex */
    public interface a<T> extends i.n.b<j<? super T>> {
        @Override // i.n.b
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes4.dex */
    public interface b<R, T> extends i.n.f<j<? super R>, j<? super T>> {
        @Override // i.n.f
        /* synthetic */ R call(T t);
    }

    public d(a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64207e = aVar;
    }

    public static d<Long> B(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j2, timeUnit)) == null) ? C(j2, timeUnit, Schedulers.computation()) : (d) invokeJL.objValue;
    }

    public static d<Long> C(long j2, TimeUnit timeUnit, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), timeUnit, gVar})) == null) ? a(new i.o.a.i(j2, timeUnit, gVar)) : (d) invokeCommon.objValue;
    }

    public static <T> d<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) ? new d<>(i.r.c.h(aVar)) : (d) invokeL.objValue;
    }

    public static <T> d<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? EmptyObservableHolder.instance() : (d) invokeV.objValue;
    }

    public static <T> d<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (d) invokeL.objValue;
    }

    public static <T> d<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t)) == null) ? ScalarSynchronousObservable.E(t) : (d) invokeL.objValue;
    }

    public static <T> d<T> i(Iterable<? extends d<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) ? j(e(iterable)) : (d) invokeL.objValue;
    }

    public static <T> d<T> j(d<? extends d<? extends T>> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, dVar)) == null) {
            if (dVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) dVar).H(UtilityFunctions.b());
            }
            return (d<T>) dVar.g(OperatorMerge.a(false));
        }
        return (d) invokeL.objValue;
    }

    public static <T> k v(j<? super T> jVar, d<T> dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jVar, dVar)) == null) {
            if (jVar != null) {
                if (dVar.f64207e != null) {
                    jVar.d();
                    if (!(jVar instanceof i.q.c)) {
                        jVar = new i.q.c(jVar);
                    }
                    try {
                        i.r.c.p(dVar, dVar.f64207e).call(jVar);
                        return i.r.c.o(jVar);
                    } catch (Throwable th) {
                        i.m.a.e(th);
                        if (jVar.isUnsubscribed()) {
                            i.r.c.j(i.r.c.m(th));
                        } else {
                            try {
                                jVar.onError(i.r.c.m(th));
                            } catch (Throwable th2) {
                                i.m.a.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                i.r.c.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return i.u.e.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (k) invokeLL.objValue;
    }

    public final d<T> A(long j2, TimeUnit timeUnit, d<? extends T> dVar, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), timeUnit, dVar, gVar})) == null) ? (d<T>) g(new r(j2, timeUnit, dVar, gVar)) : (d) invokeCommon.objValue;
    }

    public final k D(j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar)) == null) {
            try {
                jVar.d();
                i.r.c.p(this, this.f64207e).call(jVar);
                return i.r.c.o(jVar);
            } catch (Throwable th) {
                i.m.a.e(th);
                try {
                    jVar.onError(i.r.c.m(th));
                    return i.u.e.c();
                } catch (Throwable th2) {
                    i.m.a.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    i.r.c.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (k) invokeL.objValue;
    }

    public final d<T> b(i.n.b<? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) ? a(new i.o.a.e(this, new i.o.d.a(bVar, Actions.a(), Actions.a()))) : (d) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: i.n.f<? super T, ? extends i.d<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d<R> d(i.n.f<? super T, ? extends d<? extends R>> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).H(fVar);
            }
            return j(h(fVar));
        }
        return (d) invokeL.objValue;
    }

    public final <R> d<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new i.o.a.f(this.f64207e, bVar)) : (d) invokeL.objValue;
    }

    public final <R> d<R> h(i.n.f<? super T, ? extends R> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fVar)) == null) ? a(new i.o.a.g(this, fVar)) : (d) invokeL.objValue;
    }

    public final d<T> k(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gVar)) == null) ? l(gVar, i.o.d.f.f64436g) : (d) invokeL.objValue;
    }

    public final d<T> l(g gVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, gVar, i2)) == null) ? m(gVar, false, i2) : (d) invokeLI.objValue;
    }

    public final d<T> m(g gVar, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{gVar, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).I(gVar);
            }
            return (d<T>) g(new m(gVar, z, i2));
        }
        return (d) invokeCommon.objValue;
    }

    public final d<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (d<T>) g(n.a()) : (d) invokeV.objValue;
    }

    public final i.p.a<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.F(this) : (i.p.a) invokeV.objValue;
    }

    public final i.p.a<T> p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? OperatorReplay.G(this, i2) : (i.p.a) invokeI.objValue;
    }

    public final i.p.a<T> q(int i2, long j2, TimeUnit timeUnit, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), timeUnit, gVar})) == null) {
            if (i2 >= 0) {
                return OperatorReplay.I(this, j2, timeUnit, gVar, i2);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (i.p.a) invokeCommon.objValue;
    }

    public final i.p.a<T> r(long j2, TimeUnit timeUnit, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), timeUnit, gVar})) == null) ? OperatorReplay.H(this, j2, timeUnit, gVar) : (i.p.a) invokeCommon.objValue;
    }

    public final d<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? i.o.a.h.a(this) : (d) invokeV.objValue;
    }

    public final k t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new i.o.d.b(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (k) invokeV.objValue;
    }

    public final k u(j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, jVar)) == null) ? v(jVar, this) : (k) invokeL.objValue;
    }

    public final k w(i.n.b<? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bVar)) == null) {
            if (bVar != null) {
                return u(new i.o.d.b(bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (k) invokeL.objValue;
    }

    public final k x(i.n.b<? super T> bVar, i.n.b<Throwable> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, bVar, bVar2)) == null) {
            if (bVar != null) {
                if (bVar2 != null) {
                    return u(new i.o.d.b(bVar, bVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (k) invokeLL.objValue;
    }

    public final d<T> y(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, gVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).I(gVar);
            }
            return a(new q(this, gVar));
        }
        return (d) invokeL.objValue;
    }

    public final d<T> z(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j2, timeUnit)) == null) ? A(j2, timeUnit, null, Schedulers.computation()) : (d) invokeJL.objValue;
    }
}
