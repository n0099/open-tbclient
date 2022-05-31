package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.switchs.FunAdSplashClickRegionSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b45;
import com.repackage.ki5;
import com.repackage.kp6;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class rj5 implements hk5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "6021002119-1732188456";
    public static volatile boolean n;
    public static volatile kp6.h o;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<ViewGroup> b;
    public ViewGroup c;
    public FrameLayout d;
    public ViewGroup e;
    public AdLoadState f;
    public ok4 g;
    public ViewGroup.OnHierarchyChangeListener h;
    public boolean i;
    public long j;
    public final SplashNativePolicy k;
    public final kp6.i l;

    /* loaded from: classes7.dex */
    public class a extends kp6.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj5 a;

        public a(rj5 rj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj5Var;
        }

        @Override // com.repackage.kp6.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (hk5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdClicked : " + str);
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.a.g != null) {
                    this.a.g.e(false, false, 6, str, str2, str3);
                }
            }
        }

        @Override // com.repackage.kp6.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
                if (this.a.g != null) {
                    this.a.g.onAdDismiss();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.g == null ? 0 : this.a.g.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 6).param("obj_type", "a064").param("obj_param1", 4).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.i ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.a.j).eventStat();
                if (hk5.a) {
                    System.out.println("IAdSdkSplash bear ad onAdClose");
                }
            }
        }

        @Override // com.repackage.kp6.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (hk5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdError : " + str);
                }
                mk5.j(mk5.c, "1", null, null, str, null, this.a.j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.a.g != null) {
                    this.a.g.onAdDismiss();
                }
            }
        }

        @Override // com.repackage.kp6.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                if (hk5.a) {
                    System.out.println("IAdSdkSplash BEAR ad onAdshow");
                }
                this.a.g.g(false, false, 6);
                mk5.j(mk5.c, "0", null, str2, str, str3, this.a.j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.g != null ? this.a.g.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements b45.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(rj5 rj5Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj5Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.repackage.b45.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0778, (ViewGroup) null, false) : invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements kp6.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj5 a;

        public c(rj5 rj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj5Var;
        }

        @Override // com.repackage.kp6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (hk5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdLoaded successed: " + str);
                }
                if (this.a.g != null) {
                    this.a.g.f(mk5.c, true);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                if (kp6.j().o(str)) {
                    this.a.f = AdLoadState.SUCCEED;
                    mk5.i(mk5.c, "0", null, null, 0, i, this.a.i, this.a.j);
                } else {
                    this.a.f = AdLoadState.FAILED;
                    mk5.i(mk5.c, "1", str, null, 2, i, this.a.i, this.a.j);
                    ((ViewGroup) this.a.b.get()).removeView(this.a.c);
                }
                gk5.e().n(this.a.g);
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(81);
                }
                lk5.e(this.a.j);
            }
        }

        @Override // com.repackage.kp6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (hk5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onLoadError: " + str);
                }
                if (this.a.g != null) {
                    this.a.g.f(mk5.c, false);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                mk5.i(mk5.c, "1", str, null, 1, 0, this.a.i, this.a.j);
                this.a.f = AdLoadState.FAILED;
                ((ViewGroup) this.a.b.get()).removeView(this.a.c);
                gk5.e().n(this.a.g);
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(82);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements kp6.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj5 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ int b;

            public a(d dVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || rj5.o == null) {
                    return;
                }
                rj5.o.a(this.a, this.b);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public b(d dVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || rj5.o == null) {
                    return;
                }
                rj5.o.onError(this.a);
            }
        }

        public d(rj5 rj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj5Var;
        }

        @Override // com.repackage.kp6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (rj5.o == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    hashMap.put("loadSize", Integer.valueOf(i));
                    ki5.c().a(this.a.f(), "onAdLoaded", hashMap);
                } else if (li.C()) {
                    rj5.o.a(str, i);
                } else {
                    mg.a().post(new a(this, str, i));
                }
            }
        }

        @Override // com.repackage.kp6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (rj5.o == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    ki5.c().a(this.a.f(), "onError", hashMap);
                } else if (li.C()) {
                    rj5.o.onError(str);
                } else {
                    mg.a().post(new b(this, str));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj5 a;

        public e(rj5 rj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj5Var;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) || this.a.e == null || this.a.e.getVisibility() == 0) {
                return;
            }
            this.a.e.setVisibility(0);
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755348396, "Lcom/repackage/rj5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755348396, "Lcom/repackage/rj5;");
        }
    }

    public rj5(SplashNativePolicy splashNativePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {splashNativePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = AdLoadState.INIT;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = -1L;
        this.l = new a(this);
        this.k = splashNativePolicy;
        int l = ys4.k().l("splash_bear_sid_type_key", 0);
        if (UbsABTestHelper.isClickEyeSplashFunAdABTest()) {
            m = l == 1 ? "6021002538-255943035" : "6021002533-210422477";
        } else {
            m = l == 1 ? "6021002118-283136489" : "6021002119-1732188456";
        }
    }

    public static void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i) == null) {
            if (UbsABTestHelper.isClickEyeSplashFunAdABTest()) {
                m = i == 1 ? "6021002538-255943035" : "6021002533-210422477";
            } else {
                m = i == 1 ? "6021002118-283136489" : "6021002119-1732188456";
            }
            ys4.k().w("splash_bear_sid_type_key", i);
        }
    }

    @Override // com.repackage.hk5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            d dVar = new d(this);
            kp6.j().p(context, m, (int) (li.i(context) * 0.8125d), dVar, kp6.b("spalsh", gk5.e().d() + ""));
            n = true;
        }
    }

    @Override // com.repackage.hk5
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout frameLayout = this.d;
            return frameLayout != null && frameLayout.getChildCount() > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.hk5
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.hk5
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (AdLoadState) invokeV.objValue;
    }

    @Override // com.repackage.hk5
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            kp6.j().d(m);
            o = null;
        }
    }

    @Override // com.repackage.hk5
    public void e(rk4 rk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rk4Var) == null) {
            Context context = rk4Var.b().getContext();
            if (!(context instanceof Activity) || rk4Var.b() == null) {
                return;
            }
            this.i = rk4Var.d();
            this.j = rk4Var.c();
            this.b = new WeakReference<>(rk4Var.b());
            ViewGroup viewGroup = (ViewGroup) b45.e().d(1007, new b(this, context));
            this.c = viewGroup;
            if (viewGroup == null) {
                return;
            }
            this.d = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091d50);
            p();
            this.g = rk4Var.a();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(li.k(context), (int) (li.i(this.b.get().getContext()) * 0.8125d));
            layoutParams.addRule(14, -1);
            this.b.get().addView(this.c, layoutParams);
            if (hk5.a) {
                System.out.println("IAdSdkSplash BEAR ad start load");
            }
            o = new c(this);
            if (n) {
                r();
                n = false;
            } else {
                kp6 j = kp6.j();
                Activity activity = (Activity) context;
                String str = m;
                int i = (int) (li.i(context) * 0.8125d);
                kp6.h hVar = o;
                j.p(activity, str, i, hVar, kp6.b("spalsh", gk5.e().d() + ""));
            }
            if (this.f == AdLoadState.INIT) {
                this.f = AdLoadState.LOADING;
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
        }
    }

    @Override // com.repackage.hk5
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.c != null && FunAdSplashClickRegionSwitch.isOpen()) {
            ViewGroup viewGroup = (ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f091d4f);
            this.e = viewGroup;
            wq4 d2 = wq4.d(this.e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            wq4 d3 = wq4.d((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091d52));
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0101);
            WebPManager.setPureDrawable((ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091d51), R.drawable.obfuscated_res_0x7f08092e, R.color.CAM_X0201, null);
        }
    }

    public final void q() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (weakReference = this.b) == null || weakReference.get().getParent() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.b.get().getLayoutParams();
        layoutParams.width = li.k(this.b.get().getContext());
        layoutParams.height = (int) (li.i(this.b.get().getContext()) * 0.8125d);
        this.b.get().setLayoutParams(layoutParams);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || o == null || ki5.c().d(f()).isEmpty()) {
            return;
        }
        for (ki5.a aVar : ki5.c().d(f())) {
            String str = aVar.a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1349867671) {
                if (hashCode == 861234439 && str.equals("onAdLoaded")) {
                    c2 = 0;
                }
            } else if (str.equals("onError")) {
                c2 = 1;
            }
            if (c2 == 0) {
                o.a((String) aVar.b.get("sid"), ((Integer) aVar.b.get("loadSize")).intValue());
            } else if (c2 == 1) {
                o.onError((String) aVar.b.get("sid"));
            }
        }
        ki5.c().b(f());
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? kp6.j().o(m) : invokeV.booleanValue;
    }

    @Override // com.repackage.hk5
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.b != null && this.f == AdLoadState.SUCCEED) {
            q();
            this.f = AdLoadState.SHOWED;
            u();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.c != null && this.d != null) {
                if (this.h == null) {
                    this.h = new e(this);
                }
                this.d.setOnHierarchyChangeListener(this.h);
                if (this.b.get() != null) {
                    Context context = this.b.get().getContext();
                    if (context instanceof Activity) {
                        ns4.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                        if (hk5.a) {
                            PrintStream printStream = System.out;
                            printStream.println("IAdSdkSplash BEAR ad showSplash: " + m);
                        }
                        kp6.j().A((Activity) context, m, this.d, this.l, kp6.b("spalsh", gk5.e().d() + ""));
                        SkinManager.setBackgroundColor(this.c, R.color.CAM_X0101, 0);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
