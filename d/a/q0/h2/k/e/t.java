package d.a.q0.h2.k.e;

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
import d.a.p0.s.q.c1;
/* loaded from: classes8.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f58001a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f58002b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f58003c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f58004d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f58005e;

    /* renamed from: f  reason: collision with root package name */
    public View f58006f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f58007g;

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f58008e;

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
            this.f58008e = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f58008e.f58007g != null) {
                        this.f58008e.f58007g.destroy();
                        this.f58008e.f58007g = null;
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
        this.f58001a = view;
        this.f58002b = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.f58004d = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (baseWebView = this.f58007g) == null) {
            return;
        }
        baseWebView.removeAllViews();
        this.f58007g.getSettings().setBuiltInZoomControls(true);
        this.f58007g.setVisibility(8);
        d.a.d.e.m.e.a().postDelayed(new c(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
    }

    public void b(c1 c1Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{c1Var, str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (c1Var != null && !ListUtils.isEmpty(c1Var.a()) && (viewStub = this.f58002b) != null) {
                if (this.f58003c == null) {
                    this.f58003c = (PbGiftListView) viewStub.inflate();
                }
                this.f58003c.setVisibility(0);
                this.f58003c.g(c1Var, str, str2, j, j2, j3);
                this.f58003c.i();
                return;
            }
            PbGiftListView pbGiftListView = this.f58003c;
            if (pbGiftListView != null) {
                pbGiftListView.setVisibility(8);
            }
        }
    }

    public void c(d.a.p0.s.q.q0 q0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q0Var) == null) || q0Var == null || d.a.d.e.p.k.isEmpty(q0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f58007g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && q0Var.c() == d.a.p0.s.q.q0.f53413g && this.f58004d != null) {
            if (q0Var.f()) {
                LinearLayout linearLayout = this.f58005e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f58005e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f58004d.inflate();
                this.f58005e = linearLayout2;
                this.f58006f = linearLayout2.findViewById(R.id.link_thread_divider);
                this.f58007g = (BaseWebView) this.f58005e.findViewById(R.id.link_thread_webview);
            }
            this.f58006f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f58006f, R.color.CAM_X0204);
            this.f58007g.setVisibility(0);
            this.f58007g.setFocusable(false);
            this.f58007g.setBackgroundColor(0);
            this.f58007g.getSettings().setCacheMode(-1);
            this.f58007g.setVerticalScrollBarEnabled(false);
            this.f58007g.setHorizontalScrollBarEnabled(false);
            this.f58007g.getSettings().setAllowFileAccess(true);
            this.f58007g.getSettings().setAppCacheEnabled(true);
            this.f58007g.getSettings().setDomStorageEnabled(true);
            this.f58007g.getSettings().setDatabaseEnabled(true);
            this.f58007g.setOnLoadUrlListener(new a(this));
            this.f58007g.setOnPageFinishedListener(new b(this));
            this.f58007g.loadUrl(q0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (baseWebView = this.f58007g) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baseWebView = this.f58007g) == null) {
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
