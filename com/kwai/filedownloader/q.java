package com.kwai.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f10980a = new Object();
    private static final Object c = new Object();

    /* renamed from: b  reason: collision with root package name */
    private v f10981b;
    private u d;

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final q f10982a = new q();
    }

    public static q a() {
        return a.f10982a;
    }

    public static void a(Context context, c.a aVar) {
        if (com.kwai.filedownloader.f.d.f10930a) {
            com.kwai.filedownloader.f.d.c(q.class, "init Downloader with params: %s %s", context, aVar);
        }
        if (context == null) {
            throw new IllegalArgumentException("the provided context must not be null!");
        }
        com.kwai.filedownloader.f.c.a(context.getApplicationContext());
        com.kwai.filedownloader.download.b.a().a(aVar);
    }

    public int a(int i) {
        List<a.b> c2 = h.a().c(i);
        if (c2 == null || c2.isEmpty()) {
            com.kwai.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i));
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

    public boolean a(int i, String str) {
        a(i);
        if (m.a().c(i)) {
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
                return true;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public v d() {
        if (this.f10981b == null) {
            synchronized (f10980a) {
                if (this.f10981b == null) {
                    this.f10981b = new aa();
                }
            }
        }
        return this.f10981b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u e() {
        if (this.d == null) {
            synchronized (c) {
                if (this.d == null) {
                    this.d = new y();
                    a((e) this.d);
                }
            }
        }
        return this.d;
    }
}
