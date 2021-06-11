package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.IOException;
/* loaded from: classes7.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    public final i f71082a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.n.c f71083b;

    /* renamed from: c  reason: collision with root package name */
    public final e f71084c;

    public k(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.f71082a = iVar;
        this.f71083b = c(downloadInfo, iVar);
        this.f71084c = new h(bVar, this);
    }

    public e a() {
        return this.f71084c;
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) throws IOException {
        this.f71083b.a(aVar.f71039a, 0, aVar.f71041c);
        this.f71082a.f(aVar.f71041c);
    }

    public final d.o.a.e.b.n.c c(DownloadInfo downloadInfo, i iVar) throws BaseException {
        d.o.a.e.b.n.c f2 = d.o.a.e.b.l.e.f(downloadInfo.N0(), downloadInfo.M0(), d.o.a.e.b.j.a.d(downloadInfo.c0()).b("flush_buffer_size_byte", -1));
        try {
            f2.a(iVar.i());
            return f2;
        } catch (IOException e2) {
            throw new BaseException((int) RevenueServerConst.ChargeCurrencyHistoryRequest, e2);
        }
    }

    public void d() throws IOException {
        this.f71083b.o();
    }

    public void e() throws IOException {
        this.f71083b.q();
    }

    public void f() {
        d.o.a.e.b.l.e.C(this.f71083b);
    }

    public i g() {
        return this.f71082a;
    }
}
