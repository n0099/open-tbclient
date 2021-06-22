package d.a.m0.a.y0.k.g;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.m0.a.y0.d;
import java.util.Map;
/* loaded from: classes3.dex */
public interface a extends d {

    /* renamed from: d.a.m0.a.y0.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0979a {
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

    void C();

    void G(int i2);

    void H();

    void L(int i2, int i3, int i4, int i5);

    void N(ZeusPluginFactory.Invoker invoker);

    boolean O(String str, String str2, String str3, boolean z);

    boolean P();

    InterfaceC0979a Q();

    void U(Map map);

    void V();

    void X();

    int a();

    String c();

    void c0(String str);

    void d0();

    ZeusPluginFactory.Invoker g0();

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    void h0(int i2);

    void i0(@NonNull InterfaceC0979a interfaceC0979a);

    boolean isPlaying();

    void k(boolean z);

    void n0();

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i2);

    void setSpeed(float f2);

    void setSurface(Surface surface);

    void start();
}
