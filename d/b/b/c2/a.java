package d.b.b.c2;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f64986f = {"https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f64987g = {"https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f64988h = {"https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com"};

    /* renamed from: a  reason: collision with root package name */
    public String f64989a;

    /* renamed from: b  reason: collision with root package name */
    public String f64990b;

    /* renamed from: c  reason: collision with root package name */
    public String f64991c;

    /* renamed from: d  reason: collision with root package name */
    public String f64992d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f64993e;

    public a() {
        g();
    }

    public static a a(int i2) {
        a aVar = new a();
        if (i2 == 0) {
            aVar.g();
        } else if (i2 == 1) {
            aVar.h();
        } else if (i2 != 2) {
            aVar.g();
        } else {
            aVar.i();
        }
        return aVar;
    }

    public String b() {
        return this.f64989a;
    }

    public String c() {
        return this.f64990b;
    }

    public String d() {
        return this.f64991c;
    }

    public String e() {
        return this.f64992d;
    }

    public String[] f() {
        return this.f64993e;
    }

    public final void g() {
        this.f64989a = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
        this.f64990b = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
        this.f64991c = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
        this.f64992d = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
        this.f64993e = f64986f;
    }

    public final void h() {
        this.f64989a = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
        this.f64990b = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
        this.f64991c = "https://toblog.tobsnssdk.com/service/2/log_settings/";
        this.f64992d = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
        this.f64993e = f64987g;
    }

    public final void i() {
        this.f64989a = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
        this.f64990b = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
        this.f64991c = "https://toblog.itobsnssdk.com/service/2/log_settings/";
        this.f64992d = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
        this.f64993e = f64988h;
    }
}
