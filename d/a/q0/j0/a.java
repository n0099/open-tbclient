package d.a.q0.j0;

import android.animation.Animator;
import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.airbnb.lottie.RenderMode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.easterEgg.ActivityLifeCycleListener;
import com.baidu.tieba.easterEgg.EasterEggBridge;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f59437a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f59438b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.h3.l0.a f59439c;

    /* renamed from: d  reason: collision with root package name */
    public ActivityLifeCycleListener f59440d;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f59441e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.h3.l0.c f59442f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f59443g;

    /* renamed from: d.a.q0.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1494a implements d.a.q0.h3.l0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59444a;

        public C1494a(a aVar) {
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
            this.f59444a = aVar;
        }

        @Override // d.a.q0.h3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) ? this.f59444a.f59439c != null && this.f59444a.f59439c.b(this.f59444a.f59441e, str, jsPromptResult) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59445e;

        public b(a aVar) {
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
            this.f59445e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59445e.f59438b.removeCallbacksAndMessages(null);
                this.f59445e.e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59446e;

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
                    return;
                }
            }
            this.f59446e = aVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59446e.f59437a = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59447e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f59448f;

        public d(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59448f = aVar;
            this.f59447e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f59448f.h(this.f59447e);
                } catch (Throwable unused) {
                    this.f59448f.e();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59449e;

        public e(a aVar) {
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
            this.f59449e = aVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.f59449e.f59438b.removeCallbacksAndMessages(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59450a;

        public f(a aVar) {
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
            this.f59450a = aVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                this.f59450a.f59438b.removeCallbacksAndMessages(null);
                this.f59450a.e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f59452f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f59453g;

        public g(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59453g = aVar;
            this.f59451e = str;
            this.f59452f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f59453g.i(this.f59451e, this.f59452f);
                } catch (Throwable unused) {
                    this.f59453g.e();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f59455f;

        public h(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59455f = aVar;
            this.f59454e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!k.isEmpty(this.f59454e) && (view.getContext() instanceof TbPageContextSupport)) {
                    TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 1));
                    UrlManager.getInstance().dealOneLink(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{this.f59454e});
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 2));
                this.f59455f.e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59456e;

        public i(a aVar) {
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
            this.f59456e = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f59456e.e();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f59456e.f59438b.removeCallbacksAndMessages(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f59457a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-508028686, "Ld/a/q0/j0/a$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-508028686, "Ld/a/q0/j0/a$j;");
                    return;
                }
            }
            f59457a = new a(null);
        }
    }

    public /* synthetic */ a(C1494a c1494a) {
        this();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? j.f59457a : (a) invokeV.objValue;
    }

    public void e() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (popupWindow = this.f59437a) != null && popupWindow.isShowing()) {
            try {
                this.f59437a.dismiss();
            } catch (Throwable unused) {
            }
        }
    }

    public final boolean g(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) ? activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode")) : invokeL.booleanValue;
    }

    public void h(String str) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || k.isEmpty(str) || (b2 = d.a.d.a.b.f().b()) == null || b2.getWindow() == null || b2.getWindow().getDecorView() == null) {
            return;
        }
        if (g(b2)) {
            this.f59438b.postDelayed(new d(this, str), 1000L);
            return;
        }
        PopupWindow popupWindow = this.f59437a;
        if (popupWindow != null && popupWindow.isShowing()) {
            if (this.f59437a.getContentView() != null && this.f59437a.getContentView().getContext() == b2) {
                return;
            }
            e();
        }
        View inflate = LayoutInflater.from(b2).inflate(R.layout.easter_egg_dialog_h5_layout, (ViewGroup) null);
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BaseWebView baseWebView = (BaseWebView) inflate.findViewById(R.id.dialog_webview);
        this.f59441e = baseWebView;
        baseWebView.loadUrl(str);
        this.f59441e.setOnPageFinishedListener(new e(this));
        this.f59441e.setOnReceivedErrorListener(new f(this));
        this.f59441e.setBackgroundColor(0);
        this.f59441e.setOnJsPromptCallback(this.f59442f);
        j(b2, inflate);
    }

    public void i(String str, String str2) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || k.isEmpty(str)) {
            return;
        }
        PopupWindow popupWindow = this.f59437a;
        if ((popupWindow == null || !popupWindow.isShowing()) && (b2 = d.a.d.a.b.f().b()) != null && PermissionUtil.checkWriteExternalStorage(b2)) {
            if (g(b2)) {
                this.f59438b.postDelayed(new g(this, str, str2), 1000L);
                return;
            }
            View inflate = LayoutInflater.from(b2).inflate(R.layout.easter_egg_dialog_lottie_layout, (ViewGroup) null);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(R.id.easter_egg_lottie_view);
            tBLottieAnimationView.setBackgroundResource(R.color.transparent);
            tBLottieAnimationView.setAnimationUrl(str);
            tBLottieAnimationView.setRenderMode(RenderMode.HARDWARE);
            tBLottieAnimationView.enableMergePathsForKitKatAndAbove(true);
            tBLottieAnimationView.setOnClickListener(new h(this, str2));
            tBLottieAnimationView.addAnimatorListener(new i(this));
            tBLottieAnimationView.playAnimation();
            j(b2, inflate);
        }
    }

    public final void j(Activity activity, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, view) == null) {
            PopupWindow popupWindow = new PopupWindow(activity);
            this.f59437a = popupWindow;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.f59437a.setWidth(l.k(activity));
            this.f59437a.setHeight(l.i(activity));
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f59437a.setContentView(view);
            this.f59438b.removeCallbacksAndMessages(null);
            this.f59438b.postDelayed(this.f59443g, 5000L);
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null && !this.f59440d.isAdded()) {
                fragmentManager.beginTransaction().add(this.f59440d, "LIFE_CYCLE").commitAllowingStateLoss();
            }
            this.f59437a.setOnDismissListener(new c(this));
            try {
                this.f59437a.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
                TiebaStatic.log(new StatisticItem("c13126"));
            } catch (Throwable unused) {
            }
        }
    }

    public a() {
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
        this.f59438b = new Handler();
        this.f59442f = new C1494a(this);
        this.f59443g = new b(this);
        this.f59439c = new d.a.q0.h3.l0.a();
        this.f59439c.a(new EasterEggBridge());
        this.f59440d = new ActivityLifeCycleListener();
    }
}
