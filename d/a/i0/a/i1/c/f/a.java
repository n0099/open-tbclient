package d.a.i0.a.i1.c.f;

import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
/* loaded from: classes3.dex */
public interface a {
    void onGetCurrentSong(String str);

    void onGetDownloadProgress(int i2);

    void onGetDuration(int i2);

    void onGetPosition(int i2, int i3);

    void onInvokeFailed();

    void onStateChanged(BgMusicPlayState bgMusicPlayState);
}
