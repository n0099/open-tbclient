package com.kwad.sdk.core.video.a;

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
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.kwad.sdk.KsAdSDKImpl;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.core.video.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final MediaPlayer f33477a;

    /* renamed from: b  reason: collision with root package name */
    public final a f33478b;

    /* renamed from: c  reason: collision with root package name */
    public String f33479c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f33480d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f33481e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33482f;

    /* loaded from: classes6.dex */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<b> f33483a;

        public a(b bVar) {
            this.f33483a = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            b bVar = this.f33483a.get();
            if (bVar != null) {
                bVar.a(i2);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.f33483a.get();
            if (bVar != null) {
                bVar.c();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.f33483a.get();
            return bVar != null && bVar.b(i2, i3);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.f33483a.get();
            return bVar != null && bVar.c(i2, i3);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.f33483a.get();
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.f33483a.get();
            if (bVar != null) {
                bVar.d();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.f33483a.get();
            if (bVar != null) {
                bVar.a(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.f33483a.get();
            if (bVar != null) {
                bVar.a(i2, i3);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.f33481e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.f33477a = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.f33478b = new a(this);
        p();
    }

    private void o() {
        MediaDataSource mediaDataSource = this.f33480d;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f33480d = null;
        }
    }

    private void p() {
        this.f33477a.setOnPreparedListener(this.f33478b);
        this.f33477a.setOnBufferingUpdateListener(this.f33478b);
        this.f33477a.setOnCompletionListener(this.f33478b);
        this.f33477a.setOnSeekCompleteListener(this.f33478b);
        this.f33477a.setOnVideoSizeChangedListener(this.f33478b);
        this.f33477a.setOnErrorListener(this.f33478b);
        this.f33477a.setOnInfoListener(this.f33478b);
        this.f33477a.setOnTimedTextListener(this.f33478b);
    }

    private void q() {
        this.f33477a.setOnPreparedListener(null);
        this.f33477a.setOnBufferingUpdateListener(null);
        this.f33477a.setOnCompletionListener(null);
        this.f33477a.setOnSeekCompleteListener(null);
        this.f33477a.setOnVideoSizeChangedListener(null);
        this.f33477a.setOnErrorListener(null);
        this.f33477a.setOnInfoListener(null);
        this.f33477a.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2, float f3) {
        this.f33477a.setVolume(f2, f3);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f33477a.seekTo((int) j, 3);
        } else {
            this.f33477a.seekTo((int) j);
        }
    }

    @TargetApi(14)
    public void a(Context context, Uri uri, Map<String, String> map) {
        this.f33477a.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public void a(Surface surface) {
        this.f33477a.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        if (!cVar.f32787e) {
            a(cVar.f32783a);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "video/mp4");
        hashMap.put(Util.ACCEPT_RANGES, "bytes");
        hashMap.put("Status", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE206);
        hashMap.put("Cache-control", "no-cache");
        a(KsAdSDKImpl.get().getContext(), Uri.parse(cVar.f32783a), hashMap);
    }

    public void a(String str) {
        this.f33479c = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.f33477a.setDataSource(str);
        } else {
            this.f33477a.setDataSource(parse.getPath());
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(boolean z) {
        this.f33477a.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void b(int i2) {
        this.f33477a.setAudioStreamType(i2);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean e() {
        this.f33477a.prepareAsync();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void f() {
        this.f33477a.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void g() {
        this.f33477a.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int h() {
        return this.f33477a.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int i() {
        return this.f33477a.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long j() {
        try {
            return this.f33477a.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long k() {
        try {
            return this.f33477a.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void l() {
        try {
            this.f33482f = true;
            this.f33477a.release();
            o();
            a();
            q();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void m() {
        try {
            this.f33477a.reset();
        } catch (IllegalStateException unused) {
        }
        o();
        a();
        p();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int n() {
        return 1;
    }
}
