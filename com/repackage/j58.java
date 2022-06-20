package com.repackage;

import android.widget.MediaController;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
/* loaded from: classes6.dex */
public interface j58 extends MediaController.MediaPlayerControl {
    void a(long j, long j2, long j3);

    void b(TbVideoViewSet.b bVar);

    void changeRenderViewMode(int i);

    int getCurrentPositionSync();

    k58 getMediaProgressObserver();

    String getOriginUrl();

    int getPcdnState();

    i58 getPlayer();

    int getPlayerHeight();

    int getPlayerWidth();

    OnStatusChangedListener.VideoStatus getVideoStatus();

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

    void setOperableVideoContainer(c68 c68Var);

    void setPlayMode(String str);

    void setStageType(String str);

    void setThreadDataForStatistic(ThreadData threadData);

    void setTryUseViewInSet(boolean z);

    void setVideoModel(v58 v58Var);

    void setVideoPath(String str);

    void setVideoPath(String str, String str2);

    void setVideoScalingMode(int i);

    void setVideoStatData(x58 x58Var);

    void setVideoStatusChangeListener(OnStatusChangedListener onStatusChangedListener);

    void setVolume(float f, float f2);

    void stop();

    void stopPlayback();
}
