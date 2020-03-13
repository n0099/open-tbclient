package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.android.util.media.MimeType;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.c.h;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.util.v;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes6.dex */
public class SsManifestParser implements p.a<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> {
    private final XmlPullParserFactory mvh;

    public SsManifestParser() {
        try {
            this.mvh = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.p.a
    /* renamed from: e */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a b(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.mvh.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (com.google.android.exoplayer2.source.smoothstreaming.manifest.a) new d(null, uri.toString()).m(newPullParser);
        } catch (XmlPullParserException e2) {
            throw new ParserException(e2);
        }
    }

    /* loaded from: classes6.dex */
    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super("Missing required field: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static abstract class a {
        private final String mxl;
        private final a myy;
        private final List<Pair<String, Object>> myz = new LinkedList();
        private final String tag;

        protected abstract Object dxI();

        public a(a aVar, String str, String str2) {
            this.myy = aVar;
            this.mxl = str;
            this.tag = str2;
        }

        public final Object m(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            int i = 0;
            boolean z = false;
            while (true) {
                switch (xmlPullParser.getEventType()) {
                    case 1:
                        return null;
                    case 2:
                        String name = xmlPullParser.getName();
                        if (this.tag.equals(name)) {
                            n(xmlPullParser);
                            z = true;
                            break;
                        } else if (!z) {
                            break;
                        } else if (i > 0) {
                            i++;
                            break;
                        } else if (PR(name)) {
                            n(xmlPullParser);
                            break;
                        } else {
                            a a = a(this, name, this.mxl);
                            if (a != null) {
                                bz(a.m(xmlPullParser));
                                break;
                            } else {
                                i = 1;
                                break;
                            }
                        }
                    case 3:
                        if (!z) {
                            continue;
                        } else if (i > 0) {
                            i--;
                            break;
                        } else {
                            String name2 = xmlPullParser.getName();
                            p(xmlPullParser);
                            if (PR(name2)) {
                                break;
                            } else {
                                return dxI();
                            }
                        }
                    case 4:
                        if (z && i == 0) {
                            o(xmlPullParser);
                            break;
                        }
                        break;
                }
                xmlPullParser.next();
            }
        }

        private a a(a aVar, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new c(aVar, str2);
            }
            if ("Protection".equals(str)) {
                return new b(aVar, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new e(aVar, str2);
            }
            return null;
        }

        protected final void D(String str, Object obj) {
            this.myz.add(Pair.create(str, obj));
        }

        protected final Object PQ(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.myz.size()) {
                    Pair<String, Object> pair = this.myz.get(i2);
                    if (!((String) pair.first).equals(str)) {
                        i = i2 + 1;
                    } else {
                        return pair.second;
                    }
                } else if (this.myy == null) {
                    return null;
                } else {
                    return this.myy.PQ(str);
                }
            }
        }

        protected boolean PR(String str) {
            return false;
        }

        protected void n(XmlPullParser xmlPullParser) throws ParserException {
        }

        protected void o(XmlPullParser xmlPullParser) {
        }

        protected void p(XmlPullParser xmlPullParser) {
        }

        protected void bz(Object obj) {
        }

