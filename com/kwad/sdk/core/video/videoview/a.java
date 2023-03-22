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
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.core.video.kwai.e;
import com.kwad.sdk.core.video.kwai.f;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.g;
import com.kwad.sdk.utils.w;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
@Deprecated
/* loaded from: classes8.dex */
public final class a extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, c {
    public static AtomicBoolean aea = new AtomicBoolean(false);
    public int JF;
    public com.kwad.sdk.core.video.kwai.c JG;
    public int JH;
    public long JI;
    public com.kwad.sdk.contentalliance.kwai.kwai.b JK;
    public c.e JR;
    public c.h JS;
    public c.b JT;
    public c.InterfaceC0634c JU;
    public c.d JV;
    public c.a JW;
    public SurfaceTexture Kd;
    public Surface Ke;
    public AudioManager adW;
    public com.kwad.sdk.core.video.a adX;
    public b adY;
    public boolean adZ;
    public boolean aeb;
    public boolean aec;
    public ImageView aed;
    public com.kwad.sdk.contentalliance.kwai.kwai.a bV;
    public Context mContext;
    public Map<String, String> mHeaders;
    public String mUrl;
    public FrameLayout sr;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.JF = 0;
        this.adZ = false;
        this.aeb = false;
        this.aec = false;
        this.JR = new c.e() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                a.this.JF = 2;
                a.this.adY.onPlayStateChanged(a.this.JF);
                com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                cVar.start();
                if (a.this.adZ) {
                    cVar.seekTo((int) w.A(a.this.mContext, a.this.mUrl));
                }
                if (a.this.JI != 0) {
                    cVar.seekTo((int) a.this.JI);
                }
            }
        };
        this.JS = new c.h() { // from class: com.kwad.sdk.core.video.videoview.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.h
            public final void i(int i, int i2) {
                if (!a.this.aec || i2 <= i) {
                    a.this.adX.adaptVideoSize(i, i2);
                    com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
                }
            }
        };
        this.JT = new c.b() { // from class: com.kwad.sdk.core.video.videoview.a.3
            @Override // com.kwad.sdk.core.video.kwai.c.b
            public final void ns() {
                if (a.this.JF != 9) {
                    a.this.JF = 9;
                    a.this.adY.onPlayStateChanged(a.this.JF);
                    com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    a.this.sr.setKeepScreenOn(false);
                }
            }
        };
        this.JU = new c.InterfaceC0634c() { // from class: com.kwad.sdk.core.video.videoview.a.4
            @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0634c
            public final boolean j(int i, int i2) {
                if (i != -38) {
                    a.this.JF = -1;
                    a.this.adY.l(i, i2);
                    a.this.adY.onPlayStateChanged(a.this.JF);
                    com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                    return true;
                }
                return true;
            }
        };
        this.JV = new c.d() { // from class: com.kwad.sdk.core.video.videoview.a.5
            @Override // com.kwad.sdk.core.video.kwai.c.d
            public final boolean k(int i, int i2) {
                String str;
                String str2;
                if (i == 3) {
                    a.this.JF = 4;
                    a.this.adY.onPlayStateChanged(a.this.JF);
                    str = "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING";
                } else if (i == 701) {
                    if (a.this.JF == 5 || a.this.JF == 7) {
                        a.this.JF = 7;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        a.this.JF = 6;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", str2);
                    a.this.adY.onPlayStateChanged(a.this.JF);
                    return true;
                } else if (i == 702) {
                    if (a.this.JF == 6) {
                        a.this.JF = 4;
                        a.this.adY.onPlayStateChanged(a.this.JF);
                        com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (a.this.JF != 7) {
                        return true;
                    }
                    a.this.JF = 5;
                    a.this.adY.onPlayStateChanged(a.this.JF);
                    str = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                } else if (i == 10001) {
                    if (a.this.adX == null) {
                        return true;
                    }
                    a.this.adX.setRotation(i2);
                    str = "视频旋转角度：" + i2;
                } else if (i == 801) {
                    str = "视频不能seekTo，为直播视频";
                } else {
                    str = "onInfo ——> what：" + i;
                }
                com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", str);
                return true;
            }
        };
        this.JW = new c.a() { // from class: com.kwad.sdk.core.video.videoview.a.6
            @Override // com.kwad.sdk.core.video.kwai.c.a
            public final void ai(int i) {
                a.this.JH = i;
            }
        };
        this.mContext = context;
        init();
    }

    private void cg(AdTemplate adTemplate) {
        g gVar = (g) ServiceProvider.get(g.class);
        if (gVar != null) {
            gVar.load(this.aed, d.bT(adTemplate), adTemplate);
        }
    }

    private void init() {
        this.aed = vC();
        this.sr = new FrameLayout(this.mContext);
        addView(this.sr, new FrameLayout.LayoutParams(-1, -1));
    }

    private void oZ() {
        if (this.adX == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.mContext);
            this.adX = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.JK;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i;
    }

    private ImageView vC() {
        ImageView imageView = new ImageView(this.mContext);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private boolean vD() {
        return this.JF == 6;
    }

    private void vF() {
        if (this.JG == null) {
            f fVar = (f) ServiceProvider.get(f.class);
            boolean z = true;
            com.kwad.sdk.core.video.kwai.c a = e.a(this.mContext, false, fVar != null && fVar.lt(), (fVar == null || !fVar.lu()) ? false : false);
            this.JG = a;
            a.setAudioStreamType(3);
            if (this.aeb) {
                return;
            }
            this.JG.setVolume(0.0f, 0.0f);
        }
    }

    private void vG() {
        this.sr.removeView(this.adX);
        this.sr.addView(this.adX, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void vH() {
        this.sr.setKeepScreenOn(true);
        this.JG.b(this.JR);
        this.JG.a(this.JS);
        this.JG.a(this.JT);
        this.JG.a(this.JU);
        this.JG.c(this.JV);
        this.JG.a(this.JW);
        try {
            if (this.JK != null && this.bV != null) {
                this.JK.Te = this.bV;
            }
            this.JG.a(this.JK);
            if (this.Ke == null) {
                this.Ke = new Surface(this.Kd);
            }
            this.JG.setSurface(this.Ke);
            if (this.JG.prepareAsync()) {
                this.JF = 1;
                this.adY.onPlayStateChanged(1);
                com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            com.kwad.sdk.core.e.b.e("KSVideoPlayerViewView", "打开播放器发生错误", e);
        }
    }

    private void vI() {
        AudioManager audioManager = this.adW;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.adW = null;
        }
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            cVar.release();
            this.JG = null;
        }
        this.sr.removeView(this.adX);
        Surface surface = this.Ke;
        if (surface != null) {
            surface.release();
            this.Ke = null;
        }
        SurfaceTexture surfaceTexture = this.Kd;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Kd = null;
        }
        this.JF = 0;
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, Map<String, String> map) {
        this.JK = bVar;
        this.mUrl = bVar.videoUrl;
        this.mHeaders = null;
        cg(bVar.adTemplate);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getBufferPercentage() {
        return this.JH;
    }

    public final b getController() {
        return this.adY;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getDuration() {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMaxVolume() {
        AudioManager audioManager = this.adW;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public final b getVideoController() {
        return this.adY;
    }

    public final int getVolume() {
        AudioManager audioManager = this.adW;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public final boolean isCompleted() {
        return this.JF == 9;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isIdle() {
        return this.JF == 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isPaused() {
        return this.JF == 5;
    }

    public final boolean isPlaying() {
        return this.JF == 4;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.Kd;
        if (surfaceTexture2 != null) {
            this.adX.setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.Kd = surfaceTexture;
        vH();
    }

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

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void pause() {
        String str;
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar == null) {
            return;
        }
        int i = this.JF;
        if (i == 4) {
            cVar.pause();
            this.JF = 5;
            this.adY.onPlayStateChanged(5);
            str = "STATE_PAUSED";
        } else if (i != 6) {
            return;
        } else {
            cVar.pause();
            this.JF = 7;
            this.adY.onPlayStateChanged(7);
            str = "STATE_BUFFERING_PAUSED";
        }
        com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", str);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void release() {
        Context context;
        String str;
        long currentPosition;
        if (this.adZ) {
            if (isPlaying() || vD() || vE() || isPaused()) {
                context = this.mContext;
                str = this.mUrl;
                currentPosition = getCurrentPosition();
            } else if (isCompleted()) {
                context = this.mContext;
                str = this.mUrl;
                currentPosition = 0;
            }
            w.d(context, str, currentPosition);
        }
        vI();
        b bVar = this.adY;
        if (bVar != null) {
            bVar.reset();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void restart() {
        int i = this.JF;
        if (i == 5) {
            this.JG.start();
            this.JF = 4;
            this.adY.onPlayStateChanged(4);
            setPlayType(2);
            com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", "STATE_PLAYING");
        } else if (i == 7) {
            this.JG.start();
            this.JF = 6;
            this.adY.onPlayStateChanged(6);
            com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
        } else if (i == 9 || i == -1) {
            this.JG.reset();
            vH();
            setPlayType(3);
        } else {
            com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.JF + " 时不能调用restart()方法.");
        }
    }

    public final void seekTo(int i) {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            cVar.seekTo(i);
        }
    }

    public final void setController(b bVar) {
        this.sr.removeView(this.adY);
        this.adY = bVar;
        bVar.reset();
        this.sr.addView(this.adY, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        this.bV = aVar;
    }

    public final void setPortraitFullscreen(boolean z) {
        this.aec = z;
    }

    public final void setVideoSoundEnable(boolean z) {
        this.aeb = z;
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            if (z) {
                cVar.setVolume(1.0f, 1.0f);
            } else {
                cVar.setVolume(0.0f, 0.0f);
            }
        }
    }

    public final void setVolume(int i) {
        AudioManager audioManager = this.adW;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void start() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.JF != 0) {
            com.kwad.sdk.core.e.b.i("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
            return;
        }
        vF();
        oZ();
        vG();
        com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.JK;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        setPlayType(videoPlayerStatus.mVideoPlayerType == 0 ? 1 : 3);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean vE() {
        return this.JF == 7;
    }
}
