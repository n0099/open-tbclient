package i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.o.a.l;
import i.o.a.o;
import i.o.a.p;
import i.o.a.s;
import i.o.a.t;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.NeverObservableHolder;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes10.dex */
public class d<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f78344e;

    /* loaded from: classes10.dex */
    public interface a<T> extends i.n.b<j<? super T>> {
    }

    /* loaded from: classes10.dex */
    public interface b<R, T> extends i.n.f<j<? super R>, j<? super T>> {
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
        this.f78344e = aVar;
    }

    public static <T> k A(j<? super T> jVar, d<T> dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jVar, dVar)) == null) {
            if (jVar != null) {
                if (dVar.f78344e != null) {
                    jVar.onStart();
                    if (!(jVar instanceof i.q.c)) {
                        jVar = new i.q.c(jVar);
                    }
                    try {
                        i.r.c.p(dVar, dVar.f78344e).call(jVar);
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

    public static d<Long> G(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j2, timeUnit)) == null) ? H(j2, timeUnit, Schedulers.computation()) : (d) invokeJL.objValue;
    }

    public static d<Long> H(long j2, TimeUnit timeUnit, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), timeUnit, gVar})) == null) ? b(new i.o.a.j(j2, timeUnit, gVar)) : (d) invokeCommon.objValue;
    }

    public static <T> d<T> b(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar)) == null) ? new d<>(i.r.c.h(aVar)) : (d) invokeL.objValue;
    }

    public static <T> d<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? EmptyObservableHolder.instance() : (d) invokeV.objValue;
    }

    public static <T> d<T> h(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, iterable)) == null) ? b(new OnSubscribeFromIterable(iterable)) : (d) invokeL.objValue;
    }

    public static <T> d<T> i(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, t)) == null) ? ScalarSynchronousObservable.J(t) : (d) invokeL.objValue;
    }

    public static <T> d<T> l(Iterable<? extends d<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) ? m(h(iterable)) : (d) invokeL.objValue;
    }

    public static <T> d<T> m(d<? extends d<? extends T>> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, dVar)) == null) {
            if (dVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) dVar).M(UtilityFunctions.b());
            }
            return (d<T>) dVar.j(OperatorMerge.b(false));
        }
        return (d) invokeL.objValue;
    }

    public static <T> d<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? NeverObservableHolder.instance() : (d) invokeV.objValue;
    }

    public final k B(i.n.b<? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar != null) {
                return z(new i.o.d.b(bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (k) invokeL.objValue;
    }

    public final k C(i.n.b<? super T> bVar, i.n.b<Throwable> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2)) == null) {
            if (bVar != null) {
                if (bVar2 != null) {
                    return z(new i.o.d.b(bVar, bVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (k) invokeLL.objValue;
    }

    public final d<T> D(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).N(gVar);
            }
            return b(new s(this, gVar));
        }
        return (d) invokeL.objValue;
    }

    public final d<T> E(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j2, timeUnit)) == null) ? F(j2, timeUnit, null, Schedulers.computation()) : (d) invokeJL.objValue;
    }

    public final d<T> F(long j2, TimeUnit timeUnit, d<? extends T> dVar, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), timeUnit, dVar, gVar})) == null) ? (d<T>) j(new t(j2, timeUnit, dVar, gVar)) : (d) invokeCommon.objValue;
    }

    public final k I(j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jVar)) == null) {
            try {
                jVar.onStart();
                i.r.c.p(this, this.f78344e).call(jVar);
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

    public final <R> d<R> a(Class<R> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cls)) == null) ? j(new l(cls)) : (d) invokeL.objValue;
    }

    public final d<T> c(i.n.b<? super Throwable> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) ? b(new i.o.a.e(this, new i.o.d.a(Actions.a(), bVar, Actions.a()))) : (d) invokeL.objValue;
    }

    public final d<T> d(i.n.b<? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) ? b(new i.o.a.e(this, new i.o.d.a(bVar, Actions.a(), Actions.a()))) : (d) invokeL.objValue;
    }

    public final d<T> f(i.n.f<? super T, Boolean> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, fVar)) == null) ? b(new i.o.a.f(this, fVar)) : (d) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: i.n.f<? super T, ? extends i.d<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d<R> g(i.n.f<? super T, ? extends d<? extends R>> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, fVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).M(fVar);
            }
            return m(k(fVar));
        }
        return (d) invokeL.objValue;
    }

    public final <R> d<R> j(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bVar)) == null) ? b(new i.o.a.g(this.f78344e, bVar)) : (d) invokeL.objValue;
    }

    public final <R> d<R> k(i.n.f<? super T, ? extends R> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, fVar)) == null) ? b(new i.o.a.h(this, fVar)) : (d) invokeL.objValue;
    }

    public final d<T> o(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, gVar)) == null) ? p(gVar, i.o.d.f.f78602g) : (d) invokeL.objValue;
    }

    public final d<T> p(g gVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, gVar, i2)) == null) ? q(gVar, false, i2) : (d) invokeLI.objValue;
    }

    public final d<T> q(g gVar, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{gVar, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).N(gVar);
            }
            return (d<T>) j(new o(gVar, z, i2));
        }
        return (d) invokeCommon.objValue;
    }

    public final <R> d<R> r(Class<R> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, cls)) == null) ? f(InternalObservableUtils.isInstanceOf(cls)).a(cls) : (d) invokeL.objValue;
    }

    public final d<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (d<T>) j(p.b()) : (d) invokeV.objValue;
    }

    public final i.p.a<T> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? OperatorReplay.K(this) : (i.p.a) invokeV.objValue;
    }

    public final i.p.a<T> u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? OperatorReplay.L(this, i2) : (i.p.a) invokeI.objValue;
    }

    public final i.p.a<T> v(int i2, long j2, TimeUnit timeUnit, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), timeUnit, gVar})) == null) {
            if (i2 >= 0) {
                return OperatorReplay.N(this, j2, timeUnit, gVar, i2);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (i.p.a) invokeCommon.objValue;
    }

    public final i.p.a<T> w(long j2, TimeUnit timeUnit, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), timeUnit, gVar})) == null) ? OperatorReplay.M(this, j2, timeUnit, gVar) : (i.p.a) invokeCommon.objValue;
    }

    public final d<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? i.o.a.i.b(this) : (d) invokeV.objValue;
    }

    public final k y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? z(new i.o.d.b(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (k) invokeV.objValue;
    }

    public final k z(j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, jVar)) == null) ? A(jVar, this) : (k) invokeL.objValue;
    }
}
