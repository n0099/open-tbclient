package d.b.g0.a.b1.c.f;

import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
/* loaded from: classes2.dex */
public interface a {
    void onGetCurrentSong(String str);

    void onGetDownloadProgress(int i);

    void onGetDuration(int i);

    void onGetPosition(int i, int i2);

    void onInvokeFailed();

    void onStateChanged(BgMusicPlayState bgMusicPlayState);
}
