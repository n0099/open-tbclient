package d.r.b.a.a.f;

import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import d.r.b.a.a.f.d.d;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f67643a;

    /* renamed from: b  reason: collision with root package name */
    public String f67644b;

    /* renamed from: c  reason: collision with root package name */
    public String f67645c;

    /* renamed from: d  reason: collision with root package name */
    public String f67646d;

    /* renamed from: e  reason: collision with root package name */
    public ProtocolType f67647e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67648f;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f67649a = new a();
    }

    public static a c() {
        return b.f67649a;
    }

    public ProtocolType a() {
        return this.f67647e;
    }

    public void b(boolean z, ProtocolType protocolType) {
        this.f67648f = z;
        this.f67647e = protocolType;
        this.f67643a = z ? 60001 : 30079;
        this.f67644b = this.f67643a + "";
        d.b("Revenue-Env", "SERVICE_REVENUE_REPORT_TAG:" + this.f67644b);
        this.f67645c = this.f67648f ? "https://turnover-pre.yy.com" : "https://turnover.yy.com";
        this.f67646d = this.f67648f ? "00000" : "00001";
        d.b("Revenue-Env", "REVENUE_HTTP_REPORT_TAG:" + this.f67646d);
    }

    public boolean d() {
        return this.f67648f;
    }

    public a() {
        this.f67643a = 60001;
        this.f67644b = "";
        this.f67645c = "";
        this.f67646d = "";
        this.f67647e = ProtocolType.HTTP;
        d.b("Revenue-Env", " env init()");
    }
}
