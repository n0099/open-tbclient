package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class CssParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BLOCK_END = "}";
    public static final String BLOCK_START = "{";
    public static final String PROPERTY_BGCOLOR = "background-color";
    public static final String PROPERTY_FONT_FAMILY = "font-family";
    public static final String PROPERTY_FONT_STYLE = "font-style";
    public static final String PROPERTY_FONT_WEIGHT = "font-weight";
    public static final String PROPERTY_TEXT_DECORATION = "text-decoration";
    public static final String VALUE_BOLD = "bold";
    public static final String VALUE_ITALIC = "italic";
    public static final String VALUE_UNDERLINE = "underline";
    public static final Pattern VOICE_NAME_PATTERN;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringBuilder stringBuilder;
    public final ParsableByteArray styleInput;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-325322910, "Lcom/google/android/exoplayer2/text/webvtt/CssParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-325322910, "Lcom/google/android/exoplayer2/text/webvtt/CssParser;");
                return;
            }
        }
        VOICE_NAME_PATTERN = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    }

    public CssParser() {
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
        this.styleInput = new ParsableByteArray();
        this.stringBuilder = new StringBuilder();
    }

    private void applySelectorToStyle(WebvttCssStyle webvttCssStyle, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, webvttCssStyle, str) == null) || "".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            Matcher matcher = VOICE_NAME_PATTERN.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                webvttCssStyle.setTargetVoice(matcher.group(1));
            }
            str = str.substring(0, indexOf);
        }
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        String str2 = split[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            webvttCssStyle.setTargetTagName(str2.substring(0, indexOf2));
            webvttCssStyle.setTargetId(str2.substring(indexOf2 + 1));
        } else {
            webvttCssStyle.setTargetTagName(str2);
        }
        if (split.length > 1) {
            webvttCssStyle.setTargetClasses((String[]) Arrays.copyOfRange(split, 1, split.length));
        }
    }

    public static boolean maybeSkipComment(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, parsableByteArray)) != null) {
            return invokeL.booleanValue;
        }
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] bArr = parsableByteArray.data;
        if (position + 2 > limit) {
            return false;
        }
        int i = position + 1;
        if (bArr[position] != 47) {
            return false;
        }
        int i2 = i + 1;
        if (bArr[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 < limit) {
                if (((char) bArr[i2]) == '*' && ((char) bArr[i3]) == '/') {
                    i2 = i3 + 1;
                    limit = i2;
                } else {
                    i2 = i3;
                }
            } else {
                parsableByteArray.skipBytes(limit - parsableByteArray.getPosition());
                return true;
            }
        }
    }

    public static boolean maybeSkipWhitespace(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray)) == null) {
            char peekCharAtPosition = peekCharAtPosition(parsableByteArray, parsableByteArray.getPosition());
            if (peekCharAtPosition == '\t' || peekCharAtPosition == '\n' || peekCharAtPosition == '\f' || peekCharAtPosition == '\r' || peekCharAtPosition == ' ') {
                parsableByteArray.skipBytes(1);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String parseIdentifier(ParsableByteArray parsableByteArray, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, parsableByteArray, sb)) == null) {
            boolean z = false;
            sb.setLength(0);
            int position = parsableByteArray.getPosition();
            int limit = parsableByteArray.limit();
            while (position < limit && !z) {
                char c = (char) parsableByteArray.data[position];
                if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                    z = true;
                } else {
                    position++;
                    sb.append(c);
                }
            }
            parsableByteArray.skipBytes(position - parsableByteArray.getPosition());
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String parseNextToken(ParsableByteArray parsableByteArray, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, parsableByteArray, sb)) == null) {
            skipWhitespaceAndComments(parsableByteArray);
            if (parsableByteArray.bytesLeft() == 0) {
                return null;
            }
            String parseIdentifier = parseIdentifier(parsableByteArray, sb);
            if ("".equals(parseIdentifier)) {
                return "" + ((char) parsableByteArray.readUnsignedByte());
            }
            return parseIdentifier;
        }
        return (String) invokeLL.objValue;
    }

    public static String parsePropertyValue(ParsableByteArray parsableByteArray, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, parsableByteArray, sb)) == null) {
            StringBuilder sb2 = new StringBuilder();
            boolean z = false;
            while (!z) {
                int position = parsableByteArray.getPosition();
                String parseNextToken = parseNextToken(parsableByteArray, sb);
                if (parseNextToken == null) {
                    return null;
                }
                if (!"}".equals(parseNextToken) && !";".equals(parseNextToken)) {
                    sb2.append(parseNextToken);
                } else {
                    parsableByteArray.setPosition(position);
                    z = true;
                }
            }
            return sb2.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String parseSelector(ParsableByteArray parsableByteArray, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, parsableByteArray, sb)) == null) {
            skipWhitespaceAndComments(parsableByteArray);
            if (parsableByteArray.bytesLeft() >= 5 && "::cue".equals(parsableByteArray.readString(5))) {
                int position = parsableByteArray.getPosition();
                String parseNextToken = parseNextToken(parsableByteArray, sb);
                if (parseNextToken == null) {
                    return null;
                }
                if ("{".equals(parseNextToken)) {
                    parsableByteArray.setPosition(position);
                    return "";
                }
                String readCueTarget = "(".equals(parseNextToken) ? readCueTarget(parsableByteArray) : null;
                String parseNextToken2 = parseNextToken(parsableByteArray, sb);
                if (!SmallTailInfo.EMOTION_SUFFIX.equals(parseNextToken2) || parseNextToken2 == null) {
                    return null;
                }
                return readCueTarget;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void parseStyleDeclaration(ParsableByteArray parsableByteArray, WebvttCssStyle webvttCssStyle, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, parsableByteArray, webvttCssStyle, sb) == null) {
            skipWhitespaceAndComments(parsableByteArray);
            String parseIdentifier = parseIdentifier(parsableByteArray, sb);
            if (!"".equals(parseIdentifier) && ":".equals(parseNextToken(parsableByteArray, sb))) {
                skipWhitespaceAndComments(parsableByteArray);
                String parsePropertyValue = parsePropertyValue(parsableByteArray, sb);
                if (parsePropertyValue == null || "".equals(parsePropertyValue)) {
                    return;
                }
                int position = parsableByteArray.getPosition();
                String parseNextToken = parseNextToken(parsableByteArray, sb);
                if (!";".equals(parseNextToken)) {
                    if (!"}".equals(parseNextToken)) {
                        return;
                    }
                    parsableByteArray.setPosition(position);
                }
                if ("color".equals(parseIdentifier)) {
                    webvttCssStyle.setFontColor(ColorParser.parseCssColor(parsePropertyValue));
                } else if ("background-color".equals(parseIdentifier)) {
                    webvttCssStyle.setBackgroundColor(ColorParser.parseCssColor(parsePropertyValue));
                } else if ("text-decoration".equals(parseIdentifier)) {
                    if ("underline".equals(parsePropertyValue)) {
                        webvttCssStyle.setUnderline(true);
                    }
                } else if (PROPERTY_FONT_FAMILY.equals(parseIdentifier)) {
                    webvttCssStyle.setFontFamily(parsePropertyValue);
                } else if ("font-weight".equals(parseIdentifier)) {
                    if ("bold".equals(parsePropertyValue)) {
                        webvttCssStyle.setBold(true);
                    }
                } else if ("font-style".equals(parseIdentifier) && "italic".equals(parsePropertyValue)) {
                    webvttCssStyle.setItalic(true);
                }
            }
        }
    }

    public static char peekCharAtPosition(ParsableByteArray parsableByteArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, parsableByteArray, i)) == null) ? (char) parsableByteArray.data[i] : invokeLI.charValue;
    }

    public static String readCueTarget(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, parsableByteArray)) == null) {
            int position = parsableByteArray.getPosition();
            int limit = parsableByteArray.limit();
            boolean z = false;
            while (position < limit && !z) {
                int i = position + 1;
                z = ((char) parsableByteArray.data[position]) == ')';
                position = i;
            }
            return parsableByteArray.readString((position - 1) - parsableByteArray.getPosition()).trim();
        }
        return (String) invokeL.objValue;
    }

    public static void skipStyleBlock(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, parsableByteArray) == null) {
            do {
            } while (!TextUtils.isEmpty(parsableByteArray.readLine()));
        }
    }

    public static void skipWhitespaceAndComments(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, parsableByteArray) == null) {
            while (true) {
                for (boolean z = true; parsableByteArray.bytesLeft() > 0 && z; z = false) {
                    if (!maybeSkipWhitespace(parsableByteArray) && !maybeSkipComment(parsableByteArray)) {
                    }
                }
                return;
            }
        }
    }

    public WebvttCssStyle parseBlock(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parsableByteArray)) == null) {
            this.stringBuilder.setLength(0);
            int position = parsableByteArray.getPosition();
            skipStyleBlock(parsableByteArray);
            this.styleInput.reset(parsableByteArray.data, parsableByteArray.getPosition());
            this.styleInput.setPosition(position);
            String parseSelector = parseSelector(this.styleInput, this.stringBuilder);
            if (parseSelector == null || !"{".equals(parseNextToken(this.styleInput, this.stringBuilder))) {
                return null;
            }
            WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
            applySelectorToStyle(webvttCssStyle, parseSelector);
            String str = null;
            boolean z = false;
            while (!z) {
                int position2 = this.styleInput.getPosition();
                str = parseNextToken(this.styleInput, this.stringBuilder);
                boolean z2 = str == null || "}".equals(str);
                if (!z2) {
                    this.styleInput.setPosition(position2);
                    parseStyleDeclaration(this.styleInput, webvttCssStyle, this.stringBuilder);
                }
                z = z2;
            }
            if ("}".equals(str)) {
                return webvttCssStyle;
            }
            return null;
        }
        return (WebvttCssStyle) invokeL.objValue;
    }
}
