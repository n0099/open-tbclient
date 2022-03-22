package com.google.zxing.pdf417.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Formatter;
/* loaded from: classes7.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public final Codeword getCodeword(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.codewords[imageRowToCodewordIndex(i)] : (Codeword) invokeI.objValue;
    }

    public final Codeword getCodewordNearby(int i) {
        InterceptResult invokeI;
        Codeword codeword;
        Codeword codeword2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            Codeword codeword3 = getCodeword(i);
            if (codeword3 != null) {
                return codeword3;
            }
            for (int i2 = 1; i2 < 5; i2++) {
                int imageRowToCodewordIndex = imageRowToCodewordIndex(i) - i2;
                if (imageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[imageRowToCodewordIndex]) != null) {
                    return codeword2;
                }
                int imageRowToCodewordIndex2 = imageRowToCodewordIndex(i) + i2;
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

    public final int imageRowToCodewordIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i - this.boundingBox.getMinY() : invokeI.intValue;
    }

    public final void setCodeword(int i, Codeword codeword) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, codeword) == null) {
            this.codewords[imageRowToCodewordIndex(i)] = codeword;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Codeword[] codewordArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Formatter formatter = new Formatter();
            int i = 0;
            for (Codeword codeword : this.codewords) {
                if (codeword == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                    i++;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        }
        return (String) invokeV.objValue;
    }
}
