package d.a.s0.z3.m;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.player.VideoPlayData;
import com.baidu.ugc.editvideo.record.source.AMediaPlayer;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.google.android.exoplayer2.ExoPlaybackException;
import d.a.y0.t.g;
import d.f.b.a.d0.l;
import d.f.b.a.d0.v.f;
import d.f.b.a.d0.w.j;
import d.f.b.a.d0.x.a;
import d.f.b.a.d0.x.d;
import d.f.b.a.e;
import d.f.b.a.f;
import d.f.b.a.f0.a;
import d.f.b.a.f0.c;
import d.f.b.a.h;
import d.f.b.a.h0.i;
import d.f.b.a.h0.k;
import d.f.b.a.p;
import d.f.b.a.q;
import d.f.b.a.v;
import d.f.b.a.w;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class b extends AMediaPlayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f70060a;

    /* renamed from: b  reason: collision with root package name */
    public C1920b f70061b;

    /* renamed from: c  reason: collision with root package name */
    public final v f70062c;

    /* renamed from: d  reason: collision with root package name */
    public IMediaPlayer.OnSpeedChangeListener f70063d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f70064e;

    /* renamed from: f  reason: collision with root package name */
    public int f70065f;

    /* renamed from: g  reason: collision with root package name */
    public String f70066g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f70067h;

    /* renamed from: i  reason: collision with root package name */
    public l f70068i;
    public k j;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String str = "QMExoMP@" + Integer.toHexString(hashCode());
        this.f70060a = context.getApplicationContext();
        i iVar = new i();
        this.f70062c = h.a(new f(context, null), new c(new a.C2018a(iVar)), new e());
        C1920b c1920b = new C1920b(this, null);
        this.f70061b = c1920b;
        this.f70062c.i(c1920b);
        this.f70062c.J(this.f70061b);
        this.f70062c.l(false);
        this.f70067h = new Handler(Looper.getMainLooper());
        String v = d.f.b.a.i0.v.v(this.f70060a, "ExoMediaPlayer");
        this.f70066g = v;
        this.j = new k(this.f70060a, v, iVar);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            v vVar = this.f70062c;
            if (vVar == null) {
                return 0L;
            }
            w m = vVar.m();
            int k = this.f70062c.k();
            long currentPosition = this.f70062c.getCurrentPosition();
            w.c cVar = new w.c();
            if (m != null) {
                for (int i2 = 0; i2 < m.o(); i2++) {
                    long b2 = m.l(i2, cVar).b();
                    if (i2 < k) {
                        currentPosition += b2;
                    }
                }
            }
            return currentPosition;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public long getDuration() {
        InterceptResult invokeV;
        v vVar;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f70064e && (vVar = this.f70062c) != null) {
                w m = vVar.m();
                this.f70062c.k();
                this.f70062c.getCurrentPosition();
                w.c cVar = new w.c();
                if (m != null) {
                    j = 0;
                    for (int i2 = 0; i2 < m.o(); i2++) {
                        j += m.l(i2, cVar).b();
                    }
                } else {
                    j = 0;
                }
                return j == 0 ? this.f70065f : j;
            }
            return this.f70065f;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public float getPlaybackSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            v vVar = this.f70062c;
            if (vVar != null) {
                return vVar.d().f73513a;
            }
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.AMediaPlayer, com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70062c.getPlaybackState() : invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public float getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            v vVar = this.f70062c;
            if (vVar != null) {
                return vVar.O();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getCurrentPosition() >= getDuration() - 200 && getPlaybackState() == 4 : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public boolean isPlayable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int playbackState = this.f70062c.getPlaybackState();
            return (playbackState == 1 || playbackState == 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        v vVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? isPlayable() && (vVar = this.f70062c) != null && vVar.getPlaybackState() != 4 && this.f70062c.g() : invokeV.booleanValue;
    }

    public final l o(Uri uri, String str) {
        InterceptResult invokeLL;
        int y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                y = d.f.b.a.i0.v.x(uri);
            } else {
                y = d.f.b.a.i0.v.y("." + str);
            }
            if (y != 0) {
                if (y != 1) {
                    if (y != 2) {
                        if (y == 3) {
                            return new d.f.b.a.d0.i(uri, this.j, new d.f.b.a.a0.c(), this.f70067h, null);
                        }
                        throw new IllegalStateException("Unsupported type: " + y);
                    }
                    return new j(uri, this.j, this.f70067h, null);
                }
                return new d(uri, new k(this.f70060a, this.f70066g), new a.C2012a(this.j), this.f70067h, null);
            }
            return new d.f.b.a.d0.v.c(uri, new k(this.f70060a, this.f70066g), new f.a(this.j), this.f70067h, null);
        }
        return (l) invokeLL.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void pause() throws IllegalStateException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f70064e) {
            v vVar = this.f70062c;
            if (vVar != null) {
                vVar.l(false);
            }
            notifyOnPlayStateChange(2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void prepareAsync() throws IllegalStateException {
        C1920b c1920b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f70064e || this.f70068i == null || (c1920b = this.f70061b) == null || c1920b.f70069e) {
            return;
        }
        this.f70062c.b(this.f70068i);
        this.f70061b.f70069e = true;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f70064e = false;
            this.f70068i = null;
            C1920b c1920b = this.f70061b;
            if (c1920b != null) {
                c1920b.f70069e = false;
            }
            this.f70065f = 0;
            this.f70062c.release();
            C1920b c1920b2 = this.f70061b;
            if (c1920b2 != null) {
                this.f70062c.R(c1920b2);
                this.f70062c.f(this.f70061b);
            }
            this.f70061b = null;
            releaseListeners();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f70068i = null;
            this.f70064e = false;
            C1920b c1920b = this.f70061b;
            if (c1920b != null) {
                c1920b.f70069e = false;
            }
            this.f70065f = 0;
            v vVar = this.f70062c;
            if (vVar != null) {
                vVar.stop();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void seekTo(long j) throws IllegalStateException {
        v vVar;
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048589, this, j) == null) && this.f70064e && (vVar = this.f70062c) != null) {
            w m = vVar.m();
            if (!m.p()) {
                int o = m.o();
                k = 0;
                while (true) {
                    long b2 = m.l(k, new w.c()).b();
                    if (j < b2) {
                        break;
                    } else if (k == o - 1) {
                        j = b2;
                        break;
                    } else {
                        j -= b2;
                        k++;
                    }
                }
            } else {
                k = this.f70062c.k();
            }
            this.f70062c.p(k, j);
            C1920b c1920b = this.f70061b;
            if (c1920b != null) {
                c1920b.f70070f = true;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void seekToForce(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            seekTo(j);
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setAudioDataSource(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f70064e = false;
            this.f70065f = 0;
            int size = list.size();
            l[] lVarArr = new l[size];
            int i2 = 0;
            for (int i3 = 0; i3 < list.size() && i3 < size; i3++) {
                AudioPlayData audioPlayData = list.get(i3);
                int i4 = audioPlayData.realDuration;
                audioPlayData.offset = i2;
                int i5 = audioPlayData.end - audioPlayData.start;
                i2 += i5;
                this.f70065f += i5;
                l o = o(Uri.parse(audioPlayData.audioPath), "");
                int i6 = audioPlayData.start;
                if (i6 < 0) {
                    i6 = 0;
                }
                int i7 = audioPlayData.end;
                if (i7 <= i4) {
                    i4 = i7;
                }
                lVarArr[i3] = new d.f.b.a.d0.d(o, i6 * 1000, i4 * 1000);
            }
            this.f70068i = new d.f.b.a.d0.f(lVarArr);
            setPlaybackState(IMediaPlayer.STATE_GOT_SOURCE);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.AMediaPlayer, com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            setDataSource(null, Uri.parse(Uri.encode(str)), null);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        v vVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, surfaceHolder) == null) || (vVar = this.f70062c) == null) {
            return;
        }
        vVar.T(surfaceHolder);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnSpeedChangeListener(IMediaPlayer.OnSpeedChangeListener onSpeedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onSpeedChangeListener) == null) {
            this.f70063d = onSpeedChangeListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public boolean setPlaybackSpeed(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048597, this, f2)) == null) {
            v vVar = this.f70062c;
            if (vVar != null) {
                vVar.c(new p(f2, 1.0f));
                return true;
            }
            return true;
        }
        return invokeF.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setSurface(Surface surface) {
        v vVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, surface) == null) || (vVar = this.f70062c) == null) {
            return;
        }
        vVar.S(surface);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f70062c.X(f2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void start() throws IllegalStateException {
        v vVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.f70064e && (vVar = this.f70062c) != null) {
            if (vVar.getPlaybackState() == 4) {
                seekTo(0L);
            } else {
                this.f70062c.l(true);
            }
            notifyOnPlayStateChange(1);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void stop() throws IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f70068i = null;
            this.f70064e = false;
            C1920b c1920b = this.f70061b;
            if (c1920b != null) {
                c1920b.f70069e = false;
            }
            v vVar = this.f70062c;
            if (vVar != null) {
                vVar.stop();
            }
            notifyOnPlayStateChange(2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.AMediaPlayer, com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, context, uri, map) == null) {
            this.f70064e = false;
            super.setDataSource(context, uri, map);
            this.f70068i = o(uri, "");
            setPlaybackState(IMediaPlayer.STATE_GOT_SOURCE);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(uri.getPath());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            this.f70065f = g.b(extractMetadata, 0);
        }
    }

    /* renamed from: d.a.s0.z3.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1920b extends q.a implements v.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f70069e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f70070f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f70071g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f70072h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f70073i;

        public C1920b(b bVar) {
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
            this.f70073i = bVar;
            this.f70069e = false;
            this.f70070f = false;
            this.f70071g = false;
            this.f70072h = false;
        }

        @Override // d.f.b.a.q.a, d.f.b.a.q.b
        public void d(ExoPlaybackException exoPlaybackException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exoPlaybackException) == null) {
                this.f70073i.notifyOnError(1, 1, exoPlaybackException);
            }
        }

        @Override // d.f.b.a.v.c
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f70073i.notifyOnInfo(3, 0);
            }
        }

        @Override // d.f.b.a.q.a, d.f.b.a.q.b
        public void k(p pVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) || this.f70073i.f70063d == null || pVar == null) {
                return;
            }
            this.f70073i.f70063d.onSpeedChange(pVar.f73513a);
        }

        @Override // d.f.b.a.q.b
        public void m(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f70073i.setPlaybackState(i2);
                if (this.f70071g && (i2 == 3 || i2 == 4)) {
                    this.f70071g = false;
                    b bVar = this.f70073i;
                    bVar.notifyOnInfo(702, bVar.f70062c.j());
                }
                if (this.f70069e && i2 == 3) {
                    this.f70069e = false;
                    this.f70073i.f70064e = true;
                    this.f70073i.notifyOnPrepared();
                }
                if (this.f70070f && i2 == 3) {
                    this.f70070f = false;
                    this.f70073i.notifyOnSeekComplete();
                }
                if (i2 == 2) {
                    b bVar2 = this.f70073i;
                    bVar2.notifyOnInfo(701, bVar2.f70062c.j());
                    this.f70071g = true;
                } else if (i2 != 3) {
                    if (i2 == 4 && !this.f70072h) {
                        this.f70072h = true;
                        if (!this.f70073i.isLooping()) {
                            this.f70073i.notifyOnPlayStateChange(2);
                            this.f70073i.notifyOnCompletion();
                            return;
                        }
                        this.f70073i.seekTo(0L);
                        this.f70073i.notifyOnLooping();
                    }
                } else {
                    this.f70072h = false;
                }
            }
        }

        @Override // d.f.b.a.v.c
        public void onVideoSizeChanged(int i2, int i3, int i4, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) {
                this.f70073i.notifyOnVideoSizeChanged(i2, i3, i4, f2);
            }
        }

        public /* synthetic */ C1920b(b bVar, a aVar) {
            this(bVar);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setDataSource(List<VideoPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.f70064e = false;
            this.f70065f = 0;
            l[] lVarArr = new l[list.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                VideoPlayData videoPlayData = list.get(i3);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(videoPlayData.videoPath);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(9);
                mediaMetadataRetriever.release();
                int b2 = g.b(extractMetadata, 0);
                int b3 = g.b(extractMetadata2, 0);
                int b4 = g.b(extractMetadata3, 0);
                int b5 = g.b(extractMetadata4, 0);
                videoPlayData.rotation = b2;
                videoPlayData.width = b3;
                videoPlayData.height = b4;
                videoPlayData.offset = i2;
                int i4 = videoPlayData.end - videoPlayData.start;
                i2 += i4;
                this.f70065f += i4;
                l o = o(Uri.parse(videoPlayData.videoPath), "");
                int i5 = videoPlayData.start;
                if (i5 < 0) {
                    i5 = 0;
                }
                int i6 = videoPlayData.end;
                if (i6 <= b5) {
                    b5 = i6;
                }
                lVarArr[i3] = new d.f.b.a.d0.d(o, i5 * 1000, b5 * 1000);
            }
            this.f70068i = new d.f.b.a.d0.f(lVarArr);
            setPlaybackState(IMediaPlayer.STATE_GOT_SOURCE);
        }
    }
}
