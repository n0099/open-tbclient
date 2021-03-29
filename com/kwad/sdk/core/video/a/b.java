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
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.core.video.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final MediaPlayer f34106a;

    /* renamed from: b  reason: collision with root package name */
    public final a f34107b;

    /* renamed from: c  reason: collision with root package name */
    public String f34108c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f34109d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f34110e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34111f;

    /* loaded from: classes6.dex */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<b> f34112a;

        public a(b bVar) {
            this.f34112a = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            b bVar = this.f34112a.get();
            if (bVar != null) {
                bVar.a(i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.f34112a.get();
            if (bVar != null) {
                bVar.c();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.f34112a.get();
            return bVar != null && bVar.b(i, i2);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.f34112a.get();
            return bVar != null && bVar.c(i, i2);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.f34112a.get();
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.f34112a.get();
            if (bVar != null) {
                bVar.d();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.f34112a.get();
            if (bVar != null) {
                bVar.a(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.f34112a.get();
            if (bVar != null) {
                bVar.a(i, i2);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.f34110e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.f34106a = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.f34107b = new a(this);
        q();
    }

    private void p() {
        MediaDataSource mediaDataSource = this.f34109d;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f34109d = null;
        }
    }

    private void q() {
        this.f34106a.setOnPreparedListener(this.f34107b);
        this.f34106a.setOnBufferingUpdateListener(this.f34107b);
        this.f34106a.setOnCompletionListener(this.f34107b);
        this.f34106a.setOnSeekCompleteListener(this.f34107b);
        this.f34106a.setOnVideoSizeChangedListener(this.f34107b);
        this.f34106a.setOnErrorListener(this.f34107b);
        this.f34106a.setOnInfoListener(this.f34107b);
        this.f34106a.setOnTimedTextListener(this.f34107b);
    }

    private void r() {
        this.f34106a.setOnPreparedListener(null);
        this.f34106a.setOnBufferingUpdateListener(null);
        this.f34106a.setOnCompletionListener(null);
        this.f34106a.setOnSeekCompleteListener(null);
        this.f34106a.setOnVideoSizeChangedListener(null);
        this.f34106a.setOnErrorListener(null);
        this.f34106a.setOnInfoListener(null);
        this.f34106a.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2) {
        if (Build.VERSION.SDK_INT >= 23) {
            PlaybackParams playbackParams = this.f34106a.getPlaybackParams();
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            playbackParams.setSpeed(f2);
            this.f34106a.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2, float f3) {
        this.f34106a.setVolume(f2, f3);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f34106a.seekTo((int) j, 3);
        } else {
            this.f34106a.seekTo((int) j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public void a(Surface surface) {
        this.f34106a.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.d dVar) {
        a(dVar.f32541a);
    }

    public void a(String str) {
        this.f34108c = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.f34106a.setDataSource(str);
        } else {
            this.f34106a.setDataSource(parse.getPath());
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(boolean z) {
        this.f34106a.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void b(int i) {
        this.f34106a.setAudioStreamType(i);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean e() {
        this.f34106a.prepareAsync();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void f() {
        this.f34106a.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void g() {
        this.f34106a.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int h() {
        return this.f34106a.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int i() {
        return this.f34106a.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean j() {
        try {
            return this.f34106a.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long k() {
        try {
            return this.f34106a.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long l() {
        try {
            return this.f34106a.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void m() {
        try {
            this.f34111f = true;
            this.f34106a.release();
            p();
            a();
            r();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void n() {
        try {
            this.f34106a.reset();
        } catch (IllegalStateException unused) {
        }
        p();
        a();
        q();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int o() {
        return 1;
    }
}
