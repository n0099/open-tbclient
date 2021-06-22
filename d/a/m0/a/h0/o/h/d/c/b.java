package d.a.m0.a.h0.o.h.d.c;

import androidx.annotation.NonNull;
import d.a.m0.t.f;
/* loaded from: classes3.dex */
public class b implements a {
    @Override // d.a.m0.a.h0.o.h.d.c.a
    public String a(@NonNull String str) {
        return f.d(str.getBytes(), false);
    }

    @NonNull
    public String toString() {
        return "MD5KeyProvider";
    }
}
