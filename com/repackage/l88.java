package com.repackage;

import android.widget.MediaController;
import com.baidu.tieba.play.TbVideoViewContainer;
/* loaded from: classes6.dex */
public interface l88 extends MediaController.MediaPlayerControl {
    void a(long j, long j2, long j3);

    int getCurrentPositionSync();

    m88 getMediaProgressObserver();

    int getPcdnState();

    int getPlayerHeight();

    int getPlayerWidth();

    void setLooping(boolean z);

    void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar);

    void setOperableVideoContainer(e98 e98Var);

    void setPlayMode(String str);

    void setStageType(String str);

    void setVideoPath(String str);

    void setVideoPath(String str, String str2);

    void setVideoStatData(z88 z88Var);

    void setVolume(float f, float f2);

    void stopPlayback();
}
