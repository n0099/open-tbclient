package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface bo3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    bo3 e(Context context, @NonNull xm3 xm3Var);

    void g(vn3 vn3Var);

    int getCurrentPosition();

    int getDuration();

    void h(xm3 xm3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
