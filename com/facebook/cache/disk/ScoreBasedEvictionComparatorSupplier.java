package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.internal.VisibleForTesting;
/* loaded from: classes5.dex */
public class ScoreBasedEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    public final float mAgeWeight;
    public final float mSizeWeight;

    public ScoreBasedEvictionComparatorSupplier(float f2, float f3) {
        this.mAgeWeight = f2;
        this.mSizeWeight = f3;
    }

    @VisibleForTesting
    public float calculateScore(DiskStorage.Entry entry, long j) {
        return (this.mAgeWeight * ((float) (j - entry.getTimestamp()))) + (this.mSizeWeight * ((float) entry.getSize()));
    }

    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public EntryEvictionComparator get() {
        return new EntryEvictionComparator() { // from class: com.facebook.cache.disk.ScoreBasedEvictionComparatorSupplier.1
            public long now = System.currentTimeMillis();

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
                float calculateScore = ScoreBasedEvictionComparatorSupplier.this.calculateScore(entry, this.now);
                float calculateScore2 = ScoreBasedEvictionComparatorSupplier.this.calculateScore(entry2, this.now);
                if (calculateScore < calculateScore2) {
                    return 1;
                }
                return calculateScore2 == calculateScore ? 0 : -1;
            }
        };
    }
}
