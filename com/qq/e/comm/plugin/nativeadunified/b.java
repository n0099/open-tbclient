package com.qq.e.comm.plugin.nativeadunified;

import android.view.View;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void a(String str, int i, int i2, long j);

        void b();

        void c();

        void d();
    }

    /* renamed from: com.qq.e.comm.plugin.nativeadunified.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public enum EnumC1216b {
        INIT,
        PLAYING,
        AUTO_PAUSE,
        MANUAL_PAUSE,
        END,
        DEV_PAUSE,
        DEV_STOP,
        ERROR
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();

        void a(int i);

        void b();
    }

    /* loaded from: classes4.dex */
    public enum d {
        NOT_DOWNLOAD,
        START,
        PAUSE,
        COMPLETE,
        FAILED
    }

    void a(int i);

    void a(View view, int i, String str, String str2, String str3, String str4, boolean z, boolean z2);

    void a(View view, String str, boolean z);

    void a(a aVar);

    void a(EnumC1216b enumC1216b);

    void a(c cVar);

    void a(boolean z);

    boolean d();

    com.qq.e.comm.plugin.ad.g e();

    void e_();

    d f();

    EnumC1216b h();

    int i();

    void j();

    void k();

    com.qq.e.comm.plugin.s.a n();
}
