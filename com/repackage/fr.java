package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class fr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zq a;
    public cr b;
    public byte[] c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fr() {
        this(null, null, null, 7, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((zq) objArr[0], (cr) objArr[1], (byte[]) objArr[2], ((Integer) objArr[3]).intValue(), (DefaultConstructorMarker) objArr[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public fr(zq zqVar, cr crVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zqVar, crVar, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = zqVar;
        this.b = crVar;
        this.c = bArr;
    }

    public final void a(cr crVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, crVar) == null) {
            this.b = crVar;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof fr) {
                    fr frVar = (fr) obj;
                    return Intrinsics.areEqual(this.a, frVar.a) && Intrinsics.areEqual(this.b, frVar.b) && Intrinsics.areEqual(this.c, frVar.c);
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
            zq zqVar = this.a;
            int hashCode = (zqVar != null ? zqVar.hashCode() : 0) * 31;
            cr crVar = this.b;
            int hashCode2 = (hashCode + (crVar != null ? crVar.hashCode() : 0)) * 31;
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

    public /* synthetic */ fr(zq zqVar, cr crVar, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : zqVar, (i & 2) != 0 ? null : crVar, (i & 4) != 0 ? null : bArr);
    }
}
