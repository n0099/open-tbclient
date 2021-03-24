package d.b.g0.a.s0.k.g;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import d.b.g0.a.s0.d;
/* loaded from: classes3.dex */
public interface a extends d {

    /* renamed from: d.b.g0.a.s0.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0792a {
        void a(int i);

        void b(String str);

        void c(int i);

        void d(@NonNull String str);

        void e(String str);

        void f();

        void onEnded();

        void onError(int i);

        void onPrepared();

        void onRelease(String str);
    }

    void H();

    void O(String str);

    void Q();

    void U(boolean z);

    void Y(int i);

    int a();

    void a0(@NonNull InterfaceC0792a interfaceC0792a);

    String c();

    void d0(int i);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void k(int i, int i2, int i3, int i4);

    boolean n(String str, String str2, String str3, boolean z);

    boolean o();

    void pause();

    boolean prepareAsync();

    void r(boolean z);

    void release();

    void seekTo(int i);

    void setSpeed(float f2);

    void setSurface(Surface surface);

    void start();

    InterfaceC0792a t();
}
