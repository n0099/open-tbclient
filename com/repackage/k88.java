package com.repackage;

import android.widget.MediaController;
import com.baidu.tieba.play.TbVideoViewContainer;
/* loaded from: classes6.dex */
public interface k88 extends MediaController.MediaPlayerControl {
    void a(long j, long j2, long j3);

    int getCurrentPositionSync();

    l88 getMediaProgressObserver();

    int getPcdnState();

    int getPlayerHeight();

    int getPlayerWidth();

    void setLooping(boolean z);

    void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar);

    void setOperableVideoContainer(d98 d98Var);

    void setPlayMode(String str);

    void setStageType(String str);

    void setVideoPath(String str);

    void setVideoPath(String str, String str2);

    void setVideoStatData(y88 y88Var);

    void setVolume(float f, float f2);

    void stopPlayback();
}
