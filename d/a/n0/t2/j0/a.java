package d.a.n0.t2.j0;

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
import d.a.m0.r.s.a;
import d.a.n0.q.d.g.b;
import d.a.n0.t2.c0.h;
import d.a.n0.t2.f0.b.f;
import d.a.n0.t2.y;
/* loaded from: classes5.dex */
public class a extends d.a.n0.t2.j0.e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f61166g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61167h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f61168i;
    public d.a.n0.k1.o.c j;
    public String k;
    public DownloadCacheKey l;
    public d.a.n0.q.d.h.d m;
    public boolean n;
    public boolean o;
    public CustomMessageListener p;

    /* renamed from: d.a.n0.t2.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1622a implements b.a {
        public C1622a() {
        }

        @Override // d.a.n0.q.d.g.b.a
        public boolean b(View view) {
            d.a.n0.k1.o.h.c.h(a.this.f61193e);
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f61170e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f61171f;

        public b(AdvertAppInfo advertAppInfo, int i2) {
            this.f61170e = advertAppInfo;
            this.f61171f = i2;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            a.this.r(this.f61170e, this.f61171f);
            if (a.this.f61168i != null) {
                a.this.f61168i.v(a.this.A(this.f61170e, this.f61171f));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c(a aVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
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
            a.this.f61168i.r(downloadData);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public AdvertAppInfo f61174e;

        public e(AdvertAppInfo advertAppInfo) {
            this.f61174e = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                boolean z = view == a.this.f61168i;
                d.a.n0.k1.o.h.c.h(a.this.f61193e);
                if (a.this.v()) {
                    a.this.f61168i.performClick();
                    return;
                }
                AdvertAppInfo advertAppInfo = this.f61174e;
                if (advertAppInfo != null) {
                    int d2 = d.a.c.e.m.b.d(advertAppInfo.M3, -1);
                    int m = ApkDownloadView.m(a.this.A(this.f61174e, d2));
                    if ((6 == m || 7 == m) && j.z() && !j.H()) {
                        a.this.z(this.f61174e, d2, true, null);
                        return;
                    }
                    a aVar = a.this;
                    aVar.s(this.f61174e, d2, aVar.f61168i, z);
                    return;
                }
                return;
            }
            a.this.f61194f.showToast(R.string.neterror);
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
        downloadData.setUrl(advertAppInfo.X3);
        downloadData.setName(advertAppInfo.T3);
        downloadData.setPosition(i2);
        downloadData.setNotifyId(d.a.c.e.m.b.d(advertAppInfo.G3, 0));
        return downloadData;
    }

    public void B() {
        if (this.l == null || this.m == null) {
            return;
        }
        d.a.n0.q.d.e.c().q(this.l, this.m);
    }

    @Override // d.a.n0.t2.j0.e
    public void c() {
        super.c();
        SkinManager.setViewTextColor(this.f61167h, R.color.CAM_X0101, 1);
        this.f61168i.setTextColorInitSkin(R.color.CAM_X0101);
        this.f61168i.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.f61168i.i();
    }

    @Override // d.a.n0.t2.j0.e
    public void d(f fVar) {
        super.d(fVar);
        int i2 = 0;
        this.f61166g.V(fVar.f61079c, 10, false);
        this.f61167h.setText(fVar.f61078b);
        this.f61168i.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
        this.f61168i.setInitText(fVar.f61081e);
        d.a.n0.k1.o.h.b bVar = this.f61193e;
        if (bVar instanceof AdCard) {
            this.n = ((AdCard) bVar).isDirectDownload();
        }
        AdvertAppInfo advertAppInfo = this.f61192d;
        if (advertAppInfo != null) {
            e eVar = new e(advertAppInfo);
            this.f61190b.setOnClickListener(eVar);
            if (v()) {
                this.f61168i.setOnClickInterceptListener(new C1622a());
            } else {
                this.f61168i.setOnClickListener(eVar);
            }
            try {
                if (!TextUtils.isEmpty(this.f61192d.M3)) {
                    i2 = Integer.valueOf(this.f61192d.M3).intValue();
                }
            } catch (NumberFormatException unused) {
            }
            AdvertAppInfo advertAppInfo2 = this.f61192d;
            this.k = advertAppInfo2.Y3;
            DownloadData A = A(advertAppInfo2, i2);
            x(A);
            this.f61168i.setData(A);
        }
        if (!v()) {
            this.f61168i.j(this.f61194f.getUniqueId());
        }
        this.p.setTag(this.f61194f.getUniqueId());
        u();
        c();
    }

    @Override // d.a.n0.t2.j0.e
    public void h(d.a.n0.k1.o.c cVar) {
        this.j = cVar;
    }

    public final void q(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.l = downloadCacheKey;
        B();
        AdDownloadData b2 = d.a.n0.q.d.e.c().b(downloadCacheKey);
        if (b2 != null) {
            this.f61168i.c(b2.getCurrentState());
        } else {
            this.f61168i.c(DownloadStatus.STATUS_NONE);
        }
        AdvertAppInfo advertAppInfo = this.f61192d;
        String str = advertAppInfo != null ? advertAppInfo.Q3 : "";
        AdvertAppInfo advertAppInfo2 = this.f61192d;
        b2.setExtInfo(advertAppInfo2 != null ? advertAppInfo2.N3 : "");
        b2.setPage(str);
        AdvertAppInfo advertAppInfo3 = this.f61192d;
        b2.setDeeplinkUrl(advertAppInfo3 != null ? advertAppInfo3.W3 : "");
        d.a.n0.q.c.b.d.a aVar = new d.a.n0.q.c.b.d.a(this.f61168i, b2);
        this.m = new d.a.n0.q.d.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        w();
    }

    public void r(AdvertAppInfo advertAppInfo, int i2) {
        if (advertAppInfo == null) {
            return;
        }
        if (!y.c(this.f61194f.getPageActivity())) {
            l.L(this.f61194f.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            return;
        }
        d.a.n0.k1.o.c cVar = this.j;
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
                h.d(this.f61194f.getPageActivity(), advertAppInfo.Y3);
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
        this.f61166g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f61166g.setDefaultBgResource(R.color.CAM_X0205);
        this.f61166g.setIsRound(true);
        this.f61167h = (TextView) b(R.id.user_name);
        this.f61168i = (ApkDownloadView) b(R.id.download_view);
        MessageManager.getInstance().registerListener(this.p);
    }

    public final void u() {
        AdvertAppInfo advertAppInfo;
        if (!v() || (advertAppInfo = this.f61192d) == null) {
            return;
        }
        String downloadId = advertAppInfo.getDownloadId();
        DownloadCacheKey g2 = !TextUtils.isEmpty(downloadId) ? d.a.n0.q.d.e.c().g(downloadId) : null;
        if (g2 == null) {
            AdvertAppInfo advertAppInfo2 = this.f61192d;
            g2 = DownloadCacheKey.create(downloadId, advertAppInfo2.X3, advertAppInfo2.Y3);
            d.a.n0.q.d.e.c().i(g2, null);
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
        d.a.n0.q.d.e.c().i(this.l, this.m);
    }

    public final void x(DownloadData downloadData) {
        if (v()) {
            ApkDownloadView apkDownloadView = this.f61168i;
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
            l.L(this.f61194f.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.E4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.f61194f.getString(R.string.frs_network_tips);
            }
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f61194f.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new b(advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new c(this));
            aVar.create(this.f61194f).show();
        }
    }
}
