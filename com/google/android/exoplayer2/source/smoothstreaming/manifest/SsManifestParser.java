package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
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
public class SsManifestParser implements ParsingLoadable.Parser<SsManifest> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final XmlPullParserFactory xmlParserFactory;

    /* loaded from: classes5.dex */
    public static abstract class ElementParser {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String baseUri;
        public final List<Pair<String, Object>> normalizedAttributes;
        public final ElementParser parent;
        public final String tag;

        public ElementParser(ElementParser elementParser, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementParser, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = elementParser;
            this.baseUri = str;
            this.tag = str2;
            this.normalizedAttributes = new LinkedList();
        }

        private ElementParser newChildParser(ElementParser elementParser, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, elementParser, str, str2)) == null) {
                if (QualityLevelParser.TAG.equals(str)) {
                    return new QualityLevelParser(elementParser, str2);
                }
                if (ProtectionParser.TAG.equals(str)) {
                    return new ProtectionParser(elementParser, str2);
                }
                if (StreamIndexParser.TAG.equals(str)) {
                    return new StreamIndexParser(elementParser, str2);
                }
                return null;
            }
            return (ElementParser) invokeLLL.objValue;
        }

        public void addChild(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            }
        }

        public abstract Object build();

        public final Object getNormalizedAttribute(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                for (int i = 0; i < this.normalizedAttributes.size(); i++) {
                    Pair<String, Object> pair = this.normalizedAttributes.get(i);
                    if (((String) pair.first).equals(str)) {
                        return pair.second;
                    }
                }
                ElementParser elementParser = this.parent;
                if (elementParser == null) {
                    return null;
                }
                return elementParser.getNormalizedAttribute(str);
            }
            return invokeL.objValue;
        }

        public boolean handleChildInline(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public final Object parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, xmlPullParser)) != null) {
                return invokeL.objValue;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.tag.equals(name)) {
                        parseStartTag(xmlPullParser);
                        z = true;
                    } else if (z) {
                        if (i > 0) {
                            i++;
                        } else if (handleChildInline(name)) {
                            parseStartTag(xmlPullParser);
                        } else {
                            ElementParser newChildParser = newChildParser(this, name, this.baseUri);
                            if (newChildParser == null) {
                                i = 1;
                            } else {
                                addChild(newChildParser.parse(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i == 0) {
                        parseText(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i > 0) {
                    i--;
                } else {
                    String name2 = xmlPullParser.getName();
                    parseEndTag(xmlPullParser);
                    if (!handleChildInline(name2)) {
                        return build();
                    }
                }
                xmlPullParser.next();
            }
        }

        public final boolean parseBoolean(XmlPullParser xmlPullParser, String str, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, xmlPullParser, str, z)) == null) {
                String attributeValue = xmlPullParser.getAttributeValue(null, str);
                return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z;
            }
            return invokeLLZ.booleanValue;
        }

        public void parseEndTag(XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, xmlPullParser) == null) {
            }
        }

        public final int parseInt(XmlPullParser xmlPullParser, String str, int i) throws ParserException {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, xmlPullParser, str, i)) == null) {
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
            return invokeLLI.intValue;
        }

        public final long parseLong(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{xmlPullParser, str, Long.valueOf(j)})) == null) {
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
            return invokeCommon.longValue;
        }

        public final int parseRequiredInt(XmlPullParser xmlPullParser, String str) throws ParserException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, xmlPullParser, str)) == null) {
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
            return invokeLL.intValue;
        }

        public final long parseRequiredLong(XmlPullParser xmlPullParser, String str) throws ParserException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, xmlPullParser, str)) == null) {
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
            return invokeLL.longValue;
        }

        public final String parseRequiredString(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, xmlPullParser, str)) == null) {
                String attributeValue = xmlPullParser.getAttributeValue(null, str);
                if (attributeValue != null) {
                    return attributeValue;
                }
                throw new MissingFieldException(str);
            }
            return (String) invokeLL.objValue;
        }

        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, xmlPullParser) == null) {
            }
        }

        public void parseText(XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, xmlPullParser) == null) {
            }
        }

        public final void putNormalizedAttribute(String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, str, obj) == null) {
                this.normalizedAttributes.add(Pair.create(str, obj));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class MissingFieldException extends ParserException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingFieldException(String str) {
            super("Missing required field: " + str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ProtectionParser extends ElementParser {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_SYSTEM_ID = "SystemID";
        public static final String TAG = "Protection";
        public static final String TAG_PROTECTION_HEADER = "ProtectionHeader";
        public transient /* synthetic */ FieldHolder $fh;
        public boolean inProtectionHeader;
        public byte[] initData;
        public UUID uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProtectionParser(ElementParser elementParser, String str) {
            super(elementParser, str, TAG);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementParser, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ElementParser) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static String stripCurlyBraces(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str : (String) invokeL.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                UUID uuid = this.uuid;
                return new SsManifest.ProtectionElement(uuid, PsshAtomUtil.buildPsshAtom(uuid, this.initData));
            }
            return invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public boolean handleChildInline(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? TAG_PROTECTION_HEADER.equals(str) : invokeL.booleanValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseEndTag(XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xmlPullParser) == null) && TAG_PROTECTION_HEADER.equals(xmlPullParser.getName())) {
                this.inProtectionHeader = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, xmlPullParser) == null) && TAG_PROTECTION_HEADER.equals(xmlPullParser.getName())) {
                this.inProtectionHeader = true;
                this.uuid = UUID.fromString(stripCurlyBraces(xmlPullParser.getAttributeValue(null, KEY_SYSTEM_ID)));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseText(XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, xmlPullParser) == null) && this.inProtectionHeader) {
                this.initData = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class QualityLevelParser extends ElementParser {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_BITRATE = "Bitrate";
        public static final String KEY_CHANNELS = "Channels";
        public static final String KEY_CODEC_PRIVATE_DATA = "CodecPrivateData";
        public static final String KEY_FOUR_CC = "FourCC";
        public static final String KEY_INDEX = "Index";
        public static final String KEY_LANGUAGE = "Language";
        public static final String KEY_MAX_HEIGHT = "MaxHeight";
        public static final String KEY_MAX_WIDTH = "MaxWidth";
        public static final String KEY_SAMPLING_RATE = "SamplingRate";
        public static final String KEY_TYPE = "Type";
        public static final String TAG = "QualityLevel";
        public transient /* synthetic */ FieldHolder $fh;
        public Format format;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QualityLevelParser(ElementParser elementParser, String str) {
            super(elementParser, str, TAG);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementParser, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ElementParser) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static List<byte[]> buildCodecSpecificData(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    byte[] bytesFromHexString = Util.getBytesFromHexString(str);
                    byte[][] splitNalUnits = CodecSpecificDataUtil.splitNalUnits(bytesFromHexString);
                    if (splitNalUnits == null) {
                        arrayList.add(bytesFromHexString);
                    } else {
                        Collections.addAll(arrayList, splitNalUnits);
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public static String fourCCToMimeType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if (str.equalsIgnoreCase(PeerConnectionClient.VIDEO_CODEC_H264) || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                    return "video/avc";
                }
                if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                    return "audio/mp4a-latm";
                }
                if (str.equalsIgnoreCase("TTML")) {
                    return MimeTypes.APPLICATION_TTML;
                }
                if (str.equalsIgnoreCase(AudioSampleEntry.TYPE8) || str.equalsIgnoreCase(AC3SpecificBox.TYPE)) {
                    return MimeTypes.AUDIO_AC3;
                }
                if (str.equalsIgnoreCase(AudioSampleEntry.TYPE9) || str.equalsIgnoreCase(EC3SpecificBox.TYPE)) {
                    return MimeTypes.AUDIO_E_AC3;
                }
                if (str.equalsIgnoreCase("dtsc")) {
                    return MimeTypes.AUDIO_DTS;
                }
                if (str.equalsIgnoreCase(AudioSampleEntry.TYPE12) || str.equalsIgnoreCase(AudioSampleEntry.TYPE11)) {
                    return MimeTypes.AUDIO_DTS_HD;
                }
                if (str.equalsIgnoreCase(AudioSampleEntry.TYPE13)) {
                    return MimeTypes.AUDIO_DTS_EXPRESS;
                }
                if (str.equalsIgnoreCase("opus")) {
                    return MimeTypes.AUDIO_OPUS;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.format : invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xmlPullParser) == null) {
                int intValue = ((Integer) getNormalizedAttribute("Type")).intValue();
                String attributeValue = xmlPullParser.getAttributeValue(null, KEY_INDEX);
                int parseRequiredInt = parseRequiredInt(xmlPullParser, KEY_BITRATE);
                String fourCCToMimeType = fourCCToMimeType(parseRequiredString(xmlPullParser, KEY_FOUR_CC));
                if (intValue == 2) {
                    this.format = Format.createVideoContainerFormat(attributeValue, MimeTypes.VIDEO_MP4, fourCCToMimeType, null, parseRequiredInt, parseRequiredInt(xmlPullParser, "MaxWidth"), parseRequiredInt(xmlPullParser, "MaxHeight"), -1.0f, buildCodecSpecificData(xmlPullParser.getAttributeValue(null, KEY_CODEC_PRIVATE_DATA)), 0);
                } else if (intValue != 1) {
                    if (intValue == 3) {
                        this.format = Format.createTextContainerFormat(attributeValue, MimeTypes.APPLICATION_MP4, fourCCToMimeType, null, parseRequiredInt, 0, (String) getNormalizedAttribute("Language"));
                    } else {
                        this.format = Format.createContainerFormat(attributeValue, MimeTypes.APPLICATION_MP4, fourCCToMimeType, null, parseRequiredInt, 0, null);
                    }
                } else {
                    if (fourCCToMimeType == null) {
                        fourCCToMimeType = "audio/mp4a-latm";
                    }
                    int parseRequiredInt2 = parseRequiredInt(xmlPullParser, KEY_CHANNELS);
                    int parseRequiredInt3 = parseRequiredInt(xmlPullParser, KEY_SAMPLING_RATE);
                    List<byte[]> buildCodecSpecificData = buildCodecSpecificData(xmlPullParser.getAttributeValue(null, KEY_CODEC_PRIVATE_DATA));
                    if (buildCodecSpecificData.isEmpty() && "audio/mp4a-latm".equals(fourCCToMimeType)) {
                        buildCodecSpecificData = Collections.singletonList(CodecSpecificDataUtil.buildAacLcAudioSpecificConfig(parseRequiredInt3, parseRequiredInt2));
                    }
                    this.format = Format.createAudioContainerFormat(attributeValue, MimeTypes.AUDIO_MP4, fourCCToMimeType, null, parseRequiredInt, parseRequiredInt2, parseRequiredInt3, buildCodecSpecificData, 0, (String) getNormalizedAttribute("Language"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class SmoothStreamingMediaParser extends ElementParser {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_DURATION = "Duration";
        public static final String KEY_DVR_WINDOW_LENGTH = "DVRWindowLength";
        public static final String KEY_IS_LIVE = "IsLive";
        public static final String KEY_LOOKAHEAD_COUNT = "LookaheadCount";
        public static final String KEY_MAJOR_VERSION = "MajorVersion";
        public static final String KEY_MINOR_VERSION = "MinorVersion";
        public static final String KEY_TIME_SCALE = "TimeScale";
        public static final String TAG = "SmoothStreamingMedia";
        public transient /* synthetic */ FieldHolder $fh;
        public long duration;
        public long dvrWindowLength;
        public boolean isLive;
        public int lookAheadCount;
        public int majorVersion;
        public int minorVersion;
        public SsManifest.ProtectionElement protectionElement;
        public final List<SsManifest.StreamElement> streamElements;
        public long timescale;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SmoothStreamingMediaParser(ElementParser elementParser, String str) {
            super(elementParser, str, TAG);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementParser, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ElementParser) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.lookAheadCount = -1;
            this.protectionElement = null;
            this.streamElements = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void addChild(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof SsManifest.StreamElement) {
                    this.streamElements.add((SsManifest.StreamElement) obj);
                } else if (obj instanceof SsManifest.ProtectionElement) {
                    Assertions.checkState(this.protectionElement == null);
                    this.protectionElement = (SsManifest.ProtectionElement) obj;
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int size = this.streamElements.size();
                SsManifest.StreamElement[] streamElementArr = new SsManifest.StreamElement[size];
                this.streamElements.toArray(streamElementArr);
                if (this.protectionElement != null) {
                    SsManifest.ProtectionElement protectionElement = this.protectionElement;
                    DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(protectionElement.uuid, MimeTypes.VIDEO_MP4, protectionElement.data));
                    for (int i = 0; i < size; i++) {
                        SsManifest.StreamElement streamElement = streamElementArr[i];
                        int i2 = 0;
                        while (true) {
                            Format[] formatArr = streamElement.formats;
                            if (i2 < formatArr.length) {
                                formatArr[i2] = formatArr[i2].copyWithDrmInitData(drmInitData);
                                i2++;
                            }
                        }
                    }
                }
                return new SsManifest(this.majorVersion, this.minorVersion, this.timescale, this.duration, this.dvrWindowLength, this.lookAheadCount, this.isLive, this.protectionElement, streamElementArr);
            }
            return invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xmlPullParser) == null) {
                this.majorVersion = parseRequiredInt(xmlPullParser, KEY_MAJOR_VERSION);
                this.minorVersion = parseRequiredInt(xmlPullParser, KEY_MINOR_VERSION);
                this.timescale = parseLong(xmlPullParser, "TimeScale", 10000000L);
                this.duration = parseRequiredLong(xmlPullParser, KEY_DURATION);
                this.dvrWindowLength = parseLong(xmlPullParser, KEY_DVR_WINDOW_LENGTH, 0L);
                this.lookAheadCount = parseInt(xmlPullParser, KEY_LOOKAHEAD_COUNT, -1);
                this.isLive = parseBoolean(xmlPullParser, KEY_IS_LIVE, false);
                putNormalizedAttribute("TimeScale", Long.valueOf(this.timescale));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class StreamIndexParser extends ElementParser {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_DISPLAY_HEIGHT = "DisplayHeight";
        public static final String KEY_DISPLAY_WIDTH = "DisplayWidth";
        public static final String KEY_FRAGMENT_DURATION = "d";
        public static final String KEY_FRAGMENT_REPEAT_COUNT = "r";
        public static final String KEY_FRAGMENT_START_TIME = "t";
        public static final String KEY_LANGUAGE = "Language";
        public static final String KEY_MAX_HEIGHT = "MaxHeight";
        public static final String KEY_MAX_WIDTH = "MaxWidth";
        public static final String KEY_NAME = "Name";
        public static final String KEY_SUB_TYPE = "Subtype";
        public static final String KEY_TIME_SCALE = "TimeScale";
        public static final String KEY_TYPE = "Type";
        public static final String KEY_TYPE_AUDIO = "audio";
        public static final String KEY_TYPE_TEXT = "text";
        public static final String KEY_TYPE_VIDEO = "video";
        public static final String KEY_URL = "Url";
        public static final String TAG = "StreamIndex";
        public static final String TAG_STREAM_FRAGMENT = "c";
        public transient /* synthetic */ FieldHolder $fh;
        public final String baseUri;
        public int displayHeight;
        public int displayWidth;
        public final List<Format> formats;
        public String language;
        public long lastChunkDuration;
        public int maxHeight;
        public int maxWidth;
        public String name;
        public ArrayList<Long> startTimes;
        public String subType;
        public long timescale;
        public int type;
        public String url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StreamIndexParser(ElementParser elementParser, String str) {
            super(elementParser, str, TAG);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementParser, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ElementParser) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.baseUri = str;
            this.formats = new LinkedList();
        }

        private void parseStreamElementStartTag(XmlPullParser xmlPullParser) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, xmlPullParser) == null) {
                int parseType = parseType(xmlPullParser);
                this.type = parseType;
                putNormalizedAttribute("Type", Integer.valueOf(parseType));
                if (this.type == 3) {
                    this.subType = parseRequiredString(xmlPullParser, KEY_SUB_TYPE);
                } else {
                    this.subType = xmlPullParser.getAttributeValue(null, KEY_SUB_TYPE);
                }
                this.name = xmlPullParser.getAttributeValue(null, KEY_NAME);
                this.url = parseRequiredString(xmlPullParser, KEY_URL);
                this.maxWidth = parseInt(xmlPullParser, "MaxWidth", -1);
                this.maxHeight = parseInt(xmlPullParser, "MaxHeight", -1);
                this.displayWidth = parseInt(xmlPullParser, KEY_DISPLAY_WIDTH, -1);
                this.displayHeight = parseInt(xmlPullParser, KEY_DISPLAY_HEIGHT, -1);
                String attributeValue = xmlPullParser.getAttributeValue(null, "Language");
                this.language = attributeValue;
                putNormalizedAttribute("Language", attributeValue);
                long parseInt = parseInt(xmlPullParser, "TimeScale", -1);
                this.timescale = parseInt;
                if (parseInt == -1) {
                    this.timescale = ((Long) getNormalizedAttribute("TimeScale")).longValue();
                }
                this.startTimes = new ArrayList<>();
            }
        }

        private void parseStreamFragmentStartTag(XmlPullParser xmlPullParser) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(65538, this, xmlPullParser) != null) {
                return;
            }
            int size = this.startTimes.size();
            long parseLong = parseLong(xmlPullParser, "t", C.TIME_UNSET);
            int i = 1;
            if (parseLong == C.TIME_UNSET) {
                if (size == 0) {
                    parseLong = 0;
                } else if (this.lastChunkDuration != -1) {
                    parseLong = this.startTimes.get(size - 1).longValue() + this.lastChunkDuration;
                } else {
                    throw new ParserException("Unable to infer start time");
                }
            }
            this.startTimes.add(Long.valueOf(parseLong));
            this.lastChunkDuration = parseLong(xmlPullParser, "d", C.TIME_UNSET);
            long parseLong2 = parseLong(xmlPullParser, "r", 1L);
            if (parseLong2 > 1 && this.lastChunkDuration == C.TIME_UNSET) {
                throw new ParserException("Repeated chunk with unspecified duration");
            }
            while (true) {
                long j = i;
                if (j >= parseLong2) {
                    return;
                }
                this.startTimes.add(Long.valueOf((this.lastChunkDuration * j) + parseLong));
                i++;
            }
        }

        private int parseType(XmlPullParser xmlPullParser) throws ParserException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, xmlPullParser)) == null) {
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
                    throw new ParserException("Invalid key value[" + attributeValue + PreferencesUtil.RIGHT_MOUNT);
                }
                throw new MissingFieldException("Type");
            }
            return invokeL.intValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void addChild(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Format)) {
                this.formats.add((Format) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Format[] formatArr = new Format[this.formats.size()];
                this.formats.toArray(formatArr);
                return new SsManifest.StreamElement(this.baseUri, this.url, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.displayWidth, this.displayHeight, this.language, formatArr, this.startTimes, this.lastChunkDuration);
            }
            return invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public boolean handleChildInline(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? "c".equals(str) : invokeL.booleanValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, xmlPullParser) == null) {
                if ("c".equals(xmlPullParser.getName())) {
                    parseStreamFragmentStartTag(xmlPullParser);
                } else {
                    parseStreamElementStartTag(xmlPullParser);
                }
            }
        }
    }

    public SsManifestParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public SsManifest parse(Uri uri, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uri, inputStream)) == null) {
            try {
                XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
                newPullParser.setInput(inputStream, null);
                return (SsManifest) new SmoothStreamingMediaParser(null, uri.toString()).parse(newPullParser);
            } catch (XmlPullParserException e) {
                throw new ParserException(e);
            }
        }
        return (SsManifest) invokeLL.objValue;
    }
}
