package d.b.g0.a.i2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.opengl.GLES10;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.wallet.base.camera.util.ImageUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.webrtc.EglBase10;
/* loaded from: classes3.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45176a = d.b.g0.a.k.f45443a;

    public static boolean a(File file, File file2, int i) {
        FileOutputStream fileOutputStream;
        if (f45176a) {
            Log.d(ImageUtils.TAG, "压缩图片");
        }
        if (file2 == null) {
            if (f45176a) {
                Log.e(ImageUtils.TAG, "dest file is null");
            }
            return false;
        } else if (i >= 0 && i <= 100) {
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (decodeFile == null) {
                if (f45176a) {
                    Log.e(ImageUtils.TAG, "compress image，but decode bitmap is null");
                }
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            }
            try {
                decodeFile.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                d.b.g0.p.d.a(fileOutputStream);
                return true;
            } catch (FileNotFoundException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                if (f45176a) {
                    Log.e(ImageUtils.TAG, "压缩图片失败", e);
                }
                d.b.g0.p.d.a(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                d.b.g0.p.d.a(fileOutputStream2);
                throw th;
            }
        } else {
            if (f45176a) {
                Log.e(ImageUtils.TAG, "quality must be 0..100");
            }
            return false;
        }
    }

    public static int[] b() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        if (iArr[0] != 0) {
            return iArr;
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        egl10.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, 12329, 0, 12339, 1, 12344}, eGLConfigArr, 1, new int[1]);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLSurface eglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344});
        EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 1, 12344});
        egl10.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
        GLES10.glGetIntegerv(3379, iArr, 0);
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        egl10.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
        egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
        egl10.eglTerminate(eglGetDisplay);
        return iArr;
    }

    public static File c(String str) {
        return d(d.b.g0.a.z0.f.V().y().j(), str);
    }

    public static File d(String str, String str2) {
        if (f45176a) {
            Log.d(ImageUtils.TAG, "获取temp路径");
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
                    if (f45176a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (f45176a && file != null) {
            Log.e(ImageUtils.TAG, "temp路径:" + file.getAbsolutePath());
        }
        return file;
    }

    public static Uri e(String str) {
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
}
