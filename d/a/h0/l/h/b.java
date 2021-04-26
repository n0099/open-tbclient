package d.a.h0.l.h;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okio.BufferedSource;
/* loaded from: classes3.dex */
public abstract class b<T> implements c<T> {
    @Override // d.a.h0.l.h.c
    public void a(T t) {
    }

    @Override // d.a.h0.l.h.c
    public d.a.h0.l.k.a b(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        return new d.a.h0.l.k.a(2302, "业务层默认不处理下载流");
    }

    @Override // d.a.h0.l.h.c
    public void d(T t) {
    }

    @Override // d.a.h0.l.h.c
    public void f(T t, d.a.h0.l.k.a aVar) {
    }

    @Override // d.a.h0.l.h.c
    public void g(T t) {
    }

    public int h() {
        return 100;
    }

    @Override // d.a.h0.l.h.c
    public void i(T t) {
    }

    @Override // d.a.h0.l.h.c
    public void j(T t) {
    }

    @Override // d.a.h0.l.h.c
    public Map<String, Object> k() {
        HashMap hashMap = new HashMap();
        hashMap.put("queue_priority", Integer.valueOf(h()));
        return hashMap;
    }
}
