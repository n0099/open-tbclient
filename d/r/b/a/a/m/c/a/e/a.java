package d.r.b.a.a.m.c.a.e;

import android.text.TextUtils;
import d.r.b.a.a.m.c.a.b;
import java.net.URLEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a extends d.r.b.a.a.m.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    public b f67437a;

    /* renamed from: b  reason: collision with root package name */
    public String f67438b;

    /* renamed from: c  reason: collision with root package name */
    public String f67439c;

    /* renamed from: d.r.b.a.a.m.c.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1841a {

        /* renamed from: a  reason: collision with root package name */
        public a f67440a = new a(null);

        public final a a() {
            return this.f67440a;
        }

        public final C1841a b(b bVar) {
            this.f67440a.f67437a = bVar;
            return this;
        }

        public final C1841a c(String str) {
            this.f67440a.f67439c = str;
            return this;
        }

        public final C1841a d(String str) {
            this.f67440a.f67438b = str;
            return this;
        }
    }

    public a() {
        this.f67438b = "";
        this.f67439c = "";
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("event");
        sb.append("=");
        sb.append(URLEncoder.encode(this.f67438b, "UTF-8"));
        if (!TextUtils.isEmpty(this.f67439c)) {
            sb.append("&");
            sb.append("amount");
            sb.append("=");
            sb.append(this.f67439c);
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "contents.toString()");
        return sb2;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        b bVar = this.f67437a;
        sb.append(bVar != null ? bVar.e() : null);
        sb.append("&");
        sb.append(d());
        return sb.toString();
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
