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
/* loaded from: classes7.dex */
public class uy9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes7.dex */
    public interface a<T> extends iz9<az9<? super T>> {
        @Override // com.repackage.iz9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public interface b<R, T> extends mz9<az9<? super R>, az9<? super T>> {
        @Override // com.repackage.mz9
        /* synthetic */ R call(T t);
    }

    public uy9(a<T> aVar) {
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

    public static uy9<Long> B(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, timeUnit)) == null) ? C(j, timeUnit, Schedulers.computation()) : (uy9) invokeJL.objValue;
    }

    public static uy9<Long> C(long j, TimeUnit timeUnit, xy9 xy9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), timeUnit, xy9Var})) == null) ? a(new xz9(j, timeUnit, xy9Var)) : (uy9) invokeCommon.objValue;
    }

    public static <T> uy9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) ? new uy9<>(c3a.h(aVar)) : (uy9) invokeL.objValue;
    }

    public static <T> uy9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? EmptyObservableHolder.instance() : (uy9) invokeV.objValue;
    }

    public static <T> uy9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (uy9) invokeL.objValue;
    }

    public static <T> uy9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t)) == null) ? ScalarSynchronousObservable.E(t) : (uy9) invokeL.objValue;
    }

    public static <T> uy9<T> i(Iterable<? extends uy9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) ? j(e(iterable)) : (uy9) invokeL.objValue;
    }

    public static <T> uy9<T> j(uy9<? extends uy9<? extends T>> uy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, uy9Var)) == null) {
            if (uy9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) uy9Var).H(UtilityFunctions.b());
            }
            return (uy9<T>) uy9Var.g(OperatorMerge.a(false));
        }
        return (uy9) invokeL.objValue;
    }

    public static <T> bz9 v(az9<? super T> az9Var, uy9<T> uy9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, az9Var, uy9Var)) == null) {
            if (az9Var != null) {
                if (uy9Var.a != null) {
                    az9Var.d();
                    if (!(az9Var instanceof w2a)) {
                        az9Var = new w2a(az9Var);
                    }
                    try {
                        c3a.p(uy9Var, uy9Var.a).call(az9Var);
                        return c3a.o(az9Var);
                    } catch (Throwable th) {
                        gz9.e(th);
                        if (az9Var.isUnsubscribed()) {
                            c3a.j(c3a.m(th));
                        } else {
                            try {
                                az9Var.onError(c3a.m(th));
                            } catch (Throwable th2) {
                                gz9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                c3a.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return s3a.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (bz9) invokeLL.objValue;
    }

    public final uy9<T> A(long j, TimeUnit timeUnit, uy9<? extends T> uy9Var, xy9 xy9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, uy9Var, xy9Var})) == null) ? (uy9<T>) g(new g0a(j, timeUnit, uy9Var, xy9Var)) : (uy9) invokeCommon.objValue;
    }

    public final bz9 D(az9<? super T> az9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, az9Var)) == null) {
            try {
                az9Var.d();
                c3a.p(this, this.a).call(az9Var);
                return c3a.o(az9Var);
            } catch (Throwable th) {
                gz9.e(th);
                try {
                    az9Var.onError(c3a.m(th));
                    return s3a.c();
                } catch (Throwable th2) {
                    gz9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    c3a.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (bz9) invokeL.objValue;
    }

    public final uy9<T> b(iz9<? super T> iz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iz9Var)) == null) ? a(new tz9(this, new z0a(iz9Var, Actions.a(), Actions.a()))) : (uy9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.repackage.mz9<? super T, ? extends com.repackage.uy9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> uy9<R> d(mz9<? super T, ? extends uy9<? extends R>> mz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mz9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).H(mz9Var);
            }
            return j(h(mz9Var));
        }
        return (uy9) invokeL.objValue;
    }

    public final <R> uy9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new uz9(this.a, bVar)) : (uy9) invokeL.objValue;
    }

    public final <R> uy9<R> h(mz9<? super T, ? extends R> mz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mz9Var)) == null) ? a(new vz9(this, mz9Var)) : (uy9) invokeL.objValue;
    }

    public final uy9<T> k(xy9 xy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xy9Var)) == null) ? l(xy9Var, e1a.c) : (uy9) invokeL.objValue;
    }

    public final uy9<T> l(xy9 xy9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, xy9Var, i)) == null) ? m(xy9Var, false, i) : (uy9) invokeLI.objValue;
    }

    public final uy9<T> m(xy9 xy9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{xy9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).I(xy9Var);
            }
            return (uy9<T>) g(new b0a(xy9Var, z, i));
        }
        return (uy9) invokeCommon.objValue;
    }

    public final uy9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (uy9<T>) g(c0a.a()) : (uy9) invokeV.objValue;
    }

    public final t2a<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.F(this) : (t2a) invokeV.objValue;
    }

    public final t2a<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.G(this, i) : (t2a) invokeI.objValue;
    }

    public final t2a<T> q(int i, long j, TimeUnit timeUnit, xy9 xy9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, xy9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.I(this, j, timeUnit, xy9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (t2a) invokeCommon.objValue;
    }

    public final t2a<T> r(long j, TimeUnit timeUnit, xy9 xy9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, xy9Var})) == null) ? OperatorReplay.H(this, j, timeUnit, xy9Var) : (t2a) invokeCommon.objValue;
    }

    public final uy9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? wz9.a(this) : (uy9) invokeV.objValue;
    }

    public final bz9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new a1a(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (bz9) invokeV.objValue;
    }

    public final bz9 u(az9<? super T> az9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, az9Var)) == null) ? v(az9Var, this) : (bz9) invokeL.objValue;
    }

    public final bz9 w(iz9<? super T> iz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, iz9Var)) == null) {
            if (iz9Var != null) {
                return u(new a1a(iz9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (bz9) invokeL.objValue;
    }

    public final bz9 x(iz9<? super T> iz9Var, iz9<Throwable> iz9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, iz9Var, iz9Var2)) == null) {
            if (iz9Var != null) {
                if (iz9Var2 != null) {
                    return u(new a1a(iz9Var, iz9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (bz9) invokeLL.objValue;
    }

    public final uy9<T> y(xy9 xy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, xy9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).I(xy9Var);
            }
            return a(new f0a(this, xy9Var));
        }
        return (uy9) invokeL.objValue;
    }

    public final uy9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (uy9) invokeJL.objValue;
    }
}
