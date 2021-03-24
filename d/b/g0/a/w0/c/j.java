package d.b.g0.a.w0.c;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface j {

    /* loaded from: classes3.dex */
    public interface a {
        void d(j jVar);
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean b(j jVar, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void e(j jVar);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(j jVar);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void c(j jVar);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void f(j jVar);
    }

    void a();

    void b();

    j c(Context context, @NonNull d.b.g0.a.b1.g.c cVar);

    void d(d.b.g0.a.b1.g.c cVar);

    void e(boolean z);

    void f(d.b.g0.a.b1.g.c cVar);

    void g(b bVar);

    int getCurrentPosition();

    int getDuration();

    void h();

    void i(FrameLayout frameLayout);

    boolean isEnd();

    boolean isPlaying();

    void j(a aVar);

    void k(d.b.g0.a.b1.g.c cVar, boolean z);

    void l(String str);

    void m(e eVar);

    void mute(boolean z);

    void n(f fVar);

    void o(boolean z, int i);

    boolean onBackPressed();

    void p(c cVar);

    void pause();

    void q(d dVar);

    void resume();

    void seekTo(int i);

    void stop();
}
