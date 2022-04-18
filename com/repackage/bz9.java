package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes5.dex */
public class bz9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends pz9<hz9<? super T>> {
        @Override // com.repackage.pz9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends tz9<hz9<? super R>, hz9<? super T>> {
        @Override // com.repackage.tz9
        /* synthetic */ R call(T t);
    }

    public bz9(a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    public static bz9<Long> B(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, timeUnit)) == null) ? C(j, timeUnit, Schedulers.computation()) : (bz9) invokeJL.objValue;
    }

    public static bz9<Long> C(long j, TimeUnit timeUnit, ez9 ez9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), timeUnit, ez9Var})) == null) ? a(new e0a(j, timeUnit, ez9Var)) : (bz9) invokeCommon.objValue;
    }

    public static <T> bz9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) ? new bz9<>(j3a.h(aVar)) : (bz9) invokeL.objValue;
    }

    public static <T> bz9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? EmptyObservableHolder.instance() : (bz9) invokeV.objValue;
    }

    public static <T> bz9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (bz9) invokeL.objValue;
    }

    public static <T> bz9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t)) == null) ? ScalarSynchronousObservable.E(t) : (bz9) invokeL.objValue;
    }

    public static <T> bz9<T> i(Iterable<? extends bz9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) ? j(e(iterable)) : (bz9) invokeL.objValue;
    }

    public static <T> bz9<T> j(bz9<? extends bz9<? extends T>> bz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bz9Var)) == null) {
            if (bz9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) bz9Var).H(UtilityFunctions.b());
            }
            return (bz9<T>) bz9Var.g(OperatorMerge.a(false));
        }
        return (bz9) invokeL.objValue;
    }

    public static <T> iz9 v(hz9<? super T> hz9Var, bz9<T> bz9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, hz9Var, bz9Var)) == null) {
            if (hz9Var != null) {
                if (bz9Var.a != null) {
                    hz9Var.d();
                    if (!(hz9Var instanceof d3a)) {
                        hz9Var = new d3a(hz9Var);
                    }
                    try {
                        j3a.p(bz9Var, bz9Var.a).call(hz9Var);
                        return j3a.o(hz9Var);
                    } catch (Throwable th) {
                        nz9.e(th);
                        if (hz9Var.isUnsubscribed()) {
                            j3a.j(j3a.m(th));
                        } else {
                            try {
                                hz9Var.onError(j3a.m(th));
                            } catch (Throwable th2) {
                                nz9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                j3a.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return z3a.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (iz9) invokeLL.objValue;
    }

    public final bz9<T> A(long j, TimeUnit timeUnit, bz9<? extends T> bz9Var, ez9 ez9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, bz9Var, ez9Var})) == null) ? (bz9<T>) g(new n0a(j, timeUnit, bz9Var, ez9Var)) : (bz9) invokeCommon.objValue;
    }

    public final iz9 D(hz9<? super T> hz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz9Var)) == null) {
            try {
                hz9Var.d();
                j3a.p(this, this.a).call(hz9Var);
                return j3a.o(hz9Var);
            } catch (Throwable th) {
                nz9.e(th);
                try {
                    hz9Var.onError(j3a.m(th));
                    return z3a.c();
                } catch (Throwable th2) {
                    nz9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    j3a.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (iz9) invokeL.objValue;
    }

    public final bz9<T> b(pz9<? super T> pz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pz9Var)) == null) ? a(new a0a(this, new g1a(pz9Var, Actions.a(), Actions.a()))) : (bz9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.repackage.tz9<? super T, ? extends com.repackage.bz9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> bz9<R> d(tz9<? super T, ? extends bz9<? extends R>> tz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tz9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).H(tz9Var);
            }
            return j(h(tz9Var));
        }
        return (bz9) invokeL.objValue;
    }

    public final <R> bz9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new b0a(this.a, bVar)) : (bz9) invokeL.objValue;
    }

    public final <R> bz9<R> h(tz9<? super T, ? extends R> tz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tz9Var)) == null) ? a(new c0a(this, tz9Var)) : (bz9) invokeL.objValue;
    }

    public final bz9<T> k(ez9 ez9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ez9Var)) == null) ? l(ez9Var, l1a.c) : (bz9) invokeL.objValue;
    }

    public final bz9<T> l(ez9 ez9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, ez9Var, i)) == null) ? m(ez9Var, false, i) : (bz9) invokeLI.objValue;
    }

    public final bz9<T> m(ez9 ez9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{ez9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).I(ez9Var);
            }
            return (bz9<T>) g(new i0a(ez9Var, z, i));
        }
        return (bz9) invokeCommon.objValue;
    }

    public final bz9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (bz9<T>) g(j0a.a()) : (bz9) invokeV.objValue;
    }

    public final a3a<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.F(this) : (a3a) invokeV.objValue;
    }

    public final a3a<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.G(this, i) : (a3a) invokeI.objValue;
    }

    public final a3a<T> q(int i, long j, TimeUnit timeUnit, ez9 ez9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, ez9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.I(this, j, timeUnit, ez9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (a3a) invokeCommon.objValue;
    }

    public final a3a<T> r(long j, TimeUnit timeUnit, ez9 ez9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, ez9Var})) == null) ? OperatorReplay.H(this, j, timeUnit, ez9Var) : (a3a) invokeCommon.objValue;
    }

    public final bz9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? d0a.a(this) : (bz9) invokeV.objValue;
    }

    public final iz9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new h1a(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (iz9) invokeV.objValue;
    }

    public final iz9 u(hz9<? super T> hz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, hz9Var)) == null) ? v(hz9Var, this) : (iz9) invokeL.objValue;
    }

    public final iz9 w(pz9<? super T> pz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, pz9Var)) == null) {
            if (pz9Var != null) {
                return u(new h1a(pz9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (iz9) invokeL.objValue;
    }

    public final iz9 x(pz9<? super T> pz9Var, pz9<Throwable> pz9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, pz9Var, pz9Var2)) == null) {
            if (pz9Var != null) {
                if (pz9Var2 != null) {
                    return u(new h1a(pz9Var, pz9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (iz9) invokeLL.objValue;
    }

    public final bz9<T> y(ez9 ez9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, ez9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).I(ez9Var);
            }
            return a(new m0a(this, ez9Var));
        }
        return (bz9) invokeL.objValue;
    }

    public final bz9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (bz9) invokeJL.objValue;
    }
}
