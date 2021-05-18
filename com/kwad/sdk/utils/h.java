package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f34139a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f34140b;

    /* renamed from: c  reason: collision with root package name */
    public Context f34141c;

    /* renamed from: d  reason: collision with root package name */
    public a f34142d;

    public h(Context context) {
        this.f34141c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (f34140b == null) {
            synchronized (h.class) {
                if (f34140b == null) {
                    f34140b = new h(context);
                }
            }
        }
        return f34140b;
    }

    private void c() {
        Context context;
        if (!f34139a.get() || (context = this.f34141c) == null) {
            return;
        }
        context.unregisterReceiver(this.f34142d);
        f34139a.set(false);
    }

    public void a() {
        if (this.f34141c == null || f34139a.get()) {
            return;
        }
        if (this.f34142d == null) {
            this.f34142d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        this.f34141c.registerReceiver(this.f34142d, intentFilter);
        f34139a.set(true);
    }

    public void b() {
        c();
    }
}
