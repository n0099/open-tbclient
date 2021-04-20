package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f37064a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f37065b;

    /* renamed from: c  reason: collision with root package name */
    public Context f37066c;

    /* renamed from: d  reason: collision with root package name */
    public a f37067d;

    public h(Context context) {
        this.f37066c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (f37065b == null) {
            synchronized (h.class) {
                if (f37065b == null) {
                    f37065b = new h(context);
                }
            }
        }
        return f37065b;
    }

    private void c() {
        Context context;
        if (!f37064a.get() || (context = this.f37066c) == null) {
            return;
        }
        context.unregisterReceiver(this.f37067d);
        f37064a.set(false);
    }

    public void a() {
        if (this.f37066c == null || f37064a.get()) {
            return;
        }
        if (this.f37067d == null) {
            this.f37067d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.f37066c.registerReceiver(this.f37067d, intentFilter);
        f37064a.set(true);
    }

    public void b() {
        c();
    }
}
