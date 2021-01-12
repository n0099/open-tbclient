package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f10821a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private static volatile h f10822b;
    private Context c;
    private a d;

    private h(Context context) {
        this.c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (f10822b == null) {
            synchronized (h.class) {
                if (f10822b == null) {
                    f10822b = new h(context);
                }
            }
        }
        return f10822b;
    }

    private void c() {
        if (!f10821a.get() || this.c == null) {
            return;
        }
        this.c.unregisterReceiver(this.d);
        f10821a.set(false);
    }

    public void a() {
        if (this.c == null || f10821a.get()) {
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
        f10821a.set(true);
    }

    public void b() {
        c();
    }
}
