package d.f.b.a.j0;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.video.DummySurface;
import d.f.b.a.i0.i;
import d.f.b.a.i0.t;
import d.f.b.a.i0.v;
import d.f.b.a.j0.e;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes10.dex */
public class c extends MediaCodecRenderer {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] N0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A0;
    public int B0;
    public int C0;
    public float D0;
    public int E0;
    public int F0;
    public int G0;
    public float H0;
    public boolean I0;
    public int J0;
    public C2021c K0;
    public long L0;
    public int M0;
    public final Context Z;
    public final d a0;
    public final e.a b0;
    public final long c0;
    public final int i0;
    public final boolean j0;
    public final long[] k0;
    public Format[] l0;
    public b m0;
    public boolean n0;
    public Surface o0;
    public Surface p0;
    public int q0;
    public boolean r0;
    public boolean s0;
    public long t0;
    public long u0;
    public int v0;
    public int w0;
    public int x0;
    public int y0;
    public float z0;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f73448a;

        /* renamed from: b  reason: collision with root package name */
        public final int f73449b;

        /* renamed from: c  reason: collision with root package name */
        public final int f73450c;

        public b(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73448a = i2;
            this.f73449b = i3;
            this.f73450c = i4;
        }
    }

    @TargetApi(23)
    /* renamed from: d.f.b.a.j0.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public final class C2021c implements MediaCodec.OnFrameRenderedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f73451a;

        public /* synthetic */ C2021c(c cVar, MediaCodec mediaCodec, a aVar) {
            this(cVar, mediaCodec);
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{mediaCodec, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                c cVar = this.f73451a;
                if (this != cVar.K0) {
                    return;
                }
                cVar.E0();
            }
        }

        public C2021c(c cVar, MediaCodec mediaCodec) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, mediaCodec};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73451a = cVar;
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(86310310, "Ld/f/b/a/j0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(86310310, "Ld/f/b/a/j0/c;");
                return;
            }
        }
        N0 = new int[]{1920, FeatureCodes.ADVANCE_BEAUTY, 1440, 1280, 960, 854, 640, RecordConstants.DEFAULT_PREVIEW_WIDTH, 480};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, d.f.b.a.b0.b bVar, long j, @Nullable d.f.b.a.z.a<d.f.b.a.z.c> aVar, boolean z, @Nullable Handler handler, @Nullable e eVar, int i2) {
        super(2, bVar, aVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, bVar, Long.valueOf(j), aVar, Boolean.valueOf(z), handler, eVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (d.f.b.a.b0.b) objArr2[1], (d.f.b.a.z.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c0 = j;
        this.i0 = i2;
        this.Z = context.getApplicationContext();
        this.a0 = new d(context);
        this.b0 = new e.a(handler, eVar);
        this.j0 = r0();
        this.k0 = new long[10];
        this.L0 = -9223372036854775807L;
        this.t0 = -9223372036854775807L;
        this.A0 = -1;
        this.B0 = -1;
        this.D0 = -1.0f;
        this.z0 = -1.0f;
        this.q0 = 1;
        o0();
    }

    public static boolean A0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? j < -30000 : invokeJ.booleanValue;
    }

    public static boolean B0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) ? j < -500000 : invokeJ.booleanValue;
    }

    @TargetApi(23)
    public static void L0(MediaCodec mediaCodec, Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, mediaCodec, surface) == null) {
            mediaCodec.setOutputSurface(surface);
        }
    }

    public static void N0(MediaCodec mediaCodec, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, mediaCodec, i2) == null) {
            mediaCodec.setVideoScalingMode(i2);
        }
    }

    public static boolean m0(boolean z, Format format, Format format2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Boolean.valueOf(z), format, format2})) == null) ? format.sampleMimeType.equals(format2.sampleMimeType) && z0(format) == z0(format2) && (z || (format.width == format2.width && format.height == format2.height)) : invokeCommon.booleanValue;
    }

    public static boolean p0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? (("deb".equals(v.f73413b) || "flo".equals(v.f73413b)) && "OMX.qcom.video.decoder.avc".equals(str)) || (("tcl_eu".equals(v.f73413b) || "SVP-DTV15".equals(v.f73413b) || "BRAVIA_ATV2".equals(v.f73413b)) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str)) : invokeL.booleanValue;
    }

    @TargetApi(21)
    public static void q0(MediaFormat mediaFormat, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, mediaFormat, i2) == null) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i2);
        }
    }

    public static boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? v.f73412a <= 22 && "foster".equals(v.f73413b) && "NVIDIA".equals(v.f73414c) : invokeV.booleanValue;
    }

    public static Point t0(d.f.b.a.b0.a aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLL;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, aVar, format)) == null) {
            boolean z = format.height > format.width;
            int i2 = z ? format.height : format.width;
            int i3 = z ? format.width : format.height;
            float f2 = i3 / i2;
            for (int i4 : N0) {
                int i5 = (int) (i4 * f2);
                if (i4 <= i2 || i5 <= i3) {
                    break;
                }
                if (v.f73412a >= 21) {
                    int i6 = z ? i5 : i4;
                    if (!z) {
                        i4 = i5;
                    }
                    Point b2 = aVar.b(i6, i4);
                    if (aVar.n(b2.x, b2.y, format.frameRate)) {
                        return b2;
                    }
                } else {
                    int f3 = v.f(i4, 16) * 16;
                    int f4 = v.f(i5, 16) * 16;
                    if (f3 * f4 <= MediaCodecUtil.l()) {
                        int i7 = z ? f4 : f3;
                        if (!z) {
                            f3 = f4;
                        }
                        return new Point(i7, f3);
                    }
                }
            }
            return null;
        }
        return (Point) invokeLL.objValue;
    }

    public static int v0(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, format)) == null) {
            if (format.maxInputSize != -1) {
                int size = format.initializationData.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i2 += format.initializationData.get(i3).length;
                }
                return format.maxInputSize + i2;
            }
            return w0(format.sampleMimeType, format.width, format.height);
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int w0(String str, int i2, int i3) {
        InterceptResult invokeLII;
        char c2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65548, null, str, i2, i3)) == null) {
            if (i2 == -1 || i3 == -1) {
                return -1;
            }
            int i5 = 4;
            switch (str.hashCode()) {
                case -1664118616:
                    if (str.equals("video/3gpp")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1662541442:
                    if (str.equals("video/hevc")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1187890754:
                    if (str.equals("video/mp4v-es")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1331836730:
                    if (str.equals("video/avc")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1599127256:
                    if (str.equals("video/x-vnd.on2.vp8")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1599127257:
                    if (str.equals("video/x-vnd.on2.vp9")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0 && c2 != 1) {
                if (c2 == 2) {
                    if ("BRAVIA 4K 2015".equals(v.f73415d)) {
                        return -1;
                    }
                    i4 = v.f(i2, 16) * v.f(i3, 16) * 16 * 16;
                    i5 = 2;
                    return (i4 * 3) / (i5 * 2);
                } else if (c2 != 3) {
                    if (c2 == 4 || c2 == 5) {
                        i4 = i2 * i3;
                        return (i4 * 3) / (i5 * 2);
                    }
                    return -1;
                }
            }
            i4 = i2 * i3;
            i5 = 2;
            return (i4 * 3) / (i5 * 2);
        }
        return invokeLII.intValue;
    }

    public static float y0(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, format)) == null) {
            float f2 = format.pixelWidthHeightRatio;
            if (f2 == -1.0f) {
                return 1.0f;
            }
            return f2;
        }
        return invokeL.floatValue;
    }

    public static int z0(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, format)) == null) {
            int i2 = format.rotationDegrees;
            if (i2 == -1) {
                return 0;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    @Override // d.f.b.a.a
    public void A(Format[] formatArr, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, formatArr, j) == null) {
            this.l0 = formatArr;
            if (this.L0 == -9223372036854775807L) {
                this.L0 = j;
            } else {
                int i2 = this.M0;
                if (i2 == this.k0.length) {
                    Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.k0[this.M0 - 1]);
                } else {
                    this.M0 = i2 + 1;
                }
                this.k0[this.M0 - 1] = j;
            }
            super.A(formatArr, j);
        }
    }

    public boolean C0(MediaCodec mediaCodec, int i2, long j, long j2) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaCodec, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int C = C(j2);
            if (C == 0) {
                return false;
            }
            this.X.f73650i++;
            S0(this.x0 + C);
            P();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.v0 <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.b0.d(this.v0, elapsedRealtime - this.u0);
        this.v0 = 0;
        this.u0 = elapsedRealtime;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean E(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{mediaCodec, Boolean.valueOf(z), format, format2})) == null) {
            if (m0(z, format, format2)) {
                int i2 = format2.width;
                b bVar = this.m0;
                if (i2 <= bVar.f73448a && format2.height <= bVar.f73449b && v0(format2) <= this.m0.f73450c) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.r0) {
            return;
        }
        this.r0 = true;
        this.b0.g(this.o0);
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.A0 == -1 && this.B0 == -1) {
                return;
            }
            if (this.E0 == this.A0 && this.F0 == this.B0 && this.G0 == this.C0 && this.H0 == this.D0) {
                return;
            }
            this.b0.h(this.A0, this.B0, this.C0, this.D0);
            this.E0 = this.A0;
            this.F0 = this.B0;
            this.G0 = this.C0;
            this.H0 = this.D0;
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.r0) {
            this.b0.g(this.o0);
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.E0 == -1 && this.F0 == -1) {
                return;
            }
            this.b0.h(this.E0, this.F0, this.G0, this.H0);
        }
    }

    public void I0(MediaCodec mediaCodec, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{mediaCodec, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            F0();
            t.a("releaseOutputBuffer");
            mediaCodec.releaseOutputBuffer(i2, true);
            t.c();
            this.X.f73646e++;
            this.w0 = 0;
            E0();
        }
    }

    @TargetApi(21)
    public void J0(MediaCodec mediaCodec, int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{mediaCodec, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            F0();
            t.a("releaseOutputBuffer");
            mediaCodec.releaseOutputBuffer(i2, j2);
            t.c();
            this.X.f73646e++;
            this.w0 = 0;
            E0();
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.t0 = this.c0 > 0 ? SystemClock.elapsedRealtime() + this.c0 : -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void M(d.f.b.a.b0.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, aVar, mediaCodec, format, mediaCrypto) == null) {
            b u0 = u0(aVar, format, this.l0);
            this.m0 = u0;
            MediaFormat x0 = x0(format, u0, this.j0, this.J0);
            if (this.o0 == null) {
                d.f.b.a.i0.a.f(Q0(aVar.f72608d));
                if (this.p0 == null) {
                    this.p0 = DummySurface.newInstanceV17(this.Z, aVar.f72608d);
                }
                this.o0 = this.p0;
            }
            mediaCodec.configure(x0, this.o0, mediaCrypto, 0);
            if (v.f73412a < 23 || !this.I0) {
                return;
            }
            this.K0 = new C2021c(this, mediaCodec, null);
        }
    }

    public final void M0(Surface surface) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surface) == null) {
            if (surface == null) {
                Surface surface2 = this.p0;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    d.f.b.a.b0.a R = R();
                    if (R != null && Q0(R.f72608d)) {
                        surface = DummySurface.newInstanceV17(this.Z, R.f72608d);
                        this.p0 = surface;
                    }
                }
            }
            if (this.o0 != surface) {
                this.o0 = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec Q = Q();
                    if (v.f73412a >= 23 && Q != null && surface != null && !this.n0) {
                        L0(Q, surface);
                    } else {
                        f0();
                        V();
                    }
                }
                if (surface != null && surface != this.p0) {
                    H0();
                    n0();
                    if (state == 2) {
                        K0();
                        return;
                    }
                    return;
                }
                o0();
                n0();
            } else if (surface == null || surface == this.p0) {
            } else {
                H0();
                G0();
            }
        }
    }

    public boolean O0(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? B0(j) : invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void P() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.P();
            this.x0 = 0;
            this.s0 = false;
        }
    }

    public boolean P0(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? A0(j) : invokeCommon.booleanValue;
    }

    public final boolean Q0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) ? v.f73412a >= 23 && !this.I0 && (!z || DummySurface.isSecureSupported(this.Z)) : invokeZ.booleanValue;
    }

    public void R0(MediaCodec mediaCodec, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{mediaCodec, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            t.a("skipVideoBuffer");
            mediaCodec.releaseOutputBuffer(i2, false);
            t.c();
            this.X.f73647f++;
        }
    }

    public void S0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            d.f.b.a.y.d dVar = this.X;
            dVar.f73648g += i2;
            this.v0 += i2;
            int i3 = this.w0 + i2;
            this.w0 = i3;
            dVar.f73649h = Math.max(i3, dVar.f73649h);
            if (this.v0 >= this.i0) {
                D0();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void W(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.b0.b(str, j, j2);
            this.n0 = p0(str);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void X(Format format) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, format) == null) {
            super.X(format);
            this.b0.f(format);
            this.z0 = y0(format);
            this.y0 = z0(format);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Y(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, mediaCodec, mediaFormat) == null) {
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            if (z) {
                integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                integer = mediaFormat.getInteger("width");
            }
            this.A0 = integer;
            if (z) {
                integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                integer2 = mediaFormat.getInteger("height");
            }
            this.B0 = integer2;
            this.D0 = this.z0;
            if (v.f73412a >= 21) {
                int i2 = this.y0;
                if (i2 == 90 || i2 == 270) {
                    int i3 = this.A0;
                    this.A0 = this.B0;
                    this.B0 = i3;
                    this.D0 = 1.0f / this.D0;
                }
            } else {
                this.C0 = this.y0;
            }
            N0(mediaCodec, this.q0);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void Z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.x0--;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void a0(d.f.b.a.y.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) {
            this.x0++;
            if (v.f73412a >= 23 || !this.I0) {
                return;
            }
            E0();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean c0(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j3, boolean z) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), mediaCodec, byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            while (true) {
                int i4 = this.M0;
                if (i4 == 0) {
                    break;
                }
                long[] jArr = this.k0;
                if (j3 < jArr[0]) {
                    break;
                }
                this.L0 = jArr[0];
                int i5 = i4 - 1;
                this.M0 = i5;
                System.arraycopy(jArr, 1, jArr, 0, i5);
            }
            long j5 = j3 - this.L0;
            if (z) {
                R0(mediaCodec, i2, j5);
                return true;
            }
            long j6 = j3 - j;
            if (this.o0 == this.p0) {
                if (A0(j6)) {
                    this.s0 = false;
                    R0(mediaCodec, i2, j5);
                    return true;
                }
                return false;
            } else if (this.r0 && !this.s0) {
                if (getState() != 2) {
                    return false;
                }
                long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j2);
                long nanoTime = System.nanoTime();
                long b2 = this.a0.b(j3, nanoTime + (elapsedRealtime * 1000));
                long j7 = (b2 - nanoTime) / 1000;
                if (!O0(j7, j2)) {
                    j4 = j7;
                } else if (C0(mediaCodec, i2, j5, j)) {
                    this.s0 = true;
                    return false;
                } else {
                    j4 = j7;
                }
                if (P0(j4, j2)) {
                    s0(mediaCodec, i2, j5);
                    return true;
                }
                if (v.f73412a >= 21) {
                    if (j4 < 50000) {
                        J0(mediaCodec, i2, j5, b2);
                        return true;
                    }
                } else if (j4 < 30000) {
                    if (j4 > 11000) {
                        try {
                            Thread.sleep((j4 - 10000) / 1000);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    I0(mediaCodec, i2, j5);
                    return true;
                }
                return false;
            } else {
                this.s0 = false;
                if (v.f73412a >= 21) {
                    J0(mediaCodec, i2, j5, System.nanoTime());
                } else {
                    I0(mediaCodec, i2, j5);
                }
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            try {
                super.f0();
            } finally {
                this.x0 = 0;
                this.s0 = false;
                Surface surface = this.p0;
                if (surface != null) {
                    if (this.o0 == surface) {
                        this.o0 = null;
                    }
                    this.p0.release();
                    this.p0 = null;
                }
            }
        }
    }

    @Override // d.f.b.a.a, d.f.b.a.g.a
    public void g(int i2, Object obj) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048602, this, i2, obj) == null) {
            if (i2 == 1) {
                M0((Surface) obj);
            } else if (i2 == 4) {
                this.q0 = ((Integer) obj).intValue();
                MediaCodec Q = Q();
                if (Q != null) {
                    N0(Q, this.q0);
                }
            } else {
                super.g(i2, obj);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean h0(d.f.b.a.b0.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, aVar)) == null) ? this.o0 != null || Q0(aVar.f72608d) : invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.r
    public boolean isReady() {
        InterceptResult invokeV;
        Surface surface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (super.isReady() && (this.r0 || (((surface = this.p0) != null && this.o0 == surface) || Q() == null || this.I0))) {
                this.t0 = -9223372036854775807L;
                return true;
            } else if (this.t0 == -9223372036854775807L) {
                return false;
            } else {
                if (SystemClock.elapsedRealtime() < this.t0) {
                    return true;
                }
                this.t0 = -9223372036854775807L;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int k0(d.f.b.a.b0.b bVar, d.f.b.a.z.a<d.f.b.a.z.c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLL;
        boolean z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048605, this, bVar, aVar, format)) == null) {
            String str = format.sampleMimeType;
            if (i.i(str)) {
                DrmInitData drmInitData = format.drmInitData;
                if (drmInitData != null) {
                    z = false;
                    for (int i4 = 0; i4 < drmInitData.schemeDataCount; i4++) {
                        z |= drmInitData.get(i4).requiresSecureDecryption;
                    }
                } else {
                    z = false;
                }
                d.f.b.a.b0.a a2 = bVar.a(str, z);
                if (a2 == null) {
                    return (!z || bVar.a(str, false) == null) ? 1 : 2;
                } else if (d.f.b.a.a.D(aVar, drmInitData)) {
                    boolean i5 = a2.i(format.codecs);
                    if (i5 && (i2 = format.width) > 0 && (i3 = format.height) > 0) {
                        if (v.f73412a >= 21) {
                            i5 = a2.n(i2, i3, format.frameRate);
                        } else {
                            boolean z2 = i2 * i3 <= MediaCodecUtil.l();
                            if (!z2) {
                                Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.width + "x" + format.height + "] [" + v.f73416e + PreferencesUtil.RIGHT_MOUNT);
                            }
                            i5 = z2;
                        }
                    }
                    return (i5 ? 4 : 3) | (a2.f72606b ? 16 : 8) | (a2.f72607c ? 32 : 0);
                } else {
                    return 2;
                }
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    public final void n0() {
        MediaCodec Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.r0 = false;
            if (v.f73412a < 23 || !this.I0 || (Q = Q()) == null) {
                return;
            }
            this.K0 = new C2021c(this, Q, null);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.E0 = -1;
            this.F0 = -1;
            this.H0 = -1.0f;
            this.G0 = -1;
        }
    }

    public void s0(MediaCodec mediaCodec, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{mediaCodec, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            t.a("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i2, false);
            t.c();
            S0(1);
        }
    }

    public b u0(d.f.b.a.b0.a aVar, Format format, Format[] formatArr) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048609, this, aVar, format, formatArr)) == null) {
            int i2 = format.width;
            int i3 = format.height;
            int v0 = v0(format);
            if (formatArr.length == 1) {
                return new b(i2, i3, v0);
            }
            boolean z = false;
            for (Format format2 : formatArr) {
                if (m0(aVar.f72606b, format, format2)) {
                    z |= format2.width == -1 || format2.height == -1;
                    i2 = Math.max(i2, format2.width);
                    i3 = Math.max(i3, format2.height);
                    v0 = Math.max(v0, v0(format2));
                }
            }
            if (z) {
                Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i2 + "x" + i3);
                Point t0 = t0(aVar, format);
                if (t0 != null) {
                    i2 = Math.max(i2, t0.x);
                    i3 = Math.max(i3, t0.y);
                    v0 = Math.max(v0, w0(format.sampleMimeType, i2, i3));
                    Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i2 + "x" + i3);
                }
            }
            return new b(i2, i3, v0);
        }
        return (b) invokeLLL.objValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.a
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.A0 = -1;
            this.B0 = -1;
            this.D0 = -1.0f;
            this.z0 = -1.0f;
            this.L0 = -9223372036854775807L;
            this.M0 = 0;
            o0();
            n0();
            this.a0.d();
            this.K0 = null;
            this.I0 = false;
            try {
                super.v();
            } finally {
                this.X.a();
                this.b0.c(this.X);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.a
    public void w(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            super.w(z);
            int i2 = s().f73517a;
            this.J0 = i2;
            this.I0 = i2 != 0;
            this.b0.e(this.X);
            this.a0.e();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.a
    public void x(long j, boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            super.x(j, z);
            n0();
            this.w0 = 0;
            int i2 = this.M0;
            if (i2 != 0) {
                this.L0 = this.k0[i2 - 1];
                this.M0 = 0;
            }
            if (z) {
                K0();
            } else {
                this.t0 = -9223372036854775807L;
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat x0(Format format, b bVar, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{format, bVar, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            MediaFormat frameworkMediaFormatV16 = format.getFrameworkMediaFormatV16();
            frameworkMediaFormatV16.setInteger("max-width", bVar.f73448a);
            frameworkMediaFormatV16.setInteger("max-height", bVar.f73449b);
            int i3 = bVar.f73450c;
            if (i3 != -1) {
                frameworkMediaFormatV16.setInteger("max-input-size", i3);
            }
            if (z) {
                frameworkMediaFormatV16.setInteger("auto-frc", 0);
            }
            if (i2 != 0) {
                q0(frameworkMediaFormatV16, i2);
            }
            return frameworkMediaFormatV16;
        }
        return (MediaFormat) invokeCommon.objValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.a
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.y();
            this.v0 = 0;
            this.u0 = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.a
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.t0 = -9223372036854775807L;
            D0();
            super.z();
        }
    }
}
