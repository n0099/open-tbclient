package com.google.android.exoplayer2.text.e;

import android.text.Layout;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.w;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
/* loaded from: classes6.dex */
public final class a extends com.google.android.exoplayer2.text.c {
    private static final Pattern mDc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern mDd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern mDe = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern mDf = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final C0688a mDg = new C0688a(30.0f, 1, 1);
    private final XmlPullParserFactory mwN;

    public a() {
        super("TtmlDecoder");
        try {
            this.mwN = XmlPullParserFactory.newInstance();
            this.mwN.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.c
    /* renamed from: f */
    public f b(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        C0688a c0688a;
        int i2;
        f fVar;
        try {
            XmlPullParser newPullParser = this.mwN.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("", new c(null));
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            f fVar2 = null;
            LinkedList linkedList = new LinkedList();
            int i3 = 0;
            int eventType = newPullParser.getEventType();
            C0688a c0688a2 = mDg;
            for (int i4 = eventType; i4 != 1; i4 = newPullParser.getEventType()) {
                b bVar = (b) linkedList.peekLast();
                if (i3 == 0) {
                    String name = newPullParser.getName();
                    if (i4 == 2) {
                        if (PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP.equals(name)) {
                            c0688a2 = t(newPullParser);
                        }
                        if (!PY(name)) {
                            Log.i("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            int i5 = i3 + 1;
                            fVar = fVar2;
                            c0688a = c0688a2;
                            i2 = i5;
                        } else if ("head".equals(name)) {
                            a(newPullParser, hashMap, hashMap2);
                            c0688a = c0688a2;
                            i2 = i3;
                            fVar = fVar2;
                        } else {
                            try {
                                b a = a(newPullParser, bVar, hashMap2, c0688a2);
                                linkedList.addLast(a);
                                if (bVar != null) {
                                    bVar.a(a);
                                }
                                c0688a = c0688a2;
                                i2 = i3;
                                fVar = fVar2;
                            } catch (SubtitleDecoderException e) {
                                Log.w("TtmlDecoder", "Suppressing parser error", e);
                                int i6 = i3 + 1;
                                fVar = fVar2;
                                c0688a = c0688a2;
                                i2 = i6;
                            }
                        }
                    } else if (i4 == 4) {
                        bVar.a(b.PZ(newPullParser.getText()));
                        c0688a = c0688a2;
                        i2 = i3;
                        fVar = fVar2;
                    } else if (i4 == 3) {
                        f fVar3 = newPullParser.getName().equals(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP) ? new f((b) linkedList.getLast(), hashMap, hashMap2) : fVar2;
                        linkedList.removeLast();
                        C0688a c0688a3 = c0688a2;
                        i2 = i3;
                        fVar = fVar3;
                        c0688a = c0688a3;
                    } else {
                        c0688a = c0688a2;
                        i2 = i3;
                        fVar = fVar2;
                    }
                    fVar2 = fVar;
                    i3 = i2;
                    c0688a2 = c0688a;
                } else if (i4 == 2) {
                    i3++;
                } else if (i4 == 3) {
                    i3--;
                }
                newPullParser.next();
            }
            return fVar2;
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }

    private C0688a t(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        int i = 30;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        if (attributeValue != null) {
            i = Integer.parseInt(attributeValue);
        }
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split(HanziToPinyin.Token.SEPARATOR);
            if (split.length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(split[0]) / Integer.parseInt(split[1]);
        }
        int i2 = mDg.mDi;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = mDg.mDj;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new C0688a(i * f, i2, i3);
    }

    private Map<String, e> a(XmlPullParser xmlPullParser, Map<String, e> map, Map<String, c> map2) throws IOException, XmlPullParserException {
        c u;
        do {
            xmlPullParser.next();
            if (w.h(xmlPullParser, "style")) {
                String i = w.i(xmlPullParser, "style");
                e a = a(xmlPullParser, new e());
                if (i != null) {
                    for (String str : PX(i)) {
                        a.b(map.get(str));
                    }
                }
                if (a.getId() != null) {
                    map.put(a.getId(), a);
                }
            } else if (w.h(xmlPullParser, "region") && (u = u(xmlPullParser)) != null) {
                map2.put(u.id, u);
            }
        } while (!w.g(xmlPullParser, "head"));
        return map;
    }

    private c u(XmlPullParser xmlPullParser) {
        int i = 1;
        String i2 = w.i(xmlPullParser, "id");
        if (i2 == null) {
            return null;
        }
        String i3 = w.i(xmlPullParser, "origin");
        if (i3 != null) {
            Matcher matcher = mDf.matcher(i3);
            if (matcher.matches()) {
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String i4 = w.i(xmlPullParser, "extent");
                    if (i4 != null) {
                        Matcher matcher2 = mDf.matcher(i4);
                        if (matcher2.matches()) {
                            try {
                                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String i5 = w.i(xmlPullParser, "displayAlign");
                                if (i5 != null) {
                                    String QC = v.QC(i5);
                                    char c = 65535;
                                    switch (QC.hashCode()) {
                                        case -1364013995:
                                            if (QC.equals("center")) {
                                                c = 0;
                                                break;
                                            }
                                            break;
                                        case 92734940:
                                            if (QC.equals("after")) {
                                                c = 1;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (c) {
                                        case 0:
                                            parseFloat2 += parseFloat4 / 2.0f;
                                            break;
                                        case 1:
                                            parseFloat2 += parseFloat4;
                                            i = 2;
                                            break;
                                    }
                                    return new c(i2, parseFloat, parseFloat2, 0, i, parseFloat3);
                                }
                                i = 0;
                                return new c(i2, parseFloat, parseFloat2, 0, i, parseFloat3);
                            } catch (NumberFormatException e) {
                                Log.w("TtmlDecoder", "Ignoring region with malformed extent: " + i3);
                                return null;
                            }
                        }
                        Log.w("TtmlDecoder", "Ignoring region with unsupported extent: " + i3);
                        return null;
                    }
                    Log.w("TtmlDecoder", "Ignoring region without an extent");
                    return null;
                } catch (NumberFormatException e2) {
                    Log.w("TtmlDecoder", "Ignoring region with malformed origin: " + i3);
                    return null;
                }
            }
            Log.w("TtmlDecoder", "Ignoring region with unsupported origin: " + i3);
            return null;
        }
        Log.w("TtmlDecoder", "Ignoring region without an origin");
        return null;
    }

    private String[] PX(String str) {
        return str.split("\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private e a(XmlPullParser xmlPullParser, e eVar) {
        char c;
        boolean z;
        char c2;
        int attributeCount = xmlPullParser.getAttributeCount();
        e eVar2 = eVar;
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
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
                    if (attributeName.equals("fontSize")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
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
                        eVar2 = a(eVar2).Qc(attributeValue);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    eVar2 = a(eVar2);
                    try {
                        eVar2.LF(com.google.android.exoplayer2.util.d.Qn(attributeValue));
                        break;
                    } catch (IllegalArgumentException e) {
                        Log.w("TtmlDecoder", "Failed parsing background value: " + attributeValue);
                        break;
                    }
                case 2:
                    eVar2 = a(eVar2);
                    try {
                        eVar2.LE(com.google.android.exoplayer2.util.d.Qn(attributeValue));
                        break;
                    } catch (IllegalArgumentException e2) {
                        Log.w("TtmlDecoder", "Failed parsing color value: " + attributeValue);
                        break;
                    }
                case 3:
                    eVar2 = a(eVar2).Qb(attributeValue);
                    break;
                case 4:
                    try {
                        eVar2 = a(eVar2);
                        a(attributeValue, eVar2);
                        break;
                    } catch (SubtitleDecoderException e3) {
                        Log.w("TtmlDecoder", "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                case 5:
                    eVar2 = a(eVar2).vT("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 6:
                    eVar2 = a(eVar2).vU("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 7:
                    String QC = v.QC(attributeValue);
                    switch (QC.hashCode()) {
                        case -1364013995:
                            if (QC.equals("center")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 100571:
                            if (QC.equals("end")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3317767:
                            if (QC.equals("left")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 108511772:
                            if (QC.equals(HorizontalTranslateLayout.DIRECTION_RIGHT)) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 109757538:
                            if (QC.equals("start")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            eVar2 = a(eVar2).a(Layout.Alignment.ALIGN_NORMAL);
                            continue;
                        case 1:
                            eVar2 = a(eVar2).a(Layout.Alignment.ALIGN_NORMAL);
                            continue;
                        case 2:
                            eVar2 = a(eVar2).a(Layout.Alignment.ALIGN_OPPOSITE);
                            continue;
                        case 3:
                            eVar2 = a(eVar2).a(Layout.Alignment.ALIGN_OPPOSITE);
                            continue;
                        case 4:
                            eVar2 = a(eVar2).a(Layout.Alignment.ALIGN_CENTER);
                            continue;
                    }
                case '\b':
                    String QC2 = v.QC(attributeValue);
                    switch (QC2.hashCode()) {
                        case -1461280213:
                            if (QC2.equals("nounderline")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case -1026963764:
                            if (QC2.equals("underline")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 913457136:
                            if (QC2.equals("nolinethrough")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1679736913:
                            if (QC2.equals("linethrough")) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            eVar2 = a(eVar2).vR(true);
                            continue;
                        case true:
                            eVar2 = a(eVar2).vR(false);
                            continue;
                        case true:
                            eVar2 = a(eVar2).vS(true);
                            continue;
                        case true:
                            eVar2 = a(eVar2).vS(false);
                            continue;
                    }
            }
        }
        return eVar2;
    }

    private e a(e eVar) {
        return eVar == null ? new e() : eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private b a(XmlPullParser xmlPullParser, b bVar, Map<String, c> map, C0688a c0688a) throws SubtitleDecoderException {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6 = -9223372036854775807L;
        long j7 = -9223372036854775807L;
        long j8 = -9223372036854775807L;
        String str = "";
        String[] strArr = null;
        int attributeCount = xmlPullParser.getAttributeCount();
        e a = a(xmlPullParser, (e) null);
        int i = 0;
        while (i < attributeCount) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            char c = 65535;
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c = 4;
                        break;
                    }
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c = 2;
                        break;
                    }
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c = 1;
                        break;
                    }
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c = 0;
                        break;
                    }
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    long a2 = a(attributeValue, c0688a);
                    j5 = j6;
                    j3 = j8;
                    j4 = a2;
                    continue;
                    i++;
                    j6 = j5;
                    j7 = j4;
                    j8 = j3;
                case 1:
                    j3 = a(attributeValue, c0688a);
                    j4 = j7;
                    j5 = j6;
                    continue;
                    i++;
                    j6 = j5;
                    j7 = j4;
                    j8 = j3;
                case 2:
                    long j9 = j8;
                    j4 = j7;
                    j5 = a(attributeValue, c0688a);
                    j3 = j9;
                    continue;
                    i++;
                    j6 = j5;
                    j7 = j4;
                    j8 = j3;
                case 3:
                    String[] PX = PX(attributeValue);
                    if (PX.length > 0) {
                        strArr = PX;
                        j3 = j8;
                        j4 = j7;
                        j5 = j6;
                        continue;
                        i++;
                        j6 = j5;
                        j7 = j4;
                        j8 = j3;
                    }
                    break;
                case 4:
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        j3 = j8;
                        j4 = j7;
                        j5 = j6;
                        continue;
                        i++;
                        j6 = j5;
                        j7 = j4;
                        j8 = j3;
                    }
                    break;
            }
            j3 = j8;
            j4 = j7;
            j5 = j6;
            i++;
            j6 = j5;
            j7 = j4;
            j8 = j3;
        }
        if (bVar != null && bVar.mvc != -9223372036854775807L) {
            if (j7 != -9223372036854775807L) {
                j7 += bVar.mvc;
            }
            if (j8 != -9223372036854775807L) {
                long j10 = j8 + bVar.mvc;
                j = j7;
                j2 = j10;
                if (j2 == -9223372036854775807L) {
                    if (j6 != -9223372036854775807L) {
                        j2 = j + j6;
                    } else if (bVar != null && bVar.mvd != -9223372036854775807L) {
                        j2 = bVar.mvd;
                    }
                }
                return b.a(xmlPullParser.getName(), j, j2, a, strArr, str);
            }
        }
        long j11 = j8;
        j = j7;
        j2 = j11;
        if (j2 == -9223372036854775807L) {
        }
        return b.a(xmlPullParser.getName(), j, j2, a, strArr, str);
    }

    private static boolean PY(String str) {
        return str.equals(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP) || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information");
    }

    private static void a(String str, e eVar) throws SubtitleDecoderException {
        Matcher matcher;
        String[] split = str.split("\\s+");
        if (split.length == 1) {
            matcher = mDe.matcher(str);
        } else if (split.length == 2) {
            matcher = mDe.matcher(split[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            char c = 65535;
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    eVar.LG(1);
                    break;
                case 1:
                    eVar.LG(2);
                    break;
                case 2:
                    eVar.LG(3);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
            }
            eVar.by(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private static long a(String str, C0688a c0688a) throws SubtitleDecoderException {
        String group;
        String group2;
        Matcher matcher = mDc.matcher(str);
        if (matcher.matches()) {
            double parseLong = Long.parseLong(matcher.group(3)) + (Long.parseLong(matcher.group(1)) * 3600) + (Long.parseLong(matcher.group(2)) * 60);
            String group3 = matcher.group(4);
            return (long) (((matcher.group(5) != null ? ((float) Long.parseLong(group)) / c0688a.mDh : 0.0d) + parseLong + (group3 != null ? Double.parseDouble(group3) : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(group2) / c0688a.mDi) / c0688a.mDh : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = mDd.matcher(str);
        if (matcher2.matches()) {
            double parseDouble = Double.parseDouble(matcher2.group(1));
            String group4 = matcher2.group(2);
            char c = 65535;
            switch (group4.hashCode()) {
                case 102:
                    if (group4.equals("f")) {
                        c = 4;
                        break;
                    }
                    break;
                case 104:
                    if (group4.equals("h")) {
                        c = 0;
                        break;
                    }
                    break;
                case 109:
                    if (group4.equals("m")) {
                        c = 1;
                        break;
                    }
                    break;
                case 115:
                    if (group4.equals("s")) {
                        c = 2;
                        break;
                    }
                    break;
                case 116:
                    if (group4.equals("t")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3494:
                    if (group4.equals("ms")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    parseDouble *= 3600.0d;
                    break;
                case 1:
                    parseDouble *= 60.0d;
                    break;
                case 3:
                    parseDouble /= 1000.0d;
                    break;
                case 4:
                    parseDouble /= c0688a.mDh;
                    break;
                case 5:
                    parseDouble /= c0688a.mDj;
                    break;
            }
            return (long) (parseDouble * 1000000.0d);
        }
        throw new SubtitleDecoderException("Malformed time expression: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0688a {
        final float mDh;
        final int mDi;
        final int mDj;

        C0688a(float f, int i, int i2) {
            this.mDh = f;
            this.mDi = i;
            this.mDj = i2;
        }
    }
}
