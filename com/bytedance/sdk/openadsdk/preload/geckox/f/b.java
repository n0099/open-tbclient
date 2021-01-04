package com.bytedance.sdk.openadsdk.preload.geckox.f;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private String f7781b;
    private String d;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f7780a = new HashMap();
    private AtomicBoolean c = new AtomicBoolean(false);

    public b(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        }
        this.f7781b = str;
        if (file == null) {
            this.d = new File(context.getFilesDir(), "gecko_offline_res_x" + File.separator + str).getAbsolutePath();
        } else {
            this.d = new File(file, str).getAbsolutePath();
        }
    }

    public InputStream a(String str) throws Exception {
        if (this.c.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return c(str.trim()).a(str);
    }

    public boolean b(String str) throws Exception {
        if (this.c.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return c(str.trim()).b(str);
    }

    private a c(String str) {
        a aVar;
        int indexOf = str.indexOf("/");
        if (indexOf == -1) {
            new RuntimeException("缺少channel：" + str);
        }
        String substring = str.substring(0, indexOf);
        synchronized (this.f7780a) {
            aVar = this.f7780a.get(substring);
            if (aVar == null) {
                aVar = new a(this.f7781b, this.d, substring);
                this.f7780a.put(substring, aVar);
            }
        }
        return aVar;
    }

    public void a() throws Exception {
        if (!this.c.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("Loader", "release version res loader");
            b();
        }
    }

    private void b() throws Exception {
        synchronized (this.f7780a) {
            for (a aVar : this.f7780a.values()) {
                aVar.a();
            }
            this.f7780a.clear();
        }
    }
}
