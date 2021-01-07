package com.sdk.base.framework.f;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import java.lang.reflect.Method;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13127a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f13128b = f.f13119b;

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(Context context, String str, Boolean bool, Class<?>[] clsArr, Object[] objArr) {
        Object obj = null;
        try {
            Class<?> cls = Class.forName("android.telephony.SubscriptionManager");
            Object newInstance = cls.getConstructor(Class.forName("android.content.Context")).newInstance(context);
            Method declaredMethod = cls.getDeclaredMethod(str, null);
            declaredMethod.setAccessible(true);
            obj = bool.booleanValue() ? declaredMethod.invoke(null, null) : declaredMethod.invoke(newInstance, null);
        } catch (Exception e) {
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, String str2, Object obj, boolean z) {
        if (z) {
            Log.e(str, "==>" + str2 + "\n==>" + obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object b(Context context, String str, Boolean bool, Class<?>[] clsArr, Object[] objArr) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method declaredMethod = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return bool.booleanValue() ? declaredMethod.invoke(null, objArr) : declaredMethod.invoke(telephonyManager, objArr);
        } catch (Exception e) {
            c.b(f13127a, e.getMessage(), Boolean.valueOf(f13128b));
            return null;
        }
    }
}
