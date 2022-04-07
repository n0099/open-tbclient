package com.google.zxing.aztec.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.BitArray;
/* loaded from: classes5.dex */
public final class BinaryShiftToken extends Token {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final short binaryShiftByteCount;
    public final short binaryShiftStart;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinaryShiftToken(Token token, int i, int i2) {
        super(token);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {token, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Token) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.binaryShiftStart = (short) i;
        this.binaryShiftByteCount = (short) i2;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(BitArray bitArray, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048576, this, bitArray, bArr) != null) {
            return;
        }
        int i = 0;
        while (true) {
            short s = this.binaryShiftByteCount;
            if (i >= s) {
                return;
            }
            if (i == 0 || (i == 31 && s <= 62)) {
                bitArray.appendBits(31, 5);
                short s2 = this.binaryShiftByteCount;
                if (s2 > 62) {
                    bitArray.appendBits(s2 - 31, 16);
                } else if (i == 0) {
                    bitArray.appendBits(Math.min((int) s2, 31), 5);
                } else {
                    bitArray.appendBits(s2 - 31, 5);
                }
            }
            bitArray.appendBits(bArr[this.binaryShiftStart + i], 8);
            i++;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder("<");
            sb.append((int) this.binaryShiftStart);
            sb.append("::");
            sb.append((this.binaryShiftStart + this.binaryShiftByteCount) - 1);
            sb.append('>');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
