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
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.video.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final MediaPlayer f6263a;
    private final a b;
    private String c;
    private MediaDataSource d;
    private final Object e = new Object();
    private boolean f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<b> f6264a;

        a(b bVar) {
            this.f6264a = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            b bVar = this.f6264a.get();
            if (bVar != null) {
                bVar.a(i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.f6264a.get();
            if (bVar != null) {
                bVar.c();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.f6264a.get();
            return bVar != null && bVar.b(i, i2);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.f6264a.get();
            return bVar != null && bVar.c(i, i2);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.f6264a.get();
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.f6264a.get();
            if (bVar != null) {
                bVar.d();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.f6264a.get();
            if (bVar != null) {
                bVar.a(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.f6264a.get();
            if (bVar != null) {
                bVar.a(i, i2);
            }
        }
    }

    public b() {
        synchronized (this.e) {
            this.f6263a = new MediaPlayer();
        }
        this.f6263a.setAudioStreamType(3);
        this.b = new a(this);
        q();
    }

    private void p() {
        if (this.d != null) {
            try {
                this.d.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.d = null;
        }
    }

    private void q() {
        this.f6263a.setOnPreparedListener(this.b);
        this.f6263a.setOnBufferingUpdateListener(this.b);
        this.f6263a.setOnCompletionListener(this.b);
        this.f6263a.setOnSeekCompleteListener(this.b);
        this.f6263a.setOnVideoSizeChangedListener(this.b);
        this.f6263a.setOnErrorListener(this.b);
        this.f6263a.setOnInfoListener(this.b);
        this.f6263a.setOnTimedTextListener(this.b);
    }

    private void r() {
        this.f6263a.setOnPreparedListener(null);
        this.f6263a.setOnBufferingUpdateListener(null);
        this.f6263a.setOnCompletionListener(null);
        this.f6263a.setOnSeekCompleteListener(null);
        this.f6263a.setOnVideoSizeChangedListener(null);
        this.f6263a.setOnErrorListener(null);
        this.f6263a.setOnInfoListener(null);
        this.f6263a.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f) {
        if (Build.VERSION.SDK_INT >= 23) {
            PlaybackParams playbackParams = this.f6263a.getPlaybackParams();
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            playbackParams.setSpeed(f);
            this.f6263a.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f, float f2) {
        this.f6263a.setVolume(f, f2);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6263a.seekTo((int) j, 3);
        } else {
            this.f6263a.seekTo((int) j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public void a(Surface surface) {
        this.f6263a.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.d dVar) {
        a(dVar.f5747a);
    }

    public void a(String str) {
        this.c = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.f6263a.setDataSource(str);
        } else {
            this.f6263a.setDataSource(parse.getPath());
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(boolean z) {
        this.f6263a.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void b(int i) {
        this.f6263a.setAudioStreamType(i);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean e() {
        this.f6263a.prepareAsync();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void f() {
        this.f6263a.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void g() {
        this.f6263a.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int h() {
        return this.f6263a.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int i() {
        return this.f6263a.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean j() {
        try {
            return this.f6263a.isPlaying();
        } catch (IllegalStateException e) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long k() {
        try {
            return this.f6263a.getCurrentPosition();
        } catch (IllegalStateException e) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long l() {
        try {
            return this.f6263a.getDuration();
        } catch (IllegalStateException e) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void m() {
        try {
            this.f = true;
            this.f6263a.release();
            p();
            a();
            r();
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void n() {
        try {
            this.f6263a.reset();
        } catch (IllegalStateException e) {
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
