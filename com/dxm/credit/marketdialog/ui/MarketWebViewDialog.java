package com.dxm.credit.marketdialog.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.SDKJumpManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.dxm.credit.marketdialog.data.MarketDialogResponse;
import com.dxmpay.wallet.core.beans.BeanConstants;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class MarketWebViewDialog extends MarketBaseDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public WebView f55042j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f55043k;

    /* loaded from: classes12.dex */
    public class a extends SafeWebView.SafeWebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarketWebViewDialog f55044e;

        /* renamed from: com.dxm.credit.marketdialog.ui.MarketWebViewDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class RunnableC1968a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f55045e;

            public RunnableC1968a(a aVar) {
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
                this.f55045e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f55045e.f55044e.isShowing() && this.f55045e.f55044e.isInQueue()) {
                    this.f55045e.f55044e.dismiss();
                }
            }
        }

        public a(MarketWebViewDialog marketWebViewDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marketWebViewDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55044e = marketWebViewDialog;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                if (this.f55044e.isShowing() || !this.f55044e.isInQueue()) {
                    return;
                }
                this.f55044e.f55043k.postDelayed(new RunnableC1968a(this), 3000L);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
                webView.loadUrl(str);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.e.b.a.b.b f55046e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarketWebViewDialog f55047f;

        public b(MarketWebViewDialog marketWebViewDialog, c.e.b.a.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marketWebViewDialog, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55047f = marketWebViewDialog;
            this.f55046e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f55047f.isShowing()) {
                    this.f55047f.dismiss();
                }
                this.f55047f.e(this.f55046e);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.e.b.a.b.b f55048e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarketWebViewDialog f55049f;

        public c(MarketWebViewDialog marketWebViewDialog, c.e.b.a.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marketWebViewDialog, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55049f = marketWebViewDialog;
            this.f55048e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55049f.showOnly();
                this.f55049f.e(this.f55048e);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements SDKJumpManager.OnJumpListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarketWebViewDialog a;

        public d(MarketWebViewDialog marketWebViewDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marketWebViewDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = marketWebViewDialog;
        }

        @Override // com.baidu.wallet.base.widget.SDKJumpManager.OnJumpListener
        public void beforeJump(Context context, String str, String str2, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, Boolean.valueOf(z)}) == null) {
                MarketDialogResponse.Dialog dialog = this.a.mData;
                DXMSdkSAUtils.onEventWithValues("sdk_market_dialog_click_jump", Arrays.asList(dialog.group_name, dialog.group_limit));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarketWebViewDialog f55050e;

        public e(MarketWebViewDialog marketWebViewDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marketWebViewDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55050e = marketWebViewDialog;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketWebViewDialog(Context context) {
        super(context, ResUtils.style(context, "WalletTheme.TranslucentDialog"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55043k = new Handler();
        d();
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains(IStringUtil.WINDOWS_FOLDER_SEPARATOR)) {
                    str = str.replaceAll("\\\\", "\\\\\\\\");
                }
                if (str.contains("'")) {
                    str = str.replaceAll("'", "\\\\'");
                }
                if (str.contains("\"")) {
                    str = str.replaceAll("\"", "\\\\\"");
                }
                if (str.contains("\r\n")) {
                    str = str.replaceAll("\r\n", "\\u000d\\u000a");
                }
                if (str.contains(StringUtils.LF)) {
                    str = str.replaceAll(StringUtils.LF, "\\u000a");
                }
                LogUtil.d(str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setCancelable(false);
            SafeWebView safeWebView = new SafeWebView(getContext());
            this.f55042j = safeWebView;
            safeWebView.setLongClickable(true);
            this.f55042j.setOnLongClickListener(new e(this));
            WebView webView = this.f55042j;
            this.mRootView = webView;
            setContentView(webView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public final void e(c.e.b.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            f(bVar, 0, "success");
        }
    }

    public final void f(c.e.b.a.b.b bVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, bVar, i2, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put(BeanConstants.DXM_OCR_KEY_CNT, jSONObject2);
                jSONObject2.put("errCode", i2);
                jSONObject2.put("des", str);
                jSONObject2.put("data", StringUtil.EMPTY_ARRAY);
                if (i2 == 0) {
                    jSONObject.put("result", 0);
                    bVar.d("\"" + c(jSONObject.toString()) + "\"");
                    return;
                }
                jSONObject.put("result", 1);
                bVar.f("\"" + c(jSONObject.toString()) + "\"");
            } catch (JSONException unused) {
            }
        }
    }

    public final void h(c.e.b.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            f(bVar, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT, "没有端能力");
        }
    }

    public final void i(c.e.b.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            f(bVar, 20002, "参数格式错误");
        }
    }

    @Override // com.dxm.credit.marketdialog.ui.MarketBaseDialog
    public boolean initViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (getWindow() == null) {
                return false;
            }
            getWindow().setLayout(-1, -1);
            this.f55042j.setBackgroundColor(Color.parseColor("#00000000"));
            this.f55042j.setLayerType(1, null);
            this.f55042j.setScrollContainer(false);
            this.f55042j.setVerticalScrollBarEnabled(false);
            this.f55042j.setHorizontalScrollBarEnabled(false);
            WebSettings settings = this.f55042j.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(false);
            settings.setSupportZoom(false);
            settings.setDisplayZoomControls(false);
            String userAgentString = settings.getUserAgentString();
            settings.setUserAgentString(userAgentString + " " + BussinessUtils.getUA(getContext()));
            this.f55042j.setWebViewClient(new a(this));
            this.f55042j.addJavascriptInterface(this, LightappJsClient.LIGHTAPP_JS_NAME);
            MarketDialogResponse.Dialog dialog = this.mData;
            if (dialog != null) {
                this.f55042j.loadUrl(dialog.group_link_addr);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void invokeBdWalletNative(String str, String str2, String str3) {
        Handler handler;
        Runnable bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            c.e.b.a.b.b bVar2 = new c.e.b.a.b.b(this.f55042j, str2, str3);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("method_name");
                String optString2 = jSONObject.optString("params");
                JSONObject jSONObject2 = TextUtils.isEmpty(optString2) ? null : new JSONObject(optString2);
                LogUtil.d("h5dialog", optString + "," + jSONObject2);
                char c2 = 65535;
                int i2 = 0;
                switch (optString.hashCode()) {
                    case -506201172:
                        if (optString.equals("callWebDialogDismiss")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 394381848:
                        if (optString.equals("callWebDialogLink")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 394589467:
                        if (optString.equals("callWebDialogShow")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 394600562:
                        if (optString.equals("callWebDialogStat")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    handler = this.f55043k;
                    bVar = new b(this, bVar2);
                } else if (c2 != 1) {
                    if (c2 == 2) {
                        if (CheckUtils.isFastDoubleClick()) {
                            return;
                        }
                        if (jSONObject2 != null) {
                            String optString3 = jSONObject2.optString("link_addr");
                            String optString4 = jSONObject2.optString("type");
                            if (this.mData != null) {
                                SDKJumpManager.getInstance().doSDKJump(getContext(), this.mData.group_name, optString4, optString3, false, new d(this));
                                e(bVar2);
                            }
                        } else {
                            i(bVar2);
                        }
                        dismissOnly();
                        return;
                    } else if (c2 != 3) {
                        h(bVar2);
                        return;
                    } else {
                        if (jSONObject2 != null) {
                            String optString5 = jSONObject2.optString("event_key");
                            JSONArray optJSONArray = jSONObject2.optJSONArray(SavedStateHandle.VALUES);
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(optString5)) {
                                arrayList.add(optString5);
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    while (i2 < optJSONArray.length()) {
                                        arrayList.add(String.valueOf(optJSONArray.get(i2)));
                                        i2++;
                                    }
                                }
                                DXMSdkSAUtils.onEventWithValues("popwindow_t8", arrayList);
                                i2 = 1;
                            }
                            if (i2 != 0) {
                                e(bVar2);
                                return;
                            }
                        }
                        i(bVar2);
                        return;
                    }
                } else {
                    handler = this.f55043k;
                    bVar = new c(this, bVar2);
                }
                handler.post(bVar);
            } catch (Exception unused) {
                i(bVar2);
                setCancelable(true);
            }
        }
    }

    @Override // com.dxm.credit.marketdialog.ui.MarketBaseDialog
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.mData == null || !super.isValid() || TextUtils.isEmpty(this.mData.group_link_addr)) ? false : true : invokeV.booleanValue;
    }

    @Override // android.app.Dialog
    public void setOnShowListener(@Nullable DialogInterface.OnShowListener onShowListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onShowListener) == null) {
            super.setOnShowListener(onShowListener);
        }
    }

    @Override // com.dxm.credit.marketdialog.ui.MarketBaseDialog, android.app.Dialog, c.e.b.a.c.b
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!isValid()) {
                dismiss();
            } else if (isShowing()) {
            } else {
                initViews();
            }
        }
    }
}
