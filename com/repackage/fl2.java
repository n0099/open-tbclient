package com.repackage;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface fl2 {

    /* loaded from: classes6.dex */
    public interface a {
        void b(fl2 fl2Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean f(fl2 fl2Var, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void c(fl2 fl2Var);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void e(fl2 fl2Var);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(fl2 fl2Var);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void d(fl2 fl2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    fl2 e(Context context, @NonNull tp2 tp2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(tp2 tp2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(tp2 tp2Var);

    void o(tp2 tp2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
