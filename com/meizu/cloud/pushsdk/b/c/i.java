package com.meizu.cloud.pushsdk.b.c;

import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes10.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final f f74227a;

    /* renamed from: b  reason: collision with root package name */
    public final String f74228b;

    /* renamed from: c  reason: collision with root package name */
    public final c f74229c;

    /* renamed from: d  reason: collision with root package name */
    public final j f74230d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f74231e;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public f f74232a;

        /* renamed from: b  reason: collision with root package name */
        public String f74233b = "GET";

        /* renamed from: c  reason: collision with root package name */
        public c.a f74234c = new c.a();

        /* renamed from: d  reason: collision with root package name */
        public j f74235d;

        /* renamed from: e  reason: collision with root package name */
        public Object f74236e;

        public a a() {
            return a("GET", (j) null);
        }

        public a a(c cVar) {
            this.f74234c = cVar.c();
            return this;
        }

        public a a(f fVar) {
            if (fVar != null) {
                this.f74232a = fVar;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public a a(j jVar) {
            return a("POST", jVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a a(String str) {
            StringBuilder sb;
            int i2;
            f c2;
            if (str == null) {
                throw new IllegalArgumentException("url == null");
            }
            if (!str.regionMatches(true, 0, "ws:", 0, 3)) {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    sb = new StringBuilder();
                    sb.append(UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
                    i2 = 4;
                }
                c2 = f.c(str);
                if (c2 == null) {
                    return a(c2);
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            sb = new StringBuilder();
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_HTTP);
            i2 = 3;
            sb.append(str.substring(i2));
            str = sb.toString();
            c2 = f.c(str);
            if (c2 == null) {
            }
        }

        public a a(String str, j jVar) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (jVar != null && !d.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (jVar != null || !d.a(str)) {
                this.f74233b = str;
                this.f74235d = jVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public a a(String str, String str2) {
            this.f74234c.a(str, str2);
            return this;
        }

        public a b() {
            return a("HEAD", (j) null);
        }

        public a b(j jVar) {
            return a(HttpDelete.METHOD_NAME, jVar);
        }

        public a c(j jVar) {
            return a(HttpPut.METHOD_NAME, jVar);
        }

        public i c() {
            if (this.f74232a != null) {
                return new i(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a d(j jVar) {
            return a("PATCH", jVar);
        }
    }

    public i(a aVar) {
        this.f74227a = aVar.f74232a;
        this.f74228b = aVar.f74233b;
        this.f74229c = aVar.f74234c.a();
        this.f74230d = aVar.f74235d;
        this.f74231e = aVar.f74236e != null ? aVar.f74236e : this;
    }

    public f a() {
        return this.f74227a;
    }

    public String a(String str) {
        return this.f74229c.a(str);
    }

    public String b() {
        return this.f74228b;
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
        if ("HEAD".equals(b())) {
            return 4;
        }
        return "PATCH".equals(b()) ? 5 : 0;
    }

    public c d() {
        return this.f74229c;
    }

    public j e() {
        return this.f74230d;
    }

    public boolean f() {
        return this.f74227a.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f74228b);
        sb.append(", url=");
        sb.append(this.f74227a);
        sb.append(", tag=");
        Object obj = this.f74231e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append(ExtendedMessageFormat.END_FE);
        return sb.toString();
    }
}
