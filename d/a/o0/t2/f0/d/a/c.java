package d.a.o0.t2.f0.d.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.view.XfremodeRoundLayout;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.q.d.e;
import d.a.o0.q.d.g.b;
import d.a.o0.t2.o;
import d.a.o0.t2.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c implements o {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64917a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f64918b;

    /* renamed from: c  reason: collision with root package name */
    public View f64919c;

    /* renamed from: d  reason: collision with root package name */
    public XfremodeRoundLayout f64920d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f64921e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f64922f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64923g;

    /* renamed from: h  reason: collision with root package name */
    public AdAppInfoView f64924h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f64925i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public AdCard m;
    public DownloadCacheKey n;
    public d.a.o0.q.d.h.d o = null;
    public List<AdvertAppInfo> p;
    public List<AdvertAppInfo> q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdCard adCard = c.this.m;
            c.this.q.add(adCard.getAdvertAppInfo());
            d.a.o0.t2.i0.d.k(adCard.getAdvertAppInfo());
            c.this.f64919c.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdCard adCard = c.this.m;
            String str = adCard.scheme;
            if (k.isEmpty(str)) {
                return;
            }
            String str2 = adCard.ext;
            String downloadId = adCard.getDownloadId();
            int i2 = 3;
            if (!y.B(adCard.getAdvertAppInfo(), str)) {
                int i3 = adCard.goodsStyle;
                if ((i3 == 7 || i3 == 14) && adCard.videoInfo != null && adCard.getAdvertAppInfo() != null) {
                    i2 = y.g(TbadkCoreApplication.getInst(), str, adCard.getAdvertAppInfo());
                } else {
                    i2 = y.d(TbadkCoreApplication.getInst(), str, downloadId, str2);
                }
            }
            c.this.f(i2, adCard);
        }
    }

    /* renamed from: d.a.o0.t2.f0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1681c implements b.a {
        public C1681c() {
        }

        @Override // d.a.o0.q.d.g.b.a
        public boolean b(View view) {
            c.this.f(1, c.this.m);
            return false;
        }
    }

    public c(ViewStub viewStub, TbPageContext tbPageContext) {
        this.f64918b = viewStub;
        this.f64917a = tbPageContext;
    }

    @Override // d.a.o0.t2.o
    public void a(AdvertAppInfo advertAppInfo, d.a.n0.z0.c cVar) {
        if (advertAppInfo == null) {
            View view = this.f64919c;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f64919c == null) {
            l(this.f64918b);
            this.p = new ArrayList();
            this.q = new ArrayList();
        }
        q(advertAppInfo, cVar);
    }

    public final void f(int i2, AdCard adCard) {
        if (i2 == 0) {
            return;
        }
        if (y.p(i2)) {
            d.a.o0.t2.i0.d.d(adCard.getAdvertAppInfo(), i2);
        } else {
            d.a.o0.t2.i0.d.l(adCard.getAdvertAppInfo());
        }
        d.a.o0.k1.o.h.c.h(d.a.o0.k1.o.h.c.e(adCard.getAdvertAppInfo()));
    }

    public void g(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.n = downloadCacheKey;
        p();
        this.o = null;
        AdDownloadData b2 = e.c().b(downloadCacheKey);
        if (y.q(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.m;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.m.getAdvertAppInfo().T3;
            b2.setExtInfo(this.m.getAdvertAppInfo().Q3);
            b2.setDownloadKey(this.m.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.m.scheme);
        }
        d.a.o0.q.c.b.d.a aVar = new d.a.o0.q.c.b.d.a(this.f64925i, b2);
        this.o = new d.a.o0.q.d.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        n();
        this.f64925i.c(b2.getCurrentState());
    }

    public float h(@StringRes int i2) {
        try {
            return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i2).split(",")[0]);
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    public final void i() {
        this.j.setVisibility(8);
        this.f64925i.setVisibility(0);
        AdCard adCard = this.m;
        d.a.o0.t2.f0.b.b bVar = adCard.downloadInfo;
        if (bVar == null) {
            return;
        }
        String str = bVar.f64878a;
        DownloadData o = o(this.m, adCard.getPosition());
        if (y.q(str)) {
            o.setStatus(8);
        } else {
            o.setStatus(this.f64925i.getDownloadStatus());
        }
        this.f64925i.setData(o);
        this.f64925i.setOnClickInterceptListener(new C1681c());
    }

    public final void j() {
        DownloadCacheKey h2;
        AdCard adCard = this.m;
        String str = adCard.scheme;
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            h2 = e.c().g(downloadId);
        } else {
            h2 = e.c().h(str);
        }
        if (h2 == null) {
            d.a.o0.t2.f0.b.b bVar = this.m.downloadInfo;
            h2 = DownloadCacheKey.create(downloadId, bVar.f64879b, bVar.f64878a);
            e.c().i(h2, null);
        }
        g(h2);
    }

    public final void k() {
        this.f64925i.setVisibility(8);
        d.a.o0.t2.f0.b.a aVar = this.m.operate;
        String str = aVar != null ? aVar.f64876b : null;
        if (TextUtils.isEmpty(str)) {
            str = "立即查看";
        }
        this.j.setVisibility(0);
        this.j.setText(str);
    }

    public final void l(ViewStub viewStub) {
        viewStub.setLayoutResource(R.layout.ad_pic_banner_layout);
        View inflate = viewStub.inflate();
        this.f64919c = inflate;
        this.f64920d = (XfremodeRoundLayout) inflate.findViewById(R.id.ad_img_container);
        this.f64921e = (TbImageView) this.f64919c.findViewById(R.id.ad_img);
        this.f64922f = (TextView) this.f64919c.findViewById(R.id.ad_brand_name);
        this.f64923g = (TextView) this.f64919c.findViewById(R.id.ad_title);
        AdAppInfoView adAppInfoView = (AdAppInfoView) this.f64919c.findViewById(R.id.ad_app_info_view);
        this.f64924h = adAppInfoView;
        adAppInfoView.setTextColor(R.color.CAM_X0101);
        this.f64925i = (ApkDownloadView) this.f64919c.findViewById(R.id.ad_download_btn);
        this.j = (TextView) this.f64919c.findViewById(R.id.ad_transform_btn);
        this.k = (ImageView) this.f64919c.findViewById(R.id.ad_close_view);
        this.l = (TextView) this.f64919c.findViewById(R.id.ad_tag);
        this.f64920d.setRoundLayoutRadius(h(R.string.J_X05));
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.j);
        d2.m(R.string.J_X01);
        d2.f(R.color.CAM_X0201);
        TbPageContext tbPageContext = this.f64917a;
        if (tbPageContext != null) {
            this.f64925i.j(tbPageContext.getUniqueId());
        }
        this.f64925i.setTextSize(R.dimen.T_X08);
        this.f64925i.setTextColorInitSkin(R.color.CAM_X0105);
        this.f64925i.setTextColorSkin(R.color.CAM_X0105);
        this.f64925i.setStrokeWidth(R.dimen.ds0);
        this.f64925i.setBackgroundSkin(R.drawable.pic_banner_down_btn_bg);
        this.f64925i.i();
        int[] p = l.p(TbadkCoreApplication.getInst());
        int i2 = p[0];
        int i3 = p[1];
        this.k.setOnClickListener(new a());
        this.f64919c.setOnClickListener(new b());
    }

    public final void m(AdvertAppInfo advertAppInfo) {
        if (this.p.contains(advertAppInfo)) {
            return;
        }
        this.p.add(advertAppInfo);
        d.a.o0.t2.i0.d.o(advertAppInfo);
    }

    public final void n() {
        if (this.n == null || this.o == null) {
            return;
        }
        e.c().i(this.n, this.o);
    }

    public DownloadData o(AdCard adCard, int i2) {
        DownloadData downloadData = new DownloadData(adCard.getDownloadId());
        downloadData.setUrl(adCard.downloadInfo.f64879b);
        downloadData.setName(adCard.userName);
        downloadData.setPosition(i2);
        downloadData.setNotifyId(d.a.c.e.m.b.d(adCard.adId, 0));
        return downloadData;
    }

    @Override // d.a.o0.t2.o
    public void onDestroy() {
        p();
    }

    public final void p() {
        if (this.n == null || this.o == null) {
            return;
        }
        e.c().q(this.n, this.o);
    }

    public final void q(AdvertAppInfo advertAppInfo, d.a.n0.z0.c cVar) {
        AdCard adCard = (AdCard) advertAppInfo.R3;
        this.m = adCard;
        if (adCard != null && !cVar.j && !cVar.k) {
            if (this.q.contains(advertAppInfo)) {
                this.f64919c.setVisibility(8);
                return;
            }
            this.f64919c.setVisibility(0);
            m(advertAppInfo);
            ((RelativeLayout.LayoutParams) this.f64919c.getLayoutParams()).bottomMargin = cVar.f54771h + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.f64919c);
            d2.m(R.string.J_X06);
            d2.f(R.color.CAM_X0214);
            this.f64921e.U(this.m.userImage, 17, false);
            this.f64922f.setText(this.m.userName);
            this.f64923g.setText(this.m.threadTitle);
            if (this.m.appInfoModel == null) {
                this.f64924h.setVisibility(8);
                this.l.setVisibility(0);
                this.f64922f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X05));
                this.f64923g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X07));
                this.f64923g.setMaxLines(2);
            } else {
                this.f64924h.setVisibility(0);
                this.l.setVisibility(8);
                this.f64924h.setAd(advertAppInfo);
                this.f64924h.setAppInfo(this.m.appInfoModel);
                this.f64922f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06));
                this.f64923g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X08));
                this.f64923g.setMaxLines(1);
            }
            if (advertAppInfo.F4()) {
                i();
                j();
                return;
            } else if (advertAppInfo.H4()) {
                k();
                return;
            } else {
                return;
            }
        }
        this.f64919c.setVisibility(8);
    }
}
