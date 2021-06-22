package d.o.a.e.b.o.b;

import d.o.a.e.b.o.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements k {

    /* renamed from: a  reason: collision with root package name */
    public final Object f71360a;

    /* renamed from: b  reason: collision with root package name */
    public final List<com.ss.android.socialbase.downloader.model.c> f71361b;

    /* renamed from: c  reason: collision with root package name */
    public k f71362c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71363d;

    /* renamed from: e  reason: collision with root package name */
    public long f71364e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f71365f;

    @Override // d.o.a.e.b.o.k
    public InputStream a() throws IOException {
        InputStream inputStream = this.f71365f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // d.o.a.e.b.o.i
    public int b() throws IOException {
        k kVar = this.f71362c;
        if (kVar != null) {
            return kVar.b();
        }
        return 0;
    }

    public boolean b(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    @Override // d.o.a.e.b.o.i
    public void c() {
        k kVar = this.f71362c;
        if (kVar != null) {
            kVar.c();
        }
    }

    @Override // d.o.a.e.b.o.k
    public void d() {
        k kVar = this.f71362c;
        if (kVar != null) {
            kVar.d();
        }
    }

    public void e() throws InterruptedException {
        synchronized (this.f71360a) {
            if (this.f71363d && this.f71362c == null) {
                this.f71360a.wait();
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        return this.f71361b;
    }

    public boolean g() {
        try {
            if (this.f71362c != null) {
                return b(this.f71362c.b());
            }
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean h() {
        return System.currentTimeMillis() - this.f71364e < b.f71347c;
    }

    @Override // d.o.a.e.b.o.i
    public String a(String str) {
        k kVar = this.f71362c;
        if (kVar != null) {
            return kVar.a(str);
        }
        return null;
    }
}
