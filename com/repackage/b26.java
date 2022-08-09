package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b26 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a x;
    public static int y = 52428800;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public long c;
    public long d;
    public float e;
    public float f;
    public float g;
    public float h;
    public boolean i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public List<? extends y26> u;
    public List<? extends Object> v;
    public int w;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b26.y : invokeV.intValue;
        }

        public final void c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                BdLog.d("DanmakuEngine Generation[" + str + "] update to " + i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755878837, "Lcom/repackage/b26;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755878837, "Lcom/repackage/b26;");
                return;
            }
        }
        x = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b26() {
        this(0, 0L, 0L, 0L, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 4194303, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue(), ((Float) objArr[4]).floatValue(), ((Float) objArr[5]).floatValue(), ((Float) objArr[6]).floatValue(), ((Float) objArr[7]).floatValue(), ((Boolean) objArr[8]).booleanValue(), ((Integer) objArr[9]).intValue(), ((Boolean) objArr[10]).booleanValue(), ((Boolean) objArr[11]).booleanValue(), ((Integer) objArr[12]).intValue(), ((Integer) objArr[13]).intValue(), ((Integer) objArr[14]).intValue(), ((Integer) objArr[15]).intValue(), ((Integer) objArr[16]).intValue(), ((Integer) objArr[17]).intValue(), ((Integer) objArr[18]).intValue(), ((Integer) objArr[19]).intValue(), (List) objArr[20], (List) objArr[21], ((Integer) objArr[22]).intValue(), (DefaultConstructorMarker) objArr[23]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public b26(int i, long j, long j2, long j3, float f, float f2, float f3, float f4, boolean z, int i2, boolean z2, boolean z3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, List<? extends y26> dataFilter, List<? extends Object> layoutFilter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), dataFilter, layoutFilter};
            interceptable.invokeUnInit(65538, newInitContext);
            int i11 = newInitContext.flag;
            if ((i11 & 1) != 0) {
                int i12 = i11 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(dataFilter, "dataFilter");
        Intrinsics.checkNotNullParameter(layoutFilter, "layoutFilter");
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
        this.i = z;
        this.j = i2;
        this.k = z2;
        this.l = z3;
        this.m = i3;
        this.n = i4;
        this.o = i5;
        this.p = i6;
        this.q = i7;
        this.r = i8;
        this.s = i9;
        this.t = i10;
        this.u = dataFilter;
        this.v = layoutFilter;
        this.w = i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }

    public final void A(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.d = j;
        }
    }

    public final void B(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            this.e = f;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i = this.o + 1;
            this.o = i;
            this.w++;
            x.c("cache", i);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i = this.q + 1;
            this.q = i;
            this.w++;
            x.c(CloudControlRequest.REQUEST_KEY_FILTER, i);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t++;
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i = this.n + 1;
            this.n = i;
            this.w++;
            x.c(TtmlNode.TAG_LAYOUT, i);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i = this.p + 1;
            this.p = i;
            this.w++;
            x.c("measure", i);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.s++;
            this.w++;
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i = this.r + 1;
            this.r = i;
            this.w++;
            x.c("retainer", i);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int i = this.m + 1;
            this.m = i;
            this.w++;
            x.c("visibility", i);
        }
    }

    public final b26 b(int i, long j, long j2, long j3, float f, float f2, float f3, float f4, boolean z, int i2, boolean z2, boolean z3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, List<? extends y26> dataFilter, List<? extends Object> layoutFilter) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), dataFilter, layoutFilter})) == null) {
            Intrinsics.checkNotNullParameter(dataFilter, "dataFilter");
            Intrinsics.checkNotNullParameter(layoutFilter, "layoutFilter");
            return new b26(i, j, j2, j3, f, f2, f3, f4, z, i2, z2, z3, i3, i4, i5, i6, i7, i8, i9, i10, dataFilter, layoutFilter);
        }
        return (b26) invokeCommon.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.w : invokeV.intValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b26) {
                b26 b26Var = (b26) obj;
                return this.a == b26Var.a && this.b == b26Var.b && this.c == b26Var.c && this.d == b26Var.d && Intrinsics.areEqual((Object) Float.valueOf(this.e), (Object) Float.valueOf(b26Var.e)) && Intrinsics.areEqual((Object) Float.valueOf(this.f), (Object) Float.valueOf(b26Var.f)) && Intrinsics.areEqual((Object) Float.valueOf(this.g), (Object) Float.valueOf(b26Var.g)) && Intrinsics.areEqual((Object) Float.valueOf(this.h), (Object) Float.valueOf(b26Var.h)) && this.i == b26Var.i && this.j == b26Var.j && this.k == b26Var.k && this.l == b26Var.l && this.m == b26Var.m && this.n == b26Var.n && this.o == b26Var.o && this.p == b26Var.p && this.q == b26Var.q && this.r == b26Var.r && this.s == b26Var.s && this.t == b26Var.t && Intrinsics.areEqual(this.u, b26Var.u) && Intrinsics.areEqual(this.v, b26Var.v);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.h : invokeV.floatValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.o : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v15, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r1v18, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int a2 = ((((((((((((((this.a * 31) + com.repackage.a.a(this.b)) * 31) + com.repackage.a.a(this.c)) * 31) + com.repackage.a.a(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31;
            boolean z = this.i;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (((a2 + i) * 31) + this.j) * 31;
            boolean z2 = this.k;
            int i3 = z2;
            if (z2 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z3 = this.l;
            return ((((((((((((((((((((i4 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + this.s) * 31) + this.t) * 31) + this.u.hashCode()) * 31) + this.v.hashCode();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.List<? extends com.repackage.y26>, java.util.List<com.repackage.y26> */
    public final List<y26> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.u : (List) invokeV.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : invokeV.intValue;
    }

    public final long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.c : invokeV.longValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.q : invokeV.intValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.t : invokeV.intValue;
    }

    public final List<Object> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.v : (List) invokeV.objValue;
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.n : invokeV.intValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.p : invokeV.intValue;
    }

    public final long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.b : invokeV.longValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.r : invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.a : invokeV.intValue;
    }

    public final long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.d : invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return "DanmakuConfig(retainerPolicy=" + this.a + ", preCacheTimeMs=" + this.b + ", durationMs=" + this.c + ", rollingDurationMs=" + this.d + ", textSizeScale=" + this.e + ", timeFactor=" + this.f + ", screenPart=" + this.g + ", alpha=" + this.h + ", bold=" + this.i + ", density=" + this.j + ", visibility=" + this.k + ", allowOverlap=" + this.l + ", visibilityGeneration=" + this.m + ", layoutGeneration=" + this.n + ", cacheGeneration=" + this.o + ", measureGeneration=" + this.p + ", filterGeneration=" + this.q + ", retainerGeneration=" + this.r + ", renderGeneration=" + this.s + ", firstShownGeneration=" + this.t + ", dataFilter=" + this.u + ", layoutFilter=" + this.v + ')';
        }
        return (String) invokeV.objValue;
    }

    public final float u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.g : invokeV.floatValue;
    }

    public final float v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.e : invokeV.floatValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public final int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.m : invokeV.intValue;
    }

    public final void y(List<? extends y26> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.u = list;
        }
    }

    public final void z(List<? extends Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.v = list;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ b26(int i, long j, long j2, long j3, float f, float f2, float f3, float f4, boolean z, int i2, boolean z2, boolean z3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, List list, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r5, (i11 & 8) != 0 ? r5 : j3, (i11 & 16) != 0 ? 1.0f : f, (i11 & 32) != 0 ? 1.0f : f2, (i11 & 64) != 0 ? 1.0f : f3, (i11 & 128) == 0 ? f4 : 1.0f, (i11 & 256) != 0 ? false : z, (i11 & 512) != 0 ? 160 : i2, (i11 & 1024) != 0 ? true : z2, (i11 & 2048) != 0 ? false : z3, (i11 & 4096) != 0 ? 0 : i3, (i11 & 8192) != 0 ? 0 : i4, (i11 & 16384) != 0 ? 0 : i5, (i11 & 32768) != 0 ? 0 : i6, (i11 & 65536) != 0 ? 0 : i7, (i11 & 131072) != 0 ? 0 : i8, (i11 & 262144) != 0 ? 0 : i9, (i11 & 524288) != 0 ? 0 : i10, (i11 & 1048576) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i11 & 2097152) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
        int i12 = (i11 & 1) != 0 ? 1 : i;
        long j4 = (i11 & 2) != 0 ? 100L : j;
        long j5 = (i11 & 4) != 0 ? 13000L : j2;
    }
}
