package d.a.l0.a.y0.k.g;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.l0.a.y0.d;
import java.util.Map;
/* loaded from: classes3.dex */
public interface a extends d {

    /* renamed from: d.a.l0.a.y0.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0920a {
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

    void C(boolean z);

    void D();

    int G();

    boolean I();

    void J(int i2);

    void K();

    void O(int i2, int i3, int i4, int i5);

    void Q(ZeusPluginFactory.Invoker invoker);

    boolean R(String str, String str2, String str3, boolean z);

    boolean S();

    InterfaceC0920a T();

    void X(Map map);

    void Y();

    int a();

    void a0();

    String c();

    void f0(String str);

    int g();

    void g0();

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    ZeusPluginFactory.Invoker j0();

    void k0(int i2);

    void l(boolean z);

    void l0(@NonNull InterfaceC0920a interfaceC0920a);

    void pause();

    void q0();

    void release();

    void seekTo(int i2);

    void setSpeed(float f2);

    void setSurface(Surface surface);

    void start();
}
