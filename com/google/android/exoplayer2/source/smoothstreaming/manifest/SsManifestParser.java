package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import d.f.b.a.a0.q.h;
import d.f.b.a.d0.x.e.a;
import d.f.b.a.h0.o;
import d.f.b.a.i0.v;
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
public class SsManifestParser implements o.a<d.f.b.a.d0.x.e.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final XmlPullParserFactory f32758a;

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f32759a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32760b;

        /* renamed from: c  reason: collision with root package name */
        public final a f32761c;

        /* renamed from: d  reason: collision with root package name */
        public final List<Pair<String, Object>> f32762d;

        public a(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32761c = aVar;
            this.f32759a = str;
            this.f32760b = str2;
            this.f32762d = new LinkedList();
        }

        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            }
        }

        public abstract Object b();

        public final Object c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                for (int i2 = 0; i2 < this.f32762d.size(); i2++) {
                    Pair<String, Object> pair = this.f32762d.get(i2);
                    if (((String) pair.first).equals(str)) {
                        return pair.second;
                    }
                }
                a aVar = this.f32761c;
                if (aVar == null) {
                    return null;
                }
                return aVar.c(str);
            }
            return invokeL.objValue;
        }

        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public final a e(a aVar, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, aVar, str, str2)) == null) {
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
            return (a) invokeLLL.objValue;
        }

        public final Object f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, xmlPullParser)) != null) {
                return invokeL.objValue;
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f32760b.equals(name)) {
                        n(xmlPullParser);
                        z = true;
                    } else if (z) {
                        if (i2 > 0) {
                            i2++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            a e2 = e(this, name, this.f32759a);
                            if (e2 == null) {
                                i2 = 1;
                            } else {
                                a(e2.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i2 == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i2 > 0) {
                    i2--;
                } else {
                    String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        public final boolean g(XmlPullParser xmlPullParser, String str, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, xmlPullParser, str, z)) == null) {
                String attributeValue = xmlPullParser.getAttributeValue(null, str);
                return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z;
            }
            return invokeLLZ.booleanValue;
        }

        public void h(XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, xmlPullParser) == null) {
            }
        }

        public final int i(XmlPullParser xmlPullParser, String str, int i2) throws ParserException {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, xmlPullParser, str, i2)) == null) {
                String attributeValue = xmlPullParser.getAttributeValue(null, str);
                if (attributeValue != null) {
                    try {
                        return Integer.parseInt(attributeValue);
                    } catch (NumberFormatException e2) {
                        throw new ParserException(e2);
                    }
                }
                return i2;
            }
            return invokeLLI.intValue;
        }

        public final long j(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{xmlPullParser, str, Long.valueOf(j)})) == null) {
                String attributeValue = xmlPullParser.getAttributeValue(null, str);
                if (attributeValue != null) {
                    try {
                        return Long.parseLong(attributeValue);
                    } catch (NumberFormatException e2) {
                        throw new ParserException(e2);
                    }
                }
                return j;
            }
            return invokeCommon.longValue;
        }

        public final int k(XmlPullParser xmlPullParser, String str) throws ParserException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, xmlPullParser, str)) == null) {
                String attributeValue = xmlPullParser.getAttributeValue(null, str);
                if (attributeValue != null) {
                    try {
                        return Integer.parseInt(attributeValue);
                    } catch (NumberFormatException e2) {
                        throw new ParserException(e2);
                    }
                }
                throw new MissingFieldException(str);
            }
            return invokeLL.intValue;
        }

        public final long l(XmlPullParser xmlPullParser, String str) throws ParserException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, xmlPullParser, str)) == null) {
                String attributeValue = xmlPullParser.getAttributeValue(null, str);
                if (attributeValue != null) {
                    try {
                        return Long.parseLong(attributeValue);
                    } catch (NumberFormatException e2) {
                        throw new ParserException(e2);
                    }
                }
                throw new MissingFieldException(str);
            }
            return invokeLL.longValue;
        }

        public final String m(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, xmlPullParser, str)) == null) {
                String attributeValue = xmlPullParser.getAttributeValue(null, str);
                if (attributeValue != null) {
                    return attributeValue;
                }
                throw new MissingFieldException(str);
            }
            return (String) invokeLL.objValue;
        }

        public abstract void n(XmlPullParser xmlPullParser) throws ParserException;

        public void o(XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, xmlPullParser) == null) {
            }
        }

        public final void p(String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, str, obj) == null) {
                this.f32762d.add(Pair.create(str, obj));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f32763e;

        /* renamed from: f  reason: collision with root package name */
        public UUID f32764f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f32765g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str) {
            super(aVar, str, "Protection");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static String q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str : (String) invokeL.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                UUID uuid = this.f32764f;
                return new a.C2013a(uuid, h.a(uuid, this.f32765g));
            }
            return invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? "ProtectionHeader".equals(str) : invokeL.booleanValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void h(XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xmlPullParser) == null) && "ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f32763e = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, xmlPullParser) == null) && "ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f32763e = true;
                this.f32764f = UUID.fromString(q(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void o(XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, xmlPullParser) == null) && this.f32763e) {
                this.f32765g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Format f32766e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str) {
            super(aVar, str, "QualityLevel");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static List<byte[]> q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    byte[] n = v.n(str);
                    byte[][] k = d.f.b.a.i0.c.k(n);
                    if (k == null) {
                        arrayList.add(n);
                    } else {
                        Collections.addAll(arrayList, k);
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public static String r(String str) {
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
            return (String) invokeL.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32766e : invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xmlPullParser) == null) {
                int intValue = ((Integer) c("Type")).intValue();
                String attributeValue = xmlPullParser.getAttributeValue(null, "Index");
                int k = k(xmlPullParser, "Bitrate");
                String r = r(m(xmlPullParser, "FourCC"));
                if (intValue == 2) {
                    this.f32766e = Format.createVideoContainerFormat(attributeValue, "video/mp4", r, null, k, k(xmlPullParser, "MaxWidth"), k(xmlPullParser, "MaxHeight"), -1.0f, q(xmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
                } else if (intValue != 1) {
                    if (intValue == 3) {
                        this.f32766e = Format.createTextContainerFormat(attributeValue, "application/mp4", r, null, k, 0, (String) c("Language"));
                    } else {
                        this.f32766e = Format.createContainerFormat(attributeValue, "application/mp4", r, null, k, 0, null);
                    }
                } else {
                    if (r == null) {
                        r = "audio/mp4a-latm";
                    }
                    int k2 = k(xmlPullParser, "Channels");
                    int k3 = k(xmlPullParser, "SamplingRate");
                    List<byte[]> q = q(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                    if (q.isEmpty() && "audio/mp4a-latm".equals(r)) {
                        q = Collections.singletonList(d.f.b.a.i0.c.b(k3, k2));
                    }
                    this.f32766e = Format.createAudioContainerFormat(attributeValue, "audio/mp4", r, null, k, k2, k3, q, 0, (String) c("Language"));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final List<a.b> f32767e;

        /* renamed from: f  reason: collision with root package name */
        public int f32768f;

        /* renamed from: g  reason: collision with root package name */
        public int f32769g;

        /* renamed from: h  reason: collision with root package name */
        public long f32770h;

        /* renamed from: i  reason: collision with root package name */
        public long f32771i;
        public long j;
        public int k;
        public boolean l;
        public a.C2013a m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = -1;
            this.m = null;
            this.f32767e = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof a.b) {
                    this.f32767e.add((a.b) obj);
                } else if (obj instanceof a.C2013a) {
                    d.f.b.a.i0.a.f(this.m == null);
                    this.m = (a.C2013a) obj;
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int size = this.f32767e.size();
                a.b[] bVarArr = new a.b[size];
                this.f32767e.toArray(bVarArr);
                if (this.m != null) {
                    a.C2013a c2013a = this.m;
                    DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(c2013a.f73004a, "video/mp4", c2013a.f73005b));
                    for (int i2 = 0; i2 < size; i2++) {
                        a.b bVar = bVarArr[i2];
                        int i3 = 0;
                        while (true) {
                            Format[] formatArr = bVar.f73008c;
                            if (i3 < formatArr.length) {
                                formatArr[i3] = formatArr[i3].copyWithDrmInitData(drmInitData);
                                i3++;
                            }
                        }
                    }
                }
                return new d.f.b.a.d0.x.e.a(this.f32768f, this.f32769g, this.f32770h, this.f32771i, this.j, this.k, this.l, this.m, bVarArr);
            }
            return invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xmlPullParser) == null) {
                this.f32768f = k(xmlPullParser, "MajorVersion");
                this.f32769g = k(xmlPullParser, "MinorVersion");
                this.f32770h = j(xmlPullParser, "TimeScale", 10000000L);
                this.f32771i = l(xmlPullParser, "Duration");
                this.j = j(xmlPullParser, "DVRWindowLength", 0L);
                this.k = i(xmlPullParser, "LookaheadCount", -1);
                this.l = g(xmlPullParser, "IsLive", false);
                p("TimeScale", Long.valueOf(this.f32770h));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f32772e;

        /* renamed from: f  reason: collision with root package name */
        public final List<Format> f32773f;

        /* renamed from: g  reason: collision with root package name */
        public int f32774g;

        /* renamed from: h  reason: collision with root package name */
        public String f32775h;

        /* renamed from: i  reason: collision with root package name */
        public long f32776i;
        public String j;
        public String k;
        public int l;
        public int m;
        public int n;
        public int o;
        public String p;
        public ArrayList<Long> q;
        public long r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32772e = str;
            this.f32773f = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Format)) {
                this.f32773f.add((Format) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Format[] formatArr = new Format[this.f32773f.size()];
                this.f32773f.toArray(formatArr);
                return new a.b(this.f32772e, this.k, this.f32774g, this.f32775h, this.f32776i, this.j, this.l, this.m, this.n, this.o, this.p, formatArr, this.q, this.r);
            }
            return invokeV.objValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? "c".equals(str) : invokeL.booleanValue;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, xmlPullParser) == null) {
                if ("c".equals(xmlPullParser.getName())) {
                    r(xmlPullParser);
                } else {
                    q(xmlPullParser);
                }
            }
        }

        public final void q(XmlPullParser xmlPullParser) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, xmlPullParser) == null) {
                int s = s(xmlPullParser);
                this.f32774g = s;
                p("Type", Integer.valueOf(s));
                if (this.f32774g == 3) {
                    this.f32775h = m(xmlPullParser, "Subtype");
                } else {
                    this.f32775h = xmlPullParser.getAttributeValue(null, "Subtype");
                }
                this.j = xmlPullParser.getAttributeValue(null, "Name");
                this.k = m(xmlPullParser, "Url");
                this.l = i(xmlPullParser, "MaxWidth", -1);
                this.m = i(xmlPullParser, "MaxHeight", -1);
                this.n = i(xmlPullParser, "DisplayWidth", -1);
                this.o = i(xmlPullParser, "DisplayHeight", -1);
                String attributeValue = xmlPullParser.getAttributeValue(null, "Language");
                this.p = attributeValue;
                p("Language", attributeValue);
                long i2 = i(xmlPullParser, "TimeScale", -1);
                this.f32776i = i2;
                if (i2 == -1) {
                    this.f32776i = ((Long) c("TimeScale")).longValue();
                }
                this.q = new ArrayList<>();
            }
        }

        public final void r(XmlPullParser xmlPullParser) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048581, this, xmlPullParser) != null) {
                return;
            }
            int size = this.q.size();
            long j = j(xmlPullParser, "t", -9223372036854775807L);
            int i2 = 1;
            if (j == -9223372036854775807L) {
                if (size == 0) {
                    j = 0;
                } else if (this.r != -1) {
                    j = this.q.get(size - 1).longValue() + this.r;
                } else {
                    throw new ParserException("Unable to infer start time");
                }
            }
            this.q.add(Long.valueOf(j));
            this.r = j(xmlPullParser, "d", -9223372036854775807L);
            long j2 = j(xmlPullParser, r.f7745a, 1L);
            if (j2 > 1 && this.r == -9223372036854775807L) {
                throw new ParserException("Repeated chunk with unspecified duration");
            }
            while (true) {
                long j3 = i2;
                if (j3 >= j2) {
                    return;
                }
                this.q.add(Long.valueOf((this.r * j3) + j));
                i2++;
            }
        }

        public final int s(XmlPullParser xmlPullParser) throws ParserException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xmlPullParser)) == null) {
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
    }

    public SsManifestParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.f32758a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.b.a.h0.o.a
    /* renamed from: b */
    public d.f.b.a.d0.x.e.a a(Uri uri, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, inputStream)) == null) {
            try {
                XmlPullParser newPullParser = this.f32758a.newPullParser();
                newPullParser.setInput(inputStream, null);
                return (d.f.b.a.d0.x.e.a) new d(null, uri.toString()).f(newPullParser);
            } catch (XmlPullParserException e2) {
                throw new ParserException(e2);
            }
        }
        return (d.f.b.a.d0.x.e.a) invokeLL.objValue;
    }
}
