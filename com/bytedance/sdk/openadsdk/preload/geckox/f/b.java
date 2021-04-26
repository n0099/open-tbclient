package com.bytedance.sdk.openadsdk.preload.geckox.f;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public String f30892b;

    /* renamed from: d  reason: collision with root package name */
    public String f30894d;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f30891a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f30893c = new AtomicBoolean(false);

    public b(Context context, String str, File file) {
        if (!TextUtils.isEmpty(str)) {
            this.f30892b = str;
            if (file == null) {
                File filesDir = context.getFilesDir();
                this.f30894d = new File(filesDir, "gecko_offline_res_x" + File.separator + str).getAbsolutePath();
                return;
            }
            this.f30894d = new File(file, str).getAbsolutePath();
            return;
        }
        throw new RuntimeException("access key empty");
    }

    private a c(String str) {
        a aVar;
        int indexOf = str.indexOf("/");
        if (indexOf == -1) {
            new RuntimeException("缺少channel：" + str);
        }
        String substring = str.substring(0, indexOf);
        synchronized (this.f30891a) {
            aVar = this.f30891a.get(substring);
            if (aVar == null) {
                aVar = new a(this.f30892b, this.f30894d, substring);
                this.f30891a.put(substring, aVar);
            }
        }
        return aVar;
    }

    public InputStream a(String str) throws Exception {
        if (!this.f30893c.get()) {
            if (!TextUtils.isEmpty(str)) {
                return c(str.trim()).a(str);
            }
            throw new RuntimeException("relativePath empty");
        }
        throw new RuntimeException("released");
    }

    public boolean b(String str) throws Exception {
        if (!this.f30893c.get()) {
            if (!TextUtils.isEmpty(str)) {
                return c(str.trim()).b(str);
            }
            throw new RuntimeException("relativePath empty");
        }
        throw new RuntimeException("released");
    }

    private void b() throws Exception {
        synchronized (this.f30891a) {
            for (a aVar : this.f30891a.values()) {
                aVar.a();
            }
            this.f30891a.clear();
        }
    }

    public void a() throws Exception {
        if (this.f30893c.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("Loader", "release version res loader");
        b();
    }
}
