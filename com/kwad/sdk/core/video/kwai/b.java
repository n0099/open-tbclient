package com.kwad.sdk.core.video.kwai;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.toolbar.CommonToolbarStatisticConstants;
import com.google.android.exoplayer2.util.MimeTypes;
import com.kwad.sdk.service.ServiceProvider;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class b extends com.kwad.sdk.core.video.kwai.a {
    public final MediaPlayer adE;
    public final a adF;
    public String adG;
    public MediaDataSource adH;
    public final Object adI;
    public boolean adJ;

    /* loaded from: classes9.dex */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        public final WeakReference<b> mWeakMediaPlayer;

        public a(b bVar) {
            this.mWeakMediaPlayer = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnBufferingUpdate(i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnError(i, i2);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnInfo(i, i2);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.b(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.n(i, i2);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.adI = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.adE = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.adF = new a(this);
        vw();
        setLooping(false);
    }

    private void vv() {
        MediaDataSource mediaDataSource = this.adH;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.adH = null;
        }
    }

    private void vw() {
        this.adE.setOnPreparedListener(this.adF);
        this.adE.setOnBufferingUpdateListener(this.adF);
        this.adE.setOnCompletionListener(this.adF);
        this.adE.setOnSeekCompleteListener(this.adF);
        this.adE.setOnVideoSizeChangedListener(this.adF);
        this.adE.setOnErrorListener(this.adF);
        this.adE.setOnInfoListener(this.adF);
        this.adE.setOnTimedTextListener(this.adF);
    }

    private void vx() {
        this.adE.setOnPreparedListener(null);
        this.adE.setOnBufferingUpdateListener(null);
        this.adE.setOnCompletionListener(null);
        this.adE.setOnSeekCompleteListener(null);
        this.adE.setOnVideoSizeChangedListener(null);
        this.adE.setOnErrorListener(null);
        this.adE.setOnInfoListener(null);
        this.adE.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        if (!bVar.isNoCache) {
            setDataSource(bVar.videoUrl);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", MimeTypes.VIDEO_MP4);
        hashMap.put(Util.ACCEPT_RANGES, "bytes");
        hashMap.put("Status", CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_BACK);
        hashMap.put("Cache-control", "no-cache");
        setDataSource(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext(), Uri.parse(bVar.videoUrl), hashMap);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getAudioSessionId() {
        return this.adE.getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final String getCurrentPlayingUrl() {
        return "";
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long getCurrentPosition() {
        try {
            return this.adE.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final String getDataSource() {
        return this.adG;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long getDuration() {
        try {
            return this.adE.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getMediaPlayerType() {
        return 1;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoHeight() {
        return this.adE.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoWidth() {
        return this.adE.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isLooping() {
        return this.adE.isLooping();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isPlaying() {
        try {
            return this.adE.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void pause() {
        this.adE.pause();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean prepareAsync() {
        this.adE.prepareAsync();
        return true;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void release() {
        try {
            this.adJ = true;
            this.adE.release();
            vv();
            resetListeners();
            vx();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void reset() {
        try {
            this.adE.reset();
        } catch (IllegalStateException unused) {
        }
        vv();
        resetListeners();
        vw();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void seekTo(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.adE.seekTo((int) j, 3);
        } else {
            this.adE.seekTo((int) j);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setAudioStreamType(int i) {
        this.adE.setAudioStreamType(i);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(Context context, Uri uri) {
        this.adE.setDataSource(context, uri);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.adE.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
        this.adE.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(String str) {
        this.adG = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.adE.setDataSource(str);
        } else {
            this.adE.setDataSource(parse.getPath());
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.adI) {
            if (!this.adJ) {
                this.adE.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setLooping(boolean z) {
        this.adE.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setScreenOnWhilePlaying(boolean z) {
        this.adE.setScreenOnWhilePlaying(z);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setSpeed(float f) {
        if (Build.VERSION.SDK_INT >= 23) {
            PlaybackParams playbackParams = this.adE.getPlaybackParams();
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            playbackParams.setSpeed(f);
            this.adE.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.adE.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setVolume(float f, float f2) {
        this.adE.setVolume(f, f2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void start() {
        this.adE.start();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void stop() {
        this.adE.stop();
    }
}
