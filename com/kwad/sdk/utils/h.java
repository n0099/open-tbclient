package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f36774a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f36775b;

    /* renamed from: c  reason: collision with root package name */
    public Context f36776c;

    /* renamed from: d  reason: collision with root package name */
    public a f36777d;

    public h(Context context) {
        this.f36776c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        if (f36775b == null) {
            synchronized (h.class) {
                if (f36775b == null) {
                    f36775b = new h(context);
                }
            }
        }
        return f36775b;
    }

    private void c() {
        Context context;
        if (!f36774a.get() || (context = this.f36776c) == null) {
            return;
        }
        context.unregisterReceiver(this.f36777d);
        f36774a.set(false);
    }

    public void a() {
        if (this.f36776c == null || f36774a.get()) {
            return;
        }
        if (this.f36777d == null) {
            this.f36777d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.f36776c.registerReceiver(this.f36777d, intentFilter);
        f36774a.set(true);
    }

    public void b() {
        c();
    }
}
