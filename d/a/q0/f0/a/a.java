package d.a.q0.f0.a;

import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
/* loaded from: classes8.dex */
public interface a {
    boolean a(QmFilterItem qmFilterItem);

    void b(TbMultiMediaData tbMultiMediaData);

    long c();

    void d(float f2);

    boolean e();

    void f(boolean z);

    long getFrom();

    TbMediaTrackConfig getMediaTrackConfig();

    float getRatio();

    boolean isPlaying();

    void onDestroy();

    void onPause();

    void onResume();

    void pause();

    void start();
}
