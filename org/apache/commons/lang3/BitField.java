package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BitField {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int _mask;
    public final int _shift_count;

    public BitField(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this._mask = i2;
        this._shift_count = i2 != 0 ? Integer.numberOfTrailingZeros(i2) : 0;
    }

    public int clear(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 & (~this._mask) : invokeI.intValue;
    }

    public byte clearByte(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2)) == null) ? (byte) clear(b2) : invokeB.byteValue;
    }

    public short clearShort(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Short.valueOf(s)})) == null) ? (short) clear(s) : invokeCommon.shortValue;
    }

    public int getRawValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 & this._mask : invokeI.intValue;
    }

    public short getShortRawValue(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Short.valueOf(s)})) == null) ? (short) getRawValue(s) : invokeCommon.shortValue;
    }

    public short getShortValue(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Short.valueOf(s)})) == null) ? (short) getValue(s) : invokeCommon.shortValue;
    }

    public int getValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? getRawValue(i2) >> this._shift_count : invokeI.intValue;
    }

    public boolean isAllSet(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int i3 = this._mask;
            return (i2 & i3) == i3;
        }
        return invokeI.booleanValue;
    }

    public boolean isSet(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? (i2 & this._mask) != 0 : invokeI.booleanValue;
    }

    public int set(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 | this._mask : invokeI.intValue;
    }

    public int setBoolean(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? z ? set(i2) : clear(i2) : invokeCommon.intValue;
    }

    public byte setByte(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(1048587, this, b2)) == null) ? (byte) set(b2) : invokeB.byteValue;
    }

    public byte setByteBoolean(byte b2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Byte.valueOf(b2), Boolean.valueOf(z)})) == null) ? z ? setByte(b2) : clearByte(b2) : invokeCommon.byteValue;
    }

    public short setShort(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Short.valueOf(s)})) == null) ? (short) set(s) : invokeCommon.shortValue;
    }

    public short setShortBoolean(short s, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Short.valueOf(s), Boolean.valueOf(z)})) == null) ? z ? setShort(s) : clearShort(s) : invokeCommon.shortValue;
    }

    public short setShortValue(short s, short s2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Short.valueOf(s), Short.valueOf(s2)})) == null) ? (short) setValue(s, s2) : invokeCommon.shortValue;
    }

    public int setValue(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i2, i3)) == null) {
            int i4 = this._mask;
            return (i2 & (~i4)) | ((i3 << this._shift_count) & i4);
        }
        return invokeII.intValue;
    }
}
