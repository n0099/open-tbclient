package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface al2 {

    /* loaded from: classes5.dex */
    public interface a {
        void b(al2 al2Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean f(al2 al2Var, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void c(al2 al2Var);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void e(al2 al2Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(al2 al2Var);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void d(al2 al2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    al2 e(Context context, @NonNull op2 op2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(op2 op2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(op2 op2Var);

    void o(op2 op2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
