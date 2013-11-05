package javassist.util.proxy;

import java.util.Comparator;
import java.util.Map;
/* loaded from: classes.dex */
final class h implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((String) ((Map.Entry) obj).getKey()).compareTo((String) ((Map.Entry) obj2).getKey());
    }
}
