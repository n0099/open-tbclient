package org.apache.commons.codec.digest4util;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.f;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import java.util.Random;
import org.apache.commons.base.Charsets;
/* loaded from: classes7.dex */
public class UnixCrypt {
    public static final int[] CON_SALT = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 0, 0, 0, 0, 0};
    public static final int[] COV2CHAR = {46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    public static final char[] SALT_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789./".toCharArray();
    public static final boolean[] SHIFT2 = {false, false, true, true, true, true, true, true, false, true, true, true, true, true, true, false};
    public static final int[][] SKB = {new int[]{0, 16, 536870912, 536870928, 65536, 65552, 536936448, 536936464, 2048, 2064, 536872960, 536872976, 67584, 67600, 536938496, 536938512, 32, 48, 536870944, 536870960, 65568, 65584, 536936480, 536936496, 2080, 2096, 536872992, 536873008, 67616, 67632, 536938528, 536938544, 524288, 524304, 537395200, 537395216, 589824, 589840, 537460736, 537460752, 526336, 526352, 537397248, 537397264, 591872, 591888, 537462784, 537462800, 524320, 524336, 537395232, 537395248, 589856, 589872, 537460768, 537460784, 526368, 526384, 537397280, 537397296, 591904, 591920, 537462816, 537462832}, new int[]{0, NTLMEngineImpl.FLAG_REQUEST_VERSION, 8192, 33562624, 2097152, 35651584, 2105344, 35659776, 4, 33554436, ZeusMonitorType.MONITOR_TYPE_FEED_PAGE_SCROLL, 33562628, 2097156, 35651588, 2105348, 35659780, 1024, 33555456, 9216, 33563648, 2098176, 35652608, 2106368, 35660800, SDKLogTypeConstants.EXPTYPE_LITEINC_INSTALL, 33555460, 9220, 33563652, 2098180, 35652612, 2106372, 35660804, Label.FORWARD_REFERENCE_TYPE_SHORT, 301989888, 268443648, 301998080, 270532608, 304087040, 270540800, 304095232, RouterCallback.CODE_ROUTER_NOT_REGISTER, 301989892, 268443652, 301998084, 270532612, 304087044, 270540804, 304095236, 268436480, 301990912, 268444672, 301999104, 270533632, 304088064, 270541824, 304096256, 268436484, 301990916, 268444676, 301999108, 270533636, 304088068, 270541828, 304096260}, new int[]{0, 1, 262144, 262145, 16777216, 16777217, 17039360, 17039361, 2, 3, 262146, 262147, 16777218, 16777219, 17039362, 17039363, 512, 513, 262656, 262657, 16777728, 16777729, 17039872, 17039873, 514, 515, 262658, 262659, 16777730, 16777731, 17039874, 17039875, 134217728, 134217729, 134479872, 134479873, 150994944, 150994945, 151257088, 151257089, 134217730, 134217731, 134479874, 134479875, 150994946, 150994947, 151257090, 151257091, 134218240, 134218241, 134480384, 134480385, 150995456, 150995457, 151257600, 151257601, 134218242, 134218243, 134480386, 134480387, 150995458, 150995459, 151257602, 151257603}, new int[]{0, 1048576, 256, 1048832, 8, InputDeviceCompat.SOURCE_TOUCHPAD, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, 1048840, 4096, 1052672, 4352, 1052928, 4104, 1052680, 4360, 1052936, CodedInputStream.DEFAULT_SIZE_LIMIT, 68157440, 67109120, 68157696, 67108872, 68157448, 67109128, 68157704, 67112960, 68161536, 67113216, 68161792, 67112968, 68161544, 67113224, 68161800, 131072, 1179648, 131328, 1179904, 131080, 1179656, 131336, 1179912, 135168, 1183744, 135424, 1184000, 135176, 1183752, 135432, 1184008, 67239936, 68288512, 67240192, 68288768, 67239944, 68288520, 67240200, 68288776, 67244032, 68292608, 67244288, 68292864, 67244040, 68292616, 67244296, 68292872}, new int[]{0, Label.FORWARD_REFERENCE_TYPE_SHORT, 65536, 268500992, 4, RouterCallback.CODE_ROUTER_NOT_REGISTER, InputDeviceCompat.SOURCE_TRACKBALL, 268500996, 536870912, 805306368, 536936448, 805371904, 536870916, 805306372, 536936452, 805371908, 1048576, 269484032, 1114112, 269549568, 1048580, 269484036, 1114116, 269549572, 537919488, 806354944, 537985024, 806420480, 537919492, 806354948, 537985028, 806420484, 4096, 268439552, 69632, 268505088, 4100, 268439556, 69636, 268505092, 536875008, 805310464, 536940544, 805376000, 536875012, 805310468, 536940548, 805376004, 1052672, 269488128, 1118208, 269553664, 1052676, 269488132, 1118212, 269553668, 537923584, 806359040, 537989120, 806424576, 537923588, 806359044, 537989124, 806424580}, new int[]{0, 134217728, 8, 134217736, 1024, 134218752, f.f3702a, 134218760, 131072, 134348800, 131080, 134348808, 132096, 134349824, 132104, 134349832, 1, 134217729, 9, 134217737, 1025, 134218753, 1033, 134218761, 131073, 134348801, 131081, 134348809, 132097, 134349825, 132105, 134349833, NTLMEngineImpl.FLAG_REQUEST_VERSION, 167772160, 33554440, 167772168, 33555456, 167773184, 33555464, 167773192, 33685504, 167903232, 33685512, 167903240, 33686528, 167904256, 33686536, 167904264, InputDeviceCompat.SOURCE_HDMI, 167772161, 33554441, 167772169, 33555457, 167773185, 33555465, 167773193, 33685505, 167903233, 33685513, 167903241, 33686529, 167904257, 33686537, 167904265}, new int[]{0, 256, 524288, 524544, 16777216, 16777472, 17301504, 17301760, 16, AuthorityState.STATE_INIT_ING, 524304, 524560, InputDeviceCompat.SOURCE_JOYSTICK, 16777488, 17301520, 17301776, 2097152, 2097408, 2621440, 2621696, 18874368, 18874624, 19398656, 19398912, 2097168, 2097424, 2621456, 2621712, 18874384, 18874640, 19398672, 19398928, 512, 768, 524800, 525056, 16777728, 16777984, 17302016, 17302272, 528, 784, 524816, 525072, 16777744, 16778000, 17302032, 17302288, 2097664, 2097920, 2621952, 2622208, 18874880, 18875136, 19399168, 19399424, 2097680, 2097936, 2621968, 2622224, 18874896, 18875152, 19399184, 19399440}, new int[]{0, CodedInputStream.DEFAULT_SIZE_LIMIT, 262144, 67371008, 2, 67108866, 262146, 67371010, 8192, 67117056, 270336, 67379200, 8194, 67117058, 270338, 67379202, 32, 67108896, 262176, 67371040, 34, 67108898, 262178, 67371042, 8224, 67117088, 270368, 67379232, 8226, 67117090, 270370, 67379234, 2048, 67110912, 264192, 67373056, 2050, 67110914, 264194, 67373058, 10240, 67119104, 272384, 67381248, 10242, 67119106, 272386, 67381250, 2080, 67110944, 264224, 67373088, 2082, 67110946, 264226, 67373090, 10272, 67119136, 272416, 67381280, 10274, 67119138, 272418, 67381282}};
    public static final int[][] SPTRANS = {new int[]{8520192, 131072, -2139095040, -2138963456, 8388608, -2147352064, -2147352576, -2139095040, -2147352064, 8520192, 8519680, -2147483136, -2139094528, 8388608, 0, -2147352576, 131072, Integer.MIN_VALUE, 8389120, 131584, -2138963456, 8519680, -2147483136, 8389120, Integer.MIN_VALUE, 512, 131584, -2138963968, 512, -2139094528, -2138963968, 0, 0, -2138963456, 8389120, -2147352576, 8520192, 131072, -2147483136, 8389120, -2138963968, 512, 131584, -2139095040, -2147352064, Integer.MIN_VALUE, -2139095040, 8519680, -2138963456, 131584, 8519680, -2139094528, 8388608, -2147483136, -2147352576, 0, 131072, 8388608, -2139094528, 8520192, Integer.MIN_VALUE, -2138963968, 512, -2147352064}, new int[]{268705796, 0, 270336, 268697600, RouterCallback.CODE_ROUTER_NOT_REGISTER, ZeusMonitorType.MONITOR_TYPE_FEED_PAGE_SCROLL, 268443648, 270336, 8192, 268697604, 4, 268443648, 262148, 268705792, 268697600, 4, 262144, 268443652, 268697604, 8192, 270340, Label.FORWARD_REFERENCE_TYPE_SHORT, 0, 262148, 268443652, 270340, 268705792, RouterCallback.CODE_ROUTER_NOT_REGISTER, Label.FORWARD_REFERENCE_TYPE_SHORT, 262144, ZeusMonitorType.MONITOR_TYPE_FEED_PAGE_SCROLL, 268705796, 262148, 268705792, 268443648, 270340, 268705796, 262148, RouterCallback.CODE_ROUTER_NOT_REGISTER, 0, Label.FORWARD_REFERENCE_TYPE_SHORT, ZeusMonitorType.MONITOR_TYPE_FEED_PAGE_SCROLL, 262144, 268697604, 8192, Label.FORWARD_REFERENCE_TYPE_SHORT, 270340, 268443652, 268705792, 8192, 0, RouterCallback.CODE_ROUTER_NOT_REGISTER, 4, 268705796, 270336, 268697600, 268697604, 262144, ZeusMonitorType.MONITOR_TYPE_FEED_PAGE_SCROLL, 268443648, 268443652, 4, 268697600, 270336}, new int[]{1090519040, 16842816, 64, 1090519104, 1073807360, 16777216, 1090519104, 65600, 16777280, 65536, 16842752, 1073741824, 1090584640, 1073741888, 1073741824, 1090584576, 0, 1073807360, 16842816, 64, 1073741888, 1090584640, 65536, 1090519040, 1090584576, 16777280, 1073807424, 16842752, 65600, 0, 16777216, 1073807424, 16842816, 64, 1073741824, 65536, 1073741888, 1073807360, 16842752, 1090519104, 0, 16842816, 65600, 1090584576, 1073807360, 16777216, 1090584640, 1073741824, 1073807424, 1090519040, 16777216, 1090584640, 65536, 16777280, 1090519104, 65600, 16777280, 0, 1090584576, 1073741888, 1090519040, 1073807424, 64, 16842752}, new int[]{1049602, 67109888, 2, 68158466, 0, 68157440, 67109890, Constants.METHOD_SEND_USER_MSG, 68158464, 67108866, CodedInputStream.DEFAULT_SIZE_LIMIT, SDKLogTypeConstants.EXPTYPE_LITEINC_CP, 67108866, 1049602, 1048576, CodedInputStream.DEFAULT_SIZE_LIMIT, 68157442, 1049600, 1024, 2, 1049600, 67109890, 68157440, 1024, SDKLogTypeConstants.EXPTYPE_LITEINC_CP, 0, Constants.METHOD_SEND_USER_MSG, 68158464, 67109888, 68157442, 68158466, 1048576, 68157442, SDKLogTypeConstants.EXPTYPE_LITEINC_CP, 1048576, 67108866, 1049600, 67109888, 2, 68157440, 67109890, 0, 1024, Constants.METHOD_SEND_USER_MSG, 0, 68157442, 68158464, 1024, CodedInputStream.DEFAULT_SIZE_LIMIT, 68158466, 1049602, 1048576, 68158466, 2, 67109888, 1049602, Constants.METHOD_SEND_USER_MSG, 1049600, 68157440, 67109890, SDKLogTypeConstants.EXPTYPE_LITEINC_CP, CodedInputStream.DEFAULT_SIZE_LIMIT, 67108866, 68158464}, new int[]{NTLMEngineImpl.FLAG_REQUEST_VERSION, 16384, 256, 33571080, 33570824, 33554688, 16648, 33570816, 16384, 8, 33554440, 16640, 33554696, 33570824, 33571072, 0, 16640, NTLMEngineImpl.FLAG_REQUEST_VERSION, 16392, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, 33554688, 16648, 0, 33554440, 8, 33554696, 33571080, 16392, 33570816, 256, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, 33571072, 33571072, 33554696, 16392, 33570816, 16384, 8, 33554440, 33554688, NTLMEngineImpl.FLAG_REQUEST_VERSION, 16640, 33571080, 0, 16648, NTLMEngineImpl.FLAG_REQUEST_VERSION, 256, 16392, 33554696, 256, 0, 33571080, 33570824, 33571072, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, 16384, 16640, 33570824, 33554688, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, 8, 16648, 33570816, 33554440}, new int[]{536870928, 524304, 0, 537397248, 524304, 2048, 536872976, 524288, 2064, 537397264, 526336, 536870912, 536872960, 536870928, 537395200, 526352, 524288, 536872976, 537395216, 0, 2048, 16, 537397248, 537395216, 537397264, 537395200, 536870912, 2064, 16, 526336, 526352, 536872960, 2064, 536870912, 536872960, 526352, 537397248, 524304, 0, 536872960, 536870912, 2048, 537395216, 524288, 524304, 537397264, 526336, 16, 537397264, 526336, 524288, 536872976, 536870928, 537395200, 526352, 0, 2048, 536870928, 536872976, 537397248, 537395200, 2064, 16, 537395216}, new int[]{4096, 128, 4194432, 4194305, 4198529, 4097, 4224, 0, 4194304, 4194433, 129, 4198400, 1, 4198528, 4198400, 129, 4194433, 4096, 4097, 4198529, 0, 4194432, 4194305, 4224, 4198401, 4225, 4198528, 1, 4225, 4198401, 128, 4194304, 4225, 4198400, 4198401, 129, 4096, 128, 4194304, 4198401, 4194433, 4225, 4224, 0, 128, 4194305, 1, 4194432, 0, 4194433, 4194432, 4224, 129, 4096, 4198529, 4194304, 4198528, 1, 4097, 4198529, 4194305, 4198528, 4198400, 4097}, new int[]{136314912, 136347648, 32800, 0, 134250496, 2097184, 136314880, 136347680, 32, 134217728, 2129920, 32800, 2129952, 134250528, 134217760, 136314880, 32768, 2129952, 2097184, 134250496, 136347680, 134217760, 0, 2129920, 134217728, 2097152, 134250528, 136314912, 2097152, 32768, 136347648, 32, 2097152, 32768, 134217760, 136347680, 32800, 134217728, 0, 2129920, 136314912, 134250528, 134250496, 2097184, 136347648, 32, 2097184, 134250496, 136347680, 2097152, 136314880, 134217760, 2129920, 32800, 134250528, 136314880, 32, 136347648, 2129952, 0, 134217728, 136314912, 32768, 2129952}};

    public static int[] body(int[] iArr, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < 25) {
            int i7 = i6;
            for (int i8 = 0; i8 < 32; i8 += 4) {
                int i9 = i5;
                i7 = dEncrypt(i7, i9, i8, i2, i3, iArr);
                i5 = dEncrypt(i9, i7, i8 + 2, i2, i3, iArr);
            }
            i4++;
            i6 = i5;
            i5 = i7;
        }
        int[] iArr2 = new int[2];
        permOp((i6 >>> 1) | (i6 << 31), (i5 >>> 1) | (i5 << 31), 1, 1431655765, iArr2);
        permOp(iArr2[1], iArr2[0], 8, 16711935, iArr2);
        permOp(iArr2[1], iArr2[0], 2, 858993459, iArr2);
        permOp(iArr2[1], iArr2[0], 16, 65535, iArr2);
        permOp(iArr2[1], iArr2[0], 4, 252645135, iArr2);
        return new int[]{iArr2[1], iArr2[0]};
    }

    public static int byteToUnsigned(byte b2) {
        return b2 < 0 ? b2 + 256 : b2;
    }

    public static String crypt(byte[] bArr) {
        return crypt(bArr, (String) null);
    }

    public static int dEncrypt(int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        int i7 = (i3 >>> 16) ^ i3;
        int i8 = i5 & i7;
        int i9 = i6 & i7;
        int i10 = ((i8 ^ (i8 << 16)) ^ i3) ^ iArr[i4];
        int i11 = (i3 ^ (i9 ^ (i9 << 16))) ^ iArr[i4 + 1];
        int i12 = (i11 << 28) | (i11 >>> 4);
        int[][] iArr2 = SPTRANS;
        return i2 ^ (((((iArr2[7][(i12 >>> 24) & 63] | ((iArr2[1][i12 & 63] | iArr2[3][(i12 >>> 8) & 63]) | iArr2[5][(i12 >>> 16) & 63])) | iArr2[0][i10 & 63]) | iArr2[2][(i10 >>> 8) & 63]) | iArr2[4][(i10 >>> 16) & 63]) | iArr2[6][(i10 >>> 24) & 63]);
    }

    public static int[] desSetKey(byte[] bArr) {
        int i2;
        int i3;
        int i4;
        int[] iArr = new int[32];
        int[] iArr2 = new int[2];
        permOp(fourBytesToInt(bArr, 4), fourBytesToInt(bArr, 0), 4, 252645135, iArr2);
        int i5 = iArr2[0];
        permOp(hPermOp(i5, -2, -859045888), hPermOp(iArr2[1], -2, -859045888), 1, 1431655765, iArr2);
        permOp(iArr2[1], iArr2[0], 8, 16711935, iArr2);
        permOp(iArr2[1], iArr2[0], 1, 1431655765, iArr2);
        int i6 = iArr2[0];
        int i7 = iArr2[1];
        int i8 = ((i6 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >>> 16) | ((i6 & 255) << 16) | (65280 & i6) | (((-268435456) & i7) >>> 4);
        int i9 = i7 & Label.FORWARD_REFERENCE_HANDLE_MASK;
        int i10 = 0;
        int i11 = 0;
        while (i10 < 16) {
            if (SHIFT2[i10]) {
                i2 = (i9 << 26) | (i9 >>> 2);
                i3 = i8 >>> 2;
                i4 = i8 << 26;
            } else {
                i2 = (i9 << 27) | (i9 >>> 1);
                i3 = i8 >>> 1;
                i4 = i8 << 27;
            }
            i9 = i2 & Label.FORWARD_REFERENCE_HANDLE_MASK;
            i8 = (i4 | i3) & Label.FORWARD_REFERENCE_HANDLE_MASK;
            int[][] iArr3 = SKB;
            int i12 = iArr3[0][i9 & 63] | iArr3[1][((i9 >>> 6) & 3) | ((i9 >>> 7) & 60)] | iArr3[2][((i9 >>> 13) & 15) | ((i9 >>> 14) & 48)] | iArr3[3][((i9 >>> 20) & 1) | ((i9 >>> 21) & 6) | ((i9 >>> 22) & 56)];
            int i13 = iArr3[7][((i8 >>> 21) & 15) | ((i8 >>> 22) & 48)] | iArr3[4][i8 & 63] | iArr3[5][((i8 >>> 7) & 3) | ((i8 >>> 8) & 60)] | iArr3[6][(i8 >>> 15) & 63];
            int i14 = i11 + 1;
            iArr[i11] = (i13 << 16) | (65535 & i12);
            int i15 = (i12 >>> 16) | (i13 & SupportMenu.CATEGORY_MASK);
            iArr[i14] = (i15 >>> 28) | (i15 << 4);
            i10++;
            i11 = i14 + 1;
        }
        return iArr;
    }

    public static int fourBytesToInt(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int byteToUnsigned = byteToUnsigned(bArr[i2]) | (byteToUnsigned(bArr[i3]) << 8);
        return (byteToUnsigned(bArr[i4 + 1]) << 24) | byteToUnsigned | (byteToUnsigned(bArr[i4]) << 16);
    }

    public static int hPermOp(int i2, int i3, int i4) {
        int i5 = 16 - i3;
        int i6 = i4 & ((i2 << i5) ^ i2);
        return (i2 ^ i6) ^ (i6 >>> i5);
    }

    public static void intToFourBytes(int i2, byte[] bArr, int i3) {
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 8) & 255);
        bArr[i5] = (byte) ((i2 >>> 16) & 255);
        bArr[i5 + 1] = (byte) ((i2 >>> 24) & 255);
    }

    public static void permOp(int i2, int i3, int i4, int i5, int[] iArr) {
        int i6 = i5 & ((i2 >>> i4) ^ i3);
        iArr[0] = i2 ^ (i6 << i4);
        iArr[1] = i3 ^ i6;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x00a8 */
    public static String crypt(byte[] bArr, String str) {
        if (str == null) {
            Random random = new Random();
            int length = SALT_CHARS.length;
            str = "" + SALT_CHARS[random.nextInt(length)] + SALT_CHARS[random.nextInt(length)];
        } else if (!str.matches("^[./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz]{2,}$")) {
            throw new IllegalArgumentException("Invalid salt value: " + str);
        }
        StringBuilder sb = new StringBuilder("             ");
        char charAt = str.charAt(0);
        char charAt2 = str.charAt(1);
        sb.setCharAt(0, charAt);
        sb.setCharAt(1, charAt2);
        int[] iArr = CON_SALT;
        int i2 = iArr[charAt];
        int i3 = iArr[charAt2] << 4;
        byte[] bArr2 = new byte[8];
        for (int i4 = 0; i4 < 8; i4++) {
            bArr2[i4] = 0;
        }
        for (int i5 = 0; i5 < 8 && i5 < bArr.length; i5++) {
            bArr2[i5] = (byte) (bArr[i5] << 1);
        }
        int[] body = body(desSetKey(bArr2), i2, i3);
        byte[] bArr3 = new byte[9];
        intToFourBytes(body[0], bArr3, 0);
        intToFourBytes(body[1], bArr3, 4);
        bArr3[8] = 0;
        int i6 = 0;
        int i7 = 128;
        for (int i8 = 2; i8 < 13; i8++) {
            int i9 = 0;
            int i10 = 0;
            i7 = i7;
            while (i9 < 6) {
                i10 <<= 1;
                if ((bArr3[i6] & i7) != 0) {
                    i10 |= 1;
                }
                int i11 = i7 >>> 1;
                if (i11 == 0) {
                    i6++;
                    i11 = 128;
                }
                sb.setCharAt(i8, (char) COV2CHAR[i10]);
                i9++;
                i7 = i11;
            }
        }
        return sb.toString();
    }

    public static String crypt(String str) {
        return crypt(str.getBytes(Charsets.UTF_8));
    }

    public static String crypt(String str, String str2) {
        return crypt(str.getBytes(Charsets.UTF_8), str2);
    }
}
