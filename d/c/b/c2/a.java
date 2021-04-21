package d.c.b.c2;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f65902f = {"https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f65903g = {"https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f65904h = {"https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com"};

    /* renamed from: a  reason: collision with root package name */
    public String f65905a;

    /* renamed from: b  reason: collision with root package name */
    public String f65906b;

    /* renamed from: c  reason: collision with root package name */
    public String f65907c;

    /* renamed from: d  reason: collision with root package name */
    public String f65908d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f65909e;

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
        return this.f65905a;
    }

    public String c() {
        return this.f65906b;
    }

    public String d() {
        return this.f65907c;
    }

    public String e() {
        return this.f65908d;
    }

    public String[] f() {
        return this.f65909e;
    }

    public final void g() {
        this.f65905a = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
        this.f65906b = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
        this.f65907c = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
        this.f65908d = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
        this.f65909e = f65902f;
    }

    public final void h() {
        this.f65905a = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
        this.f65906b = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
        this.f65907c = "https://toblog.tobsnssdk.com/service/2/log_settings/";
        this.f65908d = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
        this.f65909e = f65903g;
    }

    public final void i() {
        this.f65905a = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
        this.f65906b = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
        this.f65907c = "https://toblog.itobsnssdk.com/service/2/log_settings/";
        this.f65908d = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
        this.f65909e = f65904h;
    }
}
