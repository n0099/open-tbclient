package d.c.c.a.b;

import com.baidu.tbadk.core.util.UrlSchemaHelper;
import d.c.c.a.b.a.e;
import d.c.c.a.b.v;
import java.net.URL;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes5.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.s f66377a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66378b;

    /* renamed from: c  reason: collision with root package name */
    public final v f66379c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f66380d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f66381e;

    /* renamed from: f  reason: collision with root package name */
    public volatile h f66382f;

    public a0(a aVar) {
        this.f66377a = aVar.f66383a;
        this.f66378b = aVar.f66384b;
        this.f66379c = aVar.f66385c.c();
        this.f66380d = aVar.f66386d;
        Object obj = aVar.f66387e;
        this.f66381e = obj == null ? this : obj;
    }

    public com.bytedance.sdk.a.b.s a() {
        return this.f66377a;
    }

    public String b(String str) {
        return this.f66379c.c(str);
    }

    public String c() {
        return this.f66378b;
    }

    public v d() {
        return this.f66379c;
    }

    public b0 e() {
        return this.f66380d;
    }

    public a f() {
        return new a(this);
    }

    public h g() {
        h hVar = this.f66382f;
        if (hVar != null) {
            return hVar;
        }
        h a2 = h.a(this.f66379c);
        this.f66382f = a2;
        return a2;
    }

    public boolean h() {
        return this.f66377a.q();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f66378b);
        sb.append(", url=");
        sb.append(this.f66377a);
        sb.append(", tag=");
        Object obj = this.f66381e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.a.b.s f66383a;

        /* renamed from: b  reason: collision with root package name */
        public String f66384b;

        /* renamed from: c  reason: collision with root package name */
        public v.a f66385c;

        /* renamed from: d  reason: collision with root package name */
        public b0 f66386d;

        /* renamed from: e  reason: collision with root package name */
        public Object f66387e;

        public a() {
            this.f66384b = "GET";
            this.f66385c = new v.a();
        }

        public a a() {
            f("GET", null);
            return this;
        }

        public a b(v vVar) {
            this.f66385c = vVar.h();
            return this;
        }

        public a c(com.bytedance.sdk.a.b.s sVar) {
            if (sVar != null) {
                this.f66383a = sVar;
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
                        this.f66384b = str;
                        this.f66386d = b0Var;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public a g(String str, String str2) {
            this.f66385c.f(str, str2);
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
            this.f66385c.d(str);
            return this;
        }

        public a l(String str, String str2) {
            this.f66385c.b(str, str2);
            return this;
        }

        public a m() {
            j(d.c.c.a.b.a.e.f66161d);
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
            if (this.f66383a != null) {
                return new a0(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a(a0 a0Var) {
            this.f66383a = a0Var.f66377a;
            this.f66384b = a0Var.f66378b;
            this.f66386d = a0Var.f66380d;
            this.f66387e = a0Var.f66381e;
            this.f66385c = a0Var.f66379c.h();
        }
    }
}
