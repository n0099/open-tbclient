package d.b.c.b.d;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f69471a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f69472b;

    /* renamed from: c  reason: collision with root package name */
    public final int f69473c;

    /* renamed from: d  reason: collision with root package name */
    public final InputStream f69474d;

    public b(int i2, List<a> list) {
        this(i2, list, -1, null);
    }

    public final InputStream a() {
        return this.f69474d;
    }

    public final int b() {
        return this.f69473c;
    }

    public final List<a> c() {
        return Collections.unmodifiableList(this.f69472b);
    }

    public final int d() {
        return this.f69471a;
    }

    public b(int i2, List<a> list, int i3, InputStream inputStream) {
        this.f69471a = i2;
        this.f69472b = list;
        this.f69473c = i3;
        this.f69474d = inputStream;
    }
}
