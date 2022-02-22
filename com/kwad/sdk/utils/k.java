package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class k {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f58164b;

    /* renamed from: c  reason: collision with root package name */
    public Context f58165c;

    /* renamed from: d  reason: collision with root package name */
    public a f58166d;

    public k(Context context) {
        this.f58165c = context.getApplicationContext();
    }

    public static k a(@NonNull Context context) {
        if (f58164b == null) {
            synchronized (k.class) {
                if (f58164b == null) {
                    f58164b = new k(context);
                }
            }
        }
        return f58164b;
    }

    private void c() {
        Context context;
        if (!a.get() || (context = this.f58165c) == null) {
            return;
        }
        context.unregisterReceiver(this.f58166d);
        a.set(false);
    }

    public void a() {
        if (this.f58165c == null || a.get()) {
            return;
        }
        if (this.f58166d == null) {
            this.f58166d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.f58165c.registerReceiver(this.f58166d, intentFilter);
        a.set(true);
    }

    public void b() {
        c();
    }
}
