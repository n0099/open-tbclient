package com.yy.mediaframework.gles;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class Texture2dProgram {
    private static final String FRAGMENT_SHADER_2D = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_2D_WITH_EXTRA_TXT = "precision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec2 vExtraTextureCoord;\nuniform sampler2D uTexture;\nuniform sampler2D uExtraTexture;\nuniform int uExtraTxtEnabled;\n\nvoid main() {\n    if (uExtraTxtEnabled == 1) {\n       vec4 base = texture2D(uTexture, vTextureCoord);\n       vec4 overlay = texture2D(uExtraTexture, vExtraTextureCoord);\n       vec4 outputColor;\n       outputColor.r = overlay.r + base.r * base.a * (1.0 - overlay.a);\n       outputColor.g = overlay.g + base.g * base.a * (1.0 - overlay.a);\n       outputColor.b = overlay.b + base.b * base.a * (1.0 - overlay.a);\n       outputColor.a = overlay.a + base.a * (1.0 - overlay.a);\n       gl_FragColor = outputColor;\n    }\n    else {\n        gl_FragColor = texture2D(uTexture, vTextureCoord);\n    }\n}";
    private static final String FRAGMENT_SHADER_2D_WITH_EXTRA_TXT_2 = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec2 vExtraTextureCoord;\nvarying vec2 vExtraTextureCoord2;\nuniform sampler2D uTexture;\nuniform sampler2D uExtraTexture;\nuniform sampler2D uExtraTexture2;\nuniform int uExtraTxtEnabled;\nuniform int uExtraTxt2Enabled;\nuniform int uSlavePicEnabled;\n\nvoid main() {\n    vec4 outputColor = texture2D(uTexture, vTextureCoord);\n    if (uExtraTxt2Enabled == 1) {\n        vec4 overlay2 = texture2D(uExtraTexture2, vExtraTextureCoord2);\n        outputColor.r = overlay2.r * overlay2.a + outputColor.r * outputColor.a * (1.0 - overlay2.a);\n        outputColor.g = overlay2.g * overlay2.a + outputColor.g * outputColor.a * (1.0 - overlay2.a);\n        outputColor.b = overlay2.b * overlay2.a + outputColor.b * outputColor.a * (1.0 - overlay2.a);\n        outputColor.a = overlay2.a + outputColor.a - overlay2.a * outputColor.a;\n    }\n    if (uExtraTxtEnabled == 1) {\n        vec4 overlay = texture2D(uExtraTexture, vExtraTextureCoord);\n        outputColor.r = overlay.r + outputColor.r * (1.0 - overlay.a);\n        outputColor.g = overlay.g + outputColor.g * (1.0 - overlay.a);\n        outputColor.b = overlay.b + outputColor.b * (1.0 - overlay.a);\n        outputColor.a = overlay.a + outputColor.a - overlay.a * outputColor.a;\n    }\n    gl_FragColor = outputColor;\n}";
    private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_BW = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_FILT = "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n";
    public static final int KERNEL_SIZE = 9;
    static final float[] SLAVE_VEX_RIGHT_BOTTOM = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, -1.0f};
    private static final String TAG = "GlUtil";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private static final String VERTEX_SHADER_WITH_EXTRA_TXT = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nattribute vec4 aExtraTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec2 vExtraTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vExtraTextureCoord = vec2(aExtraTextureCoord.x, aExtraTextureCoord.y);\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}";
    private static final String VERTEX_SHADER_WITH_EXTRA_TXT_2 = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nattribute vec4 aExtraTextureCoord;\nattribute vec4 aExtraTextureCoord2;\nvarying vec2 vTextureCoord;\nvarying vec2 vExtraTextureCoord;\nvarying vec2 vExtraTextureCoord2;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vExtraTextureCoord = vec2(aExtraTextureCoord.x, aExtraTextureCoord.y);\n    vExtraTextureCoord2 = vec2(aExtraTextureCoord2.x, aExtraTextureCoord2.y);\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}";
    private float mColorAdjust;
    private float[] mKernel = new float[9];
    private int mProgramHandle;
    private ProgramType mProgramType;
    private int mSlaveProgramHandle;
    private final FloatBuffer mSlaveVertexBuffer;
    private float[] mTexOffset;
    private int mTextureTarget;
    private int maExtraTextureCoord2Loc;
    private int maExtraTextureCoordLoc;
    private int maPositionLoc;
    private int maSlavePicPositionLoc;
    private int maSlavePicTextureCoordLoc;
    private int maTextureCoordLoc;
    private int muColorAdjustLoc;
    private int muExtraTexture2EnableLoc;
    private int muExtraTexture2Loc;
    private int muExtraTextureEnableLoc;
    private int muExtraTextureLoc;
    private int muKernelLoc;
    private int muMVPMatrixLoc;
    private int muSlavePicMVPMatrixLoc;
    private int muSlavePicTexMatrixLoc;
    private int muSlavePicTextureLoc;
    private int muTexMatrixLoc;
    private int muTexOffsetLoc;
    private int muTextureLoc;

    /* loaded from: classes6.dex */
    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_2D_WITH_EXTRA_TXT,
        TEXTURE_2D_WITH_EXTRA_TXT_2,
        TEXTURE_EXT,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_FILT
    }

    public Texture2dProgram(ProgramType programType) {
        this.mProgramType = programType;
        switch (programType) {
            case TEXTURE_2D:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_2D);
                break;
            case TEXTURE_2D_WITH_EXTRA_TXT:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER_WITH_EXTRA_TXT, FRAGMENT_SHADER_2D_WITH_EXTRA_TXT);
                break;
            case TEXTURE_2D_WITH_EXTRA_TXT_2:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER_WITH_EXTRA_TXT_2, FRAGMENT_SHADER_2D_WITH_EXTRA_TXT_2);
                this.mSlaveProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_EXT);
                break;
            case TEXTURE_EXT:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_EXT);
                break;
            case TEXTURE_EXT_BW:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_EXT_BW);
                break;
            case TEXTURE_EXT_FILT:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_EXT_FILT);
                break;
            default:
                throw new RuntimeException("Unhandled type " + programType);
        }
        if (this.mProgramHandle == 0) {
            throw new RuntimeException("Unable to create program");
        }
        YMFLog.info(this, "[Util    ]", "Created program " + this.mProgramHandle + " (" + programType + ")");
        this.maPositionLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
        GlUtil.checkLocation(this.maPositionLoc, "aPosition");
        this.maTextureCoordLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
        GlUtil.checkLocation(this.maTextureCoordLoc, "aTextureCoord");
        this.maSlavePicPositionLoc = GLES20.glGetAttribLocation(this.mSlaveProgramHandle, "aPosition");
        GlUtil.checkLocation(this.maSlavePicPositionLoc, "aPosition");
        this.maSlavePicTextureCoordLoc = GLES20.glGetAttribLocation(this.mSlaveProgramHandle, "aTextureCoord");
        GlUtil.checkLocation(this.maSlavePicTextureCoordLoc, "aTextureCoord");
        this.muMVPMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
        GlUtil.checkLocation(this.muMVPMatrixLoc, "uMVPMatrix");
        this.muTexMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        GlUtil.checkLocation(this.muTexMatrixLoc, "uTexMatrix");
        this.muSlavePicMVPMatrixLoc = GLES20.glGetUniformLocation(this.mSlaveProgramHandle, "uMVPMatrix");
        GlUtil.checkLocation(this.muSlavePicMVPMatrixLoc, "uMVPMatrix");
        this.muSlavePicTexMatrixLoc = GLES20.glGetUniformLocation(this.mSlaveProgramHandle, "uTexMatrix");
        GlUtil.checkLocation(this.muSlavePicTexMatrixLoc, "uTexMatrix");
        this.muExtraTextureEnableLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uExtraTxtEnabled");
        this.maExtraTextureCoordLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aExtraTextureCoord");
        this.muExtraTextureLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uExtraTexture");
        this.muExtraTexture2EnableLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uExtraTxt2Enabled");
        this.maExtraTextureCoord2Loc = GLES20.glGetAttribLocation(this.mProgramHandle, "aExtraTextureCoord2");
        this.muExtraTexture2Loc = GLES20.glGetUniformLocation(this.mProgramHandle, "uExtraTexture2");
        this.muTextureLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexture");
        this.muSlavePicTextureLoc = GLES20.glGetUniformLocation(this.mSlaveProgramHandle, "sTexture");
        this.muKernelLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uKernel");
        if (this.muKernelLoc < 0) {
            this.muKernelLoc = -1;
            this.muTexOffsetLoc = -1;
            this.muColorAdjustLoc = -1;
        } else {
            this.muTexOffsetLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexOffset");
            GlUtil.checkLocation(this.muTexOffsetLoc, "uTexOffset");
            this.muColorAdjustLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uColorAdjust");
            GlUtil.checkLocation(this.muColorAdjustLoc, "uColorAdjust");
            setKernel(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
            setTexSize(256, 256);
        }
        this.mSlaveVertexBuffer = ByteBuffer.allocateDirect(SLAVE_VEX_RIGHT_BOTTOM.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mSlaveVertexBuffer.put(SLAVE_VEX_RIGHT_BOTTOM).position(0);
    }

    public void release() {
        Log.d("GlUtil", "deleting program " + this.mProgramHandle);
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
    }

    public ProgramType getProgramType() {
        return this.mProgramType;
    }

    @TargetApi(15)
    public int createTextureObject() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(this.mTextureTarget, i);
        GlUtil.checkGlError("glBindTexture " + i);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        return i;
    }

    public void setKernel(float[] fArr, float f) {
        if (fArr.length != 9) {
            throw new IllegalArgumentException("Kernel size is " + fArr.length + " vs. 9");
        }
        System.arraycopy(fArr, 0, this.mKernel, 0, 9);
        this.mColorAdjust = f;
    }

    public void setTexSize(int i, int i2) {
        float f = 1.0f / i;
        float f2 = 1.0f / i2;
        this.mTexOffset = new float[]{-f, -f2, 0.0f, -f2, f, -f2, -f, 0.0f, 0.0f, 0.0f, f, 0.0f, -f, f2, 0.0f, f2, f, f2};
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        draw(fArr, floatBuffer, i, i2, i3, i4, fArr2, floatBuffer2, i5, i6, null, -1);
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6, FloatBuffer floatBuffer3, int i7) {
        draw(fArr, floatBuffer, i, i2, i3, i4, fArr2, floatBuffer2, i5, i6, floatBuffer3, i7, null, -1, null);
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6, FloatBuffer floatBuffer3, int i7, FloatBuffer floatBuffer4, int i8, float[] fArr3) {
        draw(fArr, floatBuffer, i, i2, i3, i4, fArr2, floatBuffer2, i5, i6, floatBuffer3, i7, floatBuffer4, i8);
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6, FloatBuffer floatBuffer3, int i7, FloatBuffer floatBuffer4, int i8) {
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, fArr, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, fArr2, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maPositionLoc, i3, 5126, false, i4, (Buffer) floatBuffer);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, i6, (Buffer) floatBuffer2);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i5);
        GLES20.glUniform1i(this.muTextureLoc, 0);
        if (this.muKernelLoc >= 0) {
            GLES20.glUniform1fv(this.muKernelLoc, 9, this.mKernel, 0);
            GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
            GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
        }
        if (this.muExtraTextureEnableLoc >= 0) {
            drawWaterMark(i7, i6, floatBuffer3);
        }
        if (this.muExtraTexture2EnableLoc >= 0) {
            drawSticker(i8, i6, floatBuffer4);
        }
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDrawArrays(5, i, i2);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glBindTexture(this.mTextureTarget, 0);
        GLES20.glUseProgram(0);
    }

    public void drawSlavePicture(int i, float[] fArr, float[] fArr2, float[] fArr3, int i2, int i3, int i4, int i5, int i6, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i < 0) {
            YMFLog.info(this, "[Util    ]", "invalid slavePicTextureId:" + i);
            return;
        }
        GLES20.glUseProgram(this.mSlaveProgramHandle);
        GLES20.glActiveTexture(33984);
        GlUtil.checkGlError("glActiveTexture");
        GLES20.glBindTexture(36197, i);
        GlUtil.checkGlError("glBindTexture");
        GLES20.glUniform1i(this.muSlavePicTextureLoc, 0);
        GLES20.glUniformMatrix4fv(this.muSlavePicMVPMatrixLoc, 1, false, fArr, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        if (fArr2 == null) {
            GLES20.glUniformMatrix4fv(this.muSlavePicTexMatrixLoc, 1, false, fArr3, 0);
        } else {
            GLES20.glUniformMatrix4fv(this.muSlavePicTexMatrixLoc, 1, false, fArr2, 0);
        }
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.maSlavePicPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        if (floatBuffer != null) {
            floatBuffer.rewind();
        }
        GLES20.glVertexAttribPointer(this.maSlavePicPositionLoc, i2, 5126, false, i3, (Buffer) (floatBuffer == null ? this.mSlaveVertexBuffer : floatBuffer));
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.maSlavePicTextureCoordLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maSlavePicTextureCoordLoc, 2, 5126, false, i4, (Buffer) floatBuffer2);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glDrawArrays(5, i5, i6);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maSlavePicPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maSlavePicTextureCoordLoc);
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
    }

    private String transform2String(float[] fArr) {
        StringBuilder sb = new StringBuilder();
        for (float f : fArr) {
            sb.append(String.valueOf(f));
            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        }
        return sb.toString();
    }

    private String transform2String(FloatBuffer floatBuffer) {
        if (floatBuffer == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("vertex buffer::");
        for (int i = 0; i < floatBuffer.limit(); i++) {
            sb.append(floatBuffer.get(i) + " ");
        }
        floatBuffer.rewind();
        return sb.toString();
    }

    private void drawWaterMark(int i, int i2, FloatBuffer floatBuffer) {
        if (i > 0) {
            GLES20.glUniform1i(this.muExtraTextureEnableLoc, 1);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(this.muExtraTextureLoc, 1);
            GLES20.glEnableVertexAttribArray(this.maExtraTextureCoordLoc);
            GLES20.glVertexAttribPointer(this.maExtraTextureCoordLoc, 2, 5126, false, i2, (Buffer) floatBuffer);
            GlUtil.checkGlError("glVertexAttribPointer");
            return;
        }
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glUniform1i(this.muExtraTextureEnableLoc, 0);
        GLES20.glUniform1i(this.muExtraTextureLoc, 1);
        GlUtil.checkGlError("glDrawArrays");
    }

    private void drawSticker(int i, int i2, FloatBuffer floatBuffer) {
        if (i > 0) {
            GLES20.glUniform1i(this.muExtraTexture2EnableLoc, 1);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(this.muExtraTexture2Loc, 2);
            GLES20.glEnableVertexAttribArray(this.maExtraTextureCoord2Loc);
            GLES20.glVertexAttribPointer(this.maExtraTextureCoord2Loc, 2, 5126, false, i2, (Buffer) floatBuffer);
            GlUtil.checkGlError("glVertexAttribPointer");
            return;
        }
        GLES20.glUniform1i(this.muExtraTexture2EnableLoc, 0);
        GLES20.glUniform1i(this.muExtraTexture2Loc, 2);
        GlUtil.checkGlError("glDrawArrays");
    }
}
