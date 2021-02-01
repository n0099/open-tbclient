package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes6.dex */
public class s extends r {

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a extends kotlin.collections.m {
        private int index;
        final /* synthetic */ CharSequence receiver$0;

        a(CharSequence charSequence) {
            this.receiver$0 = charSequence;
        }

        @Override // kotlin.collections.m
        public char eKV() {
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

    public static final kotlin.collections.m A(CharSequence charSequence) {
        kotlin.jvm.internal.p.o(charSequence, "$receiver");
        return new a(charSequence);
    }

    public static final kotlin.b.h B(CharSequence charSequence) {
        kotlin.jvm.internal.p.o(charSequence, "$receiver");
        return new kotlin.b.h(0, charSequence.length() - 1);
    }

    public static final int C(CharSequence charSequence) {
        kotlin.jvm.internal.p.o(charSequence, "$receiver");
        return charSequence.length() - 1;
    }

    public static final String a(CharSequence charSequence, kotlin.b.h hVar) {
        kotlin.jvm.internal.p.o(charSequence, "$receiver");
        kotlin.jvm.internal.p.o(hVar, "range");
        return charSequence.subSequence(hVar.eLv().intValue(), hVar.eLw().intValue() + 1).toString();
    }

    public static final boolean a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.p.o(charSequence, "$receiver");
        kotlin.jvm.internal.p.o(charSequence2, "other");
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
            char c = kotlin.collections.f.c(cArr);
            int indexOf = !z2 ? ((String) charSequence).indexOf(c, i) : ((String) charSequence).lastIndexOf(c, i);
            if (indexOf < 0) {
                return null;
            }
            return kotlin.f.k(Integer.valueOf(indexOf), Character.valueOf(c));
        }
        kotlin.b.h hVar = !z2 ? new kotlin.b.h(kotlin.b.l.en(i, 0), l.C(charSequence)) : kotlin.b.l.el(kotlin.b.l.eo(i, l.C(charSequence)), 0);
        int first = hVar.getFirst();
        int last = hVar.getLast();
        int eLt = hVar.eLt();
        if (eLt <= 0) {
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
                    i2 += eLt;
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
                    i2 += eLt;
                } else {
                    return kotlin.f.k(Integer.valueOf(i2), Character.valueOf(cArr[i3]));
                }
            }
        }
        return null;
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        Integer first;
        kotlin.jvm.internal.p.o(charSequence, "$receiver");
        kotlin.jvm.internal.p.o(cArr, "chars");
        Pair<Integer, Character> a2 = a(charSequence, cArr, i, z, false);
        if (a2 == null || (first = a2.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    static /* bridge */ /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        kotlin.b.h el;
        if (!z2) {
            el = new kotlin.b.h(kotlin.b.l.en(i, 0), kotlin.b.l.eo(i2, charSequence.length()));
        } else {
            el = kotlin.b.l.el(kotlin.b.l.eo(i, l.C(charSequence)), kotlin.b.l.en(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = el.getFirst();
            int last = el.getLast();
            int eLt = el.eLt();
            if (eLt <= 0 ? first >= last : first <= last) {
                while (!l.a((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                    if (first != last) {
                        first += eLt;
                    }
                }
                return first;
            }
        } else {
            int first2 = el.getFirst();
            int last2 = el.getLast();
            int eLt2 = el.eLt();
            if (eLt2 <= 0 ? first2 >= last2 : first2 <= last2) {
                while (!l.a(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
                    if (first2 != last2) {
                        first2 += eLt2;
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
            String str = (String) kotlin.collections.n.d(collection);
            int a2 = !z2 ? l.a(charSequence, str, i, false, 4, (Object) null) : l.b(charSequence, str, i, false, 4, null);
            if (a2 < 0) {
                return null;
            }
            return kotlin.f.k(Integer.valueOf(a2), str);
        }
        kotlin.b.h hVar = !z2 ? new kotlin.b.h(kotlin.b.l.en(i, 0), charSequence.length()) : kotlin.b.l.el(kotlin.b.l.eo(i, l.C(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = hVar.getFirst();
            int last = hVar.getLast();
            int eLt = hVar.eLt();
            if (eLt <= 0 ? first >= last : first <= last) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object next = it.next();
                            String str2 = (String) next;
                            if (l.a(str2, 0, (String) charSequence, first, str2.length(), z)) {
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
                        first += eLt;
                    } else {
                        return kotlin.f.k(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = hVar.getFirst();
            int last2 = hVar.getLast();
            int eLt2 = hVar.eLt();
            if (eLt2 <= 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object next2 = it2.next();
                            String str4 = (String) next2;
                            if (l.a(str4, 0, charSequence, first2, str4.length(), z)) {
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
                        first2 += eLt2;
                    } else {
                        return kotlin.f.k(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* bridge */ /* synthetic */ int a(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l.a(charSequence, c, i, z);
    }

    public static final int a(CharSequence charSequence, char c, int i, boolean z) {
        kotlin.jvm.internal.p.o(charSequence, "$receiver");
        return (z || !(charSequence instanceof String)) ? l.a(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static /* bridge */ /* synthetic */ int a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l.a(charSequence, str, i, z);
    }

    public static final int a(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.p.o(charSequence, "$receiver");
        kotlin.jvm.internal.p.o(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, str, i, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = l.C(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l.b(charSequence, str, i, z);
    }

    public static final int b(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.p.o(charSequence, "$receiver");
        kotlin.jvm.internal.p.o(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, (CharSequence) str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* bridge */ /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return l.a(charSequence, charSequence2, z);
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        kotlin.jvm.internal.p.o(charSequence, "$receiver");
        kotlin.jvm.internal.p.o(charSequence2, "other");
        return charSequence2 instanceof String ? l.a(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0 : a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0;
    }

    static /* bridge */ /* synthetic */ kotlin.sequences.c a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, i, z, i2);
    }

    private static final kotlin.sequences.c<kotlin.b.h> a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new d(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$4(kotlin.collections.f.asList(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static /* bridge */ /* synthetic */ kotlin.sequences.c a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return l.a(charSequence, strArr, z, i);
    }

    public static final kotlin.sequences.c<String> a(CharSequence charSequence, String[] strArr, boolean z, int i) {
        kotlin.jvm.internal.p.o(charSequence, "$receiver");
        kotlin.jvm.internal.p.o(strArr, "delimiters");
        return kotlin.sequences.d.c(a(charSequence, strArr, 0, z, i, 2, null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }
}
