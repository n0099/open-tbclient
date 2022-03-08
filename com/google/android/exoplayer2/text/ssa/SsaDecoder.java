package com.google.android.exoplayer2.text.ssa;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public final class SsaDecoder extends SimpleSubtitleDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIALOGUE_LINE_PREFIX = "Dialogue: ";
    public static final String FORMAT_LINE_PREFIX = "Format: ";
    public static final Pattern SSA_TIMECODE_PATTERN;
    public static final String TAG = "SsaDecoder";
    public transient /* synthetic */ FieldHolder $fh;
    public int formatEndIndex;
    public int formatKeyCount;
    public int formatStartIndex;
    public int formatTextIndex;
    public final boolean haveInitializationData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(675250598, "Lcom/google/android/exoplayer2/text/ssa/SsaDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(675250598, "Lcom/google/android/exoplayer2/text/ssa/SsaDecoder;");
                return;
            }
        }
        SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SsaDecoder() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((List) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void parseDialogueLine(String str, List<Cue> list, LongArray longArray) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, str, list, longArray) == null) {
            if (this.formatKeyCount == 0) {
                String str2 = "Skipping dialogue line before format: " + str;
                return;
            }
            String[] split = str.substring(10).split(",", this.formatKeyCount);
            long parseTimecodeUs = parseTimecodeUs(split[this.formatStartIndex]);
            if (parseTimecodeUs == C.TIME_UNSET) {
                String str3 = "Skipping invalid timing: " + str;
                return;
            }
            String str4 = split[this.formatEndIndex];
            if (str4.trim().isEmpty()) {
                j2 = -9223372036854775807L;
            } else {
                j2 = parseTimecodeUs(str4);
                if (j2 == C.TIME_UNSET) {
                    String str5 = "Skipping invalid timing: " + str;
                    return;
                }
            }
            list.add(new Cue(split[this.formatTextIndex].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", StringUtils.LF).replaceAll("\\\\n", StringUtils.LF)));
            longArray.add(parseTimecodeUs);
            if (j2 != C.TIME_UNSET) {
                list.add(null);
                longArray.add(j2);
            }
        }
    }

    private void parseEventBody(ParsableByteArray parsableByteArray, List<Cue> list, LongArray longArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, parsableByteArray, list, longArray) != null) {
            return;
        }
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
            if (!this.haveInitializationData && readLine.startsWith(FORMAT_LINE_PREFIX)) {
                parseFormatLine(readLine);
            } else if (readLine.startsWith(DIALOGUE_LINE_PREFIX)) {
                parseDialogueLine(readLine, list, longArray);
            }
        }
    }

    private void parseFormatLine(String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            String[] split = TextUtils.split(str.substring(8), ",");
            this.formatKeyCount = split.length;
            this.formatStartIndex = -1;
            this.formatEndIndex = -1;
            this.formatTextIndex = -1;
            for (int i2 = 0; i2 < this.formatKeyCount; i2++) {
                String lowerInvariant = Util.toLowerInvariant(split[i2].trim());
                int hashCode = lowerInvariant.hashCode();
                if (hashCode == 100571) {
                    if (lowerInvariant.equals("end")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else if (hashCode != 3556653) {
                    if (hashCode == 109757538 && lowerInvariant.equals("start")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else {
                    if (lowerInvariant.equals("text")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    this.formatStartIndex = i2;
                } else if (c2 == 1) {
                    this.formatEndIndex = i2;
                } else if (c2 == 2) {
                    this.formatTextIndex = i2;
                }
            }
        }
    }

    private void parseHeader(ParsableByteArray parsableByteArray) {
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, parsableByteArray) == null) {
            do {
                readLine = parsableByteArray.readLine();
                if (readLine == null) {
                    return;
                }
            } while (!readLine.startsWith("[Events]"));
        }
    }

    public static long parseTimecodeUs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            Matcher matcher = SSA_TIMECODE_PATTERN.matcher(str);
            return !matcher.matches() ? C.TIME_UNSET : (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
        }
        return invokeL.longValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SsaDecoder(List<byte[]> list) {
        super(TAG);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (list != null && !list.isEmpty()) {
            this.haveInitializationData = true;
            String str = new String(list.get(0));
            Assertions.checkArgument(str.startsWith(FORMAT_LINE_PREFIX));
            parseFormatLine(str);
            parseHeader(new ParsableByteArray(list.get(1)));
            return;
        }
        this.haveInitializationData = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public SsaSubtitle decode(byte[] bArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            LongArray longArray = new LongArray();
            ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i2);
            if (!this.haveInitializationData) {
                parseHeader(parsableByteArray);
            }
            parseEventBody(parsableByteArray, arrayList, longArray);
            Cue[] cueArr = new Cue[arrayList.size()];
            arrayList.toArray(cueArr);
            return new SsaSubtitle(cueArr, longArray.toArray());
        }
        return (SsaSubtitle) invokeCommon.objValue;
    }
}
