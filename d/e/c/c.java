package d.e.c;

import com.faceunity.gles.Drawable2d;
import com.faceunity.gles.Texture2dProgram;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable2d f66834a = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);

    /* renamed from: b  reason: collision with root package name */
    public Texture2dProgram f66835b;

    public c(Texture2dProgram texture2dProgram) {
        this.f66835b = texture2dProgram;
    }

    public int a() {
        return this.f66835b.a();
    }

    public void b(int i, float[] fArr) {
        Texture2dProgram texture2dProgram = this.f66835b;
        if (texture2dProgram == null) {
            return;
        }
        texture2dProgram.b(d.f66836a, this.f66834a.d(), 0, this.f66834a.e(), this.f66834a.a(), this.f66834a.f(), fArr, this.f66834a.b(), i, this.f66834a.c());
    }

    public void c(boolean z) {
        Texture2dProgram texture2dProgram = this.f66835b;
        if (texture2dProgram != null) {
            if (z) {
                texture2dProgram.c();
            }
            this.f66835b = null;
        }
    }
}
