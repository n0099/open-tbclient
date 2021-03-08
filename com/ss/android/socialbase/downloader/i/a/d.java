package com.ss.android.socialbase.downloader.i.a;

import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements g {

    /* renamed from: a  reason: collision with root package name */
    protected final Object f7842a;
    private final List<e> b;
    private boolean d;
    private long e;
    private InputStream f;
    private g qhA;

    public void e() throws InterruptedException {
        synchronized (this.f7842a) {
            if (this.d && this.qhA == null) {
                this.f7842a.wait();
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
        if (this.qhA != null) {
            this.qhA.d();
        }
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public String a(String str) {
        if (this.qhA != null) {
            return this.qhA.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public int b() throws IOException {
        if (this.qhA != null) {
            return this.qhA.b();
        }
        return 0;
    }

    public List<e> f() {
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public void c() {
        if (this.qhA != null) {
            this.qhA.c();
        }
    }

    public boolean g() {
        try {
            if (this.qhA != null) {
                return a(this.qhA.b());
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
        return System.currentTimeMillis() - this.e < b.f7839a;
    }
}
