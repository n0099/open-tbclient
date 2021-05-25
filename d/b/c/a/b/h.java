package d.b.c.a.b;

import com.baidu.android.common.others.lang.StringUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.b.c.a.b.a.e;
import java.util.concurrent.TimeUnit;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f65537a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f65538b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65539c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65540d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f65541e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f65542f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f65543g;

    /* renamed from: h  reason: collision with root package name */
    public final int f65544h;

    /* renamed from: i  reason: collision with root package name */
    public final int f65545i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public String m;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f65546a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f65547b;

        /* renamed from: c  reason: collision with root package name */
        public int f65548c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f65549d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f65550e = -1;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65551f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f65552g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f65553h;

        public a a() {
            this.f65546a = true;
            return this;
        }

        public a b(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds(i2);
                this.f65549d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i2);
        }

        public a c() {
            this.f65551f = true;
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

    public h(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        this.f65537a = z;
        this.f65538b = z2;
        this.f65539c = i2;
        this.f65540d = i3;
        this.f65541e = z3;
        this.f65542f = z4;
        this.f65543g = z5;
        this.f65544h = i4;
        this.f65545i = i5;
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
        int i2;
        int i3;
        String str;
        v vVar2 = vVar;
        int a2 = vVar.a();
        int i4 = 0;
        boolean z = true;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i5 = -1;
        int i6 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i7 = -1;
        int i8 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i4 < a2) {
            String b2 = vVar2.b(i4);
            String e2 = vVar2.e(i4);
            if (b2.equalsIgnoreCase("Cache-Control")) {
                if (str2 == null) {
                    str2 = e2;
                    for (i2 = 0; i2 < e2.length(); i2 = i3) {
                        int b3 = e.g.b(e2, i2, "=,;");
                        String trim = e2.substring(i2, b3).trim();
                        if (b3 == e2.length() || e2.charAt(b3) == ',' || e2.charAt(b3) == ';') {
                            i3 = b3 + 1;
                            str = null;
                        } else {
                            int a3 = e.g.a(e2, b3 + 1);
                            if (a3 < e2.length() && e2.charAt(a3) == '\"') {
                                int i9 = a3 + 1;
                                int b4 = e.g.b(e2, i9, "\"");
                                str = e2.substring(i9, b4);
                                i3 = b4 + 1;
                            } else {
                                i3 = e.g.b(e2, a3, ",;");
                                str = e2.substring(a3, i3).trim();
                            }
                        }
                        if ("no-cache".equalsIgnoreCase(trim)) {
                            z2 = true;
                        } else if ("no-store".equalsIgnoreCase(trim)) {
                            z3 = true;
                        } else if (ClientCookie.MAX_AGE_ATTR.equalsIgnoreCase(trim)) {
                            i5 = e.g.g(str, -1);
                        } else if ("s-maxage".equalsIgnoreCase(trim)) {
                            i6 = e.g.g(str, -1);
                        } else if (PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equalsIgnoreCase(trim)) {
                            z4 = true;
                        } else if ("public".equalsIgnoreCase(trim)) {
                            z5 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                            z6 = true;
                        } else if ("max-stale".equalsIgnoreCase(trim)) {
                            i7 = e.g.g(str, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(trim)) {
                            i8 = e.g.g(str, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                            z7 = true;
                        } else if ("no-transform".equalsIgnoreCase(trim)) {
                            z8 = true;
                        } else if ("immutable".equalsIgnoreCase(trim)) {
                            z9 = true;
                        }
                    }
                    i4++;
                    vVar2 = vVar;
                }
            } else if (!b2.equalsIgnoreCase("Pragma")) {
                i4++;
                vVar2 = vVar;
            }
            z = false;
            while (i2 < e2.length()) {
            }
            i4++;
            vVar2 = vVar;
        }
        return new h(z2, z3, i5, i6, z4, z5, z6, i7, i8, z7, z8, z9, !z ? null : str2);
    }

    public boolean b() {
        return this.f65537a;
    }

    public boolean c() {
        return this.f65538b;
    }

    public int d() {
        return this.f65539c;
    }

    public boolean e() {
        return this.f65541e;
    }

    public boolean f() {
        return this.f65542f;
    }

    public boolean g() {
        return this.f65543g;
    }

    public int h() {
        return this.f65544h;
    }

    public int i() {
        return this.f65545i;
    }

    public boolean j() {
        return this.j;
    }

    public boolean k() {
        return this.l;
    }

    public final String l() {
        StringBuilder sb = new StringBuilder();
        if (this.f65537a) {
            sb.append("no-cache, ");
        }
        if (this.f65538b) {
            sb.append("no-store, ");
        }
        if (this.f65539c != -1) {
            sb.append("max-age=");
            sb.append(this.f65539c);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f65540d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f65540d);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f65541e) {
            sb.append("private, ");
        }
        if (this.f65542f) {
            sb.append("public, ");
        }
        if (this.f65543g) {
            sb.append("must-revalidate, ");
        }
        if (this.f65544h != -1) {
            sb.append("max-stale=");
            sb.append(this.f65544h);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f65545i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f65545i);
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
        this.f65537a = aVar.f65546a;
        this.f65538b = aVar.f65547b;
        this.f65539c = aVar.f65548c;
        this.f65540d = -1;
        this.f65541e = false;
        this.f65542f = false;
        this.f65543g = false;
        this.f65544h = aVar.f65549d;
        this.f65545i = aVar.f65550e;
        this.j = aVar.f65551f;
        this.k = aVar.f65552g;
        this.l = aVar.f65553h;
    }
}
