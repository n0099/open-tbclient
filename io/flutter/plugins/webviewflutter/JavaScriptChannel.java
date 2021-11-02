package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class JavaScriptChannel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String javaScriptChannelName;
    public final MethodChannel methodChannel;
    public final Handler platformThreadHandler;

    public JavaScriptChannel(MethodChannel methodChannel, String str, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {methodChannel, str, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.methodChannel = methodChannel;
        this.javaScriptChannelName = str;
        this.platformThreadHandler = handler;
    }

    @JavascriptInterface
    public void postMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Runnable runnable = new Runnable(this, str) { // from class: io.flutter.plugins.webviewflutter.JavaScriptChannel.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JavaScriptChannel this$0;
                public final /* synthetic */ String val$message;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
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
                    this.val$message = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("channel", this.this$0.javaScriptChannelName);
                        hashMap.put("message", this.val$message);
                        this.this$0.methodChannel.invokeMethod("javascriptChannelMessage", hashMap);
                    }
                }
            };
            if (this.platformThreadHandler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                this.platformThreadHandler.post(runnable);
            }
        }
    }
}
