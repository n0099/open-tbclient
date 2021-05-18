package d.e.c;

import com.faceunity.gles.Drawable2d;
import com.faceunity.gles.Texture2dProgram;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable2d f66079a = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);

    /* renamed from: b  reason: collision with root package name */
    public Texture2dProgram f66080b;

    public c(Texture2dProgram texture2dProgram) {
        this.f66080b = texture2dProgram;
    }

    public int a() {
        return this.f66080b.a();
    }

    public void b(int i2, float[] fArr) {
        Texture2dProgram texture2dProgram = this.f66080b;
        if (texture2dProgram == null) {
            return;
        }
        texture2dProgram.b(d.f66081a, this.f66079a.d(), 0, this.f66079a.e(), this.f66079a.a(), this.f66079a.f(), fArr, this.f66079a.b(), i2, this.f66079a.c());
    }

    public void c(boolean z) {
        Texture2dProgram texture2dProgram = this.f66080b;
        if (texture2dProgram != null) {
            if (z) {
                texture2dProgram.c();
            }
            this.f66080b = null;
        }
    }
}
