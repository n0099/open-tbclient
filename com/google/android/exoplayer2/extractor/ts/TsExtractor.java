package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class TsExtractor implements Extractor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long AC3_FORMAT_IDENTIFIER;
    public static final int BUFFER_SIZE = 9400;
    public static final long E_AC3_FORMAT_IDENTIFIER;
    public static final ExtractorsFactory FACTORY;
    public static final long HEVC_FORMAT_IDENTIFIER;
    public static final int MAX_PID_PLUS_ONE = 8192;
    public static final int MODE_HLS = 2;
    public static final int MODE_MULTI_PMT = 0;
    public static final int MODE_SINGLE_PMT = 1;
    public static final int SNIFF_TS_PACKET_COUNT = 5;
    public static final int TS_PACKET_SIZE = 188;
    public static final int TS_PAT_PID = 0;
    public static final int TS_STREAM_TYPE_AAC_ADTS = 15;
    public static final int TS_STREAM_TYPE_AAC_LATM = 17;
    public static final int TS_STREAM_TYPE_AC3 = 129;
    public static final int TS_STREAM_TYPE_DTS = 138;
    public static final int TS_STREAM_TYPE_DVBSUBS = 89;
    public static final int TS_STREAM_TYPE_E_AC3 = 135;
    public static final int TS_STREAM_TYPE_H262 = 2;
    public static final int TS_STREAM_TYPE_H264 = 27;
    public static final int TS_STREAM_TYPE_H265 = 36;
    public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
    public static final int TS_STREAM_TYPE_ID3 = 21;
    public static final int TS_STREAM_TYPE_MPA = 3;
    public static final int TS_STREAM_TYPE_MPA_LSF = 4;
    public static final int TS_STREAM_TYPE_SPLICE_INFO = 134;
    public static final int TS_SYNC_BYTE = 71;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseIntArray continuityCounters;
    public TsPayloadReader id3Reader;
    public final int mode;
    public ExtractorOutput output;
    public final TsPayloadReader.Factory payloadReaderFactory;
    public int remainingPmts;
    public final List<TimestampAdjuster> timestampAdjusters;
    public final SparseBooleanArray trackIds;
    public boolean tracksEnded;
    public final ParsableByteArray tsPacketBuffer;
    public final SparseArray<TsPayloadReader> tsPayloadReaders;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface Mode {
    }

    /* loaded from: classes7.dex */
    public class PatReader implements SectionPayloadReader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ParsableBitArray patScratch;
        public final /* synthetic */ TsExtractor this$0;

        public PatReader(TsExtractor tsExtractor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tsExtractor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tsExtractor;
            this.patScratch = new ParsableBitArray(new byte[4]);
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void consume(ParsableByteArray parsableByteArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, parsableByteArray) == null) && parsableByteArray.readUnsignedByte() == 0) {
                parsableByteArray.skipBytes(7);
                int bytesLeft = parsableByteArray.bytesLeft() / 4;
                for (int i2 = 0; i2 < bytesLeft; i2++) {
                    parsableByteArray.readBytes(this.patScratch, 4);
                    int readBits = this.patScratch.readBits(16);
                    this.patScratch.skipBits(3);
                    if (readBits == 0) {
                        this.patScratch.skipBits(13);
                    } else {
                        int readBits2 = this.patScratch.readBits(13);
                        this.this$0.tsPayloadReaders.put(readBits2, new SectionReader(new PmtReader(this.this$0, readBits2)));
                        TsExtractor.access$108(this.this$0);
                    }
                }
                if (this.this$0.mode != 2) {
                    this.this$0.tsPayloadReaders.remove(0);
                }
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, timestampAdjuster, extractorOutput, trackIdGenerator) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class PmtReader implements SectionPayloadReader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int TS_PMT_DESC_AC3 = 106;
        public static final int TS_PMT_DESC_DTS = 123;
        public static final int TS_PMT_DESC_DVBSUBS = 89;
        public static final int TS_PMT_DESC_EAC3 = 122;
        public static final int TS_PMT_DESC_ISO639_LANG = 10;
        public static final int TS_PMT_DESC_REGISTRATION = 5;
        public transient /* synthetic */ FieldHolder $fh;
        public final int pid;
        public final ParsableBitArray pmtScratch;
        public final /* synthetic */ TsExtractor this$0;
        public final SparseIntArray trackIdToPidScratch;
        public final SparseArray<TsPayloadReader> trackIdToReaderScratch;

        public PmtReader(TsExtractor tsExtractor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tsExtractor, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tsExtractor;
            this.pmtScratch = new ParsableBitArray(new byte[5]);
            this.trackIdToReaderScratch = new SparseArray<>();
            this.trackIdToPidScratch = new SparseIntArray();
            this.pid = i2;
        }

        private TsPayloadReader.EsInfo readEsInfo(ParsableByteArray parsableByteArray, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, parsableByteArray, i2)) == null) {
                int position = parsableByteArray.getPosition();
                int i3 = i2 + position;
                String str = null;
                ArrayList arrayList = null;
                int i4 = -1;
                while (parsableByteArray.getPosition() < i3) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    int position2 = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
                    if (readUnsignedByte == 5) {
                        long readUnsignedInt = parsableByteArray.readUnsignedInt();
                        if (readUnsignedInt != TsExtractor.AC3_FORMAT_IDENTIFIER) {
                            if (readUnsignedInt != TsExtractor.E_AC3_FORMAT_IDENTIFIER) {
                                if (readUnsignedInt == TsExtractor.HEVC_FORMAT_IDENTIFIER) {
                                    i4 = 36;
                                }
                            }
                            i4 = 135;
                        }
                        i4 = 129;
                    } else {
                        if (readUnsignedByte != 106) {
                            if (readUnsignedByte != 122) {
                                if (readUnsignedByte == 123) {
                                    i4 = 138;
                                } else if (readUnsignedByte == 10) {
                                    str = parsableByteArray.readString(3).trim();
                                } else if (readUnsignedByte == 89) {
                                    arrayList = new ArrayList();
                                    while (parsableByteArray.getPosition() < position2) {
                                        String trim = parsableByteArray.readString(3).trim();
                                        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                        byte[] bArr = new byte[4];
                                        parsableByteArray.readBytes(bArr, 0, 4);
                                        arrayList.add(new TsPayloadReader.DvbSubtitleInfo(trim, readUnsignedByte2, bArr));
                                    }
                                    i4 = 89;
                                }
                            }
                            i4 = 135;
                        }
                        i4 = 129;
                    }
                    parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                }
                parsableByteArray.setPosition(i3);
                return new TsPayloadReader.EsInfo(i4, str, arrayList, Arrays.copyOfRange(parsableByteArray.data, position, i3));
            }
            return (TsPayloadReader.EsInfo) invokeLI.objValue;
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void consume(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, parsableByteArray) == null) && parsableByteArray.readUnsignedByte() == 2) {
                if (this.this$0.mode == 1 || this.this$0.mode == 2 || this.this$0.remainingPmts == 1) {
                    timestampAdjuster = (TimestampAdjuster) this.this$0.timestampAdjusters.get(0);
                } else {
                    timestampAdjuster = new TimestampAdjuster(((TimestampAdjuster) this.this$0.timestampAdjusters.get(0)).getFirstSampleTimestampUs());
                    this.this$0.timestampAdjusters.add(timestampAdjuster);
                }
                parsableByteArray.skipBytes(2);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                int i2 = 5;
                parsableByteArray.skipBytes(5);
                parsableByteArray.readBytes(this.pmtScratch, 2);
                int i3 = 4;
                this.pmtScratch.skipBits(4);
                parsableByteArray.skipBytes(this.pmtScratch.readBits(12));
                if (this.this$0.mode == 2 && this.this$0.id3Reader == null) {
                    TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(21, null, null, new byte[0]);
                    TsExtractor tsExtractor = this.this$0;
                    tsExtractor.id3Reader = tsExtractor.payloadReaderFactory.createPayloadReader(21, esInfo);
                    this.this$0.id3Reader.init(timestampAdjuster, this.this$0.output, new TsPayloadReader.TrackIdGenerator(readUnsignedShort, 21, 8192));
                }
                this.trackIdToReaderScratch.clear();
                this.trackIdToPidScratch.clear();
                int bytesLeft = parsableByteArray.bytesLeft();
                while (bytesLeft > 0) {
                    parsableByteArray.readBytes(this.pmtScratch, i2);
                    int readBits = this.pmtScratch.readBits(8);
                    this.pmtScratch.skipBits(3);
                    int readBits2 = this.pmtScratch.readBits(13);
                    this.pmtScratch.skipBits(i3);
                    int readBits3 = this.pmtScratch.readBits(12);
                    TsPayloadReader.EsInfo readEsInfo = readEsInfo(parsableByteArray, readBits3);
                    if (readBits == 6) {
                        readBits = readEsInfo.streamType;
                    }
                    bytesLeft -= readBits3 + 5;
                    int i4 = this.this$0.mode == 2 ? readBits : readBits2;
                    if (!this.this$0.trackIds.get(i4)) {
                        TsPayloadReader createPayloadReader = (this.this$0.mode == 2 && readBits == 21) ? this.this$0.id3Reader : this.this$0.payloadReaderFactory.createPayloadReader(readBits, readEsInfo);
                        if (this.this$0.mode != 2 || readBits2 < this.trackIdToPidScratch.get(i4, 8192)) {
                            this.trackIdToPidScratch.put(i4, readBits2);
                            this.trackIdToReaderScratch.put(i4, createPayloadReader);
                        }
                    }
                    i2 = 5;
                    i3 = 4;
                }
                int size = this.trackIdToPidScratch.size();
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = this.trackIdToPidScratch.keyAt(i5);
                    this.this$0.trackIds.put(keyAt, true);
                    TsPayloadReader valueAt = this.trackIdToReaderScratch.valueAt(i5);
                    if (valueAt != null) {
                        if (valueAt != this.this$0.id3Reader) {
                            valueAt.init(timestampAdjuster, this.this$0.output, new TsPayloadReader.TrackIdGenerator(readUnsignedShort, keyAt, 8192));
                        }
                        this.this$0.tsPayloadReaders.put(this.trackIdToPidScratch.valueAt(i5), valueAt);
                    }
                }
                if (this.this$0.mode == 2) {
                    if (this.this$0.tracksEnded) {
                        return;
                    }
                    this.this$0.output.endTracks();
                    this.this$0.remainingPmts = 0;
                    this.this$0.tracksEnded = true;
                    return;
                }
                this.this$0.tsPayloadReaders.remove(this.pid);
                TsExtractor tsExtractor2 = this.this$0;
                tsExtractor2.remainingPmts = tsExtractor2.mode != 1 ? this.this$0.remainingPmts - 1 : 0;
                if (this.this$0.remainingPmts == 0) {
                    this.this$0.output.endTracks();
                    this.this$0.tracksEnded = true;
                }
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, timestampAdjuster, extractorOutput, trackIdGenerator) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1687203037, "Lcom/google/android/exoplayer2/extractor/ts/TsExtractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1687203037, "Lcom/google/android/exoplayer2/extractor/ts/TsExtractor;");
                return;
            }
        }
        FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ts.TsExtractor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
            public Extractor[] createExtractors() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Extractor[]{new TsExtractor()} : (Extractor[]) invokeV.objValue;
            }
        };
        AC3_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("AC-3");
        E_AC3_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("EAC3");
        HEVC_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("HEVC");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TsExtractor() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ int access$108(TsExtractor tsExtractor) {
        int i2 = tsExtractor.remainingPmts;
        tsExtractor.remainingPmts = i2 + 1;
        return i2;
    }

    private void resetPayloadReaders() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            this.trackIds.clear();
            this.tsPayloadReaders.clear();
            SparseArray<TsPayloadReader> createInitialPayloadReaders = this.payloadReaderFactory.createInitialPayloadReaders();
            int size = createInitialPayloadReaders.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.tsPayloadReaders.put(createInitialPayloadReaders.keyAt(i2), createInitialPayloadReaders.valueAt(i2));
            }
            this.tsPayloadReaders.put(0, new SectionReader(new PatReader(this)));
            this.id3Reader = null;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, extractorOutput) == null) {
            this.output = extractorOutput;
            extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorInput, positionHolder)) == null) {
            ParsableByteArray parsableByteArray = this.tsPacketBuffer;
            byte[] bArr = parsableByteArray.data;
            if (9400 - parsableByteArray.getPosition() < 188) {
                int bytesLeft = this.tsPacketBuffer.bytesLeft();
                if (bytesLeft > 0) {
                    System.arraycopy(bArr, this.tsPacketBuffer.getPosition(), bArr, 0, bytesLeft);
                }
                this.tsPacketBuffer.reset(bArr, bytesLeft);
            }
            while (this.tsPacketBuffer.bytesLeft() < 188) {
                int limit = this.tsPacketBuffer.limit();
                int read = extractorInput.read(bArr, limit, 9400 - limit);
                if (read == -1) {
                    return -1;
                }
                this.tsPacketBuffer.setLimit(limit + read);
            }
            int limit2 = this.tsPacketBuffer.limit();
            int position = this.tsPacketBuffer.getPosition();
            while (position < limit2 && bArr[position] != 71) {
                position++;
            }
            this.tsPacketBuffer.setPosition(position);
            int i2 = position + 188;
            if (i2 > limit2) {
                return 0;
            }
            int readInt = this.tsPacketBuffer.readInt();
            if ((8388608 & readInt) != 0) {
                this.tsPacketBuffer.setPosition(i2);
                return 0;
            }
            boolean z = (4194304 & readInt) != 0;
            int i3 = (2096896 & readInt) >> 8;
            boolean z2 = (readInt & 32) != 0;
            TsPayloadReader tsPayloadReader = (readInt & 16) != 0 ? this.tsPayloadReaders.get(i3) : null;
            if (tsPayloadReader == null) {
                this.tsPacketBuffer.setPosition(i2);
                return 0;
            }
            if (this.mode != 2) {
                int i4 = readInt & 15;
                int i5 = this.continuityCounters.get(i3, i4 - 1);
                this.continuityCounters.put(i3, i4);
                if (i5 == i4) {
                    this.tsPacketBuffer.setPosition(i2);
                    return 0;
                } else if (i4 != ((i5 + 1) & 15)) {
                    tsPayloadReader.seek();
                }
            }
            if (z2) {
                this.tsPacketBuffer.skipBytes(this.tsPacketBuffer.readUnsignedByte());
            }
            this.tsPacketBuffer.setLimit(i2);
            tsPayloadReader.consume(this.tsPacketBuffer, z);
            this.tsPacketBuffer.setLimit(limit2);
            this.tsPacketBuffer.setPosition(i2);
            return 0;
        }
        return invokeLL.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            int size = this.timestampAdjusters.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.timestampAdjusters.get(i2).reset();
            }
            this.tsPacketBuffer.reset();
            this.continuityCounters.clear();
            resetPayloadReaders();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        r2 = r2 + 1;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, extractorInput)) == null) {
            byte[] bArr = this.tsPacketBuffer.data;
            extractorInput.peekFully(bArr, 0, CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE);
            int i2 = 0;
            while (i2 < 188) {
                for (int i3 = 0; i3 != 5; i3++) {
                    if (bArr[(i3 * 188) + i2] != 71) {
                        break;
                    }
                }
                extractorInput.skipFully(i2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TsExtractor(int i2) {
        this(1, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TsExtractor(int i2, int i3) {
        this(i2, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(i3));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (TimestampAdjuster) objArr2[1], (TsPayloadReader.Factory) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public TsExtractor(int i2, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), timestampAdjuster, factory};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.payloadReaderFactory = (TsPayloadReader.Factory) Assertions.checkNotNull(factory);
        this.mode = i2;
        if (i2 != 1 && i2 != 2) {
            ArrayList arrayList = new ArrayList();
            this.timestampAdjusters = arrayList;
            arrayList.add(timestampAdjuster);
        } else {
            this.timestampAdjusters = Collections.singletonList(timestampAdjuster);
        }
        this.tsPacketBuffer = new ParsableByteArray((int) BUFFER_SIZE);
        this.trackIds = new SparseBooleanArray();
        this.tsPayloadReaders = new SparseArray<>();
        this.continuityCounters = new SparseIntArray();
        resetPayloadReaders();
    }
}
