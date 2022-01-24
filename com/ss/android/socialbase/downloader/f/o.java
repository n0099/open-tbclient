package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes4.dex */
public class o {
    public static long a(@NonNull List<i> list) {
        int size = list.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = list.get(i2);
            if (iVar.c() > j2) {
                break;
            }
            if (iVar.e() > j2) {
                j2 = iVar.e();
            }
        }
        return j2;
    }

    public static long b(@NonNull List<i> list) {
        long j2;
        long j3;
        long j4 = 0;
        loop0: while (true) {
            j2 = -1;
            j3 = -1;
            for (i iVar : list) {
                if (j2 == -1) {
                    if (iVar.a() > 0) {
                        j2 = iVar.c();
                        j3 = iVar.d();
                    }
                } else if (iVar.c() <= j3) {
                    if (iVar.d() > j3) {
                        j3 = iVar.d();
                    }
                } else {
                    j4 += j3 - j2;
                    if (iVar.a() > 0) {
                        j2 = iVar.c();
                        j3 = iVar.d();
                    }
                }
            }
        }
        return (j2 < 0 || j3 <= j2) ? j4 : j4 + (j3 - j2);
    }
}
