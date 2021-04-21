package d.b.u.b.g;

import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.mario.gldraw2d.params.ScaleType;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public float f65669e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f65670f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public MirrorType f65671g = MirrorType.NO_MIRROR;

    /* renamed from: h  reason: collision with root package name */
    public int f65672h = 0;
    public ScaleType i = ScaleType.FIT_XY;
    public float j = 1.0f;
    public int k = -90;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int c() {
        return this.f65672h;
    }

    public float d() {
        return this.j;
    }

    public MirrorType e() {
        return this.f65671g;
    }

    public ScaleType f() {
        return this.i;
    }

    public int g() {
        return this.k;
    }

    public float h() {
        return this.f65669e;
    }

    public float i() {
        return this.f65670f;
    }

    public void j(int i) {
        this.f65672h = i;
    }

    public void k(MirrorType mirrorType) {
        this.f65671g = mirrorType;
    }
}
