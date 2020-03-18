package tv.cjump.jni;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.v4.internal.view.SupportMenu;
import android.util.Log;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class NativeBitmapFactory {
    static Field odD = null;
    static boolean odE = false;
    static boolean odF = false;

    private static native Bitmap createBitmap(int i, int i2, int i3, boolean z);

    private static native Bitmap createBitmap19(int i, int i2, int i3, boolean z);

    private static native boolean init();

    private static native boolean release();

    public static boolean dRy() {
        return Build.VERSION.SDK_INT < 11 || (odE && odD != null);
    }

    public static void dRz() {
        if (!odF) {
            if (!DeviceUtils.isRealARMArch() && !DeviceUtils.isRealX86Arch()) {
                odF = true;
                odE = false;
            } else if (!odE) {
                try {
                    if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 23) {
                        System.loadLibrary("ndkbitmap");
                        odE = true;
                    } else {
                        odF = true;
                        odE = false;
                    }
                } catch (Error e) {
                    e.printStackTrace();
                    odF = true;
                    odE = false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    odF = true;
                    odE = false;
                }
                if (odE) {
                    if (!init()) {
                        release();
                        odF = true;
                        odE = false;
                    } else {
                        dRB();
                        if (!dRC()) {
                            release();
                            odF = true;
                            odE = false;
                        }
                    }
                }
                Log.e("NativeBitmapFactory", "loaded" + odE);
            }
        }
    }

    public static synchronized void dRA() {
        synchronized (NativeBitmapFactory.class) {
            boolean z = odE;
            odD = null;
            odE = false;
            if (z) {
                release();
            }
        }
    }

    static void dRB() {
        try {
            odD = Bitmap.Config.class.getDeclaredField("nativeInt");
            odD.setAccessible(true);
        } catch (NoSuchFieldException e) {
            odD = null;
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=4, 127=5] */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r8.getHeight() == 2) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean dRC() {
        Bitmap bitmap;
        boolean z;
        boolean z2 = true;
        if (odD == null) {
            return false;
        }
        Bitmap bitmap2 = null;
        try {
            bitmap = b(2, 2, Bitmap.Config.ARGB_8888, true);
            if (bitmap != null) {
                try {
                    if (bitmap.getWidth() == 2) {
                    }
                } catch (Error e) {
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    return false;
                } catch (Exception e2) {
                    e = e2;
                    bitmap2 = bitmap;
                    try {
                        Log.e("NativeBitmapFactory", "exception:" + e.toString());
                        if (bitmap2 != null) {
                            bitmap2.recycle();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bitmap = bitmap2;
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bitmap != null) {
                    }
                    throw th;
                }
            }
            z2 = false;
            if (z2) {
                if (Build.VERSION.SDK_INT >= 17 && !bitmap.isPremultiplied()) {
                    bitmap.setPremultiplied(true);
                }
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setColor(SupportMenu.CATEGORY_MASK);
                paint.setTextSize(20.0f);
                canvas.drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), paint);
                canvas.drawText("TestLib", 0.0f, 0.0f, paint);
                if (Build.VERSION.SDK_INT >= 17) {
                    z = bitmap.isPremultiplied();
                    if (bitmap == null) {
                        bitmap.recycle();
                        return z;
                    }
                    return z;
                }
            }
            z = z2;
            if (bitmap == null) {
            }
        } catch (Error e3) {
            bitmap = null;
        } catch (Exception e4) {
            e = e4;
        } catch (Throwable th3) {
            th = th3;
            bitmap = null;
        }
    }

    public static int e(Bitmap.Config config) {
        try {
            if (odD == null) {
                return 0;
            }
            return odD.getInt(config);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Bitmap createBitmap(int i, int i2, Bitmap.Config config) {
        return a(i, i2, config, config.equals(Bitmap.Config.ARGB_8888));
    }

    public static synchronized Bitmap a(int i, int i2, Bitmap.Config config, boolean z) {
        Bitmap createBitmap;
        synchronized (NativeBitmapFactory.class) {
            createBitmap = (!odE || odD == null) ? Bitmap.createBitmap(i, i2, config) : b(i, i2, config, z);
        }
        return createBitmap;
    }

    private static Bitmap b(int i, int i2, Bitmap.Config config, boolean z) {
        int e = e(config);
        return Build.VERSION.SDK_INT == 19 ? createBitmap19(i, i2, e, z) : createBitmap(i, i2, e, z);
    }
}
