package com.meizu.cloud.pushsdk.b.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f34664a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f34665a = new ArrayList(20);

        private void c(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("value == null");
            }
            int length2 = str2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                char charAt2 = str2.charAt(i3);
                if (charAt2 <= 31 || charAt2 >= 127) {
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i3), str, str2));
                }
            }
        }

        public a a(String str, String str2) {
            c(str, str2);
            return b(str, str2);
        }

        public c a() {
            return new c(this);
        }

        public a b(String str, String str2) {
            this.f34665a.add(str);
            this.f34665a.add(str2.trim());
            return this;
        }
    }

    public c(a aVar) {
        this.f34664a = (String[]) aVar.f34665a.toArray(new String[aVar.f34665a.size()]);
    }

    public c(String[] strArr) {
        this.f34664a = strArr;
    }

    public static c a(String... strArr) {
        if (strArr == null || strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i2 = 0; i2 < strArr2.length; i2++) {
            if (strArr2[i2] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i2] = strArr2[i2].trim();
        }
        for (int i3 = 0; i3 < strArr2.length; i3 += 2) {
            String str = strArr2[i3];
            String str2 = strArr2[i3 + 1];
            if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            }
        }
        return new c(strArr2);
    }

    public static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public int a() {
        return this.f34664a.length / 2;
    }

    public String a(int i2) {
        return this.f34664a[i2 * 2];
    }

    public String a(String str) {
        return a(this.f34664a, str);
    }

    public String b(int i2) {
        return this.f34664a[(i2 * 2) + 1];
    }

    public Set<String> b() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int a2 = a();
        for (int i2 = 0; i2 < a2; i2++) {
            treeSet.add(a(i2));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public a c() {
        a aVar = new a();
        Collections.addAll(aVar.f34665a, this.f34664a);
        return aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a2 = a();
        for (int i2 = 0; i2 < a2; i2++) {
            sb.append(a(i2));
            sb.append(": ");
            sb.append(b(i2));
            sb.append("\n");
        }
        return sb.toString();
    }
}
