package io.flutter.plugins.webviewflutter;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes7.dex */
public class FlutterCookieManager implements MethodChannel.MethodCallHandler {
    public final MethodChannel methodChannel;

    public FlutterCookieManager(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/cookie_manager");
        this.methodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void clearCookies(final MethodChannel.Result result) {
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

    public void dispose() {
        this.methodChannel.setMethodCallHandler(null);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        if (((str.hashCode() == 928375682 && str.equals("clearCookies")) ? (char) 0 : (char) 65535) != 0) {
            result.notImplemented();
        } else {
            clearCookies(result);
        }
    }
}
