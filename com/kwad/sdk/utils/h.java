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
    public static final AtomicBoolean f37630a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f37631b;

    /* renamed from: c  reason: collision with root package name */
    public Context f37632c;

    /* renamed from: d  reason: collision with root package name */
    public a f37633d;

    public h(Context context) {
        this.f37632c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (f37631b == null) {
            synchronized (h.class) {
                if (f37631b == null) {
                    f37631b = new h(context);
                }
            }
        }
        return f37631b;
    }

    private void c() {
        Context context;
        if (!f37630a.get() || (context = this.f37632c) == null) {
            return;
        }
        context.unregisterReceiver(this.f37633d);
        f37630a.set(false);
    }

    public void a() {
        if (this.f37632c == null || f37630a.get()) {
            return;
        }
        if (this.f37633d == null) {
            this.f37633d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        this.f37632c.registerReceiver(this.f37633d, intentFilter);
        f37630a.set(true);
    }

    public void b() {
        c();
    }
}
