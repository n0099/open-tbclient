package d.a.a.u.j;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f41705a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f41706b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41707c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.u.i.a f41708d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.u.i.d f41709e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f41710f;

    public i(String str, boolean z, Path.FillType fillType, @Nullable d.a.a.u.i.a aVar, @Nullable d.a.a.u.i.d dVar, boolean z2) {
        this.f41707c = str;
        this.f41705a = z;
        this.f41706b = fillType;
        this.f41708d = aVar;
        this.f41709e = dVar;
        this.f41710f = z2;
    }

    @Override // d.a.a.u.j.b
    public d.a.a.s.b.c a(d.a.a.f fVar, d.a.a.u.k.a aVar) {
        return new d.a.a.s.b.g(fVar, aVar, this);
    }

    @Nullable
    public d.a.a.u.i.a b() {
        return this.f41708d;
    }

    public Path.FillType c() {
        return this.f41706b;
    }

    public String d() {
        return this.f41707c;
    }

    @Nullable
    public d.a.a.u.i.d e() {
        return this.f41709e;
    }

    public boolean f() {
        return this.f41710f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f41705a + '}';
    }
}
