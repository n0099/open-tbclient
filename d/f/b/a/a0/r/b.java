package d.f.b.a.a0.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.l;
import d.f.b.a.a0.r.h;
import d.f.b.a.i0.v;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes8.dex */
public final class b extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.f.b.a.i0.f n;
    public a o;

    /* loaded from: classes8.dex */
    public class a implements f, l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long[] f69436a;

        /* renamed from: b  reason: collision with root package name */
        public long[] f69437b;

        /* renamed from: c  reason: collision with root package name */
        public long f69438c;

        /* renamed from: d  reason: collision with root package name */
        public long f69439d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f69440e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69440e = bVar;
            this.f69438c = -1L;
            this.f69439d = -1L;
        }

        @Override // d.f.b.a.a0.r.f
        public long a(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                long j = this.f69439d;
                if (j >= 0) {
                    long j2 = -(j + 2);
                    this.f69439d = -1L;
                    return j2;
                }
                return -1L;
            }
            return invokeL.longValue;
        }

        @Override // d.f.b.a.a0.l
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // d.f.b.a.a0.l
        public long c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? this.f69438c + this.f69437b[v.e(this.f69436a, this.f69440e.b(j), true, true)] : invokeJ.longValue;
        }

        @Override // d.f.b.a.a0.r.f
        public l d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (l) invokeV.objValue;
        }

        @Override // d.f.b.a.a0.r.f
        public long e(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                long b2 = this.f69440e.b(j);
                this.f69439d = this.f69436a[v.e(this.f69436a, b2, true, true)];
                return b2;
            }
            return invokeJ.longValue;
        }

        public void f(d.f.b.a.i0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, lVar) == null) {
                lVar.K(1);
                int A = lVar.A() / 18;
                this.f69436a = new long[A];
                this.f69437b = new long[A];
                for (int i2 = 0; i2 < A; i2++) {
                    this.f69436a[i2] = lVar.q();
                    this.f69437b[i2] = lVar.q();
                    lVar.K(2);
                }
            }
        }

        @Override // d.f.b.a.a0.l
        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f69440e.n.b() : invokeV.longValue;
        }

        public void i(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                this.f69438c = j;
            }
        }
    }

    public b() {
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

    public static boolean n(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? bArr[0] == -1 : invokeL.booleanValue;
    }

    public static boolean o(d.f.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lVar)) == null) ? lVar.a() >= 5 && lVar.x() == 127 && lVar.z() == 1179402563 : invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.r.h
    public long e(d.f.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) {
            if (n(lVar.f70489a)) {
                return m(lVar);
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    @Override // d.f.b.a.a0.r.h
    public boolean h(d.f.b.a.i0.l lVar, long j, h.b bVar) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{lVar, Long.valueOf(j), bVar})) == null) {
            byte[] bArr = lVar.f70489a;
            if (this.n == null) {
                this.n = new d.f.b.a.i0.f(bArr, 17);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, lVar.d());
                copyOfRange[4] = ByteCompanionObject.MIN_VALUE;
                List singletonList = Collections.singletonList(copyOfRange);
                int a2 = this.n.a();
                d.f.b.a.i0.f fVar = this.n;
                bVar.f69467a = Format.createAudioSampleFormat(null, "audio/flac", null, -1, a2, fVar.f70464b, fVar.f70463a, singletonList, null, 0, null);
                return true;
            } else if ((bArr[0] & ByteCompanionObject.MAX_VALUE) == 3) {
                a aVar = new a(this);
                this.o = aVar;
                aVar.f(lVar);
                return true;
            } else if (n(bArr)) {
                a aVar2 = this.o;
                if (aVar2 != null) {
                    aVar2.i(j);
                    bVar.f69468b = this.o;
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.f.b.a.a0.r.h
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.j(z);
            if (z) {
                this.n = null;
                this.o = null;
            }
        }
    }

    public final int m(d.f.b.a.i0.l lVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lVar)) == null) {
            int i4 = (lVar.f70489a[2] & 255) >> 4;
            switch (i4) {
                case 1:
                    return 192;
                case 2:
                case 3:
                case 4:
                case 5:
                    i2 = PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE;
                    i3 = i4 - 2;
                    break;
                case 6:
                case 7:
                    lVar.K(4);
                    lVar.E();
                    int x = i4 == 6 ? lVar.x() : lVar.D();
                    lVar.J(0);
                    return x + 1;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    i2 = 256;
                    i3 = i4 - 8;
                    break;
                default:
                    return -1;
            }
            return i2 << i3;
        }
        return invokeL.intValue;
    }
}
