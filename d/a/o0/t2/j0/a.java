package d.a.o0.t2.j0;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.n0.r.s.a;
import d.a.o0.q.d.g.b;
import d.a.o0.t2.c0.h;
import d.a.o0.t2.f0.b.f;
import d.a.o0.t2.y;
/* loaded from: classes5.dex */
public class a extends d.a.o0.t2.j0.e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f64983g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64984h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f64985i;
    public d.a.o0.k1.o.c j;
    public String k;
    public DownloadCacheKey l;
    public d.a.o0.q.d.h.d m;
    public boolean n;
    public boolean o;
    public CustomMessageListener p;

    /* renamed from: d.a.o0.t2.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1682a implements b.a {
        public C1682a() {
        }

        @Override // d.a.o0.q.d.g.b.a
        public boolean b(View view) {
            d.a.o0.k1.o.h.c.h(a.this.f65010e);
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f64987e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f64988f;

        public b(AdvertAppInfo advertAppInfo, int i2) {
            this.f64987e = advertAppInfo;
            this.f64988f = i2;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            a.this.r(this.f64987e, this.f64988f);
            if (a.this.f64985i != null) {
                a.this.f64985i.v(a.this.A(this.f64987e, this.f64988f));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c(a aVar) {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            if (customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(a.this.k) || !a.this.k.equals(downloadData.getId())) {
                return;
            }
            a.this.f64985i.r(downloadData);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public AdvertAppInfo f64991e;

        public e(AdvertAppInfo advertAppInfo) {
            this.f64991e = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                boolean z = view == a.this.f64985i;
                d.a.o0.k1.o.h.c.h(a.this.f65010e);
                if (a.this.v()) {
                    a.this.f64985i.performClick();
                    return;
                }
                AdvertAppInfo advertAppInfo = this.f64991e;
                if (advertAppInfo != null) {
                    int d2 = d.a.c.e.m.b.d(advertAppInfo.P3, -1);
                    int m = ApkDownloadView.m(a.this.A(this.f64991e, d2));
                    if ((6 == m || 7 == m) && j.z() && !j.H()) {
                        a.this.z(this.f64991e, d2, true, null);
                        return;
                    }
                    a aVar = a.this;
                    aVar.s(this.f64991e, d2, aVar.f64985i, z);
                    return;
                }
                return;
            }
            a.this.f65011f.showToast(R.string.neterror);
        }
    }

    public a(View view, String str) {
        super(view, str);
        this.m = null;
        this.n = false;
        this.p = new d(2016483);
        t();
    }

    public final DownloadData A(AdvertAppInfo advertAppInfo, int i2) {
        DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
        downloadData.setUrl(advertAppInfo.a4);
        downloadData.setName(advertAppInfo.W3);
        downloadData.setPosition(i2);
        downloadData.setNotifyId(d.a.c.e.m.b.d(advertAppInfo.J3, 0));
        return downloadData;
    }

    public void B() {
        if (this.l == null || this.m == null) {
            return;
        }
        d.a.o0.q.d.e.c().q(this.l, this.m);
    }

    @Override // d.a.o0.t2.j0.e
    public void c() {
        super.c();
        SkinManager.setViewTextColor(this.f64984h, R.color.CAM_X0101, 1);
        this.f64985i.setTextColorInitSkin(R.color.CAM_X0101);
        this.f64985i.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.f64985i.i();
    }

    @Override // d.a.o0.t2.j0.e
    public void d(f fVar) {
        super.d(fVar);
        int i2 = 0;
        this.f64983g.U(fVar.f64896c, 10, false);
        this.f64984h.setText(fVar.f64895b);
        this.f64985i.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
        this.f64985i.setInitText(fVar.f64898e);
        d.a.o0.k1.o.h.b bVar = this.f65010e;
        if (bVar instanceof AdCard) {
            this.n = ((AdCard) bVar).isDirectDownload();
        }
        AdvertAppInfo advertAppInfo = this.f65009d;
        if (advertAppInfo != null) {
            e eVar = new e(advertAppInfo);
            this.f65007b.setOnClickListener(eVar);
            if (v()) {
                this.f64985i.setOnClickInterceptListener(new C1682a());
            } else {
                this.f64985i.setOnClickListener(eVar);
            }
            try {
                if (!TextUtils.isEmpty(this.f65009d.P3)) {
                    i2 = Integer.valueOf(this.f65009d.P3).intValue();
                }
            } catch (NumberFormatException unused) {
            }
            AdvertAppInfo advertAppInfo2 = this.f65009d;
            this.k = advertAppInfo2.b4;
            DownloadData A = A(advertAppInfo2, i2);
            x(A);
            this.f64985i.setData(A);
        }
        if (!v()) {
            this.f64985i.j(this.f65011f.getUniqueId());
        }
        this.p.setTag(this.f65011f.getUniqueId());
        u();
        c();
    }

    @Override // d.a.o0.t2.j0.e
    public void h(d.a.o0.k1.o.c cVar) {
        this.j = cVar;
    }

    public final void q(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.l = downloadCacheKey;
        B();
        AdDownloadData b2 = d.a.o0.q.d.e.c().b(downloadCacheKey);
        if (b2 != null) {
            this.f64985i.c(b2.getCurrentState());
        } else {
            this.f64985i.c(DownloadStatus.STATUS_NONE);
        }
        AdvertAppInfo advertAppInfo = this.f65009d;
        String str = advertAppInfo != null ? advertAppInfo.T3 : "";
        AdvertAppInfo advertAppInfo2 = this.f65009d;
        b2.setExtInfo(advertAppInfo2 != null ? advertAppInfo2.Q3 : "");
        b2.setPage(str);
        AdvertAppInfo advertAppInfo3 = this.f65009d;
        b2.setDeeplinkUrl(advertAppInfo3 != null ? advertAppInfo3.Z3 : "");
        d.a.o0.q.c.b.d.a aVar = new d.a.o0.q.c.b.d.a(this.f64985i, b2);
        this.m = new d.a.o0.q.d.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        w();
    }

    public void r(AdvertAppInfo advertAppInfo, int i2) {
        if (advertAppInfo == null) {
            return;
        }
        if (!y.c(this.f65011f.getPageActivity())) {
            l.L(this.f65011f.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            return;
        }
        d.a.o0.k1.o.c cVar = this.j;
        if (cVar != null) {
            cVar.a(advertAppInfo, i2);
        }
    }

    public void s(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo == null) {
            return;
        }
        DownloadData A = A(advertAppInfo, i2);
        int m = ApkDownloadView.m(A);
        Log.e("guoqiangxiang", "status: " + m + " id: " + A.getId());
        if (m != 1) {
            if (m == 3) {
                h.d(this.f65011f.getPageActivity(), advertAppInfo.b4);
                return;
            } else if (m != 5) {
                if (m == 6 || m == 7) {
                    r(advertAppInfo, i2);
                    apkDownloadView.s(A);
                    return;
                }
                return;
            }
        }
        h.a(advertAppInfo);
        apkDownloadView.p(A);
    }

    public final void t() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f64983g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f64983g.setDefaultBgResource(R.color.CAM_X0205);
        this.f64983g.setIsRound(true);
        this.f64984h = (TextView) b(R.id.user_name);
        this.f64985i = (ApkDownloadView) b(R.id.download_view);
        MessageManager.getInstance().registerListener(this.p);
    }

    public final void u() {
        AdvertAppInfo advertAppInfo;
        if (!v() || (advertAppInfo = this.f65009d) == null) {
            return;
        }
        String downloadId = advertAppInfo.getDownloadId();
        DownloadCacheKey g2 = !TextUtils.isEmpty(downloadId) ? d.a.o0.q.d.e.c().g(downloadId) : null;
        if (g2 == null) {
            AdvertAppInfo advertAppInfo2 = this.f65009d;
            g2 = DownloadCacheKey.create(downloadId, advertAppInfo2.a4, advertAppInfo2.b4);
            d.a.o0.q.d.e.c().i(g2, null);
        }
        q(g2);
    }

    public final boolean v() {
        return !this.n || this.o;
    }

    public void w() {
        if (this.l == null || this.m == null) {
            return;
        }
        d.a.o0.q.d.e.c().i(this.l, this.m);
    }

    public final void x(DownloadData downloadData) {
        if (v()) {
            ApkDownloadView apkDownloadView = this.f64985i;
            if (apkDownloadView == null) {
                return;
            }
            downloadData.setStatus(apkDownloadView.getDownloadStatus());
            return;
        }
        downloadData.setStatus(ApkDownloadView.m(downloadData));
    }

    public void y(boolean z) {
        this.o = z;
    }

    public void z(AdvertAppInfo advertAppInfo, int i2, boolean z, String str) {
        if (advertAppInfo == null) {
            return;
        }
        if (!j.A()) {
            l.L(this.f65011f.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.F4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.f65011f.getString(R.string.frs_network_tips);
            }
            d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f65011f.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new b(advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new c(this));
            aVar.create(this.f65011f).show();
        }
    }
}
