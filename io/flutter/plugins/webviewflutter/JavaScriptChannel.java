package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class JavaScriptChannel {
    public final String javaScriptChannelName;
    public final MethodChannel methodChannel;
    public final Handler platformThreadHandler;

    public JavaScriptChannel(MethodChannel methodChannel, String str, Handler handler) {
        this.methodChannel = methodChannel;
        this.javaScriptChannelName = str;
        this.platformThreadHandler = handler;
    }

    @JavascriptInterface
    public void postMessage(final String str) {
        Runnable runnable = new Runnable() { // from class: io.flutter.plugins.webviewflutter.JavaScriptChannel.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("channel", JavaScriptChannel.this.javaScriptChannelName);
                hashMap.put("message", str);
                JavaScriptChannel.this.methodChannel.invokeMethod("javascriptChannelMessage", hashMap);
            }
        };
        if (this.platformThreadHandler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.platformThreadHandler.post(runnable);
        }
    }
}
