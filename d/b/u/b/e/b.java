package d.b.u.b.e;

import android.opengl.GLES20;
import android.util.Log;
import com.baidu.wallet.core.StatusCode;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import d.b.u.b.f.d;
import java.nio.Buffer;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class b extends a implements c {
    public static final String k = "b";

    /* renamed from: a  reason: collision with root package name */
    public int f64688a;

    /* renamed from: b  reason: collision with root package name */
    public String f64689b = "uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: c  reason: collision with root package name */
    public String f64690c = "#extension GL_OES_EGL_image_external : require\nprecision mediump float; // 指定默认精度\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n";

    /* renamed from: d  reason: collision with root package name */
    public d f64691d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.u.b.f.c f64692e;

    /* renamed from: f  reason: collision with root package name */
    public int f64693f;

    /* renamed from: g  reason: collision with root package name */
    public int f64694g;

    /* renamed from: h  reason: collision with root package name */
    public int f64695h;
    public int i;
    public int j;

    public b() {
        new LinkedList();
    }

    @Override // d.b.u.b.e.c
    public void a(d.b.u.b.f.a aVar, d.b.u.b.g.b bVar) {
        d dVar = this.f64691d;
        if (dVar != null && dVar.g()) {
            l();
            d(this.f64691d);
            c(aVar, bVar);
            g(aVar, bVar);
            j();
            k(this.f64691d);
            f();
            return;
        }
        Log.e(k, "onDraw filter has not been setup!!!");
    }

    @Override // d.b.u.b.e.c
    public void b(d dVar, d.b.u.b.f.c cVar) {
        this.f64691d = dVar;
        this.f64692e = cVar;
        e(this.f64689b, this.f64690c);
        if (this.f64688a != -1) {
            h();
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    public void c(d.b.u.b.f.a aVar, d.b.u.b.g.b bVar) {
        GLES20.glUniformMatrix4fv(this.f64694g, 1, false, bVar.c(), 0);
        GLES20.glUniformMatrix4fv(this.f64695h, 1, false, bVar.d(), 0);
        GLES20.glEnableVertexAttribArray(this.f64693f);
        GLES20.glVertexAttribPointer(this.f64693f, aVar.a(), (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, aVar.f(), (Buffer) aVar.d());
        GLES20.glEnableVertexAttribArray(this.i);
        GLES20.glVertexAttribPointer(this.i, aVar.a(), (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, aVar.c(), (Buffer) aVar.b());
    }

    public void d(d dVar) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(dVar.e(), dVar.d());
        GLES20.glUniform1i(this.j, 0);
    }

    public void e(String str, String str2) {
        if (this.f64691d.e() != 36197) {
            str2 = str2.replaceFirst("#extension GL_OES_EGL_image_external : require", "").replace("samplerExternalOES", "sampler2D");
        }
        this.f64688a = d.b.u.b.h.a.c(str, str2);
    }

    public void f() {
        GLES20.glUseProgram(0);
    }

    public void g(d.b.u.b.f.a aVar, d.b.u.b.g.b bVar) {
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
        this.j = GLES20.glGetUniformLocation(this.f64688a, "uTexture");
        this.f64693f = GLES20.glGetAttribLocation(this.f64688a, "aPosition");
        this.f64694g = GLES20.glGetUniformLocation(this.f64688a, "uMVPMatrix");
        this.f64695h = GLES20.glGetUniformLocation(this.f64688a, "uTexMatrix");
        this.i = GLES20.glGetAttribLocation(this.f64688a, "aTextureCoord");
    }

    public void i() {
        GLES20.glDeleteProgram(this.f64688a);
        this.f64688a = -1;
    }

    public void j() {
        GLES20.glDisableVertexAttribArray(this.f64693f);
        GLES20.glDisableVertexAttribArray(this.i);
    }

    public void k(d dVar) {
        GLES20.glBindTexture(dVar.e(), 0);
    }

    public void l() {
        GLES20.glUseProgram(this.f64688a);
    }

    @Override // d.b.u.b.e.c
    public void release() {
        i();
    }
}
