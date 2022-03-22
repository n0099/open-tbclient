package com.google.android.exoplayer2.source;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes6.dex */
public final class SampleMetadataQueue {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public int absoluteStartIndex;
    public int capacity;
    public TrackOutput.CryptoData[] cryptoDatas;
    public int[] flags;
    public Format[] formats;
    public long largestDiscardedTimestampUs;
    public long largestQueuedTimestampUs;
    public int length;
    public long[] offsets;
    public int readPosition;
    public int relativeStartIndex;
    public int[] sizes;
    public int[] sourceIds;
    public long[] timesUs;
    public Format upstreamFormat;
    public boolean upstreamFormatRequired;
    public boolean upstreamKeyframeRequired;
    public int upstreamSourceId;

    /* loaded from: classes6.dex */
    public static final class SampleExtrasHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;

        public SampleExtrasHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public SampleMetadataQueue() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.capacity = 1000;
        this.sourceIds = new int[1000];
        this.offsets = new long[1000];
        this.timesUs = new long[1000];
        this.flags = new int[1000];
        this.sizes = new int[1000];
        this.cryptoDatas = new TrackOutput.CryptoData[1000];
        this.formats = new Format[1000];
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.upstreamFormatRequired = true;
        this.upstreamKeyframeRequired = true;
    }

    private long discardSamples(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i));
            this.length -= i;
            this.absoluteStartIndex += i;
            int i3 = this.relativeStartIndex + i;
            this.relativeStartIndex = i3;
            int i4 = this.capacity;
            if (i3 >= i4) {
                this.relativeStartIndex = i3 - i4;
            }
            int i5 = this.readPosition - i;
            this.readPosition = i5;
            if (i5 < 0) {
                this.readPosition = 0;
            }
            if (this.length == 0) {
                int i6 = this.relativeStartIndex;
                if (i6 == 0) {
                    i6 = this.capacity;
                }
                return this.offsets[i6 - 1] + this.sizes[i2];
            }
            return this.offsets[this.relativeStartIndex];
        }
        return invokeI.longValue;
    }

    private int findSampleBefore(int i, int i2, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            int i3 = -1;
            for (int i4 = 0; i4 < i2 && this.timesUs[i] <= j; i4++) {
                if (!z || (this.flags[i] & 1) != 0) {
                    i3 = i4;
                }
                i++;
                if (i == this.capacity) {
                    i = 0;
                }
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    private long getLargestTimestamp(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            long j = Long.MIN_VALUE;
            if (i == 0) {
                return Long.MIN_VALUE;
            }
            int relativeIndex = getRelativeIndex(i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                j = Math.max(j, this.timesUs[relativeIndex]);
                if ((this.flags[relativeIndex] & 1) != 0) {
                    break;
                }
                relativeIndex--;
                if (relativeIndex == -1) {
                    relativeIndex = this.capacity - 1;
                }
            }
            return j;
        }
        return invokeI.longValue;
    }

    private int getRelativeIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            int i2 = this.relativeStartIndex + i;
            int i3 = this.capacity;
            return i2 < i3 ? i2 : i2 - i3;
        }
        return invokeI.intValue;
    }

    public synchronized int advanceTo(long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                int relativeIndex = getRelativeIndex(this.readPosition);
                if (hasNextSample() && j >= this.timesUs[relativeIndex] && (j <= this.largestQueuedTimestampUs || z2)) {
                    int findSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, j, z);
                    if (findSampleBefore == -1) {
                        return -1;
                    }
                    this.readPosition += findSampleBefore;
                    return findSampleBefore;
                }
                return -1;
            }
        }
        return invokeCommon.intValue;
    }

    public synchronized int advanceToEnd() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i = this.length - this.readPosition;
                this.readPosition = this.length;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized boolean attemptSplice(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            synchronized (this) {
                if (this.length == 0) {
                    return j > this.largestDiscardedTimestampUs;
                } else if (Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition)) >= j) {
                    return false;
                } else {
                    int i = this.length;
                    int relativeIndex = getRelativeIndex(this.length - 1);
                    while (i > this.readPosition && this.timesUs[relativeIndex] >= j) {
                        i--;
                        relativeIndex--;
                        if (relativeIndex == -1) {
                            relativeIndex = this.capacity - 1;
                        }
                    }
                    discardUpstreamSamples(this.absoluteStartIndex + i);
                    return true;
                }
            }
        }
        return invokeJ.booleanValue;
    }

    public synchronized void commitSample(long j, int i, long j2, int i2, TrackOutput.CryptoData cryptoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(i2), cryptoData}) == null) {
            synchronized (this) {
                if (this.upstreamKeyframeRequired) {
                    if ((i & 1) == 0) {
                        return;
                    }
                    this.upstreamKeyframeRequired = false;
                }
                Assertions.checkState(!this.upstreamFormatRequired);
                commitSampleTimestamp(j);
                int relativeIndex = getRelativeIndex(this.length);
                this.timesUs[relativeIndex] = j;
                this.offsets[relativeIndex] = j2;
                this.sizes[relativeIndex] = i2;
                this.flags[relativeIndex] = i;
                this.cryptoDatas[relativeIndex] = cryptoData;
                this.formats[relativeIndex] = this.upstreamFormat;
                this.sourceIds[relativeIndex] = this.upstreamSourceId;
                int i3 = this.length + 1;
                this.length = i3;
                if (i3 == this.capacity) {
                    int i4 = this.capacity + 1000;
                    int[] iArr = new int[i4];
                    long[] jArr = new long[i4];
                    long[] jArr2 = new long[i4];
                    int[] iArr2 = new int[i4];
                    int[] iArr3 = new int[i4];
                    TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i4];
                    Format[] formatArr = new Format[i4];
                    int i5 = this.capacity - this.relativeStartIndex;
                    System.arraycopy(this.offsets, this.relativeStartIndex, jArr, 0, i5);
                    System.arraycopy(this.timesUs, this.relativeStartIndex, jArr2, 0, i5);
                    System.arraycopy(this.flags, this.relativeStartIndex, iArr2, 0, i5);
                    System.arraycopy(this.sizes, this.relativeStartIndex, iArr3, 0, i5);
                    System.arraycopy(this.cryptoDatas, this.relativeStartIndex, cryptoDataArr, 0, i5);
                    System.arraycopy(this.formats, this.relativeStartIndex, formatArr, 0, i5);
                    System.arraycopy(this.sourceIds, this.relativeStartIndex, iArr, 0, i5);
                    int i6 = this.relativeStartIndex;
                    System.arraycopy(this.offsets, 0, jArr, i5, i6);
                    System.arraycopy(this.timesUs, 0, jArr2, i5, i6);
                    System.arraycopy(this.flags, 0, iArr2, i5, i6);
                    System.arraycopy(this.sizes, 0, iArr3, i5, i6);
                    System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i5, i6);
                    System.arraycopy(this.formats, 0, formatArr, i5, i6);
                    System.arraycopy(this.sourceIds, 0, iArr, i5, i6);
                    this.offsets = jArr;
                    this.timesUs = jArr2;
                    this.flags = iArr2;
                    this.sizes = iArr3;
                    this.cryptoDatas = cryptoDataArr;
                    this.formats = formatArr;
                    this.sourceIds = iArr;
                    this.relativeStartIndex = 0;
                    this.length = this.capacity;
                    this.capacity = i4;
                }
            }
        }
    }

    public synchronized void commitSampleTimestamp(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            synchronized (this) {
                this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j);
            }
        }
    }

    public synchronized long discardTo(long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                if (this.length != 0 && j >= this.timesUs[this.relativeStartIndex]) {
                    int findSampleBefore = findSampleBefore(this.relativeStartIndex, (!z2 || this.readPosition == this.length) ? this.length : this.readPosition + 1, j, z);
                    if (findSampleBefore == -1) {
                        return -1L;
                    }
                    return discardSamples(findSampleBefore);
                }
                return -1L;
            }
        }
        return invokeCommon.longValue;
    }

    public synchronized long discardToEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.length == 0) {
                    return -1L;
                }
                return discardSamples(this.length);
            }
        }
        return invokeV.longValue;
    }

    public synchronized long discardToRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                if (this.readPosition == 0) {
                    return -1L;
                }
                return discardSamples(this.readPosition);
            }
        }
        return invokeV.longValue;
    }

    public long discardUpstreamSamples(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            int writeIndex = getWriteIndex() - i;
            Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.length - this.readPosition);
            int i2 = this.length - writeIndex;
            this.length = i2;
            this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i2));
            int i3 = this.length;
            if (i3 == 0) {
                return 0L;
            }
            int relativeIndex = getRelativeIndex(i3 - 1);
            return this.offsets[relativeIndex] + this.sizes[relativeIndex];
        }
        return invokeI.longValue;
    }

    public synchronized boolean format(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, format)) == null) {
            synchronized (this) {
                if (format == null) {
                    this.upstreamFormatRequired = true;
                    return false;
                }
                this.upstreamFormatRequired = false;
                if (Util.areEqual(format, this.upstreamFormat)) {
                    return false;
                }
                this.upstreamFormat = format;
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized long getLargestQueuedTimestampUs() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                j = this.largestQueuedTimestampUs;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public int getReadIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.absoluteStartIndex + this.readPosition : invokeV.intValue;
    }

    public synchronized Format getUpstreamFormat() {
        InterceptResult invokeV;
        Format format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                format = this.upstreamFormatRequired ? null : this.upstreamFormat;
            }
            return format;
        }
        return (Format) invokeV.objValue;
    }

    public int getWriteIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.absoluteStartIndex + this.length : invokeV.intValue;
    }

    public synchronized boolean hasNextSample() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                z = this.readPosition != this.length;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public int peekSourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return hasNextSample() ? this.sourceIds[getRelativeIndex(this.readPosition)] : this.upstreamSourceId;
        }
        return invokeV.intValue;
    }

    public synchronized int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, Format format, SampleExtrasHolder sampleExtrasHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{formatHolder, decoderInputBuffer, Boolean.valueOf(z), Boolean.valueOf(z2), format, sampleExtrasHolder})) == null) {
            synchronized (this) {
                if (!hasNextSample()) {
                    if (z2) {
                        decoderInputBuffer.setFlags(4);
                        return -4;
                    } else if (this.upstreamFormat == null || (!z && this.upstreamFormat == format)) {
                        return -3;
                    } else {
                        formatHolder.format = this.upstreamFormat;
                        return -5;
                    }
                }
                int relativeIndex = getRelativeIndex(this.readPosition);
                if (!z && this.formats[relativeIndex] == format) {
                    if (decoderInputBuffer.isFlagsOnly()) {
                        return -3;
                    }
                    decoderInputBuffer.timeUs = this.timesUs[relativeIndex];
                    decoderInputBuffer.setFlags(this.flags[relativeIndex]);
                    sampleExtrasHolder.size = this.sizes[relativeIndex];
                    sampleExtrasHolder.offset = this.offsets[relativeIndex];
                    sampleExtrasHolder.cryptoData = this.cryptoDatas[relativeIndex];
                    this.readPosition++;
                    return -4;
                }
                formatHolder.format = this.formats[relativeIndex];
                return -5;
            }
        }
        return invokeCommon.intValue;
    }

    public void reset(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.length = 0;
            this.absoluteStartIndex = 0;
            this.relativeStartIndex = 0;
            this.readPosition = 0;
            this.upstreamKeyframeRequired = true;
            this.largestDiscardedTimestampUs = Long.MIN_VALUE;
            this.largestQueuedTimestampUs = Long.MIN_VALUE;
            if (z) {
                this.upstreamFormat = null;
                this.upstreamFormatRequired = true;
            }
        }
    }

    public synchronized void rewind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                this.readPosition = 0;
            }
        }
    }

    public void sourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.upstreamSourceId = i;
        }
    }
}
