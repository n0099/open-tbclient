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
    public static final AtomicBoolean f34068a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f34069b;

    /* renamed from: c  reason: collision with root package name */
    public Context f34070c;

    /* renamed from: d  reason: collision with root package name */
    public a f34071d;

    public h(Context context) {
        this.f34070c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (f34069b == null) {
            synchronized (h.class) {
                if (f34069b == null) {
                    f34069b = new h(context);
                }
            }
        }
        return f34069b;
    }

    private void c() {
        Context context;
        if (!f34068a.get() || (context = this.f34070c) == null) {
            return;
        }
        context.unregisterReceiver(this.f34071d);
        f34068a.set(false);
    }

    public void a() {
        if (this.f34070c == null || f34068a.get()) {
            return;
        }
        if (this.f34071d == null) {
            this.f34071d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        this.f34070c.registerReceiver(this.f34071d, intentFilter);
        f34068a.set(true);
    }

    public void b() {
        c();
    }
}
