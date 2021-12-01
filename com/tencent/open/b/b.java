package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.log.SLog;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class b extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        SLog.i("openSDK_LOG.OpenWebView", "removeJSInterface");
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                getSettings().setBuiltInZoomControls(true);
                getSettings().setDisplayZoomControls(false);
                setVisibility(8);
                SLog.i("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls");
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls", e2);
            }
            super.destroy();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            WebSettings settings = getSettings();
            if (settings == null) {
                return;
            }
            settings.setSavePassword(false);
            try {
                Method method = settings.getClass().getMethod("removeJavascriptInterface", String.class);
                if (method != null) {
                    method.invoke(this, "searchBoxJavaBridge_");
                    method.invoke(this, "accessibility");
                    method.invoke(this, "accessibilityTraversal");
                    SLog.i("openSDK_LOG.OpenWebView", "remove js interface");
                }
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.OpenWebView", "remove js interface.e:" + e2.toString());
            }
        }
    }
}
