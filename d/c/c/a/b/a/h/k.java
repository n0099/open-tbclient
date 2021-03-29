package d.c.c.a.b.a.h;

import java.io.IOException;
import java.util.List;
/* loaded from: classes5.dex */
public interface k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f65389a = new a();

    /* loaded from: classes5.dex */
    public static class a implements k {
        @Override // d.c.c.a.b.a.h.k
        public void a(int i, com.bytedance.sdk.a.b.a.e.b bVar) {
        }

        @Override // d.c.c.a.b.a.h.k
        public boolean a(int i, List<d.c.c.a.b.a.h.a> list) {
            return true;
        }

        @Override // d.c.c.a.b.a.h.k
        public boolean b(int i, d.c.c.a.a.e eVar, int i2, boolean z) throws IOException {
            eVar.g(i2);
            return true;
        }

        @Override // d.c.c.a.b.a.h.k
        public boolean c(int i, List<d.c.c.a.b.a.h.a> list, boolean z) {
            return true;
        }
    }

    void a(int i, com.bytedance.sdk.a.b.a.e.b bVar);

    boolean a(int i, List<d.c.c.a.b.a.h.a> list);

    boolean b(int i, d.c.c.a.a.e eVar, int i2, boolean z) throws IOException;

    boolean c(int i, List<d.c.c.a.b.a.h.a> list, boolean z);
}
