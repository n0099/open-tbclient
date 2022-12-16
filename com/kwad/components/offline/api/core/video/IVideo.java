package com.kwad.components.offline.api.core.video;

import android.content.Context;
/* loaded from: classes8.dex */
public interface IVideo {
    IKsMediaPlayer createMediaPlayer(IKsMediaPlayerView iKsMediaPlayerView);

    BaseKsMediaPlayerView createMediaPlayerView(Context context);
}
