package com.google.common.util.concurrent;

import c.i.d.a.g;
import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public F function;
    public ListenableFuture<? extends I> inputFuture;

    /* loaded from: classes3.dex */
    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsyncTransformFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listenableFuture, asyncFunction};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ListenableFuture) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public /* bridge */ /* synthetic */ Object doTransform(Object obj, Object obj2) throws Exception {
            return doTransform((AsyncFunction<? super AsyncFunction<? super I, ? extends O>, ? extends O>) obj, (AsyncFunction<? super I, ? extends O>) obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            setResult((ListenableFuture) ((ListenableFuture) obj));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: I */
        /* JADX WARN: Multi-variable type inference failed */
        public ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> asyncFunction, I i2) throws Exception {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, asyncFunction, i2)) == null) {
                ListenableFuture<? extends O> apply = asyncFunction.apply(i2);
                n.r(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
                return apply;
            }
            return (ListenableFuture) invokeLL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.util.concurrent.ListenableFuture<? extends O> */
        /* JADX WARN: Multi-variable type inference failed */
        public void setResult(ListenableFuture<? extends O> listenableFuture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, listenableFuture) == null) {
                setFuture(listenableFuture);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, g<? super I, ? extends O>, O> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransformFuture(ListenableFuture<? extends I> listenableFuture, g<? super I, ? extends O> gVar) {
            super(listenableFuture, gVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listenableFuture, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ListenableFuture) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public /* bridge */ /* synthetic */ Object doTransform(Object obj, Object obj2) throws Exception {
            return doTransform((g<? super g<? super I, ? extends O>, ? extends O>) obj, (g<? super I, ? extends O>) obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(O o) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o) == null) {
                set(o);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: I */
        /* JADX WARN: Multi-variable type inference failed */
        public O doTransform(g<? super I, ? extends O> gVar, I i2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gVar, i2)) == null) ? gVar.apply(i2) : (O) invokeLL.objValue;
        }
    }

    public AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listenableFuture, f2};
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
        n.p(f2);
        this.function = f2;
    }

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, listenableFuture, asyncFunction, executor)) == null) {
            n.p(executor);
            AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
            listenableFuture.addListener(asyncTransformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncTransformFuture));
            return asyncTransformFuture;
        }
        return (ListenableFuture) invokeLLL.objValue;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            maybePropagateCancellationTo(this.inputFuture);
            this.inputFuture = null;
            this.function = null;
        }
    }

    public abstract T doTransform(F f2, I i2) throws Exception;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ListenableFuture<? extends I> listenableFuture = this.inputFuture;
            F f2 = this.function;
            String pendingToString = super.pendingToString();
            if (listenableFuture != null) {
                str = "inputFuture=[" + listenableFuture + "], ";
            } else {
                str = "";
            }
            if (f2 != null) {
                return str + "function=[" + f2 + PreferencesUtil.RIGHT_MOUNT;
            } else if (pendingToString != null) {
                return str + pendingToString;
            } else {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.util.concurrent.AbstractTransformFuture<I, O, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ListenableFuture<? extends I> listenableFuture = this.inputFuture;
            F f2 = this.function;
            if ((isCancelled() | (listenableFuture == null)) || (f2 == null)) {
                return;
            }
            this.inputFuture = null;
            if (listenableFuture.isCancelled()) {
                setFuture(listenableFuture);
                return;
            }
            try {
                try {
                    Object doTransform = doTransform(f2, Futures.getDone(listenableFuture));
                    this.function = null;
                    setResult(doTransform);
                } catch (Throwable th) {
                    try {
                        setException(th);
                    } finally {
                        this.function = null;
                    }
                }
            } catch (Error e2) {
                setException(e2);
            } catch (CancellationException unused) {
                cancel(false);
            } catch (RuntimeException e3) {
                setException(e3);
            } catch (ExecutionException e4) {
                setException(e4.getCause());
            }
        }
    }

    public abstract void setResult(T t);

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, g<? super I, ? extends O> gVar, Executor executor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, listenableFuture, gVar, executor)) == null) {
            n.p(gVar);
            TransformFuture transformFuture = new TransformFuture(listenableFuture, gVar);
            listenableFuture.addListener(transformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, transformFuture));
            return transformFuture;
        }
        return (ListenableFuture) invokeLLL.objValue;
    }
}
