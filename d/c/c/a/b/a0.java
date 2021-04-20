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
    public final com.bytedance.sdk.a.b.s f66282a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66283b;

    /* renamed from: c  reason: collision with root package name */
    public final v f66284c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f66285d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f66286e;

    /* renamed from: f  reason: collision with root package name */
    public volatile h f66287f;

    public a0(a aVar) {
        this.f66282a = aVar.f66288a;
        this.f66283b = aVar.f66289b;
        this.f66284c = aVar.f66290c.c();
        this.f66285d = aVar.f66291d;
        Object obj = aVar.f66292e;
        this.f66286e = obj == null ? this : obj;
    }

    public com.bytedance.sdk.a.b.s a() {
        return this.f66282a;
    }

    public String b(String str) {
        return this.f66284c.c(str);
    }

    public String c() {
        return this.f66283b;
    }

    public v d() {
        return this.f66284c;
    }

    public b0 e() {
        return this.f66285d;
    }

    public a f() {
        return new a(this);
    }

    public h g() {
        h hVar = this.f66287f;
        if (hVar != null) {
            return hVar;
        }
        h a2 = h.a(this.f66284c);
        this.f66287f = a2;
        return a2;
    }

    public boolean h() {
        return this.f66282a.q();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f66283b);
        sb.append(", url=");
        sb.append(this.f66282a);
        sb.append(", tag=");
        Object obj = this.f66286e;
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
        public com.bytedance.sdk.a.b.s f66288a;

        /* renamed from: b  reason: collision with root package name */
        public String f66289b;

        /* renamed from: c  reason: collision with root package name */
        public v.a f66290c;

        /* renamed from: d  reason: collision with root package name */
        public b0 f66291d;

        /* renamed from: e  reason: collision with root package name */
        public Object f66292e;

        public a() {
            this.f66289b = "GET";
            this.f66290c = new v.a();
        }

        public a a() {
            f("GET", null);
            return this;
        }

        public a b(v vVar) {
            this.f66290c = vVar.h();
            return this;
        }

        public a c(com.bytedance.sdk.a.b.s sVar) {
            if (sVar != null) {
                this.f66288a = sVar;
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
                        this.f66289b = str;
                        this.f66291d = b0Var;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public a g(String str, String str2) {
            this.f66290c.f(str, str2);
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
            this.f66290c.d(str);
            return this;
        }

        public a l(String str, String str2) {
            this.f66290c.b(str, str2);
            return this;
        }

        public a m() {
            j(d.c.c.a.b.a.e.f66066d);
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
            if (this.f66288a != null) {
                return new a0(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a(a0 a0Var) {
            this.f66288a = a0Var.f66282a;
            this.f66289b = a0Var.f66283b;
            this.f66291d = a0Var.f66285d;
            this.f66292e = a0Var.f66286e;
            this.f66290c = a0Var.f66284c.h();
        }
    }
}
