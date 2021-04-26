package d.a.j0.s2.e0.d.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
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
import d.a.j0.o.d.f.b;
import d.a.j0.s2.n;
import d.a.j0.s2.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c implements n {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60253a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f60254b;

    /* renamed from: c  reason: collision with root package name */
    public View f60255c;

    /* renamed from: d  reason: collision with root package name */
    public XfremodeRoundLayout f60256d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f60257e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60258f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60259g;

    /* renamed from: h  reason: collision with root package name */
    public AdAppInfoView f60260h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f60261i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public AdCard m;
    public DownloadCacheKey n;
    public d.a.j0.o.d.g.d o = null;
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
            d.a.j0.s2.h0.d.k(adCard.getAdvertAppInfo());
            c.this.f60255c.setVisibility(8);
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
            String h2 = c.this.h(adCard);
            int i2 = 3;
            if (!x.B(adCard.getAdvertAppInfo(), str)) {
                int i3 = adCard.goodsStyle;
                if ((i3 == 7 || i3 == 14) && adCard.videoInfo != null && adCard.getAdvertAppInfo() != null) {
                    i2 = x.g(TbadkCoreApplication.getInst(), str, adCard.getAdvertAppInfo());
                } else {
                    i2 = x.d(TbadkCoreApplication.getInst(), str, h2, str2);
                }
            }
            c.this.f(i2, adCard);
        }
    }

    /* renamed from: d.a.j0.s2.e0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1547c implements b.a {
        public C1547c() {
        }

        @Override // d.a.j0.o.d.f.b.a
        public boolean b(View view) {
            c.this.f(1, c.this.m);
            return false;
        }
    }

    public c(ViewStub viewStub, TbPageContext tbPageContext) {
        this.f60254b = viewStub;
        this.f60253a = tbPageContext;
    }

    @Override // d.a.j0.s2.n
    public void a(AdvertAppInfo advertAppInfo, d.a.i0.z0.c cVar) {
        if (advertAppInfo == null) {
            View view = this.f60255c;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f60255c == null) {
            m(this.f60254b);
            this.p = new ArrayList();
            this.q = new ArrayList();
        }
        r(advertAppInfo, cVar);
    }

    public final void f(int i2, AdCard adCard) {
        if (i2 == 0) {
            return;
        }
        if (x.p(i2)) {
            d.a.j0.s2.h0.d.d(adCard.getAdvertAppInfo(), i2);
        } else {
            d.a.j0.s2.h0.d.l(adCard.getAdvertAppInfo());
        }
        d.a.j0.j1.o.h.c.h(d.a.j0.j1.o.h.c.e(adCard.getAdvertAppInfo()));
    }

    public void g(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.n = downloadCacheKey;
        q();
        this.o = null;
        AdDownloadData b2 = d.a.j0.o.d.d.c().b(downloadCacheKey);
        if (x.q(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.m;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.m.getAdvertAppInfo().c4;
            b2.setExtInfo(this.m.getAdvertAppInfo().T3);
            b2.setDownloadKey(this.m.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.m.scheme);
        }
        d.a.j0.o.c.b.d.a aVar = new d.a.j0.o.c.b.d.a(this.f60261i, b2);
        this.o = new d.a.j0.o.d.g.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.d(b2);
        }
        o();
        this.f60261i.c(b2.getCurrentState());
    }

    public String h(@NonNull AdCard adCard) {
        d.a.j0.s2.e0.b.b bVar;
        return (adCard.getAdvertAppInfo() == null || adCard.getAdvertAppInfo().D4() || (bVar = adCard.downloadInfo) == null) ? "" : TextUtils.isEmpty(bVar.f60228a) ? adCard.adId : adCard.downloadInfo.f60228a;
    }

    public float i(@StringRes int i2) {
        try {
            return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i2).split(",")[0]);
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    public final void j() {
        this.j.setVisibility(8);
        this.f60261i.setVisibility(0);
        AdCard adCard = this.m;
        d.a.j0.s2.e0.b.b bVar = adCard.downloadInfo;
        if (bVar == null) {
            return;
        }
        String str = bVar.f60228a;
        DownloadData p = p(this.m, adCard.getPosition());
        if (x.q(str)) {
            p.setStatus(8);
        } else {
            p.setStatus(this.f60261i.getDownloadStatus());
        }
        this.f60261i.setData(p);
        this.f60261i.setOnClickInterceptListener(new C1547c());
    }

    public final void k() {
        DownloadCacheKey h2;
        AdCard adCard = this.m;
        String str = adCard.scheme;
        String h3 = h(adCard);
        if (!TextUtils.isEmpty(h3)) {
            h2 = d.a.j0.o.d.d.c().g(h3);
        } else {
            h2 = d.a.j0.o.d.d.c().h(str);
        }
        if (h2 == null) {
            d.a.j0.s2.e0.b.b bVar = this.m.downloadInfo;
            h2 = DownloadCacheKey.create(h3, bVar.f60229b, bVar.f60228a);
            d.a.j0.o.d.d.c().i(h2, null);
        }
        g(h2);
    }

    public final void l() {
        this.f60261i.setVisibility(8);
        d.a.j0.s2.e0.b.a aVar = this.m.operate;
        String str = aVar != null ? aVar.f60227a : null;
        if (TextUtils.isEmpty(str)) {
            str = "立即查看";
        }
        this.j.setVisibility(0);
        this.j.setText(str);
    }

    public final void m(ViewStub viewStub) {
        viewStub.setLayoutResource(R.layout.ad_pic_banner_layout);
        View inflate = viewStub.inflate();
        this.f60255c = inflate;
        this.f60256d = (XfremodeRoundLayout) inflate.findViewById(R.id.ad_img_container);
        this.f60257e = (TbImageView) this.f60255c.findViewById(R.id.ad_img);
        this.f60258f = (TextView) this.f60255c.findViewById(R.id.ad_brand_name);
        this.f60259g = (TextView) this.f60255c.findViewById(R.id.ad_title);
        AdAppInfoView adAppInfoView = (AdAppInfoView) this.f60255c.findViewById(R.id.ad_app_info_view);
        this.f60260h = adAppInfoView;
        adAppInfoView.setTextColor(R.color.CAM_X0101);
        this.f60261i = (ApkDownloadView) this.f60255c.findViewById(R.id.ad_download_btn);
        this.j = (TextView) this.f60255c.findViewById(R.id.ad_transform_btn);
        this.k = (ImageView) this.f60255c.findViewById(R.id.ad_close_view);
        this.l = (TextView) this.f60255c.findViewById(R.id.ad_tag);
        this.f60256d.setRoundLayoutRadius(i(R.string.J_X05));
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
        d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this.j);
        d2.k(R.string.J_X01);
        d2.f(R.color.CAM_X0201);
        TbPageContext tbPageContext = this.f60253a;
        if (tbPageContext != null) {
            this.f60261i.j(tbPageContext.getUniqueId());
        }
        this.f60261i.setTextSize(R.dimen.T_X08);
        this.f60261i.setTextColorInitSkin(R.color.CAM_X0105);
        this.f60261i.setTextColorSkin(R.color.CAM_X0105);
        this.f60261i.setStrokeWidth(R.dimen.ds0);
        this.f60261i.setBackgroundSkin(R.drawable.pic_banner_down_btn_bg);
        this.f60261i.i();
        int[] p = l.p(TbadkCoreApplication.getInst());
        int i2 = p[0];
        int i3 = p[1];
        this.k.setOnClickListener(new a());
        this.f60255c.setOnClickListener(new b());
    }

    public final void n(AdvertAppInfo advertAppInfo) {
        if (this.p.contains(advertAppInfo)) {
            return;
        }
        this.p.add(advertAppInfo);
        d.a.j0.s2.h0.d.o(advertAppInfo);
    }

    public final void o() {
        if (this.n == null || this.o == null) {
            return;
        }
        d.a.j0.o.d.d.c().i(this.n, this.o);
    }

    @Override // d.a.j0.s2.n
    public void onDestroy() {
        q();
    }

    public DownloadData p(AdCard adCard, int i2) {
        DownloadData downloadData = new DownloadData(h(adCard));
        downloadData.setUrl(adCard.downloadInfo.f60229b);
        downloadData.setName(adCard.userName);
        downloadData.setPosition(i2);
        downloadData.setNotifyId(d.a.c.e.m.b.d(adCard.adId, 0));
        return downloadData;
    }

    public final void q() {
        if (this.n == null || this.o == null) {
            return;
        }
        d.a.j0.o.d.d.c().q(this.n, this.o);
    }

    public final void r(AdvertAppInfo advertAppInfo, d.a.i0.z0.c cVar) {
        AdCard adCard = (AdCard) advertAppInfo.W3;
        this.m = adCard;
        if (adCard != null && !cVar.j && !cVar.k) {
            if (this.q.contains(advertAppInfo)) {
                this.f60255c.setVisibility(8);
                return;
            }
            this.f60255c.setVisibility(0);
            n(advertAppInfo);
            ((RelativeLayout.LayoutParams) this.f60255c.getLayoutParams()).bottomMargin = cVar.f50095h + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this.f60255c);
            d2.k(R.string.J_X06);
            d2.f(R.color.CAM_X0214);
            this.f60257e.V(this.m.userImage, 17, false);
            this.f60258f.setText(this.m.userName);
            this.f60259g.setText(this.m.threadTitle);
            if (this.m.appInfoModel == null) {
                this.f60260h.setVisibility(8);
                this.l.setVisibility(0);
                this.f60258f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X05));
                this.f60259g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X07));
                this.f60259g.setMaxLines(2);
            } else {
                this.f60260h.setVisibility(0);
                this.l.setVisibility(8);
                this.f60260h.setAd(advertAppInfo);
                this.f60260h.setAppInfo(this.m.appInfoModel);
                this.f60258f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06));
                this.f60259g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X08));
                this.f60259g.setMaxLines(1);
            }
            if (advertAppInfo.B4()) {
                j();
                k();
                return;
            } else if (advertAppInfo.D4()) {
                l();
                return;
            } else {
                return;
            }
        }
        this.f60255c.setVisibility(8);
    }
}
