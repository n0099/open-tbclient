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
/* loaded from: classes2.dex */
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
        long j2;
        int i2;
        int i3;
        int i4;
        int i5;
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
        SampleToChunkBox.Entry entry = entryArr[0];
        long firstChunk = entry.getFirstChunk();
        int l2i = CastUtils.l2i(entry.getSamplesPerChunk());
        int size = size();
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        int i9 = 1;
        while (true) {
            i = i7 + 1;
            if (i != firstChunk) {
                int i10 = l2i;
                j2 = firstChunk;
                i2 = i6;
                i3 = i8;
                i4 = i10;
            } else if (entryArr.length > i8) {
                SampleToChunkBox.Entry entry2 = entryArr[i8];
                i4 = CastUtils.l2i(entry2.getSamplesPerChunk());
                long firstChunk2 = entry2.getFirstChunk();
                i2 = l2i;
                i3 = i8 + 1;
                j2 = firstChunk2;
            } else {
                i4 = -1;
                i2 = l2i;
                i3 = i8;
                j2 = Long.MAX_VALUE;
            }
            int i11 = i9 + i2;
            if (i11 > size) {
                break;
            }
            i9 = i11;
            i8 = i3;
            long j3 = j2;
            i7 = i;
            l2i = i4;
            i6 = i2;
            firstChunk = j3;
        }
        this.chunkNumsStartSampleNum = new int[i + 1];
        SampleToChunkBox.Entry entry3 = entryArr[0];
        int i12 = 0;
        int i13 = 0;
        long firstChunk3 = entry3.getFirstChunk();
        int l2i2 = CastUtils.l2i(entry3.getSamplesPerChunk());
        int i14 = 1;
        int i15 = 1;
        while (true) {
            int i16 = i12 + 1;
            this.chunkNumsStartSampleNum[i12] = i14;
            if (i16 != firstChunk3) {
                i5 = i15;
            } else if (entryArr.length > i15) {
                i5 = i15 + 1;
                SampleToChunkBox.Entry entry4 = entryArr[i15];
                int l2i3 = CastUtils.l2i(entry4.getSamplesPerChunk());
                firstChunk3 = entry4.getFirstChunk();
                i13 = l2i2;
                l2i2 = l2i3;
            } else {
                firstChunk3 = Long.MAX_VALUE;
                i5 = i15;
                int i17 = l2i2;
                l2i2 = -1;
                i13 = i17;
            }
            i14 += i13;
            if (i14 > size) {
                this.chunkNumsStartSampleNum[i16] = Integer.MAX_VALUE;
                return;
            } else {
                i15 = i5;
                i12 = i16;
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
