package d.a.n0.r1.p;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
/* loaded from: classes3.dex */
public class d extends UniversalPlayer {

    /* renamed from: e  reason: collision with root package name */
    public Context f63602e;

    public d(@Nullable Context context, @NonNull String str) {
        super(context, new BaseKernelLayer("NormalVideoKernel"), str);
        this.f63602e = context;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public int getVideoHeight() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            return baseKernelLayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public int getVideoWidth() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            return baseKernelLayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void goBackOrForeground(boolean z) {
        super.goBackOrForeground(z);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        super.onCompletion();
        getPlayerCallbackManager().onUpdateProgress(getPosition(), getBufferingPosition(), getDuration());
        this.mProgressHelper.cancel();
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        super.onSeekComplete();
        this.mProgressHelper.start();
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void pause() {
        super.pause();
        this.mProgressHelper.cancel();
    }

    @Override // com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void release() {
        super.release();
        this.mProgressHelper.cancel();
        disableOrientationEventHelper();
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void resume() {
        super.resume();
        this.mProgressHelper.start();
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public final void resumeFromError() {
        setVideoUrl(this.mVideoTask.videoUrl);
        super.resumePlayer(false);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setStageInfo(String str, String str2, String str3) {
        super.setStageInfo(str, str2, str3);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoUrl(@NonNull String str) {
        super.setVideoUrl(str);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupPlugin(@NonNull Context context) {
        super.setupPlugin(context);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        super.start();
        this.mProgressHelper.start();
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void stop() {
        super.stop();
        this.mProgressHelper.cancel();
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setVideoUrl(@NonNull String str, boolean z) {
        super.setVideoUrl(str, z);
    }
}
