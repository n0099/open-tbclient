package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import com.baidubce.services.vod.VodClient;
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
/* loaded from: classes4.dex */
public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern CEA_608_ACCESSIBILITY_PATTERN;
    public static final Pattern CEA_708_ACCESSIBILITY_PATTERN;
    public static final Pattern FRAME_RATE_PATTERN;
    public static final String TAG = "MpdParser";
    public transient /* synthetic */ FieldHolder $fh;
    public final String contentId;
    public final XmlPullParserFactory xmlParserFactory;

    /* loaded from: classes4.dex */
    public static final class RepresentationInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String baseUrl;
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;
        public final String drmSchemeType;
        public final Format format;
        public final ArrayList<Descriptor> inbandEventStreams;
        public final SegmentBase segmentBase;

        public RepresentationInfo(Format format, String str, SegmentBase segmentBase, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {format, str, segmentBase, str2, arrayList, arrayList2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.format = format;
            this.baseUrl = str;
            this.segmentBase = segmentBase;
            this.drmSchemeType = str2;
            this.drmSchemeDatas = arrayList;
            this.inbandEventStreams = arrayList2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1397492126, "Lcom/google/android/exoplayer2/source/dash/manifest/DashManifestParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1397492126, "Lcom/google/android/exoplayer2/source/dash/manifest/DashManifestParser;");
                return;
            }
        }
        FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
        CEA_608_ACCESSIBILITY_PATTERN = Pattern.compile("CC([1-4])=.*");
        CEA_708_ACCESSIBILITY_PATTERN = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DashManifestParser() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int checkContentTypeConsistency(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            if (i == -1) {
                return i2;
            }
            if (i2 == -1) {
                return i;
            }
            Assertions.checkState(i == i2);
            return i;
        }
        return invokeII.intValue;
    }

    public static String checkLanguageConsistency(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str == null) {
                return str2;
            }
            if (str2 == null) {
                return str;
            }
            Assertions.checkState(str.equals(str2));
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void filterRedundantIncompleteSchemeDatas(ArrayList<DrmInitData.SchemeData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, arrayList) == null) {
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
    }

    public static String getSampleMimeType(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public static boolean mimeTypeIsRawText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? MimeTypes.isText(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_CEA608.equals(str) : invokeL.booleanValue;
    }

    public static String parseBaseUrl(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, xmlPullParser, str)) == null) {
            xmlPullParser.next();
            return UriUtil.resolve(str, xmlPullParser.getText());
        }
        return (String) invokeLL.objValue;
    }

    public static int parseCea608AccessibilityChannel(List<Descriptor> list) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, list)) == null) {
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
        return invokeL.intValue;
    }

    public static int parseCea708AccessibilityChannel(List<Descriptor> list) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
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
        return invokeL.intValue;
    }

    public static long parseDateTime(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{xmlPullParser, str, Long.valueOf(j)})) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue == null ? j : Util.parseXsDateTime(attributeValue);
        }
        return invokeCommon.longValue;
    }

    public static Descriptor parseDescriptor(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, xmlPullParser, str)) == null) {
            String parseString = parseString(xmlPullParser, "schemeIdUri", "");
            String parseString2 = parseString(xmlPullParser, "value", null);
            String parseString3 = parseString(xmlPullParser, "id", null);
            do {
                xmlPullParser.next();
            } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
            return new Descriptor(parseString, parseString2, parseString3);
        }
        return (Descriptor) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int parseDolbyChannelConfiguration(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, xmlPullParser)) == null) {
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
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        return c != 3 ? -1 : 8;
                    }
                    return 6;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static long parseDuration(XmlPullParser xmlPullParser, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{xmlPullParser, str, Long.valueOf(j)})) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue == null ? j : Util.parseXsDuration(attributeValue);
        }
        return invokeCommon.longValue;
    }

    public static float parseFrameRate(XmlPullParser xmlPullParser, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65551, null, xmlPullParser, f)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
            if (attributeValue != null) {
                Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
                if (matcher.matches()) {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    String group = matcher.group(2);
                    return !TextUtils.isEmpty(group) ? parseInt / Integer.parseInt(group) : parseInt;
                }
                return f;
            }
            return f;
        }
        return invokeLF.floatValue;
    }

    public static int parseInt(XmlPullParser xmlPullParser, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65552, null, xmlPullParser, str, i)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue == null ? i : Integer.parseInt(attributeValue);
        }
        return invokeLLI.intValue;
    }

    public static long parseLong(XmlPullParser xmlPullParser, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{xmlPullParser, str, Long.valueOf(j)})) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue == null ? j : Long.parseLong(attributeValue);
        }
        return invokeCommon.longValue;
    }

    public static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, xmlPullParser, str, str2)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue == null ? str2 : attributeValue;
        }
        return (String) invokeLLL.objValue;
    }

    public AdaptationSet buildAdaptationSet(int i, int i2, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, list2, list3})) == null) ? new AdaptationSet(i, i2, list, list2, list3) : (AdaptationSet) invokeCommon.objValue;
    }

    public Format buildFormat(String str, String str2, int i, int i2, float f, int i3, int i4, int i5, String str3, int i6, List<Descriptor> list, String str4) {
        InterceptResult invokeCommon;
        int i7;
        int parseCea708AccessibilityChannel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str3, Integer.valueOf(i6), list, str4})) == null) {
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
        return (Format) invokeCommon.objValue;
    }

    public DashManifest buildMediaPresentationDescription(long j, long j2, long j3, boolean z, long j4, long j5, long j6, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), utcTimingElement, uri, list})) == null) ? new DashManifest(j, j2, j3, z, j4, j5, j6, utcTimingElement, uri, list) : (DashManifest) invokeCommon.objValue;
    }

    public Period buildPeriod(String str, long j, List<AdaptationSet> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), list})) == null) ? new Period(str, j, list) : (Period) invokeCommon.objValue;
    }

    public RangedUri buildRangedUri(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) ? new RangedUri(str, j, j2) : (RangedUri) invokeCommon.objValue;
    }

    public Representation buildRepresentation(RepresentationInfo representationInfo, String str, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, representationInfo, str, str2, arrayList, arrayList2)) == null) {
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
        return (Representation) invokeLLLLL.objValue;
    }

    public SegmentBase.SegmentList buildSegmentList(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentBase.SegmentTimelineElement> list, List<RangedUri> list2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{rangedUri, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), list, list2})) == null) ? new SegmentBase.SegmentList(rangedUri, j, j2, i, j3, list, list2) : (SegmentBase.SegmentList) invokeCommon.objValue;
    }

    public SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangedUri, long j, long j2, int i, long j3, List<SegmentBase.SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{rangedUri, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), list, urlTemplate, urlTemplate2})) == null) ? new SegmentBase.SegmentTemplate(rangedUri, j, j2, i, j3, list, urlTemplate, urlTemplate2) : (SegmentBase.SegmentTemplate) invokeCommon.objValue;
    }

    public SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? new SegmentBase.SegmentTimelineElement(j, j2) : (SegmentBase.SegmentTimelineElement) invokeCommon.objValue;
    }

    public SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{rangedUri, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) ? new SegmentBase.SingleSegmentBase(rangedUri, j, j2, j3, j4) : (SegmentBase.SingleSegmentBase) invokeCommon.objValue;
    }

    public UtcTimingElement buildUtcTimingElement(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) ? new UtcTimingElement(str, str2) : (UtcTimingElement) invokeLL.objValue;
    }

    public int getContentType(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, format)) == null) {
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
            return mimeTypeIsRawText(str) ? 3 : -1;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Type inference failed for: r0v46, types: [java.lang.Object] */
    public AdaptationSet parseAdaptationSet(XmlPullParser xmlPullParser, String str, SegmentBase segmentBase) throws XmlPullParserException, IOException {
        InterceptResult invokeLLL;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, xmlPullParser, str, segmentBase)) == null) {
            XmlPullParser xmlPullParser3 = xmlPullParser;
            int parseInt = parseInt(xmlPullParser3, "id", -1);
            int parseContentType = parseContentType(xmlPullParser);
            String str6 = null;
            String attributeValue = xmlPullParser3.getAttributeValue(null, "mimeType");
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
        return (AdaptationSet) invokeLLL.objValue;
    }

    public void parseAdaptationSetChild(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, xmlPullParser) == null) {
        }
    }

    public int parseAudioChannelConfiguration(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, xmlPullParser)) == null) {
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
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<String, DrmInitData.SchemeData> parseContentProtection(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        InterceptResult invokeL;
        UUID uuid;
        byte[] bArr;
        boolean z;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, xmlPullParser)) == null) {
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
                if (c == 0) {
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "value");
                    String attributeValue3 = xmlPullParser.getAttributeValue(null, "cenc:default_KID");
                    if (attributeValue3 == null || "00000000-0000-0000-0000-000000000000".equals(attributeValue3)) {
                        bArr2 = null;
                        bArr = attributeValue2;
                        z = false;
                        uuid = null;
                    } else {
                        byte[] buildPsshAtom = PsshAtomUtil.buildPsshAtom(C.COMMON_PSSH_UUID, new UUID[]{UUID.fromString(attributeValue3)}, null);
                        z = false;
                        bArr = attributeValue2;
                        uuid = C.COMMON_PSSH_UUID;
                        bArr2 = buildPsshAtom;
                    }
                    do {
                        xmlPullParser.next();
                        if (XmlPullParserUtil.isStartTag(xmlPullParser, "widevine:license")) {
                        }
                    } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "ContentProtection"));
                    return Pair.create(bArr, uuid != null ? new DrmInitData.SchemeData(uuid, MimeTypes.VIDEO_MP4, bArr2, z) : null);
                }
                if (c == 1) {
                    uuid = C.PLAYREADY_UUID;
                } else if (c == 2) {
                    uuid = C.WIDEVINE_UUID;
                }
                bArr = null;
                bArr2 = bArr;
                z = false;
                do {
                    xmlPullParser.next();
                    if (XmlPullParserUtil.isStartTag(xmlPullParser, "widevine:license")) {
                        String attributeValue4 = xmlPullParser.getAttributeValue(null, "robustness_level");
                        z = attributeValue4 != null && attributeValue4.startsWith("HW");
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
                return Pair.create(bArr, uuid != null ? new DrmInitData.SchemeData(uuid, MimeTypes.VIDEO_MP4, bArr2, z) : null);
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
            return Pair.create(bArr, uuid != null ? new DrmInitData.SchemeData(uuid, MimeTypes.VIDEO_MP4, bArr2, z) : null);
        }
        return (Pair) invokeL.objValue;
    }

    public int parseContentType(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, xmlPullParser)) == null) {
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
        return invokeL.intValue;
    }

    public RangedUri parseInitialization(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, xmlPullParser)) == null) ? parseRangedUrl(xmlPullParser, "sourceURL", "range") : (RangedUri) invokeL.objValue;
    }

    public DashManifest parseMediaPresentationDescription(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        UtcTimingElement utcTimingElement;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048596, this, xmlPullParser, str)) != null) {
            return (DashManifest) invokeLL.objValue;
        }
        long parseDateTime = parseDateTime(xmlPullParser, "availabilityStartTime", C.TIME_UNSET);
        long parseDuration = parseDuration(xmlPullParser, "mediaPresentationDuration", C.TIME_UNSET);
        long parseDuration2 = parseDuration(xmlPullParser, "minBufferTime", C.TIME_UNSET);
        String attributeValue = xmlPullParser.getAttributeValue(null, "type");
        boolean z = attributeValue != null && attributeValue.equals("dynamic");
        long parseDuration3 = z ? parseDuration(xmlPullParser, "minimumUpdatePeriod", C.TIME_UNSET) : -9223372036854775807L;
        long parseDuration4 = z ? parseDuration(xmlPullParser, "timeShiftBufferDepth", C.TIME_UNSET) : -9223372036854775807L;
        long parseDuration5 = z ? parseDuration(xmlPullParser, "suggestedPresentationDelay", C.TIME_UNSET) : -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        long j = z ? -9223372036854775807L : 0L;
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
                j = j;
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "UTCTiming")) {
                utcTimingElement = parseUtcTiming(xmlPullParser);
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser, Headers.LOCATION)) {
                    uri = Uri.parse(xmlPullParser.nextText());
                } else {
                    if (XmlPullParserUtil.isStartTag(xmlPullParser, "Period") && !z3) {
                        Pair<Period, Long> parsePeriod = parsePeriod(xmlPullParser, str2, j);
                        String str3 = str2;
                        Period period = (Period) parsePeriod.first;
                        long j2 = j;
                        if (period.startMs != C.TIME_UNSET) {
                            long longValue = ((Long) parsePeriod.second).longValue();
                            long j3 = longValue == C.TIME_UNSET ? C.TIME_UNSET : period.startMs + longValue;
                            arrayList.add(period);
                            j = j3;
                            str2 = str3;
                        } else if (!z) {
                            throw new ParserException("Unable to determine start of period " + arrayList.size());
                        } else {
                            utcTimingElement = utcTimingElement2;
                            str2 = str3;
                            j = j2;
                            z3 = true;
                        }
                    }
                    utcTimingElement = utcTimingElement2;
                    str2 = str2;
                    j = j;
                }
                utcTimingElement = utcTimingElement2;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "MPD")) {
                if (parseDuration == C.TIME_UNSET) {
                    if (j != C.TIME_UNSET) {
                        parseDuration = j;
                    } else if (!z) {
                        throw new ParserException("Unable to determine duration of static manifest.");
                    }
                }
                if (!arrayList.isEmpty()) {
                    return buildMediaPresentationDescription(parseDateTime, parseDuration, parseDuration2, z, parseDuration3, parseDuration4, parseDuration5, utcTimingElement, uri, arrayList);
                }
                throw new ParserException("No periods found.");
            }
            utcTimingElement2 = utcTimingElement;
        }
    }

    public Pair<Period, Long> parsePeriod(XmlPullParser xmlPullParser, String str, long j) throws XmlPullParserException, IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{xmlPullParser, str, Long.valueOf(j)})) == null) {
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
        return (Pair) invokeCommon.objValue;
    }

    public RangedUri parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2) {
        InterceptResult invokeLLL;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048598, this, xmlPullParser, str, str2)) == null) {
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
        return (RangedUri) invokeLLL.objValue;
    }

    public RepresentationInfo parseRepresentation(XmlPullParser xmlPullParser, String str, String str2, String str3, int i, int i2, float f, int i3, int i4, String str4, int i5, List<Descriptor> list, SegmentBase segmentBase) throws XmlPullParserException, IOException {
        InterceptResult invokeCommon;
        String str5;
        SegmentBase parseSegmentTemplate;
        SegmentBase segmentBase2;
        String str6;
        String str7;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{xmlPullParser, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), str4, Integer.valueOf(i5), list, segmentBase})) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "id");
            int parseInt = parseInt(xmlPullParser, "bandwidth", -1);
            String parseString = parseString(xmlPullParser, "mimeType", str2);
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
                if (!XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
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
                } else if (z2) {
                    str5 = str9;
                    i6 = i7;
                    segmentBase2 = segmentBase3;
                    str6 = str8;
                    z = z2;
                    str7 = str5;
                } else {
                    i6 = i7;
                    str7 = parseBaseUrl(xmlPullParser, str9);
                    segmentBase2 = segmentBase3;
                    str6 = str8;
                    z = true;
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
            return new RepresentationInfo(buildFormat(attributeValue, parseString, parseInt2, parseInt3, parseFrameRate, i6, parseInt4, parseInt, str4, i5, list, parseString2), str7, segmentBase2 != null ? segmentBase2 : new SegmentBase.SingleSegmentBase(), str6, arrayList, arrayList2);
        }
        return (RepresentationInfo) invokeCommon.objValue;
    }

    public int parseRole(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, xmlPullParser)) == null) {
            String parseString = parseString(xmlPullParser, "schemeIdUri", null);
            String parseString2 = parseString(xmlPullParser, "value", null);
            do {
                xmlPullParser.next();
            } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Role"));
            return ("urn:mpeg:dash:role:2011".equals(parseString) && "main".equals(parseString2)) ? 1 : 0;
        }
        return invokeL.intValue;
    }

    public SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlPullParser, SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, xmlPullParser, singleSegmentBase)) == null) {
            long parseLong = parseLong(xmlPullParser, "timescale", singleSegmentBase != null ? singleSegmentBase.timescale : 1L);
            long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", singleSegmentBase != null ? singleSegmentBase.presentationTimeOffset : 0L);
            long j3 = singleSegmentBase != null ? singleSegmentBase.indexStart : 0L;
            long j4 = singleSegmentBase != null ? singleSegmentBase.indexLength : 0L;
            String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
            if (attributeValue != null) {
                String[] split = attributeValue.split("-");
                long parseLong3 = Long.parseLong(split[0]);
                j = (Long.parseLong(split[1]) - parseLong3) + 1;
                j2 = parseLong3;
            } else {
                j = j4;
                j2 = j3;
            }
            RangedUri rangedUri = singleSegmentBase != null ? singleSegmentBase.initialization : null;
            do {
                xmlPullParser.next();
                if (XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                    rangedUri = parseInitialization(xmlPullParser);
                }
            } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentBase"));
            return buildSingleSegmentBase(rangedUri, parseLong, parseLong2, j2, j);
        }
        return (SegmentBase.SingleSegmentBase) invokeLL.objValue;
    }

    public SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlPullParser, SegmentBase.SegmentList segmentList) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, xmlPullParser, segmentList)) == null) {
            long parseLong = parseLong(xmlPullParser, "timescale", segmentList != null ? segmentList.timescale : 1L);
            long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", segmentList != null ? segmentList.presentationTimeOffset : 0L);
            long parseLong3 = parseLong(xmlPullParser, "duration", segmentList != null ? segmentList.duration : C.TIME_UNSET);
            int parseInt = parseInt(xmlPullParser, "startNumber", segmentList != null ? segmentList.startNumber : 1);
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
        return (SegmentBase.SegmentList) invokeLL.objValue;
    }

    public SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlPullParser, SegmentBase.SegmentTemplate segmentTemplate) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, xmlPullParser, segmentTemplate)) == null) {
            long parseLong = parseLong(xmlPullParser, "timescale", segmentTemplate != null ? segmentTemplate.timescale : 1L);
            long parseLong2 = parseLong(xmlPullParser, "presentationTimeOffset", segmentTemplate != null ? segmentTemplate.presentationTimeOffset : 0L);
            long parseLong3 = parseLong(xmlPullParser, "duration", segmentTemplate != null ? segmentTemplate.duration : C.TIME_UNSET);
            int parseInt = parseInt(xmlPullParser, "startNumber", segmentTemplate != null ? segmentTemplate.startNumber : 1);
            RangedUri rangedUri = null;
            UrlTemplate parseUrlTemplate = parseUrlTemplate(xmlPullParser, VodClient.PATH_MEDIA, segmentTemplate != null ? segmentTemplate.mediaTemplate : null);
            UrlTemplate parseUrlTemplate2 = parseUrlTemplate(xmlPullParser, JoinPoint.INITIALIZATION, segmentTemplate != null ? segmentTemplate.initializationTemplate : null);
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
        return (SegmentBase.SegmentTemplate) invokeLL.objValue;
    }

    public List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, xmlPullParser)) == null) {
            ArrayList arrayList = new ArrayList();
            long j = 0;
            do {
                xmlPullParser.next();
                if (XmlPullParserUtil.isStartTag(xmlPullParser, "S")) {
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
        return (List) invokeL.objValue;
    }

    public RangedUri parseSegmentUrl(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, xmlPullParser)) == null) ? parseRangedUrl(xmlPullParser, VodClient.PATH_MEDIA, "mediaRange") : (RangedUri) invokeL.objValue;
    }

    public UrlTemplate parseUrlTemplate(XmlPullParser xmlPullParser, String str, UrlTemplate urlTemplate) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, xmlPullParser, str, urlTemplate)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? UrlTemplate.compile(attributeValue) : urlTemplate;
        }
        return (UrlTemplate) invokeLLL.objValue;
    }

    public UtcTimingElement parseUtcTiming(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, xmlPullParser)) == null) ? buildUtcTimingElement(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value")) : (UtcTimingElement) invokeL.objValue;
    }

    public DashManifestParser(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.contentId = str;
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public DashManifest parse(Uri uri, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, uri, inputStream)) == null) {
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
        return (DashManifest) invokeLL.objValue;
    }
}
