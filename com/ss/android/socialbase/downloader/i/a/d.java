package com.ss.android.socialbase.downloader.i.a;

import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements g {

    /* renamed from: a  reason: collision with root package name */
    protected final Object f13468a;

    /* renamed from: b  reason: collision with root package name */
    private final List<e> f13469b;
    private boolean d;
    private long e;
    private InputStream f;
    private g pYZ;

    public void e() throws InterruptedException {
        synchronized (this.f13468a) {
            if (this.d && this.pYZ == null) {
                this.f13468a.wait();
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
        if (this.pYZ != null) {
            this.pYZ.d();
        }
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public String a(String str) {
        if (this.pYZ != null) {
            return this.pYZ.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public int b() throws IOException {
        if (this.pYZ != null) {
            return this.pYZ.b();
        }
        return 0;
    }

    public List<e> f() {
        return this.f13469b;
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public void c() {
        if (this.pYZ != null) {
            this.pYZ.c();
        }
    }

    public boolean g() {
        try {
            if (this.pYZ != null) {
                return a(this.pYZ.b());
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
        return System.currentTimeMillis() - this.e < b.f13463a;
    }
}
