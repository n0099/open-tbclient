package com.kwad.sdk.contentalliance.home;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile long f5820a = 0;
    private a b;
    private boolean c;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a();

        void b();

        void c();
    }

    public d(@NonNull a aVar) {
        this.b = aVar;
    }

    private void b() {
        if (this.b != null) {
            this.b.b();
        }
    }

    private void c() {
        if (this.b != null) {
            this.b.c();
        }
    }

    @UiThread
    public void a() {
        if (this.b == null || this.b.a()) {
            f5820a = 0L;
        } else if (!this.c) {
            c();
        } else if (System.currentTimeMillis() - f5820a < IMConnection.RETRY_DELAY_TIMES) {
            c();
        } else {
            f5820a = System.currentTimeMillis();
            b();
        }
    }

    public void a(boolean z) {
        this.c = z;
    }
}
