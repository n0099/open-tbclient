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
public class wx9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes7.dex */
    public interface a<T> extends ky9<cy9<? super T>> {
        @Override // com.repackage.ky9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public interface b<R, T> extends oy9<cy9<? super R>, cy9<? super T>> {
        @Override // com.repackage.oy9
        /* synthetic */ R call(T t);
    }

    public wx9(a<T> aVar) {
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

    public static <T> wx9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? new wx9<>(d2a.h(aVar)) : (wx9) invokeL.objValue;
    }

    public static <T> wx9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? EmptyObservableHolder.instance() : (wx9) invokeV.objValue;
    }

    public static <T> wx9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (wx9) invokeL.objValue;
    }

    public static <T> wx9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) ? ScalarSynchronousObservable.C(t) : (wx9) invokeL.objValue;
    }

    public static <T> wx9<T> i(Iterable<? extends wx9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? j(e(iterable)) : (wx9) invokeL.objValue;
    }

    public static <T> wx9<T> j(wx9<? extends wx9<? extends T>> wx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, wx9Var)) == null) {
            if (wx9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) wx9Var).F(UtilityFunctions.b());
            }
            return (wx9<T>) wx9Var.g(OperatorMerge.a(false));
        }
        return (wx9) invokeL.objValue;
    }

    public static <T> dy9 v(cy9<? super T> cy9Var, wx9<T> wx9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, cy9Var, wx9Var)) == null) {
            if (cy9Var != null) {
                if (wx9Var.a != null) {
                    cy9Var.d();
                    if (!(cy9Var instanceof x1a)) {
                        cy9Var = new x1a(cy9Var);
                    }
                    try {
                        d2a.p(wx9Var, wx9Var.a).call(cy9Var);
                        return d2a.o(cy9Var);
                    } catch (Throwable th) {
                        iy9.e(th);
                        if (cy9Var.isUnsubscribed()) {
                            d2a.j(d2a.m(th));
                        } else {
                            try {
                                cy9Var.onError(d2a.m(th));
                            } catch (Throwable th2) {
                                iy9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                d2a.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return t2a.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (dy9) invokeLL.objValue;
    }

    public final wx9<T> A(long j, TimeUnit timeUnit, wx9<? extends T> wx9Var, zx9 zx9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, wx9Var, zx9Var})) == null) ? (wx9<T>) g(new hz9(j, timeUnit, wx9Var, zx9Var)) : (wx9) invokeCommon.objValue;
    }

    public final dy9 B(cy9<? super T> cy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cy9Var)) == null) {
            try {
                cy9Var.d();
                d2a.p(this, this.a).call(cy9Var);
                return d2a.o(cy9Var);
            } catch (Throwable th) {
                iy9.e(th);
                try {
                    cy9Var.onError(d2a.m(th));
                    return t2a.c();
                } catch (Throwable th2) {
                    iy9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    d2a.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (dy9) invokeL.objValue;
    }

    public final wx9<T> b(ky9<? super T> ky9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ky9Var)) == null) ? a(new vy9(this, new a0a(ky9Var, Actions.a(), Actions.a()))) : (wx9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.repackage.oy9<? super T, ? extends com.repackage.wx9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> wx9<R> d(oy9<? super T, ? extends wx9<? extends R>> oy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, oy9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(oy9Var);
            }
            return j(h(oy9Var));
        }
        return (wx9) invokeL.objValue;
    }

    public final <R> wx9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new wy9(this.a, bVar)) : (wx9) invokeL.objValue;
    }

    public final <R> wx9<R> h(oy9<? super T, ? extends R> oy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, oy9Var)) == null) ? a(new xy9(this, oy9Var)) : (wx9) invokeL.objValue;
    }

    public final wx9<T> k(zx9 zx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zx9Var)) == null) ? l(zx9Var, f0a.c) : (wx9) invokeL.objValue;
    }

    public final wx9<T> l(zx9 zx9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, zx9Var, i)) == null) ? m(zx9Var, false, i) : (wx9) invokeLI.objValue;
    }

    public final wx9<T> m(zx9 zx9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{zx9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(zx9Var);
            }
            return (wx9<T>) g(new cz9(zx9Var, z, i));
        }
        return (wx9) invokeCommon.objValue;
    }

    public final wx9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (wx9<T>) g(dz9.a()) : (wx9) invokeV.objValue;
    }

    public final u1a<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.D(this) : (u1a) invokeV.objValue;
    }

    public final u1a<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.E(this, i) : (u1a) invokeI.objValue;
    }

    public final u1a<T> q(int i, long j, TimeUnit timeUnit, zx9 zx9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, zx9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, zx9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (u1a) invokeCommon.objValue;
    }

    public final u1a<T> r(long j, TimeUnit timeUnit, zx9 zx9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, zx9Var})) == null) ? OperatorReplay.F(this, j, timeUnit, zx9Var) : (u1a) invokeCommon.objValue;
    }

    public final wx9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? yy9.a(this) : (wx9) invokeV.objValue;
    }

    public final dy9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new b0a(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (dy9) invokeV.objValue;
    }

    public final dy9 u(cy9<? super T> cy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, cy9Var)) == null) ? v(cy9Var, this) : (dy9) invokeL.objValue;
    }

    public final dy9 w(ky9<? super T> ky9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, ky9Var)) == null) {
            if (ky9Var != null) {
                return u(new b0a(ky9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (dy9) invokeL.objValue;
    }

    public final dy9 x(ky9<? super T> ky9Var, ky9<Throwable> ky9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, ky9Var, ky9Var2)) == null) {
            if (ky9Var != null) {
                if (ky9Var2 != null) {
                    return u(new b0a(ky9Var, ky9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (dy9) invokeLL.objValue;
    }

    public final wx9<T> y(zx9 zx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, zx9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(zx9Var);
            }
            return a(new gz9(this, zx9Var));
        }
        return (wx9) invokeL.objValue;
    }

    public final wx9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (wx9) invokeJL.objValue;
    }
}
