package com.kwai.video.player.kwai_player;

import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class AspectKwaiVodAdaptive {
    @NonNull
    public final KwaiMediaPlayer mPlayer;
    public String mRateConfig;

    public AspectKwaiVodAdaptive(@NonNull KwaiMediaPlayer kwaiMediaPlayer, boolean z) {
        this.mPlayer = kwaiMediaPlayer;
    }

    public void setAbrConfig(String str) {
        this.mPlayer.setOption(1, "abr-config-string", str);
    }

    public void setDeviceResolution(int i2, int i3) {
        this.mPlayer.setOption(1, "device-resolution-width", i2);
        this.mPlayer.setOption(1, "device-resolution-height", i3);
    }
}
