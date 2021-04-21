package d.p.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
/* loaded from: classes6.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    public final i f68202a;

    /* renamed from: b  reason: collision with root package name */
    public final d.p.a.e.b.n.c f68203b;

    /* renamed from: c  reason: collision with root package name */
    public final e f68204c;

    public k(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.f68202a = iVar;
        this.f68203b = c(downloadInfo, iVar);
        this.f68204c = new h(bVar, this);
    }

    public e a() {
        return this.f68204c;
    }

    @Override // d.p.a.e.b.i.e
    public void b(@NonNull a aVar) throws IOException {
        this.f68203b.a(aVar.f68162a, 0, aVar.f68164c);
        this.f68202a.f(aVar.f68164c);
    }

    public final d.p.a.e.b.n.c c(DownloadInfo downloadInfo, i iVar) throws BaseException {
        d.p.a.e.b.n.c f2 = d.p.a.e.b.l.e.f(downloadInfo.N0(), downloadInfo.M0(), d.p.a.e.b.j.a.d(downloadInfo.c0()).b("flush_buffer_size_byte", -1));
        try {
            f2.a(iVar.i());
            return f2;
        } catch (IOException e2) {
            throw new BaseException(1054, e2);
        }
    }

    public void d() throws IOException {
        this.f68203b.o();
    }

    public void e() throws IOException {
        this.f68203b.q();
    }

    public void f() {
        d.p.a.e.b.l.e.C(this.f68203b);
    }

    public i g() {
        return this.f68202a;
    }
}
