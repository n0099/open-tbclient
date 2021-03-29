package d.a.a.s.j;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f41397a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f41398b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41399c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.s.i.a f41400d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.s.i.d f41401e;

    public i(String str, boolean z, Path.FillType fillType, @Nullable d.a.a.s.i.a aVar, @Nullable d.a.a.s.i.d dVar) {
        this.f41399c = str;
        this.f41397a = z;
        this.f41398b = fillType;
        this.f41400d = aVar;
        this.f41401e = dVar;
    }

    @Override // d.a.a.s.j.b
    public d.a.a.q.a.b a(d.a.a.f fVar, d.a.a.s.k.a aVar) {
        return new d.a.a.q.a.f(fVar, aVar, this);
    }

    @Nullable
    public d.a.a.s.i.a b() {
        return this.f41400d;
    }

    public Path.FillType c() {
        return this.f41398b;
    }

    public String d() {
        return this.f41399c;
    }

    @Nullable
    public d.a.a.s.i.d e() {
        return this.f41401e;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f41397a + '}';
    }
}
