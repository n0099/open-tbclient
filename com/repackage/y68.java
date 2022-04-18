package com.repackage;

import android.widget.MediaController;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
/* loaded from: classes7.dex */
public interface y68 extends MediaController.MediaPlayerControl {
    void a(long j, long j2, long j3);

    void b(TbVideoViewSet.b bVar);

    void changeRenderViewMode(int i);

    int getCurrentPositionSync();

    z68 getMediaProgressObserver();

    String getOriginUrl();

    int getPcdnState();

    x68 getPlayer();

    int getPlayerHeight();

    int getPlayerWidth();

    int getVideoHeight();

    OnStatusChangedListener.VideoStatus getVideoStatus();

    int getVideoWidth();

    void j();

    void k();

    boolean l();

    void m();

    boolean n();

    void o();

    void p(TbVideoViewSet.b bVar);

    void q();

    void setCanShowPause(boolean z);

    void setContinuePlayEnable(boolean z);

    void setIsVolume0(boolean z);

    void setLocateSource(String str);

    void setLooping(boolean z);

    void setNoBussinessStats();

    void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar);

    void setOperableVideoContainer(r78 r78Var);

    void setPlayMode(String str);

    void setStageType(String str);

    void setThreadDataForStatistic(ThreadData threadData);

    void setTryUseViewInSet(boolean z);

    void setVideoModel(k78 k78Var);

    void setVideoPath(String str);

    void setVideoPath(String str, String str2);

    void setVideoScalingMode(int i);

    void setVideoStatData(m78 m78Var);

    void setVideoStatusChangeListener(OnStatusChangedListener onStatusChangedListener);

    void setVolume(float f, float f2);

    void stop();

    void stopPlayback();
}
