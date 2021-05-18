package d.o.a.e.b.l;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.t;
/* loaded from: classes7.dex */
public class c {
    public static void a(int i2, SparseArray<d.o.a.e.b.f.b> sparseArray, boolean z, DownloadInfo downloadInfo, BaseException baseException) {
        SparseArray<d.o.a.e.b.f.b> clone;
        if (!z || sparseArray == null) {
            return;
        }
        try {
            if (sparseArray.size() <= 0) {
                return;
            }
            synchronized (sparseArray) {
                clone = sparseArray.clone();
            }
            for (int i3 = 0; i3 < clone.size(); i3++) {
                d.o.a.e.b.f.b bVar = clone.get(clone.keyAt(i3));
                if (bVar != null) {
                    if (i2 == 1) {
                        bVar.l(downloadInfo);
                    } else if (i2 == 2) {
                        bVar.c(downloadInfo);
                    } else if (i2 == 4) {
                        bVar.g(downloadInfo);
                    } else if (i2 == 5) {
                        bVar.i(downloadInfo, baseException);
                    } else if (i2 == 6) {
                        bVar.d(downloadInfo);
                    } else if (i2 == 7) {
                        bVar.j(downloadInfo, baseException);
                    } else if (i2 != 11) {
                        switch (i2) {
                            case -7:
                                if (bVar instanceof d.o.a.e.b.f.a) {
                                    ((d.o.a.e.b.f.a) bVar).m(downloadInfo);
                                    break;
                                } else {
                                    continue;
                                }
                            case -6:
                                bVar.k(downloadInfo);
                                continue;
                            case -5:
                            case -2:
                                bVar.b(downloadInfo);
                                continue;
                            case -4:
                                bVar.e(downloadInfo);
                                continue;
                            case -3:
                                bVar.f(downloadInfo);
                                continue;
                            case -1:
                                bVar.h(downloadInfo, baseException);
                                continue;
                            default:
                                continue;
                        }
                    } else if (bVar instanceof t) {
                        ((t) bVar).a(downloadInfo);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
