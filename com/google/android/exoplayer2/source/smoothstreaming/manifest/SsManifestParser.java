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
/* loaded from: classes5.dex */
public class SsManifestParser implements p.a<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> {
    private final XmlPullParserFactory muo;

    public SsManifestParser() {
        try {
            this.muo = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.p.a
    /* renamed from: e */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a b(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.muo.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (com.google.android.exoplayer2.source.smoothstreaming.manifest.a) new d(null, uri.toString()).m(newPullParser);
        } catch (XmlPullParserException e2) {
            throw new ParserException(e2);
        }
    }

    /* loaded from: classes5.dex */
    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super("Missing required field: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class a {
        private final String mws;
        private final a mxF;
        private final List<Pair<String, Object>> mxG = new LinkedList();
        private final String tag;

        protected abstract Object dwv();

        public a(a aVar, String str, String str2) {
            this.mxF = aVar;
            this.mws = str;
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
                        } else if (PD(name)) {
                            n(xmlPullParser);
                            break;
                        } else {
                            a a = a(this, name, this.mws);
                            if (a != null) {
                                bx(a.m(xmlPullParser));
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
                            if (PD(name2)) {
                                break;
                            } else {
                                return dwv();
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
            this.mxG.add(Pair.create(str, obj));
        }

        protected final Object PC(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mxG.size()) {
                    Pair<String, Object> pair = this.mxG.get(i2);
                    if (!((String) pair.first).equals(str)) {
                        i = i2 + 1;
                    } else {
                        return pair.second;
                    }
                } else if (this.mxF == null) {
                    return null;
                } else {
                    return this.mxF.PC(str);
                }
            }
        }

        protected boolean PD(String str) {
            return false;
        }

        protected void n(XmlPullParser xmlPullParser) throws ParserException {
        }

        protected void o(XmlPullParser xmlPullParser) {
        }

        protected void p(XmlPullParser xmlPullParser) {
        }

        protected void bx(Object obj) {
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
    /* loaded from: classes5.dex */
    public static class d extends a {
        private long duration;
        private int lFP;
        private int lFQ;
        private final List<a.b> mxJ;
        private long mxK;
        private boolean mxc;
        private int mxx;
        private a.C0675a mxy;
        private long timescale;

        public d(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
            this.mxx = -1;
            this.mxy = null;
            this.mxJ = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            this.lFP = e(xmlPullParser, "MajorVersion");
            this.lFQ = e(xmlPullParser, "MinorVersion");
            this.timescale = d(xmlPullParser, "TimeScale", 10000000L);
            this.duration = f(xmlPullParser, "Duration");
            this.mxK = d(xmlPullParser, "DVRWindowLength", 0L);
            this.mxx = a(xmlPullParser, "LookaheadCount", -1);
            this.mxc = a(xmlPullParser, "IsLive", false);
            D("TimeScale", Long.valueOf(this.timescale));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void bx(Object obj) {
            if (obj instanceof a.b) {
                this.mxJ.add((a.b) obj);
            } else if (obj instanceof a.C0675a) {
                com.google.android.exoplayer2.util.a.checkState(this.mxy == null);
                this.mxy = (a.C0675a) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dwv() {
            a.b[] bVarArr = new a.b[this.mxJ.size()];
            this.mxJ.toArray(bVarArr);
            if (this.mxy != null) {
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(this.mxy.uuid, MimeType.Video.MP4, this.mxy.data));
                for (a.b bVar : bVarArr) {
                    for (int i = 0; i < bVar.mrN.length; i++) {
                        bVar.mrN[i] = bVar.mrN[i].a(drmInitData);
                    }
                }
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a(this.lFP, this.lFQ, this.timescale, this.duration, this.mxK, this.mxx, this.mxc, this.mxy, bVarArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends a {
        private boolean mxH;
        private byte[] mxI;
        private UUID uuid;

        public b(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean PD(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.mxH = true;
                this.uuid = UUID.fromString(PE(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void o(XmlPullParser xmlPullParser) {
            if (this.mxH) {
                this.mxI = Base64.decode(xmlPullParser.getText(), 0);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void p(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.mxH = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dwv() {
            return new a.C0675a(this.uuid, h.a(this.uuid, this.mxI));
        }

        private static String PE(String str) {
            if (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') {
                return str.substring(1, str.length() - 1);
            }
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e extends a {
        private String language;
        private int maxHeight;
        private int maxWidth;
        private int mfv;
        private int mfw;
        private final String mws;
        private final List<Format> mxL;
        private ArrayList<Long> mxM;
        private long mxN;
        private String name;
        private String subType;
        private long timescale;
        private int type;
        private String url;

        public e(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.mws = str;
            this.mxL = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean PD(String str) {
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
            int size = this.mxM.size();
            long d = d(xmlPullParser, "t", -9223372036854775807L);
            if (d == -9223372036854775807L) {
                if (size == 0) {
                    d = 0;
                } else if (this.mxN != -1) {
                    d = this.mxM.get(size - 1).longValue() + this.mxN;
                } else {
                    throw new ParserException("Unable to infer start time");
                }
            }
            int i = size + 1;
            this.mxM.add(Long.valueOf(d));
            this.mxN = d(xmlPullParser, "d", -9223372036854775807L);
            long d2 = d(xmlPullParser, "r", 1L);
            if (d2 > 1 && this.mxN == -9223372036854775807L) {
                throw new ParserException("Repeated chunk with unspecified duration");
            }
            for (int i2 = 1; i2 < d2; i2++) {
                i++;
                this.mxM.add(Long.valueOf((this.mxN * i2) + d));
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
            this.mfv = a(xmlPullParser, "DisplayWidth", -1);
            this.mfw = a(xmlPullParser, "DisplayHeight", -1);
            this.language = xmlPullParser.getAttributeValue(null, "Language");
            D("Language", this.language);
            this.timescale = a(xmlPullParser, "TimeScale", -1);
            if (this.timescale == -1) {
                this.timescale = ((Long) PC("TimeScale")).longValue();
            }
            this.mxM = new ArrayList<>();
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
        public void bx(Object obj) {
            if (obj instanceof Format) {
                this.mxL.add((Format) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dwv() {
            Format[] formatArr = new Format[this.mxL.size()];
            this.mxL.toArray(formatArr);
            return new a.b(this.mws, this.url, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.mfv, this.mfw, this.language, formatArr, this.mxM, this.mxN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c extends a {
        private Format lYQ;

        public c(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            int intValue = ((Integer) PC("Type")).intValue();
            String attributeValue = xmlPullParser.getAttributeValue(null, "Index");
            int e = e(xmlPullParser, "Bitrate");
            String PG = PG(d(xmlPullParser, "FourCC"));
            if (intValue == 2) {
                this.lYQ = Format.a(attributeValue, MimeType.Video.MP4, PG, (String) null, e, e(xmlPullParser, "MaxWidth"), e(xmlPullParser, "MaxHeight"), -1.0f, PF(xmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
            } else if (intValue == 1) {
                if (PG == null) {
                    PG = "audio/mp4a-latm";
                }
                int e2 = e(xmlPullParser, "Channels");
                int e3 = e(xmlPullParser, "SamplingRate");
                List<byte[]> PF = PF(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (PF.isEmpty() && "audio/mp4a-latm".equals(PG)) {
                    PF = Collections.singletonList(com.google.android.exoplayer2.util.c.dT(e3, e2));
                }
                this.lYQ = Format.a(attributeValue, MimeType.Audio.M4A, PG, (String) null, e, e2, e3, PF, 0, (String) PC("Language"));
            } else if (intValue == 3) {
                this.lYQ = Format.b(attributeValue, "application/mp4", PG, null, e, 0, (String) PC("Language"));
            } else {
                this.lYQ = Format.c(attributeValue, "application/mp4", PG, null, e, 0, null);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dwv() {
            return this.lYQ;
        }

        private static List<byte[]> PF(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] Qs = v.Qs(str);
                byte[][] av = com.google.android.exoplayer2.util.c.av(Qs);
                if (av == null) {
                    arrayList.add(Qs);
                } else {
                    Collections.addAll(arrayList, av);
                }
            }
            return arrayList;
        }

        private static String PG(String str) {
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
