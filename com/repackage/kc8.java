package com.repackage;

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
import com.repackage.oj5;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class kc8 implements u98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ViewStub b;
    public View c;
    public XfremodeRoundLayout d;
    public TbImageView e;
    public TextView f;
    public TextView g;
    public AdAppInfoView h;
    public ApkDownloadView i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public AdCard m;
    public DownloadCacheKey n;
    public tj5 o;
    public List<AdvertAppInfo> p;
    public List<AdvertAppInfo> q;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc8 a;

        public a(kc8 kc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AdCard adCard = this.a.m;
                this.a.q.add(adCard.getAdvertAppInfo());
                tc8.m(adCard.getAdvertAppInfo());
                this.a.c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc8 a;

        public b(kc8 kc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AdCard adCard = this.a.m;
                String str = adCard.scheme;
                if (ni.isEmpty(str)) {
                    return;
                }
                String str2 = adCard.ext;
                String downloadId = adCard.getDownloadId();
                int i = 3;
                if (!ga8.C(adCard.getAdvertAppInfo(), str)) {
                    int i2 = adCard.goodsStyle;
                    if ((i2 == 7 || i2 == 14) && adCard.videoInfo != null && adCard.getAdvertAppInfo() != null) {
                        i = ga8.g(TbadkCoreApplication.getInst(), str, adCard.getAdvertAppInfo(), adCard.playCmdScheme);
                    } else {
                        i = ga8.d(TbadkCoreApplication.getInst(), str, downloadId, str2, adCard.cmdScheme);
                    }
                }
                this.a.f(i, adCard);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements oj5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc8 a;

        public c(kc8 kc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc8Var;
        }

        @Override // com.repackage.oj5.a
        public boolean b(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                AdCard adCard = this.a.m;
                vi5.a(this.a.m.getButtonCmdScheme());
                this.a.f(1, adCard);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public kc8(ViewStub viewStub, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = null;
        this.b = viewStub;
        this.a = tbPageContext;
    }

    @Override // com.repackage.u98
    public void a(AdvertAppInfo advertAppInfo, vb5 vb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, vb5Var) == null) {
            if (advertAppInfo == null) {
                View view2 = this.c;
                if (view2 != null) {
                    view2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.c == null) {
                l(this.b);
                this.p = new ArrayList();
                this.q = new ArrayList();
            }
            q(advertAppInfo, vb5Var);
        }
    }

    public final void f(int i, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, adCard) == null) || i == 0) {
            return;
        }
        if (ga8.q(i)) {
            tc8.f(adCard.getAdvertAppInfo(), i);
        } else {
            tc8.n(adCard.getAdvertAppInfo());
        }
        bd7.h(bd7.e(adCard.getAdvertAppInfo()));
    }

    public void g(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.n = downloadCacheKey;
        p();
        this.o = null;
        AdDownloadData b2 = lj5.d().b(downloadCacheKey);
        if (ga8.r(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.m;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.m.getAdvertAppInfo().k;
            b2.setExtInfo(this.m.getAdvertAppInfo().h);
            b2.setDownloadKey(this.m.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.m.scheme);
            b2.setCmdScheme(this.m.cmdScheme);
        }
        lj5 d = lj5.d();
        ApkDownloadView apkDownloadView = this.i;
        pj5 c2 = d.c(apkDownloadView, apkDownloadView, b2);
        this.o = new rj5(c2);
        if (b2.extra().getPercent() > 0) {
            c2.e(b2);
        }
        n();
        this.i.d(b2.getCurrentState());
    }

    public float h(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            try {
                return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i).split(",")[0]);
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
            this.i.setVisibility(0);
            AdCard adCard = this.m;
            ac8 ac8Var = adCard.downloadInfo;
            if (ac8Var == null) {
                return;
            }
            String str = ac8Var.a;
            DownloadData o = o(this.m, adCard.getPosition());
            if (ga8.r(str)) {
                o.setStatus(8);
            } else {
                o.setStatus(this.i.getDownloadStatus());
            }
            this.i.setData(o);
            this.i.setOnClickInterceptListener(new c(this));
        }
    }

    public final void j() {
        DownloadCacheKey i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AdCard adCard = this.m;
            String str = adCard.scheme;
            String downloadId = adCard.getDownloadId();
            if (!TextUtils.isEmpty(downloadId)) {
                i = lj5.d().h(downloadId);
            } else {
                i = lj5.d().i(str);
            }
            if (i == null) {
                ac8 ac8Var = this.m.downloadInfo;
                i = DownloadCacheKey.create(downloadId, ac8Var.b, ac8Var.a);
                lj5.d().j(i, null);
            }
            g(i);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i.setVisibility(8);
            zb8 zb8Var = this.m.operate;
            String str = zb8Var != null ? zb8Var.b : null;
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
            viewStub.setLayoutResource(R.layout.obfuscated_res_0x7f0d0071);
            View inflate = viewStub.inflate();
            this.c = inflate;
            this.d = (XfremodeRoundLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0900b1);
            this.e = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0900ad);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090095);
            this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0900f8);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.c.findViewById(R.id.obfuscated_res_0x7f090084);
            this.h = adAppInfoView;
            adAppInfoView.setTextColor(R.color.CAM_X0101);
            this.i = (ApkDownloadView) this.c.findViewById(R.id.obfuscated_res_0x7f0900a2);
            this.j = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0900fa);
            this.k = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090096);
            this.l = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0900f0);
            this.d.setRoundLayoutRadius(h(R.string.J_X05));
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            wr4 d = wr4.d(this.j);
            d.n(R.string.J_X01);
            d.f(R.color.CAM_X0201);
            TbPageContext tbPageContext = this.a;
            if (tbPageContext != null) {
                this.i.k(tbPageContext.getUniqueId());
            }
            this.i.setTextSize(R.dimen.T_X08);
            this.i.setTextColorInitSkin(R.color.CAM_X0105);
            this.i.setTextColorSkin(R.color.CAM_X0105);
            this.i.setStrokeWidth(R.dimen.obfuscated_res_0x7f070232);
            this.i.setBackgroundSkin(R.drawable.obfuscated_res_0x7f080ee0);
            this.i.j();
            int[] p = oi.p(TbadkCoreApplication.getInst());
            int i = p[0];
            int i2 = p[1];
            this.k.setOnClickListener(new a(this));
            this.c.setOnClickListener(new b(this));
        }
    }

    public final void m(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo) == null) || this.p.contains(advertAppInfo)) {
            return;
        }
        this.p.add(advertAppInfo);
        tc8.q(advertAppInfo);
        bd7.g(bd7.e(advertAppInfo));
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.n == null || this.o == null) {
            return;
        }
        lj5.d().j(this.n, this.o);
    }

    public DownloadData o(AdCard adCard, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, adCard, i)) == null) {
            DownloadData downloadData = new DownloadData(adCard.getDownloadId());
            downloadData.setUrl(adCard.downloadInfo.b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i);
            downloadData.setNotifyId(mg.e(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    @Override // com.repackage.u98
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
        lj5.d().r(this.n, this.o);
    }

    public final void q(AdvertAppInfo advertAppInfo, vb5 vb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, advertAppInfo, vb5Var) == null) {
            AdCard adCard = (AdCard) advertAppInfo.i;
            this.m = adCard;
            if (adCard != null && !vb5Var.j && !vb5Var.k) {
                if (this.q.contains(advertAppInfo)) {
                    this.c.setVisibility(8);
                    return;
                }
                this.c.setVisibility(0);
                m(advertAppInfo);
                ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).bottomMargin = vb5Var.h + oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds52);
                wr4 d = wr4.d(this.c);
                d.n(R.string.J_X06);
                d.f(R.color.CAM_X0214);
                this.e.K(this.m.userImage, 17, false);
                this.f.setText(this.m.userName);
                this.g.setText(this.m.threadTitle);
                if (this.m.appInfoModel == null) {
                    this.h.setVisibility(8);
                    this.l.setVisibility(0);
                    this.f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X05));
                    this.g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X07));
                    this.g.setMaxLines(2);
                } else {
                    this.h.setVisibility(0);
                    this.l.setVisibility(8);
                    this.h.setAd(advertAppInfo);
                    this.h.setAppInfo(this.m.appInfoModel);
                    this.f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06));
                    this.g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X08));
                    this.g.setMaxLines(1);
                }
                if (advertAppInfo.i()) {
                    i();
                    j();
                    return;
                } else if (advertAppInfo.m()) {
                    k();
                    return;
                } else {
                    return;
                }
            }
            this.c.setVisibility(8);
        }
    }
}
