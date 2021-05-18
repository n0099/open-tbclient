package d.a.u.b.e;

import android.opengl.GLES20;
import android.util.Log;
import com.baidu.wallet.core.StatusCode;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import d.a.u.b.f.d;
import java.nio.Buffer;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class b extends a implements c {
    public static final String k = "b";

    /* renamed from: a  reason: collision with root package name */
    public int f64679a;

    /* renamed from: b  reason: collision with root package name */
    public String f64680b = "uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: c  reason: collision with root package name */
    public String f64681c = "#extension GL_OES_EGL_image_external : require\nprecision mediump float; // 指定默认精度\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n";

    /* renamed from: d  reason: collision with root package name */
    public d f64682d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.u.b.f.c f64683e;

    /* renamed from: f  reason: collision with root package name */
    public int f64684f;

    /* renamed from: g  reason: collision with root package name */
    public int f64685g;

    /* renamed from: h  reason: collision with root package name */
    public int f64686h;

    /* renamed from: i  reason: collision with root package name */
    public int f64687i;
    public int j;

    public b() {
        new LinkedList();
    }

    @Override // d.a.u.b.e.c
    public void a(d.a.u.b.f.a aVar, d.a.u.b.g.b bVar) {
        d dVar = this.f64682d;
        if (dVar != null && dVar.g()) {
            l();
            d(this.f64682d);
            c(aVar, bVar);
            g(aVar, bVar);
            j();
            k(this.f64682d);
            f();
            return;
        }
        Log.e(k, "onDraw filter has not been setup!!!");
    }

    @Override // d.a.u.b.e.c
    public void b(d dVar, d.a.u.b.f.c cVar) {
        this.f64682d = dVar;
        this.f64683e = cVar;
        e(this.f64680b, this.f64681c);
        if (this.f64679a != -1) {
            h();
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    public void c(d.a.u.b.f.a aVar, d.a.u.b.g.b bVar) {
        GLES20.glUniformMatrix4fv(this.f64685g, 1, false, bVar.c(), 0);
        GLES20.glUniformMatrix4fv(this.f64686h, 1, false, bVar.d(), 0);
        GLES20.glEnableVertexAttribArray(this.f64684f);
        GLES20.glVertexAttribPointer(this.f64684f, aVar.a(), (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, aVar.f(), (Buffer) aVar.d());
        GLES20.glEnableVertexAttribArray(this.f64687i);
        GLES20.glVertexAttribPointer(this.f64687i, aVar.a(), (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, aVar.c(), (Buffer) aVar.b());
    }

    public void d(d dVar) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(dVar.e(), dVar.d());
        GLES20.glUniform1i(this.j, 0);
    }

    public void e(String str, String str2) {
        if (this.f64682d.e() != 36197) {
            str2 = str2.replaceFirst("#extension GL_OES_EGL_image_external : require", "").replace("samplerExternalOES", "sampler2D");
        }
        this.f64679a = d.a.u.b.h.a.c(str, str2);
    }

    public void f() {
        GLES20.glUseProgram(0);
    }

    public void g(d.a.u.b.f.a aVar, d.a.u.b.g.b bVar) {
        if (bVar.f()) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
        if (bVar.e()) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(BankSignFactory.BEAN_ID_QUERY, BankSignFactory.BEAN_ID_BIND_CARD);
        }
        GLES20.glDrawArrays(5, 0, aVar.e());
        if (bVar.e()) {
            GLES20.glDisable(3042);
        }
    }

    public void h() {
        this.j = GLES20.glGetUniformLocation(this.f64679a, "uTexture");
        this.f64684f = GLES20.glGetAttribLocation(this.f64679a, "aPosition");
        this.f64685g = GLES20.glGetUniformLocation(this.f64679a, "uMVPMatrix");
        this.f64686h = GLES20.glGetUniformLocation(this.f64679a, "uTexMatrix");
        this.f64687i = GLES20.glGetAttribLocation(this.f64679a, "aTextureCoord");
    }

    public void i() {
        GLES20.glDeleteProgram(this.f64679a);
        this.f64679a = -1;
    }

    public void j() {
        GLES20.glDisableVertexAttribArray(this.f64684f);
        GLES20.glDisableVertexAttribArray(this.f64687i);
    }

    public void k(d dVar) {
        GLES20.glBindTexture(dVar.e(), 0);
    }

    public void l() {
        GLES20.glUseProgram(this.f64679a);
    }

    @Override // d.a.u.b.e.c
    public void release() {
        i();
    }
}
