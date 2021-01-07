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
/* loaded from: classes15.dex */
public class a extends com.sdk.base.framework.f.a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f13133a = f.f13119b;

    /* renamed from: b  reason: collision with root package name */
    private static final String f13134b = a.class.getSimpleName();

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
            c.b(f13134b, th.getMessage(), Boolean.valueOf(f13133a));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0110 A[Catch: Exception -> 0x013a, TRY_LEAVE, TryCatch #3 {Exception -> 0x013a, blocks: (B:3:0x000c, B:11:0x007a, B:12:0x00a1, B:20:0x0110, B:19:0x00e1), top: B:34:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ArrayList<KInfo> c(Context context) {
        Method method;
        Object obj;
        Method declaredMethod;
        Method declaredMethod2;
        boolean z;
        Method method2;
        Method method3;
        String str;
        String str2;
        String str3;
        String str4;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<KInfo> arrayList = new ArrayList<>();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Class<?> cls = Class.forName(telephonyManager.getClass().getName());
            try {
                Method declaredMethod3 = cls.getDeclaredMethod("getSubscriberInfo", new Class[0]);
                declaredMethod3.setAccessible(true);
                obj = declaredMethod3.invoke(telephonyManager, new Object[0]);
                try {
                    Class<?> cls2 = Class.forName("com.android.internal.telephony.IPhoneSubInfo");
                    method = cls2.getDeclaredMethod("getDeviceId", new Class[0]);
                    try {
                        method.setAccessible(true);
                        declaredMethod = cls2.getDeclaredMethod("getSubscriberId", new Class[0]);
                        declaredMethod.setAccessible(true);
                        declaredMethod2 = cls2.getDeclaredMethod("getLine1Number", new Class[0]);
                        declaredMethod2.setAccessible(true);
                        method2 = cls2.getDeclaredMethod("getIccSerialNumber", new Class[0]);
                        method2.setAccessible(true);
                        z = true;
                        method3 = method;
                    } catch (Exception e) {
                        declaredMethod = cls.getDeclaredMethod("getSubscriberId", new Class[0]);
                        declaredMethod.setAccessible(true);
                        declaredMethod2 = cls.getDeclaredMethod("getLine1Number", new Class[0]);
                        declaredMethod2.setAccessible(true);
                        Method declaredMethod4 = cls.getDeclaredMethod("getSimSerialNumber", new Class[0]);
                        declaredMethod4.setAccessible(true);
                        z = false;
                        method2 = declaredMethod4;
                        method3 = method;
                        if (z) {
                        }
                        KInfo kInfo = new KInfo();
                        kInfo.setIs(str);
                        kInfo.setIc(str2);
                        kInfo.setIe(str3);
                        kInfo.setM(str4);
                        kInfo.setSid(0);
                        arrayList.add(kInfo);
                        if (f13133a) {
                        }
                        return arrayList;
                    }
                } catch (Exception e2) {
                    method = null;
                }
            } catch (Exception e3) {
                method = null;
                obj = null;
            }
            if (z) {
                String str5 = (String) method2.invoke(telephonyManager, new Object[0]);
                str = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
                str2 = str5;
                str3 = (String) method3.invoke(telephonyManager, new Object[0]);
                str4 = (String) declaredMethod2.invoke(telephonyManager, new Object[0]);
            } else {
                str = (String) declaredMethod.invoke(obj, new Object[0]);
                str2 = (String) method2.invoke(obj, new Object[0]);
                str3 = (String) method3.invoke(obj, new Object[0]);
                str4 = (String) declaredMethod2.invoke(obj, new Object[0]);
            }
            KInfo kInfo2 = new KInfo();
            kInfo2.setIs(str);
            kInfo2.setIc(str2);
            kInfo2.setIe(str3);
            kInfo2.setM(str4);
            kInfo2.setSid(0);
            arrayList.add(kInfo2);
        } catch (Exception e4) {
            c.b(f13134b, e4.getMessage(), Boolean.valueOf(f13133a));
        }
        if (f13133a) {
            c.a(f13134b, "应用层获取sim卡信息耗时：" + (System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(f13133a));
        }
        return arrayList;
    }
}
