package com.google.zxing.aztec.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.BitArray;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public final class State {
    public static /* synthetic */ Interceptable $ic;
    public static final State INITIAL_STATE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int binaryShiftByteCount;
    public final int bitCount;
    public final int mode;
    public final Token token;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1805440730, "Lcom/google/zxing/aztec/encoder/State;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1805440730, "Lcom/google/zxing/aztec/encoder/State;");
                return;
            }
        }
        INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    }

    public State(Token token, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {token, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.token = token;
        this.mode = i2;
        this.binaryShiftByteCount = i3;
        this.bitCount = i4;
    }

    public State addBinaryShiftChar(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Token token = this.token;
            int i3 = this.mode;
            int i4 = this.bitCount;
            if (i3 == 4 || i3 == 2) {
                int i5 = HighLevelEncoder.LATCH_TABLE[i3][0];
                int i6 = 65535 & i5;
                int i7 = i5 >> 16;
                token = token.add(i6, i7);
                i4 += i7;
                i3 = 0;
            }
            int i8 = this.binaryShiftByteCount;
            State state = new State(token, i3, this.binaryShiftByteCount + 1, i4 + ((i8 == 0 || i8 == 31) ? 18 : i8 == 62 ? 9 : 8));
            return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i2 + 1) : state;
        }
        return (State) invokeI.objValue;
    }

    public State endBinaryShift(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int i3 = this.binaryShiftByteCount;
            return i3 == 0 ? this : new State(this.token.addBinaryShift(i2 - i3, i3), this.mode, 0, this.bitCount);
        }
        return (State) invokeI.objValue;
    }

    public int getBinaryShiftByteCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.binaryShiftByteCount : invokeV.intValue;
    }

    public int getBitCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.bitCount : invokeV.intValue;
    }

    public int getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mode : invokeV.intValue;
    }

    public Token getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.token : (Token) invokeV.objValue;
    }

    public boolean isBetterThanOrEqualTo(State state) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, state)) == null) {
            int i3 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
            int i4 = state.binaryShiftByteCount;
            if (i4 > 0 && ((i2 = this.binaryShiftByteCount) == 0 || i2 > i4)) {
                i3 += 10;
            }
            return i3 <= state.bitCount;
        }
        return invokeL.booleanValue;
    }

    public State latchAndAppend(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) {
            int i4 = this.bitCount;
            Token token = this.token;
            int i5 = this.mode;
            if (i2 != i5) {
                int i6 = HighLevelEncoder.LATCH_TABLE[i5][i2];
                int i7 = 65535 & i6;
                int i8 = i6 >> 16;
                token = token.add(i7, i8);
                i4 += i8;
            }
            int i9 = i2 == 2 ? 4 : 5;
            return new State(token.add(i3, i9), i2, 0, i4 + i9);
        }
        return (State) invokeII.objValue;
    }

    public State shiftAndAppend(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            Token token = this.token;
            int i4 = this.mode == 2 ? 4 : 5;
            return new State(token.add(HighLevelEncoder.SHIFT_TABLE[this.mode][i2], i4).add(i3, 5), this.mode, 0, this.bitCount + i4 + 5);
        }
        return (State) invokeII.objValue;
    }

    public BitArray toBitArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bArr)) == null) {
            LinkedList<Token> linkedList = new LinkedList();
            for (Token token = endBinaryShift(bArr.length).token; token != null; token = token.getPrevious()) {
                linkedList.addFirst(token);
            }
            BitArray bitArray = new BitArray();
            for (Token token2 : linkedList) {
                token2.appendTo(bitArray, bArr);
            }
            return bitArray;
        }
        return (BitArray) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount)) : (String) invokeV.objValue;
    }
}
