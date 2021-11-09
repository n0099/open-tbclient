package com.win.opensdk.bridge.core;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class JsCallJava {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f70494a;

    /* renamed from: b  reason: collision with root package name */
    public String f70495b;

    /* renamed from: c  reason: collision with root package name */
    public String f70496c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f70497d;

    public JsCallJava() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static JsCallJava newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new JsCallJava() : (JsCallJava) invokeV.objValue;
    }

    public void call(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) || webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("rainbow")) {
            Uri parse = Uri.parse(str);
            this.f70494a = parse.getHost();
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                this.f70495b = "";
            } else {
                this.f70495b = path.replace("/", "");
            }
            this.f70496c = String.valueOf(parse.getPort());
            try {
                this.f70497d = new JSONObject(parse.getQuery());
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f70497d = new JSONObject();
            }
        }
        Method findMethod = NativeMethodInjectHelper.getInstance().findMethod(this.f70494a, this.f70495b);
        JsCallback newInstance = JsCallback.newInstance(webView, this.f70496c);
        if (findMethod == null) {
            JsCallback.invokeJsCallback(newInstance, false, null, "Method (" + this.f70495b + ") in this class (" + this.f70494a + ") not found!");
            return;
        }
        try {
            findMethod.invoke(null, webView, this.f70497d, newInstance);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }
}
