package d.a.p0.s.y;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final l f53660a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, Method> f53661b;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: d.a.p0.s.y.d */
    /* JADX WARN: Multi-variable type inference failed */
    public d(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53660a = lVar;
        this.f53661b = new HashMap<>();
        c(getClass());
        if (this.f53661b.isEmpty()) {
            throw new IllegalStateException("No native methods found!");
        }
    }

    @Override // d.a.p0.s.y.h
    public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, jSONObject2) == null) {
            Method method = this.f53661b.get(str);
            if (method != null) {
                o oVar = (o) method.getAnnotation(o.class);
                String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
                try {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (!oVar.isAsync()) {
                        if (parameterTypes.length == 2) {
                            invoke = method.invoke(this, optString, jSONObject);
                        } else if (parameterTypes.length == 1) {
                            invoke = method.invoke(this, jSONObject);
                        } else if (parameterTypes.length == 0) {
                            e.a("native method " + getClass().getSimpleName() + ":" + oVar.value() + " ignored all parameters.");
                            invoke = method.invoke(this, new Object[0]);
                        } else {
                            f(str, jSONObject2, "500", "parameters too much!");
                            return;
                        }
                        if (TextUtils.isEmpty(optString)) {
                            return;
                        }
                        e(optString, (JSONObject) invoke);
                        return;
                    } else if (parameterTypes.length == 2) {
                        method.invoke(this, optString, jSONObject);
                        return;
                    } else if (parameterTypes.length == 1) {
                        method.invoke(this, jSONObject);
                        if (TextUtils.isEmpty(optString)) {
                            return;
                        }
                        e(optString, null);
                        return;
                    } else if (parameterTypes.length == 0) {
                        e.a("native method " + getClass().getSimpleName() + ":" + oVar.value() + " ignored all parameters.");
                        method.invoke(this, new Object[0]);
                        if (TextUtils.isEmpty(optString)) {
                            return;
                        }
                        e(optString, null);
                        return;
                    } else {
                        f(str, jSONObject2, "500", "parameters too much!");
                        return;
                    }
                } catch (IllegalAccessException e2) {
                    e.a("native method call error:" + e2.getMessage());
                    f(str, jSONObject2, "501", "IllegalAccessException:" + e2.getMessage());
                    return;
                } catch (InvocationTargetException e3) {
                    e.a("native method call error:" + e3.getMessage());
                    f(str, jSONObject2, "502", "InvocationTargetException:" + e3.getMessage());
                    return;
                } catch (Exception e4) {
                    e.a("native method call error:" + e4.getMessage());
                    f(str, jSONObject2, "503", "Native call exception:" + e4.getMessage());
                    return;
                }
            }
            f(str, jSONObject2, "403", "method " + str + " not exists");
        }
    }

    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53660a.f() : (Context) invokeV.objValue;
    }

    public final void c(Class<? extends d> cls) {
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls) == null) {
            for (Method method : cls.getDeclaredMethods()) {
                o oVar = (o) method.getAnnotation(o.class);
                if (oVar != null) {
                    String value = oVar.value();
                    String str = TextUtils.isEmpty(value) ? null : value;
                    if (oVar.isAsync() && !Void.TYPE.equals(method.getReturnType())) {
                        throw new IllegalArgumentException("Method with async flag should return void.");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = method.getName();
                    }
                    method.setAccessible(true);
                    this.f53661b.put(str, method);
                }
            }
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass == null || superclass == cls) {
                return;
            }
            c(superclass);
        }
    }

    public void d(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            a.a(message);
        }
    }

    public void e(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, jSONObject) == null) {
            if (TextUtils.isEmpty(str)) {
                e.a("sendResponseToJS got empty callbackId.");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "0");
            hashMap.put("errMsg", "success");
            if (jSONObject != null) {
                hashMap.put("data", jSONObject);
            }
            this.f53660a.c(m.k(str, hashMap));
        }
    }

    public final void f(String str, JSONObject jSONObject, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, jSONObject, str2, str3) == null) {
            String optString = jSONObject.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.a("method " + str + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", str2);
            hashMap.put("errMsg", str3);
            this.f53660a.c(m.k(optString, hashMap));
        }
    }
}
