package d.b.c.b.d;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f65740a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f65741b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65742c;

    /* renamed from: d  reason: collision with root package name */
    public final InputStream f65743d;

    public b(int i2, List<a> list) {
        this(i2, list, -1, null);
    }

    public final InputStream a() {
        return this.f65743d;
    }

    public final int b() {
        return this.f65742c;
    }

    public final List<a> c() {
        return Collections.unmodifiableList(this.f65741b);
    }

    public final int d() {
        return this.f65740a;
    }

    public b(int i2, List<a> list, int i3, InputStream inputStream) {
        this.f65740a = i2;
        this.f65741b = list;
        this.f65742c = i3;
        this.f65743d = inputStream;
    }
}
