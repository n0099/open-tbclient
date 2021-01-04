package com.bytedance.sdk.openadsdk.preload.geckox.f;

import com.bytedance.sdk.openadsdk.preload.geckox.f.a.c;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.k;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private String f7777a;

    /* renamed from: b  reason: collision with root package name */
    private String f7778b;
    private volatile File c;
    private volatile Long d;
    private volatile com.bytedance.sdk.openadsdk.preload.geckox.f.a.a e;
    private AtomicBoolean f = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, String str2, String str3) {
        this.f7777a = str2;
        this.f7778b = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final InputStream a(String str) throws Exception {
        return c(this.f7778b).a(a(this.f7778b, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(String str) throws Exception {
        return c(this.f7778b).b(a(this.f7778b, str));
    }

    private synchronized com.bytedance.sdk.openadsdk.preload.geckox.f.a.a c(String str) throws Exception {
        com.bytedance.sdk.openadsdk.preload.geckox.f.a.a aVar;
        if (this.e != null) {
            aVar = this.e;
        } else {
            File d = d(str);
            if (d == null) {
                throw new FileNotFoundException("channel no exist，channel:" + str);
            }
            File file = new File(d, "res.macv");
            File file2 = new File(d, "res");
            if (file2.exists() && file2.isDirectory()) {
                this.e = new c(d);
            } else if (file.exists() && file.isFile()) {
                this.e = new com.bytedance.sdk.openadsdk.preload.geckox.f.a.b(d);
            } else {
                throw new RuntimeException("can not find res, dir:" + d.getAbsolutePath());
            }
            aVar = this.e;
        }
        return aVar;
    }

    private String a(String str, String str2) {
        return str2.substring(str.length() + 1);
    }

    private synchronized File d(String str) throws Exception {
        File file = null;
        synchronized (this) {
            if (this.c != null) {
                file = this.c;
            } else if (this.d == null || this.d.longValue() != -1) {
                com.bytedance.sdk.openadsdk.preload.geckox.g.b a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(this.f7777a + File.separator + str + File.separator + "select.lock");
                if (this.d == null) {
                    this.d = k.a(new File(this.f7777a, str));
                }
                if (this.d == null) {
                    this.d = -1L;
                    a2.a();
                } else {
                    File file2 = new File(this.f7777a, File.separator + str + File.separator + this.d + File.separator + "using.lock");
                    this.c = file2.getParentFile();
                    com.bytedance.sdk.openadsdk.preload.geckox.g.c.a(file2.getAbsolutePath());
                    file = this.c;
                    a2.a();
                }
            }
        }
        return file;
    }

    private void b() throws Exception {
        com.bytedance.sdk.openadsdk.preload.geckox.g.b a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(this.f7777a + File.separator + this.f7778b + File.separator + "select.lock");
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-file-lock", "channel version loader clean");
        try {
            if (this.c != null) {
                com.bytedance.sdk.openadsdk.preload.geckox.g.c.b(this.c.getAbsolutePath() + File.separator + "using.lock");
                a2.a();
                com.bytedance.sdk.openadsdk.preload.geckox.a.c.a(this.f7777a + File.separator + this.f7778b);
            }
        } finally {
            a2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() throws Exception {
        if (!this.f.getAndSet(true)) {
            b();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        try {
            a();
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(e);
        }
    }
}
