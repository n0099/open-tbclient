package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface nj2 {

    /* loaded from: classes6.dex */
    public interface a {
        void b(nj2 nj2Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean f(nj2 nj2Var, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void c(nj2 nj2Var);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void e(nj2 nj2Var);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(nj2 nj2Var);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void d(nj2 nj2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    nj2 e(Context context, @NonNull bo2 bo2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(bo2 bo2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(bo2 bo2Var);

    void o(bo2 bo2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
