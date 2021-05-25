package d.a.l0.v.h;

import com.baidu.swan.videoplayer.SwanVideoView;
/* loaded from: classes3.dex */
public interface a {
    void a(SwanVideoView swanVideoView);

    void b(boolean z);

    void onBufferingUpdate(int i2);

    void onEnd();

    void onError(int i2, int i3, String str);

    void onPause();

    void onPrepared();

    void onResume();

    void onSeekEnd();

    void onStart();

    void onVideoSizeChanged(int i2, int i3);
}
