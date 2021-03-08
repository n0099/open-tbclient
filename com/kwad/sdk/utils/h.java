package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f7146a = new AtomicBoolean(false);
    private static volatile h b;
    private Context c;
    private a d;

    private h(Context context) {
        this.c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new h(context);
                }
            }
        }
        return b;
    }

    private void c() {
        if (!f7146a.get() || this.c == null) {
            return;
        }
        this.c.unregisterReceiver(this.d);
        f7146a.set(false);
    }

    public void a() {
        if (this.c == null || f7146a.get()) {
            return;
        }
        if (this.d == null) {
            this.d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        this.c.registerReceiver(this.d, intentFilter);
        f7146a.set(true);
    }

    public void b() {
        c();
    }
}
