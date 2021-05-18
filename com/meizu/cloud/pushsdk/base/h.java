package com.meizu.cloud.pushsdk.base;

import android.content.Context;
import android.os.Environment;
/* loaded from: classes6.dex */
public class h extends i<g> implements g {

    /* renamed from: c  reason: collision with root package name */
    public static h f34850c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34851d;

    public h(g gVar) {
        super(gVar);
        this.f34851d = false;
    }

    public static h b() {
        if (f34850c == null) {
            synchronized (h.class) {
                if (f34850c == null) {
                    f34850c = new h(new b());
                }
            }
        }
        return f34850c;
    }

    public void a(Context context) {
        if (this.f34851d) {
            return;
        }
        this.f34851d = true;
        b((context.getApplicationInfo().flags & 2) != 0);
        a(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/" + context.getPackageName());
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        c().a(str);
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        c().a(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        c().a(str, str2, th);
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(boolean z) {
        c().a(z);
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public boolean a() {
        return c().a();
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        c().b(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        c().b(z);
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        c().c(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        c().d(str, str2);
    }
}
