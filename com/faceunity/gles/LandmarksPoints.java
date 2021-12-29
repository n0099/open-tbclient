package com.faceunity.gles;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class LandmarksPoints {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COORDS_PER_VERTEX = 2;
    public static float[] flipMtx;
    public static float[] originMtx;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer bb;
    public float[] color;
    public final String fragmentShaderCode;
    public int mColorHandle;
    public int mMVPMatrixHandle;
    public float mPointSize;
    public int mPointSizeHandle;
    public int mPositionHandle;
    public final int mProgram;
    public float[] pointsCoords;
    public final FloatBuffer vertexBuffer;
    public final int vertexCount;
    public final String vertexShaderCode;
    public final int vertexStride;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-900299416, "Lcom/faceunity/gles/LandmarksPoints;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-900299416, "Lcom/faceunity/gles/LandmarksPoints;");
                return;
            }
        }
        float[] fArr = GlUtil.IDENTITY_MATRIX;
        originMtx = fArr;
        flipMtx = Arrays.copyOf(fArr, fArr.length);
    }

    public LandmarksPoints() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.vertexShaderCode = "uniform mat4 uMVPMatrix;attribute vec4 vPosition;uniform float uPointSize;void main() {  gl_Position = uMVPMatrix * vPosition;  gl_PointSize = uPointSize;}";
        this.fragmentShaderCode = "precision mediump float;uniform vec4 vColor;void main() {  gl_FragColor = vColor;}";
        this.mPointSize = 6.0f;
        float[] fArr = new float[150];
        this.pointsCoords = fArr;
        this.vertexCount = fArr.length / 2;
        this.vertexStride = 8;
        this.color = new float[]{0.63671875f, 0.76953125f, 0.22265625f, 1.0f};
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        this.bb = allocateDirect;
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = this.bb.asFloatBuffer();
        this.vertexBuffer = asFloatBuffer;
        asFloatBuffer.put(this.pointsCoords);
        this.vertexBuffer.position(0);
        int loadShader = GlUtil.loadShader(35633, "uniform mat4 uMVPMatrix;attribute vec4 vPosition;uniform float uPointSize;void main() {  gl_Position = uMVPMatrix * vPosition;  gl_PointSize = uPointSize;}");
        int loadShader2 = GlUtil.loadShader(35632, "precision mediump float;uniform vec4 vColor;void main() {  gl_FragColor = vColor;}");
        int glCreateProgram = GLES20.glCreateProgram();
        this.mProgram = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, loadShader);
        GLES20.glAttachShader(this.mProgram, loadShader2);
        GLES20.glLinkProgram(this.mProgram);
    }

    public void draw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            GLES20.glUseProgram(this.mProgram);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
            this.mPositionHandle = glGetAttribLocation;
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, (Buffer) this.vertexBuffer);
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "vColor");
            this.mColorHandle = glGetUniformLocation;
            GLES20.glUniform4fv(glGetUniformLocation, 1, this.color, 0);
            this.mMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
            GlUtil.checkGlError("glGetUniformLocation");
            this.mPointSizeHandle = GLES20.glGetUniformLocation(this.mProgram, "uPointSize");
            GlUtil.checkGlError("glGetUniformLocation");
            GLES20.glUniformMatrix4fv(this.mMVPMatrixHandle, 1, false, originMtx, 0);
            GlUtil.checkGlError("glUniformMatrix4fv");
            GLES20.glUniform1f(this.mPointSizeHandle, this.mPointSize);
            GlUtil.checkGlError("glUniform1f");
            GLES20.glDrawArrays(0, 0, this.vertexCount);
            GLES20.glDisableVertexAttribArray(this.mPositionHandle);
        }
    }

    public void refresh(float[] fArr, int i2, int i3, float f2, float f3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fArr, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)}) == null) {
            for (int i4 = 0; i4 < 150; i4++) {
                this.pointsCoords[i4] = fArr[i4];
            }
            for (int i5 = 0; i5 < fArr.length; i5 += 2) {
                float f4 = z ? i2 - this.pointsCoords[i5] : this.pointsCoords[i5];
                float[] fArr2 = this.pointsCoords;
                int i6 = i5 + 1;
                fArr2[i5] = (-(((fArr2[i6] / i3) * 0.8f) + 0.2f)) * 1.0f;
                fArr2[i6] = (((((f4 / i2) - f2) / f3) * 0.64f) + 0.36f) * 1.0f;
            }
            this.vertexBuffer.put(this.pointsCoords);
            this.vertexBuffer.position(0);
        }
    }

    public void setPointSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            this.mPointSize = f2;
        }
    }
}
