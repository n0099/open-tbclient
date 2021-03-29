package d.o.a.e.b.m;

import android.text.TextUtils;
import d.o.a.e.b.g.r;
/* loaded from: classes7.dex */
public class p implements r {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f67171a;

    public p(String str) {
        this.f67171a = b(str);
    }

    @Override // d.o.a.e.b.g.r
    public long a(int i, int i2) {
        long[] jArr = this.f67171a;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int i3 = i - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        long[] jArr2 = this.f67171a;
        if (i3 > jArr2.length - 1) {
            i3 = jArr2.length - 1;
        }
        return this.f67171a[i3];
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
            for (int i = 0; i < split.length; i++) {
                jArr[i] = Long.parseLong(split[i]);
            }
            return jArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
