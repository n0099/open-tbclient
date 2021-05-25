package d.r.b.a.a;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IReporter;
import com.yy.mobile.framework.revenuesdk.giftapi.IGiftService;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import d.r.b.a.a.f.f.a;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a implements IRevenue, d.r.b.a.a.f.c.c, d.r.b.a.a.f.c.d {

    /* renamed from: a  reason: collision with root package name */
    public int f67656a;

    /* renamed from: b  reason: collision with root package name */
    public int f67657b;

    /* renamed from: c  reason: collision with root package name */
    public String f67658c;

    /* renamed from: d  reason: collision with root package name */
    public String f67659d;

    /* renamed from: e  reason: collision with root package name */
    public String f67660e;

    /* renamed from: f  reason: collision with root package name */
    public String f67661f;

    /* renamed from: g  reason: collision with root package name */
    public IGiftService f67662g;

    /* renamed from: h  reason: collision with root package name */
    public IAppPayService f67663h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public IReporter f67664i;
    public d.r.b.a.a.k.a j;

    public a(int i2) {
        this.f67656a = i2;
    }

    public final void a(Context context, String str, String str2, boolean z, boolean z2) {
        this.f67662g = (IGiftService) e.f67685a.a(IGiftService.class, this.f67656a, this.f67657b, this.f67658c, this.f67659d, str, str2, z, z2, this, context, this.f67664i, this.j);
        this.f67663h = (IAppPayService) e.f67685a.a(IAppPayService.class, this.f67656a, this.f67657b, this.f67658c, this.f67659d, str, str2, z, z2, this, context, this.f67664i, this.j);
        if (this.f67662g == null) {
            this.f67662g = new d.r.b.a.a.l.a();
        }
        if (this.f67663h == null) {
            this.f67663h = new d.r.b.a.a.l.b();
        }
    }

    public void b(b bVar) {
        d.r.b.a.a.f.d.d.f("Revenue", "initConfig -> versionName:4.1.4-bdpay");
        if (bVar != null) {
            if (bVar.v() != null) {
                bVar.A();
                this.f67657b = bVar.B();
                bVar.u();
                this.f67659d = bVar.r();
                this.f67660e = bVar.z();
                this.f67661f = bVar.w();
                this.f67664i = bVar.y().getReporter();
                this.j = new d.r.b.a.a.k.a(bVar);
                this.f67658c = bVar.t();
                c.a(this.f67656a, bVar);
                d(bVar);
                c(bVar);
                a(bVar.s(), this.f67660e, this.f67661f, false, bVar.x());
                return;
            }
            throw new IllegalArgumentException("Data Sender == null,Revenue init fail!");
        }
        throw new IllegalArgumentException("init Revenue config == null!");
    }

    public final void c(b bVar) {
        d.r.b.a.a.f.d.a.f67707b = String.valueOf(this.f67656a);
        d.r.b.a.a.f.d.a.f67710e = bVar.y().getAppName();
        d.r.b.a.a.f.d.a.f67708c = Build.MANUFACTURER + "_" + Build.MODEL;
        StringBuilder sb = new StringBuilder();
        sb.append("Android");
        sb.append(Build.VERSION.RELEASE);
        d.r.b.a.a.f.d.a.f67709d = sb.toString();
        d.r.b.a.a.f.d.a.f67711f = bVar.r();
        d.r.b.a.a.f.d.a.f67706a = bVar.A() + "";
        d.r.b.a.a.f.d.a.f67713h = "4.1.4-bdpay";
        d.r.b.a.a.f.d.a.f67712g = bVar.y().getDeviceId();
    }

    public final void d(b bVar) {
        a.c.p = String.valueOf(this.f67656a);
        a.c.q = 2;
        a.c.r = Build.MANUFACTURER + "_" + Build.MODEL;
        StringBuilder sb = new StringBuilder();
        sb.append("Android");
        sb.append(Build.VERSION.RELEASE);
        a.c.s = sb.toString();
        a.c.t = bVar.t();
        a.C1901a.f67749a = Float.valueOf(bVar.y().getReportRatio());
        a.C1901a.f67750b = bVar.y().getAppName();
        d.r.b.a.a.f.d.d.b("Revenue", "ReportRatio:" + a.C1901a.f67749a);
    }

    @Override // d.r.b.a.a.f.c.c
    public void g(int i2, String str, int i3, int i4, String str2) {
        IGiftService iGiftService = this.f67662g;
        if (iGiftService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iGiftService).g(i2, str, i3, i4, str2);
        }
        IAppPayService iAppPayService = this.f67663h;
        if (iAppPayService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iAppPayService).g(i2, str, i3, i4, str2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IAppPayService getAppPayService() {
        return this.f67663h;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IGiftService getGiftService() {
        return this.f67662g;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public d.r.b.a.a.f.f.b getSDKReporter() {
        return this.j;
    }

    @Override // d.r.b.a.a.f.c.c
    public void h(int i2, d.r.b.a.a.f.e.b bVar) {
        int i3 = this.f67656a;
        if (i3 != i2) {
            d.r.b.a.a.f.d.d.c("Revenue", "currentAppId = %d, BroadcastData appId not match!", Integer.valueOf(i3));
            return;
        }
        IGiftService iGiftService = this.f67662g;
        if (iGiftService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iGiftService).h(i2, bVar);
        }
        IAppPayService iAppPayService = this.f67663h;
        if (iAppPayService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iAppPayService).h(i2, bVar);
        }
    }

    @Override // d.r.b.a.a.f.c.c
    public void j(int i2, d.r.b.a.a.f.e.e eVar) {
        int i3 = this.f67656a;
        if (i3 != i2) {
            d.r.b.a.a.f.d.d.c("Revenue", "currentAppId = %d, UnicastData appId not match!", Integer.valueOf(i3));
            return;
        }
        IGiftService iGiftService = this.f67662g;
        if (iGiftService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iGiftService).j(i2, eVar);
        }
        IAppPayService iAppPayService = this.f67663h;
        if (iAppPayService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iAppPayService).j(i2, eVar);
        }
    }

    @Override // d.r.b.a.a.f.c.c
    public void k(int i2, d.r.b.a.a.f.e.d dVar) {
        int i3 = this.f67656a;
        if (i3 != i2) {
            d.r.b.a.a.f.d.d.c("Revenue", "currentAppId = %d, ResponseData appId not match!", Integer.valueOf(i3));
            return;
        }
        IGiftService iGiftService = this.f67662g;
        if (iGiftService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iGiftService).k(i2, dVar);
        }
        IAppPayService iAppPayService = this.f67663h;
        if (iAppPayService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iAppPayService).k(i2, dVar);
        }
    }

    @Override // d.r.b.a.a.f.c.d
    public void sendData(int i2, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        b b2 = c.b(this.f67656a);
        if (b2 == null || b2.v() == null) {
            return;
        }
        b2.v().sendData(this.f67656a, str, arrayList, bArr);
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void sendHeartBeat(long j, String str) {
        String a2 = d.r.b.a.a.f.h.e.a();
        d.r.b.a.a.h.a aVar = new d.r.b.a.a.h.a(j, this.f67656a, a2, str);
        b b2 = c.b(this.f67656a);
        if (b2 == null || b2.v() == null) {
            return;
        }
        b2.v().sendData(this.f67656a, a2, null, aVar.b());
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void updateConfig(b bVar) {
        if (bVar != null) {
            c.a(this.f67656a, bVar);
            if (bVar.v() != null) {
                this.f67658c = bVar.t();
                bVar.A();
                String str = this.f67658c;
                a.c.t = str;
                IGiftService iGiftService = this.f67662g;
                if (iGiftService != null) {
                    iGiftService.setCountryCode(str);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Data Sender == null,Revenue update fail!");
        }
        throw new IllegalArgumentException("update Revenue config == null!");
    }
}
