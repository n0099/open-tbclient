package d.a.p0.w2;

import android.view.View;
/* loaded from: classes8.dex */
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
