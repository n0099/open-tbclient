package d.f.b.a.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.w;
/* loaded from: classes8.dex */
public final class r extends w {
    public static /* synthetic */ Interceptable $ic;
    public static final Object j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final long f70297b;

    /* renamed from: c  reason: collision with root package name */
    public final long f70298c;

    /* renamed from: d  reason: collision with root package name */
    public final long f70299d;

    /* renamed from: e  reason: collision with root package name */
    public final long f70300e;

    /* renamed from: f  reason: collision with root package name */
    public final long f70301f;

    /* renamed from: g  reason: collision with root package name */
    public final long f70302g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f70303h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f70304i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(80769649, "Ld/f/b/a/d0/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(80769649, "Ld/f/b/a/d0/r;");
                return;
            }
        }
        j = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(long j2, boolean z) {
        this(j2, j2, 0L, 0L, z, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Boolean) objArr2[4]).booleanValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // d.f.b.a.w
    public int b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? j.equals(obj) ? 0 : -1 : invokeL.intValue;
    }

    @Override // d.f.b.a.w
    public w.b g(int i2, w.b bVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)})) == null) {
            d.f.b.a.i0.a.c(i2, 0, 1);
            Object obj = z ? j : null;
            bVar.n(obj, obj, 0, this.f70299d, -this.f70301f);
            return bVar;
        }
        return (w.b) invokeCommon.objValue;
    }

    @Override // d.f.b.a.w
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // d.f.b.a.w
    public w.c n(int i2, w.c cVar, boolean z, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
            d.f.b.a.i0.a.c(i2, 0, 1);
            Object obj = z ? j : null;
            long j3 = this.f70302g;
            if (this.f70304i) {
                j3 += j2;
                if (j3 > this.f70300e) {
                    j3 = -9223372036854775807L;
                }
            }
            cVar.d(obj, this.f70297b, this.f70298c, this.f70303h, this.f70304i, j3, this.f70300e, 0, 0, this.f70301f);
            return cVar;
        }
        return (w.c) invokeCommon.objValue;
    }

    @Override // d.f.b.a.w
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(long j2, long j3, long j4, long j5, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j2, j3, j4, j5, z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), ((Long) objArr2[5]).longValue(), ((Boolean) objArr2[6]).booleanValue(), ((Boolean) objArr2[7]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public r(long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70297b = j2;
        this.f70298c = j3;
        this.f70299d = j4;
        this.f70300e = j5;
        this.f70301f = j6;
        this.f70302g = j7;
        this.f70303h = z;
        this.f70304i = z2;
    }
}
