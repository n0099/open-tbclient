package d.a.p0.t.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.switchs.FunAdSplashClickRegionSwitch;
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
import d.a.p0.v0.a;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class c implements d.a.p0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String j = "6021002119-1732188456";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f62234b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f62235c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f62236d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f62237e;

    /* renamed from: f  reason: collision with root package name */
    public AdLoadState f62238f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.k.a f62239g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f62240h;

    /* renamed from: i  reason: collision with root package name */
    public final a.g f62241i;

    /* loaded from: classes8.dex */
    public class a extends a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f62242a;

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
            this.f62242a = cVar;
        }

        @Override // d.a.p0.v0.a.g
        public void onAdClicked(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (d.a.p0.t.a.h.b.f62276a) {
                    Log.d("IAdSdkSplash", "BEAR ad onAdClicked : " + str);
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.f62242a.f62239g != null) {
                    this.f62242a.f62239g.b(false, false, 6);
                }
            }
        }

        @Override // d.a.p0.v0.a.g
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
                FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
                if (this.f62242a.f62239g != null) {
                    this.f62242a.f62239g.onAdDismiss();
                }
            }
        }

        @Override // d.a.p0.v0.a.g
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (d.a.p0.t.a.h.b.f62276a) {
                    Log.d("IAdSdkSplash", "BEAR ad onAdError : " + str);
                }
                d.a.p0.t.a.j.a.k(d.a.p0.t.a.j.a.f62287d, "1");
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.f62242a.f62239g != null) {
                    this.f62242a.f62239g.onAdDismiss();
                }
            }
        }

        @Override // d.a.p0.v0.a.g
        public void onAdShow(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (d.a.p0.t.a.h.b.f62276a) {
                    Log.d("IAdSdkSplash", "BEAR ad onAdshow");
                }
                this.f62242a.f62239g.c(false, false, 6);
                d.a.p0.t.a.j.a.k(d.a.p0.t.a.j.a.f62287d, "0");
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f62243a;

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
            this.f62243a = cVar;
        }

        @Override // d.a.p0.v0.a.f
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (d.a.p0.t.a.h.b.f62276a) {
                    Log.d("IAdSdkSplash", "BEAR ad onAdLoaded successed: " + str);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                d.a.p0.t.a.j.a.j(d.a.p0.t.a.j.a.f62287d, "0", i2);
                if (d.a.p0.v0.a.h().k(str)) {
                    this.f62243a.f62238f = AdLoadState.SUCCEED;
                } else {
                    this.f62243a.f62238f = AdLoadState.FAILED;
                    ((ViewGroup) this.f62243a.f62234b.get()).removeView(this.f62243a.f62235c);
                }
                d.a.p0.t.a.h.a.c().g(this.f62243a.f62239g);
            }
        }

        @Override // d.a.p0.v0.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (d.a.p0.t.a.h.b.f62276a) {
                    Log.d("IAdSdkSplash", "BEAR ad onLoadError: " + str);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                d.a.p0.t.a.j.a.j(d.a.p0.t.a.j.a.f62287d, str, 0);
                this.f62243a.f62238f = AdLoadState.FAILED;
                ((ViewGroup) this.f62243a.f62234b.get()).removeView(this.f62243a.f62235c);
                d.a.p0.t.a.h.a.c().g(this.f62243a.f62239g);
            }
        }
    }

    /* renamed from: d.a.p0.t.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewGroup$OnHierarchyChangeListenerC1637c implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62244e;

        public ViewGroup$OnHierarchyChangeListenerC1637c(c cVar) {
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
            this.f62244e = cVar;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) || this.f62244e.f62237e == null || this.f62244e.f62237e.getVisibility() == 0) {
                return;
            }
            this.f62244e.f62237e.setVisibility(0);
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1108710805, "Ld/a/p0/t/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1108710805, "Ld/a/p0/t/a/c;");
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
        this.f62238f = AdLoadState.INIT;
        this.f62239g = null;
        this.f62240h = null;
        this.f62241i = new a(this);
        j = d.a.o0.r.d0.b.j().k("splash_bear_sid_type_key", 0) == 1 ? "6021002118-283136489" : "6021002119-1732188456";
    }

    public static void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i2) == null) {
            j = i2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
            d.a.o0.r.d0.b.j().v("splash_bear_sid_type_key", i2);
        }
    }

    @Override // d.a.p0.t.a.h.b
    public AdLoadState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62238f : (AdLoadState) invokeV.objValue;
    }

    @Override // d.a.p0.t.a.h.b
    public void b(d.a.o0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = dVar.b().getContext();
            if (!(context instanceof Activity) || dVar.b() == null) {
                return;
            }
            this.f62234b = new WeakReference<>(dVar.b());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.splash_fun_layout, (ViewGroup) null, false);
            this.f62235c = viewGroup;
            if (viewGroup == null) {
                return;
            }
            this.f62236d = (FrameLayout) viewGroup.findViewById(R.id.splash_fun_container);
            i();
            this.f62239g = dVar.a();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(context), (int) (l.i(this.f62234b.get().getContext()) * 0.8125d));
            layoutParams.addRule(14, -1);
            this.f62234b.get().addView(this.f62235c, layoutParams);
            if (d.a.p0.t.a.h.b.f62276a) {
                Log.d("IAdSdkSplash", "BEAR ad start load");
            }
            String str = j;
            b bVar = new b(this);
            d.a.p0.v0.a.h().l((Activity) context, str, bVar, d.a.p0.v0.a.a("spalsh", d.a.p0.t.a.h.a.c().b() + ""));
            this.f62238f = AdLoadState.LOADING;
            d.a.p0.t.a.j.a.i(d.a.p0.t.a.j.a.f62287d);
            FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
        }
    }

    @Override // d.a.p0.t.a.h.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    @Override // d.a.p0.t.a.h.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.p0.v0.a.h().c(j);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f62235c != null && FunAdSplashClickRegionSwitch.isOpen()) {
            ViewGroup viewGroup = (ViewGroup) this.f62235c.findViewById(R.id.splash_fun_click_region);
            this.f62237e = viewGroup;
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.f62237e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            d.a.o0.r.u.c d3 = d.a.o0.r.u.c.d((TextView) viewGroup.findViewById(R.id.splash_fun_textview));
            d3.y(R.string.F_X01);
            d3.t(R.color.CAM_X0101);
            WebPManager.setPureDrawable((ImageView) this.f62237e.findViewById(R.id.splash_fun_go), R.drawable.icon_pure_go, R.color.CAM_X0201, null);
        }
    }

    public final void j() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (weakReference = this.f62234b) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f62234b.get().getLayoutParams();
        layoutParams.width = l.k(this.f62234b.get().getContext());
        layoutParams.height = (int) (l.i(this.f62234b.get().getContext()) * 0.8125d);
        this.f62234b.get().setLayoutParams(layoutParams);
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f62235c != null && this.f62236d != null) {
                if (this.f62240h == null) {
                    this.f62240h = new ViewGroup$OnHierarchyChangeListenerC1637c(this);
                }
                this.f62236d.setOnHierarchyChangeListener(this.f62240h);
                if (this.f62234b.get() != null) {
                    Context context = this.f62234b.get().getContext();
                    if (context instanceof Activity) {
                        d.a.o0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                        d.a.p0.v0.a h2 = d.a.p0.v0.a.h();
                        Activity activity = (Activity) context;
                        String str = j;
                        FrameLayout frameLayout = this.f62236d;
                        a.g gVar = this.f62241i;
                        h2.o(activity, str, frameLayout, gVar, d.a.p0.v0.a.a("spalsh", d.a.p0.t.a.h.a.c().b() + ""));
                        SkinManager.setBackgroundColor(this.f62235c, R.color.CAM_X0101, 0);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.t.a.h.b
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f62234b != null && this.f62238f == AdLoadState.SUCCEED) {
            j();
            this.f62238f = AdLoadState.SHOWED;
            l();
        }
    }
}
