package d.c.c.b.d;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f66518a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f66519b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66520c;

    /* renamed from: d  reason: collision with root package name */
    public final InputStream f66521d;

    public b(int i, List<a> list) {
        this(i, list, -1, null);
    }

    public final InputStream a() {
        return this.f66521d;
    }

    public final int b() {
        return this.f66520c;
    }

    public final List<a> c() {
        return Collections.unmodifiableList(this.f66519b);
    }

    public final int d() {
        return this.f66518a;
    }

    public b(int i, List<a> list, int i2, InputStream inputStream) {
        this.f66518a = i;
        this.f66519b = list;
        this.f66520c = i2;
        this.f66521d = inputStream;
    }
}
