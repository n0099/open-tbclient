package com.repackage;

import android.view.View;
/* loaded from: classes6.dex */
public interface i98 {
    void autoPlay(int i);

    boolean canPlay();

    long getCurrentPosition();

    int getPlayStatus();

    String getPlayUrl();

    View getVideoContainer();

    boolean isPlayStarted();

    boolean isPlaying();

    void release();

    void startPlay();

    void stopPlay();
}
