package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import b.h.d.a.g;
import b.h.d.a.j;
import b.h.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.Partially;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public final class Futures extends GwtFuturesCatchingSpecialization {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static final class CallbackListener<V> implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final FutureCallback<? super V> callback;
        public final Future<V> future;

        public CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {future, futureCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.future = future;
            this.callback = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.callback.onSuccess(Futures.getDone(this.future));
                } catch (Error e2) {
                    e = e2;
                    this.callback.onFailure(e);
                } catch (RuntimeException e3) {
                    e = e3;
                    this.callback.onFailure(e);
                } catch (ExecutionException e4) {
                    this.callback.onFailure(e4.getCause());
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                j.b c2 = j.c(this);
                c2.h(this.callback);
                return c2.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class FutureCombiner<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean allMustSucceed;
        public final ImmutableList<ListenableFuture<? extends V>> futures;

        public <C> ListenableFuture<C> call(Callable<C> callable, Executor executor) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, callable, executor)) == null) ? new CombinedFuture(this.futures, this.allMustSucceed, executor, callable) : (ListenableFuture) invokeLL.objValue;
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> asyncCallable, Executor executor) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, asyncCallable, executor)) == null) ? new CombinedFuture(this.futures, this.allMustSucceed, executor, asyncCallable) : (ListenableFuture) invokeLL.objValue;
        }

        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.concurrent.Callable<java.lang.Void>, java.util.concurrent.Callable<C> */
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.google.common.util.concurrent.ListenableFuture<C>, com.google.common.util.concurrent.ListenableFuture<?> */
        public ListenableFuture<?> run(Runnable runnable, Executor executor) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, executor)) == null) ? call(new Callable<Void>(this, runnable) { // from class: com.google.common.util.concurrent.Futures.FutureCombiner.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FutureCombiner this$0;
                public final /* synthetic */ Runnable val$combiner;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, runnable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$combiner = runnable;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        this.val$combiner.run();
                        return null;
                    }
                    return (Void) invokeV.objValue;
                }
            }, executor) : (ListenableFuture) invokeLL.objValue;
        }

        public FutureCombiner(boolean z, ImmutableList<ListenableFuture<? extends V>> immutableList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), immutableList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.allMustSucceed = z;
            this.futures = immutableList;
        }
    }

    /* loaded from: classes11.dex */
    public static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public InCompletionOrderState<T> state;

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.state = null;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                InCompletionOrderState<T> inCompletionOrderState = this.state;
                if (super.cancel(z)) {
                    inCompletionOrderState.recordOutputCancellation(z);
                    return true;
                }
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                InCompletionOrderState<T> inCompletionOrderState = this.state;
                if (inCompletionOrderState != null) {
                    return "inputCount=[" + inCompletionOrderState.inputFutures.length + "], remaining=[" + inCompletionOrderState.incompleteOutputCount.get() + PreferencesUtil.RIGHT_MOUNT;
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        public InCompletionOrderFuture(InCompletionOrderState<T> inCompletionOrderState) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inCompletionOrderState};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.state = inCompletionOrderState;
        }
    }

    /* loaded from: classes11.dex */
    public static final class InCompletionOrderState<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int delegateIndex;
        public final AtomicInteger incompleteOutputCount;
        public final ListenableFuture<? extends T>[] inputFutures;
        public boolean shouldInterrupt;
        public boolean wasCancelled;

        private void recordCompletion() {
            ListenableFuture<? extends T>[] listenableFutureArr;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) && this.incompleteOutputCount.decrementAndGet() == 0 && this.wasCancelled) {
                for (ListenableFuture<? extends T> listenableFuture : this.inputFutures) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.shouldInterrupt);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recordInputCompletion(ImmutableList<AbstractFuture<T>> immutableList, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65543, this, immutableList, i2) == null) {
                ListenableFuture<? extends T>[] listenableFutureArr = this.inputFutures;
                ListenableFuture<? extends T> listenableFuture = listenableFutureArr[i2];
                listenableFutureArr[i2] = null;
                for (int i3 = this.delegateIndex; i3 < immutableList.size(); i3++) {
                    if (immutableList.get(i3).setFuture(listenableFuture)) {
                        recordCompletion();
                        this.delegateIndex = i3 + 1;
                        return;
                    }
                }
                this.delegateIndex = immutableList.size();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recordOutputCancellation(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
                this.wasCancelled = true;
                if (!z) {
                    this.shouldInterrupt = false;
                }
                recordCompletion();
            }
        }

        public InCompletionOrderState(ListenableFuture<? extends T>[] listenableFutureArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listenableFutureArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.wasCancelled = false;
            this.shouldInterrupt = true;
            this.delegateIndex = 0;
            this.inputFutures = listenableFutureArr;
            this.incompleteOutputCount = new AtomicInteger(listenableFutureArr.length);
        }
    }

    /* loaded from: classes11.dex */
    public static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ListenableFuture<V> delegate;

        public NonCancellationPropagatingFuture(ListenableFuture<V> listenableFuture) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listenableFuture};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delegate = listenableFuture;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.delegate = null;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ListenableFuture<V> listenableFuture = this.delegate;
                if (listenableFuture != null) {
                    return "delegate=[" + listenableFuture + PreferencesUtil.RIGHT_MOUNT;
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<V> listenableFuture;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (listenableFuture = this.delegate) == null) {
                return;
            }
            setFuture(listenableFuture);
        }
    }

    public Futures() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, listenableFuture, futureCallback, executor) == null) {
            n.p(futureCallback);
            listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
        }
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, listenableFutureArr)) == null) ? new CollectionFuture.ListFuture(ImmutableList.copyOf(listenableFutureArr), true) : (ListenableFuture) invokeL.objValue;
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> listenableFuture, Class<X> cls, g<? super X, ? extends V> gVar, Executor executor) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, listenableFuture, cls, gVar, executor)) == null) ? AbstractCatchingFuture.create(listenableFuture, cls, gVar, executor) : (ListenableFuture) invokeLLLL.objValue;
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, listenableFuture, cls, asyncFunction, executor)) == null) ? AbstractCatchingFuture.create(listenableFuture, cls, asyncFunction, executor) : (ListenableFuture) invokeLLLL.objValue;
    }

    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, future, cls)) == null) ? (V) FuturesGetChecked.getChecked(future, cls) : (V) invokeLL.objValue;
    }

    public static <V> V getDone(Future<V> future) throws ExecutionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, future)) == null) {
            n.A(future.isDone(), "Future was expected to be done: %s", future);
            return (V) Uninterruptibles.getUninterruptibly(future);
        }
        return (V) invokeL.objValue;
    }

    public static <V> V getUnchecked(Future<V> future) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, future)) == null) {
            n.p(future);
            try {
                return (V) Uninterruptibles.getUninterruptibly(future);
            } catch (ExecutionException e2) {
                wrapAndThrowUnchecked(e2.getCause());
                throw new AssertionError();
            }
        }
        return (V) invokeL.objValue;
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new ImmediateFuture.ImmediateCancelledFuture() : (ListenableFuture) invokeV.objValue;
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, th)) == null) {
            n.p(th);
            return new ImmediateFuture.ImmediateFailedFuture(th);
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public static <V> ListenableFuture<V> immediateFuture(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, v)) == null) {
            if (v == null) {
                return ImmediateFuture.ImmediateSuccessfulFuture.NULL;
            }
            return new ImmediateFuture.ImmediateSuccessfulFuture(v);
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        InterceptResult invokeL;
        Collection copyOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, iterable)) == null) {
            if (iterable instanceof Collection) {
                copyOf = (Collection) iterable;
            } else {
                copyOf = ImmutableList.copyOf(iterable);
            }
            ListenableFuture[] listenableFutureArr = (ListenableFuture[]) copyOf.toArray(new ListenableFuture[copyOf.size()]);
            InCompletionOrderState inCompletionOrderState = new InCompletionOrderState(listenableFutureArr);
            ImmutableList.a builder = ImmutableList.builder();
            for (int i2 = 0; i2 < listenableFutureArr.length; i2++) {
                builder.h(new InCompletionOrderFuture(inCompletionOrderState));
            }
            ImmutableList<ListenableFuture<T>> j = builder.j();
            for (int i3 = 0; i3 < listenableFutureArr.length; i3++) {
                listenableFutureArr[i3].addListener(new Runnable(inCompletionOrderState, j, i3) { // from class: com.google.common.util.concurrent.Futures.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ImmutableList val$delegates;
                    public final /* synthetic */ int val$localI;
                    public final /* synthetic */ InCompletionOrderState val$state;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {inCompletionOrderState, j, Integer.valueOf(i3)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$state = inCompletionOrderState;
                        this.val$delegates = j;
                        this.val$localI = i3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$state.recordInputCompletion(this.val$delegates, this.val$localI);
                        }
                    }
                }, MoreExecutors.directExecutor());
            }
            return j;
        }
        return (ImmutableList) invokeL.objValue;
    }

    public static <I, O> Future<O> lazyTransform(Future<I> future, g<? super I, ? extends O> gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, future, gVar)) == null) {
            n.p(future);
            n.p(gVar);
            return new Future<O>(future, gVar) { // from class: com.google.common.util.concurrent.Futures.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g val$function;
                public final /* synthetic */ Future val$input;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {future, gVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$input = future;
                    this.val$function = gVar;
                }

                /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, O] */
                /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, O] */
                private O applyTransformation(I i2) throws ExecutionException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, i2)) == null) {
                        try {
                            return this.val$function.apply(i2);
                        } catch (Throwable th) {
                            throw new ExecutionException(th);
                        }
                    }
                    return invokeL.objValue;
                }

                @Override // java.util.concurrent.Future
                public boolean cancel(boolean z) {
                    InterceptResult invokeZ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeZ = interceptable2.invokeZ(1048576, this, z)) == null) ? this.val$input.cancel(z) : invokeZ.booleanValue;
                }

                /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, O] */
                /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, O] */
                @Override // java.util.concurrent.Future
                public O get() throws InterruptedException, ExecutionException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? applyTransformation(this.val$input.get()) : invokeV.objValue;
                }

                @Override // java.util.concurrent.Future
                public boolean isCancelled() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.val$input.isCancelled() : invokeV.booleanValue;
                }

                @Override // java.util.concurrent.Future
                public boolean isDone() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) ? this.val$input.isDone() : invokeV.booleanValue;
                }

                /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, O] */
                /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, O] */
                @Override // java.util.concurrent.Future
                public O get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                    InterceptResult invokeJL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeJL = interceptable2.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, timeUnit)) == null) ? applyTransformation(this.val$input.get(j, timeUnit)) : invokeJL.objValue;
                }
            };
        }
        return (Future) invokeLL.objValue;
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, listenableFuture)) == null) {
            if (listenableFuture.isDone()) {
                return listenableFuture;
            }
            NonCancellationPropagatingFuture nonCancellationPropagatingFuture = new NonCancellationPropagatingFuture(listenableFuture);
            listenableFuture.addListener(nonCancellationPropagatingFuture, MoreExecutors.directExecutor());
            return nonCancellationPropagatingFuture;
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> asyncCallable, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{asyncCallable, Long.valueOf(j), timeUnit, scheduledExecutorService})) == null) {
            TrustedListenableFutureTask create = TrustedListenableFutureTask.create(asyncCallable);
            create.addListener(new Runnable(scheduledExecutorService.schedule(create, j, timeUnit)) { // from class: com.google.common.util.concurrent.Futures.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Future val$scheduled;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$scheduled = r6;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$scheduled.cancel(false);
                    }
                }
            }, MoreExecutors.directExecutor());
            return create;
        }
        return (ListenableFuture) invokeCommon.objValue;
    }

    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> asyncCallable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, asyncCallable, executor)) == null) {
            TrustedListenableFutureTask create = TrustedListenableFutureTask.create(asyncCallable);
            executor.execute(create);
            return create;
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, listenableFutureArr)) == null) ? new CollectionFuture.ListFuture(ImmutableList.copyOf(listenableFutureArr), false) : (ListenableFuture) invokeL.objValue;
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, g<? super I, ? extends O> gVar, Executor executor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, listenableFuture, gVar, executor)) == null) ? AbstractTransformFuture.create(listenableFuture, gVar, executor) : (ListenableFuture) invokeLLL.objValue;
    }

    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, null, listenableFuture, asyncFunction, executor)) == null) ? AbstractTransformFuture.create(listenableFuture, asyncFunction, executor) : (ListenableFuture) invokeLLL.objValue;
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... listenableFutureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, listenableFutureArr)) == null) ? new FutureCombiner<>(false, ImmutableList.copyOf(listenableFutureArr)) : (FutureCombiner) invokeL.objValue;
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... listenableFutureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, listenableFutureArr)) == null) ? new FutureCombiner<>(true, ImmutableList.copyOf(listenableFutureArr)) : (FutureCombiner) invokeL.objValue;
    }

    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65562, null, new Object[]{listenableFuture, Long.valueOf(j), timeUnit, scheduledExecutorService})) == null) ? listenableFuture.isDone() ? listenableFuture : TimeoutFuture.create(listenableFuture, j, timeUnit, scheduledExecutorService) : (ListenableFuture) invokeCommon.objValue;
    }

    public static void wrapAndThrowUnchecked(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, th) == null) {
            if (th instanceof Error) {
                throw new ExecutionError((Error) th);
            }
            throw new UncheckedExecutionException(th);
        }
    }

    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iterable)) == null) ? new CollectionFuture.ListFuture(ImmutableList.copyOf(iterable), true) : (ListenableFuture) invokeL.objValue;
    }

    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j, TimeUnit timeUnit) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{future, cls, Long.valueOf(j), timeUnit})) == null) ? (V) FuturesGetChecked.getChecked(future, cls, j, timeUnit) : (V) invokeCommon.objValue;
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, iterable)) == null) ? new CollectionFuture.ListFuture(ImmutableList.copyOf(iterable), false) : (ListenableFuture) invokeL.objValue;
    }

    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, iterable)) == null) ? new FutureCombiner<>(false, ImmutableList.copyOf(iterable)) : (FutureCombiner) invokeL.objValue;
    }

    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, iterable)) == null) ? new FutureCombiner<>(true, ImmutableList.copyOf(iterable)) : (FutureCombiner) invokeL.objValue;
    }
}
