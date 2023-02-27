package com.facebook.imagepipeline.producers;

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
    public static final String TAG = "PriorityNetworkFetcher";
    public final MonotonicClock mClock;
    public final HashSet<PriorityFetchState<FETCH_STATE>> mCurrentlyFetching;
    public final NetworkFetcher<FETCH_STATE> mDelegate;
    public final LinkedList<PriorityFetchState<FETCH_STATE>> mHiPriQueue;
    public final boolean mIsHiPriFifo;
    public final Object mLock;
    public final LinkedList<PriorityFetchState<FETCH_STATE>> mLowPriQueue;
    public final int mMaxOutstandingHiPri;
    public final int mMaxOutstandingLowPri;

    /* loaded from: classes7.dex */
    public static class PriorityFetchState<FETCH_STATE extends FetchState> extends FetchState {
        public NetworkFetcher.Callback callback;
        public final FETCH_STATE delegatedState;
        public long dequeuedTimestamp;
        public final long enqueuedTimestamp;
        public final int hiPriCountWhenCreated;
        public final int lowPriCountWhenCreated;

        public PriorityFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext, FETCH_STATE fetch_state, long j, int i, int i2) {
            super(consumer, producerContext);
            this.delegatedState = fetch_state;
            this.enqueuedTimestamp = j;
            this.hiPriCountWhenCreated = i;
            this.lowPriCountWhenCreated = i2;
        }
    }

    public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> networkFetcher, boolean z, int i, int i2) {
        this(networkFetcher, z, i, i2, RealtimeSinceBootClock.get());
    }

    @VisibleForTesting
    public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> networkFetcher, boolean z, int i, int i2, MonotonicClock monotonicClock) {
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

    private void putInQueue(PriorityFetchState<FETCH_STATE> priorityFetchState, boolean z) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromQueue(PriorityFetchState<FETCH_STATE> priorityFetchState, String str) {
        synchronized (this.mLock) {
            FLog.v(TAG, "remove: %s %s", str, priorityFetchState.getUri());
            this.mCurrentlyFetching.remove(priorityFetchState);
            if (!this.mHiPriQueue.remove(priorityFetchState)) {
                this.mLowPriQueue.remove(priorityFetchState);
            }
        }
        dequeueIfAvailableSlots();
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

    private void delegateFetch(final PriorityFetchState<FETCH_STATE> priorityFetchState) {
        try {
            this.mDelegate.fetch(priorityFetchState.delegatedState, new NetworkFetcher.Callback() { // from class: com.facebook.imagepipeline.producers.PriorityNetworkFetcher.2
                @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
                public void onResponse(InputStream inputStream, int i) throws IOException {
                    priorityFetchState.callback.onResponse(inputStream, i);
                }

                @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
                public void onCancellation() {
                    PriorityNetworkFetcher.this.removeFromQueue(priorityFetchState, "CANCEL");
                    priorityFetchState.callback.onCancellation();
                }

                @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
                public void onFailure(Throwable th) {
                    PriorityNetworkFetcher.this.removeFromQueue(priorityFetchState, "FAIL");
                    priorityFetchState.callback.onFailure(th);
                }
            });
        } catch (Exception unused) {
            removeFromQueue(priorityFetchState, "FAIL");
        }
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ boolean shouldPropagate(FetchState fetchState) {
        return shouldPropagate((PriorityFetchState) ((PriorityFetchState) fetchState));
    }

    private void dequeueIfAvailableSlots() {
        PriorityFetchState<FETCH_STATE> priorityFetchState;
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

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public PriorityFetchState<FETCH_STATE> createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new PriorityFetchState<>(consumer, producerContext, this.mDelegate.createFetchState(consumer, producerContext), this.mClock.now(), this.mHiPriQueue.size(), this.mLowPriQueue.size());
    }

    public void onFetchCompletion(PriorityFetchState<FETCH_STATE> priorityFetchState, int i) {
        removeFromQueue(priorityFetchState, "SUCCESS");
        this.mDelegate.onFetchCompletion(priorityFetchState.delegatedState, i);
    }

    public void fetch(final PriorityFetchState<FETCH_STATE> priorityFetchState, final NetworkFetcher.Callback callback) {
        boolean z;
        String str;
        priorityFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PriorityNetworkFetcher.1
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                PriorityNetworkFetcher.this.removeFromQueue(priorityFetchState, "CANCEL");
                callback.onCancellation();
            }

            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onPriorityChanged() {
                boolean z2;
                PriorityNetworkFetcher priorityNetworkFetcher = PriorityNetworkFetcher.this;
                PriorityFetchState priorityFetchState2 = priorityFetchState;
                if (priorityFetchState2.getContext().getPriority() == Priority.HIGH) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                priorityNetworkFetcher.changePriority(priorityFetchState2, z2);
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

    @Nullable
    public Map<String, String> getExtraMap(PriorityFetchState<FETCH_STATE> priorityFetchState, int i) {
        HashMap hashMap;
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

    @VisibleForTesting
    public HashSet<PriorityFetchState<FETCH_STATE>> getCurrentlyFetching() {
        return this.mCurrentlyFetching;
    }

    @VisibleForTesting
    public List<PriorityFetchState<FETCH_STATE>> getHiPriQueue() {
        return this.mHiPriQueue;
    }

    @VisibleForTesting
    public List<PriorityFetchState<FETCH_STATE>> getLowPriQueue() {
        return this.mLowPriQueue;
    }

    public boolean shouldPropagate(PriorityFetchState<FETCH_STATE> priorityFetchState) {
        return this.mDelegate.shouldPropagate(priorityFetchState.delegatedState);
    }
}
