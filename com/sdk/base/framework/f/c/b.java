package com.sdk.base.framework.f.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends com.sdk.base.framework.f.a {
    private static final String a = b.class.getName();
    private static Boolean b = Boolean.valueOf(f.b);

    public static ArrayList<String> a(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            arrayList = com.sdk.base.framework.f.a.a.b() >= 21 ? b(context) : c(context);
        } catch (Exception e) {
            c.b(a, e.getMessage(), b);
        }
        return arrayList;
    }

    private static ArrayList<String> b(Context context) {
        int i = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        System.currentTimeMillis();
        try {
            Method declaredMethod = Class.forName("android.telephony.SubscriptionInfo").getDeclaredMethod("getSimSlotIndex", new Class[0]);
            declaredMethod.setAccessible(true);
            List list = (List) a(context, "getActiveSubscriptionInfoList", false, null, null);
            if (list != null) {
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    String str = (String) b(context, "getDeviceId", false, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(((Integer) declaredMethod.invoke(list.get(i2), new Object[0])).intValue())});
                    if (c.a(str).booleanValue()) {
                        str = (String) b(context, "getDeviceId", false, null, null);
                    }
                    if (c.b(str).booleanValue()) {
                        arrayList.add(str);
                    }
                    i = i2 + 1;
                }
            }
        } catch (Throwable th) {
            c.b(a, th.getMessage(), b);
        }
        b.booleanValue();
        return arrayList;
    }

    private static ArrayList<String> c(Context context) {
        Method declaredMethod;
        Object obj;
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Class<?> cls = Class.forName(telephonyManager.getClass().getName());
            Object obj2 = null;
            try {
                Method declaredMethod2 = cls.getDeclaredMethod("getSubscriberInfo", new Class[0]);
                declaredMethod2.setAccessible(true);
                obj2 = declaredMethod2.invoke(telephonyManager, new Object[0]);
                Method declaredMethod3 = Class.forName("com.android.internal.telephony.IPhoneSubInfo").getDeclaredMethod("getDeviceId", new Class[0]);
                declaredMethod3.setAccessible(true);
                obj = obj2;
                z = true;
                declaredMethod = declaredMethod3;
            } catch (Exception e) {
                declaredMethod = cls.getDeclaredMethod("getDeviceId", new Class[0]);
                declaredMethod.setAccessible(true);
                obj = obj2;
                z = false;
            }
            arrayList.add(z ? (String) declaredMethod.invoke(obj, new Object[0]) : (String) declaredMethod.invoke(telephonyManager, new Object[0]));
        } catch (Exception e2) {
            c.b(a, e2.getMessage(), b);
        }
        if (b.booleanValue()) {
            c.a(a, "应用层获取IMEI信息耗时：" + (System.currentTimeMillis() - currentTimeMillis), b);
        }
        return arrayList;
    }
}
