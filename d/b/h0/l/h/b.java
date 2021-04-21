package d.b.h0.l.h;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okio.BufferedSource;
/* loaded from: classes3.dex */
public abstract class b<T> implements c<T> {
    @Override // d.b.h0.l.h.c
    public void a(T t) {
    }

    @Override // d.b.h0.l.h.c
    public void b(T t) {
    }

    @Override // d.b.h0.l.h.c
    public void c(T t) {
    }

    @Override // d.b.h0.l.h.c
    public Map<String, Object> d() {
        HashMap hashMap = new HashMap();
        hashMap.put("queue_priority", Integer.valueOf(e()));
        return hashMap;
    }

    public int e() {
        return 100;
    }

    @Override // d.b.h0.l.h.c
    public d.b.h0.l.k.a f(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        return new d.b.h0.l.k.a(2302, "业务层默认不处理下载流");
    }

    @Override // d.b.h0.l.h.c
    public void i(T t) {
    }

    @Override // d.b.h0.l.h.c
    public void l(T t, d.b.h0.l.k.a aVar) {
    }

    @Override // d.b.h0.l.h.c
    public void n(T t) {
    }
}
