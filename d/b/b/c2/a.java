package d.b.b.c2;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f68821f = {"https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f68822g = {"https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f68823h = {"https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com"};

    /* renamed from: a  reason: collision with root package name */
    public String f68824a;

    /* renamed from: b  reason: collision with root package name */
    public String f68825b;

    /* renamed from: c  reason: collision with root package name */
    public String f68826c;

    /* renamed from: d  reason: collision with root package name */
    public String f68827d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f68828e;

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
        return this.f68824a;
    }

    public String c() {
        return this.f68825b;
    }

    public String d() {
        return this.f68826c;
    }

    public String e() {
        return this.f68827d;
    }

    public String[] f() {
        return this.f68828e;
    }

    public final void g() {
        this.f68824a = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
        this.f68825b = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
        this.f68826c = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
        this.f68827d = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
        this.f68828e = f68821f;
    }

    public final void h() {
        this.f68824a = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
        this.f68825b = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
        this.f68826c = "https://toblog.tobsnssdk.com/service/2/log_settings/";
        this.f68827d = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
        this.f68828e = f68822g;
    }

    public final void i() {
        this.f68824a = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
        this.f68825b = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
        this.f68826c = "https://toblog.itobsnssdk.com/service/2/log_settings/";
        this.f68827d = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
        this.f68828e = f68823h;
    }
}
