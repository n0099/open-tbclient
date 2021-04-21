package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f37159a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f37160b;

    /* renamed from: c  reason: collision with root package name */
    public Context f37161c;

    /* renamed from: d  reason: collision with root package name */
    public a f37162d;

    public h(Context context) {
        this.f37161c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (f37160b == null) {
            synchronized (h.class) {
                if (f37160b == null) {
                    f37160b = new h(context);
                }
            }
        }
        return f37160b;
    }

    private void c() {
        Context context;
        if (!f37159a.get() || (context = this.f37161c) == null) {
            return;
        }
        context.unregisterReceiver(this.f37162d);
        f37159a.set(false);
    }

    public void a() {
        if (this.f37161c == null || f37159a.get()) {
            return;
        }
        if (this.f37162d == null) {
            this.f37162d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.f37161c.registerReceiver(this.f37162d, intentFilter);
        f37159a.set(true);
    }

    public void b() {
        c();
    }
}
