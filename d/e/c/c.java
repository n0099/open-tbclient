package d.e.c;

import com.faceunity.gles.Drawable2d;
import com.faceunity.gles.Texture2dProgram;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable2d f69957a = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);

    /* renamed from: b  reason: collision with root package name */
    public Texture2dProgram f69958b;

    public c(Texture2dProgram texture2dProgram) {
        this.f69958b = texture2dProgram;
    }

    public int a() {
        return this.f69958b.a();
    }

    public void b(int i2, float[] fArr) {
        Texture2dProgram texture2dProgram = this.f69958b;
        if (texture2dProgram == null) {
            return;
        }
        texture2dProgram.b(d.f69959a, this.f69957a.d(), 0, this.f69957a.e(), this.f69957a.a(), this.f69957a.f(), fArr, this.f69957a.b(), i2, this.f69957a.c());
    }

    public void c(boolean z) {
        Texture2dProgram texture2dProgram = this.f69958b;
        if (texture2dProgram != null) {
            if (z) {
                texture2dProgram.c();
            }
            this.f69958b = null;
        }
    }
}
