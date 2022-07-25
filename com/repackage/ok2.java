package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface ok2 {

    /* loaded from: classes6.dex */
    public interface a {
        void b(ok2 ok2Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean f(ok2 ok2Var, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void c(ok2 ok2Var);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void e(ok2 ok2Var);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(ok2 ok2Var);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void d(ok2 ok2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    ok2 e(Context context, @NonNull cp2 cp2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(cp2 cp2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(cp2 cp2Var);

    void o(cp2 cp2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
