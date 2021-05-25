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
    public final com.bytedance.sdk.a.b.s f65491a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65492b;

    /* renamed from: c  reason: collision with root package name */
    public final v f65493c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f65494d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f65495e;

    /* renamed from: f  reason: collision with root package name */
    public volatile h f65496f;

    public a0(a aVar) {
        this.f65491a = aVar.f65497a;
        this.f65492b = aVar.f65498b;
        this.f65493c = aVar.f65499c.c();
        this.f65494d = aVar.f65500d;
        Object obj = aVar.f65501e;
        this.f65495e = obj == null ? this : obj;
    }

    public com.bytedance.sdk.a.b.s a() {
        return this.f65491a;
    }

    public String b(String str) {
        return this.f65493c.c(str);
    }

    public String c() {
        return this.f65492b;
    }

    public v d() {
        return this.f65493c;
    }

    public b0 e() {
        return this.f65494d;
    }

    public a f() {
        return new a(this);
    }

    public h g() {
        h hVar = this.f65496f;
        if (hVar != null) {
            return hVar;
        }
        h a2 = h.a(this.f65493c);
        this.f65496f = a2;
        return a2;
    }

    public boolean h() {
        return this.f65491a.q();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f65492b);
        sb.append(", url=");
        sb.append(this.f65491a);
        sb.append(", tag=");
        Object obj = this.f65495e;
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
        public com.bytedance.sdk.a.b.s f65497a;

        /* renamed from: b  reason: collision with root package name */
        public String f65498b;

        /* renamed from: c  reason: collision with root package name */
        public v.a f65499c;

        /* renamed from: d  reason: collision with root package name */
        public b0 f65500d;

        /* renamed from: e  reason: collision with root package name */
        public Object f65501e;

        public a() {
            this.f65498b = "GET";
            this.f65499c = new v.a();
        }

        public a a() {
            f("GET", null);
            return this;
        }

        public a b(v vVar) {
            this.f65499c = vVar.h();
            return this;
        }

        public a c(com.bytedance.sdk.a.b.s sVar) {
            if (sVar != null) {
                this.f65497a = sVar;
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
                        this.f65498b = str;
                        this.f65500d = b0Var;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public a g(String str, String str2) {
            this.f65499c.f(str, str2);
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
            this.f65499c.d(str);
            return this;
        }

        public a l(String str, String str2) {
            this.f65499c.b(str, str2);
            return this;
        }

        public a m() {
            j(d.b.c.a.b.a.e.f65257d);
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
            if (this.f65497a != null) {
                return new a0(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a(a0 a0Var) {
            this.f65497a = a0Var.f65491a;
            this.f65498b = a0Var.f65492b;
            this.f65500d = a0Var.f65494d;
            this.f65501e = a0Var.f65495e;
            this.f65499c = a0Var.f65493c.h();
        }
    }
}
