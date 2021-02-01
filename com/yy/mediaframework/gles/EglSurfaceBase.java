package com.yy.mediaframework.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.baidu.mobstat.Config;
import com.yy.mediaframework.utils.YMFLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
@TargetApi(17)
/* loaded from: classes4.dex */
public class EglSurfaceBase implements IEglSurfaceBase {
    protected static final String TAG = "GlUtil";
    protected EglCore mEglCore;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    private int mWidth = -1;
    private int mHeight = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public EglSurfaceBase(EglCore eglCore) {
        this.mEglCore = eglCore;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    @TargetApi(17)
    public void createWindowSurface(Object obj) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.mEglCore.createWindowSurface(obj);
        YMFLog.info(this, "[Procedur]", "createWindowSurface:" + this.mEGLSurface);
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    @TargetApi(17)
    public void createOffscreenSurface(int i, int i2) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.mEglCore.createOffscreenSurface(i, i2);
        YMFLog.info(this, "[Procedur]", "createOffscreenSurface:" + this.mEGLSurface);
        this.mWidth = i;
        this.mHeight = i2;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public int getWidth() {
        return this.mWidth < 0 ? this.mEglCore.querySurface(this.mEGLSurface, 12375) : this.mWidth;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public int getHeight() {
        return this.mHeight < 0 ? this.mEglCore.querySurface(this.mEGLSurface, 12374) : this.mHeight;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    @TargetApi(17)
    public void releaseEglSurface() {
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public void makeCurrent() {
        this.mEglCore._makeCurrent(this.mEGLSurface);
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public boolean isCurrent() {
        return this.mEglCore._isCurrent(this.mEGLSurface);
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public void makeCurrentReadFrom(Object obj) {
        if (obj instanceof EglSurfaceBaseKhronos) {
            this.mEglCore._makeCurrent(this.mEGLSurface, ((EglSurfaceBase) obj).mEGLSurface);
            return;
        }
        throw new RuntimeException("makeCurrentReadFrom readSurface is not getInstance of  EglSurfaceBase");
    }

    public void makeCurrentReadFrom(EglSurfaceBase eglSurfaceBase) {
        this.mEglCore._makeCurrent(this.mEGLSurface, eglSurfaceBase.mEGLSurface);
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public boolean swapBuffers() {
        boolean swapBuffers = this.mEglCore.swapBuffers(this.mEGLSurface);
        if (!swapBuffers) {
            YMFLog.error(this, "[Procedur]", "WARNING: swapBuffers() failed");
        }
        return swapBuffers;
    }

    @Override // com.yy.mediaframework.gles.IEglSurfaceBase
    public void setPresentationTime(long j) {
        this.mEglCore._setPresentationTime(this.mEGLSurface, j);
    }

    public void saveFrame(File file) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        if (!this.mEglCore.isCurrent(this.mEGLSurface)) {
            throw new RuntimeException("Expected EGL context/surface is not current");
        }
        String file2 = file.toString();
        int width = getWidth();
        int height = getHeight();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, width, height, 6408, 5121, allocateDirect);
        GlUtil.checkGlError("glReadPixels");
        allocateDirect.rewind();
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            createBitmap.compress(Bitmap.CompressFormat.PNG, 90, bufferedOutputStream);
            createBitmap.recycle();
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    YMFLog.error(this, "[Procedur]", "close BufferedOutputStream failed:" + e);
                }
            }
            YMFLog.debug(this, "[Procedur]", "Saved " + width + Config.EVENT_HEAT_X + height + " frame as '" + file2 + "'");
        } catch (Throwable th2) {
            th = th2;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                    YMFLog.error(this, "[Procedur]", "close BufferedOutputStream failed:" + e2);
                    throw th;
                }
            }
            throw th;
        }
    }

    public EGLSurface getEGLSurface() {
        return this.mEGLSurface;
    }
}
