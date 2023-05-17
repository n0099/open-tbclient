package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, context, z)) == null) {
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
                    if (z == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue() && !TextUtils.isEmpty(str)) {
                        return new File(str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return Environment.getExternalStorageDirectory();
        }
        return (File) invokeLZ.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, bArr2)) == null) {
            byte[] bArr3 = new byte[256];
            for (int i = 0; i < 256; i++) {
                bArr3[i] = (byte) i;
            }
            if (bArr2.length == 0) {
                bArr3 = null;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < 256; i4++) {
                    i3 = ((bArr2[i2] & 255) + (bArr3[i4] & 255) + i3) & 255;
                    byte b = bArr3[i4];
                    bArr3[i4] = bArr3[i3];
                    bArr3[i3] = b;
                    i2 = (i2 + 1) % bArr2.length;
                }
            }
            byte[] bArr4 = new byte[bArr.length];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < bArr.length; i7++) {
                i5 = (i5 + 1) & 255;
                i6 = ((bArr3[i5] & 255) + i6) & 255;
                byte b2 = bArr3[i5];
                bArr3[i5] = bArr3[i6];
                bArr3[i6] = b2;
                bArr4[i7] = (byte) (bArr3[((bArr3[i5] & 255) + (bArr3[i6] & 255)) & 255] ^ bArr[i7]);
                bArr4[i7] = (byte) (bArr4[i7] ^ ExifInterface.START_CODE);
            }
            return bArr4;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        byte[] a = a(bArr, bArr2);
                        if (a != null) {
                            if (a.length > 0) {
                            }
                        }
                        return a;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        byte[] a = a(bArr, bArr2);
                        if (a != null) {
                            if (a.length > 0) {
                            }
                        }
                        return a;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }
}
