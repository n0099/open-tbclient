package com.google.common.util.concurrent;

import c.i.c.a.g;
import c.i.c.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.FluentFuture;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Class<X> exceptionType;
    public F fallback;
    public ListenableFuture<? extends V> inputFuture;

    /* loaded from: classes7.dex */
    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listenableFuture, cls, asyncFunction};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ListenableFuture) objArr2[0], (Class) objArr2[1], objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Throwable */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) throws Exception {
            return doFallback((AsyncFunction<? super AsyncFunction<? super X, ? extends V>, ? extends V>) obj, (AsyncFunction<? super X, ? extends V>) th);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            setResult((ListenableFuture) ((ListenableFuture) obj));
        }

        public ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> asyncFunction, X x) throws Exception {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, asyncFunction, x)) == null) {
                ListenableFuture<? extends V> apply = asyncFunction.apply(x);
                n.r(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
                return apply;
            }
            return (ListenableFuture) invokeLL.objValue;
        }

        public void setResult(ListenableFuture<? extends V> listenableFuture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, listenableFuture) == null) {
                setFuture(listenableFuture);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, g<? super X, ? extends V>, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, g<? super X, ? extends V> gVar) {
            super(listenableFuture, cls, gVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listenableFuture, cls, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ListenableFuture) objArr2[0], (Class) objArr2[1], objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Throwable */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) throws Exception {
            return doFallback((g<? super g<? super X, ? extends V>, ? extends V>) obj, (g<? super X, ? extends V>) th);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v) == null) {
                set(v);
            }
        }

        public V doFallback(g<? super X, ? extends V> gVar, X x) throws Exception {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gVar, x)) == null) ? gVar.apply(x) : (V) invokeLL.objValue;
        }
    }

    public AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listenableFuture, cls, f2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(listenableFuture);
        this.inputFuture = listenableFuture;
        n.p(cls);
        this.exceptionType = cls;
        n.p(f2);
        this.fallback = f2;
    }

    public static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, g<? super X, ? extends V> gVar, Executor executor) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, listenableFuture, cls, gVar, executor)) == null) {
            CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, gVar);
            listenableFuture.addListener(catchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, catchingFuture));
            return catchingFuture;
        }
        return (ListenableFuture) invokeLLLL.objValue;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            maybePropagateCancellationTo(this.inputFuture);
            this.inputFuture = null;
            this.exceptionType = null;
            this.fallback = null;
        }
    }

    public abstract T doFallback(F f2, X x) throws Exception;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ListenableFuture<? extends V> listenableFuture = this.inputFuture;
            Class<X> cls = this.exceptionType;
            F f2 = this.fallback;
            String pendingToString = super.pendingToString();
            if (listenableFuture != null) {
                str = "inputFuture=[" + listenableFuture + "], ";
            } else {
                str = "";
            }
            if (cls == null || f2 == null) {
                if (pendingToString != null) {
                    return str + pendingToString;
                }
                return null;
            }
            return str + "exceptionType=[" + cls + "], fallback=[" + f2 + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.util.concurrent.AbstractCatchingFuture<V, X extends java.lang.Throwable, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0041  */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class<X extends java.lang.Throwable>, F] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ListenableFuture<? extends V> listenableFuture = this.inputFuture;
            Class<X> cls = this.exceptionType;
            F f2 = this.fallback;
            if (((f2 == null) | (listenableFuture == null) | (cls == null)) || isCancelled()) {
                return;
            }
            ?? r3 = (Class<X>) false;
            this.inputFuture = null;
            try {
                obj = Futures.getDone(listenableFuture);
                th = null;
            } catch (ExecutionException e2) {
                Throwable cause = e2.getCause();
                n.p(cause);
                th = cause;
                obj = null;
                if (th == null) {
                }
            } catch (Throwable th) {
                th = th;
                obj = null;
                if (th == null) {
                }
            }
            if (th == null) {
                set(obj);
            } else if (!Platform.isInstanceOfThrowableClass(th, cls)) {
                setFuture(listenableFuture);
            } else {
                try {
                    Object doFallback = doFallback(f2, th);
                    this.exceptionType = null;
                    this.fallback = null;
                    setResult(doFallback);
                } catch (Throwable th2) {
                    try {
                        setException(th2);
                    } finally {
                        this.exceptionType = null;
                        this.fallback = null;
                    }
                }
            }
        }
    }

    public abstract void setResult(T t);

    public static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, listenableFuture, cls, asyncFunction, executor)) == null) {
            AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
            listenableFuture.addListener(asyncCatchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncCatchingFuture));
            return asyncCatchingFuture;
        }
        return (ListenableFuture) invokeLLLL.objValue;
    }
}
