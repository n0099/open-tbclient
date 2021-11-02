package com.google.zxing.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public final class DecoderResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<byte[]> byteSegments;
    public final String ecLevel;
    public Integer erasures;
    public Integer errorsCorrected;
    public int numBits;
    public Object other;
    public final byte[] rawBytes;
    public final int structuredAppendParity;
    public final int structuredAppendSequenceNumber;
    public final String text;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, str, list, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((byte[]) objArr2[0], (String) objArr2[1], (List) objArr2[2], (String) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public List<byte[]> getByteSegments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.byteSegments : (List) invokeV.objValue;
    }

    public String getECLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.ecLevel : (String) invokeV.objValue;
    }

    public Integer getErasures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.erasures : (Integer) invokeV.objValue;
    }

    public Integer getErrorsCorrected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.errorsCorrected : (Integer) invokeV.objValue;
    }

    public int getNumBits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.numBits : invokeV.intValue;
    }

    public Object getOther() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.other : invokeV.objValue;
    }

    public byte[] getRawBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.rawBytes : (byte[]) invokeV.objValue;
    }

    public int getStructuredAppendParity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.structuredAppendParity : invokeV.intValue;
    }

    public int getStructuredAppendSequenceNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.structuredAppendSequenceNumber : invokeV.intValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.text : (String) invokeV.objValue;
    }

    public boolean hasStructuredAppend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.structuredAppendParity >= 0 && this.structuredAppendSequenceNumber >= 0 : invokeV.booleanValue;
    }

    public void setErasures(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, num) == null) {
            this.erasures = num;
        }
    }

    public void setErrorsCorrected(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, num) == null) {
            this.errorsCorrected = num;
        }
    }

    public void setNumBits(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.numBits = i2;
        }
    }

    public void setOther(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, obj) == null) {
            this.other = obj;
        }
    }

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, str, list, str2, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.rawBytes = bArr;
        this.numBits = bArr == null ? 0 : bArr.length * 8;
        this.text = str;
        this.byteSegments = list;
        this.ecLevel = str2;
        this.structuredAppendParity = i3;
        this.structuredAppendSequenceNumber = i2;
    }
}
