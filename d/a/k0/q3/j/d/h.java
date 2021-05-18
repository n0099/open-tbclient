package d.a.k0.q3.j.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import com.baidu.searchbox.afx.recode.OutputSurface;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
/* loaded from: classes5.dex */
public class h implements SurfaceTexture.OnFrameAvailableListener {
    public static int q;
    public static int r;
    public static int[] s = {0, 0, 0};

    /* renamed from: e  reason: collision with root package name */
    public SurfaceTexture f59967e;

    /* renamed from: f  reason: collision with root package name */
    public Surface f59968f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59970h;

    /* renamed from: i  reason: collision with root package name */
    public Context f59971i;
    public String j;
    public int k;
    public int l;
    public d.e.c.c m;
    public d.e.c.c n;
    public int o;

    /* renamed from: g  reason: collision with root package name */
    public Object f59969g = new Object();
    public final float[] p = new float[16];

    public h(Context context, String str, int i2, int i3) {
        this.j = "normal";
        this.f59971i = context;
        this.j = str;
        this.k = i2;
        this.l = i3;
        f();
    }

    public void a() {
        synchronized (this.f59969g) {
            while (!this.f59970h) {
                try {
                    this.f59969g.wait(500L);
                    if (!this.f59970h) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f59970h = false;
        }
        b("before updateTexImage");
        this.f59967e.updateTexImage();
    }

    public void b(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        Log.e(OutputSurface.TAG, str + ": glError " + glGetError);
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public void c() {
        this.f59967e.updateTexImage();
        this.f59967e.getTransformMatrix(this.p);
        faceunity.fuItemSetParam(q, "filter_name", this.j);
        faceunity.fuItemSetParam(q, "eye_bright", 0.0d);
        faceunity.fuItemSetParam(q, "tooth_whiten", 0.0d);
        this.m.b(faceunity.fuBeautifyImage(this.o, 1, this.k, this.l, 0, s), this.p);
    }

    public Surface d() {
        return this.f59968f;
    }

    public void e() {
        this.f59968f.release();
        this.f59968f = null;
        this.f59967e = null;
        d.e.c.c cVar = this.m;
        if (cVar != null) {
            cVar.c(false);
            this.m = null;
        }
        faceunity.fuDestroyItem(r);
        int[] iArr = s;
        r = 0;
        iArr[1] = 0;
        faceunity.fuDestroyItem(q);
        int[] iArr2 = s;
        q = 0;
        iArr2[0] = 0;
        faceunity.fuOnDeviceLost();
    }

    public final void f() {
        this.m = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        Log.d(OutputSurface.TAG, "onSurfaceCreated: ");
        d.e.c.c cVar = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
        this.n = cVar;
        this.o = cVar.a();
        this.f59967e = new SurfaceTexture(this.o);
        this.f59968f = new Surface(this.f59967e);
        int a2 = d.e.a.a(this.f59971i);
        q = a2;
        s[0] = a2;
        this.f59967e.setOnFrameAvailableListener(this);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Log.d(OutputSurface.TAG, "new frame available");
        synchronized (this.f59969g) {
            if (!this.f59970h) {
                this.f59970h = true;
                this.f59969g.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }
}
