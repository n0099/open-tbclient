package io.flutter.plugins.webviewflutter;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class FlutterWebView implements MethodChannel.MethodCallHandler, PlatformView {
    private static final String JS_CHANNEL_NAMES_FIELD = "javascriptChannelNames";
    private final FlutterWebViewClient flutterWebViewClient;
    private final MethodChannel methodChannel;
    private final Handler platformThreadHandler;
    private final InputAwareWebView webView;

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(17)
    public FlutterWebView(Context context, BinaryMessenger binaryMessenger, int i, Map<String, Object> map, View view) {
        DisplayListenerProxy displayListenerProxy = new DisplayListenerProxy();
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        displayListenerProxy.onPreWebViewInitialization(displayManager);
        this.webView = new InputAwareWebView(context, view);
        displayListenerProxy.onPostWebViewInitialization(displayManager);
        this.platformThreadHandler = new Handler(context.getMainLooper());
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/webview_" + i);
        this.methodChannel.setMethodCallHandler(this);
        this.flutterWebViewClient = new FlutterWebViewClient(this.methodChannel);
        applySettings((Map) map.get("settings"));
        if (map.containsKey(JS_CHANNEL_NAMES_FIELD)) {
            registerJavaScriptChannelNames((List) map.get(JS_CHANNEL_NAMES_FIELD));
        }
        updateAutoMediaPlaybackPolicy(((Integer) map.get("autoMediaPlaybackPolicy")).intValue());
        if (map.containsKey("userAgent")) {
            updateUserAgent((String) map.get("userAgent"));
        }
        if (map.containsKey("initialUrl")) {
            this.webView.loadUrl((String) map.get("initialUrl"));
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public View getView() {
        return this.webView;
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionUnlocked() {
        this.webView.unlockInputConnection();
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionLocked() {
        this.webView.lockInputConnection();
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewAttached(View view) {
        this.webView.setContainerView(view);
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewDetached() {
        this.webView.setContainerView(null);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        char c = 65535;
        switch (str.hashCode()) {
            case -1990164468:
                if (str.equals("updateSettings")) {
                    c = 1;
                    break;
                }
                break;
            case -1707388194:
                if (str.equals("addJavascriptChannels")) {
                    c = '\t';
                    break;
                }
                break;
            case -1331417355:
                if (str.equals("getScrollX")) {
                    c = 15;
                    break;
                }
                break;
            case -1331417354:
                if (str.equals("getScrollY")) {
                    c = 16;
                    break;
                }
                break;
            case -1241591313:
                if (str.equals("goBack")) {
                    c = 4;
                    break;
                }
                break;
            case -1088982730:
                if (str.equals("currentUrl")) {
                    c = 7;
                    break;
                }
                break;
            case -1067273523:
                if (str.equals("canGoForward")) {
                    c = 3;
                    break;
                }
                break;
            case -934641255:
                if (str.equals("reload")) {
                    c = 6;
                    break;
                }
                break;
            case -759238347:
                if (str.equals("clearCache")) {
                    c = 11;
                    break;
                }
                break;
            case -402165756:
                if (str.equals("scrollBy")) {
                    c = 14;
                    break;
                }
                break;
            case -402165208:
                if (str.equals("scrollTo")) {
                    c = '\r';
                    break;
                }
                break;
            case -318289731:
                if (str.equals("goForward")) {
                    c = 5;
                    break;
                }
                break;
            case -317054497:
                if (str.equals("canGoBack")) {
                    c = 2;
                    break;
                }
                break;
            case 336631465:
                if (str.equals("loadUrl")) {
                    c = 0;
                    break;
                }
                break;
            case 651673601:
                if (str.equals("removeJavascriptChannels")) {
                    c = '\n';
                    break;
                }
                break;
            case 1937913574:
                if (str.equals("evaluateJavascript")) {
                    c = '\b';
                    break;
                }
                break;
            case 1966196898:
                if (str.equals("getTitle")) {
                    c = '\f';
                    break;
                }
                break;
        }
        switch (c) {
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

    private void loadUrl(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.arguments;
        String str = (String) map.get("url");
        Map<String, String> map2 = (Map) map.get("headers");
        if (map2 == null) {
            map2 = Collections.emptyMap();
        }
        this.webView.loadUrl(str, map2);
        result.success(null);
    }

    private void canGoBack(MethodChannel.Result result) {
        result.success(Boolean.valueOf(this.webView.canGoBack()));
    }

    private void canGoForward(MethodChannel.Result result) {
        result.success(Boolean.valueOf(this.webView.canGoForward()));
    }

    private void goBack(MethodChannel.Result result) {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        }
        result.success(null);
    }

    private void goForward(MethodChannel.Result result) {
        if (this.webView.canGoForward()) {
            this.webView.goForward();
        }
        result.success(null);
    }

    private void reload(MethodChannel.Result result) {
        this.webView.reload();
        result.success(null);
    }

    private void currentUrl(MethodChannel.Result result) {
        result.success(this.webView.getUrl());
    }

    private void updateSettings(MethodCall methodCall, MethodChannel.Result result) {
        applySettings((Map) methodCall.arguments);
        result.success(null);
    }

    @TargetApi(19)
    private void evaluateJavaScript(MethodCall methodCall, final MethodChannel.Result result) {
        String str = (String) methodCall.arguments;
        if (str == null) {
            throw new UnsupportedOperationException("JavaScript string cannot be null");
        }
        this.webView.evaluateJavascript(str, new ValueCallback<String>() { // from class: io.flutter.plugins.webviewflutter.FlutterWebView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str2) {
                result.success(str2);
            }
        });
    }

    private void addJavaScriptChannels(MethodCall methodCall, MethodChannel.Result result) {
        registerJavaScriptChannelNames((List) methodCall.arguments);
        result.success(null);
    }

    private void removeJavaScriptChannels(MethodCall methodCall, MethodChannel.Result result) {
        for (String str : (List) methodCall.arguments) {
            this.webView.removeJavascriptInterface(str);
        }
        result.success(null);
    }

    private void clearCache(MethodChannel.Result result) {
        this.webView.clearCache(true);
        WebStorage.getInstance().deleteAllData();
        result.success(null);
    }

    private void getTitle(MethodChannel.Result result) {
        result.success(this.webView.getTitle());
    }

    private void scrollTo(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.arguments;
        this.webView.scrollTo(((Integer) map.get("x")).intValue(), ((Integer) map.get("y")).intValue());
        result.success(null);
    }

    private void scrollBy(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.arguments;
        this.webView.scrollBy(((Integer) map.get("x")).intValue(), ((Integer) map.get("y")).intValue());
        result.success(null);
    }

    private void getScrollX(MethodChannel.Result result) {
        result.success(Integer.valueOf(this.webView.getScrollX()));
    }

    private void getScrollY(MethodChannel.Result result) {
        result.success(Integer.valueOf(this.webView.getScrollY()));
    }

    private void applySettings(Map<String, Object> map) {
        for (String str : map.keySet()) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1151668596:
                    if (str.equals("jsMode")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1069908877:
                    if (str.equals("debuggingEnabled")) {
                        c = 2;
                        break;
                    }
                    break;
                case 311430650:
                    if (str.equals("userAgent")) {
                        c = 4;
                        break;
                    }
                    break;
                case 858297331:
                    if (str.equals("hasNavigationDelegate")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1670862916:
                    if (str.equals("gestureNavigationEnabled")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    updateJsMode(((Integer) map.get(str)).intValue());
                    break;
                case 1:
                    this.webView.setWebViewClient(this.flutterWebViewClient.createWebViewClient(((Boolean) map.get(str)).booleanValue()));
                    break;
                case 2:
                    boolean booleanValue = ((Boolean) map.get(str)).booleanValue();
                    InputAwareWebView inputAwareWebView = this.webView;
                    InputAwareWebView.setWebContentsDebuggingEnabled(booleanValue);
                    break;
                case 3:
                    break;
                case 4:
                    updateUserAgent((String) map.get(str));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown WebView setting: " + str);
            }
        }
    }

    private void updateJsMode(int i) {
        switch (i) {
            case 0:
                this.webView.getSettings().setJavaScriptEnabled(false);
                return;
            case 1:
                this.webView.getSettings().setJavaScriptEnabled(true);
                return;
            default:
                throw new IllegalArgumentException("Trying to set unknown JavaScript mode: " + i);
        }
    }

    private void updateAutoMediaPlaybackPolicy(int i) {
        this.webView.getSettings().setMediaPlaybackRequiresUserGesture(i != 1);
    }

    private void registerJavaScriptChannelNames(List<String> list) {
        for (String str : list) {
            this.webView.addJavascriptInterface(new JavaScriptChannel(this.methodChannel, str, this.platformThreadHandler), str);
        }
    }

    private void updateUserAgent(String str) {
        this.webView.getSettings().setUserAgentString(str);
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void dispose() {
        this.methodChannel.setMethodCallHandler(null);
        this.webView.dispose();
        this.webView.destroy();
    }
}
