package d.o.a.e.b.o.b;

import d.o.a.e.b.o.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements k {

    /* renamed from: a  reason: collision with root package name */
    public final Object f66741a;

    /* renamed from: b  reason: collision with root package name */
    public final List<com.ss.android.socialbase.downloader.model.c> f66742b;

    /* renamed from: c  reason: collision with root package name */
    public k f66743c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66744d;

    /* renamed from: e  reason: collision with root package name */
    public long f66745e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f66746f;

    @Override // d.o.a.e.b.o.k
    public InputStream a() throws IOException {
        InputStream inputStream = this.f66746f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // d.o.a.e.b.o.i
    public int b() throws IOException {
        k kVar = this.f66743c;
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
        k kVar = this.f66743c;
        if (kVar != null) {
            kVar.c();
        }
    }

    @Override // d.o.a.e.b.o.k
    public void d() {
        k kVar = this.f66743c;
        if (kVar != null) {
            kVar.d();
        }
    }

    public void e() throws InterruptedException {
        synchronized (this.f66741a) {
            if (this.f66744d && this.f66743c == null) {
                this.f66741a.wait();
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        return this.f66742b;
    }

    public boolean g() {
        try {
            if (this.f66743c != null) {
                return b(this.f66743c.b());
            }
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean h() {
        return System.currentTimeMillis() - this.f66745e < b.f66728c;
    }

    @Override // d.o.a.e.b.o.i
    public String a(String str) {
        k kVar = this.f66743c;
        if (kVar != null) {
            return kVar.a(str);
        }
        return null;
    }
}
