package com.yy.mediaframework.utils;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Environment;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.gpuimage.util.GLShaderProgram;
import com.yy.mediaframework.gpuimage.util.TextureRotationUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;
/* loaded from: classes4.dex */
public class OESTO2DTool {
    public static String fragmentShader = "#extension GL_OES_EGL_image_external : require                     \nprecision mediump float;                                           \nvarying vec2 vTexCoord;                                            \nuniform samplerExternalOES uTexture0;                              \nvoid main()                                                        \n{                                                                  \n    vec4 color = texture2D(uTexture0, vTexCoord);                  \n    gl_FragColor = color; //vec4(color.y, color.y, color.y, 1.0);  \n}";
    public static final String vertexShader = "attribute vec4 aPosition;          \nattribute vec4 aTextureCoord;      \nvarying vec2 vTexCoord;            \nvoid main()                        \n{                                  \n    gl_Position = aPosition;       \n    vTexCoord = aTextureCoord.xy;  \n}";
    private int mFrameBuffer;
    private FloatBuffer mGLTextureBuffer;
    private FloatBuffer mMasterVertexBuffer;
    private GLShaderProgram mShaderProgram;
    private int mTexture2d = -1;
    private ByteBuffer snapByteBuffer = null;
    private int mSnapIndex = 0;
    private String mSnapShotPath = Environment.getExternalStorageDirectory().getPath() + "/YYImage";
    private String mFileNamePrefix = "snap";
    private int mQuality = 50;
    private final float[] CUBE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    static /* synthetic */ int access$008(OESTO2DTool oESTO2DTool) {
        int i = oESTO2DTool.mSnapIndex;
        oESTO2DTool.mSnapIndex = i + 1;
        return i;
    }

    public OESTO2DTool() {
        this.mFrameBuffer = -1;
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.mFrameBuffer = iArr[0];
        this.mShaderProgram = new GLShaderProgram();
        this.mShaderProgram.setProgram(vertexShader, fragmentShader);
        this.mMasterVertexBuffer = ByteBuffer.allocateDirect(this.CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mMasterVertexBuffer.put(this.CUBE).position(0);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.FULL_RECTANGLE_TEX_COORDS.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(TextureRotationUtil.TEXTURE_ROTATED_90).position(0);
        this.mGLTextureBuffer = GlUtil.setFlipY(asFloatBuffer);
        if (this.mSnapShotPath != null) {
            File file = new File(this.mSnapShotPath);
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                YMFLog.error(this, "[Util    ]", "mkdirs " + this.mSnapShotPath + " failed !");
            }
        }
    }

    public void release() {
        if (this.mFrameBuffer != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.mFrameBuffer}, 0);
            this.mFrameBuffer = -1;
        }
        if (this.mShaderProgram != null) {
            this.mShaderProgram.destory();
            this.mShaderProgram = null;
        }
        if (this.mMasterVertexBuffer != null) {
            this.mMasterVertexBuffer.clear();
            this.mMasterVertexBuffer = null;
        }
        if (this.mGLTextureBuffer != null) {
            this.mGLTextureBuffer.clear();
            this.mGLTextureBuffer = null;
        }
        if (this.mTexture2d != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.mTexture2d}, 0);
            this.mTexture2d = -1;
        }
        if (this.snapByteBuffer != null) {
            this.snapByteBuffer.clear();
            this.snapByteBuffer = null;
        }
    }

    public void saveOESTextureToJPEG(int i, int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        if (this.mTexture2d == -1) {
            this.mTexture2d = GLUtil.genTexture(3553, i2, i3);
        }
        if (this.snapByteBuffer == null) {
            this.snapByteBuffer = ByteBuffer.allocate(i2 * i3 * 4);
            this.snapByteBuffer.order(ByteOrder.nativeOrder());
        }
        GLES20.glBindFramebuffer(36160, this.mFrameBuffer);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mTexture2d, 0);
        this.mShaderProgram.useProgram();
        this.mShaderProgram.setUniformTexture("uTexture0", 0, i, 36197);
        this.mMasterVertexBuffer.position(0);
        this.mGLTextureBuffer.position(0);
        this.mShaderProgram.setVertexAttribPointer("aPosition", 2, 5126, false, 0, this.mMasterVertexBuffer);
        this.mShaderProgram.setVertexAttribPointer("aTextureCoord", 2, 5126, false, 0, this.mGLTextureBuffer);
        GLES20.glDrawArrays(5, 0, 4);
        if (this.snapByteBuffer != null) {
            this.snapByteBuffer.clear();
            this.snapByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, this.snapByteBuffer);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(this.snapByteBuffer);
            saveToFile(createBitmap);
        }
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void saveToFile(final Bitmap bitmap) {
        new Thread(new Runnable() { // from class: com.yy.mediaframework.utils.OESTO2DTool.1
            @Override // java.lang.Runnable
            public void run() {
                FileOutputStream fileOutputStream;
                OESTO2DTool.access$008(OESTO2DTool.this);
                String str = OESTO2DTool.this.mSnapShotPath + File.separator + OESTO2DTool.this.mFileNamePrefix + String.format("%03d", Integer.valueOf(OESTO2DTool.this.mSnapIndex)) + ".jpg";
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (FileNotFoundException e) {
                    YMFLog.error(this, "[Util    ]", String.format(Locale.getDefault(), "%s not found, exception:%s", str, e.toString()));
                    fileOutputStream = null;
                }
                if (fileOutputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, OESTO2DTool.this.mQuality, fileOutputStream);
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        YMFLog.error(this, "[Util    ]", "save to file exception:" + e2.toString());
                    } finally {
                        bitmap.recycle();
                    }
                }
            }
        }).start();
    }

    public int ConvertOES(int i, int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        int genTexture = GLUtil.genTexture(3553, i2, i3);
        GLES20.glBindFramebuffer(36160, this.mFrameBuffer);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, genTexture, 0);
        this.mShaderProgram.useProgram();
        this.mShaderProgram.setUniformTexture("uTexture0", 0, i, 36197);
        this.mMasterVertexBuffer.position(0);
        this.mGLTextureBuffer.position(0);
        this.mShaderProgram.setVertexAttribPointer("aPosition", 2, 5126, false, 0, this.mMasterVertexBuffer);
        this.mShaderProgram.setVertexAttribPointer("aTextureCoord", 2, 5126, false, 0, this.mGLTextureBuffer);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        return genTexture;
    }

    public int ConvertOES(int i, int i2, int i3, int i4) {
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glBindFramebuffer(36160, this.mFrameBuffer);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i4, 0);
        this.mShaderProgram.useProgram();
        this.mShaderProgram.setUniformTexture("uTexture0", 0, i, 36197);
        this.mMasterVertexBuffer.position(0);
        this.mGLTextureBuffer.position(0);
        this.mShaderProgram.setVertexAttribPointer("aPosition", 2, 5126, false, 0, this.mMasterVertexBuffer);
        this.mShaderProgram.setVertexAttribPointer("aTextureCoord", 2, 5126, false, 0, this.mGLTextureBuffer);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        return i4;
    }
}
