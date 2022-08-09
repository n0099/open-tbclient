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
public class pu9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes7.dex */
    public interface a<T> extends dv9<vu9<? super T>> {
        @Override // com.repackage.dv9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public interface b<R, T> extends hv9<vu9<? super R>, vu9<? super T>> {
        @Override // com.repackage.hv9
        /* synthetic */ R call(T t);
    }

    public pu9(a<T> aVar) {
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

    public static <T> pu9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? new pu9<>(wy9.h(aVar)) : (pu9) invokeL.objValue;
    }

    public static <T> pu9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? EmptyObservableHolder.instance() : (pu9) invokeV.objValue;
    }

    public static <T> pu9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (pu9) invokeL.objValue;
    }

    public static <T> pu9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) ? ScalarSynchronousObservable.C(t) : (pu9) invokeL.objValue;
    }

    public static <T> pu9<T> i(Iterable<? extends pu9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? j(e(iterable)) : (pu9) invokeL.objValue;
    }

    public static <T> pu9<T> j(pu9<? extends pu9<? extends T>> pu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, pu9Var)) == null) {
            if (pu9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) pu9Var).F(UtilityFunctions.b());
            }
            return (pu9<T>) pu9Var.g(OperatorMerge.a(false));
        }
        return (pu9) invokeL.objValue;
    }

    public static <T> wu9 v(vu9<? super T> vu9Var, pu9<T> pu9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, vu9Var, pu9Var)) == null) {
            if (vu9Var != null) {
                if (pu9Var.a != null) {
                    vu9Var.d();
                    if (!(vu9Var instanceof qy9)) {
                        vu9Var = new qy9(vu9Var);
                    }
                    try {
                        wy9.p(pu9Var, pu9Var.a).call(vu9Var);
                        return wy9.o(vu9Var);
                    } catch (Throwable th) {
                        bv9.e(th);
                        if (vu9Var.isUnsubscribed()) {
                            wy9.j(wy9.m(th));
                        } else {
                            try {
                                vu9Var.onError(wy9.m(th));
                            } catch (Throwable th2) {
                                bv9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                wy9.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return mz9.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (wu9) invokeLL.objValue;
    }

    public final pu9<T> A(long j, TimeUnit timeUnit, pu9<? extends T> pu9Var, su9 su9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, pu9Var, su9Var})) == null) ? (pu9<T>) g(new aw9(j, timeUnit, pu9Var, su9Var)) : (pu9) invokeCommon.objValue;
    }

    public final wu9 B(vu9<? super T> vu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vu9Var)) == null) {
            try {
                vu9Var.d();
                wy9.p(this, this.a).call(vu9Var);
                return wy9.o(vu9Var);
            } catch (Throwable th) {
                bv9.e(th);
                try {
                    vu9Var.onError(wy9.m(th));
                    return mz9.c();
                } catch (Throwable th2) {
                    bv9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    wy9.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (wu9) invokeL.objValue;
    }

    public final pu9<T> b(dv9<? super T> dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dv9Var)) == null) ? a(new ov9(this, new tw9(dv9Var, Actions.a(), Actions.a()))) : (pu9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.repackage.hv9<? super T, ? extends com.repackage.pu9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> pu9<R> d(hv9<? super T, ? extends pu9<? extends R>> hv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hv9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(hv9Var);
            }
            return j(h(hv9Var));
        }
        return (pu9) invokeL.objValue;
    }

    public final <R> pu9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new pv9(this.a, bVar)) : (pu9) invokeL.objValue;
    }

    public final <R> pu9<R> h(hv9<? super T, ? extends R> hv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hv9Var)) == null) ? a(new qv9(this, hv9Var)) : (pu9) invokeL.objValue;
    }

    public final pu9<T> k(su9 su9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, su9Var)) == null) ? l(su9Var, yw9.c) : (pu9) invokeL.objValue;
    }

    public final pu9<T> l(su9 su9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, su9Var, i)) == null) ? m(su9Var, false, i) : (pu9) invokeLI.objValue;
    }

    public final pu9<T> m(su9 su9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{su9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(su9Var);
            }
            return (pu9<T>) g(new vv9(su9Var, z, i));
        }
        return (pu9) invokeCommon.objValue;
    }

    public final pu9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (pu9<T>) g(wv9.a()) : (pu9) invokeV.objValue;
    }

    public final ny9<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.D(this) : (ny9) invokeV.objValue;
    }

    public final ny9<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.E(this, i) : (ny9) invokeI.objValue;
    }

    public final ny9<T> q(int i, long j, TimeUnit timeUnit, su9 su9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, su9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, su9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (ny9) invokeCommon.objValue;
    }

    public final ny9<T> r(long j, TimeUnit timeUnit, su9 su9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, su9Var})) == null) ? OperatorReplay.F(this, j, timeUnit, su9Var) : (ny9) invokeCommon.objValue;
    }

    public final pu9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? rv9.a(this) : (pu9) invokeV.objValue;
    }

    public final wu9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new uw9(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (wu9) invokeV.objValue;
    }

    public final wu9 u(vu9<? super T> vu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, vu9Var)) == null) ? v(vu9Var, this) : (wu9) invokeL.objValue;
    }

    public final wu9 w(dv9<? super T> dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, dv9Var)) == null) {
            if (dv9Var != null) {
                return u(new uw9(dv9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (wu9) invokeL.objValue;
    }

    public final wu9 x(dv9<? super T> dv9Var, dv9<Throwable> dv9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, dv9Var, dv9Var2)) == null) {
            if (dv9Var != null) {
                if (dv9Var2 != null) {
                    return u(new uw9(dv9Var, dv9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (wu9) invokeLL.objValue;
    }

    public final pu9<T> y(su9 su9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, su9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(su9Var);
            }
            return a(new zv9(this, su9Var));
        }
        return (pu9) invokeL.objValue;
    }

    public final pu9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (pu9) invokeJL.objValue;
    }
}
