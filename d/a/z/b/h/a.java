package d.a.z.b.h;

import android.opengl.GLES20;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f71523a = "a";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-801039736, "Ld/a/z/b/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-801039736, "Ld/a/z/b/h/a;");
        }
    }

    public static void a(String str) {
        int glGetError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || (glGetError = GLES20.glGetError()) == 0) {
            return;
        }
        Log.e(f71523a, str + ": glError 0x" + Integer.toHexString(glGetError));
    }

    public static FloatBuffer b(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fArr)) == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            return asFloatBuffer;
        }
        return (FloatBuffer) invokeL.objValue;
    }

    public static int c(String str, String str2) {
        InterceptResult invokeLL;
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            int d3 = d(35633, str);
            if (d3 == 0 || (d2 = d(35632, str2)) == 0) {
                return -1;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            a("glCreateProgram");
            if (glCreateProgram == 0) {
                Log.e(f71523a, "Could not create program");
            }
            GLES20.glAttachShader(glCreateProgram, d3);
            a("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, d2);
            a("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Log.e(f71523a, "Could not link program: ");
                Log.e(f71523a, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return -1;
            }
            return glCreateProgram;
        }
        return invokeLL.intValue;
    }

    public static int d(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65540, null, i2, str)) == null) {
            int glCreateShader = GLES20.glCreateShader(i2);
            a("glCreateShader type=" + i2);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String str2 = f71523a;
                Log.e(str2, "Could not compile shader " + i2 + ":");
                String str3 = f71523a;
                Log.e(str3, " " + GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return invokeIL.intValue;
    }
}
