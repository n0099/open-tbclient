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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new SparseArray<>();
        }
        return (SparseArray) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultTsPayloadReaderFactory(int i) {
        this(i, Collections.emptyList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public DefaultTsPayloadReaderFactory(int i, List<Format> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.flags = i;
        if (!isSet(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.createTextSampleFormat(null, MimeTypes.APPLICATION_CEA608, 0, null));
        }
        this.closedCaptionFormats = list;
    }

    private SeiReader buildSeiReader(TsPayloadReader.EsInfo esInfo) {
        InterceptResult invokeL;
        boolean z;
        String str;
        int i;
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
                    for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                        String readString = parsableByteArray.readString(3);
                        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                        if ((readUnsignedByte3 & 128) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            i = readUnsignedByte3 & 63;
                            str = MimeTypes.APPLICATION_CEA708;
                        } else {
                            str = MimeTypes.APPLICATION_CEA608;
                            i = 1;
                        }
                        list.add(Format.createTextSampleFormat((String) null, str, (String) null, -1, 0, readString, i, (DrmInitData) null));
                        parsableByteArray.skipBytes(2);
                    }
                }
                parsableByteArray.setPosition(position);
            }
            return new SeiReader(list);
        }
        return (SeiReader) invokeL.objValue;
    }

    private boolean isSet(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            if ((i & this.flags) != 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public TsPayloadReader createPayloadReader(int i, TsPayloadReader.EsInfo esInfo) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, esInfo)) == null) {
            if (i != 2) {
                if (i != 3 && i != 4) {
                    if (i != 15) {
                        if (i != 17) {
                            if (i != 21) {
                                if (i != 27) {
                                    if (i != 36) {
                                        if (i != 89) {
                                            if (i != 138) {
                                                if (i != 129) {
                                                    if (i != 130) {
                                                        if (i != 134) {
                                                            if (i != 135) {
                                                                return null;
                                                            }
                                                        } else if (isSet(16)) {
                                                            return null;
                                                        } else {
                                                            return new SectionReader(new SpliceInfoSectionReader());
                                                        }
                                                    }
                                                }
                                                return new PesReader(new Ac3Reader(esInfo.language));
                                            }
                                            return new PesReader(new DtsReader(esInfo.language));
                                        }
                                        return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos));
                                    }
                                    return new PesReader(new H265Reader(buildSeiReader(esInfo)));
                                } else if (isSet(4)) {
                                    return null;
                                } else {
                                    return new PesReader(new H264Reader(buildSeiReader(esInfo), isSet(1), isSet(8)));
                                }
                            }
                            return new PesReader(new Id3Reader());
                        } else if (isSet(2)) {
                            return null;
                        } else {
                            return new PesReader(new LatmReader(esInfo.language));
                        }
                    } else if (isSet(2)) {
                        return null;
                    } else {
                        return new PesReader(new AdtsReader(false, esInfo.language));
                    }
                }
                return new PesReader(new MpegAudioReader(esInfo.language));
            }
            return new PesReader(new H262Reader());
        }
        return (TsPayloadReader) invokeIL.objValue;
    }
}
