package d.c.b.c2;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f64962f = {"https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f64963g = {"https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f64964h = {"https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com"};

    /* renamed from: a  reason: collision with root package name */
    public String f64965a;

    /* renamed from: b  reason: collision with root package name */
    public String f64966b;

    /* renamed from: c  reason: collision with root package name */
    public String f64967c;

    /* renamed from: d  reason: collision with root package name */
    public String f64968d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f64969e;

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
        return this.f64965a;
    }

    public String c() {
        return this.f64966b;
    }

    public String d() {
        return this.f64967c;
    }

    public String e() {
        return this.f64968d;
    }

    public String[] f() {
        return this.f64969e;
    }

    public final void g() {
        this.f64965a = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
        this.f64966b = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
        this.f64967c = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
        this.f64968d = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
        this.f64969e = f64962f;
    }

    public final void h() {
        this.f64965a = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
        this.f64966b = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
        this.f64967c = "https://toblog.tobsnssdk.com/service/2/log_settings/";
        this.f64968d = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
        this.f64969e = f64963g;
    }

    public final void i() {
        this.f64965a = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
        this.f64966b = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
        this.f64967c = "https://toblog.itobsnssdk.com/service/2/log_settings/";
        this.f64968d = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
        this.f64969e = f64964h;
    }
}
