package d.o.a.e.b.m;

import android.text.TextUtils;
import d.o.a.e.b.g.r;
/* loaded from: classes7.dex */
public class p implements r {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f67413a;

    public p(String str) {
        this.f67413a = b(str);
    }

    @Override // d.o.a.e.b.g.r
    public long a(int i2, int i3) {
        long[] jArr = this.f67413a;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int i4 = i2 - 1;
        if (i4 < 0) {
            i4 = 0;
        }
        long[] jArr2 = this.f67413a;
        if (i4 > jArr2.length - 1) {
            i4 = jArr2.length - 1;
        }
        return this.f67413a[i4];
    }

    public final long[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length == 0) {
                return null;
            }
            long[] jArr = new long[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                jArr[i2] = Long.parseLong(split[i2]);
            }
            return jArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
