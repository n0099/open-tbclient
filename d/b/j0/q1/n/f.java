package d.b.j0.q1.n;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.helper.SimpleStyleSwitchHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.tieba.medialive.player.strategy.IVideoUpdateStrategy;
import d.b.c.e.p.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends d implements LivePlayer {
    public static final Integer i = 0;

    /* renamed from: f  reason: collision with root package name */
    public List<LivePlayer.OnProgressChangeListener> f60902f;

    /* renamed from: g  reason: collision with root package name */
    public IVideoUpdateStrategy f60903g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60904h;

    /* loaded from: classes3.dex */
    public class a extends d.b.j0.q1.n.j.a.a {
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
        public final /* synthetic */ int f60905e;

        public b(int i) {
            this.f60905e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f60905e;
            if (i == -2) {
                if (f.this.isPlaying()) {
                    f.this.pauseInternal(2);
                }
                f.this.mHasAudioFocus = false;
            } else if (i != -1) {
                if (i == 1 && f.this.isPause() && f.this.isForeground()) {
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
        this.f60902f = new ArrayList();
        this.f60904h = false;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void addProgressListener(@NonNull LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        this.f60902f.add(onProgressChangeListener);
    }

    public final IVideoUpdateStrategy c() {
        if (this.f60903g == null) {
            this.f60903g = new a(this);
        }
        return this.f60903g;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean checkMode(@NonNull String str) {
        return TextUtils.equals(this.mCurrentMode, str);
    }

    public final void d(int i2) {
        if (isPlayerMute()) {
            return;
        }
        d.b.j0.z.f.b(new b(i2));
    }

    public final void e(boolean z) {
        this.f60904h = z;
        this.mVideoSession.getControlEventTrigger().pause(z);
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.pause();
        }
        getStatDispatcher().pause();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void imCloseTimeStatistics() {
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void onAudioFocusChanged(int i2) {
        d(i2);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void onUpdateProgress(int i2, int i3, int i4) {
        for (LivePlayer.OnProgressChangeListener onProgressChangeListener : this.f60902f) {
            onProgressChangeListener.onUpdateProgress(i2, i3, i4);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void pauseInternal(int i2) {
        pauseInternal(i2 == 1);
    }

    @Override // d.b.j0.q1.n.d, com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void release() {
        super.release();
        this.f60902f.clear();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removeProgressListener(@NonNull LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        this.f60902f.remove(onProgressChangeListener);
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
            } else if (this.f60904h) {
            } else {
                resume();
            }
        }
    }

    public void saveProgressToDb() {
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
        String str = hashMap.get(i);
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

    @Override // d.b.j0.q1.n.d, com.baidu.searchbox.player.BDVideoPlayer
    public void setupPlugin(@NonNull Context context) {
        super.setupPlugin(context);
    }

    @Override // d.b.j0.q1.n.d, com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
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
        this.f60902f = new ArrayList();
        this.f60904h = false;
    }
}
