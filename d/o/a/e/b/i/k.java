package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
/* loaded from: classes7.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    public final i f67296a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.n.c f67297b;

    /* renamed from: c  reason: collision with root package name */
    public final e f67298c;

    public k(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.f67296a = iVar;
        this.f67297b = c(downloadInfo, iVar);
        this.f67298c = new h(bVar, this);
    }

    public e a() {
        return this.f67298c;
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) throws IOException {
        this.f67297b.a(aVar.f67253a, 0, aVar.f67255c);
        this.f67296a.f(aVar.f67255c);
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
        this.f67297b.o();
    }

    public void e() throws IOException {
        this.f67297b.q();
    }

    public void f() {
        d.o.a.e.b.l.e.C(this.f67297b);
    }

    public i g() {
        return this.f67296a;
    }
}
