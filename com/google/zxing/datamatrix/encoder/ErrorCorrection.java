package com.google.zxing.datamatrix.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.location.BDLocation;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.qq.e.comm.adevent.AdEventType;
/* loaded from: classes9.dex */
public final class ErrorCorrection {
    public static final int MODULO_VALUE = 301;
    public static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    public static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, Cea708Decoder.COMMAND_SPA, 134, 240, 92, 254}, new int[]{28, 24, Constants.METHOD_IM_SEND_MCAST_MSG, TTAdConstant.IMAGE_MODE_LIVE, 223, GDiffPatcher.DATA_INT, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, GDiffPatcher.COPY_UBYTE_USHORT, 60, 97, 120}, new int[]{41, 153, Cea708Decoder.COMMAND_DF6, 91, 61, 42, Cea708Decoder.COMMAND_DLC, 213, 97, 178, 100, 242}, new int[]{Cea708Decoder.COMMAND_DS4, 97, 192, GDiffPatcher.COPY_INT_UBYTE, 95, 9, Cea708Decoder.COMMAND_DF5, 119, 138, 45, 18, MatroskaExtractor.ID_PIXEL_HEIGHT, 83, Constants.METHOD_IM_SEND_MCAST_MSG}, new int[]{83, 195, 100, 39, TsExtractor.TS_PACKET_SIZE, 75, 66, 61, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, 213, 109, 129, 94, 254, 225, 48, 90, TsExtractor.TS_PACKET_SIZE}, new int[]{15, 195, GDiffPatcher.COPY_UBYTE_UBYTE, 9, 233, 71, 168, 2, TsExtractor.TS_PACKET_SIZE, 160, 153, 145, GDiffPatcher.COPY_INT_USHORT, 79, 108, 82, 27, MatroskaExtractor.ID_TRACK_ENTRY, MatroskaExtractor.ID_PIXEL_HEIGHT, 172}, new int[]{52, 190, 88, 205, 109, 39, MatroskaExtractor.ID_PIXEL_WIDTH, 21, 155, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, H262Reader.START_GROUP, 96, 50, 193}, new int[]{AdEventType.VIDEO_LOADING, 231, 43, 97, 71, 96, 103, MatroskaExtractor.ID_TRACK_ENTRY, 37, Cea708Decoder.COMMAND_SWA, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, Cea708Decoder.COMMAND_SWA, 233, 168, 93, 255}, new int[]{GDiffPatcher.COPY_UBYTE_USHORT, 127, 242, 218, 130, 250, BDLocation.TypeServerDecryptError, 181, 102, 120, 84, 179, PassFaceRecogManager.j, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, Cea708Decoder.COMMAND_DSW, 95, 119, 115, 44, 175, H262Reader.START_GROUP, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, Cea708Decoder.COMMAND_DSW, 31, 19, 38, 22, 153, GDiffPatcher.DATA_USHORT, 105, 122, 2, GDiffPatcher.COPY_UBYTE_USHORT, 133, 242, 8, 175, 95, 100, 9, 167, 105, Constants.METHOD_IM_EMOJI, 111, 57, 121, 21, 1, GDiffPatcher.COPY_INT_USHORT, 57, 54, 101, GDiffPatcher.DATA_INT, 202, 69, 50, 150, 177, Constants.METHOD_MEDIA_NOTIFY, 5, 9, 5}, new int[]{GDiffPatcher.COPY_UBYTE_USHORT, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, TsExtractor.TS_PACKET_SIZE, Constants.METHOD_IM_CONSULT_IM_UPDATE_MSG, 87, 191, 106, 16, 147, 118, 23, 37, 90, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 205, 131, 88, 120, 100, 66, 138, MatroskaExtractor.ID_PIXEL_HEIGHT, 240, 82, 44, MatroskaExtractor.ID_PIXEL_WIDTH, 87, 187, 147, 160, 175, 69, 213, 92, GDiffPatcher.COPY_INT_USHORT, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, PassFaceRecogManager.j, 208, 100, 29, 175, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, Cea708Decoder.COMMAND_SPL, 218, 234, 117, 203, 29, 232, Cea708Decoder.COMMAND_SPA, 238, 22, 150, 201, 117, 62, 207, 164, 13, Cea708Decoder.COMMAND_DSW, GDiffPatcher.COPY_UBYTE_USHORT, 127, 67, GDiffPatcher.DATA_USHORT, 28, 155, 43, 203, 107, 233, 53, Cea708Decoder.COMMAND_RST, 46}, new int[]{242, 93, 169, 50, Cea708Decoder.COMMAND_SPA, 210, 39, 118, 202, TsExtractor.TS_PACKET_SIZE, 201, PsExtractor.PRIVATE_STREAM_1, Cea708Decoder.COMMAND_RST, 108, 196, 37, Constants.METHOD_IM_SEND_MCAST_MSG, 112, 134, 230, GDiffPatcher.COPY_UBYTE_USHORT, 63, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 190, 250, 106, Constants.METHOD_IM_SEND_MCAST_MSG, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, TsExtractor.TS_PACKET_SIZE, 17, MatroskaExtractor.ID_SIMPLE_BLOCK, 31, MatroskaExtractor.ID_PIXEL_WIDTH, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 4, 107, 232, 7, 94, TTAdConstant.IMAGE_MODE_LIVE, 224, 124, 86, 47, 11, 204}, new int[]{PassFaceRecogManager.j, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, GDiffPatcher.COPY_UBYTE_UBYTE, Cea708Decoder.COMMAND_DF2, 36, 73, 127, 213, 136, GDiffPatcher.DATA_INT, 180, 234, Constants.METHOD_IM_DELIVER_CONFIG_MSG, Cea708Decoder.COMMAND_DF6, 177, 68, 122, 93, 213, 15, 160, 227, Constants.METHOD_IM_CONSULT_NOTIFY_MSG, 66, Cea708Decoder.COMMAND_TGW, 153, Constants.METHOD_IM_SEND_MCAST_MSG, 202, 167, 179, 25, PassFaceRecogManager.j, 232, 96, 210, 231, 136, 223, Constants.METHOD_IM_CONSULT_IM_FILTER_SESSION_MSG, 181, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, 59, 52, 172, 25, 49, 232, AdEventType.VIDEO_LOADING, PsExtractor.PRIVATE_STREAM_1, 64, 54, 108, 153, 132, 63, 96, 103, 82, MatroskaExtractor.ID_PIXEL_HEIGHT}};
    public static final int[] LOG = new int[256];
    public static final int[] ALOG = new int[255];

    static {
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

    public static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    public static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i4 < iArr.length) {
                if (iArr[i4] == i3) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
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

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
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
}
