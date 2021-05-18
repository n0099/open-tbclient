package d.b.c.b.d;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f65697a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f65698b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65699c;

    /* renamed from: d  reason: collision with root package name */
    public final InputStream f65700d;

    public b(int i2, List<a> list) {
        this(i2, list, -1, null);
    }

    public final InputStream a() {
        return this.f65700d;
    }

    public final int b() {
        return this.f65699c;
    }

    public final List<a> c() {
        return Collections.unmodifiableList(this.f65698b);
    }

    public final int d() {
        return this.f65697a;
    }

    public b(int i2, List<a> list, int i3, InputStream inputStream) {
        this.f65697a = i2;
        this.f65698b = list;
        this.f65699c = i3;
        this.f65700d = inputStream;
    }
}
