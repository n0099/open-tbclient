package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class k {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f41401b;

    /* renamed from: c  reason: collision with root package name */
    public Context f41402c;

    /* renamed from: d  reason: collision with root package name */
    public a f41403d;

    public k(Context context) {
        this.f41402c = context.getApplicationContext();
    }

    public static k a(@NonNull Context context) {
        if (f41401b == null) {
            synchronized (k.class) {
                if (f41401b == null) {
                    f41401b = new k(context);
                }
            }
        }
        return f41401b;
    }

    private void c() {
        Context context;
        if (!a.get() || (context = this.f41402c) == null) {
            return;
        }
        context.unregisterReceiver(this.f41403d);
        a.set(false);
    }

    public void a() {
        if (this.f41402c == null || a.get()) {
            return;
        }
        if (this.f41403d == null) {
            this.f41403d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.f41402c.registerReceiver(this.f41403d, intentFilter);
        a.set(true);
    }

    public void b() {
        c();
    }
}
