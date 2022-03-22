package org.webrtc;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.FloatBuffer;
/* loaded from: classes8.dex */
public class GlShader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GlShader";
    public transient /* synthetic */ FieldHolder $fh;
    public int program;

    public GlShader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int compileShader = compileShader(35633, str);
        int compileShader2 = compileShader(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        this.program = glCreateProgram;
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, compileShader);
            GLES20.glAttachShader(this.program, compileShader2);
            GLES20.glLinkProgram(this.program);
            int[] iArr = {0};
            GLES20.glGetProgramiv(this.program, 35714, iArr, 0);
            if (iArr[0] == 1) {
                GLES20.glDeleteShader(compileShader);
                GLES20.glDeleteShader(compileShader2);
                GlUtil.checkNoGLES2Error("Creating GlShader");
                return;
            }
            Logging.e(TAG, "Could not link program: " + GLES20.glGetProgramInfoLog(this.program));
            throw new RuntimeException(GLES20.glGetProgramInfoLog(this.program));
        }
        throw new RuntimeException("glCreateProgram() failed. GLES20 error: " + GLES20.glGetError());
    }

    public static int compileShader(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, str)) == null) {
            int glCreateShader = GLES20.glCreateShader(i);
            if (glCreateShader != 0) {
                GLES20.glShaderSource(glCreateShader, str);
                GLES20.glCompileShader(glCreateShader);
                int[] iArr = {0};
                GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
                if (iArr[0] == 1) {
                    GlUtil.checkNoGLES2Error("compileShader");
                    return glCreateShader;
                }
                Logging.e(TAG, "Compile error " + GLES20.glGetShaderInfoLog(glCreateShader) + " in shader:\n" + str);
                throw new RuntimeException(GLES20.glGetShaderInfoLog(glCreateShader));
            }
            throw new RuntimeException("glCreateShader() failed. GLES20 error: " + GLES20.glGetError());
        }
        return invokeIL.intValue;
    }

    public int getAttribLocation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int i = this.program;
            if (i != -1) {
                int glGetAttribLocation = GLES20.glGetAttribLocation(i, str);
                if (glGetAttribLocation >= 0) {
                    return glGetAttribLocation;
                }
                throw new RuntimeException("Could not locate '" + str + "' in program");
            }
            throw new RuntimeException("The program has been released");
        }
        return invokeL.intValue;
    }

    public int getUniformLocation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int i = this.program;
            if (i != -1) {
                int glGetUniformLocation = GLES20.glGetUniformLocation(i, str);
                if (glGetUniformLocation >= 0) {
                    return glGetUniformLocation;
                }
                throw new RuntimeException("Could not locate uniform '" + str + "' in program");
            }
            throw new RuntimeException("The program has been released");
        }
        return invokeL.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Logging.d(TAG, "Deleting shader.");
            int i = this.program;
            if (i != -1) {
                GLES20.glDeleteProgram(i);
                this.program = -1;
            }
        }
    }

    public void setVertexAttribArray(String str, int i, FloatBuffer floatBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i, floatBuffer) == null) {
            setVertexAttribArray(str, i, 0, floatBuffer);
        }
    }

    public void useProgram() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i = this.program;
            if (i != -1) {
                GLES20.glUseProgram(i);
                GlUtil.checkNoGLES2Error("glUseProgram");
                return;
            }
            throw new RuntimeException("The program has been released");
        }
    }

    public void setVertexAttribArray(String str, int i, int i2, FloatBuffer floatBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), floatBuffer}) == null) {
            if (this.program != -1) {
                int attribLocation = getAttribLocation(str);
                GLES20.glEnableVertexAttribArray(attribLocation);
                GLES20.glVertexAttribPointer(attribLocation, i, 5126, false, i2, (Buffer) floatBuffer);
                GlUtil.checkNoGLES2Error("setVertexAttribArray");
                return;
            }
            throw new RuntimeException("The program has been released");
        }
    }
}
