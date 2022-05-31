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
/* loaded from: classes6.dex */
public class qu9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes6.dex */
    public interface a<T> extends ev9<wu9<? super T>> {
        @Override // com.repackage.ev9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public interface b<R, T> extends iv9<wu9<? super R>, wu9<? super T>> {
        @Override // com.repackage.iv9
        /* synthetic */ R call(T t);
    }

    public qu9(a<T> aVar) {
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

    public static <T> qu9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? new qu9<>(xy9.h(aVar)) : (qu9) invokeL.objValue;
    }

    public static <T> qu9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? EmptyObservableHolder.instance() : (qu9) invokeV.objValue;
    }

    public static <T> qu9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (qu9) invokeL.objValue;
    }

    public static <T> qu9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) ? ScalarSynchronousObservable.C(t) : (qu9) invokeL.objValue;
    }

    public static <T> qu9<T> i(Iterable<? extends qu9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? j(e(iterable)) : (qu9) invokeL.objValue;
    }

    public static <T> qu9<T> j(qu9<? extends qu9<? extends T>> qu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, qu9Var)) == null) {
            if (qu9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) qu9Var).F(UtilityFunctions.b());
            }
            return (qu9<T>) qu9Var.g(OperatorMerge.a(false));
        }
        return (qu9) invokeL.objValue;
    }

    public static <T> xu9 v(wu9<? super T> wu9Var, qu9<T> qu9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, wu9Var, qu9Var)) == null) {
            if (wu9Var != null) {
                if (qu9Var.a != null) {
                    wu9Var.d();
                    if (!(wu9Var instanceof ry9)) {
                        wu9Var = new ry9(wu9Var);
                    }
                    try {
                        xy9.p(qu9Var, qu9Var.a).call(wu9Var);
                        return xy9.o(wu9Var);
                    } catch (Throwable th) {
                        cv9.e(th);
                        if (wu9Var.isUnsubscribed()) {
                            xy9.j(xy9.m(th));
                        } else {
                            try {
                                wu9Var.onError(xy9.m(th));
                            } catch (Throwable th2) {
                                cv9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                xy9.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return nz9.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (xu9) invokeLL.objValue;
    }

    public final qu9<T> A(long j, TimeUnit timeUnit, qu9<? extends T> qu9Var, tu9 tu9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, qu9Var, tu9Var})) == null) ? (qu9<T>) g(new bw9(j, timeUnit, qu9Var, tu9Var)) : (qu9) invokeCommon.objValue;
    }

    public final xu9 B(wu9<? super T> wu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wu9Var)) == null) {
            try {
                wu9Var.d();
                xy9.p(this, this.a).call(wu9Var);
                return xy9.o(wu9Var);
            } catch (Throwable th) {
                cv9.e(th);
                try {
                    wu9Var.onError(xy9.m(th));
                    return nz9.c();
                } catch (Throwable th2) {
                    cv9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    xy9.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (xu9) invokeL.objValue;
    }

    public final qu9<T> b(ev9<? super T> ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ev9Var)) == null) ? a(new pv9(this, new uw9(ev9Var, Actions.a(), Actions.a()))) : (qu9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.repackage.iv9<? super T, ? extends com.repackage.qu9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> qu9<R> d(iv9<? super T, ? extends qu9<? extends R>> iv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iv9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(iv9Var);
            }
            return j(h(iv9Var));
        }
        return (qu9) invokeL.objValue;
    }

    public final <R> qu9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new qv9(this.a, bVar)) : (qu9) invokeL.objValue;
    }

    public final <R> qu9<R> h(iv9<? super T, ? extends R> iv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iv9Var)) == null) ? a(new rv9(this, iv9Var)) : (qu9) invokeL.objValue;
    }

    public final qu9<T> k(tu9 tu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tu9Var)) == null) ? l(tu9Var, zw9.c) : (qu9) invokeL.objValue;
    }

    public final qu9<T> l(tu9 tu9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, tu9Var, i)) == null) ? m(tu9Var, false, i) : (qu9) invokeLI.objValue;
    }

    public final qu9<T> m(tu9 tu9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{tu9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(tu9Var);
            }
            return (qu9<T>) g(new wv9(tu9Var, z, i));
        }
        return (qu9) invokeCommon.objValue;
    }

    public final qu9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (qu9<T>) g(xv9.a()) : (qu9) invokeV.objValue;
    }

    public final oy9<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.D(this) : (oy9) invokeV.objValue;
    }

    public final oy9<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.E(this, i) : (oy9) invokeI.objValue;
    }

    public final oy9<T> q(int i, long j, TimeUnit timeUnit, tu9 tu9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, tu9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, tu9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (oy9) invokeCommon.objValue;
    }

    public final oy9<T> r(long j, TimeUnit timeUnit, tu9 tu9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, tu9Var})) == null) ? OperatorReplay.F(this, j, timeUnit, tu9Var) : (oy9) invokeCommon.objValue;
    }

    public final qu9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? sv9.a(this) : (qu9) invokeV.objValue;
    }

    public final xu9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new vw9(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (xu9) invokeV.objValue;
    }

    public final xu9 u(wu9<? super T> wu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, wu9Var)) == null) ? v(wu9Var, this) : (xu9) invokeL.objValue;
    }

    public final xu9 w(ev9<? super T> ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, ev9Var)) == null) {
            if (ev9Var != null) {
                return u(new vw9(ev9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (xu9) invokeL.objValue;
    }

    public final xu9 x(ev9<? super T> ev9Var, ev9<Throwable> ev9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, ev9Var, ev9Var2)) == null) {
            if (ev9Var != null) {
                if (ev9Var2 != null) {
                    return u(new vw9(ev9Var, ev9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (xu9) invokeLL.objValue;
    }

    public final qu9<T> y(tu9 tu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tu9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(tu9Var);
            }
            return a(new aw9(this, tu9Var));
        }
        return (qu9) invokeL.objValue;
    }

    public final qu9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (qu9) invokeJL.objValue;
    }
}
