package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes10.dex */
public class u extends t {

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a extends kotlin.collections.n {
        private int index;
        final /* synthetic */ CharSequence pTM;

        a(CharSequence charSequence) {
            this.pTM = charSequence;
        }

        @Override // kotlin.collections.n
        public char eBw() {
            CharSequence charSequence = this.pTM;
            int i = this.index;
            this.index = i + 1;
            return charSequence.charAt(i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.pTM.length();
        }
    }

    public static final kotlin.collections.n x(CharSequence charSequence) {
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        return new a(charSequence);
    }

    public static final kotlin.b.h y(CharSequence charSequence) {
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        return new kotlin.b.h(0, charSequence.length() - 1);
    }

    public static final int z(CharSequence charSequence) {
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        return charSequence.length() - 1;
    }

    public static final String a(CharSequence charSequence, kotlin.b.h hVar) {
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        kotlin.jvm.internal.q.n(hVar, "range");
        return charSequence.subSequence(hVar.eCb().intValue(), hVar.eCc().intValue() + 1).toString();
    }

    public static final boolean a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        kotlin.jvm.internal.q.n(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!kotlin.text.a.a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        kotlin.jvm.internal.q.n(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.f.c(cArr), i);
        }
        int ex = kotlin.b.l.ex(i, 0);
        int z3 = l.z(charSequence);
        if (ex <= z3) {
            while (true) {
                char charAt = charSequence.charAt(ex);
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    } else if (kotlin.text.a.a(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z2) {
                    if (ex == z3) {
                        break;
                    }
                    ex++;
                } else {
                    return ex;
                }
            }
        }
        return -1;
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        kotlin.b.h ev;
        if (!z2) {
            ev = new kotlin.b.h(kotlin.b.l.ex(i, 0), kotlin.b.l.ey(i2, charSequence.length()));
        } else {
            ev = kotlin.b.l.ev(kotlin.b.l.ey(i, l.z(charSequence)), kotlin.b.l.ex(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = ev.getFirst();
            int last = ev.getLast();
            int eBZ = ev.eBZ();
            if (eBZ <= 0 ? first >= last : first <= last) {
                while (!l.a((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                    if (first != last) {
                        first += eBZ;
                    }
                }
                return first;
            }
        } else {
            int first2 = ev.getFirst();
            int last2 = ev.getLast();
            int eBZ2 = ev.eBZ();
            if (eBZ2 <= 0 ? first2 >= last2 : first2 <= last2) {
                while (!l.a(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
                    if (first2 != last2) {
                        first2 += eBZ2;
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
            String str = (String) kotlin.collections.o.d(collection);
            int a2 = !z2 ? l.a(charSequence, str, i, false, 4, (Object) null) : l.b(charSequence, str, i, false, 4, (Object) null);
            if (a2 < 0) {
                return null;
            }
            return kotlin.j.k(Integer.valueOf(a2), str);
        }
        kotlin.b.h hVar = !z2 ? new kotlin.b.h(kotlin.b.l.ex(i, 0), charSequence.length()) : kotlin.b.l.ev(kotlin.b.l.ey(i, l.z(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = hVar.getFirst();
            int last = hVar.getLast();
            int eBZ = hVar.eBZ();
            if (eBZ <= 0 ? first >= last : first <= last) {
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
                        first += eBZ;
                    } else {
                        return kotlin.j.k(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = hVar.getFirst();
            int last2 = hVar.getLast();
            int eBZ2 = hVar.eBZ();
            if (eBZ2 <= 0 ? first2 >= last2 : first2 <= last2) {
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
                        first2 += eBZ2;
                    } else {
                        return kotlin.j.k(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l.a(charSequence, c, i, z);
    }

    public static final int a(CharSequence charSequence, char c, int i, boolean z) {
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        return (z || !(charSequence instanceof String)) ? l.a(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l.a(charSequence, str, i, z);
    }

    public static final int a(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        kotlin.jvm.internal.q.n(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, str, i, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = l.z(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l.b(charSequence, str, i, z);
    }

    public static final int b(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        kotlin.jvm.internal.q.n(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, (CharSequence) str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return l.a(charSequence, charSequence2, z);
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        kotlin.jvm.internal.q.n(charSequence2, "other");
        return charSequence2 instanceof String ? l.a(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0 : a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0;
    }

    static /* synthetic */ kotlin.sequences.c a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
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

    public static /* synthetic */ kotlin.sequences.c a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return l.a(charSequence, strArr, z, i);
    }

    public static final kotlin.sequences.c<String> a(CharSequence charSequence, String[] strArr, boolean z, int i) {
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        kotlin.jvm.internal.q.n(strArr, "delimiters");
        return kotlin.sequences.e.c(a(charSequence, strArr, 0, z, i, 2, null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static /* synthetic */ List b(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return l.b(charSequence, strArr, z, i);
    }

    public static final List<String> b(CharSequence charSequence, String[] strArr, boolean z, int i) {
        kotlin.jvm.internal.q.n(charSequence, "receiver$0");
        kotlin.jvm.internal.q.n(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return a(charSequence, str, z, i);
            }
        }
        Iterable<kotlin.b.h> c = kotlin.sequences.e.c(a(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.o.a(c, 10));
        for (kotlin.b.h hVar : c) {
            arrayList.add(l.a(charSequence, hVar));
        }
        return arrayList;
    }

    private static final List<String> a(CharSequence charSequence, String str, boolean z, int i) {
        if (i >= 0) {
            int a2 = l.a(charSequence, str, 0, z);
            if (a2 == -1 || i == 1) {
                return kotlin.collections.o.bU(charSequence.toString());
            }
            boolean z2 = i > 0;
            ArrayList arrayList = new ArrayList(z2 ? kotlin.b.l.ey(i, 10) : 10);
            int i2 = 0;
            int i3 = a2;
            do {
                arrayList.add(charSequence.subSequence(i2, i3).toString());
                i2 = str.length() + i3;
                if (z2 && arrayList.size() == i - 1) {
                    break;
                }
                i3 = l.a(charSequence, str, i2, z);
            } while (i3 != -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }
}
