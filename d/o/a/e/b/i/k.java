package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.IOException;
/* loaded from: classes7.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    public final i f71186a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.n.c f71187b;

    /* renamed from: c  reason: collision with root package name */
    public final e f71188c;

    public k(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.f71186a = iVar;
        this.f71187b = c(downloadInfo, iVar);
        this.f71188c = new h(bVar, this);
    }

    public e a() {
        return this.f71188c;
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) throws IOException {
        this.f71187b.a(aVar.f71143a, 0, aVar.f71145c);
        this.f71186a.f(aVar.f71145c);
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
        this.f71187b.o();
    }

    public void e() throws IOException {
        this.f71187b.q();
    }

    public void f() {
        d.o.a.e.b.l.e.C(this.f71187b);
    }

    public i g() {
        return this.f71186a;
    }
}
