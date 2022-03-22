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
import com.kwad.sdk.KsAdSDKImpl;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.core.video.kwai.a {
    public final MediaPlayer a;

    /* renamed from: b  reason: collision with root package name */
    public final a f39882b;

    /* renamed from: c  reason: collision with root package name */
    public String f39883c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f39884d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f39885e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39886f;

    /* loaded from: classes7.dex */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        public final WeakReference<b> a;

        public a(b bVar) {
            this.a = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            b bVar = this.a.get();
            if (bVar != null) {
                bVar.a(i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.a.get();
            if (bVar != null) {
                bVar.c();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.a.get();
            return bVar != null && bVar.b(i, i2);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.a.get();
            return bVar != null && bVar.c(i, i2);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.a.get();
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.a.get();
            if (bVar != null) {
                bVar.d();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.a.get();
            if (bVar != null) {
                bVar.a(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.a.get();
            if (bVar != null) {
                bVar.a(i, i2);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.f39885e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.f39882b = new a(this);
        q();
        a(false);
    }

    private void p() {
        MediaDataSource mediaDataSource = this.f39884d;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f39884d = null;
        }
    }

    private void q() {
        this.a.setOnPreparedListener(this.f39882b);
        this.a.setOnBufferingUpdateListener(this.f39882b);
        this.a.setOnCompletionListener(this.f39882b);
        this.a.setOnSeekCompleteListener(this.f39882b);
        this.a.setOnVideoSizeChangedListener(this.f39882b);
        this.a.setOnErrorListener(this.f39882b);
        this.a.setOnInfoListener(this.f39882b);
        this.a.setOnTimedTextListener(this.f39882b);
    }

    private void r() {
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
    public void a(float f2, float f3) {
        this.a.setVolume(f2, f3);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.seekTo((int) j, 3);
        } else {
            this.a.seekTo((int) j);
        }
    }

    @TargetApi(14)
    public void a(Context context, Uri uri, Map<String, String> map) {
        this.a.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public void a(Surface surface) {
        this.a.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        if (!cVar.f39289f) {
            a(cVar.f39285b);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", MimeTypes.VIDEO_MP4);
        hashMap.put(Util.ACCEPT_RANGES, "bytes");
        hashMap.put("Status", "206");
        hashMap.put("Cache-control", "no-cache");
        a(KsAdSDKImpl.get().getContext(), Uri.parse(cVar.f39285b), hashMap);
    }

    public void a(String str) {
        this.f39883c = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.a.setDataSource(str);
        } else {
            this.a.setDataSource(parse.getPath());
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(boolean z) {
        this.a.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void b(int i) {
        this.a.setAudioStreamType(i);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public boolean e() {
        this.a.prepareAsync();
        return true;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void f() {
        this.a.start();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void g() {
        this.a.pause();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int h() {
        return this.a.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int i() {
        return this.a.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public long j() {
        try {
            return this.a.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public long k() {
        try {
            return this.a.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void l() {
        try {
            this.f39886f = true;
            this.a.release();
            p();
            a();
            r();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void m() {
        try {
            this.a.reset();
        } catch (IllegalStateException unused) {
        }
        p();
        a();
        q();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public boolean n() {
        return this.a.isLooping();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int o() {
        return 1;
    }
}
