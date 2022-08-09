package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import android.util.Log;
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
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes5.dex */
public final class TtmlDecoder extends SimpleSubtitleDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ATTR_BEGIN = "begin";
    public static final String ATTR_DURATION = "dur";
    public static final String ATTR_END = "end";
    public static final String ATTR_REGION = "region";
    public static final String ATTR_STYLE = "style";
    public static final Pattern CLOCK_TIME;
    public static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE;
    public static final int DEFAULT_FRAME_RATE = 30;
    public static final Pattern FONT_SIZE;
    public static final Pattern OFFSET_TIME;
    public static final Pattern PERCENTAGE_COORDINATES;
    public static final String TAG = "TtmlDecoder";
    public static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    public transient /* synthetic */ FieldHolder $fh;
    public final XmlPullParserFactory xmlParserFactory;

    /* loaded from: classes5.dex */
    public static final class FrameAndTickRate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float effectiveFrameRate;
        public final int subFrameRate;
        public final int tickRate;

        public FrameAndTickRate(float f, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.effectiveFrameRate = f;
            this.subFrameRate = i;
            this.tickRate = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1811844610, "Lcom/google/android/exoplayer2/text/ttml/TtmlDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1811844610, "Lcom/google/android/exoplayer2/text/ttml/TtmlDecoder;");
                return;
            }
        }
        CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
        OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
        FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
        PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
        DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TtmlDecoder() {
        super(TAG);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    private TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, ttmlStyle)) == null) ? ttmlStyle == null ? new TtmlStyle() : ttmlStyle : (TtmlStyle) invokeL.objValue;
    }

    public static boolean isSupportedTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str.equals("tt") || str.equals("head") || str.equals(TtmlNode.TAG_BODY) || str.equals(TtmlNode.TAG_DIV) || str.equals("p") || str.equals(TtmlNode.TAG_SPAN) || str.equals(TtmlNode.TAG_BR) || str.equals("style") || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals("region") || str.equals(TtmlNode.TAG_METADATA) || str.equals(TtmlNode.TAG_SMPTE_IMAGE) || str.equals(TtmlNode.TAG_SMPTE_DATA) || str.equals(TtmlNode.TAG_SMPTE_INFORMATION) : invokeL.booleanValue;
    }

    public static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, ttmlStyle) == null) {
            String[] split = str.split("\\s+");
            if (split.length == 1) {
                matcher = FONT_SIZE.matcher(str);
            } else if (split.length == 2) {
                matcher = FONT_SIZE.matcher(split[1]);
                Log.w(TAG, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
            } else {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
            }
            if (matcher.matches()) {
                String group = matcher.group(3);
                char c = 65535;
                int hashCode = group.hashCode();
                if (hashCode != 37) {
                    if (hashCode != 3240) {
                        if (hashCode == 3592 && group.equals("px")) {
                            c = 0;
                        }
                    } else if (group.equals("em")) {
                        c = 1;
                    }
                } else if (group.equals("%")) {
                    c = 2;
                }
                if (c == 0) {
                    ttmlStyle.setFontSizeUnit(1);
                } else if (c == 1) {
                    ttmlStyle.setFontSizeUnit(2);
                } else if (c == 2) {
                    ttmlStyle.setFontSizeUnit(3);
                } else {
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
                }
                ttmlStyle.setFontSize(Float.valueOf(matcher.group(1)).floatValue());
                return;
            }
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
    }

    private FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, xmlPullParser)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(TTP, "frameRate");
            int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
            float f = 1.0f;
            String attributeValue2 = xmlPullParser.getAttributeValue(TTP, "frameRateMultiplier");
            if (attributeValue2 != null) {
                String[] split = attributeValue2.split(" ");
                if (split.length == 2) {
                    f = Integer.parseInt(split[0]) / Integer.parseInt(split[1]);
                } else {
                    throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
                }
            }
            int i = DEFAULT_FRAME_AND_TICK_RATE.subFrameRate;
            String attributeValue3 = xmlPullParser.getAttributeValue(TTP, "subFrameRate");
            if (attributeValue3 != null) {
                i = Integer.parseInt(attributeValue3);
            }
            int i2 = DEFAULT_FRAME_AND_TICK_RATE.tickRate;
            String attributeValue4 = xmlPullParser.getAttributeValue(TTP, "tickRate");
            if (attributeValue4 != null) {
                i2 = Integer.parseInt(attributeValue4);
            }
            return new FrameAndTickRate(parseInt * f, i, i2);
        }
        return (FrameAndTickRate) invokeL.objValue;
    }

    private Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) throws IOException, XmlPullParserException {
        TtmlRegion parseRegionAttributes;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, this, xmlPullParser, map, map2)) == null) {
            do {
                xmlPullParser.next();
                if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                    String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                    TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                    if (attributeValue != null) {
                        for (String str : parseStyleIds(attributeValue)) {
                            parseStyleAttributes.chain(map.get(str));
                        }
                    }
                    if (parseStyleAttributes.getId() != null) {
                        map.put(parseStyleAttributes.getId(), parseStyleAttributes);
                    }
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region") && (parseRegionAttributes = parseRegionAttributes(xmlPullParser)) != null) {
                    map2.put(parseRegionAttributes.id, parseRegionAttributes);
                }
            } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "head"));
            return map;
        }
        return (Map) invokeLLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map<String, TtmlRegion> map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        InterceptResult invokeLLLL;
        long j;
        long j2;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, this, xmlPullParser, ttmlNode, map, frameAndTickRate)) == null) {
            int attributeCount = xmlPullParser.getAttributeCount();
            TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, null);
            String[] strArr = null;
            String str = "";
            long j3 = C.TIME_UNSET;
            long j4 = C.TIME_UNSET;
            long j5 = C.TIME_UNSET;
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = xmlPullParser.getAttributeName(i);
                String attributeValue = xmlPullParser.getAttributeValue(i);
                switch (attributeName.hashCode()) {
                    case -934795532:
                        if (attributeName.equals("region")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 99841:
                        if (attributeName.equals("dur")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 100571:
                        if (attributeName.equals("end")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 93616297:
                        if (attributeName.equals("begin")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 109780401:
                        if (attributeName.equals("style")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 0) {
                    j3 = parseTimeExpression(attributeValue, frameAndTickRate);
                } else if (c == 1) {
                    j4 = parseTimeExpression(attributeValue, frameAndTickRate);
                } else if (c == 2) {
                    j5 = parseTimeExpression(attributeValue, frameAndTickRate);
                } else if (c != 3) {
                    if (c == 4 && map.containsKey(attributeValue)) {
                        str = attributeValue;
                    }
                } else {
                    String[] parseStyleIds = parseStyleIds(attributeValue);
                    if (parseStyleIds.length > 0) {
                        strArr = parseStyleIds;
                    }
                }
            }
            if (ttmlNode != null) {
                long j6 = ttmlNode.startTimeUs;
                j = C.TIME_UNSET;
                if (j6 != C.TIME_UNSET) {
                    if (j3 != C.TIME_UNSET) {
                        j3 += j6;
                    }
                    if (j4 != C.TIME_UNSET) {
                        j4 += ttmlNode.startTimeUs;
                    }
                }
            } else {
                j = C.TIME_UNSET;
            }
            long j7 = j3;
            if (j4 == j) {
                if (j5 != j) {
                    j2 = j7 + j5;
                } else if (ttmlNode != null) {
                    long j8 = ttmlNode.endTimeUs;
                    if (j8 != j) {
                        j2 = j8;
                    }
                }
                return TtmlNode.buildNode(xmlPullParser.getName(), j7, j2, parseStyleAttributes, strArr, str);
            }
            j2 = j4;
            return TtmlNode.buildNode(xmlPullParser.getName(), j7, j2, parseStyleAttributes, strArr, str);
        }
        return (TtmlNode) invokeLLLL.objValue;
    }

    private TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, xmlPullParser)) == null) {
            String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id");
            if (attributeValue == null) {
                return null;
            }
            String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "origin");
            if (attributeValue2 != null) {
                Matcher matcher = PERCENTAGE_COORDINATES.matcher(attributeValue2);
                if (matcher.matches()) {
                    try {
                        float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                        int i = 2;
                        float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                        String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
                        if (attributeValue3 != null) {
                            Matcher matcher2 = PERCENTAGE_COORDINATES.matcher(attributeValue3);
                            if (matcher2.matches()) {
                                try {
                                    float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                    float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                    String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                    if (attributeValue4 != null) {
                                        String lowerInvariant = Util.toLowerInvariant(attributeValue4);
                                        char c = 65535;
                                        int hashCode = lowerInvariant.hashCode();
                                        if (hashCode != -1364013995) {
                                            if (hashCode == 92734940 && lowerInvariant.equals("after")) {
                                                c = 1;
                                            }
                                        } else if (lowerInvariant.equals("center")) {
                                            c = 0;
                                        }
                                        if (c == 0) {
                                            parseFloat2 += parseFloat4 / 2.0f;
                                            i = 1;
                                        } else if (c == 1) {
                                            parseFloat2 += parseFloat4;
                                        }
                                        return new TtmlRegion(attributeValue, parseFloat, parseFloat2, 0, i, parseFloat3);
                                    }
                                    i = 0;
                                    return new TtmlRegion(attributeValue, parseFloat, parseFloat2, 0, i, parseFloat3);
                                } catch (NumberFormatException unused) {
                                    Log.w(TAG, "Ignoring region with malformed extent: " + attributeValue2);
                                    return null;
                                }
                            }
                            Log.w(TAG, "Ignoring region with unsupported extent: " + attributeValue2);
                            return null;
                        }
                        Log.w(TAG, "Ignoring region without an extent");
                        return null;
                    } catch (NumberFormatException unused2) {
                        Log.w(TAG, "Ignoring region with malformed origin: " + attributeValue2);
                        return null;
                    }
                }
                Log.w(TAG, "Ignoring region with unsupported origin: " + attributeValue2);
                return null;
            }
            Log.w(TAG, "Ignoring region without an origin");
            return null;
        }
        return (TtmlRegion) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, xmlPullParser, ttmlStyle)) == null) {
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                String attributeName = xmlPullParser.getAttributeName(i);
                char c2 = 65535;
                switch (attributeName.hashCode()) {
                    case -1550943582:
                        if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_STYLE)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1224696685:
                        if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1065511464:
                        if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case -879295043:
                        if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case -734428249:
                        if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3355:
                        if (attributeName.equals("id")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 94842723:
                        if (attributeName.equals("color")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 365601008:
                        if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1287124693:
                        if (attributeName.equals(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        if ("style".equals(xmlPullParser.getName())) {
                            ttmlStyle = createIfNull(ttmlStyle).setId(attributeValue);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        ttmlStyle = createIfNull(ttmlStyle);
                        try {
                            ttmlStyle.setBackgroundColor(ColorParser.parseTtmlColor(attributeValue));
                            break;
                        } catch (IllegalArgumentException unused) {
                            Log.w(TAG, "Failed parsing background value: " + attributeValue);
                            break;
                        }
                    case 2:
                        ttmlStyle = createIfNull(ttmlStyle);
                        try {
                            ttmlStyle.setFontColor(ColorParser.parseTtmlColor(attributeValue));
                            break;
                        } catch (IllegalArgumentException unused2) {
                            Log.w(TAG, "Failed parsing color value: " + attributeValue);
                            break;
                        }
                    case 3:
                        ttmlStyle = createIfNull(ttmlStyle).setFontFamily(attributeValue);
                        break;
                    case 4:
                        try {
                            ttmlStyle = createIfNull(ttmlStyle);
                            parseFontSize(attributeValue, ttmlStyle);
                            break;
                        } catch (SubtitleDecoderException unused3) {
                            Log.w(TAG, "Failed parsing fontSize value: " + attributeValue);
                            break;
                        }
                    case 5:
                        ttmlStyle = createIfNull(ttmlStyle).setBold("bold".equalsIgnoreCase(attributeValue));
                        break;
                    case 6:
                        ttmlStyle = createIfNull(ttmlStyle).setItalic("italic".equalsIgnoreCase(attributeValue));
                        break;
                    case 7:
                        String lowerInvariant = Util.toLowerInvariant(attributeValue);
                        switch (lowerInvariant.hashCode()) {
                            case -1364013995:
                                if (lowerInvariant.equals("center")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 100571:
                                if (lowerInvariant.equals("end")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (lowerInvariant.equals("left")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (lowerInvariant.equals("right")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 109757538:
                                if (lowerInvariant.equals("start")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                        }
                        if (c2 != 0) {
                            if (c2 != 1) {
                                if (c2 != 2) {
                                    if (c2 != 3) {
                                        if (c2 != 4) {
                                            break;
                                        } else {
                                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_CENTER);
                                            break;
                                        }
                                    } else {
                                        ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                                        break;
                                    }
                                } else {
                                    ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                                    break;
                                }
                            } else {
                                ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                                break;
                            }
                        } else {
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                            break;
                        }
                    case '\b':
                        String lowerInvariant2 = Util.toLowerInvariant(attributeValue);
                        switch (lowerInvariant2.hashCode()) {
                            case -1461280213:
                                if (lowerInvariant2.equals(TtmlNode.NO_UNDERLINE)) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case -1026963764:
                                if (lowerInvariant2.equals("underline")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 913457136:
                                if (lowerInvariant2.equals(TtmlNode.NO_LINETHROUGH)) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 1679736913:
                                if (lowerInvariant2.equals(TtmlNode.LINETHROUGH)) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        if (c2 != 0) {
                            if (c2 != 1) {
                                if (c2 != 2) {
                                    if (c2 != 3) {
                                        break;
                                    } else {
                                        ttmlStyle = createIfNull(ttmlStyle).setUnderline(false);
                                        break;
                                    }
                                } else {
                                    ttmlStyle = createIfNull(ttmlStyle).setUnderline(true);
                                    break;
                                }
                            } else {
                                ttmlStyle = createIfNull(ttmlStyle).setLinethrough(false);
                                break;
                            }
                        } else {
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(true);
                            break;
                        }
                }
            }
            return ttmlStyle;
        }
        return (TtmlStyle) invokeLL.objValue;
    }

    private String[] parseStyleIds(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) ? str.split("\\s+") : (String[]) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c0, code lost:
        if (r14.equals("s") != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long parseTimeExpression(String str, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        InterceptResult invokeLL;
        double d;
        double d2;
        String group;
        String group2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, frameAndTickRate)) == null) {
            Matcher matcher = CLOCK_TIME.matcher(str);
            char c = 2;
            if (matcher.matches()) {
                double parseLong = (Long.parseLong(matcher.group(1)) * 3600) + (Long.parseLong(matcher.group(2)) * 60) + Long.parseLong(matcher.group(3));
                String group3 = matcher.group(4);
                return (long) ((parseLong + (group3 != null ? Double.parseDouble(group3) : 0.0d) + (matcher.group(5) != null ? ((float) Long.parseLong(group)) / frameAndTickRate.effectiveFrameRate : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(group2) / frameAndTickRate.subFrameRate) / frameAndTickRate.effectiveFrameRate : 0.0d)) * 1000000.0d);
            }
            Matcher matcher2 = OFFSET_TIME.matcher(str);
            if (matcher2.matches()) {
                double parseDouble = Double.parseDouble(matcher2.group(1));
                String group4 = matcher2.group(2);
                int hashCode = group4.hashCode();
                if (hashCode == 102) {
                    if (group4.equals("f")) {
                        c = 4;
                    }
                    c = 65535;
                } else if (hashCode == 104) {
                    if (group4.equals("h")) {
                        c = 0;
                    }
                    c = 65535;
                } else if (hashCode == 109) {
                    if (group4.equals("m")) {
                        c = 1;
                    }
                    c = 65535;
                } else if (hashCode == 3494) {
                    if (group4.equals("ms")) {
                        c = 3;
                    }
                    c = 65535;
                } else if (hashCode != 115) {
                    if (hashCode == 116 && group4.equals("t")) {
                        c = 5;
                    }
                    c = 65535;
                }
                if (c == 0) {
                    d = 3600.0d;
                } else if (c != 1) {
                    if (c == 3) {
                        d2 = 1000.0d;
                    } else if (c != 4) {
                        if (c == 5) {
                            d2 = frameAndTickRate.tickRate;
                        }
                        return (long) (parseDouble * 1000000.0d);
                    } else {
                        d2 = frameAndTickRate.effectiveFrameRate;
                    }
                    parseDouble /= d2;
                    return (long) (parseDouble * 1000000.0d);
                } else {
                    d = 60.0d;
                }
                parseDouble *= d;
                return (long) (parseDouble * 1000000.0d);
            }
            throw new SubtitleDecoderException("Malformed time expression: " + str);
        }
        return invokeLL.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public TtmlSubtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            try {
                XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                TtmlSubtitle ttmlSubtitle = null;
                hashMap2.put("", new TtmlRegion(null));
                int i2 = 0;
                newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
                LinkedList linkedList = new LinkedList();
                FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                    TtmlNode ttmlNode = (TtmlNode) linkedList.peekLast();
                    if (i2 == 0) {
                        String name = newPullParser.getName();
                        if (eventType == 2) {
                            if ("tt".equals(name)) {
                                frameAndTickRate = parseFrameAndTickRates(newPullParser);
                            }
                            if (!isSupportedTag(name)) {
                                Log.i(TAG, "Ignoring unsupported tag: " + newPullParser.getName());
                            } else if ("head".equals(name)) {
                                parseHeader(newPullParser, hashMap, hashMap2);
                            } else {
                                try {
                                    TtmlNode parseNode = parseNode(newPullParser, ttmlNode, hashMap2, frameAndTickRate);
                                    linkedList.addLast(parseNode);
                                    if (ttmlNode != null) {
                                        ttmlNode.addChild(parseNode);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    Log.w(TAG, "Suppressing parser error", e);
                                }
                            }
                            i2++;
                        } else if (eventType == 4) {
                            ttmlNode.addChild(TtmlNode.buildTextNode(newPullParser.getText()));
                        } else if (eventType == 3) {
                            if (newPullParser.getName().equals("tt")) {
                                ttmlSubtitle = new TtmlSubtitle((TtmlNode) linkedList.getLast(), hashMap, hashMap2);
                            }
                            linkedList.removeLast();
                        }
                    } else {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                i2--;
                            }
                        }
                        i2++;
                    }
                    newPullParser.next();
                }
                return ttmlSubtitle;
            } catch (IOException e2) {
                throw new IllegalStateException("Unexpected error when reading input.", e2);
            } catch (XmlPullParserException e3) {
                throw new SubtitleDecoderException("Unable to decode source", e3);
            }
        }
        return (TtmlSubtitle) invokeCommon.objValue;
    }
}
