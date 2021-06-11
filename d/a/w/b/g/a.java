package d.a.w.b.g;

import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.mario.gldraw2d.params.ScaleType;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public float f68475e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f68476f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public MirrorType f68477g = MirrorType.NO_MIRROR;

    /* renamed from: h  reason: collision with root package name */
    public int f68478h = 0;

    /* renamed from: i  reason: collision with root package name */
    public ScaleType f68479i = ScaleType.FIT_XY;
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
        return this.f68478h;
    }

    public float d() {
        return this.j;
    }

    public MirrorType e() {
        return this.f68477g;
    }

    public ScaleType f() {
        return this.f68479i;
    }

    public int g() {
        return this.k;
    }

    public float h() {
        return this.f68475e;
    }

    public float i() {
        return this.f68476f;
    }

    public void j(int i2) {
        this.f68478h = i2;
    }

    public void k(MirrorType mirrorType) {
        this.f68477g = mirrorType;
    }
}
