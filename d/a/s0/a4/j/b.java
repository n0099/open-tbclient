package d.a.s0.a4.j;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f57423a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f57424b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.a4.j.a f57425c;

    /* renamed from: d  reason: collision with root package name */
    public View f57426d;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f57427e;

    /* renamed from: f  reason: collision with root package name */
    public View f57428f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57429g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.r0.r.f0.a f57430h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.r0.r.f0.c f57431i;
    public boolean j;
    public float k;
    public Runnable l;
    public Runnable m;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57432e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57432e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57432e.f57427e == null) {
                return;
            }
            this.f57432e.q(false);
            this.f57432e.t();
        }
    }

    /* renamed from: d.a.s0.a4.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1311b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57433e;

        public RunnableC1311b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57433e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57433e.f57424b == null) {
                return;
            }
            this.f57433e.f57424b.ShowSoftKeyPadDelay(this.f57433e.f57427e);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57434e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57434e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57434e.f57425c.e();
                this.f57434e.f57424b.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f57435a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57435a = bVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f57435a.j = true;
                if (this.f57435a.f57425c != null) {
                    this.f57435a.f57425c.d();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                this.f57435a.q(false);
                this.f57435a.f57424b.showToast(R.string.neterror);
                this.f57435a.f57424b.finish();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                if (StringUtils.isNull(str) || this.f57435a.f57425c == null) {
                    return false;
                }
                if (!this.f57435a.j) {
                    this.f57435a.j = true;
                    this.f57435a.q(false);
                    this.f57435a.t();
                    this.f57435a.f57425c.d();
                    return true;
                }
                return this.f57435a.f57425c.f(str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57436e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57436e = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f57436e.f57424b.finish();
            }
        }
    }

    public b(AccountAccessActivity accountAccessActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {accountAccessActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57424b = null;
        this.f57425c = null;
        this.f57426d = null;
        this.f57427e = null;
        this.f57428f = null;
        this.f57429g = null;
        this.f57430h = null;
        this.f57431i = null;
        this.j = false;
        this.k = 1.2631578f;
        this.l = new a(this);
        this.m = new RunnableC1311b(this);
        if (accountAccessActivity == null) {
            return;
        }
        this.f57424b = accountAccessActivity;
        if (k(accountAccessActivity)) {
            return;
        }
        accountAccessActivity.finish();
    }

    public Animation f(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f2, f3);
            translateAnimation.setFillAfter(true);
            translateAnimation.setDuration(300L);
            return translateAnimation;
        }
        return (Animation) invokeCommon.objValue;
    }

    public BaseActivity g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57424b : (BaseActivity) invokeV.objValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57423a : invokeV.floatValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.floatValue;
    }

    public WebView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57427e : (WebView) invokeV.objValue;
    }

    public final boolean k(AccountAccessActivity accountAccessActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, accountAccessActivity)) == null) {
            accountAccessActivity.setActivityBgTransparent();
            accountAccessActivity.setSwipeBackEnabled(false);
            accountAccessActivity.setContentView(R.layout.account_access_activity);
            View findViewById = accountAccessActivity.findViewById(R.id.account_access_black_layout);
            this.f57426d = findViewById;
            findViewById.setOnClickListener(new c(this));
            View findViewById2 = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
            this.f57428f = findViewById2;
            TextView textView = (TextView) findViewById2.findViewById(R.id.custom_loading_text);
            this.f57429g = textView;
            textView.setText(accountAccessActivity.getResources().getString(R.string.sending));
            d.a.r0.r.f0.c cVar = new d.a.r0.r.f0.c();
            this.f57431i = cVar;
            cVar.f55627a = 1000L;
            this.f57423a = l.k(accountAccessActivity.getBaseContext()) / l.i(accountAccessActivity.getBaseContext());
            if (this.f57427e == null) {
                try {
                    this.f57427e = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                    UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.f57427e, this.k);
                    this.f57427e.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                    this.f57427e.setWebViewClient(new d(this));
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.l);
            d.a.c.e.m.e.a().removeCallbacks(this.m);
            this.f57430h = null;
        }
    }

    public void m(d.a.s0.a4.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f57425c = aVar;
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.k = f2;
            UtilHelper.setSupportHeight(this.f57424b.getPageContext().getPageActivity(), this.f57427e, f2);
        }
    }

    public void o(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048585, this, i2, i3, i4, i5) == null) && (this.f57427e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f57427e.getLayoutParams();
            marginLayoutParams.setMargins(i2, i3, i4, i5);
            this.f57427e.setLayoutParams(marginLayoutParams);
        }
    }

    public void p(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (view = this.f57428f) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (this.f57430h == null) {
                d.a.r0.r.f0.a aVar = new d.a.r0.r.f0.a(this.f57424b.getPageContext());
                this.f57430h = aVar;
                aVar.e(new e(this));
            }
            this.f57430h.h(z);
        }
    }

    public void r(boolean z) {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (baseWebView = this.f57427e) == null) {
            return;
        }
        if (z) {
            baseWebView.setVisibility(0);
        } else {
            baseWebView.setVisibility(4);
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            d.a.c.e.m.e.a().postDelayed(this.l, i2);
        }
    }

    public void t() {
        BaseActivity baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (baseActivity = this.f57424b) == null) {
            return;
        }
        if (this.k == this.f57423a) {
            int i2 = l.i(baseActivity.getBaseContext());
            BaseWebView baseWebView = this.f57427e;
            baseWebView.startAnimation(f(i2 - (baseWebView.getWidth() * 1.2631578f), 0.0f));
            d.a.c.e.m.e.a().postDelayed(this.m, 800L);
            return;
        }
        BaseWebView baseWebView2 = this.f57427e;
        baseWebView2.startAnimation(f(baseWebView2.getHeight(), 0.0f));
    }
}
