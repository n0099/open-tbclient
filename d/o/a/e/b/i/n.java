package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes7.dex */
public class n {
    public static long a(@NonNull List<i> list) {
        int size = list.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = list.get(i2);
            if (iVar.g() > j) {
                break;
            }
            if (iVar.k() > j) {
                j = iVar.k();
            }
        }
        return j;
    }

    public static long b(@NonNull List<i> list) {
        long j;
        long j2;
        long j3 = 0;
        loop0: while (true) {
            j = -1;
            j2 = -1;
            for (i iVar : list) {
                if (j == -1) {
                    if (iVar.a() > 0) {
                        j = iVar.g();
                        j2 = iVar.i();
                    }
                } else if (iVar.g() <= j2) {
                    if (iVar.i() > j2) {
                        j2 = iVar.i();
                    }
                } else {
                    j3 += j2 - j;
                    if (iVar.a() > 0) {
                        j = iVar.g();
                        j2 = iVar.i();
                    }
                }
            }
        }
        return (j < 0 || j2 <= j) ? j3 : j3 + (j2 - j);
    }
}
