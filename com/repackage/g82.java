package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class g82 implements f82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile g82 g;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, h82> a;
    public HashMap<String, ArrayList<ValueCallback<String>>> b;
    public String c;
    public HttpManager d;
    public final Object e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755724240, "Lcom/repackage/g82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755724240, "Lcom/repackage/g82;");
                return;
            }
        }
        f = rg1.a;
    }

    public g82() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = new HashMap<>();
        this.e = new Object();
        this.d = pj2.l().a();
        this.c = pj2.f().a();
    }

    public static g82 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g == null) {
                synchronized (g82.class) {
                    if (g == null) {
                        g = new g82();
                    }
                }
            }
            return g;
        }
        return (g82) invokeV.objValue;
    }

    @Override // com.repackage.f82
    public void a(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this.e) {
                if (f(str) && (arrayList = this.b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.get(i).onReceiveValue(str2);
                        if (f) {
                            Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                        }
                    }
                    this.a.remove(str);
                }
            }
        }
    }

    public final void b(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, valueCallback) == null) {
            if (this.b.containsKey(str)) {
                this.b.get(str).add(valueCallback);
                return;
            }
            ArrayList<ValueCallback<String>> arrayList = new ArrayList<>();
            arrayList.add(valueCallback);
            this.b.put(str, arrayList);
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (f) {
                Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
            }
            h82 h82Var = new h82(this.d, this.c, str, this);
            this.a.put(str, h82Var);
            h82Var.e();
        }
    }

    public final String d(String str) throws MalformedURLException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return this.c + pj2.f().c(str);
        }
        return (String) invokeL.objValue;
    }

    public final boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.a.containsKey(str) : invokeL.booleanValue;
    }

    @Override // com.repackage.f82
    public void fail(int i, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            synchronized (this.e) {
                if (f(str) && (arrayList = this.b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.get(i2).onReceiveValue("");
                    }
                    this.a.remove(str);
                }
            }
        }
    }

    public void g(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, valueCallback) == null) {
            if (TextUtils.isEmpty(str)) {
                valueCallback.onReceiveValue(null);
                return;
            }
            try {
                String d = d(str);
                if (TextUtils.isEmpty(d)) {
                    return;
                }
                File file = new File(d(str));
                if (file.exists() && !file.isDirectory()) {
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(d);
                        return;
                    }
                    return;
                }
                synchronized (this.e) {
                    if (!f(str)) {
                        c(str);
                    }
                    b(str, valueCallback);
                }
            } catch (Exception e) {
                if (f) {
                    e.printStackTrace();
                }
            }
        }
    }
}
