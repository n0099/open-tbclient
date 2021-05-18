package d.a.k0.s2.j0;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.j0.r.s.a;
import d.a.k0.o.d.f.b;
import d.a.k0.s2.c0.h;
import d.a.k0.s2.f0.b.f;
import d.a.k0.s2.y;
/* loaded from: classes5.dex */
public class a extends d.a.k0.s2.j0.e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f61064g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61065h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f61066i;
    public ApkDownloadView j;
    public d.a.k0.j1.o.c k;
    public String l;
    public DownloadCacheKey m;
    public d.a.k0.o.d.g.d n;
    public boolean o;
    public boolean p;
    public CustomMessageListener q;

    /* renamed from: d.a.k0.s2.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1616a implements b.a {
        public C1616a() {
        }

        @Override // d.a.k0.o.d.f.b.a
        public boolean b(View view) {
            d.a.k0.j1.o.h.c.h(a.this.f61091e);
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f61068e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f61069f;

        public b(AdvertAppInfo advertAppInfo, int i2) {
            this.f61068e = advertAppInfo;
            this.f61069f = i2;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            a.this.r(this.f61068e, this.f61069f);
            if (a.this.j != null) {
                a.this.j.v(a.this.A(this.f61068e, this.f61069f));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c(a aVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
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
            if (customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(a.this.l) || !a.this.l.equals(downloadData.getId())) {
                return;
            }
            a.this.j.r(downloadData);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public AdvertAppInfo f61072e;

        public e(AdvertAppInfo advertAppInfo) {
            this.f61072e = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                boolean z = view == a.this.j;
                d.a.k0.j1.o.h.c.h(a.this.f61091e);
                if (a.this.v()) {
                    a.this.j.performClick();
                    return;
                }
                AdvertAppInfo advertAppInfo = this.f61072e;
                if (advertAppInfo != null) {
                    int d2 = d.a.c.e.m.b.d(advertAppInfo.L3, -1);
                    int m = ApkDownloadView.m(a.this.A(this.f61072e, d2));
                    if ((6 == m || 7 == m) && j.z() && !j.H()) {
                        a.this.z(this.f61072e, d2, true, null);
                        return;
                    }
                    a aVar = a.this;
                    aVar.s(this.f61072e, d2, aVar.j, z);
                    return;
                }
                return;
            }
            a.this.f61092f.showToast(R.string.neterror);
        }
    }

    public a(View view, String str) {
        super(view, str);
        this.n = null;
        this.o = false;
        this.q = new d(2016483);
        t();
    }

    public final DownloadData A(AdvertAppInfo advertAppInfo, int i2) {
        DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
        downloadData.setUrl(advertAppInfo.W3);
        downloadData.setName(advertAppInfo.S3);
        downloadData.setPosition(i2);
        downloadData.setNotifyId(d.a.c.e.m.b.d(advertAppInfo.F3, 0));
        return downloadData;
    }

    public void B() {
        if (this.m == null || this.n == null) {
            return;
        }
        d.a.k0.o.d.d.c().q(this.m, this.n);
    }

    @Override // d.a.k0.s2.j0.e
    public void c() {
        super.c();
        SkinManager.setViewTextColor(this.f61065h, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f61066i, R.color.CAM_X0620, 1);
        SkinManager.setBackgroundResource(this.f61066i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        this.j.setTextColorInitSkin(R.color.CAM_X0101);
        this.j.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
        this.j.i();
    }

    @Override // d.a.k0.s2.j0.e
    public void d(f fVar) {
        super.d(fVar);
        int i2 = 0;
        this.f61064g.V(fVar.f60977c, 10, false);
        this.f61065h.setText(fVar.f60976b);
        this.f61066i.setText(fVar.f60979e);
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
        d.a.k0.j1.o.h.b bVar = this.f61091e;
        if (bVar instanceof AdCard) {
            this.o = ((AdCard) bVar).isDirectDownload();
        }
        AdvertAppInfo advertAppInfo = this.f61090d;
        if (advertAppInfo != null) {
            e eVar = new e(advertAppInfo);
            this.f61088b.setOnClickListener(eVar);
            if (v()) {
                this.j.setOnClickInterceptListener(new C1616a());
            } else {
                this.j.setOnClickListener(eVar);
            }
            try {
                if (!TextUtils.isEmpty(this.f61090d.L3)) {
                    i2 = Integer.valueOf(this.f61090d.L3).intValue();
                }
            } catch (NumberFormatException unused) {
            }
            AdvertAppInfo advertAppInfo2 = this.f61090d;
            this.l = advertAppInfo2.X3;
            DownloadData A = A(advertAppInfo2, i2);
            x(A);
            this.j.setData(A);
        }
        if (!v()) {
            this.j.j(this.f61092f.getUniqueId());
        }
        this.q.setTag(this.f61092f.getUniqueId());
        u();
        c();
    }

    @Override // d.a.k0.s2.j0.e
    public void h(d.a.k0.j1.o.c cVar) {
        this.k = cVar;
    }

    public final void q(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.m = downloadCacheKey;
        B();
        AdDownloadData b2 = d.a.k0.o.d.d.c().b(downloadCacheKey);
        if (b2 != null) {
            this.j.c(b2.getCurrentState());
        } else {
            this.j.c(DownloadStatus.STATUS_NONE);
        }
        AdvertAppInfo advertAppInfo = this.f61090d;
        String str = advertAppInfo != null ? advertAppInfo.P3 : "";
        AdvertAppInfo advertAppInfo2 = this.f61090d;
        b2.setExtInfo(advertAppInfo2 != null ? advertAppInfo2.M3 : "");
        b2.setPage(str);
        AdvertAppInfo advertAppInfo3 = this.f61090d;
        b2.setDeeplinkUrl(advertAppInfo3 != null ? advertAppInfo3.V3 : "");
        d.a.k0.o.c.b.d.a aVar = new d.a.k0.o.c.b.d.a(this.j, b2);
        this.n = new d.a.k0.o.d.g.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.d(b2);
        }
        w();
    }

    public void r(AdvertAppInfo advertAppInfo, int i2) {
        if (advertAppInfo == null) {
            return;
        }
        if (!y.c(this.f61092f.getPageActivity())) {
            l.L(this.f61092f.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            return;
        }
        d.a.k0.j1.o.c cVar = this.k;
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
                h.d(this.f61092f.getPageActivity(), advertAppInfo.X3);
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
        this.f61064g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f61064g.setDefaultBgResource(R.color.CAM_X0205);
        this.f61064g.setIsRound(true);
        this.f61065h = (TextView) b(R.id.user_name);
        this.f61066i = (TextView) b(R.id.action);
        this.j = (ApkDownloadView) b(R.id.download_view);
        MessageManager.getInstance().registerListener(this.q);
    }

    public final void u() {
        AdvertAppInfo advertAppInfo;
        if (!v() || (advertAppInfo = this.f61090d) == null) {
            return;
        }
        String downloadId = advertAppInfo.getDownloadId();
        DownloadCacheKey g2 = !TextUtils.isEmpty(downloadId) ? d.a.k0.o.d.d.c().g(downloadId) : null;
        if (g2 == null) {
            AdvertAppInfo advertAppInfo2 = this.f61090d;
            g2 = DownloadCacheKey.create(downloadId, advertAppInfo2.W3, advertAppInfo2.X3);
            d.a.k0.o.d.d.c().i(g2, null);
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
        d.a.k0.o.d.d.c().i(this.m, this.n);
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

    public void z(AdvertAppInfo advertAppInfo, int i2, boolean z, String str) {
        if (advertAppInfo == null) {
            return;
        }
        if (!j.A()) {
            l.L(this.f61092f.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.D4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.f61092f.getString(R.string.frs_network_tips);
            }
            d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f61092f.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new b(advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new c(this));
            aVar.create(this.f61092f).show();
        }
    }
}
