package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface yj2 {

    /* loaded from: classes7.dex */
    public interface a {
        void b(yj2 yj2Var);
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean f(yj2 yj2Var, int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void c(yj2 yj2Var);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void e(yj2 yj2Var);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(yj2 yj2Var);
    }

    /* loaded from: classes7.dex */
    public interface f {
        void d(yj2 yj2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    yj2 e(Context context, @NonNull mo2 mo2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(mo2 mo2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(mo2 mo2Var);

    void o(mo2 mo2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
