package org.chromium.base.metrics;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.Log;
/* loaded from: classes2.dex */
public final class CachingUmaRecorder implements UmaRecorder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_HISTOGRAM_COUNT = 256;
    @VisibleForTesting
    public static final int MAX_USER_ACTION_COUNT = 256;
    public static final String TAG = "CachingUmaRecorder";
    @Nullable
    @GuardedBy("mRwLock")
    public UmaRecorder mDelegate;
    @GuardedBy("mRwLock")
    public int mDroppedUserActionCount;
    public final ReentrantReadWriteLock mRwLock = new ReentrantReadWriteLock(false);
    @GuardedBy("mRwLock")
    public Map<String, Histogram> mHistogramByName = new HashMap();
    public AtomicInteger mDroppedHistogramSampleCount = new AtomicInteger();
    @GuardedBy("mRwLock")
    public List<UserAction> mUserActions = new ArrayList();

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static class Histogram {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        @VisibleForTesting
        public static final int MAX_SAMPLE_COUNT = 256;
        public final int mMax;
        public final int mMin;
        public final String mName;
        public final int mNumBuckets;
        @GuardedBy("this")
        public final List<Integer> mSamples = new ArrayList(1);
        public final int mType;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface Type {
            public static final int BOOLEAN = 1;
            public static final int EXPONENTIAL = 2;
            public static final int LINEAR = 3;
            public static final int SPARSE = 4;
        }

        public Histogram(int i, String str, int i2, int i3, int i4) {
            this.mType = i;
            this.mName = str;
            this.mMin = i2;
            this.mMax = i3;
            this.mNumBuckets = i4;
        }

        public synchronized boolean addSample(int i, String str, int i2, int i3, int i4, int i5) {
            if (this.mSamples.size() >= 256) {
                return false;
            }
            this.mSamples.add(Integer.valueOf(i2));
            return true;
        }

        public synchronized int flushTo(UmaRecorder umaRecorder) {
            boolean z;
            int size;
            int i = this.mType;
            int i2 = 0;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            while (i2 < this.mSamples.size()) {
                                umaRecorder.recordSparseHistogram(this.mName, this.mSamples.get(i2).intValue());
                                i2++;
                            }
                        }
                    } else {
                        while (i2 < this.mSamples.size()) {
                            umaRecorder.recordLinearHistogram(this.mName, this.mSamples.get(i2).intValue(), this.mMin, this.mMax, this.mNumBuckets);
                            i2++;
                        }
                    }
                } else {
                    while (i2 < this.mSamples.size()) {
                        umaRecorder.recordExponentialHistogram(this.mName, this.mSamples.get(i2).intValue(), this.mMin, this.mMax, this.mNumBuckets);
                        i2++;
                    }
                }
            } else {
                for (int i3 = 0; i3 < this.mSamples.size(); i3++) {
                    int intValue = this.mSamples.get(i3).intValue();
                    String str = this.mName;
                    if (intValue != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    umaRecorder.recordBooleanHistogram(str, z);
                }
            }
            size = this.mSamples.size();
            this.mSamples.clear();
            return size;
        }
    }

    /* loaded from: classes2.dex */
    public static class UserAction {
        public final long mElapsedRealtimeMillis;
        public final String mName;

        public UserAction(String str, long j) {
            this.mName = str;
            this.mElapsedRealtimeMillis = j;
        }

        public void flushTo(UmaRecorder umaRecorder) {
            umaRecorder.recordUserAction(this.mName, this.mElapsedRealtimeMillis);
        }
    }

    @GuardedBy("mRwLock")
    private void cacheHistogramSampleAlreadyWriteLocked(int i, String str, int i2, int i3, int i4, int i5) {
        Histogram histogram = this.mHistogramByName.get(str);
        if (histogram == null) {
            if (this.mHistogramByName.size() >= 256) {
                this.mDroppedHistogramSampleCount.incrementAndGet();
                return;
            }
            Histogram histogram2 = new Histogram(i, str, i3, i4, i5);
            this.mHistogramByName.put(str, histogram2);
            histogram = histogram2;
        }
        if (!histogram.addSample(i, str, i2, i3, i4, i5)) {
            this.mDroppedHistogramSampleCount.incrementAndGet();
        }
    }

    private void cacheOrRecordHistogramSample(int i, String str, int i2, int i3, int i4, int i5) {
        if (tryAppendOrRecordSample(i, str, i2, i3, i4, i5)) {
            return;
        }
        this.mRwLock.writeLock().lock();
        try {
            if (this.mDelegate == null) {
                cacheHistogramSampleAlreadyWriteLocked(i, str, i2, i3, i4, i5);
                return;
            }
            this.mRwLock.readLock().lock();
            try {
                recordHistogramSampleAlreadyLocked(i, str, i2, i3, i4, i5);
            } finally {
                this.mRwLock.readLock().unlock();
            }
        } finally {
            this.mRwLock.writeLock().unlock();
        }
    }

    @GuardedBy("mRwLock")
    private void recordHistogramSampleAlreadyLocked(int i, String str, int i2, int i3, int i4, int i5) {
        boolean z = true;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.mDelegate.recordSparseHistogram(str, i2);
                        return;
                    }
                    throw new UnsupportedOperationException("Unknown histogram type " + i);
                }
                this.mDelegate.recordLinearHistogram(str, i2, i3, i4, i5);
                return;
            }
            this.mDelegate.recordExponentialHistogram(str, i2, i3, i4, i5);
            return;
        }
        UmaRecorder umaRecorder = this.mDelegate;
        if (i2 == 0) {
            z = false;
        }
        umaRecorder.recordBooleanHistogram(str, z);
    }

    private boolean tryAppendOrRecordSample(int i, String str, int i2, int i3, int i4, int i5) {
        this.mRwLock.readLock().lock();
        try {
            if (this.mDelegate != null) {
                recordHistogramSampleAlreadyLocked(i, str, i2, i3, i4, i5);
            } else {
                Histogram histogram = this.mHistogramByName.get(str);
                if (histogram == null) {
                    return false;
                } else if (!histogram.addSample(i, str, i2, i3, i4, i5)) {
                    this.mDroppedHistogramSampleCount.incrementAndGet();
                }
            }
            return true;
        } finally {
            this.mRwLock.readLock().unlock();
        }
    }

    @GuardedBy("mRwLock")
    private void flushHistogramsAlreadyLocked(Map<String, Histogram> map, int i) {
        int size = map.size();
        int i2 = 0;
        for (Histogram histogram : map.values()) {
            i2 += histogram.flushTo(this.mDelegate);
        }
        Log.i(TAG, "Flushed %d samples from %d histograms.", Integer.valueOf(i2), Integer.valueOf(size));
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.DroppedHistogramSampleCount", i, 1, 1000000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.FlushedHistogramCount", size, 1, DefaultOggSeeker.MATCH_BYTE_RANGE, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.InputHistogramSampleCount", i2 + i, 1, 1000000, 50);
    }

    private void flushUserActionsAlreadyLocked(List<UserAction> list, int i) {
        for (UserAction userAction : list) {
            userAction.flushTo(this.mDelegate);
        }
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.DroppedUserActionCount", i, 1, 1000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.InputUserActionCount", list.size() + i, 1, 10000, 50);
    }

    @Override // org.chromium.base.metrics.UmaRecorder
    public void recordBooleanHistogram(String str, boolean z) {
        cacheOrRecordHistogramSample(1, str, z ? 1 : 0, 0, 0, 0);
    }

    @Override // org.chromium.base.metrics.UmaRecorder
    public void recordSparseHistogram(String str, int i) {
        cacheOrRecordHistogramSample(4, str, i, 0, 0, 0);
    }

    @Override // org.chromium.base.metrics.UmaRecorder
    public void recordExponentialHistogram(String str, int i, int i2, int i3, int i4) {
        cacheOrRecordHistogramSample(2, str, i, i2, i3, i4);
    }

    @Override // org.chromium.base.metrics.UmaRecorder
    public void recordLinearHistogram(String str, int i, int i2, int i3, int i4) {
        cacheOrRecordHistogramSample(3, str, i, i2, i3, i4);
    }

    @Override // org.chromium.base.metrics.UmaRecorder
    public void recordUserAction(String str, long j) {
        this.mRwLock.readLock().lock();
        try {
            if (this.mDelegate != null) {
                this.mDelegate.recordUserAction(str, j);
                return;
            }
            this.mRwLock.readLock().unlock();
            this.mRwLock.writeLock().lock();
            try {
                if (this.mDelegate == null) {
                    if (this.mUserActions.size() < 256) {
                        this.mUserActions.add(new UserAction(str, j));
                    } else {
                        this.mDroppedUserActionCount++;
                    }
                    return;
                }
                this.mRwLock.readLock().lock();
                try {
                    this.mDelegate.recordUserAction(str, j);
                } finally {
                }
            } finally {
                this.mRwLock.writeLock().unlock();
            }
        } finally {
        }
    }

    public UmaRecorder setDelegate(@Nullable UmaRecorder umaRecorder) {
        Map<String, Histogram> map;
        int i;
        this.mRwLock.writeLock().lock();
        try {
            UmaRecorder umaRecorder2 = this.mDelegate;
            this.mDelegate = umaRecorder;
            if (umaRecorder == null) {
                return umaRecorder2;
            }
            List<UserAction> list = null;
            int i2 = 0;
            if (!this.mHistogramByName.isEmpty()) {
                map = this.mHistogramByName;
                this.mHistogramByName = new HashMap();
                i = this.mDroppedHistogramSampleCount.getAndSet(0);
            } else {
                map = null;
                i = 0;
            }
            if (!this.mUserActions.isEmpty()) {
                list = this.mUserActions;
                this.mUserActions = new ArrayList();
                int i3 = this.mDroppedUserActionCount;
                this.mDroppedUserActionCount = 0;
                i2 = i3;
            }
            this.mRwLock.readLock().lock();
            if (map != null) {
                try {
                    flushHistogramsAlreadyLocked(map, i);
                } catch (Throwable th) {
                    this.mRwLock.readLock().unlock();
                    throw th;
                }
            }
            if (list != null) {
                flushUserActionsAlreadyLocked(list, i2);
            }
            this.mRwLock.readLock().unlock();
            return umaRecorder2;
        } finally {
            this.mRwLock.writeLock().unlock();
        }
    }
}
