package d.r.b.a.a.m.c.a.d;

import com.baidu.wallet.paysdk.api.BaiduPay;
import d.r.b.a.a.m.c.a.b;
import java.net.URLEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a extends d.r.b.a.a.m.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    public b f68156a;

    /* renamed from: b  reason: collision with root package name */
    public String f68157b;

    /* renamed from: c  reason: collision with root package name */
    public String f68158c;

    /* renamed from: d  reason: collision with root package name */
    public String f68159d;

    /* renamed from: e  reason: collision with root package name */
    public String f68160e;

    /* renamed from: f  reason: collision with root package name */
    public String f68161f;

    /* renamed from: g  reason: collision with root package name */
    public String f68162g;

    /* renamed from: h  reason: collision with root package name */
    public String f68163h;

    /* renamed from: i  reason: collision with root package name */
    public String f68164i;
    public String j;

    /* renamed from: d.r.b.a.a.m.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1908a {

        /* renamed from: a  reason: collision with root package name */
        public final a f68165a = new a(null);

        public final a a() {
            return this.f68165a;
        }

        public final C1908a b(b bVar) {
            this.f68165a.f68156a = bVar;
            return this;
        }

        public final C1908a c(String str) {
            this.f68165a.f68163h = str;
            return this;
        }

        public final C1908a d(String str) {
            this.f68165a.f68162g = str;
            return this;
        }

        public final C1908a e(String str) {
            this.f68165a.f68164i = str;
            return this;
        }

        public final C1908a f(String str) {
            this.f68165a.f68157b = str;
            return this;
        }

        public final C1908a g(String str) {
            this.f68165a.f68160e = str;
            return this;
        }

        public final C1908a h(String str) {
            this.f68165a.f68161f = str;
            return this;
        }

        public final C1908a i(String str) {
            this.f68165a.f68159d = str;
            return this;
        }

        public final C1908a j(String str) {
            this.f68165a.f68158c = str;
            return this;
        }
    }

    public a() {
        this.f68157b = "";
        this.f68158c = "";
        this.f68159d = "";
        this.f68160e = "";
        this.f68161f = "";
        this.f68162g = "";
        this.f68163h = "";
        this.f68164i = "";
        this.j = "";
    }

    public final String j() {
        String str = "orderid=" + URLEncoder.encode(this.f68157b, "UTF-8") + "&purchasetime=" + URLEncoder.encode(this.f68158c, "UTF-8") + "&productid=" + URLEncoder.encode(this.f68159d, "UTF-8") + "&payentranceid=" + URLEncoder.encode(this.f68160e, "UTF-8") + "&paytraceid=" + URLEncoder.encode(this.f68161f, "UTF-8") + "&event=" + URLEncoder.encode(this.f68162g, "UTF-8") + "&code=" + this.f68163h + "&msg=" + URLEncoder.encode(this.f68164i, "UTF-8") + "&" + BaiduPay.PAY_FROM + "=" + URLEncoder.encode(this.j, "UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(str, "contents.toString()");
        return str;
    }

    public String k() {
        StringBuilder sb = new StringBuilder();
        b bVar = this.f68156a;
        sb.append(bVar != null ? bVar.e() : null);
        sb.append("&");
        sb.append(j());
        return sb.toString();
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
