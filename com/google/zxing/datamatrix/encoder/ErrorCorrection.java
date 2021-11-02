package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.apollon.a;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.utils.ContactPermissionUtil;
import com.facebook.imageutils.JfifUtil;
/* loaded from: classes2.dex */
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
        FACTORS = new int[][]{new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, GDiffPatcher.DATA_INT, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, BaseActivity.DIALOG_LOADING}, new int[]{156, 97, 192, GDiffPatcher.COPY_INT_UBYTE, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 100, 39, Opcodes.NEWARRAY, 75, 66, 61, BaseActivity.DIALOG_PROMPT, 213, 109, 129, 94, 254, 225, 48, 90, Opcodes.NEWARRAY}, new int[]{15, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 244, 9, WriteActivity.CONTENT_MAX_COUNT, 71, 168, 2, Opcodes.NEWARRAY, 160, 153, 145, GDiffPatcher.COPY_INT_USHORT, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, Opcodes.ARETURN, 21, a.f35825e, Constants.METHOD_IM_DELIVER_CONFIG_MSG, GDiffPatcher.COPY_USHORT_INT, 223, a.f35825e, 21, 5, 172, 254, 124, 12, Opcodes.PUTFIELD, Opcodes.INVOKESTATIC, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, Opcodes.DCMPL, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, Opcodes.DCMPL, WriteActivity.CONTENT_MAX_COUNT, 168, 93, 255}, new int[]{245, 127, BaseActivity.DIALOG_LOADING, 218, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 250, 162, Opcodes.PUTFIELD, 102, 120, 84, 179, PassLivenessRecogActivity.S, GDiffPatcher.COPY_USHORT_INT, 80, Opcodes.INVOKEVIRTUAL, 229, 18, 2, 4, 68, 33, 101, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, 95, 119, 115, 44, 175, Opcodes.INVOKESTATIC, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, 31, 19, 38, 22, 153, GDiffPatcher.DATA_USHORT, 105, 122, 2, 245, 133, BaseActivity.DIALOG_LOADING, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, GDiffPatcher.COPY_INT_USHORT, 57, 54, 101, GDiffPatcher.DATA_INT, 202, 69, 50, 150, Opcodes.RETURN, Constants.METHOD_MEDIA_NOTIFY, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, Opcodes.NEWARRAY, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 205, IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, 88, 120, 100, 66, 138, 186, 240, 82, 44, Opcodes.ARETURN, 87, Opcodes.NEW, 147, 160, 175, 69, 213, 92, GDiffPatcher.COPY_INT_USHORT, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, PassLivenessRecogActivity.S, 208, 100, 29, 175, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 230, 192, JfifUtil.MARKER_RST7, 235, 150, Opcodes.IF_ICMPEQ, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, 245, 127, 67, GDiffPatcher.DATA_USHORT, 28, a.f35825e, 43, 203, 107, WriteActivity.CONTENT_MAX_COUNT, 53, 143, 46}, new int[]{BaseActivity.DIALOG_LOADING, 93, Opcodes.RET, 50, 144, 210, 39, 118, 202, Opcodes.NEWARRAY, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, Opcodes.NEWARRAY, 17, 163, 31, Opcodes.ARETURN, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{PassLivenessRecogActivity.S, 228, 173, 89, GDiffPatcher.COPY_USHORT_INT, Opcodes.FCMPL, Opcodes.IF_ICMPEQ, 56, 89, 33, 147, 244, Opcodes.IFNE, 36, 73, 127, 213, 136, GDiffPatcher.DATA_INT, 180, 234, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 158, Opcodes.RETURN, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, PassLivenessRecogActivity.S, 232, 96, 210, 231, 136, 223, 239, Opcodes.PUTFIELD, BaseActivity.DIALOG_PROMPT, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
        LOG = new int[256];
        ALOG = new int[255];
        int i2 = 1;
        for (int i3 = 0; i3 < 255; i3++) {
            ALOG[i3] = i2;
            LOG[i2] = i3;
            i2 <<= 1;
            if (i2 >= 256) {
                i2 ^= 301;
            }
        }
    }

    public ErrorCorrection() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String createECCBlock(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, charSequence, i2)) == null) ? createECCBlock(charSequence, 0, charSequence.length(), i2) : (String) invokeLI.objValue;
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
                    int i2 = 0;
                    while (i2 < interleavedBlockCount) {
                        int i3 = i2 + 1;
                        iArr[i2] = symbolInfo.getDataLengthForInterleavedBlock(i3);
                        iArr2[i2] = symbolInfo.getErrorLengthForInterleavedBlock(i3);
                        iArr3[i2] = 0;
                        if (i2 > 0) {
                            iArr3[i2] = iArr3[i2 - 1] + iArr[i2];
                        }
                        i2 = i3;
                    }
                    for (int i4 = 0; i4 < interleavedBlockCount; i4++) {
                        StringBuilder sb2 = new StringBuilder(iArr[i4]);
                        for (int i5 = i4; i5 < symbolInfo.getDataCapacity(); i5 += interleavedBlockCount) {
                            sb2.append(str.charAt(i5));
                        }
                        String createECCBlock = createECCBlock(sb2.toString(), iArr2[i4]);
                        int i6 = i4;
                        int i7 = 0;
                        while (i6 < iArr2[i4] * interleavedBlockCount) {
                            sb.setCharAt(symbolInfo.getDataCapacity() + i6, createECCBlock.charAt(i7));
                            i6 += interleavedBlockCount;
                            i7++;
                        }
                    }
                }
                return sb.toString();
            }
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        return (String) invokeLL.objValue;
    }

    public static String createECCBlock(CharSequence charSequence, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65539, null, charSequence, i2, i3, i4)) == null) {
            int i5 = 0;
            while (true) {
                int[] iArr = FACTOR_SETS;
                if (i5 >= iArr.length) {
                    i5 = -1;
                    break;
                } else if (iArr[i5] == i4) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 >= 0) {
                int[] iArr2 = FACTORS[i5];
                char[] cArr = new char[i4];
                for (int i6 = 0; i6 < i4; i6++) {
                    cArr[i6] = 0;
                }
                for (int i7 = i2; i7 < i2 + i3; i7++) {
                    int i8 = i4 - 1;
                    int charAt = cArr[i8] ^ charSequence.charAt(i7);
                    while (i8 > 0) {
                        if (charAt != 0 && iArr2[i8] != 0) {
                            char c2 = cArr[i8 - 1];
                            int[] iArr3 = ALOG;
                            int[] iArr4 = LOG;
                            cArr[i8] = (char) (c2 ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i8]]) % 255]);
                        } else {
                            cArr[i8] = cArr[i8 - 1];
                        }
                        i8--;
                    }
                    if (charAt != 0 && iArr2[0] != 0) {
                        int[] iArr5 = ALOG;
                        int[] iArr6 = LOG;
                        cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                    } else {
                        cArr[0] = 0;
                    }
                }
                char[] cArr2 = new char[i4];
                for (int i9 = 0; i9 < i4; i9++) {
                    cArr2[i9] = cArr[(i4 - i9) - 1];
                }
                return String.valueOf(cArr2);
            }
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i4);
        }
        return (String) invokeLIII.objValue;
    }
}
