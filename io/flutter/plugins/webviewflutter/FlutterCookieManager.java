package io.flutter.plugins.webviewflutter;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes17.dex */
class FlutterCookieManager implements MethodChannel.MethodCallHandler {
    private final MethodChannel methodChannel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlutterCookieManager(BinaryMessenger binaryMessenger) {
        this.methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/cookie_manager");
        this.methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        char c = 65535;
        switch (str.hashCode()) {
            case 928375682:
                if (str.equals("clearCookies")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                clearCookies(result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispose() {
        this.methodChannel.setMethodCallHandler(null);
    }

    private static void clearCookies(final MethodChannel.Result result) {
        CookieManager cookieManager = CookieManager.getInstance();
        final boolean hasCookies = cookieManager.hasCookies();
        if (Build.VERSION.SDK_INT >= 21) {
            cookieManager.removeAllCookies(new ValueCallback<Boolean>() { // from class: io.flutter.plugins.webviewflutter.FlutterCookieManager.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Boolean bool) {
                    MethodChannel.Result.this.success(Boolean.valueOf(hasCookies));
                }
            });
            return;
        }
        cookieManager.removeAllCookie();
        result.success(Boolean.valueOf(hasCookies));
    }
}
