package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.kwad.sdk.utils.as;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends KSApiWebView {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f36467b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f36468a;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, Object> f36469c;

    /* renamed from: d  reason: collision with root package name */
    public String f36470d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1113650127, "Lcom/kwad/sdk/core/page/widget/webview/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1113650127, "Lcom/kwad/sdk/core/page/widget/webview/b;");
                return;
            }
        }
        f36467b = new String[]{"getClass", "hashCode", "notify", "notifyAll", "equals", "toString", "wait"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36469c = new HashMap<>();
        this.f36470d = null;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f36469c = new HashMap<>();
        this.f36470d = null;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f36469c = new HashMap<>();
        this.f36470d = null;
        d();
    }

    private Class<?> a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, obj)) == null) {
            Class<?> cls = obj.getClass();
            return cls == Integer.class ? Integer.TYPE : cls == Boolean.class ? Boolean.TYPE : String.class;
        }
        return (Class) invokeL.objValue;
    }

    private void a(ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, valueCallback) == null) {
            try {
                if (TextUtils.isEmpty(this.f36470d)) {
                    return;
                }
                as.a(this, this.f36470d, valueCallback);
            } catch (Exception unused) {
            }
        }
    }

    private void a(String str, Object obj, StringBuilder sb) {
        Method[] methods;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, str, obj, sb) == null) || TextUtils.isEmpty(str) || obj == null || sb == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        sb.append("if(typeof(window.");
        sb.append(str);
        sb.append(")!='undefined'){");
        sb.append("}else {");
        sb.append("    window.");
        sb.append(str);
        sb.append("={");
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            if (!a(name)) {
                sb.append("        ");
                sb.append(name);
                sb.append(":function(");
                int length = method.getParameterTypes().length;
                if (length > 0) {
                    int i2 = length - 1;
                    int i3 = 0;
                    while (true) {
                        sb.append("arg");
                        if (i3 >= i2) {
                            break;
                        }
                        sb.append(i3);
                        sb.append(",");
                        i3++;
                    }
                    sb.append(i2);
                }
                sb.append(") {");
                if (method.getReturnType() != Void.TYPE) {
                    sb.append("            return ");
                    str2 = "prompt('";
                } else {
                    str2 = "            prompt('";
                }
                sb.append(str2);
                sb.append("MyApp:");
                sb.append("'+");
                sb.append("JSON.stringify({");
                sb.append("obj");
                sb.append(":'");
                sb.append(str);
                sb.append("',");
                sb.append(WebChromeClient.KEY_FUNCTION_NAME);
                sb.append(":'");
                sb.append(name);
                sb.append("',");
                sb.append("args");
                sb.append(":[");
                if (length > 0) {
                    int i4 = length - 1;
                    int i5 = 0;
                    while (true) {
                        sb.append("arg");
                        if (i5 >= i4) {
                            break;
                        }
                        sb.append(i5);
                        sb.append(",");
                        i5++;
                    }
                    sb.append(i4);
                }
                sb.append("]})");
                sb.append(");");
                sb.append("        }, ");
            }
        }
        sb.append("    };");
        sb.append("}");
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod(str, String.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this, str2);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049 A[Catch: Exception -> 0x0052, NoSuchMethodException | Exception -> 0x0054, TryCatch #2 {NoSuchMethodException | Exception -> 0x0054, blocks: (B:17:0x002a, B:19:0x0038, B:27:0x004d, B:26:0x0049), top: B:39:0x002a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(JsPromptResult jsPromptResult, String str, String str2, Object[] objArr) {
        InterceptResult invokeLLLL;
        Object invoke;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, this, jsPromptResult, str, str2, objArr)) == null) {
            Object obj = this.f36469c.get(str);
            boolean z2 = false;
            if (obj == null) {
                jsPromptResult.cancel();
                return false;
            }
            Class<?>[] clsArr = null;
            int length = objArr != null ? objArr.length : 0;
            if (length > 0) {
                clsArr = new Class[length];
                for (int i2 = 0; i2 < length; i2++) {
                    clsArr[i2] = a(objArr[i2]);
                }
            }
            try {
                invoke = obj.getClass().getMethod(str2, clsArr).invoke(obj, objArr);
            } catch (NoSuchMethodException | Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            if (invoke != null && invoke.getClass() != Void.TYPE) {
                z = false;
                jsPromptResult.confirm(!z ? "" : invoke.toString());
                z2 = true;
                jsPromptResult.cancel();
                return z2;
            }
            z = true;
            jsPromptResult.confirm(!z ? "" : invoke.toString());
            z2 = true;
            jsPromptResult.cancel();
            return z2;
        }
        return invokeLLLL.booleanValue;
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            for (String str2 : f36467b) {
                if (str2.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            e();
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            try {
                if (!b() || c()) {
                    return false;
                }
                a("removeJavascriptInterface", "searchBoxJavaBridge_");
                a("removeJavascriptInterface", "accessibility");
                a("removeJavascriptInterface", "accessibilityTraversal");
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? ((AccessibilityManager) getContext().getApplicationContext().getSystemService("accessibility")).isEnabled() : invokeV.booleanValue;
    }

    private String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (this.f36469c.size() == 0) {
                this.f36470d = null;
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:(function JsAddJavascriptInterface_(){");
            for (Map.Entry<String, Object> entry : this.f36469c.entrySet()) {
                try {
                    a(entry.getKey(), entry.getValue(), sb);
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            sb.append("})()");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private void setAccessibilityEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, this, z) == null) {
            try {
                Method declaredMethod = AccessibilityManager.class.getDeclaredMethod("setAccessibilityState", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke((AccessibilityManager) getContext().getApplicationContext().getSystemService("accessibility"), Boolean.valueOf(z));
                declaredMethod.setAccessible(false);
            } catch (Exception unused) {
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && Build.VERSION.SDK_INT == 17 && this.f36468a == null && f()) {
            this.f36468a = Boolean.TRUE;
            setAccessibilityEnabled(false);
        }
    }

    public void a(WebView webView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView) == null) && (webView instanceof b)) {
            a(webView, (ValueCallback<String>) null);
        }
    }

    public void a(WebView webView, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, valueCallback) == null) {
            if (!TextUtils.isEmpty(this.f36470d)) {
                a(valueCallback);
                return;
            }
            this.f36470d = g();
            a(valueCallback);
        }
    }

    public void a(Object obj, String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, obj, str, valueCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f36469c.put(str, obj);
        a(this, valueCallback);
    }

    public boolean a(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (str2.startsWith("MyApp:")) {
                try {
                    JSONObject jSONObject = new JSONObject(str2.substring(6));
                    String string = jSONObject.getString("obj");
                    String string2 = jSONObject.getString(WebChromeClient.KEY_FUNCTION_NAME);
                    JSONArray jSONArray = jSONObject.getJSONArray("args");
                    Object[] objArr = null;
                    if (jSONArray != null && (length = jSONArray.length()) > 0) {
                        objArr = new Object[length];
                        for (int i2 = 0; i2 < length; i2++) {
                            objArr[i2] = jSONArray.get(i2);
                        }
                    }
                    if (a(jsPromptResult, string, string2, objArr)) {
                        return true;
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                jsPromptResult.cancel();
                return false;
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, obj, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f36469c.put(str, obj);
        a(this, (ValueCallback<String>) null);
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Build.VERSION.SDK_INT >= 11 : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Build.VERSION.SDK_INT >= 17 : invokeV.booleanValue;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            super.loadUrl(str);
            com.kwad.sdk.core.d.a.d("loadUrl", DataEntryUrlBox.TYPE + str + Integer.toHexString(hashCode()));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void setOverScrollMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            try {
                super.setOverScrollMode(i2);
            } catch (Exception e2) {
                String stackTraceString = Log.getStackTraceString(e2);
                if (!stackTraceString.contains("android.content.pm.PackageManager$NameNotFoundException") && !stackTraceString.contains("java.lang.RuntimeException: Cannot load WebView") && !stackTraceString.contains("android.webkit.WebViewFactory$MissingWebViewPackageException: Failed to load WebView provider: No WebView installed")) {
                    throw e2;
                }
                try {
                    destroy();
                } catch (Exception unused) {
                }
            }
        }
    }
}
