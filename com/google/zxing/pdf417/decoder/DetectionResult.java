package com.google.zxing.pdf417.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Formatter;
/* loaded from: classes6.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (!(interceptable == null || interceptable.invokeL(65537, this, detectionResultColumn) == null) || detectionResultColumn == null) {
            return;
        }
        ((DetectionResultRowIndicatorColumn) detectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
    }

    public static boolean adjustRowNumber(Codeword codeword, Codeword codeword2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, codeword, codeword2)) == null) {
            if (codeword2 != null && codeword2.hasValidRowNumber() && codeword2.getBucket() == codeword.getBucket()) {
                codeword.setRowNumber(codeword2.getRowNumber());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int adjustRowNumberIfValid(int i2, int i3, Codeword codeword) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i2, i3, codeword)) == null) {
            if (codeword == null || codeword.hasValidRowNumber()) {
                return i3;
            }
            if (codeword.isValidRowNumber(i2)) {
                codeword.setRowNumber(i2);
                return 0;
            }
            return i3 + 1;
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
            for (int i2 = 1; i2 < this.barcodeColumnCount + 1; i2++) {
                Codeword[] codewords = this.detectionResultColumns[i2].getCodewords();
                for (int i3 = 0; i3 < codewords.length; i3++) {
                    if (codewords[i3] != null && !codewords[i3].hasValidRowNumber()) {
                        adjustRowNumbers(i2, i3, codewords);
                    }
                }
            }
            return adjustRowNumbersByRow;
        }
        return invokeV.intValue;
    }

    private int adjustRowNumbersByRow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            adjustRowNumbersFromBothRI();
            return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
        }
        return invokeV.intValue;
    }

    private void adjustRowNumbersFromBothRI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
            if (detectionResultColumnArr[0] == null || detectionResultColumnArr[this.barcodeColumnCount + 1] == null) {
                return;
            }
            Codeword[] codewords = detectionResultColumnArr[0].getCodewords();
            Codeword[] codewords2 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
            for (int i2 = 0; i2 < codewords.length; i2++) {
                if (codewords[i2] != null && codewords2[i2] != null && codewords[i2].getRowNumber() == codewords2[i2].getRowNumber()) {
                    for (int i3 = 1; i3 <= this.barcodeColumnCount; i3++) {
                        Codeword codeword = this.detectionResultColumns[i3].getCodewords()[i2];
                        if (codeword != null) {
                            codeword.setRowNumber(codewords[i2].getRowNumber());
                            if (!codeword.hasValidRowNumber()) {
                                this.detectionResultColumns[i3].getCodewords()[i2] = null;
                            }
                        }
                    }
                }
            }
        }
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
            int i2 = 0;
            for (int i3 = 0; i3 < codewords.length; i3++) {
                if (codewords[i3] != null) {
                    int rowNumber = codewords[i3].getRowNumber();
                    int i4 = 0;
                    for (int i5 = 1; i5 < this.barcodeColumnCount + 1 && i4 < 2; i5++) {
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

    private int adjustRowNumbersFromRRI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
            int i2 = this.barcodeColumnCount;
            if (detectionResultColumnArr[i2 + 1] == null) {
                return 0;
            }
            Codeword[] codewords = detectionResultColumnArr[i2 + 1].getCodewords();
            int i3 = 0;
            for (int i4 = 0; i4 < codewords.length; i4++) {
                if (codewords[i4] != null) {
                    int rowNumber = codewords[i4].getRowNumber();
                    int i5 = 0;
                    for (int i6 = this.barcodeColumnCount + 1; i6 > 0 && i5 < 2; i6--) {
                        Codeword codeword = this.detectionResultColumns[i6].getCodewords()[i4];
                        if (codeword != null) {
                            i5 = adjustRowNumberIfValid(rowNumber, i5, codeword);
                            if (!codeword.hasValidRowNumber()) {
                                i3++;
                            }
                        }
                    }
                }
            }
            return i3;
        }
        return invokeV.intValue;
    }

    public int getBarcodeColumnCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.barcodeColumnCount : invokeV.intValue;
    }

    public int getBarcodeECLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.barcodeMetadata.getErrorCorrectionLevel() : invokeV.intValue;
    }

    public int getBarcodeRowCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.barcodeMetadata.getRowCount() : invokeV.intValue;
    }

    public BoundingBox getBoundingBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.boundingBox : (BoundingBox) invokeV.objValue;
    }

    public DetectionResultColumn getDetectionResultColumn(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.detectionResultColumns[i2] : (DetectionResultColumn) invokeI.objValue;
    }

    public DetectionResultColumn[] getDetectionResultColumns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
            adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
            int i2 = 928;
            while (true) {
                int adjustRowNumbers = adjustRowNumbers();
                if (adjustRowNumbers <= 0 || adjustRowNumbers >= i2) {
                    break;
                }
                i2 = adjustRowNumbers;
            }
            return this.detectionResultColumns;
        }
        return (DetectionResultColumn[]) invokeV.objValue;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, boundingBox) == null) {
            this.boundingBox = boundingBox;
        }
    }

    public void setDetectionResultColumn(int i2, DetectionResultColumn detectionResultColumn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, detectionResultColumn) == null) {
            this.detectionResultColumns[i2] = detectionResultColumn;
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
            for (int i2 = 0; i2 < detectionResultColumn.getCodewords().length; i2++) {
                formatter.format("CW %3d:", Integer.valueOf(i2));
                for (int i3 = 0; i3 < this.barcodeColumnCount + 2; i3++) {
                    DetectionResultColumn[] detectionResultColumnArr2 = this.detectionResultColumns;
                    if (detectionResultColumnArr2[i3] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        Codeword codeword = detectionResultColumnArr2[i3].getCodewords()[i2];
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

    private void adjustRowNumbers(int i2, int i3, Codeword[] codewordArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(AdIconUtil.AD_TEXT_ID, this, i2, i3, codewordArr) == null) {
            Codeword codeword = codewordArr[i3];
            Codeword[] codewords = this.detectionResultColumns[i2 - 1].getCodewords();
            DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
            int i4 = i2 + 1;
            Codeword[] codewords2 = detectionResultColumnArr[i4] != null ? detectionResultColumnArr[i4].getCodewords() : codewords;
            Codeword[] codewordArr2 = new Codeword[14];
            codewordArr2[2] = codewords[i3];
            codewordArr2[3] = codewords2[i3];
            if (i3 > 0) {
                int i5 = i3 - 1;
                codewordArr2[0] = codewordArr[i5];
                codewordArr2[4] = codewords[i5];
                codewordArr2[5] = codewords2[i5];
            }
            if (i3 > 1) {
                int i6 = i3 - 2;
                codewordArr2[8] = codewordArr[i6];
                codewordArr2[10] = codewords[i6];
                codewordArr2[11] = codewords2[i6];
            }
            if (i3 < codewordArr.length - 1) {
                int i7 = i3 + 1;
                codewordArr2[1] = codewordArr[i7];
                codewordArr2[6] = codewords[i7];
                codewordArr2[7] = codewords2[i7];
            }
            if (i3 < codewordArr.length - 2) {
                int i8 = i3 + 2;
                codewordArr2[9] = codewordArr[i8];
                codewordArr2[12] = codewords[i8];
                codewordArr2[13] = codewords2[i8];
            }
            for (int i9 = 0; i9 < 14 && !adjustRowNumber(codeword, codewordArr2[i9]); i9++) {
            }
        }
    }
}
