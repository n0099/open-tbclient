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
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

        public AllocationNode(long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.startPosition = j2;
            this.endPosition = j2 + i2;
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

        public int translateOffset(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? ((int) (j2 - this.startPosition)) + this.allocation.offset : invokeJ.intValue;
        }
    }

    /* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    private void advanceReadTo(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(65537, this, j2) != null) {
            return;
        }
        while (true) {
            AllocationNode allocationNode = this.readAllocationNode;
            if (j2 < allocationNode.endPosition) {
                return;
            }
            this.readAllocationNode = allocationNode.next;
        }
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, allocationNode) == null) && allocationNode.wasInitialized) {
            AllocationNode allocationNode2 = this.writeAllocationNode;
            int i2 = (allocationNode2.wasInitialized ? 1 : 0) + (((int) (allocationNode2.startPosition - allocationNode.startPosition)) / this.allocationLength);
            Allocation[] allocationArr = new Allocation[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                allocationArr[i3] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private void discardDownstreamTo(long j2) {
        AllocationNode allocationNode;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65539, this, j2) == null) || j2 == -1) {
            return;
        }
        while (true) {
            allocationNode = this.firstAllocationNode;
            if (j2 < allocationNode.endPosition) {
                break;
            }
            this.allocator.release(allocationNode.allocation);
            this.firstAllocationNode = this.firstAllocationNode.clear();
        }
        if (this.readAllocationNode.startPosition < allocationNode.startPosition) {
            this.readAllocationNode = allocationNode;
        }
    }

    public static Format getAdjustedSampleFormat(Format format, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, format, j2)) == null) {
            if (format == null) {
                return null;
            }
            if (j2 != 0) {
                long j3 = format.subsampleOffsetUs;
                return j3 != Long.MAX_VALUE ? format.copyWithSubsampleOffsetUs(j3 + j2) : format;
            }
            return format;
        }
        return (Format) invokeLJ.objValue;
    }

    private void postAppend(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i2) == null) {
            long j2 = this.totalBytesWritten + i2;
            this.totalBytesWritten = j2;
            AllocationNode allocationNode = this.writeAllocationNode;
            if (j2 == allocationNode.endPosition) {
                this.writeAllocationNode = allocationNode.next;
            }
        }
    }

    private int preAppend(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i2)) == null) {
            AllocationNode allocationNode = this.writeAllocationNode;
            if (!allocationNode.wasInitialized) {
                allocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
            }
            return Math.min(i2, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
        }
        return invokeI.intValue;
    }

    private void readData(long j2, ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Long.valueOf(j2), byteBuffer, Integer.valueOf(i2)}) == null) {
            advanceReadTo(j2);
            while (i2 > 0) {
                int min = Math.min(i2, (int) (this.readAllocationNode.endPosition - j2));
                AllocationNode allocationNode = this.readAllocationNode;
                byteBuffer.put(allocationNode.allocation.data, allocationNode.translateOffset(j2), min);
                i2 -= min;
                j2 += min;
                AllocationNode allocationNode2 = this.readAllocationNode;
                if (j2 == allocationNode2.endPosition) {
                    this.readAllocationNode = allocationNode2.next;
                }
            }
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, decoderInputBuffer, sampleExtrasHolder) == null) {
            long j2 = sampleExtrasHolder.offset;
            this.scratch.reset(1);
            readData(j2, this.scratch.data, 1);
            long j3 = j2 + 1;
            byte b2 = this.scratch.data[0];
            boolean z = (b2 & 128) != 0;
            int i3 = b2 & ByteCompanionObject.MAX_VALUE;
            CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
            if (cryptoInfo.iv == null) {
                cryptoInfo.iv = new byte[16];
            }
            readData(j3, decoderInputBuffer.cryptoInfo.iv, i3);
            long j4 = j3 + i3;
            if (z) {
                this.scratch.reset(2);
                readData(j4, this.scratch.data, 2);
                j4 += 2;
                i2 = this.scratch.readUnsignedShort();
            } else {
                i2 = 1;
            }
            int[] iArr = decoderInputBuffer.cryptoInfo.numBytesOfClearData;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = decoderInputBuffer.cryptoInfo.numBytesOfEncryptedData;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i2 * 6;
                this.scratch.reset(i4);
                readData(j4, this.scratch.data, i4);
                j4 += i4;
                this.scratch.setPosition(0);
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr2[i5] = this.scratch.readUnsignedShort();
                    iArr4[i5] = this.scratch.readUnsignedIntToInt();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = sampleExtrasHolder.size - ((int) (j4 - sampleExtrasHolder.offset));
            }
            TrackOutput.CryptoData cryptoData = sampleExtrasHolder.cryptoData;
            CryptoInfo cryptoInfo2 = decoderInputBuffer.cryptoInfo;
            cryptoInfo2.set(i2, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo2.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
            long j5 = sampleExtrasHolder.offset;
            int i6 = (int) (j4 - j5);
            sampleExtrasHolder.offset = j5 + i6;
            sampleExtrasHolder.size -= i6;
        }
    }

    public int advanceTo(long j2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.metadataQueue.advanceTo(j2, z, z2) : invokeCommon.intValue;
    }

    public int advanceToEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.metadataQueue.advanceToEnd() : invokeV.intValue;
    }

    public void discardTo(long j2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            discardDownstreamTo(this.metadataQueue.discardTo(j2, z, z2));
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

    public void discardUpstreamSamples(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            long discardUpstreamSamples = this.metadataQueue.discardUpstreamSamples(i2);
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

    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{formatHolder, decoderInputBuffer, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2)})) == null) {
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
                    if (decoderInputBuffer.timeUs < j2) {
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
    public int sampleData(ExtractorInput extractorInput, int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{extractorInput, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int preAppend = preAppend(i2);
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
    public void sampleMetadata(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), cryptoData}) == null) {
            if (this.pendingFormatAdjustment) {
                format(this.lastUnadjustedFormat);
            }
            if (this.pendingSplice) {
                if ((i2 & 1) == 0 || !this.metadataQueue.attemptSplice(j2)) {
                    return;
                }
                this.pendingSplice = false;
            }
            this.metadataQueue.commitSample(j2 + this.sampleOffsetUs, i2, (this.totalBytesWritten - i3) - i4, i3, cryptoData);
        }
    }

    public void setSampleOffsetUs(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) || this.sampleOffsetUs == j2) {
            return;
        }
        this.sampleOffsetUs = j2;
        this.pendingFormatAdjustment = true;
    }

    public void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, upstreamFormatChangedListener) == null) {
            this.upstreamFormatChangeListener = upstreamFormatChangedListener;
        }
    }

    public void sourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.metadataQueue.sourceId(i2);
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

    private void readData(long j2, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j2), bArr, Integer.valueOf(i2)}) == null) {
            advanceReadTo(j2);
            int i3 = i2;
            while (i3 > 0) {
                int min = Math.min(i3, (int) (this.readAllocationNode.endPosition - j2));
                AllocationNode allocationNode = this.readAllocationNode;
                System.arraycopy(allocationNode.allocation.data, allocationNode.translateOffset(j2), bArr, i2 - i3, min);
                i3 -= min;
                j2 += min;
                AllocationNode allocationNode2 = this.readAllocationNode;
                if (j2 == allocationNode2.endPosition) {
                    this.readAllocationNode = allocationNode2.next;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, parsableByteArray, i2) == null) {
            while (i2 > 0) {
                int preAppend = preAppend(i2);
                AllocationNode allocationNode = this.writeAllocationNode;
                parsableByteArray.readBytes(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
                i2 -= preAppend;
                postAppend(preAppend);
            }
        }
    }
}
