package d.a.s0.u1.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.browser.IBrowserView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.medialive.browser.HkWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.j;
/* loaded from: classes9.dex */
public class a implements IBrowserView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HkWebView f67276a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f67277b;

    /* renamed from: c  reason: collision with root package name */
    public View f67278c;

    /* renamed from: d  reason: collision with root package name */
    public View f67279d;

    /* renamed from: e  reason: collision with root package name */
    public View f67280e;

    /* renamed from: f  reason: collision with root package name */
    public IBrowserView.OnBrowserStatusChangeCallBack f67281f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67282g;

    /* renamed from: d.a.s0.u1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1780a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f67283a;

        public C1780a(a aVar) {
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
            this.f67283a = aVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f67283a.i();
                if (this.f67283a.f67281f != null) {
                    this.f67283a.f67281f.onHideLoading();
                }
                if (this.f67283a.f67282g) {
                    this.f67283a.j();
                    if (this.f67283a.f67281f != null) {
                        this.f67283a.f67281f.onLoadFailure();
                    }
                } else if (this.f67283a.f67281f != null) {
                    this.f67283a.f67281f.onLoadSuccess();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.f67283a.f67282g = false;
                this.f67283a.k();
                this.f67283a.h();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest, webResourceError) == null) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                this.f67283a.f67282g = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                this.f67283a.f67282g = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Activity b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str) || (b2 = d.a.c.a.b.f().b()) == null) {
                    return false;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(b2), new String[]{str}, true);
                return true;
            }
            return invokeLL.booleanValue;
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
        this.f67282g = false;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canScrollVertically(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            HkWebView hkWebView = this.f67276a;
            if (hkWebView != null) {
                return hkWebView.canScrollVertically(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public View getView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (this.f67277b == null) {
                this.f67277b = new FrameLayout(context);
            }
            if (this.f67280e == null) {
                View view = new View(context);
                this.f67280e = view;
                view.setBackgroundColor(context.getResources().getColor(17170443));
            }
            if (this.f67276a == null) {
                HkWebView hkWebView = new HkWebView(context);
                this.f67276a = hkWebView;
                hkWebView.setWebViewClient(new C1780a(this));
            }
            this.f67277b.addView(this.f67276a);
            return this.f67277b;
        }
        return (View) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f67279d != null && this.f67280e.getParent() != null) {
                ((ViewGroup) this.f67280e.getParent()).removeView(this.f67280e);
            }
            View view = this.f67278c;
            if (view == null || view.getParent() == null) {
                return;
            }
            ((ViewGroup) this.f67278c.getParent()).removeView(this.f67278c);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f67279d != null && this.f67280e.getParent() != null) {
                ((ViewGroup) this.f67280e.getParent()).removeView(this.f67280e);
            }
            View view = this.f67279d;
            if (view == null || view.getParent() == null) {
                return;
            }
            ((ViewGroup) this.f67279d.getParent()).removeView(this.f67279d);
        }
    }

    public final void j() {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f67277b != null && (view2 = this.f67280e) != null && view2.getParent() == null) {
                this.f67277b.addView(this.f67280e, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f67277b == null || (view = this.f67278c) == null || view.getParent() != null) {
                return;
            }
            this.f67277b.addView(this.f67278c, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void k() {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f67277b != null && (view2 = this.f67280e) != null && view2.getParent() == null) {
                this.f67277b.addView(this.f67280e, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f67277b == null || (view = this.f67279d) == null || view.getParent() != null) {
                return;
            }
            this.f67277b.addView(this.f67279d, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void loadUrl(String str) {
        HkWebView hkWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (hkWebView = this.f67276a) == null) {
            return;
        }
        hkWebView.loadUrl(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f67276a = null;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void refresh() {
        HkWebView hkWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hkWebView = this.f67276a) == null) {
            return;
        }
        hkWebView.reload();
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setDynamicDispatcherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setErrorView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            this.f67278c = view;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            this.f67279d = view;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnBrowserStatusChangeCallBack(IBrowserView.OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onBrowserStatusChangeCallBack) == null) {
            this.f67281f = onBrowserStatusChangeCallBack;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnLongPressListener(IBrowserView.OnLongPressListener onLongPressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onLongPressListener) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setStateViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setUpSelect(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }
}
