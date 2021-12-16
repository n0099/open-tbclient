package com.google.zxing.qrcode.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
/* loaded from: classes3.dex */
public final class FormatInformation {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[][] FORMAT_INFO_DECODE_LOOKUP;
    public static final int FORMAT_INFO_MASK_QR = 21522;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte dataMask;
    public final ErrorCorrectionLevel errorCorrectionLevel;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(138711915, "Lcom/google/zxing/qrcode/decoder/FormatInformation;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(138711915, "Lcom/google/zxing/qrcode/decoder/FormatInformation;");
                return;
            }
        }
        FORMAT_INFO_DECODE_LOOKUP = new int[][]{new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{SpeedStatsStampTable.SECOND_DRAW_DISPATCH_STAMP_KEY, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{PayBeanFactory.BEAN_ID_CARD_ADD, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    }

    public FormatInformation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.errorCorrectionLevel = ErrorCorrectionLevel.forBits((i2 >> 3) & 3);
        this.dataMask = (byte) (i2 & 7);
    }

    public static FormatInformation decodeFormatInformation(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            FormatInformation doDecodeFormatInformation = doDecodeFormatInformation(i2, i3);
            return doDecodeFormatInformation != null ? doDecodeFormatInformation : doDecodeFormatInformation(i2 ^ 21522, i3 ^ 21522);
        }
        return (FormatInformation) invokeII.objValue;
    }

    public static FormatInformation doDecodeFormatInformation(int i2, int i3) {
        InterceptResult invokeII;
        int[][] iArr;
        int numBitsDiffering;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            int i4 = Integer.MAX_VALUE;
            int i5 = 0;
            for (int[] iArr2 : FORMAT_INFO_DECODE_LOOKUP) {
                int i6 = iArr2[0];
                if (i6 != i2 && i6 != i3) {
                    int numBitsDiffering2 = numBitsDiffering(i2, i6);
                    if (numBitsDiffering2 < i4) {
                        i5 = iArr2[1];
                        i4 = numBitsDiffering2;
                    }
                    if (i2 != i3 && (numBitsDiffering = numBitsDiffering(i3, i6)) < i4) {
                        i5 = iArr2[1];
                        i4 = numBitsDiffering;
                    }
                } else {
                    return new FormatInformation(iArr2[1]);
                }
            }
            if (i4 <= 3) {
                return new FormatInformation(i5);
            }
            return null;
        }
        return (FormatInformation) invokeII.objValue;
    }

    public static int numBitsDiffering(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) ? Integer.bitCount(i2 ^ i3) : invokeII.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof FormatInformation) {
                FormatInformation formatInformation = (FormatInformation) obj;
                return this.errorCorrectionLevel == formatInformation.errorCorrectionLevel && this.dataMask == formatInformation.dataMask;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public byte getDataMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dataMask : invokeV.byteValue;
    }

    public ErrorCorrectionLevel getErrorCorrectionLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.errorCorrectionLevel : (ErrorCorrectionLevel) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.errorCorrectionLevel.ordinal() << 3) | this.dataMask : invokeV.intValue;
    }
}
