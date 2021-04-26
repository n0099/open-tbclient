package d.r.b.a.a.m.c.a;

import java.net.URLEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b extends d.r.b.a.a.m.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    public String f67414a;

    /* renamed from: b  reason: collision with root package name */
    public String f67415b;

    /* renamed from: c  reason: collision with root package name */
    public String f67416c;

    /* renamed from: d  reason: collision with root package name */
    public String f67417d;

    /* renamed from: e  reason: collision with root package name */
    public String f67418e;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public b f67419a = new b(null);

        public final b a() {
            return this.f67419a;
        }

        public final a b(String str) {
            this.f67419a.f67414a = str;
            return this;
        }

        public final a c(String str) {
            this.f67419a.f67415b = str;
            return this;
        }

        public final a d(String str) {
            this.f67419a.f67418e = str;
            return this;
        }

        public final a e(String str) {
            this.f67419a.f67416c = str;
            return this;
        }
    }

    public b() {
        this.f67414a = "-1";
        this.f67415b = "";
        this.f67416c = "";
        this.f67417d = "";
        this.f67418e = "";
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append("act");
        sb.append("=");
        sb.append(URLEncoder.encode(this.f67414a, "UTF-8"));
        sb.append("&");
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        sb.append("time");
        sb.append("=");
        sb.append(URLEncoder.encode(valueOf, "UTF-8"));
        sb.append("&");
        sb.append("key");
        sb.append("=");
        sb.append(URLEncoder.encode(d.r.b.a.a.m.c.d.c.c(this.f67414a + valueOf + "HiidoYYSystem"), "UTF-8"));
        sb.append("&");
        sb.append("appid");
        sb.append("=");
        sb.append(this.f67415b);
        sb.append("&");
        sb.append("usechannel");
        sb.append("=");
        sb.append(this.f67416c);
        sb.append("&");
        sb.append("hostid");
        sb.append("=");
        sb.append(this.f67417d);
        sb.append("&");
        sb.append("uid");
        sb.append("=");
        sb.append(this.f67418e);
        sb.append("&");
        sb.append("appkey");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f67420a, "UTF-8"));
        sb.append("&");
        sb.append("sdkver");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f67421b, "UTF-8"));
        sb.append("&");
        sb.append("bundleid");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f67422c, "UTF-8"));
        sb.append("&");
        sb.append("clientver");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f67423d, "UTF-8"));
        sb.append("&");
        sb.append("sys");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f67424e, "UTF-8"));
        sb.append("&");
        sb.append("sjm");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f67425f, "UTF-8"));
        sb.append("&");
        sb.append("mbos");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f67426g, "UTF-8"));
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "contents.toString()");
        return sb2;
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
