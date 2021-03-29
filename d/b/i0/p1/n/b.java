package d.b.i0.p1.n;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.interfaces.liveshowplayer.LiveShowPlayerCallback;
import com.baidu.searchbox.live.interfaces.liveshowplayer.LiveShowPlayerStatusCallback;
import com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService;
import com.baidu.tieba.medialive.player.TbLiveVideoView;
/* loaded from: classes3.dex */
public class b implements LiveShowPlayerService {

    /* loaded from: classes3.dex */
    public class a implements CyberPlayerManager.InstallListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveShowPlayerCallback f58809a;

        public a(b bVar, LiveShowPlayerCallback liveShowPlayerCallback) {
            this.f58809a = liveShowPlayerCallback;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            LiveShowPlayerCallback liveShowPlayerCallback = this.f58809a;
            if (liveShowPlayerCallback != null) {
                liveShowPlayerCallback.cyberInitCallBack(-1, str);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            LiveShowPlayerCallback liveShowPlayerCallback = this.f58809a;
            if (liveShowPlayerCallback != null) {
                liveShowPlayerCallback.cyberInitCallBack(0, str);
            }
        }
    }

    /* renamed from: d.b.i0.p1.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1452b extends d.b.i0.p1.n.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveShowPlayerCallback f58810a;

        public C1452b(b bVar, LiveShowPlayerCallback liveShowPlayerCallback) {
            this.f58810a = liveShowPlayerCallback;
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            LiveShowPlayerCallback liveShowPlayerCallback = this.f58810a;
            if (liveShowPlayerCallback != null) {
                liveShowPlayerCallback.playerCallBack(i, Integer.valueOf(i2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TbLiveVideoView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveShowPlayerStatusCallback f58811a;

        public c(b bVar, LiveShowPlayerStatusCallback liveShowPlayerStatusCallback) {
            this.f58811a = liveShowPlayerStatusCallback;
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onBufferingUpdate(int i) {
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onCompletion() {
            LiveShowPlayerStatusCallback liveShowPlayerStatusCallback = this.f58811a;
            if (liveShowPlayerStatusCallback != null) {
                liveShowPlayerStatusCallback.onEnded();
            }
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onError(int i, int i2) {
            LiveShowPlayerStatusCallback liveShowPlayerStatusCallback = this.f58811a;
            if (liveShowPlayerStatusCallback != null) {
                liveShowPlayerStatusCallback.onError(i, i2);
            }
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onInfo(int i, int i2) {
            LiveShowPlayerStatusCallback liveShowPlayerStatusCallback = this.f58811a;
            if (liveShowPlayerStatusCallback != null) {
                liveShowPlayerStatusCallback.onInfo(i, i2);
            }
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onPrepared() {
            LiveShowPlayerStatusCallback liveShowPlayerStatusCallback = this.f58811a;
            if (liveShowPlayerStatusCallback != null) {
                liveShowPlayerStatusCallback.onStart();
            }
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onSeekComplete() {
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onVideoSizeChanged(int i, int i2) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public Object createPlayerWithUrl(Context context, String str) {
        return (TbLiveVideoView) getLivePlayer(context);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void dismissFloating(Object obj, boolean z) {
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public int getCurrentPosition(Object obj) {
        if (obj instanceof TbLiveVideoView) {
            return ((TbLiveVideoView) obj).getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public int getDuration(Object obj) {
        if (obj instanceof TbLiveVideoView) {
            return ((TbLiveVideoView) obj).getDuration();
        }
        return 0;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public Object getLivePlayer(Context context) {
        return new TbLiveVideoView(context);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public View getPlayerView(Object obj) {
        if (obj instanceof TbLiveVideoView) {
            return (TbLiveVideoView) obj;
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public int getVideoHeight(Object obj) {
        if (obj instanceof TbLiveVideoView) {
            return ((TbLiveVideoView) obj).getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public String getVideoPath(Object obj) {
        if (obj instanceof TbLiveVideoView) {
            return ((TbLiveVideoView) obj).getVideoURI().getPath();
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public int getVideoWidth(Object obj) {
        if (obj instanceof TbLiveVideoView) {
            return ((TbLiveVideoView) obj).getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public boolean hasFloatingPermission() {
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void initCyberCore(LiveShowPlayerCallback liveShowPlayerCallback, int i) {
        g.e().g(new a(this, liveShowPlayerCallback));
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public boolean isCoreLoaded(int i) {
        return g.e().f();
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public boolean isFloatShowing(Object obj) {
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public boolean isPlaying(Object obj) {
        if (obj instanceof TbLiveVideoView) {
            return ((TbLiveVideoView) obj).isPlaying();
        }
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void mute(Object obj, boolean z) {
        if (obj instanceof TbLiveVideoView) {
            ((TbLiveVideoView) obj).muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void pause(Object obj) {
        if (obj instanceof TbLiveVideoView) {
            new Throwable().printStackTrace();
            ((TbLiveVideoView) obj).pause();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void resume(Object obj) {
        if (obj instanceof TbLiveVideoView) {
            ((TbLiveVideoView) obj).start();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setDecodeMode(Object obj, int i) {
        if (obj instanceof TbLiveVideoView) {
            ((TbLiveVideoView) obj).setDecodeMode(i);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setExternalInfo(Object obj, String str, Object obj2) {
        if (obj instanceof TbLiveVideoView) {
            ((TbLiveVideoView) obj).setExternalInfo(str, obj2);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setPlayerCallback(Object obj, LiveShowPlayerCallback liveShowPlayerCallback) {
        if (obj instanceof f) {
            ((f) obj).setPlayerListener(new C1452b(this, liveShowPlayerCallback));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setVideoPath(Object obj, String str) {
        if (obj instanceof TbLiveVideoView) {
            ((TbLiveVideoView) obj).setVideoURI(Uri.parse(str));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setVideoRotation(Object obj, int i) {
        if (obj instanceof TbLiveVideoView) {
            ((TbLiveVideoView) obj).setVideoRotation(i);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setVideoScalingMode(Object obj, int i) {
        if (obj instanceof TbLiveVideoView) {
            ((TbLiveVideoView) obj).setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public Object showFloating(Object obj, View view, String str, LiveShowPlayerCallback liveShowPlayerCallback) {
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void start(Object obj) {
        if (obj instanceof TbLiveVideoView) {
            ((TbLiveVideoView) obj).start();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void stopPlayback(Object obj) {
        if (obj instanceof TbLiveVideoView) {
            ((TbLiveVideoView) obj).stopPlayback();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void switchNormal(Object obj) {
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setPlayerCallback(Object obj, LiveShowPlayerStatusCallback liveShowPlayerStatusCallback) {
        if (obj instanceof TbLiveVideoView) {
            ((TbLiveVideoView) obj).setPlayerCallback(new c(this, liveShowPlayerStatusCallback));
        }
    }
}
