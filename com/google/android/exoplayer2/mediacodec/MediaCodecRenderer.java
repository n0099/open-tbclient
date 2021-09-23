package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a;
import c.i.b.a.b0.b;
import c.i.b.a.i0.j;
import c.i.b.a.i0.t;
import c.i.b.a.i0.v;
import c.i.b.a.l;
import c.i.b.a.y.d;
import c.i.b.a.y.e;
import c.i.b.a.z.c;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
@TargetApi(16)
/* loaded from: classes9.dex */
public abstract class MediaCodecRenderer extends a {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] Y;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public ByteBuffer[] I;
    public ByteBuffer[] J;
    public long K;
    public int L;
    public int M;
    public boolean N;
    public boolean O;
    public int P;
    public int Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public d X;
    public final b m;
    @Nullable
    public final c.i.b.a.z.a<c> n;
    public final boolean o;
    public final e p;
    public final e q;
    public final l r;
    public final List<Long> s;
    public final MediaCodec.BufferInfo t;
    public Format u;
    public DrmSession<c> v;
    public DrmSession<c> w;
    public MediaCodec x;
    public c.i.b.a.b0.a y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(908998919, "Lcom/google/android/exoplayer2/mediacodec/MediaCodecRenderer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(908998919, "Lcom/google/android/exoplayer2/mediacodec/MediaCodecRenderer;");
                return;
            }
        }
        Y = v.n("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCodecRenderer(int i2, b bVar, @Nullable c.i.b.a.z.a<c> aVar, boolean z) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bVar, aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.a.f(v.f33861a >= 16);
        c.i.b.a.i0.a.e(bVar);
        this.m = bVar;
        this.n = aVar;
        this.o = z;
        this.p = new e(0);
        this.q = e.r();
        this.r = new l();
        this.s = new ArrayList();
        this.t = new MediaCodec.BufferInfo();
        this.P = 0;
        this.Q = 0;
    }

    public static boolean H(String str, Format format) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, format)) == null) ? v.f33861a < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str) : invokeLL.booleanValue;
    }

    public static boolean I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (v.f33861a <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (v.f33861a <= 19 && "hb2000".equals(v.f33862b) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) : invokeL.booleanValue;
    }

    public static boolean J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? v.f33861a == 21 && "OMX.google.aac.decoder".equals(str) : invokeL.booleanValue;
    }

    public static boolean K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? v.f33861a <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str)) : invokeL.booleanValue;
    }

    public static boolean L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            int i2 = v.f33861a;
            return i2 < 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (v.f33861a == 19 && v.f33864d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
        }
        return invokeL.booleanValue;
    }

    public static boolean M(String str, Format format) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, format)) == null) ? v.f33861a <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str) : invokeLL.booleanValue;
    }

    public static MediaCodec.CryptoInfo V(e eVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, eVar, i2)) == null) {
            MediaCodec.CryptoInfo a2 = eVar.f34111f.a();
            if (i2 == 0) {
                return a2;
            }
            if (a2.numBytesOfClearData == null) {
                a2.numBytesOfClearData = new int[1];
            }
            int[] iArr = a2.numBytesOfClearData;
            iArr[0] = iArr[0] + i2;
            return a2;
        }
        return (MediaCodec.CryptoInfo) invokeLI.objValue;
    }

    @Override // c.i.b.a.a
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public boolean F(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaCodec, Boolean.valueOf(z), format, format2})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final int G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (v.f33861a <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (v.f33864d.startsWith("SM-T585") || v.f33864d.startsWith("SM-A510") || v.f33864d.startsWith("SM-A520") || v.f33864d.startsWith("SM-J700"))) {
                return 2;
            }
            if (v.f33861a < 24) {
                if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
                    return ("flounder".equals(v.f33862b) || "flounder_lte".equals(v.f33862b) || "grouper".equals(v.f33862b) || "tilapia".equals(v.f33862b)) ? 1 : 0;
                }
                return 0;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public abstract void N(c.i.b.a.b0.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException;

    public final boolean O(long j2, long j3) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        boolean d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (this.M < 0) {
                if (this.E && this.S) {
                    try {
                        this.M = this.x.dequeueOutputBuffer(this.t, U());
                    } catch (IllegalStateException unused) {
                        c0();
                        if (this.U) {
                            g0();
                        }
                        return false;
                    }
                } else {
                    this.M = this.x.dequeueOutputBuffer(this.t, U());
                }
                int i2 = this.M;
                if (i2 < 0) {
                    if (i2 == -2) {
                        f0();
                        return true;
                    } else if (i2 == -3) {
                        e0();
                        return true;
                    } else {
                        if (this.C && (this.T || this.Q == 2)) {
                            c0();
                        }
                        return false;
                    }
                } else if (this.H) {
                    this.H = false;
                    this.x.releaseOutputBuffer(i2, false);
                    this.M = -1;
                    return true;
                } else {
                    MediaCodec.BufferInfo bufferInfo = this.t;
                    if ((bufferInfo.flags & 4) != 0) {
                        c0();
                        this.M = -1;
                        return false;
                    }
                    ByteBuffer byteBuffer = this.J[i2];
                    if (byteBuffer != null) {
                        byteBuffer.position(bufferInfo.offset);
                        MediaCodec.BufferInfo bufferInfo2 = this.t;
                        byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                    }
                    this.N = j0(this.t.presentationTimeUs);
                }
            }
            if (this.E && this.S) {
                try {
                    d0 = d0(j2, j3, this.x, this.J[this.M], this.M, this.t.flags, this.t.presentationTimeUs, this.N);
                } catch (IllegalStateException unused2) {
                    c0();
                    if (this.U) {
                        g0();
                    }
                    return false;
                }
            } else {
                MediaCodec mediaCodec = this.x;
                ByteBuffer[] byteBufferArr = this.J;
                int i3 = this.M;
                ByteBuffer byteBuffer2 = byteBufferArr[i3];
                MediaCodec.BufferInfo bufferInfo3 = this.t;
                d0 = d0(j2, j3, mediaCodec, byteBuffer2, i3, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.N);
            }
            if (d0) {
                a0(this.t.presentationTimeUs);
                this.M = -1;
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean P() throws ExoPlaybackException {
        InterceptResult invokeV;
        int position;
        int C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            MediaCodec mediaCodec = this.x;
            if (mediaCodec == null || this.Q == 2 || this.T) {
                return false;
            }
            if (this.L < 0) {
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
                this.L = dequeueInputBuffer;
                if (dequeueInputBuffer < 0) {
                    return false;
                }
                e eVar = this.p;
                eVar.f34112g = this.I[dequeueInputBuffer];
                eVar.f();
            }
            if (this.Q == 1) {
                if (!this.C) {
                    this.S = true;
                    this.x.queueInputBuffer(this.L, 0, 0, 0L, 4);
                    this.L = -1;
                }
                this.Q = 2;
                return false;
            } else if (this.G) {
                this.G = false;
                this.p.f34112g.put(Y);
                this.x.queueInputBuffer(this.L, 0, Y.length, 0L, 0);
                this.L = -1;
                this.R = true;
                return true;
            } else {
                if (this.V) {
                    C = -4;
                    position = 0;
                } else {
                    if (this.P == 1) {
                        for (int i2 = 0; i2 < this.u.initializationData.size(); i2++) {
                            this.p.f34112g.put(this.u.initializationData.get(i2));
                        }
                        this.P = 2;
                    }
                    position = this.p.f34112g.position();
                    C = C(this.r, this.p, false);
                }
                if (C == -3) {
                    return false;
                }
                if (C == -5) {
                    if (this.P == 2) {
                        this.p.f();
                        this.P = 1;
                    }
                    Y(this.r.f33945a);
                    return true;
                } else if (this.p.j()) {
                    if (this.P == 2) {
                        this.p.f();
                        this.P = 1;
                    }
                    this.T = true;
                    if (!this.R) {
                        c0();
                        return false;
                    }
                    try {
                        if (!this.C) {
                            this.S = true;
                            this.x.queueInputBuffer(this.L, 0, 0, 0L, 4);
                            this.L = -1;
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e2) {
                        throw ExoPlaybackException.createForRenderer(e2, u());
                    }
                } else if (this.W && !this.p.k()) {
                    this.p.f();
                    if (this.P == 2) {
                        this.P = 1;
                    }
                    return true;
                } else {
                    this.W = false;
                    boolean p = this.p.p();
                    boolean k0 = k0(p);
                    this.V = k0;
                    if (k0) {
                        return false;
                    }
                    if (this.A && !p) {
                        j.b(this.p.f34112g);
                        if (this.p.f34112g.position() == 0) {
                            return true;
                        }
                        this.A = false;
                    }
                    try {
                        long j2 = this.p.f34113h;
                        if (this.p.i()) {
                            this.s.add(Long.valueOf(j2));
                        }
                        this.p.o();
                        b0(this.p);
                        if (p) {
                            this.x.queueSecureInputBuffer(this.L, 0, V(this.p, position), j2, 0);
                        } else {
                            this.x.queueInputBuffer(this.L, 0, this.p.f34112g.limit(), j2, 0);
                        }
                        this.L = -1;
                        this.R = true;
                        this.P = 0;
                        this.X.f34104c++;
                        return true;
                    } catch (MediaCodec.CryptoException e3) {
                        throw ExoPlaybackException.createForRenderer(e3, u());
                    }
                }
            }
        }
        return invokeV.booleanValue;
    }

    public void Q() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.K = -9223372036854775807L;
            this.L = -1;
            this.M = -1;
            this.W = true;
            this.V = false;
            this.N = false;
            this.s.clear();
            this.G = false;
            this.H = false;
            if (!this.B && (!this.D || !this.S)) {
                if (this.Q != 0) {
                    g0();
                    W();
                } else {
                    this.x.flush();
                    this.R = false;
                }
            } else {
                g0();
                W();
            }
            if (!this.O || this.u == null) {
                return;
            }
            this.P = 1;
        }
    }

    public final MediaCodec R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.x : (MediaCodec) invokeV.objValue;
    }

    public final c.i.b.a.b0.a S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.y : (c.i.b.a.b0.a) invokeV.objValue;
    }

    public c.i.b.a.b0.a T(b bVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048585, this, bVar, format, z)) == null) ? bVar.a(format.sampleMimeType, z) : (c.i.b.a.b0.a) invokeLLZ.objValue;
    }

    public long U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void W() throws ExoPlaybackException {
        Format format;
        MediaCrypto mediaCrypto;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.x == null && (format = this.u) != null) {
            DrmSession<c> drmSession = this.w;
            this.v = drmSession;
            String str = format.sampleMimeType;
            if (drmSession != null) {
                c a2 = drmSession.a();
                if (a2 == null) {
                    DrmSession.DrmSessionException error = this.v.getError();
                    if (error != null) {
                        throw ExoPlaybackException.createForRenderer(error, u());
                    }
                    return;
                }
                mediaCrypto = a2.a();
                z = a2.b(str);
            } else {
                mediaCrypto = null;
                z = false;
            }
            if (this.y == null) {
                try {
                    c.i.b.a.b0.a T = T(this.m, this.u, z);
                    this.y = T;
                    if (T == null && z) {
                        c.i.b.a.b0.a T2 = T(this.m, this.u, false);
                        this.y = T2;
                        if (T2 != null) {
                            String str2 = "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.y.f32997a + ".";
                        }
                    }
                    if (this.y == null) {
                        m0(new DecoderInitializationException(this.u, (Throwable) null, z, (int) DecoderInitializationException.NO_SUITABLE_DECODER_ERROR));
                        throw null;
                    }
                } catch (MediaCodecUtil.DecoderQueryException e2) {
                    m0(new DecoderInitializationException(this.u, e2, z, (int) DecoderInitializationException.DECODER_QUERY_ERROR));
                    throw null;
                }
            }
            if (i0(this.y)) {
                String str3 = this.y.f32997a;
                this.z = G(str3);
                this.A = H(str3, this.u);
                this.B = L(str3);
                this.C = K(str3);
                this.D = I(str3);
                this.E = J(str3);
                this.F = M(str3, this.u);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    t.a("createCodec:" + str3);
                    this.x = MediaCodec.createByCodecName(str3);
                    t.c();
                    t.a("configureCodec");
                    N(this.y, this.x, this.u, mediaCrypto);
                    t.c();
                    t.a("startCodec");
                    this.x.start();
                    t.c();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    X(str3, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.I = this.x.getInputBuffers();
                    this.J = this.x.getOutputBuffers();
                    this.K = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.L = -1;
                    this.M = -1;
                    this.W = true;
                    this.X.f34102a++;
                } catch (Exception e3) {
                    m0(new DecoderInitializationException(this.u, e3, z, str3));
                    throw null;
                }
            }
        }
    }

    public abstract void X(String str, long j2, long j3);

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
        if (r5.height == r0.height) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Y(Format format) throws ExoPlaybackException {
        MediaCodec mediaCodec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, format) == null) {
            Format format2 = this.u;
            this.u = format;
            boolean z = true;
            if (!v.a(format.drmInitData, format2 == null ? null : format2.drmInitData)) {
                if (this.u.drmInitData != null) {
                    c.i.b.a.z.a<c> aVar = this.n;
                    if (aVar != null) {
                        DrmSession<c> c2 = aVar.c(Looper.myLooper(), this.u.drmInitData);
                        this.w = c2;
                        if (c2 == this.v) {
                            this.n.a(c2);
                        }
                    } else {
                        throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), u());
                    }
                } else {
                    this.w = null;
                }
            }
            if (this.w == this.v && (mediaCodec = this.x) != null && F(mediaCodec, this.y.f32998b, format2, this.u)) {
                this.O = true;
                this.P = 1;
                int i2 = this.z;
                if (i2 != 2) {
                    if (i2 == 1) {
                        Format format3 = this.u;
                        if (format3.width == format2.width) {
                        }
                    }
                    z = false;
                }
                this.G = z;
            } else if (this.R) {
                this.Q = 1;
            } else {
                g0();
                W();
            }
        }
    }

    public abstract void Z(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException;

    @Override // c.i.b.a.s
    public final int a(Format format) throws ExoPlaybackException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, format)) == null) {
            try {
                return l0(this.m, this.n, format);
            } catch (MediaCodecUtil.DecoderQueryException e2) {
                throw ExoPlaybackException.createForRenderer(e2, u());
            }
        }
        return invokeL.intValue;
    }

    public void a0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
        }
    }

    @Override // c.i.b.a.r
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.U : invokeV.booleanValue;
    }

    public void b0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
        }
    }

    public final void c0() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.Q == 2) {
                g0();
                W();
                return;
            }
            this.U = true;
            h0();
        }
    }

    public abstract boolean d0(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) throws ExoPlaybackException;

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.J = this.x.getOutputBuffers();
        }
    }

    public final void f0() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            MediaFormat outputFormat = this.x.getOutputFormat();
            if (this.z != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                this.H = true;
                return;
            }
            if (this.F) {
                outputFormat.setInteger("channel-count", 1);
            }
            Z(this.x, outputFormat);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.K = -9223372036854775807L;
            this.L = -1;
            this.M = -1;
            this.V = false;
            this.N = false;
            this.s.clear();
            this.I = null;
            this.J = null;
            this.y = null;
            this.O = false;
            this.R = false;
            this.A = false;
            this.B = false;
            this.z = 0;
            this.C = false;
            this.D = false;
            this.F = false;
            this.G = false;
            this.H = false;
            this.S = false;
            this.P = 0;
            this.Q = 0;
            this.p.f34112g = null;
            MediaCodec mediaCodec = this.x;
            if (mediaCodec != null) {
                this.X.f34103b++;
                try {
                    mediaCodec.stop();
                    try {
                        this.x.release();
                        this.x = null;
                        DrmSession<c> drmSession = this.v;
                        if (drmSession == null || this.w == drmSession) {
                            return;
                        }
                        try {
                            this.n.a(drmSession);
                        } finally {
                        }
                    } catch (Throwable th) {
                        this.x = null;
                        DrmSession<c> drmSession2 = this.v;
                        if (drmSession2 != null && this.w != drmSession2) {
                            try {
                                this.n.a(drmSession2);
                            } finally {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        this.x.release();
                        this.x = null;
                        DrmSession<c> drmSession3 = this.v;
                        if (drmSession3 != null && this.w != drmSession3) {
                            try {
                                this.n.a(drmSession3);
                            } finally {
                            }
                        }
                        throw th2;
                    } catch (Throwable th3) {
                        this.x = null;
                        DrmSession<c> drmSession4 = this.v;
                        if (drmSession4 != null && this.w != drmSession4) {
                            try {
                                this.n.a(drmSession4);
                            } finally {
                            }
                        }
                        throw th3;
                    }
                }
            }
        }
    }

    public void h0() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    public boolean i0(c.i.b.a.b0.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, aVar)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.i.b.a.r
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (this.u == null || this.V || (!v() && this.M < 0 && (this.K == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.K))) ? false : true : invokeV.booleanValue;
    }

    public final boolean j0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048603, this, j2)) == null) {
            int size = this.s.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.s.get(i2).longValue() == j2) {
                    this.s.remove(i2);
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // c.i.b.a.r
    public void k(long j2, long j3) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (this.U) {
                h0();
                return;
            }
            if (this.u == null) {
                this.q.f();
                int C = C(this.r, this.q, true);
                if (C != -5) {
                    if (C == -4) {
                        c.i.b.a.i0.a.f(this.q.j());
                        this.T = true;
                        c0();
                        return;
                    }
                    return;
                }
                Y(this.r.f33945a);
            }
            W();
            if (this.x != null) {
                t.a("drainAndFeed");
                do {
                } while (O(j2, j3));
                do {
                } while (P());
                t.c();
            } else {
                this.X.f34105d += D(j2);
                this.q.f();
                int C2 = C(this.r, this.q, false);
                if (C2 == -5) {
                    Y(this.r.f33945a);
                } else if (C2 == -4) {
                    c.i.b.a.i0.a.f(this.q.j());
                    this.T = true;
                    c0();
                }
            }
            this.X.a();
        }
    }

    public final boolean k0(boolean z) throws ExoPlaybackException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) {
            if (this.v == null || (!z && this.o)) {
                return false;
            }
            int state = this.v.getState();
            if (state != 1) {
                return state != 4;
            }
            throw ExoPlaybackException.createForRenderer(this.v.getError(), u());
        }
        return invokeZ.booleanValue;
    }

    public abstract int l0(b bVar, c.i.b.a.z.a<c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException;

    public final void m0(DecoderInitializationException decoderInitializationException) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, decoderInitializationException) == null) {
            throw ExoPlaybackException.createForRenderer(decoderInitializationException, u());
        }
    }

    @Override // c.i.b.a.a, c.i.b.a.s
    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return 8;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    @Override // c.i.b.a.a
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.u = null;
            try {
                g0();
                try {
                    if (this.v != null) {
                        this.n.a(this.v);
                    }
                    try {
                        if (this.w != null && this.w != this.v) {
                            this.n.a(this.w);
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        if (this.w != null && this.w != this.v) {
                            this.n.a(this.w);
                        }
                        throw th;
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                try {
                    if (this.v != null) {
                        this.n.a(this.v);
                    }
                    try {
                        if (this.w != null && this.w != this.v) {
                            this.n.a(this.w);
                        }
                        throw th2;
                    } finally {
                    }
                } catch (Throwable th3) {
                    try {
                        if (this.w != null && this.w != this.v) {
                            this.n.a(this.w);
                        }
                        throw th3;
                    } finally {
                    }
                }
            }
        }
    }

    @Override // c.i.b.a.a
    public void x(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.X = new d();
        }
    }

    @Override // c.i.b.a.a
    public void y(long j2, boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.T = false;
            this.U = false;
            if (this.x != null) {
                Q();
            }
        }
    }

    @Override // c.i.b.a.a
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public static class DecoderInitializationException extends Exception {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CUSTOM_ERROR_CODE_BASE = -50000;
        public static final int DECODER_QUERY_ERROR = -49998;
        public static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public transient /* synthetic */ FieldHolder $fh;
        public final String decoderName;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecoderInitializationException(Format format, Throwable th, boolean z, int i2) {
            super("Decoder init failed: [" + i2 + "], " + format, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {format, th, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z;
            this.decoderName = null;
            this.diagnosticInfo = buildCustomDiagnosticInfo(i2);
        }

        public static String buildCustomDiagnosticInfo(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                String str = i2 < 0 ? "neg_" : "";
                return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(i2);
            }
            return (String) invokeI.objValue;
        }

        @TargetApi(21)
        public static String getDiagnosticInfoV21(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
                if (th instanceof MediaCodec.CodecException) {
                    return ((MediaCodec.CodecException) th).getDiagnosticInfo();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecoderInitializationException(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + format, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {format, th, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z;
            this.decoderName = str;
            this.diagnosticInfo = v.f33861a >= 21 ? getDiagnosticInfoV21(th) : null;
        }
    }
}
