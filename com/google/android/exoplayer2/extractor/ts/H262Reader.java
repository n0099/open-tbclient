package com.google.android.exoplayer2.extractor.ts;

import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class H262Reader implements ElementaryStreamReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double[] FRAME_RATE_VALUES;
    public static final int START_EXTENSION = 181;
    public static final int START_GROUP = 184;
    public static final int START_PICTURE = 0;
    public static final int START_SEQUENCE_HEADER = 179;
    public transient /* synthetic */ FieldHolder $fh;
    public final CsdBuffer csdBuffer;
    public String formatId;
    public long frameDurationUs;
    public boolean hasOutputFormat;
    public TrackOutput output;
    public long pesTimeUs;
    public final boolean[] prefixFlags;
    public boolean sampleHasPicture;
    public boolean sampleIsKeyframe;
    public long samplePosition;
    public long sampleTimeUs;
    public boolean startedFirstSample;
    public long totalBytesWritten;

    /* loaded from: classes6.dex */
    public static final class CsdBuffer {
        public static /* synthetic */ Interceptable $ic;
        public static final byte[] START_CODE;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] data;
        public boolean isFilling;
        public int length;
        public int sequenceExtensionPosition;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2099418907, "Lcom/google/android/exoplayer2/extractor/ts/H262Reader$CsdBuffer;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2099418907, "Lcom/google/android/exoplayer2/extractor/ts/H262Reader$CsdBuffer;");
                    return;
                }
            }
            START_CODE = new byte[]{0, 0, 1};
        }

        public CsdBuffer(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.data = new byte[i];
        }

        public void onData(byte[] bArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, bArr, i, i2) == null) && this.isFilling) {
                int i3 = i2 - i;
                byte[] bArr2 = this.data;
                int length = bArr2.length;
                int i4 = this.length;
                if (length < i4 + i3) {
                    this.data = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.data, this.length, i3);
                this.length += i3;
            }
        }

        public boolean onStartCode(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
                if (this.isFilling) {
                    int i3 = this.length - i2;
                    this.length = i3;
                    if (this.sequenceExtensionPosition == 0 && i == 181) {
                        this.sequenceExtensionPosition = i3;
                    } else {
                        this.isFilling = false;
                        return true;
                    }
                } else if (i == 179) {
                    this.isFilling = true;
                }
                byte[] bArr = START_CODE;
                onData(bArr, 0, bArr.length);
                return false;
            }
            return invokeII.booleanValue;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.isFilling = false;
                this.length = 0;
                this.sequenceExtensionPosition = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1400851285, "Lcom/google/android/exoplayer2/extractor/ts/H262Reader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1400851285, "Lcom/google/android/exoplayer2/extractor/ts/H262Reader;");
                return;
            }
        }
        FRAME_RATE_VALUES = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    }

    public H262Reader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.prefixFlags = new boolean[4];
        this.csdBuffer = new CsdBuffer(128);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Format, Long> parseCsdBuffer(CsdBuffer csdBuffer, String str) {
        InterceptResult invokeLL;
        float f2;
        int i;
        float f3;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, csdBuffer, str)) == null) {
            byte[] copyOf = Arrays.copyOf(csdBuffer.data, csdBuffer.length);
            int i4 = copyOf[5] & 255;
            int i5 = ((copyOf[4] & 255) << 4) | (i4 >> 4);
            int i6 = ((i4 & 15) << 8) | (copyOf[6] & 255);
            int i7 = (copyOf[7] & 240) >> 4;
            if (i7 == 2) {
                f2 = i6 * 4;
                i = i5 * 3;
            } else if (i7 == 3) {
                f2 = i6 * 16;
                i = i5 * 9;
            } else if (i7 != 4) {
                f3 = 1.0f;
                Format createVideoSampleFormat = Format.createVideoSampleFormat(str, MimeTypes.VIDEO_MPEG2, null, -1, -1, i5, i6, -1.0f, Collections.singletonList(copyOf), -1, f3, null);
                long j = 0;
                i2 = (copyOf[7] & 15) - 1;
                if (i2 >= 0) {
                    double[] dArr = FRAME_RATE_VALUES;
                    if (i2 < dArr.length) {
                        double d2 = dArr[i2];
                        int i8 = csdBuffer.sequenceExtensionPosition + 9;
                        int i9 = (copyOf[i8] & 96) >> 5;
                        if (i9 != (copyOf[i8] & 31)) {
                            d2 *= (i9 + 1.0d) / (i3 + 1);
                        }
                        j = (long) (1000000.0d / d2);
                    }
                }
                return Pair.create(createVideoSampleFormat, Long.valueOf(j));
            } else {
                f2 = i6 * 121;
                i = i5 * 100;
            }
            f3 = f2 / i;
            Format createVideoSampleFormat2 = Format.createVideoSampleFormat(str, MimeTypes.VIDEO_MPEG2, null, -1, -1, i5, i6, -1.0f, Collections.singletonList(copyOf), -1, f3, null);
            long j2 = 0;
            i2 = (copyOf[7] & 15) - 1;
            if (i2 >= 0) {
            }
            return Pair.create(createVideoSampleFormat2, Long.valueOf(j2));
        }
        return (Pair) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, parsableByteArray) == null) {
            int position = parsableByteArray.getPosition();
            int limit = parsableByteArray.limit();
            byte[] bArr = parsableByteArray.data;
            this.totalBytesWritten += parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
            while (true) {
                int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
                if (findNalUnit == limit) {
                    break;
                }
                int i = findNalUnit + 3;
                int i2 = parsableByteArray.data[i] & 255;
                if (!this.hasOutputFormat) {
                    int i3 = findNalUnit - position;
                    if (i3 > 0) {
                        this.csdBuffer.onData(bArr, position, findNalUnit);
                    }
                    if (this.csdBuffer.onStartCode(i2, i3 < 0 ? -i3 : 0)) {
                        Pair<Format, Long> parseCsdBuffer = parseCsdBuffer(this.csdBuffer, this.formatId);
                        this.output.format((Format) parseCsdBuffer.first);
                        this.frameDurationUs = ((Long) parseCsdBuffer.second).longValue();
                        this.hasOutputFormat = true;
                    }
                }
                if (i2 == 0 || i2 == 179) {
                    int i4 = limit - findNalUnit;
                    if (this.startedFirstSample && this.sampleHasPicture && this.hasOutputFormat) {
                        this.output.sampleMetadata(this.sampleTimeUs, this.sampleIsKeyframe ? 1 : 0, ((int) (this.totalBytesWritten - this.samplePosition)) - i4, i4, null);
                    }
                    if (!this.startedFirstSample || this.sampleHasPicture) {
                        this.samplePosition = this.totalBytesWritten - i4;
                        long j = this.pesTimeUs;
                        if (j == C.TIME_UNSET) {
                            j = this.startedFirstSample ? this.sampleTimeUs + this.frameDurationUs : 0L;
                        }
                        this.sampleTimeUs = j;
                        this.sampleIsKeyframe = false;
                        this.pesTimeUs = C.TIME_UNSET;
                        this.startedFirstSample = true;
                    }
                    this.sampleHasPicture = i2 == 0;
                } else if (i2 == 184) {
                    this.sampleIsKeyframe = true;
                }
                position = i;
            }
            if (this.hasOutputFormat) {
                return;
            }
            this.csdBuffer.onData(bArr, position, limit);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorOutput, trackIdGenerator) == null) {
            trackIdGenerator.generateNewId();
            this.formatId = trackIdGenerator.getFormatId();
            this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.pesTimeUs = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NalUnitUtil.clearPrefixFlags(this.prefixFlags);
            this.csdBuffer.reset();
            this.totalBytesWritten = 0L;
            this.startedFirstSample = false;
        }
    }
}
