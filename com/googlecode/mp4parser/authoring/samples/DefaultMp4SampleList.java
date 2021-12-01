package com.googlecode.mp4parser.authoring.samples;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SoftReference<Sample>[] cache;
    public int[] chunkNumsStartSampleNum;
    public long[] chunkOffsets;
    public int lastChunk;
    public SampleSizeBox ssb;
    public Container topLevel;
    public TrackBox trackBox;

    public DefaultMp4SampleList(long j2, Container container) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), container};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.trackBox = null;
        this.cache = null;
        int i4 = 0;
        this.lastChunk = 0;
        this.topLevel = container;
        for (TrackBox trackBox : ((MovieBox) container.getBoxes(MovieBox.class).get(0)).getBoxes(TrackBox.class)) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j2) {
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
            int i5 = 1;
            int i6 = 0;
            int i7 = 1;
            int i8 = 0;
            int i9 = 1;
            do {
                i6++;
                if (i6 == firstChunk) {
                    if (entryArr.length > i7) {
                        SampleToChunkBox.Entry entry2 = entryArr[i7];
                        i8 = l2i;
                        l2i = CastUtils.l2i(entry2.getSamplesPerChunk());
                        i7++;
                        firstChunk = entry2.getFirstChunk();
                    } else {
                        i8 = l2i;
                        firstChunk = Long.MAX_VALUE;
                        l2i = -1;
                    }
                }
                i9 += i8;
            } while (i9 <= size);
            this.chunkNumsStartSampleNum = new int[i6 + 1];
            SampleToChunkBox.Entry entry3 = entryArr[0];
            long firstChunk2 = entry3.getFirstChunk();
            int l2i2 = CastUtils.l2i(entry3.getSamplesPerChunk());
            int i10 = 0;
            int i11 = 1;
            while (true) {
                int i12 = i4 + 1;
                this.chunkNumsStartSampleNum[i4] = i5;
                if (i12 == firstChunk2) {
                    if (entryArr.length > i11) {
                        SampleToChunkBox.Entry entry4 = entryArr[i11];
                        i10 = l2i2;
                        l2i2 = CastUtils.l2i(entry4.getSamplesPerChunk());
                        firstChunk2 = entry4.getFirstChunk();
                        i11++;
                    } else {
                        i10 = l2i2;
                        firstChunk2 = Long.MAX_VALUE;
                        l2i2 = -1;
                    }
                }
                i5 += i10;
                if (i5 > size) {
                    this.chunkNumsStartSampleNum[i12] = Integer.MAX_VALUE;
                    return;
                }
                i4 = i12;
            }
        } else {
            throw new RuntimeException("This MP4 does not contain track " + j2);
        }
    }

    public synchronized int getChunkForSample(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            synchronized (this) {
                int i3 = i2 + 1;
                if (i3 >= this.chunkNumsStartSampleNum[this.lastChunk] && i3 < this.chunkNumsStartSampleNum[this.lastChunk + 1]) {
                    return this.lastChunk;
                }
                if (i3 < this.chunkNumsStartSampleNum[this.lastChunk]) {
                    this.lastChunk = 0;
                    while (this.chunkNumsStartSampleNum[this.lastChunk + 1] <= i3) {
                        this.lastChunk++;
                    }
                    return this.lastChunk;
                }
                this.lastChunk++;
                while (this.chunkNumsStartSampleNum[this.lastChunk + 1] <= i3) {
                    this.lastChunk++;
                }
                return this.lastChunk;
            }
        }
        return invokeI.intValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? CastUtils.l2i(this.trackBox.getSampleTableBox().getSampleSizeBox().getSampleCount()) : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            SoftReference<Sample>[] softReferenceArr = this.cache;
            if (i2 < softReferenceArr.length) {
                if (softReferenceArr[i2] != null && softReferenceArr[i2].get() != null) {
                    return this.cache[i2].get();
                }
                int chunkForSample = getChunkForSample(i2);
                int i3 = this.chunkNumsStartSampleNum[chunkForSample];
                long j2 = this.chunkOffsets[CastUtils.l2i(chunkForSample)];
                while (i3 < i2 + 1) {
                    j2 += this.ssb.getSampleSizeAtIndex(i3 - 1);
                    i3++;
                }
                SampleImpl sampleImpl = new SampleImpl(j2, this.ssb.getSampleSizeAtIndex(i3 - 1), this.topLevel);
                this.cache[i2] = new SoftReference<>(sampleImpl);
                return sampleImpl;
            }
            throw new IndexOutOfBoundsException();
        }
        return (Sample) invokeI.objValue;
    }
}
