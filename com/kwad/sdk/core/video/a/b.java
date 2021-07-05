package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.core.video.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final MediaPlayer f36604a;

    /* renamed from: b  reason: collision with root package name */
    public final a f36605b;

    /* renamed from: c  reason: collision with root package name */
    public String f36606c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f36607d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f36608e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36609f;

    /* loaded from: classes7.dex */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<b> f36610a;

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
            this.f36610a = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) || (bVar = this.f36610a.get()) == null) {
                return;
            }
            bVar.a(i2);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) || (bVar = this.f36610a.get()) == null) {
                return;
            }
            bVar.c();
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer, i2, i3)) == null) {
                b bVar = this.f36610a.get();
                return bVar != null && bVar.b(i2, i3);
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, mediaPlayer, i2, i3)) == null) {
                b bVar = this.f36610a.get();
                return bVar != null && bVar.c(i2, i3);
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, mediaPlayer) == null) || (bVar = this.f36610a.get()) == null) {
                return;
            }
            bVar.b();
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, mediaPlayer) == null) || (bVar = this.f36610a.get()) == null) {
                return;
            }
            bVar.d();
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048582, this, mediaPlayer, timedText) == null) || (bVar = this.f36610a.get()) == null) {
                return;
            }
            bVar.a(timedText);
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048583, this, mediaPlayer, i2, i3) == null) || (bVar = this.f36610a.get()) == null) {
                return;
            }
            bVar.a(i2, i3);
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
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
        Object obj = new Object();
        this.f36608e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.f36604a = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.f36605b = new a(this);
        q();
    }

    private void p() {
        MediaDataSource mediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (mediaDataSource = this.f36607d) == null) {
            return;
        }
        try {
            mediaDataSource.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f36607d = null;
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f36604a.setOnPreparedListener(this.f36605b);
            this.f36604a.setOnBufferingUpdateListener(this.f36605b);
            this.f36604a.setOnCompletionListener(this.f36605b);
            this.f36604a.setOnSeekCompleteListener(this.f36605b);
            this.f36604a.setOnVideoSizeChangedListener(this.f36605b);
            this.f36604a.setOnErrorListener(this.f36605b);
            this.f36604a.setOnInfoListener(this.f36605b);
            this.f36604a.setOnTimedTextListener(this.f36605b);
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f36604a.setOnPreparedListener(null);
            this.f36604a.setOnBufferingUpdateListener(null);
            this.f36604a.setOnCompletionListener(null);
            this.f36604a.setOnSeekCompleteListener(null);
            this.f36604a.setOnVideoSizeChangedListener(null);
            this.f36604a.setOnErrorListener(null);
            this.f36604a.setOnInfoListener(null);
            this.f36604a.setOnTimedTextListener(null);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        PlaybackParams playbackParams = this.f36604a.getPlaybackParams();
        if (playbackParams == null) {
            playbackParams = new PlaybackParams();
        }
        playbackParams.setSpeed(f2);
        this.f36604a.setPlaybackParams(playbackParams);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f36604a.setVolume(f2, f3);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f36604a.seekTo((int) j, 3);
            } else {
                this.f36604a.seekTo((int) j);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surface) == null) {
            this.f36604a.setSurface(surface);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            a(dVar.f34983a);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f36606c = str;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
                this.f36604a.setDataSource(str);
            } else {
                this.f36604a.setDataSource(parse.getPath());
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f36604a.setLooping(z);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f36604a.setAudioStreamType(i2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.f36604a.prepareAsync();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f36604a.start();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f36604a.pause();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f36604a.getVideoWidth() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36604a.getVideoHeight() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            try {
                return this.f36604a.isPlaying();
            } catch (IllegalStateException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            try {
                return this.f36604a.getCurrentPosition();
            } catch (IllegalStateException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                return this.f36604a.getDuration();
            } catch (IllegalStateException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            try {
                this.f36609f = true;
                this.f36604a.release();
                p();
                a();
                r();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            try {
                this.f36604a.reset();
            } catch (IllegalStateException unused) {
            }
            p();
            a();
            q();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }
}
