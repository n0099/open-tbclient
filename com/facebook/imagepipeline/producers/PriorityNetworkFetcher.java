package com.facebook.imagepipeline.producers;

import androidx.core.view.InputDeviceCompat;
import com.alipay.security.mobile.module.http.model.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class PriorityNetworkFetcher<FETCH_STATE extends FetchState> implements NetworkFetcher<PriorityFetchState<FETCH_STATE>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PriorityNetworkFetcher";
    public transient /* synthetic */ FieldHolder $fh;
    public final MonotonicClock mClock;
    public final HashSet<PriorityFetchState<FETCH_STATE>> mCurrentlyFetching;
    public final NetworkFetcher<FETCH_STATE> mDelegate;
    public final LinkedList<PriorityFetchState<FETCH_STATE>> mHiPriQueue;
    public final boolean mIsHiPriFifo;
    public final Object mLock;
    public final LinkedList<PriorityFetchState<FETCH_STATE>> mLowPriQueue;
    public final int mMaxOutstandingHiPri;
    public final int mMaxOutstandingLowPri;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1550824047, "Lcom/facebook/imagepipeline/producers/PriorityNetworkFetcher;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1550824047, "Lcom/facebook/imagepipeline/producers/PriorityNetworkFetcher;");
        }
    }

    /* loaded from: classes7.dex */
    public static class PriorityFetchState<FETCH_STATE extends FetchState> extends FetchState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetworkFetcher.Callback callback;
        public final FETCH_STATE delegatedState;
        public long dequeuedTimestamp;
        public final long enqueuedTimestamp;
        public final int hiPriCountWhenCreated;
        public final int lowPriCountWhenCreated;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PriorityFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext, FETCH_STATE fetch_state, long j, int i, int i2) {
            super(consumer, producerContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer, producerContext, fetch_state, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Consumer) objArr2[0], (ProducerContext) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delegatedState = fetch_state;
            this.enqueuedTimestamp = j;
            this.hiPriCountWhenCreated = i;
            this.lowPriCountWhenCreated = i2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> networkFetcher, boolean z, int i, int i2) {
        this(networkFetcher, z, i, i2, RealtimeSinceBootClock.get());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {networkFetcher, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((NetworkFetcher) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (MonotonicClock) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @VisibleForTesting
    public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> networkFetcher, boolean z, int i, int i2, MonotonicClock monotonicClock) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {networkFetcher, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), monotonicClock};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mHiPriQueue = new LinkedList<>();
        this.mLowPriQueue = new LinkedList<>();
        this.mCurrentlyFetching = new HashSet<>();
        this.mDelegate = networkFetcher;
        this.mIsHiPriFifo = z;
        this.mMaxOutstandingHiPri = i;
        this.mMaxOutstandingLowPri = i2;
        if (i > i2) {
            this.mClock = monotonicClock;
            return;
        }
        throw new IllegalArgumentException("maxOutstandingHiPri should be > maxOutstandingLowPri");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changePriority(PriorityFetchState<FETCH_STATE> priorityFetchState, boolean z) {
        LinkedList<PriorityFetchState<FETCH_STATE>> linkedList;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, this, priorityFetchState, z) == null) {
            synchronized (this.mLock) {
                if (z) {
                    linkedList = this.mLowPriQueue;
                } else {
                    linkedList = this.mHiPriQueue;
                }
                if (!linkedList.remove(priorityFetchState)) {
                    return;
                }
                String str2 = TAG;
                if (z) {
                    str = "HIPRI";
                } else {
                    str = "LOWPRI";
                }
                FLog.v(str2, "change-pri: %s %s", str, priorityFetchState.getUri());
                putInQueue(priorityFetchState, z);
                dequeueIfAvailableSlots();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromQueue(PriorityFetchState<FETCH_STATE> priorityFetchState, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, priorityFetchState, str) == null) {
            synchronized (this.mLock) {
                FLog.v(TAG, "remove: %s %s", str, priorityFetchState.getUri());
                this.mCurrentlyFetching.remove(priorityFetchState);
                if (!this.mHiPriQueue.remove(priorityFetchState)) {
                    this.mLowPriQueue.remove(priorityFetchState);
                }
            }
            dequeueIfAvailableSlots();
        }
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public PriorityFetchState<FETCH_STATE> createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, consumer, producerContext)) == null) {
            return new PriorityFetchState<>(consumer, producerContext, this.mDelegate.createFetchState(consumer, producerContext), this.mClock.now(), this.mHiPriQueue.size(), this.mLowPriQueue.size());
        }
        return (PriorityFetchState) invokeLL.objValue;
    }

    private void delegateFetch(PriorityFetchState<FETCH_STATE> priorityFetchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, priorityFetchState) == null) {
            try {
                this.mDelegate.fetch(priorityFetchState.delegatedState, new NetworkFetcher.Callback(this, priorityFetchState) { // from class: com.facebook.imagepipeline.producers.PriorityNetworkFetcher.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PriorityNetworkFetcher this$0;
                    public final /* synthetic */ PriorityFetchState val$fetchState;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, priorityFetchState};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$fetchState = priorityFetchState;
                    }

                    @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
                    public void onCancellation() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.this$0.removeFromQueue(this.val$fetchState, "CANCEL");
                        this.val$fetchState.callback.onCancellation();
                    }

                    @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
                    public void onFailure(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                            this.this$0.removeFromQueue(this.val$fetchState, "FAIL");
                            this.val$fetchState.callback.onFailure(th);
                        }
                    }

                    @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
                    public void onResponse(InputStream inputStream, int i) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_SEND_USER_MSG, this, inputStream, i) == null) {
                            this.val$fetchState.callback.onResponse(inputStream, i);
                        }
                    }
                });
            } catch (Exception unused) {
                removeFromQueue(priorityFetchState, "FAIL");
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ boolean shouldPropagate(FetchState fetchState) {
        return shouldPropagate((PriorityFetchState) ((PriorityFetchState) fetchState));
    }

    private void dequeueIfAvailableSlots() {
        PriorityFetchState<FETCH_STATE> priorityFetchState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            synchronized (this.mLock) {
                int size = this.mCurrentlyFetching.size();
                if (size < this.mMaxOutstandingHiPri) {
                    priorityFetchState = this.mHiPriQueue.pollFirst();
                } else {
                    priorityFetchState = null;
                }
                if (priorityFetchState == null && size < this.mMaxOutstandingLowPri) {
                    priorityFetchState = this.mLowPriQueue.pollFirst();
                }
                if (priorityFetchState == null) {
                    return;
                }
                priorityFetchState.dequeuedTimestamp = this.mClock.now();
                this.mCurrentlyFetching.add(priorityFetchState);
                FLog.v(TAG, "fetching: %s (concurrent: %s hi-pri queue: %s low-pri queue: %s)", priorityFetchState.getUri(), Integer.valueOf(size), Integer.valueOf(this.mHiPriQueue.size()), Integer.valueOf(this.mLowPriQueue.size()));
                delegateFetch(priorityFetchState);
            }
        }
    }

    private void putInQueue(PriorityFetchState<FETCH_STATE> priorityFetchState, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, this, priorityFetchState, z) == null) {
            if (z) {
                if (this.mIsHiPriFifo) {
                    this.mHiPriQueue.addLast(priorityFetchState);
                    return;
                } else {
                    this.mHiPriQueue.addFirst(priorityFetchState);
                    return;
                }
            }
            this.mLowPriQueue.addLast(priorityFetchState);
        }
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ FetchState createFetchState(Consumer consumer, ProducerContext producerContext) {
        return createFetchState((Consumer<EncodedImage>) consumer, producerContext);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ void fetch(FetchState fetchState, NetworkFetcher.Callback callback) {
        fetch((PriorityFetchState) ((PriorityFetchState) fetchState), callback);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    @Nullable
    public /* bridge */ /* synthetic */ Map getExtraMap(FetchState fetchState, int i) {
        return getExtraMap((PriorityFetchState) ((PriorityFetchState) fetchState), i);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ void onFetchCompletion(FetchState fetchState, int i) {
        onFetchCompletion((PriorityFetchState) ((PriorityFetchState) fetchState), i);
    }

    public void fetch(PriorityFetchState<FETCH_STATE> priorityFetchState, NetworkFetcher.Callback callback) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, priorityFetchState, callback) == null) {
            priorityFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks(this, priorityFetchState, callback) { // from class: com.facebook.imagepipeline.producers.PriorityNetworkFetcher.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PriorityNetworkFetcher this$0;
                public final /* synthetic */ NetworkFetcher.Callback val$callback;
                public final /* synthetic */ PriorityFetchState val$fetchState;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, priorityFetchState, callback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fetchState = priorityFetchState;
                    this.val$callback = callback;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.removeFromQueue(this.val$fetchState, "CANCEL");
                    this.val$callback.onCancellation();
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onPriorityChanged() {
                    boolean z2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        PriorityNetworkFetcher priorityNetworkFetcher = this.this$0;
                        PriorityFetchState priorityFetchState2 = this.val$fetchState;
                        if (priorityFetchState2.getContext().getPriority() == Priority.HIGH) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        priorityNetworkFetcher.changePriority(priorityFetchState2, z2);
                    }
                }
            });
            synchronized (this.mLock) {
                if (this.mCurrentlyFetching.contains(priorityFetchState)) {
                    String str2 = TAG;
                    FLog.e(str2, "fetch state was enqueued twice: " + priorityFetchState);
                    return;
                }
                if (priorityFetchState.getContext().getPriority() == Priority.HIGH) {
                    z = true;
                } else {
                    z = false;
                }
                String str3 = TAG;
                if (z) {
                    str = "HI-PRI";
                } else {
                    str = "LOW-PRI";
                }
                FLog.v(str3, "enqueue: %s %s", str, priorityFetchState.getUri());
                priorityFetchState.callback = callback;
                putInQueue(priorityFetchState, z);
                dequeueIfAvailableSlots();
            }
        }
    }

    @Nullable
    public Map<String, String> getExtraMap(PriorityFetchState<FETCH_STATE> priorityFetchState, int i) {
        InterceptResult invokeLI;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, priorityFetchState, i)) == null) {
            Map<String, String> extraMap = this.mDelegate.getExtraMap(priorityFetchState.delegatedState, i);
            if (extraMap != null) {
                hashMap = new HashMap(extraMap);
            } else {
                hashMap = new HashMap();
            }
            hashMap.put("pri_queue_time", "" + (priorityFetchState.dequeuedTimestamp - priorityFetchState.enqueuedTimestamp));
            hashMap.put("hipri_queue_size", "" + priorityFetchState.hiPriCountWhenCreated);
            hashMap.put("lowpri_queue_size", "" + priorityFetchState.lowPriCountWhenCreated);
            return hashMap;
        }
        return (Map) invokeLI.objValue;
    }

    @VisibleForTesting
    public HashSet<PriorityFetchState<FETCH_STATE>> getCurrentlyFetching() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mCurrentlyFetching;
        }
        return (HashSet) invokeV.objValue;
    }

    @VisibleForTesting
    public List<PriorityFetchState<FETCH_STATE>> getHiPriQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mHiPriQueue;
        }
        return (List) invokeV.objValue;
    }

    @VisibleForTesting
    public List<PriorityFetchState<FETCH_STATE>> getLowPriQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mLowPriQueue;
        }
        return (List) invokeV.objValue;
    }

    public void onFetchCompletion(PriorityFetchState<FETCH_STATE> priorityFetchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, priorityFetchState, i) == null) {
            removeFromQueue(priorityFetchState, c.p);
            this.mDelegate.onFetchCompletion(priorityFetchState.delegatedState, i);
        }
    }

    public boolean shouldPropagate(PriorityFetchState<FETCH_STATE> priorityFetchState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, priorityFetchState)) == null) {
            return this.mDelegate.shouldPropagate(priorityFetchState.delegatedState);
        }
        return invokeL.booleanValue;
    }
}
