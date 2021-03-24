package d.b.g0.s.h;

import com.baidu.swan.videoplayer.SwanVideoView;
/* loaded from: classes3.dex */
public interface a {
    void a();

    void b(SwanVideoView swanVideoView);

    void c(boolean z);

    void onBufferingUpdate(int i);

    void onError(int i, int i2, String str);

    void onPause();

    void onPrepared();

    void onResume();

    void onSeekEnd();

    void onStart();

    void onVideoSizeChanged(int i, int i2);
}
