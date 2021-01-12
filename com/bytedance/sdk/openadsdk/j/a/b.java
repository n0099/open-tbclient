package com.bytedance.sdk.openadsdk.j.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.g.d;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final File f7220a;

    public void a() {
        d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b();
            }
        });
    }

    public void b() {
        com.bytedance.sdk.openadsdk.j.d.c().d();
        Context a2 = e.a();
        if (a2 != null) {
            com.bytedance.sdk.openadsdk.j.b.c.a(a2).a(1);
        }
        for (File file : this.f7220a.listFiles()) {
            try {
                file.delete();
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.a.a
    public File c(String str) {
        return e(str);
    }

    @Override // com.bytedance.sdk.openadsdk.j.a.a
    public File d(String str) {
        return e(str);
    }

    File e(String str) {
        return new File(this.f7220a, str);
    }
}
