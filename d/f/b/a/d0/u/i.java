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
public class i extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int l;
    public final long m;
    public final d n;
    public volatile int o;
    public volatile boolean p;
    public volatile boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d.f.b.a.h0.e eVar, d.f.b.a.h0.g gVar, Format format, int i2, Object obj, long j, long j2, int i3, int i4, long j3, d dVar) {
        super(eVar, gVar, format, i2, obj, j, j2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r5;
            Object[] objArr = {eVar, gVar, format, Integer.valueOf(i2), obj, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j3), dVar};
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
        this.m = j3;
        this.n = dVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void a() throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.f.b.a.h0.g b2 = this.f69860a.b(this.o);
            try {
                d.f.b.a.a0.b bVar = new d.f.b.a.a0.b(this.f69867h, b2.f70385c, this.f69867h.a(b2));
                if (this.o == 0) {
                    b i2 = i();
                    i2.c(this.m);
                    this.n.d(i2);
                }
                d.f.b.a.a0.e eVar = this.n.f69868e;
                int i3 = 0;
                while (i3 == 0 && !this.p) {
                    i3 = eVar.e(bVar, null);
                }
                d.f.b.a.i0.a.f(i3 != 1);
                this.o = (int) (bVar.getPosition() - this.f69860a.f70385c);
                v.h(this.f69867h);
                this.q = true;
            } catch (Throwable th) {
                v.h(this.f69867h);
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.p = true;
        }
    }

    @Override // d.f.b.a.d0.u.c
    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.o : invokeV.longValue;
    }

    @Override // d.f.b.a.d0.u.l
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f69891i + this.l : invokeV.intValue;
    }

    @Override // d.f.b.a.d0.u.l
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.booleanValue;
    }
}
