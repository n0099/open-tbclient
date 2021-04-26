package d.r.b.a.a.m.c.a.d;

import com.baidu.wallet.paysdk.api.BaiduPay;
import d.r.b.a.a.m.c.a.b;
import java.net.URLEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a extends d.r.b.a.a.m.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    public b f67427a;

    /* renamed from: b  reason: collision with root package name */
    public String f67428b;

    /* renamed from: c  reason: collision with root package name */
    public String f67429c;

    /* renamed from: d  reason: collision with root package name */
    public String f67430d;

    /* renamed from: e  reason: collision with root package name */
    public String f67431e;

    /* renamed from: f  reason: collision with root package name */
    public String f67432f;

    /* renamed from: g  reason: collision with root package name */
    public String f67433g;

    /* renamed from: h  reason: collision with root package name */
    public String f67434h;

    /* renamed from: i  reason: collision with root package name */
    public String f67435i;
    public String j;

    /* renamed from: d.r.b.a.a.m.c.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1840a {

        /* renamed from: a  reason: collision with root package name */
        public final a f67436a = new a(null);

        public final a a() {
            return this.f67436a;
        }

        public final C1840a b(b bVar) {
            this.f67436a.f67427a = bVar;
            return this;
        }

        public final C1840a c(String str) {
            this.f67436a.f67434h = str;
            return this;
        }

        public final C1840a d(String str) {
            this.f67436a.f67433g = str;
            return this;
        }

        public final C1840a e(String str) {
            this.f67436a.f67435i = str;
            return this;
        }

        public final C1840a f(String str) {
            this.f67436a.f67428b = str;
            return this;
        }

        public final C1840a g(String str) {
            this.f67436a.f67431e = str;
            return this;
        }

        public final C1840a h(String str) {
            this.f67436a.f67432f = str;
            return this;
        }

        public final C1840a i(String str) {
            this.f67436a.f67430d = str;
            return this;
        }

        public final C1840a j(String str) {
            this.f67436a.f67429c = str;
            return this;
        }
    }

    public a() {
        this.f67428b = "";
        this.f67429c = "";
        this.f67430d = "";
        this.f67431e = "";
        this.f67432f = "";
        this.f67433g = "";
        this.f67434h = "";
        this.f67435i = "";
        this.j = "";
    }

    public final String j() {
        String str = "orderid=" + URLEncoder.encode(this.f67428b, "UTF-8") + "&purchasetime=" + URLEncoder.encode(this.f67429c, "UTF-8") + "&productid=" + URLEncoder.encode(this.f67430d, "UTF-8") + "&payentranceid=" + URLEncoder.encode(this.f67431e, "UTF-8") + "&paytraceid=" + URLEncoder.encode(this.f67432f, "UTF-8") + "&event=" + URLEncoder.encode(this.f67433g, "UTF-8") + "&code=" + this.f67434h + "&msg=" + URLEncoder.encode(this.f67435i, "UTF-8") + "&" + BaiduPay.PAY_FROM + "=" + URLEncoder.encode(this.j, "UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(str, "contents.toString()");
        return str;
    }

    public String k() {
        StringBuilder sb = new StringBuilder();
        b bVar = this.f67427a;
        sb.append(bVar != null ? bVar.e() : null);
        sb.append("&");
        sb.append(j());
        return sb.toString();
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
