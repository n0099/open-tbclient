package com.kwad.sdk.contentalliance.home;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile long f8732a = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f8733b;
    private boolean c;

    /* loaded from: classes4.dex */
    public interface a {
        boolean a();

        void b();

        void c();
    }

    public d(@NonNull a aVar) {
        this.f8733b = aVar;
    }

    private void b() {
        if (this.f8733b != null) {
            this.f8733b.b();
        }
    }

    private void c() {
        if (this.f8733b != null) {
            this.f8733b.c();
        }
    }

    @UiThread
    public void a() {
        if (this.f8733b == null || this.f8733b.a()) {
            f8732a = 0L;
        } else if (!this.c) {
            c();
        } else if (System.currentTimeMillis() - f8732a < IMConnection.RETRY_DELAY_TIMES) {
            c();
        } else {
            f8732a = System.currentTimeMillis();
            b();
        }
    }

    public void a(boolean z) {
        this.c = z;
    }
}
