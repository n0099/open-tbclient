package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f36775a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f36776b;

    /* renamed from: c  reason: collision with root package name */
    public Context f36777c;

    /* renamed from: d  reason: collision with root package name */
    public a f36778d;

    public h(Context context) {
        this.f36777c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (f36776b == null) {
            synchronized (h.class) {
                if (f36776b == null) {
                    f36776b = new h(context);
                }
            }
        }
        return f36776b;
    }

    private void c() {
        Context context;
        if (!f36775a.get() || (context = this.f36777c) == null) {
            return;
        }
        context.unregisterReceiver(this.f36778d);
        f36775a.set(false);
    }

    public void a() {
        if (this.f36777c == null || f36775a.get()) {
            return;
        }
        if (this.f36778d == null) {
            this.f36778d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.f36777c.registerReceiver(this.f36778d, intentFilter);
        f36775a.set(true);
    }

    public void b() {
        c();
    }
}
