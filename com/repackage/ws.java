package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ws {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public volatile int b;
    public Integer c;
    public Integer d;
    public Integer e;
    public Integer f;
    public byte[] g;
    public byte[] h;
    public long i;
    public byte[] j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ws() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Integer) objArr[0], (Integer) objArr[1], (Integer) objArr[2], (Integer) objArr[3], (byte[]) objArr[4], (byte[]) objArr[5], ((Long) objArr[6]).longValue(), (byte[]) objArr[7], ((Integer) objArr[8]).intValue(), (DefaultConstructorMarker) objArr[9]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ws(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {num, num2, num3, num4, bArr, bArr2, Long.valueOf(j), bArr3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = num;
        this.d = num2;
        this.e = num3;
        this.f = num4;
        this.g = bArr;
        this.h = bArr2;
        this.i = j;
        this.j = bArr3;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.a = i;
        }
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.i = j;
        }
    }

    public final void d(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, num) == null) {
            this.c = num;
        }
    }

    public final void e(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) {
            this.g = bArr;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof ws) {
                    ws wsVar = (ws) obj;
                    if (Intrinsics.areEqual(this.c, wsVar.c) && Intrinsics.areEqual(this.d, wsVar.d) && Intrinsics.areEqual(this.e, wsVar.e) && Intrinsics.areEqual(this.f, wsVar.f) && Intrinsics.areEqual(this.g, wsVar.g) && Intrinsics.areEqual(this.h, wsVar.h)) {
                        if (!(this.i == wsVar.i) || !Intrinsics.areEqual(this.j, wsVar.j)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("Recovery: add recoveryCount: " + this.b);
            this.b = this.b + 1;
        }
    }

    public final void g(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, num) == null) {
            this.d = num;
        }
    }

    public final void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr) == null) {
            this.h = bArr;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Integer num = this.c;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            Integer num2 = this.d;
            int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.e;
            int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.f;
            int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
            byte[] bArr = this.g;
            int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
            byte[] bArr2 = this.h;
            int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
            long j = this.i;
            int i = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            byte[] bArr3 = this.j;
            return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
        }
        return invokeV.intValue;
    }

    public final void i(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, num) == null) {
            this.e = num;
        }
    }

    public final void j(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bArr) == null) {
            this.j = bArr;
        }
    }

    public final synchronized boolean k() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                z = false;
                if (this.g != null && this.h != null && this.i > currentTimeMillis && this.a == 1) {
                    z = true;
                }
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("isSessionEnable " + this.g + WebvttCueParser.CHAR_SPACE + this.h + WebvttCueParser.CHAR_SPACE + this.i + WebvttCueParser.CHAR_SPACE + this.a);
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void l(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, num) == null) {
            this.f = num;
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.b < 3 : invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("Downgrade: reset downgrade count " + this.b);
            this.b = 0;
        }
    }

    public final Integer o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.c : (Integer) invokeV.objValue;
    }

    public final Integer p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.d : (Integer) invokeV.objValue;
    }

    public final byte[] q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.g : (byte[]) invokeV.objValue;
    }

    public final byte[] r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.h : (byte[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "SessionParams(dhGroupId=" + this.c + ", dhSecretKey=" + this.d + ", dhPublicKey=" + this.e + ", dhServerPublicKey=" + this.f + ", aesSecretKey=" + Arrays.toString(this.g) + ", sessionTicket=" + Arrays.toString(this.h) + ", expireTime=" + this.i + ", entryType=" + Arrays.toString(this.j) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ ws(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) == 0 ? bArr3 : null);
    }
}
