package com.bytedance.sdk.openadsdk.k.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.k.e;
import com.bytedance.sdk.openadsdk.k.g.d;
import com.bytedance.sdk.openadsdk.l.g;
import java.io.File;
/* loaded from: classes6.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final File f29514a;

    public void a() {
        d.a(new g("clear") { // from class: com.bytedance.sdk.openadsdk.k.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b();
            }
        });
    }

    public void b() {
        com.bytedance.sdk.openadsdk.k.d.c().d();
        Context a2 = e.a();
        if (a2 != null) {
            com.bytedance.sdk.openadsdk.k.b.c.a(a2).a(1);
        }
        for (File file : this.f29514a.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.a.a
    public File c(String str) {
        return e(str);
    }

    @Override // com.bytedance.sdk.openadsdk.k.a.a
    public File d(String str) {
        return e(str);
    }

    public File e(String str) {
        return new File(this.f29514a, str);
    }
}
