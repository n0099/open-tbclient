package d.f.b.a.d0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.i0.v;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class m extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int l;
    public final Format m;
    public volatile int n;
    public volatile boolean o;
    public volatile boolean p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(d.f.b.a.h0.e eVar, d.f.b.a.h0.g gVar, Format format, int i2, Object obj, long j, long j2, int i3, int i4, Format format2) {
        super(eVar, gVar, format, i2, obj, j, j2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {eVar, gVar, format, Integer.valueOf(i2), obj, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), format2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.f.b.a.h0.e) objArr2[0], (d.f.b.a.h0.g) objArr2[1], (Format) objArr2[2], ((Integer) objArr2[3]).intValue(), objArr2[4], ((Long) objArr2[5]).longValue(), ((Long) objArr2[6]).longValue(), ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = i4;
        this.m = format2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void a() throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                long a2 = this.f69867h.a(this.f69860a.b(this.n));
                if (a2 != -1) {
                    a2 += this.n;
                }
                d.f.b.a.a0.b bVar = new d.f.b.a.a0.b(this.f69867h, this.n, a2);
                b i2 = i();
                i2.c(0L);
                d.f.b.a.a0.m a3 = i2.a(0, this.l);
                a3.b(this.m);
                for (int i3 = 0; i3 != -1; i3 = a3.d(bVar, Integer.MAX_VALUE, true)) {
                    this.n += i3;
                }
                a3.c(this.f69865f, 1, this.n, 0, null);
                v.h(this.f69867h);
                this.p = true;
            } catch (Throwable th) {
                v.h(this.f69867h);
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.o : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o = true;
        }
    }

    @Override // d.f.b.a.d0.u.c
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : invokeV.longValue;
    }

    @Override // d.f.b.a.d0.u.l
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : invokeV.booleanValue;
    }
}
