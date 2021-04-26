package d.b.c.b.d;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f65011a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f65012b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65013c;

    /* renamed from: d  reason: collision with root package name */
    public final InputStream f65014d;

    public b(int i2, List<a> list) {
        this(i2, list, -1, null);
    }

    public final InputStream a() {
        return this.f65014d;
    }

    public final int b() {
        return this.f65013c;
    }

    public final List<a> c() {
        return Collections.unmodifiableList(this.f65012b);
    }

    public final int d() {
        return this.f65011a;
    }

    public b(int i2, List<a> list, int i3, InputStream inputStream) {
        this.f65011a = i2;
        this.f65012b = list;
        this.f65013c = i3;
        this.f65014d = inputStream;
    }
}
