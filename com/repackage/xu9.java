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
public class xu9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes7.dex */
    public interface a<T> extends lv9<dv9<? super T>> {
        @Override // com.repackage.lv9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public interface b<R, T> extends pv9<dv9<? super R>, dv9<? super T>> {
        @Override // com.repackage.pv9
        /* synthetic */ R call(T t);
    }

    public xu9(a<T> aVar) {
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

    public static <T> xu9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? new xu9<>(ez9.h(aVar)) : (xu9) invokeL.objValue;
    }

    public static <T> xu9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? EmptyObservableHolder.instance() : (xu9) invokeV.objValue;
    }

    public static <T> xu9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (xu9) invokeL.objValue;
    }

    public static <T> xu9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) ? ScalarSynchronousObservable.C(t) : (xu9) invokeL.objValue;
    }

    public static <T> xu9<T> i(Iterable<? extends xu9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? j(e(iterable)) : (xu9) invokeL.objValue;
    }

    public static <T> xu9<T> j(xu9<? extends xu9<? extends T>> xu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, xu9Var)) == null) {
            if (xu9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) xu9Var).F(UtilityFunctions.b());
            }
            return (xu9<T>) xu9Var.g(OperatorMerge.a(false));
        }
        return (xu9) invokeL.objValue;
    }

    public static <T> ev9 v(dv9<? super T> dv9Var, xu9<T> xu9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, dv9Var, xu9Var)) == null) {
            if (dv9Var != null) {
                if (xu9Var.a != null) {
                    dv9Var.d();
                    if (!(dv9Var instanceof yy9)) {
                        dv9Var = new yy9(dv9Var);
                    }
                    try {
                        ez9.p(xu9Var, xu9Var.a).call(dv9Var);
                        return ez9.o(dv9Var);
                    } catch (Throwable th) {
                        jv9.e(th);
                        if (dv9Var.isUnsubscribed()) {
                            ez9.j(ez9.m(th));
                        } else {
                            try {
                                dv9Var.onError(ez9.m(th));
                            } catch (Throwable th2) {
                                jv9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                ez9.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return uz9.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (ev9) invokeLL.objValue;
    }

    public final xu9<T> A(long j, TimeUnit timeUnit, xu9<? extends T> xu9Var, av9 av9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, xu9Var, av9Var})) == null) ? (xu9<T>) g(new iw9(j, timeUnit, xu9Var, av9Var)) : (xu9) invokeCommon.objValue;
    }

    public final ev9 B(dv9<? super T> dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dv9Var)) == null) {
            try {
                dv9Var.d();
                ez9.p(this, this.a).call(dv9Var);
                return ez9.o(dv9Var);
            } catch (Throwable th) {
                jv9.e(th);
                try {
                    dv9Var.onError(ez9.m(th));
                    return uz9.c();
                } catch (Throwable th2) {
                    jv9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    ez9.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (ev9) invokeL.objValue;
    }

    public final xu9<T> b(lv9<? super T> lv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lv9Var)) == null) ? a(new wv9(this, new bx9(lv9Var, Actions.a(), Actions.a()))) : (xu9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.repackage.pv9<? super T, ? extends com.repackage.xu9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> xu9<R> d(pv9<? super T, ? extends xu9<? extends R>> pv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pv9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(pv9Var);
            }
            return j(h(pv9Var));
        }
        return (xu9) invokeL.objValue;
    }

    public final <R> xu9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new xv9(this.a, bVar)) : (xu9) invokeL.objValue;
    }

    public final <R> xu9<R> h(pv9<? super T, ? extends R> pv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pv9Var)) == null) ? a(new yv9(this, pv9Var)) : (xu9) invokeL.objValue;
    }

    public final xu9<T> k(av9 av9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, av9Var)) == null) ? l(av9Var, gx9.c) : (xu9) invokeL.objValue;
    }

    public final xu9<T> l(av9 av9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, av9Var, i)) == null) ? m(av9Var, false, i) : (xu9) invokeLI.objValue;
    }

    public final xu9<T> m(av9 av9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{av9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(av9Var);
            }
            return (xu9<T>) g(new dw9(av9Var, z, i));
        }
        return (xu9) invokeCommon.objValue;
    }

    public final xu9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (xu9<T>) g(ew9.a()) : (xu9) invokeV.objValue;
    }

    public final vy9<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.D(this) : (vy9) invokeV.objValue;
    }

    public final vy9<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.E(this, i) : (vy9) invokeI.objValue;
    }

    public final vy9<T> q(int i, long j, TimeUnit timeUnit, av9 av9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, av9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, av9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (vy9) invokeCommon.objValue;
    }

    public final vy9<T> r(long j, TimeUnit timeUnit, av9 av9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, av9Var})) == null) ? OperatorReplay.F(this, j, timeUnit, av9Var) : (vy9) invokeCommon.objValue;
    }

    public final xu9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? zv9.a(this) : (xu9) invokeV.objValue;
    }

    public final ev9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new cx9(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (ev9) invokeV.objValue;
    }

    public final ev9 u(dv9<? super T> dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, dv9Var)) == null) ? v(dv9Var, this) : (ev9) invokeL.objValue;
    }

    public final ev9 w(lv9<? super T> lv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, lv9Var)) == null) {
            if (lv9Var != null) {
                return u(new cx9(lv9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (ev9) invokeL.objValue;
    }

    public final ev9 x(lv9<? super T> lv9Var, lv9<Throwable> lv9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, lv9Var, lv9Var2)) == null) {
            if (lv9Var != null) {
                if (lv9Var2 != null) {
                    return u(new cx9(lv9Var, lv9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (ev9) invokeLL.objValue;
    }

    public final xu9<T> y(av9 av9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, av9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(av9Var);
            }
            return a(new hw9(this, av9Var));
        }
        return (xu9) invokeL.objValue;
    }

    public final xu9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (xu9) invokeJL.objValue;
    }
}
