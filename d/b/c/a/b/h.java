package d.b.c.a.b;

import com.baidu.android.common.others.lang.StringUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.b.c.a.b.a.e;
import java.util.concurrent.TimeUnit;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f69372a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f69373b;

    /* renamed from: c  reason: collision with root package name */
    public final int f69374c;

    /* renamed from: d  reason: collision with root package name */
    public final int f69375d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f69376e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f69377f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f69378g;

    /* renamed from: h  reason: collision with root package name */
    public final int f69379h;

    /* renamed from: i  reason: collision with root package name */
    public final int f69380i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public String m;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f69381a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f69382b;

        /* renamed from: c  reason: collision with root package name */
        public int f69383c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f69384d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f69385e = -1;

        /* renamed from: f  reason: collision with root package name */
        public boolean f69386f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f69387g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f69388h;

        public a a() {
            this.f69381a = true;
            return this;
        }

        public a b(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds(i2);
                this.f69384d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i2);
        }

        public a c() {
            this.f69386f = true;
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
        this.f69372a = z;
        this.f69373b = z2;
        this.f69374c = i2;
        this.f69375d = i3;
        this.f69376e = z3;
        this.f69377f = z4;
        this.f69378g = z5;
        this.f69379h = i4;
        this.f69380i = i5;
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
        return this.f69372a;
    }

    public boolean c() {
        return this.f69373b;
    }

    public int d() {
        return this.f69374c;
    }

    public boolean e() {
        return this.f69376e;
    }

    public boolean f() {
        return this.f69377f;
    }

    public boolean g() {
        return this.f69378g;
    }

    public int h() {
        return this.f69379h;
    }

    public int i() {
        return this.f69380i;
    }

    public boolean j() {
        return this.j;
    }

    public boolean k() {
        return this.l;
    }

    public final String l() {
        StringBuilder sb = new StringBuilder();
        if (this.f69372a) {
            sb.append("no-cache, ");
        }
        if (this.f69373b) {
            sb.append("no-store, ");
        }
        if (this.f69374c != -1) {
            sb.append("max-age=");
            sb.append(this.f69374c);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f69375d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f69375d);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f69376e) {
            sb.append("private, ");
        }
        if (this.f69377f) {
            sb.append("public, ");
        }
        if (this.f69378g) {
            sb.append("must-revalidate, ");
        }
        if (this.f69379h != -1) {
            sb.append("max-stale=");
            sb.append(this.f69379h);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        if (this.f69380i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f69380i);
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
        this.f69372a = aVar.f69381a;
        this.f69373b = aVar.f69382b;
        this.f69374c = aVar.f69383c;
        this.f69375d = -1;
        this.f69376e = false;
        this.f69377f = false;
        this.f69378g = false;
        this.f69379h = aVar.f69384d;
        this.f69380i = aVar.f69385e;
        this.j = aVar.f69386f;
        this.k = aVar.f69387g;
        this.l = aVar.f69388h;
    }
}
