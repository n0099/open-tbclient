package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class q extends p {
    public static final boolean m(CharSequence charSequence) {
        boolean z;
        kotlin.jvm.internal.p.i(charSequence, "$receiver");
        if (charSequence.length() != 0) {
            kotlin.b.c o = k.o(charSequence);
            if (!(o instanceof Collection) || !((Collection) o).isEmpty()) {
                Iterator<Integer> it = o.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    } else if (!a.isWhitespace(charSequence.charAt(((y) it).cMP()))) {
                        z = false;
                        break;
                    }
                }
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final boolean a(String str, int i, String str2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.p.i(str, "$receiver");
        kotlin.jvm.internal.p.i(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }
}
