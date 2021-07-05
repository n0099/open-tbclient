package d.a.s0.w2.j0;

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
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.r.s.a;
import d.a.s0.q.d.g.b;
import d.a.s0.w2.c0.h;
import d.a.s0.w2.f0.b.f;
import d.a.s0.w2.x;
/* loaded from: classes9.dex */
public class a extends d.a.s0.w2.j0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f69240g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f69241h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f69242i;
    public d.a.s0.n1.o.c j;
    public String k;
    public DownloadCacheKey l;
    public d.a.s0.q.d.h.d m;
    public boolean n;
    public boolean o;
    public CustomMessageListener p;

    /* renamed from: d.a.s0.w2.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1876a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f69243a;

        public C1876a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69243a = aVar;
        }

        @Override // d.a.s0.q.d.g.b.a
        public boolean b(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                d.a.s0.n1.o.h.c.h(this.f69243a.f69267e);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f69244e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f69245f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f69246g;

        public b(a aVar, AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, advertAppInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69246g = aVar;
            this.f69244e = advertAppInfo;
            this.f69245f = i2;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f69246g.r(this.f69244e, this.f69245f);
                if (this.f69246g.f69242i != null) {
                    this.f69246g.f69242i.v(this.f69246g.A(this.f69244e, this.f69245f));
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f69247a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69247a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(this.f69247a.k) || !this.f69247a.k.equals(downloadData.getId())) {
                return;
            }
            this.f69247a.f69242i.r(downloadData);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public AdvertAppInfo f69248e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f69249f;

        public e(a aVar, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, advertAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69249f = aVar;
            this.f69248e = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.A()) {
                    boolean z = view == this.f69249f.f69242i;
                    d.a.s0.n1.o.h.c.h(this.f69249f.f69267e);
                    if (this.f69249f.v()) {
                        this.f69249f.f69242i.performClick();
                        return;
                    }
                    AdvertAppInfo advertAppInfo = this.f69248e;
                    if (advertAppInfo != null) {
                        int d2 = d.a.c.e.m.b.d(advertAppInfo.R3, -1);
                        int m = ApkDownloadView.m(this.f69249f.A(this.f69248e, d2));
                        if ((6 == m || 7 == m) && j.z() && !j.H()) {
                            this.f69249f.z(this.f69248e, d2, true, null);
                            return;
                        }
                        a aVar = this.f69249f;
                        aVar.s(this.f69248e, d2, aVar.f69242i, z);
                        return;
                    }
                    return;
                }
                this.f69249f.f69268f.showToast(R.string.neterror);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(View view, String str) {
        super(view, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = null;
        this.n = false;
        this.p = new d(this, 2016483);
        t();
    }

    public final DownloadData A(AdvertAppInfo advertAppInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, advertAppInfo, i2)) == null) {
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.c4);
            downloadData.setName(advertAppInfo.Y3);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(d.a.c.e.m.b.d(advertAppInfo.L3, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.l == null || this.m == null) {
            return;
        }
        d.a.s0.q.d.e.c().q(this.l, this.m);
    }

    @Override // d.a.s0.w2.j0.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            SkinManager.setViewTextColor(this.f69241h, R.color.CAM_X0101, 1);
            this.f69242i.setTextColorInitSkin(R.color.CAM_X0101);
            this.f69242i.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
            this.f69242i.i();
        }
    }

    @Override // d.a.s0.w2.j0.e
    public void d(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.d(fVar);
            int i2 = 0;
            this.f69240g.M(fVar.f69152c, 10, false);
            this.f69241h.setText(fVar.f69151b);
            this.f69242i.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
            this.f69242i.setInitText(fVar.f69154e);
            d.a.s0.n1.o.h.b bVar = this.f69267e;
            if (bVar instanceof AdCard) {
                this.n = ((AdCard) bVar).isDirectDownload();
            }
            AdvertAppInfo advertAppInfo = this.f69266d;
            if (advertAppInfo != null) {
                e eVar = new e(this, advertAppInfo);
                this.f69264b.setOnClickListener(eVar);
                if (v()) {
                    this.f69242i.setOnClickInterceptListener(new C1876a(this));
                } else {
                    this.f69242i.setOnClickListener(eVar);
                }
                try {
                    if (!TextUtils.isEmpty(this.f69266d.R3)) {
                        i2 = Integer.valueOf(this.f69266d.R3).intValue();
                    }
                } catch (NumberFormatException unused) {
                }
                AdvertAppInfo advertAppInfo2 = this.f69266d;
                this.k = advertAppInfo2.d4;
                DownloadData A = A(advertAppInfo2, i2);
                x(A);
                this.f69242i.setData(A);
            }
            if (!v()) {
                this.f69242i.j(this.f69268f.getUniqueId());
            }
            this.p.setTag(this.f69268f.getUniqueId());
            u();
            c();
        }
    }

    @Override // d.a.s0.w2.j0.e
    public void h(d.a.s0.n1.o.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public final void q(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.l = downloadCacheKey;
        B();
        AdDownloadData b2 = d.a.s0.q.d.e.c().b(downloadCacheKey);
        if (b2 != null) {
            this.f69242i.c(b2.getCurrentState());
        } else {
            this.f69242i.c(DownloadStatus.STATUS_NONE);
        }
        AdvertAppInfo advertAppInfo = this.f69266d;
        String str = advertAppInfo != null ? advertAppInfo.V3 : "";
        AdvertAppInfo advertAppInfo2 = this.f69266d;
        b2.setExtInfo(advertAppInfo2 != null ? advertAppInfo2.S3 : "");
        b2.setPage(str);
        AdvertAppInfo advertAppInfo3 = this.f69266d;
        b2.setDeeplinkUrl(advertAppInfo3 != null ? advertAppInfo3.b4 : "");
        d.a.s0.q.c.b.d.a aVar = new d.a.s0.q.c.b.d.a(this.f69242i, b2);
        this.m = new d.a.s0.q.d.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        w();
    }

    public void r(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, advertAppInfo, i2) == null) || advertAppInfo == null) {
            return;
        }
        if (!x.c(this.f69268f.getPageActivity())) {
            l.L(this.f69268f.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            return;
        }
        d.a.s0.n1.o.c cVar = this.j;
        if (cVar != null) {
            cVar.a(advertAppInfo, i2);
        }
    }

    public void s(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{advertAppInfo, Integer.valueOf(i2), apkDownloadView, Boolean.valueOf(z)}) == null) || advertAppInfo == null) {
            return;
        }
        DownloadData A = A(advertAppInfo, i2);
        int m = ApkDownloadView.m(A);
        Log.e("guoqiangxiang", "status: " + m + " id: " + A.getId());
        if (m != 1) {
            if (m == 3) {
                h.d(this.f69268f.getPageActivity(), advertAppInfo.d4);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
            this.f69240g = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f69240g.setDefaultBgResource(R.color.CAM_X0205);
            this.f69240g.setIsRound(true);
            this.f69241h = (TextView) b(R.id.user_name);
            this.f69242i = (ApkDownloadView) b(R.id.download_view);
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    public final void u() {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && v() && (advertAppInfo = this.f69266d) != null) {
            String downloadId = advertAppInfo.getDownloadId();
            DownloadCacheKey g2 = !TextUtils.isEmpty(downloadId) ? d.a.s0.q.d.e.c().g(downloadId) : null;
            if (g2 == null) {
                AdvertAppInfo advertAppInfo2 = this.f69266d;
                g2 = DownloadCacheKey.create(downloadId, advertAppInfo2.c4, advertAppInfo2.d4);
                d.a.s0.q.d.e.c().i(g2, null);
            }
            q(g2);
        }
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? !this.n || this.o : invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.l == null || this.m == null) {
            return;
        }
        d.a.s0.q.d.e.c().i(this.l, this.m);
    }

    public final void x(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadData) == null) {
            if (v()) {
                ApkDownloadView apkDownloadView = this.f69242i;
                if (apkDownloadView == null) {
                    return;
                }
                downloadData.setStatus(apkDownloadView.getDownloadStatus());
                return;
            }
            downloadData.setStatus(ApkDownloadView.m(downloadData));
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.o = z;
        }
    }

    public void z(AdvertAppInfo advertAppInfo, int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) || advertAppInfo == null) {
            return;
        }
        if (!j.A()) {
            l.L(this.f69268f.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.t4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.f69268f.getString(R.string.frs_network_tips);
            }
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f69268f.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new b(this, advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new c(this));
            aVar.create(this.f69268f).show();
        }
    }
}
