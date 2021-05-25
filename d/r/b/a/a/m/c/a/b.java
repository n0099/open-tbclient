package d.r.b.a.a.m.c.a;

import java.net.URLEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b extends d.r.b.a.a.m.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    public String f68143a;

    /* renamed from: b  reason: collision with root package name */
    public String f68144b;

    /* renamed from: c  reason: collision with root package name */
    public String f68145c;

    /* renamed from: d  reason: collision with root package name */
    public String f68146d;

    /* renamed from: e  reason: collision with root package name */
    public String f68147e;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public b f68148a = new b(null);

        public final b a() {
            return this.f68148a;
        }

        public final a b(String str) {
            this.f68148a.f68143a = str;
            return this;
        }

        public final a c(String str) {
            this.f68148a.f68144b = str;
            return this;
        }

        public final a d(String str) {
            this.f68148a.f68147e = str;
            return this;
        }

        public final a e(String str) {
            this.f68148a.f68145c = str;
            return this;
        }
    }

    public b() {
        this.f68143a = "-1";
        this.f68144b = "";
        this.f68145c = "";
        this.f68146d = "";
        this.f68147e = "";
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append("act");
        sb.append("=");
        sb.append(URLEncoder.encode(this.f68143a, "UTF-8"));
        sb.append("&");
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        sb.append("time");
        sb.append("=");
        sb.append(URLEncoder.encode(valueOf, "UTF-8"));
        sb.append("&");
        sb.append("key");
        sb.append("=");
        sb.append(URLEncoder.encode(d.r.b.a.a.m.c.d.c.c(this.f68143a + valueOf + "HiidoYYSystem"), "UTF-8"));
        sb.append("&");
        sb.append("appid");
        sb.append("=");
        sb.append(this.f68144b);
        sb.append("&");
        sb.append("usechannel");
        sb.append("=");
        sb.append(this.f68145c);
        sb.append("&");
        sb.append("hostid");
        sb.append("=");
        sb.append(this.f68146d);
        sb.append("&");
        sb.append("uid");
        sb.append("=");
        sb.append(this.f68147e);
        sb.append("&");
        sb.append("appkey");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68149a, "UTF-8"));
        sb.append("&");
        sb.append("sdkver");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68150b, "UTF-8"));
        sb.append("&");
        sb.append("bundleid");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68151c, "UTF-8"));
        sb.append("&");
        sb.append("clientver");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68152d, "UTF-8"));
        sb.append("&");
        sb.append("sys");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68153e, "UTF-8"));
        sb.append("&");
        sb.append("sjm");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68154f, "UTF-8"));
        sb.append("&");
        sb.append("mbos");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68155g, "UTF-8"));
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "contents.toString()");
        return sb2;
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
