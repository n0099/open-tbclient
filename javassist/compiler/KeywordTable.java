package javassist.compiler;

import java.util.HashMap;
/* loaded from: classes.dex */
public final class KeywordTable extends HashMap {
    public int lookup(String str) {
        Object obj = get(str);
        if (obj == null) {
            return -1;
        }
        return ((Integer) obj).intValue();
    }

    public void append(String str, int i) {
        put(str, new Integer(i));
    }
}
