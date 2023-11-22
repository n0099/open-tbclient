package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.coremedia.iso.boxes.sampleentry.SubtitleSampleEntry;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.aspectj.lang.JoinPoint;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes9.dex */
public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {
    public static final String TAG = "MpdParser";
    public final String contentId;
    public final XmlPullParserFactory xmlParserFactory;
    public static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    public static final Pattern CEA_608_ACCESSIBILITY_PATTERN = Pattern.compile("CC([1-4])=.*");
    public static final Pattern CEA_708_ACCESSIBILITY_PATTERN = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    public void parseAdaptationSetChild(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
    }

    /* loaded from: classes9.dex */
    public static final class RepresentationInfo {
        public final String baseUrl;
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;
        public final String drmSchemeType;
        public final Format format;
        public final ArrayList<Descriptor> inbandEventStreams;
        public final SegmentBase segmentBase;

        public RepresentationInfo(Format format, String str, SegmentBase segmentBase, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
            this.format = format;
            this.baseUrl = str;
            this.segmentBase = segmentBase;
            this.drmSchemeType = str2;
            this.drmSchemeDatas = arrayList;
            this.inbandEventStreams = arrayList2;
        }
    }

    public DashManifestParser() {
        this(null);
    }

    public DashManifestParser(String str) {
        this.contentId = str;
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public static void filterRedundantIncompleteSchemeDatas(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        break;
                    } else if (arrayList.get(i).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    public static boolean mimeTypeIsRawText(String str) {
        if (!MimeTypes.isText(str) && !MimeTypes.APPLICATION_TTML.equals(str) && !MimeTypes.APPLICATION_MP4VTT.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str) && !MimeTypes.APPLICATION_CEA608.equals(str)) {
            return false;
        }
        return true;
    }

    public int getContentType(Format format) {
        String str = format.sampleMimeType;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (MimeTypes.isVideo(str)) {
            return 2;
        }
        if (MimeTypes.isAudio(str)) {
            return 1;
        }
        if (!mimeTypeIsRawText(str)) {
            return -1;
        }
        return 3;
    }

    public int parseAudioChannelConfiguration(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", null);
        int i = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(parseString)) {
            i = parseInt(xmlPullParser, "value", -1);
        } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(parseString)) {
            i = parseDolbyChannelConfiguration(xmlPullParser);
        }
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }

    public int parseContentType(XmlPullParser xmlPullParser) {
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
        if (!"text".equals(attributeValue)) {
            return -1;
        }
        return 3;
    }

    public RangedUri parseInitialization(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", "range");
    }

    public int parseRole(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", null);
        String parseString2 = parseString(xmlPullParser, "value", null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Role"));
        if ("urn:mpeg:dash:role:2011".equals(parseString) && "main".equals(parseString2)) {
            return 1;
        }
        return 0;
    }

    public RangedUri parseSegmentUrl(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "media", "mediaRange");
    }

    public UtcTimingElement parseUtcTiming(XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    public static int checkContentTypeConsistency(int i, int i2) {
        boolean z;
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        if (i == i2) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        return i;
    }

    public static String checkLanguageConsistency(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        Assertions.checkState(str.equals(str2));
        return str;
    }

    public static String parseBaseUrl(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return UriUtil.resolve(str, xmlPullParser.getText());
    }

    public static Descriptor parseDescriptor(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser, "value", null);
        String parseString3 = parseString(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return new Descriptor(parseString, parseString2, parseString3);
    }

    public SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j, long j2) {
        return new SegmentBase.SegmentTimelineElement(j, j2);
    }

    public UtcTimingElement buildUtcTimingElement(String str, String str2) {
        return new UtcTimingElement(str, str2);
    }

    public static String getSampleMimeType(String str, String str2) {
        if (MimeTypes.isAudio(str)) {
            return MimeTypes.getAudioMediaMimeType(str2);
        }
        if (MimeTypes.isVideo(str)) {
            return MimeTypes.getVideoMediaMimeType(str2);
        }
        if (mimeTypeIsRawText(str)) {
            return str;
        }
        if (MimeTypes.APPLICATION_MP4.equals(str)) {
            if (SubtitleSampleEntry.TYPE1.equals(str2)) {
                return MimeTypes.APPLICATION_TTML;
            }
            if ("wvtt".equals(str2)) {
                return MimeTypes.APPLICATION_MP4VTT;
            }
        } else if (MimeTypes.APPLICATION_RAWCC.equals(str) && str2 != null) {
            if (str2.contains("cea708")) {
                return MimeTypes.APPLICATION_CEA708;
            }
            if (str2.contains("eia608") || str2.contains("cea608")) {
                return MimeTypes.APPLICATION_CEA608;
            }
        }
        return null;
    }

    public SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlPullParser, SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (singleSegmentBase != null) {
            j = singleSegmentBase.timescale;
        } else {
            j = 1;
        }
        long parseLong = parseLong(xmlPullParser, "timescale", j);
        long j6 = 0;
        if (singleSegmentBase != null) {
            j2 = singleSegmentBase.presentationTimeOffset;
        } else {
            j2 = 0;
        }
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", j2);
        if (singleSegmentBase != null) {
            j3 = singleSegmentBase.indexStart;
        } else {
            j3 = 0;
        }
        if (singleSegmentBase != null) {
            j6 = singleSegmentBase.indexLength;
        }
        RangedUri rangedUri = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            long parseLong3 = Long.parseLong(split[0]);
            j4 = (Long.parseLong(split[1]) - parseLong3) + 1;
            j5 = parseLong3;
        } else {
            j4 = j6;
            j5 = j3;
        }
        if (singleSegmentBase != null) {
            rangedUri = singleSegmentBase.initialization;
        }
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentBase"));
        return buildSingleSegmentBase(rangedUri, parseLong, parseLong2, j5, j4);
    }

    public SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlPullParser, SegmentBase.SegmentList segmentList) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long j3;
        int i;
        if (segmentList != null) {
            j = segmentList.timescale;
        } else {
            j = 1;
        }
        long parseLong = parseLong(xmlPullParser, "timescale", j);
        if (segmentList != null) {
            j2 = segmentList.presentationTimeOffset;
        } else {
            j2 = 0;
        }
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", j2);
        if (segmentList != null) {
            j3 = segmentList.duration;
        } else {
            j3 = C.TIME_UNSET;
        }
        long parseLong3 = parseLong(xmlPullParser, "duration", j3);
        if (segmentList != null) {
            i = segmentList.startNumber;
        } else {
            i = 1;
        }
        int parseInt = parseInt(xmlPullParser, "startNumber", i);
        List<RangedUri> list = null;
        RangedUri rangedUri = null;
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                list2 = parseSegmentTimeline(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentURL")) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(parseSegmentUrl(xmlPullParser));
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentList"));
        if (segmentList != null) {
            if (rangedUri == null) {
                rangedUri = segmentList.initialization;
            }
            if (list2 == null) {
                list2 = segmentList.segmentTimeline;
            }
            if (list == null) {
                list = segmentList.mediaSegments;
            }
        }
        return buildSegmentList(rangedUri, parseLong, parseLong2, parseInt, parseLong3, list2, list);
    }

    public SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlPullParser, SegmentBase.SegmentTemplate segmentTemplate) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long j3;
        int i;
        UrlTemplate urlTemplate;
        UrlTemplate urlTemplate2;
        if (segmentTemplate != null) {
            j = segmentTemplate.timescale;
        } else {
            j = 1;
        }
        long parseLong = parseLong(xmlPullParser, "timescale", j);
        if (segmentTemplate != null) {
            j2 = segmentTemplate.presentationTimeOffset;
        } else {
            j2 = 0;
        }
        long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", j2);
        if (segmentTemplate != null) {
            j3 = segmentTemplate.duration;
        } else {
            j3 = C.TIME_UNSET;
        }
        long parseLong3 = parseLong(xmlPullParser, "duration", j3);
        if (segmentTemplate != null) {
            i = segmentTemplate.startNumber;
        } else {
            i = 1;
        }
        int parseInt = parseInt(xmlPullParser, "startNumber", i);
        RangedUri rangedUri = null;
        if (segmentTemplate != null) {
            urlTemplate = segmentTemplate.mediaTemplate;
        } else {
            urlTemplate = null;
        }
        UrlTemplate parseUrlTemplate = parseUrlTemplate(xmlPullParser, "media", urlTemplate);
        if (segmentTemplate != null) {
            urlTemplate2 = segmentTemplate.initializationTemplate;
        } else {
            urlTemplate2 = null;
        }
        UrlTemplate parseUrlTemplate2 = parseUrlTemplate(xmlPullParser, JoinPoint.INITIALIZATION, urlTemplate2);
        List<SegmentBase.SegmentTimelineElement> list = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                list = parseSegmentTimeline(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTemplate"));
        if (segmentTemplate != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate.initialization;
            }
            if (list == null) {
                list = segmentTemplate.segmentTimeline;
            }
        }
        return buildSegmentTemplate(rangedUri, parseLong, parseLong2, parseInt, parseLong3, list, parseUrlTemplate2, parseUrlTemplate);
    }

    public static int parseCea608AccessibilityChannel(List<Descriptor> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = CEA_608_ACCESSIBILITY_PATTERN.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w(TAG, "Unable to parse CEA-608 channel number from: " + descriptor.value);
            }
        }
        return -1;
    }

    public static int parseCea708AccessibilityChannel(List<Descriptor> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = CEA_708_ACCESSIBILITY_PATTERN.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w(TAG, "Unable to parse CEA-708 service block number from: " + descriptor.value);
            }
        }
        return -1;
    }

    public static long parseDateTime(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j;
        }
        return Util.parseXsDateTime(attributeValue);
    }

    public static long parseDuration(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j;
        }
        return Util.parseXsDuration(attributeValue);
    }

    public static int parseInt(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return Integer.parseInt(attributeValue);
        }
        return i;
    }

    public static long parseLong(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return Long.parseLong(attributeValue);
        }
        return j;
    }

    public static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return attributeValue;
        }
        return str2;
    }

    public Period buildPeriod(String str, long j, List<AdaptationSet> list) {
        return new Period(str, j, list);
    }

    public RangedUri buildRangedUri(String str, long j, long j2) {
        return new RangedUri(str, j, j2);
    }

    public UrlTemplate parseUrlTemplate(XmlPullParser xmlPullParser, String str, UrlTemplate urlTemplate) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return UrlTemplate.compile(attributeValue);
        }
        return urlTemplate;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int parseDolbyChannelConfiguration(XmlPullParser xmlPullParser) {
        char c;
        String lowerInvariant = Util.toLowerInvariant(xmlPullParser.getAttributeValue(null, "value"));
        if (lowerInvariant == null) {
            return -1;
        }
        switch (lowerInvariant.hashCode()) {
            case 1596796:
                if (lowerInvariant.equals("4000")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2937391:
                if (lowerInvariant.equals("a000")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3094035:
                if (lowerInvariant.equals("f801")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3133436:
                if (lowerInvariant.equals("fa01")) {
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
            return 1;
        }
        if (c == 1) {
            return 2;
        }
        if (c != 2) {
            if (c != 3) {
                return -1;
            }
            return 8;
        }
        return 6;
    }

    public static float parseFrameRate(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue != null) {
            Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public DashManifest parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return parseMediaPresentationDescription(newPullParser, uri.toString());
            }
            throw new ParserException("inputStream does not contain a valid media presentation description");
        } catch (XmlPullParserException e) {
            throw new ParserException(e);
        }
    }

    public AdaptationSet buildAdaptationSet(int i, int i2, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3) {
        return new AdaptationSet(i, i2, list, list2, list3);
    }

    public Representation buildRepresentation(RepresentationInfo representationInfo, String str, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
        Format format = representationInfo.format;
        String str3 = representationInfo.drmSchemeType;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = representationInfo.drmSchemeDatas;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            filterRedundantIncompleteSchemeDatas(arrayList3);
            format = format.copyWithDrmInitData(new DrmInitData(str2, arrayList3));
        }
        ArrayList<Descriptor> arrayList4 = representationInfo.inbandEventStreams;
        arrayList4.addAll(arrayList2);
        return Representation.newInstance(str, -1L, format, representationInfo.baseUrl, representationInfo.segmentBase, arrayList4);
    }

    public SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
        return new SegmentBase.SingleSegmentBase(rangedUri, j, j2, j3, j4);
    }

    public Format buildFormat(String str, String str2, int i, int i2, float f, int i3, int i4, int i5, String str3, int i6, List<Descriptor> list, String str4) {
        int i7;
        int parseCea708AccessibilityChannel;
        String sampleMimeType = getSampleMimeType(str2, str4);
        if (sampleMimeType != null) {
            if (MimeTypes.isVideo(sampleMimeType)) {
                return Format.createVideoContainerFormat(str, str2, sampleMimeType, str4, i5, i, i2, f, null, i6);
            }
            if (MimeTypes.isAudio(sampleMimeType)) {
                return Format.createAudioContainerFormat(str, str2, sampleMimeType, str4, i5, i3, i4, null, i6, str3);
            }
            if (mimeTypeIsRawText(sampleMimeType)) {
                if (MimeTypes.APPLICATION_CEA608.equals(sampleMimeType)) {
                    parseCea708AccessibilityChannel = parseCea608AccessibilityChannel(list);
                } else if (MimeTypes.APPLICATION_CEA708.equals(sampleMimeType)) {
                    parseCea708AccessibilityChannel = parseCea708AccessibilityChannel(list);
                } else {
                    i7 = -1;
                    return Format.createTextContainerFormat(str, str2, sampleMimeType, str4, i5, i6, str3, i7);
                }
                i7 = parseCea708AccessibilityChannel;
                return Format.createTextContainerFormat(str, str2, sampleMimeType, str4, i5, i6, str3, i7);
            }
        }
        return Format.createContainerFormat(str, str2, sampleMimeType, str4, i5, i6, str3);
    }

    public DashManifest buildMediaPresentationDescription(long j, long j2, long j3, boolean z, long j4, long j5, long j6, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        return new DashManifest(j, j2, j3, z, j4, j5, j6, utcTimingElement, uri, list);
    }

    public SegmentBase.SegmentList buildSegmentList(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentBase.SegmentTimelineElement> list, List<RangedUri> list2) {
        return new SegmentBase.SegmentList(rangedUri, j, j2, i, j3, list, list2);
    }

    public SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentBase.SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2) {
        return new SegmentBase.SegmentTemplate(rangedUri, j, j2, i, j3, list, urlTemplate, urlTemplate2);
    }

    /* JADX WARN: Type inference failed for: r0v44, types: [java.lang.Object] */
    public AdaptationSet parseAdaptationSet(XmlPullParser xmlPullParser, String str, SegmentBase segmentBase) throws XmlPullParserException, IOException {
        String str2;
        String str3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList<DrmInitData.SchemeData> arrayList4;
        String str4;
        String str5;
        XmlPullParser xmlPullParser2;
        int i;
        ArrayList<Descriptor> arrayList5;
        SegmentBase parseSegmentTemplate;
        int i2;
        XmlPullParser xmlPullParser3 = xmlPullParser;
        int parseInt = parseInt(xmlPullParser3, "id", -1);
        int parseContentType = parseContentType(xmlPullParser);
        String str6 = null;
        String attributeValue = xmlPullParser3.getAttributeValue(null, DownloadCenterFunConstants.MIME_TYPE);
        String attributeValue2 = xmlPullParser3.getAttributeValue(null, "codecs");
        int parseInt2 = parseInt(xmlPullParser3, "width", -1);
        int parseInt3 = parseInt(xmlPullParser3, "height", -1);
        float parseFrameRate = parseFrameRate(xmlPullParser3, -1.0f);
        int parseInt4 = parseInt(xmlPullParser3, "audioSamplingRate", -1);
        String str7 = WebvttCueParser.TAG_LANG;
        String attributeValue3 = xmlPullParser3.getAttributeValue(null, WebvttCueParser.TAG_LANG);
        ArrayList<DrmInitData.SchemeData> arrayList6 = new ArrayList<>();
        ArrayList<Descriptor> arrayList7 = new ArrayList<>();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        String str8 = str;
        SegmentBase segmentBase2 = segmentBase;
        int i3 = parseContentType;
        String str9 = attributeValue3;
        String str10 = null;
        int i4 = -1;
        boolean z = false;
        int i5 = 0;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser3, "BaseURL")) {
                if (!z) {
                    z = true;
                    str3 = parseBaseUrl(xmlPullParser3, str8);
                    arrayList = arrayList10;
                    arrayList2 = arrayList9;
                    arrayList3 = arrayList8;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList6;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    i2 = i3;
                }
                str2 = str9;
                i = i3;
                str3 = str8;
                arrayList = arrayList10;
                arrayList2 = arrayList9;
                arrayList3 = arrayList8;
                arrayList5 = arrayList7;
                arrayList4 = arrayList6;
                str4 = str7;
                str5 = str6;
                xmlPullParser2 = xmlPullParser3;
                i2 = i;
                str9 = str2;
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentProtection")) {
                    Pair<String, DrmInitData.SchemeData> parseContentProtection = parseContentProtection(xmlPullParser);
                    Object obj = parseContentProtection.first;
                    if (obj != null) {
                        str10 = (String) obj;
                    }
                    ?? r0 = parseContentProtection.second;
                    if (r0 != 0) {
                        arrayList6.add(r0);
                    }
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentComponent")) {
                    str9 = checkLanguageConsistency(str9, xmlPullParser3.getAttributeValue(str6, str7));
                    str3 = str8;
                    arrayList = arrayList10;
                    arrayList2 = arrayList9;
                    arrayList3 = arrayList8;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList6;
                    str4 = str7;
                    str5 = str6;
                    i2 = checkContentTypeConsistency(i3, parseContentType(xmlPullParser));
                    xmlPullParser2 = xmlPullParser3;
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Role")) {
                    i5 |= parseRole(xmlPullParser);
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "AudioChannelConfiguration")) {
                    i4 = parseAudioChannelConfiguration(xmlPullParser);
                } else {
                    if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Accessibility")) {
                        arrayList8.add(parseDescriptor(xmlPullParser3, "Accessibility"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "SupplementalProperty")) {
                        arrayList9.add(parseDescriptor(xmlPullParser3, "SupplementalProperty"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser3, "Representation")) {
                        String str11 = str9;
                        str3 = str8;
                        arrayList2 = arrayList9;
                        arrayList3 = arrayList8;
                        arrayList4 = arrayList6;
                        str4 = str7;
                        str5 = str6;
                        RepresentationInfo parseRepresentation = parseRepresentation(xmlPullParser, str8, attributeValue, attributeValue2, parseInt2, parseInt3, parseFrameRate, i4, parseInt4, str11, i5, arrayList3, segmentBase2);
                        int checkContentTypeConsistency = checkContentTypeConsistency(i3, getContentType(parseRepresentation.format));
                        arrayList = arrayList10;
                        arrayList.add(parseRepresentation);
                        i2 = checkContentTypeConsistency;
                        str9 = str11;
                        arrayList5 = arrayList7;
                        xmlPullParser2 = xmlPullParser;
                    } else {
                        str2 = str9;
                        str3 = str8;
                        arrayList = arrayList10;
                        arrayList2 = arrayList9;
                        arrayList3 = arrayList8;
                        ArrayList<Descriptor> arrayList11 = arrayList7;
                        arrayList4 = arrayList6;
                        str4 = str7;
                        str5 = str6;
                        xmlPullParser2 = xmlPullParser;
                        i = i3;
                        if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentBase")) {
                            parseSegmentTemplate = parseSegmentBase(xmlPullParser2, (SegmentBase.SingleSegmentBase) segmentBase2);
                        } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentList")) {
                            parseSegmentTemplate = parseSegmentList(xmlPullParser2, (SegmentBase.SegmentList) segmentBase2);
                        } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTemplate")) {
                            parseSegmentTemplate = parseSegmentTemplate(xmlPullParser2, (SegmentBase.SegmentTemplate) segmentBase2);
                        } else {
                            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "InbandEventStream")) {
                                arrayList5 = arrayList11;
                                arrayList5.add(parseDescriptor(xmlPullParser2, "InbandEventStream"));
                            } else {
                                arrayList5 = arrayList11;
                                if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                                    parseAdaptationSetChild(xmlPullParser);
                                }
                            }
                            i2 = i;
                            str9 = str2;
                        }
                        segmentBase2 = parseSegmentTemplate;
                        i2 = i;
                        str9 = str2;
                        arrayList5 = arrayList11;
                    }
                    str2 = str9;
                    i = i3;
                    str3 = str8;
                    arrayList = arrayList10;
                    arrayList2 = arrayList9;
                    arrayList3 = arrayList8;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList6;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    i2 = i;
                    str9 = str2;
                }
                str3 = str8;
                arrayList = arrayList10;
                arrayList2 = arrayList9;
                arrayList3 = arrayList8;
                arrayList5 = arrayList7;
                arrayList4 = arrayList6;
                str4 = str7;
                str5 = str6;
                xmlPullParser2 = xmlPullParser3;
                i2 = i3;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                break;
            }
            xmlPullParser3 = xmlPullParser2;
            arrayList7 = arrayList5;
            i3 = i2;
            arrayList9 = arrayList2;
            arrayList8 = arrayList3;
            arrayList6 = arrayList4;
            str7 = str4;
            str6 = str5;
            arrayList10 = arrayList;
            str8 = str3;
        }
        ArrayList arrayList12 = new ArrayList(arrayList.size());
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            arrayList12.add(buildRepresentation((RepresentationInfo) arrayList.get(i6), this.contentId, str10, arrayList4, arrayList5));
        }
        return buildAdaptationSet(parseInt, i2, arrayList12, arrayList3, arrayList2);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<String, DrmInitData.SchemeData> parseContentProtection(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        UUID uuid;
        byte[] bArr;
        boolean z;
        byte[] bArr2;
        DrmInitData.SchemeData schemeData = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue != null) {
            String lowerInvariant = Util.toLowerInvariant(attributeValue);
            char c = 65535;
            int hashCode = lowerInvariant.hashCode();
            if (hashCode != 489446379) {
                if (hashCode != 755418770) {
                    if (hashCode == 1812765994 && lowerInvariant.equals("urn:mpeg:dash:mp4protection:2011")) {
                        c = 0;
                    }
                } else if (lowerInvariant.equals(HlsPlaylistParser.KEYFORMAT_WIDEVINE_PSSH_BINARY)) {
                    c = 2;
                }
            } else if (lowerInvariant.equals("urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95")) {
                c = 1;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        uuid = C.WIDEVINE_UUID;
                    }
                } else {
                    uuid = C.PLAYREADY_UUID;
                }
                bArr = null;
                bArr2 = bArr;
                z = false;
                do {
                    xmlPullParser.next();
                    if (XmlPullParserUtil.isStartTag(xmlPullParser, "widevine:license")) {
                        String attributeValue2 = xmlPullParser.getAttributeValue(null, "robustness_level");
                        if (attributeValue2 != null && attributeValue2.startsWith("HW")) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else if (bArr2 == null) {
                        if (XmlPullParserUtil.isStartTag(xmlPullParser, "cenc:pssh") && xmlPullParser.next() == 4) {
                            byte[] decode = Base64.decode(xmlPullParser.getText(), 0);
                            UUID parseUuid = PsshAtomUtil.parseUuid(decode);
                            if (parseUuid == null) {
                                Log.w(TAG, "Skipping malformed cenc:pssh data");
                                uuid = parseUuid;
                                bArr2 = null;
                            } else {
                                bArr2 = decode;
                                uuid = parseUuid;
                            }
                        } else if (uuid == C.PLAYREADY_UUID && XmlPullParserUtil.isStartTag(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                            bArr2 = PsshAtomUtil.buildPsshAtom(C.PLAYREADY_UUID, Base64.decode(xmlPullParser.getText(), 0));
                        }
                    }
                } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
                if (uuid != null) {
                    schemeData = new DrmInitData.SchemeData(uuid, "video/mp4", bArr2, z);
                }
                return Pair.create(bArr, schemeData);
            }
            String attributeValue3 = xmlPullParser.getAttributeValue(null, "value");
            String attributeValue4 = xmlPullParser.getAttributeValue(null, "cenc:default_KID");
            if (attributeValue4 != null && !"00000000-0000-0000-0000-000000000000".equals(attributeValue4)) {
                byte[] buildPsshAtom = PsshAtomUtil.buildPsshAtom(C.COMMON_PSSH_UUID, new UUID[]{UUID.fromString(attributeValue4)}, null);
                z = false;
                bArr = attributeValue3;
                uuid = C.COMMON_PSSH_UUID;
                bArr2 = buildPsshAtom;
            } else {
                bArr2 = null;
                bArr = attributeValue3;
                z = false;
                uuid = null;
            }
            do {
                xmlPullParser.next();
                if (XmlPullParserUtil.isStartTag(xmlPullParser, "widevine:license")) {
                }
            } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
            if (uuid != null) {
            }
            return Pair.create(bArr, schemeData);
        }
        uuid = null;
        bArr = null;
        bArr2 = bArr;
        z = false;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "widevine:license")) {
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
        if (uuid != null) {
        }
        return Pair.create(bArr, schemeData);
    }

    public DashManifest parseMediaPresentationDescription(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        UtcTimingElement utcTimingElement;
        long parseDateTime = parseDateTime(xmlPullParser, "availabilityStartTime", C.TIME_UNSET);
        long parseDuration = parseDuration(xmlPullParser, "mediaPresentationDuration", C.TIME_UNSET);
        long parseDuration2 = parseDuration(xmlPullParser, "minBufferTime", C.TIME_UNSET);
        String attributeValue = xmlPullParser.getAttributeValue(null, "type");
        if (attributeValue != null && attributeValue.equals(PraiseUBCHelper.SOURCE_DYNAMIC)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            j = parseDuration(xmlPullParser, "minimumUpdatePeriod", C.TIME_UNSET);
        } else {
            j = -9223372036854775807L;
        }
        if (z) {
            j2 = parseDuration(xmlPullParser, "timeShiftBufferDepth", C.TIME_UNSET);
        } else {
            j2 = -9223372036854775807L;
        }
        if (z) {
            j3 = parseDuration(xmlPullParser, "suggestedPresentationDelay", C.TIME_UNSET);
        } else {
            j3 = -9223372036854775807L;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            j4 = -9223372036854775807L;
        } else {
            j4 = 0;
        }
        long j6 = j4;
        boolean z2 = false;
        boolean z3 = false;
        Uri uri = null;
        String str2 = str;
        UtcTimingElement utcTimingElement2 = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    str2 = parseBaseUrl(xmlPullParser, str2);
                    utcTimingElement = utcTimingElement2;
                    z2 = true;
                }
                utcTimingElement = utcTimingElement2;
                str2 = str2;
                j6 = j6;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "UTCTiming")) {
                utcTimingElement = parseUtcTiming(xmlPullParser);
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser, "Location")) {
                    uri = Uri.parse(xmlPullParser.nextText());
                } else {
                    if (XmlPullParserUtil.isStartTag(xmlPullParser, "Period") && !z3) {
                        Pair<Period, Long> parsePeriod = parsePeriod(xmlPullParser, str2, j6);
                        String str3 = str2;
                        Period period = (Period) parsePeriod.first;
                        long j7 = j6;
                        if (period.startMs == C.TIME_UNSET) {
                            if (z) {
                                utcTimingElement = utcTimingElement2;
                                str2 = str3;
                                j6 = j7;
                                z3 = true;
                            } else {
                                throw new ParserException("Unable to determine start of period " + arrayList.size());
                            }
                        } else {
                            long longValue = ((Long) parsePeriod.second).longValue();
                            if (longValue == C.TIME_UNSET) {
                                j5 = C.TIME_UNSET;
                            } else {
                                j5 = period.startMs + longValue;
                            }
                            arrayList.add(period);
                            j6 = j5;
                            str2 = str3;
                        }
                    }
                    utcTimingElement = utcTimingElement2;
                    str2 = str2;
                    j6 = j6;
                }
                utcTimingElement = utcTimingElement2;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "MPD")) {
                if (parseDuration == C.TIME_UNSET) {
                    if (j6 != C.TIME_UNSET) {
                        parseDuration = j6;
                    } else if (!z) {
                        throw new ParserException("Unable to determine duration of static manifest.");
                    }
                }
                if (!arrayList.isEmpty()) {
                    return buildMediaPresentationDescription(parseDateTime, parseDuration, parseDuration2, z, j, j2, j3, utcTimingElement, uri, arrayList);
                }
                throw new ParserException("No periods found.");
            }
            utcTimingElement2 = utcTimingElement;
        }
    }

    public Pair<Period, Long> parsePeriod(XmlPullParser xmlPullParser, String str, long j) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        long parseDuration = parseDuration(xmlPullParser, "start", j);
        long parseDuration2 = parseDuration(xmlPullParser, "duration", C.TIME_UNSET);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        SegmentBase segmentBase = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z) {
                    str = parseBaseUrl(xmlPullParser, str);
                    z = true;
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "AdaptationSet")) {
                arrayList.add(parseAdaptationSet(xmlPullParser, str, segmentBase));
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                segmentBase = parseSegmentBase(xmlPullParser, null);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                segmentBase = parseSegmentList(xmlPullParser, null);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                segmentBase = parseSegmentTemplate(xmlPullParser, null);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Period"));
        return Pair.create(buildPeriod(attributeValue, parseDuration, arrayList), Long.valueOf(parseDuration2));
    }

    public RangedUri parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j = Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = (Long.parseLong(split[1]) - j) + 1;
                return buildRangedUri(attributeValue, j, j2);
            }
        } else {
            j = 0;
        }
        j2 = -1;
        return buildRangedUri(attributeValue, j, j2);
    }

    public RepresentationInfo parseRepresentation(XmlPullParser xmlPullParser, String str, String str2, String str3, int i, int i2, float f, int i3, int i4, String str4, int i5, List<Descriptor> list, SegmentBase segmentBase) throws XmlPullParserException, IOException {
        String str5;
        SegmentBase parseSegmentTemplate;
        SegmentBase segmentBase2;
        String str6;
        String str7;
        boolean z;
        SegmentBase singleSegmentBase;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int parseInt = parseInt(xmlPullParser, "bandwidth", -1);
        String parseString = parseString(xmlPullParser, DownloadCenterFunConstants.MIME_TYPE, str2);
        String parseString2 = parseString(xmlPullParser, "codecs", str3);
        int parseInt2 = parseInt(xmlPullParser, "width", i);
        int parseInt3 = parseInt(xmlPullParser, "height", i2);
        float parseFrameRate = parseFrameRate(xmlPullParser, f);
        int parseInt4 = parseInt(xmlPullParser, "audioSamplingRate", i4);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i6 = i3;
        SegmentBase segmentBase3 = segmentBase;
        String str8 = null;
        boolean z2 = false;
        String str9 = str;
        while (true) {
            xmlPullParser.next();
            int i7 = i6;
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    i6 = i7;
                    str7 = parseBaseUrl(xmlPullParser, str9);
                    segmentBase2 = segmentBase3;
                    str6 = str8;
                    z = true;
                } else {
                    str5 = str9;
                    i6 = i7;
                    segmentBase2 = segmentBase3;
                    str6 = str8;
                    z = z2;
                    str7 = str5;
                }
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser, "AudioChannelConfiguration")) {
                    i6 = parseAudioChannelConfiguration(xmlPullParser);
                    segmentBase2 = segmentBase3;
                    str6 = str8;
                } else {
                    if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                        parseSegmentTemplate = parseSegmentBase(xmlPullParser, (SegmentBase.SingleSegmentBase) segmentBase3);
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                        parseSegmentTemplate = parseSegmentList(xmlPullParser, (SegmentBase.SegmentList) segmentBase3);
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                        parseSegmentTemplate = parseSegmentTemplate(xmlPullParser, (SegmentBase.SegmentTemplate) segmentBase3);
                    } else {
                        if (XmlPullParserUtil.isStartTag(xmlPullParser, "ContentProtection")) {
                            Pair<String, DrmInitData.SchemeData> parseContentProtection = parseContentProtection(xmlPullParser);
                            str5 = str9;
                            Object obj = parseContentProtection.first;
                            if (obj != null) {
                                str8 = (String) obj;
                            }
                            Object obj2 = parseContentProtection.second;
                            if (obj2 != null) {
                                arrayList.add(obj2);
                            }
                        } else {
                            str5 = str9;
                            if (XmlPullParserUtil.isStartTag(xmlPullParser, "InbandEventStream")) {
                                arrayList2.add(parseDescriptor(xmlPullParser, "InbandEventStream"));
                            }
                        }
                        i6 = i7;
                        segmentBase2 = segmentBase3;
                        str6 = str8;
                        z = z2;
                        str7 = str5;
                    }
                    segmentBase2 = parseSegmentTemplate;
                    str6 = str8;
                    i6 = i7;
                }
                boolean z3 = z2;
                str7 = str9;
                z = z3;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "Representation")) {
                break;
            }
            segmentBase3 = segmentBase2;
            str8 = str6;
            String str10 = str7;
            z2 = z;
            str9 = str10;
        }
        Format buildFormat = buildFormat(attributeValue, parseString, parseInt2, parseInt3, parseFrameRate, i6, parseInt4, parseInt, str4, i5, list, parseString2);
        if (segmentBase2 != null) {
            singleSegmentBase = segmentBase2;
        } else {
            singleSegmentBase = new SegmentBase.SingleSegmentBase();
        }
        return new RepresentationInfo(buildFormat, str7, singleSegmentBase, str6, arrayList, arrayList2);
    }

    public List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, ExifInterface.LATITUDE_SOUTH)) {
                j = parseLong(xmlPullParser, "t", j);
                long parseLong = parseLong(xmlPullParser, "d", C.TIME_UNSET);
                int parseInt = parseInt(xmlPullParser, "r", 0) + 1;
                for (int i = 0; i < parseInt; i++) {
                    arrayList.add(buildSegmentTimelineElement(j, parseLong));
                    j += parseLong;
                }
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }
}
