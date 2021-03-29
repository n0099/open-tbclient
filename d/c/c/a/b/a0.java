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
    public final com.bytedance.sdk.a.b.s f65437a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65438b;

    /* renamed from: c  reason: collision with root package name */
    public final v f65439c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f65440d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f65441e;

    /* renamed from: f  reason: collision with root package name */
    public volatile h f65442f;

    public a0(a aVar) {
        this.f65437a = aVar.f65443a;
        this.f65438b = aVar.f65444b;
        this.f65439c = aVar.f65445c.c();
        this.f65440d = aVar.f65446d;
        Object obj = aVar.f65447e;
        this.f65441e = obj == null ? this : obj;
    }

    public com.bytedance.sdk.a.b.s a() {
        return this.f65437a;
    }

    public String b(String str) {
        return this.f65439c.c(str);
    }

    public String c() {
        return this.f65438b;
    }

    public v d() {
        return this.f65439c;
    }

    public b0 e() {
        return this.f65440d;
    }

    public a f() {
        return new a(this);
    }

    public h g() {
        h hVar = this.f65442f;
        if (hVar != null) {
            return hVar;
        }
        h a2 = h.a(this.f65439c);
        this.f65442f = a2;
        return a2;
    }

    public boolean h() {
        return this.f65437a.q();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f65438b);
        sb.append(", url=");
        sb.append(this.f65437a);
        sb.append(", tag=");
        Object obj = this.f65441e;
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
        public com.bytedance.sdk.a.b.s f65443a;

        /* renamed from: b  reason: collision with root package name */
        public String f65444b;

        /* renamed from: c  reason: collision with root package name */
        public v.a f65445c;

        /* renamed from: d  reason: collision with root package name */
        public b0 f65446d;

        /* renamed from: e  reason: collision with root package name */
        public Object f65447e;

        public a() {
            this.f65444b = "GET";
            this.f65445c = new v.a();
        }

        public a a() {
            f("GET", null);
            return this;
        }

        public a b(v vVar) {
            this.f65445c = vVar.h();
            return this;
        }

        public a c(com.bytedance.sdk.a.b.s sVar) {
            if (sVar != null) {
                this.f65443a = sVar;
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
                        this.f65444b = str;
                        this.f65446d = b0Var;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public a g(String str, String str2) {
            this.f65445c.f(str, str2);
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
            this.f65445c.d(str);
            return this;
        }

        public a l(String str, String str2) {
            this.f65445c.b(str, str2);
            return this;
        }

        public a m() {
            j(d.c.c.a.b.a.e.f65221d);
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
            if (this.f65443a != null) {
                return new a0(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a(a0 a0Var) {
            this.f65443a = a0Var.f65437a;
            this.f65444b = a0Var.f65438b;
            this.f65446d = a0Var.f65440d;
            this.f65447e = a0Var.f65441e;
            this.f65445c = a0Var.f65439c.h();
        }
    }
}
