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
    private final XmlPullParserFactory muU;

    public SsManifestParser() {
        try {
            this.muU = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.p.a
    /* renamed from: e */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a b(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.muU.newPullParser();
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
        private final String mwY;
        private final a myl;
        private final List<Pair<String, Object>> mym = new LinkedList();
        private final String tag;

        protected abstract Object dxF();

        public a(a aVar, String str, String str2) {
            this.myl = aVar;
            this.mwY = str;
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
                        } else if (PQ(name)) {
                            n(xmlPullParser);
                            break;
                        } else {
                            a a = a(this, name, this.mwY);
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
                            if (PQ(name2)) {
                                break;
                            } else {
                                return dxF();
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
            this.mym.add(Pair.create(str, obj));
        }

        protected final Object PP(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mym.size()) {
                    Pair<String, Object> pair = this.mym.get(i2);
                    if (!((String) pair.first).equals(str)) {
                        i = i2 + 1;
                    } else {
                        return pair.second;
                    }
                } else if (this.myl == null) {
                    return null;
                } else {
                    return this.myl.PP(str);
                }
            }
        }

        protected boolean PQ(String str) {
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
        private int lGw;
        private int lGx;
        private boolean mxI;
        private int myd;
        private a.C0683a mye;
        private final List<a.b> myp;
        private long myq;
        private long timescale;

        public d(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
            this.myd = -1;
            this.mye = null;
            this.myp = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            this.lGw = e(xmlPullParser, "MajorVersion");
            this.lGx = e(xmlPullParser, "MinorVersion");
            this.timescale = d(xmlPullParser, "TimeScale", 10000000L);
            this.duration = f(xmlPullParser, "Duration");
            this.myq = d(xmlPullParser, "DVRWindowLength", 0L);
            this.myd = a(xmlPullParser, "LookaheadCount", -1);
            this.mxI = a(xmlPullParser, "IsLive", false);
            D("TimeScale", Long.valueOf(this.timescale));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void bz(Object obj) {
            if (obj instanceof a.b) {
                this.myp.add((a.b) obj);
            } else if (obj instanceof a.C0683a) {
                com.google.android.exoplayer2.util.a.checkState(this.mye == null);
                this.mye = (a.C0683a) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dxF() {
            a.b[] bVarArr = new a.b[this.myp.size()];
            this.myp.toArray(bVarArr);
            if (this.mye != null) {
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(this.mye.uuid, MimeType.Video.MP4, this.mye.data));
                for (a.b bVar : bVarArr) {
                    for (int i = 0; i < bVar.msu.length; i++) {
                        bVar.msu[i] = bVar.msu[i].a(drmInitData);
                    }
                }
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a(this.lGw, this.lGx, this.timescale, this.duration, this.myq, this.myd, this.mxI, this.mye, bVarArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends a {
        private boolean myn;
        private byte[] myo;
        private UUID uuid;

        public b(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean PQ(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.myn = true;
                this.uuid = UUID.fromString(PR(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void o(XmlPullParser xmlPullParser) {
            if (this.myn) {
                this.myo = Base64.decode(xmlPullParser.getText(), 0);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void p(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.myn = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dxF() {
            return new a.C0683a(this.uuid, h.a(this.uuid, this.myo));
        }

        private static String PR(String str) {
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
        private int mgb;
        private int mgc;
        private final String mwY;
        private final List<Format> myr;
        private ArrayList<Long> mys;
        private long myt;
        private String name;
        private String subType;
        private long timescale;
        private int type;
        private String url;

        public e(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.mwY = str;
            this.myr = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean PQ(String str) {
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
            int size = this.mys.size();
            long d = d(xmlPullParser, "t", -9223372036854775807L);
            if (d == -9223372036854775807L) {
                if (size == 0) {
                    d = 0;
                } else if (this.myt != -1) {
                    d = this.mys.get(size - 1).longValue() + this.myt;
                } else {
                    throw new ParserException("Unable to infer start time");
                }
            }
            int i = size + 1;
            this.mys.add(Long.valueOf(d));
            this.myt = d(xmlPullParser, "d", -9223372036854775807L);
            long d2 = d(xmlPullParser, "r", 1L);
            if (d2 > 1 && this.myt == -9223372036854775807L) {
                throw new ParserException("Repeated chunk with unspecified duration");
            }
            for (int i2 = 1; i2 < d2; i2++) {
                i++;
                this.mys.add(Long.valueOf((this.myt * i2) + d));
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
            this.mgb = a(xmlPullParser, "DisplayWidth", -1);
            this.mgc = a(xmlPullParser, "DisplayHeight", -1);
            this.language = xmlPullParser.getAttributeValue(null, "Language");
            D("Language", this.language);
            this.timescale = a(xmlPullParser, "TimeScale", -1);
            if (this.timescale == -1) {
                this.timescale = ((Long) PP("TimeScale")).longValue();
            }
            this.mys = new ArrayList<>();
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
                this.myr.add((Format) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dxF() {
            Format[] formatArr = new Format[this.myr.size()];
            this.myr.toArray(formatArr);
            return new a.b(this.mwY, this.url, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.mgb, this.mgc, this.language, formatArr, this.mys, this.myt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c extends a {
        private Format lZw;

        public c(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            int intValue = ((Integer) PP("Type")).intValue();
            String attributeValue = xmlPullParser.getAttributeValue(null, "Index");
            int e = e(xmlPullParser, "Bitrate");
            String PT = PT(d(xmlPullParser, "FourCC"));
            if (intValue == 2) {
                this.lZw = Format.a(attributeValue, MimeType.Video.MP4, PT, (String) null, e, e(xmlPullParser, "MaxWidth"), e(xmlPullParser, "MaxHeight"), -1.0f, PS(xmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
            } else if (intValue == 1) {
                if (PT == null) {
                    PT = "audio/mp4a-latm";
                }
                int e2 = e(xmlPullParser, "Channels");
                int e3 = e(xmlPullParser, "SamplingRate");
                List<byte[]> PS = PS(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (PS.isEmpty() && "audio/mp4a-latm".equals(PT)) {
                    PS = Collections.singletonList(com.google.android.exoplayer2.util.c.dW(e3, e2));
                }
                this.lZw = Format.a(attributeValue, MimeType.Audio.M4A, PT, (String) null, e, e2, e3, PS, 0, (String) PP("Language"));
            } else if (intValue == 3) {
                this.lZw = Format.d(attributeValue, "application/mp4", PT, null, e, 0, (String) PP("Language"));
            } else {
                this.lZw = Format.e(attributeValue, "application/mp4", PT, null, e, 0, null);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object dxF() {
            return this.lZw;
        }

        private static List<byte[]> PS(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] QF = v.QF(str);
                byte[][] aA = com.google.android.exoplayer2.util.c.aA(QF);
                if (aA == null) {
                    arrayList.add(QF);
                } else {
                    Collections.addAll(arrayList, aA);
                }
            }
            return arrayList;
        }

        private static String PT(String str) {
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
