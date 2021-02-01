package com.yy.mediaframework.gpuimage;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.yy.mediaframework.gpuimage.custom.IGPUProcess;
import com.yy.mediaframework.gpuimage.custom.OF_EffectInfo;
import com.yy.mediaframework.gpuimage.util.OpenGlUtils;
import com.yy.mediaframework.utils.YMFLog;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
/* loaded from: classes4.dex */
public class GPUImageFilter {
    public static final String NO_FILTER_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
    public static final String NO_FILTER_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}";
    private static final String TAG = "GPUImageFilter";
    private boolean m2DTextureEnable;
    private String mFragmentShader;
    protected int mGLAttribPosition;
    protected int mGLAttribTextureCoordinate;
    protected int mGLProgId;
    protected int mGLUniformTexture;
    protected int mImageHeight;
    protected int mImageWidth;
    protected boolean mIsInitialized;
    protected int mOutputHeight;
    protected int mOutputWidth;
    private final LinkedList<Runnable> mRunOnDraw;
    protected int mTextureTarget;
    private final String mVertexShader;
    private int muTexMatrixLoc;

    public GPUImageFilter() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public GPUImageFilter(String str, String str2) {
        this.m2DTextureEnable = false;
        this.mRunOnDraw = new LinkedList<>();
        this.mVertexShader = str;
        this.mFragmentShader = str2;
    }

    public final void init() {
        onInitExt(false);
        onInit();
        this.mIsInitialized = true;
        onInitialized();
    }

    public String getFragmentShader() {
        return this.mFragmentShader;
    }

    public void setFragmentShader(String str) {
        this.mFragmentShader = str;
    }

    public final void initForExternalTextureInput(boolean z) {
        YMFLog.info(this, "[Util    ]", "initForExternalTextureInput:" + z);
        onInitExt(z);
        onInit();
        this.mIsInitialized = true;
        onInitialized();
    }

    public void onInit() {
        YMFLog.info(this, "[Util    ]", "onInit");
    }

    @TargetApi(15)
    public void onInitExt(boolean z) {
        YMFLog.info(this, "[Util    ]", "onInitExt:" + z);
        String str = this.mFragmentShader;
        this.mTextureTarget = 3553;
        if (z) {
            this.mTextureTarget = 36197;
            str = "#extension GL_OES_EGL_image_external : require\n" + this.mFragmentShader.replace("uniform sampler2D inputImageTexture;", "uniform samplerExternalOES inputImageTexture;");
        }
        this.mGLProgId = OpenGlUtils.loadProgram(this.mVertexShader, str);
        this.mGLAttribPosition = GLES20.glGetAttribLocation(this.mGLProgId, "position");
        this.mGLUniformTexture = GLES20.glGetUniformLocation(this.mGLProgId, "inputImageTexture");
        this.mGLAttribTextureCoordinate = GLES20.glGetAttribLocation(this.mGLProgId, "inputTextureCoordinate");
        this.muTexMatrixLoc = GLES20.glGetUniformLocation(this.mGLProgId, "uTexMatrix");
        this.mIsInitialized = true;
    }

    public void onInitialized() {
        YMFLog.info(this, "[Util    ]", "onInitialized");
    }

    public final void destroy() {
        YMFLog.info(this, "[Util    ]", "destroy");
        this.mIsInitialized = false;
        GLES20.glDeleteProgram(this.mGLProgId);
        onDestroy();
    }

    public void onDestroy() {
    }

    public void onOutputSizeChanged(int i, int i2) {
        YMFLog.info(this, "[Util    ]", "onOutputSizeChanged width:" + i + " ,height:" + i2);
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public void checkTextureTypeUpdate(int i) {
    }

    public void onImageSizeChanged(int i, int i2) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
    }

    public int getLastTextureID() {
        return -1;
    }

    public void onDraw(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i2, float[] fArr, boolean z, byte[] bArr, long j) {
        OpenGlUtils.checkGlError("onDraw");
        GLES20.glUseProgram(this.mGLProgId);
        runPendingOnDrawTasks();
        if (!this.mIsInitialized) {
            YMFLog.debug(this, "[Util    ]", "onDraw mIsInitialized false");
            return;
        }
        OpenGlUtils.checkGlError("glUseProgram");
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
        OpenGlUtils.checkGlError("glEnableVertexAttribArray");
        GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, fArr, 0);
        OpenGlUtils.checkGlError("glUniformMatrix4fv");
        if (i != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(i2, i);
            OpenGlUtils.checkGlError("glBindTexture");
        }
        onDrawArraysPre(i, floatBuffer, floatBuffer2, i2, fArr);
        OpenGlUtils.checkGlError("onDrawArraysPre");
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
        GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
        GLES20.glBindTexture(i2, 0);
        OpenGlUtils.checkGlError("glBindTexture");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDrawArraysPre(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i2, float[] fArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public int getProgram() {
        return this.mGLProgId;
    }

    public int getAttribPosition() {
        return this.mGLAttribPosition;
    }

    public int getAttribTextureCoordinate() {
        return this.mGLAttribTextureCoordinate;
    }

    public int getUniformTexture() {
        return this.mGLUniformTexture;
    }

    protected void setInteger(final int i, final int i2) {
        runOnDraw(new Runnable() { // from class: com.yy.mediaframework.gpuimage.GPUImageFilter.1
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1i(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFloat(final int i, final float f) {
        runOnDraw(new Runnable() { // from class: com.yy.mediaframework.gpuimage.GPUImageFilter.2
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1f(i, f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFloatVec2(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.yy.mediaframework.gpuimage.GPUImageFilter.3
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    protected void setFloatVec3(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.yy.mediaframework.gpuimage.GPUImageFilter.4
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform3fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFloatVec4(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.yy.mediaframework.gpuimage.GPUImageFilter.5
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    protected void setFloatArray(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.yy.mediaframework.gpuimage.GPUImageFilter.6
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1fv(i, fArr.length, FloatBuffer.wrap(fArr));
            }
        });
    }

    protected void setPoint(final int i, final PointF pointF) {
        runOnDraw(new Runnable() { // from class: com.yy.mediaframework.gpuimage.GPUImageFilter.7
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform2fv(i, 1, new float[]{pointF.x, pointF.y}, 0);
            }
        });
    }

    protected void setUniformMatrix3f(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.yy.mediaframework.gpuimage.GPUImageFilter.8
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniformMatrix3fv(i, 1, false, fArr, 0);
            }
        });
    }

    protected void setUniformMatrix4f(final int i, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.yy.mediaframework.gpuimage.GPUImageFilter.9
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnDraw(Runnable runnable) {
        if (this.mIsInitialized) {
            synchronized (this.mRunOnDraw) {
                this.mRunOnDraw.addLast(runnable);
            }
        }
    }

    public static String loadShader(String str, Context context) {
        try {
            InputStream open = context.getAssets().open(str);
            String convertStreamToString = convertStreamToString(open);
            open.close();
            return convertStreamToString;
        } catch (Exception e) {
            YMFLog.info(null, "[Util    ]", "loadShader exception:" + e.getMessage());
            return "";
        }
    }

    public static String convertStreamToString(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public void enable2DTextureDraw(boolean z) {
        this.m2DTextureEnable = z;
    }

    public void setEncodeSize(int i, int i2) {
    }

    public void setWitnessFilterPath(String str) {
    }

    public void setLookupTablePath(String str) {
    }

    public void setBeauty5Effect(String str) {
    }

    public void setBeautyParam(float f) {
    }

    public void setStickerEffect(String str) {
    }

    public void setNewStickerEffect(String str, String str2) {
    }

    public void setGiftEffect(String str) {
    }

    public void setJoyPkEffect(String str, int i, String str2) {
    }

    public void removeJoyPkEffectWithTag(String str) {
    }

    public void isAnimationTagExist(String str) {
    }

    public void setFaceLiftValue(Map<Integer, Float> map) {
    }

    public void setFaceLiftValueOpt(Map<Integer, Float> map) {
    }

    public void setThinFaceParam(float f) {
    }

    public void setStickerEffectParam(float f) {
    }

    public void onBeautyParamChanged() {
    }

    public float getStickerEffectParam() {
        return 0.0f;
    }

    public OF_EffectInfo getOfEffectInfo() {
        return null;
    }

    public void setGPUImageBeautyFilter(IGPUProcess iGPUProcess) {
    }
}
