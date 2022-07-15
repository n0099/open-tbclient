package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.zxing.Dimension;
/* loaded from: classes5.dex */
public class SymbolInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final SymbolInfo[] PROD_SYMBOLS;
    public static SymbolInfo[] symbols;
    public transient /* synthetic */ FieldHolder $fh;
    public final int dataCapacity;
    public final int dataRegions;
    public final int errorCodewords;
    public final int matrixHeight;
    public final int matrixWidth;
    public final boolean rectangular;
    public final int rsBlockData;
    public final int rsBlockError;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2133978587, "Lcom/google/zxing/datamatrix/encoder/SymbolInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2133978587, "Lcom/google/zxing/datamatrix/encoder/SymbolInfo;");
                return;
            }
        }
        SymbolInfo[] symbolInfoArr = {new SymbolInfo(false, 3, 5, 8, 8, 1), new SymbolInfo(false, 5, 7, 10, 10, 1), new SymbolInfo(true, 5, 7, 16, 6, 1), new SymbolInfo(false, 8, 10, 12, 12, 1), new SymbolInfo(true, 10, 11, 14, 6, 2), new SymbolInfo(false, 12, 12, 14, 14, 1), new SymbolInfo(true, 16, 14, 24, 10, 1), new SymbolInfo(false, 18, 14, 16, 16, 1), new SymbolInfo(false, 22, 18, 18, 18, 1), new SymbolInfo(true, 22, 18, 16, 10, 2), new SymbolInfo(false, 30, 20, 20, 20, 1), new SymbolInfo(true, 32, 24, 16, 14, 2), new SymbolInfo(false, 36, 24, 22, 22, 1), new SymbolInfo(false, 44, 28, 24, 24, 1), new SymbolInfo(true, 49, 28, 22, 14, 2), new SymbolInfo(false, 62, 36, 14, 14, 4), new SymbolInfo(false, 86, 42, 16, 16, 4), new SymbolInfo(false, 114, 48, 18, 18, 4), new SymbolInfo(false, Cea708Decoder.COMMAND_SPA, 56, 20, 20, 4), new SymbolInfo(false, MatroskaExtractor.ID_TRACK_ENTRY, 68, 22, 22, 4), new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new SymbolInfo(false, 280, 112, 14, 14, 16, Cea708Decoder.COMMAND_DLW, 56), new SymbolInfo(false, 368, Cea708Decoder.COMMAND_SPA, 16, 16, 16, 92, 36), new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48), new SymbolInfo(false, 576, 224, 20, 20, 16, Cea708Decoder.COMMAND_SPA, 56), new SymbolInfo(false, 696, 272, 22, 22, 16, MatroskaExtractor.ID_TRACK_ENTRY, 68), new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56), new SymbolInfo(false, 1050, 408, 18, 18, 36, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 68), new SymbolInfo(false, 1304, 496, 20, 20, 36, MatroskaExtractor.ID_SIMPLE_BLOCK, 62), new DataMatrixSymbolInfo144()};
        PROD_SYMBOLS = symbolInfoArr;
        symbols = symbolInfoArr;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SymbolInfo(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue(), ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private int getHorizontalDataRegions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int i = this.dataRegions;
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2 && i != 4) {
                    if (i != 16) {
                        if (i == 36) {
                            return 6;
                        }
                        throw new IllegalStateException("Cannot handle this number of data regions");
                    }
                    return 4;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    private int getVerticalDataRegions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int i = this.dataRegions;
            if (i == 1 || i == 2) {
                return 1;
            }
            if (i != 4) {
                if (i != 16) {
                    if (i == 36) {
                        return 6;
                    }
                    throw new IllegalStateException("Cannot handle this number of data regions");
                }
                return 4;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public static SymbolInfo lookup(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) ? lookup(i, SymbolShapeHint.FORCE_NONE, true) : (SymbolInfo) invokeI.objValue;
    }

    public static void overrideSymbolSet(SymbolInfo[] symbolInfoArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, symbolInfoArr) == null) {
            symbols = symbolInfoArr;
        }
    }

    public int getCodewordCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dataCapacity + this.errorCodewords : invokeV.intValue;
    }

    public final int getDataCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dataCapacity : invokeV.intValue;
    }

    public int getDataLengthForInterleavedBlock(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.rsBlockData : invokeI.intValue;
    }

    public final int getErrorCodewords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.errorCodewords : invokeV.intValue;
    }

    public final int getErrorLengthForInterleavedBlock(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.rsBlockError : invokeI.intValue;
    }

    public int getInterleavedBlockCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.dataCapacity / this.rsBlockData : invokeV.intValue;
    }

    public final int getSymbolDataHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getVerticalDataRegions() * this.matrixHeight : invokeV.intValue;
    }

    public final int getSymbolDataWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getHorizontalDataRegions() * this.matrixWidth : invokeV.intValue;
    }

    public final int getSymbolHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getSymbolDataHeight() + (getVerticalDataRegions() << 1) : invokeV.intValue;
    }

    public final int getSymbolWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getSymbolDataWidth() + (getHorizontalDataRegions() << 1) : invokeV.intValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.rectangular ? "Rectangular Symbol:" : "Square Symbol:");
            sb.append(" data region ");
            sb.append(this.matrixWidth);
            sb.append('x');
            sb.append(this.matrixHeight);
            sb.append(", symbol size ");
            sb.append(getSymbolWidth());
            sb.append('x');
            sb.append(getSymbolHeight());
            sb.append(", symbol data size ");
            sb.append(getSymbolDataWidth());
            sb.append('x');
            sb.append(getSymbolDataHeight());
            sb.append(", codewords ");
            sb.append(this.dataCapacity);
            sb.append('+');
            sb.append(this.errorCodewords);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public SymbolInfo(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.rectangular = z;
        this.dataCapacity = i;
        this.errorCodewords = i2;
        this.matrixWidth = i3;
        this.matrixHeight = i4;
        this.dataRegions = i5;
        this.rsBlockData = i6;
        this.rsBlockError = i7;
    }

    public static SymbolInfo lookup(int i, SymbolShapeHint symbolShapeHint) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65542, null, i, symbolShapeHint)) == null) ? lookup(i, symbolShapeHint, true) : (SymbolInfo) invokeIL.objValue;
    }

    public static SymbolInfo lookup(int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return lookup(i, z ? SymbolShapeHint.FORCE_NONE : SymbolShapeHint.FORCE_SQUARE, z2);
        }
        return (SymbolInfo) invokeCommon.objValue;
    }

    public static SymbolInfo lookup(int i, SymbolShapeHint symbolShapeHint, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), symbolShapeHint, Boolean.valueOf(z)})) == null) ? lookup(i, symbolShapeHint, null, null, z) : (SymbolInfo) invokeCommon.objValue;
    }

    public static SymbolInfo lookup(int i, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2, boolean z) {
        InterceptResult invokeCommon;
        SymbolInfo[] symbolInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), symbolShapeHint, dimension, dimension2, Boolean.valueOf(z)})) == null) {
            for (SymbolInfo symbolInfo : symbols) {
                if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && symbolInfo.rectangular) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.rectangular) && ((dimension == null || (symbolInfo.getSymbolWidth() >= dimension.getWidth() && symbolInfo.getSymbolHeight() >= dimension.getHeight())) && ((dimension2 == null || (symbolInfo.getSymbolWidth() <= dimension2.getWidth() && symbolInfo.getSymbolHeight() <= dimension2.getHeight())) && i <= symbolInfo.dataCapacity)))) {
                    return symbolInfo;
                }
            }
            if (z) {
                throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i);
            }
            return null;
        }
        return (SymbolInfo) invokeCommon.objValue;
    }
}
