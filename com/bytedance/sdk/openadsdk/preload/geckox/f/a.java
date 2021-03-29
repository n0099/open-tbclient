package com.bytedance.sdk.openadsdk.preload.geckox.f;

import com.bytedance.sdk.openadsdk.preload.geckox.f.a.c;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.k;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f30275a;

    /* renamed from: b  reason: collision with root package name */
    public String f30276b;

    /* renamed from: c  reason: collision with root package name */
    public volatile File f30277c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Long f30278d;

    /* renamed from: e  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.preload.geckox.f.a.a f30279e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f30280f = new AtomicBoolean(false);

    public a(String str, String str2, String str3) {
        this.f30275a = str2;
        this.f30276b = str3;
    }

    private synchronized com.bytedance.sdk.openadsdk.preload.geckox.f.a.a c(String str) throws Exception {
        if (this.f30279e != null) {
            return this.f30279e;
        }
        File d2 = d(str);
        if (d2 != null) {
            File file = new File(d2, "res.macv");
            File file2 = new File(d2, UriUtil.LOCAL_RESOURCE_SCHEME);
            if (file2.exists() && file2.isDirectory()) {
                this.f30279e = new c(d2);
            } else if (file.exists() && file.isFile()) {
                this.f30279e = new com.bytedance.sdk.openadsdk.preload.geckox.f.a.b(d2);
            } else {
                throw new RuntimeException("can not find res, dir:" + d2.getAbsolutePath());
            }
            return this.f30279e;
        }
        throw new FileNotFoundException("channel no exist，channel:" + str);
    }

    private synchronized File d(String str) throws Exception {
        if (this.f30277c != null) {
            return this.f30277c;
        } else if (this.f30278d == null || this.f30278d.longValue() != -1) {
            com.bytedance.sdk.openadsdk.preload.geckox.g.b a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(this.f30275a + File.separator + str + File.separator + "select.lock");
            if (this.f30278d == null) {
                this.f30278d = k.a(new File(this.f30275a, str));
            }
            if (this.f30278d == null) {
                this.f30278d = -1L;
                a2.a();
                return null;
            }
            String str2 = this.f30275a;
            File file = new File(str2, File.separator + str + File.separator + this.f30278d + File.separator + "using.lock");
            this.f30277c = file.getParentFile();
            com.bytedance.sdk.openadsdk.preload.geckox.g.c.a(file.getAbsolutePath());
            File file2 = this.f30277c;
            a2.a();
            return file2;
        } else {
            return null;
        }
    }

    public final InputStream a(String str) throws Exception {
        return c(this.f30276b).a(a(this.f30276b, str));
    }

    public final boolean b(String str) throws Exception {
        return c(this.f30276b).b(a(this.f30276b, str));
    }

    public void finalize() throws Throwable {
        super.finalize();
        try {
            a();
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(e2);
        }
    }

    private String a(String str, String str2) {
        return str2.substring(str.length() + 1);
    }

    private void b() throws Exception {
        com.bytedance.sdk.openadsdk.preload.geckox.g.b a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(this.f30275a + File.separator + this.f30276b + File.separator + "select.lock");
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-file-lock", "channel version loader clean");
        try {
            if (this.f30277c == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.preload.geckox.g.c.b(this.f30277c.getAbsolutePath() + File.separator + "using.lock");
            a2.a();
            com.bytedance.sdk.openadsdk.preload.geckox.a.c.a(this.f30275a + File.separator + this.f30276b);
        } finally {
            a2.a();
        }
    }

    public void a() throws Exception {
        if (this.f30280f.getAndSet(true)) {
            return;
        }
        b();
    }
}
