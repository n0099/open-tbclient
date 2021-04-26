package d.b.b.c2;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f64257f = {"https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f64258g = {"https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f64259h = {"https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com"};

    /* renamed from: a  reason: collision with root package name */
    public String f64260a;

    /* renamed from: b  reason: collision with root package name */
    public String f64261b;

    /* renamed from: c  reason: collision with root package name */
    public String f64262c;

    /* renamed from: d  reason: collision with root package name */
    public String f64263d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f64264e;

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
        return this.f64260a;
    }

    public String c() {
        return this.f64261b;
    }

    public String d() {
        return this.f64262c;
    }

    public String e() {
        return this.f64263d;
    }

    public String[] f() {
        return this.f64264e;
    }

    public final void g() {
        this.f64260a = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
        this.f64261b = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
        this.f64262c = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
        this.f64263d = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
        this.f64264e = f64257f;
    }

    public final void h() {
        this.f64260a = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
        this.f64261b = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
        this.f64262c = "https://toblog.tobsnssdk.com/service/2/log_settings/";
        this.f64263d = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
        this.f64264e = f64258g;
    }

    public final void i() {
        this.f64260a = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
        this.f64261b = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
        this.f64262c = "https://toblog.itobsnssdk.com/service/2/log_settings/";
        this.f64263d = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
        this.f64264e = f64259h;
    }
}
