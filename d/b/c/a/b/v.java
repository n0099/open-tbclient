package d.b.c.a.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes5.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f64886a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f64887a = new ArrayList(20);

        public a a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                e(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            } else if (str.startsWith(":")) {
                e("", str.substring(1));
                return this;
            } else {
                e("", str);
                return this;
            }
        }

        public a b(String str, String str2) {
            g(str, str2);
            e(str, str2);
            return this;
        }

        public v c() {
            return new v(this);
        }

        public a d(String str) {
            int i2 = 0;
            while (i2 < this.f64887a.size()) {
                if (str.equalsIgnoreCase(this.f64887a.get(i2))) {
                    this.f64887a.remove(i2);
                    this.f64887a.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public a e(String str, String str2) {
            this.f64887a.add(str);
            this.f64887a.add(str2.trim());
            return this;
        }

        public a f(String str, String str2) {
            g(str, str2);
            d(str);
            e(str, str2);
            return this;
        }

        public final void g(String str, String str2) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        char charAt = str.charAt(i2);
                        if (charAt <= ' ' || charAt >= 127) {
                            throw new IllegalArgumentException(d.b.c.a.b.a.e.j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                        }
                    }
                    if (str2 != null) {
                        int length2 = str2.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            char charAt2 = str2.charAt(i3);
                            if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                                throw new IllegalArgumentException(d.b.c.a.b.a.e.j("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i3), str, str2));
                            }
                        }
                        return;
                    }
                    throw new NullPointerException("value for name " + str + " == null");
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new NullPointerException("name == null");
        }
    }

    public v(a aVar) {
        List<String> list = aVar.f64887a;
        this.f64886a = (String[]) list.toArray(new String[list.size()]);
    }

    public static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public int a() {
        return this.f64886a.length / 2;
    }

    public String b(int i2) {
        return this.f64886a[i2 * 2];
    }

    public String c(String str) {
        return d(this.f64886a, str);
    }

    public String e(int i2) {
        return this.f64886a[(i2 * 2) + 1];
    }

    public boolean equals(Object obj) {
        return (obj instanceof v) && Arrays.equals(((v) obj).f64886a, this.f64886a);
    }

    public List<String> f(String str) {
        int a2 = a();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < a2; i2++) {
            if (str.equalsIgnoreCase(b(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(e(i2));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public Set<String> g() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int a2 = a();
        for (int i2 = 0; i2 < a2; i2++) {
            treeSet.add(b(i2));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public a h() {
        a aVar = new a();
        Collections.addAll(aVar.f64887a, this.f64886a);
        return aVar;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f64886a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a2 = a();
        for (int i2 = 0; i2 < a2; i2++) {
            sb.append(b(i2));
            sb.append(": ");
            sb.append(e(i2));
            sb.append("\n");
        }
        return sb.toString();
    }
}
