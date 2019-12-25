package com.meizu.cloud.pushsdk.base;

import android.content.Context;
import android.os.Environment;
/* loaded from: classes5.dex */
public class h extends j<g> implements g {
    private static h c;
    private boolean d;

    protected h(g gVar) {
        super(gVar);
        this.d = false;
    }

    public static h b() {
        if (c == null) {
            synchronized (h.class) {
                if (c == null) {
                    c = new h(new b());
                }
            }
        }
        return c;
    }

    public void a(Context context) {
        if (this.d) {
            return;
        }
        this.d = true;
        if ((context.getApplicationInfo().flags & 2) != 0) {
            b(true);
        } else {
            b(false);
        }
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
