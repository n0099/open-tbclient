package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface mo3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    mo3 e(Context context, @NonNull in3 in3Var);

    void g(go3 go3Var);

    int getCurrentPosition();

    int getDuration();

    void h(in3 in3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
