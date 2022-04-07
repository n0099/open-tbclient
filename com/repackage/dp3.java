package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface dp3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    dp3 e(Context context, @NonNull zn3 zn3Var);

    void g(xo3 xo3Var);

    int getCurrentPosition();

    int getDuration();

    void h(zn3 zn3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
