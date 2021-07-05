package d.a.s0.w2;

import android.view.View;
/* loaded from: classes9.dex */
public interface m {
    void autoPlay(int i2);

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
