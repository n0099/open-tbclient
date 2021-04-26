package d.e.c;

import com.faceunity.gles.Drawable2d;
import com.faceunity.gles.Texture2dProgram;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable2d f65393a = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);

    /* renamed from: b  reason: collision with root package name */
    public Texture2dProgram f65394b;

    public c(Texture2dProgram texture2dProgram) {
        this.f65394b = texture2dProgram;
    }

    public int a() {
        return this.f65394b.a();
    }

    public void b(int i2, float[] fArr) {
        Texture2dProgram texture2dProgram = this.f65394b;
        if (texture2dProgram == null) {
            return;
        }
        texture2dProgram.b(d.f65395a, this.f65393a.d(), 0, this.f65393a.e(), this.f65393a.a(), this.f65393a.f(), fArr, this.f65393a.b(), i2, this.f65393a.c());
    }

    public void c(boolean z) {
        Texture2dProgram texture2dProgram = this.f65394b;
        if (texture2dProgram != null) {
            if (z) {
                texture2dProgram.c();
            }
            this.f65394b = null;
        }
    }
}
