package tv.chushou.sdk.tieba.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Keep;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.HashMap;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import tv.chushou.common.player.a;
import tv.chushou.common.player.b;
@Keep
/* loaded from: classes4.dex */
public final class TiebaPlayer implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnVideoFlowListener, CyberPlayerManager.OnVideoSizeChangedListener, a {
    public static final Companion Companion = new Companion(null);
    private static final String STAGE_INFO_TYPE = "1000";
    private static final String TAG = "TiebaPlayer";
    private boolean isPrepared;
    private b listener;
    private boolean mute;
    private CyberPlayer player;
    private int state;
    private Surface surface;
    private SurfaceHolder surfaceHolder;
    private Uri uri;
    private long seekPosWhenPrepared = -1;
    private int decodeMode = 1;

    @Keep
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final void init(Context context) {
            q.j(context, "context");
            if (!CyberPlayerManager.isCoreLoaded(1)) {
                CyberPlayerManager.install(context, "ChuShou", null);
            }
        }
    }

    @Override // tv.chushou.common.player.a
    public void setVideoURI(Uri uri) {
        this.uri = uri;
    }

    @Override // tv.chushou.common.player.a
    public Uri getUri() {
        return this.uri;
    }

    @Override // tv.chushou.common.player.a
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Surface surface = surfaceHolder != null ? surfaceHolder.getSurface() : null;
        if (surface != null && surface.isValid()) {
            CyberPlayer cyberPlayer = this.player;
            if (cyberPlayer != null) {
                cyberPlayer.setDisplay(surfaceHolder);
            }
            this.surfaceHolder = surfaceHolder;
        }
    }

    public void setSurface(Surface surface) {
        if (surface != null && surface.isValid()) {
            CyberPlayer cyberPlayer = this.player;
            if (cyberPlayer != null) {
                cyberPlayer.setSurface(surface);
            }
            this.surface = surface;
        }
    }

    @Override // tv.chushou.common.player.a
    public void open() {
        CyberPlayer cyberPlayer;
        Surface surface;
        CyberPlayer cyberPlayer2;
        try {
            if (this.player != null) {
                CyberPlayer cyberPlayer3 = this.player;
                if (cyberPlayer3 != null) {
                    cyberPlayer3.setOnPreparedListener(null);
                }
                CyberPlayer cyberPlayer4 = this.player;
                if (cyberPlayer4 != null) {
                    cyberPlayer4.setOnVideoSizeChangedListener(null);
                }
                CyberPlayer cyberPlayer5 = this.player;
                if (cyberPlayer5 != null) {
                    cyberPlayer5.setOnCompletionListener(null);
                }
                CyberPlayer cyberPlayer6 = this.player;
                if (cyberPlayer6 != null) {
                    cyberPlayer6.setOnErrorListener(null);
                }
                CyberPlayer cyberPlayer7 = this.player;
                if (cyberPlayer7 != null) {
                    cyberPlayer7.setOnBufferingUpdateListener(null);
                }
                CyberPlayer cyberPlayer8 = this.player;
                if (cyberPlayer8 != null) {
                    cyberPlayer8.setOnInfoListener(null);
                }
                CyberPlayer cyberPlayer9 = this.player;
                if (cyberPlayer9 != null) {
                    cyberPlayer9.stop();
                }
                CyberPlayer cyberPlayer10 = this.player;
                if (cyberPlayer10 != null) {
                    cyberPlayer10.release();
                }
                this.player = null;
            }
            if (this.player == null) {
                this.player = new CyberPlayer(this.decodeMode);
                setStageInfo();
                CyberPlayer cyberPlayer11 = this.player;
                if (cyberPlayer11 != null) {
                    cyberPlayer11.setOnPreparedListener(this);
                }
                CyberPlayer cyberPlayer12 = this.player;
                if (cyberPlayer12 != null) {
                    cyberPlayer12.setOnVideoSizeChangedListener(this);
                }
                CyberPlayer cyberPlayer13 = this.player;
                if (cyberPlayer13 != null) {
                    cyberPlayer13.setOnCompletionListener(this);
                }
                CyberPlayer cyberPlayer14 = this.player;
                if (cyberPlayer14 != null) {
                    cyberPlayer14.setOnErrorListener(this);
                }
                CyberPlayer cyberPlayer15 = this.player;
                if (cyberPlayer15 != null) {
                    cyberPlayer15.setOnBufferingUpdateListener(this);
                }
                CyberPlayer cyberPlayer16 = this.player;
                if (cyberPlayer16 != null) {
                    cyberPlayer16.setOnInfoListener(this);
                }
                CyberPlayer cyberPlayer17 = this.player;
                if (cyberPlayer17 != null) {
                    cyberPlayer17.muteOrUnmuteAudio(this.mute);
                }
            }
            resetState();
            SurfaceHolder surfaceHolder = this.surfaceHolder;
            if (surfaceHolder != null && (surface = surfaceHolder.getSurface()) != null && surface.isValid() && (cyberPlayer2 = this.player) != null) {
                cyberPlayer2.setDisplay(surfaceHolder);
            }
            Surface surface2 = this.surface;
            if (surface2 != null && surface2.isValid() && (cyberPlayer = this.player) != null) {
                cyberPlayer.setSurface(this.surface);
            }
            CyberPlayer cyberPlayer18 = this.player;
            if (cyberPlayer18 != null) {
                Uri uri = this.uri;
                cyberPlayer18.setDataSource((uri == null || (r1 = uri.toString()) == null) ? "" : "");
            }
            CyberPlayer cyberPlayer19 = this.player;
            if (cyberPlayer19 != null) {
                cyberPlayer19.prepareAsync();
            }
            this.state = 2;
        } catch (Exception e) {
            tv.chushou.a.a.c.a.dOQ().e(TAG, "open", e);
            onError(CyberPlayerManager.MEDIA_ERROR_OPEN_VIDEO_FAIL, 0, null);
        }
    }

    @Override // tv.chushou.common.player.a
    public void play() {
        if (this.isPrepared && this.player != null) {
            CyberPlayer cyberPlayer = this.player;
            if (cyberPlayer != null) {
                cyberPlayer.start();
            }
            this.state = 4;
            b bVar = this.listener;
            if (bVar != null) {
                bVar.dBr();
            }
        }
    }

    @Override // tv.chushou.common.player.a
    public void pause() {
        if (this.isPrepared && this.player != null) {
            CyberPlayer cyberPlayer = this.player;
            if (cyberPlayer != null) {
                cyberPlayer.pause();
            }
            this.state = 5;
            b bVar = this.listener;
            if (bVar != null) {
                bVar.dBs();
            }
        }
    }

    @Override // tv.chushou.common.player.a
    public void stop() {
        if (this.player != null) {
            CyberPlayer cyberPlayer = this.player;
            if (cyberPlayer != null) {
                cyberPlayer.stop();
            }
            this.state = 6;
            this.isPrepared = false;
            b bVar = this.listener;
            if (bVar != null) {
                bVar.dBt();
            }
        }
    }

    @Override // tv.chushou.common.player.a
    public void seekTo(long j) {
        if (this.player != null && this.isPrepared) {
            CyberPlayer cyberPlayer = this.player;
            if (cyberPlayer != null) {
                cyberPlayer.seekTo(j);
                return;
            }
            return;
        }
        this.seekPosWhenPrepared = j;
    }

    @Override // tv.chushou.common.player.a
    public int getDuration() {
        CyberPlayer cyberPlayer;
        if (this.player == null || !this.isPrepared || (cyberPlayer = this.player) == null) {
            return 0;
        }
        return cyberPlayer.getDuration();
    }

    @Override // tv.chushou.common.player.a
    public int getCurrentPos() {
        CyberPlayer cyberPlayer;
        if (this.player == null || !this.isPrepared || (cyberPlayer = this.player) == null) {
            return 0;
        }
        return cyberPlayer.getCurrentPosition();
    }

    @Override // tv.chushou.common.player.a
    public int getWidth() {
        CyberPlayer cyberPlayer = this.player;
        if (cyberPlayer != null) {
            return cyberPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // tv.chushou.common.player.a
    public int getHeight() {
        CyberPlayer cyberPlayer = this.player;
        if (cyberPlayer != null) {
            return cyberPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // tv.chushou.common.player.a
    public void setOnActivityCallBack(b bVar) {
        this.listener = bVar;
    }

    @Override // tv.chushou.common.player.a
    public int getPlayState() {
        return this.state;
    }

    @Override // tv.chushou.common.player.a
    public void setVolume(float f, float f2) {
        if (f <= 0.0f) {
            this.mute = true;
            CyberPlayer cyberPlayer = this.player;
            if (cyberPlayer != null) {
                cyberPlayer.muteOrUnmuteAudio(true);
                return;
            }
            return;
        }
        this.mute = false;
        CyberPlayer cyberPlayer2 = this.player;
        if (cyberPlayer2 != null) {
            cyberPlayer2.muteOrUnmuteAudio(false);
        }
    }

    @Override // tv.chushou.common.player.a
    public void setHardwearDecod(boolean z) {
        if (z) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.decodeMode = 2;
                return;
            } else {
                this.decodeMode = 1;
                return;
            }
        }
        this.decodeMode = 1;
    }

    @Override // tv.chushou.common.player.a
    public void setDisplayRect(int i, int i2, int i3, int i4) {
    }

    @Override // tv.chushou.common.player.a
    public void release() {
        tv.chushou.a.a.c.a.dOQ().d(TAG, "release");
        CyberPlayer cyberPlayer = this.player;
        if (cyberPlayer != null) {
            cyberPlayer.setOnPreparedListener(null);
        }
        CyberPlayer cyberPlayer2 = this.player;
        if (cyberPlayer2 != null) {
            cyberPlayer2.setOnVideoSizeChangedListener(null);
        }
        CyberPlayer cyberPlayer3 = this.player;
        if (cyberPlayer3 != null) {
            cyberPlayer3.setOnCompletionListener(null);
        }
        CyberPlayer cyberPlayer4 = this.player;
        if (cyberPlayer4 != null) {
            cyberPlayer4.setOnErrorListener(null);
        }
        CyberPlayer cyberPlayer5 = this.player;
        if (cyberPlayer5 != null) {
            cyberPlayer5.setOnBufferingUpdateListener(null);
        }
        CyberPlayer cyberPlayer6 = this.player;
        if (cyberPlayer6 != null) {
            cyberPlayer6.setOnInfoListener(null);
        }
        CyberPlayer cyberPlayer7 = this.player;
        if (cyberPlayer7 != null) {
            cyberPlayer7.stop();
        }
        CyberPlayer cyberPlayer8 = this.player;
        if (cyberPlayer8 != null) {
            cyberPlayer8.release();
        }
        this.player = null;
        resetState();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        tv.chushou.a.a.c.a.dOQ().d(TAG, "onBufferingUpdate:" + i);
        b bVar = this.listener;
        if (bVar != null) {
            bVar.MD(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        tv.chushou.a.a.c.a.dOQ().d(TAG, "onPrepared");
        this.state = 3;
        this.isPrepared = true;
        if (this.seekPosWhenPrepared > 0) {
            CyberPlayer cyberPlayer = this.player;
            if (cyberPlayer != null) {
                cyberPlayer.seekTo(this.seekPosWhenPrepared);
            }
            this.seekPosWhenPrepared = -1L;
        }
        b bVar = this.listener;
        if (bVar != null) {
            bVar.dBo();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        tv.chushou.a.a.c.a.dOQ().d(TAG, "onCompletion");
        this.state = 7;
        this.seekPosWhenPrepared = -1L;
        b bVar = this.listener;
        if (bVar != null) {
            bVar.dBm();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        tv.chushou.a.a.c.a.dOQ().d(TAG, "onError, what:" + i + ", extra:" + i2 + ", obj:" + obj);
        this.state = -1;
        b bVar = this.listener;
        if (bVar != null) {
            bVar.ME(i2);
            return true;
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        tv.chushou.a.a.c.a.dOQ().d(TAG, "onInfo, what:" + i + ", extra:" + i2 + ", obj:" + obj);
        switch (i) {
            case CyberPlayerManager.MEDIA_INFO_BUFFERING_START /* 701 */:
                b bVar = this.listener;
                if (bVar != null) {
                    bVar.dBp();
                    return true;
                }
                return true;
            case CyberPlayerManager.MEDIA_INFO_BUFFERING_END /* 702 */:
                b bVar2 = this.listener;
                if (bVar2 != null) {
                    bVar2.dBq();
                    return true;
                }
                return true;
            case CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL /* 904 */:
                b bVar3 = this.listener;
                if (bVar3 != null) {
                    bVar3.dBn();
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        tv.chushou.a.a.c.a.dOQ().d(TAG, "onVideoSizeChanged");
        b bVar = this.listener;
        if (bVar != null) {
            bVar.dBl();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoFlowListener
    public void onRecordFlow(HashMap<String, String> hashMap) {
        tv.chushou.a.a.c.a.dOQ().d(TAG, "onRecordFlow");
    }

    private final void resetState() {
        this.state = 0;
        this.isPrepared = false;
        this.seekPosWhenPrepared = -1L;
    }

    private final void setStageInfo() {
        HashMap hashMap = new HashMap();
        hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, "1000");
        CyberPlayer cyberPlayer = this.player;
        if (cyberPlayer != null) {
            cyberPlayer.setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, hashMap);
        }
    }
}
