package d.f.b.a.a0.t;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.t.w;
/* loaded from: classes8.dex */
public final class l implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.i0.l f69597a;

    /* renamed from: b  reason: collision with root package name */
    public d.f.b.a.a0.m f69598b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69599c;

    /* renamed from: d  reason: collision with root package name */
    public long f69600d;

    /* renamed from: e  reason: collision with root package name */
    public int f69601e;

    /* renamed from: f  reason: collision with root package name */
    public int f69602f;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69597a = new d.f.b.a.i0.l(10);
    }

    @Override // d.f.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f69599c = false;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void c(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) && this.f69599c) {
            int a2 = lVar.a();
            int i2 = this.f69602f;
            if (i2 < 10) {
                int min = Math.min(a2, 10 - i2);
                System.arraycopy(lVar.f70489a, lVar.c(), this.f69597a.f70489a, this.f69602f, min);
                if (this.f69602f + min == 10) {
                    this.f69597a.J(0);
                    if (73 == this.f69597a.x() && 68 == this.f69597a.x() && 51 == this.f69597a.x()) {
                        this.f69597a.K(3);
                        this.f69601e = this.f69597a.w() + 10;
                    } else {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.f69599c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a2, this.f69601e - this.f69602f);
            this.f69598b.a(lVar, min2);
            this.f69602f += min2;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void d() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f69599c && (i2 = this.f69601e) != 0 && this.f69602f == i2) {
            this.f69598b.c(this.f69600d, 1, i2, 0, null);
            this.f69599c = false;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && z) {
            this.f69599c = true;
            this.f69600d = j;
            this.f69601e = 0;
            this.f69602f = 0;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void f(d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gVar, dVar) == null) {
            dVar.a();
            d.f.b.a.a0.m a2 = gVar.a(dVar.c(), 4);
            this.f69598b = a2;
            a2.b(Format.createSampleFormat(dVar.b(), "application/id3", null, -1, null));
        }
    }
}
