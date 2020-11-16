package com.google.zxing.datamatrix.encoder;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import org.apache.http.HttpStatus;
/* loaded from: classes15.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, GDiffPatcher.COPY_INT_INT}, new int[]{28, 24, 185, Opcodes.IF_ACMPNE, 223, GDiffPatcher.DATA_INT, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, DownloadConstants.STATUS_WAITING_TO_RETRY, 168, 39, GDiffPatcher.COPY_UBYTE_USHORT, 60, 97, 120}, new int[]{41, Opcodes.IFEQ, Opcodes.IFLE, 91, 61, 42, 142, 213, 97, Opcodes.GETSTATIC, 100, BaseActivity.DIALOG_LOADING}, new int[]{156, 97, 192, GDiffPatcher.COPY_INT_UBYTE, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 100, 39, Opcodes.NEWARRAY, 75, 66, 61, BaseActivity.DIALOG_PROMPT, 213, 109, 129, 94, GDiffPatcher.COPY_INT_INT, 225, 48, 90, Opcodes.NEWARRAY}, new int[]{15, DownloadConstants.STATUS_WAITING_FOR_NETWORK, GDiffPatcher.COPY_UBYTE_UBYTE, 9, 233, 71, 168, 2, Opcodes.NEWARRAY, 160, Opcodes.IFEQ, 145, GDiffPatcher.COPY_INT_USHORT, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, Opcodes.ARETURN, 21, 155, Constants.METHOD_IM_DELIVER_CONFIG_MSG, GDiffPatcher.COPY_USHORT_INT, 223, 155, 21, 5, 172, GDiffPatcher.COPY_INT_INT, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, 12, Opcodes.PUTFIELD, Opcodes.INVOKESTATIC, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, Opcodes.DCMPL, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 53, 75, 34, 249, Constants.METHOD_IM_FRIEND_GROUP_DROP, 17, 138, 110, 213, 141, 136, 120, Opcodes.DCMPL, 233, 168, 93, 255}, new int[]{GDiffPatcher.COPY_UBYTE_USHORT, 127, BaseActivity.DIALOG_LOADING, 218, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 250, 162, Opcodes.PUTFIELD, 102, 120, 84, 179, 220, GDiffPatcher.COPY_USHORT_INT, 80, Opcodes.INVOKEVIRTUAL, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, Opcodes.INVOKESTATIC, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, Opcodes.IFEQ, GDiffPatcher.DATA_USHORT, 105, 122, 2, GDiffPatcher.COPY_UBYTE_USHORT, 133, BaseActivity.DIALOG_LOADING, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, Constants.METHOD_IM_FRIEND_GROUP_DROP, 21, 1, GDiffPatcher.COPY_INT_USHORT, 57, 54, 101, GDiffPatcher.DATA_INT, 202, 69, 50, 150, Opcodes.RETURN, Constants.METHOD_MEDIA_NOTIFY, 5, 9, 5}, new int[]{GDiffPatcher.COPY_UBYTE_USHORT, IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, Opcodes.NEWARRAY, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 205, IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, 88, 120, 100, 66, 138, 186, 240, 82, 44, Opcodes.ARETURN, 87, Opcodes.NEW, 147, 160, 175, 69, 213, 92, GDiffPatcher.COPY_INT_USHORT, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, RtcConstants.METHOD_IM_RTC_MSG, 192, 215, 235, 150, Opcodes.IF_ICMPEQ, 36, 223, 38, 200, IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, HttpStatus.SC_MULTI_STATUS, 164, 13, 137, GDiffPatcher.COPY_UBYTE_USHORT, 127, 67, GDiffPatcher.DATA_USHORT, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{BaseActivity.DIALOG_LOADING, 93, Opcodes.RET, 50, 144, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, 39, 118, 202, Opcodes.NEWARRAY, 201, 189, 143, 108, 196, 37, 185, 112, 134, RtcConstants.METHOD_IM_RTC_MSG, GDiffPatcher.COPY_UBYTE_USHORT, 63, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, Opcodes.NEWARRAY, 17, Opcodes.IF_ICMPGT, 31, Opcodes.ARETURN, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 4, 107, 232, 7, 94, Opcodes.IF_ACMPNE, 224, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, GDiffPatcher.COPY_USHORT_INT, Opcodes.FCMPL, Opcodes.IF_ICMPEQ, 56, 89, 33, 147, GDiffPatcher.COPY_UBYTE_UBYTE, Opcodes.IFNE, 36, 73, 127, 213, 136, GDiffPatcher.DATA_INT, 180, 234, Constants.METHOD_IM_DELIVER_CONFIG_MSG, Opcodes.IFLE, Opcodes.RETURN, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, Opcodes.IFEQ, 185, 202, 167, 179, 25, 220, 232, 96, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, 231, 136, 223, 239, Opcodes.PUTFIELD, BaseActivity.DIALOG_PROMPT, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, Opcodes.IFEQ, IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER, 63, 96, 103, 82, 186}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

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

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
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
            for (int i = 0; i < interleavedBlockCount; i++) {
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i + 1);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i + 1);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
            }
            for (int i2 = 0; i2 < interleavedBlockCount; i2++) {
                StringBuilder sb2 = new StringBuilder(iArr[i2]);
                for (int i3 = i2; i3 < symbolInfo.getDataCapacity(); i3 += interleavedBlockCount) {
                    sb2.append(str.charAt(i3));
                }
                String createECCBlock = createECCBlock(sb2.toString(), iArr2[i2]);
                int i4 = i2;
                int i5 = 0;
                while (i4 < iArr2[i2] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i4, createECCBlock.charAt(i5));
                    i4 += interleavedBlockCount;
                    i5++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            if (i4 >= FACTOR_SETS.length) {
                i4 = -1;
                break;
            } else if (FACTOR_SETS[i4] == i3) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i3);
        }
        int[] iArr = FACTORS[i4];
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = 0;
        }
        for (int i6 = i; i6 < i + i2; i6++) {
            int charAt = charSequence.charAt(i6) ^ cArr[i3 - 1];
            for (int i7 = i3 - 1; i7 > 0; i7--) {
                if (charAt != 0 && iArr[i7] != 0) {
                    cArr[i7] = (char) (cArr[i7 - 1] ^ ALOG[(LOG[charAt] + LOG[iArr[i7]]) % 255]);
                } else {
                    cArr[i7] = cArr[i7 - 1];
                }
            }
            if (charAt != 0 && iArr[0] != 0) {
                cArr[0] = (char) ALOG[(LOG[charAt] + LOG[iArr[0]]) % 255];
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
}
