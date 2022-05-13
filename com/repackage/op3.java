package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface op3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    op3 e(Context context, @NonNull ko3 ko3Var);

    void g(ip3 ip3Var);

    int getCurrentPosition();

    int getDuration();

    void h(ko3 ko3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
