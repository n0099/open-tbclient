package d.r.b.a.a.m.c.a.d;

import com.baidu.wallet.paysdk.api.BaiduPay;
import d.r.b.a.a.m.c.a.b;
import java.net.URLEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a extends d.r.b.a.a.m.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    public b f68113a;

    /* renamed from: b  reason: collision with root package name */
    public String f68114b;

    /* renamed from: c  reason: collision with root package name */
    public String f68115c;

    /* renamed from: d  reason: collision with root package name */
    public String f68116d;

    /* renamed from: e  reason: collision with root package name */
    public String f68117e;

    /* renamed from: f  reason: collision with root package name */
    public String f68118f;

    /* renamed from: g  reason: collision with root package name */
    public String f68119g;

    /* renamed from: h  reason: collision with root package name */
    public String f68120h;

    /* renamed from: i  reason: collision with root package name */
    public String f68121i;
    public String j;

    /* renamed from: d.r.b.a.a.m.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1904a {

        /* renamed from: a  reason: collision with root package name */
        public final a f68122a = new a(null);

        public final a a() {
            return this.f68122a;
        }

        public final C1904a b(b bVar) {
            this.f68122a.f68113a = bVar;
            return this;
        }

        public final C1904a c(String str) {
            this.f68122a.f68120h = str;
            return this;
        }

        public final C1904a d(String str) {
            this.f68122a.f68119g = str;
            return this;
        }

        public final C1904a e(String str) {
            this.f68122a.f68121i = str;
            return this;
        }

        public final C1904a f(String str) {
            this.f68122a.f68114b = str;
            return this;
        }

        public final C1904a g(String str) {
            this.f68122a.f68117e = str;
            return this;
        }

        public final C1904a h(String str) {
            this.f68122a.f68118f = str;
            return this;
        }

        public final C1904a i(String str) {
            this.f68122a.f68116d = str;
            return this;
        }

        public final C1904a j(String str) {
            this.f68122a.f68115c = str;
            return this;
        }
    }

    public a() {
        this.f68114b = "";
        this.f68115c = "";
        this.f68116d = "";
        this.f68117e = "";
        this.f68118f = "";
        this.f68119g = "";
        this.f68120h = "";
        this.f68121i = "";
        this.j = "";
    }

    public final String j() {
        String str = "orderid=" + URLEncoder.encode(this.f68114b, "UTF-8") + "&purchasetime=" + URLEncoder.encode(this.f68115c, "UTF-8") + "&productid=" + URLEncoder.encode(this.f68116d, "UTF-8") + "&payentranceid=" + URLEncoder.encode(this.f68117e, "UTF-8") + "&paytraceid=" + URLEncoder.encode(this.f68118f, "UTF-8") + "&event=" + URLEncoder.encode(this.f68119g, "UTF-8") + "&code=" + this.f68120h + "&msg=" + URLEncoder.encode(this.f68121i, "UTF-8") + "&" + BaiduPay.PAY_FROM + "=" + URLEncoder.encode(this.j, "UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(str, "contents.toString()");
        return str;
    }

    public String k() {
        StringBuilder sb = new StringBuilder();
        b bVar = this.f68113a;
        sb.append(bVar != null ? bVar.e() : null);
        sb.append("&");
        sb.append(j());
        return sb.toString();
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
