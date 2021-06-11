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
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.core.video.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final MediaPlayer f34743a;

    /* renamed from: b  reason: collision with root package name */
    public final a f34744b;

    /* renamed from: c  reason: collision with root package name */
    public String f34745c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f34746d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f34747e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34748f;

    /* loaded from: classes7.dex */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<b> f34749a;

        public a(b bVar) {
            this.f34749a = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            b bVar = this.f34749a.get();
            if (bVar != null) {
                bVar.a(i2);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.f34749a.get();
            if (bVar != null) {
                bVar.c();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.f34749a.get();
            return bVar != null && bVar.b(i2, i3);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.f34749a.get();
            return bVar != null && bVar.c(i2, i3);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.f34749a.get();
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.f34749a.get();
            if (bVar != null) {
                bVar.d();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.f34749a.get();
            if (bVar != null) {
                bVar.a(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.f34749a.get();
            if (bVar != null) {
                bVar.a(i2, i3);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.f34747e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.f34743a = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.f34744b = new a(this);
        q();
    }

    private void p() {
        MediaDataSource mediaDataSource = this.f34746d;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f34746d = null;
        }
    }

    private void q() {
        this.f34743a.setOnPreparedListener(this.f34744b);
        this.f34743a.setOnBufferingUpdateListener(this.f34744b);
        this.f34743a.setOnCompletionListener(this.f34744b);
        this.f34743a.setOnSeekCompleteListener(this.f34744b);
        this.f34743a.setOnVideoSizeChangedListener(this.f34744b);
        this.f34743a.setOnErrorListener(this.f34744b);
        this.f34743a.setOnInfoListener(this.f34744b);
        this.f34743a.setOnTimedTextListener(this.f34744b);
    }

    private void r() {
        this.f34743a.setOnPreparedListener(null);
        this.f34743a.setOnBufferingUpdateListener(null);
        this.f34743a.setOnCompletionListener(null);
        this.f34743a.setOnSeekCompleteListener(null);
        this.f34743a.setOnVideoSizeChangedListener(null);
        this.f34743a.setOnErrorListener(null);
        this.f34743a.setOnInfoListener(null);
        this.f34743a.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2) {
        if (Build.VERSION.SDK_INT >= 23) {
            PlaybackParams playbackParams = this.f34743a.getPlaybackParams();
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            playbackParams.setSpeed(f2);
            this.f34743a.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2, float f3) {
        this.f34743a.setVolume(f2, f3);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f34743a.seekTo((int) j, 3);
        } else {
            this.f34743a.seekTo((int) j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public void a(Surface surface) {
        this.f34743a.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.d dVar) {
        a(dVar.f33122a);
    }

    public void a(String str) {
        this.f34745c = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.f34743a.setDataSource(str);
        } else {
            this.f34743a.setDataSource(parse.getPath());
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(boolean z) {
        this.f34743a.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void b(int i2) {
        this.f34743a.setAudioStreamType(i2);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean e() {
        this.f34743a.prepareAsync();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void f() {
        this.f34743a.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void g() {
        this.f34743a.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int h() {
        return this.f34743a.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int i() {
        return this.f34743a.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean j() {
        try {
            return this.f34743a.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long k() {
        try {
            return this.f34743a.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long l() {
        try {
            return this.f34743a.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void m() {
        try {
            this.f34748f = true;
            this.f34743a.release();
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
            this.f34743a.reset();
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
