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
public class ur9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes7.dex */
    public interface a<T> extends is9<as9<? super T>> {
        @Override // com.repackage.is9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public interface b<R, T> extends ms9<as9<? super R>, as9<? super T>> {
        @Override // com.repackage.ms9
        /* synthetic */ R call(T t);
    }

    public ur9(a<T> aVar) {
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

    public static <T> ur9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? new ur9<>(bw9.h(aVar)) : (ur9) invokeL.objValue;
    }

    public static <T> ur9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? EmptyObservableHolder.instance() : (ur9) invokeV.objValue;
    }

    public static <T> ur9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (ur9) invokeL.objValue;
    }

    public static <T> ur9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) ? ScalarSynchronousObservable.C(t) : (ur9) invokeL.objValue;
    }

    public static <T> ur9<T> i(Iterable<? extends ur9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? j(e(iterable)) : (ur9) invokeL.objValue;
    }

    public static <T> ur9<T> j(ur9<? extends ur9<? extends T>> ur9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ur9Var)) == null) {
            if (ur9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) ur9Var).F(UtilityFunctions.b());
            }
            return (ur9<T>) ur9Var.g(OperatorMerge.a(false));
        }
        return (ur9) invokeL.objValue;
    }

    public static <T> bs9 v(as9<? super T> as9Var, ur9<T> ur9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, as9Var, ur9Var)) == null) {
            if (as9Var != null) {
                if (ur9Var.a != null) {
                    as9Var.d();
                    if (!(as9Var instanceof vv9)) {
                        as9Var = new vv9(as9Var);
                    }
                    try {
                        bw9.p(ur9Var, ur9Var.a).call(as9Var);
                        return bw9.o(as9Var);
                    } catch (Throwable th) {
                        gs9.e(th);
                        if (as9Var.isUnsubscribed()) {
                            bw9.j(bw9.m(th));
                        } else {
                            try {
                                as9Var.onError(bw9.m(th));
                            } catch (Throwable th2) {
                                gs9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                bw9.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return rw9.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (bs9) invokeLL.objValue;
    }

    public final ur9<T> A(long j, TimeUnit timeUnit, ur9<? extends T> ur9Var, xr9 xr9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, ur9Var, xr9Var})) == null) ? (ur9<T>) g(new ft9(j, timeUnit, ur9Var, xr9Var)) : (ur9) invokeCommon.objValue;
    }

    public final bs9 B(as9<? super T> as9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, as9Var)) == null) {
            try {
                as9Var.d();
                bw9.p(this, this.a).call(as9Var);
                return bw9.o(as9Var);
            } catch (Throwable th) {
                gs9.e(th);
                try {
                    as9Var.onError(bw9.m(th));
                    return rw9.c();
                } catch (Throwable th2) {
                    gs9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    bw9.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (bs9) invokeL.objValue;
    }

    public final ur9<T> b(is9<? super T> is9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, is9Var)) == null) ? a(new ts9(this, new yt9(is9Var, Actions.a(), Actions.a()))) : (ur9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.repackage.ms9<? super T, ? extends com.repackage.ur9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> ur9<R> d(ms9<? super T, ? extends ur9<? extends R>> ms9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ms9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(ms9Var);
            }
            return j(h(ms9Var));
        }
        return (ur9) invokeL.objValue;
    }

    public final <R> ur9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new us9(this.a, bVar)) : (ur9) invokeL.objValue;
    }

    public final <R> ur9<R> h(ms9<? super T, ? extends R> ms9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ms9Var)) == null) ? a(new vs9(this, ms9Var)) : (ur9) invokeL.objValue;
    }

    public final ur9<T> k(xr9 xr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xr9Var)) == null) ? l(xr9Var, du9.c) : (ur9) invokeL.objValue;
    }

    public final ur9<T> l(xr9 xr9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, xr9Var, i)) == null) ? m(xr9Var, false, i) : (ur9) invokeLI.objValue;
    }

    public final ur9<T> m(xr9 xr9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{xr9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(xr9Var);
            }
            return (ur9<T>) g(new at9(xr9Var, z, i));
        }
        return (ur9) invokeCommon.objValue;
    }

    public final ur9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (ur9<T>) g(bt9.a()) : (ur9) invokeV.objValue;
    }

    public final sv9<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.D(this) : (sv9) invokeV.objValue;
    }

    public final sv9<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.E(this, i) : (sv9) invokeI.objValue;
    }

    public final sv9<T> q(int i, long j, TimeUnit timeUnit, xr9 xr9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, xr9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, xr9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (sv9) invokeCommon.objValue;
    }

    public final sv9<T> r(long j, TimeUnit timeUnit, xr9 xr9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, xr9Var})) == null) ? OperatorReplay.F(this, j, timeUnit, xr9Var) : (sv9) invokeCommon.objValue;
    }

    public final ur9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? ws9.a(this) : (ur9) invokeV.objValue;
    }

    public final bs9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new zt9(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (bs9) invokeV.objValue;
    }

    public final bs9 u(as9<? super T> as9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, as9Var)) == null) ? v(as9Var, this) : (bs9) invokeL.objValue;
    }

    public final bs9 w(is9<? super T> is9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, is9Var)) == null) {
            if (is9Var != null) {
                return u(new zt9(is9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (bs9) invokeL.objValue;
    }

    public final bs9 x(is9<? super T> is9Var, is9<Throwable> is9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, is9Var, is9Var2)) == null) {
            if (is9Var != null) {
                if (is9Var2 != null) {
                    return u(new zt9(is9Var, is9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (bs9) invokeLL.objValue;
    }

    public final ur9<T> y(xr9 xr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, xr9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(xr9Var);
            }
            return a(new et9(this, xr9Var));
        }
        return (ur9) invokeL.objValue;
    }

    public final ur9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (ur9) invokeJL.objValue;
    }
}
