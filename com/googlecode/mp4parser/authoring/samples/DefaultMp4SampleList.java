package com.googlecode.mp4parser.authoring.samples;

import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.TrackBox;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.util.CastUtils;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.List;
/* loaded from: classes6.dex */
public class DefaultMp4SampleList extends AbstractList<Sample> {
    SoftReference<Sample>[] cache;
    int[] chunkNumsStartSampleNum;
    long[] chunkOffsets;
    int lastChunk = 0;
    SampleSizeBox ssb;
    Container topLevel;
    TrackBox trackBox;

    public DefaultMp4SampleList(long j, Container container) {
        int i;
        int i2;
        int i3;
        this.trackBox = null;
        this.cache = null;
        this.topLevel = container;
        for (TrackBox trackBox : ((MovieBox) container.getBoxes(MovieBox.class).get(0)).getBoxes(TrackBox.class)) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j) {
                this.trackBox = trackBox;
            }
        }
        if (this.trackBox == null) {
            throw new RuntimeException("This MP4 does not contain track " + j);
        }
        this.chunkOffsets = this.trackBox.getSampleTableBox().getChunkOffsetBox().getChunkOffsets();
        this.cache = (SoftReference[]) Array.newInstance(SoftReference.class, size());
        this.ssb = this.trackBox.getSampleTableBox().getSampleSizeBox();
        List<SampleToChunkBox.Entry> entries = this.trackBox.getSampleTableBox().getSampleToChunkBox().getEntries();
        SampleToChunkBox.Entry[] entryArr = (SampleToChunkBox.Entry[]) entries.toArray(new SampleToChunkBox.Entry[entries.size()]);
        int i4 = 1;
        SampleToChunkBox.Entry entry = entryArr[0];
        int i5 = 0;
        long firstChunk = entry.getFirstChunk();
        int l2i = CastUtils.l2i(entry.getSamplesPerChunk());
        int size = size();
        int i6 = 1;
        int i7 = 0;
        while (true) {
            i7++;
            if (i7 != firstChunk) {
                i = l2i;
                i2 = i4;
            } else if (entryArr.length > i4) {
                i2 = i4 + 1;
                SampleToChunkBox.Entry entry2 = entryArr[i4];
                i = CastUtils.l2i(entry2.getSamplesPerChunk());
                firstChunk = entry2.getFirstChunk();
                i5 = l2i;
            } else {
                i = -1;
                firstChunk = Long.MAX_VALUE;
                i5 = l2i;
                i2 = i4;
            }
            i6 += i5;
            if (i6 > size) {
                break;
            }
            l2i = i;
            i4 = i2;
        }
        this.chunkNumsStartSampleNum = new int[i7 + 1];
        SampleToChunkBox.Entry entry3 = entryArr[0];
        int i8 = 0;
        long firstChunk2 = entry3.getFirstChunk();
        int l2i2 = CastUtils.l2i(entry3.getSamplesPerChunk());
        int i9 = 1;
        int i10 = 0;
        int i11 = 1;
        while (true) {
            int i12 = i8 + 1;
            this.chunkNumsStartSampleNum[i8] = i9;
            if (i12 != firstChunk2) {
                i3 = l2i2;
            } else if (entryArr.length > i11) {
                SampleToChunkBox.Entry entry4 = entryArr[i11];
                i3 = CastUtils.l2i(entry4.getSamplesPerChunk());
                firstChunk2 = entry4.getFirstChunk();
                i10 = l2i2;
                i11++;
            } else {
                i3 = -1;
                firstChunk2 = Long.MAX_VALUE;
                i10 = l2i2;
            }
            i9 += i10;
            if (i9 > size) {
                this.chunkNumsStartSampleNum[i12] = Integer.MAX_VALUE;
                return;
            } else {
                l2i2 = i3;
                i8 = i12;
            }
        }
    }

    synchronized int getChunkForSample(int i) {
        int i2;
        int i3 = i + 1;
        if (i3 >= this.chunkNumsStartSampleNum[this.lastChunk] && i3 < this.chunkNumsStartSampleNum[this.lastChunk + 1]) {
            i2 = this.lastChunk;
        } else if (i3 < this.chunkNumsStartSampleNum[this.lastChunk]) {
            this.lastChunk = 0;
            while (this.chunkNumsStartSampleNum[this.lastChunk + 1] <= i3) {
                this.lastChunk++;
            }
            i2 = this.lastChunk;
        } else {
            this.lastChunk++;
            while (this.chunkNumsStartSampleNum[this.lastChunk + 1] <= i3) {
                this.lastChunk++;
            }
            i2 = this.lastChunk;
        }
        return i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i) {
        if (i >= this.cache.length) {
            throw new IndexOutOfBoundsException();
        }
        if (this.cache[i] != null && this.cache[i].get() != null) {
            return this.cache[i].get();
        }
        int chunkForSample = getChunkForSample(i);
        int i2 = this.chunkNumsStartSampleNum[chunkForSample];
        long j = this.chunkOffsets[CastUtils.l2i(chunkForSample)];
        while (i2 < i + 1) {
            j += this.ssb.getSampleSizeAtIndex(i2 - 1);
            i2++;
        }
        SampleImpl sampleImpl = new SampleImpl(j, this.ssb.getSampleSizeAtIndex(i2 - 1), this.topLevel);
        this.cache[i] = new SoftReference<>(sampleImpl);
        return sampleImpl;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return CastUtils.l2i(this.trackBox.getSampleTableBox().getSampleSizeBox().getSampleCount());
    }
}
