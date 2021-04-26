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
    public SoftReference<Sample>[] cache;
    public int[] chunkNumsStartSampleNum;
    public long[] chunkOffsets;
    public int lastChunk = 0;
    public SampleSizeBox ssb;
    public Container topLevel;
    public TrackBox trackBox;

    public DefaultMp4SampleList(long j, Container container) {
        this.trackBox = null;
        this.cache = null;
        int i2 = 0;
        this.topLevel = container;
        for (TrackBox trackBox : ((MovieBox) container.getBoxes(MovieBox.class).get(0)).getBoxes(TrackBox.class)) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j) {
                this.trackBox = trackBox;
            }
        }
        TrackBox trackBox2 = this.trackBox;
        if (trackBox2 != null) {
            this.chunkOffsets = trackBox2.getSampleTableBox().getChunkOffsetBox().getChunkOffsets();
            this.cache = (SoftReference[]) Array.newInstance(SoftReference.class, size());
            this.ssb = this.trackBox.getSampleTableBox().getSampleSizeBox();
            List<SampleToChunkBox.Entry> entries = this.trackBox.getSampleTableBox().getSampleToChunkBox().getEntries();
            SampleToChunkBox.Entry[] entryArr = (SampleToChunkBox.Entry[]) entries.toArray(new SampleToChunkBox.Entry[entries.size()]);
            SampleToChunkBox.Entry entry = entryArr[0];
            long firstChunk = entry.getFirstChunk();
            int l2i = CastUtils.l2i(entry.getSamplesPerChunk());
            int size = size();
            int i3 = 1;
            int i4 = 0;
            int i5 = 1;
            int i6 = 0;
            int i7 = 1;
            do {
                i4++;
                if (i4 == firstChunk) {
                    if (entryArr.length > i5) {
                        SampleToChunkBox.Entry entry2 = entryArr[i5];
                        i6 = l2i;
                        l2i = CastUtils.l2i(entry2.getSamplesPerChunk());
                        i5++;
                        firstChunk = entry2.getFirstChunk();
                    } else {
                        i6 = l2i;
                        firstChunk = Long.MAX_VALUE;
                        l2i = -1;
                    }
                }
                i7 += i6;
            } while (i7 <= size);
            this.chunkNumsStartSampleNum = new int[i4 + 1];
            SampleToChunkBox.Entry entry3 = entryArr[0];
            long firstChunk2 = entry3.getFirstChunk();
            int l2i2 = CastUtils.l2i(entry3.getSamplesPerChunk());
            int i8 = 0;
            int i9 = 1;
            while (true) {
                int i10 = i2 + 1;
                this.chunkNumsStartSampleNum[i2] = i3;
                if (i10 == firstChunk2) {
                    if (entryArr.length > i9) {
                        SampleToChunkBox.Entry entry4 = entryArr[i9];
                        i8 = l2i2;
                        l2i2 = CastUtils.l2i(entry4.getSamplesPerChunk());
                        firstChunk2 = entry4.getFirstChunk();
                        i9++;
                    } else {
                        i8 = l2i2;
                        firstChunk2 = Long.MAX_VALUE;
                        l2i2 = -1;
                    }
                }
                i3 += i8;
                if (i3 > size) {
                    this.chunkNumsStartSampleNum[i10] = Integer.MAX_VALUE;
                    return;
                }
                i2 = i10;
            }
        } else {
            throw new RuntimeException("This MP4 does not contain track " + j);
        }
    }

    public synchronized int getChunkForSample(int i2) {
        int i3 = i2 + 1;
        if (i3 >= this.chunkNumsStartSampleNum[this.lastChunk] && i3 < this.chunkNumsStartSampleNum[this.lastChunk + 1]) {
            return this.lastChunk;
        } else if (i3 < this.chunkNumsStartSampleNum[this.lastChunk]) {
            this.lastChunk = 0;
            while (this.chunkNumsStartSampleNum[this.lastChunk + 1] <= i3) {
                this.lastChunk++;
            }
            return this.lastChunk;
        } else {
            this.lastChunk++;
            while (this.chunkNumsStartSampleNum[this.lastChunk + 1] <= i3) {
                this.lastChunk++;
            }
            return this.lastChunk;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return CastUtils.l2i(this.trackBox.getSampleTableBox().getSampleSizeBox().getSampleCount());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i2) {
        SoftReference<Sample>[] softReferenceArr = this.cache;
        if (i2 < softReferenceArr.length) {
            if (softReferenceArr[i2] != null && softReferenceArr[i2].get() != null) {
                return this.cache[i2].get();
            }
            int chunkForSample = getChunkForSample(i2);
            int i3 = this.chunkNumsStartSampleNum[chunkForSample];
            long j = this.chunkOffsets[CastUtils.l2i(chunkForSample)];
            while (i3 < i2 + 1) {
                j += this.ssb.getSampleSizeAtIndex(i3 - 1);
                i3++;
            }
            SampleImpl sampleImpl = new SampleImpl(j, this.ssb.getSampleSizeAtIndex(i3 - 1), this.topLevel);
            this.cache[i2] = new SoftReference<>(sampleImpl);
            return sampleImpl;
        }
        throw new IndexOutOfBoundsException();
    }
}
