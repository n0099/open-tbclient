package d.a.m0.a.v2.z0;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class a {
    @NonNull
    @SafeVarargs
    public static <E> HashSet<E> a(E... eArr) {
        if (eArr != null && eArr.length > 0) {
            HashSet<E> hashSet = new HashSet<>(eArr.length);
            Collections.addAll(hashSet, eArr);
            return hashSet;
        }
        return new HashSet<>();
    }
}
