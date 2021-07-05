package d.a.q0.a.v2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.opengl.GLES10;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.webrtc.EglBase10;
/* loaded from: classes8.dex */
public final class u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51410a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(129924352, "Ld/a/q0/a/v2/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(129924352, "Ld/a/q0/a/v2/u;");
                return;
            }
        }
        f51410a = d.a.q0.a.k.f49133a;
    }

    public static Bitmap a(Bitmap bitmap, long j, boolean z) {
        InterceptResult invokeCommon;
        byte[] byteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bitmap, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (bitmap == null || j <= 0) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            if (byteArrayOutputStream.size() <= j) {
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                byteArrayOutputStream.reset();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
                if (byteArrayOutputStream.size() >= j) {
                    byteArray = byteArrayOutputStream.toByteArray();
                } else {
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < i2) {
                        i4 = (i3 + i2) / 2;
                        byteArrayOutputStream.reset();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                        int i5 = (byteArrayOutputStream.size() > j ? 1 : (byteArrayOutputStream.size() == j ? 0 : -1));
                        if (i5 == 0) {
                            break;
                        } else if (i5 > 0) {
                            i2 = i4 - 1;
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                    if (i2 == i4 - 1) {
                        byteArrayOutputStream.reset();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                }
            }
            if (z && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static boolean b(File file, File file2, int i2) {
        InterceptResult invokeLLI;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, file, file2, i2)) == null) {
            if (f51410a) {
                Log.d("ImageUtils", "压缩图片");
            }
            if (file2 == null) {
                if (f51410a) {
                    Log.e("ImageUtils", "dest file is null");
                }
                return false;
            } else if (i2 >= 0 && i2 <= 100) {
                Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (decodeFile == null) {
                    if (f51410a) {
                        Log.e("ImageUtils", "compress image，but decode bitmap is null");
                    }
                    return false;
                }
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                    d.a.q0.t.d.d(fileOutputStream);
                    return true;
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream2 = fileOutputStream;
                    if (f51410a) {
                        Log.e("ImageUtils", "压缩图片失败", e);
                    }
                    d.a.q0.t.d.d(fileOutputStream2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    d.a.q0.t.d.d(fileOutputStream2);
                    throw th;
                }
            } else {
                if (f51410a) {
                    Log.e("ImageUtils", "quality must be 0..100");
                }
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    public static boolean c(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, str, str2, i2)) == null) {
            try {
                if (f51410a) {
                    Log.d("ImageUtils", "copyJpegExif oldFilePath:" + str + "，newFilePath：" + str2 + ",quality:" + i2);
                }
                ExifInterface i3 = i(str);
                ExifInterface i4 = i(str2);
                if (i3 != null && i4 != null) {
                    Field[] fields = ExifInterface.class.getFields();
                    for (int i5 = 0; i5 < fields.length; i5++) {
                        String name = fields[i5].getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith("TAG")) {
                            String obj = fields[i5].get(ExifInterface.class).toString();
                            String attribute = i3.getAttribute(obj);
                            if (f51410a) {
                                Log.d("ImageUtils", "fields name:" + obj + "，value：" + attribute);
                            }
                            if (!TextUtils.isEmpty(obj) && !TextUtils.equals("Orientation", obj)) {
                                if (i2 < 100) {
                                    char c2 = 65535;
                                    switch (obj.hashCode()) {
                                        case -2093253645:
                                            if (obj.equals("PixelYDimension")) {
                                                c2 = 3;
                                                break;
                                            }
                                            break;
                                        case -1896740140:
                                            if (obj.equals("PixelXDimension")) {
                                                c2 = 1;
                                                break;
                                            }
                                            break;
                                        case -666122239:
                                            if (obj.equals("ImageLength")) {
                                                c2 = 2;
                                                break;
                                            }
                                            break;
                                        case 542970187:
                                            if (obj.equals("ImageWidth")) {
                                                c2 = 0;
                                                break;
                                            }
                                            break;
                                    }
                                    if (c2 != 0) {
                                        if (c2 != 1) {
                                            if (c2 != 2) {
                                                if (c2 == 3) {
                                                }
                                            }
                                        }
                                    }
                                }
                                if (attribute != null) {
                                    i4.setAttribute(obj, attribute);
                                }
                            }
                        }
                    }
                    i4.saveAttributes();
                    return true;
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    public static boolean d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, file)) == null) {
            if (file.getParentFile().exists()) {
                return true;
            }
            return file.getParentFile().mkdirs();
        }
        return invokeL.booleanValue;
    }

    public static Bitmap e(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            try {
                return MediaStore.Images.Media.getBitmap(d.a.q0.a.a2.d.g().getContentResolver(), uri);
            } catch (Exception e2) {
                if (f51410a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        ExifInterface i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (i2 = i(str)) == null) {
                return 0;
            }
            int attributeInt = i2.getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        }
        return invokeL.intValue;
    }

    public static Bitmap g(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, drawable)) == null) {
            if (drawable == null) {
                return null;
            }
            return h(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap h(Drawable drawable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, drawable, i2, i3)) == null) {
            Bitmap bitmap = null;
            if (drawable != null && i2 > 0 && i3 > 0) {
                try {
                    bitmap = Bitmap.createBitmap(i2, i3, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                    if (bitmap != null) {
                        Canvas canvas = new Canvas(bitmap);
                        drawable.setBounds(0, 0, i2, i3);
                        drawable.draw(canvas);
                    }
                } catch (Exception | OutOfMemoryError e2) {
                    e2.printStackTrace();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static ExifInterface i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new ExifInterface(str);
            } catch (IOException unused) {
                return null;
            }
        }
        return (ExifInterface) invokeL.objValue;
    }

    public static int[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            int[] iArr = new int[1];
            GLES10.glGetIntegerv(3379, iArr, 0);
            if (iArr[0] != 0) {
                return iArr;
            }
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            egl10.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, ZeusMonitorType.MONITOR_TYPE_NETINJECT_DETECT_COUNT, 0, ZeusMonitorType.MONITOR_TYPE_MULTI_PERFORMANCE_TIMING, 1, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, eGLConfigArr, 1, new int[1]);
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLSurface eglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, ZeusMonitorType.MONITOR_TYPE_AD_FILTER});
            EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 1, ZeusMonitorType.MONITOR_TYPE_AD_FILTER});
            egl10.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
            GLES10.glGetIntegerv(3379, iArr, 0);
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
            egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
            egl10.eglTerminate(eglGetDisplay);
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public static File k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? l(d.a.q0.a.g1.f.V().I().k(), str) : (File) invokeL.objValue;
    }

    public static File l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            if (f51410a) {
                Log.d("ImageUtils", "获取temp路径");
            }
            String str3 = "swan_tmp_" + System.currentTimeMillis() + "_" + str2;
            File file = null;
            if (!TextUtils.isEmpty(str)) {
                File file2 = new File(str);
                if (file2.exists()) {
                    file = new File(file2, str3);
                } else if (file2.mkdirs()) {
                    file = new File(file2, str3);
                }
                if (file != null && !file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e2) {
                        if (f51410a) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if (f51410a && file != null) {
                Log.e("ImageUtils", "temp路径:" + file.getAbsolutePath());
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public static Uri m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://") && !str.startsWith("content://")) {
                if (str.startsWith("/")) {
                    return Uri.fromFile(new File(str));
                }
                return null;
            }
            return Uri.parse(str);
        }
        return (Uri) invokeL.objValue;
    }

    public static boolean n(File file, File file2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLI = interceptable.invokeLLI(65550, null, file, file2, i2)) != null) {
            return invokeLLI.booleanValue;
        }
        if (f51410a) {
            Log.d("ImageUtils", "rotateAndCompressImage");
        }
        if (file2 == null || file == null || !file.exists() || !file2.exists()) {
            if (f51410a) {
                Log.e("ImageUtils", "dest file or sourceFile is null");
            }
            return false;
        } else if (i2 >= 0 && i2 <= 100) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                    if (decodeFile != null && decodeFile.getWidth() != 0 && decodeFile.getHeight() != 0) {
                        int f2 = f(file.getAbsolutePath());
                        if (f2 != 0) {
                            Matrix matrix = new Matrix();
                            matrix.postRotate(f2);
                            decodeFile = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        try {
                            decodeFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream2);
                            d.a.q0.t.d.d(fileOutputStream2);
                            c(file.getAbsolutePath(), file2.getAbsolutePath(), i2);
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            if (f51410a) {
                                Log.e("ImageUtils", "rotateAndCompressImage fail:", e);
                            }
                            d.a.q0.t.d.d(fileOutputStream);
                            return false;
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            fileOutputStream = fileOutputStream2;
                            if (f51410a) {
                                Log.e("ImageUtils", "rotateAndCompressImage fail:", e);
                            }
                            d.a.q0.t.d.d(fileOutputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            d.a.q0.t.d.d(fileOutputStream);
                            throw th;
                        }
                    }
                    if (f51410a) {
                        Log.e("ImageUtils", "compress image，but decode bitmap is null");
                    }
                    d.a.q0.t.d.d(null);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
            } catch (OutOfMemoryError e5) {
                e = e5;
            }
        } else {
            if (f51410a) {
                Log.e("ImageUtils", "quality must be 0..100");
            }
            return false;
        }
    }

    public static boolean o(Bitmap bitmap, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65551, null, bitmap, str, i2)) == null) ? p(bitmap, str, i2, Bitmap.CompressFormat.JPEG) : invokeLLI.booleanValue;
    }

    public static boolean p(Bitmap bitmap, String str, int i2, Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65552, null, bitmap, str, i2, compressFormat)) == null) {
            if (compressFormat == null) {
                compressFormat = Bitmap.CompressFormat.JPEG;
            }
            boolean z = false;
            if (d.a.q0.t.d.v()) {
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        File file = new File(str);
                        if (!d(file)) {
                            d.a.q0.t.d.d(null);
                            return false;
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        if (bitmap != null) {
                            try {
                                z = bitmap.compress(compressFormat, i2, fileOutputStream2);
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                if (f51410a) {
                                    Log.e("ImageUtils", "保存图片失败", e);
                                }
                                d.a.q0.t.d.d(fileOutputStream);
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                d.a.q0.t.d.d(fileOutputStream);
                                throw th;
                            }
                        }
                        d.a.q0.t.d.d(fileOutputStream2);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                }
            }
            return z;
        }
        return invokeLLIL.booleanValue;
    }

    public static void q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) || str == null || context == null) {
            return;
        }
        File file = new File(str);
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }
}
