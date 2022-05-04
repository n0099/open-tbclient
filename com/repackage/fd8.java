package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.oj5;
/* loaded from: classes6.dex */
public class fd8 extends ld8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView i;
    public TextView j;
    public ApkDownloadView k;
    public xc7 l;
    public String m;
    public DownloadCacheKey n;
    public tj5 o;
    public boolean p;
    public CustomMessageListener q;

    /* loaded from: classes6.dex */
    public class a implements oj5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nc8 a;
        public final /* synthetic */ fd8 b;

        public a(fd8 fd8Var, nc8 nc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd8Var, nc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fd8Var;
            this.a = nc8Var;
        }

        @Override // com.repackage.oj5.a
        public boolean b(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                fd8 fd8Var = this.b;
                if (fd8Var.p) {
                    vi5.a(this.a.j);
                } else {
                    vi5.a(fd8Var.g.getButtonCmdScheme());
                }
                ed7.h(this.b.e);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ fd8 c;

        public b(fd8 fd8Var, AdvertAppInfo advertAppInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd8Var, advertAppInfo, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fd8Var;
            this.a = advertAppInfo;
            this.b = i;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.c.s(this.a, this.b);
                if (this.c.k != null) {
                    this.c.k.w(this.c.B(this.a, this.b));
                }
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(fd8 fd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(fd8 fd8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fd8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(this.a.m) || !this.a.m.equals(downloadData.getId())) {
                return;
            }
            this.a.k.s(downloadData);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdvertAppInfo a;
        public final /* synthetic */ fd8 b;

        public e(fd8 fd8Var, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd8Var, advertAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fd8Var;
            this.a = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (mi.A()) {
                    boolean z = view2 == this.b.k;
                    ed7.h(this.b.e);
                    if (this.b.w()) {
                        this.b.k.performClick();
                        return;
                    }
                    AdvertAppInfo advertAppInfo = this.a;
                    if (advertAppInfo != null) {
                        int e = mg.e(advertAppInfo.g, -1);
                        int n = ApkDownloadView.n(this.b.B(this.a, e));
                        if ((6 == n || 7 == n) && mi.z() && !mi.H()) {
                            this.b.A(this.a, e, true, null);
                            return;
                        }
                        fd8 fd8Var = this.b;
                        fd8Var.t(this.a, e, fd8Var.k, z);
                        return;
                    }
                    return;
                }
                this.b.f.showToast(R.string.obfuscated_res_0x7f0f0c17);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fd8(View view2, String str) {
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
        this.o = null;
        this.q = new d(this, 2016483);
        u();
    }

    public void A(AdvertAppInfo advertAppInfo, int i, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{advertAppInfo, Integer.valueOf(i), Boolean.valueOf(z), str}) == null) || advertAppInfo == null) {
            return;
        }
        if (!mi.A()) {
            oi.M(this.f.getPageActivity(), R.string.obfuscated_res_0x7f0f0c17);
        } else if (advertAppInfo.i()) {
            if (TextUtils.isEmpty(str)) {
                str = this.f.getString(R.string.obfuscated_res_0x7f0f0714);
            }
            cr4 cr4Var = new cr4(this.f.getPageActivity());
            cr4Var.setMessage(str);
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f025d, new b(this, advertAppInfo, i));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new c(this));
            cr4Var.create(this.f).show();
        }
    }

    public final DownloadData B(AdvertAppInfo advertAppInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, i)) == null) {
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.r);
            downloadData.setName(advertAppInfo.n);
            downloadData.setPosition(i);
            downloadData.setNotifyId(mg.e(advertAppInfo.a, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.n == null || this.o == null) {
            return;
        }
        lj5.d().r(this.n, this.o);
    }

    @Override // com.repackage.ld8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            this.k.setTextColorInitSkin(R.color.CAM_X0101);
            this.k.setBackgroundSkin(R.drawable.obfuscated_res_0x7f0811cf);
            this.k.j();
        }
    }

    @Override // com.repackage.ld8
    public void d(nc8 nc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nc8Var) == null) {
            super.d(nc8Var);
            int i = 0;
            this.i.K(nc8Var.c, 10, false);
            this.j.setText(nc8Var.b);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
            this.k.setInitText(nc8Var.e);
            AdvertAppInfo advertAppInfo = this.d;
            if (advertAppInfo != null) {
                e eVar = new e(this, advertAppInfo);
                this.b.setOnClickListener(eVar);
                if (w()) {
                    this.k.setOnClickInterceptListener(new a(this, nc8Var));
                } else {
                    this.k.setOnClickListener(eVar);
                }
                try {
                    if (!TextUtils.isEmpty(this.d.g)) {
                        i = Integer.valueOf(this.d.g).intValue();
                    }
                } catch (NumberFormatException unused) {
                }
                AdvertAppInfo advertAppInfo2 = this.d;
                this.m = advertAppInfo2.s;
                DownloadData B = B(advertAppInfo2, i);
                y(B);
                this.k.setData(B);
            }
            if (!w()) {
                this.k.k(this.f.getUniqueId());
            }
            this.q.setTag(this.f.getUniqueId());
            v();
            c();
        }
    }

    @Override // com.repackage.ld8
    public void h(xc7 xc7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xc7Var) == null) {
            this.l = xc7Var;
        }
    }

    public final void r(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.n = downloadCacheKey;
        C();
        AdDownloadData b2 = lj5.d().b(downloadCacheKey);
        if (b2 != null) {
            this.k.d(b2.getCurrentState());
        } else {
            this.k.d(DownloadStatus.STATUS_NONE);
        }
        AdvertAppInfo advertAppInfo = this.d;
        String str = advertAppInfo != null ? advertAppInfo.k : "";
        AdvertAppInfo advertAppInfo2 = this.d;
        b2.setExtInfo(advertAppInfo2 != null ? advertAppInfo2.h : "");
        b2.setPage(str);
        AdvertAppInfo advertAppInfo3 = this.d;
        b2.setDeeplinkUrl(advertAppInfo3 != null ? advertAppInfo3.q : "");
        AdvertAppInfo advertAppInfo4 = this.d;
        b2.setCmdScheme(advertAppInfo4 != null ? advertAppInfo4.t : "");
        lj5 d2 = lj5.d();
        ApkDownloadView apkDownloadView = this.k;
        pj5 c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.o = new rj5(c2);
        if (b2.extra().getPercent() > 0) {
            c2.e(b2);
        }
        x();
    }

    public void s(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, advertAppInfo, i) == null) || advertAppInfo == null) {
            return;
        }
        if (!na8.c(this.f.getPageActivity())) {
            oi.M(this.f.getPageActivity(), R.string.obfuscated_res_0x7f0f1585);
            return;
        }
        xc7 xc7Var = this.l;
        if (xc7Var != null) {
            xc7Var.a(advertAppInfo, i);
        }
    }

    public void t(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{advertAppInfo, Integer.valueOf(i), apkDownloadView, Boolean.valueOf(z)}) == null) || advertAppInfo == null) {
            return;
        }
        DownloadData B = B(advertAppInfo, i);
        int n = ApkDownloadView.n(B);
        Log.e("guoqiangxiang", "status: " + n + " id: " + B.getId());
        if (n != 1) {
            if (n == 3) {
                nb8.d(this.f.getPageActivity(), advertAppInfo.s);
                return;
            } else if (n != 5) {
                if (n == 6 || n == 7) {
                    s(advertAppInfo, i);
                    apkDownloadView.t(B);
                    return;
                }
                return;
            }
        }
        nb8.a(advertAppInfo);
        apkDownloadView.q(B);
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.obfuscated_res_0x7f0922aa);
            this.i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.i.setDefaultBgResource(R.color.CAM_X0205);
            this.i.setIsRound(true);
            this.j = (TextView) b(R.id.obfuscated_res_0x7f09229d);
            this.k = (ApkDownloadView) b(R.id.obfuscated_res_0x7f090833);
            MessageManager.getInstance().registerListener(this.q);
        }
    }

    public final void v() {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && w() && (advertAppInfo = this.d) != null) {
            String downloadId = advertAppInfo.getDownloadId();
            DownloadCacheKey h = !TextUtils.isEmpty(downloadId) ? lj5.d().h(downloadId) : null;
            if (h == null) {
                AdvertAppInfo advertAppInfo2 = this.d;
                h = DownloadCacheKey.create(downloadId, advertAppInfo2.r, advertAppInfo2.s);
                lj5.d().j(h, null);
            }
            r(h);
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.n == null || this.o == null) {
            return;
        }
        lj5.d().j(this.n, this.o);
    }

    public final void y(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, downloadData) == null) {
            if (w()) {
                ApkDownloadView apkDownloadView = this.k;
                if (apkDownloadView == null) {
                    return;
                }
                downloadData.setStatus(apkDownloadView.getDownloadStatus());
                return;
            }
            downloadData.setStatus(ApkDownloadView.n(downloadData));
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.p = z;
        }
    }
}
