package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DESCRIPTOR_TAG_CAPTION_SERVICE = 134;
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Format> closedCaptionFormats;
    public final int flags;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface Flags {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultTsPayloadReaderFactory() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private SeiReader buildSeiReader(TsPayloadReader.EsInfo esInfo) {
        InterceptResult invokeL;
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, esInfo)) == null) {
            if (isSet(32)) {
                return new SeiReader(this.closedCaptionFormats);
            }
            ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.descriptorBytes);
            List<Format> list = this.closedCaptionFormats;
            while (parsableByteArray.bytesLeft() > 0) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
                if (readUnsignedByte == 134) {
                    list = new ArrayList<>();
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                    for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                        String readString = parsableByteArray.readString(3);
                        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                        if ((readUnsignedByte3 & 128) != 0) {
                            i2 = readUnsignedByte3 & 63;
                            str = MimeTypes.APPLICATION_CEA708;
                        } else {
                            str = MimeTypes.APPLICATION_CEA608;
                            i2 = 1;
                        }
                        list.add(Format.createTextSampleFormat((String) null, str, (String) null, -1, 0, readString, i2, (DrmInitData) null));
                        parsableByteArray.skipBytes(2);
                    }
                }
                parsableByteArray.setPosition(position);
            }
            return new SeiReader(list);
        }
        return (SeiReader) invokeL.objValue;
    }

    private boolean isSet(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) ? (i2 & this.flags) != 0 : invokeI.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new SparseArray<>() : (SparseArray) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public TsPayloadReader createPayloadReader(int i2, TsPayloadReader.EsInfo esInfo) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, esInfo)) == null) {
            if (i2 != 2) {
                if (i2 == 3 || i2 == 4) {
                    return new PesReader(new MpegAudioReader(esInfo.language));
                }
                if (i2 == 15) {
                    if (isSet(2)) {
                        return null;
                    }
                    return new PesReader(new AdtsReader(false, esInfo.language));
                } else if (i2 == 17) {
                    if (isSet(2)) {
                        return null;
                    }
                    return new PesReader(new LatmReader(esInfo.language));
                } else if (i2 != 21) {
                    if (i2 == 27) {
                        if (isSet(4)) {
                            return null;
                        }
                        return new PesReader(new H264Reader(buildSeiReader(esInfo), isSet(1), isSet(8)));
                    } else if (i2 != 36) {
                        if (i2 != 89) {
                            if (i2 != 138) {
                                if (i2 != 129) {
                                    if (i2 != 130) {
                                        if (i2 == 134) {
                                            if (isSet(16)) {
                                                return null;
                                            }
                                            return new SectionReader(new SpliceInfoSectionReader());
                                        } else if (i2 != 135) {
                                            return null;
                                        }
                                    }
                                }
                                return new PesReader(new Ac3Reader(esInfo.language));
                            }
                            return new PesReader(new DtsReader(esInfo.language));
                        }
                        return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos));
                    } else {
                        return new PesReader(new H265Reader(buildSeiReader(esInfo)));
                    }
                } else {
                    return new PesReader(new Id3Reader());
                }
            }
            return new PesReader(new H262Reader());
        }
        return (TsPayloadReader) invokeIL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultTsPayloadReaderFactory(int i2) {
        this(i2, Collections.emptyList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public DefaultTsPayloadReaderFactory(int i2, List<Format> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.flags = i2;
        if (!isSet(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.createTextSampleFormat(null, MimeTypes.APPLICATION_CEA608, 0, null));
        }
        this.closedCaptionFormats = list;
    }
}
