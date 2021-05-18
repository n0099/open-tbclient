package d.b.b.c2;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f64943f = {"https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f64944g = {"https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f64945h = {"https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com"};

    /* renamed from: a  reason: collision with root package name */
    public String f64946a;

    /* renamed from: b  reason: collision with root package name */
    public String f64947b;

    /* renamed from: c  reason: collision with root package name */
    public String f64948c;

    /* renamed from: d  reason: collision with root package name */
    public String f64949d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f64950e;

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
        return this.f64946a;
    }

    public String c() {
        return this.f64947b;
    }

    public String d() {
        return this.f64948c;
    }

    public String e() {
        return this.f64949d;
    }

    public String[] f() {
        return this.f64950e;
    }

    public final void g() {
        this.f64946a = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
        this.f64947b = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
        this.f64948c = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
        this.f64949d = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
        this.f64950e = f64943f;
    }

    public final void h() {
        this.f64946a = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
        this.f64947b = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
        this.f64948c = "https://toblog.tobsnssdk.com/service/2/log_settings/";
        this.f64949d = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
        this.f64950e = f64944g;
    }

    public final void i() {
        this.f64946a = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
        this.f64947b = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
        this.f64948c = "https://toblog.itobsnssdk.com/service/2/log_settings/";
        this.f64949d = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
        this.f64950e = f64945h;
    }
}
