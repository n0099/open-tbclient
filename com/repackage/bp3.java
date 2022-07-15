package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface bp3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    bp3 e(Context context, @NonNull xn3 xn3Var);

    void g(vo3 vo3Var);

    int getCurrentPosition();

    int getDuration();

    void h(xn3 xn3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
