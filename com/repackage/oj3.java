package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$ClientHello;
import com.baidu.swan.bdtls.impl.model.Bdtls$ServerHello;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class oj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bdtls$ClientHello a;
    public Bdtls$ServerHello b;
    public byte[] c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public oj3() {
        this(null, null, null, 7, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Bdtls$ClientHello) objArr[0], (Bdtls$ServerHello) objArr[1], (byte[]) objArr[2], ((Integer) objArr[3]).intValue(), (DefaultConstructorMarker) objArr[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public oj3(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdtls$ClientHello, bdtls$ServerHello, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = bdtls$ClientHello;
        this.b = bdtls$ServerHello;
        this.c = bArr;
    }

    public final void a(Bdtls$ServerHello bdtls$ServerHello) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdtls$ServerHello) == null) {
            this.b = bdtls$ServerHello;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof oj3) {
                    oj3 oj3Var = (oj3) obj;
                    return Intrinsics.areEqual(this.a, oj3Var.a) && Intrinsics.areEqual(this.b, oj3Var.b) && Intrinsics.areEqual(this.c, oj3Var.c);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Bdtls$ClientHello bdtls$ClientHello = this.a;
            int hashCode = (bdtls$ClientHello != null ? bdtls$ClientHello.hashCode() : 0) * 31;
            Bdtls$ServerHello bdtls$ServerHello = this.b;
            int hashCode2 = (hashCode + (bdtls$ServerHello != null ? bdtls$ServerHello.hashCode() : 0)) * 31;
            byte[] bArr = this.c;
            return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "HandshakeParams(clientHello=" + this.a + ", serverHello=" + this.b + ", encodeDHPublicKey=" + Arrays.toString(this.c) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ oj3(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bdtls$ClientHello, (i & 2) != 0 ? null : bdtls$ServerHello, (i & 4) != 0 ? null : bArr);
    }
}
