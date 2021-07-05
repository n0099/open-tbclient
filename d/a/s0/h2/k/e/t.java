package d.a.s0.h2.k.e;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.c1;
/* loaded from: classes9.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f60660a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f60661b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f60662c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f60663d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f60664e;

    /* renamed from: f  reason: collision with root package name */
    public View f60665f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f60666g;

    /* loaded from: classes9.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f60667e;

        public c(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60667e = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f60667e.f60666g != null) {
                        this.f60667e.f60666g.destroy();
                        this.f60667e.f60666g = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    public t(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60660a = view;
        this.f60661b = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.f60663d = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (baseWebView = this.f60666g) == null) {
            return;
        }
        baseWebView.removeAllViews();
        this.f60666g.getSettings().setBuiltInZoomControls(true);
        this.f60666g.setVisibility(8);
        d.a.c.e.m.e.a().postDelayed(new c(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
    }

    public void b(c1 c1Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{c1Var, str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (c1Var != null && !ListUtils.isEmpty(c1Var.a()) && (viewStub = this.f60661b) != null) {
                if (this.f60662c == null) {
                    this.f60662c = (PbGiftListView) viewStub.inflate();
                }
                this.f60662c.setVisibility(0);
                this.f60662c.g(c1Var, str, str2, j, j2, j3);
                this.f60662c.i();
                return;
            }
            PbGiftListView pbGiftListView = this.f60662c;
            if (pbGiftListView != null) {
                pbGiftListView.setVisibility(8);
            }
        }
    }

    public void c(d.a.r0.r.q.q0 q0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q0Var) == null) || q0Var == null || d.a.c.e.p.k.isEmpty(q0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f60666g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && q0Var.c() == d.a.r0.r.q.q0.f56030g && this.f60663d != null) {
            if (q0Var.f()) {
                LinearLayout linearLayout = this.f60664e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f60664e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f60663d.inflate();
                this.f60664e = linearLayout2;
                this.f60665f = linearLayout2.findViewById(R.id.link_thread_divider);
                this.f60666g = (BaseWebView) this.f60664e.findViewById(R.id.link_thread_webview);
            }
            this.f60665f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f60665f, R.color.CAM_X0204);
            this.f60666g.setVisibility(0);
            this.f60666g.setFocusable(false);
            this.f60666g.setBackgroundColor(0);
            this.f60666g.getSettings().setCacheMode(-1);
            this.f60666g.setVerticalScrollBarEnabled(false);
            this.f60666g.setHorizontalScrollBarEnabled(false);
            this.f60666g.getSettings().setAllowFileAccess(true);
            this.f60666g.getSettings().setAppCacheEnabled(true);
            this.f60666g.getSettings().setDomStorageEnabled(true);
            this.f60666g.getSettings().setDatabaseEnabled(true);
            this.f60666g.setOnLoadUrlListener(new a(this));
            this.f60666g.setOnPageFinishedListener(new b(this));
            this.f60666g.loadUrl(q0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (baseWebView = this.f60666g) == null) {
            return;
        }
        try {
            baseWebView.onPause();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baseWebView = this.f60666g) == null) {
            return;
        }
        try {
            baseWebView.onResume();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }
}
