package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
/* loaded from: classes7.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    public final i f67062a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.n.c f67063b;

    /* renamed from: c  reason: collision with root package name */
    public final e f67064c;

    public k(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.f67062a = iVar;
        this.f67063b = c(downloadInfo, iVar);
        this.f67064c = new h(bVar, this);
    }

    public e a() {
        return this.f67064c;
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) throws IOException {
        this.f67063b.a(aVar.f67022a, 0, aVar.f67024c);
        this.f67062a.f(aVar.f67024c);
    }

    public final d.o.a.e.b.n.c c(DownloadInfo downloadInfo, i iVar) throws BaseException {
        d.o.a.e.b.n.c f2 = d.o.a.e.b.l.e.f(downloadInfo.N0(), downloadInfo.M0(), d.o.a.e.b.j.a.d(downloadInfo.c0()).b("flush_buffer_size_byte", -1));
        try {
            f2.a(iVar.i());
            return f2;
        } catch (IOException e2) {
            throw new BaseException(1054, e2);
        }
    }

    public void d() throws IOException {
        this.f67063b.o();
    }

    public void e() throws IOException {
        this.f67063b.q();
    }

    public void f() {
        d.o.a.e.b.l.e.C(this.f67063b);
    }

    public i g() {
        return this.f67062a;
    }
}
