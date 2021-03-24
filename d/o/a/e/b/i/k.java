package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
/* loaded from: classes7.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    public final i f67057a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.n.c f67058b;

    /* renamed from: c  reason: collision with root package name */
    public final e f67059c;

    public k(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.f67057a = iVar;
        this.f67058b = c(downloadInfo, iVar);
        this.f67059c = new h(bVar, this);
    }

    public e a() {
        return this.f67059c;
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) throws IOException {
        this.f67058b.a(aVar.f67017a, 0, aVar.f67019c);
        this.f67057a.f(aVar.f67019c);
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
        this.f67058b.o();
    }

    public void e() throws IOException {
        this.f67058b.q();
    }

    public void f() {
        d.o.a.e.b.l.e.C(this.f67058b);
    }

    public i g() {
        return this.f67057a;
    }
}
