package d.o.a.e.b.l;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.t;
/* loaded from: classes7.dex */
public class c {
    public static void a(int i, SparseArray<d.o.a.e.b.f.b> sparseArray, boolean z, DownloadInfo downloadInfo, BaseException baseException) {
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
            for (int i2 = 0; i2 < clone.size(); i2++) {
                d.o.a.e.b.f.b bVar = clone.get(clone.keyAt(i2));
                if (bVar != null) {
                    if (i == 1) {
                        bVar.l(downloadInfo);
                    } else if (i == 2) {
                        bVar.f(downloadInfo);
                    } else if (i == 4) {
                        bVar.c(downloadInfo);
                    } else if (i == 5) {
                        bVar.g(downloadInfo, baseException);
                    } else if (i == 6) {
                        bVar.h(downloadInfo);
                    } else if (i == 7) {
                        bVar.i(downloadInfo, baseException);
                    } else if (i != 11) {
                        switch (i) {
                            case -7:
                                if (bVar instanceof d.o.a.e.b.f.a) {
                                    ((d.o.a.e.b.f.a) bVar).m(downloadInfo);
                                    break;
                                } else {
                                    continue;
                                }
                            case -6:
                                bVar.j(downloadInfo);
                                continue;
                            case -5:
                            case -2:
                                bVar.d(downloadInfo);
                                continue;
                            case -4:
                                bVar.k(downloadInfo);
                                continue;
                            case -3:
                                bVar.b(downloadInfo);
                                continue;
                            case -1:
                                bVar.e(downloadInfo, baseException);
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
