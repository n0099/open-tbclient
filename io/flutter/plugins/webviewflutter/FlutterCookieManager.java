package io.flutter.plugins.webviewflutter;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes9.dex */
public class FlutterCookieManager implements MethodChannel.MethodCallHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MethodChannel methodChannel;

    public FlutterCookieManager(BinaryMessenger binaryMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binaryMessenger};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/cookie_manager");
        this.methodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void clearCookies(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, result) == null) {
            CookieManager cookieManager = CookieManager.getInstance();
            boolean hasCookies = cookieManager.hasCookies();
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.removeAllCookies(new ValueCallback<Boolean>(result, hasCookies) { // from class: io.flutter.plugins.webviewflutter.FlutterCookieManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean val$hasCookies;
                    public final /* synthetic */ MethodChannel.Result val$result;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {result, Boolean.valueOf(hasCookies)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$result = result;
                        this.val$hasCookies = hasCookies;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            this.val$result.success(Boolean.valueOf(this.val$hasCookies));
                        }
                    }
                });
                return;
            }
            cookieManager.removeAllCookie();
            result.success(Boolean.valueOf(hasCookies));
        }
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.methodChannel.setMethodCallHandler(null);
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, methodCall, result) == null) {
            String str = methodCall.method;
            if (((str.hashCode() == 928375682 && str.equals("clearCookies")) ? (char) 0 : (char) 65535) != 0) {
                result.notImplemented();
            } else {
                clearCookies(result);
            }
        }
    }
}
