package com.kwai.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f35198a = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f35199c = new Object();

    /* renamed from: b  reason: collision with root package name */
    public v f35200b;

    /* renamed from: d  reason: collision with root package name */
    public u f35201d;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final q f35202a = new q();
    }

    public static q a() {
        return a.f35202a;
    }

    public static void a(Context context, c.a aVar) {
        if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.c(q.class, "init Downloader with params: %s %s", context, aVar);
        }
        if (context == null) {
            throw new IllegalArgumentException("the provided context must not be null!");
        }
        com.kwai.filedownloader.f.c.a(context.getApplicationContext());
        com.kwai.filedownloader.download.b.a().a(aVar);
    }

    public int a(int i2) {
        List<a.b> c2 = h.a().c(i2);
        if (c2 == null || c2.isEmpty()) {
            com.kwai.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i2));
            return 0;
        }
        for (a.b bVar : c2) {
            bVar.F().f();
        }
        return c2.size();
    }

    public com.kwai.filedownloader.a a(String str) {
        return new c(str);
    }

    public void a(e eVar) {
        f.a().a("event.service.connect.changed", eVar);
    }

    public boolean a(int i2, String str) {
        a(i2);
        if (m.a().c(i2)) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            File file = new File(com.kwai.filedownloader.f.f.d(str));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            }
            return true;
        }
        return false;
    }

    public void b() {
        if (c()) {
            return;
        }
        m.a().a(com.kwai.filedownloader.f.c.a());
    }

    public boolean c() {
        return m.a().c();
    }

    public v d() {
        if (this.f35200b == null) {
            synchronized (f35198a) {
                if (this.f35200b == null) {
                    this.f35200b = new aa();
                }
            }
        }
        return this.f35200b;
    }

    public u e() {
        if (this.f35201d == null) {
            synchronized (f35199c) {
                if (this.f35201d == null) {
                    y yVar = new y();
                    this.f35201d = yVar;
                    a(yVar);
                }
            }
        }
        return this.f35201d;
    }
}
