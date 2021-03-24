package d.b.u.b.g;

import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.mario.gldraw2d.params.ScaleType;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public float f64710e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f64711f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public MirrorType f64712g = MirrorType.NO_MIRROR;

    /* renamed from: h  reason: collision with root package name */
    public int f64713h = 0;
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
        return this.f64713h;
    }

    public float d() {
        return this.j;
    }

    public MirrorType e() {
        return this.f64712g;
    }

    public ScaleType f() {
        return this.i;
    }

    public int g() {
        return this.k;
    }

    public float h() {
        return this.f64710e;
    }

    public float i() {
        return this.f64711f;
    }

    public void j(int i) {
        this.f64713h = i;
    }

    public void k(MirrorType mirrorType) {
        this.f64712g = mirrorType;
    }
}
