package d.l.a.e.b.l;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.f.v;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, SparseArray<d.l.a.e.b.f.c> sparseArray, boolean z, DownloadInfo downloadInfo, BaseException baseException) {
        SparseArray<d.l.a.e.b.f.c> clone;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), sparseArray, Boolean.valueOf(z), downloadInfo, baseException}) == null) && z && sparseArray != null) {
            try {
                if (sparseArray.size() <= 0) {
                    return;
                }
                synchronized (sparseArray) {
                    clone = sparseArray.clone();
                }
                for (int i3 = 0; i3 < clone.size(); i3++) {
                    d.l.a.e.b.f.c cVar = clone.get(clone.keyAt(i3));
                    if (cVar != null) {
                        if (i2 == 1) {
                            cVar.l(downloadInfo);
                        } else if (i2 == 2) {
                            cVar.c(downloadInfo);
                        } else if (i2 == 4) {
                            cVar.g(downloadInfo);
                        } else if (i2 == 5) {
                            cVar.i(downloadInfo, baseException);
                        } else if (i2 == 6) {
                            cVar.d(downloadInfo);
                        } else if (i2 == 7) {
                            cVar.j(downloadInfo, baseException);
                        } else if (i2 != 11) {
                            switch (i2) {
                                case -7:
                                    if (cVar instanceof d.l.a.e.b.f.a) {
                                        ((d.l.a.e.b.f.a) cVar).m(downloadInfo);
                                        break;
                                    } else {
                                        continue;
                                    }
                                case -6:
                                    cVar.k(downloadInfo);
                                    continue;
                                case -5:
                                case -2:
                                    cVar.b(downloadInfo);
                                    continue;
                                case -4:
                                    cVar.e(downloadInfo);
                                    continue;
                                case -3:
                                    cVar.f(downloadInfo);
                                    continue;
                                case -1:
                                    cVar.h(downloadInfo, baseException);
                                    continue;
                                default:
                                    continue;
                            }
                        } else if (cVar instanceof v) {
                            ((v) cVar).a(downloadInfo);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
