package d.f.b.a.a0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.a0.t.w;
/* loaded from: classes10.dex */
public final class s implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final r f72547a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.i0.l f72548b;

    /* renamed from: c  reason: collision with root package name */
    public int f72549c;

    /* renamed from: d  reason: collision with root package name */
    public int f72550d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f72551e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f72552f;

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
        this.f72547a = rVar;
        this.f72548b = new d.f.b.a.i0.l(32);
    }

    @Override // d.f.b.a.a0.t.w
    public void a(d.f.b.a.i0.s sVar, d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.f72547a.a(sVar, gVar, dVar);
            this.f72552f = true;
        }
    }

    @Override // d.f.b.a.a0.t.w
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f72552f = true;
        }
    }

    @Override // d.f.b.a.a0.t.w
    public void c(d.f.b.a.i0.l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, z) == null) {
            int c2 = z ? lVar.c() + lVar.x() : -1;
            if (this.f72552f) {
                if (!z) {
                    return;
                }
                this.f72552f = false;
                lVar.J(c2);
                this.f72550d = 0;
            }
            while (lVar.a() > 0) {
                int i2 = this.f72550d;
                if (i2 < 3) {
                    if (i2 == 0) {
                        int x = lVar.x();
                        lVar.J(lVar.c() - 1);
                        if (x == 255) {
                            this.f72552f = true;
                            return;
                        }
                    }
                    int min = Math.min(lVar.a(), 3 - this.f72550d);
                    lVar.g(this.f72548b.f73386a, this.f72550d, min);
                    int i3 = this.f72550d + min;
                    this.f72550d = i3;
                    if (i3 == 3) {
                        this.f72548b.G(3);
                        this.f72548b.K(1);
                        int x2 = this.f72548b.x();
                        int x3 = this.f72548b.x();
                        this.f72551e = (x2 & 128) != 0;
                        this.f72549c = (((x2 & 15) << 8) | x3) + 3;
                        int b2 = this.f72548b.b();
                        int i4 = this.f72549c;
                        if (b2 < i4) {
                            d.f.b.a.i0.l lVar2 = this.f72548b;
                            byte[] bArr = lVar2.f73386a;
                            lVar2.G(Math.min(4098, Math.max(i4, bArr.length * 2)));
                            System.arraycopy(bArr, 0, this.f72548b.f73386a, 0, 3);
                        }
                    }
                } else {
                    int min2 = Math.min(lVar.a(), this.f72549c - this.f72550d);
                    lVar.g(this.f72548b.f73386a, this.f72550d, min2);
                    int i5 = this.f72550d + min2;
                    this.f72550d = i5;
                    int i6 = this.f72549c;
                    if (i5 != i6) {
                        continue;
                    } else {
                        if (this.f72551e) {
                            if (d.f.b.a.i0.v.m(this.f72548b.f73386a, 0, i6, -1) != 0) {
                                this.f72552f = true;
                                return;
                            }
                            this.f72548b.G(this.f72549c - 4);
                        } else {
                            this.f72548b.G(i6);
                        }
                        this.f72547a.c(this.f72548b);
                        this.f72550d = 0;
                    }
                }
            }
        }
    }
}
