package d.r.b.a.a.f;

import com.baidu.android.imsdk.IMConstants;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import d.r.b.a.a.f.d.d;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f67686a;

    /* renamed from: b  reason: collision with root package name */
    public String f67687b;

    /* renamed from: c  reason: collision with root package name */
    public String f67688c;

    /* renamed from: d  reason: collision with root package name */
    public String f67689d;

    /* renamed from: e  reason: collision with root package name */
    public ProtocolType f67690e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67691f;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f67692a = new a();
    }

    public static a c() {
        return b.f67692a;
    }

    public ProtocolType a() {
        return this.f67690e;
    }

    public void b(boolean z, ProtocolType protocolType) {
        this.f67691f = z;
        this.f67690e = protocolType;
        this.f67686a = z ? IMConstants.ERROR_JOIN_GROUP_NUMBER_FULL : 30079;
        this.f67687b = this.f67686a + "";
        d.b("Revenue-Env", "SERVICE_REVENUE_REPORT_TAG:" + this.f67687b);
        this.f67688c = this.f67691f ? "https://turnover-pre.yy.com" : "https://turnover.yy.com";
        this.f67689d = this.f67691f ? "00000" : "00001";
        d.b("Revenue-Env", "REVENUE_HTTP_REPORT_TAG:" + this.f67689d);
    }

    public boolean d() {
        return this.f67691f;
    }

    public a() {
        this.f67686a = IMConstants.ERROR_JOIN_GROUP_NUMBER_FULL;
        this.f67687b = "";
        this.f67688c = "";
        this.f67689d = "";
        this.f67690e = ProtocolType.HTTP;
        d.b("Revenue-Env", " env init()");
    }
}
