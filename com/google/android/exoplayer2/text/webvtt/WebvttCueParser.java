package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCue;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class WebvttCueParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final char CHAR_AMPERSAND = '&';
    public static final char CHAR_GREATER_THAN = '>';
    public static final char CHAR_LESS_THAN = '<';
    public static final char CHAR_SEMI_COLON = ';';
    public static final char CHAR_SLASH = '/';
    public static final char CHAR_SPACE = ' ';
    public static final Pattern CUE_HEADER_PATTERN;
    public static final Pattern CUE_SETTING_PATTERN;
    public static final String ENTITY_AMPERSAND = "amp";
    public static final String ENTITY_GREATER_THAN = "gt";
    public static final String ENTITY_LESS_THAN = "lt";
    public static final String ENTITY_NON_BREAK_SPACE = "nbsp";
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_ITALIC = 2;
    public static final String TAG = "WebvttCueParser";
    public static final String TAG_BOLD = "b";
    public static final String TAG_CLASS = "c";
    public static final String TAG_ITALIC = "i";
    public static final String TAG_LANG = "lang";
    public static final String TAG_UNDERLINE = "u";
    public static final String TAG_VOICE = "v";
    public transient /* synthetic */ FieldHolder $fh;
    public final StringBuilder textBuilder;

    /* loaded from: classes4.dex */
    public static final class StartTag {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] NO_CLASSES;
        public transient /* synthetic */ FieldHolder $fh;
        public final String[] classes;
        public final String name;
        public final int position;
        public final String voice;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-421939642, "Lcom/google/android/exoplayer2/text/webvtt/WebvttCueParser$StartTag;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-421939642, "Lcom/google/android/exoplayer2/text/webvtt/WebvttCueParser$StartTag;");
                    return;
                }
            }
            NO_CLASSES = new String[0];
        }

        public StartTag(String str, int i, String str2, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, strArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.position = i;
            this.name = str;
            this.voice = str2;
            this.classes = strArr;
        }

        public static StartTag buildStartTag(String str, int i) {
            InterceptResult invokeLI;
            String str2;
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
                String trim = str.trim();
                if (trim.isEmpty()) {
                    return null;
                }
                int indexOf = trim.indexOf(" ");
                if (indexOf == -1) {
                    str2 = "";
                } else {
                    String trim2 = trim.substring(indexOf).trim();
                    trim = trim.substring(0, indexOf);
                    str2 = trim2;
                }
                String[] split = trim.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String str3 = split[0];
                if (split.length > 1) {
                    strArr = (String[]) Arrays.copyOfRange(split, 1, split.length);
                } else {
                    strArr = NO_CLASSES;
                }
                return new StartTag(str3, i, str2, strArr);
            }
            return (StartTag) invokeLI.objValue;
        }

        public static StartTag buildWholeCueVirtualTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new StartTag("", 0, "", new String[0]) : (StartTag) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class StyleMatch implements Comparable<StyleMatch> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int score;
        public final WebvttCssStyle style;

        public StyleMatch(int i, WebvttCssStyle webvttCssStyle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), webvttCssStyle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.score = i;
            this.style = webvttCssStyle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull StyleMatch styleMatch) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, styleMatch)) == null) ? this.score - styleMatch.score : invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1001903540, "Lcom/google/android/exoplayer2/text/webvtt/WebvttCueParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1001903540, "Lcom/google/android/exoplayer2/text/webvtt/WebvttCueParser;");
                return;
            }
        }
        CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
        CUE_SETTING_PATTERN = Pattern.compile("(\\S+?):(\\S+)");
    }

    public WebvttCueParser() {
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
        this.textBuilder = new StringBuilder();
    }

    public static void applyEntity(String str, SpannableStringBuilder spannableStringBuilder) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, spannableStringBuilder) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 3309) {
                if (str.equals(ENTITY_GREATER_THAN)) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode == 3464) {
                if (str.equals(ENTITY_LESS_THAN)) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode != 96708) {
                if (hashCode == 3374865 && str.equals(ENTITY_NON_BREAK_SPACE)) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (str.equals(ENTITY_AMPERSAND)) {
                    c = 3;
                }
                c = 65535;
            }
            if (c == 0) {
                spannableStringBuilder.append('<');
            } else if (c == 1) {
                spannableStringBuilder.append('>');
            } else if (c == 2) {
                spannableStringBuilder.append(CHAR_SPACE);
            } else if (c != 3) {
                Log.w(TAG, "ignoring unsupported entity: '&" + str + ";'");
            } else {
                spannableStringBuilder.append('&');
            }
        }
    }

    public static void applySpansForTag(String str, StartTag startTag, SpannableStringBuilder spannableStringBuilder, List<WebvttCssStyle> list, List<StyleMatch> list2) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, str, startTag, spannableStringBuilder, list, list2) == null) {
            int i = startTag.position;
            int length = spannableStringBuilder.length();
            String str2 = startTag.name;
            int hashCode = str2.hashCode();
            if (hashCode == 0) {
                if (str2.equals("")) {
                    c = 6;
                }
                c = 65535;
            } else if (hashCode == 105) {
                if (str2.equals("i")) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode == 3314158) {
                if (str2.equals(TAG_LANG)) {
                    c = 4;
                }
                c = 65535;
            } else if (hashCode == 98) {
                if (str2.equals("b")) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode == 99) {
                if (str2.equals("c")) {
                    c = 3;
                }
                c = 65535;
            } else if (hashCode != 117) {
                if (hashCode == 118 && str2.equals("v")) {
                    c = 5;
                }
                c = 65535;
            } else {
                if (str2.equals("u")) {
                    c = 2;
                }
                c = 65535;
            }
            switch (c) {
                case 0:
                    spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                    break;
                case 1:
                    spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                    break;
                case 2:
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    return;
            }
            list2.clear();
            getApplicableStyles(list, str, startTag, list2);
            int size = list2.size();
            for (int i2 = 0; i2 < size; i2++) {
                applyStyleToText(spannableStringBuilder, list2.get(i2).style, i, length);
            }
        }
    }

    public static void applyStyleToText(SpannableStringBuilder spannableStringBuilder, WebvttCssStyle webvttCssStyle, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, spannableStringBuilder, webvttCssStyle, i, i2) == null) || webvttCssStyle == null) {
            return;
        }
        if (webvttCssStyle.getStyle() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(webvttCssStyle.getStyle()), i, i2, 33);
        }
        if (webvttCssStyle.isLinethrough()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (webvttCssStyle.isUnderline()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (webvttCssStyle.hasFontColor()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(webvttCssStyle.getFontColor()), i, i2, 33);
        }
        if (webvttCssStyle.hasBackgroundColor()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(webvttCssStyle.getBackgroundColor()), i, i2, 33);
        }
        if (webvttCssStyle.getFontFamily() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(webvttCssStyle.getFontFamily()), i, i2, 33);
        }
        if (webvttCssStyle.getTextAlign() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(webvttCssStyle.getTextAlign()), i, i2, 33);
        }
        int fontSizeUnit = webvttCssStyle.getFontSizeUnit();
        if (fontSizeUnit == 1) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) webvttCssStyle.getFontSize(), true), i, i2, 33);
        } else if (fontSizeUnit == 2) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(webvttCssStyle.getFontSize()), i, i2, 33);
        } else if (fontSizeUnit != 3) {
        } else {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(webvttCssStyle.getFontSize() / 100.0f), i, i2, 33);
        }
    }

    public static int findEndOfTag(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i)) == null) {
            int indexOf = str.indexOf(62, i);
            return indexOf == -1 ? str.length() : indexOf + 1;
        }
        return invokeLI.intValue;
    }

    public static void getApplicableStyles(List<WebvttCssStyle> list, String str, StartTag startTag, List<StyleMatch> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, list, str, startTag, list2) == null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                WebvttCssStyle webvttCssStyle = list.get(i);
                int specificityScore = webvttCssStyle.getSpecificityScore(str, startTag.name, startTag.classes, startTag.voice);
                if (specificityScore > 0) {
                    list2.add(new StyleMatch(specificityScore, webvttCssStyle));
                }
            }
            Collections.sort(list2);
        }
    }

    public static String getTagName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return null;
            }
            return trim.split("[ \\.]")[0];
        }
        return (String) invokeL.objValue;
    }

    public static boolean isSupportedTag(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 98) {
                if (str.equals("b")) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode == 99) {
                if (str.equals("c")) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode == 105) {
                if (str.equals("i")) {
                    c = 2;
                }
                c = 65535;
            } else if (hashCode == 3314158) {
                if (str.equals(TAG_LANG)) {
                    c = 3;
                }
                c = 65535;
            } else if (hashCode != 117) {
                if (hashCode == 118 && str.equals("v")) {
                    c = 5;
                }
                c = 65535;
            } else {
                if (str.equals("u")) {
                    c = 4;
                }
                c = 65535;
            }
            return c == 0 || c == 1 || c == 2 || c == 3 || c == 4 || c == 5;
        }
        return invokeL.booleanValue;
    }

    public static void parseCueSettingsList(String str, WebvttCue.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, builder) == null) {
            Matcher matcher = CUE_SETTING_PATTERN.matcher(str);
            while (matcher.find()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                try {
                    if ("line".equals(group)) {
                        parseLineAttribute(group2, builder);
                    } else if (ConstPath.KEY_ALIGN.equals(group)) {
                        builder.setTextAlignment(parseTextAlignment(group2));
                    } else if ("position".equals(group)) {
                        parsePositionAttribute(group2, builder);
                    } else if ("size".equals(group)) {
                        builder.setWidth(WebvttParserUtil.parsePercentage(group2));
                    } else {
                        Log.w(TAG, "Unknown cue setting " + group + ":" + group2);
                    }
                } catch (NumberFormatException unused) {
                    Log.w(TAG, "Skipping bad cue setting: " + matcher.group());
                }
            }
        }
    }

    public static void parseCueText(String str, String str2, WebvttCue.Builder builder, List<WebvttCssStyle> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65547, null, str, str2, builder, list) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Stack stack = new Stack();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                if (charAt == '&') {
                    i++;
                    int indexOf = str2.indexOf(59, i);
                    int indexOf2 = str2.indexOf(32, i);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf != -1) {
                        applyEntity(str2.substring(i, indexOf), spannableStringBuilder);
                        if (indexOf == indexOf2) {
                            spannableStringBuilder.append(" ");
                        }
                        i = indexOf + 1;
                    } else {
                        spannableStringBuilder.append(charAt);
                    }
                } else if (charAt != '<') {
                    spannableStringBuilder.append(charAt);
                    i++;
                } else {
                    int i2 = i + 1;
                    if (i2 < str2.length()) {
                        boolean z = str2.charAt(i2) == '/';
                        i2 = findEndOfTag(str2, i2);
                        int i3 = i2 - 2;
                        boolean z2 = str2.charAt(i3) == '/';
                        int i4 = i + (z ? 2 : 1);
                        if (!z2) {
                            i3 = i2 - 1;
                        }
                        String substring = str2.substring(i4, i3);
                        String tagName = getTagName(substring);
                        if (tagName != null && isSupportedTag(tagName)) {
                            if (z) {
                                while (!stack.isEmpty()) {
                                    StartTag startTag = (StartTag) stack.pop();
                                    applySpansForTag(str, startTag, spannableStringBuilder, list, arrayList);
                                    if (startTag.name.equals(tagName)) {
                                        break;
                                    }
                                }
                            } else if (!z2) {
                                stack.push(StartTag.buildStartTag(substring, spannableStringBuilder.length()));
                            }
                        }
                    }
                    i = i2;
                }
            }
            while (!stack.isEmpty()) {
                applySpansForTag(str, (StartTag) stack.pop(), spannableStringBuilder, list, arrayList);
            }
            applySpansForTag(str, StartTag.buildWholeCueVirtualTag(), spannableStringBuilder, list, arrayList);
            builder.setText(spannableStringBuilder);
        }
    }

    public static void parseLineAttribute(String str, WebvttCue.Builder builder) throws NumberFormatException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, builder) == null) {
            int indexOf = str.indexOf(44);
            if (indexOf != -1) {
                builder.setLineAnchor(parsePositionAnchor(str.substring(indexOf + 1)));
                str = str.substring(0, indexOf);
            } else {
                builder.setLineAnchor(Integer.MIN_VALUE);
            }
            if (str.endsWith("%")) {
                builder.setLine(WebvttParserUtil.parsePercentage(str)).setLineType(0);
                return;
            }
            int parseInt = Integer.parseInt(str);
            if (parseInt < 0) {
                parseInt--;
            }
            builder.setLine(parseInt).setLineType(1);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int parsePositionAnchor(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1074341483:
                    if (str.equals(NativeConstants.MIDDLE)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 100571:
                    if (str.equals("end")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c == 1 || c == 2) {
                    return 1;
                }
                if (c != 3) {
                    Log.w(TAG, "Invalid anchor value: " + str);
                    return Integer.MIN_VALUE;
                }
                return 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void parsePositionAttribute(String str, WebvttCue.Builder builder) throws NumberFormatException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, builder) == null) {
            int indexOf = str.indexOf(44);
            if (indexOf != -1) {
                builder.setPositionAnchor(parsePositionAnchor(str.substring(indexOf + 1)));
                str = str.substring(0, indexOf);
            } else {
                builder.setPositionAnchor(Integer.MIN_VALUE);
            }
            builder.setPosition(WebvttParserUtil.parsePercentage(str));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Layout.Alignment parseTextAlignment(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1074341483:
                    if (str.equals(NativeConstants.MIDDLE)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 100571:
                    if (str.equals("end")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0 || c == 1) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            if (c == 2 || c == 3) {
                return Layout.Alignment.ALIGN_CENTER;
            }
            if (c != 4 && c != 5) {
                Log.w(TAG, "Invalid alignment value: " + str);
                return null;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return (Layout.Alignment) invokeL.objValue;
    }

    public boolean parseCue(ParsableByteArray parsableByteArray, WebvttCue.Builder builder, List<WebvttCssStyle> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, parsableByteArray, builder, list)) == null) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return false;
            }
            Matcher matcher = CUE_HEADER_PATTERN.matcher(readLine);
            if (matcher.matches()) {
                return parseCue(null, matcher, parsableByteArray, builder, this.textBuilder, list);
            }
            String readLine2 = parsableByteArray.readLine();
            if (readLine2 == null) {
                return false;
            }
            Matcher matcher2 = CUE_HEADER_PATTERN.matcher(readLine2);
            if (matcher2.matches()) {
                return parseCue(readLine.trim(), matcher2, parsableByteArray, builder, this.textBuilder, list);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean parseCue(String str, Matcher matcher, ParsableByteArray parsableByteArray, WebvttCue.Builder builder, StringBuilder sb, List<WebvttCssStyle> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, matcher, parsableByteArray, builder, sb, list})) != null) {
            return invokeCommon.booleanValue;
        }
        try {
            builder.setStartTime(WebvttParserUtil.parseTimestampUs(matcher.group(1))).setEndTime(WebvttParserUtil.parseTimestampUs(matcher.group(2)));
            parseCueSettingsList(matcher.group(3), builder);
            sb.setLength(0);
            while (true) {
                String readLine = parsableByteArray.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (sb.length() > 0) {
                        sb.append("\n");
                    }
                    sb.append(readLine.trim());
                } else {
                    parseCueText(str, sb.toString(), builder, list);
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }
}
