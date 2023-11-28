package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.video.a.f;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.i;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.y;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
@Deprecated
/* loaded from: classes10.dex */
public final class a extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, c {
    public static AtomicBoolean aAw = new AtomicBoolean(false);
    public int TD;
    public com.kwad.sdk.core.video.a.c TE;
    public int TF;
    public long TG;
    public com.kwad.sdk.contentalliance.a.a.b TI;
    public c.e TR;
    public c.i TS;
    public c.b TT;
    public c.InterfaceC0713c TU;
    public c.d TV;
    public c.a TW;
    public SurfaceTexture Ue;
    public Surface Uf;
    public AudioManager aAs;
    public com.kwad.sdk.core.video.a aAt;
    public b aAu;
    public boolean aAv;
    public boolean aAx;
    public boolean aAy;
    public ImageView aAz;
    public com.kwad.sdk.contentalliance.a.a.a dd;
    public FrameLayout hR;
    public Context mContext;
    public Map<String, String> mHeaders;
    public String mUrl;

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private ImageView EY() {
        ImageView imageView = new ImageView(this.mContext);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private boolean EZ() {
        if (this.TD == 6) {
            return true;
        }
        return false;
    }

    private void Fc() {
        this.hR.removeView(this.aAt);
        this.hR.addView(this.aAt, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void init() {
        this.aAz = EY();
        this.hR = new FrameLayout(this.mContext);
        addView(this.hR, new FrameLayout.LayoutParams(-1, -1));
    }

    private void rm() {
        if (this.aAt == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.mContext);
            this.aAt = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean Fa() {
        if (this.TD == 7) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getBufferPercentage() {
        return this.TF;
    }

    public final b getController() {
        return this.aAu;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMaxVolume() {
        AudioManager audioManager = this.aAs;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public final b getVideoController() {
        return this.aAu;
    }

    public final int getVolume() {
        AudioManager audioManager = this.aAs;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public final boolean isCompleted() {
        if (this.TD == 9) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isIdle() {
        if (this.TD == 0) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isPaused() {
        if (this.TD == 5) {
            return true;
        }
        return false;
    }

    public final boolean isPlaying() {
        if (this.TD == 4) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void start() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.TD == 0) {
            Fb();
            rm();
            Fc();
            com.kwad.sdk.contentalliance.a.a.b bVar = this.TI;
            if (bVar != null && (videoPlayerStatus = bVar.videoPlayerStatus) != null) {
                if (videoPlayerStatus.mVideoPlayerType == 0) {
                    setPlayType(1);
                } else {
                    setPlayType(3);
                }
            }
            com.kwad.sdk.core.video.a.a.a.ea("videoStartPlay");
            return;
        }
        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
    }

    public a(Context context) {
        this(context, null);
    }

    private void eg(AdTemplate adTemplate) {
        i iVar = (i) ServiceProvider.get(i.class);
        if (iVar != null) {
            iVar.load(this.aAz, e.dT(adTemplate), adTemplate);
        }
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.TI;
        if (bVar != null && (videoPlayerStatus = bVar.videoPlayerStatus) != null) {
            videoPlayerStatus.mVideoPlayerType = i;
        }
    }

    public final void seekTo(int i) {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            cVar.seekTo(i);
        }
    }

    public final void setController(b bVar) {
        this.hR.removeView(this.aAu);
        this.aAu = bVar;
        bVar.reset();
        this.hR.addView(this.aAu, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.a.a.a aVar) {
        this.dd = aVar;
    }

    public final void setLooping(boolean z) {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            cVar.setLooping(z);
        }
    }

    public final void setPortraitFullscreen(boolean z) {
        this.aAy = z;
    }

    public final void setVideoSoundEnable(boolean z) {
        this.aAx = z;
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            if (z) {
                cVar.setVolume(1.0f, 1.0f);
            } else {
                cVar.setVolume(0.0f, 0.0f);
            }
        }
    }

    public final void setVolume(int i) {
        AudioManager audioManager = this.aAs;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.TD = 0;
        this.aAv = false;
        this.aAx = false;
        this.aAy = false;
        this.TR = new c.e() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.TD = 2;
                a.this.aAu.onPlayStateChanged(a.this.TD);
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                cVar.start();
                if (a.this.aAv) {
                    cVar.seekTo((int) y.T(a.this.mContext, a.this.mUrl));
                }
                if (a.this.TG != 0) {
                    cVar.seekTo((int) a.this.TG);
                }
            }
        };
        this.TS = new c.i() { // from class: com.kwad.sdk.core.video.videoview.a.2
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void m(int i, int i2) {
                if (a.this.aAy && i2 > i) {
                    return;
                }
                a.this.aAt.adaptVideoSize(i, i2);
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
            }
        };
        this.TT = new c.b() { // from class: com.kwad.sdk.core.video.videoview.a.3
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void oO() {
                if (a.this.TD == 9) {
                    return;
                }
                a.this.TD = 9;
                a.this.aAu.onPlayStateChanged(a.this.TD);
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                a.this.hR.setKeepScreenOn(false);
            }
        };
        this.TU = new c.InterfaceC0713c() { // from class: com.kwad.sdk.core.video.videoview.a.4
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0713c
            public final boolean n(int i, int i2) {
                if (i == -38) {
                    return true;
                }
                a.this.TD = -1;
                a.this.aAu.p(i, i2);
                a.this.aAu.onPlayStateChanged(a.this.TD);
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                return true;
            }
        };
        this.TV = new c.d() { // from class: com.kwad.sdk.core.video.videoview.a.5
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean o(int i, int i2) {
                if (i != 3) {
                    if (i == 701) {
                        if (a.this.TD == 5 || a.this.TD == 7) {
                            a.this.TD = 7;
                            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                        } else {
                            a.this.TD = 6;
                            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                        }
                        a.this.aAu.onPlayStateChanged(a.this.TD);
                        return true;
                    } else if (i == 702) {
                        if (a.this.TD == 6) {
                            a.this.TD = 4;
                            a.this.aAu.onPlayStateChanged(a.this.TD);
                            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                        }
                        if (a.this.TD != 7) {
                            return true;
                        }
                        a.this.TD = 5;
                        a.this.aAu.onPlayStateChanged(a.this.TD);
                        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                        return true;
                    } else if (i == 10001) {
                        if (a.this.aAt != null) {
                            a.this.aAt.setRotation(i2);
                            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "视频旋转角度：" + i2);
                            return true;
                        }
                        return true;
                    } else if (i == 801) {
                        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "视频不能seekTo，为直播视频");
                        return true;
                    } else {
                        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> what：" + i);
                        return true;
                    }
                }
                a.this.TD = 4;
                a.this.aAu.onPlayStateChanged(a.this.TD);
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING");
                return true;
            }
        };
        this.TW = new c.a() { // from class: com.kwad.sdk.core.video.videoview.a.6
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void au(int i) {
                a.this.TF = i;
            }
        };
        this.mContext = context;
        init();
    }

    private void Fb() {
        boolean z;
        if (this.TE == null) {
            f fVar = (f) ServiceProvider.get(f.class);
            boolean z2 = true;
            if (fVar != null && fVar.yf()) {
                z = true;
            } else {
                z = false;
            }
            com.kwad.sdk.core.video.a.c a = com.kwad.sdk.core.video.a.e.a(this.mContext, false, z, (fVar == null || !fVar.yg()) ? false : false, 0);
            this.TE = a;
            a.setAudioStreamType(3);
            if (!this.aAx) {
                this.TE.setVolume(0.0f, 0.0f);
            }
        }
    }

    private void Fe() {
        AudioManager audioManager = this.aAs;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.aAs = null;
        }
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            cVar.release();
            this.TE = null;
            com.kwad.sdk.core.video.a.a.a.ea("videoFinishPlay");
        }
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.core.video.videoview.a.7
            @Override // java.lang.Runnable
            public final void run() {
                a.this.hR.removeView(a.this.aAt);
            }
        });
        Surface surface = this.Uf;
        if (surface != null) {
            surface.release();
            this.Uf = null;
        }
        SurfaceTexture surfaceTexture = this.Ue;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Ue = null;
        }
        this.TD = 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void pause() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar == null) {
            return;
        }
        int i = this.TD;
        if (i == 4) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.ea("videoPausePlay");
            this.TD = 5;
            this.aAu.onPlayStateChanged(5);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_PAUSED");
        } else if (i == 6) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.ea("videoPausePlay");
            this.TD = 7;
            this.aAu.onPlayStateChanged(7);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void release() {
        if (this.aAv) {
            if (!isPlaying() && !EZ() && !Fa() && !isPaused()) {
                if (isCompleted()) {
                    y.e(this.mContext, this.mUrl, 0L);
                }
            } else {
                y.e(this.mContext, this.mUrl, getCurrentPosition());
            }
        }
        Fe();
        b bVar = this.aAu;
        if (bVar != null) {
            bVar.reset();
        }
    }

    private void Fd() {
        this.hR.setKeepScreenOn(true);
        this.TE.b(this.TR);
        this.TE.a(this.TS);
        this.TE.a(this.TT);
        this.TE.a(this.TU);
        this.TE.c(this.TV);
        this.TE.a(this.TW);
        try {
            if (this.TI != null && this.dd != null) {
                this.TI.aoi = this.dd;
            }
            this.TE.a(this.TI);
            if (this.Uf == null) {
                this.Uf = new Surface(this.Ue);
            }
            this.TE.setSurface(this.Uf);
            if (this.TE.prepareAsync()) {
                this.TD = 1;
                this.aAu.onPlayStateChanged(1);
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.core.e.c.e("KSVideoPlayerViewView", "打开播放器发生错误", e);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void restart() {
        int i = this.TD;
        if (i == 5) {
            this.TE.start();
            com.kwad.sdk.core.video.a.a.a.ea("videoResumePlay");
            this.TD = 4;
            this.aAu.onPlayStateChanged(4);
            setPlayType(2);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_PLAYING");
        } else if (i == 7) {
            this.TE.start();
            com.kwad.sdk.core.video.a.a.a.ea("videoResumePlay");
            this.TD = 6;
            this.aAu.onPlayStateChanged(6);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
        } else if (i != 9 && i != -1) {
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.TD + " 时不能调用restart()方法.");
        } else {
            this.TE.reset();
            Fd();
            setPlayType(3);
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, Map<String, String> map) {
        this.TI = bVar;
        this.mUrl = bVar.videoUrl;
        this.mHeaders = null;
        eg(bVar.adTemplate);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.Ue;
        if (surfaceTexture2 == null) {
            this.Ue = surfaceTexture;
            Fd();
            return;
        }
        this.aAt.setSurfaceTexture(surfaceTexture2);
    }
}
