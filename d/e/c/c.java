package d.e.c;

import com.faceunity.gles.Drawable2d;
import com.faceunity.gles.Texture2dProgram;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable2d f65988a = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);

    /* renamed from: b  reason: collision with root package name */
    public Texture2dProgram f65989b;

    public c(Texture2dProgram texture2dProgram) {
        this.f65989b = texture2dProgram;
    }

    public int a() {
        return this.f65989b.a();
    }

    public void b(int i, float[] fArr) {
        Texture2dProgram texture2dProgram = this.f65989b;
        if (texture2dProgram == null) {
            return;
        }
        texture2dProgram.b(d.f65990a, this.f65988a.d(), 0, this.f65988a.e(), this.f65988a.a(), this.f65988a.f(), fArr, this.f65988a.b(), i, this.f65988a.c());
    }

    public void c(boolean z) {
        Texture2dProgram texture2dProgram = this.f65989b;
        if (texture2dProgram != null) {
            if (z) {
                texture2dProgram.c();
            }
            this.f65989b = null;
        }
    }
}
