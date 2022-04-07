package com.google.android.exoplayer2.metadata.scte35;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class SpliceInfoDecoder implements MetadataDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_PRIVATE_COMMAND = 255;
    public static final int TYPE_SPLICE_INSERT = 5;
    public static final int TYPE_SPLICE_NULL = 0;
    public static final int TYPE_SPLICE_SCHEDULE = 4;
    public static final int TYPE_TIME_SIGNAL = 6;
    public transient /* synthetic */ FieldHolder $fh;
    public final ParsableByteArray sectionData;
    public final ParsableBitArray sectionHeader;
    public TimestampAdjuster timestampAdjuster;

    public SpliceInfoDecoder() {
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
        this.sectionData = new ParsableByteArray();
        this.sectionHeader = new ParsableBitArray();
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer) throws MetadataDecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, metadataInputBuffer)) == null) {
            TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
            if (timestampAdjuster == null || metadataInputBuffer.subsampleOffsetUs != timestampAdjuster.getTimestampOffsetUs()) {
                TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(metadataInputBuffer.timeUs);
                this.timestampAdjuster = timestampAdjuster2;
                timestampAdjuster2.adjustSampleTimestamp(metadataInputBuffer.timeUs - metadataInputBuffer.subsampleOffsetUs);
            }
            ByteBuffer byteBuffer = metadataInputBuffer.data;
            byte[] array = byteBuffer.array();
            int limit = byteBuffer.limit();
            this.sectionData.reset(array, limit);
            this.sectionHeader.reset(array, limit);
            this.sectionHeader.skipBits(39);
            long readBits = (this.sectionHeader.readBits(1) << 32) | this.sectionHeader.readBits(32);
            this.sectionHeader.skipBits(20);
            int readBits2 = this.sectionHeader.readBits(12);
            int readBits3 = this.sectionHeader.readBits(8);
            Metadata.Entry entry = null;
            this.sectionData.skipBytes(14);
            if (readBits3 == 0) {
                entry = new SpliceNullCommand();
            } else if (readBits3 == 255) {
                entry = PrivateCommand.parseFromSection(this.sectionData, readBits2, readBits);
            } else if (readBits3 == 4) {
                entry = SpliceScheduleCommand.parseFromSection(this.sectionData);
            } else if (readBits3 == 5) {
                entry = SpliceInsertCommand.parseFromSection(this.sectionData, readBits, this.timestampAdjuster);
            } else if (readBits3 == 6) {
                entry = TimeSignalCommand.parseFromSection(this.sectionData, readBits, this.timestampAdjuster);
            }
            return entry == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(entry);
        }
        return (Metadata) invokeL.objValue;
    }
}
