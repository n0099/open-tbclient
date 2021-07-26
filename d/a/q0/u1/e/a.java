package d.a.q0.u1.e;

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
import d.a.d.a.j;
/* loaded from: classes8.dex */
public class a implements IBrowserView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HkWebView f64704a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f64705b;

    /* renamed from: c  reason: collision with root package name */
    public View f64706c;

    /* renamed from: d  reason: collision with root package name */
    public View f64707d;

    /* renamed from: e  reason: collision with root package name */
    public View f64708e;

    /* renamed from: f  reason: collision with root package name */
    public IBrowserView.OnBrowserStatusChangeCallBack f64709f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64710g;

    /* renamed from: d.a.q0.u1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1742a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64711a;

        public C1742a(a aVar) {
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
            this.f64711a = aVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f64711a.i();
                if (this.f64711a.f64709f != null) {
                    this.f64711a.f64709f.onHideLoading();
                }
                if (this.f64711a.f64710g) {
                    this.f64711a.j();
                    if (this.f64711a.f64709f != null) {
                        this.f64711a.f64709f.onLoadFailure();
                    }
                } else if (this.f64711a.f64709f != null) {
                    this.f64711a.f64709f.onLoadSuccess();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.f64711a.f64710g = false;
                this.f64711a.k();
                this.f64711a.h();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest, webResourceError) == null) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                this.f64711a.f64710g = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                this.f64711a.f64710g = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Activity b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str) || (b2 = d.a.d.a.b.f().b()) == null) {
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
        this.f64710g = false;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canScrollVertically(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            HkWebView hkWebView = this.f64704a;
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
            if (this.f64705b == null) {
                this.f64705b = new FrameLayout(context);
            }
            if (this.f64708e == null) {
                View view = new View(context);
                this.f64708e = view;
                view.setBackgroundColor(context.getResources().getColor(17170443));
            }
            if (this.f64704a == null) {
                HkWebView hkWebView = new HkWebView(context);
                this.f64704a = hkWebView;
                hkWebView.setWebViewClient(new C1742a(this));
            }
            this.f64705b.addView(this.f64704a);
            return this.f64705b;
        }
        return (View) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f64707d != null && this.f64708e.getParent() != null) {
                ((ViewGroup) this.f64708e.getParent()).removeView(this.f64708e);
            }
            View view = this.f64706c;
            if (view == null || view.getParent() == null) {
                return;
            }
            ((ViewGroup) this.f64706c.getParent()).removeView(this.f64706c);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f64707d != null && this.f64708e.getParent() != null) {
                ((ViewGroup) this.f64708e.getParent()).removeView(this.f64708e);
            }
            View view = this.f64707d;
            if (view == null || view.getParent() == null) {
                return;
            }
            ((ViewGroup) this.f64707d.getParent()).removeView(this.f64707d);
        }
    }

    public final void j() {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f64705b != null && (view2 = this.f64708e) != null && view2.getParent() == null) {
                this.f64705b.addView(this.f64708e, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f64705b == null || (view = this.f64706c) == null || view.getParent() != null) {
                return;
            }
            this.f64705b.addView(this.f64706c, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void k() {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f64705b != null && (view2 = this.f64708e) != null && view2.getParent() == null) {
                this.f64705b.addView(this.f64708e, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f64705b == null || (view = this.f64707d) == null || view.getParent() != null) {
                return;
            }
            this.f64705b.addView(this.f64707d, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void loadUrl(String str) {
        HkWebView hkWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (hkWebView = this.f64704a) == null) {
            return;
        }
        hkWebView.loadUrl(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f64704a = null;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void refresh() {
        HkWebView hkWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hkWebView = this.f64704a) == null) {
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
            this.f64706c = view;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            this.f64707d = view;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnBrowserStatusChangeCallBack(IBrowserView.OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onBrowserStatusChangeCallBack) == null) {
            this.f64709f = onBrowserStatusChangeCallBack;
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
