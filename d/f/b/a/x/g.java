package d.f.b.a.x;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.material.internal.ManufacturerUtils;
import d.f.b.a.i0.v;
import d.f.b.a.p;
import d.f.b.a.x.d;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes8.dex */
public class g extends MediaCodecRenderer implements d.f.b.a.i0.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d.a Z;
    public final AudioSink a0;
    public boolean b0;
    public boolean c0;
    public MediaFormat i0;
    public int j0;
    public int k0;
    public int l0;
    public int m0;
    public long n0;
    public boolean o0;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public final class b implements AudioSink.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f70701a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70701a = gVar;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f70701a.Z.b(i2);
                this.f70701a.r0(i2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void b(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f70701a.Z.c(i2, j, j2);
                this.f70701a.t0(i2, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f70701a.s0();
                this.f70701a.o0 = true;
            }
        }

        public /* synthetic */ b(g gVar, a aVar) {
            this(gVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(d.f.b.a.b0.b bVar, @Nullable d.f.b.a.z.a<d.f.b.a.z.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, @Nullable c cVar, AudioProcessor... audioProcessorArr) {
        this(bVar, aVar, z, handler, dVar, new DefaultAudioSink(cVar, audioProcessorArr));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {bVar, aVar, Boolean.valueOf(z), handler, dVar, cVar, audioProcessorArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((d.f.b.a.b0.b) objArr2[0], (d.f.b.a.z.a) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (Handler) objArr2[3], (d) objArr2[4], (AudioSink) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean q0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? v.f70515a < 24 && "OMX.SEC.aac.dec".equals(str) && ManufacturerUtils.SAMSUNG.equals(v.f70517c) && (v.f70516b.startsWith("zeroflte") || v.f70516b.startsWith("herolte") || v.f70516b.startsWith("heroqlte")) : invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.a
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a0.pause();
            super.A();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void N(d.f.b.a.b0.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, mediaCodec, format, mediaCrypto) == null) {
            this.c0 = q0(aVar.f69708a);
            if (this.b0) {
                MediaFormat frameworkMediaFormatV16 = format.getFrameworkMediaFormatV16();
                this.i0 = frameworkMediaFormatV16;
                frameworkMediaFormatV16.setString("mime", "audio/raw");
                mediaCodec.configure(this.i0, (Surface) null, mediaCrypto, 0);
                this.i0.setString("mime", format.sampleMimeType);
                return;
            }
            mediaCodec.configure(format.getFrameworkMediaFormatV16(), (Surface) null, mediaCrypto, 0);
            this.i0 = null;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public d.f.b.a.b0.a T(d.f.b.a.b0.b bVar, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLZ;
        d.f.b.a.b0.a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, bVar, format, z)) == null) {
            if (p0(format.sampleMimeType) && (b2 = bVar.b()) != null) {
                this.b0 = true;
                return b2;
            }
            this.b0 = false;
            return super.T(bVar, format, z);
        }
        return (d.f.b.a.b0.a) invokeLLZ.objValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void X(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.Z.d(str, j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Y(Format format) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, format) == null) {
            super.Y(format);
            this.Z.g(format);
            this.j0 = "audio/raw".equals(format.sampleMimeType) ? format.pcmEncoding : 2;
            this.k0 = format.channelCount;
            int i2 = format.encoderDelay;
            if (i2 == -1) {
                i2 = 0;
            }
            this.l0 = i2;
            int i3 = format.encoderPadding;
            this.m0 = i3 != -1 ? i3 : 0;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Z(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int[] iArr;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, mediaCodec, mediaFormat) == null) {
            boolean z = this.i0 != null;
            String string = z ? this.i0.getString("mime") : "audio/raw";
            if (z) {
                mediaFormat = this.i0;
            }
            int integer = mediaFormat.getInteger("channel-count");
            int integer2 = mediaFormat.getInteger("sample-rate");
            if (this.c0 && integer == 6 && (i2 = this.k0) < 6) {
                iArr = new int[i2];
                for (int i3 = 0; i3 < this.k0; i3++) {
                    iArr[i3] = i3;
                }
            } else {
                iArr = null;
            }
            try {
                this.a0.h(string, integer, integer2, this.j0, 0, iArr, this.l0, this.m0);
            } catch (AudioSink.ConfigurationException e2) {
                throw ExoPlaybackException.createForRenderer(e2, u());
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.r
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? super.b() && this.a0.b() : invokeV.booleanValue;
    }

    @Override // d.f.b.a.i0.h
    public p c(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pVar)) == null) ? this.a0.c(pVar) : (p) invokeL.objValue;
    }

    @Override // d.f.b.a.i0.h
    public p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a0.d() : (p) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean d0(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j3, boolean z) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), mediaCodec, byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            if (this.b0 && (i3 & 2) != 0) {
                mediaCodec.releaseOutputBuffer(i2, false);
                return true;
            } else if (z) {
                mediaCodec.releaseOutputBuffer(i2, false);
                this.X.f70750f++;
                this.a0.m();
                return true;
            } else {
                try {
                    if (this.a0.f(byteBuffer, j3)) {
                        mediaCodec.releaseOutputBuffer(i2, false);
                        this.X.f70749e++;
                        return true;
                    }
                    return false;
                } catch (AudioSink.InitializationException | AudioSink.WriteException e2) {
                    throw ExoPlaybackException.createForRenderer(e2, u());
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.f.b.a.a, d.f.b.a.g.a
    public void h(int i2, Object obj) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, obj) == null) {
            if (i2 == 2) {
                this.a0.setVolume(((Float) obj).floatValue());
            } else if (i2 != 3) {
                super.h(i2, obj);
            } else {
                this.a0.e((d.f.b.a.x.b) obj);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void h0() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                this.a0.k();
            } catch (AudioSink.WriteException e2) {
                throw ExoPlaybackException.createForRenderer(e2, u());
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.r
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a0.i() || super.isReady() : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int l0(d.f.b.a.b0.b bVar, d.f.b.a.z.a<d.f.b.a.z.c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLL;
        boolean z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, bVar, aVar, format)) == null) {
            String str = format.sampleMimeType;
            boolean z2 = false;
            if (d.f.b.a.i0.i.g(str)) {
                int i4 = v.f70515a >= 21 ? 32 : 0;
                boolean E = d.f.b.a.a.E(aVar, format.drmInitData);
                if (E && p0(str) && bVar.b() != null) {
                    return i4 | 8 | 4;
                }
                DrmInitData drmInitData = format.drmInitData;
                if (drmInitData != null) {
                    z = false;
                    for (int i5 = 0; i5 < drmInitData.schemeDataCount; i5++) {
                        z |= drmInitData.get(i5).requiresSecureDecryption;
                    }
                } else {
                    z = false;
                }
                d.f.b.a.b0.a a2 = bVar.a(str, z);
                if (a2 == null) {
                    return (!z || bVar.a(str, false) == null) ? 1 : 2;
                } else if (E) {
                    if (v.f70515a < 21 || (((i2 = format.sampleRate) == -1 || a2.h(i2)) && ((i3 = format.channelCount) == -1 || a2.g(i3)))) {
                        z2 = true;
                    }
                    return i4 | 8 | (z2 ? 4 : 3);
                } else {
                    return 2;
                }
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    @Override // d.f.b.a.a, d.f.b.a.r
    public d.f.b.a.i0.h m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this : (d.f.b.a.i0.h) invokeV.objValue;
    }

    public boolean p0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? this.a0.n(str) : invokeL.booleanValue;
    }

    @Override // d.f.b.a.i0.h
    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            long l = this.a0.l(b());
            if (l != Long.MIN_VALUE) {
                if (!this.o0) {
                    l = Math.max(this.n0, l);
                }
                this.n0 = l;
                this.o0 = false;
            }
            return this.n0;
        }
        return invokeV.longValue;
    }

    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void t0(int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.a
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            try {
                this.a0.release();
                try {
                    super.w();
                } finally {
                }
            } catch (Throwable th) {
                try {
                    super.w();
                    throw th;
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.a
    public void x(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.x(z);
            this.Z.f(this.X);
            int i2 = t().f70620a;
            if (i2 != 0) {
                this.a0.g(i2);
            } else {
                this.a0.a();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.a
    public void y(long j, boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            super.y(j, z);
            this.a0.reset();
            this.n0 = j;
            this.o0 = true;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, d.f.b.a.a
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.z();
            this.a0.play();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d.f.b.a.b0.b bVar, @Nullable d.f.b.a.z.a<d.f.b.a.z.c> aVar, boolean z, @Nullable Handler handler, @Nullable d dVar, AudioSink audioSink) {
        super(1, bVar, aVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, aVar, Boolean.valueOf(z), handler, dVar, audioSink};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (d.f.b.a.b0.b) objArr2[1], (d.f.b.a.z.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Z = new d.a(handler, dVar);
        this.a0 = audioSink;
        audioSink.j(new b(this, null));
    }
}
