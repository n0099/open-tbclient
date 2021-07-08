package d.f.b.a.a0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.t.w;
/* loaded from: classes8.dex */
public final class u implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.f.b.a.i0.s f69658a;

    /* renamed from: b  reason: collision with root package name */
    public d.f.b.a.a0.m f69659b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69660c;

    public u() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.f.b.a.a0.t.r
    public void a(d.f.b.a.i0.s sVar, d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.f69658a = sVar;
            dVar.a();
            d.f.b.a.a0.m a2 = gVar.a(dVar.c(), 4);
            this.f69659b = a2;
            a2.b(Format.createSampleFormat(dVar.b(), "application/x-scte35", null, -1, null));
        }
    }

    @Override // d.f.b.a.a0.t.r
    public void c(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            if (!this.f69660c) {
                if (this.f69658a.e() == -9223372036854775807L) {
                    return;
                }
                this.f69659b.b(Format.createSampleFormat(null, "application/x-scte35", this.f69658a.e()));
                this.f69660c = true;
            }
            int a2 = lVar.a();
            this.f69659b.a(lVar, a2);
            this.f69659b.c(this.f69658a.d(), 1, a2, 0, null);
        }
    }
}
