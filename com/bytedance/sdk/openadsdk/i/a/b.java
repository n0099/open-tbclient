package com.bytedance.sdk.openadsdk.i.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.i.g.d;
import java.io.File;
/* loaded from: classes6.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final File f4802a;

    public void a() {
        d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b();
            }
        });
    }

    public void b() {
        com.bytedance.sdk.openadsdk.i.d.c().d();
        Context a2 = e.a();
        if (a2 != null) {
            com.bytedance.sdk.openadsdk.i.b.c.a(a2).a(1);
        }
        for (File file : this.f4802a.listFiles()) {
            try {
                file.delete();
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public File c(String str) {
        return e(str);
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public File d(String str) {
        return e(str);
    }

    File e(String str) {
        return new File(this.f4802a, str);
    }
}
