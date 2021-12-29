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
    public static volatile k f60238b;

    /* renamed from: c  reason: collision with root package name */
    public Context f60239c;

    /* renamed from: d  reason: collision with root package name */
    public a f60240d;

    public k(Context context) {
        this.f60239c = context.getApplicationContext();
    }

    public static k a(@NonNull Context context) {
        if (f60238b == null) {
            synchronized (k.class) {
                if (f60238b == null) {
                    f60238b = new k(context);
                }
            }
        }
        return f60238b;
    }

    private void c() {
        Context context;
        if (!a.get() || (context = this.f60239c) == null) {
            return;
        }
        context.unregisterReceiver(this.f60240d);
        a.set(false);
    }

    public void a() {
        if (this.f60239c == null || a.get()) {
            return;
        }
        if (this.f60240d == null) {
            this.f60240d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.f60239c.registerReceiver(this.f60240d, intentFilter);
        a.set(true);
    }

    public void b() {
        c();
    }
}
