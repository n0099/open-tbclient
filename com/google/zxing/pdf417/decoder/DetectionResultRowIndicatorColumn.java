package com.google.zxing.pdf417.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.ResultPoint;
/* loaded from: classes7.dex */
public final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean isLeft;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetectionResultRowIndicatorColumn(BoundingBox boundingBox, boolean z) {
        super(boundingBox);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {boundingBox, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BoundingBox) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isLeft = z;
    }

    private void adjustIncompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, barcodeMetadata) == null) {
            BoundingBox boundingBox = getBoundingBox();
            ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
            ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
            int imageRowToCodewordIndex = imageRowToCodewordIndex((int) bottomLeft.getY());
            Codeword[] codewords = getCodewords();
            int i = -1;
            int i2 = 0;
            int i3 = 1;
            for (int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) topLeft.getY()); imageRowToCodewordIndex2 < imageRowToCodewordIndex; imageRowToCodewordIndex2++) {
                if (codewords[imageRowToCodewordIndex2] != null) {
                    Codeword codeword = codewords[imageRowToCodewordIndex2];
                    codeword.setRowNumberAsRowIndicatorColumn();
                    int rowNumber = codeword.getRowNumber() - i;
                    if (rowNumber == 0) {
                        i2++;
                    } else {
                        if (rowNumber == 1) {
                            i3 = Math.max(i3, i2);
                            i = codeword.getRowNumber();
                        } else if (codeword.getRowNumber() >= barcodeMetadata.getRowCount()) {
                            codewords[imageRowToCodewordIndex2] = null;
                        } else {
                            i = codeword.getRowNumber();
                        }
                        i2 = 1;
                    }
                }
            }
        }
    }

    private void removeIncorrectCodewords(Codeword[] codewordArr, BarcodeMetadata barcodeMetadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, codewordArr, barcodeMetadata) == null) {
            for (int i = 0; i < codewordArr.length; i++) {
                Codeword codeword = codewordArr[i];
                if (codewordArr[i] != null) {
                    int value = codeword.getValue() % 30;
                    int rowNumber = codeword.getRowNumber();
                    if (rowNumber > barcodeMetadata.getRowCount()) {
                        codewordArr[i] = null;
                    } else {
                        if (!this.isLeft) {
                            rowNumber += 2;
                        }
                        int i2 = rowNumber % 3;
                        if (i2 != 0) {
                            if (i2 != 1) {
                                if (i2 == 2 && value + 1 != barcodeMetadata.getColumnCount()) {
                                    codewordArr[i] = null;
                                }
                            } else if (value / 3 != barcodeMetadata.getErrorCorrectionLevel() || value % 3 != barcodeMetadata.getRowCountLowerPart()) {
                                codewordArr[i] = null;
                            }
                        } else if ((value * 3) + 1 != barcodeMetadata.getRowCountUpperPart()) {
                            codewordArr[i] = null;
                        }
                    }
                }
            }
        }
    }

    private void setRowNumbers() {
        Codeword[] codewords;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            for (Codeword codeword : getCodewords()) {
                if (codeword != null) {
                    codeword.setRowNumberAsRowIndicatorColumn();
                }
            }
        }
    }

    public void adjustCompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, barcodeMetadata) == null) {
            Codeword[] codewords = getCodewords();
            setRowNumbers();
            removeIncorrectCodewords(codewords, barcodeMetadata);
            BoundingBox boundingBox = getBoundingBox();
            ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
            ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
            int imageRowToCodewordIndex = imageRowToCodewordIndex((int) topLeft.getY());
            int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) bottomLeft.getY());
            int i = -1;
            int i2 = 0;
            int i3 = 1;
            while (imageRowToCodewordIndex < imageRowToCodewordIndex2) {
                if (codewords[imageRowToCodewordIndex] != null) {
                    Codeword codeword = codewords[imageRowToCodewordIndex];
                    int rowNumber = codeword.getRowNumber() - i;
                    if (rowNumber == 0) {
                        i2++;
                    } else {
                        if (rowNumber == 1) {
                            i3 = Math.max(i3, i2);
                            i = codeword.getRowNumber();
                        } else if (rowNumber < 0 || codeword.getRowNumber() >= barcodeMetadata.getRowCount() || rowNumber > imageRowToCodewordIndex) {
                            codewords[imageRowToCodewordIndex] = null;
                        } else {
                            if (i3 > 2) {
                                rowNumber *= i3 - 2;
                            }
                            boolean z = rowNumber >= imageRowToCodewordIndex;
                            for (int i4 = 1; i4 <= rowNumber && !z; i4++) {
                                z = codewords[imageRowToCodewordIndex - i4] != null;
                            }
                            if (z) {
                                codewords[imageRowToCodewordIndex] = null;
                            } else {
                                i = codeword.getRowNumber();
                            }
                        }
                        i2 = 1;
                    }
                }
                imageRowToCodewordIndex++;
            }
        }
    }

    public BarcodeMetadata getBarcodeMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Codeword[] codewords = getCodewords();
            BarcodeValue barcodeValue = new BarcodeValue();
            BarcodeValue barcodeValue2 = new BarcodeValue();
            BarcodeValue barcodeValue3 = new BarcodeValue();
            BarcodeValue barcodeValue4 = new BarcodeValue();
            for (Codeword codeword : codewords) {
                if (codeword != null) {
                    codeword.setRowNumberAsRowIndicatorColumn();
                    int value = codeword.getValue() % 30;
                    int rowNumber = codeword.getRowNumber();
                    if (!this.isLeft) {
                        rowNumber += 2;
                    }
                    int i = rowNumber % 3;
                    if (i == 0) {
                        barcodeValue2.setValue((value * 3) + 1);
                    } else if (i == 1) {
                        barcodeValue4.setValue(value / 3);
                        barcodeValue3.setValue(value % 3);
                    } else if (i == 2) {
                        barcodeValue.setValue(value + 1);
                    }
                }
            }
            if (barcodeValue.getValue().length == 0 || barcodeValue2.getValue().length == 0 || barcodeValue3.getValue().length == 0 || barcodeValue4.getValue().length == 0 || barcodeValue.getValue()[0] <= 0 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90) {
                return null;
            }
            BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
            removeIncorrectCodewords(codewords, barcodeMetadata);
            return barcodeMetadata;
        }
        return (BarcodeMetadata) invokeV.objValue;
    }

    public int[] getRowHeights() {
        InterceptResult invokeV;
        Codeword[] codewords;
        int rowNumber;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BarcodeMetadata barcodeMetadata = getBarcodeMetadata();
            if (barcodeMetadata == null) {
                return null;
            }
            adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
            int rowCount = barcodeMetadata.getRowCount();
            int[] iArr = new int[rowCount];
            for (Codeword codeword : getCodewords()) {
                if (codeword != null && (rowNumber = codeword.getRowNumber()) < rowCount) {
                    iArr[rowNumber] = iArr[rowNumber] + 1;
                }
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public boolean isLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isLeft : invokeV.booleanValue;
    }

    @Override // com.google.zxing.pdf417.decoder.DetectionResultColumn
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "IsLeft: " + this.isLeft + '\n' + super.toString();
        }
        return (String) invokeV.objValue;
    }
}
