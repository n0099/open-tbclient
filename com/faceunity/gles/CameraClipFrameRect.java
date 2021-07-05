package com.faceunity.gles;

import android.opengl.GLES20;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.StatusCode;
import java.nio.Buffer;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class CameraClipFrameRect {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = vec4(texture2D(sTexture, vTextureCoord).rgb, 1.0);\n}\n";
    public static final float[] FULL_RECTANGLE_COORDS;
    public static final float[] FULL_RECTANGLE_TEX_COORDS;
    public static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "CameraClipFrameRect";
    public static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    public static float clipBottom;
    public static float clipTop;
    public transient /* synthetic */ FieldHolder $fh;
    public final FloatBuffer FULL_RECTANGLE_BUF;
    public final FloatBuffer FULL_RECTANGLE_TEX_BUF;
    public int mCoordsPerVertex;
    public int mProgramHandle;
    public FloatBuffer mTexCoordArray;
    public int mTexCoordStride;
    public FloatBuffer mVertexArray;
    public int mVertexCount;
    public int mVertexStride;
    public int maPositionLoc;
    public int maTextureCoordLoc;
    public int muMVPMatrixLoc;
    public int muTexMatrixLoc;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-462368694, "Lcom/faceunity/gles/CameraClipFrameRect;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-462368694, "Lcom/faceunity/gles/CameraClipFrameRect;");
                return;
            }
        }
        FULL_RECTANGLE_COORDS = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        clipTop = 0.1f;
        clipBottom = 0.9f;
        FULL_RECTANGLE_TEX_COORDS = new float[]{0.0f, 0.1f, 1.0f, 0.1f, 0.0f, 0.9f, 1.0f, 0.9f};
    }

    public CameraClipFrameRect(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Log.d(TAG, "X : " + f2 + " Y : " + f3);
        int loadShader = GlUtil.loadShader(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n");
        int loadShader2 = GlUtil.loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = vec4(texture2D(sTexture, vTextureCoord).rgb, 1.0);\n}\n");
        int glCreateProgram = GLES20.glCreateProgram();
        this.mProgramHandle = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, loadShader);
        GLES20.glAttachShader(this.mProgramHandle, loadShader2);
        GLES20.glLinkProgram(this.mProgramHandle);
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
        float[] fArr = FULL_RECTANGLE_COORDS;
        float f4 = (f2 * 2.0f) - 1.0f;
        fArr[6] = f4;
        fArr[2] = f4;
        float f5 = 1.0f - (f3 * 2.0f);
        fArr[3] = f5;
        fArr[1] = f5;
        this.FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr);
        FloatBuffer createFloatBuffer = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
        this.FULL_RECTANGLE_TEX_BUF = createFloatBuffer;
        this.mVertexArray = this.FULL_RECTANGLE_BUF;
        this.mTexCoordArray = createFloatBuffer;
        this.mCoordsPerVertex = 2;
        this.mVertexStride = 2 * 4;
        this.mVertexCount = FULL_RECTANGLE_COORDS.length / 2;
    }

    public void drawFrame(int i2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, fArr) == null) {
            GlUtil.checkGlError("draw start");
            GLES20.glUseProgram(this.mProgramHandle);
            GlUtil.checkGlError("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
            GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, GlUtil.IDENTITY_MATRIX, 0);
            GlUtil.checkGlError("glUniformMatrix4fv");
            GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, fArr, 0);
            GlUtil.checkGlError("glUniformMatrix4fv");
            GLES20.glEnableVertexAttribArray(this.maPositionLoc);
            GlUtil.checkGlError("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.maPositionLoc, this.mCoordsPerVertex, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, this.mVertexStride, (Buffer) this.mVertexArray);
            GlUtil.checkGlError("glVertexAttribPointer");
            GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
            GlUtil.checkGlError("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, this.mTexCoordStride, (Buffer) this.mTexCoordArray);
            GlUtil.checkGlError("glVertexAttribPointer");
            GLES20.glDrawArrays(5, 0, this.mVertexCount);
            GlUtil.checkGlError("glDrawArrays");
            GLES20.glDisableVertexAttribArray(this.maPositionLoc);
            GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
            GLES20.glBindTexture(36197, 0);
            GLES20.glUseProgram(0);
        }
    }

    public void release(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }
}
