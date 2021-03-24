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
    public String f30274a;

    /* renamed from: b  reason: collision with root package name */
    public String f30275b;

    /* renamed from: c  reason: collision with root package name */
    public volatile File f30276c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Long f30277d;

    /* renamed from: e  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.preload.geckox.f.a.a f30278e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f30279f = new AtomicBoolean(false);

    public a(String str, String str2, String str3) {
        this.f30274a = str2;
        this.f30275b = str3;
    }

    private synchronized com.bytedance.sdk.openadsdk.preload.geckox.f.a.a c(String str) throws Exception {
        if (this.f30278e != null) {
            return this.f30278e;
        }
        File d2 = d(str);
        if (d2 != null) {
            File file = new File(d2, "res.macv");
            File file2 = new File(d2, UriUtil.LOCAL_RESOURCE_SCHEME);
            if (file2.exists() && file2.isDirectory()) {
                this.f30278e = new c(d2);
            } else if (file.exists() && file.isFile()) {
                this.f30278e = new com.bytedance.sdk.openadsdk.preload.geckox.f.a.b(d2);
            } else {
                throw new RuntimeException("can not find res, dir:" + d2.getAbsolutePath());
            }
            return this.f30278e;
        }
        throw new FileNotFoundException("channel no exist，channel:" + str);
    }

    private synchronized File d(String str) throws Exception {
        if (this.f30276c != null) {
            return this.f30276c;
        } else if (this.f30277d == null || this.f30277d.longValue() != -1) {
            com.bytedance.sdk.openadsdk.preload.geckox.g.b a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(this.f30274a + File.separator + str + File.separator + "select.lock");
            if (this.f30277d == null) {
                this.f30277d = k.a(new File(this.f30274a, str));
            }
            if (this.f30277d == null) {
                this.f30277d = -1L;
                a2.a();
                return null;
            }
            String str2 = this.f30274a;
            File file = new File(str2, File.separator + str + File.separator + this.f30277d + File.separator + "using.lock");
            this.f30276c = file.getParentFile();
            com.bytedance.sdk.openadsdk.preload.geckox.g.c.a(file.getAbsolutePath());
            File file2 = this.f30276c;
            a2.a();
            return file2;
        } else {
            return null;
        }
    }

    public final InputStream a(String str) throws Exception {
        return c(this.f30275b).a(a(this.f30275b, str));
    }

    public final boolean b(String str) throws Exception {
        return c(this.f30275b).b(a(this.f30275b, str));
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
        com.bytedance.sdk.openadsdk.preload.geckox.g.b a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(this.f30274a + File.separator + this.f30275b + File.separator + "select.lock");
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-file-lock", "channel version loader clean");
        try {
            if (this.f30276c == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.preload.geckox.g.c.b(this.f30276c.getAbsolutePath() + File.separator + "using.lock");
            a2.a();
            com.bytedance.sdk.openadsdk.preload.geckox.a.c.a(this.f30274a + File.separator + this.f30275b);
        } finally {
            a2.a();
        }
    }

    public void a() throws Exception {
        if (this.f30279f.getAndSet(true)) {
            return;
        }
        b();
    }
}
