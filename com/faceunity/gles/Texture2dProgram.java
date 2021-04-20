package com.faceunity.gles;

import android.opengl.GLES20;
import android.util.Log;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.core.StatusCode;
import d.e.c.d;
import java.nio.Buffer;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class Texture2dProgram {

    /* renamed from: a  reason: collision with root package name */
    public int f30420a;

    /* renamed from: b  reason: collision with root package name */
    public int f30421b;

    /* renamed from: c  reason: collision with root package name */
    public int f30422c;

    /* renamed from: d  reason: collision with root package name */
    public int f30423d;

    /* renamed from: e  reason: collision with root package name */
    public int f30424e;

    /* renamed from: f  reason: collision with root package name */
    public int f30425f;

    /* renamed from: g  reason: collision with root package name */
    public int f30426g;

    /* renamed from: h  reason: collision with root package name */
    public int f30427h;
    public int i;
    public float[] j = new float[9];
    public float[] k;
    public float l;

    /* loaded from: classes6.dex */
    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_FILT
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30428a;

        static {
            int[] iArr = new int[ProgramType.values().length];
            f30428a = iArr;
            try {
                iArr[ProgramType.TEXTURE_2D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30428a[ProgramType.TEXTURE_EXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30428a[ProgramType.TEXTURE_EXT_BW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30428a[ProgramType.TEXTURE_EXT_FILT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Texture2dProgram(ProgramType programType) {
        int i = a.f30428a[programType.ordinal()];
        if (i == 1) {
            this.i = 3553;
            this.f30420a = d.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = vec4(texture2D(sTexture, vTextureCoord).rgb, 1.0);\n}\n");
        } else if (i == 2) {
            this.i = 36197;
            this.f30420a = d.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = vec4(texture2D(sTexture, vTextureCoord).rgb, 1.0);\n}\n");
        } else if (i == 3) {
            this.i = 36197;
            this.f30420a = d.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n");
        } else if (i == 4) {
            this.i = 36197;
            this.f30420a = d.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n");
        } else {
            throw new RuntimeException("Unhandled type " + programType);
        }
        if (this.f30420a != 0) {
            Log.d("Grafika", "Created program " + this.f30420a + " (" + programType + SmallTailInfo.EMOTION_SUFFIX);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.f30420a, "aPosition");
            this.f30426g = glGetAttribLocation;
            d.b(glGetAttribLocation, "aPosition");
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f30420a, "aTextureCoord");
            this.f30427h = glGetAttribLocation2;
            d.b(glGetAttribLocation2, "aTextureCoord");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.f30420a, "uMVPMatrix");
            this.f30421b = glGetUniformLocation;
            d.b(glGetUniformLocation, "uMVPMatrix");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f30420a, "uTexMatrix");
            this.f30422c = glGetUniformLocation2;
            d.b(glGetUniformLocation2, "uTexMatrix");
            int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.f30420a, "uKernel");
            this.f30423d = glGetUniformLocation3;
            if (glGetUniformLocation3 < 0) {
                this.f30423d = -1;
                this.f30424e = -1;
                this.f30425f = -1;
                return;
            }
            int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.f30420a, "uTexOffset");
            this.f30424e = glGetUniformLocation4;
            d.b(glGetUniformLocation4, "uTexOffset");
            int glGetUniformLocation5 = GLES20.glGetUniformLocation(this.f30420a, "uColorAdjust");
            this.f30425f = glGetUniformLocation5;
            d.b(glGetUniformLocation5, "uColorAdjust");
            d(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
            e(256, 256);
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    public int a() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        d.a("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(this.i, i);
        d.a("glBindTexture " + i);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        d.a("glTexParameter");
        return i;
    }

    public void b(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        d.a("draw start");
        GLES20.glUseProgram(this.f30420a);
        d.a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.i, i5);
        GLES20.glUniformMatrix4fv(this.f30421b, 1, false, fArr, 0);
        d.a("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.f30422c, 1, false, fArr2, 0);
        d.a("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f30426g);
        d.a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f30426g, i3, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, i4, (Buffer) floatBuffer);
        d.a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f30427h);
        d.a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f30427h, 2, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, i6, (Buffer) floatBuffer2);
        d.a("glVertexAttribPointer");
        int i7 = this.f30423d;
        if (i7 >= 0) {
            GLES20.glUniform1fv(i7, 9, this.j, 0);
            GLES20.glUniform2fv(this.f30424e, 9, this.k, 0);
            GLES20.glUniform1f(this.f30425f, this.l);
        }
        GLES20.glDrawArrays(5, i, i2);
        d.a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f30426g);
        GLES20.glDisableVertexAttribArray(this.f30427h);
        GLES20.glBindTexture(this.i, 0);
        GLES20.glUseProgram(0);
    }

    public void c() {
        Log.d("Grafika", "deleting program " + this.f30420a);
        GLES20.glDeleteProgram(this.f30420a);
        this.f30420a = -1;
    }

    public void d(float[] fArr, float f2) {
        if (fArr.length == 9) {
            System.arraycopy(fArr, 0, this.j, 0, 9);
            this.l = f2;
            return;
        }
        throw new IllegalArgumentException("Kernel size is " + fArr.length + " vs. 9");
    }

    public void e(int i, int i2) {
        float f2 = 1.0f / i;
        float f3 = 1.0f / i2;
        float f4 = -f2;
        float f5 = -f3;
        this.k = new float[]{f4, f5, 0.0f, f5, f2, f5, f4, 0.0f, 0.0f, 0.0f, f2, 0.0f, f4, f3, 0.0f, f3, f2, f3};
    }
}
