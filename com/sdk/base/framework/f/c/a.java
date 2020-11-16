package com.sdk.base.framework.f.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.c.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends com.sdk.base.framework.f.a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f4494a = f.b;
    private static final String b = a.class.getSimpleName();

    public static ArrayList<KInfo> a(Context context) {
        ArrayList<KInfo> arrayList = new ArrayList<>();
        try {
            arrayList = com.sdk.base.framework.f.a.a.b() >= 21 ? b(context) : c(context);
        } catch (Throwable th) {
        }
        return arrayList;
    }

    @TargetApi(22)
    private static ArrayList<KInfo> b(Context context) {
        System.currentTimeMillis();
        ArrayList<KInfo> arrayList = new ArrayList<>();
        try {
            Class<?> cls = Class.forName("android.telephony.SubscriptionInfo");
            Method declaredMethod = cls.getDeclaredMethod("getIccId", new Class[0]);
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = cls.getDeclaredMethod("getSubscriptionId", new Class[0]);
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = cls.getDeclaredMethod("getNumber", new Class[0]);
            declaredMethod3.setAccessible(true);
            Method declaredMethod4 = cls.getDeclaredMethod("getSimSlotIndex", new Class[0]);
            declaredMethod4.setAccessible(true);
            Method declaredMethod5 = cls.getDeclaredMethod("getCarrierName", new Class[0]);
            declaredMethod5.setAccessible(true);
            List list = (List) a(context, "getActiveSubscriptionInfoList", false, null, null);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Object obj = list.get(i);
                    KInfo kInfo = new KInfo();
                    int intValue = ((Integer) declaredMethod2.invoke(obj, new Object[0])).intValue();
                    int intValue2 = ((Integer) declaredMethod4.invoke(obj, new Object[0])).intValue();
                    String str = (String) b(context, "getSubscriberId", false, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(intValue)});
                    if (c.a(str).booleanValue()) {
                        str = (String) b(context, "getSubscriberId", false, null, null);
                    }
                    if (c.b(str).booleanValue()) {
                        kInfo.setIs(str);
                    }
                    String str2 = (String) b(context, "getDeviceId", false, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(intValue2)});
                    if (c.a(str2).booleanValue()) {
                        str2 = (String) b(context, "getDeviceId", false, null, null);
                    }
                    if (c.b(str2).booleanValue()) {
                        kInfo.setIe(str2);
                    }
                    String str3 = (String) declaredMethod.invoke(obj, new Object[0]);
                    if (c.b(str3).booleanValue()) {
                        kInfo.setIc(str3);
                    }
                    String str4 = (String) declaredMethod3.invoke(obj, new Object[0]);
                    if (c.b(str4).booleanValue()) {
                        kInfo.setM(str4);
                    }
                    String str5 = (String) declaredMethod5.invoke(obj, new Object[0]);
                    if (c.b(str5).booleanValue()) {
                        kInfo.setCn(str5);
                    }
                    try {
                        if (intValue == ((Integer) a(context, "getDefaultDataSubId", true, null, null)).intValue()) {
                            kInfo.setIdfd(true);
                        }
                    } catch (Exception e) {
                        if (intValue == ((Integer) a(context, "getDefaultDataSubscriptionId", true, null, null)).intValue()) {
                            kInfo.setIdfd(true);
                        }
                    }
                    kInfo.setSid(intValue2);
                    if (intValue == ((Integer) a(context, "getDefaultSmsSubId", true, null, null)).intValue()) {
                        kInfo.setIdfs(true);
                    }
                    arrayList.add(kInfo);
                }
            }
        } catch (Throwable th) {
            c.b(b, th.getMessage(), Boolean.valueOf(f4494a));
        }
        return arrayList;
    }

    private static ArrayList<KInfo> c(Context context) {
        Method method;
        Object obj;
        Method method2;
        Method method3;
        Method method4;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<KInfo> arrayList = new ArrayList<>();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Class<?> cls = Class.forName(telephonyManager.getClass().getName());
            Object obj2 = null;
            Method method5 = null;
            try {
                Method declaredMethod = cls.getDeclaredMethod("getSubscriberInfo", new Class[0]);
                declaredMethod.setAccessible(true);
                obj2 = declaredMethod.invoke(telephonyManager, new Object[0]);
                Class<?> cls2 = Class.forName("com.android.internal.telephony.IPhoneSubInfo");
                method5 = cls2.getDeclaredMethod("getDeviceId", new Class[0]);
                method5.setAccessible(true);
                Method declaredMethod2 = cls2.getDeclaredMethod("getSubscriberId", new Class[0]);
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls2.getDeclaredMethod("getLine1Number", new Class[0]);
                declaredMethod3.setAccessible(true);
                Method declaredMethod4 = cls2.getDeclaredMethod("getIccSerialNumber", new Class[0]);
                declaredMethod4.setAccessible(true);
                method = declaredMethod2;
                obj = obj2;
                method2 = declaredMethod4;
                method3 = declaredMethod3;
                method4 = method5;
                z = true;
            } catch (Exception e) {
                Method declaredMethod5 = cls.getDeclaredMethod("getSubscriberId", new Class[0]);
                declaredMethod5.setAccessible(true);
                Method declaredMethod6 = cls.getDeclaredMethod("getLine1Number", new Class[0]);
                declaredMethod6.setAccessible(true);
                Method declaredMethod7 = cls.getDeclaredMethod("getSimSerialNumber", new Class[0]);
                declaredMethod7.setAccessible(true);
                method = declaredMethod5;
                obj = obj2;
                method2 = declaredMethod7;
                method3 = declaredMethod6;
                method4 = method5;
                z = false;
            }
            if (z) {
                str3 = (String) method2.invoke(obj, new Object[0]);
                str4 = (String) method.invoke(obj, new Object[0]);
                str = (String) method4.invoke(obj, new Object[0]);
                str2 = (String) method3.invoke(obj, new Object[0]);
            } else {
                String str5 = (String) method2.invoke(telephonyManager, new Object[0]);
                String str6 = (String) method.invoke(telephonyManager, new Object[0]);
                str = (String) method4.invoke(telephonyManager, new Object[0]);
                str2 = (String) method3.invoke(telephonyManager, new Object[0]);
                str3 = str5;
                str4 = str6;
            }
            KInfo kInfo = new KInfo();
            kInfo.setIs(str4);
            kInfo.setIc(str3);
            kInfo.setIe(str);
            kInfo.setM(str2);
            kInfo.setSid(0);
            arrayList.add(kInfo);
        } catch (Exception e2) {
            c.b(b, e2.getMessage(), Boolean.valueOf(f4494a));
        }
        if (f4494a) {
            c.a(b, "应用层获取sim卡信息耗时：" + (System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(f4494a));
        }
        return arrayList;
    }
}
