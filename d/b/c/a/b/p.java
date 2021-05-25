package d.b.c.a.b;

import com.alipay.sdk.encrypt.a;
import d.b.c.a.b.a.e;
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
/* loaded from: classes6.dex */
public final class p {
    public static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    public final String f65591a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65592b;

    /* renamed from: c  reason: collision with root package name */
    public final long f65593c;

    /* renamed from: d  reason: collision with root package name */
    public final String f65594d;

    /* renamed from: e  reason: collision with root package name */
    public final String f65595e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f65596f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f65597g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f65598h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f65599i;

    public p(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f65591a = str;
        this.f65592b = str2;
        this.f65593c = j2;
        this.f65594d = str3;
        this.f65595e = str4;
        this.f65596f = z;
        this.f65597g = z2;
        this.f65599i = z3;
        this.f65598h = z4;
    }

    public static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
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

    public static long c(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = m.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(m).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
                i8 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(l).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(k).matches()) {
                i7 = k.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(j).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 >= 1601) {
            if (i7 != -1) {
                if (i6 < 1 || i6 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i5 < 0 || i5 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i8 < 0 || i8 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i9 >= 0 && i9 <= 59) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(d.b.c.a.b.a.e.o);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, i4);
                    gregorianCalendar.set(2, i7 - 1);
                    gregorianCalendar.set(5, i6);
                    gregorianCalendar.set(11, i5);
                    gregorianCalendar.set(12, i8);
                    gregorianCalendar.set(13, i9);
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
        int c3 = d.b.c.a.b.a.e.c(str, 0, length, ';');
        char c4 = a.f1873h;
        int c5 = d.b.c.a.b.a.e.c(str, 0, c3, a.f1873h);
        if (c5 == c3) {
            return null;
        }
        String C = d.b.c.a.b.a.e.C(str, 0, c5);
        if (C.isEmpty() || d.b.c.a.b.a.e.y(C) != -1) {
            return null;
        }
        String C2 = d.b.c.a.b.a.e.C(str, c5 + 1, c3);
        if (d.b.c.a.b.a.e.y(C2) != -1) {
            return null;
        }
        int i2 = c3 + 1;
        String str3 = null;
        String str4 = null;
        long j4 = -1;
        long j5 = 253402300799999L;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        while (i2 < length) {
            int c6 = d.b.c.a.b.a.e.c(str, i2, length, c2);
            int c7 = d.b.c.a.b.a.e.c(str, i2, c6, c4);
            String C3 = d.b.c.a.b.a.e.C(str, i2, c7);
            String C4 = c7 < c6 ? d.b.c.a.b.a.e.C(str, c7 + 1, c6) : "";
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
                i2 = c6 + 1;
                c2 = ';';
                c4 = a.f1873h;
            }
            z4 = true;
            i2 = c6 + 1;
            c2 = ';';
            c4 = a.f1873h;
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
            if (v.length() == str2.length() && d.b.c.a.b.a.j.a.a().b(str2) == null) {
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
        for (int i2 = 0; i2 < size; i2++) {
            p e2 = e(sVar, f2.get(i2));
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
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !d.b.c.a.b.a.e.D(str);
    }

    public static String k(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String i2 = d.b.c.a.b.a.e.i(str);
            if (i2 != null) {
                return i2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            p pVar = (p) obj;
            return pVar.f65591a.equals(this.f65591a) && pVar.f65592b.equals(this.f65592b) && pVar.f65594d.equals(this.f65594d) && pVar.f65595e.equals(this.f65595e) && pVar.f65593c == this.f65593c && pVar.f65596f == this.f65596f && pVar.f65597g == this.f65597g && pVar.f65598h == this.f65598h && pVar.f65599i == this.f65599i;
        }
        return false;
    }

    public String f() {
        return this.f65591a;
    }

    public String g(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f65591a);
        sb.append(a.f1873h);
        sb.append(this.f65592b);
        if (this.f65598h) {
            if (this.f65593c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(e.f.a(new Date(this.f65593c)));
            }
        }
        if (!this.f65599i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f65594d);
        }
        sb.append("; path=");
        sb.append(this.f65595e);
        if (this.f65596f) {
            sb.append("; secure");
        }
        if (this.f65597g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public int hashCode() {
        long j2 = this.f65593c;
        return ((((((((((((((((527 + this.f65591a.hashCode()) * 31) + this.f65592b.hashCode()) * 31) + this.f65594d.hashCode()) * 31) + this.f65595e.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f65596f ? 1 : 0)) * 31) + (!this.f65597g ? 1 : 0)) * 31) + (!this.f65598h ? 1 : 0)) * 31) + (!this.f65599i ? 1 : 0);
    }

    public String j() {
        return this.f65592b;
    }

    public String toString() {
        return g(false);
    }
}
