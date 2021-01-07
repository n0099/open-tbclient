package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.nativeadunified.k;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes4.dex */
class a {
    public static NativeUnifiedADData a(final NativeUnifiedADData nativeUnifiedADData, final k.a aVar) {
        if (nativeUnifiedADData instanceof ADEventListener) {
            try {
                final Method declaredMethod = ADEventListener.class.getDeclaredMethod("setAdListener", ADListener.class);
                return (NativeUnifiedADData) Proxy.newProxyInstance(NativeUnifiedADData.class.getClassLoader(), new Class[]{NativeUnifiedADData.class, ADEventListener.class}, new InvocationHandler() { // from class: com.qq.e.comm.plugin.nativeadunified.a.1
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                        if (declaredMethod.equals(method)) {
                            aVar.a((ADListener) objArr[0]);
                            return method.invoke(nativeUnifiedADData, aVar);
                        }
                        return method.invoke(nativeUnifiedADData, objArr);
                    }
                });
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return nativeUnifiedADData;
            }
        }
        return nativeUnifiedADData;
    }

    public static BaseNativeUnifiedAd a(String str, Context context, String str2, String str3) throws Exception {
        return (BaseNativeUnifiedAd) Class.forName(str).asSubclass(BaseNativeUnifiedAd.class).getDeclaredConstructor(Context.class, String.class, String.class).newInstance(context, str2, str3);
    }
}
