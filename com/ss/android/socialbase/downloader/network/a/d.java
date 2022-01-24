package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements i {
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final List<com.ss.android.socialbase.downloader.model.c> f60295b;

    /* renamed from: c  reason: collision with root package name */
    public i f60296c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60297d;

    /* renamed from: e  reason: collision with root package name */
    public long f60298e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f60299f;

    @Override // com.ss.android.socialbase.downloader.network.i
    public InputStream a() throws IOException {
        InputStream inputStream = this.f60299f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        i iVar = this.f60296c;
        if (iVar != null) {
            return iVar.b();
        }
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        i iVar = this.f60296c;
        if (iVar != null) {
            iVar.c();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public void d() {
        i iVar = this.f60296c;
        if (iVar != null) {
            iVar.d();
        }
    }

    public void e() throws InterruptedException {
        synchronized (this.a) {
            if (this.f60297d && this.f60296c == null) {
                this.a.wait();
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        return this.f60295b;
    }

    public boolean g() {
        try {
            if (this.f60296c != null) {
                return a(this.f60296c.b());
            }
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean h() {
        return System.currentTimeMillis() - this.f60298e < b.a;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        i iVar = this.f60296c;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }
}
