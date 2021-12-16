package com.google.zxing.aztec.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.BitArray;
import kotlin.text.Typography;
/* loaded from: classes3.dex */
public final class SimpleToken extends Token {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final short bitCount;
    public final short value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleToken(Token token, int i2, int i3) {
        super(token);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {token, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Token) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.value = (short) i2;
        this.bitCount = (short) i3;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(BitArray bitArray, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bitArray, bArr) == null) {
            bitArray.appendBits(this.value, this.bitCount);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            short s = this.value;
            short s2 = this.bitCount;
            int i2 = (s & ((1 << s2) - 1)) | (1 << s2);
            return "<" + Integer.toBinaryString(i2 | (1 << this.bitCount)).substring(1) + Typography.greater;
        }
        return (String) invokeV.objValue;
    }
}
