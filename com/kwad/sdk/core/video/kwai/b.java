package com.kwad.sdk.core.video.kwai;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.Util;
import com.google.android.exoplayer2.util.MimeTypes;
import com.kwad.sdk.service.ServiceProvider;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class b extends com.kwad.sdk.core.video.kwai.a {
    public final MediaPlayer a;
    public final a b;
    public String c;
    public MediaDataSource d;
    public final Object e;
    public boolean f;

    /* loaded from: classes5.dex */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        public final WeakReference<b> a;

        public a(b bVar) {
            this.a = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            b bVar = this.a.get();
            if (bVar != null) {
                bVar.a(i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.a.get();
            if (bVar != null) {
                bVar.c();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.a.get();
            return bVar != null && bVar.b(i, i2);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.a.get();
            return bVar != null && bVar.c(i, i2);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.a.get();
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            this.a.get();
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            this.a.get();
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.a.get();
            if (bVar != null) {
                bVar.a(i, i2);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.b = new a(this);
        n();
        a(false);
    }

    @TargetApi(14)
    private void a(Context context, Uri uri, Map<String, String> map) {
        this.a.setDataSource(context, uri, map);
    }

    private void a(String str) {
        this.c = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.a.setDataSource(str);
        } else {
            this.a.setDataSource(parse.getPath());
        }
    }

    private void m() {
        MediaDataSource mediaDataSource = this.d;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.d = null;
        }
    }

    private void n() {
        this.a.setOnPreparedListener(this.b);
        this.a.setOnBufferingUpdateListener(this.b);
        this.a.setOnCompletionListener(this.b);
        this.a.setOnSeekCompleteListener(this.b);
        this.a.setOnVideoSizeChangedListener(this.b);
        this.a.setOnErrorListener(this.b);
        this.a.setOnInfoListener(this.b);
        this.a.setOnTimedTextListener(this.b);
    }

    private void o() {
        this.a.setOnPreparedListener(null);
        this.a.setOnBufferingUpdateListener(null);
        this.a.setOnCompletionListener(null);
        this.a.setOnSeekCompleteListener(null);
        this.a.setOnVideoSizeChangedListener(null);
        this.a.setOnErrorListener(null);
        this.a.setOnInfoListener(null);
        this.a.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(float f, float f2) {
        this.a.setVolume(f, f2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.seekTo((int) j, 3);
        } else {
            this.a.seekTo((int) j);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public final void a(Surface surface) {
        this.a.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        if (!bVar.f) {
            a(bVar.b);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", MimeTypes.VIDEO_MP4);
        hashMap.put(Util.ACCEPT_RANGES, "bytes");
        hashMap.put("Status", "206");
        hashMap.put("Cache-control", "no-cache");
        a(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a(), Uri.parse(bVar.b), hashMap);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(boolean z) {
        this.a.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void b(int i) {
        this.a.setAudioStreamType(3);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean d() {
        this.a.prepareAsync();
        return true;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void e() {
        this.a.start();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void f() {
        this.a.pause();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long g() {
        try {
            return this.a.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long h() {
        try {
            return this.a.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void i() {
        try {
            this.f = true;
            this.a.release();
            m();
            a();
            o();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.a(th);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void j() {
        try {
            this.a.reset();
        } catch (IllegalStateException unused) {
        }
        m();
        a();
        n();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean k() {
        return this.a.isLooping();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int l() {
        return 1;
    }
}
