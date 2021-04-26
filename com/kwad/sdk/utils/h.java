package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f34894a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f34895b;

    /* renamed from: c  reason: collision with root package name */
    public Context f34896c;

    /* renamed from: d  reason: collision with root package name */
    public a f34897d;

    public h(Context context) {
        this.f34896c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (f34895b == null) {
            synchronized (h.class) {
                if (f34895b == null) {
                    f34895b = new h(context);
                }
            }
        }
        return f34895b;
    }

    private void c() {
        Context context;
        if (!f34894a.get() || (context = this.f34896c) == null) {
            return;
        }
        context.unregisterReceiver(this.f34897d);
        f34894a.set(false);
    }

    public void a() {
        if (this.f34896c == null || f34894a.get()) {
            return;
        }
        if (this.f34897d == null) {
            this.f34897d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.f34896c.registerReceiver(this.f34897d, intentFilter);
        f34894a.set(true);
    }

    public void b() {
        c();
    }
}
