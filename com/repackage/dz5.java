package com.repackage;

import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
/* loaded from: classes5.dex */
public interface dz5 {

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    boolean a(QmFilterItem qmFilterItem);

    void b(a aVar);

    void c(TbMultiMediaData tbMultiMediaData);

    long d();

    void e();

    void f(float f);

    boolean g();

    long getCurrentPlayTime();

    long getFrom();

    TbMediaTrackConfig getMediaTrackConfig();

    float getRatio();

    void h(boolean z);

    boolean isPlaying();

    void onDestroy();

    void onPause();

    void onResume();

    void pause();

    void start();
}
