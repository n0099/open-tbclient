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
    public int f67613a;

    /* renamed from: b  reason: collision with root package name */
    public int f67614b;

    /* renamed from: c  reason: collision with root package name */
    public String f67615c;

    /* renamed from: d  reason: collision with root package name */
    public String f67616d;

    /* renamed from: e  reason: collision with root package name */
    public String f67617e;

    /* renamed from: f  reason: collision with root package name */
    public String f67618f;

    /* renamed from: g  reason: collision with root package name */
    public IGiftService f67619g;

    /* renamed from: h  reason: collision with root package name */
    public IAppPayService f67620h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public IReporter f67621i;
    public d.r.b.a.a.k.a j;

    public a(int i2) {
        this.f67613a = i2;
    }

    public final void a(Context context, String str, String str2, boolean z, boolean z2) {
        this.f67619g = (IGiftService) e.f67642a.a(IGiftService.class, this.f67613a, this.f67614b, this.f67615c, this.f67616d, str, str2, z, z2, this, context, this.f67621i, this.j);
        this.f67620h = (IAppPayService) e.f67642a.a(IAppPayService.class, this.f67613a, this.f67614b, this.f67615c, this.f67616d, str, str2, z, z2, this, context, this.f67621i, this.j);
        if (this.f67619g == null) {
            this.f67619g = new d.r.b.a.a.l.a();
        }
        if (this.f67620h == null) {
            this.f67620h = new d.r.b.a.a.l.b();
        }
    }

    public void b(b bVar) {
        d.r.b.a.a.f.d.d.f("Revenue", "initConfig -> versionName:4.1.4-bdpay");
        if (bVar != null) {
            if (bVar.v() != null) {
                bVar.A();
                this.f67614b = bVar.B();
                bVar.u();
                this.f67616d = bVar.r();
                this.f67617e = bVar.z();
                this.f67618f = bVar.w();
                this.f67621i = bVar.y().getReporter();
                this.j = new d.r.b.a.a.k.a(bVar);
                this.f67615c = bVar.t();
                c.a(this.f67613a, bVar);
                d(bVar);
                c(bVar);
                a(bVar.s(), this.f67617e, this.f67618f, false, bVar.x());
                return;
            }
            throw new IllegalArgumentException("Data Sender == null,Revenue init fail!");
        }
        throw new IllegalArgumentException("init Revenue config == null!");
    }

    public final void c(b bVar) {
        d.r.b.a.a.f.d.a.f67664b = String.valueOf(this.f67613a);
        d.r.b.a.a.f.d.a.f67667e = bVar.y().getAppName();
        d.r.b.a.a.f.d.a.f67665c = Build.MANUFACTURER + "_" + Build.MODEL;
        StringBuilder sb = new StringBuilder();
        sb.append("Android");
        sb.append(Build.VERSION.RELEASE);
        d.r.b.a.a.f.d.a.f67666d = sb.toString();
        d.r.b.a.a.f.d.a.f67668f = bVar.r();
        d.r.b.a.a.f.d.a.f67663a = bVar.A() + "";
        d.r.b.a.a.f.d.a.f67670h = "4.1.4-bdpay";
        d.r.b.a.a.f.d.a.f67669g = bVar.y().getDeviceId();
    }

    public final void d(b bVar) {
        a.c.p = String.valueOf(this.f67613a);
        a.c.q = 2;
        a.c.r = Build.MANUFACTURER + "_" + Build.MODEL;
        StringBuilder sb = new StringBuilder();
        sb.append("Android");
        sb.append(Build.VERSION.RELEASE);
        a.c.s = sb.toString();
        a.c.t = bVar.t();
        a.C1897a.f67706a = Float.valueOf(bVar.y().getReportRatio());
        a.C1897a.f67707b = bVar.y().getAppName();
        d.r.b.a.a.f.d.d.b("Revenue", "ReportRatio:" + a.C1897a.f67706a);
    }

    @Override // d.r.b.a.a.f.c.c
    public void g(int i2, String str, int i3, int i4, String str2) {
        IGiftService iGiftService = this.f67619g;
        if (iGiftService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iGiftService).g(i2, str, i3, i4, str2);
        }
        IAppPayService iAppPayService = this.f67620h;
        if (iAppPayService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iAppPayService).g(i2, str, i3, i4, str2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IAppPayService getAppPayService() {
        return this.f67620h;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IGiftService getGiftService() {
        return this.f67619g;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public d.r.b.a.a.f.f.b getSDKReporter() {
        return this.j;
    }

    @Override // d.r.b.a.a.f.c.c
    public void h(int i2, d.r.b.a.a.f.e.b bVar) {
        int i3 = this.f67613a;
        if (i3 != i2) {
            d.r.b.a.a.f.d.d.c("Revenue", "currentAppId = %d, BroadcastData appId not match!", Integer.valueOf(i3));
            return;
        }
        IGiftService iGiftService = this.f67619g;
        if (iGiftService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iGiftService).h(i2, bVar);
        }
        IAppPayService iAppPayService = this.f67620h;
        if (iAppPayService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iAppPayService).h(i2, bVar);
        }
    }

    @Override // d.r.b.a.a.f.c.c
    public void j(int i2, d.r.b.a.a.f.e.e eVar) {
        int i3 = this.f67613a;
        if (i3 != i2) {
            d.r.b.a.a.f.d.d.c("Revenue", "currentAppId = %d, UnicastData appId not match!", Integer.valueOf(i3));
            return;
        }
        IGiftService iGiftService = this.f67619g;
        if (iGiftService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iGiftService).j(i2, eVar);
        }
        IAppPayService iAppPayService = this.f67620h;
        if (iAppPayService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iAppPayService).j(i2, eVar);
        }
    }

    @Override // d.r.b.a.a.f.c.c
    public void k(int i2, d.r.b.a.a.f.e.d dVar) {
        int i3 = this.f67613a;
        if (i3 != i2) {
            d.r.b.a.a.f.d.d.c("Revenue", "currentAppId = %d, ResponseData appId not match!", Integer.valueOf(i3));
            return;
        }
        IGiftService iGiftService = this.f67619g;
        if (iGiftService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iGiftService).k(i2, dVar);
        }
        IAppPayService iAppPayService = this.f67620h;
        if (iAppPayService instanceof d.r.b.a.a.f.c.c) {
            ((d.r.b.a.a.f.c.c) iAppPayService).k(i2, dVar);
        }
    }

    @Override // d.r.b.a.a.f.c.d
    public void sendData(int i2, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        b b2 = c.b(this.f67613a);
        if (b2 == null || b2.v() == null) {
            return;
        }
        b2.v().sendData(this.f67613a, str, arrayList, bArr);
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void sendHeartBeat(long j, String str) {
        String a2 = d.r.b.a.a.f.h.e.a();
        d.r.b.a.a.h.a aVar = new d.r.b.a.a.h.a(j, this.f67613a, a2, str);
        b b2 = c.b(this.f67613a);
        if (b2 == null || b2.v() == null) {
            return;
        }
        b2.v().sendData(this.f67613a, a2, null, aVar.b());
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void updateConfig(b bVar) {
        if (bVar != null) {
            c.a(this.f67613a, bVar);
            if (bVar.v() != null) {
                this.f67615c = bVar.t();
                bVar.A();
                String str = this.f67615c;
                a.c.t = str;
                IGiftService iGiftService = this.f67619g;
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
