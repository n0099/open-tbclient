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
    public final d.f.b.a.i0.l f70051a;

    /* renamed from: b  reason: collision with root package name */
    public d.f.b.a.a0.m f70052b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f70053c;

    /* renamed from: d  reason: collision with root package name */
    public long f70054d;

    /* renamed from: e  reason: collision with root package name */
    public int f70055e;

    /* renamed from: f  reason: collision with root package name */
    public int f70056f;

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
        this.f70051a = new d.f.b.a.i0.l(10);
    }

    @Override // d.f.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f70053c = false;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void c(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) && this.f70053c) {
            int a2 = lVar.a();
            int i2 = this.f70056f;
            if (i2 < 10) {
                int min = Math.min(a2, 10 - i2);
                System.arraycopy(lVar.f70943a, lVar.c(), this.f70051a.f70943a, this.f70056f, min);
                if (this.f70056f + min == 10) {
                    this.f70051a.J(0);
                    if (73 == this.f70051a.x() && 68 == this.f70051a.x() && 51 == this.f70051a.x()) {
                        this.f70051a.K(3);
                        this.f70055e = this.f70051a.w() + 10;
                    } else {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.f70053c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a2, this.f70055e - this.f70056f);
            this.f70052b.a(lVar, min2);
            this.f70056f += min2;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void d() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f70053c && (i2 = this.f70055e) != 0 && this.f70056f == i2) {
            this.f70052b.c(this.f70054d, 1, i2, 0, null);
            this.f70053c = false;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && z) {
            this.f70053c = true;
            this.f70054d = j;
            this.f70055e = 0;
            this.f70056f = 0;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void f(d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gVar, dVar) == null) {
            dVar.a();
            d.f.b.a.a0.m a2 = gVar.a(dVar.c(), 4);
            this.f70052b = a2;
            a2.b(Format.createSampleFormat(dVar.b(), "application/id3", null, -1, null));
        }
    }
}
