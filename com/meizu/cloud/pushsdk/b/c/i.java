package com.meizu.cloud.pushsdk.b.c;

import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes6.dex */
public class i {
    private final f a;
    private final String b;
    private final c c;
    private final j d;
    private final Object e;

    /* loaded from: classes6.dex */
    public static class a {
        private f a;
        private String b = "GET";
        private c.a c = new c.a();
        private j d;
        private Object e;

        public a a() {
            return a("GET", (j) null);
        }

        public a a(c cVar) {
            this.c = cVar.c();
            return this;
        }

        public a a(f fVar) {
            if (fVar == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.a = fVar;
            return this;
        }

        public a a(j jVar) {
            return a("POST", jVar);
        }

        public a a(String str) {
            if (str == null) {
                throw new IllegalArgumentException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
            }
            f c = f.c(str);
            if (c == null) {
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            return a(c);
        }

        public a a(String str, j jVar) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (jVar == null || d.b(str)) {
                if (jVar == null && d.a(str)) {
                    throw new IllegalArgumentException("method " + str + " must have a request body.");
                }
                this.b = str;
                this.d = jVar;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must not have a request body.");
        }

        public a a(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public a b() {
            return a(HttpHead.METHOD_NAME, (j) null);
        }

        public a b(j jVar) {
            return a(HttpDelete.METHOD_NAME, jVar);
        }

        public a c(j jVar) {
            return a(HttpPut.METHOD_NAME, jVar);
        }

        public i c() {
            if (this.a == null) {
                throw new IllegalStateException("url == null");
            }
            return new i(this);
        }

        public a d(j jVar) {
            return a("PATCH", jVar);
        }
    }

    private i(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public f a() {
        return this.a;
    }

    public String a(String str) {
        return this.c.a(str);
    }

    public String b() {
        return this.b;
    }

    public int c() {
        if ("GET".equals(b())) {
            return 0;
        }
        if ("POST".equals(b())) {
            return 1;
        }
        if (HttpPut.METHOD_NAME.equals(b())) {
            return 2;
        }
        if (HttpDelete.METHOD_NAME.equals(b())) {
            return 3;
        }
        if (HttpHead.METHOD_NAME.equals(b())) {
            return 4;
        }
        return "PATCH".equals(b()) ? 5 : 0;
    }

    public c d() {
        return this.c;
    }

    public j e() {
        return this.d;
    }

    public boolean f() {
        return this.a.a();
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tag=" + (this.e != this ? this.e : null) + '}';
    }
}
