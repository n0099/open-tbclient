package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface tp3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    tp3 e(Context context, @NonNull po3 po3Var);

    void g(np3 np3Var);

    int getCurrentPosition();

    int getDuration();

    void h(po3 po3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
