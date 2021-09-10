package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import c.i.b.a.p;
import c.i.b.a.x.f;
import c.i.b.a.x.h;
import c.i.b.a.x.j;
import c.i.b.a.x.k;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public final class DefaultAudioSink implements AudioSink {
    public static /* synthetic */ Interceptable $ic;
    public static boolean h0;
    public static boolean i0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public long D;
    public long E;
    public boolean F;
    public long G;
    public Method H;
    public int I;
    public long J;
    public long K;
    public int L;
    public long M;
    public long N;
    public int O;
    public int P;
    public long Q;
    public long R;
    public long S;
    public float T;
    public AudioProcessor[] U;
    public ByteBuffer[] V;
    public ByteBuffer W;
    public ByteBuffer X;
    public byte[] Y;
    public int Z;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final c.i.b.a.x.c f70067a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.x.e f70068b;
    public boolean b0;

    /* renamed from: c  reason: collision with root package name */
    public final k f70069c;
    public boolean c0;

    /* renamed from: d  reason: collision with root package name */
    public final j f70070d;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public final AudioProcessor[] f70071e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public final ConditionVariable f70072f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public final long[] f70073g;
    public long g0;

    /* renamed from: h  reason: collision with root package name */
    public final c f70074h;

    /* renamed from: i  reason: collision with root package name */
    public final LinkedList<e> f70075i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public AudioSink.a f70076j;
    public AudioTrack k;
    public AudioTrack l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public c.i.b.a.x.b r;
    public boolean s;
    public int t;
    public long u;
    public p v;
    public p w;
    public long x;
    public long y;
    public ByteBuffer z;

    /* loaded from: classes9.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AudioTrack f70077e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DefaultAudioSink f70078f;

        public a(DefaultAudioSink defaultAudioSink, AudioTrack audioTrack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultAudioSink, audioTrack};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70078f = defaultAudioSink;
            this.f70077e = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f70077e.flush();
                    this.f70077e.release();
                } finally {
                    this.f70078f.f70072f.open();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AudioTrack f70079e;

        public b(DefaultAudioSink defaultAudioSink, AudioTrack audioTrack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultAudioSink, audioTrack};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70079e = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70079e.release();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AudioTrack f70080a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f70081b;

        /* renamed from: c  reason: collision with root package name */
        public int f70082c;

        /* renamed from: d  reason: collision with root package name */
        public long f70083d;

        /* renamed from: e  reason: collision with root package name */
        public long f70084e;

        /* renamed from: f  reason: collision with root package name */
        public long f70085f;

        /* renamed from: g  reason: collision with root package name */
        public long f70086g;

        /* renamed from: h  reason: collision with root package name */
        public long f70087h;

        /* renamed from: i  reason: collision with root package name */
        public long f70088i;

        /* renamed from: j  reason: collision with root package name */
        public long f70089j;

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
                }
            }
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f70086g != -9223372036854775807L) {
                    return Math.min(this.f70089j, this.f70088i + ((((SystemClock.elapsedRealtime() * 1000) - this.f70086g) * this.f70082c) / 1000000));
                }
                int playState = this.f70080a.getPlayState();
                if (playState == 1) {
                    return 0L;
                }
                long playbackHeadPosition = 4294967295L & this.f70080a.getPlaybackHeadPosition();
                if (this.f70081b) {
                    if (playState == 2 && playbackHeadPosition == 0) {
                        this.f70085f = this.f70083d;
                    }
                    playbackHeadPosition += this.f70085f;
                }
                if (v.f33838a <= 26) {
                    if (playbackHeadPosition == 0 && this.f70083d > 0 && playState == 3) {
                        if (this.f70087h == -9223372036854775807L) {
                            this.f70087h = SystemClock.elapsedRealtime();
                        }
                        return this.f70083d;
                    }
                    this.f70087h = -9223372036854775807L;
                }
                if (this.f70083d > playbackHeadPosition) {
                    this.f70084e++;
                }
                this.f70083d = playbackHeadPosition;
                return playbackHeadPosition + (this.f70084e << 32);
            }
            return invokeV.longValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (a() * 1000000) / this.f70082c : invokeV.longValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.longValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.longValue;
        }

        public void e(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
                this.f70088i = a();
                this.f70086g = SystemClock.elapsedRealtime() * 1000;
                this.f70089j = j2;
                this.f70080a.stop();
            }
        }

        public boolean f(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) ? this.f70087h != -9223372036854775807L && j2 > 0 && SystemClock.elapsedRealtime() - this.f70087h >= 200 : invokeJ.booleanValue;
        }

        public void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f70086g == -9223372036854775807L) {
                this.f70080a.pause();
            }
        }

        public void h(AudioTrack audioTrack, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048583, this, audioTrack, z) == null) {
                this.f70080a = audioTrack;
                this.f70081b = z;
                this.f70086g = -9223372036854775807L;
                this.f70087h = -9223372036854775807L;
                this.f70083d = 0L;
                this.f70084e = 0L;
                this.f70085f = 0L;
                if (audioTrack != null) {
                    this.f70082c = audioTrack.getSampleRate();
                }
            }
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    @TargetApi(19)
    /* loaded from: classes9.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AudioTimestamp k;
        public long l;
        public long m;
        public long n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.c
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : invokeV.longValue;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.c
        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k.nanoTime : invokeV.longValue;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.c
        public void h(AudioTrack audioTrack, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, audioTrack, z) == null) {
                super.h(audioTrack, z);
                this.l = 0L;
                this.m = 0L;
                this.n = 0L;
            }
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.c
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                boolean timestamp = this.f70080a.getTimestamp(this.k);
                if (timestamp) {
                    long j2 = this.k.framePosition;
                    if (this.m > j2) {
                        this.l++;
                    }
                    this.m = j2;
                    this.n = j2 + (this.l << 32);
                }
                return timestamp;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final p f70090a;

        /* renamed from: b  reason: collision with root package name */
        public final long f70091b;

        /* renamed from: c  reason: collision with root package name */
        public final long f70092c;

        public /* synthetic */ e(p pVar, long j2, long j3, a aVar) {
            this(pVar, j2, j3);
        }

        public e(p pVar, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70090a = pVar;
            this.f70091b = j2;
            this.f70092c = j3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(278210556, "Lcom/google/android/exoplayer2/audio/DefaultAudioSink;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(278210556, "Lcom/google/android/exoplayer2/audio/DefaultAudioSink;");
        }
    }

    public DefaultAudioSink(@Nullable c.i.b.a.x.c cVar, AudioProcessor[] audioProcessorArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, audioProcessorArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70067a = cVar;
        this.f70072f = new ConditionVariable(true);
        if (v.f33838a >= 18) {
            try {
                this.H = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (v.f33838a >= 19) {
            this.f70074h = new d();
        } else {
            this.f70074h = new c(null);
        }
        this.f70068b = new c.i.b.a.x.e();
        this.f70069c = new k();
        this.f70070d = new j();
        AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 4];
        this.f70071e = audioProcessorArr2;
        audioProcessorArr2[0] = new h();
        AudioProcessor[] audioProcessorArr3 = this.f70071e;
        audioProcessorArr3[1] = this.f70068b;
        audioProcessorArr3[2] = this.f70069c;
        System.arraycopy(audioProcessorArr, 0, audioProcessorArr3, 3, audioProcessorArr.length);
        this.f70071e[audioProcessorArr.length + 3] = this.f70070d;
        this.f70073g = new long[10];
        this.T = 1.0f;
        this.P = 0;
        this.r = c.i.b.a.x.b.f33991e;
        this.d0 = 0;
        this.w = p.f33942d;
        this.a0 = -1;
        this.U = new AudioProcessor[0];
        this.V = new ByteBuffer[0];
        this.f70075i = new LinkedList<>();
    }

    @TargetApi(21)
    public static void M(AudioTrack audioTrack, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65538, null, audioTrack, f2) == null) {
            audioTrack.setVolume(f2);
        }
    }

    public static void N(AudioTrack audioTrack, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65539, null, audioTrack, f2) == null) {
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    @TargetApi(21)
    public static int P(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, audioTrack, byteBuffer, i2)) == null) ? audioTrack.write(byteBuffer, i2, 1) : invokeLLI.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int u(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            switch (str.hashCode()) {
                case -1095064472:
                    if (str.equals("audio/vnd.dts")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 187078296:
                    if (str.equals("audio/ac3")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1504578661:
                    if (str.equals("audio/eac3")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1505942594:
                    if (str.equals("audio/vnd.dts.hd")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return c2 != 3 ? 0 : 8;
                    }
                    return 7;
                }
                return 6;
            }
            return 5;
        }
        return invokeL.intValue;
    }

    public static int v(int i2, ByteBuffer byteBuffer) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i2, byteBuffer)) == null) {
            if (i2 == 7 || i2 == 8) {
                return f.b(byteBuffer);
            }
            if (i2 == 5) {
                return c.i.b.a.x.a.a();
            }
            if (i2 == 6) {
                return c.i.b.a.x.a.g(byteBuffer);
            }
            throw new IllegalStateException("Unexpected audio encoding: " + i2);
        }
        return invokeIL.intValue;
    }

    public final AudioTrack A() throws AudioSink.InitializationException {
        InterceptResult invokeV;
        AudioTrack audioTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (v.f33838a >= 21) {
                audioTrack = q();
            } else {
                int t = v.t(this.r.f33994c);
                if (this.d0 == 0) {
                    audioTrack = new AudioTrack(t, this.n, this.o, this.q, this.t, 1);
                } else {
                    audioTrack = new AudioTrack(t, this.n, this.o, this.q, this.t, 1, this.d0);
                }
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new AudioSink.InitializationException(state, this.n, this.o, this.t);
        }
        return (AudioTrack) invokeV.objValue;
    }

    public final AudioTrack B(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new AudioTrack(3, 4000, 4, 2, 2, 0, i2) : (AudioTrack) invokeI.objValue;
    }

    public final long C(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? (j2 * 1000000) / this.m : invokeJ.longValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l != null : invokeV.booleanValue;
    }

    public final void E() {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long b2 = this.f70074h.b();
            if (b2 == 0) {
                return;
            }
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.E >= 30000) {
                long[] jArr = this.f70073g;
                int i2 = this.B;
                jArr[i2] = b2 - nanoTime;
                this.B = (i2 + 1) % 10;
                int i3 = this.C;
                if (i3 < 10) {
                    this.C = i3 + 1;
                }
                this.E = nanoTime;
                this.D = 0L;
                int i4 = 0;
                while (true) {
                    int i5 = this.C;
                    if (i4 >= i5) {
                        break;
                    }
                    this.D += this.f70073g[i4] / i5;
                    i4++;
                }
            }
            if (!F() && nanoTime - this.G >= 500000) {
                boolean i6 = this.f70074h.i();
                this.F = i6;
                if (i6) {
                    long d2 = this.f70074h.d() / 1000;
                    long c2 = this.f70074h.c();
                    if (d2 < this.R) {
                        this.F = false;
                    } else if (Math.abs(d2 - nanoTime) > 5000000) {
                        String str = "Spurious audio timestamp (system clock mismatch): " + c2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + d2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + nanoTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + w() + StringUtil.ARRAY_ELEMENT_SEPARATOR + x();
                        if (!i0) {
                            this.F = false;
                        } else {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                    } else if (Math.abs(t(c2) - b2) > 5000000) {
                        String str2 = "Spurious audio timestamp (frame position mismatch): " + c2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + d2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + nanoTime + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + w() + StringUtil.ARRAY_ELEMENT_SEPARATOR + x();
                        if (!i0) {
                            this.F = false;
                        } else {
                            throw new InvalidAudioTrackTimestampException(str2);
                        }
                    }
                }
                if (this.H != null && !this.s) {
                    try {
                        long intValue = (((Integer) method.invoke(this.l, null)).intValue() * 1000) - this.u;
                        this.S = intValue;
                        long max = Math.max(intValue, 0L);
                        this.S = max;
                        if (max > 5000000) {
                            String str3 = "Ignoring impossibly large audio latency: " + this.S;
                            this.S = 0L;
                        }
                    } catch (Exception unused) {
                        this.H = null;
                    }
                }
                this.G = nanoTime;
            }
        }
    }

    public final boolean F() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? v.f33838a < 23 && ((i2 = this.q) == 5 || i2 == 6) : invokeV.booleanValue;
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? F() && this.l.getPlayState() == 2 && this.l.getPlaybackHeadPosition() == 0 : invokeV.booleanValue;
    }

    public final void H(long j2) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            int length = this.U.length;
            int i2 = length;
            while (i2 >= 0) {
                if (i2 > 0) {
                    byteBuffer = this.V[i2 - 1];
                } else {
                    byteBuffer = this.W;
                    if (byteBuffer == null) {
                        byteBuffer = AudioProcessor.f70066a;
                    }
                }
                if (i2 == length) {
                    O(byteBuffer, j2);
                } else {
                    AudioProcessor audioProcessor = this.U[i2];
                    audioProcessor.a(byteBuffer);
                    ByteBuffer g2 = audioProcessor.g();
                    this.V[i2] = g2;
                    if (g2.hasRemaining()) {
                        i2++;
                    }
                }
                if (byteBuffer.hasRemaining()) {
                    return;
                }
                i2--;
            }
        }
    }

    public final void I() {
        AudioTrack audioTrack;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (audioTrack = this.k) == null) {
            return;
        }
        this.k = null;
        new b(this, audioTrack).start();
    }

    public final void J() {
        AudioProcessor[] audioProcessorArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            for (AudioProcessor audioProcessor : this.f70071e) {
                if (audioProcessor.isActive()) {
                    arrayList.add(audioProcessor);
                } else {
                    audioProcessor.flush();
                }
            }
            int size = arrayList.size();
            this.U = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
            this.V = new ByteBuffer[size];
            for (int i2 = 0; i2 < size; i2++) {
                AudioProcessor audioProcessor2 = this.U[i2];
                audioProcessor2.flush();
                this.V[i2] = audioProcessor2.g();
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.D = 0L;
            this.C = 0;
            this.B = 0;
            this.E = 0L;
            this.F = false;
            this.G = 0L;
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && D()) {
            if (v.f33838a >= 21) {
                M(this.l, this.T);
            } else {
                N(this.l, this.T);
            }
        }
    }

    public final boolean O(ByteBuffer byteBuffer, long j2) throws AudioSink.WriteException {
        InterceptResult invokeLJ;
        int P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048588, this, byteBuffer, j2)) == null) {
            if (byteBuffer.hasRemaining()) {
                ByteBuffer byteBuffer2 = this.X;
                if (byteBuffer2 != null) {
                    c.i.b.a.i0.a.a(byteBuffer2 == byteBuffer);
                } else {
                    this.X = byteBuffer;
                    if (v.f33838a < 21) {
                        int remaining = byteBuffer.remaining();
                        byte[] bArr = this.Y;
                        if (bArr == null || bArr.length < remaining) {
                            this.Y = new byte[remaining];
                        }
                        int position = byteBuffer.position();
                        byteBuffer.get(this.Y, 0, remaining);
                        byteBuffer.position(position);
                        this.Z = 0;
                    }
                }
                int remaining2 = byteBuffer.remaining();
                if (v.f33838a < 21) {
                    int a2 = this.t - ((int) (this.M - (this.f70074h.a() * this.L)));
                    if (a2 > 0) {
                        P = this.l.write(this.Y, this.Z, Math.min(remaining2, a2));
                        if (P > 0) {
                            this.Z += P;
                            byteBuffer.position(byteBuffer.position() + P);
                        }
                    } else {
                        P = 0;
                    }
                } else if (this.e0) {
                    c.i.b.a.i0.a.f(j2 != -9223372036854775807L);
                    P = Q(this.l, byteBuffer, remaining2, j2);
                } else {
                    P = P(this.l, byteBuffer, remaining2);
                }
                this.g0 = SystemClock.elapsedRealtime();
                if (P >= 0) {
                    if (!this.s) {
                        this.M += P;
                    }
                    if (P == remaining2) {
                        if (this.s) {
                            this.N += this.O;
                        }
                        this.X = null;
                        return true;
                    }
                    return false;
                }
                throw new AudioSink.WriteException(P);
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }

    @TargetApi(21)
    public final int Q(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{audioTrack, byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (this.z == null) {
                ByteBuffer allocate = ByteBuffer.allocate(16);
                this.z = allocate;
                allocate.order(ByteOrder.BIG_ENDIAN);
                this.z.putInt(1431633921);
            }
            if (this.A == 0) {
                this.z.putInt(4, i2);
                this.z.putLong(8, j2 * 1000);
                this.z.position(0);
                this.A = i2;
            }
            int remaining = this.z.remaining();
            if (remaining > 0) {
                int write = audioTrack.write(this.z, remaining, 1);
                if (write < 0) {
                    this.A = 0;
                    return write;
                } else if (write < remaining) {
                    return 0;
                }
            }
            int P = P(audioTrack, byteBuffer, i2);
            if (P < 0) {
                this.A = 0;
                return P;
            }
            this.A -= P;
            return P;
        }
        return invokeCommon.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.e0) {
            this.e0 = false;
            this.d0 = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? !D() || (this.b0 && !i()) : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public p c(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pVar)) == null) {
            if (this.s) {
                p pVar2 = p.f33942d;
                this.w = pVar2;
                return pVar2;
            }
            float k = this.f70070d.k(pVar.f33943a);
            j jVar = this.f70070d;
            float f2 = pVar.f33944b;
            jVar.j(f2);
            p pVar3 = new p(k, f2);
            p pVar4 = this.v;
            if (pVar4 == null) {
                pVar4 = !this.f70075i.isEmpty() ? this.f70075i.getLast().f70090a : this.w;
            }
            if (!pVar3.equals(pVar4)) {
                if (D()) {
                    this.v = pVar3;
                } else {
                    this.w = pVar3;
                }
            }
            return this.w;
        }
        return (p) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.w : (p) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void e(c.i.b.a.x.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) || this.r.equals(bVar)) {
            return;
        }
        this.r = bVar;
        if (this.e0) {
            return;
        }
        reset();
        this.d0 = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean f(ByteBuffer byteBuffer, long j2) throws AudioSink.InitializationException, AudioSink.WriteException {
        InterceptResult invokeLJ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048595, this, byteBuffer, j2)) == null) {
            ByteBuffer byteBuffer2 = this.W;
            c.i.b.a.i0.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
            if (!D()) {
                z();
                if (this.c0) {
                    play();
                }
            }
            if (F()) {
                if (this.l.getPlayState() == 2) {
                    this.f0 = false;
                    return false;
                } else if (this.l.getPlayState() == 1 && this.f70074h.a() != 0) {
                    return false;
                }
            }
            boolean z = this.f0;
            boolean i3 = i();
            this.f0 = i3;
            if (z && !i3 && this.l.getPlayState() != 1 && this.f70076j != null) {
                this.f70076j.b(this.t, c.i.b.a.b.b(this.u), SystemClock.elapsedRealtime() - this.g0);
            }
            if (this.W == null) {
                if (!byteBuffer.hasRemaining()) {
                    return true;
                }
                if (this.s && this.O == 0) {
                    this.O = v(this.q, byteBuffer);
                }
                if (this.v != null) {
                    if (!r()) {
                        return false;
                    }
                    this.f70075i.add(new e(this.v, Math.max(0L, j2), t(x()), null));
                    this.v = null;
                    J();
                }
                if (this.P == 0) {
                    this.Q = Math.max(0L, j2);
                    this.P = 1;
                } else {
                    long C = this.Q + C(w());
                    if (this.P != 1 || Math.abs(C - j2) <= 200000) {
                        i2 = 2;
                    } else {
                        String str = "Discontinuity detected [expected " + C + ", got " + j2 + PreferencesUtil.RIGHT_MOUNT;
                        i2 = 2;
                        this.P = 2;
                    }
                    if (this.P == i2) {
                        this.Q += j2 - C;
                        this.P = 1;
                        AudioSink.a aVar = this.f70076j;
                        if (aVar != null) {
                            aVar.c();
                        }
                    }
                }
                if (this.s) {
                    this.K += this.O;
                } else {
                    this.J += byteBuffer.remaining();
                }
                this.W = byteBuffer;
            }
            if (this.s) {
                O(this.W, j2);
            } else {
                H(j2);
            }
            if (!this.W.hasRemaining()) {
                this.W = null;
                return true;
            } else if (this.f70074h.f(x())) {
                reset();
                return true;
            } else {
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            c.i.b.a.i0.a.f(v.f33838a >= 21);
            if (this.e0 && this.d0 == i2) {
                return;
            }
            this.e0 = true;
            this.d0 = i2;
            reset();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x014e  */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(String str, int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6, int i7) throws AudioSink.ConfigurationException {
        boolean z;
        int i8;
        AudioProcessor[] audioProcessorArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.m = i3;
            boolean z2 = !"audio/raw".equals(str);
            if (!z2) {
                this.I = v.s(i4, i2);
                this.f70069c.i(i6, i7);
                this.f70068b.i(iArr);
                z = false;
                for (AudioProcessor audioProcessor : this.f70071e) {
                    try {
                        z |= audioProcessor.h(i3, i2, i4);
                        if (audioProcessor.isActive()) {
                            i2 = audioProcessor.c();
                            i3 = audioProcessor.d();
                            i4 = audioProcessor.e();
                        }
                    } catch (AudioProcessor.UnhandledFormatException e2) {
                        throw new AudioSink.ConfigurationException(e2);
                    }
                }
                if (z) {
                    J();
                }
            } else {
                i4 = u(str);
                z = false;
            }
            int i9 = GDiffPatcher.COPY_INT_UBYTE;
            int i10 = 12;
            switch (i2) {
                case 1:
                    i8 = 4;
                    break;
                case 2:
                    i8 = 12;
                    break;
                case 3:
                    i8 = 28;
                    break;
                case 4:
                    i8 = 204;
                    break;
                case 5:
                    i8 = PassLivenessRecogActivity.S;
                    break;
                case 6:
                    i8 = GDiffPatcher.COPY_INT_UBYTE;
                    break;
                case 7:
                    i8 = 1276;
                    break;
                case 8:
                    i8 = c.i.b.a.b.f32969a;
                    break;
                default:
                    throw new AudioSink.ConfigurationException("Unsupported channel count: " + i2);
            }
            if (v.f33838a <= 23 && "foster".equals(v.f33839b) && "NVIDIA".equals(v.f33840c)) {
                if (i2 != 3 && i2 != 5) {
                    if (i2 == 7) {
                        i9 = c.i.b.a.b.f32969a;
                    }
                }
                if (v.f33838a <= 25 || !"fugu".equals(v.f33839b) || !z2 || i2 != 1) {
                    i10 = i9;
                }
                if (z && D() && this.p == i4 && this.n == i3 && this.o == i10) {
                    return;
                }
                reset();
                this.p = i4;
                this.s = z2;
                this.n = i3;
                this.o = i10;
                if (!z2) {
                    i4 = 2;
                }
                this.q = i4;
                this.L = v.s(2, i2);
                if (i5 == 0) {
                    this.t = i5;
                } else if (z2) {
                    int i11 = this.q;
                    if (i11 != 5 && i11 != 6) {
                        this.t = 49152;
                    } else {
                        this.t = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;
                    }
                } else {
                    int minBufferSize = AudioTrack.getMinBufferSize(i3, i10, this.q);
                    c.i.b.a.i0.a.f(minBufferSize != -2);
                    int i12 = minBufferSize * 4;
                    int s = ((int) s(250000L)) * this.L;
                    int max = (int) Math.max(minBufferSize, s(750000L) * this.L);
                    if (i12 < s) {
                        i12 = s;
                    } else if (i12 > max) {
                        i12 = max;
                    }
                    this.t = i12;
                }
                this.u = !z2 ? -9223372036854775807L : t(this.t / this.L);
                c(this.w);
            }
            i9 = i8;
            if (v.f33838a <= 25) {
            }
            i10 = i9;
            if (z) {
            }
            reset();
            this.p = i4;
            this.s = z2;
            this.n = i3;
            this.o = i10;
            if (!z2) {
            }
            this.q = i4;
            this.L = v.s(2, i2);
            if (i5 == 0) {
            }
            this.u = !z2 ? -9223372036854775807L : t(this.t / this.L);
            c(this.w);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? D() && (x() > this.f70074h.a() || G()) : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void j(AudioSink.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            this.f70076j = aVar;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void k() throws AudioSink.WriteException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && !this.b0 && D() && r()) {
            this.f70074h.e(x());
            this.A = 0;
            this.b0 = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long l(boolean z) {
        InterceptResult invokeZ;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
            if (y()) {
                if (this.l.getPlayState() == 3) {
                    E();
                }
                long nanoTime = System.nanoTime() / 1000;
                if (this.F) {
                    j2 = t(this.f70074h.c() + s(nanoTime - (this.f70074h.d() / 1000)));
                } else {
                    if (this.C == 0) {
                        j2 = this.f70074h.b();
                    } else {
                        j2 = nanoTime + this.D;
                    }
                    if (!z) {
                        j2 -= this.S;
                    }
                }
                return this.Q + p(Math.min(j2, t(x())));
            }
            return Long.MIN_VALUE;
        }
        return invokeZ.longValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.P == 1) {
            this.P = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            c.i.b.a.x.c cVar = this.f70067a;
            return cVar != null && cVar.c(u(str));
        }
        return invokeL.booleanValue;
    }

    public final long p(long j2) {
        long j3;
        long j4;
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048604, this, j2)) == null) {
            while (!this.f70075i.isEmpty() && j2 >= this.f70075i.getFirst().f70092c) {
                e remove = this.f70075i.remove();
                this.w = remove.f70090a;
                this.y = remove.f70092c;
                this.x = remove.f70091b - this.Q;
            }
            if (this.w.f33943a == 1.0f) {
                return (j2 + this.x) - this.y;
            }
            if (this.f70075i.isEmpty()) {
                j3 = this.x;
                j4 = this.f70070d.i(j2 - this.y);
            } else {
                j3 = this.x;
                j4 = (long) (this.w.f33943a * (j2 - this.y));
            }
            return j3 + j4;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.c0 = false;
            if (D()) {
                K();
                this.f70074h.g();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.c0 = true;
            if (D()) {
                this.R = System.nanoTime() / 1000;
                this.l.play();
            }
        }
    }

    @TargetApi(21)
    public final AudioTrack q() {
        InterceptResult invokeV;
        AudioAttributes a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.e0) {
                a2 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
            } else {
                a2 = this.r.a();
            }
            AudioAttributes audioAttributes = a2;
            AudioFormat build = new AudioFormat.Builder().setChannelMask(this.o).setEncoding(this.q).setSampleRate(this.n).build();
            int i2 = this.d0;
            return new AudioTrack(audioAttributes, build, this.t, 1, i2 != 0 ? i2 : 0);
        }
        return (AudioTrack) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0036 -> B:11:0x0016). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r() throws AudioSink.WriteException {
        InterceptResult invokeV;
        boolean z;
        int i2;
        AudioProcessor[] audioProcessorArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048608, this)) != null) {
            return invokeV.booleanValue;
        }
        if (this.a0 == -1) {
            this.a0 = this.s ? this.U.length : 0;
            z = true;
            i2 = this.a0;
            audioProcessorArr = this.U;
            if (i2 < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i2];
                if (z) {
                    audioProcessor.f();
                }
                H(-9223372036854775807L);
                if (!audioProcessor.b()) {
                    return false;
                }
                this.a0++;
                z = true;
                i2 = this.a0;
                audioProcessorArr = this.U;
                if (i2 < audioProcessorArr.length) {
                    ByteBuffer byteBuffer = this.X;
                    if (byteBuffer != null) {
                        O(byteBuffer, -9223372036854775807L);
                        if (this.X != null) {
                            return false;
                        }
                    }
                    this.a0 = -1;
                    return true;
                }
            }
        } else {
            z = false;
            i2 = this.a0;
            audioProcessorArr = this.U;
            if (i2 < audioProcessorArr.length) {
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            reset();
            I();
            for (AudioProcessor audioProcessor : this.f70071e) {
                audioProcessor.reset();
            }
            this.d0 = 0;
            this.c0 = false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && D()) {
            this.J = 0L;
            this.K = 0L;
            this.M = 0L;
            this.N = 0L;
            this.O = 0;
            p pVar = this.v;
            if (pVar != null) {
                this.w = pVar;
                this.v = null;
            } else if (!this.f70075i.isEmpty()) {
                this.w = this.f70075i.getLast().f70090a;
            }
            this.f70075i.clear();
            this.x = 0L;
            this.y = 0L;
            this.W = null;
            this.X = null;
            int i2 = 0;
            while (true) {
                AudioProcessor[] audioProcessorArr = this.U;
                if (i2 >= audioProcessorArr.length) {
                    break;
                }
                AudioProcessor audioProcessor = audioProcessorArr[i2];
                audioProcessor.flush();
                this.V[i2] = audioProcessor.g();
                i2++;
            }
            this.b0 = false;
            this.a0 = -1;
            this.z = null;
            this.A = 0;
            this.P = 0;
            this.S = 0L;
            K();
            if (this.l.getPlayState() == 3) {
                this.l.pause();
            }
            AudioTrack audioTrack = this.l;
            this.l = null;
            this.f70074h.h(null, false);
            this.f70072f.close();
            new a(this, audioTrack).start();
        }
    }

    public final long s(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048611, this, j2)) == null) ? (j2 * this.n) / 1000000 : invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048612, this, f2) == null) || this.T == f2) {
            return;
        }
        this.T = f2;
        L();
    }

    public final long t(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048613, this, j2)) == null) ? (j2 * 1000000) / this.n : invokeJ.longValue;
    }

    public final long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.s ? this.K : this.J / this.I : invokeV.longValue;
    }

    public final long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.s ? this.N : this.M / this.L : invokeV.longValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? D() && this.P != 0 : invokeV.booleanValue;
    }

    public final void z() throws AudioSink.InitializationException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.f70072f.block();
            AudioTrack A = A();
            this.l = A;
            int audioSessionId = A.getAudioSessionId();
            if (h0 && v.f33838a < 21) {
                AudioTrack audioTrack = this.k;
                if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                    I();
                }
                if (this.k == null) {
                    this.k = B(audioSessionId);
                }
            }
            if (this.d0 != audioSessionId) {
                this.d0 = audioSessionId;
                AudioSink.a aVar = this.f70076j;
                if (aVar != null) {
                    aVar.a(audioSessionId);
                }
            }
            this.f70074h.h(this.l, F());
            L();
            this.f0 = false;
        }
    }
}
