package com.google.zxing.datamatrix;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;
/* loaded from: classes11.dex */
public final class DataMatrixWriter implements Writer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DataMatrixWriter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static BitMatrix convertByteMatrixToBitMatrix(ByteMatrix byteMatrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, byteMatrix)) == null) {
            int width = byteMatrix.getWidth();
            int height = byteMatrix.getHeight();
            BitMatrix bitMatrix = new BitMatrix(width, height);
            bitMatrix.clear();
            for (int i2 = 0; i2 < width; i2++) {
                for (int i3 = 0; i3 < height; i3++) {
                    if (byteMatrix.get(i2, i3) == 1) {
                        bitMatrix.set(i2, i3);
                    }
                }
            }
            return bitMatrix;
        }
        return (BitMatrix) invokeL.objValue;
    }

    public static BitMatrix encodeLowLevel(DefaultPlacement defaultPlacement, SymbolInfo symbolInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, defaultPlacement, symbolInfo)) == null) {
            int symbolDataWidth = symbolInfo.getSymbolDataWidth();
            int symbolDataHeight = symbolInfo.getSymbolDataHeight();
            ByteMatrix byteMatrix = new ByteMatrix(symbolInfo.getSymbolWidth(), symbolInfo.getSymbolHeight());
            int i2 = 0;
            for (int i3 = 0; i3 < symbolDataHeight; i3++) {
                if (i3 % symbolInfo.matrixHeight == 0) {
                    int i4 = 0;
                    for (int i5 = 0; i5 < symbolInfo.getSymbolWidth(); i5++) {
                        byteMatrix.set(i4, i2, i5 % 2 == 0);
                        i4++;
                    }
                    i2++;
                }
                int i6 = 0;
                for (int i7 = 0; i7 < symbolDataWidth; i7++) {
                    if (i7 % symbolInfo.matrixWidth == 0) {
                        byteMatrix.set(i6, i2, true);
                        i6++;
                    }
                    byteMatrix.set(i6, i2, defaultPlacement.getBit(i7, i3));
                    i6++;
                    int i8 = symbolInfo.matrixWidth;
                    if (i7 % i8 == i8 - 1) {
                        byteMatrix.set(i6, i2, i3 % 2 == 0);
                        i6++;
                    }
                }
                i2++;
                int i9 = symbolInfo.matrixHeight;
                if (i3 % i9 == i9 - 1) {
                    int i10 = 0;
                    for (int i11 = 0; i11 < symbolInfo.getSymbolWidth(); i11++) {
                        byteMatrix.set(i10, i2, true);
                        i10++;
                    }
                    i2++;
                }
            }
            return convertByteMatrixToBitMatrix(byteMatrix);
        }
        return (BitMatrix) invokeLL.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, str, barcodeFormat, i2, i3)) == null) ? encode(str, barcodeFormat, i2, i3, null) : (BitMatrix) invokeLLII.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) {
        InterceptResult invokeCommon;
        Dimension dimension;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, barcodeFormat, Integer.valueOf(i2), Integer.valueOf(i3), map})) == null) {
            if (!str.isEmpty()) {
                if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
                    throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
                } else if (i2 >= 0 && i3 >= 0) {
                    SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
                    Dimension dimension2 = null;
                    if (map != null) {
                        SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                        if (symbolShapeHint2 != null) {
                            symbolShapeHint = symbolShapeHint2;
                        }
                        Dimension dimension3 = (Dimension) map.get(EncodeHintType.MIN_SIZE);
                        if (dimension3 == null) {
                            dimension3 = null;
                        }
                        dimension = (Dimension) map.get(EncodeHintType.MAX_SIZE);
                        if (dimension == null) {
                            dimension = null;
                        }
                        dimension2 = dimension3;
                    } else {
                        dimension = null;
                    }
                    String encodeHighLevel = HighLevelEncoder.encodeHighLevel(str, symbolShapeHint, dimension2, dimension);
                    SymbolInfo lookup = SymbolInfo.lookup(encodeHighLevel.length(), symbolShapeHint, dimension2, dimension, true);
                    DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(encodeHighLevel, lookup), lookup.getSymbolDataWidth(), lookup.getSymbolDataHeight());
                    defaultPlacement.place();
                    return encodeLowLevel(defaultPlacement, lookup);
                } else {
                    throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
                }
            }
            throw new IllegalArgumentException("Found empty contents");
        }
        return (BitMatrix) invokeCommon.objValue;
    }
}