        protected final String d(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        protected final int a(XmlPullParser xmlPullParser, String str, int i) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e) {
                    throw new ParserException(e);
                }
            }
            return i;
        }

        protected final int e(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e) {
                    throw new ParserException(e);
                }
            }
            throw new MissingFieldException(str);
        }

        protected final long d(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e) {
                    throw new ParserException(e);
                }
            }
            return j;
        }

        protected final long f(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e) {
                    throw new ParserException(e);
                }
            }
            throw new MissingFieldException(str);
        }

        protected final boolean a(XmlPullParser xmlPullParser, String str, boolean z) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return Boolean.parseBoolean(attributeValue);
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class d extends a {
        private long duration;
        private int lGJ;
        private int lGK;
        private boolean mxV;
        private final List<a.b> myC;
        private long myD;
        private int myq;
        private a.C0683a myr;
        private long timescale;

        public d(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
            this.myq = -1;
            this.myr = null;
            this.myC = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            this.lGJ = e(xmlPullParser, "MajorVersion");
            this.lGK = e(xmlPullParser, "MinorVersion");
            this.timescale = d(xmlPullParser, "TimeScale", 10000000L);
            this.duration = f(xmlPullParser, "Duration");
            this.myD = d(xmlPullParser, "DVRWindowLength", 0L);
            this.myq = a(xmlPullParser, "LookaheadCount", -1);
            this.mxV = a(xmlPullParser, "IsLive", false);
            D("TimeScale", Long.valueOf(this.timescale));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void bz(Object obj) {
            if (obj instanceof a.b) {
                this.myC.add((a.b) obj);
            } else if (obj instanceof a.C0683a) {
                com.google.android.exoplayer2.util.a.checkState(this.myr == null);
                this.myr = (a.C0683a) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dxI() {
            a.b[] bVarArr = new a.b[this.myC.size()];
            this.myC.toArray(bVarArr);
            if (this.myr != null) {
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(this.myr.uuid, MimeType.Video.MP4, this.myr.data));
                for (a.b bVar : bVarArr) {
                    for (int i = 0; i < bVar.msH.length; i++) {
                        bVar.msH[i] = bVar.msH[i].a(drmInitData);
                    }
                }
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a(this.lGJ, this.lGK, this.timescale, this.duration, this.myD, this.myq, this.mxV, this.myr, bVarArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends a {
        private boolean myA;
        private byte[] myB;
        private UUID uuid;

        public b(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean PR(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.myA = true;
                this.uuid = UUID.fromString(PS(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void o(XmlPullParser xmlPullParser) {
            if (this.myA) {
                this.myB = Base64.decode(xmlPullParser.getText(), 0);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void p(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.myA = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dxI() {
            return new a.C0683a(this.uuid, h.a(this.uuid, this.myB));
        }

        private static String PS(String str) {
            if (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') {
                return str.substring(1, str.length() - 1);
            }
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e extends a {
        private String language;
        private int maxHeight;
        private int maxWidth;
        private int mgo;
        private int mgp;
        private final String mxl;
        private final List<Format> myE;
        private ArrayList<Long> myF;
        private long myG;
        private String name;
        private String subType;
        private long timescale;
        private int type;
        private String url;

        public e(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.mxl = str;
            this.myE = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean PR(String str) {
            return "c".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            if ("c".equals(xmlPullParser.getName())) {
                q(xmlPullParser);
            } else {
                r(xmlPullParser);
            }
        }

        private void q(XmlPullParser xmlPullParser) throws ParserException {
            int size = this.myF.size();
            long d = d(xmlPullParser, "t", -9223372036854775807L);
            if (d == -9223372036854775807L) {
                if (size == 0) {
                    d = 0;
                } else if (this.myG != -1) {
                    d = this.myF.get(size - 1).longValue() + this.myG;
                } else {
                    throw new ParserException("Unable to infer start time");
                }
            }
            int i = size + 1;
            this.myF.add(Long.valueOf(d));
            this.myG = d(xmlPullParser, "d", -9223372036854775807L);
            long d2 = d(xmlPullParser, "r", 1L);
            if (d2 > 1 && this.myG == -9223372036854775807L) {
                throw new ParserException("Repeated chunk with unspecified duration");
            }
            for (int i2 = 1; i2 < d2; i2++) {
                i++;
                this.myF.add(Long.valueOf((this.myG * i2) + d));
            }
        }

        private void r(XmlPullParser xmlPullParser) throws ParserException {
            this.type = s(xmlPullParser);
            D("Type", Integer.valueOf(this.type));
            if (this.type == 3) {
                this.subType = d(xmlPullParser, "Subtype");
            } else {
                this.subType = xmlPullParser.getAttributeValue(null, "Subtype");
            }
            this.name = xmlPullParser.getAttributeValue(null, "Name");
            this.url = d(xmlPullParser, "Url");
            this.maxWidth = a(xmlPullParser, "MaxWidth", -1);
            this.maxHeight = a(xmlPullParser, "MaxHeight", -1);
            this.mgo = a(xmlPullParser, "DisplayWidth", -1);
            this.mgp = a(xmlPullParser, "DisplayHeight", -1);
            this.language = xmlPullParser.getAttributeValue(null, "Language");
            D("Language", this.language);
            this.timescale = a(xmlPullParser, "TimeScale", -1);
            if (this.timescale == -1) {
                this.timescale = ((Long) PQ("TimeScale")).longValue();
            }
            this.myF = new ArrayList<>();
        }

        private int s(XmlPullParser xmlPullParser) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue != null) {
                if ("audio".equalsIgnoreCase(attributeValue)) {
                    return 1;
                }
                if ("video".equalsIgnoreCase(attributeValue)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(attributeValue)) {
                    return 3;
                }
                throw new ParserException("Invalid key value[" + attributeValue + "]");
            }
            throw new MissingFieldException("Type");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void bz(Object obj) {
            if (obj instanceof Format) {
                this.myE.add((Format) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dxI() {
            Format[] formatArr = new Format[this.myE.size()];
            this.myE.toArray(formatArr);
            return new a.b(this.mxl, this.url, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.mgo, this.mgp, this.language, formatArr, this.myF, this.myG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c extends a {
        private Format lZJ;

        public c(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            int intValue = ((Integer) PQ("Type")).intValue();
            String attributeValue = xmlPullParser.getAttributeValue(null, "Index");
            int e = e(xmlPullParser, "Bitrate");
            String PU = PU(d(xmlPullParser, "FourCC"));
            if (intValue == 2) {
                this.lZJ = Format.a(attributeValue, MimeType.Video.MP4, PU, (String) null, e, e(xmlPullParser, "MaxWidth"), e(xmlPullParser, "MaxHeight"), -1.0f, PT(xmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
            } else if (intValue == 1) {
                if (PU == null) {
                    PU = "audio/mp4a-latm";
                }
                int e2 = e(xmlPullParser, "Channels");
                int e3 = e(xmlPullParser, "SamplingRate");
                List<byte[]> PT = PT(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (PT.isEmpty() && "audio/mp4a-latm".equals(PU)) {
                    PT = Collections.singletonList(com.google.android.exoplayer2.util.c.dW(e3, e2));
                }
                this.lZJ = Format.a(attributeValue, MimeType.Audio.M4A, PU, (String) null, e, e2, e3, PT, 0, (String) PQ("Language"));
            } else if (intValue == 3) {
                this.lZJ = Format.d(attributeValue, "application/mp4", PU, null, e, 0, (String) PQ("Language"));
            } else {
                this.lZJ = Format.e(attributeValue, "application/mp4", PU, null, e, 0, null);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dxI() {
            return this.lZJ;
        }

        private static List<byte[]> PT(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] QG = v.QG(str);
                byte[][] aA = com.google.android.exoplayer2.util.c.aA(QG);
                if (aA == null) {
                    arrayList.add(QG);
                } else {
                    Collections.addAll(arrayList, aA);
                }
            }
            return arrayList;
        }

        private static String PU(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return "video/avc";
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return "audio/mp4a-latm";
            }
            if (str.equalsIgnoreCase("TTML")) {
                return "application/ttml+xml";
            }
            if (str.equalsIgnoreCase(AudioSampleEntry.TYPE8) || str.equalsIgnoreCase(AC3SpecificBox.TYPE)) {
                return "audio/ac3";
            }
            if (str.equalsIgnoreCase(AudioSampleEntry.TYPE9) || str.equalsIgnoreCase(EC3SpecificBox.TYPE)) {
                return "audio/eac3";
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (str.equalsIgnoreCase(AudioSampleEntry.TYPE12) || str.equalsIgnoreCase(AudioSampleEntry.TYPE11)) {
                return "audio/vnd.dts.hd";
            }
            if (str.equalsIgnoreCase(AudioSampleEntry.TYPE13)) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (str.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }
    }
}
