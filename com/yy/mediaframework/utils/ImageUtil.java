package com.yy.mediaframework.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.opengl.GLES20;
import android.os.Environment;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.yy.mediaframework.gpuimage.util.OpenGlUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
/* loaded from: classes4.dex */
public class ImageUtil {
    private static final String TAG = "ImageUtil";
    public static int mFileIndex = 1;
    private static final String sImageFiles = "YYImage";

    public static native int ABGRScaleClip(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr3, int i9, int i10, boolean z);

    public static native int ABGRToI420(byte[] bArr, int i, int i2, byte[] bArr2, int i3, boolean z);

    public static native int ARGBRatation(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public static native int ARGBToABGR(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4);

    public static native int ConvertToI420(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public static native int ConvertToI420Ex(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11);

    public static native int I420Scale(byte[] bArr, int i, int i2, int i3, byte[] bArr2, int i4, int i5, int i6, boolean z);

    public static native int I420ToABGR(byte[] bArr, int i, int i2, byte[] bArr2, int i3, boolean z);

    public static native int I420ToNV12(byte[] bArr, int i, int i2, int i3, byte[] bArr2, boolean z);

    public static native int I420ToNV21(byte[] bArr, byte[] bArr2, int i, int i2, boolean z);

    public static native int NV21ToARGB(byte[] bArr, int i, int i2, byte[] bArr2);

    public static native void RBGAtoYUV(byte[] bArr, int i, int i2, byte[] bArr2);

    public static native double psnrCoefRGBA2I420(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    public static native double psnrCoefRGBA2NV12(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    public static String getLogFileName() {
        String str = Environment.getExternalStorageDirectory().toString() + File.separator + sImageFiles;
        File file = new File(str);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        StringBuilder append = new StringBuilder().append(str).append(File.separator).append("Image-").append(Thread.currentThread().getId());
        int i = mFileIndex;
        mFileIndex = i + 1;
        return append.append(i).toString();
    }

    public static void LogImage2Files(final byte[] bArr, final String str) {
        new Thread(new Runnable() { // from class: com.yy.mediaframework.utils.ImageUtil.1
            @Override // java.lang.Runnable
            public void run() {
                File file = new File(ImageUtil.getLogFileName() + "." + str);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(bArr, 0, bArr.length);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        YMFLog.error((Object) null, "[Util    ]", "LogImage2Files exception:" + e.getMessage());
                    }
                }
            }
        }, "YY_yyvideolib_LogImage2Files_Thread").start();
    }

    public static void saveYUV2File(final byte[] bArr, int i, int i2) {
        new Thread(new Runnable() { // from class: com.yy.mediaframework.utils.ImageUtil.2
            @Override // java.lang.Runnable
            public void run() {
                File file = new File(ImageUtil.getLogFileName() + ".yuv");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        YMFLog.error((Object) null, "[Util    ]", "saveYUV2JPEG exception:" + e.getMessage());
                    }
                }
            }
        }, "YY_yyvideolib_saveYUV2JPEG_Thread").start();
    }

    public static void saveYUV2FileWithName(final ByteBuffer byteBuffer, final String str, final int i, final int i2) {
        new Thread(new Runnable() { // from class: com.yy.mediaframework.utils.ImageUtil.3
            @Override // java.lang.Runnable
            public void run() {
                File file = new File(ImageUtil.getLogFileName() + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2 + ".yuv");
                if (!file.exists()) {
                    try {
                        byte[] bArr = new byte[((i * i2) * 3) / 2];
                        byteBuffer.rewind();
                        byteBuffer.get(bArr);
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        YMFLog.error((Object) null, "[Util    ]", "saveYUV2FileWithName exception:" + e.getMessage());
                    }
                }
            }
        }, "YY_yyvideolib_saveYUV2JPEG_Thread").start();
    }

    public static void saveYUV2JPEG(final byte[] bArr, final int i, final int i2) {
        new Thread(new Runnable() { // from class: com.yy.mediaframework.utils.ImageUtil.4
            @Override // java.lang.Runnable
            public void run() {
                File file = new File(ImageUtil.getLogFileName() + ".jpg");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 70, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        YMFLog.error((Object) null, "[Util    ]", "saveYUV2JPEG exception:" + e.getMessage());
                    }
                }
            }
        }, "YY_yyvideolib_saveYUV2JPEG_Thread").start();
    }

    public static Bitmap createImgae(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        return createBitmap;
    }

    public static void saveToFile(final Bitmap bitmap, final boolean z) {
        new Thread(new Runnable() { // from class: com.yy.mediaframework.utils.ImageUtil.5
            /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF] complete} */
            @Override // java.lang.Runnable
            public void run() {
                FileOutputStream fileOutputStream;
                String str = ImageUtil.getLogFileName() + "rbg.jpg";
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (FileNotFoundException e) {
                    YMFLog.error((Object) null, "[Util    ]", String.format(Locale.getDefault(), "%s not found, exception:%s", str, e.toString()));
                    fileOutputStream = null;
                }
                if (fileOutputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    try {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            if (z) {
                                bitmap.recycle();
                            }
                        } catch (IOException e2) {
                            YMFLog.error((Object) null, "[Util    ]", "save to file exception:" + e2.toString());
                            if (z) {
                                bitmap.recycle();
                            }
                        }
                    } catch (Throwable th) {
                        if (z) {
                            bitmap.recycle();
                        }
                        throw th;
                    }
                }
            }
        }, "YY_yyvideolib_saveToFile_Thread").start();
    }

    public static void save2DTextureToJPEG(int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        if (iArr[0] != 0 && i != 0 && i2 > 0 && i3 > 0) {
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2 * i3 * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, allocateDirect);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            if (createBitmap != null) {
                createBitmap.copyPixelsFromBuffer(allocateDirect);
                saveToFile(createBitmap, true);
            }
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
    }

    public static void SaveEGLSurfaceToJpeg(int i, int i2) {
        OpenGlUtils.checkGlError("SaveEGLSurfaceToJpeg  enter... ");
        GLES20.glBindFramebuffer(36160, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * i2 * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, allocateDirect);
        OpenGlUtils.checkGlError("glReadPixels ");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        if (createBitmap != null) {
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            saveToFile(createBitmap, true);
        }
        OpenGlUtils.checkGlError("SaveEGLSurfaceToJpeg  out... ");
    }

    public static void saveRGBAToFile(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        if (createBitmap != null) {
            createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
            saveToFile(createBitmap, true);
        }
    }

    public static String getImageFormatName(int i) {
        switch (i) {
            case 0:
                return "NV21";
            case 1:
                return "NV12";
            case 2:
                return "I420";
            case 3:
                return "YV12";
            case 36:
                return "RGBA";
            default:
                return "";
        }
    }
}
