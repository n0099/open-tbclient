package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class k {
    public static final AtomicBoolean a = new AtomicBoolean(false);
    public static volatile k b;
    public Context c;
    public a d;

    public k(Context context) {
        this.c = context.getApplicationContext();
    }

    public static k a(@NonNull Context context) {
        if (b == null) {
            synchronized (k.class) {
                if (b == null) {
                    b = new k(context);
                }
            }
        }
        return b;
    }

    private void c() {
        Context context;
        if (!a.get() || (context = this.c) == null) {
            return;
        }
        context.unregisterReceiver(this.d);
        a.set(false);
    }

    public void a() {
        if (this.c == null || a.get()) {
            return;
        }
        if (this.d == null) {
            this.d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.c.registerReceiver(this.d, intentFilter);
        a.set(true);
    }

    public void b() {
        c();
    }
}
