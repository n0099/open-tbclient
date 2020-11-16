package kotlin.text;

import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.ad;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes9.dex */
public class t extends s {
    public static final boolean K(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        } else if (!z) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ String a(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return l.k(str, str2, str3, z);
    }

    public static final String k(String str, String str2, String str3, boolean z) {
        String a2;
        kotlin.jvm.internal.q.n(str, "receiver$0");
        kotlin.jvm.internal.q.n(str2, "oldValue");
        kotlin.jvm.internal.q.n(str3, "newValue");
        a2 = kotlin.sequences.e.a(l.a(str, new String[]{str2}, z, 0, 4, (Object) null), (r14 & 1) != 0 ? ", " : str3, (r14 & 2) != 0 ? "" : null, (r14 & 4) != 0 ? "" : null, (r14 & 8) != 0 ? -1 : 0, (r14 & 16) != 0 ? StringHelper.STRING_MORE : null, (r14 & 32) != 0 ? null : null);
        return a2;
    }

    public static /* synthetic */ boolean a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return l.L(str, str2, z);
    }

    public static final boolean L(String str, String str2, boolean z) {
        kotlin.jvm.internal.q.n(str, "receiver$0");
        kotlin.jvm.internal.q.n(str2, "prefix");
        return !z ? str.startsWith(str2) : l.a(str, 0, str2, 0, str2.length(), z);
    }

    public static final boolean isBlank(CharSequence charSequence) {
        boolean z;
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        if (charSequence.length() != 0) {
            kotlin.b.h z2 = l.z(charSequence);
            if (!(z2 instanceof Collection) || !((Collection) z2).isEmpty()) {
                Iterator<Integer> it = z2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    } else if (!a.isWhitespace(charSequence.charAt(((ad) it).nextInt()))) {
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
        kotlin.jvm.internal.q.n(str, "receiver$0");
        kotlin.jvm.internal.q.n(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }
}
