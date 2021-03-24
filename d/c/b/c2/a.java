package d.c.b.c2;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f64961f = {"https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f64962g = {"https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f64963h = {"https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com"};

    /* renamed from: a  reason: collision with root package name */
    public String f64964a;

    /* renamed from: b  reason: collision with root package name */
    public String f64965b;

    /* renamed from: c  reason: collision with root package name */
    public String f64966c;

    /* renamed from: d  reason: collision with root package name */
    public String f64967d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f64968e;

    public a() {
        g();
    }

    public static a a(int i) {
        a aVar = new a();
        if (i == 0) {
            aVar.g();
        } else if (i == 1) {
            aVar.h();
        } else if (i != 2) {
            aVar.g();
        } else {
            aVar.i();
        }
        return aVar;
    }

    public String b() {
        return this.f64964a;
    }

    public String c() {
        return this.f64965b;
    }

    public String d() {
        return this.f64966c;
    }

    public String e() {
        return this.f64967d;
    }

    public String[] f() {
        return this.f64968e;
    }

    public final void g() {
        this.f64964a = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
        this.f64965b = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
        this.f64966c = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
        this.f64967d = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
        this.f64968e = f64961f;
    }

    public final void h() {
        this.f64964a = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
        this.f64965b = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
        this.f64966c = "https://toblog.tobsnssdk.com/service/2/log_settings/";
        this.f64967d = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
        this.f64968e = f64962g;
    }

    public final void i() {
        this.f64964a = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
        this.f64965b = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
        this.f64966c = "https://toblog.itobsnssdk.com/service/2/log_settings/";
        this.f64967d = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
        this.f64968e = f64963h;
    }
}
