package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class k {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f56514b;

    /* renamed from: c  reason: collision with root package name */
    public Context f56515c;

    /* renamed from: d  reason: collision with root package name */
    public a f56516d;

    public k(Context context) {
        this.f56515c = context.getApplicationContext();
    }

    public static k a(@NonNull Context context) {
        if (f56514b == null) {
            synchronized (k.class) {
                if (f56514b == null) {
                    f56514b = new k(context);
                }
            }
        }
        return f56514b;
    }

    private void c() {
        Context context;
        if (!a.get() || (context = this.f56515c) == null) {
            return;
        }
        context.unregisterReceiver(this.f56516d);
        a.set(false);
    }

    public void a() {
        if (this.f56515c == null || a.get()) {
            return;
        }
        if (this.f56516d == null) {
            this.f56516d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.f56515c.registerReceiver(this.f56516d, intentFilter);
        a.set(true);
    }

    public void b() {
        c();
    }
}
