package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes5.dex */
public final class ErrorCorrection {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] ALOG;
    public static final int[][] FACTORS;
    public static final int[] FACTOR_SETS;
    public static final int[] LOG;
    public static final int MODULO_VALUE = 301;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1814380517, "Lcom/google/zxing/datamatrix/encoder/ErrorCorrection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1814380517, "Lcom/google/zxing/datamatrix/encoder/ErrorCorrection;");
                return;
            }
        }
        FACTOR_SETS = new int[]{5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
        FACTORS = new int[][]{new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, Cea708Decoder.COMMAND_SPA, 134, 240, 92, 254}, new int[]{28, 24, Constants.METHOD_IM_SEND_MCAST_MSG, 166, 223, 248, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, w0.d0, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, Cea708Decoder.COMMAND_DLC, 213, 97, 178, 100, w0.i0}, new int[]{Cea708Decoder.COMMAND_DS4, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, Constants.METHOD_IM_SEND_MCAST_MSG}, new int[]{83, 195, 100, 39, TsExtractor.TS_PACKET_SIZE, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, TsExtractor.TS_PACKET_SIZE}, new int[]{15, 195, GDiffPatcher.COPY_UBYTE_UBYTE, 9, WriteActivity.CONTENT_MAX_COUNT, 71, w0.d0, 2, TsExtractor.TS_PACKET_SIZE, 160, 153, 145, GDiffPatcher.COPY_INT_USHORT, 79, 108, 82, 27, MatroskaExtractor.ID_TRACK_ENTRY, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, MatroskaExtractor.ID_PIXEL_WIDTH, 21, 155, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, H262Reader.START_GROUP, 96, 50, 193}, new int[]{w0.A, 231, 43, 97, 71, 96, 103, MatroskaExtractor.ID_TRACK_ENTRY, 37, Cea708Decoder.COMMAND_SWA, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 53, 75, 34, 249, 121, 17, 138, 110, 213, Cea708Decoder.COMMAND_DLY, 136, 120, Cea708Decoder.COMMAND_SWA, WriteActivity.CONTENT_MAX_COUNT, w0.d0, 93, 255}, new int[]{245, 127, w0.i0, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, Cea708Decoder.COMMAND_DSW, 95, 119, 115, 44, 175, H262Reader.START_GROUP, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, Cea708Decoder.COMMAND_DSW, 31, 19, 38, 22, 153, GDiffPatcher.DATA_USHORT, 105, 122, 2, 245, 133, w0.i0, 8, 175, 95, 100, 9, 167, 105, w0.c0, 111, 57, 121, 21, 1, GDiffPatcher.COPY_INT_USHORT, 57, 54, 101, 248, 202, 69, 50, 150, w0.u, Constants.METHOD_MEDIA_NOTIFY, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, TsExtractor.TS_PACKET_SIZE, 237, 87, w0.M, 106, 16, 147, 118, 23, 37, 90, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, MatroskaExtractor.ID_PIXEL_WIDTH, 87, MatroskaExtractor.ID_CUE_POINT, 147, 160, 175, 69, 213, 92, GDiffPatcher.COPY_INT_USHORT, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 230, 192, 215, w0.k0, 150, 159, 36, 223, 38, 200, 132, 54, 228, Cea708Decoder.COMMAND_SPL, 218, 234, 117, 203, 29, w0.c1, Cea708Decoder.COMMAND_SPA, 238, 22, 150, 201, 117, 62, 207, 164, 13, Cea708Decoder.COMMAND_DSW, 245, 127, 67, GDiffPatcher.DATA_USHORT, 28, 155, 43, 203, 107, WriteActivity.CONTENT_MAX_COUNT, 53, 143, 46}, new int[]{w0.i0, 93, w0.w, 50, Cea708Decoder.COMMAND_SPA, 210, 39, 118, 202, TsExtractor.TS_PACKET_SIZE, 201, PsExtractor.PRIVATE_STREAM_1, 143, 108, 196, 37, Constants.METHOD_IM_SEND_MCAST_MSG, 112, 134, 230, 245, 63, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 190, 250, 106, Constants.METHOD_IM_SEND_MCAST_MSG, w0.h0, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, TsExtractor.TS_PACKET_SIZE, 17, MatroskaExtractor.ID_SIMPLE_BLOCK, 31, MatroskaExtractor.ID_PIXEL_WIDTH, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 4, 107, w0.c1, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, w0.i, 89, 251, 149, 159, 56, 89, 33, 147, GDiffPatcher.COPY_UBYTE_UBYTE, Cea708Decoder.COMMAND_DF2, 36, 73, 127, 213, 136, 248, 180, 234, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 158, w0.u, 68, 122, 93, 213, 15, 160, w0.z, 236, 66, 139, 153, Constants.METHOD_IM_SEND_MCAST_MSG, 202, 167, 179, 25, 220, w0.c1, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, w0.c1, w0.A, PsExtractor.PRIVATE_STREAM_1, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
        LOG = new int[256];
        ALOG = new int[255];
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    public ErrorCorrection() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String createECCBlock(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, charSequence, i)) == null) ? createECCBlock(charSequence, 0, charSequence.length(), i) : (String) invokeLI.objValue;
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, symbolInfo)) == null) {
            if (str.length() == symbolInfo.getDataCapacity()) {
                StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
                sb.append(str);
                int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
                if (interleavedBlockCount == 1) {
                    sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
                } else {
                    sb.setLength(sb.capacity());
                    int[] iArr = new int[interleavedBlockCount];
                    int[] iArr2 = new int[interleavedBlockCount];
                    int[] iArr3 = new int[interleavedBlockCount];
                    int i = 0;
                    while (i < interleavedBlockCount) {
                        int i2 = i + 1;
                        iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                        iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                        iArr3[i] = 0;
                        if (i > 0) {
                            iArr3[i] = iArr3[i - 1] + iArr[i];
                        }
                        i = i2;
                    }
                    for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                        StringBuilder sb2 = new StringBuilder(iArr[i3]);
                        for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                            sb2.append(str.charAt(i4));
                        }
                        String createECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                        int i5 = i3;
                        int i6 = 0;
                        while (i5 < iArr2[i3] * interleavedBlockCount) {
                            sb.setCharAt(symbolInfo.getDataCapacity() + i5, createECCBlock.charAt(i6));
                            i5 += interleavedBlockCount;
                            i6++;
                        }
                    }
                }
                return sb.toString();
            }
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        return (String) invokeLL.objValue;
    }

    public static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65539, null, charSequence, i, i2, i3)) == null) {
            int i4 = 0;
            while (true) {
                int[] iArr = FACTOR_SETS;
                if (i4 >= iArr.length) {
                    i4 = -1;
                    break;
                } else if (iArr[i4] == i3) {
                    break;
                } else {
                    i4++;
                }
            }
            if (i4 >= 0) {
                int[] iArr2 = FACTORS[i4];
                char[] cArr = new char[i3];
                for (int i5 = 0; i5 < i3; i5++) {
                    cArr[i5] = 0;
                }
                for (int i6 = i; i6 < i + i2; i6++) {
                    int i7 = i3 - 1;
                    int charAt = cArr[i7] ^ charSequence.charAt(i6);
                    while (i7 > 0) {
                        if (charAt != 0 && iArr2[i7] != 0) {
                            char c = cArr[i7 - 1];
                            int[] iArr3 = ALOG;
                            int[] iArr4 = LOG;
                            cArr[i7] = (char) (c ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i7]]) % 255]);
                        } else {
                            cArr[i7] = cArr[i7 - 1];
                        }
                        i7--;
                    }
                    if (charAt != 0 && iArr2[0] != 0) {
                        int[] iArr5 = ALOG;
                        int[] iArr6 = LOG;
                        cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                    } else {
                        cArr[0] = 0;
                    }
                }
                char[] cArr2 = new char[i3];
                for (int i8 = 0; i8 < i3; i8++) {
                    cArr2[i8] = cArr[(i3 - i8) - 1];
                }
                return String.valueOf(cArr2);
            }
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i3);
        }
        return (String) invokeLIII.objValue;
    }
}
