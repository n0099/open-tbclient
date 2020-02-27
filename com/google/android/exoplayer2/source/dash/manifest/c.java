package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.support.media.ExifInterface;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.util.media.MimeType;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidubce.http.Headers;
import com.coremedia.iso.boxes.sampleentry.SubtitleSampleEntry;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.dash.manifest.h;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.w;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes6.dex */
public class c extends DefaultHandler implements p.a<b> {
    private static final Pattern muQ = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final Pattern muR = Pattern.compile("CC([1-4])=.*");
    private static final Pattern muS = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private final String muT;
    private final XmlPullParserFactory muU;

    public c() {
        this(null);
    }

    public c(String str) {
        this.muT = str;
        try {
            this.muU = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.p.a
    /* renamed from: c */
    public b b(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.muU.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() != 2 || !"MPD".equals(newPullParser.getName())) {
                throw new ParserException("inputStream does not contain a valid media presentation description");
            }
            return a(newPullParser, uri.toString());
        } catch (XmlPullParserException e) {
            throw new ParserException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected b a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        k kVar;
        boolean z;
        String str2;
        long j;
        long c = c(xmlPullParser, "availabilityStartTime", -9223372036854775807L);
        long b = b(xmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
        long b2 = b(xmlPullParser, "minBufferTime", -9223372036854775807L);
        String attributeValue = xmlPullParser.getAttributeValue(null, "type");
        boolean z2 = attributeValue != null && attributeValue.equals(PraiseUBCHelper.SOURCE_DYNAMIC);
        long b3 = z2 ? b(xmlPullParser, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long b4 = z2 ? b(xmlPullParser, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long b5 = z2 ? b(xmlPullParser, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        k kVar2 = null;
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        boolean z4 = false;
        long j2 = z2 ? -9223372036854775807L : 0L;
        String str3 = str;
        Uri uri = null;
        while (true) {
            boolean z5 = z3;
            xmlPullParser.next();
            if (w.h(xmlPullParser, "BaseURL")) {
                if (!z4) {
                    z = true;
                    str2 = c(xmlPullParser, str3);
                    z3 = z5;
                    kVar = kVar2;
                }
                z = z4;
                z3 = z5;
                kVar = kVar2;
                str2 = str3;
            } else if (w.h(xmlPullParser, "UTCTiming")) {
                z3 = z5;
                kVar = c(xmlPullParser);
                z = z4;
                str2 = str3;
            } else if (w.h(xmlPullParser, Headers.LOCATION)) {
                uri = Uri.parse(xmlPullParser.nextText());
                z = z4;
                z3 = z5;
                kVar = kVar2;
                str2 = str3;
            } else {
                if (w.h(xmlPullParser, "Period") && !z5) {
                    Pair<e, Long> a2 = a(xmlPullParser, str3, j2);
                    e eVar = (e) a2.first;
                    if (eVar.muZ == -9223372036854775807L) {
                        if (z2) {
                            z3 = true;
                            kVar = kVar2;
                            z = z4;
                            str2 = str3;
                        } else {
                            throw new ParserException("Unable to determine start of period " + arrayList.size());
                        }
                    } else {
                        long longValue = ((Long) a2.second).longValue();
                        j2 = longValue == -9223372036854775807L ? -9223372036854775807L : longValue + eVar.muZ;
                        arrayList.add(eVar);
                    }
                }
                z = z4;
                z3 = z5;
                kVar = kVar2;
                str2 = str3;
            }
            if (w.g(xmlPullParser, "MPD")) {
                if (b == -9223372036854775807L) {
                    if (j2 == -9223372036854775807L) {
                        if (!z2) {
                            throw new ParserException("Unable to determine duration of static manifest.");
                        }
                    } else {
                        j = j2;
                        if (!arrayList.isEmpty()) {
                            throw new ParserException("No periods found.");
                        }
                        return a(c, j, b2, z2, b3, b4, b5, kVar, uri, arrayList);
                    }
                }
                j = b;
                if (!arrayList.isEmpty()) {
                }
            } else {
                kVar2 = kVar;
                str3 = str2;
                z4 = z;
            }
        }
    }

    protected b a(long j, long j2, long j3, boolean z, long j4, long j5, long j6, k kVar, Uri uri, List<e> list) {
        return new b(j, j2, j3, z, j4, j5, j6, kVar, uri, list);
    }

    protected k c(XmlPullParser xmlPullParser) {
        return fo(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    protected k fo(String str, String str2) {
        return new k(str, str2);
    }

    protected Pair<e, Long> a(XmlPullParser xmlPullParser, String str, long j) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        long b = b(xmlPullParser, "start", j);
        long b2 = b(xmlPullParser, "duration", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        h hVar = null;
        String str2 = str;
        do {
            xmlPullParser.next();
            if (w.h(xmlPullParser, "BaseURL")) {
                if (!z) {
                    str2 = c(xmlPullParser, str2);
                    z = true;
                }
            } else if (w.h(xmlPullParser, "AdaptationSet")) {
                arrayList.add(a(xmlPullParser, str2, hVar));
            } else if (w.h(xmlPullParser, "SegmentBase")) {
                hVar = a(xmlPullParser, (h.e) null);
            } else if (w.h(xmlPullParser, "SegmentList")) {
                hVar = a(xmlPullParser, (h.b) null);
            } else if (w.h(xmlPullParser, "SegmentTemplate")) {
                hVar = a(xmlPullParser, (h.c) null);
            }
        } while (!w.g(xmlPullParser, "Period"));
        return Pair.create(a(attributeValue, b, arrayList), Long.valueOf(b2));
    }

    protected e a(String str, long j, List<com.google.android.exoplayer2.source.dash.manifest.a> list) {
        return new e(str, j, list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r25v0, resolved type: com.google.android.exoplayer2.source.dash.manifest.c */
    /* JADX WARN: Multi-variable type inference failed */
    protected com.google.android.exoplayer2.source.dash.manifest.a a(XmlPullParser xmlPullParser, String str, h hVar) throws XmlPullParserException, IOException {
        boolean z;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        int a2 = a(xmlPullParser, "id", -1);
        int d = d(xmlPullParser);
        String attributeValue = xmlPullParser.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "codecs");
        int a3 = a(xmlPullParser, "width", -1);
        int a4 = a(xmlPullParser, "height", -1);
        float a5 = a(xmlPullParser, -1.0f);
        int i3 = -1;
        int a6 = a(xmlPullParser, "audioSamplingRate", -1);
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "lang");
        String str5 = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        int i4 = 0;
        boolean z2 = false;
        h hVar2 = hVar;
        String str6 = str;
        while (true) {
            xmlPullParser.next();
            if (w.h(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    z = true;
                    str2 = attributeValue3;
                    str3 = c(xmlPullParser, str6);
                    i2 = i3;
                    i = d;
                    str4 = str5;
                }
                z = z2;
                str2 = attributeValue3;
                i = d;
                str3 = str6;
                i2 = i3;
                str4 = str5;
            } else if (w.h(xmlPullParser, "ContentProtection")) {
                Pair<String, DrmInitData.SchemeData> e = e(xmlPullParser);
                String str7 = e.first != null ? (String) e.first : str5;
                if (e.second != null) {
                    arrayList.add(e.second);
                }
                str2 = attributeValue3;
                i = d;
                boolean z3 = z2;
                str3 = str6;
                i2 = i3;
                str4 = str7;
                z = z3;
            } else if (w.h(xmlPullParser, "ContentComponent")) {
                str2 = fq(attributeValue3, xmlPullParser.getAttributeValue(null, "lang"));
                i = dO(d, d(xmlPullParser));
                z = z2;
                str3 = str6;
                i2 = i3;
                str4 = str5;
            } else if (w.h(xmlPullParser, "Role")) {
                i4 |= f(xmlPullParser);
                z = z2;
                str2 = attributeValue3;
                i = d;
                str3 = str6;
                i2 = i3;
                str4 = str5;
            } else if (w.h(xmlPullParser, "AudioChannelConfiguration")) {
                z = z2;
                str2 = attributeValue3;
                i = d;
                str3 = str6;
                i2 = k(xmlPullParser);
                str4 = str5;
            } else if (w.h(xmlPullParser, "Accessibility")) {
                arrayList3.add(b(xmlPullParser, "Accessibility"));
                z = z2;
                str2 = attributeValue3;
                i = d;
                str3 = str6;
                i2 = i3;
                str4 = str5;
            } else if (w.h(xmlPullParser, "SupplementalProperty")) {
                arrayList4.add(b(xmlPullParser, "SupplementalProperty"));
                z = z2;
                str2 = attributeValue3;
                i = d;
                str3 = str6;
                i2 = i3;
                str4 = str5;
            } else if (w.h(xmlPullParser, "Representation")) {
                a a7 = a(xmlPullParser, str6, attributeValue, attributeValue2, a3, a4, a5, i3, a6, attributeValue3, i4, arrayList3, hVar2);
                int dO = dO(d, n(a7.lZw));
                arrayList5.add(a7);
                str2 = attributeValue3;
                i = dO;
                z = z2;
                str3 = str6;
                i2 = i3;
                str4 = str5;
            } else if (w.h(xmlPullParser, "SegmentBase")) {
                hVar2 = a(xmlPullParser, (h.e) hVar2);
                z = z2;
                str2 = attributeValue3;
                i = d;
                str3 = str6;
                i2 = i3;
                str4 = str5;
            } else if (w.h(xmlPullParser, "SegmentList")) {
                hVar2 = a(xmlPullParser, (h.b) hVar2);
                z = z2;
                str2 = attributeValue3;
                i = d;
                str3 = str6;
                i2 = i3;
                str4 = str5;
            } else if (w.h(xmlPullParser, "SegmentTemplate")) {
                hVar2 = a(xmlPullParser, (h.c) hVar2);
                z = z2;
                str2 = attributeValue3;
                i = d;
                str3 = str6;
                i2 = i3;
                str4 = str5;
            } else if (w.h(xmlPullParser, "InbandEventStream")) {
                arrayList2.add(b(xmlPullParser, "InbandEventStream"));
                z = z2;
                str2 = attributeValue3;
                i = d;
                str3 = str6;
                i2 = i3;
                str4 = str5;
            } else {
                if (w.w(xmlPullParser)) {
                    g(xmlPullParser);
                }
                z = z2;
                str2 = attributeValue3;
                i = d;
                str3 = str6;
                i2 = i3;
                str4 = str5;
            }
            if (w.g(xmlPullParser, "AdaptationSet")) {
                break;
            }
            str5 = str4;
            d = i;
            attributeValue3 = str2;
            i3 = i2;
            str6 = str3;
            z2 = z;
        }
        ArrayList arrayList6 = new ArrayList(arrayList5.size());
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < arrayList5.size()) {
                arrayList6.add(a((a) arrayList5.get(i6), this.muT, str4, arrayList, arrayList2));
                i5 = i6 + 1;
            } else {
                return a(a2, i, arrayList6, arrayList3, arrayList4);
            }
        }
    }

    protected com.google.android.exoplayer2.source.dash.manifest.a a(int i, int i2, List<g> list, List<d> list2, List<d> list3) {
        return new com.google.android.exoplayer2.source.dash.manifest.a(i, i2, list, list2, list3);
    }

    protected int d(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, CameraActivityConfig.KEY_CONTENT_TYPE);
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    protected int n(Format format) {
        String str = format.sampleMimeType;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (com.google.android.exoplayer2.util.i.OQ(str)) {
            return 2;
        }
        if (com.google.android.exoplayer2.util.i.Qo(str)) {
            return 1;
        }
        return PF(str) ? 3 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Pair<String, DrmInitData.SchemeData> e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean z;
        UUID uuid;
        byte[] bArr;
        String str;
        String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue != null) {
            String QB = v.QB(attributeValue);
            char c = 65535;
            switch (QB.hashCode()) {
                case 489446379:
                    if (QB.equals("urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95")) {
                        c = 1;
                        break;
                    }
                    break;
                case 755418770:
                    if (QB.equals("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1812765994:
                    if (QB.equals("urn:mpeg:dash:mp4protection:2011")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "value");
                    String attributeValue3 = xmlPullParser.getAttributeValue(null, "cenc:default_KID");
                    if (attributeValue3 != null && !"00000000-0000-0000-0000-000000000000".equals(attributeValue3)) {
                        str = attributeValue2;
                        bArr = com.google.android.exoplayer2.extractor.c.h.a(com.google.android.exoplayer2.b.lYe, new UUID[]{UUID.fromString(attributeValue3)}, null);
                        uuid = com.google.android.exoplayer2.b.lYe;
                        z = false;
                        break;
                    } else {
                        z = false;
                        uuid = null;
                        str = attributeValue2;
                        bArr = null;
                        break;
                    }
                    break;
                case 1:
                    uuid = com.google.android.exoplayer2.b.lYh;
                    bArr = null;
                    str = null;
                    z = false;
                    break;
                case 2:
                    uuid = com.google.android.exoplayer2.b.lYg;
                    bArr = null;
                    str = null;
                    z = false;
                    break;
            }
            do {
                xmlPullParser.next();
                if (!w.h(xmlPullParser, "widevine:license")) {
                    String attributeValue4 = xmlPullParser.getAttributeValue(null, "robustness_level");
                    z = attributeValue4 != null && attributeValue4.startsWith("HW");
                } else if (bArr == null) {
                    if (w.h(xmlPullParser, "cenc:pssh") && xmlPullParser.next() == 4) {
                        bArr = Base64.decode(xmlPullParser.getText(), 0);
                        uuid = com.google.android.exoplayer2.extractor.c.h.au(bArr);
                        if (uuid == null) {
                            Log.w("MpdParser", "Skipping malformed cenc:pssh data");
                            bArr = null;
                        }
                    } else if (uuid == com.google.android.exoplayer2.b.lYh && w.h(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                        bArr = com.google.android.exoplayer2.extractor.c.h.a(com.google.android.exoplayer2.b.lYh, Base64.decode(xmlPullParser.getText(), 0));
                    }
                }
            } while (!w.g(xmlPullParser, "ContentProtection"));
            return Pair.create(str, uuid != null ? new DrmInitData.SchemeData(uuid, MimeType.Video.MP4, bArr, z) : null);
        }
        z = false;
        uuid = null;
        bArr = null;
        str = null;
        do {
            xmlPullParser.next();
            if (!w.h(xmlPullParser, "widevine:license")) {
            }
        } while (!w.g(xmlPullParser, "ContentProtection"));
        return Pair.create(str, uuid != null ? new DrmInitData.SchemeData(uuid, MimeType.Video.MP4, bArr, z) : null);
    }

    protected int f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String b = b(xmlPullParser, "schemeIdUri", (String) null);
        String b2 = b(xmlPullParser, "value", (String) null);
        do {
            xmlPullParser.next();
        } while (!w.g(xmlPullParser, "Role"));
        return ("urn:mpeg:dash:role:2011".equals(b) && "main".equals(b2)) ? 1 : 0;
    }

    protected void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
    }

    protected a a(XmlPullParser xmlPullParser, String str, String str2, String str3, int i, int i2, float f, int i3, int i4, String str4, int i5, List<d> list, h hVar) throws XmlPullParserException, IOException {
        h.e eVar;
        String str5;
        boolean z;
        String str6;
        int i6;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int a2 = a(xmlPullParser, "bandwidth", -1);
        String b = b(xmlPullParser, "mimeType", str2);
        String b2 = b(xmlPullParser, "codecs", str3);
        int a3 = a(xmlPullParser, "width", i);
        int a4 = a(xmlPullParser, "height", i2);
        float a5 = a(xmlPullParser, f);
        int a6 = a(xmlPullParser, "audioSamplingRate", i4);
        String str7 = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
        int i7 = i3;
        h hVar2 = hVar;
        String str8 = str;
        while (true) {
            xmlPullParser.next();
            if (w.h(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    String c = c(xmlPullParser, str8);
                    str6 = str7;
                    eVar = hVar2;
                    str5 = c;
                    z = true;
                    i6 = i7;
                }
                i6 = i7;
                eVar = hVar2;
                str5 = str8;
                str6 = str7;
                z = z2;
            } else if (w.h(xmlPullParser, "AudioChannelConfiguration")) {
                i6 = k(xmlPullParser);
                eVar = hVar2;
                str5 = str8;
                z = z2;
                str6 = str7;
            } else if (w.h(xmlPullParser, "SegmentBase")) {
                i6 = i7;
                eVar = a(xmlPullParser, (h.e) hVar2);
                str5 = str8;
                str6 = str7;
                z = z2;
            } else if (w.h(xmlPullParser, "SegmentList")) {
                i6 = i7;
                eVar = a(xmlPullParser, (h.b) hVar2);
                str5 = str8;
                str6 = str7;
                z = z2;
            } else if (w.h(xmlPullParser, "SegmentTemplate")) {
                i6 = i7;
                eVar = a(xmlPullParser, (h.c) hVar2);
                str5 = str8;
                str6 = str7;
                z = z2;
            } else if (w.h(xmlPullParser, "ContentProtection")) {
                Pair<String, DrmInitData.SchemeData> e = e(xmlPullParser);
                String str9 = e.first != null ? (String) e.first : str7;
                if (e.second != null) {
                    arrayList.add(e.second);
                }
                eVar = hVar2;
                str5 = str8;
                z = z2;
                str6 = str9;
                i6 = i7;
            } else {
                if (w.h(xmlPullParser, "InbandEventStream")) {
                    arrayList2.add(b(xmlPullParser, "InbandEventStream"));
                }
                i6 = i7;
                eVar = hVar2;
                str5 = str8;
                str6 = str7;
                z = z2;
            }
            if (w.g(xmlPullParser, "Representation")) {
                break;
            }
            z2 = z;
            str7 = str6;
            i7 = i6;
            hVar2 = eVar;
            str8 = str5;
        }
        return new a(a(attributeValue, b, a3, a4, a5, i6, a6, a2, str4, i5, list, b2), str5, eVar != null ? eVar : new h.e(), str6, arrayList, arrayList2);
    }

    protected Format a(String str, String str2, int i, int i2, float f, int i3, int i4, int i5, String str3, int i6, List<d> list, String str4) {
        int i7;
        String fp = fp(str2, str4);
        if (fp != null) {
            if (com.google.android.exoplayer2.util.i.OQ(fp)) {
                return Format.a(str, str2, fp, str4, i5, i, i2, f, (List<byte[]>) null, i6);
            }
            if (com.google.android.exoplayer2.util.i.Qo(fp)) {
                return Format.a(str, str2, fp, str4, i5, i3, i4, (List<byte[]>) null, i6, str3);
            }
            if (PF(fp)) {
                if ("application/cea-608".equals(fp)) {
                    i7 = ff(list);
                } else if ("application/cea-708".equals(fp)) {
                    i7 = fg(list);
                } else {
                    i7 = -1;
                }
                return Format.a(str, str2, fp, str4, i5, i6, str3, i7);
            }
        }
        return Format.e(str, str2, fp, str4, i5, i6, str3);
    }

    protected g a(a aVar, String str, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<d> arrayList2) {
        Format format = aVar.lZw;
        if (aVar.muW != null) {
            str2 = aVar.muW;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = aVar.muX;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            be(arrayList3);
            format = format.a(new DrmInitData(str2, arrayList3));
        }
        ArrayList<d> arrayList4 = aVar.muY;
        arrayList4.addAll(arrayList2);
        return g.a(str, -1L, format, aVar.baseUrl, aVar.muV, arrayList4);
    }

    protected h.e a(XmlPullParser xmlPullParser, h.e eVar) throws XmlPullParserException, IOException {
        long j;
        long d = d(xmlPullParser, "timescale", eVar != null ? eVar.timescale : 1L);
        long d2 = d(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.mvk : 0L);
        long j2 = eVar != null ? eVar.mvq : 0L;
        long j3 = eVar != null ? eVar.mvr : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            long parseLong = Long.parseLong(split[0]);
            j3 = (Long.parseLong(split[1]) - parseLong) + 1;
            j = parseLong;
        } else {
            j = j2;
        }
        f fVar = eVar != null ? eVar.mvj : null;
        while (true) {
            xmlPullParser.next();
            f i = w.h(xmlPullParser, "Initialization") ? i(xmlPullParser) : fVar;
            if (w.g(xmlPullParser, "SegmentBase")) {
                return a(i, d, d2, j, j3);
            }
            fVar = i;
        }
    }

    protected h.e a(f fVar, long j, long j2, long j3, long j4) {
        return new h.e(fVar, j, j2, j3, j4);
    }

    protected h.b a(XmlPullParser xmlPullParser, h.b bVar) throws XmlPullParserException, IOException {
        List<f> list;
        f fVar;
        List<h.d> list2;
        f fVar2 = null;
        long d = d(xmlPullParser, "timescale", bVar != null ? bVar.timescale : 1L);
        long d2 = d(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.mvk : 0L);
        long d3 = d(xmlPullParser, "duration", bVar != null ? bVar.duration : -9223372036854775807L);
        int a2 = a(xmlPullParser, "startNumber", bVar != null ? bVar.mvl : 1);
        List<f> list3 = null;
        List<h.d> list4 = null;
        do {
            xmlPullParser.next();
            if (w.h(xmlPullParser, "Initialization")) {
                fVar2 = i(xmlPullParser);
            } else if (w.h(xmlPullParser, "SegmentTimeline")) {
                list4 = h(xmlPullParser);
            } else if (w.h(xmlPullParser, "SegmentURL")) {
                if (list3 == null) {
                    list3 = new ArrayList<>();
                }
                list3.add(j(xmlPullParser));
            }
        } while (!w.g(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            f fVar3 = fVar2 != null ? fVar2 : bVar.mvj;
            list2 = list4 != null ? list4 : bVar.mvm;
            if (list3 == null) {
                list3 = bVar.mvn;
            }
            fVar = fVar3;
            list = list3;
        } else {
            list = list3;
            List<h.d> list5 = list4;
            fVar = fVar2;
            list2 = list5;
        }
        return a(fVar, d, d2, a2, d3, list2, list);
    }

    protected h.b a(f fVar, long j, long j2, int i, long j3, List<h.d> list, List<f> list2) {
        return new h.b(fVar, j, j2, i, j3, list, list2);
    }

    protected h.c a(XmlPullParser xmlPullParser, h.c cVar) throws XmlPullParserException, IOException {
        List<h.d> list;
        long d = d(xmlPullParser, "timescale", cVar != null ? cVar.timescale : 1L);
        long d2 = d(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.mvk : 0L);
        long d3 = d(xmlPullParser, "duration", cVar != null ? cVar.duration : -9223372036854775807L);
        int a2 = a(xmlPullParser, "startNumber", cVar != null ? cVar.mvl : 1);
        j a3 = a(xmlPullParser, "media", cVar != null ? cVar.mvp : null);
        j a4 = a(xmlPullParser, "initialization", cVar != null ? cVar.mvo : null);
        List<h.d> list2 = null;
        f fVar = null;
        do {
            xmlPullParser.next();
            if (w.h(xmlPullParser, "Initialization")) {
                fVar = i(xmlPullParser);
            } else if (w.h(xmlPullParser, "SegmentTimeline")) {
                list2 = h(xmlPullParser);
            }
        } while (!w.g(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (fVar == null) {
                fVar = cVar.mvj;
            }
            if (list2 == null) {
                list2 = cVar.mvm;
            }
            list = list2;
        } else {
            list = list2;
        }
        return a(fVar, d, d2, a2, d3, list, a4, a3);
    }

    protected h.c a(f fVar, long j, long j2, int i, long j3, List<h.d> list, j jVar, j jVar2) {
        return new h.c(fVar, j, j2, i, j3, list, jVar, jVar2);
    }

    protected List<h.d> h(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        do {
            xmlPullParser.next();
            if (w.h(xmlPullParser, ExifInterface.LATITUDE_SOUTH)) {
                j = d(xmlPullParser, "t", j);
                long d = d(xmlPullParser, "d", -9223372036854775807L);
                int a2 = a(xmlPullParser, "r", 0) + 1;
                int i = 0;
                while (i < a2) {
                    arrayList.add(U(j, d));
                    i++;
                    j += d;
                }
            }
        } while (!w.g(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    protected h.d U(long j, long j2) {
        return new h.d(j, j2);
    }

    protected j a(XmlPullParser xmlPullParser, String str, j jVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return j.PI(attributeValue);
        }
        return jVar;
    }

    protected f i(XmlPullParser xmlPullParser) {
        return a(xmlPullParser, "sourceURL", "range");
    }

    protected f j(XmlPullParser xmlPullParser) {
        return a(xmlPullParser, "media", "mediaRange");
    }

    protected f a(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        long j = 0;
        long j2 = -1;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            j = Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = (Long.parseLong(split[1]) - j) + 1;
            }
        }
        return h(attributeValue, j, j2);
    }

    protected f h(String str, long j, long j2) {
        return new f(str, j, j2);
    }

    protected int k(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = -1;
        String b = b(xmlPullParser, "schemeIdUri", (String) null);
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(b)) {
            i = a(xmlPullParser, "value", -1);
        } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(b)) {
            i = l(xmlPullParser);
        }
        do {
            xmlPullParser.next();
        } while (!w.g(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }

    private static void be(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        if (!arrayList.get(i2).a(schemeData)) {
                            i = i2 + 1;
                        } else {
                            arrayList.remove(size);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static String fp(String str, String str2) {
        if (com.google.android.exoplayer2.util.i.Qo(str)) {
            return com.google.android.exoplayer2.util.i.Qr(str2);
        }
        if (com.google.android.exoplayer2.util.i.OQ(str)) {
            return com.google.android.exoplayer2.util.i.Qq(str2);
        }
        if (!PF(str)) {
            if ("application/mp4".equals(str)) {
                if (SubtitleSampleEntry.TYPE1.equals(str2)) {
                    return "application/ttml+xml";
                }
                if ("wvtt".equals(str2)) {
                    return "application/x-mp4-vtt";
                }
            } else if ("application/x-rawcc".equals(str)) {
                if (str2 != null) {
                    if (str2.contains("cea708")) {
                        return "application/cea-708";
                    }
                    if (str2.contains("eia608") || str2.contains("cea608")) {
                        return "application/cea-608";
                    }
                }
                return null;
            }
            return null;
        }
        return str;
    }

    private static boolean PF(String str) {
        return com.google.android.exoplayer2.util.i.Qp(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str) || "application/cea-608".equals(str);
    }

    private static String fq(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 != null) {
            com.google.android.exoplayer2.util.a.checkState(str.equals(str2));
            return str;
        }
        return str;
    }

    private static int dO(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 != -1) {
            com.google.android.exoplayer2.util.a.checkState(i == i2);
            return i;
        }
        return i;
    }

    protected static d b(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String b = b(xmlPullParser, "schemeIdUri", "");
        String b2 = b(xmlPullParser, "value", (String) null);
        String b3 = b(xmlPullParser, "id", (String) null);
        do {
            xmlPullParser.next();
        } while (!w.g(xmlPullParser, str));
        return new d(b, b2, b3);
    }

    protected static int ff(List<d> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                d dVar = list.get(i2);
                if ("urn:scte:dash:cc:cea-608:2015".equals(dVar.schemeIdUri) && dVar.value != null) {
                    Matcher matcher = muR.matcher(dVar.value);
                    if (matcher.matches()) {
                        return Integer.parseInt(matcher.group(1));
                    }
                    Log.w("MpdParser", "Unable to parse CEA-608 channel number from: " + dVar.value);
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    protected static int fg(List<d> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                d dVar = list.get(i2);
                if ("urn:scte:dash:cc:cea-708:2015".equals(dVar.schemeIdUri) && dVar.value != null) {
                    Matcher matcher = muS.matcher(dVar.value);
                    if (matcher.matches()) {
                        return Integer.parseInt(matcher.group(1));
                    }
                    Log.w("MpdParser", "Unable to parse CEA-708 service block number from: " + dVar.value);
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    protected static float a(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue != null) {
            Matcher matcher = muQ.matcher(attributeValue);
            if (matcher.matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                String group = matcher.group(2);
                if (!TextUtils.isEmpty(group)) {
                    return parseInt / Integer.parseInt(group);
                }
                return parseInt;
            }
            return f;
        }
        return f;
    }

    protected static long b(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : v.QC(attributeValue);
    }

    protected static long c(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : v.QD(attributeValue);
    }

    protected static String c(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return u.ft(str, xmlPullParser.getText());
    }

    protected static int a(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    protected static long d(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    protected static String b(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected static int l(XmlPullParser xmlPullParser) {
        char c;
        String QB = v.QB(xmlPullParser.getAttributeValue(null, "value"));
        if (QB == null) {
            return -1;
        }
        switch (QB.hashCode()) {
            case 1596796:
                if (QB.equals("4000")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2937391:
                if (QB.equals("a000")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3094035:
                if (QB.equals("f801")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3133436:
                if (QB.equals("fa01")) {
                    c = 3;
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
                return 1;
            case 1:
                return 2;
            case 2:
                return 6;
            case 3:
                return 8;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final String baseUrl;
        public final Format lZw;
        public final h muV;
        public final String muW;
        public final ArrayList<DrmInitData.SchemeData> muX;
        public final ArrayList<d> muY;

        public a(Format format, String str, h hVar, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<d> arrayList2) {
            this.lZw = format;
            this.baseUrl = str;
            this.muV = hVar;
            this.muW = str2;
            this.muX = arrayList;
            this.muY = arrayList2;
        }
    }
}
