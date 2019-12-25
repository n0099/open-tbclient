package kotlin.text;

import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class r extends q {
    public static final boolean D(String str, String str2, boolean z) {
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
        return l.j(str, str2, str3, z);
    }

    public static final String j(String str, String str2, String str3, boolean z) {
        String a;
        kotlin.jvm.internal.p.j(str, "$receiver");
        kotlin.jvm.internal.p.j(str2, "oldValue");
        kotlin.jvm.internal.p.j(str3, "newValue");
        a = kotlin.sequences.d.a(l.a(str, new String[]{str2}, z, 0, 4, (Object) null), (r14 & 1) != 0 ? ", " : str3, (r14 & 2) != 0 ? "" : null, (r14 & 4) != 0 ? "" : null, (r14 & 8) != 0 ? -1 : 0, (r14 & 16) != 0 ? StringHelper.STRING_MORE : null, (r14 & 32) != 0 ? null : null);
        return a;
    }

    public static /* synthetic */ boolean a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return l.E(str, str2, z);
    }

    public static final boolean E(String str, String str2, boolean z) {
        kotlin.jvm.internal.p.j(str, "$receiver");
        kotlin.jvm.internal.p.j(str2, "prefix");
        return !z ? str.startsWith(str2) : l.a(str, 0, str2, 0, str2.length(), z);
    }

    public static final boolean isBlank(CharSequence charSequence) {
        boolean z;
        kotlin.jvm.internal.p.j(charSequence, "$receiver");
        if (charSequence.length() != 0) {
            kotlin.b.c s = l.s(charSequence);
            if (!(s instanceof Collection) || !((Collection) s).isEmpty()) {
                Iterator<Integer> it = s.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    } else if (!a.isWhitespace(charSequence.charAt(((y) it).dyJ()))) {
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
        kotlin.jvm.internal.p.j(str, "$receiver");
        kotlin.jvm.internal.p.j(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }
}
