package d.c.c.a.b;

import com.alipay.sdk.encrypt.a;
import d.c.c.a.b.a.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http.HttpDate;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes5.dex */
public final class p {
    public static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    public final String f66472a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66473b;

    /* renamed from: c  reason: collision with root package name */
    public final long f66474c;

    /* renamed from: d  reason: collision with root package name */
    public final String f66475d;

    /* renamed from: e  reason: collision with root package name */
    public final String f66476e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f66477f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f66478g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f66479h;
    public final boolean i;

    public p(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f66472a = str;
        this.f66473b = str2;
        this.f66474c = j2;
        this.f66475d = str3;
        this.f66476e = str4;
        this.f66477f = z;
        this.f66478g = z2;
        this.i = z3;
        this.f66479h = z4;
    }

    public static int a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static long b(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e2;
        }
    }

    public static long c(String str, int i, int i2) {
        int a2 = a(str, i, i2, false);
        Matcher matcher = m.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a2 < i2) {
            int a3 = a(str, a2 + 1, i2, true);
            matcher.region(a2, a3);
            if (i4 == -1 && matcher.usePattern(m).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(l).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(k).matches()) {
                i6 = k.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i3 == -1 && matcher.usePattern(j).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 >= 1601) {
            if (i6 != -1) {
                if (i5 < 1 || i5 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i4 < 0 || i4 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i7 < 0 || i7 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i8 >= 0 && i8 <= 59) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(d.c.c.a.b.a.e.o);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, i3);
                    gregorianCalendar.set(2, i6 - 1);
                    gregorianCalendar.set(5, i5);
                    gregorianCalendar.set(11, i4);
                    gregorianCalendar.set(12, i7);
                    gregorianCalendar.set(13, i8);
                    gregorianCalendar.set(14, 0);
                    return gregorianCalendar.getTimeInMillis();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static p d(long j2, com.bytedance.sdk.a.b.s sVar, String str) {
        long j3;
        String v;
        p pVar;
        String str2;
        String substring;
        int length = str.length();
        char c2 = ';';
        int c3 = d.c.c.a.b.a.e.c(str, 0, length, ';');
        char c4 = a.f1922h;
        int c5 = d.c.c.a.b.a.e.c(str, 0, c3, a.f1922h);
        if (c5 == c3) {
            return null;
        }
        String C = d.c.c.a.b.a.e.C(str, 0, c5);
        if (C.isEmpty() || d.c.c.a.b.a.e.y(C) != -1) {
            return null;
        }
        String C2 = d.c.c.a.b.a.e.C(str, c5 + 1, c3);
        if (d.c.c.a.b.a.e.y(C2) != -1) {
            return null;
        }
        int i = c3 + 1;
        String str3 = null;
        String str4 = null;
        long j4 = -1;
        long j5 = 253402300799999L;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        while (i < length) {
            int c6 = d.c.c.a.b.a.e.c(str, i, length, c2);
            int c7 = d.c.c.a.b.a.e.c(str, i, c6, c4);
            String C3 = d.c.c.a.b.a.e.C(str, i, c7);
            String C4 = c7 < c6 ? d.c.c.a.b.a.e.C(str, c7 + 1, c6) : "";
            if (C3.equalsIgnoreCase("expires")) {
                try {
                    j5 = c(C4, 0, C4.length());
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (C3.equalsIgnoreCase(ClientCookie.MAX_AGE_ATTR)) {
                j4 = b(C4);
            } else {
                if (C3.equalsIgnoreCase("domain")) {
                    str4 = k(C4);
                    z3 = false;
                } else if (C3.equalsIgnoreCase("path")) {
                    str3 = C4;
                } else if (C3.equalsIgnoreCase(ClientCookie.SECURE_ATTR)) {
                    z = true;
                } else if (C3.equalsIgnoreCase("httponly")) {
                    z2 = true;
                }
                i = c6 + 1;
                c2 = ';';
                c4 = a.f1922h;
            }
            z4 = true;
            i = c6 + 1;
            c2 = ';';
            c4 = a.f1922h;
        }
        long j6 = Long.MIN_VALUE;
        if (j4 != Long.MIN_VALUE) {
            if (j4 != -1) {
                j6 = j2 + (j4 <= 9223372036854775L ? j4 * 1000 : Long.MAX_VALUE);
                if (j6 < j2 || j6 > HttpDate.MAX_DATE) {
                    j3 = 253402300799999L;
                }
            } else {
                j3 = j5;
            }
            v = sVar.v();
            if (str4 != null) {
                str2 = v;
                pVar = null;
            } else if (!i(v, str4)) {
                return null;
            } else {
                pVar = null;
                str2 = str4;
            }
            if (v.length() == str2.length() && d.c.c.a.b.a.j.a.a().b(str2) == null) {
                return pVar;
            }
            if (str3 == null && str3.startsWith("/")) {
                substring = str3;
            } else {
                String x = sVar.x();
                int lastIndexOf = x.lastIndexOf(47);
                substring = lastIndexOf != 0 ? x.substring(0, lastIndexOf) : "/";
            }
            return new p(C, C2, j3, str2, substring, z, z2, z3, z4);
        }
        j3 = j6;
        v = sVar.v();
        if (str4 != null) {
        }
        if (v.length() == str2.length()) {
        }
        if (str3 == null) {
        }
        String x2 = sVar.x();
        int lastIndexOf2 = x2.lastIndexOf(47);
        substring = lastIndexOf2 != 0 ? x2.substring(0, lastIndexOf2) : "/";
        return new p(C, C2, j3, str2, substring, z, z2, z3, z4);
    }

    public static p e(com.bytedance.sdk.a.b.s sVar, String str) {
        return d(System.currentTimeMillis(), sVar, str);
    }

    public static List<p> h(com.bytedance.sdk.a.b.s sVar, v vVar) {
        List<String> f2 = vVar.f("Set-Cookie");
        int size = f2.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            p e2 = e(sVar, f2.get(i));
            if (e2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(e2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public static boolean i(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !d.c.c.a.b.a.e.D(str);
    }

    public static String k(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String i = d.c.c.a.b.a.e.i(str);
            if (i != null) {
                return i;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            p pVar = (p) obj;
            return pVar.f66472a.equals(this.f66472a) && pVar.f66473b.equals(this.f66473b) && pVar.f66475d.equals(this.f66475d) && pVar.f66476e.equals(this.f66476e) && pVar.f66474c == this.f66474c && pVar.f66477f == this.f66477f && pVar.f66478g == this.f66478g && pVar.f66479h == this.f66479h && pVar.i == this.i;
        }
        return false;
    }

    public String f() {
        return this.f66472a;
    }

    public String g(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f66472a);
        sb.append(a.f1922h);
        sb.append(this.f66473b);
        if (this.f66479h) {
            if (this.f66474c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(e.f.a(new Date(this.f66474c)));
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f66475d);
        }
        sb.append("; path=");
        sb.append(this.f66476e);
        if (this.f66477f) {
            sb.append("; secure");
        }
        if (this.f66478g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public int hashCode() {
        long j2 = this.f66474c;
        return ((((((((((((((((527 + this.f66472a.hashCode()) * 31) + this.f66473b.hashCode()) * 31) + this.f66475d.hashCode()) * 31) + this.f66476e.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f66477f ? 1 : 0)) * 31) + (!this.f66478g ? 1 : 0)) * 31) + (!this.f66479h ? 1 : 0)) * 31) + (!this.i ? 1 : 0);
    }

    public String j() {
        return this.f66473b;
    }

    public String toString() {
        return g(false);
    }
}
