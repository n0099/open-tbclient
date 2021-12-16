package com.google.zxing.pdf417.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Formatter;
/* loaded from: classes3.dex */
public class DetectionResultColumn {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_NEARBY_DISTANCE = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public final BoundingBox boundingBox;
    public final Codeword[] codewords;

    public DetectionResultColumn(BoundingBox boundingBox) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {boundingBox};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.boundingBox = new BoundingBox(boundingBox);
        this.codewords = new Codeword[(boundingBox.getMaxY() - boundingBox.getMinY()) + 1];
    }

    public final BoundingBox getBoundingBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.boundingBox : (BoundingBox) invokeV.objValue;
    }

    public final Codeword getCodeword(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.codewords[imageRowToCodewordIndex(i2)] : (Codeword) invokeI.objValue;
    }

    public final Codeword getCodewordNearby(int i2) {
        InterceptResult invokeI;
        Codeword codeword;
        Codeword codeword2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Codeword codeword3 = getCodeword(i2);
            if (codeword3 != null) {
                return codeword3;
            }
            for (int i3 = 1; i3 < 5; i3++) {
                int imageRowToCodewordIndex = imageRowToCodewordIndex(i2) - i3;
                if (imageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[imageRowToCodewordIndex]) != null) {
                    return codeword2;
                }
                int imageRowToCodewordIndex2 = imageRowToCodewordIndex(i2) + i3;
                Codeword[] codewordArr = this.codewords;
                if (imageRowToCodewordIndex2 < codewordArr.length && (codeword = codewordArr[imageRowToCodewordIndex2]) != null) {
                    return codeword;
                }
            }
            return null;
        }
        return (Codeword) invokeI.objValue;
    }

    public final Codeword[] getCodewords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.codewords : (Codeword[]) invokeV.objValue;
    }

    public final int imageRowToCodewordIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 - this.boundingBox.getMinY() : invokeI.intValue;
    }

    public final void setCodeword(int i2, Codeword codeword) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, codeword) == null) {
            this.codewords[imageRowToCodewordIndex(i2)] = codeword;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Codeword[] codewordArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Formatter formatter = new Formatter();
            int i2 = 0;
            for (Codeword codeword : this.codewords) {
                if (codeword == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i2));
                    i2++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i2), Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                    i2++;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        }
        return (String) invokeV.objValue;
    }
}
