package com.repackage;

import android.media.MediaPlayer;
/* loaded from: classes6.dex */
public interface kt3 extends xs3 {
    void a(boolean z);

    void d(String str) throws Exception;

    void f(v54 v54Var);

    void h(MediaPlayer.OnInfoListener onInfoListener);

    void i(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void k(MediaPlayer.OnPreparedListener onPreparedListener);

    void l(MediaPlayer.OnErrorListener onErrorListener);

    void o(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void r(MediaPlayer.OnCompletionListener onCompletionListener);

    void setVolume(float f);

    boolean t();
}
