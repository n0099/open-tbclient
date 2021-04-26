package d.a.h0.a.s0.k.g;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import d.a.h0.a.s0.d;
/* loaded from: classes2.dex */
public interface a extends d {

    /* renamed from: d.a.h0.a.s0.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0764a {
        void a(int i2);

        void b(int i2);

        void c(String str);

        void d(@NonNull String str);

        void e(String str);

        void f();

        void onEnded();

        void onError(int i2);

        void onPrepared();

        void onRelease(String str);
    }

    void B(boolean z);

    boolean E();

    void F(int i2);

    void J(int i2, int i3, int i4, int i5);

    boolean L(String str, String str2, String str3, boolean z);

    boolean M();

    InterfaceC0764a N();

    void S();

    void X(String str);

    void Y();

    String b();

    void b0(int i2);

    int c();

    void c0(@NonNull InterfaceC0764a interfaceC0764a);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void k(boolean z);

    void pause();

    void release();

    void seekTo(int i2);

    void setSpeed(float f2);

    void setSurface(Surface surface);

    void start();
}
