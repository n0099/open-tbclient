package d.c.c.b.d;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f65673a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f65674b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65675c;

    /* renamed from: d  reason: collision with root package name */
    public final InputStream f65676d;

    public b(int i, List<a> list) {
        this(i, list, -1, null);
    }

    public final InputStream a() {
        return this.f65676d;
    }

    public final int b() {
        return this.f65675c;
    }

    public final List<a> c() {
        return Collections.unmodifiableList(this.f65674b);
    }

    public final int d() {
        return this.f65673a;
    }

    public b(int i, List<a> list, int i2, InputStream inputStream) {
        this.f65673a = i;
        this.f65674b = list;
        this.f65675c = i2;
        this.f65676d = inputStream;
    }
}
