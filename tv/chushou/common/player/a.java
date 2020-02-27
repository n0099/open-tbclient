package tv.chushou.common.player;

import android.net.Uri;
import android.view.SurfaceHolder;
/* loaded from: classes5.dex */
public interface a {
    int getCurrentPos();

    int getDuration();

    int getHeight();

    int getPlayState();

    Uri getUri();

    int getWidth();

    void open();

    void pause();

    void play();

    void release();

    void seekTo(long j);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setDisplayRect(int i, int i2, int i3, int i4);

    void setHardwearDecod(boolean z);

    void setOnActivityCallBack(b bVar);

    void setVideoURI(Uri uri);

    void setVolume(float f, float f2);

    void stop();
}
