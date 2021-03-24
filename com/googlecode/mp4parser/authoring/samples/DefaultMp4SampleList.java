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
        int i = 0;
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
            int i2 = 1;
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            int i6 = 1;
            do {
                i3++;
                if (i3 == firstChunk) {
                    if (entryArr.length > i4) {
                        SampleToChunkBox.Entry entry2 = entryArr[i4];
                        i5 = l2i;
                        l2i = CastUtils.l2i(entry2.getSamplesPerChunk());
                        i4++;
                        firstChunk = entry2.getFirstChunk();
                    } else {
                        i5 = l2i;
                        firstChunk = Long.MAX_VALUE;
                        l2i = -1;
                    }
                }
                i6 += i5;
            } while (i6 <= size);
            this.chunkNumsStartSampleNum = new int[i3 + 1];
            SampleToChunkBox.Entry entry3 = entryArr[0];
            long firstChunk2 = entry3.getFirstChunk();
            int l2i2 = CastUtils.l2i(entry3.getSamplesPerChunk());
            int i7 = 0;
            int i8 = 1;
            while (true) {
                int i9 = i + 1;
                this.chunkNumsStartSampleNum[i] = i2;
                if (i9 == firstChunk2) {
                    if (entryArr.length > i8) {
                        SampleToChunkBox.Entry entry4 = entryArr[i8];
                        i7 = l2i2;
                        l2i2 = CastUtils.l2i(entry4.getSamplesPerChunk());
                        firstChunk2 = entry4.getFirstChunk();
                        i8++;
                    } else {
                        i7 = l2i2;
                        firstChunk2 = Long.MAX_VALUE;
                        l2i2 = -1;
                    }
                }
                i2 += i7;
                if (i2 > size) {
                    this.chunkNumsStartSampleNum[i9] = Integer.MAX_VALUE;
                    return;
                }
                i = i9;
            }
        } else {
            throw new RuntimeException("This MP4 does not contain track " + j);
        }
    }

    public synchronized int getChunkForSample(int i) {
        int i2 = i + 1;
        if (i2 >= this.chunkNumsStartSampleNum[this.lastChunk] && i2 < this.chunkNumsStartSampleNum[this.lastChunk + 1]) {
            return this.lastChunk;
        } else if (i2 < this.chunkNumsStartSampleNum[this.lastChunk]) {
            this.lastChunk = 0;
            while (this.chunkNumsStartSampleNum[this.lastChunk + 1] <= i2) {
                this.lastChunk++;
            }
            return this.lastChunk;
        } else {
            this.lastChunk++;
            while (this.chunkNumsStartSampleNum[this.lastChunk + 1] <= i2) {
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
    public Sample get(int i) {
        SoftReference<Sample>[] softReferenceArr = this.cache;
        if (i < softReferenceArr.length) {
            if (softReferenceArr[i] != null && softReferenceArr[i].get() != null) {
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
        throw new IndexOutOfBoundsException();
    }
}
