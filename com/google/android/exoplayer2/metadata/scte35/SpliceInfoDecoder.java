package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public final class SpliceInfoDecoder implements MetadataDecoder {
    public static final int TYPE_PRIVATE_COMMAND = 255;
    public static final int TYPE_SPLICE_INSERT = 5;
    public static final int TYPE_SPLICE_NULL = 0;
    public static final int TYPE_SPLICE_SCHEDULE = 4;
    public static final int TYPE_TIME_SIGNAL = 6;
    public final ParsableByteArray sectionData = new ParsableByteArray();
    public final ParsableBitArray sectionHeader = new ParsableBitArray();
    public TimestampAdjuster timestampAdjuster;

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer) throws MetadataDecoderException {
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
        if (readBits3 != 0) {
            if (readBits3 != 255) {
                if (readBits3 != 4) {
                    if (readBits3 != 5) {
                        if (readBits3 == 6) {
                            entry = TimeSignalCommand.parseFromSection(this.sectionData, readBits, this.timestampAdjuster);
                        }
                    } else {
                        entry = SpliceInsertCommand.parseFromSection(this.sectionData, readBits, this.timestampAdjuster);
                    }
                } else {
                    entry = SpliceScheduleCommand.parseFromSection(this.sectionData);
                }
            } else {
                entry = PrivateCommand.parseFromSection(this.sectionData, readBits2, readBits);
            }
        } else {
            entry = new SpliceNullCommand();
        }
        if (entry == null) {
            return new Metadata(new Metadata.Entry[0]);
        }
        return new Metadata(entry);
    }
}
