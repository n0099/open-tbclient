package com.meizu.cloud.pushsdk.base;

import android.content.Context;
import android.os.Environment;
/* loaded from: classes10.dex */
public class h extends i<g> implements g {

    /* renamed from: c  reason: collision with root package name */
    public static h f74364c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74365d;

    public h(g gVar) {
        super(gVar);
        this.f74365d = false;
    }

    public static h b() {
        if (f74364c == null) {
            synchronized (h.class) {
                if (f74364c == null) {
                    f74364c = new h(new b());
                }
            }
        }
        return f74364c;
    }

    public void a(Context context) {
        if (this.f74365d) {
            return;
        }
        this.f74365d = true;
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
