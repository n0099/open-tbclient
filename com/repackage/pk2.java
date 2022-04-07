package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface pk2 {

    /* loaded from: classes6.dex */
    public interface a {
        void b(pk2 pk2Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean f(pk2 pk2Var, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void c(pk2 pk2Var);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void e(pk2 pk2Var);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(pk2 pk2Var);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void d(pk2 pk2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    pk2 e(Context context, @NonNull dp2 dp2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(dp2 dp2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(dp2 dp2Var);

    void o(dp2 dp2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
