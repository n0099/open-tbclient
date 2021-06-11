package d.a.n0.r1.p;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.helper.SimpleStyleSwitchHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.tieba.medialive.player.strategy.IVideoUpdateStrategy;
import d.a.c.e.p.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends d implements LivePlayer {

    /* renamed from: i  reason: collision with root package name */
    public static final Integer f63603i = 0;

    /* renamed from: f  reason: collision with root package name */
    public List<LivePlayer.OnProgressChangeListener> f63604f;

    /* renamed from: g  reason: collision with root package name */
    public IVideoUpdateStrategy f63605g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63606h;

    /* loaded from: classes3.dex */
    public class a extends d.a.n0.r1.p.j.a.a {
        public a(f fVar) {
        }

        @Override // com.baidu.tieba.medialive.player.strategy.IVideoUpdateStrategy
        public boolean a() {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f63607e;

        public b(int i2) {
            this.f63607e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.f63607e;
            if (i2 == -2) {
                if (f.this.isPlaying()) {
                    f.this.pauseInternal(2);
                }
                f.this.mHasAudioFocus = false;
            } else if (i2 != -1) {
                if (i2 == 1 && f.this.isPause() && f.this.isForeground()) {
                    f.this.resume();
                }
            } else {
                if (f.this.isPlaying()) {
                    f.this.pauseInternal(2);
                }
                f.this.abandonAudioFocus();
            }
        }
    }

    public f(String str) {
        super(null, str);
        this.f63604f = new ArrayList();
        this.f63606h = false;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void addOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void addProgressListener(@NonNull LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        this.f63604f.add(onProgressChangeListener);
    }

    public final IVideoUpdateStrategy c() {
        if (this.f63605g == null) {
            this.f63605g = new a(this);
        }
        return this.f63605g;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean checkMode(@NonNull String str) {
        return TextUtils.equals(this.mCurrentMode, str);
    }

    public final void d(int i2) {
        if (isPlayerMute()) {
            return;
        }
        d.a.n0.b0.f.b(new b(i2));
    }

    public final void e(boolean z) {
        this.f63606h = z;
        this.mVideoSession.getControlEventTrigger().pause(z);
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.pause();
        }
        getStatDispatcher().pause();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public Object getInfo(Object obj, Object obj2, LivePlayer.InfoCallback infoCallback) {
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void imCloseTimeStatistics() {
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void onAudioFocusChanged(int i2) {
        d(i2);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void pauseInternal(int i2) {
        pauseInternal(i2 == 1);
    }

    @Override // d.a.n0.r1.p.d, com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void release() {
        super.release();
        this.f63604f.clear();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removeOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removeProgressListener(@NonNull LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        this.f63604f.remove(onProgressChangeListener);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resetDefaultSwitchHelper() {
        this.mStyleSwitchHelper = new SimpleStyleSwitchHelper(this);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resume(boolean z) {
        if (isPause()) {
            if (z) {
                super.resume();
            } else if (this.f63606h) {
            } else {
                resume();
            }
        }
    }

    public void saveProgressToDb() {
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void seekTo(int i2, int i3) {
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setExtInfoStatistics(HashMap<String, String> hashMap) {
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setMode(@NonNull String str) {
        this.mCurrentMode = str;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setVideoInfo(@Nullable HashMap<Integer, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        String str = hashMap.get(f63603i);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setVideoUrl(str);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupPlayer(Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        super.setupPlayer(context, baseKernelLayer);
        this.mLayerContainer.setClickable(false);
    }

    @Override // d.a.n0.r1.p.d, com.baidu.searchbox.player.BDVideoPlayer
    public void setupPlugin(@NonNull Context context) {
        super.setupPlugin(context);
    }

    @Override // d.a.n0.r1.p.d, com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        super.start();
        if (this.mVideoTask.videoUrl.isEmpty()) {
            return;
        }
        if (!j.H() && !j.z()) {
            if (j.v() || j.u()) {
                if (c().a()) {
                    doPlay();
                    return;
                } else {
                    this.mVideoSession.getControlEventTrigger().showNetTip();
                    return;
                }
            }
            return;
        }
        doPlay();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void stopTimeStatistics() {
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void pauseInternal(boolean z) {
        e(z);
    }

    public f(@Nullable Context context, String str) {
        super(context, str);
        this.f63604f = new ArrayList();
        this.f63606h = false;
    }
}
