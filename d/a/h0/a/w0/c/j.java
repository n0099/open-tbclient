package d.a.h0.a.w0.c;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public interface j {

    /* loaded from: classes2.dex */
    public interface a {
        void b(j jVar);
    }

    /* loaded from: classes2.dex */
    public interface b {
        boolean f(j jVar, int i2, int i3);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void c(j jVar);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void e(j jVar);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(j jVar);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void d(j jVar);
    }

    void a();

    void b();

    j c(Context context, @NonNull d.a.h0.a.b1.g.c cVar);

    void d();

    void e(FrameLayout frameLayout);

    void f(a aVar);

    void g(d.a.h0.a.b1.g.c cVar, boolean z);

    int getCurrentPosition();

    int getDuration();

    void h(String str);

    void i(e eVar);

    boolean isEnd();

    boolean isPlaying();

    void j(f fVar);

    void k(boolean z, int i2);

    void l(d dVar);

    void m(d.a.h0.a.b1.g.c cVar);

    void mute(boolean z);

    void n(boolean z);

    void o(d.a.h0.a.b1.g.c cVar);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    void q(c cVar);

    void resume();

    void seekTo(int i2);

    void stop();
}
