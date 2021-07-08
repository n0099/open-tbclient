package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.GDTLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                if (b(context) && a(context, Class.forName(CustomPkgConstants.getADActivityName())) && a(context, Class.forName(CustomPkgConstants.getPortraitADActivityName())) && a(context, Class.forName(CustomPkgConstants.getLandscapeADActivityName()))) {
                    if (b(context, Class.forName(CustomPkgConstants.getDownLoadServiceName()))) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                GDTLogger.e("Exception While check SDK Env", th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, clsArr)) == null) {
            for (int i2 = 0; i2 <= 0; i2++) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(context, clsArr[0]);
                    if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                        GDTLogger.e(String.format("Activity[%s] is required in AndroidManifest.xml", clsArr[0].getName()));
                        return false;
                    }
                } catch (Throwable th) {
                    GDTLogger.e("Exception while checking required activities", th);
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        GZIPOutputStream gZIPOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream2 = null;
            r1 = null;
            byte[] bArr2 = null;
            try {
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        try {
                            gZIPOutputStream.write(bArr);
                            gZIPOutputStream.finish();
                            bArr2 = byteArrayOutputStream.toByteArray();
                            gZIPOutputStream.close();
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (gZIPOutputStream != null) {
                                gZIPOutputStream.close();
                            }
                            byteArrayOutputStream.close();
                            return bArr2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream2 = gZIPOutputStream;
                        if (gZIPOutputStream2 != null) {
                            try {
                                gZIPOutputStream2.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                throw th;
                            }
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e = e5;
                gZIPOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (gZIPOutputStream2 != null) {
                }
                byteArrayOutputStream.close();
                throw th;
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String[] strArr = {"android.permission.INTERNET", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, "android.permission.ACCESS_WIFI_STATE"};
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    String str = strArr[i2];
                    if (context.checkCallingOrSelfPermission(str) == -1) {
                        GDTLogger.e(String.format("Permission %s is required in AndroidManifest.xml", str));
                        return false;
                    }
                } catch (Throwable th) {
                    GDTLogger.e("Check required Permissions error", th);
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, clsArr)) == null) {
            for (int i2 = 0; i2 <= 0; i2++) {
                try {
                    Class<?> cls = clsArr[0];
                    Intent intent = new Intent();
                    intent.setClass(context, cls);
                    if (context.getPackageManager().resolveService(intent, 65536) == null) {
                        GDTLogger.e(String.format("Service[%s] is required in AndroidManifest.xml", cls.getName()));
                        return false;
                    }
                } catch (Throwable th) {
                    GDTLogger.e("Exception while checking required services", th);
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        GZIPInputStream gZIPInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            GZIPInputStream gZIPInputStream2 = null;
            r2 = null;
            byte[] bArr3 = null;
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    while (true) {
                        try {
                            try {
                                int read = gZIPInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (gZIPInputStream != null) {
                                    gZIPInputStream.close();
                                }
                                byteArrayInputStream.close();
                                byteArrayOutputStream.close();
                                return bArr3;
                            }
                        } catch (Throwable th) {
                            th = th;
                            gZIPInputStream2 = gZIPInputStream;
                            if (gZIPInputStream2 != null) {
                                try {
                                    gZIPInputStream2.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    }
                    byteArrayOutputStream.flush();
                    bArr3 = byteArrayOutputStream.toByteArray();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e = e5;
                gZIPInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (gZIPInputStream2 != null) {
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
            return bArr3;
        }
        return (byte[]) invokeL.objValue;
    }
}
