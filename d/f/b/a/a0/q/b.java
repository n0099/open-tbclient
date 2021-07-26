package d.f.b.a.a0.q;

import android.util.Log;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import d.f.b.a.a0.q.a;
import d.f.b.a.a0.q.d;
import d.f.b.a.i0.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f69770a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f69771b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f69772c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f69773d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f69774e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f69775f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f69776g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f69777a;

        /* renamed from: b  reason: collision with root package name */
        public int f69778b;

        /* renamed from: c  reason: collision with root package name */
        public int f69779c;

        /* renamed from: d  reason: collision with root package name */
        public long f69780d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f69781e;

        /* renamed from: f  reason: collision with root package name */
        public final d.f.b.a.i0.l f69782f;

        /* renamed from: g  reason: collision with root package name */
        public final d.f.b.a.i0.l f69783g;

        /* renamed from: h  reason: collision with root package name */
        public int f69784h;

        /* renamed from: i  reason: collision with root package name */
        public int f69785i;

        public a(d.f.b.a.i0.l lVar, d.f.b.a.i0.l lVar2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, lVar2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69783g = lVar;
            this.f69782f = lVar2;
            this.f69781e = z;
            lVar2.J(12);
            this.f69777a = lVar2.B();
            lVar.J(12);
            this.f69785i = lVar.B();
            d.f.b.a.i0.a.g(lVar.i() == 1, "first_chunk must be 1");
            this.f69778b = -1;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f69778b + 1;
                this.f69778b = i2;
                if (i2 == this.f69777a) {
                    return false;
                }
                this.f69780d = this.f69781e ? this.f69782f.C() : this.f69782f.z();
                if (this.f69778b == this.f69784h) {
                    this.f69779c = this.f69783g.B();
                    this.f69783g.K(4);
                    int i3 = this.f69785i - 1;
                    this.f69785i = i3;
                    this.f69784h = i3 > 0 ? this.f69783g.B() - 1 : -1;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: d.f.b.a.a0.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1972b {
        int a();

        int b();

        boolean c();
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final k[] f69786a;

        /* renamed from: b  reason: collision with root package name */
        public Format f69787b;

        /* renamed from: c  reason: collision with root package name */
        public int f69788c;

        /* renamed from: d  reason: collision with root package name */
        public int f69789d;

        public c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69786a = new k[i2];
            this.f69789d = 0;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements InterfaceC1972b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f69790a;

        /* renamed from: b  reason: collision with root package name */
        public final int f69791b;

        /* renamed from: c  reason: collision with root package name */
        public final d.f.b.a.i0.l f69792c;

        public d(a.b bVar) {
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
            d.f.b.a.i0.l lVar = bVar.P0;
            this.f69792c = lVar;
            lVar.J(12);
            this.f69790a = this.f69792c.B();
            this.f69791b = this.f69792c.B();
        }

        @Override // d.f.b.a.a0.q.b.InterfaceC1972b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f69790a;
                return i2 == 0 ? this.f69792c.B() : i2;
            }
            return invokeV.intValue;
        }

        @Override // d.f.b.a.a0.q.b.InterfaceC1972b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69791b : invokeV.intValue;
        }

        @Override // d.f.b.a.a0.q.b.InterfaceC1972b
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69790a != 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements InterfaceC1972b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.f.b.a.i0.l f69793a;

        /* renamed from: b  reason: collision with root package name */
        public final int f69794b;

        /* renamed from: c  reason: collision with root package name */
        public final int f69795c;

        /* renamed from: d  reason: collision with root package name */
        public int f69796d;

        /* renamed from: e  reason: collision with root package name */
        public int f69797e;

        public e(a.b bVar) {
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
            d.f.b.a.i0.l lVar = bVar.P0;
            this.f69793a = lVar;
            lVar.J(12);
            this.f69795c = this.f69793a.B() & 255;
            this.f69794b = this.f69793a.B();
        }

        @Override // d.f.b.a.a0.q.b.InterfaceC1972b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f69795c;
                if (i2 == 8) {
                    return this.f69793a.x();
                }
                if (i2 == 16) {
                    return this.f69793a.D();
                }
                int i3 = this.f69796d;
                this.f69796d = i3 + 1;
                if (i3 % 2 == 0) {
                    int x = this.f69793a.x();
                    this.f69797e = x;
                    return (x & 240) >> 4;
                }
                return this.f69797e & 15;
            }
            return invokeV.intValue;
        }

        @Override // d.f.b.a.a0.q.b.InterfaceC1972b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69794b : invokeV.intValue;
        }

        @Override // d.f.b.a.a0.q.b.InterfaceC1972b
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f69798a;

        /* renamed from: b  reason: collision with root package name */
        public final long f69799b;

        /* renamed from: c  reason: collision with root package name */
        public final int f69800c;

        public f(int i2, long j, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69798a = i2;
            this.f69799b = j;
            this.f69800c = i3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1942639388, "Ld/f/b/a/a0/q/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1942639388, "Ld/f/b/a/a0/q/b;");
                return;
            }
        }
        f69770a = v.q("vide");
        f69771b = v.q("soun");
        f69772c = v.q("text");
        f69773d = v.q("sbtl");
        f69774e = v.q("subt");
        f69775f = v.q("clcp");
        v.q("cenc");
        f69776g = v.q("meta");
    }

    public static int a(d.f.b.a.i0.l lVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, lVar, i2, i3)) == null) {
            int c2 = lVar.c();
            while (c2 - i2 < i3) {
                lVar.J(c2);
                int i4 = lVar.i();
                d.f.b.a.i0.a.b(i4 > 0, "childAtomSize should be positive");
                if (lVar.i() == d.f.b.a.a0.q.a.K) {
                    return c2;
                }
                c2 += i4;
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public static void b(d.f.b.a.i0.l lVar, int i2, int i3, int i4, int i5, String str, boolean z, DrmInitData drmInitData, c cVar, int i6) throws ParserException {
        int i7;
        int i8;
        int i9;
        String str2;
        int i10;
        int i11;
        String str3;
        String str4;
        DrmInitData drmInitData2;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z), drmInitData, cVar, Integer.valueOf(i6)}) == null) {
            int i13 = i3;
            DrmInitData drmInitData3 = drmInitData;
            lVar.J(i13 + 8 + 8);
            if (z) {
                i7 = lVar.D();
                lVar.K(6);
            } else {
                lVar.K(8);
                i7 = 0;
            }
            if (i7 == 0 || i7 == 1) {
                int D = lVar.D();
                lVar.K(6);
                int y = lVar.y();
                if (i7 == 1) {
                    lVar.K(16);
                }
                i8 = y;
                i9 = D;
            } else if (i7 != 2) {
                return;
            } else {
                lVar.K(16);
                i8 = (int) Math.round(lVar.h());
                i9 = lVar.B();
                lVar.K(20);
            }
            int c2 = lVar.c();
            int i14 = i2;
            if (i14 == d.f.b.a.a0.q.a.b0) {
                Pair<Integer, k> n = n(lVar, i13, i4);
                if (n != null) {
                    i14 = ((Integer) n.first).intValue();
                    drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((k) n.second).f69861a);
                    cVar.f69786a[i6] = (k) n.second;
                }
                lVar.J(c2);
            }
            DrmInitData drmInitData4 = drmInitData3;
            String str5 = "audio/raw";
            if (i14 == d.f.b.a.a0.q.a.o) {
                str2 = "audio/ac3";
            } else if (i14 == d.f.b.a.a0.q.a.q) {
                str2 = "audio/eac3";
            } else if (i14 == d.f.b.a.a0.q.a.s) {
                str2 = "audio/vnd.dts";
            } else if (i14 == d.f.b.a.a0.q.a.t || i14 == d.f.b.a.a0.q.a.u) {
                str2 = "audio/vnd.dts.hd";
            } else if (i14 == d.f.b.a.a0.q.a.v) {
                str2 = "audio/vnd.dts.hd;profile=lbr";
            } else if (i14 == d.f.b.a.a0.q.a.y0) {
                str2 = "audio/3gpp";
            } else if (i14 == d.f.b.a.a0.q.a.z0) {
                str2 = "audio/amr-wb";
            } else if (i14 == d.f.b.a.a0.q.a.m || i14 == d.f.b.a.a0.q.a.n) {
                str2 = "audio/raw";
            } else if (i14 == d.f.b.a.a0.q.a.k) {
                str2 = "audio/mpeg";
            } else {
                str2 = i14 == d.f.b.a.a0.q.a.O0 ? "audio/alac" : null;
            }
            String str6 = str2;
            int i15 = i9;
            int i16 = i8;
            int i17 = c2;
            byte[] bArr = null;
            while (i17 - i13 < i4) {
                lVar.J(i17);
                int i18 = lVar.i();
                d.f.b.a.i0.a.b(i18 > 0, "childAtomSize should be positive");
                int i19 = lVar.i();
                if (i19 != d.f.b.a.a0.q.a.K && (!z || i19 != d.f.b.a.a0.q.a.l)) {
                    if (i19 == d.f.b.a.a0.q.a.p) {
                        lVar.J(i17 + 8);
                        cVar.f69787b = d.f.b.a.x.a.c(lVar, Integer.toString(i5), str, drmInitData4);
                    } else if (i19 == d.f.b.a.a0.q.a.r) {
                        lVar.J(i17 + 8);
                        cVar.f69787b = d.f.b.a.x.a.f(lVar, Integer.toString(i5), str, drmInitData4);
                    } else {
                        if (i19 == d.f.b.a.a0.q.a.w) {
                            i12 = i17;
                            str3 = str6;
                            str4 = str5;
                            drmInitData2 = drmInitData4;
                            cVar.f69787b = Format.createAudioSampleFormat(Integer.toString(i5), str6, null, -1, -1, i15, i16, null, drmInitData2, 0, str);
                            i10 = i18;
                        } else {
                            i12 = i17;
                            str3 = str6;
                            str4 = str5;
                            drmInitData2 = drmInitData4;
                            i10 = i18;
                            if (i19 == d.f.b.a.a0.q.a.O0) {
                                byte[] bArr2 = new byte[i10];
                                i11 = i12;
                                lVar.J(i11);
                                lVar.g(bArr2, 0, i10);
                                bArr = bArr2;
                            }
                        }
                        i11 = i12;
                    }
                    i10 = i18;
                    i11 = i17;
                    str3 = str6;
                    str4 = str5;
                    drmInitData2 = drmInitData4;
                } else {
                    i10 = i18;
                    i11 = i17;
                    str3 = str6;
                    str4 = str5;
                    drmInitData2 = drmInitData4;
                    int a2 = i19 == d.f.b.a.a0.q.a.K ? i11 : a(lVar, i11, i10);
                    if (a2 != -1) {
                        Pair<String, byte[]> e2 = e(lVar, a2);
                        str6 = (String) e2.first;
                        bArr = (byte[]) e2.second;
                        if ("audio/mp4a-latm".equals(str6)) {
                            Pair<Integer, Integer> i20 = d.f.b.a.i0.c.i(bArr);
                            i16 = ((Integer) i20.first).intValue();
                            i15 = ((Integer) i20.second).intValue();
                        }
                        i17 = i11 + i10;
                        i13 = i3;
                        drmInitData4 = drmInitData2;
                        str5 = str4;
                    }
                }
                str6 = str3;
                i17 = i11 + i10;
                i13 = i3;
                drmInitData4 = drmInitData2;
                str5 = str4;
            }
            String str7 = str6;
            String str8 = str5;
            DrmInitData drmInitData5 = drmInitData4;
            if (cVar.f69787b != null || str7 == null) {
                return;
            }
            cVar.f69787b = Format.createAudioSampleFormat(Integer.toString(i5), str7, null, -1, -1, i15, i16, str8.equals(str7) ? 2 : -1, bArr != null ? Collections.singletonList(bArr) : null, drmInitData5, 0, str);
        }
    }

    public static Pair<Integer, k> c(d.f.b.a.i0.l lVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, lVar, i2, i3)) == null) {
            int i4 = i2 + 8;
            String str = null;
            Integer num = null;
            int i5 = -1;
            int i6 = 0;
            while (i4 - i2 < i3) {
                lVar.J(i4);
                int i7 = lVar.i();
                int i8 = lVar.i();
                if (i8 == d.f.b.a.a0.q.a.c0) {
                    num = Integer.valueOf(lVar.i());
                } else if (i8 == d.f.b.a.a0.q.a.X) {
                    lVar.K(4);
                    str = lVar.u(4);
                } else if (i8 == d.f.b.a.a0.q.a.Y) {
                    i5 = i4;
                    i6 = i7;
                }
                i4 += i7;
            }
            if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                d.f.b.a.i0.a.b(num != null, "frma atom is mandatory");
                d.f.b.a.i0.a.b(i5 != -1, "schi atom is mandatory");
                k o = o(lVar, i5, i6, str);
                d.f.b.a.i0.a.b(o != null, "tenc atom is mandatory");
                return Pair.create(num, o);
            }
            return null;
        }
        return (Pair) invokeLII.objValue;
    }

    public static Pair<long[], long[]> d(a.C1971a c1971a) {
        InterceptResult invokeL;
        a.b g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c1971a)) == null) {
            if (c1971a != null && (g2 = c1971a.g(d.f.b.a.a0.q.a.R)) != null) {
                d.f.b.a.i0.l lVar = g2.P0;
                lVar.J(8);
                int c2 = d.f.b.a.a0.q.a.c(lVar.i());
                int B = lVar.B();
                long[] jArr = new long[B];
                long[] jArr2 = new long[B];
                for (int i2 = 0; i2 < B; i2++) {
                    jArr[i2] = c2 == 1 ? lVar.C() : lVar.z();
                    jArr2[i2] = c2 == 1 ? lVar.q() : lVar.i();
                    if (lVar.t() == 1) {
                        lVar.K(2);
                    } else {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                }
                return Pair.create(jArr, jArr2);
            }
            return Pair.create(null, null);
        }
        return (Pair) invokeL.objValue;
    }

    public static Pair<String, byte[]> e(d.f.b.a.i0.l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, lVar, i2)) == null) {
            lVar.J(i2 + 8 + 4);
            lVar.K(1);
            f(lVar);
            lVar.K(2);
            int x = lVar.x();
            if ((x & 128) != 0) {
                lVar.K(2);
            }
            if ((x & 64) != 0) {
                lVar.K(lVar.D());
            }
            if ((x & 32) != 0) {
                lVar.K(2);
            }
            lVar.K(1);
            f(lVar);
            int x2 = lVar.x();
            String str = null;
            if (x2 == 32) {
                str = "video/mp4v-es";
            } else if (x2 == 33) {
                str = "video/avc";
            } else if (x2 != 35) {
                if (x2 != 64) {
                    if (x2 == 107) {
                        return Pair.create("audio/mpeg", null);
                    }
                    if (x2 == 96 || x2 == 97) {
                        str = "video/mpeg2";
                    } else if (x2 == 165) {
                        str = "audio/ac3";
                    } else if (x2 != 166) {
                        switch (x2) {
                            case 102:
                            case 103:
                            case 104:
                                break;
                            default:
                                switch (x2) {
                                    case Opcodes.RET /* 169 */:
                                    case 172:
                                        return Pair.create("audio/vnd.dts", null);
                                    case Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID /* 170 */:
                                    case Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID /* 171 */:
                                        return Pair.create("audio/vnd.dts.hd", null);
                                }
                        }
                    } else {
                        str = "audio/eac3";
                    }
                }
                str = "audio/mp4a-latm";
            } else {
                str = "video/hevc";
            }
            lVar.K(12);
            lVar.K(1);
            int f2 = f(lVar);
            byte[] bArr = new byte[f2];
            lVar.g(bArr, 0, f2);
            return Pair.create(str, bArr);
        }
        return (Pair) invokeLI.objValue;
    }

    public static int f(d.f.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, lVar)) == null) {
            int x = lVar.x();
            int i2 = x & 127;
            while ((x & 128) == 128) {
                x = lVar.x();
                i2 = (i2 << 7) | (x & 127);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int g(d.f.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, lVar)) == null) {
            lVar.J(16);
            int i2 = lVar.i();
            if (i2 == f69771b) {
                return 1;
            }
            if (i2 == f69770a) {
                return 2;
            }
            if (i2 == f69772c || i2 == f69773d || i2 == f69774e || i2 == f69775f) {
                return 3;
            }
            return i2 == f69776g ? 4 : -1;
        }
        return invokeL.intValue;
    }

    public static Metadata h(d.f.b.a.i0.l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, lVar, i2)) == null) {
            lVar.K(8);
            ArrayList arrayList = new ArrayList();
            while (lVar.c() < i2) {
                Metadata.Entry c2 = d.f.b.a.a0.q.f.c(lVar);
                if (c2 != null) {
                    arrayList.add(c2);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new Metadata(arrayList);
        }
        return (Metadata) invokeLI.objValue;
    }

    public static Pair<Long, String> i(d.f.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, lVar)) == null) {
            lVar.J(8);
            int c2 = d.f.b.a.a0.q.a.c(lVar.i());
            lVar.K(c2 == 0 ? 8 : 16);
            long z = lVar.z();
            lVar.K(c2 == 0 ? 4 : 8);
            int D = lVar.D();
            return Pair.create(Long.valueOf(z), "" + ((char) (((D >> 10) & 31) + 96)) + ((char) (((D >> 5) & 31) + 96)) + ((char) ((D & 31) + 96)));
        }
        return (Pair) invokeL.objValue;
    }

    public static Metadata j(d.f.b.a.i0.l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, lVar, i2)) == null) {
            lVar.K(12);
            while (lVar.c() < i2) {
                int c2 = lVar.c();
                int i3 = lVar.i();
                if (lVar.i() == d.f.b.a.a0.q.a.C0) {
                    lVar.J(c2);
                    return h(lVar, c2 + i3);
                }
                lVar.K(i3 - 8);
            }
            return null;
        }
        return (Metadata) invokeLI.objValue;
    }

    public static long k(d.f.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, lVar)) == null) {
            lVar.J(8);
            lVar.K(d.f.b.a.a0.q.a.c(lVar.i()) != 0 ? 16 : 8);
            return lVar.z();
        }
        return invokeL.longValue;
    }

    public static float l(d.f.b.a.i0.l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, lVar, i2)) == null) {
            lVar.J(i2 + 8);
            return lVar.B() / lVar.B();
        }
        return invokeLI.floatValue;
    }

    public static byte[] m(d.f.b.a.i0.l lVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65549, null, lVar, i2, i3)) == null) {
            int i4 = i2 + 8;
            while (i4 - i2 < i3) {
                lVar.J(i4);
                int i5 = lVar.i();
                if (lVar.i() == d.f.b.a.a0.q.a.J0) {
                    return Arrays.copyOfRange(lVar.f70943a, i4, i5 + i4);
                }
                i4 += i5;
            }
            return null;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static Pair<Integer, k> n(d.f.b.a.i0.l lVar, int i2, int i3) {
        InterceptResult invokeLII;
        Pair<Integer, k> c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65550, null, lVar, i2, i3)) == null) {
            int c3 = lVar.c();
            while (c3 - i2 < i3) {
                lVar.J(c3);
                int i4 = lVar.i();
                d.f.b.a.i0.a.b(i4 > 0, "childAtomSize should be positive");
                if (lVar.i() == d.f.b.a.a0.q.a.W && (c2 = c(lVar, c3, i4)) != null) {
                    return c2;
                }
                c3 += i4;
            }
            return null;
        }
        return (Pair) invokeLII.objValue;
    }

    public static k o(d.f.b.a.i0.l lVar, int i2, int i3, String str) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), str})) != null) {
            return (k) invokeCommon.objValue;
        }
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            lVar.J(i6);
            int i7 = lVar.i();
            if (lVar.i() == d.f.b.a.a0.q.a.Z) {
                int c2 = d.f.b.a.a0.q.a.c(lVar.i());
                lVar.K(1);
                if (c2 == 0) {
                    lVar.K(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int x = lVar.x();
                    i4 = x & 15;
                    i5 = (x & 240) >> 4;
                }
                boolean z = lVar.x() == 1;
                int x2 = lVar.x();
                byte[] bArr2 = new byte[16];
                lVar.g(bArr2, 0, 16);
                if (z && x2 == 0) {
                    int x3 = lVar.x();
                    bArr = new byte[x3];
                    lVar.g(bArr, 0, x3);
                }
                return new k(z, str, x2, bArr2, i5, i4, bArr);
            }
            i6 += i7;
        }
    }

    public static m p(j jVar, a.C1971a c1971a, d.f.b.a.a0.i iVar) throws ParserException {
        InterceptResult invokeLLL;
        InterfaceC1972b eVar;
        boolean z;
        int i2;
        int i3;
        j jVar2;
        int i4;
        String str;
        int[] iArr;
        long[] jArr;
        long[] jArr2;
        int[] iArr2;
        int i5;
        long j;
        long[] jArr3;
        int i6;
        int[] iArr3;
        int[] iArr4;
        boolean z2;
        int[] iArr5;
        long[] jArr4;
        int[] iArr6;
        int i7;
        int[] iArr7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, jVar, c1971a, iVar)) == null) {
            a.b g2 = c1971a.g(d.f.b.a.a0.q.a.q0);
            if (g2 != null) {
                eVar = new d(g2);
            } else {
                a.b g3 = c1971a.g(d.f.b.a.a0.q.a.r0);
                if (g3 != null) {
                    eVar = new e(g3);
                } else {
                    throw new ParserException("Track has no sample table size information");
                }
            }
            int b2 = eVar.b();
            if (b2 == 0) {
                return new m(new long[0], new int[0], 0, new long[0], new int[0]);
            }
            a.b g4 = c1971a.g(d.f.b.a.a0.q.a.s0);
            if (g4 == null) {
                g4 = c1971a.g(d.f.b.a.a0.q.a.t0);
                z = true;
            } else {
                z = false;
            }
            d.f.b.a.i0.l lVar = g4.P0;
            d.f.b.a.i0.l lVar2 = c1971a.g(d.f.b.a.a0.q.a.p0).P0;
            d.f.b.a.i0.l lVar3 = c1971a.g(d.f.b.a.a0.q.a.m0).P0;
            a.b g5 = c1971a.g(d.f.b.a.a0.q.a.n0);
            d.f.b.a.i0.l lVar4 = null;
            d.f.b.a.i0.l lVar5 = g5 != null ? g5.P0 : null;
            a.b g6 = c1971a.g(d.f.b.a.a0.q.a.o0);
            d.f.b.a.i0.l lVar6 = g6 != null ? g6.P0 : null;
            a aVar = new a(lVar2, lVar, z);
            lVar3.J(12);
            int B = lVar3.B() - 1;
            int B2 = lVar3.B();
            int B3 = lVar3.B();
            if (lVar6 != null) {
                lVar6.J(12);
                i2 = lVar6.B();
            } else {
                i2 = 0;
            }
            int i10 = -1;
            if (lVar5 != null) {
                lVar5.J(12);
                i3 = lVar5.B();
                if (i3 > 0) {
                    i10 = lVar5.B() - 1;
                    lVar4 = lVar5;
                }
            } else {
                lVar4 = lVar5;
                i3 = 0;
            }
            long j2 = 0;
            if (!(eVar.c() && "audio/raw".equals(jVar.f69857f.sampleMimeType) && B == 0 && i2 == 0 && i3 == 0)) {
                long[] jArr5 = new long[b2];
                int[] iArr8 = new int[b2];
                int i11 = i3;
                long[] jArr6 = new long[b2];
                iArr = new int[b2];
                int i12 = B3;
                long j3 = 0;
                j = 0;
                int i13 = B;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                int i19 = i11;
                int i20 = i10;
                int i21 = i2;
                int i22 = B2;
                while (i14 < b2) {
                    while (i17 == 0) {
                        d.f.b.a.i0.a.f(aVar.a());
                        j3 = aVar.f69780d;
                        i17 = aVar.f69779c;
                        i13 = i13;
                        i22 = i22;
                    }
                    int i23 = i13;
                    int i24 = i22;
                    if (lVar6 != null) {
                        while (i16 == 0 && i21 > 0) {
                            i16 = lVar6.B();
                            i18 = lVar6.i();
                            i21--;
                        }
                        i16--;
                    }
                    int i25 = i18;
                    jArr5[i14] = j3;
                    iArr8[i14] = eVar.a();
                    if (iArr8[i14] > i15) {
                        i15 = iArr8[i14];
                    }
                    int i26 = b2;
                    InterfaceC1972b interfaceC1972b = eVar;
                    jArr6[i14] = j + i25;
                    iArr[i14] = lVar4 == null ? 1 : 0;
                    if (i14 == i20) {
                        iArr[i14] = 1;
                        i19--;
                        if (i19 > 0) {
                            i20 = lVar4.B() - 1;
                        }
                    }
                    j += i12;
                    int i27 = i24 - 1;
                    if (i27 == 0 && i23 > 0) {
                        i23--;
                        i27 = lVar3.B();
                        i12 = lVar3.i();
                    }
                    int i28 = i27;
                    j3 += iArr8[i14];
                    i17--;
                    i14++;
                    eVar = interfaceC1972b;
                    b2 = i26;
                    i12 = i12;
                    i22 = i28;
                    i18 = i25;
                    i13 = i23;
                }
                i4 = b2;
                int i29 = i13;
                int i30 = i22;
                d.f.b.a.i0.a.a(i16 == 0);
                while (i21 > 0) {
                    d.f.b.a.i0.a.a(lVar6.B() == 0);
                    lVar6.i();
                    i21--;
                }
                if (i19 == 0 && i30 == 0) {
                    i9 = i17;
                    if (i9 == 0 && i29 == 0) {
                        jVar2 = jVar;
                        str = "AtomParsers";
                        jArr = jArr5;
                        jArr2 = jArr6;
                        iArr2 = iArr8;
                        i5 = i15;
                    }
                } else {
                    i9 = i17;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Inconsistent stbl box for track ");
                jVar2 = jVar;
                sb.append(jVar2.f69852a);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i19);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i30);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i9);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i29);
                String sb2 = sb.toString();
                str = "AtomParsers";
                Log.w(str, sb2);
                jArr = jArr5;
                jArr2 = jArr6;
                iArr2 = iArr8;
                i5 = i15;
            } else {
                jVar2 = jVar;
                i4 = b2;
                InterfaceC1972b interfaceC1972b2 = eVar;
                str = "AtomParsers";
                int i31 = aVar.f69777a;
                long[] jArr7 = new long[i31];
                int[] iArr9 = new int[i31];
                while (aVar.a()) {
                    int i32 = aVar.f69778b;
                    jArr7[i32] = aVar.f69780d;
                    iArr9[i32] = aVar.f69779c;
                }
                d.b a2 = d.f.b.a.a0.q.d.a(interfaceC1972b2.a(), jArr7, iArr9, B3);
                long[] jArr8 = a2.f69805a;
                int[] iArr10 = a2.f69806b;
                int i33 = a2.f69807c;
                long[] jArr9 = a2.f69808d;
                iArr = a2.f69809e;
                jArr = jArr8;
                jArr2 = jArr9;
                iArr2 = iArr10;
                i5 = i33;
                j = 0;
            }
            if (jVar2.f69859h != null && !iVar.a()) {
                long[] jArr10 = jVar2.f69859h;
                if (jArr10.length == 1 && jVar2.f69853b == 1 && jArr2.length >= 2) {
                    long j4 = jVar2.f69860i[0];
                    long F = v.F(jArr10[0], jVar2.f69854c, jVar2.f69855d) + j4;
                    if (jArr2[0] <= j4 && j4 < jArr2[1] && jArr2[jArr2.length - 1] < F && F <= j) {
                        long j5 = j - F;
                        long F2 = v.F(j4 - jArr2[0], jVar2.f69857f.sampleRate, jVar2.f69854c);
                        long F3 = v.F(j5, jVar2.f69857f.sampleRate, jVar2.f69854c);
                        if ((F2 != 0 || F3 != 0) && F2 <= 2147483647L && F3 <= 2147483647L) {
                            iVar.f69670a = (int) F2;
                            iVar.f69671b = (int) F3;
                            v.H(jArr2, 1000000L, jVar2.f69854c);
                            return new m(jArr, iArr2, i5, jArr2, iArr);
                        }
                    }
                }
                long[] jArr11 = jVar2.f69859h;
                if (jArr11.length == 1) {
                    char c2 = 0;
                    if (jArr11[0] == 0) {
                        int i34 = 0;
                        while (i34 < jArr2.length) {
                            jArr2[i34] = v.F(jArr2[i34] - jVar2.f69860i[c2], 1000000L, jVar2.f69854c);
                            i34++;
                            c2 = 0;
                        }
                        return new m(jArr, iArr2, i5, jArr2, iArr);
                    }
                }
                boolean z3 = jVar2.f69853b == 1;
                boolean z4 = false;
                int i35 = 0;
                int i36 = 0;
                int i37 = 0;
                while (true) {
                    long[] jArr12 = jVar2.f69859h;
                    if (i37 >= jArr12.length) {
                        break;
                    }
                    int[] iArr11 = iArr;
                    long j6 = jVar2.f69860i[i37];
                    if (j6 != -1) {
                        iArr7 = iArr2;
                        i8 = i5;
                        long F4 = v.F(jArr12[i37], jVar2.f69854c, jVar2.f69855d);
                        int b3 = v.b(jArr2, j6, true, true);
                        int b4 = v.b(jArr2, j6 + F4, z3, false);
                        i35 += b4 - b3;
                        z4 |= i36 != b3;
                        i36 = b4;
                    } else {
                        iArr7 = iArr2;
                        i8 = i5;
                    }
                    i37++;
                    iArr = iArr11;
                    iArr2 = iArr7;
                    i5 = i8;
                }
                int[] iArr12 = iArr;
                int[] iArr13 = iArr2;
                int i38 = i5;
                boolean z5 = z4 | (i35 != i4);
                long[] jArr13 = z5 ? new long[i35] : jArr;
                int[] iArr14 = z5 ? new int[i35] : iArr13;
                int i39 = z5 ? 0 : i38;
                int[] iArr15 = z5 ? new int[i35] : iArr12;
                long[] jArr14 = new long[i35];
                int i40 = i39;
                int i41 = 0;
                int i42 = 0;
                while (true) {
                    long[] jArr15 = jVar2.f69859h;
                    if (i41 >= jArr15.length) {
                        break;
                    }
                    int[] iArr16 = iArr14;
                    int[] iArr17 = iArr13;
                    long j7 = jVar2.f69860i[i41];
                    long j8 = jArr15[i41];
                    if (j7 != -1) {
                        i6 = i41;
                        int[] iArr18 = iArr15;
                        int b5 = v.b(jArr2, j7, true, true);
                        int b6 = v.b(jArr2, v.F(j8, jVar2.f69854c, jVar2.f69855d) + j7, z3, false);
                        if (z5) {
                            int i43 = b6 - b5;
                            System.arraycopy(jArr, b5, jArr13, i42, i43);
                            iArr3 = iArr17;
                            z2 = z3;
                            iArr5 = iArr16;
                            System.arraycopy(iArr3, b5, iArr5, i42, i43);
                            jArr3 = jArr13;
                            iArr4 = iArr12;
                            jArr4 = jArr;
                            iArr6 = iArr18;
                            System.arraycopy(iArr4, b5, iArr6, i42, i43);
                        } else {
                            jArr3 = jArr13;
                            iArr3 = iArr17;
                            iArr4 = iArr12;
                            z2 = z3;
                            jArr4 = jArr;
                            iArr6 = iArr18;
                            iArr5 = iArr16;
                        }
                        int i44 = i40;
                        while (b5 < b6) {
                            int i45 = b6;
                            int i46 = i44;
                            long j9 = j7;
                            jArr14[i42] = v.F(j2, 1000000L, jVar2.f69855d) + v.F(jArr2[b5] - j7, 1000000L, jVar2.f69854c);
                            if (z5) {
                                i7 = i46;
                                if (iArr5[i42] > i7) {
                                    i44 = iArr3[b5];
                                    i42++;
                                    b5++;
                                    b6 = i45;
                                    j7 = j9;
                                }
                            } else {
                                i7 = i46;
                            }
                            i44 = i7;
                            i42++;
                            b5++;
                            b6 = i45;
                            j7 = j9;
                        }
                        i40 = i44;
                    } else {
                        jArr3 = jArr13;
                        i6 = i41;
                        iArr3 = iArr17;
                        iArr4 = iArr12;
                        z2 = z3;
                        iArr5 = iArr16;
                        jArr4 = jArr;
                        iArr6 = iArr15;
                    }
                    j2 += j8;
                    i41 = i6 + 1;
                    iArr14 = iArr5;
                    iArr13 = iArr3;
                    iArr15 = iArr6;
                    z3 = z2;
                    jArr = jArr4;
                    iArr12 = iArr4;
                    jArr13 = jArr3;
                }
                long[] jArr16 = jArr13;
                int[] iArr19 = iArr14;
                int[] iArr20 = iArr13;
                int[] iArr21 = iArr12;
                long[] jArr17 = jArr;
                int[] iArr22 = iArr15;
                boolean z6 = false;
                for (int i47 = 0; i47 < iArr22.length && !z6; i47++) {
                    z6 |= (iArr22[i47] & 1) != 0;
                }
                if (!z6) {
                    Log.w(str, "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
                    v.H(jArr2, 1000000L, jVar2.f69854c);
                    return new m(jArr17, iArr20, i38, jArr2, iArr21);
                }
                return new m(jArr16, iArr19, i40, jArr14, iArr22);
            }
            long[] jArr18 = jArr;
            int[] iArr23 = iArr2;
            int i48 = i5;
            v.H(jArr2, 1000000L, jVar2.f69854c);
            return new m(jArr18, iArr23, i48, jArr2, iArr);
        }
        return (m) invokeLLL.objValue;
    }

    public static c q(d.f.b.a.i0.l lVar, int i2, int i3, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), str, drmInitData, Boolean.valueOf(z)})) == null) {
            lVar.J(12);
            int i4 = lVar.i();
            c cVar = new c(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                int c2 = lVar.c();
                int i6 = lVar.i();
                d.f.b.a.i0.a.b(i6 > 0, "childAtomSize should be positive");
                int i7 = lVar.i();
                if (i7 != d.f.b.a.a0.q.a.f69762c && i7 != d.f.b.a.a0.q.a.f69763d && i7 != d.f.b.a.a0.q.a.a0 && i7 != d.f.b.a.a0.q.a.l0 && i7 != d.f.b.a.a0.q.a.f69764e && i7 != d.f.b.a.a0.q.a.f69765f && i7 != d.f.b.a.a0.q.a.f69766g && i7 != d.f.b.a.a0.q.a.K0 && i7 != d.f.b.a.a0.q.a.L0) {
                    if (i7 != d.f.b.a.a0.q.a.j && i7 != d.f.b.a.a0.q.a.b0 && i7 != d.f.b.a.a0.q.a.o && i7 != d.f.b.a.a0.q.a.q && i7 != d.f.b.a.a0.q.a.s && i7 != d.f.b.a.a0.q.a.v && i7 != d.f.b.a.a0.q.a.t && i7 != d.f.b.a.a0.q.a.u && i7 != d.f.b.a.a0.q.a.y0 && i7 != d.f.b.a.a0.q.a.z0 && i7 != d.f.b.a.a0.q.a.m && i7 != d.f.b.a.a0.q.a.n && i7 != d.f.b.a.a0.q.a.k && i7 != d.f.b.a.a0.q.a.O0) {
                        if (i7 != d.f.b.a.a0.q.a.k0 && i7 != d.f.b.a.a0.q.a.u0 && i7 != d.f.b.a.a0.q.a.v0 && i7 != d.f.b.a.a0.q.a.w0 && i7 != d.f.b.a.a0.q.a.x0) {
                            if (i7 == d.f.b.a.a0.q.a.N0) {
                                cVar.f69787b = Format.createSampleFormat(Integer.toString(i2), "application/x-camera-motion", null, -1, null);
                            }
                        } else {
                            r(lVar, i7, c2, i6, i2, str, cVar);
                        }
                    } else {
                        b(lVar, i7, c2, i6, i2, str, z, drmInitData, cVar, i5);
                    }
                } else {
                    v(lVar, i7, c2, i6, i2, i3, drmInitData, cVar, i5);
                }
                lVar.J(c2 + i6);
            }
            return cVar;
        }
        return (c) invokeCommon.objValue;
    }

    public static void r(d.f.b.a.i0.l lVar, int i2, int i3, int i4, int i5, String str, c cVar) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, cVar}) == null) {
            lVar.J(i3 + 8 + 8);
            String str2 = "application/ttml+xml";
            List list = null;
            long j = Long.MAX_VALUE;
            if (i2 != d.f.b.a.a0.q.a.k0) {
                if (i2 == d.f.b.a.a0.q.a.u0) {
                    int i6 = (i4 - 8) - 8;
                    byte[] bArr = new byte[i6];
                    lVar.g(bArr, 0, i6);
                    list = Collections.singletonList(bArr);
                    str2 = "application/x-quicktime-tx3g";
                } else if (i2 == d.f.b.a.a0.q.a.v0) {
                    str2 = "application/x-mp4-vtt";
                } else if (i2 == d.f.b.a.a0.q.a.w0) {
                    j = 0;
                } else if (i2 == d.f.b.a.a0.q.a.x0) {
                    cVar.f69789d = 1;
                    str2 = "application/x-mp4-cea-608";
                } else {
                    throw new IllegalStateException();
                }
            }
            cVar.f69787b = Format.createTextSampleFormat(Integer.toString(i5), str2, null, -1, 0, str, -1, null, j, list);
        }
    }

    public static f s(d.f.b.a.i0.l lVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, lVar)) == null) {
            lVar.J(8);
            int c2 = d.f.b.a.a0.q.a.c(lVar.i());
            lVar.K(c2 == 0 ? 8 : 16);
            int i2 = lVar.i();
            lVar.K(4);
            int c3 = lVar.c();
            int i3 = c2 == 0 ? 4 : 8;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i5 >= i3) {
                    z = true;
                    break;
                } else if (lVar.f70943a[c3 + i5] != -1) {
                    z = false;
                    break;
                } else {
                    i5++;
                }
            }
            long j = -9223372036854775807L;
            if (z) {
                lVar.K(i3);
            } else {
                long z2 = c2 == 0 ? lVar.z() : lVar.C();
                if (z2 != 0) {
                    j = z2;
                }
            }
            lVar.K(16);
            int i6 = lVar.i();
            int i7 = lVar.i();
            lVar.K(4);
            int i8 = lVar.i();
            int i9 = lVar.i();
            if (i6 == 0 && i7 == 65536 && i8 == -65536 && i9 == 0) {
                i4 = 90;
            } else if (i6 == 0 && i7 == -65536 && i8 == 65536 && i9 == 0) {
                i4 = 270;
            } else if (i6 == -65536 && i7 == 0 && i8 == 0 && i9 == -65536) {
                i4 = 180;
            }
            return new f(i2, j, i4);
        }
        return (f) invokeL.objValue;
    }

    public static j t(a.C1971a c1971a, a.b bVar, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        InterceptResult invokeCommon;
        a.b bVar2;
        long j2;
        long[] jArr;
        long[] jArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{c1971a, bVar, Long.valueOf(j), drmInitData, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            a.C1971a f2 = c1971a.f(d.f.b.a.a0.q.a.F);
            int g2 = g(f2.g(d.f.b.a.a0.q.a.T).P0);
            if (g2 == -1) {
                return null;
            }
            f s = s(c1971a.g(d.f.b.a.a0.q.a.P).P0);
            if (j == -9223372036854775807L) {
                bVar2 = bVar;
                j2 = s.f69799b;
            } else {
                bVar2 = bVar;
                j2 = j;
            }
            long k = k(bVar2.P0);
            long F = j2 != -9223372036854775807L ? v.F(j2, 1000000L, k) : -9223372036854775807L;
            a.C1971a f3 = f2.f(d.f.b.a.a0.q.a.G).f(d.f.b.a.a0.q.a.H);
            Pair<Long, String> i2 = i(f2.g(d.f.b.a.a0.q.a.S).P0);
            c q = q(f3.g(d.f.b.a.a0.q.a.U).P0, s.f69798a, s.f69800c, (String) i2.second, drmInitData, z2);
            if (z) {
                jArr = null;
                jArr2 = null;
            } else {
                Pair<long[], long[]> d2 = d(c1971a.f(d.f.b.a.a0.q.a.Q));
                jArr2 = (long[]) d2.second;
                jArr = (long[]) d2.first;
            }
            if (q.f69787b == null) {
                return null;
            }
            return new j(s.f69798a, g2, ((Long) i2.first).longValue(), k, F, q.f69787b, q.f69789d, q.f69786a, q.f69788c, jArr, jArr2);
        }
        return (j) invokeCommon.objValue;
    }

    public static Metadata u(a.b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65557, null, bVar, z)) == null) {
            if (z) {
                return null;
            }
            d.f.b.a.i0.l lVar = bVar.P0;
            lVar.J(8);
            while (lVar.a() >= 8) {
                int c2 = lVar.c();
                int i2 = lVar.i();
                if (lVar.i() == d.f.b.a.a0.q.a.B0) {
                    lVar.J(c2);
                    return j(lVar, c2 + i2);
                }
                lVar.K(i2 - 8);
            }
            return null;
        }
        return (Metadata) invokeLZ.objValue;
    }

    public static void v(d.f.b.a.i0.l lVar, int i2, int i3, int i4, int i5, int i6, DrmInitData drmInitData, c cVar, int i7) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), drmInitData, cVar, Integer.valueOf(i7)}) == null) {
            DrmInitData drmInitData2 = drmInitData;
            lVar.J(i3 + 8 + 8);
            lVar.K(16);
            int D = lVar.D();
            int D2 = lVar.D();
            lVar.K(50);
            int c2 = lVar.c();
            String str = null;
            int i8 = i2;
            if (i8 == d.f.b.a.a0.q.a.a0) {
                Pair<Integer, k> n = n(lVar, i3, i4);
                if (n != null) {
                    i8 = ((Integer) n.first).intValue();
                    drmInitData2 = drmInitData2 == null ? null : drmInitData2.copyWithSchemeType(((k) n.second).f69861a);
                    cVar.f69786a[i7] = (k) n.second;
                }
                lVar.J(c2);
            }
            DrmInitData drmInitData3 = drmInitData2;
            List<byte[]> list = null;
            byte[] bArr = null;
            boolean z = false;
            float f2 = 1.0f;
            int i9 = -1;
            while (c2 - i3 < i4) {
                lVar.J(c2);
                int c3 = lVar.c();
                int i10 = lVar.i();
                if (i10 == 0 && lVar.c() - i3 == i4) {
                    break;
                }
                d.f.b.a.i0.a.b(i10 > 0, "childAtomSize should be positive");
                int i11 = lVar.i();
                if (i11 == d.f.b.a.a0.q.a.I) {
                    d.f.b.a.i0.a.f(str == null);
                    lVar.J(c3 + 8);
                    d.f.b.a.j0.a b2 = d.f.b.a.j0.a.b(lVar);
                    list = b2.f70998a;
                    cVar.f69788c = b2.f70999b;
                    if (!z) {
                        f2 = b2.f71002e;
                    }
                    str = "video/avc";
                } else if (i11 == d.f.b.a.a0.q.a.J) {
                    d.f.b.a.i0.a.f(str == null);
                    lVar.J(c3 + 8);
                    d.f.b.a.j0.b a2 = d.f.b.a.j0.b.a(lVar);
                    list = a2.f71003a;
                    cVar.f69788c = a2.f71004b;
                    str = "video/hevc";
                } else if (i11 == d.f.b.a.a0.q.a.M0) {
                    d.f.b.a.i0.a.f(str == null);
                    str = i8 == d.f.b.a.a0.q.a.K0 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else if (i11 == d.f.b.a.a0.q.a.f69767h) {
                    d.f.b.a.i0.a.f(str == null);
                    str = "video/3gpp";
                } else if (i11 == d.f.b.a.a0.q.a.K) {
                    d.f.b.a.i0.a.f(str == null);
                    Pair<String, byte[]> e2 = e(lVar, c3);
                    str = (String) e2.first;
                    list = Collections.singletonList(e2.second);
                } else if (i11 == d.f.b.a.a0.q.a.j0) {
                    f2 = l(lVar, c3);
                    z = true;
                } else if (i11 == d.f.b.a.a0.q.a.I0) {
                    bArr = m(lVar, c3, i10);
                } else if (i11 == d.f.b.a.a0.q.a.H0) {
                    int x = lVar.x();
                    lVar.K(3);
                    if (x == 0) {
                        int x2 = lVar.x();
                        if (x2 == 0) {
                            i9 = 0;
                        } else if (x2 == 1) {
                            i9 = 1;
                        } else if (x2 == 2) {
                            i9 = 2;
                        } else if (x2 == 3) {
                            i9 = 3;
                        }
                    }
                }
                c2 += i10;
            }
            if (str == null) {
                return;
            }
            cVar.f69787b = Format.createVideoSampleFormat(Integer.toString(i5), str, null, -1, -1, D, D2, -1.0f, list, i6, f2, bArr, i9, null, drmInitData3);
        }
    }
}
