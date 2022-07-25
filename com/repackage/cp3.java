package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface cp3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    cp3 e(Context context, @NonNull yn3 yn3Var);

    void g(wo3 wo3Var);

    int getCurrentPosition();

    int getDuration();

    void h(yn3 yn3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
