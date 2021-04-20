package d.b.i0.s2.h0;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.h0.r.s.a;
import d.b.i0.o.d.f.b;
import d.b.i0.s2.a0.h;
import d.b.i0.s2.w;
/* loaded from: classes4.dex */
public class a extends d.b.i0.s2.h0.e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f61711g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61712h;
    public TextView i;
    public ApkDownloadView j;
    public d.b.i0.j1.o.c k;
    public String l;
    public DownloadCacheKey m;
    public d.b.i0.o.d.g.d n;
    public boolean o;
    public boolean p;
    public CustomMessageListener q;

    /* renamed from: d.b.i0.s2.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1583a implements b.a {
        public C1583a(a aVar) {
        }

        @Override // d.b.i0.o.d.f.b.a
        public boolean b(View view) {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f61713e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f61714f;

        public b(AdvertAppInfo advertAppInfo, int i) {
            this.f61713e = advertAppInfo;
            this.f61714f = i;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            a.this.r(this.f61713e, this.f61714f);
            if (a.this.j != null) {
                a.this.j.v(a.this.A(this.f61713e, this.f61714f));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c(a aVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            if (customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(a.this.l) || !a.this.l.equals(downloadData.getId())) {
                return;
            }
            a.this.j.r(downloadData);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public AdvertAppInfo f61717e;

        public e(AdvertAppInfo advertAppInfo) {
            this.f61717e = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                boolean z = view == a.this.j;
                d.b.i0.j1.o.h.c.h(a.this.f61734e);
                if (a.this.v()) {
                    a.this.j.performClick();
                    return;
                }
                AdvertAppInfo advertAppInfo = this.f61717e;
                if (advertAppInfo != null) {
                    int d2 = d.b.c.e.m.b.d(advertAppInfo.K3, -1);
                    int m = ApkDownloadView.m(a.this.A(this.f61717e, d2));
                    if ((6 == m || 7 == m) && j.z() && !j.H()) {
                        AdvertAppInfo.a aVar = this.f61717e.U3;
                        a.this.z(this.f61717e, d2, true, aVar != null ? aVar.f12870g : "");
                        return;
                    }
                    a aVar2 = a.this;
                    aVar2.s(this.f61717e, d2, aVar2.j, z);
                    return;
                }
                return;
            }
            a.this.f61735f.showToast(R.string.neterror);
        }
    }

    public a(View view, String str) {
        super(view, str);
        this.n = null;
        this.o = false;
        this.q = new d(2016483);
        t();
    }

    public final DownloadData A(AdvertAppInfo advertAppInfo, int i) {
        String str = advertAppInfo.J3;
        if (str == null) {
            str = advertAppInfo.E3;
        }
        DownloadData downloadData = new DownloadData(str);
        downloadData.setUrl(advertAppInfo.I3);
        downloadData.setName(advertAppInfo.F3);
        downloadData.setPosition(i);
        downloadData.setNotifyId(d.b.c.e.m.b.d(advertAppInfo.E3, 0));
        return downloadData;
    }

    public void B() {
        if (this.m == null || this.n == null) {
            return;
        }
        d.b.i0.o.d.d.c().q(this.m, this.n);
    }

    @Override // d.b.i0.s2.h0.e
    public void c() {
        super.c();
        SkinManager.setViewTextColor(this.f61712h, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0620, 1);
        SkinManager.setBackgroundResource(this.i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        this.j.setTextColorInitSkin(R.color.CAM_X0101);
        this.j.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.j.i();
    }

    @Override // d.b.i0.s2.h0.e
    public void d(d.b.i0.s2.c0.b.e eVar) {
        super.d(eVar);
        int i = 0;
        this.f61711g.W(eVar.f61598c, 10, false);
        this.f61712h.setText(eVar.f61597b);
        this.i.setText(eVar.f61600e);
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
        d.b.i0.j1.o.h.b bVar = this.f61734e;
        if (bVar instanceof AdCard) {
            this.o = ((AdCard) bVar).directDownload;
        }
        AdvertAppInfo advertAppInfo = this.f61733d;
        if (advertAppInfo != null) {
            e eVar2 = new e(advertAppInfo);
            this.f61731b.setOnClickListener(eVar2);
            if (v()) {
                this.j.setOnClickInterceptListener(new C1583a(this));
            } else {
                this.j.setOnClickListener(eVar2);
            }
            try {
                if (!TextUtils.isEmpty(this.f61733d.K3)) {
                    i = Integer.valueOf(this.f61733d.K3).intValue();
                }
            } catch (NumberFormatException unused) {
            }
            AdvertAppInfo advertAppInfo2 = this.f61733d;
            this.l = advertAppInfo2.J3;
            DownloadData A = A(advertAppInfo2, i);
            x(A);
            this.j.setData(A);
        }
        if (!v()) {
            this.j.j(this.f61735f.getUniqueId());
        }
        this.q.setTag(this.f61735f.getUniqueId());
        u();
        c();
    }

    @Override // d.b.i0.s2.h0.e
    public void h(d.b.i0.j1.o.c cVar) {
        this.k = cVar;
    }

    public final void q(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.m = downloadCacheKey;
        B();
        AdDownloadData b2 = d.b.i0.o.d.d.c().b(downloadCacheKey);
        if (b2 != null) {
            this.j.c(b2.getCurrentState());
        } else {
            this.j.c(DownloadStatus.STATUS_NONE);
        }
        AdvertAppInfo advertAppInfo = this.f61733d;
        String str = advertAppInfo != null ? advertAppInfo.c4 : "";
        AdvertAppInfo advertAppInfo2 = this.f61733d;
        b2.setExtInfo(advertAppInfo2 != null ? advertAppInfo2.T3 : "");
        b2.setPage(str);
        AdvertAppInfo advertAppInfo3 = this.f61733d;
        b2.setDeeplinkUrl(advertAppInfo3 != null ? advertAppInfo3.H3 : "");
        d.b.i0.o.c.b.d.a aVar = new d.b.i0.o.c.b.d.a(this.j, b2);
        this.n = new d.b.i0.o.d.g.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.d(b2);
        }
        w();
    }

    public void r(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return;
        }
        if (!w.c(this.f61735f.getPageActivity())) {
            l.K(this.f61735f.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            return;
        }
        d.b.i0.j1.o.c cVar = this.k;
        if (cVar != null) {
            cVar.a(advertAppInfo, i);
        }
    }

    public void s(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo == null) {
            return;
        }
        DownloadData A = A(advertAppInfo, i);
        int m = ApkDownloadView.m(A);
        Log.e("guoqiangxiang", "status: " + m + " id: " + A.getId());
        if (m != 1) {
            if (m == 3) {
                h.d(this.f61735f.getPageActivity(), advertAppInfo.J3);
                return;
            } else if (m != 5) {
                if (m == 6 || m == 7) {
                    r(advertAppInfo, i);
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
        this.f61711g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f61711g.setDefaultBgResource(R.color.CAM_X0205);
        this.f61711g.setIsRound(true);
        this.f61712h = (TextView) b(R.id.user_name);
        this.i = (TextView) b(R.id.action);
        this.j = (ApkDownloadView) b(R.id.download_view);
        MessageManager.getInstance().registerListener(this.q);
    }

    public final void u() {
        AdvertAppInfo advertAppInfo;
        if (!v() || (advertAppInfo = this.f61733d) == null) {
            return;
        }
        String str = advertAppInfo.J3;
        DownloadCacheKey g2 = !TextUtils.isEmpty(str) ? d.b.i0.o.d.d.c().g(str) : null;
        if (g2 == null) {
            AdvertAppInfo advertAppInfo2 = this.f61733d;
            g2 = DownloadCacheKey.create(str, advertAppInfo2.I3, advertAppInfo2.J3);
            d.b.i0.o.d.d.c().i(g2, null);
        }
        q(g2);
    }

    public final boolean v() {
        return !this.o || this.p;
    }

    public void w() {
        if (this.m == null || this.n == null) {
            return;
        }
        d.b.i0.o.d.d.c().i(this.m, this.n);
    }

    public final void x(DownloadData downloadData) {
        if (v()) {
            ApkDownloadView apkDownloadView = this.j;
            if (apkDownloadView == null) {
                return;
            }
            downloadData.setStatus(apkDownloadView.getDownloadStatus());
            return;
        }
        downloadData.setStatus(ApkDownloadView.m(downloadData));
    }

    public void y(boolean z) {
        this.p = z;
    }

    public void z(AdvertAppInfo advertAppInfo, int i, boolean z, String str) {
        if (advertAppInfo == null) {
            return;
        }
        if (!j.A()) {
            l.K(this.f61735f.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.B4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.f61735f.getString(R.string.frs_network_tips);
            }
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f61735f.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new b(advertAppInfo, i));
            aVar.setNegativeButton(R.string.cancel, new c(this));
            aVar.create(this.f61735f).show();
        }
    }
}
