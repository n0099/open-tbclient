package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface nk2 {

    /* loaded from: classes6.dex */
    public interface a {
        void b(nk2 nk2Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean f(nk2 nk2Var, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void c(nk2 nk2Var);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void e(nk2 nk2Var);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(nk2 nk2Var);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void d(nk2 nk2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    nk2 e(Context context, @NonNull bp2 bp2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(bp2 bp2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(bp2 bp2Var);

    void o(bp2 bp2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
