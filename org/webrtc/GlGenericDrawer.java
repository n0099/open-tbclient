package org.webrtc;

import android.opengl.GLES20;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import javax.annotation.Nullable;
import org.webrtc.RendererCommon;
/* loaded from: classes9.dex */
public class GlGenericDrawer implements RendererCommon.GlDrawer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_VERTEX_SHADER_STRING = "varying vec2 tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\nuniform mat4 tex_mat;\nvoid main() {\n  gl_Position = in_pos;\n  tc = (tex_mat * in_tc).xy;\n}\n";
    public static final FloatBuffer FULL_RECTANGLE_BUFFER;
    public static final FloatBuffer FULL_RECTANGLE_TEXTURE_BUFFER;
    public static final String INPUT_TEXTURE_COORDINATE_NAME = "in_tc";
    public static final String INPUT_VERTEX_COORDINATE_NAME = "in_pos";
    public static final String TEXTURE_MATRIX_NAME = "tex_mat";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public GlShader currentShader;
    @Nullable
    public ShaderType currentShaderType;
    public final String genericFragmentSource;
    public int inPosLocation;
    public int inTcLocation;
    public final ShaderCallbacks shaderCallbacks;
    public int texMatrixLocation;
    public final String vertexShader;

    /* loaded from: classes9.dex */
    public interface ShaderCallbacks {
        void onNewShader(GlShader glShader);

        void onPrepareShader(GlShader glShader, float[] fArr, int i2, int i3, int i4, int i5);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class ShaderType {
        public static final /* synthetic */ ShaderType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ShaderType OES;
        public static final ShaderType RGB;
        public static final ShaderType YUV;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-657612144, "Lorg/webrtc/GlGenericDrawer$ShaderType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-657612144, "Lorg/webrtc/GlGenericDrawer$ShaderType;");
                    return;
                }
            }
            OES = new ShaderType("OES", 0);
            RGB = new ShaderType("RGB", 1);
            ShaderType shaderType = new ShaderType("YUV", 2);
            YUV = shaderType;
            $VALUES = new ShaderType[]{OES, RGB, shaderType};
        }

        public ShaderType(String str, int i2) {
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

        public static ShaderType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ShaderType) Enum.valueOf(ShaderType.class, str) : (ShaderType) invokeL.objValue;
        }

        public static ShaderType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ShaderType[]) $VALUES.clone() : (ShaderType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(148171075, "Lorg/webrtc/GlGenericDrawer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(148171075, "Lorg/webrtc/GlGenericDrawer;");
                return;
            }
        }
        FULL_RECTANGLE_BUFFER = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        FULL_RECTANGLE_TEXTURE_BUFFER = GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlGenericDrawer(String str, ShaderCallbacks shaderCallbacks) {
        this(DEFAULT_VERTEX_SHADER_STRING, str, shaderCallbacks);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, shaderCallbacks};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (ShaderCallbacks) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static String createFragmentShaderString(String str, ShaderType shaderType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, shaderType)) == null) {
            StringBuilder sb = new StringBuilder();
            if (shaderType == ShaderType.OES) {
                sb.append("#extension GL_OES_EGL_image_external : require\n");
            }
            sb.append("precision mediump float;\n");
            sb.append("varying vec2 tc;\n");
            if (shaderType == ShaderType.YUV) {
                sb.append("uniform sampler2D y_tex;\n");
                sb.append("uniform sampler2D u_tex;\n");
                sb.append("uniform sampler2D v_tex;\n");
                sb.append("vec4 sample(vec2 p) {\n");
                sb.append("  float y = texture2D(y_tex, p).r * 1.16438;\n");
                sb.append("  float u = texture2D(u_tex, p).r;\n");
                sb.append("  float v = texture2D(v_tex, p).r;\n");
                sb.append("  return vec4(y + 1.59603 * v - 0.874202,\n");
                sb.append("    y - 0.391762 * u - 0.812968 * v + 0.531668,\n");
                sb.append("    y + 2.01723 * u - 1.08563, 1);\n");
                sb.append("}\n");
                sb.append(str);
            } else {
                String str2 = shaderType == ShaderType.OES ? "samplerExternalOES" : "sampler2D";
                sb.append("uniform ");
                sb.append(str2);
                sb.append(" tex;\n");
                sb.append(str.replace("sample(", "texture2D(tex, "));
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    private void prepareShader(ShaderType shaderType, float[] fArr, int i2, int i3, int i4, int i5) {
        GlShader glShader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{shaderType, fArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (shaderType.equals(this.currentShaderType)) {
                glShader = this.currentShader;
            } else {
                this.currentShaderType = shaderType;
                GlShader glShader2 = this.currentShader;
                if (glShader2 != null) {
                    glShader2.release();
                }
                GlShader createShader = createShader(shaderType);
                this.currentShader = createShader;
                createShader.useProgram();
                if (shaderType == ShaderType.YUV) {
                    GLES20.glUniform1i(createShader.getUniformLocation("y_tex"), 0);
                    GLES20.glUniform1i(createShader.getUniformLocation("u_tex"), 1);
                    GLES20.glUniform1i(createShader.getUniformLocation("v_tex"), 2);
                } else {
                    GLES20.glUniform1i(createShader.getUniformLocation("tex"), 0);
                }
                GlUtil.checkNoGLES2Error("Create shader");
                this.shaderCallbacks.onNewShader(createShader);
                this.texMatrixLocation = createShader.getUniformLocation(TEXTURE_MATRIX_NAME);
                this.inPosLocation = createShader.getAttribLocation(INPUT_VERTEX_COORDINATE_NAME);
                this.inTcLocation = createShader.getAttribLocation(INPUT_TEXTURE_COORDINATE_NAME);
                glShader = createShader;
            }
            glShader.useProgram();
            GLES20.glEnableVertexAttribArray(this.inPosLocation);
            GLES20.glVertexAttribPointer(this.inPosLocation, 2, 5126, false, 0, (Buffer) FULL_RECTANGLE_BUFFER);
            GLES20.glEnableVertexAttribArray(this.inTcLocation);
            GLES20.glVertexAttribPointer(this.inTcLocation, 2, 5126, false, 0, (Buffer) FULL_RECTANGLE_TEXTURE_BUFFER);
            GLES20.glUniformMatrix4fv(this.texMatrixLocation, 1, false, fArr, 0);
            this.shaderCallbacks.onPrepareShader(glShader, fArr, i2, i3, i4, i5);
            GlUtil.checkNoGLES2Error("Prepare shader");
        }
    }

    public GlShader createShader(ShaderType shaderType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, shaderType)) == null) ? new GlShader(this.vertexShader, createFragmentShaderString(this.genericFragmentSource, shaderType)) : (GlShader) invokeL.objValue;
    }

    @Override // org.webrtc.RendererCommon.GlDrawer
    public void drawOes(int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), fArr, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            prepareShader(ShaderType.OES, fArr, i3, i4, i7, i8);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
            GLES20.glViewport(i5, i6, i7, i8);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glBindTexture(36197, 0);
        }
    }

    @Override // org.webrtc.RendererCommon.GlDrawer
    public void drawRgb(int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), fArr, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            prepareShader(ShaderType.RGB, fArr, i3, i4, i7, i8);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i2);
            GLES20.glViewport(i5, i6, i7, i8);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glBindTexture(3553, 0);
        }
    }

    @Override // org.webrtc.RendererCommon.GlDrawer
    public void drawYuv(int[] iArr, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{iArr, fArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            prepareShader(ShaderType.YUV, fArr, i2, i3, i6, i7);
            for (int i8 = 0; i8 < 3; i8++) {
                GLES20.glActiveTexture(33984 + i8);
                GLES20.glBindTexture(3553, iArr[i8]);
            }
            GLES20.glViewport(i4, i5, i6, i7);
            GLES20.glDrawArrays(5, 0, 4);
            for (int i9 = 0; i9 < 3; i9++) {
                GLES20.glActiveTexture(i9 + 33984);
                GLES20.glBindTexture(3553, 0);
            }
        }
    }

    @Override // org.webrtc.RendererCommon.GlDrawer
    public void release() {
        GlShader glShader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (glShader = this.currentShader) == null) {
            return;
        }
        glShader.release();
        this.currentShader = null;
        this.currentShaderType = null;
    }

    public GlGenericDrawer(String str, String str2, ShaderCallbacks shaderCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, shaderCallbacks};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.vertexShader = str;
        this.genericFragmentSource = str2;
        this.shaderCallbacks = shaderCallbacks;
    }
}
