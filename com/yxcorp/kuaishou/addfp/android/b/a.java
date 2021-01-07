package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes5.dex */
public final class a {
    static {
        String[] strArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "getNetworkIso", com.baidu.pass.biometrics.face.liveness.d.b.f4081a, "c", "d", "e", "f"};
    }

    public static boolean a() {
        return false;
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = (byte) i;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < 256) {
            int i5 = ((bArr[i4] & 255) + (bArr2[i2] & 255) + i3) & 255;
            byte b2 = bArr2[i2];
            bArr2[i2] = bArr2[i5];
            bArr2[i5] = b2;
            i4 = (i4 + 1) % bArr.length;
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0003 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        ?? r1 = 0;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] h = (bArr == null || bArr2 == null) ? null : h(bArr, bArr2);
                    if (h != null) {
                        r1 = h.length;
                        return r1 > 0 ? h : h;
                    }
                    return h;
                }
            } catch (Throwable th) {
                b.a(th);
                return r1;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0003 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public static byte[] b(byte[] bArr, byte[] bArr2) {
        ?? r1 = 0;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] h = (bArr == null || bArr2 == null) ? null : h(bArr, bArr2);
                    if (h != null) {
                        r1 = h.length;
                        return r1 > 0 ? h : h;
                    }
                    return h;
                }
            } catch (Throwable th) {
                b.a(th);
                return r1;
            }
        }
        return null;
    }

    private static byte[] h(byte[] bArr, byte[] bArr2) {
        byte[] a2 = a(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < bArr.length) {
            i3 = (i3 + 1) & 255;
            int i4 = ((a2[i3] & 255) + i2) & 255;
            byte b2 = a2[i3];
            a2[i3] = a2[i4];
            a2[i4] = b2;
            bArr3[i] = (byte) (a2[((a2[i3] & 255) + (a2[i4] & 255)) & 255] ^ bArr[i]);
            bArr3[i] = (byte) (bArr3[i] ^ 42);
            i++;
            i2 = i4;
        }
        return bArr3;
    }

    public static String[] jf(Context context) {
        List<SubscriptionInfo> activeSubscriptionInfoList;
        String str;
        try {
            if (e.a(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                int phoneCount = Build.VERSION.SDK_INT >= 23 ? ((TelephonyManager) context.getSystemService("phone")).getPhoneCount() : Build.VERSION.SDK_INT >= 22 ? SubscriptionManager.from(context).getActiveSubscriptionInfoCount() : 1;
                if (phoneCount == 0) {
                    phoneCount = 1;
                }
                if (phoneCount > 1 && Build.VERSION.SDK_INT >= 22 && (activeSubscriptionInfoList = SubscriptionManager.from(context).getActiveSubscriptionInfoList()) != null) {
                    String str2 = "";
                    int size = activeSubscriptionInfoList.size();
                    if (size > 1) {
                        String iccId = activeSubscriptionInfoList.get(0).getIccId();
                        str = activeSubscriptionInfoList.get(1).getIccId();
                        str2 = iccId;
                    } else if (size == 1) {
                        str2 = activeSubscriptionInfoList.get(0).getIccId();
                        str = "";
                    } else {
                        str = "";
                    }
                    if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
                        return new String[]{str2, str};
                    }
                }
                String simSerialNumber = telephonyManager.getSimSerialNumber();
                return new String[]{simSerialNumber == null ? "KWE_N" : simSerialNumber, "KWE_N"};
            }
            return new String[]{"KWE_PN", "KWE_PN"};
        } catch (Throwable th) {
            b.a(th);
            return new String[]{"KWE_N", "KWE_N"};
        }
    }

    public static File w(Context context, boolean z) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(invoke, i);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue() && !TextUtils.isEmpty(str)) {
                    return new File(str);
                }
            }
        } catch (Throwable th) {
            b.a(th);
        }
        return Environment.getExternalStorageDirectory();
    }
}
