package d.f.b.a.a0.o;

import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import d.f.b.a.a0.h;
import d.f.b.a.a0.k;
import d.f.b.a.a0.l;
import d.f.b.a.a0.m;
import d.f.b.a.i0.g;
import d.f.b.a.i0.i;
import d.f.b.a.i0.j;
import d.f.b.a.i0.l;
import d.f.b.a.i0.v;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes8.dex */
public final class d implements d.f.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] Z;
    public static final byte[] a0;
    public static final byte[] b0;
    public static final byte[] c0;
    public static final byte[] d0;
    public static final UUID e0;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public g B;
    public g C;
    public boolean D;
    public int E;
    public long F;
    public long G;
    public int H;
    public int I;
    public int[] J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public byte S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public d.f.b.a.a0.g Y;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.a0.o.b f69261a;

    /* renamed from: b  reason: collision with root package name */
    public final f f69262b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<c> f69263c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f69264d;

    /* renamed from: e  reason: collision with root package name */
    public final l f69265e;

    /* renamed from: f  reason: collision with root package name */
    public final l f69266f;

    /* renamed from: g  reason: collision with root package name */
    public final l f69267g;

    /* renamed from: h  reason: collision with root package name */
    public final l f69268h;

    /* renamed from: i  reason: collision with root package name */
    public final l f69269i;
    public final l j;
    public final l k;
    public final l l;
    public final l m;
    public ByteBuffer n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public c t;
    public boolean u;
    public int v;
    public long w;
    public boolean x;
    public long y;
    public long z;

    /* loaded from: classes8.dex */
    public static class a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public final class b implements d.f.b.a.a0.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f69270a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69270a = dVar;
        }

        @Override // d.f.b.a.a0.o.c
        public void a(int i2) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f69270a.k(i2);
            }
        }

        @Override // d.f.b.a.a0.o.c
        public void b(int i2, double d2) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)}) == null) {
                this.f69270a.m(i2, d2);
            }
        }

        @Override // d.f.b.a.a0.o.c
        public void c(int i2, long j) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f69270a.o(i2, j);
            }
        }

        @Override // d.f.b.a.a0.o.c
        public void d(int i2, int i3, d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, fVar) == null) {
                this.f69270a.g(i2, i3, fVar);
            }
        }

        @Override // d.f.b.a.a0.o.c
        public void e(int i2, String str) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                this.f69270a.z(i2, str);
            }
        }

        @Override // d.f.b.a.a0.o.c
        public void f(int i2, long j, long j2) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f69270a.y(i2, j, j2);
            }
        }

        @Override // d.f.b.a.a0.o.c
        public int g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.f69270a.n(i2) : invokeI.intValue;
        }

        @Override // d.f.b.a.a0.o.c
        public boolean h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.f69270a.q(i2) : invokeI.booleanValue;
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this(dVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1942579868, "Ld/f/b/a/a0/o/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1942579868, "Ld/f/b/a/a0/o/d;");
                return;
            }
        }
        Z = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, UtilsBlink.VER_TYPE_SEPARATOR, UtilsBlink.VER_TYPE_SEPARATOR, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        a0 = new byte[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
        b0 = v.w("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        c0 = new byte[]{68, 105, 97, 108, 111, 103, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, Constants.SHORT_PING_CMD_TYPE, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        d0 = new byte[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
        e0 = new UUID(72057594037932032L, -9223371306706625679L);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(int i2) {
        this(new d.f.b.a.a0.o.a(), i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((d.f.b.a.a0.o.b) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int[] l(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, iArr, i2)) == null) {
            if (iArr == null) {
                return new int[i2];
            }
            return iArr.length >= i2 ? iArr : new int[Math.max(iArr.length * 2, i2)];
        }
        return (int[]) invokeLI.objValue;
    }

    public static boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str) : invokeL.booleanValue;
    }

    public static void x(byte[] bArr, long j, String str, int i2, long j2, byte[] bArr2) {
        byte[] w;
        byte[] bArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{bArr, Long.valueOf(j), str, Integer.valueOf(i2), Long.valueOf(j2), bArr2}) == null) {
            if (j == -9223372036854775807L) {
                w = bArr2;
                bArr3 = w;
            } else {
                int i3 = (int) (j / 3600000000L);
                long j3 = j - ((i3 * 3600) * 1000000);
                int i4 = (int) (j3 / 60000000);
                long j4 = j3 - ((i4 * 60) * 1000000);
                int i5 = (int) (j4 / 1000000);
                w = v.w(String.format(Locale.US, str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf((int) ((j4 - (i5 * 1000000)) / j2))));
                bArr3 = bArr2;
            }
            System.arraycopy(w, 0, bArr, i2, bArr3.length);
        }
    }

    public final void A(d.f.b.a.a0.f fVar, c cVar, int i2) throws IOException, InterruptedException {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, fVar, cVar, i2) == null) {
            if ("S_TEXT/UTF8".equals(cVar.f69271a)) {
                B(fVar, Z, i2);
            } else if ("S_TEXT/ASS".equals(cVar.f69271a)) {
                B(fVar, c0, i2);
            } else {
                m mVar = cVar.O;
                if (!this.O) {
                    if (cVar.f69275e) {
                        this.M &= -1073741825;
                        if (!this.P) {
                            fVar.readFully(this.f69267g.f70489a, 0, 1);
                            this.N++;
                            byte[] bArr = this.f69267g.f70489a;
                            if ((bArr[0] & ByteCompanionObject.MIN_VALUE) != 128) {
                                this.S = bArr[0];
                                this.P = true;
                            } else {
                                throw new ParserException("Extension bit is set in signal byte");
                            }
                        }
                        if ((this.S & 1) == 1) {
                            boolean z = (this.S & 2) == 2;
                            this.M |= 1073741824;
                            if (!this.Q) {
                                fVar.readFully(this.l.f70489a, 0, 8);
                                this.N += 8;
                                this.Q = true;
                                this.f69267g.f70489a[0] = (byte) ((z ? 128 : 0) | 8);
                                this.f69267g.J(0);
                                mVar.a(this.f69267g, 1);
                                this.V++;
                                this.l.J(0);
                                mVar.a(this.l, 8);
                                this.V += 8;
                            }
                            if (z) {
                                if (!this.R) {
                                    fVar.readFully(this.f69267g.f70489a, 0, 1);
                                    this.N++;
                                    this.f69267g.J(0);
                                    this.T = this.f69267g.x();
                                    this.R = true;
                                }
                                int i4 = this.T * 4;
                                this.f69267g.G(i4);
                                fVar.readFully(this.f69267g.f70489a, 0, i4);
                                this.N += i4;
                                short s = (short) ((this.T / 2) + 1);
                                int i5 = (s * 6) + 2;
                                ByteBuffer byteBuffer = this.n;
                                if (byteBuffer == null || byteBuffer.capacity() < i5) {
                                    this.n = ByteBuffer.allocate(i5);
                                }
                                this.n.position(0);
                                this.n.putShort(s);
                                int i6 = 0;
                                int i7 = 0;
                                while (true) {
                                    i3 = this.T;
                                    if (i6 >= i3) {
                                        break;
                                    }
                                    int B = this.f69267g.B();
                                    if (i6 % 2 == 0) {
                                        this.n.putShort((short) (B - i7));
                                    } else {
                                        this.n.putInt(B - i7);
                                    }
                                    i6++;
                                    i7 = B;
                                }
                                int i8 = (i2 - this.N) - i7;
                                if (i3 % 2 == 1) {
                                    this.n.putInt(i8);
                                } else {
                                    this.n.putShort((short) i8);
                                    this.n.putInt(0);
                                }
                                this.m.H(this.n.array(), i5);
                                mVar.a(this.m, i5);
                                this.V += i5;
                            }
                        }
                    } else {
                        byte[] bArr2 = cVar.f69276f;
                        if (bArr2 != null) {
                            this.j.H(bArr2, bArr2.length);
                        }
                    }
                    this.O = true;
                }
                int d2 = i2 + this.j.d();
                if (!"V_MPEG4/ISO/AVC".equals(cVar.f69271a) && !"V_MPEGH/ISO/HEVC".equals(cVar.f69271a)) {
                    while (true) {
                        int i9 = this.N;
                        if (i9 >= d2) {
                            break;
                        }
                        t(fVar, mVar, d2 - i9);
                    }
                } else {
                    byte[] bArr3 = this.f69266f.f70489a;
                    bArr3[0] = 0;
                    bArr3[1] = 0;
                    bArr3[2] = 0;
                    int i10 = cVar.P;
                    int i11 = 4 - i10;
                    while (this.N < d2) {
                        int i12 = this.U;
                        if (i12 == 0) {
                            u(fVar, bArr3, i11, i10);
                            this.f69266f.J(0);
                            this.U = this.f69266f.B();
                            this.f69265e.J(0);
                            mVar.a(this.f69265e, 4);
                            this.V += 4;
                        } else {
                            this.U = i12 - t(fVar, mVar, i12);
                        }
                    }
                }
                if ("A_VORBIS".equals(cVar.f69271a)) {
                    this.f69268h.J(0);
                    mVar.a(this.f69268h, 4);
                    this.V += 4;
                }
            }
        }
    }

    public final void B(d.f.b.a.a0.f fVar, byte[] bArr, int i2) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, bArr, i2) == null) {
            int length = bArr.length + i2;
            if (this.k.b() < length) {
                this.k.f70489a = Arrays.copyOf(bArr, length + i2);
            } else {
                System.arraycopy(bArr, 0, this.k.f70489a, 0, bArr.length);
            }
            fVar.readFully(this.k.f70489a, bArr.length, i2);
            this.k.G(length);
        }
    }

    @Override // d.f.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.A = -9223372036854775807L;
            this.E = 0;
            this.f69261a.reset();
            this.f69262b.e();
            v();
        }
    }

    @Override // d.f.b.a.a0.e
    public boolean d(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? new e().b(fVar) : invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public int e(d.f.b.a.a0.f fVar, k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) == null) {
            this.W = false;
            boolean z = true;
            while (z && !this.W) {
                z = this.f69261a.a(fVar);
                if (z && r(kVar, fVar.getPosition())) {
                    return 1;
                }
            }
            return z ? 0 : -1;
        }
        return invokeLL.intValue;
    }

    @Override // d.f.b.a.a0.e
    public void f(d.f.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.Y = gVar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x01f9, code lost:
        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(int i2, int i3, d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        char c2;
        int i4;
        int i5;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIIL(1048582, this, i2, i3, fVar) != null) {
            return;
        }
        int i6 = 0;
        int i7 = 1;
        if (i2 != 161 && i2 != 163) {
            if (i2 == 16981) {
                byte[] bArr = new byte[i3];
                this.t.f69276f = bArr;
                fVar.readFully(bArr, 0, i3);
                return;
            } else if (i2 == 18402) {
                byte[] bArr2 = new byte[i3];
                fVar.readFully(bArr2, 0, i3);
                this.t.f69277g = new m.a(1, bArr2, 0, 0);
                return;
            } else if (i2 == 21419) {
                Arrays.fill(this.f69269i.f70489a, (byte) 0);
                fVar.readFully(this.f69269i.f70489a, 4 - i3, i3);
                this.f69269i.J(0);
                this.v = (int) this.f69269i.z();
                return;
            } else if (i2 == 25506) {
                byte[] bArr3 = new byte[i3];
                this.t.f69278h = bArr3;
                fVar.readFully(bArr3, 0, i3);
                return;
            } else if (i2 == 30322) {
                byte[] bArr4 = new byte[i3];
                this.t.o = bArr4;
                fVar.readFully(bArr4, 0, i3);
                return;
            } else {
                throw new ParserException("Unexpected id: " + i2);
            }
        }
        if (this.E == 0) {
            this.K = (int) this.f69262b.d(fVar, false, true, 8);
            this.L = this.f69262b.b();
            this.G = -9223372036854775807L;
            this.E = 1;
            this.f69267g.F();
        }
        c cVar = this.f69263c.get(this.K);
        if (cVar == null) {
            fVar.h(i3 - this.L);
            this.E = 0;
            return;
        }
        if (this.E == 1) {
            s(fVar, 3);
            int i8 = (this.f69267g.f70489a[2] & 6) >> 1;
            byte b2 = 255;
            if (i8 == 0) {
                this.I = 1;
                int[] l = l(this.J, 1);
                this.J = l;
                l[0] = (i3 - this.L) - 3;
            } else if (i2 == 163) {
                int i9 = 4;
                s(fVar, 4);
                int i10 = (this.f69267g.f70489a[3] & 255) + 1;
                this.I = i10;
                int[] l2 = l(this.J, i10);
                this.J = l2;
                if (i8 == 2) {
                    int i11 = this.I;
                    Arrays.fill(l2, 0, i11, ((i3 - this.L) - 4) / i11);
                } else if (i8 == 1) {
                    int i12 = 0;
                    int i13 = 0;
                    while (true) {
                        i4 = this.I;
                        if (i12 >= i4 - 1) {
                            break;
                        }
                        this.J[i12] = 0;
                        do {
                            i9++;
                            s(fVar, i9);
                            i5 = this.f69267g.f70489a[i9 - 1] & 255;
                            iArr = this.J;
                            iArr[i12] = iArr[i12] + i5;
                        } while (i5 == 255);
                        i13 += iArr[i12];
                        i12++;
                    }
                    this.J[i4 - 1] = ((i3 - this.L) - i9) - i13;
                } else if (i8 != 3) {
                    throw new ParserException("Unexpected lacing value: " + i8);
                } else {
                    int i14 = 0;
                    int i15 = 0;
                    while (true) {
                        int i16 = this.I;
                        if (i14 < i16 - 1) {
                            this.J[i14] = i6;
                            i9++;
                            s(fVar, i9);
                            int i17 = i9 - 1;
                            if (this.f69267g.f70489a[i17] == 0) {
                                throw new ParserException("No valid varint length mask found");
                            }
                            long j = 0;
                            int i18 = 0;
                            while (true) {
                                if (i18 >= 8) {
                                    break;
                                }
                                int i19 = i7 << (7 - i18);
                                if ((this.f69267g.f70489a[i17] & i19) != 0) {
                                    i9 += i18;
                                    s(fVar, i9);
                                    long j2 = (~i19) & this.f69267g.f70489a[i17] & b2;
                                    int i20 = i17 + 1;
                                    j = j2;
                                    while (i20 < i9) {
                                        b2 = 255;
                                        i20++;
                                        j = (j << 8) | (this.f69267g.f70489a[i20] & b2);
                                    }
                                    if (i14 > 0) {
                                        j -= (1 << ((i18 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i18++;
                                    i7 = 1;
                                    b2 = 255;
                                }
                            }
                            long j3 = j;
                            if (j3 < -2147483648L || j3 > 2147483647L) {
                                break;
                            }
                            int i21 = (int) j3;
                            int[] iArr2 = this.J;
                            if (i14 != 0) {
                                i21 += iArr2[i14 - 1];
                            }
                            iArr2[i14] = i21;
                            i15 += this.J[i14];
                            i14++;
                            i6 = 0;
                            i7 = 1;
                            b2 = 255;
                        } else {
                            c2 = 1;
                            this.J[i16 - 1] = ((i3 - this.L) - i9) - i15;
                            break;
                        }
                    }
                }
            } else {
                throw new ParserException("Lacing only supported in SimpleBlocks.");
            }
            c2 = 1;
            byte[] bArr5 = this.f69267g.f70489a;
            this.F = this.A + w((bArr5[c2] & 255) | (bArr5[0] << 8));
            this.M = ((this.f69267g.f70489a[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | ((cVar.f69273c == 2 || (i2 == 163 && (this.f69267g.f70489a[2] & ByteCompanionObject.MIN_VALUE) == 128)) ? 1 : 0);
            this.E = 2;
            this.H = 0;
        }
        if (i2 != 163) {
            A(fVar, cVar, this.J[0]);
            return;
        }
        while (true) {
            int i22 = this.H;
            if (i22 < this.I) {
                A(fVar, cVar, this.J[i22]);
                i(cVar, this.F + ((this.H * cVar.f69274d) / 1000));
                this.H++;
            } else {
                this.E = 0;
                return;
            }
        }
    }

    public final d.f.b.a.a0.l h() {
        InterceptResult invokeV;
        g gVar;
        g gVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048583, this)) != null) {
            return (d.f.b.a.a0.l) invokeV.objValue;
        }
        if (this.p != -1 && this.s != -9223372036854775807L && (gVar = this.B) != null && gVar.c() != 0 && (gVar2 = this.C) != null && gVar2.c() == this.B.c()) {
            int c2 = this.B.c();
            int[] iArr = new int[c2];
            long[] jArr = new long[c2];
            long[] jArr2 = new long[c2];
            long[] jArr3 = new long[c2];
            int i2 = 0;
            for (int i3 = 0; i3 < c2; i3++) {
                jArr3[i3] = this.B.b(i3);
                jArr[i3] = this.p + this.C.b(i3);
            }
            while (true) {
                int i4 = c2 - 1;
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    iArr[i2] = (int) (jArr[i5] - jArr[i2]);
                    jArr2[i2] = jArr3[i5] - jArr3[i2];
                    i2 = i5;
                } else {
                    iArr[i4] = (int) ((this.p + this.o) - jArr[i4]);
                    jArr2[i4] = this.s - jArr3[i4];
                    this.B = null;
                    this.C = null;
                    return new d.f.b.a.a0.a(iArr, jArr, jArr2, jArr3);
                }
            }
        } else {
            this.B = null;
            this.C = null;
            return new l.a(this.s);
        }
    }

    public final void i(c cVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, j) == null) {
            if ("S_TEXT/UTF8".equals(cVar.f69271a)) {
                j(cVar, "%02d:%02d:%02d,%03d", 19, 1000L, a0);
            } else if ("S_TEXT/ASS".equals(cVar.f69271a)) {
                j(cVar, "%01d:%02d:%02d:%02d", 21, 10000L, d0);
            }
            cVar.O.c(j, this.M, this.V, 0, cVar.f69277g);
            this.W = true;
            v();
        }
    }

    public final void j(c cVar, String str, int i2, long j, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{cVar, str, Integer.valueOf(i2), Long.valueOf(j), bArr}) == null) {
            x(this.k.f70489a, this.G, str, i2, j, bArr);
            m mVar = cVar.O;
            d.f.b.a.i0.l lVar = this.k;
            mVar.a(lVar, lVar.d());
            this.V += this.k.d();
        }
    }

    public void k(int i2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 == 160) {
                if (this.E != 2) {
                    return;
                }
                if (!this.X) {
                    this.M |= 1;
                }
                i(this.f69263c.get(this.K), this.F);
                this.E = 0;
            } else if (i2 == 174) {
                if (p(this.t.f69271a)) {
                    c cVar = this.t;
                    cVar.c(this.Y, cVar.f69272b);
                    SparseArray<c> sparseArray = this.f69263c;
                    c cVar2 = this.t;
                    sparseArray.put(cVar2.f69272b, cVar2);
                }
                this.t = null;
            } else if (i2 == 19899) {
                int i3 = this.v;
                if (i3 != -1) {
                    long j = this.w;
                    if (j != -1) {
                        if (i3 == 475249515) {
                            this.y = j;
                            return;
                        }
                        return;
                    }
                }
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            } else if (i2 == 25152) {
                c cVar3 = this.t;
                if (cVar3.f69275e) {
                    if (cVar3.f69277g != null) {
                        cVar3.f69279i = new DrmInitData(new DrmInitData.SchemeData(d.f.b.a.b.f69704b, "video/webm", this.t.f69277g.f69230b));
                        return;
                    }
                    throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                }
            } else if (i2 == 28032) {
                c cVar4 = this.t;
                if (cVar4.f69275e && cVar4.f69276f != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
            } else if (i2 == 357149030) {
                if (this.q == -9223372036854775807L) {
                    this.q = 1000000L;
                }
                long j2 = this.r;
                if (j2 != -9223372036854775807L) {
                    this.s = w(j2);
                }
            } else if (i2 != 374648427) {
                if (i2 == 475249515 && !this.u) {
                    this.Y.p(h());
                    this.u = true;
                }
            } else if (this.f69263c.size() != 0) {
                this.Y.j();
            } else {
                throw new ParserException("No valid tracks were found");
            }
        }
    }

    public void m(int i2, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)}) == null) {
            if (i2 == 181) {
                this.t.I = (int) d2;
            } else if (i2 != 17545) {
                switch (i2) {
                    case 21969:
                        this.t.w = (float) d2;
                        return;
                    case 21970:
                        this.t.x = (float) d2;
                        return;
                    case 21971:
                        this.t.y = (float) d2;
                        return;
                    case 21972:
                        this.t.z = (float) d2;
                        return;
                    case 21973:
                        this.t.A = (float) d2;
                        return;
                    case 21974:
                        this.t.B = (float) d2;
                        return;
                    case 21975:
                        this.t.C = (float) d2;
                        return;
                    case 21976:
                        this.t.D = (float) d2;
                        return;
                    case 21977:
                        this.t.E = (float) d2;
                        return;
                    case 21978:
                        this.t.F = (float) d2;
                        return;
                    default:
                        return;
                }
            } else {
                this.r = (long) d2;
            }
        }
    }

    public int n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            switch (i2) {
                case IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER /* 131 */:
                case 136:
                case 155:
                case Opcodes.IF_ICMPEQ /* 159 */:
                case Opcodes.ARETURN /* 176 */:
                case 179:
                case 186:
                case JfifUtil.MARKER_RST7 /* 215 */:
                case 231:
                case BaseActivity.DIALOG_PROMPT /* 241 */:
                case GDiffPatcher.COPY_USHORT_INT /* 251 */:
                case 16980:
                case 17029:
                case 17143:
                case 18401:
                case 18408:
                case 20529:
                case 20530:
                case 21420:
                case 21432:
                case 21680:
                case 21682:
                case 21690:
                case 21930:
                case 21945:
                case 21946:
                case 21947:
                case 21948:
                case 21949:
                case 22186:
                case 22203:
                case 25188:
                case 2352003:
                case 2807729:
                    return 2;
                case 134:
                case 17026:
                case 2274716:
                    return 3;
                case 160:
                case 174:
                case 183:
                case Opcodes.NEW /* 187 */:
                case 224:
                case 225:
                case 18407:
                case 19899:
                case 20532:
                case 20533:
                case 21936:
                case 21968:
                case 25152:
                case 28032:
                case 30320:
                case 290298740:
                case 357149030:
                case 374648427:
                case 408125543:
                case 440786851:
                case 475249515:
                case 524531317:
                    return 1;
                case 161:
                case 163:
                case 16981:
                case 18402:
                case 21419:
                case 25506:
                case 30322:
                    return 4;
                case Opcodes.PUTFIELD /* 181 */:
                case 17545:
                case 21969:
                case 21970:
                case 21971:
                case 21972:
                case 21973:
                case 21974:
                case 21975:
                case 21976:
                case 21977:
                case 21978:
                    return 5;
                default:
                    return 0;
            }
        }
        return invokeI.intValue;
    }

    public void o(int i2, long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (i2 == 20529) {
                if (j == 0) {
                    return;
                }
                throw new ParserException("ContentEncodingOrder " + j + " not supported");
            } else if (i2 == 20530) {
                if (j == 1) {
                    return;
                }
                throw new ParserException("ContentEncodingScope " + j + " not supported");
            } else {
                switch (i2) {
                    case IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER /* 131 */:
                        this.t.f69273c = (int) j;
                        return;
                    case 136:
                        this.t.L = j == 1;
                        return;
                    case 155:
                        this.G = w(j);
                        return;
                    case Opcodes.IF_ICMPEQ /* 159 */:
                        this.t.G = (int) j;
                        return;
                    case Opcodes.ARETURN /* 176 */:
                        this.t.j = (int) j;
                        return;
                    case 179:
                        this.B.a(w(j));
                        return;
                    case 186:
                        this.t.k = (int) j;
                        return;
                    case JfifUtil.MARKER_RST7 /* 215 */:
                        this.t.f69272b = (int) j;
                        return;
                    case 231:
                        this.A = w(j);
                        return;
                    case BaseActivity.DIALOG_PROMPT /* 241 */:
                        if (this.D) {
                            return;
                        }
                        this.C.a(j);
                        this.D = true;
                        return;
                    case GDiffPatcher.COPY_USHORT_INT /* 251 */:
                        this.X = true;
                        return;
                    case 16980:
                        if (j == 3) {
                            return;
                        }
                        throw new ParserException("ContentCompAlgo " + j + " not supported");
                    case 17029:
                        if (j < 1 || j > 2) {
                            throw new ParserException("DocTypeReadVersion " + j + " not supported");
                        }
                        return;
                    case 17143:
                        if (j == 1) {
                            return;
                        }
                        throw new ParserException("EBMLReadVersion " + j + " not supported");
                    case 18401:
                        if (j == 5) {
                            return;
                        }
                        throw new ParserException("ContentEncAlgo " + j + " not supported");
                    case 18408:
                        if (j == 1) {
                            return;
                        }
                        throw new ParserException("AESSettingsCipherMode " + j + " not supported");
                    case 21420:
                        this.w = j + this.p;
                        return;
                    case 21432:
                        int i3 = (int) j;
                        if (i3 == 0) {
                            this.t.p = 0;
                            return;
                        } else if (i3 == 1) {
                            this.t.p = 2;
                            return;
                        } else if (i3 == 3) {
                            this.t.p = 1;
                            return;
                        } else if (i3 != 15) {
                            return;
                        } else {
                            this.t.p = 3;
                            return;
                        }
                    case 21680:
                        this.t.l = (int) j;
                        return;
                    case 21682:
                        this.t.n = (int) j;
                        return;
                    case 21690:
                        this.t.m = (int) j;
                        return;
                    case 21930:
                        this.t.M = j == 1;
                        return;
                    case 22186:
                        this.t.J = j;
                        return;
                    case 22203:
                        this.t.K = j;
                        return;
                    case 25188:
                        this.t.H = (int) j;
                        return;
                    case 2352003:
                        this.t.f69274d = (int) j;
                        return;
                    case 2807729:
                        this.q = j;
                        return;
                    default:
                        switch (i2) {
                            case 21945:
                                int i4 = (int) j;
                                if (i4 == 1) {
                                    this.t.t = 2;
                                    return;
                                } else if (i4 != 2) {
                                    return;
                                } else {
                                    this.t.t = 1;
                                    return;
                                }
                            case 21946:
                                int i5 = (int) j;
                                if (i5 != 1) {
                                    if (i5 == 16) {
                                        this.t.s = 6;
                                        return;
                                    } else if (i5 == 18) {
                                        this.t.s = 7;
                                        return;
                                    } else if (i5 != 6 && i5 != 7) {
                                        return;
                                    }
                                }
                                this.t.s = 3;
                                return;
                            case 21947:
                                c cVar = this.t;
                                cVar.q = true;
                                int i6 = (int) j;
                                if (i6 == 1) {
                                    cVar.r = 1;
                                    return;
                                } else if (i6 == 9) {
                                    cVar.r = 6;
                                    return;
                                } else if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                    this.t.r = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.t.u = (int) j;
                                return;
                            case 21949:
                                this.t.v = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            }
        }
    }

    public boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427 : invokeI.booleanValue;
    }

    public final boolean r(k kVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048591, this, kVar, j)) == null) {
            if (this.x) {
                this.z = j;
                kVar.f69227a = this.y;
                this.x = false;
                return true;
            }
            if (this.u) {
                long j2 = this.z;
                if (j2 != -1) {
                    kVar.f69227a = j2;
                    this.z = -1L;
                    return true;
                }
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public final void s(d.f.b.a.a0.f fVar, int i2) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, fVar, i2) == null) || this.f69267g.d() >= i2) {
            return;
        }
        if (this.f69267g.b() < i2) {
            d.f.b.a.i0.l lVar = this.f69267g;
            byte[] bArr = lVar.f70489a;
            lVar.H(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i2)), this.f69267g.d());
        }
        d.f.b.a.i0.l lVar2 = this.f69267g;
        fVar.readFully(lVar2.f70489a, lVar2.d(), i2 - this.f69267g.d());
        this.f69267g.I(i2);
    }

    public final int t(d.f.b.a.a0.f fVar, m mVar, int i2) throws IOException, InterruptedException {
        InterceptResult invokeLLI;
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, fVar, mVar, i2)) == null) {
            int a2 = this.j.a();
            if (a2 > 0) {
                d2 = Math.min(i2, a2);
                mVar.a(this.j, d2);
            } else {
                d2 = mVar.d(fVar, i2, false);
            }
            this.N += d2;
            this.V += d2;
            return d2;
        }
        return invokeLLI.intValue;
    }

    public final void u(d.f.b.a.a0.f fVar, byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048595, this, fVar, bArr, i2, i3) == null) {
            int min = Math.min(i3, this.j.a());
            fVar.readFully(bArr, i2 + min, i3 - min);
            if (min > 0) {
                this.j.g(bArr, i2, min);
            }
            this.N += i3;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.N = 0;
            this.V = 0;
            this.U = 0;
            this.O = false;
            this.P = false;
            this.R = false;
            this.T = 0;
            this.S = (byte) 0;
            this.Q = false;
            this.j.F();
        }
    }

    public final long w(long j) throws ParserException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j)) == null) {
            long j2 = this.q;
            if (j2 != -9223372036854775807L) {
                return v.F(j, j2, 1000L);
            }
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return invokeJ.longValue;
    }

    public void y(int i2, long j, long j2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (i2 == 160) {
                this.X = false;
            } else if (i2 == 174) {
                this.t = new c(null);
            } else if (i2 == 187) {
                this.D = false;
            } else if (i2 == 19899) {
                this.v = -1;
                this.w = -1L;
            } else if (i2 == 20533) {
                this.t.f69275e = true;
            } else if (i2 == 21968) {
                this.t.q = true;
            } else if (i2 == 408125543) {
                long j3 = this.p;
                if (j3 != -1 && j3 != j) {
                    throw new ParserException("Multiple Segment elements not supported");
                }
                this.p = j;
                this.o = j2;
            } else if (i2 != 475249515) {
                if (i2 == 524531317 && !this.u) {
                    if (this.f69264d && this.y != -1) {
                        this.x = true;
                        return;
                    }
                    this.Y.p(new l.a(this.s));
                    this.u = true;
                }
            } else {
                this.B = new g();
                this.C = new g();
            }
        }
    }

    public void z(int i2, String str) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i2, str) == null) {
            if (i2 == 134) {
                this.t.f69271a = str;
            } else if (i2 != 17026) {
                if (i2 != 2274716) {
                    return;
                }
                this.t.N = str;
            } else if ("webm".equals(str) || "matroska".equals(str)) {
            } else {
                throw new ParserException("DocType " + str + " not supported");
            }
        }
    }

    public d(d.f.b.a.a0.o.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = -1L;
        this.q = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.y = -1L;
        this.z = -1L;
        this.A = -9223372036854775807L;
        this.f69261a = bVar;
        bVar.b(new b(this, null));
        this.f69264d = (i2 & 1) == 0;
        this.f69262b = new f();
        this.f69263c = new SparseArray<>();
        this.f69267g = new d.f.b.a.i0.l(4);
        this.f69268h = new d.f.b.a.i0.l(ByteBuffer.allocate(4).putInt(-1).array());
        this.f69269i = new d.f.b.a.i0.l(4);
        this.f69265e = new d.f.b.a.i0.l(j.f70469a);
        this.f69266f = new d.f.b.a.i0.l(4);
        this.j = new d.f.b.a.i0.l();
        this.k = new d.f.b.a.i0.l();
        this.l = new d.f.b.a.i0.l(8);
        this.m = new d.f.b.a.i0.l();
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float A;
        public float B;
        public float C;
        public float D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public long J;
        public long K;
        public boolean L;
        public boolean M;
        public String N;
        public m O;
        public int P;

        /* renamed from: a  reason: collision with root package name */
        public String f69271a;

        /* renamed from: b  reason: collision with root package name */
        public int f69272b;

        /* renamed from: c  reason: collision with root package name */
        public int f69273c;

        /* renamed from: d  reason: collision with root package name */
        public int f69274d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f69275e;

        /* renamed from: f  reason: collision with root package name */
        public byte[] f69276f;

        /* renamed from: g  reason: collision with root package name */
        public m.a f69277g;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f69278h;

        /* renamed from: i  reason: collision with root package name */
        public DrmInitData f69279i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public byte[] o;
        public int p;
        public boolean q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public float w;
        public float x;
        public float y;
        public float z;

        public c() {
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
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = null;
            this.p = -1;
            this.q = false;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 1000;
            this.v = 200;
            this.w = -1.0f;
            this.x = -1.0f;
            this.y = -1.0f;
            this.z = -1.0f;
            this.A = -1.0f;
            this.B = -1.0f;
            this.C = -1.0f;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 1;
            this.H = -1;
            this.I = 8000;
            this.J = 0L;
            this.K = 0L;
            this.M = true;
            this.N = "eng";
        }

        public static List<byte[]> d(d.f.b.a.i0.l lVar) throws ParserException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lVar)) == null) {
                try {
                    lVar.K(16);
                    if (lVar.n() != 826496599) {
                        return null;
                    }
                    byte[] bArr = lVar.f70489a;
                    for (int c2 = lVar.c() + 20; c2 < bArr.length - 4; c2++) {
                        if (bArr[c2] == 0 && bArr[c2 + 1] == 0 && bArr[c2 + 2] == 1 && bArr[c2 + 3] == 15) {
                            return Collections.singletonList(Arrays.copyOfRange(bArr, c2, bArr.length));
                        }
                    }
                    throw new ParserException("Failed to find FourCC VC1 initialization data");
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new ParserException("Error parsing FourCC VC1 codec private");
                }
            }
            return (List) invokeL.objValue;
        }

        public static boolean e(d.f.b.a.i0.l lVar) throws ParserException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lVar)) == null) {
                try {
                    int p = lVar.p();
                    if (p == 1) {
                        return true;
                    }
                    if (p == 65534) {
                        lVar.J(24);
                        if (lVar.q() == d.e0.getMostSignificantBits()) {
                            if (lVar.q() == d.e0.getLeastSignificantBits()) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new ParserException("Error parsing MS/ACM codec private");
                }
            }
            return invokeL.booleanValue;
        }

        public static List<byte[]> f(byte[] bArr) throws ParserException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
                try {
                    if (bArr[0] == 2) {
                        int i2 = 1;
                        int i3 = 0;
                        while (bArr[i2] == -1) {
                            i3 += 255;
                            i2++;
                        }
                        int i4 = i2 + 1;
                        int i5 = i3 + bArr[i2];
                        int i6 = 0;
                        while (bArr[i4] == -1) {
                            i6 += 255;
                            i4++;
                        }
                        int i7 = i4 + 1;
                        int i8 = i6 + bArr[i4];
                        if (bArr[i7] == 1) {
                            byte[] bArr2 = new byte[i5];
                            System.arraycopy(bArr, i7, bArr2, 0, i5);
                            int i9 = i7 + i5;
                            if (bArr[i9] == 3) {
                                int i10 = i9 + i8;
                                if (bArr[i10] == 5) {
                                    byte[] bArr3 = new byte[bArr.length - i10];
                                    System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                                    ArrayList arrayList = new ArrayList(2);
                                    arrayList.add(bArr2);
                                    arrayList.add(bArr3);
                                    return arrayList;
                                }
                                throw new ParserException("Error parsing vorbis codec private");
                            }
                            throw new ParserException("Error parsing vorbis codec private");
                        }
                        throw new ParserException("Error parsing vorbis codec private");
                    }
                    throw new ParserException("Error parsing vorbis codec private");
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
            }
            return (List) invokeL.objValue;
        }

        public final byte[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.w == -1.0f || this.x == -1.0f || this.y == -1.0f || this.z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f) {
                    return null;
                }
                byte[] bArr = new byte[25];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.put((byte) 0);
                wrap.putShort((short) ((this.w * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.x * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.y * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.z * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.A * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.B * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.C * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.D * 50000.0f) + 0.5f));
                wrap.putShort((short) (this.E + 0.5f));
                wrap.putShort((short) (this.F + 0.5f));
                wrap.putShort((short) this.u);
                wrap.putShort((short) this.v);
                return bArr;
            }
            return (byte[]) invokeV.objValue;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void c(d.f.b.a.a0.g gVar, int i2) throws ParserException {
            char c2;
            String str;
            List<byte[]> singletonList;
            String str2;
            List<byte[]> list;
            int i3;
            int i4;
            String str3;
            int r;
            Format createImageSampleFormat;
            int i5;
            int i6;
            int i7;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, i2) == null) {
                String str4 = this.f69271a;
                int i8 = 1;
                switch (str4.hashCode()) {
                    case -2095576542:
                        if (str4.equals("V_MPEG4/ISO/AP")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -2095575984:
                        if (str4.equals("V_MPEG4/ISO/SP")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1985379776:
                        if (str4.equals("A_MS/ACM")) {
                            c2 = 22;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1784763192:
                        if (str4.equals("A_TRUEHD")) {
                            c2 = 17;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1730367663:
                        if (str4.equals("A_VORBIS")) {
                            c2 = '\n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1482641358:
                        if (str4.equals("A_MPEG/L2")) {
                            c2 = '\r';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1482641357:
                        if (str4.equals("A_MPEG/L3")) {
                            c2 = 14;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1373388978:
                        if (str4.equals("V_MS/VFW/FOURCC")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -933872740:
                        if (str4.equals("S_DVBSUB")) {
                            c2 = DecodedBitStreamParser.FS;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -538363189:
                        if (str4.equals("V_MPEG4/ISO/ASP")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -538363109:
                        if (str4.equals("V_MPEG4/ISO/AVC")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -425012669:
                        if (str4.equals("S_VOBSUB")) {
                            c2 = JSONLexer.EOI;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -356037306:
                        if (str4.equals("A_DTS/LOSSLESS")) {
                            c2 = 20;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 62923557:
                        if (str4.equals("A_AAC")) {
                            c2 = '\f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 62923603:
                        if (str4.equals("A_AC3")) {
                            c2 = 15;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 62927045:
                        if (str4.equals("A_DTS")) {
                            c2 = 18;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 82338133:
                        if (str4.equals("V_VP8")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 82338134:
                        if (str4.equals("V_VP9")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 99146302:
                        if (str4.equals("S_HDMV/PGS")) {
                            c2 = 27;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 444813526:
                        if (str4.equals("V_THEORA")) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 542569478:
                        if (str4.equals("A_DTS/EXPRESS")) {
                            c2 = 19;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 725957860:
                        if (str4.equals("A_PCM/INT/LIT")) {
                            c2 = 23;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 738597099:
                        if (str4.equals("S_TEXT/ASS")) {
                            c2 = 25;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 855502857:
                        if (str4.equals("V_MPEGH/ISO/HEVC")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1422270023:
                        if (str4.equals("S_TEXT/UTF8")) {
                            c2 = 24;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1809237540:
                        if (str4.equals("V_MPEG2")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1950749482:
                        if (str4.equals("A_EAC3")) {
                            c2 = 16;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1950789798:
                        if (str4.equals("A_FLAC")) {
                            c2 = 21;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1951062397:
                        if (str4.equals("A_OPUS")) {
                            c2 = 11;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                String str5 = "audio/x-unknown";
                switch (c2) {
                    case 0:
                        str = "video/x-vnd.on2.vp8";
                        str5 = str;
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 1:
                        str = "video/x-vnd.on2.vp9";
                        str5 = str;
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 2:
                        str = "video/mpeg2";
                        str5 = str;
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 3:
                    case 4:
                    case 5:
                        byte[] bArr = this.f69278h;
                        singletonList = bArr == null ? null : Collections.singletonList(bArr);
                        str2 = "video/mp4v-es";
                        str5 = str2;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 6:
                        d.f.b.a.j0.a b2 = d.f.b.a.j0.a.b(new d.f.b.a.i0.l(this.f69278h));
                        list = b2.f70544a;
                        this.P = b2.f70545b;
                        str2 = "video/avc";
                        singletonList = list;
                        str5 = str2;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 7:
                        d.f.b.a.j0.b a2 = d.f.b.a.j0.b.a(new d.f.b.a.i0.l(this.f69278h));
                        list = a2.f70549a;
                        this.P = a2.f70550b;
                        str2 = "video/hevc";
                        singletonList = list;
                        str5 = str2;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case '\b':
                        singletonList = d(new d.f.b.a.i0.l(this.f69278h));
                        if (singletonList != null) {
                            str2 = "video/wvc1";
                            str5 = str2;
                            i3 = -1;
                            i4 = -1;
                            break;
                        } else {
                            Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                            str5 = "video/x-unknown";
                            i3 = -1;
                            i4 = -1;
                        }
                    case '\t':
                        str5 = "video/x-unknown";
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case '\n':
                        singletonList = f(this.f69278h);
                        str5 = "audio/vorbis";
                        i3 = -1;
                        i4 = 8192;
                        break;
                    case 11:
                        singletonList = new ArrayList<>(3);
                        singletonList.add(this.f69278h);
                        singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.J).array());
                        singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
                        str5 = "audio/opus";
                        i3 = -1;
                        i4 = 5760;
                        break;
                    case '\f':
                        singletonList = Collections.singletonList(this.f69278h);
                        str2 = "audio/mp4a-latm";
                        str5 = str2;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case '\r':
                        str3 = "audio/mpeg-L2";
                        str5 = str3;
                        singletonList = null;
                        i3 = -1;
                        i4 = 4096;
                        break;
                    case 14:
                        str3 = "audio/mpeg";
                        str5 = str3;
                        singletonList = null;
                        i3 = -1;
                        i4 = 4096;
                        break;
                    case 15:
                        str = "audio/ac3";
                        str5 = str;
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 16:
                        str = "audio/eac3";
                        str5 = str;
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 17:
                        str = "audio/true-hd";
                        str5 = str;
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 18:
                    case 19:
                        str = "audio/vnd.dts";
                        str5 = str;
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 20:
                        str = "audio/vnd.dts.hd";
                        str5 = str;
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 21:
                        singletonList = Collections.singletonList(this.f69278h);
                        str2 = "audio/flac";
                        str5 = str2;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 22:
                        if (e(new d.f.b.a.i0.l(this.f69278h))) {
                            r = v.r(this.H);
                            if (r == 0) {
                                Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.H + ". Setting mimeType to audio/x-unknown");
                            }
                            i3 = r;
                            str5 = "audio/raw";
                            singletonList = null;
                            i4 = -1;
                            break;
                        } else {
                            Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                        }
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                    case 23:
                        r = v.r(this.H);
                        if (r == 0) {
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.H + ". Setting mimeType to audio/x-unknown");
                            singletonList = null;
                            i3 = -1;
                            i4 = -1;
                            break;
                        }
                        i3 = r;
                        str5 = "audio/raw";
                        singletonList = null;
                        i4 = -1;
                    case 24:
                        str5 = "application/x-subrip";
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 25:
                        str5 = "text/x-ssa";
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 26:
                        singletonList = Collections.singletonList(this.f69278h);
                        str5 = "application/vobsub";
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 27:
                        str5 = "application/pgs";
                        singletonList = null;
                        i3 = -1;
                        i4 = -1;
                        break;
                    case 28:
                        byte[] bArr2 = this.f69278h;
                        singletonList = Collections.singletonList(new byte[]{bArr2[0], bArr2[1], bArr2[2], bArr2[3]});
                        str5 = "application/dvbsubs";
                        i3 = -1;
                        i4 = -1;
                        break;
                    default:
                        throw new ParserException("Unrecognized codec identifier.");
                }
                int i9 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                if (i.g(str5)) {
                    createImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i2), str5, null, -1, i4, this.G, this.I, i3, singletonList, this.f69279i, i9, this.N);
                } else if (i.i(str5)) {
                    if (this.n == 0) {
                        int i10 = this.l;
                        i5 = -1;
                        if (i10 == -1) {
                            i10 = this.j;
                        }
                        this.l = i10;
                        int i11 = this.m;
                        if (i11 == -1) {
                            i11 = this.k;
                        }
                        this.m = i11;
                    } else {
                        i5 = -1;
                    }
                    createImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i2), str5, null, -1, i4, this.j, this.k, -1.0f, singletonList, -1, (this.l == i5 || (i7 = this.m) == i5) ? -1.0f : (this.k * i6) / (this.j * i7), this.o, this.p, this.q ? new ColorInfo(this.r, this.t, this.s, b()) : null, this.f69279i);
                    i8 = 2;
                } else {
                    if ("application/x-subrip".equals(str5)) {
                        createImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i2), str5, i9, this.N, this.f69279i);
                    } else if ("text/x-ssa".equals(str5)) {
                        ArrayList arrayList = new ArrayList(2);
                        arrayList.add(d.b0);
                        arrayList.add(this.f69278h);
                        createImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i2), str5, null, -1, i9, this.N, -1, this.f69279i, Long.MAX_VALUE, arrayList);
                    } else if (!"application/vobsub".equals(str5) && !"application/pgs".equals(str5) && !"application/dvbsubs".equals(str5)) {
                        throw new ParserException("Unexpected MIME type.");
                    } else {
                        createImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i2), str5, null, -1, singletonList, this.N, this.f69279i);
                    }
                    i8 = 3;
                }
                m a3 = gVar.a(this.f69272b, i8);
                this.O = a3;
                a3.b(createImageSampleFormat);
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
