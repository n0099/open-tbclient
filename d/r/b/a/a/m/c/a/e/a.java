package d.r.b.a.a.m.c.a.e;

import android.text.TextUtils;
import d.r.b.a.a.m.c.a.b;
import java.net.URLEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a extends d.r.b.a.a.m.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    public b f68123a;

    /* renamed from: b  reason: collision with root package name */
    public String f68124b;

    /* renamed from: c  reason: collision with root package name */
    public String f68125c;

    /* renamed from: d.r.b.a.a.m.c.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1905a {

        /* renamed from: a  reason: collision with root package name */
        public a f68126a = new a(null);

        public final a a() {
            return this.f68126a;
        }

        public final C1905a b(b bVar) {
            this.f68126a.f68123a = bVar;
            return this;
        }

        public final C1905a c(String str) {
            this.f68126a.f68125c = str;
            return this;
        }

        public final C1905a d(String str) {
            this.f68126a.f68124b = str;
            return this;
        }
    }

    public a() {
        this.f68124b = "";
        this.f68125c = "";
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("event");
        sb.append("=");
        sb.append(URLEncoder.encode(this.f68124b, "UTF-8"));
        if (!TextUtils.isEmpty(this.f68125c)) {
            sb.append("&");
            sb.append("amount");
            sb.append("=");
            sb.append(this.f68125c);
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "contents.toString()");
        return sb2;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        b bVar = this.f68123a;
        sb.append(bVar != null ? bVar.e() : null);
        sb.append("&");
        sb.append(d());
        return sb.toString();
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
