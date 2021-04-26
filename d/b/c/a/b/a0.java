package d.b.c.a.b;

import com.baidu.tbadk.core.util.UrlSchemaHelper;
import d.b.c.a.b.a.e;
import d.b.c.a.b.v;
import java.net.URL;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes5.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.s f64762a;

    /* renamed from: b  reason: collision with root package name */
    public final String f64763b;

    /* renamed from: c  reason: collision with root package name */
    public final v f64764c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f64765d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f64766e;

    /* renamed from: f  reason: collision with root package name */
    public volatile h f64767f;

    public a0(a aVar) {
        this.f64762a = aVar.f64768a;
        this.f64763b = aVar.f64769b;
        this.f64764c = aVar.f64770c.c();
        this.f64765d = aVar.f64771d;
        Object obj = aVar.f64772e;
        this.f64766e = obj == null ? this : obj;
    }

    public com.bytedance.sdk.a.b.s a() {
        return this.f64762a;
    }

    public String b(String str) {
        return this.f64764c.c(str);
    }

    public String c() {
        return this.f64763b;
    }

    public v d() {
        return this.f64764c;
    }

    public b0 e() {
        return this.f64765d;
    }

    public a f() {
        return new a(this);
    }

    public h g() {
        h hVar = this.f64767f;
        if (hVar != null) {
            return hVar;
        }
        h a2 = h.a(this.f64764c);
        this.f64767f = a2;
        return a2;
    }

    public boolean h() {
        return this.f64762a.q();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f64763b);
        sb.append(", url=");
        sb.append(this.f64762a);
        sb.append(", tag=");
        Object obj = this.f64766e;
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
        public com.bytedance.sdk.a.b.s f64768a;

        /* renamed from: b  reason: collision with root package name */
        public String f64769b;

        /* renamed from: c  reason: collision with root package name */
        public v.a f64770c;

        /* renamed from: d  reason: collision with root package name */
        public b0 f64771d;

        /* renamed from: e  reason: collision with root package name */
        public Object f64772e;

        public a() {
            this.f64769b = "GET";
            this.f64770c = new v.a();
        }

        public a a() {
            f("GET", null);
            return this;
        }

        public a b(v vVar) {
            this.f64770c = vVar.h();
            return this;
        }

        public a c(com.bytedance.sdk.a.b.s sVar) {
            if (sVar != null) {
                this.f64768a = sVar;
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
                        this.f64769b = str;
                        this.f64771d = b0Var;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public a g(String str, String str2) {
            this.f64770c.f(str, str2);
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
            this.f64770c.d(str);
            return this;
        }

        public a l(String str, String str2) {
            this.f64770c.b(str, str2);
            return this;
        }

        public a m() {
            j(d.b.c.a.b.a.e.f64528d);
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
            if (this.f64768a != null) {
                return new a0(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a(a0 a0Var) {
            this.f64768a = a0Var.f64762a;
            this.f64769b = a0Var.f64763b;
            this.f64771d = a0Var.f64765d;
            this.f64772e = a0Var.f64766e;
            this.f64770c = a0Var.f64764c.h();
        }
    }
}
