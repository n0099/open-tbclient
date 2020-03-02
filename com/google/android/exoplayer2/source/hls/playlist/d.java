package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.util.Base64;
import com.baidu.android.util.media.MimeType;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.util.v;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class d implements p.a<c> {
    private static final Pattern mxb = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern mxc = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern mxd = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern mxe = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern mxf = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern mxg = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern mxh = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern mxi = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern mxj = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern mxk = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern mxl = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern mxm = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern mxn = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern mxo = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES)");
    private static final Pattern mxp = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern mxq = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern mxr = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern mxs = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern mxt = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern mxu = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern mxv = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern mxw = PO("AUTOSELECT");
    private static final Pattern mxx = PO("DEFAULT");
    private static final Pattern mxy = PO("FORCED");

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [156=4] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.p.a
    /* renamed from: d */
    public c b(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        c a2;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (b(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        v.closeQuietly(bufferedReader);
                        throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                    }
                    trim = readLine.trim();
                    if (!trim.isEmpty()) {
                        if (trim.startsWith("#EXT-X-STREAM-INF")) {
                            arrayDeque.add(trim);
                            a2 = a(new a(arrayDeque, bufferedReader), uri.toString());
                            break;
                        } else if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                            break;
                        } else {
                            arrayDeque.add(trim);
                        }
                    }
                }
                arrayDeque.add(trim);
                a2 = b(new a(arrayDeque, bufferedReader), uri.toString());
                return a2;
            }
            throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
        } finally {
            v.closeQuietly(bufferedReader);
        }
    }

    private static boolean b(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int a2 = a(bufferedReader, true, read);
        int length = "#EXTM3U".length();
        int i = a2;
        for (int i2 = 0; i2 < length; i2++) {
            if (i != "#EXTM3U".charAt(i2)) {
                return false;
            }
            i = bufferedReader.read();
        }
        return v.LY(a(bufferedReader, false, i));
    }

    private static int a(BufferedReader bufferedReader, boolean z, int i) throws IOException {
        while (i != -1 && Character.isWhitespace(i) && (z || !v.LY(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    private static com.google.android.exoplayer2.source.hls.playlist.a a(a aVar, String str) throws IOException {
        String str2;
        int parseInt;
        ArrayList arrayList;
        Format format;
        int i;
        int i2;
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Format format2 = null;
        ArrayList arrayList6 = null;
        boolean z = false;
        while (aVar.hasNext()) {
            String next = aVar.next();
            if (next.startsWith("#EXT")) {
                arrayList5.add(next);
            }
            if (next.startsWith("#EXT-X-MEDIA")) {
                int PN = PN(next);
                String c = c(next, mxq);
                String d = d(next, mxu);
                String c2 = c(next, mxt);
                String d2 = d(next, mxs);
                char c3 = 65535;
                switch (d2.hashCode()) {
                    case -959297733:
                        if (d2.equals("SUBTITLES")) {
                            c3 = 1;
                            break;
                        }
                        break;
                    case -333210994:
                        if (d2.equals("CLOSED-CAPTIONS")) {
                            c3 = 2;
                            break;
                        }
                        break;
                    case 62628790:
                        if (d2.equals("AUDIO")) {
                            c3 = 0;
                            break;
                        }
                        break;
                }
                switch (c3) {
                    case 0:
                        Format a2 = Format.a(d, "application/x-mpegURL", (String) null, (String) null, -1, -1, -1, (List<byte[]>) null, PN, c2);
                        if (c != null) {
                            arrayList3.add(new a.C0681a(c, a2));
                            arrayList = arrayList6;
                            format = format2;
                            break;
                        } else {
                            format = a2;
                            arrayList = arrayList6;
                            break;
                        }
                    case 1:
                        arrayList4.add(new a.C0681a(c, Format.d(d, "application/x-mpegURL", "text/vtt", null, -1, PN, c2)));
                        arrayList = arrayList6;
                        format = format2;
                        break;
                    case 2:
                        String d3 = d(next, mxv);
                        if (d3.startsWith("CC")) {
                            str2 = "application/cea-608";
                            parseInt = Integer.parseInt(d3.substring(2));
                        } else {
                            str2 = "application/cea-708";
                            parseInt = Integer.parseInt(d3.substring(7));
                        }
                        ArrayList arrayList7 = arrayList6 == null ? new ArrayList() : arrayList6;
                        arrayList7.add(Format.a(d, (String) null, str2, (String) null, -1, PN, c2, parseInt));
                        arrayList = arrayList7;
                        format = format2;
                        break;
                    default:
                        arrayList = arrayList6;
                        format = format2;
                        break;
                }
                arrayList6 = arrayList;
                format2 = format;
            } else if (next.startsWith("#EXT-X-STREAM-INF")) {
                boolean contains = z | next.contains("CLOSED-CAPTIONS=NONE");
                int a3 = a(next, mxc);
                String c4 = c(next, mxb);
                if (c4 != null) {
                    a3 = Integer.parseInt(c4);
                }
                String c5 = c(next, mxd);
                String c6 = c(next, mxe);
                if (c6 != null) {
                    String[] split = c6.split(Config.EVENT_HEAT_X);
                    int parseInt2 = Integer.parseInt(split[0]);
                    int parseInt3 = Integer.parseInt(split[1]);
                    if (parseInt2 <= 0 || parseInt3 <= 0) {
                        parseInt2 = -1;
                        parseInt3 = -1;
                    }
                    i2 = parseInt3;
                    i = parseInt2;
                } else {
                    i = -1;
                    i2 = -1;
                }
                float f = -1.0f;
                String c7 = c(next, mxf);
                if (c7 != null) {
                    f = Float.parseFloat(c7);
                }
                String next2 = aVar.next();
                if (hashSet.add(next2)) {
                    arrayList2.add(new a.C0681a(next2, Format.a(Integer.toString(arrayList2.size()), "application/x-mpegURL", (String) null, c5, a3, i, i2, f, (List<byte[]>) null, 0)));
                }
                z = contains;
            }
        }
        return new com.google.android.exoplayer2.source.hls.playlist.a(str, arrayList5, arrayList2, arrayList3, arrayList4, format2, z ? Collections.emptyList() : arrayList6);
    }

    private static int PN(String str) {
        return (a(str, mxx, false) ? 1 : 0) | (a(str, mxy, false) ? 2 : 0) | (a(str, mxw, false) ? 4 : 0);
    }

    private static b b(a aVar, String str) throws IOException {
        int i;
        String hexString;
        b.a aVar2 = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j = 0;
        long j2 = -1;
        String str2 = null;
        DrmInitData drmInitData = null;
        long j3 = -9223372036854775807L;
        int i2 = 0;
        long j4 = -9223372036854775807L;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        long j5 = 0;
        int i6 = 1;
        boolean z2 = false;
        boolean z3 = false;
        int i7 = 0;
        String str3 = null;
        long j6 = 0;
        long j7 = 0;
        while (aVar.hasNext()) {
            String next = aVar.next();
            if (next.startsWith("#EXT")) {
                arrayList2.add(next);
            }
            if (next.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String d = d(next, mxi);
                if ("VOD".equals(d)) {
                    i = 1;
                } else {
                    i = "EVENT".equals(d) ? 2 : i3;
                }
                i3 = i;
            } else if (next.startsWith("#EXT-X-START")) {
                j4 = (long) (b(next, mxl) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-MAP")) {
                String d2 = d(next, mxq);
                String c = c(next, mxn);
                if (c != null) {
                    String[] split = c.split("@");
                    j2 = Long.parseLong(split[0]);
                    if (split.length > 1) {
                        j7 = Long.parseLong(split[1]);
                    }
                }
                b.a aVar3 = new b.a(d2, j7, j2);
                j2 = -1;
                j7 = 0;
                aVar2 = aVar3;
            } else if (next.startsWith("#EXT-X-TARGETDURATION")) {
                j3 = a(next, mxg) * TimeUtils.NANOS_PER_MS;
            } else if (next.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                int a2 = a(next, mxj);
                i7 = a2;
                i2 = a2;
            } else if (next.startsWith("#EXT-X-VERSION")) {
                i6 = a(next, mxh);
            } else if (next.startsWith("#EXTINF")) {
                j5 = (long) (b(next, mxk) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-KEY")) {
                String d3 = d(next, mxo);
                String c2 = c(next, mxp);
                String str4 = null;
                String str5 = null;
                if (!"NONE".equals(d3)) {
                    str5 = c(next, mxr);
                    if ("identity".equals(c2) || c2 == null) {
                        if ("AES-128".equals(d3)) {
                            str4 = d(next, mxq);
                        }
                    } else {
                        DrmInitData.SchemeData fr = fr(next, c2);
                        if (fr != null) {
                            drmInitData = new DrmInitData("SAMPLE-AES-CENC".equals(d3) ? "cenc" : "cbcs", fr);
                        }
                    }
                }
                str3 = str5;
                str2 = str4;
            } else if (next.startsWith("#EXT-X-BYTERANGE")) {
                String[] split2 = d(next, mxm).split("@");
                j2 = Long.parseLong(split2[0]);
                j7 = split2.length > 1 ? Long.parseLong(split2[1]) : j7;
            } else if (next.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                i5 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                z = true;
            } else if (next.equals("#EXT-X-DISCONTINUITY")) {
                i4++;
            } else if (next.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                if (j6 == 0) {
                    j6 = com.google.android.exoplayer2.b.fo(v.QD(next.substring(next.indexOf(58) + 1))) - j;
                }
            } else if (!next.startsWith("#")) {
                if (str2 == null) {
                    hexString = null;
                } else {
                    hexString = str3 != null ? str3 : Integer.toHexString(i7);
                }
                int i8 = i7 + 1;
                long j8 = j2 == -1 ? 0L : j7;
                arrayList.add(new b.a(next, j5, i4, j, str2, hexString, j8, j2));
                j += j5;
                long j9 = j2 != -1 ? j8 + j2 : j8;
                j2 = -1;
                i7 = i8;
                j5 = 0;
                j7 = j9;
            } else if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                z2 = true;
            } else if (next.equals("#EXT-X-ENDLIST")) {
                z3 = true;
            }
        }
        return new b(i3, str, arrayList2, j4, j6, z, i5, i2, i6, j3, z2, z3, j6 != 0, drmInitData, aVar2, arrayList);
    }

    private static DrmInitData.SchemeData fr(String str, String str2) throws ParserException {
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String d = d(str, mxq);
            return new DrmInitData.SchemeData(com.google.android.exoplayer2.b.lYi, MimeType.Video.MP4, Base64.decode(d.substring(d.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            try {
                return new DrmInitData.SchemeData(com.google.android.exoplayer2.b.lYi, "hls", str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new ParserException(e);
            }
        } else {
            return null;
        }
    }

    private static int a(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(d(str, pattern));
    }

    private static double b(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(d(str, pattern));
    }

    private static String c(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static String d(String str, Pattern pattern) throws ParserException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new ParserException("Couldn't match " + pattern.pattern() + " in " + str);
    }

    private static boolean a(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1).equals("YES");
        }
        return z;
    }

    private static Pattern PO(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private final Queue<String> mxA;
        private String mxB;
        private final BufferedReader mxz;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.mxA = queue;
            this.mxz = bufferedReader;
        }

        public boolean hasNext() throws IOException {
            if (this.mxB != null) {
                return true;
            }
            if (!this.mxA.isEmpty()) {
                this.mxB = this.mxA.poll();
                return true;
            }
            do {
                String readLine = this.mxz.readLine();
                this.mxB = readLine;
                if (readLine != null) {
                    this.mxB = this.mxB.trim();
                } else {
                    return false;
                }
            } while (this.mxB.isEmpty());
            return true;
        }

        public String next() throws IOException {
            if (hasNext()) {
                String str = this.mxB;
                this.mxB = null;
                return str;
            }
            return null;
        }
    }
}
