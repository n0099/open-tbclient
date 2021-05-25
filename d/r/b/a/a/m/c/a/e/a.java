package d.r.b.a.a.m.c.a.e;

import android.text.TextUtils;
import d.r.b.a.a.m.c.a.b;
import java.net.URLEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a extends d.r.b.a.a.m.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    public b f68166a;

    /* renamed from: b  reason: collision with root package name */
    public String f68167b;

    /* renamed from: c  reason: collision with root package name */
    public String f68168c;

    /* renamed from: d.r.b.a.a.m.c.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1909a {

        /* renamed from: a  reason: collision with root package name */
        public a f68169a = new a(null);

        public final a a() {
            return this.f68169a;
        }

        public final C1909a b(b bVar) {
            this.f68169a.f68166a = bVar;
            return this;
        }

        public final C1909a c(String str) {
            this.f68169a.f68168c = str;
            return this;
        }

        public final C1909a d(String str) {
            this.f68169a.f68167b = str;
            return this;
        }
    }

    public a() {
        this.f68167b = "";
        this.f68168c = "";
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("event");
        sb.append("=");
        sb.append(URLEncoder.encode(this.f68167b, "UTF-8"));
        if (!TextUtils.isEmpty(this.f68168c)) {
            sb.append("&");
            sb.append("amount");
            sb.append("=");
            sb.append(this.f68168c);
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "contents.toString()");
        return sb2;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        b bVar = this.f68166a;
        sb.append(bVar != null ? bVar.e() : null);
        sb.append("&");
        sb.append(d());
        return sb.toString();
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
