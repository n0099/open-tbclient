package d.a.q0.c.a.i;

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
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bdtls$ClientHello f52397a;

    /* renamed from: b  reason: collision with root package name */
    public Bdtls$ServerHello f52398b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f52399c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d() {
        this(null, null, null, 7, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Bdtls$ClientHello) objArr[0], (Bdtls$ServerHello) objArr[1], (byte[]) objArr[2], ((Integer) objArr[3]).intValue(), (DefaultConstructorMarker) objArr[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdtls$ClientHello, bdtls$ServerHello, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52397a = bdtls$ClientHello;
        this.f52398b = bdtls$ServerHello;
        this.f52399c = bArr;
    }

    public final void a(Bdtls$ServerHello bdtls$ServerHello) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdtls$ServerHello) == null) {
            this.f52398b = bdtls$ServerHello;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof d) {
                    d dVar = (d) obj;
                    return Intrinsics.areEqual(this.f52397a, dVar.f52397a) && Intrinsics.areEqual(this.f52398b, dVar.f52398b) && Intrinsics.areEqual(this.f52399c, dVar.f52399c);
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
            Bdtls$ClientHello bdtls$ClientHello = this.f52397a;
            int hashCode = (bdtls$ClientHello != null ? bdtls$ClientHello.hashCode() : 0) * 31;
            Bdtls$ServerHello bdtls$ServerHello = this.f52398b;
            int hashCode2 = (hashCode + (bdtls$ServerHello != null ? bdtls$ServerHello.hashCode() : 0)) * 31;
            byte[] bArr = this.f52399c;
            return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "HandshakeParams(clientHello=" + this.f52397a + ", serverHello=" + this.f52398b + ", encodeDHPublicKey=" + Arrays.toString(this.f52399c) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : bdtls$ClientHello, (i2 & 2) != 0 ? null : bdtls$ServerHello, (i2 & 4) != 0 ? null : bArr);
    }
}
