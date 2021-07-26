package d.a.x.b.e;

import android.opengl.GLES20;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.StatusCode;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import d.a.x.b.f.d;
import java.nio.Buffer;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class b extends a implements c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String k = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68965a;

    /* renamed from: b  reason: collision with root package name */
    public String f68966b;

    /* renamed from: c  reason: collision with root package name */
    public String f68967c;

    /* renamed from: d  reason: collision with root package name */
    public d f68968d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.x.b.f.c f68969e;

    /* renamed from: f  reason: collision with root package name */
    public int f68970f;

    /* renamed from: g  reason: collision with root package name */
    public int f68971g;

    /* renamed from: h  reason: collision with root package name */
    public int f68972h;

    /* renamed from: i  reason: collision with root package name */
    public int f68973i;
    public int j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(8217548, "Ld/a/x/b/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(8217548, "Ld/a/x/b/e/b;");
        }
    }

    public b() {
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
        this.f68966b = "uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
        this.f68967c = "#extension GL_OES_EGL_image_external : require\nprecision mediump float; // 指定默认精度\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n";
        new LinkedList();
    }

    @Override // d.a.x.b.e.c
    public void a(d.a.x.b.f.a aVar, d.a.x.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, bVar) == null) {
            d dVar = this.f68968d;
            if (dVar != null && dVar.i()) {
                l();
                d(this.f68968d);
                c(aVar, bVar);
                g(aVar, bVar);
                j();
                k(this.f68968d);
                f();
                return;
            }
            Log.e(k, "onDraw filter has not been setup!!!");
        }
    }

    @Override // d.a.x.b.e.c
    public void b(d dVar, d.a.x.b.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, cVar) == null) {
            this.f68968d = dVar;
            this.f68969e = cVar;
            e(this.f68966b, this.f68967c);
            if (this.f68965a != -1) {
                h();
                return;
            }
            throw new RuntimeException("Unable to create program");
        }
    }

    public void c(d.a.x.b.f.a aVar, d.a.x.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, bVar) == null) {
            GLES20.glUniformMatrix4fv(this.f68971g, 1, false, bVar.e(), 0);
            GLES20.glUniformMatrix4fv(this.f68972h, 1, false, bVar.f(), 0);
            GLES20.glEnableVertexAttribArray(this.f68970f);
            GLES20.glVertexAttribPointer(this.f68970f, aVar.a(), (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, aVar.f(), (Buffer) aVar.d());
            GLES20.glEnableVertexAttribArray(this.f68973i);
            GLES20.glVertexAttribPointer(this.f68973i, aVar.a(), (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, aVar.c(), (Buffer) aVar.b());
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(dVar.g(), dVar.f());
            GLES20.glUniform1i(this.j, 0);
        }
    }

    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            if (this.f68968d.g() != 36197) {
                str2 = str2.replaceFirst("#extension GL_OES_EGL_image_external : require", "").replace("samplerExternalOES", "sampler2D");
            }
            this.f68965a = d.a.x.b.h.a.c(str, str2);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            GLES20.glUseProgram(0);
        }
    }

    public void g(d.a.x.b.f.a aVar, d.a.x.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, aVar, bVar) == null) {
            if (bVar.h()) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
            }
            if (bVar.g()) {
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(BankSignFactory.BEAN_ID_QUERY, BankSignFactory.BEAN_ID_BIND_CARD);
            }
            GLES20.glDrawArrays(5, 0, aVar.e());
            if (bVar.g()) {
                GLES20.glDisable(3042);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j = GLES20.glGetUniformLocation(this.f68965a, "uTexture");
            this.f68970f = GLES20.glGetAttribLocation(this.f68965a, "aPosition");
            this.f68971g = GLES20.glGetUniformLocation(this.f68965a, "uMVPMatrix");
            this.f68972h = GLES20.glGetUniformLocation(this.f68965a, "uTexMatrix");
            this.f68973i = GLES20.glGetAttribLocation(this.f68965a, "aTextureCoord");
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            GLES20.glDeleteProgram(this.f68965a);
            this.f68965a = -1;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            GLES20.glDisableVertexAttribArray(this.f68970f);
            GLES20.glDisableVertexAttribArray(this.f68973i);
        }
    }

    public void k(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            GLES20.glBindTexture(dVar.g(), 0);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GLES20.glUseProgram(this.f68965a);
        }
    }

    @Override // d.a.x.b.e.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            i();
        }
    }
}
