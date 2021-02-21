package com.ss.android.socialbase.downloader.i.a;

import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements g {

    /* renamed from: a  reason: collision with root package name */
    protected final Object f13171a;

    /* renamed from: b  reason: collision with root package name */
    private final List<e> f13172b;
    private boolean d;
    private long e;
    private InputStream f;
    private g qgL;

    public void e() throws InterruptedException {
        synchronized (this.f13171a) {
            if (this.d && this.qgL == null) {
                this.f13171a.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.i.g
    public InputStream a() throws IOException {
        if (this.f != null) {
            return this.f;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.i.g
    public void d() {
        if (this.qgL != null) {
            this.qgL.d();
        }
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public String a(String str) {
        if (this.qgL != null) {
            return this.qgL.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public int b() throws IOException {
        if (this.qgL != null) {
            return this.qgL.b();
        }
        return 0;
    }

    public List<e> f() {
        return this.f13172b;
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public void c() {
        if (this.qgL != null) {
            this.qgL.c();
        }
    }

    public boolean g() {
        try {
            if (this.qgL != null) {
                return a(this.qgL.b());
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    public boolean h() {
        return System.currentTimeMillis() - this.e < b.f13166a;
    }
}
