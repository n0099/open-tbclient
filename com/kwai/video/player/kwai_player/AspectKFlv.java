package com.kwai.video.player.kwai_player;

import android.text.TextUtils;
import androidx.annotation.Keep;
@Keep
/* loaded from: classes6.dex */
public class AspectKFlv {
    public final KwaiMediaPlayer mPlayer;

    public AspectKFlv(KwaiMediaPlayer kwaiMediaPlayer, boolean z) {
        this.mPlayer = kwaiMediaPlayer;
        kwaiMediaPlayer.setOption(4, "enable-live-manifest", z ? 1L : 0L);
    }

    public boolean isLiveManifest() {
        return this.mPlayer._isLiveManifest();
    }

    public void setLiveAdaptiveConfig(String str) {
        KwaiMediaPlayer kwaiMediaPlayer = this.mPlayer;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        kwaiMediaPlayer.setOption(1, "liveAdaptConfig", str);
    }
}
