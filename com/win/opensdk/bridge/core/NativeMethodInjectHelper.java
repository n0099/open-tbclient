package com.win.opensdk.bridge.core;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NativeMethodInjectHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile NativeMethodInjectHelper f71422c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayMap f71423a;

    /* renamed from: b  reason: collision with root package name */
    public List f71424b;

    public NativeMethodInjectHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71423a = new ArrayMap();
        this.f71424b = new ArrayList();
    }

    public static NativeMethodInjectHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            NativeMethodInjectHelper nativeMethodInjectHelper = f71422c;
            if (nativeMethodInjectHelper == null) {
                synchronized (NativeMethodInjectHelper.class) {
                    nativeMethodInjectHelper = f71422c;
                    if (nativeMethodInjectHelper == null) {
                        nativeMethodInjectHelper = new NativeMethodInjectHelper();
                        f71422c = nativeMethodInjectHelper;
                    }
                }
            }
            return nativeMethodInjectHelper;
        }
        return (NativeMethodInjectHelper) invokeV.objValue;
    }

    public NativeMethodInjectHelper clazz(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            if (cls != null) {
                this.f71424b.add(cls);
                return this;
            }
            throw new NullPointerException("NativeMethodInjectHelper:The clazz can not be null!");
        }
        return (NativeMethodInjectHelper) invokeL.objValue;
    }

    public Method findMethod(String str, String str2) {
        InterceptResult invokeLL;
        ArrayMap arrayMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !this.f71423a.containsKey(str) || (arrayMap = (ArrayMap) this.f71423a.get(str)) == null || !arrayMap.containsKey(str2)) {
                return null;
            }
            return (Method) arrayMap.get(str2);
        }
        return (Method) invokeLL.objValue;
    }

    public void inject() {
        int size;
        Method[] declaredMethods;
        Class<?>[] parameterTypes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (size = this.f71424b.size()) == 0) {
            return;
        }
        this.f71423a.clear();
        for (int i2 = 0; i2 < size; i2++) {
            Class cls = (Class) this.f71424b.get(i2);
            if (cls != null) {
                ArrayMap arrayMap = new ArrayMap();
                for (Method method : cls.getDeclaredMethods()) {
                    int modifiers = method.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & 8) != 0 && method.getReturnType() == Void.TYPE && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 3 && WebView.class == parameterTypes[0] && JSONObject.class == parameterTypes[1] && JsCallback.class == parameterTypes[2]) {
                        arrayMap.put(method.getName(), method);
                    }
                }
                this.f71423a.put(cls.getSimpleName(), arrayMap);
            }
        }
        this.f71424b.clear();
    }
}
