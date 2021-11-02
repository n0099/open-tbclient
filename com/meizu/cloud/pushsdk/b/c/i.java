package com.meizu.cloud.pushsdk.b.c;

import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final f f67325a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67326b;

    /* renamed from: c  reason: collision with root package name */
    public final c f67327c;

    /* renamed from: d  reason: collision with root package name */
    public final j f67328d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f67329e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public f f67330a;

        /* renamed from: b  reason: collision with root package name */
        public String f67331b = "GET";

        /* renamed from: c  reason: collision with root package name */
        public c.a f67332c = new c.a();

        /* renamed from: d  reason: collision with root package name */
        public j f67333d;

        /* renamed from: e  reason: collision with root package name */
        public Object f67334e;

        public a a() {
            return a("GET", (j) null);
        }

        public a a(c cVar) {
            this.f67332c = cVar.c();
            return this;
        }

        public a a(f fVar) {
            if (fVar != null) {
                this.f67330a = fVar;
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
                this.f67331b = str;
                this.f67333d = jVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public a a(String str, String str2) {
            this.f67332c.a(str, str2);
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
            if (this.f67330a != null) {
                return new i(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a d(j jVar) {
            return a("PATCH", jVar);
        }
    }

    public i(a aVar) {
        this.f67325a = aVar.f67330a;
        this.f67326b = aVar.f67331b;
        this.f67327c = aVar.f67332c.a();
        this.f67328d = aVar.f67333d;
        this.f67329e = aVar.f67334e != null ? aVar.f67334e : this;
    }

    public f a() {
        return this.f67325a;
    }

    public String a(String str) {
        return this.f67327c.a(str);
    }

    public String b() {
        return this.f67326b;
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
        return this.f67327c;
    }

    public j e() {
        return this.f67328d;
    }

    public boolean f() {
        return this.f67325a.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f67326b);
        sb.append(", url=");
        sb.append(this.f67325a);
        sb.append(", tag=");
        Object obj = this.f67329e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append(ExtendedMessageFormat.END_FE);
        return sb.toString();
    }
}
