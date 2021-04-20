package d.o.a.e.b.m;
/* loaded from: classes6.dex */
public class b implements d.o.a.e.b.g.h {
    @Override // d.o.a.e.b.g.h
    public int a(int i, com.ss.android.socialbase.downloader.network.l lVar) {
        if (lVar.ordinal() <= com.ss.android.socialbase.downloader.network.l.MODERATE.ordinal()) {
            return 1;
        }
        return lVar == com.ss.android.socialbase.downloader.network.l.GOOD ? i - 1 : i;
    }
}
