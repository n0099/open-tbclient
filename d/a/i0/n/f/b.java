package d.a.i0.n.f;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class b<T> implements c<T> {
    @Override // d.a.i0.n.f.c
    public void a(T t) {
    }

    @Override // d.a.i0.n.f.c
    public void c(T t) {
    }

    @Override // d.a.i0.n.f.c
    public void e(T t, d.a.i0.n.h.a aVar) {
    }

    @Override // d.a.i0.n.f.c
    public void f(T t) {
    }

    public int g() {
        return 100;
    }

    @Override // d.a.i0.n.f.c
    public d.a.i0.n.h.a h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
        return new d.a.i0.n.h.a(2302, "业务层默认不处理下载流");
    }

    @Override // d.a.i0.n.f.c
    public void i(T t) {
    }

    @Override // d.a.i0.n.f.c
    public void j(T t) {
    }

    @Override // d.a.i0.n.f.c
    public Map<String, Object> k() {
        HashMap hashMap = new HashMap();
        hashMap.put("queue_priority", Integer.valueOf(g()));
        return hashMap;
    }
}
