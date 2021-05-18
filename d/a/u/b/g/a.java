package d.a.u.b.g;

import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.mario.gldraw2d.params.ScaleType;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public float f64704e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f64705f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public MirrorType f64706g = MirrorType.NO_MIRROR;

    /* renamed from: h  reason: collision with root package name */
    public int f64707h = 0;

    /* renamed from: i  reason: collision with root package name */
    public ScaleType f64708i = ScaleType.FIT_XY;
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
        return this.f64707h;
    }

    public float d() {
        return this.j;
    }

    public MirrorType e() {
        return this.f64706g;
    }

    public ScaleType f() {
        return this.f64708i;
    }

    public int g() {
        return this.k;
    }

    public float h() {
        return this.f64704e;
    }

    public float i() {
        return this.f64705f;
    }

    public void j(int i2) {
        this.f64707h = i2;
    }

    public void k(MirrorType mirrorType) {
        this.f64706g = mirrorType;
    }
}
