package d.b.c.b.d;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f69575a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f69576b;

    /* renamed from: c  reason: collision with root package name */
    public final int f69577c;

    /* renamed from: d  reason: collision with root package name */
    public final InputStream f69578d;

    public b(int i2, List<a> list) {
        this(i2, list, -1, null);
    }

    public final InputStream a() {
        return this.f69578d;
    }

    public final int b() {
        return this.f69577c;
    }

    public final List<a> c() {
        return Collections.unmodifiableList(this.f69576b);
    }

    public final int d() {
        return this.f69575a;
    }

    public b(int i2, List<a> list, int i3, InputStream inputStream) {
        this.f69575a = i2;
        this.f69576b = list;
        this.f69577c = i3;
        this.f69578d = inputStream;
    }
}
