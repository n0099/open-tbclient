package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
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
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class WebvttExtractor implements Extractor {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern LOCAL_TIMESTAMP;
    public static final Pattern MEDIA_TIMESTAMP;
    public transient /* synthetic */ FieldHolder $fh;
    public final String language;
    public ExtractorOutput output;
    public byte[] sampleData;
    public final ParsableByteArray sampleDataWrapper;
    public int sampleSize;
    public final TimestampAdjuster timestampAdjuster;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2031928239, "Lcom/google/android/exoplayer2/source/hls/WebvttExtractor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2031928239, "Lcom/google/android/exoplayer2/source/hls/WebvttExtractor;");
                return;
            }
        }
        LOCAL_TIMESTAMP = Pattern.compile("LOCAL:([^,]+)");
        MEDIA_TIMESTAMP = Pattern.compile("MPEGTS:(\\d+)");
    }

    public WebvttExtractor(String str, TimestampAdjuster timestampAdjuster) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, timestampAdjuster};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.language = str;
        this.timestampAdjuster = timestampAdjuster;
        this.sampleDataWrapper = new ParsableByteArray();
        this.sampleData = new byte[1024];
    }

    private TrackOutput buildTrackOutput(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j)) == null) {
            TrackOutput track = this.output.track(0, 3);
            track.format(Format.createTextSampleFormat((String) null, MimeTypes.TEXT_VTT, (String) null, -1, 0, this.language, (DrmInitData) null, j));
            this.output.endTracks();
            return track;
        }
        return (TrackOutput) invokeJ.objValue;
    }

    private void processSample() throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65539, this) != null) {
            return;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.sampleData);
        try {
            WebvttParserUtil.validateWebvttHeaderLine(parsableByteArray);
            long j = 0;
            long j2 = 0;
            while (true) {
                String readLine = parsableByteArray.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                        Matcher matcher = LOCAL_TIMESTAMP.matcher(readLine);
                        if (matcher.find()) {
                            Matcher matcher2 = MEDIA_TIMESTAMP.matcher(readLine);
                            if (matcher2.find()) {
                                j2 = WebvttParserUtil.parseTimestampUs(matcher.group(1));
                                j = TimestampAdjuster.ptsToUs(Long.parseLong(matcher2.group(1)));
                            } else {
                                throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + readLine);
                            }
                        } else {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + readLine);
                        }
                    }
                } else {
                    Matcher findNextCueHeader = WebvttParserUtil.findNextCueHeader(parsableByteArray);
                    if (findNextCueHeader == null) {
                        buildTrackOutput(0L);
                        return;
                    }
                    long parseTimestampUs = WebvttParserUtil.parseTimestampUs(findNextCueHeader.group(1));
                    long adjustTsTimestamp = this.timestampAdjuster.adjustTsTimestamp(TimestampAdjuster.usToPts((j + parseTimestampUs) - j2));
                    TrackOutput buildTrackOutput = buildTrackOutput(adjustTsTimestamp - parseTimestampUs);
                    this.sampleDataWrapper.reset(this.sampleData, this.sampleSize);
                    buildTrackOutput.sampleData(this.sampleDataWrapper, this.sampleSize);
                    buildTrackOutput.sampleMetadata(adjustTsTimestamp, 1, this.sampleSize, 0, null);
                    return;
                }
            }
        } catch (SubtitleDecoderException e) {
            throw new ParserException(e);
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
            int length = (int) extractorInput.getLength();
            int i = this.sampleSize;
            byte[] bArr = this.sampleData;
            if (i == bArr.length) {
                this.sampleData = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
            }
            byte[] bArr2 = this.sampleData;
            int i2 = this.sampleSize;
            int read = extractorInput.read(bArr2, i2, bArr2.length - i2);
            if (read != -1) {
                int i3 = this.sampleSize + read;
                this.sampleSize = i3;
                if (length == -1 || i3 != length) {
                    return 0;
                }
            }
            processSample();
            return -1;
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
    public void seek(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            throw new IllegalStateException();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, extractorInput)) == null) {
            throw new IllegalStateException();
        }
        return invokeL.booleanValue;
    }
}
