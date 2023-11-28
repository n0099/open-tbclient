package com.kwad.components.ad.reward.monitor;
/* loaded from: classes10.dex */
public enum RewardInteractionCallbackType implements a {
    AD_CLICK("ad_click"),
    PAGE_DISMISS("page_close"),
    VIDEO_PLAY_ERROR("play_error"),
    VIDEO_PLAY_END("play_end"),
    VIDEO_SKIP_TO_END("skip_to_end"),
    VIDEO_PLAY_START("play_start"),
    REWARD_VERIFY("reward_verify"),
    REWARD_STEP_VERIFY("reward_step_verify"),
    EXTRA_REWARD_VERIFY("extra_reward_verify");
    
    public String typeValue;

    RewardInteractionCallbackType(String str) {
        this.typeValue = str;
    }

    @Override // com.kwad.components.ad.reward.monitor.a
    public final String getTypeValue() {
        return this.typeValue;
    }
}
