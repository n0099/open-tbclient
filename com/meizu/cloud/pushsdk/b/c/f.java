package com.meizu.cloud.pushsdk.b.c;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.searchbox.ugc.model.UgcConstant;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes8.dex */
public class f {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.meizu.cloud.pushsdk.b.c.f$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[a.EnumC0853a.values().length];

        static {
            try {
                a[a.EnumC0853a.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[a.EnumC0853a.INVALID_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[a.EnumC0853a.UNSUPPORTED_SCHEME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[a.EnumC0853a.MISSING_SCHEME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[a.EnumC0853a.INVALID_PORT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class a {
        String a;
        String d;
        List<String> g;
        String h;
        String b = "";
        String c = "";
        int e = -1;
        final List<String> f = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.meizu.cloud.pushsdk.b.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public enum EnumC0853a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            this.f.add("");
        }

        private static String a(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i4 < bArr.length) {
                int i5 = i4;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i4;
                if (i6 > i2) {
                    i2 = i6;
                    i3 = i4;
                }
                i4 = i5 + 2;
            }
            com.meizu.cloud.pushsdk.b.g.b bVar = new com.meizu.cloud.pushsdk.b.g.b();
            while (i < bArr.length) {
                if (i == i3) {
                    bVar.b(58);
                    i += i2;
                    if (i == 16) {
                        bVar.b(58);
                    }
                } else {
                    if (i > 0) {
                        bVar.b(58);
                    }
                    bVar.d(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                    i += 2;
                }
            }
            return bVar.h();
        }

        private void a(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f.clear();
                this.f.add("");
                i++;
            } else {
                this.f.set(this.f.size() - 1, "");
            }
            int i3 = i;
            while (i3 < i2) {
                int a = m.a(str, i3, i2, "/\\");
                boolean z = a < i2;
                a(str, i3, a, z, true);
                if (z) {
                    a++;
                }
                i3 = a;
            }
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a = f.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (b(a)) {
                return;
            }
            if (c(a)) {
                c();
                return;
            }
            if (this.f.get(this.f.size() - 1).isEmpty()) {
                this.f.set(this.f.size() - 1, a);
            } else {
                this.f.add(a);
            }
            if (z) {
                this.f.add("");
            }
        }

        private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i;
            int i5 = i3;
            while (i4 < i2) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i3) {
                    if (str.charAt(i4) != '.') {
                        return false;
                    }
                    i4++;
                }
                int i6 = 0;
                int i7 = i4;
                while (i7 < i2) {
                    char charAt = str.charAt(i7);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    if ((i6 != 0 || i4 == i7) && ((i6 * 10) + charAt) - 48 <= 255) {
                        i7++;
                    }
                    return false;
                }
                if (i7 - i4 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i6;
                i5++;
                i4 = i7;
            }
            return i5 == i3 + 4;
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            for (int i3 = i + 1; i3 < i2; i3++) {
                char charAt2 = str.charAt(i3);
                if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                    if (charAt2 == ':') {
                        return i3;
                    }
                    return -1;
                }
            }
            return -1;
        }

        private boolean b(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private static int c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private void c() {
            if (!this.f.remove(this.f.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
            } else {
                this.f.set(this.f.size() - 1, "");
            }
        }

        private boolean c(String str) {
            return str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static int d(String str, int i, int i2) {
            int i3 = i;
            while (i3 < i2) {
                switch (str.charAt(i3)) {
                    case ':':
                        return i3;
                    case '[':
                        break;
                    default:
                        i3++;
                }
                do {
                    i3++;
                    if (i3 < i2) {
                    }
                    i3++;
                } while (str.charAt(i3) != ']');
                i3++;
            }
            return i2;
        }

        private static String e(String str, int i, int i2) {
            String a = f.a(str, i, i2, false);
            if (a.contains(":")) {
                InetAddress f = (a.startsWith("[") && a.endsWith("]")) ? f(a, 1, a.length() - 1) : f(a, 0, a.length());
                if (f == null) {
                    return null;
                }
                byte[] address = f.getAddress();
                if (address.length == 16) {
                    return a(address);
                }
                throw new AssertionError();
            }
            return m.a(a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static InetAddress f(String str, int i, int i2) {
            int i3;
            int i4;
            byte[] bArr = new byte[16];
            int i5 = i;
            int i6 = -1;
            int i7 = -1;
            int i8 = 0;
            while (true) {
                if (i5 < i2) {
                    if (i8 != bArr.length) {
                        if (i5 + 2 <= i2 && str.regionMatches(i5, "::", 0, 2)) {
                            if (i7 == -1) {
                                i5 += 2;
                                i7 = i8 + 2;
                                if (i5 != i2) {
                                    i8 = i7;
                                    int i9 = 0;
                                    i3 = i5;
                                    while (i3 < i2) {
                                    }
                                    i4 = i3 - i5;
                                    if (i4 == 0) {
                                        break;
                                    }
                                    break;
                                }
                                i8 = i7;
                                break;
                            }
                            return null;
                        }
                        if (i8 != 0) {
                            if (!str.regionMatches(i5, ":", 0, 1)) {
                                if (str.regionMatches(i5, ".", 0, 1) && a(str, i6, i2, bArr, i8 - 2)) {
                                    i8 += 2;
                                }
                                return null;
                            }
                            i5++;
                        }
                        int i92 = 0;
                        i3 = i5;
                        while (i3 < i2) {
                            int a = f.a(str.charAt(i3));
                            if (a == -1) {
                                break;
                            }
                            i92 = (i92 << 4) + a;
                            i3++;
                        }
                        i4 = i3 - i5;
                        if (i4 == 0 || i4 > 4) {
                            break;
                        }
                        int i10 = i8 + 1;
                        bArr[i8] = (byte) ((i92 >>> 8) & 255);
                        i8 = i10 + 1;
                        bArr[i10] = (byte) (i92 & 255);
                        i6 = i5;
                        i5 = i3;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            if (i8 != bArr.length) {
                if (i7 == -1) {
                    return null;
                }
                System.arraycopy(bArr, i7, bArr, bArr.length - (i8 - i7), i8 - i7);
                Arrays.fill(bArr, i7, (bArr.length - i8) + i7, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException e) {
                throw new AssertionError();
            }
        }

        private static int g(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(f.a(str, i, i2, "", false, false, false, true));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        int a() {
            return this.e != -1 ? this.e : f.a(this.a);
        }

        EnumC0853a a(f fVar, String str) {
            int i;
            int a = m.a(str, 0, str.length());
            int b = m.b(str, a, str.length());
            if (b(str, a, b) != -1) {
                if (str.regionMatches(true, a, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                    this.a = "https";
                    a += UrlSchemaHelper.SCHEMA_TYPE_HTTPS.length();
                } else if (!str.regionMatches(true, a, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                    return EnumC0853a.UNSUPPORTED_SCHEME;
                } else {
                    this.a = HttpHost.DEFAULT_SCHEME_NAME;
                    a += UrlSchemaHelper.SCHEMA_TYPE_HTTP.length();
                }
            } else if (fVar == null) {
                return EnumC0853a.MISSING_SCHEME;
            } else {
                this.a = fVar.b;
            }
            boolean z = false;
            boolean z2 = false;
            int c = c(str, a, b);
            if (c >= 2 || fVar == null || !fVar.b.equals(this.a)) {
                int i2 = a + c;
                while (true) {
                    boolean z3 = z2;
                    boolean z4 = z;
                    int i3 = i2;
                    int a2 = m.a(str, i3, b, "@/\\?#");
                    switch (a2 != b ? str.charAt(a2) : (char) 65535) {
                        case 65535:
                        case '#':
                        case '/':
                        case '?':
                        case '\\':
                            int d = d(str, i3, a2);
                            if (d + 1 < a2) {
                                this.d = e(str, i3, d);
                                this.e = g(str, d + 1, a2);
                                if (this.e == -1) {
                                    return EnumC0853a.INVALID_PORT;
                                }
                            } else {
                                this.d = e(str, i3, d);
                                this.e = f.a(this.a);
                            }
                            if (this.d != null) {
                                a = a2;
                                break;
                            } else {
                                return EnumC0853a.INVALID_HOST;
                            }
                        case '@':
                            if (z3) {
                                this.c += "%40" + f.a(str, i3, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            } else {
                                int a3 = m.a(str, i3, a2, ':');
                                String a4 = f.a(str, i3, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (z4) {
                                    a4 = this.b + "%40" + a4;
                                }
                                this.b = a4;
                                if (a3 != a2) {
                                    z3 = true;
                                    this.c = f.a(str, a3 + 1, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                }
                                z4 = true;
                            }
                            i2 = a2 + 1;
                            z2 = z3;
                            break;
                        default:
                            z2 = z3;
                            i2 = i3;
                            break;
                    }
                    z = z4;
                }
            } else {
                this.b = fVar.b();
                this.c = fVar.c();
                this.d = fVar.e;
                this.e = fVar.f;
                this.f.clear();
                this.f.addAll(fVar.d());
                if (a == b || str.charAt(a) == '#') {
                    a(fVar.e());
                }
            }
            int a5 = m.a(str, a, b, "?#");
            a(str, a, a5);
            if (a5 >= b || str.charAt(a5) != '?') {
                i = a5;
            } else {
                i = m.a(str, a5, b, (char) UgcConstant.TOPIC_PATTERN_TAG);
                this.g = f.b(f.a(str, a5 + 1, i, " \"'<>#", true, false, true, true));
            }
            if (i < b && str.charAt(i) == '#') {
                this.h = f.a(str, i + 1, b, "", true, false, false, false);
            }
            return EnumC0853a.SUCCESS;
        }

        public a a(String str) {
            this.g = str != null ? f.b(f.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a a(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(f.a(str, " \"'<>#&=", false, false, true, true));
            this.g.add(str2 != null ? f.a(str2, " \"'<>#&=", false, false, true, true) : null);
            return this;
        }

        public f b() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.d == null) {
                throw new IllegalStateException("host == null");
            }
            return new f(this, null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("://");
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append(UgcConstant.AT_PATTERN_TAG);
            }
            if (this.d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
            int a = a();
            if (a != f.a(this.a)) {
                sb.append(':');
                sb.append(a);
            }
            f.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                f.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append(UgcConstant.TOPIC_PATTERN_TAG);
                sb.append(this.h);
            }
            return sb.toString();
        }
    }

    private f(a aVar) {
        this.b = aVar.a;
        this.c = a(aVar.b, false);
        this.d = a(aVar.c, false);
        this.e = aVar.d;
        this.f = aVar.a();
        this.g = a(aVar.f, false);
        this.h = aVar.g != null ? a(aVar.g, true) : null;
        this.i = aVar.h != null ? a(aVar.h, false) : null;
        this.j = aVar.toString();
    }

    /* synthetic */ f(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    static int a(char c) {
        if (c < '0' || c > '9') {
            if (c < 'a' || c > 'f') {
                if (c < 'A' || c > 'F') {
                    return -1;
                }
                return (c - 'A') + 10;
            }
            return (c - 'a') + 10;
        }
        return c - '0';
    }

    public static int a(String str) {
        if (str.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        if (str.equals("https")) {
            return Constants.SOCKET_PORT_SSL;
        }
        return -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !a(str, i3, i2)))) || (codePointAt == 43 && z3)))) {
                com.meizu.cloud.pushsdk.b.g.b bVar = new com.meizu.cloud.pushsdk.b.g.b();
                bVar.a(str, i, i3);
                a(bVar, str, i3, i2, str2, z, z2, z3, z4);
                return bVar.h();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                com.meizu.cloud.pushsdk.b.g.b bVar = new com.meizu.cloud.pushsdk.b.g.b();
                bVar.a(str, i, i3);
                a(bVar, str, i3, i2, z);
                return bVar.h();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? a(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void a(com.meizu.cloud.pushsdk.b.g.b bVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        com.meizu.cloud.pushsdk.b.g.b bVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    bVar.b(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i, i2)))))) {
                    if (bVar2 == null) {
                        bVar2 = new com.meizu.cloud.pushsdk.b.g.b();
                    }
                    bVar2.a(codePointAt);
                    while (!bVar2.c()) {
                        int f = bVar2.f() & 255;
                        bVar.b(37);
                        bVar.b((int) a[(f >> 4) & 15]);
                        bVar.b((int) a[f & 15]);
                    }
                } else {
                    bVar.a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static void a(com.meizu.cloud.pushsdk.b.g.b bVar, String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt != 37 || i3 + 2 >= i2) {
                if (codePointAt == 43 && z) {
                    bVar.b(32);
                }
                bVar.a(codePointAt);
            } else {
                int a2 = a(str.charAt(i3 + 1));
                int a3 = a(str.charAt(i3 + 2));
                if (a2 != -1 && a3 != -1) {
                    bVar.b((a2 << 4) + a3);
                    i3 += 2;
                }
                bVar.a(codePointAt);
            }
            i3 += Character.charCount(codePointAt);
        }
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    static boolean a(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && a(str.charAt(i + 1)) != -1 && a(str.charAt(i + 2)) != -1;
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static f c(String str) {
        a aVar = new a();
        if (aVar.a((f) null, str) == a.EnumC0853a.SUCCESS) {
            return aVar.b();
        }
        return null;
    }

    public boolean a() {
        return this.b.equals("https");
    }

    public String b() {
        if (this.c.isEmpty()) {
            return "";
        }
        int length = this.b.length() + 3;
        return this.j.substring(length, m.a(this.j, length, this.j.length(), ":@"));
    }

    public String c() {
        if (this.d.isEmpty()) {
            return "";
        }
        int indexOf = this.j.indexOf(64);
        return this.j.substring(this.j.indexOf(58, this.b.length() + 3) + 1, indexOf);
    }

    public List<String> d() {
        int indexOf = this.j.indexOf(47, this.b.length() + 3);
        int a2 = m.a(this.j, indexOf, this.j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i = indexOf + 1;
            indexOf = m.a(this.j, i, a2, '/');
            arrayList.add(this.j.substring(i, indexOf));
        }
        return arrayList;
    }

    public String e() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        return this.j.substring(indexOf, m.a(this.j, indexOf + 1, this.j.length(), (char) UgcConstant.TOPIC_PATTERN_TAG));
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((f) obj).j.equals(this.j);
    }

    public String f() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public a g() {
        a aVar = new a();
        aVar.a = this.b;
        aVar.b = b();
        aVar.c = c();
        aVar.d = this.e;
        aVar.e = this.f != a(this.b) ? this.f : -1;
        aVar.f.clear();
        aVar.f.addAll(d());
        aVar.a(e());
        aVar.h = f();
        return aVar;
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }
}
