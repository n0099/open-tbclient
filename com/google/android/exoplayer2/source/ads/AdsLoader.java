package com.google.android.exoplayer2.source.ads;

import android.view.ViewGroup;
import com.google.android.exoplayer2.ExoPlayer;
import java.io.IOException;
/* loaded from: classes6.dex */
public interface AdsLoader {

    /* loaded from: classes6.dex */
    public interface EventListener {
        void onAdClicked();

        void onAdPlaybackState(AdPlaybackState adPlaybackState);

        void onAdTapped();

        void onLoadError(IOException iOException);
    }

    void attachPlayer(ExoPlayer exoPlayer, EventListener eventListener, ViewGroup viewGroup);

    void detachPlayer();

    void release();
}
