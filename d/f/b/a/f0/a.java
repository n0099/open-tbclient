package d.f.b.a.f0;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.net.BdNetTask;
import com.google.android.exoplayer2.Format;
import d.f.b.a.d0.s;
import d.f.b.a.f0.f;
/* loaded from: classes10.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final d.f.b.a.h0.c f73206g;

    /* renamed from: h  reason: collision with root package name */
    public final int f73207h;

    /* renamed from: i  reason: collision with root package name */
    public final long f73208i;
    public final long j;
    public final float k;
    public final float l;
    public int m;
    public int n;

    /* renamed from: d.f.b.a.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C2018a implements f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.f.b.a.h0.c f73209a;

        /* renamed from: b  reason: collision with root package name */
        public final int f73210b;

        /* renamed from: c  reason: collision with root package name */
        public final int f73211c;

        /* renamed from: d  reason: collision with root package name */
        public final int f73212d;

        /* renamed from: e  reason: collision with root package name */
        public final int f73213e;

        /* renamed from: f  reason: collision with root package name */
        public final float f73214f;

        /* renamed from: g  reason: collision with root package name */
        public final float f73215g;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C2018a(d.f.b.a.h0.c cVar) {
            this(cVar, 800000, 10000, BdNetTask.TIMEOUT_READ, BdNetTask.TIMEOUT_READ, 0.75f, 0.75f);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((d.f.b.a.h0.c) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue(), ((Float) objArr2[6]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.b.a.f0.f.a
        /* renamed from: b */
        public a a(s sVar, int... iArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar, iArr)) == null) ? new a(sVar, iArr, this.f73209a, this.f73210b, this.f73211c, this.f73212d, this.f73213e, this.f73214f, this.f73215g) : (a) invokeLL.objValue;
        }

        public C2018a(d.f.b.a.h0.c cVar, int i2, int i3, int i4, int i5, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f73209a = cVar;
            this.f73210b = i2;
            this.f73211c = i3;
            this.f73212d = i4;
            this.f73213e = i5;
            this.f73214f = f2;
            this.f73215g = f3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(s sVar, int[] iArr, d.f.b.a.h0.c cVar, int i2, long j, long j2, long j3, float f2, float f3) {
        super(sVar, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {sVar, iArr, cVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((s) objArr2[0], (int[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73206g = cVar;
        this.f73207h = i2;
        this.f73208i = j * 1000;
        this.j = j2 * 1000;
        this.k = f2;
        this.l = f3;
        this.m = n(Long.MIN_VALUE);
        this.n = 1;
    }

    @Override // d.f.b.a.f0.f
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // d.f.b.a.f0.f
    public void i(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i2 = this.m;
            int n = n(elapsedRealtime);
            this.m = n;
            if (n == i2) {
                return;
            }
            if (!m(i2, elapsedRealtime)) {
                Format h2 = h(i2);
                Format h3 = h(this.m);
                if (h3.bitrate > h2.bitrate && j2 < o(j3)) {
                    this.m = i2;
                } else if (h3.bitrate < h2.bitrate && j2 >= this.j) {
                    this.m = i2;
                }
            }
            if (this.m != i2) {
                this.n = 3;
            }
        }
    }

    @Override // d.f.b.a.f0.f
    public Object j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    @Override // d.f.b.a.f0.f
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : invokeV.intValue;
    }

    public final int n(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            long c2 = this.f73206g.c();
            long j2 = c2 == -1 ? this.f73207h : ((float) c2) * this.k;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f73217b; i3++) {
                if (j == Long.MIN_VALUE || !m(i3, j)) {
                    if (h(i3).bitrate <= j2) {
                        return i3;
                    }
                    i2 = i3;
                }
            }
            return i2;
        }
        return invokeJ.intValue;
    }

    public final long o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            return (j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) != 0 && (j > this.f73208i ? 1 : (j == this.f73208i ? 0 : -1)) <= 0 ? ((float) j) * this.l : this.f73208i;
        }
        return invokeJ.longValue;
    }
}
