package kotlin.collections;

import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
@kotlin.e
/* loaded from: classes5.dex */
public abstract class e<K, V> implements Map<K, V> {
    public static final a qiS = new a(null);

    public abstract Set getEntries();

    protected e() {
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final int size() {
        return getSize();
    }

    public final boolean c(Map.Entry<?, ?> entry) {
        if (entry instanceof Map.Entry) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (this == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            }
            V v = get(key);
            if (!kotlin.jvm.internal.p.l(value, v)) {
                return false;
            }
            if (v == null) {
                if (this == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                }
                if (!containsKey(key)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if ((obj instanceof Map) && size() == ((Map) obj).size()) {
            Set<Map.Entry<K, V>> entrySet = ((Map) obj).entrySet();
            if (!(entrySet instanceof Collection) || !entrySet.isEmpty()) {
                Iterator<T> it = entrySet.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    } else if (!c((Map.Entry) it.next())) {
                        z = false;
                        break;
                    }
                }
            } else {
                z = true;
            }
            return z;
        }
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    public int getSize() {
        return entrySet().size();
    }

    public String toString() {
        String a2;
        a2 = n.a(entrySet(), (r14 & 1) != 0 ? ", " : ", ", (r14 & 2) != 0 ? "" : "{", (r14 & 4) != 0 ? "" : "}", (r14 & 8) != 0 ? -1 : 0, (r14 & 16) != 0 ? StringHelper.STRING_MORE : null, (r14 & 32) != 0 ? null : new AbstractMap$toString$1(this));
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(Map.Entry<? extends K, ? extends V> entry) {
        return toString(entry.getKey()) + "=" + toString(entry.getValue());
    }

    private final String toString(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
