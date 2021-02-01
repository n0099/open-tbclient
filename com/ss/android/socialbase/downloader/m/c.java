package com.ss.android.socialbase.downloader.m;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.d.ag;
import com.ss.android.socialbase.downloader.d.x;
/* loaded from: classes6.dex */
public class c {
    public static void a(int i, SparseArray<com.ss.android.socialbase.downloader.d.b> sparseArray, boolean z, com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
        SparseArray<com.ss.android.socialbase.downloader.d.b> clone;
        if (z && sparseArray != null) {
            try {
                if (sparseArray.size() > 0) {
                    synchronized (sparseArray) {
                        clone = sparseArray.clone();
                    }
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < clone.size()) {
                            com.ss.android.socialbase.downloader.d.b bVar = clone.get(clone.keyAt(i3));
                            if (bVar != null) {
                                switch (i) {
                                    case -7:
                                        if (bVar instanceof x) {
                                            ((x) bVar).p(cVar);
                                            break;
                                        } else {
                                            continue;
                                        }
                                    case -6:
                                        bVar.i(cVar);
                                        continue;
                                    case -5:
                                    case -2:
                                        bVar.d(cVar);
                                        continue;
                                    case -4:
                                        bVar.f(cVar);
                                        continue;
                                    case -3:
                                        bVar.e(cVar);
                                        continue;
                                    case -1:
                                        bVar.a(cVar, aVar);
                                        continue;
                                    case 1:
                                        bVar.a(cVar);
                                        continue;
                                    case 2:
                                        bVar.b(cVar);
                                        continue;
                                    case 4:
                                        bVar.c(cVar);
                                        continue;
                                    case 5:
                                        bVar.b(cVar, aVar);
                                        continue;
                                    case 6:
                                        bVar.h(cVar);
                                        continue;
                                    case 7:
                                        bVar.c(cVar, aVar);
                                        continue;
                                    case 11:
                                        if (bVar instanceof ag) {
                                            ((ag) bVar).g(cVar);
                                            break;
                                        } else {
                                            continue;
                                        }
                                }
                            }
                            i2 = i3 + 1;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
