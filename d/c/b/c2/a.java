package d.c.b.c2;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f65807f = {"https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f65808g = {"https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f65809h = {"https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com"};

    /* renamed from: a  reason: collision with root package name */
    public String f65810a;

    /* renamed from: b  reason: collision with root package name */
    public String f65811b;

    /* renamed from: c  reason: collision with root package name */
    public String f65812c;

    /* renamed from: d  reason: collision with root package name */
    public String f65813d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f65814e;

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
        return this.f65810a;
    }

    public String c() {
        return this.f65811b;
    }

    public String d() {
        return this.f65812c;
    }

    public String e() {
        return this.f65813d;
    }

    public String[] f() {
        return this.f65814e;
    }

    public final void g() {
        this.f65810a = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
        this.f65811b = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
        this.f65812c = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
        this.f65813d = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
        this.f65814e = f65807f;
    }

    public final void h() {
        this.f65810a = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
        this.f65811b = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
        this.f65812c = "https://toblog.tobsnssdk.com/service/2/log_settings/";
        this.f65813d = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
        this.f65814e = f65808g;
    }

    public final void i() {
        this.f65810a = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
        this.f65811b = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
        this.f65812c = "https://toblog.itobsnssdk.com/service/2/log_settings/";
        this.f65813d = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
        this.f65814e = f65809h;
    }
}
