package com.kwai.video.player.kwai_player;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class AspectKwaiVodAdaptive {
    @NonNull
    private final KwaiMediaPlayer mPlayer;
    private String mRateConfig;

    public AspectKwaiVodAdaptive(@NonNull KwaiMediaPlayer kwaiMediaPlayer, boolean z) {
        this.mPlayer = kwaiMediaPlayer;
    }

    public void setAbrConfig(String str) {
        this.mPlayer.setOption(1, "abr-config-string", str);
    }

    public void setDeviceResolution(int i, int i2) {
        this.mPlayer.setOption(1, "device-resolution-width", i);
        this.mPlayer.setOption(1, "device-resolution-height", i2);
    }
}
