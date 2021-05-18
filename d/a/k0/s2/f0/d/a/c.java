package d.a.k0.s2.f0.d.a;

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
import d.a.k0.o.d.f.b;
import d.a.k0.s2.o;
import d.a.k0.s2.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c implements o {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60998a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f60999b;

    /* renamed from: c  reason: collision with root package name */
    public View f61000c;

    /* renamed from: d  reason: collision with root package name */
    public XfremodeRoundLayout f61001d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f61002e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61003f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61004g;

    /* renamed from: h  reason: collision with root package name */
    public AdAppInfoView f61005h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f61006i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public AdCard m;
    public DownloadCacheKey n;
    public d.a.k0.o.d.g.d o = null;
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
            d.a.k0.s2.i0.d.k(adCard.getAdvertAppInfo());
            c.this.f61000c.setVisibility(8);
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

    /* renamed from: d.a.k0.s2.f0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1615c implements b.a {
        public C1615c() {
        }

        @Override // d.a.k0.o.d.f.b.a
        public boolean b(View view) {
            c.this.f(1, c.this.m);
            return false;
        }
    }

    public c(ViewStub viewStub, TbPageContext tbPageContext) {
        this.f60999b = viewStub;
        this.f60998a = tbPageContext;
    }

    @Override // d.a.k0.s2.o
    public void a(AdvertAppInfo advertAppInfo, d.a.j0.z0.c cVar) {
        if (advertAppInfo == null) {
            View view = this.f61000c;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f61000c == null) {
            l(this.f60999b);
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
            d.a.k0.s2.i0.d.d(adCard.getAdvertAppInfo(), i2);
        } else {
            d.a.k0.s2.i0.d.l(adCard.getAdvertAppInfo());
        }
        d.a.k0.j1.o.h.c.h(d.a.k0.j1.o.h.c.e(adCard.getAdvertAppInfo()));
    }

    public void g(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.n = downloadCacheKey;
        p();
        this.o = null;
        AdDownloadData b2 = d.a.k0.o.d.d.c().b(downloadCacheKey);
        if (y.q(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.m;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.m.getAdvertAppInfo().P3;
            b2.setExtInfo(this.m.getAdvertAppInfo().M3);
            b2.setDownloadKey(this.m.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.m.scheme);
        }
        d.a.k0.o.c.b.d.a aVar = new d.a.k0.o.c.b.d.a(this.f61006i, b2);
        this.o = new d.a.k0.o.d.g.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.d(b2);
        }
        n();
        this.f61006i.c(b2.getCurrentState());
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
        this.f61006i.setVisibility(0);
        AdCard adCard = this.m;
        d.a.k0.s2.f0.b.b bVar = adCard.downloadInfo;
        if (bVar == null) {
            return;
        }
        String str = bVar.f60959a;
        DownloadData o = o(this.m, adCard.getPosition());
        if (y.q(str)) {
            o.setStatus(8);
        } else {
            o.setStatus(this.f61006i.getDownloadStatus());
        }
        this.f61006i.setData(o);
        this.f61006i.setOnClickInterceptListener(new C1615c());
    }

    public final void j() {
        DownloadCacheKey h2;
        AdCard adCard = this.m;
        String str = adCard.scheme;
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            h2 = d.a.k0.o.d.d.c().g(downloadId);
        } else {
            h2 = d.a.k0.o.d.d.c().h(str);
        }
        if (h2 == null) {
            d.a.k0.s2.f0.b.b bVar = this.m.downloadInfo;
            h2 = DownloadCacheKey.create(downloadId, bVar.f60960b, bVar.f60959a);
            d.a.k0.o.d.d.c().i(h2, null);
        }
        g(h2);
    }

    public final void k() {
        this.f61006i.setVisibility(8);
        d.a.k0.s2.f0.b.a aVar = this.m.operate;
        String str = aVar != null ? aVar.f60957b : null;
        if (TextUtils.isEmpty(str)) {
            str = "立即查看";
        }
        this.j.setVisibility(0);
        this.j.setText(str);
    }

    public final void l(ViewStub viewStub) {
        viewStub.setLayoutResource(R.layout.ad_pic_banner_layout);
        View inflate = viewStub.inflate();
        this.f61000c = inflate;
        this.f61001d = (XfremodeRoundLayout) inflate.findViewById(R.id.ad_img_container);
        this.f61002e = (TbImageView) this.f61000c.findViewById(R.id.ad_img);
        this.f61003f = (TextView) this.f61000c.findViewById(R.id.ad_brand_name);
        this.f61004g = (TextView) this.f61000c.findViewById(R.id.ad_title);
        AdAppInfoView adAppInfoView = (AdAppInfoView) this.f61000c.findViewById(R.id.ad_app_info_view);
        this.f61005h = adAppInfoView;
        adAppInfoView.setTextColor(R.color.CAM_X0101);
        this.f61006i = (ApkDownloadView) this.f61000c.findViewById(R.id.ad_download_btn);
        this.j = (TextView) this.f61000c.findViewById(R.id.ad_transform_btn);
        this.k = (ImageView) this.f61000c.findViewById(R.id.ad_close_view);
        this.l = (TextView) this.f61000c.findViewById(R.id.ad_tag);
        this.f61001d.setRoundLayoutRadius(h(R.string.J_X05));
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
        d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(this.j);
        d2.k(R.string.J_X01);
        d2.f(R.color.CAM_X0201);
        TbPageContext tbPageContext = this.f60998a;
        if (tbPageContext != null) {
            this.f61006i.j(tbPageContext.getUniqueId());
        }
        this.f61006i.setTextSize(R.dimen.T_X08);
        this.f61006i.setTextColorInitSkin(R.color.CAM_X0105);
        this.f61006i.setTextColorSkin(R.color.CAM_X0105);
        this.f61006i.setStrokeWidth(R.dimen.ds0);
        this.f61006i.setBackgroundSkin(R.drawable.pic_banner_down_btn_bg);
        this.f61006i.i();
        int[] p = l.p(TbadkCoreApplication.getInst());
        int i2 = p[0];
        int i3 = p[1];
        this.k.setOnClickListener(new a());
        this.f61000c.setOnClickListener(new b());
    }

    public final void m(AdvertAppInfo advertAppInfo) {
        if (this.p.contains(advertAppInfo)) {
            return;
        }
        this.p.add(advertAppInfo);
        d.a.k0.s2.i0.d.o(advertAppInfo);
    }

    public final void n() {
        if (this.n == null || this.o == null) {
            return;
        }
        d.a.k0.o.d.d.c().i(this.n, this.o);
    }

    public DownloadData o(AdCard adCard, int i2) {
        DownloadData downloadData = new DownloadData(adCard.getDownloadId());
        downloadData.setUrl(adCard.downloadInfo.f60960b);
        downloadData.setName(adCard.userName);
        downloadData.setPosition(i2);
        downloadData.setNotifyId(d.a.c.e.m.b.d(adCard.adId, 0));
        return downloadData;
    }

    @Override // d.a.k0.s2.o
    public void onDestroy() {
        p();
    }

    public final void p() {
        if (this.n == null || this.o == null) {
            return;
        }
        d.a.k0.o.d.d.c().q(this.n, this.o);
    }

    public final void q(AdvertAppInfo advertAppInfo, d.a.j0.z0.c cVar) {
        AdCard adCard = (AdCard) advertAppInfo.N3;
        this.m = adCard;
        if (adCard != null && !cVar.j && !cVar.k) {
            if (this.q.contains(advertAppInfo)) {
                this.f61000c.setVisibility(8);
                return;
            }
            this.f61000c.setVisibility(0);
            m(advertAppInfo);
            ((RelativeLayout.LayoutParams) this.f61000c.getLayoutParams()).bottomMargin = cVar.f50914h + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(this.f61000c);
            d2.k(R.string.J_X06);
            d2.f(R.color.CAM_X0214);
            this.f61002e.V(this.m.userImage, 17, false);
            this.f61003f.setText(this.m.userName);
            this.f61004g.setText(this.m.threadTitle);
            if (this.m.appInfoModel == null) {
                this.f61005h.setVisibility(8);
                this.l.setVisibility(0);
                this.f61003f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X05));
                this.f61004g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X07));
                this.f61004g.setMaxLines(2);
            } else {
                this.f61005h.setVisibility(0);
                this.l.setVisibility(8);
                this.f61005h.setAd(advertAppInfo);
                this.f61005h.setAppInfo(this.m.appInfoModel);
                this.f61003f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06));
                this.f61004g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X08));
                this.f61004g.setMaxLines(1);
            }
            if (advertAppInfo.D4()) {
                i();
                j();
                return;
            } else if (advertAppInfo.F4()) {
                k();
                return;
            } else {
                return;
            }
        }
        this.f61000c.setVisibility(8);
    }
}
