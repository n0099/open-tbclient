package d.p.a.e.b.m;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class i implements d.p.a.e.b.g.k {
    @Override // d.p.a.e.b.g.k
    public int a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String F0 = d.p.a.e.b.l.e.F0(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(F0)) {
            return 0;
        }
        return F0.hashCode();
    }
}
