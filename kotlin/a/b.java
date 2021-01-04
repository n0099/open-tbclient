package kotlin.a;

import kotlin.e;
/* JADX INFO: Access modifiers changed from: package-private */
@e
/* loaded from: classes5.dex */
public class b {
    public static final <T extends Comparable<?>> int c(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }
}
