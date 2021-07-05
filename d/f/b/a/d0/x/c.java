package d.f.b.a.d0.x;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.d0.b;
import d.f.b.a.d0.e;
import d.f.b.a.d0.k;
import d.f.b.a.d0.o;
import d.f.b.a.d0.p;
import d.f.b.a.d0.s;
import d.f.b.a.d0.t;
import d.f.b.a.d0.u.f;
import d.f.b.a.d0.x.b;
import d.f.b.a.d0.x.e.a;
import d.f.b.a.h0.n;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class c implements k, p.a<f<b>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final b.a f72988e;

    /* renamed from: f  reason: collision with root package name */
    public final n f72989f;

    /* renamed from: g  reason: collision with root package name */
    public final int f72990g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a f72991h;

    /* renamed from: i  reason: collision with root package name */
    public final d.f.b.a.h0.b f72992i;
    public final t j;
    public final d.f.b.a.a0.q.k[] k;
    public k.a l;
    public d.f.b.a.d0.x.e.a m;
    public f<b>[] n;
    public e o;

    public c(d.f.b.a.d0.x.e.a aVar, b.a aVar2, int i2, b.a aVar3, n nVar, d.f.b.a.h0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, Integer.valueOf(i2), aVar3, nVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72988e = aVar2;
        this.f72989f = nVar;
        this.f72990g = i2;
        this.f72991h = aVar3;
        this.f72992i = bVar;
        this.j = f(aVar);
        a.C2013a c2013a = aVar.f73000b;
        if (c2013a != null) {
            this.k = new d.f.b.a.a0.q.k[]{new d.f.b.a.a0.q.k(true, null, 8, m(c2013a.f73005b), 0, 0, null)};
        } else {
            this.k = null;
        }
        this.m = aVar;
        f<b>[] n = n(0);
        this.n = n;
        this.o = new e(n);
    }

    public static t f(d.f.b.a.d0.x.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, aVar)) != null) {
            return (t) invokeL.objValue;
        }
        s[] sVarArr = new s[aVar.f73001c.length];
        int i2 = 0;
        while (true) {
            a.b[] bVarArr = aVar.f73001c;
            if (i2 < bVarArr.length) {
                sVarArr[i2] = new s(bVarArr[i2].f73008c);
                i2++;
            } else {
                return new t(sVarArr);
            }
        }
    }

    public static byte[] m(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < bArr.length; i2 += 2) {
                sb.append((char) bArr[i2]);
            }
            String sb2 = sb.toString();
            byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
            t(decode, 0, 3);
            t(decode, 1, 2);
            t(decode, 4, 5);
            t(decode, 6, 7);
            return decode;
        }
        return (byte[]) invokeL.objValue;
    }

    public static f<b>[] n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? new f[i2] : (f[]) invokeI.objValue;
    }

    public static void t(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65540, null, bArr, i2, i3) == null) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }
    }

    public final f<b> a(d.f.b.a.f0.f fVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, fVar, j)) == null) {
            int b2 = this.j.b(fVar.d());
            return new f<>(this.m.f73001c[b2].f73006a, null, this.f72988e.a(this.f72989f, this.m, b2, fVar, this.k), this, this.f72992i, j, this.f72990g, this.f72991h);
        }
        return (f) invokeLJ.objValue;
    }

    @Override // d.f.b.a.d0.k, d.f.b.a.d0.p
    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.o.b(j) : invokeJ.booleanValue;
    }

    @Override // d.f.b.a.d0.k, d.f.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o.c() : invokeV.longValue;
    }

    @Override // d.f.b.a.d0.k, d.f.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.o.d() : invokeV.longValue;
    }

    @Override // d.f.b.a.d0.k
    public long e(d.f.b.a.f0.f[] fVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{fVarArr, zArr, oVarArr, zArr2, Long.valueOf(j)})) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < fVarArr.length; i2++) {
                if (oVarArr[i2] != null) {
                    f fVar = (f) oVarArr[i2];
                    if (fVarArr[i2] != null && zArr[i2]) {
                        arrayList.add(fVar);
                    } else {
                        fVar.B();
                        oVarArr[i2] = null;
                    }
                }
                if (oVarArr[i2] == null && fVarArr[i2] != null) {
                    f<b> a2 = a(fVarArr[i2], j);
                    arrayList.add(a2);
                    oVarArr[i2] = a2;
                    zArr2[i2] = true;
                }
            }
            f<b>[] n = n(arrayList.size());
            this.n = n;
            arrayList.toArray(n);
            this.o = new e(this.n);
            return j;
        }
        return invokeCommon.longValue;
    }

    @Override // d.f.b.a.d0.k
    public long g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            for (f<b> fVar : this.n) {
                fVar.C(j);
            }
            return j;
        }
        return invokeJ.longValue;
    }

    @Override // d.f.b.a.d0.k
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return -9223372036854775807L;
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.d0.k
    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (t) invokeV.objValue;
    }

    @Override // d.f.b.a.d0.k
    public void o(k.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, aVar, j) == null) {
            this.l = aVar;
            aVar.l(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.b.a.d0.p.a
    /* renamed from: p */
    public void j(f<b> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.l.j(this);
        }
    }

    @Override // d.f.b.a.d0.k
    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f72989f.a();
        }
    }

    @Override // d.f.b.a.d0.k
    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (f<b> fVar : this.n) {
                fVar.B();
            }
        }
    }

    public void u(d.f.b.a.d0.x.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.m = aVar;
            for (f<b> fVar : this.n) {
                fVar.u().b(aVar);
            }
            this.l.j(this);
        }
    }
}
