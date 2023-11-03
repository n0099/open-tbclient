package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.util.Base64;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    public static final String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
    public static final String BOOLEAN_FALSE = "NO";
    public static final String BOOLEAN_TRUE = "YES";
    public static final String KEYFORMAT_IDENTITY = "identity";
    public static final String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    public static final String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
    public static final String METHOD_AES_128 = "AES-128";
    public static final String METHOD_NONE = "NONE";
    public static final String METHOD_SAMPLE_AES = "SAMPLE-AES";
    public static final String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
    public static final String PLAYLIST_HEADER = "#EXTM3U";
    public static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
    public static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
    public static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
    public static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
    public static final String TAG_INDEPENDENT_SEGMENTS = "#EXT-X-INDEPENDENT-SEGMENTS";
    public static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
    public static final String TAG_KEY = "#EXT-X-KEY";
    public static final String TAG_MEDIA = "#EXT-X-MEDIA";
    public static final String TAG_MEDIA_DURATION = "#EXTINF";
    public static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
    public static final String TAG_PLAYLIST_TYPE = "#EXT-X-PLAYLIST-TYPE";
    public static final String TAG_PREFIX = "#EXT";
    public static final String TAG_PROGRAM_DATE_TIME = "#EXT-X-PROGRAM-DATE-TIME";
    public static final String TAG_START = "#EXT-X-START";
    public static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
    public static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
    public static final String TAG_VERSION = "#EXT-X-VERSION";
    public static final String TYPE_AUDIO = "AUDIO";
    public static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    public static final String TYPE_SUBTITLES = "SUBTITLES";
    public static final String TYPE_VIDEO = "VIDEO";
    public static final Pattern REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    public static final Pattern REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    public static final Pattern REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES)");
    public static final Pattern REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    public static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern("DEFAULT");
    public static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");

    /* loaded from: classes9.dex */
    public static class LineIterator {
        public final Queue<String> extraLines;
        public String next;
        public final BufferedReader reader;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        public boolean hasNext() throws IOException {
            String trim;
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = this.extraLines.poll();
                return true;
            }
            do {
                String readLine = this.reader.readLine();
                this.next = readLine;
                if (readLine != null) {
                    trim = readLine.trim();
                    this.next = trim;
                } else {
                    return false;
                }
            } while (trim.isEmpty());
            return true;
        }

        public String next() throws IOException {
            if (!hasNext()) {
                return null;
            }
            String str = this.next;
            this.next = null;
            return str;
        }
    }

    public static boolean checkPlaylistHeader(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int skipIgnorableWhitespace = skipIgnorableWhitespace(bufferedReader, true, read);
        for (int i = 0; i < 7; i++) {
            if (skipIgnorableWhitespace != PLAYLIST_HEADER.charAt(i)) {
                return false;
            }
            skipIgnorableWhitespace = bufferedReader.read();
        }
        return Util.isLinebreak(skipIgnorableWhitespace(bufferedReader, false, skipIgnorableWhitespace));
    }

    public static Pattern compileBooleanAttrPattern(String str) {
        return Pattern.compile(str + "=(" + BOOLEAN_FALSE + "|" + BOOLEAN_TRUE + SmallTailInfo.EMOTION_SUFFIX);
    }

    public static int parseSelectionFlags(String str) {
        int i;
        int i2 = 0;
        boolean parseBooleanAttribute = parseBooleanAttribute(str, REGEX_DEFAULT, false);
        if (parseBooleanAttribute(str, REGEX_FORCED, false)) {
            i = 2;
        } else {
            i = 0;
        }
        int i3 = (parseBooleanAttribute ? 1 : 0) | i;
        if (parseBooleanAttribute(str, REGEX_AUTOSELECT, false)) {
            i2 = 4;
        }
        return i3 | i2;
    }

    public static boolean parseBooleanAttribute(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1).equals(BOOLEAN_TRUE);
        }
        return z;
    }

    public static int skipIgnorableWhitespace(BufferedReader bufferedReader, boolean z, int i) throws IOException {
        while (i != -1 && Character.isWhitespace(i) && (z || !Util.isLinebreak(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    public static double parseDoubleAttr(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(parseStringAttr(str, pattern));
    }

    public static int parseIntAttr(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(parseStringAttr(str, pattern));
    }

    public static String parseOptionalStringAttr(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x008c A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HlsMasterPlaylist parseMasterPlaylist(LineIterator lineIterator, String str) throws IOException {
        ArrayList arrayList;
        char c;
        int parseInt;
        String str2;
        int i;
        int i2;
        float f;
        int i3;
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = null;
        Format format = null;
        boolean z = false;
        while (lineIterator.hasNext()) {
            String next = lineIterator.next();
            if (next.startsWith(TAG_PREFIX)) {
                arrayList5.add(next);
            }
            if (next.startsWith(TAG_MEDIA)) {
                int parseSelectionFlags = parseSelectionFlags(next);
                String parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_URI);
                String parseStringAttr = parseStringAttr(next, REGEX_NAME);
                String parseOptionalStringAttr2 = parseOptionalStringAttr(next, REGEX_LANGUAGE);
                String parseStringAttr2 = parseStringAttr(next, REGEX_TYPE);
                int hashCode = parseStringAttr2.hashCode();
                if (hashCode != -959297733) {
                    if (hashCode != -333210994) {
                        if (hashCode == 62628790 && parseStringAttr2.equals(TYPE_AUDIO)) {
                            c = 0;
                            if (c == 0) {
                                if (c != 1) {
                                    if (c == 2) {
                                        String parseStringAttr3 = parseStringAttr(next, REGEX_INSTREAM_ID);
                                        if (parseStringAttr3.startsWith("CC")) {
                                            parseInt = Integer.parseInt(parseStringAttr3.substring(2));
                                            str2 = MimeTypes.APPLICATION_CEA608;
                                        } else {
                                            parseInt = Integer.parseInt(parseStringAttr3.substring(7));
                                            str2 = MimeTypes.APPLICATION_CEA708;
                                        }
                                        int i4 = parseInt;
                                        String str3 = str2;
                                        if (arrayList6 == null) {
                                            arrayList6 = new ArrayList();
                                        }
                                        arrayList6.add(Format.createTextContainerFormat(parseStringAttr, null, str3, null, -1, parseSelectionFlags, parseOptionalStringAttr2, i4));
                                    }
                                } else {
                                    arrayList4.add(new HlsMasterPlaylist.HlsUrl(parseOptionalStringAttr, Format.createTextContainerFormat(parseStringAttr, MimeTypes.APPLICATION_M3U8, MimeTypes.TEXT_VTT, null, -1, parseSelectionFlags, parseOptionalStringAttr2)));
                                }
                            } else {
                                Format createAudioContainerFormat = Format.createAudioContainerFormat(parseStringAttr, MimeTypes.APPLICATION_M3U8, null, null, -1, -1, -1, null, parseSelectionFlags, parseOptionalStringAttr2);
                                if (parseOptionalStringAttr == null) {
                                    format = createAudioContainerFormat;
                                } else {
                                    arrayList3.add(new HlsMasterPlaylist.HlsUrl(parseOptionalStringAttr, createAudioContainerFormat));
                                }
                            }
                        }
                        c = 65535;
                        if (c == 0) {
                        }
                    } else {
                        if (parseStringAttr2.equals(TYPE_CLOSED_CAPTIONS)) {
                            c = 2;
                            if (c == 0) {
                            }
                        }
                        c = 65535;
                        if (c == 0) {
                        }
                    }
                } else {
                    if (parseStringAttr2.equals(TYPE_SUBTITLES)) {
                        c = 1;
                        if (c == 0) {
                        }
                    }
                    c = 65535;
                    if (c == 0) {
                    }
                }
            } else if (next.startsWith(TAG_STREAM_INF)) {
                z |= next.contains(ATTR_CLOSED_CAPTIONS_NONE);
                int parseIntAttr = parseIntAttr(next, REGEX_BANDWIDTH);
                String parseOptionalStringAttr3 = parseOptionalStringAttr(next, REGEX_AVERAGE_BANDWIDTH);
                if (parseOptionalStringAttr3 != null) {
                    parseIntAttr = Integer.parseInt(parseOptionalStringAttr3);
                }
                int i5 = parseIntAttr;
                String parseOptionalStringAttr4 = parseOptionalStringAttr(next, REGEX_CODECS);
                String parseOptionalStringAttr5 = parseOptionalStringAttr(next, REGEX_RESOLUTION);
                if (parseOptionalStringAttr5 != null) {
                    String[] split = parseOptionalStringAttr5.split("x");
                    int parseInt2 = Integer.parseInt(split[0]);
                    int parseInt3 = Integer.parseInt(split[1]);
                    if (parseInt2 > 0 && parseInt3 > 0) {
                        i3 = parseInt3;
                    } else {
                        parseInt2 = -1;
                        i3 = -1;
                    }
                    i = parseInt2;
                    i2 = i3;
                } else {
                    i = -1;
                    i2 = -1;
                }
                String parseOptionalStringAttr6 = parseOptionalStringAttr(next, REGEX_FRAME_RATE);
                if (parseOptionalStringAttr6 != null) {
                    f = Float.parseFloat(parseOptionalStringAttr6);
                } else {
                    f = -1.0f;
                }
                String next2 = lineIterator.next();
                if (hashSet.add(next2)) {
                    arrayList2.add(new HlsMasterPlaylist.HlsUrl(next2, Format.createVideoContainerFormat(Integer.toString(arrayList2.size()), MimeTypes.APPLICATION_M3U8, null, parseOptionalStringAttr4, i5, i, i2, f, null, 0)));
                }
            }
        }
        if (z) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = arrayList6;
        }
        return new HlsMasterPlaylist(str, arrayList5, arrayList2, arrayList3, arrayList4, format, arrayList);
    }

    public static HlsMediaPlaylist parseMediaPlaylist(LineIterator lineIterator, String str) throws IOException {
        boolean z;
        String str2;
        String hexString;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        int i = 0;
        int i2 = 0;
        long j3 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        boolean z3 = false;
        boolean z4 = false;
        DrmInitData drmInitData = null;
        HlsMediaPlaylist.Segment segment = null;
        long j4 = 0;
        int i6 = 0;
        long j5 = -1;
        String str3 = null;
        long j6 = 0;
        String str4 = null;
        loop0: while (true) {
            long j7 = 0;
            while (lineIterator.hasNext()) {
                String next = lineIterator.next();
                if (next.startsWith(TAG_PREFIX)) {
                    arrayList2.add(next);
                }
                if (next.startsWith(TAG_PLAYLIST_TYPE)) {
                    String parseStringAttr = parseStringAttr(next, REGEX_PLAYLIST_TYPE);
                    if ("VOD".equals(parseStringAttr)) {
                        i2 = 1;
                    } else if ("EVENT".equals(parseStringAttr)) {
                        i2 = 2;
                    }
                } else if (next.startsWith(TAG_START)) {
                    j = (long) (parseDoubleAttr(next, REGEX_TIME_OFFSET) * 1000000.0d);
                } else if (next.startsWith(TAG_INIT_SEGMENT)) {
                    String parseStringAttr2 = parseStringAttr(next, REGEX_URI);
                    String parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE);
                    if (parseOptionalStringAttr != null) {
                        String[] split = parseOptionalStringAttr.split("@");
                        j5 = Long.parseLong(split[0]);
                        if (split.length > 1) {
                            j4 = Long.parseLong(split[1]);
                        }
                    }
                    segment = new HlsMediaPlaylist.Segment(parseStringAttr2, j4, j5);
                    j4 = 0;
                    j5 = -1;
                } else if (next.startsWith(TAG_TARGET_DURATION)) {
                    j2 = 1000000 * parseIntAttr(next, REGEX_TARGET_DURATION);
                } else if (next.startsWith(TAG_MEDIA_SEQUENCE)) {
                    i6 = parseIntAttr(next, REGEX_MEDIA_SEQUENCE);
                    i4 = i6;
                } else if (next.startsWith(TAG_VERSION)) {
                    i5 = parseIntAttr(next, REGEX_VERSION);
                } else if (next.startsWith(TAG_MEDIA_DURATION)) {
                    j7 = (long) (parseDoubleAttr(next, REGEX_MEDIA_DURATION) * 1000000.0d);
                } else if (next.startsWith(TAG_KEY)) {
                    String parseStringAttr3 = parseStringAttr(next, REGEX_METHOD);
                    String parseOptionalStringAttr2 = parseOptionalStringAttr(next, REGEX_KEYFORMAT);
                    if (!METHOD_NONE.equals(parseStringAttr3)) {
                        String parseOptionalStringAttr3 = parseOptionalStringAttr(next, REGEX_IV);
                        if (!"identity".equals(parseOptionalStringAttr2) && parseOptionalStringAttr2 != null) {
                            DrmInitData.SchemeData parseWidevineSchemeData = parseWidevineSchemeData(next, parseOptionalStringAttr2);
                            if (parseWidevineSchemeData != null) {
                                if (METHOD_SAMPLE_AES_CENC.equals(parseStringAttr3)) {
                                    str2 = "cenc";
                                } else {
                                    str2 = C.CENC_TYPE_cbcs;
                                }
                                drmInitData = new DrmInitData(str2, parseWidevineSchemeData);
                            }
                        } else if (METHOD_AES_128.equals(parseStringAttr3)) {
                            str3 = parseStringAttr(next, REGEX_URI);
                            str4 = parseOptionalStringAttr3;
                        }
                        str4 = parseOptionalStringAttr3;
                        str3 = null;
                    } else {
                        str3 = null;
                        str4 = null;
                    }
                } else if (next.startsWith(TAG_BYTERANGE)) {
                    String[] split2 = parseStringAttr(next, REGEX_BYTERANGE).split("@");
                    j5 = Long.parseLong(split2[0]);
                    if (split2.length > 1) {
                        j4 = Long.parseLong(split2[1]);
                    }
                } else if (next.startsWith(TAG_DISCONTINUITY_SEQUENCE)) {
                    i3 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                    z2 = true;
                } else if (next.equals(TAG_DISCONTINUITY)) {
                    i++;
                } else if (next.startsWith(TAG_PROGRAM_DATE_TIME)) {
                    if (j3 == 0) {
                        j3 = C.msToUs(Util.parseXsDateTime(next.substring(next.indexOf(58) + 1))) - j6;
                    }
                } else if (!next.startsWith("#")) {
                    if (str3 == null) {
                        hexString = null;
                    } else if (str4 != null) {
                        hexString = str4;
                    } else {
                        hexString = Integer.toHexString(i6);
                    }
                    int i7 = i6 + 1;
                    int i8 = (j5 > (-1L) ? 1 : (j5 == (-1L) ? 0 : -1));
                    if (i8 == 0) {
                        j4 = 0;
                    }
                    arrayList.add(new HlsMediaPlaylist.Segment(next, j7, i, j6, str3, hexString, j4, j5));
                    j6 += j7;
                    if (i8 != 0) {
                        j4 += j5;
                    }
                    i6 = i7;
                    j5 = -1;
                } else if (next.equals(TAG_INDEPENDENT_SEGMENTS)) {
                    z3 = true;
                } else if (next.equals(TAG_ENDLIST)) {
                    z4 = true;
                }
            }
            break loop0;
        }
        if (j3 != 0) {
            z = true;
        } else {
            z = false;
        }
        return new HlsMediaPlaylist(i2, str, arrayList2, j, j3, z2, i3, i4, i5, j2, z3, z4, z, drmInitData, segment, arrayList);
    }

    public static String parseStringAttr(String str, Pattern pattern) throws ParserException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new ParserException("Couldn't match " + pattern.pattern() + " in " + str);
    }

    public static DrmInitData.SchemeData parseWidevineSchemeData(String str, String str2) throws ParserException {
        if (KEYFORMAT_WIDEVINE_PSSH_BINARY.equals(str2)) {
            String parseStringAttr = parseStringAttr(str, REGEX_URI);
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "video/mp4", Base64.decode(parseStringAttr.substring(parseStringAttr.indexOf(44)), 0));
        } else if (KEYFORMAT_WIDEVINE_PSSH_JSON.equals(str2)) {
            try {
                return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "hls", str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new ParserException(e);
            }
        } else {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (checkPlaylistHeader(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (trim.startsWith(TAG_STREAM_INF)) {
                                arrayDeque.add(trim);
                                return parseMasterPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                            } else if (trim.startsWith(TAG_TARGET_DURATION) || trim.startsWith(TAG_MEDIA_SEQUENCE) || trim.startsWith(TAG_MEDIA_DURATION) || trim.startsWith(TAG_KEY) || trim.startsWith(TAG_BYTERANGE) || trim.equals(TAG_DISCONTINUITY) || trim.equals(TAG_DISCONTINUITY_SEQUENCE) || trim.equals(TAG_ENDLIST)) {
                                break;
                            } else {
                                arrayDeque.add(trim);
                            }
                        }
                    } else {
                        Util.closeQuietly(bufferedReader);
                        throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                arrayDeque.add(trim);
                return parseMediaPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
            }
            throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
        } finally {
            Util.closeQuietly(bufferedReader);
        }
    }
}
