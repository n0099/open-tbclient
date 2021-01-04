package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f11120a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private static volatile h f11121b;
    private Context c;
    private a d;

    private h(Context context) {
        this.c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (f11121b == null) {
            synchronized (h.class) {
                if (f11121b == null) {
                    f11121b = new h(context);
                }
            }
        }
        return f11121b;
    }

    private void c() {
        if (!f11120a.get() || this.c == null) {
            return;
        }
        this.c.unregisterReceiver(this.d);
        f11120a.set(false);
    }

    public void a() {
        if (this.c == null || f11120a.get()) {
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
        f11120a.set(true);
    }

    public void b() {
        c();
    }
}
