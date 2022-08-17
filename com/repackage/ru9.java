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
public class ru9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes7.dex */
    public interface a<T> extends fv9<xu9<? super T>> {
        @Override // com.repackage.fv9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public interface b<R, T> extends jv9<xu9<? super R>, xu9<? super T>> {
        @Override // com.repackage.jv9
        /* synthetic */ R call(T t);
    }

    public ru9(a<T> aVar) {
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

    public static <T> ru9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? new ru9<>(yy9.h(aVar)) : (ru9) invokeL.objValue;
    }

    public static <T> ru9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? EmptyObservableHolder.instance() : (ru9) invokeV.objValue;
    }

    public static <T> ru9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (ru9) invokeL.objValue;
    }

    public static <T> ru9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) ? ScalarSynchronousObservable.C(t) : (ru9) invokeL.objValue;
    }

    public static <T> ru9<T> i(Iterable<? extends ru9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? j(e(iterable)) : (ru9) invokeL.objValue;
    }

    public static <T> ru9<T> j(ru9<? extends ru9<? extends T>> ru9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ru9Var)) == null) {
            if (ru9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) ru9Var).F(UtilityFunctions.b());
            }
            return (ru9<T>) ru9Var.g(OperatorMerge.a(false));
        }
        return (ru9) invokeL.objValue;
    }

    public static <T> yu9 v(xu9<? super T> xu9Var, ru9<T> ru9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, xu9Var, ru9Var)) == null) {
            if (xu9Var != null) {
                if (ru9Var.a != null) {
                    xu9Var.d();
                    if (!(xu9Var instanceof sy9)) {
                        xu9Var = new sy9(xu9Var);
                    }
                    try {
                        yy9.p(ru9Var, ru9Var.a).call(xu9Var);
                        return yy9.o(xu9Var);
                    } catch (Throwable th) {
                        dv9.e(th);
                        if (xu9Var.isUnsubscribed()) {
                            yy9.j(yy9.m(th));
                        } else {
                            try {
                                xu9Var.onError(yy9.m(th));
                            } catch (Throwable th2) {
                                dv9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                yy9.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return oz9.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (yu9) invokeLL.objValue;
    }

    public final ru9<T> A(long j, TimeUnit timeUnit, ru9<? extends T> ru9Var, uu9 uu9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, ru9Var, uu9Var})) == null) ? (ru9<T>) g(new cw9(j, timeUnit, ru9Var, uu9Var)) : (ru9) invokeCommon.objValue;
    }

    public final yu9 B(xu9<? super T> xu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xu9Var)) == null) {
            try {
                xu9Var.d();
                yy9.p(this, this.a).call(xu9Var);
                return yy9.o(xu9Var);
            } catch (Throwable th) {
                dv9.e(th);
                try {
                    xu9Var.onError(yy9.m(th));
                    return oz9.c();
                } catch (Throwable th2) {
                    dv9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    yy9.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (yu9) invokeL.objValue;
    }

    public final ru9<T> b(fv9<? super T> fv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fv9Var)) == null) ? a(new qv9(this, new vw9(fv9Var, Actions.a(), Actions.a()))) : (ru9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.repackage.jv9<? super T, ? extends com.repackage.ru9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> ru9<R> d(jv9<? super T, ? extends ru9<? extends R>> jv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jv9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(jv9Var);
            }
            return j(h(jv9Var));
        }
        return (ru9) invokeL.objValue;
    }

    public final <R> ru9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new rv9(this.a, bVar)) : (ru9) invokeL.objValue;
    }

    public final <R> ru9<R> h(jv9<? super T, ? extends R> jv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jv9Var)) == null) ? a(new sv9(this, jv9Var)) : (ru9) invokeL.objValue;
    }

    public final ru9<T> k(uu9 uu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, uu9Var)) == null) ? l(uu9Var, ax9.c) : (ru9) invokeL.objValue;
    }

    public final ru9<T> l(uu9 uu9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, uu9Var, i)) == null) ? m(uu9Var, false, i) : (ru9) invokeLI.objValue;
    }

    public final ru9<T> m(uu9 uu9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{uu9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(uu9Var);
            }
            return (ru9<T>) g(new xv9(uu9Var, z, i));
        }
        return (ru9) invokeCommon.objValue;
    }

    public final ru9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (ru9<T>) g(yv9.a()) : (ru9) invokeV.objValue;
    }

    public final py9<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.D(this) : (py9) invokeV.objValue;
    }

    public final py9<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.E(this, i) : (py9) invokeI.objValue;
    }

    public final py9<T> q(int i, long j, TimeUnit timeUnit, uu9 uu9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, uu9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, uu9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (py9) invokeCommon.objValue;
    }

    public final py9<T> r(long j, TimeUnit timeUnit, uu9 uu9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, uu9Var})) == null) ? OperatorReplay.F(this, j, timeUnit, uu9Var) : (py9) invokeCommon.objValue;
    }

    public final ru9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? tv9.a(this) : (ru9) invokeV.objValue;
    }

    public final yu9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new ww9(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (yu9) invokeV.objValue;
    }

    public final yu9 u(xu9<? super T> xu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, xu9Var)) == null) ? v(xu9Var, this) : (yu9) invokeL.objValue;
    }

    public final yu9 w(fv9<? super T> fv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, fv9Var)) == null) {
            if (fv9Var != null) {
                return u(new ww9(fv9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (yu9) invokeL.objValue;
    }

    public final yu9 x(fv9<? super T> fv9Var, fv9<Throwable> fv9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, fv9Var, fv9Var2)) == null) {
            if (fv9Var != null) {
                if (fv9Var2 != null) {
                    return u(new ww9(fv9Var, fv9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (yu9) invokeLL.objValue;
    }

    public final ru9<T> y(uu9 uu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, uu9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(uu9Var);
            }
            return a(new bw9(this, uu9Var));
        }
        return (ru9) invokeL.objValue;
    }

    public final ru9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (ru9) invokeJL.objValue;
    }
}
