package com.kwad.sdk.contentalliance.home;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile long f8734a = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f8735b;
    private boolean c;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a();

        void b();

        void c();
    }

    public d(@NonNull a aVar) {
        this.f8735b = aVar;
    }

    private void b() {
        if (this.f8735b != null) {
            this.f8735b.b();
        }
    }

    private void c() {
        if (this.f8735b != null) {
            this.f8735b.c();
        }
    }

    @UiThread
    public void a() {
        if (this.f8735b == null || this.f8735b.a()) {
            f8734a = 0L;
        } else if (!this.c) {
            c();
        } else if (System.currentTimeMillis() - f8734a < IMConnection.RETRY_DELAY_TIMES) {
            c();
        } else {
            f8734a = System.currentTimeMillis();
            b();
        }
    }

    public void a(boolean z) {
        this.c = z;
    }
}
