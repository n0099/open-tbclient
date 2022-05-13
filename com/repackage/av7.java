package com.repackage;

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
/* loaded from: classes5.dex */
public class av7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public ViewStub b;
    public PbGiftListView c;
    public ViewStub d;
    public LinearLayout e;
    public View f;
    public BaseWebView g;

    /* loaded from: classes5.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(av7 av7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {av7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes5.dex */
    public class b implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(av7 av7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {av7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ av7 a;

        public c(av7 av7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {av7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = av7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.g != null) {
                        this.a.g.destroy();
                        this.a.g = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    public av7(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        this.b = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090ca1);
        this.d = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f091277);
    }

    public void a() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (baseWebView = this.g) == null) {
            return;
        }
        baseWebView.removeAllViews();
        this.g.getSettings().setBuiltInZoomControls(true);
        this.g.setVisibility(8);
        ng.a().postDelayed(new c(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
    }

    public void b(cq4 cq4Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{cq4Var, str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (cq4Var != null && !ListUtils.isEmpty(cq4Var.a()) && (viewStub = this.b) != null) {
                if (this.c == null) {
                    this.c = (PbGiftListView) viewStub.inflate();
                }
                this.c.setVisibility(0);
                this.c.g(cq4Var, str, str2, j, j2, j3);
                this.c.i();
                return;
            }
            PbGiftListView pbGiftListView = this.c;
            if (pbGiftListView != null) {
                pbGiftListView.setVisibility(8);
            }
        }
    }

    public void c(rp4 rp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rp4Var) == null) || rp4Var == null || li.isEmpty(rp4Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && rp4Var.c() == rp4.g && this.d != null) {
            if (rp4Var.f()) {
                LinearLayout linearLayout = this.e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.d.inflate();
                this.e = linearLayout2;
                this.f = linearLayout2.findViewById(R.id.obfuscated_res_0x7f091272);
                this.g = (BaseWebView) this.e.findViewById(R.id.obfuscated_res_0x7f091278);
            }
            this.f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
            this.g.setVisibility(0);
            this.g.setFocusable(false);
            this.g.setBackgroundColor(0);
            this.g.getSettings().setCacheMode(-1);
            this.g.setVerticalScrollBarEnabled(false);
            this.g.setHorizontalScrollBarEnabled(false);
            this.g.getSettings().setAllowFileAccess(true);
            this.g.getSettings().setAppCacheEnabled(true);
            this.g.getSettings().setDomStorageEnabled(true);
            this.g.getSettings().setDatabaseEnabled(true);
            this.g.setOnLoadUrlListener(new a(this));
            this.g.setOnPageFinishedListener(new b(this));
            this.g.loadUrl(rp4Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (baseWebView = this.g) == null) {
            return;
        }
        try {
            baseWebView.onPause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void e() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baseWebView = this.g) == null) {
            return;
        }
        try {
            baseWebView.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }
}
