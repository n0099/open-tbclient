package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
/* loaded from: classes6.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    public final i f66567a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.n.c f66568b;

    /* renamed from: c  reason: collision with root package name */
    public final e f66569c;

    public k(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.f66567a = iVar;
        this.f66568b = c(downloadInfo, iVar);
        this.f66569c = new h(bVar, this);
    }

    public e a() {
        return this.f66569c;
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) throws IOException {
        this.f66568b.a(aVar.f66524a, 0, aVar.f66526c);
        this.f66567a.f(aVar.f66526c);
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
        this.f66568b.o();
    }

    public void e() throws IOException {
        this.f66568b.q();
    }

    public void f() {
        d.o.a.e.b.l.e.C(this.f66568b);
    }

    public i g() {
        return this.f66567a;
    }
}
