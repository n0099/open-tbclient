package com.meizu.cloud.pushsdk.b.c;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.google.android.material.badge.BadgeDrawable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes3.dex */
public class f {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    public final String f60833b;

    /* renamed from: c  reason: collision with root package name */
    public final String f60834c;

    /* renamed from: d  reason: collision with root package name */
    public final String f60835d;

    /* renamed from: e  reason: collision with root package name */
    public final String f60836e;

    /* renamed from: f  reason: collision with root package name */
    public final int f60837f;

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f60838g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f60839h;

    /* renamed from: i  reason: collision with root package name */
    public final String f60840i;

    /* renamed from: j  reason: collision with root package name */
    public final String f60841j;

    /* renamed from: com.meizu.cloud.pushsdk.b.c.f$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.EnumC2144a.values().length];
            a = iArr;
            try {
                iArr[a.EnumC2144a.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.EnumC2144a.INVALID_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.EnumC2144a.UNSUPPORTED_SCHEME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a.EnumC2144a.MISSING_SCHEME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[a.EnumC2144a.INVALID_PORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public String a;

        /* renamed from: d  reason: collision with root package name */
        public String f60844d;

        /* renamed from: f  reason: collision with root package name */
        public final List<String> f60846f;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f60847g;

        /* renamed from: h  reason: collision with root package name */
        public String f60848h;

        /* renamed from: b  reason: collision with root package name */
        public String f60842b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f60843c = "";

        /* renamed from: e  reason: collision with root package name */
        public int f60845e = -1;

