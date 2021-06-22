package d.b.c.a.b;

import com.baidu.tbadk.core.util.UrlSchemaHelper;
import d.b.c.a.b.a.e;
import d.b.c.a.b.v;
import java.net.URL;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes6.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.s f69326a;

    /* renamed from: b  reason: collision with root package name */
    public final String f69327b;

    /* renamed from: c  reason: collision with root package name */
    public final v f69328c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f69329d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f69330e;

    /* renamed from: f  reason: collision with root package name */
    public volatile h f69331f;

    public a0(a aVar) {
        this.f69326a = aVar.f69332a;
        this.f69327b = aVar.f69333b;
        this.f69328c = aVar.f69334c.c();
        this.f69329d = aVar.f69335d;
        Object obj = aVar.f69336e;
        this.f69330e = obj == null ? this : obj;
    }

    public com.bytedance.sdk.a.b.s a() {
        return this.f69326a;
    }

    public String b(String str) {
        return this.f69328c.c(str);
    }

    public String c() {
        return this.f69327b;
    }

    public v d() {
        return this.f69328c;
    }

    public b0 e() {
        return this.f69329d;
    }

    public a f() {
        return new a(this);
    }

    public h g() {
        h hVar = this.f69331f;
        if (hVar != null) {
            return hVar;
        }
        h a2 = h.a(this.f69328c);
        this.f69331f = a2;
        return a2;
    }

    public boolean h() {
        return this.f69326a.q();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f69327b);
        sb.append(", url=");
        sb.append(this.f69326a);
        sb.append(", tag=");
        Object obj = this.f69330e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.a.b.s f69332a;

        /* renamed from: b  reason: collision with root package name */
        public String f69333b;

        /* renamed from: c  reason: collision with root package name */
        public v.a f69334c;

        /* renamed from: d  reason: collision with root package name */
        public b0 f69335d;

        /* renamed from: e  reason: collision with root package name */
        public Object f69336e;

        public a() {
            this.f69333b = "GET";
            this.f69334c = new v.a();
        }

        public a a() {
            f("GET", null);
            return this;
        }

        public a b(v vVar) {
            this.f69334c = vVar.h();
            return this;
        }

        public a c(com.bytedance.sdk.a.b.s sVar) {
            if (sVar != null) {
                this.f69332a = sVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a d(b0 b0Var) {
            f("POST", b0Var);
            return this;
        }

        public a e(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
                }
                com.bytedance.sdk.a.b.s t = com.bytedance.sdk.a.b.s.t(str);
                if (t != null) {
                    c(t);
                    return this;
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new NullPointerException("url == null");
        }

        public a f(String str, b0 b0Var) {
            if (str != null) {
                if (str.length() != 0) {
                    if (b0Var != null && !e.h.c(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    } else if (b0Var == null && e.h.b(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    } else {
                        this.f69333b = str;
                        this.f69335d = b0Var;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public a g(String str, String str2) {
            this.f69334c.f(str, str2);
            return this;
        }

        public a h(URL url) {
            if (url != null) {
                com.bytedance.sdk.a.b.s b2 = com.bytedance.sdk.a.b.s.b(url);
                if (b2 != null) {
                    c(b2);
                    return this;
                }
                throw new IllegalArgumentException("unexpected url: " + url);
            }
            throw new NullPointerException("url == null");
        }

        public a i() {
            f("HEAD", null);
            return this;
        }

        public a j(b0 b0Var) {
            f(HttpDelete.METHOD_NAME, b0Var);
            return this;
        }

        public a k(String str) {
            this.f69334c.d(str);
            return this;
        }

        public a l(String str, String str2) {
            this.f69334c.b(str, str2);
            return this;
        }

        public a m() {
            j(d.b.c.a.b.a.e.f69092d);
            return this;
        }

        public a n(b0 b0Var) {
            f(HttpPut.METHOD_NAME, b0Var);
            return this;
        }

        public a o(b0 b0Var) {
            f("PATCH", b0Var);
            return this;
        }

        public a0 p() {
            if (this.f69332a != null) {
                return new a0(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a(a0 a0Var) {
            this.f69332a = a0Var.f69326a;
            this.f69333b = a0Var.f69327b;
            this.f69335d = a0Var.f69329d;
            this.f69336e = a0Var.f69330e;
            this.f69334c = a0Var.f69328c.h();
        }
    }
}
