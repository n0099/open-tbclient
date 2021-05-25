package d.a.l0.f.i.m.b;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import d.a.l0.f.i.l.e;
/* loaded from: classes3.dex */
public interface c {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    c e(Context context, @NonNull d.a.l0.f.i.j.b bVar);

    void g(e eVar);

    int getCurrentPosition();

    int getDuration();

    void h(d.a.l0.f.i.j.b bVar);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
