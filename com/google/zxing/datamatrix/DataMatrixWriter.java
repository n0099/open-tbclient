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
/* loaded from: classes7.dex */
public final class DataMatrixWriter implements Writer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DataMatrixWriter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            for (int i = 0; i < width; i++) {
                for (int i2 = 0; i2 < height; i2++) {
                    if (byteMatrix.get(i, i2) == 1) {
                        bitMatrix.set(i, i2);
                    }
                }
            }
            return bitMatrix;
        }
        return (BitMatrix) invokeL.objValue;
    }

    public static BitMatrix encodeLowLevel(DefaultPlacement defaultPlacement, SymbolInfo symbolInfo) {
        InterceptResult invokeLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, defaultPlacement, symbolInfo)) == null) {
            int symbolDataWidth = symbolInfo.getSymbolDataWidth();
            int symbolDataHeight = symbolInfo.getSymbolDataHeight();
            ByteMatrix byteMatrix = new ByteMatrix(symbolInfo.getSymbolWidth(), symbolInfo.getSymbolHeight());
            int i = 0;
            for (int i2 = 0; i2 < symbolDataHeight; i2++) {
                if (i2 % symbolInfo.matrixHeight == 0) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < symbolInfo.getSymbolWidth(); i4++) {
                        if (i4 % 2 == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        byteMatrix.set(i3, i, z2);
                        i3++;
                    }
                    i++;
                }
                int i5 = 0;
                for (int i6 = 0; i6 < symbolDataWidth; i6++) {
                    if (i6 % symbolInfo.matrixWidth == 0) {
                        byteMatrix.set(i5, i, true);
                        i5++;
                    }
                    byteMatrix.set(i5, i, defaultPlacement.getBit(i6, i2));
                    i5++;
                    int i7 = symbolInfo.matrixWidth;
                    if (i6 % i7 == i7 - 1) {
                        if (i2 % 2 == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        byteMatrix.set(i5, i, z);
                        i5++;
                    }
                }
                i++;
                int i8 = symbolInfo.matrixHeight;
                if (i2 % i8 == i8 - 1) {
                    int i9 = 0;
                    for (int i10 = 0; i10 < symbolInfo.getSymbolWidth(); i10++) {
                        byteMatrix.set(i9, i, true);
                        i9++;
                    }
                    i++;
                }
            }
            return convertByteMatrixToBitMatrix(byteMatrix);
        }
        return (BitMatrix) invokeLL.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, str, barcodeFormat, i, i2)) == null) {
            return encode(str, barcodeFormat, i, i2, null);
        }
        return (BitMatrix) invokeLLII.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map map) {
        InterceptResult invokeCommon;
        Dimension dimension;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, barcodeFormat, Integer.valueOf(i), Integer.valueOf(i2), map})) == null) {
            if (!str.isEmpty()) {
                if (barcodeFormat == BarcodeFormat.DATA_MATRIX) {
                    if (i >= 0 && i2 >= 0) {
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
                    }
                    throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
                }
                throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
            }
            throw new IllegalArgumentException("Found empty contents");
        }
        return (BitMatrix) invokeCommon.objValue;
    }
}
