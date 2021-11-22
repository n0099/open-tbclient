package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import b.h.b.a.i0.v;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes11.dex */
public final class Format implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<Format> CREATOR;
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int accessibilityChannel;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    public int hashCode;
    public final int height;
    public final String id;
    public final List<byte[]> initializationData;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    /* loaded from: classes11.dex */
    public static class a implements Parcelable.Creator<Format> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Format createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new Format(parcel) : (Format) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Format[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new Format[i2] : (Format[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(742195750, "Lcom/google/android/exoplayer2/Format;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(742195750, "Lcom/google/android/exoplayer2/Format;");
                return;
            }
        }
        CREATOR = new a();
    }

    public Format(String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, float f2, int i6, float f3, byte[] bArr, int i7, ColorInfo colorInfo, int i8, int i9, int i10, int i11, int i12, int i13, String str5, int i14, long j, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Integer.valueOf(i6), Float.valueOf(f3), bArr, Integer.valueOf(i7), colorInfo, Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), str5, Integer.valueOf(i14), Long.valueOf(j), list, drmInitData, metadata};
            interceptable.invokeUnInit(65538, newInitContext);
            int i15 = newInitContext.flag;
            if ((i15 & 1) != 0) {
                int i16 = i15 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.id = str;
        this.containerMimeType = str2;
        this.sampleMimeType = str3;
        this.codecs = str4;
        this.bitrate = i2;
        this.maxInputSize = i3;
        this.width = i4;
        this.height = i5;
        this.frameRate = f2;
        this.rotationDegrees = i6;
        this.pixelWidthHeightRatio = f3;
        this.projectionData = bArr;
        this.stereoMode = i7;
        this.colorInfo = colorInfo;
        this.channelCount = i8;
        this.sampleRate = i9;
        this.pcmEncoding = i10;
        this.encoderDelay = i11;
        this.encoderPadding = i12;
        this.selectionFlags = i13;
        this.language = str5;
        this.accessibilityChannel = i14;
        this.subsampleOffsetUs = j;
        this.initializationData = list == null ? Collections.emptyList() : list;
        this.drmInitData = drmInitData;
        this.metadata = metadata;
    }

    public static Format createAudioContainerFormat(String str, String str2, String str3, String str4, int i2, int i3, int i4, List<byte[]> list, int i5, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), list, Integer.valueOf(i5), str5})) == null) ? new Format(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, -1, -1, -1, i5, str5, -1, Long.MAX_VALUE, list, null, null) : (Format) invokeCommon.objValue;
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), list, drmInitData, Integer.valueOf(i6), str4})) == null) ? createAudioSampleFormat(str, str2, str3, i2, i3, i4, i5, -1, list, drmInitData, i6, str4) : (Format) invokeCommon.objValue;
    }

    public static Format createContainerFormat(String str, String str2, String str3, String str4, int i2, int i3, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), str5})) == null) ? new Format(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str5, -1, Long.MAX_VALUE, null, null, null) : (Format) invokeCommon.objValue;
    }

    public static Format createImageSampleFormat(String str, String str2, String str3, int i2, List<byte[]> list, String str4, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, Integer.valueOf(i2), list, str4, drmInitData})) == null) ? new Format(str, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, drmInitData, null) : (Format) invokeCommon.objValue;
    }

    public static Format createSampleFormat(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, str2, Long.valueOf(j)})) == null) ? new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j, null, null, null) : (Format) invokeCommon.objValue;
    }

    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, int i2, int i3, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), str5})) == null) ? createTextContainerFormat(str, str2, str3, str4, i2, i3, str5, -1) : (Format) invokeCommon.objValue;
    }

    public static Format createTextSampleFormat(String str, String str2, int i2, String str3) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65549, null, str, str2, i2, str3)) == null) ? createTextSampleFormat(str, str2, i2, str3, null) : (Format) invokeLLIL.objValue;
    }

    public static Format createVideoContainerFormat(String str, String str2, String str3, String str4, int i2, int i3, int i4, float f2, List<byte[]> list, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), list, Integer.valueOf(i5)})) == null) ? new Format(str, str2, str3, str4, i2, -1, i3, i4, f2, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i5, null, -1, Long.MAX_VALUE, list, null, null) : (Format) invokeCommon.objValue;
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), list, drmInitData})) == null) ? createVideoSampleFormat(str, str2, str3, i2, i3, i4, i5, f2, list, -1, -1.0f, drmInitData) : (Format) invokeCommon.objValue;
    }

    private DrmInitData getFilledManifestDrmData(DrmInitData drmInitData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, drmInitData)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < drmInitData.schemeDataCount; i2++) {
                DrmInitData.SchemeData schemeData = drmInitData.get(i2);
                if (schemeData.hasData()) {
                    arrayList.add(schemeData);
                } else {
                    arrayList2.add(schemeData);
                }
            }
            if (arrayList2.isEmpty()) {
                return drmInitData;
            }
            if (this.drmInitData == null) {
                return null;
            }
            int size = arrayList2.size();
            int i3 = 0;
            while (true) {
                DrmInitData drmInitData2 = this.drmInitData;
                if (i3 >= drmInitData2.schemeDataCount) {
                    break;
                }
                DrmInitData.SchemeData schemeData2 = drmInitData2.get(i3);
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    } else if (schemeData2.canReplace((DrmInitData.SchemeData) arrayList2.get(i4))) {
                        arrayList.add(schemeData2);
                        break;
                    } else {
                        i4++;
                    }
                }
                i3++;
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new DrmInitData(drmInitData.schemeType, (DrmInitData.SchemeData[]) arrayList.toArray(new DrmInitData.SchemeData[arrayList.size()]));
        }
        return (DrmInitData) invokeL.objValue;
    }

    @TargetApi(16)
    public static void maybeSetByteBufferV16(MediaFormat mediaFormat, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65559, null, mediaFormat, str, bArr) == null) || bArr == null) {
            return;
        }
        mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
    }

    @TargetApi(24)
    public static void maybeSetColorInfoV24(MediaFormat mediaFormat, ColorInfo colorInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65560, null, mediaFormat, colorInfo) == null) || colorInfo == null) {
            return;
        }
        maybeSetIntegerV16(mediaFormat, "color-transfer", colorInfo.colorTransfer);
        maybeSetIntegerV16(mediaFormat, "color-standard", colorInfo.colorSpace);
        maybeSetIntegerV16(mediaFormat, "color-range", colorInfo.colorRange);
        maybeSetByteBufferV16(mediaFormat, "hdr-static-info", colorInfo.hdrStaticInfo);
    }

    @TargetApi(16)
    public static void maybeSetFloatV16(MediaFormat mediaFormat, String str, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{mediaFormat, str, Float.valueOf(f2)}) == null) || f2 == -1.0f) {
            return;
        }
        mediaFormat.setFloat(str, f2);
    }

    @TargetApi(16)
    public static void maybeSetIntegerV16(MediaFormat mediaFormat, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65562, null, mediaFormat, str, i2) == null) || i2 == -1) {
            return;
        }
        mediaFormat.setInteger(str, i2);
    }

    @TargetApi(16)
    public static void maybeSetStringV16(MediaFormat mediaFormat, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65563, null, mediaFormat, str, str2) == null) || str2 == null) {
            return;
        }
        mediaFormat.setString(str, str2);
    }

    public static String toLogString(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, format)) == null) {
            if (format == null) {
                return StringUtil.NULL_STRING;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("id=");
            sb.append(format.id);
            sb.append(", mimeType=");
            sb.append(format.sampleMimeType);
            if (format.bitrate != -1) {
                sb.append(", bitrate=");
                sb.append(format.bitrate);
            }
            if (format.width != -1 && format.height != -1) {
                sb.append(", res=");
                sb.append(format.width);
                sb.append("x");
                sb.append(format.height);
            }
            if (format.frameRate != -1.0f) {
                sb.append(", fps=");
                sb.append(format.frameRate);
            }
            if (format.channelCount != -1) {
                sb.append(", channels=");
                sb.append(format.channelCount);
            }
            if (format.sampleRate != -1) {
                sb.append(", sample_rate=");
                sb.append(format.sampleRate);
            }
            if (format.language != null) {
                sb.append(", language=");
                sb.append(format.language);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public Format copyWithContainerInfo(String str, String str2, int i2, int i3, int i4, int i5, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str3})) == null) ? new Format(str, this.containerMimeType, this.sampleMimeType, str2, i2, this.maxInputSize, i3, i4, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i5, str3, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata) : (Format) invokeCommon.objValue;
    }

    public Format copyWithDrmInitData(DrmInitData drmInitData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drmInitData)) == null) ? new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, drmInitData, this.metadata) : (Format) invokeL.objValue;
    }

    public Format copyWithGaplessInfo(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) ? new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, i2, i3, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata) : (Format) invokeII.objValue;
    }

    public Format copyWithManifestFormatInfo(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, format)) == null) {
            if (this == format) {
                return this;
            }
            String str = format.id;
            String str2 = this.codecs;
            if (str2 == null) {
                str2 = format.codecs;
            }
            String str3 = str2;
            int i2 = this.bitrate;
            if (i2 == -1) {
                i2 = format.bitrate;
            }
            int i3 = i2;
            float f2 = this.frameRate;
            if (f2 == -1.0f) {
                f2 = format.frameRate;
            }
            float f3 = f2;
            int i4 = this.selectionFlags | format.selectionFlags;
            String str4 = this.language;
            if (str4 == null) {
                str4 = format.language;
            }
            String str5 = str4;
            DrmInitData drmInitData = format.drmInitData;
            return new Format(str, this.containerMimeType, this.sampleMimeType, str3, i3, this.maxInputSize, this.width, this.height, f3, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i4, str5, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, drmInitData != null ? getFilledManifestDrmData(drmInitData) : this.drmInitData, this.metadata);
        }
        return (Format) invokeL.objValue;
    }

    public Format copyWithMaxInputSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, i2, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata) : (Format) invokeI.objValue;
    }

    public Format copyWithMetadata(Metadata metadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, metadata)) == null) ? new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, metadata) : (Format) invokeL.objValue;
    }

    public Format copyWithRotationDegrees(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, i2, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata) : (Format) invokeI.objValue;
    }

    public Format copyWithSubsampleOffsetUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) ? new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, j, this.initializationData, this.drmInitData, this.metadata) : (Format) invokeJ.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Format.class == obj.getClass()) {
                Format format = (Format) obj;
                if (this.bitrate == format.bitrate && this.maxInputSize == format.maxInputSize && this.width == format.width && this.height == format.height && this.frameRate == format.frameRate && this.rotationDegrees == format.rotationDegrees && this.pixelWidthHeightRatio == format.pixelWidthHeightRatio && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.subsampleOffsetUs == format.subsampleOffsetUs && this.selectionFlags == format.selectionFlags && v.a(this.id, format.id) && v.a(this.language, format.language) && this.accessibilityChannel == format.accessibilityChannel && v.a(this.containerMimeType, format.containerMimeType) && v.a(this.sampleMimeType, format.sampleMimeType) && v.a(this.codecs, format.codecs) && v.a(this.drmInitData, format.drmInitData) && v.a(this.metadata, format.metadata) && v.a(this.colorInfo, format.colorInfo) && Arrays.equals(this.projectionData, format.projectionData) && this.initializationData.size() == format.initializationData.size()) {
                    for (int i2 = 0; i2 < this.initializationData.size(); i2++) {
                        if (!Arrays.equals(this.initializationData.get(i2), format.initializationData.get(i2))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat getFrameworkMediaFormatV16() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", this.sampleMimeType);
            maybeSetStringV16(mediaFormat, "language", this.language);
            maybeSetIntegerV16(mediaFormat, "max-input-size", this.maxInputSize);
            maybeSetIntegerV16(mediaFormat, "width", this.width);
            maybeSetIntegerV16(mediaFormat, "height", this.height);
            maybeSetFloatV16(mediaFormat, "frame-rate", this.frameRate);
            maybeSetIntegerV16(mediaFormat, "rotation-degrees", this.rotationDegrees);
            maybeSetIntegerV16(mediaFormat, "channel-count", this.channelCount);
            maybeSetIntegerV16(mediaFormat, "sample-rate", this.sampleRate);
            for (int i2 = 0; i2 < this.initializationData.size(); i2++) {
                mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap(this.initializationData.get(i2)));
            }
            maybeSetColorInfoV24(mediaFormat, this.colorInfo);
            return mediaFormat;
        }
        return (MediaFormat) invokeV.objValue;
    }

    public int getPixelCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i3 = this.width;
            if (i3 == -1 || (i2 = this.height) == -1) {
                return -1;
            }
            return i3 * i2;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.hashCode == 0) {
                String str = this.id;
                int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.containerMimeType;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.sampleMimeType;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.codecs;
                int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.channelCount) * 31) + this.sampleRate) * 31;
                String str5 = this.language;
                int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.accessibilityChannel) * 31;
                DrmInitData drmInitData = this.drmInitData;
                int hashCode6 = (hashCode5 + (drmInitData == null ? 0 : drmInitData.hashCode())) * 31;
                Metadata metadata = this.metadata;
                this.hashCode = hashCode6 + (metadata != null ? metadata.hashCode() : 0);
            }
            return this.hashCode;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "Format(" + this.id + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.containerMimeType + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.sampleMimeType + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.bitrate + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.language + ", [" + this.width + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.height + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.frameRate + PreferencesUtil.RIGHT_MOUNT + ", [" + this.channelCount + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.sampleRate + "])";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, parcel, i2) == null) {
            parcel.writeString(this.id);
            parcel.writeString(this.containerMimeType);
            parcel.writeString(this.sampleMimeType);
            parcel.writeString(this.codecs);
            parcel.writeInt(this.bitrate);
            parcel.writeInt(this.maxInputSize);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            parcel.writeFloat(this.frameRate);
            parcel.writeInt(this.rotationDegrees);
            parcel.writeFloat(this.pixelWidthHeightRatio);
            parcel.writeInt(this.projectionData != null ? 1 : 0);
            byte[] bArr = this.projectionData;
            if (bArr != null) {
                parcel.writeByteArray(bArr);
            }
            parcel.writeInt(this.stereoMode);
            parcel.writeParcelable(this.colorInfo, i2);
            parcel.writeInt(this.channelCount);
            parcel.writeInt(this.sampleRate);
            parcel.writeInt(this.pcmEncoding);
            parcel.writeInt(this.encoderDelay);
            parcel.writeInt(this.encoderPadding);
            parcel.writeInt(this.selectionFlags);
            parcel.writeString(this.language);
            parcel.writeInt(this.accessibilityChannel);
            parcel.writeLong(this.subsampleOffsetUs);
            int size = this.initializationData.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeByteArray(this.initializationData.get(i3));
            }
            parcel.writeParcelable(this.drmInitData, 0);
            parcel.writeParcelable(this.metadata, 0);
        }
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, List<byte[]> list, DrmInitData drmInitData, int i7, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), list, drmInitData, Integer.valueOf(i7), str4})) == null) ? createAudioSampleFormat(str, str2, str3, i2, i3, i4, i5, i6, -1, -1, list, drmInitData, i7, str4, null) : (Format) invokeCommon.objValue;
    }

    public static Format createSampleFormat(String str, String str2, String str3, int i2, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{str, str2, str3, Integer.valueOf(i2), drmInitData})) == null) ? new Format(str, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, drmInitData, null) : (Format) invokeCommon.objValue;
    }

    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, int i2, int i3, String str5, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), str5, Integer.valueOf(i4)})) == null) ? new Format(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str5, i4, Long.MAX_VALUE, null, null, null) : (Format) invokeCommon.objValue;
    }

    public static Format createTextSampleFormat(String str, String str2, int i2, String str3, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{str, str2, Integer.valueOf(i2), str3, drmInitData})) == null) ? createTextSampleFormat(str, str2, null, -1, i2, str3, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList()) : (Format) invokeCommon.objValue;
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), list, Integer.valueOf(i6), Float.valueOf(f3), drmInitData})) == null) ? createVideoSampleFormat(str, str2, str3, i2, i3, i4, i5, f2, list, i6, f3, null, -1, null, drmInitData) : (Format) invokeCommon.objValue;
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, List<byte[]> list, DrmInitData drmInitData, int i9, String str4, Metadata metadata) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), list, drmInitData, Integer.valueOf(i9), str4, metadata})) == null) ? new Format(str, null, str2, str3, i2, i3, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i4, i5, i6, i7, i8, i9, str4, -1, Long.MAX_VALUE, list, drmInitData, metadata) : (Format) invokeCommon.objValue;
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, byte[] bArr, int i7, ColorInfo colorInfo, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), list, Integer.valueOf(i6), Float.valueOf(f3), bArr, Integer.valueOf(i7), colorInfo, drmInitData})) == null) ? new Format(str, null, str2, str3, i2, i3, i4, i5, f2, i6, f3, bArr, i7, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null) : (Format) invokeCommon.objValue;
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i2, int i3, String str4, int i4, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4, Integer.valueOf(i4), drmInitData})) == null) ? createTextSampleFormat(str, str2, str3, i2, i3, str4, i4, drmInitData, Long.MAX_VALUE, Collections.emptyList()) : (Format) invokeCommon.objValue;
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i2, int i3, String str4, DrmInitData drmInitData, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4, drmInitData, Long.valueOf(j)})) == null) ? createTextSampleFormat(str, str2, str3, i2, i3, str4, -1, drmInitData, j, Collections.emptyList()) : (Format) invokeCommon.objValue;
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i2, int i3, String str4, int i4, DrmInitData drmInitData, long j, List<byte[]> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4, Integer.valueOf(i4), drmInitData, Long.valueOf(j), list})) == null) ? new Format(str, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str4, i4, j, list, drmInitData, null) : (Format) invokeCommon.objValue;
    }

    public Format(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.id = parcel.readString();
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.codecs = parcel.readString();
        this.bitrate = parcel.readInt();
        this.maxInputSize = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        this.projectionData = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.colorInfo = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.selectionFlags = parcel.readInt();
        this.language = parcel.readString();
        this.accessibilityChannel = parcel.readInt();
        this.subsampleOffsetUs = parcel.readLong();
        int readInt = parcel.readInt();
        this.initializationData = new ArrayList(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            this.initializationData.add(parcel.createByteArray());
        }
        this.drmInitData = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.metadata = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
    }
}
