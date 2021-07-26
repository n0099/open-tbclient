package d.a.q0.t.a;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RsplashType;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashLpCloseListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.data.AdSplashStyle;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.o0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class d implements d.a.q0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f62889b;

    /* renamed from: c  reason: collision with root package name */
    public int f62890c;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f62891d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f62892e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f62893f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.l.b f62894g;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62895a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62895a = dVar;
        }

        @Override // d.a.p0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62895a.m();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.l.a f62896a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f62897b;

        public b(d dVar, d.a.p0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62897b = dVar;
            this.f62896a = aVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                d.a.d.e.n.a a2 = j.a();
                a2.b("type", "cpc");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.q0.t.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rsplashType, i2) == null) {
                d.a.q0.t.a.j.a.j(d.a.q0.t.a.j.a.f62932e, "0", i2);
                this.f62897b.f62893f = AdLoadState.SUCCEED;
                if (d.a.q0.t.a.h.b.f62920a) {
                    Log.d("IAdSdkSplash", "bes cpc ad loaded success");
                }
                if (this.f62897b.f62891d == null || this.f62897b.f62892e == null) {
                    return;
                }
                this.f62897b.f62889b = rsplashType;
                this.f62897b.f62890c = 0;
                d.a.q0.t.a.h.a.c().g(this.f62896a);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (d.a.q0.t.a.h.b.f62920a) {
                    Log.d("IAdSdkSplash", "bes cpc ad onAdClick ");
                }
                d.a.p0.l.a aVar = this.f62896a;
                if (aVar != null) {
                    aVar.b(this.f62897b.f62889b == RsplashType.VIDEO, 1 == this.f62897b.f62890c, 7, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = this.f62897b.f62893f == AdLoadState.DISMISSED;
                this.f62897b.f62893f = AdLoadState.DISMISSED;
                d.a.p0.l.a aVar = this.f62896a;
                if (aVar == null || z) {
                    return;
                }
                aVar.onAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                d.a.q0.t.a.j.a.j(d.a.q0.t.a.j.a.f62932e, str, 0);
                if (d.a.q0.t.a.h.b.f62920a) {
                    Log.d("IAdSdkSplash", "bes cpc ad loaded failed : " + str);
                }
                this.f62897b.f62893f = AdLoadState.FAILED;
                d.a.q0.t.a.h.a.c().g(this.f62896a);
                d.a.q0.t.a.j.a.k(d.a.q0.t.a.j.a.f62932e, "1");
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (d.a.q0.t.a.h.b.f62920a) {
                    Log.d("IAdSdkSplash", "bes cpc ad present");
                }
                boolean z = 1 == this.f62897b.f62890c;
                d.a.p0.l.a aVar = this.f62896a;
                if (aVar != null) {
                    aVar.c(false, z, 7);
                }
                d.a.q0.t.a.j.a.k(d.a.q0.t.a.j.a.f62932e, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.p0.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f62896a) == null) {
                return;
            }
            aVar.onLpClosed();
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62890c = 1;
        new AdSplashStyle();
        this.f62893f = AdLoadState.INIT;
        this.f62894g = new a(this);
    }

    @Override // d.a.q0.t.a.h.b
    public AdLoadState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62893f : (AdLoadState) invokeV.objValue;
    }

    @Override // d.a.q0.t.a.h.b
    public void b(d.a.p0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f52711c = this.f62894g;
        d.a.p0.l.a a2 = dVar.a();
        this.f62892e = new WeakReference<>(dVar.b());
        b bVar = new b(this, a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.f0.a.b.a.f42713a.get().e());
            this.f62891d = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.f0.a.b.a.f42713a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), bVar);
            this.f62893f = AdLoadState.LOADING;
            this.f62891d.load();
            d.a.q0.t.a.j.a.i(d.a.q0.t.a.j.a.f62932e);
            if (d.a.q0.t.a.h.b.f62920a) {
                Log.d("IAdSdkSplash", "bes cpc ad start load ");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    @Override // d.a.q0.t.a.h.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "cpc" : (String) invokeV.objValue;
    }

    @Override // d.a.q0.t.a.h.b
    public void destroy() {
        SplashAd splashAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (splashAd = this.f62891d) == null) {
            return;
        }
        splashAd.destroy();
    }

    public final void m() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.f62892e) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f62892e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f62892e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.q0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f62891d == null || (weakReference = this.f62892e) == null || weakReference.get() == null || this.f62893f != AdLoadState.SUCCEED) {
            return;
        }
        m();
        int i2 = this.f62890c;
        if (this.f62892e.get().getChildCount() > 0) {
            this.f62892e.get().removeAllViews();
        }
        if (d.a.q0.t.a.h.b.f62920a) {
            Log.d("IAdSdkSplash", "bes cpc ad show");
        }
        this.f62893f = AdLoadState.SHOWED;
        this.f62891d.show(this.f62892e.get());
    }
}
