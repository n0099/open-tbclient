package io.flutter.plugins.webviewflutter;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugins.webviewflutter.InputAwareWebView;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes3.dex */
public class FlutterWebView implements PlatformView, MethodChannel.MethodCallHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JS_CHANNEL_NAMES_FIELD = "javascriptChannelNames";
    public transient /* synthetic */ FieldHolder $fh;
    public final FlutterWebViewClient flutterWebViewClient;
    public final MethodChannel methodChannel;
    public final Handler platformThreadHandler;
    public final InputAwareWebView webView;

    @TargetApi(17)
    public FlutterWebView(Context context, BinaryMessenger binaryMessenger, int i2, Map<String, Object> map, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, binaryMessenger, Integer.valueOf(i2), map, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        DisplayListenerProxy displayListenerProxy = new DisplayListenerProxy();
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        displayListenerProxy.onPreWebViewInitialization(displayManager);
        InputAwareWebView inputAwareWebView = new InputAwareWebView(context, view);
        this.webView = inputAwareWebView;
        inputAwareWebView.setOnScrollChangedCallback(new InputAwareWebView.OnScrollChangedCallback(this) { // from class: io.flutter.plugins.webviewflutter.FlutterWebView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterWebView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.plugins.webviewflutter.InputAwareWebView.OnScrollChangedCallback
            public void onScroll(int i5, int i6, int i7, int i8) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIII(1048576, this, i5, i6, i7, i8) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("offsetY", String.valueOf(this.this$0.webView.getScrollY()));
                    this.this$0.methodChannel.invokeMethod("onPageOffsetY", hashMap);
                }
            }
        });
        displayListenerProxy.onPostWebViewInitialization(displayManager);
        this.platformThreadHandler = new Handler(context.getMainLooper());
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/webview_" + i2);
        this.methodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.flutterWebViewClient = new FlutterWebViewClient(this.methodChannel);
        applySettings((Map) map.get("settings"));
        if (map.containsKey(JS_CHANNEL_NAMES_FIELD)) {
            registerJavaScriptChannelNames((List) map.get(JS_CHANNEL_NAMES_FIELD));
        }
        updateAutoMediaPlaybackPolicy(((Integer) map.get("autoMediaPlaybackPolicy")).intValue());
        if (map.containsKey(TTDownloadField.TT_USERAGENT)) {
            updateUserAgent((String) map.get(TTDownloadField.TT_USERAGENT));
        }
        if (map.containsKey("initialUrl")) {
            this.webView.loadUrl((String) map.get("initialUrl"));
        }
    }

    private void addJavaScriptChannels(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, methodCall, result) == null) {
            registerJavaScriptChannelNames((List) methodCall.arguments);
            result.success(null);
        }
    }

    private void applySettings(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, map) == null) {
            for (String str : map.keySet()) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1151668596:
                        if (str.equals("jsMode")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1069908877:
                        if (str.equals("debuggingEnabled")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 311430650:
                        if (str.equals(TTDownloadField.TT_USERAGENT)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 858297331:
                        if (str.equals("hasNavigationDelegate")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1670862916:
                        if (str.equals("gestureNavigationEnabled")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    updateJsMode(((Integer) map.get(str)).intValue());
                } else if (c2 == 1) {
                    this.webView.setWebViewClient(this.flutterWebViewClient.createWebViewClient(((Boolean) map.get(str)).booleanValue()));
                } else if (c2 == 2) {
                    WebView.setWebContentsDebuggingEnabled(((Boolean) map.get(str)).booleanValue());
                } else if (c2 == 3) {
                    continue;
                } else if (c2 == 4) {
                    updateUserAgent((String) map.get(str));
                } else {
                    throw new IllegalArgumentException("Unknown WebView setting: " + str);
                }
            }
        }
    }

    private void canGoBack(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, result) == null) {
            result.success(Boolean.valueOf(this.webView.canGoBack()));
        }
    }

    private void canGoForward(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, result) == null) {
            result.success(Boolean.valueOf(this.webView.canGoForward()));
        }
    }

    private void clearCache(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, result) == null) {
            this.webView.clearCache(true);
            WebStorage.getInstance().deleteAllData();
            result.success(null);
        }
    }

    private void currentUrl(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, result) == null) {
            result.success(this.webView.getUrl());
        }
    }

    @TargetApi(19)
    private void evaluateJavaScript(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, methodCall, result) == null) {
            String str = (String) methodCall.arguments;
            if (str != null) {
                this.webView.evaluateJavascript(str, new ValueCallback<String>(this, result) { // from class: io.flutter.plugins.webviewflutter.FlutterWebView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FlutterWebView this$0;
                    public final /* synthetic */ MethodChannel.Result val$result;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, result};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$result = result;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                            this.val$result.success(str2);
                        }
                    }
                });
                return;
            }
            throw new UnsupportedOperationException("JavaScript string cannot be null");
        }
    }

    private void getScrollX(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, result) == null) {
            result.success(Integer.valueOf(this.webView.getScrollX()));
        }
    }

    private void getScrollY(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, result) == null) {
            result.success(Integer.valueOf(this.webView.getScrollY()));
        }
    }

    private void getTitle(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, result) == null) {
            result.success(this.webView.getTitle());
        }
    }

    private void goBack(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, result) == null) {
            if (this.webView.canGoBack()) {
                this.webView.goBack();
            }
            result.success(null);
        }
    }

    private void goForward(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, result) == null) {
            if (this.webView.canGoForward()) {
                this.webView.goForward();
            }
            result.success(null);
        }
    }

    private void loadUrl(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, this, methodCall, result) == null) {
            Map map = (Map) methodCall.arguments;
            String str = (String) map.get("url");
            Map<String, String> map2 = (Map) map.get("headers");
            if (map2 == null) {
                map2 = Collections.emptyMap();
            }
            this.webView.loadUrl(str, map2);
            result.success(null);
        }
    }

    private void registerJavaScriptChannelNames(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, list) == null) {
            for (String str : list) {
                this.webView.addJavascriptInterface(new JavaScriptChannel(this.methodChannel, str, this.platformThreadHandler), str);
            }
        }
    }

    private void reload(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, result) == null) {
            this.webView.reload();
            result.success(null);
        }
    }

    private void removeJavaScriptChannels(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, methodCall, result) == null) {
            for (String str : (List) methodCall.arguments) {
                this.webView.removeJavascriptInterface(str);
            }
            result.success(null);
        }
    }

    private void scrollBy(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, this, methodCall, result) == null) {
            Map map = (Map) methodCall.arguments;
            this.webView.scrollBy(((Integer) map.get("x")).intValue(), ((Integer) map.get("y")).intValue());
            result.success(null);
        }
    }

    private void scrollTo(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, methodCall, result) == null) {
            Map map = (Map) methodCall.arguments;
            this.webView.scrollTo(((Integer) map.get("x")).intValue(), ((Integer) map.get("y")).intValue());
            result.success(null);
        }
    }

    private void updateAutoMediaPlaybackPolicy(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, this, i2) == null) {
            this.webView.getSettings().setMediaPlaybackRequiresUserGesture(i2 != 1);
        }
    }

    private void updateJsMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, this, i2) == null) {
            if (i2 == 0) {
                this.webView.getSettings().setJavaScriptEnabled(false);
            } else if (i2 == 1) {
                this.webView.getSettings().setJavaScriptEnabled(true);
            } else {
                throw new IllegalArgumentException("Trying to set unknown JavaScript mode: " + i2);
            }
        }
    }

    private void updateSettings(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, methodCall, result) == null) {
            applySettings((Map) methodCall.arguments);
            result.success(null);
        }
    }

    private void updateUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, str) == null) {
            this.webView.getSettings().setUserAgentString(str);
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.methodChannel.setMethodCallHandler(null);
            this.webView.dispose();
            this.webView.destroy();
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.webView : (View) invokeV.objValue;
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewAttached(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.webView.setContainerView(view);
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewDetached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.webView.setContainerView(null);
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionLocked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.webView.lockInputConnection();
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionUnlocked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.webView.unlockInputConnection();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, methodCall, result) == null) {
            String str = methodCall.method;
            switch (str.hashCode()) {
                case -1990164468:
                    if (str.equals("updateSettings")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1707388194:
                    if (str.equals("addJavascriptChannels")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1331417355:
                    if (str.equals("getScrollX")) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1331417354:
                    if (str.equals("getScrollY")) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1241591313:
                    if (str.equals("goBack")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1088982730:
                    if (str.equals("currentUrl")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1067273523:
                    if (str.equals("canGoForward")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -934641255:
                    if (str.equals("reload")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -759238347:
                    if (str.equals("clearCache")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -402165756:
                    if (str.equals("scrollBy")) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -402165208:
                    if (str.equals("scrollTo")) {
                        c2 = CharUtils.CR;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -318289731:
                    if (str.equals("goForward")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -317054497:
                    if (str.equals("canGoBack")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 336631465:
                    if (str.equals("loadUrl")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 651673601:
                    if (str.equals("removeJavascriptChannels")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1937913574:
                    if (str.equals("evaluateJavascript")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1966196898:
                    if (str.equals("getTitle")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    loadUrl(methodCall, result);
                    return;
                case 1:
                    updateSettings(methodCall, result);
                    return;
                case 2:
                    canGoBack(result);
                    return;
                case 3:
                    canGoForward(result);
                    return;
                case 4:
                    goBack(result);
                    return;
                case 5:
                    goForward(result);
                    return;
                case 6:
                    reload(result);
                    return;
                case 7:
                    currentUrl(result);
                    return;
                case '\b':
                    evaluateJavaScript(methodCall, result);
                    return;
                case '\t':
                    addJavaScriptChannels(methodCall, result);
                    return;
                case '\n':
                    removeJavaScriptChannels(methodCall, result);
                    return;
                case 11:
                    clearCache(result);
                    return;
                case '\f':
                    getTitle(result);
                    return;
                case '\r':
                    scrollTo(methodCall, result);
                    return;
                case 14:
                    scrollBy(methodCall, result);
                    return;
                case 15:
                    getScrollX(result);
                    return;
                case 16:
                    getScrollY(result);
                    return;
                default:
                    result.notImplemented();
                    return;
            }
        }
    }
}
