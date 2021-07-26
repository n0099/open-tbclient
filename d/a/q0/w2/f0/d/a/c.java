package d.a.q0.w2.f0.d.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.q0.q.d.e;
import d.a.q0.q.d.g.b;
import d.a.q0.w2.n;
import d.a.q0.w2.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66620a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f66621b;

    /* renamed from: c  reason: collision with root package name */
    public View f66622c;

    /* renamed from: d  reason: collision with root package name */
    public XfremodeRoundLayout f66623d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f66624e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66625f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66626g;

    /* renamed from: h  reason: collision with root package name */
    public AdAppInfoView f66627h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f66628i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public AdCard m;
    public DownloadCacheKey n;
    public d.a.q0.q.d.h.d o;
    public List<AdvertAppInfo> p;
    public List<AdvertAppInfo> q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66629e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66629e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.f66629e.m;
                this.f66629e.q.add(adCard.getAdvertAppInfo());
                d.a.q0.w2.i0.d.l(adCard.getAdvertAppInfo());
                this.f66629e.f66622c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66630e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66630e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.f66630e.m;
                String str = adCard.scheme;
                if (k.isEmpty(str)) {
                    return;
                }
                String str2 = adCard.ext;
                String downloadId = adCard.getDownloadId();
                int i2 = 3;
                if (!x.B(adCard.getAdvertAppInfo(), str)) {
                    int i3 = adCard.goodsStyle;
                    if ((i3 == 7 || i3 == 14) && adCard.videoInfo != null && adCard.getAdvertAppInfo() != null) {
                        i2 = x.g(TbadkCoreApplication.getInst(), str, adCard.getAdvertAppInfo());
                    } else {
                        i2 = x.d(TbadkCoreApplication.getInst(), str, downloadId, str2);
                    }
                }
                this.f66630e.f(i2, adCard);
            }
        }
    }

    /* renamed from: d.a.q0.w2.f0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1837c implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f66631a;

        public C1837c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66631a = cVar;
        }

        @Override // d.a.q0.q.d.g.b.a
        public boolean b(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f66631a.f(1, this.f66631a.m);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public c(ViewStub viewStub, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = null;
        this.f66621b = viewStub;
        this.f66620a = tbPageContext;
    }

    @Override // d.a.q0.w2.n
    public void a(AdvertAppInfo advertAppInfo, d.a.p0.b1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, cVar) == null) {
            if (advertAppInfo == null) {
                View view = this.f66622c;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f66622c == null) {
                l(this.f66621b);
                this.p = new ArrayList();
                this.q = new ArrayList();
            }
            q(advertAppInfo, cVar);
        }
    }

    public final void f(int i2, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, adCard) == null) || i2 == 0) {
            return;
        }
        if (x.p(i2)) {
            d.a.q0.w2.i0.d.e(adCard.getAdvertAppInfo(), i2);
        } else {
            d.a.q0.w2.i0.d.m(adCard.getAdvertAppInfo());
        }
        d.a.q0.n1.o.h.c.h(d.a.q0.n1.o.h.c.e(adCard.getAdvertAppInfo()));
    }

    public void g(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.n = downloadCacheKey;
        p();
        this.o = null;
        AdDownloadData b2 = e.c().b(downloadCacheKey);
        if (x.q(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.m;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.m.getAdvertAppInfo().b4;
            b2.setExtInfo(this.m.getAdvertAppInfo().Y3);
            b2.setDownloadKey(this.m.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.m.scheme);
        }
        d.a.q0.q.c.b.d.a aVar = new d.a.q0.q.c.b.d.a(this.f66628i, b2);
        this.o = new d.a.q0.q.d.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        n();
        this.f66628i.c(b2.getCurrentState());
    }

    public float h(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            try {
                return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i2).split(",")[0]);
            } catch (NumberFormatException unused) {
                return 0.0f;
            }
        }
        return invokeI.floatValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.j.setVisibility(8);
            this.f66628i.setVisibility(0);
            AdCard adCard = this.m;
            d.a.q0.w2.f0.b.b bVar = adCard.downloadInfo;
            if (bVar == null) {
                return;
            }
            String str = bVar.f66581a;
            DownloadData o = o(this.m, adCard.getPosition());
            if (x.q(str)) {
                o.setStatus(8);
            } else {
                o.setStatus(this.f66628i.getDownloadStatus());
            }
            this.f66628i.setData(o);
            this.f66628i.setOnClickInterceptListener(new C1837c(this));
        }
    }

    public final void j() {
        DownloadCacheKey h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AdCard adCard = this.m;
            String str = adCard.scheme;
            String downloadId = adCard.getDownloadId();
            if (!TextUtils.isEmpty(downloadId)) {
                h2 = e.c().g(downloadId);
            } else {
                h2 = e.c().h(str);
            }
            if (h2 == null) {
                d.a.q0.w2.f0.b.b bVar = this.m.downloadInfo;
                h2 = DownloadCacheKey.create(downloadId, bVar.f66582b, bVar.f66581a);
                e.c().i(h2, null);
            }
            g(h2);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f66628i.setVisibility(8);
            d.a.q0.w2.f0.b.a aVar = this.m.operate;
            String str = aVar != null ? aVar.f66579b : null;
            if (TextUtils.isEmpty(str)) {
                str = "立即查看";
            }
            this.j.setVisibility(0);
            this.j.setText(str);
        }
    }

    public final void l(ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewStub) == null) {
            viewStub.setLayoutResource(R.layout.ad_pic_banner_layout);
            View inflate = viewStub.inflate();
            this.f66622c = inflate;
            this.f66623d = (XfremodeRoundLayout) inflate.findViewById(R.id.ad_img_container);
            this.f66624e = (TbImageView) this.f66622c.findViewById(R.id.ad_img);
            this.f66625f = (TextView) this.f66622c.findViewById(R.id.ad_brand_name);
            this.f66626g = (TextView) this.f66622c.findViewById(R.id.ad_title);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.f66622c.findViewById(R.id.ad_app_info_view);
            this.f66627h = adAppInfoView;
            adAppInfoView.setTextColor(R.color.CAM_X0101);
            this.f66628i = (ApkDownloadView) this.f66622c.findViewById(R.id.ad_download_btn);
            this.j = (TextView) this.f66622c.findViewById(R.id.ad_transform_btn);
            this.k = (ImageView) this.f66622c.findViewById(R.id.ad_close_view);
            this.l = (TextView) this.f66622c.findViewById(R.id.ad_tag);
            this.f66623d.setRoundLayoutRadius(h(R.string.J_X05));
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.j);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0201);
            TbPageContext tbPageContext = this.f66620a;
            if (tbPageContext != null) {
                this.f66628i.j(tbPageContext.getUniqueId());
            }
            this.f66628i.setTextSize(R.dimen.T_X08);
            this.f66628i.setTextColorInitSkin(R.color.CAM_X0105);
            this.f66628i.setTextColorSkin(R.color.CAM_X0105);
            this.f66628i.setStrokeWidth(R.dimen.ds0);
            this.f66628i.setBackgroundSkin(R.drawable.pic_banner_down_btn_bg);
            this.f66628i.i();
            int[] p = l.p(TbadkCoreApplication.getInst());
            int i2 = p[0];
            int i3 = p[1];
            this.k.setOnClickListener(new a(this));
            this.f66622c.setOnClickListener(new b(this));
        }
    }

    public final void m(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo) == null) || this.p.contains(advertAppInfo)) {
            return;
        }
        this.p.add(advertAppInfo);
        d.a.q0.w2.i0.d.p(advertAppInfo);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.n == null || this.o == null) {
            return;
        }
        e.c().i(this.n, this.o);
    }

    public DownloadData o(AdCard adCard, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, adCard, i2)) == null) {
            DownloadData downloadData = new DownloadData(adCard.getDownloadId());
            downloadData.setUrl(adCard.downloadInfo.f66582b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(d.a.d.e.m.b.d(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    @Override // d.a.q0.w2.n
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.n == null || this.o == null) {
            return;
        }
        e.c().q(this.n, this.o);
    }

    public final void q(AdvertAppInfo advertAppInfo, d.a.p0.b1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, advertAppInfo, cVar) == null) {
            AdCard adCard = (AdCard) advertAppInfo.Z3;
            this.m = adCard;
            if (adCard != null && !cVar.j && !cVar.k) {
                if (this.q.contains(advertAppInfo)) {
                    this.f66622c.setVisibility(8);
                    return;
                }
                this.f66622c.setVisibility(0);
                m(advertAppInfo);
                ((RelativeLayout.LayoutParams) this.f66622c.getLayoutParams()).bottomMargin = cVar.f52044h + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
                d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.f66622c);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0214);
                this.f66624e.M(this.m.userImage, 17, false);
                this.f66625f.setText(this.m.userName);
                this.f66626g.setText(this.m.threadTitle);
                if (this.m.appInfoModel == null) {
                    this.f66627h.setVisibility(8);
                    this.l.setVisibility(0);
                    this.f66625f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X05));
                    this.f66626g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X07));
                    this.f66626g.setMaxLines(2);
                } else {
                    this.f66627h.setVisibility(0);
                    this.l.setVisibility(8);
                    this.f66627h.setAd(advertAppInfo);
                    this.f66627h.setAppInfo(this.m.appInfoModel);
                    this.f66625f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06));
                    this.f66626g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X08));
                    this.f66626g.setMaxLines(1);
                }
                if (advertAppInfo.w4()) {
                    i();
                    j();
                    return;
                } else if (advertAppInfo.y4()) {
                    k();
                    return;
                } else {
                    return;
                }
            }
            this.f66622c.setVisibility(8);
        }
    }
}
