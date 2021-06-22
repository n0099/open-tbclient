package d.a.m0.a.c1.d;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface j {

    /* loaded from: classes3.dex */
    public interface a {
        void b(j jVar);
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean f(j jVar, int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void c(j jVar);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void e(j jVar);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(j jVar);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void d(j jVar);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    j e(Context context, @NonNull d.a.m0.a.i1.g.c cVar);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(d.a.m0.a.i1.g.c cVar, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i2);

    void m(d dVar);

    void mute(boolean z);

    void n(d.a.m0.a.i1.g.c cVar);

    void o(d.a.m0.a.i1.g.c cVar);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    void q(c cVar);

    void resume();

    void seekTo(int i2);

    void stop();
}