        /* renamed from: com.meizu.cloud.pushsdk.b.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public enum EnumC2144a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f60846f = arrayList;
            arrayList.add("");
        }

        public static String a(byte[] bArr) {
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            int i5 = 0;
            while (i4 < bArr.length) {
                int i6 = i4;
                while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                    i6 += 2;
                }
                int i7 = i6 - i4;
                if (i7 > i5) {
                    i3 = i4;
                    i5 = i7;
                }
                i4 = i6 + 2;
            }
            com.meizu.cloud.pushsdk.b.g.b bVar = new com.meizu.cloud.pushsdk.b.g.b();
            while (i2 < bArr.length) {
                if (i2 == i3) {
                    bVar.b(58);
                    i2 += i5;
                    if (i2 == 16) {
                        bVar.b(58);
                    }
                } else {
                    if (i2 > 0) {
                        bVar.b(58);
                    }
                    bVar.d(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                    i2 += 2;
                }
            }
            return bVar.h();
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.f60846f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f60846f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f60846f
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = com.meizu.cloud.pushsdk.b.c.m.a(r11, r6, r13, r12)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.b.c.f.a.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i2, int i3, boolean z, boolean z2) {
            String a = f.a(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (b(a)) {
                return;
            }
            if (c(a)) {
                c();
                return;
            }
            List<String> list = this.f60846f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f60846f;
                list2.set(list2.size() - 1, a);
            } else {
                this.f60846f.add(a);
            }
            if (z) {
                this.f60846f.add("");
            }
        }

        public static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
            int i5 = i4;
            while (i2 < i3) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i4) {
                    if (str.charAt(i2) != '.') {
                        return false;
                    }
                    i2++;
                }
                int i6 = i2;
                int i7 = 0;
                while (i6 < i3) {
                    char charAt = str.charAt(i6);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i6++;
                    }
                }
                if (i6 - i2 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i7;
                i5++;
                i2 = i6;
            }
            return i5 == i4 + 4;
        }

        public static int b(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private boolean b(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public static int c(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        private void c() {
            List<String> list = this.f60846f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f60846f.isEmpty()) {
                this.f60846f.add("");
                return;
            }
            List<String> list2 = this.f60846f;
            list2.set(list2.size() - 1, "");
        }

        private boolean c(String str) {
            return str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public static int d(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 < i3) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        public static String e(String str, int i2, int i3) {
            String a = f.a(str, i2, i3, false);
            if (a.contains(":")) {
                InetAddress f2 = (a.startsWith(PreferencesUtil.LEFT_MOUNT) && a.endsWith(PreferencesUtil.RIGHT_MOUNT)) ? f(a, 1, a.length() - 1) : f(a, 0, a.length());
                if (f2 == null) {
                    return null;
                }
                byte[] address = f2.getAddress();
                if (address.length == 16) {
                    return a(address);
                }
                throw new AssertionError();
            }
            return m.a(a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static InetAddress f(String str, int i2, int i3) {
            int i4;
            byte[] bArr = new byte[16];
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (true) {
                if (i2 < i3) {
                    if (i5 != 16) {
                        int i8 = i2 + 2;
                        if (i8 <= i3 && str.regionMatches(i2, "::", 0, 2)) {
                            if (i6 == -1) {
                                i5 += 2;
                                i6 = i5;
                                if (i8 != i3) {
                                    i7 = i8;
                                    i2 = i7;
                                    int i9 = 0;
                                    while (i2 < i3) {
                                    }
                                    i4 = i2 - i7;
                                    if (i4 == 0) {
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            return null;
                        }
                        if (i5 != 0) {
                            if (str.regionMatches(i2, ":", 0, 1)) {
                                i2++;
                            } else if (!str.regionMatches(i2, ".", 0, 1) || !a(str, i7, i3, bArr, i5 - 2)) {
                                return null;
                            } else {
                                i5 += 2;
                            }
                        }
                        i7 = i2;
                        i2 = i7;
                        int i92 = 0;
                        while (i2 < i3) {
                            int a = f.a(str.charAt(i2));
                            if (a == -1) {
                                break;
                            }
                            i92 = (i92 << 4) + a;
                            i2++;
                        }
                        i4 = i2 - i7;
                        if (i4 == 0 || i4 > 4) {
                            break;
                        }
                        int i10 = i5 + 1;
                        bArr[i5] = (byte) ((i92 >>> 8) & 255);
                        i5 = i10 + 1;
                        bArr[i10] = (byte) (i92 & 255);
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            if (i5 != 16) {
                if (i6 == -1) {
                    return null;
                }
                int i11 = i5 - i6;
                System.arraycopy(bArr, i6, bArr, 16 - i11, i11);
                Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }

        public static int g(String str, int i2, int i3) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(f.a(str, i2, i3, "", false, false, false, true));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public int a() {
            int i2 = this.f60845e;
            return i2 != -1 ? i2 : f.a(this.a);
        }

        public EnumC2144a a(f fVar, String str) {
            int a;
            int i2;
            int a2 = m.a(str, 0, str.length());
            int b2 = m.b(str, a2, str.length());
            if (b(str, a2, b2) != -1) {
                if (str.regionMatches(true, a2, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                    this.a = "https";
                    a2 += 6;
                } else if (!str.regionMatches(true, a2, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                    return EnumC2144a.UNSUPPORTED_SCHEME;
                } else {
                    this.a = "http";
                    a2 += 5;
                }
            } else if (fVar == null) {
                return EnumC2144a.MISSING_SCHEME;
            } else {
                this.a = fVar.f60833b;
            }
            int c2 = c(str, a2, b2);
            char c3 = '?';
            char c4 = '#';
            if (c2 >= 2 || fVar == null || !fVar.f60833b.equals(this.a)) {
                int i3 = a2 + c2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = m.a(str, i3, b2, "@/\\?#");
                    char charAt = a != b2 ? str.charAt(a) : (char) 65535;
                    if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z) {
                            i2 = a;
                            this.f60843c += "%40" + f.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        } else {
                            int a3 = m.a(str, i3, a, ':');
                            i2 = a;
                            String a4 = f.a(str, i3, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (z2) {
                                a4 = this.f60842b + "%40" + a4;
                            }
                            this.f60842b = a4;
                            if (a3 != i2) {
                                this.f60843c = f.a(str, a3 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                z = true;
                            }
                            z2 = true;
                        }
                        i3 = i2 + 1;
                    }
                    c3 = '?';
                    c4 = '#';
                }
                int d2 = d(str, i3, a);
                int i4 = d2 + 1;
                this.f60844d = e(str, i3, d2);
                if (i4 < a) {
                    int g2 = g(str, i4, a);
                    this.f60845e = g2;
                    if (g2 == -1) {
                        return EnumC2144a.INVALID_PORT;
                    }
                } else {
                    this.f60845e = f.a(this.a);
                }
                if (this.f60844d == null) {
                    return EnumC2144a.INVALID_HOST;
                }
                a2 = a;
            } else {
                this.f60842b = fVar.b();
                this.f60843c = fVar.c();
                this.f60844d = fVar.f60836e;
                this.f60845e = fVar.f60837f;
                this.f60846f.clear();
                this.f60846f.addAll(fVar.d());
                if (a2 == b2 || str.charAt(a2) == '#') {
                    a(fVar.e());
                }
            }
            int a5 = m.a(str, a2, b2, "?#");
            a(str, a2, a5);
            if (a5 < b2 && str.charAt(a5) == '?') {
                int a6 = m.a(str, a5, b2, '#');
                this.f60847g = f.b(f.a(str, a5 + 1, a6, " \"'<>#", true, false, true, true));
                a5 = a6;
            }
            if (a5 < b2 && str.charAt(a5) == '#') {
                this.f60848h = f.a(str, 1 + a5, b2, "", true, false, false, false);
            }
            return EnumC2144a.SUCCESS;
        }

        public a a(String str) {
            this.f60847g = str != null ? f.b(f.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a a(String str, String str2) {
            if (str != null) {
                if (this.f60847g == null) {
                    this.f60847g = new ArrayList();
                }
                this.f60847g.add(f.a(str, " \"'<>#&=", false, false, true, true));
                this.f60847g.add(str2 != null ? f.a(str2, " \"'<>#&=", false, false, true, true) : null);
                return this;
            }
            throw new IllegalArgumentException("name == null");
        }

        public f b() {
            if (this.a != null) {
                if (this.f60844d != null) {
                    return new f(this, null);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("://");
            if (!this.f60842b.isEmpty() || !this.f60843c.isEmpty()) {
                sb.append(this.f60842b);
                if (!this.f60843c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f60843c);
                }
                sb.append('@');
            }
            if (this.f60844d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f60844d);
                sb.append(']');
            } else {
                sb.append(this.f60844d);
            }
            int a = a();
            if (a != f.a(this.a)) {
                sb.append(':');
                sb.append(a);
            }
            f.a(sb, this.f60846f);
            if (this.f60847g != null) {
                sb.append('?');
                f.b(sb, this.f60847g);
            }
            if (this.f60848h != null) {
                sb.append('#');
                sb.append(this.f60848h);
            }
            return sb.toString();
        }
    }

    public f(a aVar) {
        this.f60833b = aVar.a;
        this.f60834c = a(aVar.f60842b, false);
        this.f60835d = a(aVar.f60843c, false);
        this.f60836e = aVar.f60844d;
        this.f60837f = aVar.a();
        this.f60838g = a(aVar.f60846f, false);
        List<String> list = aVar.f60847g;
        this.f60839h = list != null ? a(list, true) : null;
        String str = aVar.f60848h;
        this.f60840i = str != null ? a(str, false) : null;
        this.f60841j = aVar.toString();
    }

    public /* synthetic */ f(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return -1;
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return Constants.SOCKET_PORT_SSL;
        }
        return -1;
    }

    public static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            com.meizu.cloud.pushsdk.b.g.b bVar = new com.meizu.cloud.pushsdk.b.g.b();
            bVar.a(str, i2, i4);
            a(bVar, str, i4, i3, str2, z, z2, z3, z4);
            return bVar.h();
        }
        return str.substring(i2, i3);
    }

    public static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                com.meizu.cloud.pushsdk.b.g.b bVar = new com.meizu.cloud.pushsdk.b.g.b();
                bVar.a(str, i2, i4);
                a(bVar, str, i4, i3, z);
                return bVar.h();
            }
        }
        return str.substring(i2, i3);
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    public static String a(String str, boolean z) {
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

    public static void a(com.meizu.cloud.pushsdk.b.g.b bVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        com.meizu.cloud.pushsdk.b.g.b bVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    bVar.b(z ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i2, i3)))))) {
                    if (bVar2 == null) {
                        bVar2 = new com.meizu.cloud.pushsdk.b.g.b();
                    }
                    bVar2.a(codePointAt);
                    while (!bVar2.c()) {
                        int f2 = bVar2.f() & 255;
                        bVar.b(37);
                        bVar.b((int) a[(f2 >> 4) & 15]);
                        bVar.b((int) a[f2 & 15]);
                    }
                } else {
                    bVar.a(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static void a(com.meizu.cloud.pushsdk.b.g.b bVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt != 37 || (i4 = i2 + 2) >= i3) {
                if (codePointAt == 43 && z) {
                    bVar.b(32);
                }
                bVar.a(codePointAt);
            } else {
                int a2 = a(str.charAt(i2 + 1));
                int a3 = a(str.charAt(i4));
                if (a2 != -1 && a3 != -1) {
                    bVar.b((a2 << 4) + a3);
                    i2 = i4;
                }
                bVar.a(codePointAt);
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && a(str.charAt(i2 + 1)) != -1 && a(str.charAt(i4)) != -1;
    }

    public static List<String> b(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(com.alipay.sdk.encrypt.a.f31721h);
                sb.append(str2);
            }
        }
    }

    public static f c(String str) {
        a aVar = new a();
        if (aVar.a((f) null, str) == a.EnumC2144a.SUCCESS) {
            return aVar.b();
        }
        return null;
    }

    public boolean a() {
        return this.f60833b.equals("https");
    }

    public String b() {
        if (this.f60834c.isEmpty()) {
            return "";
        }
        int length = this.f60833b.length() + 3;
        String str = this.f60841j;
        return this.f60841j.substring(length, m.a(str, length, str.length(), ":@"));
    }

    public String c() {
        if (this.f60835d.isEmpty()) {
            return "";
        }
        int indexOf = this.f60841j.indexOf(64);
        return this.f60841j.substring(this.f60841j.indexOf(58, this.f60833b.length() + 3) + 1, indexOf);
    }

    public List<String> d() {
        int indexOf = this.f60841j.indexOf(47, this.f60833b.length() + 3);
        String str = this.f60841j;
        int a2 = m.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = m.a(this.f60841j, i2, a2, '/');
            arrayList.add(this.f60841j.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String e() {
        if (this.f60839h == null) {
            return null;
        }
        int indexOf = this.f60841j.indexOf(63) + 1;
        String str = this.f60841j;
        return this.f60841j.substring(indexOf, m.a(str, indexOf + 1, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((f) obj).f60841j.equals(this.f60841j);
    }

    public String f() {
        if (this.f60840i == null) {
            return null;
        }
        return this.f60841j.substring(this.f60841j.indexOf(35) + 1);
    }

    public a g() {
        a aVar = new a();
        aVar.a = this.f60833b;
        aVar.f60842b = b();
        aVar.f60843c = c();
        aVar.f60844d = this.f60836e;
        aVar.f60845e = this.f60837f != a(this.f60833b) ? this.f60837f : -1;
        aVar.f60846f.clear();
        aVar.f60846f.addAll(d());
        aVar.a(e());
        aVar.f60848h = f();
        return aVar;
    }

    public int hashCode() {
        return this.f60841j.hashCode();
    }

    public String toString() {
        return this.f60841j;
    }
}
