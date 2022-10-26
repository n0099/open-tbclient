package com.google.android.exoplayer2.text.webvtt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class WebvttParserUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern COMMENT;
    public static final Pattern HEADER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1113507215, "Lcom/google/android/exoplayer2/text/webvtt/WebvttParserUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1113507215, "Lcom/google/android/exoplayer2/text/webvtt/WebvttParserUtil;");
                return;
            }
        }
        COMMENT = Pattern.compile("^NOTE(( |\t).*)?$");
        HEADER = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");
    }

    public WebvttParserUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Matcher findNextCueHeader(ParsableByteArray parsableByteArray) {
        String readLine;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, parsableByteArray)) != null) {
            return (Matcher) invokeL.objValue;
        }
        while (true) {
            String readLine2 = parsableByteArray.readLine();
            if (readLine2 != null) {
                if (COMMENT.matcher(readLine2).matches()) {
                    do {
                        readLine = parsableByteArray.readLine();
                        if (readLine != null) {
                        }
                    } while (!readLine.isEmpty());
                } else {
                    Matcher matcher = WebvttCueParser.CUE_HEADER_PATTERN.matcher(readLine2);
                    if (matcher.matches()) {
                        return matcher;
                    }
                }
            } else {
                return null;
            }
        }
    }

    public static float parsePercentage(String str) throws NumberFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str.endsWith("%")) {
                return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
            }
            throw new NumberFormatException("Percentages must end with %");
        }
        return invokeL.floatValue;
    }

    public static void validateWebvttHeaderLine(ParsableByteArray parsableByteArray) throws SubtitleDecoderException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, parsableByteArray) == null) {
            String readLine = parsableByteArray.readLine();
            if (readLine != null && HEADER.matcher(readLine).matches()) {
                return;
            }
            throw new SubtitleDecoderException("Expected WEBVTT. Got " + readLine);
        }
    }

    public static long parseTimestampUs(String str) throws NumberFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, 2);
            long j = 0;
            for (String str2 : split[0].split(":")) {
                j = (j * 60) + Long.parseLong(str2);
            }
            long j2 = j * 1000;
            if (split.length == 2) {
                j2 += Long.parseLong(split[1]);
            }
            return j2 * 1000;
        }
        return invokeL.longValue;
    }
}
