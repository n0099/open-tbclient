package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleMetadataQueue;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes4.dex */
public final class SampleQueue implements TrackOutput {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ADVANCE_FAILED = -1;
    public static final int INITIAL_SCRATCH_SIZE = 32;
    public transient /* synthetic */ FieldHolder $fh;
    public final int allocationLength;
    public final Allocator allocator;
    public Format downstreamFormat;
    public final SampleMetadataQueue.SampleExtrasHolder extrasHolder;
    public AllocationNode firstAllocationNode;
    public Format lastUnadjustedFormat;
    public final SampleMetadataQueue metadataQueue;
    public boolean pendingFormatAdjustment;
    public boolean pendingSplice;
    public AllocationNode readAllocationNode;
    public long sampleOffsetUs;
    public final ParsableByteArray scratch;
    public long totalBytesWritten;
    public UpstreamFormatChangedListener upstreamFormatChangeListener;
    public AllocationNode writeAllocationNode;

    /* loaded from: classes4.dex */
    public static final class AllocationNode {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public Allocation allocation;
        public final long endPosition;
        @Nullable
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.startPosition = j;
            this.endPosition = j + i;
        }

        public AllocationNode clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.allocation = null;
                AllocationNode allocationNode = this.next;
                this.next = null;
                return allocationNode;
            }
            return (AllocationNode) invokeV.objValue;
        }

        public void initialize(Allocation allocation, AllocationNode allocationNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, allocation, allocationNode) == null) {
                this.allocation = allocation;
                this.next = allocationNode;
                this.wasInitialized = true;
            }
        }

        public int translateOffset(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? ((int) (j - this.startPosition)) + this.allocation.offset : invokeJ.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {allocator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.allocator = allocator;
        this.allocationLength = allocator.getIndividualAllocationLength();
        this.metadataQueue = new SampleMetadataQueue();
        this.extrasHolder = new SampleMetadataQueue.SampleExtrasHolder();
        this.scratch = new ParsableByteArray(32);
        AllocationNode allocationNode = new AllocationNode(0L, this.allocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    private void advanceReadTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(65537, this, j) != null) {
            return;
        }
        while (true) {
            AllocationNode allocationNode = this.readAllocationNode;
            if (j < allocationNode.endPosition) {
                return;
            }
            this.readAllocationNode = allocationNode.next;
        }
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, allocationNode) == null) && allocationNode.wasInitialized) {
            AllocationNode allocationNode2 = this.writeAllocationNode;
            int i = (allocationNode2.wasInitialized ? 1 : 0) + (((int) (allocationNode2.startPosition - allocationNode.startPosition)) / this.allocationLength);
            Allocation[] allocationArr = new Allocation[i];
            for (int i2 = 0; i2 < i; i2++) {
                allocationArr[i2] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private void discardDownstreamTo(long j) {
        AllocationNode allocationNode;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65539, this, j) == null) || j == -1) {
            return;
        }
        while (true) {
            allocationNode = this.firstAllocationNode;
            if (j < allocationNode.endPosition) {
                break;
            }
            this.allocator.release(allocationNode.allocation);
            this.firstAllocationNode = this.firstAllocationNode.clear();
        }
        if (this.readAllocationNode.startPosition < allocationNode.startPosition) {
            this.readAllocationNode = allocationNode;
        }
    }

    public static Format getAdjustedSampleFormat(Format format, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, format, j)) == null) {
            if (format == null) {
                return null;
            }
            if (j != 0) {
                long j2 = format.subsampleOffsetUs;
                return j2 != Long.MAX_VALUE ? format.copyWithSubsampleOffsetUs(j2 + j) : format;
            }
            return format;
        }
        return (Format) invokeLJ.objValue;
    }

    private void postAppend(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            long j = this.totalBytesWritten + i;
            this.totalBytesWritten = j;
            AllocationNode allocationNode = this.writeAllocationNode;
            if (j == allocationNode.endPosition) {
                this.writeAllocationNode = allocationNode.next;
            }
        }
    }

    private int preAppend(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i)) == null) {
            AllocationNode allocationNode = this.writeAllocationNode;
            if (!allocationNode.wasInitialized) {
                allocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
            }
            return Math.min(i, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
        }
        return invokeI.intValue;
    }

    private void readData(long j, ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Long.valueOf(j), byteBuffer, Integer.valueOf(i)}) == null) {
            advanceReadTo(j);
            while (i > 0) {
                int min = Math.min(i, (int) (this.readAllocationNode.endPosition - j));
                AllocationNode allocationNode = this.readAllocationNode;
                byteBuffer.put(allocationNode.allocation.data, allocationNode.translateOffset(j), min);
                i -= min;
                j += min;
                AllocationNode allocationNode2 = this.readAllocationNode;
                if (j == allocationNode2.endPosition) {
                    this.readAllocationNode = allocationNode2.next;
                }
            }
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, decoderInputBuffer, sampleExtrasHolder) == null) {
            long j = sampleExtrasHolder.offset;
            this.scratch.reset(1);
            readData(j, this.scratch.data, 1);
            long j2 = j + 1;
            byte b = this.scratch.data[0];
            boolean z = (b & 128) != 0;
            int i2 = b & ByteCompanionObject.MAX_VALUE;
            CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
            if (cryptoInfo.iv == null) {
                cryptoInfo.iv = new byte[16];
            }
            readData(j2, decoderInputBuffer.cryptoInfo.iv, i2);
            long j3 = j2 + i2;
            if (z) {
                this.scratch.reset(2);
                readData(j3, this.scratch.data, 2);
                j3 += 2;
                i = this.scratch.readUnsignedShort();
            } else {
                i = 1;
            }
            int[] iArr = decoderInputBuffer.cryptoInfo.numBytesOfClearData;
            if (iArr == null || iArr.length < i) {
                iArr = new int[i];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = decoderInputBuffer.cryptoInfo.numBytesOfEncryptedData;
            if (iArr3 == null || iArr3.length < i) {
                iArr3 = new int[i];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i3 = i * 6;
                this.scratch.reset(i3);
                readData(j3, this.scratch.data, i3);
                j3 += i3;
                this.scratch.setPosition(0);
                for (int i4 = 0; i4 < i; i4++) {
                    iArr2[i4] = this.scratch.readUnsignedShort();
                    iArr4[i4] = this.scratch.readUnsignedIntToInt();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = sampleExtrasHolder.size - ((int) (j3 - sampleExtrasHolder.offset));
            }
            TrackOutput.CryptoData cryptoData = sampleExtrasHolder.cryptoData;
            CryptoInfo cryptoInfo2 = decoderInputBuffer.cryptoInfo;
            cryptoInfo2.set(i, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo2.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
            long j4 = sampleExtrasHolder.offset;
            int i5 = (int) (j3 - j4);
            sampleExtrasHolder.offset = j4 + i5;
            sampleExtrasHolder.size -= i5;
        }
    }

    public int advanceTo(long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.metadataQueue.advanceTo(j, z, z2) : invokeCommon.intValue;
    }

    public int advanceToEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.metadataQueue.advanceToEnd() : invokeV.intValue;
    }

    public void discardTo(long j, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            discardDownstreamTo(this.metadataQueue.discardTo(j, z, z2));
        }
    }

    public void discardToEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            discardDownstreamTo(this.metadataQueue.discardToEnd());
        }
    }

    public void discardToRead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            discardDownstreamTo(this.metadataQueue.discardToRead());
        }
    }

    public void discardUpstreamSamples(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            long discardUpstreamSamples = this.metadataQueue.discardUpstreamSamples(i);
            this.totalBytesWritten = discardUpstreamSamples;
            if (discardUpstreamSamples != 0) {
                AllocationNode allocationNode = this.firstAllocationNode;
                if (discardUpstreamSamples != allocationNode.startPosition) {
                    while (this.totalBytesWritten > allocationNode.endPosition) {
                        allocationNode = allocationNode.next;
                    }
                    AllocationNode allocationNode2 = allocationNode.next;
                    clearAllocationNodes(allocationNode2);
                    AllocationNode allocationNode3 = new AllocationNode(allocationNode.endPosition, this.allocationLength);
                    allocationNode.next = allocationNode3;
                    if (this.totalBytesWritten != allocationNode.endPosition) {
                        allocationNode3 = allocationNode;
                    }
                    this.writeAllocationNode = allocationNode3;
                    if (this.readAllocationNode == allocationNode2) {
                        this.readAllocationNode = allocationNode.next;
                        return;
                    }
                    return;
                }
            }
            clearAllocationNodes(this.firstAllocationNode);
            AllocationNode allocationNode4 = new AllocationNode(this.totalBytesWritten, this.allocationLength);
            this.firstAllocationNode = allocationNode4;
            this.readAllocationNode = allocationNode4;
            this.writeAllocationNode = allocationNode4;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, format) == null) {
            Format adjustedSampleFormat = getAdjustedSampleFormat(format, this.sampleOffsetUs);
            boolean format2 = this.metadataQueue.format(adjustedSampleFormat);
            this.lastUnadjustedFormat = format;
            this.pendingFormatAdjustment = false;
            UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
            if (upstreamFormatChangedListener == null || !format2) {
                return;
            }
            upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedSampleFormat);
        }
    }

    public long getLargestQueuedTimestampUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.metadataQueue.getLargestQueuedTimestampUs() : invokeV.longValue;
    }

    public int getReadIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.metadataQueue.getReadIndex() : invokeV.intValue;
    }

    public Format getUpstreamFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.metadataQueue.getUpstreamFormat() : (Format) invokeV.objValue;
    }

    public int getWriteIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.metadataQueue.getWriteIndex() : invokeV.intValue;
    }

    public boolean hasNextSample() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.metadataQueue.hasNextSample() : invokeV.booleanValue;
    }

    public int peekSourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.metadataQueue.peekSourceId() : invokeV.intValue;
    }

    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{formatHolder, decoderInputBuffer, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j)})) == null) {
            int read = this.metadataQueue.read(formatHolder, decoderInputBuffer, z, z2, this.downstreamFormat, this.extrasHolder);
            if (read == -5) {
                this.downstreamFormat = formatHolder.format;
                return -5;
            } else if (read != -4) {
                if (read == -3) {
                    return -3;
                }
                throw new IllegalStateException();
            } else {
                if (!decoderInputBuffer.isEndOfStream()) {
                    if (decoderInputBuffer.timeUs < j) {
                        decoderInputBuffer.addFlag(Integer.MIN_VALUE);
                    }
                    if (decoderInputBuffer.isEncrypted()) {
                        readEncryptionData(decoderInputBuffer, this.extrasHolder);
                    }
                    decoderInputBuffer.ensureSpaceForWrite(this.extrasHolder.size);
                    SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder = this.extrasHolder;
                    readData(sampleExtrasHolder.offset, decoderInputBuffer.data, sampleExtrasHolder.size);
                }
                return -4;
            }
        }
        return invokeCommon.intValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            reset(false);
        }
    }

    public void rewind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.metadataQueue.rewind();
            this.readAllocationNode = this.firstAllocationNode;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{extractorInput, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int preAppend = preAppend(i);
            AllocationNode allocationNode = this.writeAllocationNode;
            int read = extractorInput.read(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
            if (read != -1) {
                postAppend(read);
                return read;
            } else if (z) {
                return -1;
            } else {
                throw new EOFException();
            }
        }
        return invokeCommon.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), cryptoData}) == null) {
            if (this.pendingFormatAdjustment) {
                format(this.lastUnadjustedFormat);
            }
            if (this.pendingSplice) {
                if ((i & 1) == 0 || !this.metadataQueue.attemptSplice(j)) {
                    return;
                }
                this.pendingSplice = false;
            }
            this.metadataQueue.commitSample(j + this.sampleOffsetUs, i, (this.totalBytesWritten - i2) - i3, i2, cryptoData);
        }
    }

    public void setSampleOffsetUs(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048596, this, j) == null) || this.sampleOffsetUs == j) {
            return;
        }
        this.sampleOffsetUs = j;
        this.pendingFormatAdjustment = true;
    }

    public void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, upstreamFormatChangedListener) == null) {
            this.upstreamFormatChangeListener = upstreamFormatChangedListener;
        }
    }

    public void sourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.metadataQueue.sourceId(i);
        }
    }

    public void splice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.pendingSplice = true;
        }
    }

    public void reset(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.metadataQueue.reset(z);
            clearAllocationNodes(this.firstAllocationNode);
            AllocationNode allocationNode = new AllocationNode(0L, this.allocationLength);
            this.firstAllocationNode = allocationNode;
            this.readAllocationNode = allocationNode;
            this.writeAllocationNode = allocationNode;
            this.totalBytesWritten = 0L;
            this.allocator.trim();
        }
    }

    private void readData(long j, byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j), bArr, Integer.valueOf(i)}) == null) {
            advanceReadTo(j);
            int i2 = i;
            while (i2 > 0) {
                int min = Math.min(i2, (int) (this.readAllocationNode.endPosition - j));
                AllocationNode allocationNode = this.readAllocationNode;
                System.arraycopy(allocationNode.allocation.data, allocationNode.translateOffset(j), bArr, i - i2, min);
                i2 -= min;
                j += min;
                AllocationNode allocationNode2 = this.readAllocationNode;
                if (j == allocationNode2.endPosition) {
                    this.readAllocationNode = allocationNode2.next;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, parsableByteArray, i) == null) {
            while (i > 0) {
                int preAppend = preAppend(i);
                AllocationNode allocationNode = this.writeAllocationNode;
                parsableByteArray.readBytes(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
                i -= preAppend;
                postAppend(preAppend);
            }
        }
    }
}
