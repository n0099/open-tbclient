package d.q.a.a.c.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes7.dex */
public final class a {
    public static File a(Context context, boolean z) {
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
            b.c(th);
        }
        return Environment.getExternalStorageDirectory();
    }

    public static boolean b() {
        return false;
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = (byte) i;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i3 = ((bArr[i2] & 255) + (bArr2[i4] & 255) + i3) & 255;
            byte b2 = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b2;
            i2 = (i2 + 1) % bArr.length;
        }
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0019 A[Catch: all -> 0x001d, TRY_LEAVE, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0003, B:7:0x0008, B:13:0x0011, B:16:0x0019), top: B:22:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    if (bArr != null && bArr2 != null) {
                        bArr3 = g(bArr, bArr2);
                        if (bArr3 != null) {
                            if (bArr3.length > 0) {
                            }
                        }
                        return bArr3;
                    }
                    bArr3 = null;
                    if (bArr3 != null) {
                    }
                    return bArr3;
                }
            } catch (Throwable th) {
                b.c(th);
            }
        }
        return null;
    }

    public static String[] e(Context context) {
        List<SubscriptionInfo> activeSubscriptionInfoList;
        String str;
        try {
            if (e.e(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                int phoneCount = Build.VERSION.SDK_INT >= 23 ? ((TelephonyManager) context.getSystemService("phone")).getPhoneCount() : Build.VERSION.SDK_INT >= 22 ? SubscriptionManager.from(context).getActiveSubscriptionInfoCount() : 1;
                if (phoneCount == 0) {
                    phoneCount = 1;
                }
                if (phoneCount > 1 && Build.VERSION.SDK_INT >= 22 && (activeSubscriptionInfoList = SubscriptionManager.from(context).getActiveSubscriptionInfoList()) != null) {
                    int size = activeSubscriptionInfoList.size();
                    String str2 = "";
                    if (size > 1) {
                        str2 = activeSubscriptionInfoList.get(0).getIccId();
                        str = activeSubscriptionInfoList.get(1).getIccId();
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
                if (simSerialNumber == null) {
                    simSerialNumber = "KWE_N";
                }
                return new String[]{simSerialNumber, "KWE_N"};
            }
            return new String[]{"KWE_PN", "KWE_PN"};
        } catch (Throwable th) {
            b.c(th);
            return new String[]{"KWE_N", "KWE_N"};
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0019 A[Catch: all -> 0x001d, TRY_LEAVE, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0003, B:7:0x0008, B:13:0x0011, B:16:0x0019), top: B:22:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] f(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    if (bArr != null && bArr2 != null) {
                        bArr3 = g(bArr, bArr2);
                        if (bArr3 != null) {
                            if (bArr3.length > 0) {
                            }
                        }
                        return bArr3;
                    }
                    bArr3 = null;
                    if (bArr3 != null) {
                    }
                    return bArr3;
                }
            } catch (Throwable th) {
                b.c(th);
            }
        }
        return null;
    }

    public static byte[] g(byte[] bArr, byte[] bArr2) {
        byte[] c2 = c(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = ((c2[i] & 255) + i2) & 255;
            byte b2 = c2[i];
            c2[i] = c2[i2];
            c2[i2] = b2;
            bArr3[i3] = (byte) (c2[((c2[i] & 255) + (c2[i2] & 255)) & 255] ^ bArr[i3]);
            bArr3[i3] = (byte) (bArr3[i3] ^ ExifInterface.START_CODE);
        }
        return bArr3;
    }
}
