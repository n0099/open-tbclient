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
/* loaded from: classes8.dex */
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

    public int getBinaryShiftByteCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.binaryShiftByteCount;
        }
        return invokeV.intValue;
    }

    public int getBitCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.bitCount;
        }
        return invokeV.intValue;
    }

    public int getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mode;
        }
        return invokeV.intValue;
    }

    public Token getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.token;
        }
        return (Token) invokeV.objValue;
    }

    public State(Token token, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {token, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.token = token;
        this.mode = i;
        this.binaryShiftByteCount = i2;
        this.bitCount = i3;
    }

    public State addBinaryShiftChar(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
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
            if (i8 != 0 && i8 != 31) {
                if (i8 == 62) {
                    i2 = 9;
                } else {
                    i2 = 8;
                }
            } else {
                i2 = 18;
            }
            State state = new State(token, i3, this.binaryShiftByteCount + 1, i4 + i2);
            if (state.binaryShiftByteCount == 2078) {
                return state.endBinaryShift(i + 1);
            }
            return state;
        }
        return (State) invokeI.objValue;
    }

    public State endBinaryShift(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int i2 = this.binaryShiftByteCount;
            if (i2 == 0) {
                return this;
            }
            return new State(this.token.addBinaryShift(i - i2, i2), this.mode, 0, this.bitCount);
        }
        return (State) invokeI.objValue;
    }

    public boolean isBetterThanOrEqualTo(State state) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, state)) == null) {
            int i2 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
            int i3 = state.binaryShiftByteCount;
            if (i3 > 0 && ((i = this.binaryShiftByteCount) == 0 || i > i3)) {
                i2 += 10;
            }
            if (i2 <= state.bitCount) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
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

    public State latchAndAppend(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i, i2)) == null) {
            int i4 = this.bitCount;
            Token token = this.token;
            int i5 = this.mode;
            if (i != i5) {
                int i6 = HighLevelEncoder.LATCH_TABLE[i5][i];
                int i7 = 65535 & i6;
                int i8 = i6 >> 16;
                token = token.add(i7, i8);
                i4 += i8;
            }
            if (i == 2) {
                i3 = 4;
            } else {
                i3 = 5;
            }
            return new State(token.add(i2, i3), i, 0, i4 + i3);
        }
        return (State) invokeII.objValue;
    }

    public State shiftAndAppend(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) {
            Token token = this.token;
            if (this.mode == 2) {
                i3 = 4;
            } else {
                i3 = 5;
            }
            return new State(token.add(HighLevelEncoder.SHIFT_TABLE[this.mode][i], i3).add(i2, 5), this.mode, 0, this.bitCount + i3 + 5);
        }
        return (State) invokeII.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount));
        }
        return (String) invokeV.objValue;
    }
}
