package com.repackage;

import android.opengl.GLES20;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class kb0 extends jb0 implements lb0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String k = "kb0";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public pb0 d;
    public ob0 e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755564776, "Lcom/repackage/kb0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755564776, "Lcom/repackage/kb0;");
        }
    }

    public kb0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = "uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
        this.c = "#extension GL_OES_EGL_image_external : require\nprecision mediump float; // 指定默认精度\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n";
        new LinkedList();
    }

    @Override // com.repackage.lb0
    public void a(mb0 mb0Var, rb0 rb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, mb0Var, rb0Var) == null) {
            pb0 pb0Var = this.d;
            if (pb0Var != null && pb0Var.e()) {
                l();
                d(this.d);
                c(mb0Var, rb0Var);
                g(mb0Var, rb0Var);
                j();
                k(this.d);
                f();
                return;
            }
            Log.e(k, "onDraw filter has not been setup!!!");
        }
    }

    @Override // com.repackage.lb0
    public void b(pb0 pb0Var, ob0 ob0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pb0Var, ob0Var) == null) {
            this.d = pb0Var;
            this.e = ob0Var;
            e(this.b, this.c);
            if (this.a != -1) {
                h();
                return;
            }
            throw new RuntimeException("Unable to create program");
        }
    }

    public void c(mb0 mb0Var, rb0 rb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, mb0Var, rb0Var) == null) {
            GLES20.glUniformMatrix4fv(this.g, 1, false, rb0Var.b(), 0);
            GLES20.glUniformMatrix4fv(this.h, 1, false, rb0Var.c(), 0);
            GLES20.glEnableVertexAttribArray(this.f);
            GLES20.glVertexAttribPointer(this.f, mb0Var.a(), 5126, false, mb0Var.f(), (Buffer) mb0Var.d());
            GLES20.glEnableVertexAttribArray(this.i);
            GLES20.glVertexAttribPointer(this.i, mb0Var.a(), 5126, false, mb0Var.c(), (Buffer) mb0Var.b());
        }
    }

    public void d(pb0 pb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pb0Var) == null) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(pb0Var.getType(), pb0Var.c());
            GLES20.glUniform1i(this.j, 0);
        }
    }

    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            if (this.d.getType() != 36197) {
                str2 = str2.replaceFirst("#extension GL_OES_EGL_image_external : require", "").replace("samplerExternalOES", "sampler2D");
            }
            this.a = tb0.c(str, str2);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            GLES20.glUseProgram(0);
        }
    }

    public void g(mb0 mb0Var, rb0 rb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, mb0Var, rb0Var) == null) {
            if (rb0Var.e()) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
            }
            if (rb0Var.d()) {
                GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                GLES20.glBlendFunc(770, 771);
            }
            GLES20.glDrawArrays(5, 0, mb0Var.e());
            if (rb0Var.d()) {
                GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j = GLES20.glGetUniformLocation(this.a, "uTexture");
            this.f = GLES20.glGetAttribLocation(this.a, "aPosition");
            this.g = GLES20.glGetUniformLocation(this.a, "uMVPMatrix");
            this.h = GLES20.glGetUniformLocation(this.a, "uTexMatrix");
            this.i = GLES20.glGetAttribLocation(this.a, "aTextureCoord");
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            GLES20.glDeleteProgram(this.a);
            this.a = -1;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            GLES20.glDisableVertexAttribArray(this.f);
            GLES20.glDisableVertexAttribArray(this.i);
        }
    }

    public void k(pb0 pb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pb0Var) == null) {
            GLES20.glBindTexture(pb0Var.getType(), 0);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GLES20.glUseProgram(this.a);
        }
    }

    @Override // com.repackage.lb0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            i();
        }
    }
}
