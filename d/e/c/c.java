package d.e.c;

import com.faceunity.gles.Drawable2d;
import com.faceunity.gles.Texture2dProgram;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable2d f66122a = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);

    /* renamed from: b  reason: collision with root package name */
    public Texture2dProgram f66123b;

    public c(Texture2dProgram texture2dProgram) {
        this.f66123b = texture2dProgram;
    }

    public int a() {
        return this.f66123b.a();
    }

    public void b(int i2, float[] fArr) {
        Texture2dProgram texture2dProgram = this.f66123b;
        if (texture2dProgram == null) {
            return;
        }
        texture2dProgram.b(d.f66124a, this.f66122a.d(), 0, this.f66122a.e(), this.f66122a.a(), this.f66122a.f(), fArr, this.f66122a.b(), i2, this.f66122a.c());
    }

    public void c(boolean z) {
        Texture2dProgram texture2dProgram = this.f66123b;
        if (texture2dProgram != null) {
            if (z) {
                texture2dProgram.c();
            }
            this.f66123b = null;
        }
    }
}
