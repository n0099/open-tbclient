package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
/* loaded from: classes6.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    public final i f68055a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.n.c f68056b;

    /* renamed from: c  reason: collision with root package name */
    public final e f68057c;

    public k(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.f68055a = iVar;
        this.f68056b = c(downloadInfo, iVar);
        this.f68057c = new h(bVar, this);
    }

    public e a() {
        return this.f68057c;
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) throws IOException {
        this.f68056b.a(aVar.f68015a, 0, aVar.f68017c);
        this.f68055a.f(aVar.f68017c);
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
        this.f68056b.o();
    }

    public void e() throws IOException {
        this.f68056b.q();
    }

    public void f() {
        d.o.a.e.b.l.e.C(this.f68056b);
    }

    public i g() {
        return this.f68055a;
    }
}
