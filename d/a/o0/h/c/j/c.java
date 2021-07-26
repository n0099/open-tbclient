package d.a.o0.h.c.j;

import android.media.MediaPlayer;
/* loaded from: classes7.dex */
public interface c extends d.a.o0.h.c.a {
    void a(boolean z);

    void c(String str) throws Exception;

    void e(d.a.o0.l.a.c cVar);

    void g(MediaPlayer.OnInfoListener onInfoListener);

    void h(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void j(MediaPlayer.OnPreparedListener onPreparedListener);

    void l(MediaPlayer.OnErrorListener onErrorListener);

    void o(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void r(MediaPlayer.OnCompletionListener onCompletionListener);

    void setVolume(float f2);

    boolean t();
}
