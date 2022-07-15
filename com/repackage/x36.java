package com.repackage;

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
/* loaded from: classes7.dex */
public class x36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PopupWindow a;
    public Handler b;
    public cj8 c;
    public ActivityLifeCycleListener d;
    public BaseWebView e;
    public ej8 f;
    public Runnable g;

    /* loaded from: classes7.dex */
    public class a implements ej8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x36 a;

        public a(x36 x36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x36Var;
        }

        @Override // com.repackage.ej8
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) ? this.a.c != null && this.a.c.b(this.a.e, str, jsPromptResult) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x36 a;

        public b(x36 x36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x36Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.removeCallbacksAndMessages(null);
                this.a.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x36 a;

        public c(x36 x36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x36Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ x36 b;

        public d(x36 x36Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x36Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x36Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.b.h(this.a);
                } catch (Throwable unused) {
                    this.b.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x36 a;

        public e(x36 x36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x36Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.a.b.removeCallbacksAndMessages(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x36 a;

        public f(x36 x36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x36Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i, str, str2) == null) {
                this.a.b.removeCallbacksAndMessages(null);
                this.a.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ x36 c;

        public g(x36 x36Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x36Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x36Var;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.c.i(this.a, this.b);
                } catch (Throwable unused) {
                    this.c.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ x36 b;

        public h(x36 x36Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x36Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x36Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!oi.isEmpty(this.a) && (view2.getContext() instanceof TbPageContextSupport)) {
                    TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 1));
                    UrlManager.getInstance().dealOneLink(((TbPageContextSupport) view2.getContext()).getPageContext(), new String[]{this.a});
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 2));
                this.b.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x36 a;

        public i(x36 x36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x36Var;
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
                this.a.e();
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
                this.a.b.removeCallbacksAndMessages(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public static x36 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(80656752, "Lcom/repackage/x36$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(80656752, "Lcom/repackage/x36$j;");
                    return;
                }
            }
            a = new x36(null);
        }
    }

    public /* synthetic */ x36(a aVar) {
        this();
    }

    public static x36 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? j.a : (x36) invokeV.objValue;
    }

    public void e() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (popupWindow = this.a) != null && popupWindow.isShowing()) {
            try {
                this.a.dismiss();
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || oi.isEmpty(str) || (b2 = z8.g().b()) == null || b2.getWindow() == null || b2.getWindow().getDecorView() == null) {
            return;
        }
        if (g(b2)) {
            this.b.postDelayed(new d(this, str), 1000L);
            return;
        }
        PopupWindow popupWindow = this.a;
        if (popupWindow != null && popupWindow.isShowing()) {
            if (this.a.getContentView() != null && this.a.getContentView().getContext() == b2) {
                return;
            }
            e();
        }
        View inflate = LayoutInflater.from(b2).inflate(R.layout.obfuscated_res_0x7f0d023a, (ViewGroup) null);
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BaseWebView baseWebView = (BaseWebView) inflate.findViewById(R.id.obfuscated_res_0x7f090795);
        this.e = baseWebView;
        baseWebView.loadUrl(str);
        this.e.setOnPageFinishedListener(new e(this));
        this.e.setOnReceivedErrorListener(new f(this));
        this.e.setBackgroundColor(0);
        this.e.setOnJsPromptCallback(this.f);
        j(b2, inflate);
    }

    public void i(String str, String str2) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || oi.isEmpty(str)) {
            return;
        }
        PopupWindow popupWindow = this.a;
        if ((popupWindow == null || !popupWindow.isShowing()) && (b2 = z8.g().b()) != null && PermissionUtil.checkWriteExternalStorage(b2)) {
            if (g(b2)) {
                this.b.postDelayed(new g(this, str, str2), 1000L);
                return;
            }
            View inflate = LayoutInflater.from(b2).inflate(R.layout.obfuscated_res_0x7f0d023b, (ViewGroup) null);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f09081e);
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

    public final void j(Activity activity, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, view2) == null) {
            PopupWindow popupWindow = new PopupWindow(activity);
            this.a = popupWindow;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.a.setWidth(pi.k(activity));
            this.a.setHeight(pi.i(activity));
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.a.setContentView(view2);
            this.b.removeCallbacksAndMessages(null);
            this.b.postDelayed(this.g, 5000L);
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null && !this.d.isAdded()) {
                fragmentManager.beginTransaction().add(this.d, "LIFE_CYCLE").commitAllowingStateLoss();
            }
            this.a.setOnDismissListener(new c(this));
            try {
                this.a.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
                TiebaStatic.log(new StatisticItem("c13126"));
            } catch (Throwable unused) {
            }
        }
    }

    public x36() {
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
        this.b = new Handler();
        this.f = new a(this);
        this.g = new b(this);
        this.c = new cj8();
        this.c.a(new EasterEggBridge());
        this.d = new ActivityLifeCycleListener();
    }
}
