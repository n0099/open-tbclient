package d.n.a.a.c.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-590029370, "Ld/n/a/a/c/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-590029370, "Ld/n/a/a/c/b/b;");
        }
    }

    public static File a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, context, z)) == null) {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            try {
                Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
                Method method2 = cls.getMethod("getPath", new Class[0]);
                Method method3 = cls.getMethod("isRemovable", new Class[0]);
                Object invoke = method.invoke(storageManager, new Object[0]);
                int length = Array.getLength(invoke);
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = Array.get(invoke, i2);
                    String str = (String) method2.invoke(obj, new Object[0]);
                    if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue() && !TextUtils.isEmpty(str)) {
                        return new File(str);
                    }
                }
            } catch (Throwable th) {
                c.c(th);
            }
            return Environment.getExternalStorageDirectory();
        }
        return (File) invokeLZ.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static byte[] c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            byte[] bArr2 = new byte[256];
            for (int i2 = 0; i2 < 256; i2++) {
                bArr2[i2] = (byte) i2;
            }
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 256; i5++) {
                i4 = ((bArr[i3] & 255) + (bArr2[i5] & 255) + i4) & 255;
                byte b2 = bArr2[i5];
                bArr2[i5] = bArr2[i4];
                bArr2[i4] = b2;
                i3 = (i3 + 1) % bArr.length;
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x001d A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #0 {all -> 0x0021, blocks: (B:6:0x0007, B:9:0x000c, B:15:0x0015, B:18:0x001d), top: B:28:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] d(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        byte[] bArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, bArr2)) == null) {
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
                    c.c(th);
                }
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String[] e(Context context) {
        InterceptResult invokeL;
        List<SubscriptionInfo> activeSubscriptionInfoList;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            try {
                if (f.e(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
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
                c.c(th);
                return new String[]{"KWE_N", "KWE_N"};
            }
        }
        return (String[]) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x001d A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #0 {all -> 0x0021, blocks: (B:6:0x0007, B:9:0x000c, B:15:0x0015, B:18:0x001d), top: B:28:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] f(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        byte[] bArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, bArr, bArr2)) == null) {
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
                    c.c(th);
                }
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] g(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bArr, bArr2)) == null) {
            byte[] c2 = c(bArr2);
            byte[] bArr3 = new byte[bArr.length];
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < bArr.length; i4++) {
                i2 = (i2 + 1) & 255;
                i3 = ((c2[i2] & 255) + i3) & 255;
                byte b2 = c2[i2];
                c2[i2] = c2[i3];
                c2[i3] = b2;
                bArr3[i4] = (byte) (c2[((c2[i2] & 255) + (c2[i3] & 255)) & 255] ^ bArr[i4]);
                bArr3[i4] = (byte) (bArr3[i4] ^ 42);
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }
}
