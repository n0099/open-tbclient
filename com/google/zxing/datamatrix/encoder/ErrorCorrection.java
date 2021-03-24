package com.google.zxing.datamatrix.encoder;

import androidx.fragment.app.FragmentManagerImpl;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.wallet.utils.ContactPermissionUtil;
import com.facebook.imageutils.JfifUtil;
/* loaded from: classes6.dex */
public final class ErrorCorrection {
    public static final int MODULO_VALUE = 301;
    public static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    public static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, GDiffPatcher.DATA_INT, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, BaseActivity.DIALOG_LOADING}, new int[]{156, 97, 192, GDiffPatcher.COPY_INT_UBYTE, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 100, 39, Opcodes.NEWARRAY, 75, 66, 61, BaseActivity.DIALOG_PROMPT, 213, 109, 129, 94, 254, 225, 48, 90, Opcodes.NEWARRAY}, new int[]{15, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 244, 9, WriteActivity.CONTENT_MAX_COUNT, 71, 168, 2, Opcodes.NEWARRAY, 160, 153, 145, GDiffPatcher.COPY_INT_USHORT, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, Opcodes.ARETURN, 21, 155, Constants.METHOD_IM_DELIVER_CONFIG_MSG, GDiffPatcher.COPY_USHORT_INT, 223, 155, 21, 5, 172, 254, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, 12, Opcodes.PUTFIELD, Opcodes.INVOKESTATIC, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, Opcodes.DCMPL, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 53, 75, 34, 249, Constants.METHOD_IM_FRIEND_GROUP_DROP, 17, 138, 110, 213, 141, 136, 120, Opcodes.DCMPL, WriteActivity.CONTENT_MAX_COUNT, 168, 93, 255}, new int[]{245, 127, BaseActivity.DIALOG_LOADING, 218, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 250, 162, Opcodes.PUTFIELD, 102, 120, 84, 179, FragmentManagerImpl.ANIM_DUR, GDiffPatcher.COPY_USHORT_INT, 80, Opcodes.INVOKEVIRTUAL, 229, 18, 2, 4, 68, 33, 101, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, 95, 119, 115, 44, 175, Opcodes.INVOKESTATIC, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, 31, 19, 38, 22, 153, GDiffPatcher.DATA_USHORT, 105, 122, 2, 245, 133, BaseActivity.DIALOG_LOADING, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, Constants.METHOD_IM_FRIEND_GROUP_DROP, 21, 1, GDiffPatcher.COPY_INT_USHORT, 57, 54, 101, GDiffPatcher.DATA_INT, 202, 69, 50, 150, Opcodes.RETURN, Constants.METHOD_MEDIA_NOTIFY, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, Opcodes.NEWARRAY, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 205, IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, 88, 120, 100, 66, 138, 186, 240, 82, 44, Opcodes.ARETURN, 87, Opcodes.NEW, 147, 160, 175, 69, 213, 92, GDiffPatcher.COPY_INT_USHORT, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, FragmentManagerImpl.ANIM_DUR, 208, 100, 29, 175, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, RtcConstants.METHOD_IM_RTC_MSG, 192, JfifUtil.MARKER_RST7, 235, 150, Opcodes.IF_ICMPEQ, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, IChannelPay.ID_IPAY_PAY_GAME, 13, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, 245, 127, 67, GDiffPatcher.DATA_USHORT, 28, 155, 43, 203, 107, WriteActivity.CONTENT_MAX_COUNT, 53, 143, 46}, new int[]{BaseActivity.DIALOG_LOADING, 93, Opcodes.RET, 50, 144, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, 39, 118, 202, Opcodes.NEWARRAY, 201, 189, 143, 108, 196, 37, 185, 112, 134, RtcConstants.METHOD_IM_RTC_MSG, 245, 63, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, Opcodes.NEWARRAY, 17, 163, 31, Opcodes.ARETURN, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 4, 107, 232, 7, 94, 166, 224, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, 86, 47, 11, 204}, new int[]{FragmentManagerImpl.ANIM_DUR, 228, 173, 89, GDiffPatcher.COPY_USHORT_INT, Opcodes.FCMPL, Opcodes.IF_ICMPEQ, 56, 89, 33, 147, 244, Opcodes.IFNE, 36, 73, 127, 213, 136, GDiffPatcher.DATA_INT, 180, 234, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 158, Opcodes.RETURN, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, FragmentManagerImpl.ANIM_DUR, 232, 96, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, 231, 136, 223, 239, Opcodes.PUTFIELD, BaseActivity.DIALOG_PROMPT, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
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

    public static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
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
                        char c2 = cArr[i7 - 1];
                        int[] iArr3 = ALOG;
                        int[] iArr4 = LOG;
                        cArr[i7] = (char) (c2 ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i7]]) % 255]);
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
}
