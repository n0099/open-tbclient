package d.r.b.a.a.f;

import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import d.r.b.a.a.f.d.d;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f66957a;

    /* renamed from: b  reason: collision with root package name */
    public String f66958b;

    /* renamed from: c  reason: collision with root package name */
    public String f66959c;

    /* renamed from: d  reason: collision with root package name */
    public String f66960d;

    /* renamed from: e  reason: collision with root package name */
    public ProtocolType f66961e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66962f;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f66963a = new a();
    }

    public static a c() {
        return b.f66963a;
    }

    public ProtocolType a() {
        return this.f66961e;
    }

    public void b(boolean z, ProtocolType protocolType) {
        this.f66962f = z;
        this.f66961e = protocolType;
        this.f66957a = z ? 60001 : 30079;
        this.f66958b = this.f66957a + "";
        d.b("Revenue-Env", "SERVICE_REVENUE_REPORT_TAG:" + this.f66958b);
        this.f66959c = this.f66962f ? "https://turnover-pre.yy.com" : "https://turnover.yy.com";
        this.f66960d = this.f66962f ? "00000" : "00001";
        d.b("Revenue-Env", "REVENUE_HTTP_REPORT_TAG:" + this.f66960d);
    }

    public boolean d() {
        return this.f66962f;
    }

    public a() {
        this.f66957a = 60001;
        this.f66958b = "";
        this.f66959c = "";
        this.f66960d = "";
        this.f66961e = ProtocolType.HTTP;
        d.b("Revenue-Env", " env init()");
    }
}
