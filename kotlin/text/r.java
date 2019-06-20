package kotlin.text;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
/* loaded from: classes2.dex */
class r extends q {

    /* loaded from: classes2.dex */
    public static final class a extends kotlin.collections.m {
        private int index;
        final /* synthetic */ CharSequence receiver$0;

        a(CharSequence charSequence) {
            this.receiver$0 = charSequence;
        }

        @Override // kotlin.collections.m
        public char cJR() {
            CharSequence charSequence = this.receiver$0;
            int i = this.index;
            this.index = i + 1;
            return charSequence.charAt(i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.receiver$0.length();
        }
    }

    public static final kotlin.collections.m n(CharSequence charSequence) {
        kotlin.jvm.internal.p.k(charSequence, "$receiver");
        return new a(charSequence);
    }

    public static final kotlin.b.c o(CharSequence charSequence) {
        kotlin.jvm.internal.p.k(charSequence, "$receiver");
        return new kotlin.b.c(0, charSequence.length() - 1);
    }

    public static final int p(CharSequence charSequence) {
        kotlin.jvm.internal.p.k(charSequence, "$receiver");
        return charSequence.length() - 1;
    }

    public static final String a(CharSequence charSequence, kotlin.b.c cVar) {
        kotlin.jvm.internal.p.k(charSequence, "$receiver");
        kotlin.jvm.internal.p.k(cVar, "range");
        return charSequence.subSequence(cVar.cKg().intValue(), cVar.cKh().intValue() + 1).toString();
    }

    public static final boolean a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.p.k(charSequence, "$receiver");
        kotlin.jvm.internal.p.k(charSequence2, ImageViewerConfig.FROM_OTHER);
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        int i4 = i3 - 1;
        if (0 <= i4) {
            for (int i5 = 0; kotlin.text.a.a(charSequence.charAt(i + i5), charSequence2.charAt(i2 + i5), z); i5++) {
                if (i5 != i4) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0087 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Pair<Integer, Character> a(CharSequence charSequence, char[] cArr, int i, boolean z, boolean z2) {
        int i2;
        int length;
        int i3;
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            char b = kotlin.collections.f.b(cArr);
            int indexOf = !z2 ? ((String) charSequence).indexOf(b, i) : ((String) charSequence).lastIndexOf(b, i);
            if (indexOf < 0) {
                return null;
            }
            return kotlin.c.g(Integer.valueOf(indexOf), Character.valueOf(b));
        }
        kotlin.b.c cVar = !z2 ? new kotlin.b.c(kotlin.b.d.cR(i, 0), k.p(charSequence)) : kotlin.b.d.cP(kotlin.b.d.cS(i, k.p(charSequence)), 0);
        int first = cVar.getFirst();
        int last = cVar.getLast();
        int cKe = cVar.cKe();
        if (cKe <= 0) {
            if (first >= last) {
                i2 = first;
                while (true) {
                    char charAt = charSequence.charAt(i2);
                    length = cArr.length;
                    i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                        }
                        i3++;
                    }
                    if (i3 >= 0) {
                    }
                    i2 += cKe;
                }
            }
            return null;
        }
        if (first <= last) {
            i2 = first;
            while (true) {
                char charAt2 = charSequence.charAt(i2);
                length = cArr.length;
                i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        if (kotlin.text.a.a(cArr[i3], charAt2, z)) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 >= 0) {
                    if (i2 == last) {
                        break;
                    }
                    i2 += cKe;
                } else {
                    return kotlin.c.g(Integer.valueOf(i2), Character.valueOf(cArr[i3]));
                }
            }
        }
        return null;
    }

    static /* bridge */ /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        kotlin.b.c cP;
        if (!z2) {
            cP = new kotlin.b.c(kotlin.b.d.cR(i, 0), kotlin.b.d.cS(i2, charSequence.length()));
        } else {
            cP = kotlin.b.d.cP(kotlin.b.d.cS(i, k.p(charSequence)), kotlin.b.d.cR(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = cP.getFirst();
            int last = cP.getLast();
            int cKe = cP.cKe();
            if (cKe <= 0 ? first >= last : first <= last) {
                while (!k.a((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                    if (first != last) {
                        first += cKe;
                    }
                }
                return first;
            }
        } else {
            int first2 = cP.getFirst();
            int last2 = cP.getLast();
            int cKe2 = cP.cKe();
            if (cKe2 <= 0 ? first2 >= last2 : first2 <= last2) {
                while (!k.a(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
                    if (first2 != last2) {
                        first2 += cKe2;
                    }
                }
                return first2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, String> a(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (!z && collection.size() == 1) {
            String str = (String) kotlin.collections.n.b(collection);
            int a2 = !z2 ? k.a(charSequence, str, i, false, 4, (Object) null) : k.b(charSequence, str, i, false, 4, null);
            if (a2 < 0) {
                return null;
            }
            return kotlin.c.g(Integer.valueOf(a2), str);
        }
        kotlin.b.c cVar = !z2 ? new kotlin.b.c(kotlin.b.d.cR(i, 0), charSequence.length()) : kotlin.b.d.cP(kotlin.b.d.cS(i, k.p(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = cVar.getFirst();
            int last = cVar.getLast();
            int cKe = cVar.cKe();
            if (cKe <= 0 ? first >= last : first <= last) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object next = it.next();
                            String str2 = (String) next;
                            if (k.a(str2, 0, (String) charSequence, first, str2.length(), z)) {
                                obj2 = next;
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += cKe;
                    } else {
                        return kotlin.c.g(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = cVar.getFirst();
            int last2 = cVar.getLast();
            int cKe2 = cVar.cKe();
            if (cKe2 <= 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object next2 = it2.next();
                            String str4 = (String) next2;
                            if (k.a(str4, 0, charSequence, first2, str4.length(), z)) {
                                obj = next2;
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += cKe2;
                    } else {
                        return kotlin.c.g(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* bridge */ /* synthetic */ int a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return k.a(charSequence, str, i, z);
    }

    public static final int a(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.p.k(charSequence, "$receiver");
        kotlin.jvm.internal.p.k(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, str, i, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = k.p(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return k.b(charSequence, str, i, z);
    }

    public static final int b(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.p.k(charSequence, "$receiver");
        kotlin.jvm.internal.p.k(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, (CharSequence) str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }
}
