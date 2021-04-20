package d.b.i0.s2.c0.d.a;

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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.o.d.f.b;
import d.b.i0.s2.n;
import d.b.i0.s2.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61616a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f61617b;

    /* renamed from: c  reason: collision with root package name */
    public View f61618c;

    /* renamed from: d  reason: collision with root package name */
    public XfremodeRoundLayout f61619d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f61620e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61621f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61622g;

    /* renamed from: h  reason: collision with root package name */
    public AdAppInfoView f61623h;
    public ApkDownloadView i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public AdCard m;
    public DownloadCacheKey n;
    public d.b.i0.o.d.g.d o = null;
    public List<AdvertAppInfo> p;
    public List<AdvertAppInfo> q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdCard adCard = c.this.m;
            c.this.q.add(adCard.getAdvertAppInfo());
            d.b.i0.s2.f0.d.k(adCard.getAdvertAppInfo());
            c.this.f61618c.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
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
            int i = 3;
            if (!w.B(adCard.getAdvertAppInfo(), str)) {
                int i2 = adCard.goodsStyle;
                if ((i2 == 7 || i2 == 14) && adCard.videoInfo != null && adCard.getAdvertAppInfo() != null) {
                    i = w.g(TbadkCoreApplication.getInst(), str, adCard.getAdvertAppInfo());
                } else {
                    i = w.d(TbadkCoreApplication.getInst(), str, h2, str2);
                }
            }
            c.this.f(i, adCard);
        }
    }

    /* renamed from: d.b.i0.s2.c0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1580c implements b.a {
        public C1580c() {
        }

        @Override // d.b.i0.o.d.f.b.a
        public boolean b(View view) {
            c.this.f(1, c.this.m);
            return false;
        }
    }

    public c(ViewStub viewStub, TbPageContext tbPageContext) {
        this.f61617b = viewStub;
        this.f61616a = tbPageContext;
    }

    @Override // d.b.i0.s2.n
    public void a(AdvertAppInfo advertAppInfo, d.b.h0.z0.c cVar) {
        if (advertAppInfo == null) {
            View view = this.f61618c;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f61618c == null) {
            m(this.f61617b);
            this.p = new ArrayList();
            this.q = new ArrayList();
        }
        r(advertAppInfo, cVar);
    }

    public final void f(int i, AdCard adCard) {
        if (i == 0) {
            return;
        }
        if (w.p(i)) {
            d.b.i0.s2.f0.d.d(adCard.getAdvertAppInfo(), i);
        } else {
            d.b.i0.s2.f0.d.l(adCard.getAdvertAppInfo());
        }
        d.b.i0.j1.o.h.c.h(d.b.i0.j1.o.h.c.e(adCard.getAdvertAppInfo()));
    }

    public void g(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.n = downloadCacheKey;
        q();
        this.o = null;
        AdDownloadData b2 = d.b.i0.o.d.d.c().b(downloadCacheKey);
        if (w.q(b2.getPkgName())) {
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
        d.b.i0.o.c.b.d.a aVar = new d.b.i0.o.c.b.d.a(this.i, b2);
        this.o = new d.b.i0.o.d.g.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.d(b2);
        }
        o();
        this.i.c(b2.getCurrentState());
    }

    public String h(@NonNull AdCard adCard) {
        d.b.i0.s2.c0.b.b bVar;
        return (adCard.getAdvertAppInfo() == null || adCard.getAdvertAppInfo().D4() || (bVar = adCard.downloadInfo) == null) ? "" : TextUtils.isEmpty(bVar.f61594a) ? adCard.adId : adCard.downloadInfo.f61594a;
    }

    public float i(@StringRes int i) {
        try {
            return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i).split(",")[0]);
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    public final void j() {
        this.j.setVisibility(8);
        this.i.setVisibility(0);
        AdCard adCard = this.m;
        d.b.i0.s2.c0.b.b bVar = adCard.downloadInfo;
        if (bVar == null) {
            return;
        }
        String str = bVar.f61594a;
        DownloadData p = p(this.m, adCard.getPosition());
        if (w.q(str)) {
            p.setStatus(8);
        } else {
            p.setStatus(this.i.getDownloadStatus());
        }
        this.i.setData(p);
        this.i.setOnClickInterceptListener(new C1580c());
    }

    public final void k() {
        DownloadCacheKey h2;
        AdCard adCard = this.m;
        String str = adCard.scheme;
        String h3 = h(adCard);
        if (!TextUtils.isEmpty(h3)) {
            h2 = d.b.i0.o.d.d.c().g(h3);
        } else {
            h2 = d.b.i0.o.d.d.c().h(str);
        }
        if (h2 == null) {
            d.b.i0.s2.c0.b.b bVar = this.m.downloadInfo;
            h2 = DownloadCacheKey.create(h3, bVar.f61595b, bVar.f61594a);
            d.b.i0.o.d.d.c().i(h2, null);
        }
        g(h2);
    }

    public final void l() {
        this.i.setVisibility(8);
        d.b.i0.s2.c0.b.a aVar = this.m.operate;
        String str = aVar != null ? aVar.f61593a : null;
        if (TextUtils.isEmpty(str)) {
            str = "立即查看";
        }
        this.j.setVisibility(0);
        this.j.setText(str);
    }

    public final void m(ViewStub viewStub) {
        viewStub.setLayoutResource(R.layout.ad_pic_banner_layout);
        View inflate = viewStub.inflate();
        this.f61618c = inflate;
        this.f61619d = (XfremodeRoundLayout) inflate.findViewById(R.id.ad_img_container);
        this.f61620e = (TbImageView) this.f61618c.findViewById(R.id.ad_img);
        this.f61621f = (TextView) this.f61618c.findViewById(R.id.ad_brand_name);
        this.f61622g = (TextView) this.f61618c.findViewById(R.id.ad_title);
        AdAppInfoView adAppInfoView = (AdAppInfoView) this.f61618c.findViewById(R.id.ad_app_info_view);
        this.f61623h = adAppInfoView;
        adAppInfoView.setTextColor(R.color.CAM_X0101);
        this.i = (ApkDownloadView) this.f61618c.findViewById(R.id.ad_download_btn);
        this.j = (TextView) this.f61618c.findViewById(R.id.ad_transform_btn);
        this.k = (ImageView) this.f61618c.findViewById(R.id.ad_close_view);
        this.l = (TextView) this.f61618c.findViewById(R.id.ad_tag);
        this.f61619d.setRoundLayoutRadius(i(R.string.J_X05));
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
        d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.j);
        d2.k(R.string.J_X01);
        d2.f(R.color.CAM_X0201);
        TbPageContext tbPageContext = this.f61616a;
        if (tbPageContext != null) {
            this.i.j(tbPageContext.getUniqueId());
        }
        this.i.setTextSize(R.dimen.T_X08);
        this.i.setTextColorInitSkin(R.color.CAM_X0105);
        this.i.setTextColorSkin(R.color.CAM_X0105);
        this.i.setStrokeWidth(R.dimen.ds0);
        this.i.setBackgroundSkin(R.drawable.pic_banner_down_btn_bg);
        this.i.i();
        int[] p = l.p(TbadkCoreApplication.getInst());
        int i = p[0];
        int i2 = p[1];
        this.k.setOnClickListener(new a());
        this.f61618c.setOnClickListener(new b());
    }

    public final void n(AdvertAppInfo advertAppInfo) {
        if (this.p.contains(advertAppInfo)) {
            return;
        }
        this.p.add(advertAppInfo);
        d.b.i0.s2.f0.d.o(advertAppInfo);
    }

    public final void o() {
        if (this.n == null || this.o == null) {
            return;
        }
        d.b.i0.o.d.d.c().i(this.n, this.o);
    }

    @Override // d.b.i0.s2.n
    public void onDestroy() {
        q();
    }

    public DownloadData p(AdCard adCard, int i) {
        DownloadData downloadData = new DownloadData(h(adCard));
        downloadData.setUrl(adCard.downloadInfo.f61595b);
        downloadData.setName(adCard.userName);
        downloadData.setPosition(i);
        downloadData.setNotifyId(d.b.c.e.m.b.d(adCard.adId, 0));
        return downloadData;
    }

    public final void q() {
        if (this.n == null || this.o == null) {
            return;
        }
        d.b.i0.o.d.d.c().q(this.n, this.o);
    }

    public final void r(AdvertAppInfo advertAppInfo, d.b.h0.z0.c cVar) {
        AdCard adCard = (AdCard) advertAppInfo.W3;
        this.m = adCard;
        if (adCard != null && !cVar.j && !cVar.k) {
            if (this.q.contains(advertAppInfo)) {
                this.f61618c.setVisibility(8);
                return;
            }
            this.f61618c.setVisibility(0);
            n(advertAppInfo);
            ((RelativeLayout.LayoutParams) this.f61618c.getLayoutParams()).bottomMargin = cVar.f52082h + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.f61618c);
            d2.k(R.string.J_X06);
            d2.f(R.color.CAM_X0214);
            this.f61620e.W(this.m.userImage, 17, false);
            this.f61621f.setText(this.m.userName);
            this.f61622g.setText(this.m.threadTitle);
            if (this.m.appInfoModel == null) {
                this.f61623h.setVisibility(8);
                this.l.setVisibility(0);
                this.f61621f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X05));
                this.f61622g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X07));
                this.f61622g.setMaxLines(2);
            } else {
                this.f61623h.setVisibility(0);
                this.l.setVisibility(8);
                this.f61623h.setAd(advertAppInfo);
                this.f61623h.setAppInfo(this.m.appInfoModel);
                this.f61621f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06));
                this.f61622g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X08));
                this.f61622g.setMaxLines(1);
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
        this.f61618c.setVisibility(8);
    }
}
