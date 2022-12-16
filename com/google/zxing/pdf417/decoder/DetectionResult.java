package com.google.zxing.pdf417.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Formatter;
/* loaded from: classes8.dex */
public final class DetectionResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ADJUST_ROW_NUMBER_SKIP = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final int barcodeColumnCount;
    public final BarcodeMetadata barcodeMetadata;
    public BoundingBox boundingBox;
    public final DetectionResultColumn[] detectionResultColumns;

    public DetectionResult(BarcodeMetadata barcodeMetadata, BoundingBox boundingBox) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {barcodeMetadata, boundingBox};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.barcodeMetadata = barcodeMetadata;
        int columnCount = barcodeMetadata.getColumnCount();
        this.barcodeColumnCount = columnCount;
        this.boundingBox = boundingBox;
        this.detectionResultColumns = new DetectionResultColumn[columnCount + 2];
    }

    private void adjustIndicatorColumnRowNumbers(DetectionResultColumn detectionResultColumn) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, detectionResultColumn) == null) && detectionResultColumn != null) {
            ((DetectionResultRowIndicatorColumn) detectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
        }
    }

    public DetectionResultColumn getDetectionResultColumn(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return this.detectionResultColumns[i];
        }
        return (DetectionResultColumn) invokeI.objValue;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, boundingBox) == null) {
            this.boundingBox = boundingBox;
        }
    }

    public static boolean adjustRowNumber(Codeword codeword, Codeword codeword2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, codeword, codeword2)) == null) {
            if (codeword2 == null || !codeword2.hasValidRowNumber() || codeword2.getBucket() != codeword.getBucket()) {
                return false;
            }
            codeword.setRowNumber(codeword2.getRowNumber());
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setDetectionResultColumn(int i, DetectionResultColumn detectionResultColumn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, detectionResultColumn) == null) {
            this.detectionResultColumns[i] = detectionResultColumn;
        }
    }

    public static int adjustRowNumberIfValid(int i, int i2, Codeword codeword) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i, i2, codeword)) == null) {
            if (codeword == null) {
                return i2;
            }
            if (!codeword.hasValidRowNumber()) {
                if (codeword.isValidRowNumber(i)) {
                    codeword.setRowNumber(i);
                    return 0;
                }
                return i2 + 1;
            }
            return i2;
        }
        return invokeIIL.intValue;
    }

    private int adjustRowNumbers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int adjustRowNumbersByRow = adjustRowNumbersByRow();
            if (adjustRowNumbersByRow == 0) {
                return 0;
            }
            for (int i = 1; i < this.barcodeColumnCount + 1; i++) {
                Codeword[] codewords = this.detectionResultColumns[i].getCodewords();
                for (int i2 = 0; i2 < codewords.length; i2++) {
                    if (codewords[i2] != null && !codewords[i2].hasValidRowNumber()) {
                        adjustRowNumbers(i, i2, codewords);
                    }
                }
            }
            return adjustRowNumbersByRow;
        }
        return invokeV.intValue;
    }

    public DetectionResultColumn[] getDetectionResultColumns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
            adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
            int i = 928;
            while (true) {
                int adjustRowNumbers = adjustRowNumbers();
                if (adjustRowNumbers <= 0 || adjustRowNumbers >= i) {
                    break;
                }
                i = adjustRowNumbers;
            }
            return this.detectionResultColumns;
        }
        return (DetectionResultColumn[]) invokeV.objValue;
    }

    private void adjustRowNumbers(int i, int i2, Codeword[] codewordArr) {
        Codeword[] codewordArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65541, this, i, i2, codewordArr) == null) {
            Codeword codeword = codewordArr[i2];
            Codeword[] codewords = this.detectionResultColumns[i - 1].getCodewords();
            DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
            int i3 = i + 1;
            if (detectionResultColumnArr[i3] != null) {
                codewordArr2 = detectionResultColumnArr[i3].getCodewords();
            } else {
                codewordArr2 = codewords;
            }
            Codeword[] codewordArr3 = new Codeword[14];
            codewordArr3[2] = codewords[i2];
            codewordArr3[3] = codewordArr2[i2];
            if (i2 > 0) {
                int i4 = i2 - 1;
                codewordArr3[0] = codewordArr[i4];
                codewordArr3[4] = codewords[i4];
                codewordArr3[5] = codewordArr2[i4];
            }
            if (i2 > 1) {
                int i5 = i2 - 2;
                codewordArr3[8] = codewordArr[i5];
                codewordArr3[10] = codewords[i5];
                codewordArr3[11] = codewordArr2[i5];
            }
            if (i2 < codewordArr.length - 1) {
                int i6 = i2 + 1;
                codewordArr3[1] = codewordArr[i6];
                codewordArr3[6] = codewords[i6];
                codewordArr3[7] = codewordArr2[i6];
            }
            if (i2 < codewordArr.length - 2) {
                int i7 = i2 + 2;
                codewordArr3[9] = codewordArr[i7];
                codewordArr3[12] = codewords[i7];
                codewordArr3[13] = codewordArr2[i7];
            }
            for (int i8 = 0; i8 < 14 && !adjustRowNumber(codeword, codewordArr3[i8]); i8++) {
            }
        }
    }

    private int adjustRowNumbersByRow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            adjustRowNumbersFromBothRI();
            return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
        }
        return invokeV.intValue;
    }

    public int getBarcodeColumnCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.barcodeColumnCount;
        }
        return invokeV.intValue;
    }

    public int getBarcodeECLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.barcodeMetadata.getErrorCorrectionLevel();
        }
        return invokeV.intValue;
    }

    public int getBarcodeRowCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.barcodeMetadata.getRowCount();
        }
        return invokeV.intValue;
    }

    public BoundingBox getBoundingBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.boundingBox;
        }
        return (BoundingBox) invokeV.objValue;
    }

    private void adjustRowNumbersFromBothRI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
            if (detectionResultColumnArr[0] != null && detectionResultColumnArr[this.barcodeColumnCount + 1] != null) {
                Codeword[] codewords = detectionResultColumnArr[0].getCodewords();
                Codeword[] codewords2 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
                for (int i = 0; i < codewords.length; i++) {
                    if (codewords[i] != null && codewords2[i] != null && codewords[i].getRowNumber() == codewords2[i].getRowNumber()) {
                        for (int i2 = 1; i2 <= this.barcodeColumnCount; i2++) {
                            Codeword codeword = this.detectionResultColumns[i2].getCodewords()[i];
                            if (codeword != null) {
                                codeword.setRowNumber(codewords[i].getRowNumber());
                                if (!codeword.hasValidRowNumber()) {
                                    this.detectionResultColumns[i2].getCodewords()[i] = null;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
            DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
            if (detectionResultColumn == null) {
                detectionResultColumn = detectionResultColumnArr[this.barcodeColumnCount + 1];
            }
            Formatter formatter = new Formatter();
            for (int i = 0; i < detectionResultColumn.getCodewords().length; i++) {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.barcodeColumnCount + 2; i2++) {
                    DetectionResultColumn[] detectionResultColumnArr2 = this.detectionResultColumns;
                    if (detectionResultColumnArr2[i2] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        Codeword codeword = detectionResultColumnArr2[i2].getCodewords()[i];
                        if (codeword == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        }
        return (String) invokeV.objValue;
    }

    private int adjustRowNumbersFromLRI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
            if (detectionResultColumnArr[0] == null) {
                return 0;
            }
            Codeword[] codewords = detectionResultColumnArr[0].getCodewords();
            int i = 0;
            for (int i2 = 0; i2 < codewords.length; i2++) {
                if (codewords[i2] != null) {
                    int rowNumber = codewords[i2].getRowNumber();
                    int i3 = 0;
                    for (int i4 = 1; i4 < this.barcodeColumnCount + 1 && i3 < 2; i4++) {
                        Codeword codeword = this.detectionResultColumns[i4].getCodewords()[i2];
                        if (codeword != null) {
                            i3 = adjustRowNumberIfValid(rowNumber, i3, codeword);
                            if (!codeword.hasValidRowNumber()) {
                                i++;
                            }
                        }
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    private int adjustRowNumbersFromRRI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
            int i = this.barcodeColumnCount;
            if (detectionResultColumnArr[i + 1] == null) {
                return 0;
            }
            Codeword[] codewords = detectionResultColumnArr[i + 1].getCodewords();
            int i2 = 0;
            for (int i3 = 0; i3 < codewords.length; i3++) {
                if (codewords[i3] != null) {
                    int rowNumber = codewords[i3].getRowNumber();
                    int i4 = 0;
                    for (int i5 = this.barcodeColumnCount + 1; i5 > 0 && i4 < 2; i5--) {
                        Codeword codeword = this.detectionResultColumns[i5].getCodewords()[i3];
                        if (codeword != null) {
                            i4 = adjustRowNumberIfValid(rowNumber, i4, codeword);
                            if (!codeword.hasValidRowNumber()) {
                                i2++;
                            }
                        }
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }
}
