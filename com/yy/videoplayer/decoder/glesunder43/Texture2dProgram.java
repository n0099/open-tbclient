package com.yy.videoplayer.decoder.glesunder43;

import android.opengl.GLES20;
import android.util.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class Texture2dProgram {
    private static final String FRAGMENT_SHADER_2D = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_WATERMARK = "precision highp float;\nvarying vec2 vTextureCoord;\nvarying vec2 glPositionCoord;\nvarying vec2 waterTextureCoord;\nuniform sampler2D sTexture;\nuniform sampler2D waterTexture;\nuniform int waterEnabled;\nvoid main() {\n    if (waterEnabled == 1) {\n        vec4 wColor = texture2D(waterTexture, waterTextureCoord);\n        gl_FragColor = vec4(texture2D(sTexture, vTextureCoord).rgb * wColor.a + wColor.rgb, 1.0);\n    }\n    else {\n        gl_FragColor = texture2D(sTexture, vTextureCoord);\n    }\n}\n";
    public static final String FRAGMENT_SHADER_YUV = "precision highp float;varying vec2 vTextureCoord;uniform sampler2D tex_y;uniform sampler2D tex_u;uniform sampler2D tex_v;void main() {    vec3 yuv;    yuv.x = texture2D(tex_y, vTextureCoord).r;    yuv.y = texture2D(tex_u, vTextureCoord).r - 0.5;    yuv.z = texture2D(tex_v, vTextureCoord).r - 0.5;    yuv.x = 1.1643 * yuv.x - 0.0728;    vec3 rgb = vec3(        yuv.x + 1.5958 * yuv.z,        yuv.x - 0.39173 * yuv.y - 0.8129 * yuv.z,        yuv.x + 2.017 * yuv.y    );    gl_FragColor = vec4(rgb, 1);}";
    private static final String TAG = "Grafika";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private static final String VERTEX_SHADER_WATERMARK = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec2 waterTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    waterTextureCoord = aTextureCoord.xy;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private int mProgramHandle;
    private ProgramType mProgramType;
    protected int mSampleULoc;
    protected int mSampleVLoc;
    protected int mSampleYLoc;
    private int mTextureTarget;
    private int mWaterEnabledLoc;
    private int mWaterTextureLoc;
    private int maPositionLoc;
    private int maTextureCoordLoc;
    private int muMVPMatrixLoc;
    private int muTexMatrixLoc;

    /* loaded from: classes6.dex */
    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_WATERMARK,
        TEXTURE_YUV
    }

    public Texture2dProgram(ProgramType programType) {
        this.mProgramType = programType;
        switch (programType) {
            case TEXTURE_2D:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
                break;
            case TEXTURE_EXT:
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_EXT);
                break;
            case TEXTURE_WATERMARK:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER_WATERMARK, FRAGMENT_SHADER_WATERMARK);
                break;
            case TEXTURE_YUV:
                this.mTextureTarget = 3553;
                this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision highp float;varying vec2 vTextureCoord;uniform sampler2D tex_y;uniform sampler2D tex_u;uniform sampler2D tex_v;void main() {    vec3 yuv;    yuv.x = texture2D(tex_y, vTextureCoord).r;    yuv.y = texture2D(tex_u, vTextureCoord).r - 0.5;    yuv.z = texture2D(tex_v, vTextureCoord).r - 0.5;    yuv.x = 1.1643 * yuv.x - 0.0728;    vec3 rgb = vec3(        yuv.x + 1.5958 * yuv.z,        yuv.x - 0.39173 * yuv.y - 0.8129 * yuv.z,        yuv.x + 2.017 * yuv.y    );    gl_FragColor = vec4(rgb, 1);}");
                break;
            default:
                throw new RuntimeException("Unhandled type " + programType);
        }
        if (this.mProgramHandle == 0) {
            throw new RuntimeException("Unable to create program");
        }
        Log.d("Grafika", "Created program " + this.mProgramHandle + " (" + programType + ")");
        this.maPositionLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
        GlUtil.checkLocation(this.maPositionLoc, "aPosition");
        this.maTextureCoordLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
        GlUtil.checkLocation(this.maTextureCoordLoc, "aTextureCoord");
        this.muMVPMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
        GlUtil.checkLocation(this.muMVPMatrixLoc, "uMVPMatrix");
        this.muTexMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        GlUtil.checkLocation(this.muTexMatrixLoc, "uTexMatrix");
        this.mWaterTextureLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "waterTexture");
        this.mWaterEnabledLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "waterEnabled");
        this.mSampleYLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "tex_y");
        this.mSampleULoc = GLES20.glGetUniformLocation(this.mProgramHandle, "tex_u");
        this.mSampleVLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "tex_v");
    }

    public void release() {
        Log.d("Grafika", "deleting program " + this.mProgramHandle);
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
    }

    public ProgramType getProgramType() {
        return this.mProgramType;
    }

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

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6, int i7, int i8, int i9, int i10) {
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        if (this.mSampleYLoc >= 0) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i8);
            GLES20.glUniform1i(this.mSampleYLoc, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, i9);
            GLES20.glUniform1i(this.mSampleULoc, 1);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, i10);
            GLES20.glUniform1i(this.mSampleVLoc, 2);
        } else {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.mTextureTarget, i5);
        }
        if (this.mWaterEnabledLoc >= 0) {
            if (i7 != -1) {
                GLES20.glUniform1i(this.mWaterEnabledLoc, 1);
                GLES20.glActiveTexture(33986);
                GLES20.glBindTexture(3553, i7);
                GLES20.glUniform1i(this.mWaterTextureLoc, 2);
            } else {
                GLES20.glUniform1i(this.mWaterEnabledLoc, 0);
                GLES20.glUniform1i(this.mWaterTextureLoc, 0);
            }
        }
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
        GLES20.glDrawArrays(5, i, i2);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glBindTexture(this.mTextureTarget, 0);
        GLES20.glUseProgram(0);
    }
}
