package d.b.c.a.b.a.h;

import java.io.IOException;
import java.util.List;
/* loaded from: classes5.dex */
public interface k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f64714a = new a();

    /* loaded from: classes5.dex */
    public static class a implements k {
        @Override // d.b.c.a.b.a.h.k
        public void a(int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
        }

        @Override // d.b.c.a.b.a.h.k
        public boolean a(int i2, List<d.b.c.a.b.a.h.a> list) {
            return true;
        }

        @Override // d.b.c.a.b.a.h.k
        public boolean b(int i2, d.b.c.a.a.e eVar, int i3, boolean z) throws IOException {
            eVar.g(i3);
            return true;
        }

        @Override // d.b.c.a.b.a.h.k
        public boolean c(int i2, List<d.b.c.a.b.a.h.a> list, boolean z) {
            return true;
        }
    }

    void a(int i2, com.bytedance.sdk.a.b.a.e.b bVar);

    boolean a(int i2, List<d.b.c.a.b.a.h.a> list);

    boolean b(int i2, d.b.c.a.a.e eVar, int i3, boolean z) throws IOException;

    boolean c(int i2, List<d.b.c.a.b.a.h.a> list, boolean z);
}
