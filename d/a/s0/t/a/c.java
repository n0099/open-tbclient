package d.a.s0.t.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.v0.a;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class c implements d.a.s0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static String f65456g = "6021002119-1732188456";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f65457b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f65458c;

    /* renamed from: d  reason: collision with root package name */
    public AdLoadState f65459d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.k.a f65460e;

    /* renamed from: f  reason: collision with root package name */
    public final a.g f65461f;

    /* loaded from: classes9.dex */
    public class a extends a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65462a;

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
            this.f65462a = cVar;
        }

        @Override // d.a.s0.v0.a.g
        public void onAdClicked(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "BEAR ad onAdClicked : " + str);
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.f65462a.f65460e != null) {
                    this.f65462a.f65460e.b(false, false, 6);
                }
            }
        }

        @Override // d.a.s0.v0.a.g
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
                FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
                if (this.f65462a.f65460e != null) {
                    this.f65462a.f65460e.onAdDismiss();
                }
            }
        }

        @Override // d.a.s0.v0.a.g
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "BEAR ad onAdError : " + str);
                }
                d.a.s0.t.a.j.a.k(d.a.s0.t.a.j.a.f65506d, "1");
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.f65462a.f65460e != null) {
                    this.f65462a.f65460e.onAdDismiss();
                }
            }
        }

        @Override // d.a.s0.v0.a.g
        public void onAdShow(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "BEAR ad onAdshow");
                }
                this.f65462a.f65460e.c(false, false, 6);
                d.a.s0.t.a.j.a.k(d.a.s0.t.a.j.a.f65506d, "0");
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65463a;

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
            this.f65463a = cVar;
        }

        @Override // d.a.s0.v0.a.f
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "BEAR ad onAdLoaded successed: " + str);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                d.a.s0.t.a.j.a.j(d.a.s0.t.a.j.a.f65506d, "0", i2);
                if (d.a.s0.v0.a.h().k(str)) {
                    this.f65463a.f65459d = AdLoadState.SUCCEED;
                } else {
                    this.f65463a.f65459d = AdLoadState.FAILED;
                    ((ViewGroup) this.f65463a.f65457b.get()).removeView(this.f65463a.f65458c);
                }
                d.a.s0.t.a.h.a.c().g(this.f65463a.f65460e);
            }
        }

        @Override // d.a.s0.v0.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (d.a.s0.t.a.h.b.f65495a) {
                    Log.d("IAdSdkSplash", "BEAR ad onLoadError: " + str);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                d.a.s0.t.a.j.a.j(d.a.s0.t.a.j.a.f65506d, str, 0);
                this.f65463a.f65459d = AdLoadState.FAILED;
                ((ViewGroup) this.f65463a.f65457b.get()).removeView(this.f65463a.f65458c);
                d.a.s0.t.a.h.a.c().g(this.f65463a.f65460e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2058860398, "Ld/a/s0/t/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2058860398, "Ld/a/s0/t/a/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65459d = AdLoadState.INIT;
        this.f65460e = null;
        this.f65461f = new a(this);
        f65456g = d.a.r0.r.d0.b.j().k("splash_bear_sid_type_key", 0) == 1 ? "6021002118-283136489" : "6021002119-1732188456";
    }

    public static void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2) == null) {
            f65456g = i2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
            d.a.r0.r.d0.b.j().v("splash_bear_sid_type_key", i2);
        }
    }

    @Override // d.a.s0.t.a.h.b
    public AdLoadState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65459d : (AdLoadState) invokeV.objValue;
    }

    @Override // d.a.s0.t.a.h.b
    public void b(d.a.r0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = dVar.b().getContext();
            if (!(context instanceof Activity) || dVar.b() == null) {
                return;
            }
            this.f65457b = new WeakReference<>(dVar.b());
            Activity activity = (Activity) context;
            ViewGroup g2 = d.a.s0.v0.a.h().g(activity, f65456g);
            this.f65458c = g2;
            if (g2 == null) {
                return;
            }
            this.f65460e = dVar.a();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(context), (int) (l.i(this.f65457b.get().getContext()) * 0.8125d));
            layoutParams.addRule(14, -1);
            this.f65457b.get().addView(this.f65458c, layoutParams);
            if (d.a.s0.t.a.h.b.f65495a) {
                Log.d("IAdSdkSplash", "BEAR ad start load");
            }
            d.a.s0.v0.a h2 = d.a.s0.v0.a.h();
            String str = f65456g;
            b bVar = new b(this);
            h2.l(activity, str, bVar, d.a.s0.v0.a.a("spalsh", d.a.s0.t.a.h.a.c().b() + ""));
            this.f65459d = AdLoadState.LOADING;
            d.a.s0.t.a.j.a.i(d.a.s0.t.a.j.a.f65506d);
            FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
        }
    }

    @Override // d.a.s0.t.a.h.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    @Override // d.a.s0.t.a.h.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.s0.v0.a.h().c(f65456g);
        }
    }

    public final void h() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.f65457b) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f65457b.get().getLayoutParams();
        layoutParams.width = l.k(this.f65457b.get().getContext());
        layoutParams.height = (int) (l.i(this.f65457b.get().getContext()) * 0.8125d);
        this.f65457b.get().setLayoutParams(layoutParams);
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f65458c != null && this.f65457b.get() != null) {
                Context context = this.f65457b.get().getContext();
                if (context instanceof Activity) {
                    d.a.r0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                    d.a.s0.v0.a h2 = d.a.s0.v0.a.h();
                    Activity activity = (Activity) context;
                    String str = f65456g;
                    ViewGroup viewGroup = this.f65458c;
                    a.g gVar = this.f65461f;
                    h2.o(activity, str, viewGroup, gVar, d.a.s0.v0.a.a("spalsh", d.a.s0.t.a.h.a.c().b() + ""));
                    SkinManager.setBackgroundColor(this.f65458c, R.color.CAM_X0101, 0);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.t.a.h.b
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f65457b != null && this.f65459d == AdLoadState.SUCCEED) {
            h();
            this.f65459d = AdLoadState.SHOWED;
            j();
        }
    }
}
