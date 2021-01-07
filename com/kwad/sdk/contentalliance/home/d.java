package com.kwad.sdk.contentalliance.home;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile long f9032a = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f9033b;
    private boolean c;

    /* loaded from: classes5.dex */
    public interface a {
        boolean a();

        void b();

        void c();
    }

    public d(@NonNull a aVar) {
        this.f9033b = aVar;
    }

    private void b() {
        if (this.f9033b != null) {
            this.f9033b.b();
        }
    }

    private void c() {
        if (this.f9033b != null) {
            this.f9033b.c();
        }
    }

    @UiThread
    public void a() {
        if (this.f9033b == null || this.f9033b.a()) {
            f9032a = 0L;
        } else if (!this.c) {
            c();
        } else if (System.currentTimeMillis() - f9032a < IMConnection.RETRY_DELAY_TIMES) {
            c();
        } else {
            f9032a = System.currentTimeMillis();
            b();
        }
    }

    public void a(boolean z) {
        this.c = z;
    }
}
