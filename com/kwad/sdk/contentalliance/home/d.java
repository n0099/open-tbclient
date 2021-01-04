package com.kwad.sdk.contentalliance.home;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile long f9031a = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f9032b;
    private boolean c;

    /* loaded from: classes5.dex */
    public interface a {
        boolean a();

        void b();

        void c();
    }

    public d(@NonNull a aVar) {
        this.f9032b = aVar;
    }

    private void b() {
        if (this.f9032b != null) {
            this.f9032b.b();
        }
    }

    private void c() {
        if (this.f9032b != null) {
            this.f9032b.c();
        }
    }

    @UiThread
    public void a() {
        if (this.f9032b == null || this.f9032b.a()) {
            f9031a = 0L;
        } else if (!this.c) {
            c();
        } else if (System.currentTimeMillis() - f9031a < IMConnection.RETRY_DELAY_TIMES) {
            c();
        } else {
            f9031a = System.currentTimeMillis();
            b();
        }
    }

    public void a(boolean z) {
        this.c = z;
    }
}
