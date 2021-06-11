package d.g.c.c;

import com.baidu.android.common.others.lang.StringUtil;
import com.kwai.video.player.KsMediaMeta;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes6.dex */
public final class n {
    public static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    public static boolean b(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder c(int i2) {
        m.b(i2, "size");
        return new StringBuilder((int) Math.min(i2 * 8, (long) KsMediaMeta.AV_CH_STEREO_RIGHT));
    }

    public static boolean d(Collection<?> collection, Object obj) {
        d.g.c.a.n.p(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean e(Collection<?> collection, Object obj) {
        d.g.c.a.n.p(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static String f(Collection<?> collection) {
        StringBuilder c2 = c(collection.size());
        c2.append('[');
        boolean z = true;
        for (Object obj : collection) {
            if (!z) {
                c2.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            z = false;
            if (obj == collection) {
                c2.append("(this Collection)");
            } else {
                c2.append(obj);
            }
        }
        c2.append(']');
        return c2.toString();
    }
}
