package d.a.a.s.j;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f41396a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f41397b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41398c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.s.i.a f41399d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.s.i.d f41400e;

    public i(String str, boolean z, Path.FillType fillType, @Nullable d.a.a.s.i.a aVar, @Nullable d.a.a.s.i.d dVar) {
        this.f41398c = str;
        this.f41396a = z;
        this.f41397b = fillType;
        this.f41399d = aVar;
        this.f41400e = dVar;
    }

    @Override // d.a.a.s.j.b
    public d.a.a.q.a.b a(d.a.a.f fVar, d.a.a.s.k.a aVar) {
        return new d.a.a.q.a.f(fVar, aVar, this);
    }

    @Nullable
    public d.a.a.s.i.a b() {
        return this.f41399d;
    }

    public Path.FillType c() {
        return this.f41397b;
    }

    public String d() {
        return this.f41398c;
    }

    @Nullable
    public d.a.a.s.i.d e() {
        return this.f41400e;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f41396a + '}';
    }
}
