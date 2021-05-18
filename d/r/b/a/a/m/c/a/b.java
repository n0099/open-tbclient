package d.r.b.a.a.m.c.a;

import java.net.URLEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b extends d.r.b.a.a.m.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    public String f68100a;

    /* renamed from: b  reason: collision with root package name */
    public String f68101b;

    /* renamed from: c  reason: collision with root package name */
    public String f68102c;

    /* renamed from: d  reason: collision with root package name */
    public String f68103d;

    /* renamed from: e  reason: collision with root package name */
    public String f68104e;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public b f68105a = new b(null);

        public final b a() {
            return this.f68105a;
        }

        public final a b(String str) {
            this.f68105a.f68100a = str;
            return this;
        }

        public final a c(String str) {
            this.f68105a.f68101b = str;
            return this;
        }

        public final a d(String str) {
            this.f68105a.f68104e = str;
            return this;
        }

        public final a e(String str) {
            this.f68105a.f68102c = str;
            return this;
        }
    }

    public b() {
        this.f68100a = "-1";
        this.f68101b = "";
        this.f68102c = "";
        this.f68103d = "";
        this.f68104e = "";
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append("act");
        sb.append("=");
        sb.append(URLEncoder.encode(this.f68100a, "UTF-8"));
        sb.append("&");
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        sb.append("time");
        sb.append("=");
        sb.append(URLEncoder.encode(valueOf, "UTF-8"));
        sb.append("&");
        sb.append("key");
        sb.append("=");
        sb.append(URLEncoder.encode(d.r.b.a.a.m.c.d.c.c(this.f68100a + valueOf + "HiidoYYSystem"), "UTF-8"));
        sb.append("&");
        sb.append("appid");
        sb.append("=");
        sb.append(this.f68101b);
        sb.append("&");
        sb.append("usechannel");
        sb.append("=");
        sb.append(this.f68102c);
        sb.append("&");
        sb.append("hostid");
        sb.append("=");
        sb.append(this.f68103d);
        sb.append("&");
        sb.append("uid");
        sb.append("=");
        sb.append(this.f68104e);
        sb.append("&");
        sb.append("appkey");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68106a, "UTF-8"));
        sb.append("&");
        sb.append("sdkver");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68107b, "UTF-8"));
        sb.append("&");
        sb.append("bundleid");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68108c, "UTF-8"));
        sb.append("&");
        sb.append("clientver");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68109d, "UTF-8"));
        sb.append("&");
        sb.append("sys");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68110e, "UTF-8"));
        sb.append("&");
        sb.append("sjm");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68111f, "UTF-8"));
        sb.append("&");
        sb.append("mbos");
        sb.append("=");
        sb.append(URLEncoder.encode(c.f68112g, "UTF-8"));
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "contents.toString()");
        return sb2;
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
