package com.faceunity.gles;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public class Texture2dProgram {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRAGMENT_SHADER_2D = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = vec4(texture2D(sTexture, vTextureCoord).rgb, 1.0);\n}\n";
    public static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = vec4(texture2D(sTexture, vTextureCoord).rgb, 1.0);\n}\n";
    public static final String FRAGMENT_SHADER_EXT_BW = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n";
    public static final String FRAGMENT_SHADER_EXT_FILT = "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n";
    public static final int KERNEL_SIZE = 9;
    public static final String TAG = "Grafika";
    public static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    public transient /* synthetic */ FieldHolder $fh;
    public float mColorAdjust;
    public float[] mKernel;
    public int mProgramHandle;
    public ProgramType mProgramType;
    public float[] mTexOffset;
    public int mTextureTarget;
    public int maPositionLoc;
    public int maTextureCoordLoc;
    public int muColorAdjustLoc;
    public int muKernelLoc;
    public int muMVPMatrixLoc;
    public int muTexMatrixLoc;
    public int muTexOffsetLoc;

    /* renamed from: com.faceunity.gles.Texture2dProgram$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$faceunity$gles$Texture2dProgram$ProgramType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(22839980, "Lcom/faceunity/gles/Texture2dProgram$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(22839980, "Lcom/faceunity/gles/Texture2dProgram$1;");
                    return;
                }
            }
            int[] iArr = new int[ProgramType.values().length];
            $SwitchMap$com$faceunity$gles$Texture2dProgram$ProgramType = iArr;
            try {
                iArr[ProgramType.TEXTURE_2D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_BW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$faceunity$gles$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_FILT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class ProgramType {
        public static final /* synthetic */ ProgramType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ProgramType TEXTURE_2D;
        public static final ProgramType TEXTURE_EXT;
        public static final ProgramType TEXTURE_EXT_BW;
        public static final ProgramType TEXTURE_EXT_FILT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1238674881, "Lcom/faceunity/gles/Texture2dProgram$ProgramType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1238674881, "Lcom/faceunity/gles/Texture2dProgram$ProgramType;");
                    return;
                }
            }
            TEXTURE_2D = new ProgramType("TEXTURE_2D", 0);
            TEXTURE_EXT = new ProgramType("TEXTURE_EXT", 1);
            TEXTURE_EXT_BW = new ProgramType("TEXTURE_EXT_BW", 2);
            ProgramType programType = new ProgramType("TEXTURE_EXT_FILT", 3);
            TEXTURE_EXT_FILT = programType;
            $VALUES = new ProgramType[]{TEXTURE_2D, TEXTURE_EXT, TEXTURE_EXT_BW, programType};
        }

        public ProgramType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ProgramType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ProgramType) Enum.valueOf(ProgramType.class, str) : (ProgramType) invokeL.objValue;
        }

        public static ProgramType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ProgramType[]) $VALUES.clone() : (ProgramType[]) invokeV.objValue;
        }
    }

    public Texture2dProgram(ProgramType programType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {programType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mKernel = new float[9];
        this.mProgramType = programType;
        int i4 = AnonymousClass1.$SwitchMap$com$faceunity$gles$Texture2dProgram$ProgramType[programType.ordinal()];
        if (i4 == 1) {
            this.mTextureTarget = 3553;
            this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", FRAGMENT_SHADER_2D);
        } else if (i4 == 2) {
            this.mTextureTarget = 36197;
            this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = vec4(texture2D(sTexture, vTextureCoord).rgb, 1.0);\n}\n");
        } else if (i4 == 3) {
            this.mTextureTarget = 36197;
            this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n");
        } else if (i4 == 4) {
            this.mTextureTarget = 36197;
            this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n");
        } else {
            throw new RuntimeException("Unhandled type " + programType);
        }
        if (this.mProgramHandle != 0) {
            String str = "Created program " + this.mProgramHandle + " (" + programType + SmallTailInfo.EMOTION_SUFFIX;
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.maPositionLoc = glGetAttribLocation;
            GlUtil.checkLocation(glGetAttribLocation, "aPosition");
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.maTextureCoordLoc = glGetAttribLocation2;
            GlUtil.checkLocation(glGetAttribLocation2, "aTextureCoord");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
            this.muMVPMatrixLoc = glGetUniformLocation;
            GlUtil.checkLocation(glGetUniformLocation, "uMVPMatrix");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
            this.muTexMatrixLoc = glGetUniformLocation2;
            GlUtil.checkLocation(glGetUniformLocation2, "uTexMatrix");
            int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.mProgramHandle, "uKernel");
            this.muKernelLoc = glGetUniformLocation3;
            if (glGetUniformLocation3 < 0) {
                this.muKernelLoc = -1;
                this.muTexOffsetLoc = -1;
                this.muColorAdjustLoc = -1;
                return;
            }
            int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexOffset");
            this.muTexOffsetLoc = glGetUniformLocation4;
            GlUtil.checkLocation(glGetUniformLocation4, "uTexOffset");
            int glGetUniformLocation5 = GLES20.glGetUniformLocation(this.mProgramHandle, "uColorAdjust");
            this.muColorAdjustLoc = glGetUniformLocation5;
            GlUtil.checkLocation(glGetUniformLocation5, "uColorAdjust");
            setKernel(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
            setTexSize(256, 256);
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    public int createTextureObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GlUtil.checkGlError("glGenTextures");
            int i2 = iArr[0];
            GLES20.glBindTexture(this.mTextureTarget, i2);
            GlUtil.checkGlError("glBindTexture " + i2);
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            GlUtil.checkGlError("glTexParameter");
            return i2;
        }
        return invokeV.intValue;
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i2, int i3, int i4, int i5, float[] fArr2, FloatBuffer floatBuffer2, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fArr, floatBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), fArr2, floatBuffer2, Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            GlUtil.checkGlError("draw start");
            GLES20.glUseProgram(this.mProgramHandle);
            GlUtil.checkGlError("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.mTextureTarget, i6);
            GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, fArr, 0);
            GlUtil.checkGlError("glUniformMatrix4fv");
            GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, fArr2, 0);
            GlUtil.checkGlError("glUniformMatrix4fv");
            GLES20.glEnableVertexAttribArray(this.maPositionLoc);
            GlUtil.checkGlError("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.maPositionLoc, i4, 5126, false, i5, (Buffer) floatBuffer);
            GlUtil.checkGlError("glVertexAttribPointer");
            GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
            GlUtil.checkGlError("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, i7, (Buffer) floatBuffer2);
            GlUtil.checkGlError("glVertexAttribPointer");
            int i8 = this.muKernelLoc;
            if (i8 >= 0) {
                GLES20.glUniform1fv(i8, 9, this.mKernel, 0);
                GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
                GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
            }
            GLES20.glDrawArrays(5, i2, i3);
            GlUtil.checkGlError("glDrawArrays");
            GLES20.glDisableVertexAttribArray(this.maPositionLoc);
            GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
            GLES20.glBindTexture(this.mTextureTarget, 0);
            GLES20.glUseProgram(0);
        }
    }

    public ProgramType getProgramType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mProgramType : (ProgramType) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String str = "deleting program " + this.mProgramHandle;
            GLES20.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
    }

    public void setKernel(float[] fArr, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048580, this, fArr, f2) == null) {
            if (fArr.length == 9) {
                System.arraycopy(fArr, 0, this.mKernel, 0, 9);
                this.mColorAdjust = f2;
                return;
            }
            throw new IllegalArgumentException("Kernel size is " + fArr.length + " vs. 9");
        }
    }

    public void setTexSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            float f2 = 1.0f / i2;
            float f3 = 1.0f / i3;
            float f4 = -f2;
            float f5 = -f3;
            this.mTexOffset = new float[]{f4, f5, 0.0f, f5, f2, f5, f4, 0.0f, 0.0f, 0.0f, f2, 0.0f, f4, f3, 0.0f, f3, f2, f3};
        }
    }
}
