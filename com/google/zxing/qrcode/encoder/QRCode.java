package com.google.zxing.qrcode.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
/* loaded from: classes8.dex */
public final class QRCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NUM_MASK_PATTERNS = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public ErrorCorrectionLevel ecLevel;
    public int maskPattern;
    public ByteMatrix matrix;
    public Mode mode;
    public Version version;

    public static boolean isValidMaskPattern(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i >= 0 && i < 8 : invokeI.booleanValue;
    }

    public QRCode() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.maskPattern = -1;
    }

    public ErrorCorrectionLevel getECLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.ecLevel;
        }
        return (ErrorCorrectionLevel) invokeV.objValue;
    }

    public int getMaskPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.maskPattern;
        }
        return invokeV.intValue;
    }

    public ByteMatrix getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.matrix;
        }
        return (ByteMatrix) invokeV.objValue;
    }

    public Mode getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mode;
        }
        return (Mode) invokeV.objValue;
    }

    public Version getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.version;
        }
        return (Version) invokeV.objValue;
    }

    public void setECLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, errorCorrectionLevel) == null) {
            this.ecLevel = errorCorrectionLevel;
        }
    }

    public void setMaskPattern(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.maskPattern = i;
        }
    }

    public void setMatrix(ByteMatrix byteMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, byteMatrix) == null) {
            this.matrix = byteMatrix;
        }
    }

    public void setMode(Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mode) == null) {
            this.mode = mode;
        }
    }

    public void setVersion(Version version) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, version) == null) {
            this.version = version;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder(200);
            sb.append("<<\n");
            sb.append(" mode: ");
            sb.append(this.mode);
            sb.append("\n ecLevel: ");
            sb.append(this.ecLevel);
            sb.append("\n version: ");
            sb.append(this.version);
            sb.append("\n maskPattern: ");
            sb.append(this.maskPattern);
            if (this.matrix == null) {
                sb.append("\n matrix: null\n");
            } else {
                sb.append("\n matrix:\n");
                sb.append(this.matrix);
            }
            sb.append(">>\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
