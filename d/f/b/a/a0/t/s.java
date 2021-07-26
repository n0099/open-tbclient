package d.f.b.a.a0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.a0.t.w;
/* loaded from: classes8.dex */
public final class s implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final r f70104a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.i0.l f70105b;

    /* renamed from: c  reason: collision with root package name */
    public int f70106c;

    /* renamed from: d  reason: collision with root package name */
    public int f70107d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f70108e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70109f;

    public s(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70104a = rVar;
        this.f70105b = new d.f.b.a.i0.l(32);
    }

    @Override // d.f.b.a.a0.t.w
    public void a(d.f.b.a.i0.s sVar, d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.f70104a.a(sVar, gVar, dVar);
            this.f70109f = true;
        }
    }

    @Override // d.f.b.a.a0.t.w
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70109f = true;
        }
    }

    @Override // d.f.b.a.a0.t.w
    public void c(d.f.b.a.i0.l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, z) == null) {
            int c2 = z ? lVar.c() + lVar.x() : -1;
            if (this.f70109f) {
                if (!z) {
                    return;
                }
                this.f70109f = false;
                lVar.J(c2);
                this.f70107d = 0;
            }
            while (lVar.a() > 0) {
                int i2 = this.f70107d;
                if (i2 < 3) {
                    if (i2 == 0) {
                        int x = lVar.x();
                        lVar.J(lVar.c() - 1);
                        if (x == 255) {
                            this.f70109f = true;
                            return;
                        }
                    }
                    int min = Math.min(lVar.a(), 3 - this.f70107d);
                    lVar.g(this.f70105b.f70943a, this.f70107d, min);
                    int i3 = this.f70107d + min;
                    this.f70107d = i3;
                    if (i3 == 3) {
                        this.f70105b.G(3);
                        this.f70105b.K(1);
                        int x2 = this.f70105b.x();
                        int x3 = this.f70105b.x();
                        this.f70108e = (x2 & 128) != 0;
                        this.f70106c = (((x2 & 15) << 8) | x3) + 3;
                        int b2 = this.f70105b.b();
                        int i4 = this.f70106c;
                        if (b2 < i4) {
                            d.f.b.a.i0.l lVar2 = this.f70105b;
                            byte[] bArr = lVar2.f70943a;
                            lVar2.G(Math.min(4098, Math.max(i4, bArr.length * 2)));
                            System.arraycopy(bArr, 0, this.f70105b.f70943a, 0, 3);
                        }
                    }
                } else {
                    int min2 = Math.min(lVar.a(), this.f70106c - this.f70107d);
                    lVar.g(this.f70105b.f70943a, this.f70107d, min2);
                    int i5 = this.f70107d + min2;
                    this.f70107d = i5;
                    int i6 = this.f70106c;
                    if (i5 != i6) {
                        continue;
                    } else {
                        if (this.f70108e) {
                            if (d.f.b.a.i0.v.m(this.f70105b.f70943a, 0, i6, -1) != 0) {
                                this.f70109f = true;
                                return;
                            }
                            this.f70105b.G(this.f70106c - 4);
                        } else {
                            this.f70105b.G(i6);
                        }
                        this.f70104a.c(this.f70105b);
                        this.f70107d = 0;
                    }
                }
            }
        }
    }
}
