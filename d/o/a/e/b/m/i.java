package d.o.a.e.b.m;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class i implements d.o.a.e.b.g.k {
    @Override // d.o.a.e.b.g.k
    public int a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String F0 = d.o.a.e.b.l.e.F0(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(F0)) {
            return 0;
        }
        return F0.hashCode();
    }
}
