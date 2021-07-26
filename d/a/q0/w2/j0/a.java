package d.a.q0.w2.j0;

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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.s.s.a;
import d.a.q0.q.d.g.b;
import d.a.q0.w2.f0.b.f;
import d.a.q0.w2.x;
/* loaded from: classes8.dex */
public class a extends d.a.q0.w2.j0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f66699g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f66700h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f66701i;
    public d.a.q0.n1.o.c j;
    public String k;
    public DownloadCacheKey l;
    public d.a.q0.q.d.h.d m;
    public boolean n;
    public boolean o;
    public CustomMessageListener p;

    /* renamed from: d.a.q0.w2.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1838a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66702a;

        public C1838a(a aVar) {
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
            this.f66702a = aVar;
        }

        @Override // d.a.q0.q.d.g.b.a
        public boolean b(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                d.a.q0.n1.o.h.c.h(this.f66702a.f66726e);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f66703e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66704f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f66705g;

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
            this.f66705g = aVar;
            this.f66703e = advertAppInfo;
            this.f66704f = i2;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f66705g.r(this.f66703e, this.f66704f);
                if (this.f66705g.f66701i != null) {
                    this.f66705g.f66701i.v(this.f66705g.A(this.f66703e, this.f66704f));
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66706a;

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
            this.f66706a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(this.f66706a.k) || !this.f66706a.k.equals(downloadData.getId())) {
                return;
            }
            this.f66706a.f66701i.r(downloadData);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public AdvertAppInfo f66707e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f66708f;

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
            this.f66708f = aVar;
            this.f66707e = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.A()) {
                    boolean z = view == this.f66708f.f66701i;
                    d.a.q0.n1.o.h.c.h(this.f66708f.f66726e);
                    if (this.f66708f.v()) {
                        this.f66708f.f66701i.performClick();
                        return;
                    }
                    AdvertAppInfo advertAppInfo = this.f66707e;
                    if (advertAppInfo != null) {
                        int d2 = d.a.d.e.m.b.d(advertAppInfo.X3, -1);
                        int m = ApkDownloadView.m(this.f66708f.A(this.f66707e, d2));
                        if ((6 == m || 7 == m) && j.z() && !j.H()) {
                            this.f66708f.z(this.f66707e, d2, true, null);
                            return;
                        }
                        a aVar = this.f66708f;
                        aVar.s(this.f66707e, d2, aVar.f66701i, z);
                        return;
                    }
                    return;
                }
                this.f66708f.f66727f.showToast(R.string.neterror);
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
            downloadData.setUrl(advertAppInfo.i4);
            downloadData.setName(advertAppInfo.e4);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(d.a.d.e.m.b.d(advertAppInfo.R3, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.l == null || this.m == null) {
            return;
        }
        d.a.q0.q.d.e.c().q(this.l, this.m);
    }

    @Override // d.a.q0.w2.j0.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            SkinManager.setViewTextColor(this.f66700h, R.color.CAM_X0101, 1);
            this.f66701i.setTextColorInitSkin(R.color.CAM_X0101);
            this.f66701i.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
            this.f66701i.i();
        }
    }

    @Override // d.a.q0.w2.j0.e
    public void d(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.d(fVar);
            int i2 = 0;
            this.f66699g.M(fVar.f66599c, 10, false);
            this.f66700h.setText(fVar.f66598b);
            this.f66701i.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
            this.f66701i.setInitText(fVar.f66601e);
            d.a.q0.n1.o.h.b bVar = this.f66726e;
            if (bVar instanceof AdCard) {
                this.n = ((AdCard) bVar).isDirectDownload();
            }
            AdvertAppInfo advertAppInfo = this.f66725d;
            if (advertAppInfo != null) {
                e eVar = new e(this, advertAppInfo);
                this.f66723b.setOnClickListener(eVar);
                if (v()) {
                    this.f66701i.setOnClickInterceptListener(new C1838a(this));
                } else {
                    this.f66701i.setOnClickListener(eVar);
                }
                try {
                    if (!TextUtils.isEmpty(this.f66725d.X3)) {
                        i2 = Integer.valueOf(this.f66725d.X3).intValue();
                    }
                } catch (NumberFormatException unused) {
                }
                AdvertAppInfo advertAppInfo2 = this.f66725d;
                this.k = advertAppInfo2.j4;
                DownloadData A = A(advertAppInfo2, i2);
                x(A);
                this.f66701i.setData(A);
            }
            if (!v()) {
                this.f66701i.j(this.f66727f.getUniqueId());
            }
            this.p.setTag(this.f66727f.getUniqueId());
            u();
            c();
        }
    }

    @Override // d.a.q0.w2.j0.e
    public void h(d.a.q0.n1.o.c cVar) {
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
        AdDownloadData b2 = d.a.q0.q.d.e.c().b(downloadCacheKey);
        if (b2 != null) {
            this.f66701i.c(b2.getCurrentState());
        } else {
            this.f66701i.c(DownloadStatus.STATUS_NONE);
        }
        AdvertAppInfo advertAppInfo = this.f66725d;
        String str = advertAppInfo != null ? advertAppInfo.b4 : "";
        AdvertAppInfo advertAppInfo2 = this.f66725d;
        b2.setExtInfo(advertAppInfo2 != null ? advertAppInfo2.Y3 : "");
        b2.setPage(str);
        AdvertAppInfo advertAppInfo3 = this.f66725d;
        b2.setDeeplinkUrl(advertAppInfo3 != null ? advertAppInfo3.h4 : "");
        d.a.q0.q.c.b.d.a aVar = new d.a.q0.q.c.b.d.a(this.f66701i, b2);
        this.m = new d.a.q0.q.d.h.b(aVar);
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
        if (!x.c(this.f66727f.getPageActivity())) {
            l.L(this.f66727f.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            return;
        }
        d.a.q0.n1.o.c cVar = this.j;
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
                d.a.q0.w2.c0.j.d(this.f66727f.getPageActivity(), advertAppInfo.j4);
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
        d.a.q0.w2.c0.j.a(advertAppInfo);
        apkDownloadView.p(A);
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
            this.f66699g = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f66699g.setDefaultBgResource(R.color.CAM_X0205);
            this.f66699g.setIsRound(true);
            this.f66700h = (TextView) b(R.id.user_name);
            this.f66701i = (ApkDownloadView) b(R.id.download_view);
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    public final void u() {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && v() && (advertAppInfo = this.f66725d) != null) {
            String downloadId = advertAppInfo.getDownloadId();
            DownloadCacheKey g2 = !TextUtils.isEmpty(downloadId) ? d.a.q0.q.d.e.c().g(downloadId) : null;
            if (g2 == null) {
                AdvertAppInfo advertAppInfo2 = this.f66725d;
                g2 = DownloadCacheKey.create(downloadId, advertAppInfo2.i4, advertAppInfo2.j4);
                d.a.q0.q.d.e.c().i(g2, null);
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
        d.a.q0.q.d.e.c().i(this.l, this.m);
    }

    public final void x(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadData) == null) {
            if (v()) {
                ApkDownloadView apkDownloadView = this.f66701i;
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
            l.L(this.f66727f.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.w4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.f66727f.getString(R.string.frs_network_tips);
            }
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f66727f.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new b(this, advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new c(this));
            aVar.create(this.f66727f).show();
        }
    }
}
