package d.o.a.e.b.o.b;

import d.o.a.e.b.o.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements k {

    /* renamed from: a  reason: collision with root package name */
    public final Object f67470a;

    /* renamed from: b  reason: collision with root package name */
    public final List<com.ss.android.socialbase.downloader.model.c> f67471b;

    /* renamed from: c  reason: collision with root package name */
    public k f67472c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67473d;

    /* renamed from: e  reason: collision with root package name */
    public long f67474e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f67475f;

    @Override // d.o.a.e.b.o.k
    public InputStream a() throws IOException {
        InputStream inputStream = this.f67475f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // d.o.a.e.b.o.i
    public int b() throws IOException {
        k kVar = this.f67472c;
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
        k kVar = this.f67472c;
        if (kVar != null) {
            kVar.c();
        }
    }

    @Override // d.o.a.e.b.o.k
    public void d() {
        k kVar = this.f67472c;
        if (kVar != null) {
            kVar.d();
        }
    }

    public void e() throws InterruptedException {
        synchronized (this.f67470a) {
            if (this.f67473d && this.f67472c == null) {
                this.f67470a.wait();
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        return this.f67471b;
    }

    public boolean g() {
        try {
            if (this.f67472c != null) {
                return b(this.f67472c.b());
            }
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean h() {
        return System.currentTimeMillis() - this.f67474e < b.f67457c;
    }

    @Override // d.o.a.e.b.o.i
    public String a(String str) {
        k kVar = this.f67472c;
        if (kVar != null) {
            return kVar.a(str);
        }
        return null;
    }
}
