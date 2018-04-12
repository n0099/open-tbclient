package tv.danmaku.ijk.media.player;

import android.view.View;
import android.widget.MediaController;
/* loaded from: classes2.dex */
public interface IMediaController {
    void hide();

    boolean isShowing();

    void setAnchorView(View view2);

    void setEnabled(boolean z);

    void setMediaPlayer(MediaController.MediaPlayerControl mediaPlayerControl);

    void show();

    void show(int i);

    void showOnce(View view2);
}
