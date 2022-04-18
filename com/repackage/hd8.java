package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oj5;
/* loaded from: classes6.dex */
public class hd8 extends ld8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout i;
    public RoundTbImageView j;
    public TextView k;
    public TextView l;
    public ApkDownloadView m;
    public TextView n;
    public CountDownTextView o;
    public AdAppInfoView p;
    public DownloadCacheKey q;
    public tj5 r;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(hd8 hd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd8 a;

        public b(hd8 hd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hd8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (onClickListener = this.a.h) == null) {
                return;
            }
            onClickListener.onClick(view2);
            this.a.o.c();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nc8 a;
        public final /* synthetic */ hd8 b;

        public c(hd8 hd8Var, nc8 nc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hd8Var, nc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hd8Var;
            this.a = nc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = this.a.d;
                if (na8.C(this.b.d, str)) {
                    i = 3;
                } else {
                    AdvertAppInfo advertAppInfo = this.b.d;
                    i = na8.e(this.b.f, str, advertAppInfo.i() ? this.b.d.getDownloadId() : this.b.d.a, advertAppInfo.h, this.a.j);
                }
                if (i == 0) {
                    return;
                }
                AdvertAppInfo advertAppInfo2 = this.b.d;
                zc8 b = dd8.b(advertAppInfo2, 2, advertAppInfo2.position);
                b.h("VIDEO_FLOW_TAIL");
                bd8.b().d(b);
                ed7.h(ed7.e(this.b.d));
                this.b.o.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements oj5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd8 a;

        public d(hd8 hd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hd8Var;
        }

        @Override // com.repackage.oj5.a
        public boolean b(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                vi5.a(this.a.g.getButtonCmdScheme());
                ed7.h(ed7.e(this.a.d));
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd8(View view2, String str) {
        super(view2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p();
    }

    @Override // com.repackage.ld8
    public void d(nc8 nc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nc8Var) == null) {
            super.d(nc8Var);
            if (nc8Var == null) {
                return;
            }
            this.j.K(nc8Var.c, 30, false);
            this.k.setText(nc8Var.b);
            this.l.setText(nc8Var.i);
            this.n.setOnClickListener(new b(this));
            this.o.setFormatString(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f00b5));
            this.i.setOnClickListener(new c(this, nc8Var));
            AdvertAppInfo advertAppInfo = this.d;
            if (advertAppInfo == null || this.g == null || !advertAppInfo.i()) {
                return;
            }
            this.p.setAd(this.d);
            this.p.setAppInfo(this.d.i.getAppInfoModel());
            q();
            r();
        }
    }

    @Override // com.repackage.ld8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e();
            this.o.update(5);
            this.o.e();
            s();
            AdvertAppInfo advertAppInfo = this.d;
            bd8.b().d(dd8.b(advertAppInfo, 103, advertAppInfo.position));
        }
    }

    @Override // com.repackage.ld8
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.f();
            u();
        }
    }

    @Override // com.repackage.ld8
    public void m(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            super.m(cVar);
            this.o.setTimeoutListener(cVar);
        }
    }

    public void o(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.q = downloadCacheKey;
        u();
        this.r = null;
        AdDownloadData b2 = lj5.d().b(downloadCacheKey);
        if (na8.r(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.g;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.g.getAdvertAppInfo().k;
            b2.setExtInfo(this.g.getAdvertAppInfo().h);
            b2.setDownloadKey(this.g.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.g.scheme);
            b2.setCmdScheme(this.g.cmdScheme);
        }
        lj5 d2 = lj5.d();
        ApkDownloadView apkDownloadView = this.m;
        pj5 c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.r = new rj5(c2);
        if (b2.extra().getPercent() > 0) {
            c2.e(b2);
        }
        s();
        this.m.d(b2.getCurrentState());
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.setOnClickListener(new a(this));
            this.i = (RelativeLayout) b(R.id.obfuscated_res_0x7f090098);
            this.j = (RoundTbImageView) b(R.id.obfuscated_res_0x7f092286);
            this.k = (TextView) b(R.id.obfuscated_res_0x7f09229d);
            this.l = (TextView) b(R.id.obfuscated_res_0x7f092282);
            this.m = (ApkDownloadView) b(R.id.obfuscated_res_0x7f090820);
            this.n = (TextView) b(R.id.obfuscated_res_0x7f091a38);
            this.o = (CountDownTextView) b(R.id.obfuscated_res_0x7f090703);
            this.p = (AdAppInfoView) b(R.id.obfuscated_res_0x7f0900b4);
            this.m.setTextColorInitSkin(R.color.CAM_X0101);
            this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.m.setTextSize(R.dimen.T_X06);
            this.m.setForegroundSkin(R.color.black_alpha15);
            this.m.setBackgroundSkin(R.drawable.obfuscated_res_0x7f081239);
            this.m.setRatio(0);
            this.m.j();
        }
    }

    public final void q() {
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (adCard = this.g) == null || adCard.downloadInfo == null) {
            return;
        }
        this.m.setInitText(adCard.operate.b);
        AdCard adCard2 = this.g;
        String str = adCard2.downloadInfo.a;
        DownloadData t = t(this.g, adCard2.getPosition());
        if (na8.r(str)) {
            t.setStatus(8);
        } else {
            t.setStatus(this.m.getDownloadStatus());
        }
        this.m.setData(t);
        this.m.setOnClickInterceptListener(new d(this));
    }

    public final void r() {
        DownloadCacheKey i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            AdCard adCard = this.g;
            String str = adCard.scheme;
            String downloadId = adCard.getDownloadId();
            if (!TextUtils.isEmpty(downloadId)) {
                i = lj5.d().h(downloadId);
            } else {
                i = lj5.d().i(str);
            }
            if (i == null) {
                hc8 hc8Var = this.g.downloadInfo;
                i = DownloadCacheKey.create(downloadId, hc8Var.b, hc8Var.a);
                lj5.d().j(i, null);
            }
            o(i);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.q == null || this.r == null) {
            return;
        }
        lj5.d().j(this.q, this.r);
    }

    public DownloadData t(AdCard adCard, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, adCard, i)) == null) {
            DownloadData downloadData = new DownloadData(adCard.getDownloadId());
            downloadData.setUrl(adCard.downloadInfo.b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i);
            downloadData.setNotifyId(mg.e(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.q == null || this.r == null) {
            return;
        }
        lj5.d().r(this.q, this.r);
    }
}
