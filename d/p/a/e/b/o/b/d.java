package d.p.a.e.b.o.b;

import d.p.a.e.b.o.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements k {

    /* renamed from: a  reason: collision with root package name */
    public final Object f68364a;

    /* renamed from: b  reason: collision with root package name */
    public final List<com.ss.android.socialbase.downloader.model.c> f68365b;

    /* renamed from: c  reason: collision with root package name */
    public k f68366c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68367d;

    /* renamed from: e  reason: collision with root package name */
    public long f68368e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f68369f;

    @Override // d.p.a.e.b.o.k
    public InputStream a() throws IOException {
        InputStream inputStream = this.f68369f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // d.p.a.e.b.o.i
    public int b() throws IOException {
        k kVar = this.f68366c;
        if (kVar != null) {
            return kVar.b();
        }
        return 0;
    }

    public boolean b(int i) {
        return i >= 200 && i < 300;
    }

    @Override // d.p.a.e.b.o.i
    public void c() {
        k kVar = this.f68366c;
        if (kVar != null) {
            kVar.c();
        }
    }

    @Override // d.p.a.e.b.o.k
    public void d() {
        k kVar = this.f68366c;
        if (kVar != null) {
            kVar.d();
        }
    }

    public void e() throws InterruptedException {
        synchronized (this.f68364a) {
            if (this.f68367d && this.f68366c == null) {
                this.f68364a.wait();
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        return this.f68365b;
    }

    public boolean g() {
        try {
            if (this.f68366c != null) {
                return b(this.f68366c.b());
            }
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean h() {
        return System.currentTimeMillis() - this.f68368e < b.f68352c;
    }

    @Override // d.p.a.e.b.o.i
    public String a(String str) {
        k kVar = this.f68366c;
        if (kVar != null) {
            return kVar.a(str);
        }
        return null;
    }
}
