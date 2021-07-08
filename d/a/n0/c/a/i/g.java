package d.a.n0.c.a.i;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f49109a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f49110b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f49111c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f49112d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f49113e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f49114f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f49115g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f49116h;

    /* renamed from: i  reason: collision with root package name */
    public long f49117i;
    public byte[] j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Integer) objArr[0], (Integer) objArr[1], (Integer) objArr[2], (Integer) objArr[3], (byte[]) objArr[4], (byte[]) objArr[5], ((Long) objArr[6]).longValue(), (byte[]) objArr[7], ((Integer) objArr[8]).intValue(), (DefaultConstructorMarker) objArr[9]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {num, num2, num3, num4, bArr, bArr2, Long.valueOf(j), bArr3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49111c = num;
        this.f49112d = num2;
        this.f49113e = num3;
        this.f49114f = num4;
        this.f49115g = bArr;
        this.f49116h = bArr2;
        this.f49117i = j;
        this.j = bArr3;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (k.f45831a) {
                Log.d("BDTLS", "Recovery: add recoveryCount: " + this.f49110b);
            }
            this.f49110b++;
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49110b < 3 : invokeV.booleanValue;
    }

    public final byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49115g : (byte[]) invokeV.objValue;
    }

    public final Integer d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49111c : (Integer) invokeV.objValue;
    }

    public final Integer e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49113e : (Integer) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof g) {
                    g gVar = (g) obj;
                    return Intrinsics.areEqual(this.f49111c, gVar.f49111c) && Intrinsics.areEqual(this.f49112d, gVar.f49112d) && Intrinsics.areEqual(this.f49113e, gVar.f49113e) && Intrinsics.areEqual(this.f49114f, gVar.f49114f) && Intrinsics.areEqual(this.f49115g, gVar.f49115g) && Intrinsics.areEqual(this.f49116h, gVar.f49116h) && this.f49117i == gVar.f49117i && Intrinsics.areEqual(this.j, gVar.j);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final Integer f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f49112d : (Integer) invokeV.objValue;
    }

    public final Integer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f49114f : (Integer) invokeV.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f49109a : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Integer num = this.f49111c;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            Integer num2 = this.f49112d;
            int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.f49113e;
            int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.f49114f;
            int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
            byte[] bArr = this.f49115g;
            int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
            byte[] bArr2 = this.f49116h;
            int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
            long j = this.f49117i;
            int i2 = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            byte[] bArr3 = this.j;
            return i2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
        }
        return invokeV.intValue;
    }

    public final byte[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f49116h : (byte[]) invokeV.objValue;
    }

    public final synchronized boolean j() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                z = false;
                if (this.f49115g != null && this.f49116h != null && this.f49117i > currentTimeMillis && this.f49109a == 1) {
                    z = true;
                }
                if (d.a.n0.c.a.a.f49075a) {
                    Log.d("BDTLS", "isSessionEnable " + this.f49115g + ' ' + this.f49116h + ' ' + this.f49117i + ' ' + this.f49109a);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (k.f45831a) {
                Log.d("BDTLS", "Downgrade: reset downgrade count " + this.f49110b);
            }
            this.f49110b = 0;
        }
    }

    public final void l(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            this.f49115g = bArr;
        }
    }

    public final void m(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, num) == null) {
            this.f49111c = num;
        }
    }

    public final void n(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, num) == null) {
            this.f49113e = num;
        }
    }

    public final void o(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, num) == null) {
            this.f49112d = num;
        }
    }

    public final void p(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, num) == null) {
            this.f49114f = num;
        }
    }

    public final void q(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bArr) == null) {
            this.j = bArr;
        }
    }

    public final void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.f49117i = j;
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f49109a = i2;
        }
    }

    public final void t(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bArr) == null) {
            this.f49116h = bArr;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "SessionParams(dhGroupId=" + this.f49111c + ", dhSecretKey=" + this.f49112d + ", dhPublicKey=" + this.f49113e + ", dhServerPublicKey=" + this.f49114f + ", aesSecretKey=" + Arrays.toString(this.f49115g) + ", sessionTicket=" + Arrays.toString(this.f49116h) + ", expireTime=" + this.f49117i + ", entryType=" + Arrays.toString(this.j) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : num4, (i2 & 16) != 0 ? null : bArr, (i2 & 32) != 0 ? null : bArr2, (i2 & 64) != 0 ? 0L : j, (i2 & 128) == 0 ? bArr3 : null);
    }
}
