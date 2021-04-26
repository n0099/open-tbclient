package com.kwad.sdk.live.mode;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class a {
    public static String a(@NonNull LiveInfo liveInfo) {
        return liveInfo.liveStreamId;
    }

    public static long b(@NonNull LiveInfo liveInfo) {
        return liveInfo.user.user_id;
    }

    public static String c(@NonNull LiveInfo liveInfo) {
        return liveInfo.exp_tag;
    }
}
