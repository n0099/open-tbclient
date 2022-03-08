package com.google.common.util.concurrent;

import c.i.c.a.n;
import c.i.c.c.o1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes7.dex */
public abstract class AggregateFuture<InputT, OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger logger;
    public transient /* synthetic */ FieldHolder $fh;
    public AggregateFuture<InputT, OutputT>.RunningState runningState;

    /* loaded from: classes7.dex */
    public abstract class RunningState extends AggregateFutureState implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean allMustSucceed;
        public final boolean collectsValues;
        public ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;
        public final /* synthetic */ AggregateFuture this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RunningState(AggregateFuture aggregateFuture, ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z, boolean z2) {
            super(immutableCollection.size());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aggregateFuture, immutableCollection, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = aggregateFuture;
            n.p(immutableCollection);
            this.futures = immutableCollection;
            this.allMustSucceed = z;
            this.collectsValues = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decrementCountAndMaybeComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                int decrementRemainingAndGet = decrementRemainingAndGet();
                n.x(decrementRemainingAndGet >= 0, "Less than 0 remaining futures");
                if (decrementRemainingAndGet == 0) {
                    processCompleted();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void handleException(Throwable th) {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(65542, this, th) != null) {
                return;
            }
            n.p(th);
            if (this.allMustSucceed) {
                z = this.this$0.setException(th);
                if (!z) {
                    z2 = AggregateFuture.addCausalChain(getOrInitSeenExceptions(), th);
                    z3 = th instanceof Error;
                    if (!((!z) & this.allMustSucceed & z2) && !z3) {
                        AggregateFuture.logger.log(Level.SEVERE, z3 ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
                        return;
                    }
                    return;
                }
                releaseResourcesAfterFailure();
            } else {
                z = false;
            }
            z2 = true;
            z3 = th instanceof Error;
            if (!(((!z) & this.allMustSucceed & z2) | z3)) {
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.util.concurrent.AggregateFuture$RunningState */
        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleOneInputDone(int i2, Future<? extends InputT> future) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65543, this, i2, future) == null) {
                n.x(this.allMustSucceed || !this.this$0.isDone() || this.this$0.isCancelled(), "Future was done before all dependencies completed");
                try {
                    n.x(future.isDone(), "Tried to set value from future which is not done");
                    if (this.allMustSucceed) {
                        if (future.isCancelled()) {
                            this.this$0.runningState = null;
                            this.this$0.cancel(false);
                        } else {
                            Object done = Futures.getDone(future);
                            if (this.collectsValues) {
                                collectOneValue(this.allMustSucceed, i2, done);
                            }
                        }
                    } else if (this.collectsValues && !future.isCancelled()) {
                        collectOneValue(this.allMustSucceed, i2, Futures.getDone(future));
                    }
                } catch (ExecutionException e2) {
                    handleException(e2.getCause());
                } catch (Throwable th) {
                    handleException(th);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void init() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65544, this) == null) {
                if (this.futures.isEmpty()) {
                    handleAllCompleted();
                } else if (this.allMustSucceed) {
                    int i2 = 0;
                    o1<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                    while (it.hasNext()) {
                        ListenableFuture<? extends InputT> next = it.next();
                        next.addListener(new Runnable(this, i2, next) { // from class: com.google.common.util.concurrent.AggregateFuture.RunningState.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ RunningState this$1;
                            public final /* synthetic */ int val$index;
                            public final /* synthetic */ ListenableFuture val$listenable;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2), next};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$index = i2;
                                this.val$listenable = next;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        this.this$1.handleOneInputDone(this.val$index, this.val$listenable);
                                    } finally {
                                        this.this$1.decrementCountAndMaybeComplete();
                                    }
                                }
                            }
                        }, MoreExecutors.directExecutor());
                        i2++;
                    }
                } else {
                    o1<? extends ListenableFuture<? extends InputT>> it2 = this.futures.iterator();
                    while (it2.hasNext()) {
                        it2.next().addListener(this, MoreExecutors.directExecutor());
                    }
                }
            }
        }

        private void processCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, this) == null) {
                if (this.collectsValues & (!this.allMustSucceed)) {
                    int i2 = 0;
                    o1<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                    while (it.hasNext()) {
                        handleOneInputDone(i2, it.next());
                        i2++;
                    }
                }
                handleAllCompleted();
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState
        public final void addInitialException(Set<Throwable> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || this.this$0.isCancelled()) {
                return;
            }
            AggregateFuture.addCausalChain(set, this.this$0.tryInternalFastPathGetFailure());
        }

        public abstract void collectOneValue(boolean z, int i2, InputT inputt);

        public abstract void handleAllCompleted();

        public void interruptTask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public void releaseResourcesAfterFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.futures = null;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                decrementCountAndMaybeComplete();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1576365460, "Lcom/google/common/util/concurrent/AggregateFuture;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1576365460, "Lcom/google/common/util/concurrent/AggregateFuture;");
                return;
            }
        }
        logger = Logger.getLogger(AggregateFuture.class.getName());
    }

    public AggregateFuture() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean addCausalChain(Set<Throwable> set, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, set, th)) == null) {
            while (th != null) {
                if (!set.add(th)) {
                    return false;
                }
                th = th.getCause();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.afterDone();
            releaseResources();
        }
    }

    public final void init(AggregateFuture<InputT, OutputT>.RunningState runningState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runningState) == null) {
            this.runningState = runningState;
            runningState.init();
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        InterceptResult invokeV;
        ImmutableCollection immutableCollection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AggregateFuture<InputT, OutputT>.RunningState runningState = this.runningState;
            if (runningState == null || (immutableCollection = runningState.futures) == null) {
                return null;
            }
            return "futures=[" + immutableCollection + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public final void releaseResources() {
        AggregateFuture<InputT, OutputT>.RunningState runningState;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (runningState = this.runningState) == null) {
            return;
        }
        this.runningState = null;
        ImmutableCollection immutableCollection = runningState.futures;
        boolean wasInterrupted = wasInterrupted();
        if (wasInterrupted) {
            runningState.interruptTask();
        }
        if (isCancelled() && (immutableCollection != null)) {
            o1 it = immutableCollection.iterator();
            while (it.hasNext()) {
                ((ListenableFuture) it.next()).cancel(wasInterrupted);
            }
        }
    }
}
