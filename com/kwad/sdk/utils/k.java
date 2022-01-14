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
    public static volatile k f57952b;

    /* renamed from: c  reason: collision with root package name */
    public Context f57953c;

    /* renamed from: d  reason: collision with root package name */
    public a f57954d;

    public k(Context context) {
        this.f57953c = context.getApplicationContext();
    }

    public static k a(@NonNull Context context) {
        if (f57952b == null) {
            synchronized (k.class) {
                if (f57952b == null) {
                    f57952b = new k(context);
                }
            }
        }
        return f57952b;
    }

    private void c() {
        Context context;
        if (!a.get() || (context = this.f57953c) == null) {
            return;
        }
        context.unregisterReceiver(this.f57954d);
        a.set(false);
    }

    public void a() {
        if (this.f57953c == null || a.get()) {
            return;
        }
        if (this.f57954d == null) {
            this.f57954d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.f57953c.registerReceiver(this.f57954d, intentFilter);
        a.set(true);
    }

    public void b() {
        c();
    }
}
