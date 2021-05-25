package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.GDTLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes7.dex */
public class a {
    public static boolean a(Context context) {
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

    public static boolean a(Context context, Class<?>... clsArr) {
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

    /* JADX WARN: Removed duplicated region for block: B:38:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr) {
        Throwable th;
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = null;
        bArr2 = null;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            try {
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
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
                } catch (Throwable th2) {
                    th = th2;
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
                e = e4;
                gZIPOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                if (gZIPOutputStream2 != null) {
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return bArr2;
    }

    public static boolean b(Context context) {
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

    public static boolean b(Context context, Class<?>... clsArr) {
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

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0052: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:28:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        byte[] bArr3 = null;
        bArr3 = null;
        GZIPInputStream gZIPInputStream3 = null;
        try {
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    while (true) {
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
                    }
                    byteArrayOutputStream.flush();
                    bArr3 = byteArrayOutputStream.toByteArray();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream3 = gZIPInputStream2;
                    if (gZIPInputStream3 != null) {
                        try {
                            gZIPInputStream3.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            throw th;
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                gZIPInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (gZIPInputStream3 != null) {
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return bArr3;
    }
}
