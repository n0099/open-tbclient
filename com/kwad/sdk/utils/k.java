package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class k {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f57997b;

    /* renamed from: c  reason: collision with root package name */
    public Context f57998c;

    /* renamed from: d  reason: collision with root package name */
    public a f57999d;

    public k(Context context) {
        this.f57998c = context.getApplicationContext();
    }

    public static k a(@NonNull Context context) {
        if (f57997b == null) {
            synchronized (k.class) {
                if (f57997b == null) {
                    f57997b = new k(context);
                }
            }
        }
        return f57997b;
    }

    private void c() {
        Context context;
        if (!a.get() || (context = this.f57998c) == null) {
            return;
        }
        context.unregisterReceiver(this.f57999d);
        a.set(false);
    }

    public void a() {
        if (this.f57998c == null || a.get()) {
            return;
        }
        if (this.f57999d == null) {
            this.f57999d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.f57998c.registerReceiver(this.f57999d, intentFilter);
        a.set(true);
    }

    public void b() {
        c();
    }
}
