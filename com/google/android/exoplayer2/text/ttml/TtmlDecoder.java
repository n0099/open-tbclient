package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import android.util.Log;
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
/* loaded from: classes9.dex */
public final class TtmlDecoder extends SimpleSubtitleDecoder {
    public static final String ATTR_BEGIN = "begin";
    public static final String ATTR_DURATION = "dur";
    public static final String ATTR_END = "end";
    public static final String ATTR_REGION = "region";
    public static final String ATTR_STYLE = "style";
    public static final int DEFAULT_FRAME_RATE = 30;
    public static final String TAG = "TtmlDecoder";
    public static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    public final XmlPullParserFactory xmlParserFactory;
    public static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    public static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    public static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    public static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    public static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);

    /* loaded from: classes9.dex */
    public static final class FrameAndTickRate {
        public final float effectiveFrameRate;
        public final int subFrameRate;
        public final int tickRate;

        public FrameAndTickRate(float f, int i, int i2) {
            this.effectiveFrameRate = f;
            this.subFrameRate = i;
            this.tickRate = i2;
        }
    }

    public TtmlDecoder() {
        super(TAG);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    private TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        if (ttmlStyle == null) {
            return new TtmlStyle();
        }
        return ttmlStyle;
    }

    private String[] parseStyleIds(String str) {
        return str.split("\\s+");
    }

    public static boolean isSupportedTag(String str) {
        if (!str.equals("tt") && !str.equals("head") && !str.equals("body") && !str.equals(TtmlNode.TAG_DIV) && !str.equals("p") && !str.equals(TtmlNode.TAG_SPAN) && !str.equals("br") && !str.equals("style") && !str.equals(TtmlNode.TAG_STYLING) && !str.equals(TtmlNode.TAG_LAYOUT) && !str.equals("region") && !str.equals(TtmlNode.TAG_METADATA) && !str.equals(TtmlNode.TAG_SMPTE_IMAGE) && !str.equals(TtmlNode.TAG_SMPTE_DATA) && !str.equals(TtmlNode.TAG_SMPTE_INFORMATION)) {
            return false;
        }
        return true;
    }

    private FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        int i;
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "frameRate");
        if (attributeValue != null) {
            i = Integer.parseInt(attributeValue);
        } else {
            i = 30;
        }
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
        int i2 = DEFAULT_FRAME_AND_TICK_RATE.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue(TTP, "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = DEFAULT_FRAME_AND_TICK_RATE.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue(TTP, "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(i * f, i2, i3);
    }

    public static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
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
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        ttmlStyle.setFontSizeUnit(3);
                    } else {
                        throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
                    }
                } else {
                    ttmlStyle.setFontSizeUnit(2);
                }
            } else {
                ttmlStyle.setFontSizeUnit(1);
            }
            ttmlStyle.setFontSize(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:
        if (r14.equals("s") != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long parseTimeExpression(String str, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        double d;
        double d2;
        double d3;
        double d4;
        String group;
        Matcher matcher = CLOCK_TIME.matcher(str);
        char c = 2;
        if (matcher.matches()) {
            double parseLong = (Long.parseLong(matcher.group(1)) * 3600) + (Long.parseLong(matcher.group(2)) * 60) + Long.parseLong(matcher.group(3));
            String group2 = matcher.group(4);
            double d5 = 0.0d;
            if (group2 != null) {
                d3 = Double.parseDouble(group2);
            } else {
                d3 = 0.0d;
            }
            double d6 = parseLong + d3;
            String group3 = matcher.group(5);
            if (group3 != null) {
                d4 = ((float) Long.parseLong(group3)) / frameAndTickRate.effectiveFrameRate;
            } else {
                d4 = 0.0d;
            }
            double d7 = d6 + d4;
            if (matcher.group(6) != null) {
                d5 = (Long.parseLong(group) / frameAndTickRate.subFrameRate) / frameAndTickRate.effectiveFrameRate;
            }
            return (long) ((d7 + d5) * 1000000.0d);
        }
        Matcher matcher2 = OFFSET_TIME.matcher(str);
        if (matcher2.matches()) {
            double parseDouble = Double.parseDouble(matcher2.group(1));
            String group4 = matcher2.group(2);
            int hashCode = group4.hashCode();
            if (hashCode != 102) {
                if (hashCode != 104) {
                    if (hashCode != 109) {
                        if (hashCode != 3494) {
                            if (hashCode != 115) {
                                if (hashCode == 116 && group4.equals("t")) {
                                    c = 5;
                                }
                                c = 65535;
                            }
                        } else {
                            if (group4.equals("ms")) {
                                c = 3;
                            }
                            c = 65535;
                        }
                    } else {
                        if (group4.equals("m")) {
                            c = 1;
                        }
                        c = 65535;
                    }
                } else {
                    if (group4.equals("h")) {
                        c = 0;
                    }
                    c = 65535;
                }
            } else {
                if (group4.equals("f")) {
                    c = 4;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 3) {
                        if (c != 4) {
                            if (c == 5) {
                                d2 = frameAndTickRate.tickRate;
                            }
                            return (long) (parseDouble * 1000000.0d);
                        }
                        d2 = frameAndTickRate.effectiveFrameRate;
                    } else {
                        d2 = 1000.0d;
                    }
                    parseDouble /= d2;
                    return (long) (parseDouble * 1000000.0d);
                }
                d = 60.0d;
            } else {
                d = 3600.0d;
            }
            parseDouble *= d;
            return (long) (parseDouble * 1000000.0d);
        }
        throw new SubtitleDecoderException("Malformed time expression: " + str);
    }

    private Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) throws IOException, XmlPullParserException {
        TtmlRegion parseRegionAttributes;
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map<String, TtmlRegion> map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        long j;
        long j2;
        char c;
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
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c == 4 && map.containsKey(attributeValue)) {
                                str = attributeValue;
                            }
                        } else {
                            String[] parseStyleIds = parseStyleIds(attributeValue);
                            if (parseStyleIds.length > 0) {
                                strArr = parseStyleIds;
                            }
                        }
                    } else {
                        j5 = parseTimeExpression(attributeValue, frameAndTickRate);
                    }
                } else {
                    j4 = parseTimeExpression(attributeValue, frameAndTickRate);
                }
            } else {
                j3 = parseTimeExpression(attributeValue, frameAndTickRate);
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

    private TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser) {
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
                                    if (c != 0) {
                                        if (c == 1) {
                                            parseFloat2 += parseFloat4;
                                        }
                                    } else {
                                        parseFloat2 += parseFloat4 / 2.0f;
                                        i = 1;
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        char c;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public TtmlSubtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
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
}
