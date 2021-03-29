package d.c.c.a.b;

import com.baidu.android.common.others.lang.StringUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.c.c.a.b.a.e;
import java.util.concurrent.TimeUnit;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f65480a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f65481b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65482c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65483d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f65484e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f65485f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f65486g;

    /* renamed from: h  reason: collision with root package name */
    public final int f65487h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public String m;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f65488a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f65489b;

        /* renamed from: c  reason: collision with root package name */
        public int f65490c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f65491d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f65492e = -1;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65493f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f65494g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f65495h;

        public a a() {
            this.f65488a = true;
            return this;
        }

        public a b(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f65491d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public a c() {
            this.f65493f = true;
            return this;
        }

        public h d() {
            return new h(this);
        }
    }

    static {
        a aVar = new a();
        aVar.a();
        aVar.d();
        a aVar2 = new a();
        aVar2.c();
        aVar2.b(Integer.MAX_VALUE, TimeUnit.SECONDS);
        aVar2.d();
    }

    public h(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f65480a = z;
        this.f65481b = z2;
        this.f65482c = i;
        this.f65483d = i2;
        this.f65484e = z3;
        this.f65485f = z4;
        this.f65486g = z5;
        this.f65487h = i3;
        this.i = i4;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static h a(v vVar) {
        int i;
        int i2;
        String str;
        v vVar2 = vVar;
        int a2 = vVar.a();
        int i3 = 0;
        boolean z = true;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i4 = -1;
        int i5 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i6 = -1;
        int i7 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i3 < a2) {
            String b2 = vVar2.b(i3);
            String e2 = vVar2.e(i3);
            if (b2.equalsIgnoreCase("Cache-Control")) {
                if (str2 == null) {
                    str2 = e2;
                    for (i = 0; i < e2.length(); i = i2) {
                        int b3 = e.g.b(e2, i, "=,;");
                        String trim = e2.substring(i, b3).trim();
                        if (b3 == e2.length() || e2.charAt(b3) == ',' || e2.charAt(b3) == ';') {
                            i2 = b3 + 1;
                            str = null;
                        } else {
                            int a3 = e.g.a(e2, b3 + 1);
                            if (a3 < e2.length() && e2.charAt(a3) == '\"') {
                                int i8 = a3 + 1;
                                int b4 = e.g.b(e2, i8, "\"");
                                str = e2.substring(i8, b4);
                                i2 = b4 + 1;
                            } else {
                                i2 = e.g.b(e2, a3, ",;");
                                str = e2.substring(a3, i2).trim();
                            }
                        }
                        if ("no-cache".equalsIgnoreCase(trim)) {
                            z2 = true;
                        } else if ("no-store".equalsIgnoreCase(trim)) {
                            z3 = true;
                        } else if (ClientCookie.MAX_AGE_ATTR.equalsIgnoreCase(trim)) {
                            i4 = e.g.g(str, -1);
                        } else if ("s-maxage".equalsIgnoreCase(trim)) {
                            i5 = e.g.g(str, -1);
                        } else if (PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equalsIgnoreCase(trim)) {
                            z4 = true;
                        } else if ("public".equalsIgnoreCase(trim)) {
                            z5 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                            z6 = true;
                        } else if ("max-stale".equalsIgnoreCase(trim)) {
                            i6 = e.g.g(str, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(trim)) {
                            i7 = e.g.g(str, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                            z7 = true;
                        } else if ("no-transform".equalsIgnoreCase(trim)) {
                            z8 = true;
                        } else if ("immutable".equalsIgnoreCase(trim)) {
                            z9 = true;
                        }
                    }
                    i3++;
                    vVar2 = vVar;
                }
            } else if (!b2.equalsIgnoreCase("Pragma")) {
                i3++;
                vVar2 = vVar;
            }
            z = false;
            while (i < e2.length()) {
            }
            i3++;
            vVar2 = vVar;
        }
        return new h(z2, z3, i4, i5, z4, z5, z6, i6, i7, z7, z8, z9, !z ? null : str2);
    }

    public boolean b() {
        return this.f65480a;
    }

    public boolean c() {
        return this.f65481b;
    }

    public int d() {
        return this.f65482c;
    }

    public boolean e() {
        return this.f65484e;
    }

    public boolean f() {
        return this.f65485f;
    }

    public boolean g() {
        return this.f65486g;
    }

    public int h() {
        return this.f65487h;
    }

    public int i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }

    public boolean k() {
        return this.l;
    }

    public final String l() {
        StringBuilder sb = new StringBuilder();
        if (this.f65480a) {
            sb.append("no-cache, ");
        }
        if (this.f65481b) {
            sb.append("no-store, ");
        }
        if (this.f65482c != -1) {
            sb.append("max-age=");
            sb.append(this.f65482c);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f65483d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f65483d);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f65484e) {
            sb.append("private, ");
        }
        if (this.f65485f) {
            sb.append("public, ");
        }
        if (this.f65486g) {
            sb.append("must-revalidate, ");
        }
        if (this.f65487h != -1) {
            sb.append("max-stale=");
            sb.append(this.f65487h);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.i != -1) {
            sb.append("min-fresh=");
            sb.append(this.i);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        String l = l();
        this.m = l;
        return l;
    }

    public h(a aVar) {
        this.f65480a = aVar.f65488a;
        this.f65481b = aVar.f65489b;
        this.f65482c = aVar.f65490c;
        this.f65483d = -1;
        this.f65484e = false;
        this.f65485f = false;
        this.f65486g = false;
        this.f65487h = aVar.f65491d;
        this.i = aVar.f65492e;
        this.j = aVar.f65493f;
        this.k = aVar.f65494g;
        this.l = aVar.f65495h;
    }
}
