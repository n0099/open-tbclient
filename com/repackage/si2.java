package com.repackage;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import java.util.Map;
/* loaded from: classes7.dex */
public interface si2 extends ee2 {

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i);

        void b(int i);

        void c(String str);

        void d(@NonNull String str);

        void e(String str);

        void f();

        void onEnded();

        void onError(int i);

        void onPrepared();

        void onRelease(String str);
    }

    void B(boolean z);

    void C();

    void G(int i);

    void H();

    void L(int i, int i2, int i3, int i4);

    void N(ZeusPluginFactory.Invoker invoker);

    boolean O(String str, String str2, String str3, boolean z);

    boolean P();

    a Q();

    void T(Map map);

    void U();

    void W();

    int a();

    void b0(String str);

    String c();

    void c0();

    ZeusPluginFactory.Invoker f0();

    void g0(int i);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    void h0(@NonNull a aVar);

    boolean isPlaying();

    boolean j0();

    void l(boolean z);

    void n0();

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
