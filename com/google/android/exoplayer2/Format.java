package com.google.android.exoplayer2;

import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class Format implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator CREATOR;
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
    public final List initializationData;
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

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
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
        CREATOR = new Parcelable.Creator() { // from class: com.google.android.exoplayer2.Format.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public Format createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new Format(parcel);
                }
                return (Format) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public Format[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new Format[i];
                }
                return (Format[]) invokeI.objValue;
            }
        };
    }

    public int getPixelCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = this.width;
            if (i2 == -1 || (i = this.height) == -1) {
                return -1;
            }
            return i2 * i;
        }
        return invokeV.intValue;
    }

    public Format(Parcel parcel) {
        boolean z;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            bArr = parcel.createByteArray();
        } else {
            bArr = null;
        }
        this.projectionData = bArr;
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
        for (int i3 = 0; i3 < readInt; i3++) {
            this.initializationData.add(parcel.createByteArray());
        }
        this.drmInitData = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.metadata = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
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
                if (this.bitrate == format.bitrate && this.maxInputSize == format.maxInputSize && this.width == format.width && this.height == format.height && this.frameRate == format.frameRate && this.rotationDegrees == format.rotationDegrees && this.pixelWidthHeightRatio == format.pixelWidthHeightRatio && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.subsampleOffsetUs == format.subsampleOffsetUs && this.selectionFlags == format.selectionFlags && Util.areEqual(this.id, format.id) && Util.areEqual(this.language, format.language) && this.accessibilityChannel == format.accessibilityChannel && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.drmInitData, format.drmInitData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Arrays.equals(this.projectionData, format.projectionData) && this.initializationData.size() == format.initializationData.size()) {
                    for (int i = 0; i < this.initializationData.size(); i++) {
                        if (!Arrays.equals((byte[]) this.initializationData.get(i), (byte[]) format.initializationData.get(i))) {
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

    public Format(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List list, DrmInitData drmInitData, Metadata metadata) {
        List list2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), Integer.valueOf(i5), Float.valueOf(f2), bArr, Integer.valueOf(i6), colorInfo, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), str5, Integer.valueOf(i13), Long.valueOf(j), list, drmInitData, metadata};
            interceptable.invokeUnInit(65538, newInitContext);
            int i14 = newInitContext.flag;
            if ((i14 & 1) != 0) {
                int i15 = i14 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.id = str;
        this.containerMimeType = str2;
        this.sampleMimeType = str3;
        this.codecs = str4;
        this.bitrate = i;
        this.maxInputSize = i2;
        this.width = i3;
        this.height = i4;
        this.frameRate = f;
        this.rotationDegrees = i5;
        this.pixelWidthHeightRatio = f2;
        this.projectionData = bArr;
        this.stereoMode = i6;
        this.colorInfo = colorInfo;
        this.channelCount = i7;
        this.sampleRate = i8;
        this.pcmEncoding = i9;
        this.encoderDelay = i10;
        this.encoderPadding = i11;
        this.selectionFlags = i12;
        this.language = str5;
        this.accessibilityChannel = i13;
        this.subsampleOffsetUs = j;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = list;
        }
        this.initializationData = list2;
        this.drmInitData = drmInitData;
        this.metadata = metadata;
    }

    public static Format createAudioContainerFormat(String str, String str2, String str3, String str4, int i, int i2, int i3, List list, int i4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), list, Integer.valueOf(i4), str5})) == null) {
            return new Format(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i2, i3, -1, -1, -1, i4, str5, -1, Long.MAX_VALUE, list, null, null);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i, int i2, String str4, int i3, DrmInitData drmInitData, long j, List list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), str4, Integer.valueOf(i3), drmInitData, Long.valueOf(j), list})) == null) {
            return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, i3, j, list, drmInitData, null);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createVideoContainerFormat(String str, String str2, String str3, String str4, int i, int i2, int i3, float f, List list, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), list, Integer.valueOf(i4)})) == null) {
            return new Format(str, str2, str3, str4, i, -1, i2, i3, f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i4, null, -1, Long.MAX_VALUE, list, null, null);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List list, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), list, drmInitData})) == null) {
            return createVideoSampleFormat(str, str2, str3, i, i2, i3, i4, f, list, -1, -1.0f, drmInitData);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, List list, DrmInitData drmInitData, int i8, String str4, Metadata metadata) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), list, drmInitData, Integer.valueOf(i8), str4, metadata})) == null) {
            return new Format(str, null, str2, str3, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, i6, i7, i8, str4, -1, Long.MAX_VALUE, list, drmInitData, metadata);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List list, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), list, Integer.valueOf(i5), Float.valueOf(f2), bArr, Integer.valueOf(i6), colorInfo, drmInitData})) == null) {
            return new Format(str, null, str2, str3, i, i2, i3, i4, f, i5, f2, bArr, i6, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List list, DrmInitData drmInitData, int i6, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), list, drmInitData, Integer.valueOf(i6), str4})) == null) {
            return createAudioSampleFormat(str, str2, str3, i, i2, i3, i4, i5, -1, -1, list, drmInitData, i6, str4, null);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List list, int i5, float f2, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), list, Integer.valueOf(i5), Float.valueOf(f2), drmInitData})) == null) {
            return createVideoSampleFormat(str, str2, str3, i, i2, i3, i4, f, list, i5, f2, null, -1, null, drmInitData);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, List list, DrmInitData drmInitData, int i5, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), list, drmInitData, Integer.valueOf(i5), str4})) == null) {
            return createAudioSampleFormat(str, str2, str3, i, i2, i3, i4, -1, list, drmInitData, i5, str4);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createContainerFormat(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), str5})) == null) {
            return new Format(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, -1, Long.MAX_VALUE, null, null, null);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createImageSampleFormat(String str, String str2, String str3, int i, List list, String str4, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, Integer.valueOf(i), list, str4, drmInitData})) == null) {
            return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, drmInitData, null);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createSampleFormat(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j, null, null, null);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createSampleFormat(String str, String str2, String str3, int i, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{str, str2, str3, Integer.valueOf(i), drmInitData})) == null) {
            return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, drmInitData, null);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), str5})) == null) {
            return createTextContainerFormat(str, str2, str3, str4, i, i2, str5, -1);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, int i, int i2, String str5, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), str5, Integer.valueOf(i3)})) == null) {
            return new Format(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, i3, Long.MAX_VALUE, null, null, null);
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createTextSampleFormat(String str, String str2, int i, String str3) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65549, null, str, str2, i, str3)) == null) {
            return createTextSampleFormat(str, str2, i, str3, null);
        }
        return (Format) invokeLLIL.objValue;
    }

    public static Format createTextSampleFormat(String str, String str2, int i, String str3, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{str, str2, Integer.valueOf(i), str3, drmInitData})) == null) {
            return createTextSampleFormat(str, str2, null, -1, i, str3, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList());
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i, int i2, String str4, int i3, DrmInitData drmInitData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), str4, Integer.valueOf(i3), drmInitData})) == null) {
            return createTextSampleFormat(str, str2, str3, i, i2, str4, i3, drmInitData, Long.MAX_VALUE, Collections.emptyList());
        }
        return (Format) invokeCommon.objValue;
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i, int i2, String str4, DrmInitData drmInitData, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), str4, drmInitData, Long.valueOf(j)})) == null) {
            return createTextSampleFormat(str, str2, str3, i, i2, str4, -1, drmInitData, j, Collections.emptyList());
        }
        return (Format) invokeCommon.objValue;
    }

    private DrmInitData getFilledManifestDrmData(DrmInitData drmInitData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, drmInitData)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < drmInitData.schemeDataCount; i++) {
                DrmInitData.SchemeData schemeData = drmInitData.get(i);
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
            int i2 = 0;
            while (true) {
                DrmInitData drmInitData2 = this.drmInitData;
                if (i2 >= drmInitData2.schemeDataCount) {
                    break;
                }
                DrmInitData.SchemeData schemeData2 = drmInitData2.get(i2);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (schemeData2.canReplace((DrmInitData.SchemeData) arrayList2.get(i3))) {
                        arrayList.add(schemeData2);
                        break;
                    } else {
                        i3++;
                    }
                }
                i2++;
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new DrmInitData(drmInitData.schemeType, (DrmInitData.SchemeData[]) arrayList.toArray(new DrmInitData.SchemeData[arrayList.size()]));
        }
        return (DrmInitData) invokeL.objValue;
    }

    public Format copyWithDrmInitData(DrmInitData drmInitData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drmInitData)) == null) {
            return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, drmInitData, this.metadata);
        }
        return (Format) invokeL.objValue;
    }

    public Format copyWithMaxInputSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, i, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
        }
        return (Format) invokeI.objValue;
    }

    public Format copyWithMetadata(Metadata metadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, metadata)) == null) {
            return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, metadata);
        }
        return (Format) invokeL.objValue;
    }

    public Format copyWithRotationDegrees(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, i, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
        }
        return (Format) invokeI.objValue;
    }

    public Format copyWithSubsampleOffsetUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, j, this.initializationData, this.drmInitData, this.metadata);
        }
        return (Format) invokeJ.objValue;
    }

    public static void maybeSetByteBufferV16(MediaFormat mediaFormat, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65559, null, mediaFormat, str, bArr) == null) && bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void maybeSetFloatV16(MediaFormat mediaFormat, String str, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{mediaFormat, str, Float.valueOf(f)}) == null) && f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    public static void maybeSetIntegerV16(MediaFormat mediaFormat, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65562, null, mediaFormat, str, i) == null) && i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void maybeSetStringV16(MediaFormat mediaFormat, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65563, null, mediaFormat, str, str2) == null) && str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    public static void maybeSetColorInfoV24(MediaFormat mediaFormat, ColorInfo colorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65560, null, mediaFormat, colorInfo) != null) || colorInfo == null) {
            return;
        }
        maybeSetIntegerV16(mediaFormat, "color-transfer", colorInfo.colorTransfer);
        maybeSetIntegerV16(mediaFormat, "color-standard", colorInfo.colorSpace);
        maybeSetIntegerV16(mediaFormat, "color-range", colorInfo.colorRange);
        maybeSetByteBufferV16(mediaFormat, "hdr-static-info", colorInfo.hdrStaticInfo);
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

    public Format copyWithManifestFormatInfo(Format format) {
        InterceptResult invokeL;
        DrmInitData drmInitData;
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
            int i = this.bitrate;
            if (i == -1) {
                i = format.bitrate;
            }
            int i2 = i;
            float f = this.frameRate;
            if (f == -1.0f) {
                f = format.frameRate;
            }
            float f2 = f;
            int i3 = this.selectionFlags | format.selectionFlags;
            String str4 = this.language;
            if (str4 == null) {
                str4 = format.language;
            }
            String str5 = str4;
            DrmInitData drmInitData2 = format.drmInitData;
            if (drmInitData2 != null) {
                drmInitData = getFilledManifestDrmData(drmInitData2);
            } else {
                drmInitData = this.drmInitData;
            }
            return new Format(str, this.containerMimeType, this.sampleMimeType, str3, i2, this.maxInputSize, this.width, this.height, f2, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i3, str5, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, drmInitData, this.metadata);
        }
        return (Format) invokeL.objValue;
    }

    public Format copyWithContainerInfo(String str, String str2, int i, int i2, int i3, int i4, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str3})) == null) {
            return new Format(str, this.containerMimeType, this.sampleMimeType, str2, i, this.maxInputSize, i2, i3, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i4, str3, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
        }
        return (Format) invokeCommon.objValue;
    }

    public Format copyWithGaplessInfo(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, i, i2, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
        }
        return (Format) invokeII.objValue;
    }

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
            for (int i = 0; i < this.initializationData.size(); i++) {
                mediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap((byte[]) this.initializationData.get(i)));
            }
            maybeSetColorInfoV24(mediaFormat, this.colorInfo);
            return mediaFormat;
        }
        return (MediaFormat) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.hashCode == 0) {
                String str = this.id;
                int i = 0;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                int i2 = (527 + hashCode) * 31;
                String str2 = this.containerMimeType;
                if (str2 == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = str2.hashCode();
                }
                int i3 = (i2 + hashCode2) * 31;
                String str3 = this.sampleMimeType;
                if (str3 == null) {
                    hashCode3 = 0;
                } else {
                    hashCode3 = str3.hashCode();
                }
                int i4 = (i3 + hashCode3) * 31;
                String str4 = this.codecs;
                if (str4 == null) {
                    hashCode4 = 0;
                } else {
                    hashCode4 = str4.hashCode();
                }
                int i5 = (((((((((((i4 + hashCode4) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.channelCount) * 31) + this.sampleRate) * 31;
                String str5 = this.language;
                if (str5 == null) {
                    hashCode5 = 0;
                } else {
                    hashCode5 = str5.hashCode();
                }
                int i6 = (((i5 + hashCode5) * 31) + this.accessibilityChannel) * 31;
                DrmInitData drmInitData = this.drmInitData;
                if (drmInitData == null) {
                    hashCode6 = 0;
                } else {
                    hashCode6 = drmInitData.hashCode();
                }
                int i7 = (i6 + hashCode6) * 31;
                Metadata metadata = this.metadata;
                if (metadata != null) {
                    i = metadata.hashCode();
                }
                this.hashCode = i7 + i;
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
    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, parcel, i) == null) {
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
            if (this.projectionData != null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            byte[] bArr = this.projectionData;
            if (bArr != null) {
                parcel.writeByteArray(bArr);
            }
            parcel.writeInt(this.stereoMode);
            parcel.writeParcelable(this.colorInfo, i);
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
                parcel.writeByteArray((byte[]) this.initializationData.get(i3));
            }
            parcel.writeParcelable(this.drmInitData, 0);
            parcel.writeParcelable(this.metadata, 0);
        }
    }
}
