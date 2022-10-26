package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes8.dex */
public class d implements i {
    public final Object a;
    public final List b;
    public i c;
    public boolean d;
    public long e;
    public InputStream f;

    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public InputStream a() throws IOException {
        InputStream inputStream = this.f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        i iVar = this.c;
        if (iVar != null) {
            return iVar.b();
        }
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        i iVar = this.c;
        if (iVar != null) {
            iVar.c();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public void d() {
        i iVar = this.c;
        if (iVar != null) {
            iVar.d();
        }
    }

    public void e() throws InterruptedException {
        synchronized (this.a) {
            if (this.d && this.c == null) {
                this.a.wait();
            }
        }
    }

    public List f() {
        return this.b;
    }

    public boolean g() {
        try {
            if (this.c == null) {
                return false;
            }
            if (!a(this.c.b())) {
                return false;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean h() {
        if (System.currentTimeMillis() - this.e < b.a) {
            return true;
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        i iVar = this.c;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }
}
