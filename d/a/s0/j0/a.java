package d.a.s0.j0;

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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f62058a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f62059b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.h3.l0.a f62060c;

    /* renamed from: d  reason: collision with root package name */
    public ActivityLifeCycleListener f62061d;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f62062e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.h3.l0.c f62063f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f62064g;

    /* renamed from: d.a.s0.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1533a implements d.a.s0.h3.l0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f62065a;

        public C1533a(a aVar) {
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
            this.f62065a = aVar;
        }

        @Override // d.a.s0.h3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) ? this.f62065a.f62060c != null && this.f62065a.f62060c.b(this.f62065a.f62062e, str, jsPromptResult) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62066e;

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
            this.f62066e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62066e.f62059b.removeCallbacksAndMessages(null);
                this.f62066e.e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62067e;

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
            this.f62067e = aVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62067e.f62058a = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62068e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f62069f;

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
            this.f62069f = aVar;
            this.f62068e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f62069f.h(this.f62068e);
                } catch (Throwable unused) {
                    this.f62069f.e();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62070e;

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
            this.f62070e = aVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.f62070e.f62059b.removeCallbacksAndMessages(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f62071a;

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
            this.f62071a = aVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                this.f62071a.f62059b.removeCallbacksAndMessages(null);
                this.f62071a.e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62072e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f62073f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f62074g;

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
            this.f62074g = aVar;
            this.f62072e = str;
            this.f62073f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f62074g.i(this.f62072e, this.f62073f);
                } catch (Throwable unused) {
                    this.f62074g.e();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62075e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f62076f;

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
            this.f62076f = aVar;
            this.f62075e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!k.isEmpty(this.f62075e) && (view.getContext() instanceof TbPageContextSupport)) {
                    TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 1));
                    UrlManager.getInstance().dealOneLink(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{this.f62075e});
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 2));
                this.f62076f.e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62077e;

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
            this.f62077e = aVar;
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
                this.f62077e.e();
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
                this.f62077e.f62059b.removeCallbacksAndMessages(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f62078a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-901055696, "Ld/a/s0/j0/a$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-901055696, "Ld/a/s0/j0/a$j;");
                    return;
                }
            }
            f62078a = new a(null);
        }
    }

    public /* synthetic */ a(C1533a c1533a) {
        this();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? j.f62078a : (a) invokeV.objValue;
    }

    public void e() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (popupWindow = this.f62058a) != null && popupWindow.isShowing()) {
            try {
                this.f62058a.dismiss();
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || k.isEmpty(str) || (b2 = d.a.c.a.b.f().b()) == null || b2.getWindow() == null || b2.getWindow().getDecorView() == null) {
            return;
        }
        if (g(b2)) {
            this.f62059b.postDelayed(new d(this, str), 1000L);
            return;
        }
        PopupWindow popupWindow = this.f62058a;
        if (popupWindow != null && popupWindow.isShowing()) {
            if (this.f62058a.getContentView() != null && this.f62058a.getContentView().getContext() == b2) {
                return;
            }
            e();
        }
        View inflate = LayoutInflater.from(b2).inflate(R.layout.easter_egg_dialog_h5_layout, (ViewGroup) null);
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BaseWebView baseWebView = (BaseWebView) inflate.findViewById(R.id.dialog_webview);
        this.f62062e = baseWebView;
        baseWebView.loadUrl(str);
        this.f62062e.setOnPageFinishedListener(new e(this));
        this.f62062e.setOnReceivedErrorListener(new f(this));
        this.f62062e.setBackgroundColor(0);
        this.f62062e.setOnJsPromptCallback(this.f62063f);
        j(b2, inflate);
    }

    public void i(String str, String str2) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || k.isEmpty(str)) {
            return;
        }
        PopupWindow popupWindow = this.f62058a;
        if ((popupWindow == null || !popupWindow.isShowing()) && (b2 = d.a.c.a.b.f().b()) != null && PermissionUtil.checkWriteExternalStorage(b2)) {
            if (g(b2)) {
                this.f62059b.postDelayed(new g(this, str, str2), 1000L);
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
            this.f62058a = popupWindow;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.f62058a.setWidth(l.k(activity));
            this.f62058a.setHeight(l.i(activity));
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f62058a.setContentView(view);
            this.f62059b.removeCallbacksAndMessages(null);
            this.f62059b.postDelayed(this.f62064g, 5000L);
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null && !this.f62061d.isAdded()) {
                fragmentManager.beginTransaction().add(this.f62061d, "LIFE_CYCLE").commitAllowingStateLoss();
            }
            this.f62058a.setOnDismissListener(new c(this));
            try {
                this.f62058a.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
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
        this.f62059b = new Handler();
        this.f62063f = new C1533a(this);
        this.f62064g = new b(this);
        this.f62060c = new d.a.s0.h3.l0.a();
        this.f62060c.a(new EasterEggBridge());
        this.f62061d = new ActivityLifeCycleListener();
    }
}
