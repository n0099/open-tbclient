package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f37532a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f37533b;

    /* renamed from: c  reason: collision with root package name */
    public Context f37534c;

    /* renamed from: d  reason: collision with root package name */
    public a f37535d;

    public h(Context context) {
        this.f37534c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (f37533b == null) {
            synchronized (h.class) {
                if (f37533b == null) {
                    f37533b = new h(context);
                }
            }
        }
        return f37533b;
    }

    private void c() {
        Context context;
        if (!f37532a.get() || (context = this.f37534c) == null) {
            return;
        }
        context.unregisterReceiver(this.f37535d);
        f37532a.set(false);
    }

    public void a() {
        if (this.f37534c == null || f37532a.get()) {
            return;
        }
        if (this.f37535d == null) {
            this.f37535d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        this.f37534c.registerReceiver(this.f37535d, intentFilter);
        f37532a.set(true);
    }

    public void b() {
        c();
    }
}
